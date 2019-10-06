package com.facebook.p127a;

import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.facebook.C6787r;

/* renamed from: com.facebook.a.d */
/* compiled from: AnalyticsUserIDStore */
class C6622d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f12048a;

    C6622d(String str) {
        this.f12048a = str;
    }

    public void run() {
        C6623e.f12050b.writeLock().lock();
        try {
            C6623e.f12051c = this.f12048a;
            Editor editor = PreferenceManager.getDefaultSharedPreferences(C6787r.m13815e()).edit();
            editor.putString("com.facebook.appevents.AnalyticsUserIDStore.userID", C6623e.f12051c);
            editor.apply();
        } finally {
            C6623e.f12050b.writeLock().unlock();
        }
    }
}
