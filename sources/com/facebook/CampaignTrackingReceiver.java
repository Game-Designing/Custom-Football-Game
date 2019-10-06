package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.facebook.p127a.C6638q;
import p005cm.aptoide.p006pt.database.realm.StoredMinimalAd;

public final class CampaignTrackingReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String str = StoredMinimalAd.REFERRER;
        String referrer = intent.getStringExtra(str);
        if (referrer != null && referrer.startsWith("fb")) {
            C6638q.m13221b(intent.getStringExtra(str));
        }
    }
}
