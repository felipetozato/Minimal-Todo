package com.example.avjindersinghsekhon.minimaltodo.Main;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.avjindersinghsekhon.minimaltodo.About.AboutActivity;
import com.example.avjindersinghsekhon.minimaltodo.AppDefault.AppDefaultActivity;
import com.example.avjindersinghsekhon.minimaltodo.BuildConfig;
import com.example.avjindersinghsekhon.minimaltodo.R;
import com.example.avjindersinghsekhon.minimaltodo.Settings.SettingsActivity;
import com.sumup.merchant.api.SumUpAPI;
import com.sumup.merchant.api.SumUpLogin;
import com.sumup.merchant.api.SumUpPayment;
import com.sumup.merchant.api.SumUpState;

import java.math.BigDecimal;
import java.util.UUID;

public class MainActivity extends AppDefaultActivity {

    private final static int SUMUP_LOGIN_REQUEST_CODE = 1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected int contentViewLayoutRes() {
        return R.layout.activity_main;
    }

    @NonNull
    @Override
    protected Fragment createInitialFragment() {
        return MainFragment.newInstance();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.aboutMeMenuItem:
                Intent i = new Intent(this, AboutActivity.class);
                startActivity(i);
                return true;
//            case R.id.switch_themes:
//                if(mTheme == R.style.CustomStyle_DarkTheme){
//                    addThemeToSharedPreferences(LIGHTTHEME);
//                }
//                else{
//                    addThemeToSharedPreferences(DARKTHEME);
//                }
//
////                if(mTheme == R.style.CustomStyle_DarkTheme){
////                    mTheme = R.style.CustomStyle_LightTheme;
////                }
////                else{
////                    mTheme = R.style.CustomStyle_DarkTheme;
////                }
//                this.recreate();
//                return true;
            case R.id.preferences:
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                return true;
            case R.id.supportMenuItem:
                loginAuth();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == SumUpAPI.Response.ResultCode.SUCCESSFUL) {
            switch (requestCode) {
                case SUMUP_LOGIN_REQUEST_CODE:
                    openPaymentMethod();
                    break;
                case 2:
                    Log.d("SUMUP", "Result code of sumup: $resultCode");
                default:
                    super.onActivityResult(requestCode, resultCode, data);
            }
        }
    }

    private void loginAuth() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://api.sumup.com/authorize?response_type=code&client_id=kkP2aqEnexRnDfvXVq9Rvf-08xsm&redirect_uri=minimaltodo://login/callback&scope=payments%20transactions.history"));
        this.startActivity(intent);
    }

    private void openPaymentMethod() {
        if (SumUpAPI.isLoggedIn()) {
            doPayment();
        } else {
            SumUpLogin sumupLogin = SumUpLogin.builder(BuildConfig.AFFILIATE_ID).build();
            SumUpAPI.openLoginActivity(this, sumupLogin, SUMUP_LOGIN_REQUEST_CODE);
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

        SumUpAPI.checkout(MainActivity.this, payment, 2);
    }

}


