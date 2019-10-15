package com.example.avjindersinghsekhon.minimaltodo.view.payment

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.view.View
import com.example.avjindersinghsekhon.minimaltodo.data.model.Receipt
import com.example.avjindersinghsekhon.minimaltodo.view.AppDefault.AppDefaultFragment

import com.example.avjindersinghsekhon.minimaltodo.R
import com.example.avjindersinghsekhon.minimaltodo.view.Utility.CurrencyUtils
import kotlinx.android.synthetic.main.content_sum_up_receipt_detail.*
import java.text.SimpleDateFormat

class SumUpTransactionReceiptDetailFragment : AppDefaultFragment() {

    companion object {
        private const val DATE_FORMAT_PATTERN = "dd/MM/yyyy - HH:mm"
        private const val TRANSACTION_ID_KEY = "ID_KEY"

        @JvmStatic
        fun newInstance(transactionId: String = "TETSFYN73C") =
                SumUpTransactionReceiptDetailFragment().apply {
                    arguments = Bundle().apply {
                        putString(TRANSACTION_ID_KEY, transactionId)
                    }
                }
    }

    override fun layoutRes(): Int {
        return R.layout.fragment_sum_up_receipt_detail
    }

    //TODO Inject using viewModelProviders
    private val viewModel = TrasactionHistoryViewModel()
    private lateinit var transactionId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            transactionId = it.getString(TRANSACTION_ID_KEY) ?: ""
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getReceipt(transactionId).observe(this, observeReceipt())
        (this.requireActivity() as SumUpTransactionHistoryActivity).setTitle(transactionId)
    }

    private fun observeReceipt(): Observer<Receipt> {
        return Observer { receipt ->
            progressBar.visibility = View.GONE

            if (receipt == null) return@Observer
            receipt.transactionData?.transactionCode?.let { transactionIdText.text = it }
            receipt.merchantData?.merchantProfile?.address?.let{
                cardAddress.visibility = View.VISIBLE
                val fullAddress = " ${it.addressLine1} - ${it.regisonName}"
                addressText.text = fullAddress
            }
            receipt.transactionData?.let {
                val amount = CurrencyUtils.currencyCodeToDisplayableText(it.currency ?: "") +
                " ${it.amount?.toString()}"
                totalAmountText.text = amount
            }
            receipt.transactionData?.card?.let {
                cardCreditCard.visibility = View.VISIBLE
                creditCardNumberText.text = "•••• ${it.last4Digits}"
                cardCreditCard.requestLayout()
            }
            receipt.transactionData?.status?.let {
                cardTranscationStatus.visibility = View.VISIBLE
                transactionStatusText.text = it
                cardTranscationStatus.requestLayout()
            }
            receipt.transactionData?.timestampAsDate()?.let {
                dateText.text = SimpleDateFormat(DATE_FORMAT_PATTERN).format(it)
            }
            receipt.cardData?.name?.let {
                operationTypeText.text = it
            }
        }
    }
}
