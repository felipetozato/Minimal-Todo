package com.example.avjindersinghsekhon.minimaltodo.Analytics;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;

import com.example.avjindersinghsekhon.minimaltodo.R;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.sumup.merchant.api.SumUpState;

import java.util.Map;

public class AnalyticsApplication extends Application {

    private Tracker mTracker;
    private static final boolean IS_ENABLED = true;
    public static Context appContext; //Not great, but would require dagger to avoid this or avoid passing context everywhere

    @Override
    public void onCreate() {
        super.onCreate();
        SumUpState.init(this);
        appContext = this;
    }

    synchronized private Tracker getDefaultTracker() {
        if (mTracker == null) {
            GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);

            /*R.xml.app_tracker contains my Analytics code
            To use this, go to Google Analytics, and get
            your code, create a file under res/xml , and save
            your code as <string name="ga_trackingId">UX-XXXXXXXX-Y</string>
            */

            //mTracker = analytics.newTracker(R.xml.app_tracker);
            mTracker = analytics.newTracker(R.xml.global_tracker);
//
            mTracker.setAppName("Minimal");
            mTracker.enableExceptionReporting(true);
            try {
                mTracker.setAppId(getPackageManager().getPackageInfo(getPackageName(), 0).versionName);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }

        }
        return mTracker;
    }

    public void send(Object screenName) {
        send(screenName, new HitBuilders.ScreenViewBuilder().build());
    }

    private void send(Object screenName, Map<String, String> params) {
        if (IS_ENABLED) {
            Tracker tracker = getDefaultTracker();
            tracker.setScreenName(getClassName(screenName));
            tracker.send(params);
        }
    }

    private String getClassName(Object o) {
        Class c = o.getClass();
        while (c.isAnonymousClass()) {
            c = c.getEnclosingClass();
        }
        return c.getSimpleName();

    }

    public void send(Object screenName, String category, String action) {
        send(screenName, new HitBuilders.EventBuilder().setCategory(category).setAction(action).build());
    }

    public void send(Object screenName, String category, String action, String label) {
        send(screenName, new HitBuilders.EventBuilder().setCategory(category).setAction(action).setLabel(label).build());
    }
}
