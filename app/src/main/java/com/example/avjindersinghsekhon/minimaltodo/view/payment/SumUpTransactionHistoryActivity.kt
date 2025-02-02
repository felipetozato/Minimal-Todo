package com.example.avjindersinghsekhon.minimaltodo.view.payment

import android.support.v4.app.Fragment
import com.example.avjindersinghsekhon.minimaltodo.view.AppDefault.AppDefaultActivity
import com.example.avjindersinghsekhon.minimaltodo.R

class SumUpTransactionHistoryActivity : AppDefaultActivity() {

    override fun contentViewLayoutRes(): Int {
        return R.layout.activity_sum_up_transaction_history
    }

    override fun createInitialFragment(): Fragment {
        return SumUpTransactionReceiptDetailFragment.newInstance()
    }

    override fun shouldSetupBackButton(): Boolean {
        return true
    }

    public fun setTitle(title: String) {
        toolbar?.let { it.title = title }
    }

}
