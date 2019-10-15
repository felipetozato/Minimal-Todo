package com.example.avjindersinghsekhon.minimaltodo.view.AddToDo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.example.avjindersinghsekhon.minimaltodo.view.AppDefault.AppDefaultActivity;
import com.example.avjindersinghsekhon.minimaltodo.BuildConfig;
import com.example.avjindersinghsekhon.minimaltodo.R;
import com.sumup.merchant.api.SumUpAPI;
import com.sumup.merchant.api.SumUpLogin;
import com.sumup.merchant.api.SumUpPayment;

import java.math.BigDecimal;
import java.util.UUID;

public class AddToDoActivity extends AppDefaultActivity {
    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int contentViewLayoutRes() {
        return R.layout.activity_add_to_do;
    }

    @NonNull
    @Override
    protected Fragment createInitialFragment() {
        return AddToDoFragment.newInstance();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private final static int SUMUP_LOGIN_REQUEST_CODE = 1;

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == SumUpAPI.Response.ResultCode.SUCCESSFUL) {
            switch (requestCode) {
                case SUMUP_LOGIN_REQUEST_CODE:
                    openPaymentMethod();
                    break;
                default:
                    super.onActivityResult(requestCode, resultCode, data);
            }
        }
    }

    private void doPayment() {
        SumUpPayment payment = SumUpPayment.builder()
                // mandatory parameters
                .total(new BigDecimal("20.40")) // minimum 1.00
                .currency(SumUpPayment.Currency.BRL)
                // optional: include a tip amount in addition to the total
                .tip(new BigDecimal("0.0"))
                // optional: add details
                .title("Donation for the app")
                .receiptEmail("felipe.test@gmail.com")
                .receiptSMS("+3531234567890")
                // optional: Add metadata
                .addAdditionalInfo("AccountId", "taxi0334")
                .addAdditionalInfo("From", "Paris")
                .addAdditionalInfo("To", "Berlin")
                // optional: foreign transaction ID, must be unique!
                .foreignTransactionId(UUID.randomUUID().toString())  // can not exceed 128 chars
                // optional: skip the success screen
                .skipSuccessScreen()
                .build();

        SumUpAPI.checkout(this, payment, 2);
    }

    public void openPaymentMethod() {
        if (SumUpAPI.isLoggedIn()) {
            doPayment();
        } else {
            SumUpLogin sumupLogin = SumUpLogin.builder(BuildConfig.AFFILIATE_ID).build();
            SumUpAPI.openLoginActivity(this, sumupLogin, SUMUP_LOGIN_REQUEST_CODE);
        }
    }

}

