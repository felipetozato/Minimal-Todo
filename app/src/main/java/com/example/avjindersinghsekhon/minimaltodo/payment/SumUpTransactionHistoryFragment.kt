package com.example.avjindersinghsekhon.minimaltodo.payment

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.view.View
import com.example.avjindersinghsekhon.minimaltodo.data.model.Receipt
import com.example.avjindersinghsekhon.minimaltodo.AppDefault.AppDefaultFragment

import com.example.avjindersinghsekhon.minimaltodo.R
import kotlinx.android.synthetic.main.content_sum_up_transaction_history.*
import java.text.SimpleDateFormat

class SumUpTransactionHistoryFragment : AppDefaultFragment() {

    override fun layoutRes(): Int {
        return R.layout.fragment_sum_up_transaction_history
    }

    //TODO Inject using viewModelProviders
    private val viewModel = TrasactionHistoryViewModel()
    private lateinit var transactionId: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        transactionId = "TETSFYN73C"
        viewModel.getReceipt(transactionId).observe(this, observeReceipt())
        (this.requireActivity() as SumUpTransactionHistoryActivity).setTitle(transactionId)
    }

    private fun observeReceipt(): Observer<Receipt> {
        return Observer { receipt ->
            progressBar.visibility = View.GONE

            if (receipt == null) return@Observer
            receipt.transactionData?.transactionCode?.let { transactionIdText.text = it }
            receipt.merchantData?.merchantProfile?.address?.let{
                addressTextLabel.visibility = View.VISIBLE
                val fullAddress = " ${it.addressLine1} - ${it.regisonName}"
                addressText.text = fullAddress
            }
            receipt.transactionData?.let {
                val amount = "${it.currency} ${it.amount?.toString()}"
                totalAmountText.text = amount
            }
            receipt.transactionData?.card?.let {
                creditCardNumberTextLabel.visibility = View.VISIBLE
                creditCardNumberText.text = "•••• ${it.last4Digits}"
            }
            receipt.transactionData?.status?.let {
                transactionStatusTextLabel.visibility = View.VISIBLE
                transactionStatusText.text = it
            }
            receipt.transactionData?.timestamp?.let {
                val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                val datetime = formatter.parse(it)
                dateText.text = SimpleDateFormat("dd/MM/yyyy - HH:mm").format(datetime)
            }
            receipt.cardData?.name?.let {
                operationTypeText.text = it
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = SumUpTransactionHistoryFragment()
    }
}
