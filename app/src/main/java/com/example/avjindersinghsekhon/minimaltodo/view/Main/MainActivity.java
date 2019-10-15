package com.example.avjindersinghsekhon.minimaltodo.view.Main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.avjindersinghsekhon.minimaltodo.view.About.AboutActivity;
import com.example.avjindersinghsekhon.minimaltodo.view.AppDefault.AppDefaultActivity;
import com.example.avjindersinghsekhon.minimaltodo.R;
import com.example.avjindersinghsekhon.minimaltodo.view.Settings.SettingsActivity;
import com.example.avjindersinghsekhon.minimaltodo.view.payment.SumUpTransactionHistoryActivity;

public class MainActivity extends AppDefaultActivity {

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
            case R.id.preferences:
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                return true;
            case R.id.supportMenuItem:
                openTransactionReceiptScreen();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //OAuth flow. Not used...
//    private void loginAuth() {
//        Intent intent = new Intent(Intent.ACTION_VIEW);
//        intent.setData(Uri.parse("https://api.sumup.com/authorize?response_type=code&client_id=kkP2aqEnexRnDfvXVq9Rvf-08xsm&redirect_uri=minimaltodo://login/callback&scope=payments%20transactions.history"));
//        this.startActivity(intent);
//    }

    private void openTransactionReceiptScreen() {
        Intent intent = new Intent(this, SumUpTransactionHistoryActivity.class);
        this.startActivity(intent);
    }

}


