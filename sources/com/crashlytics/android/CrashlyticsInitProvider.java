package com.crashlytics.android;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.crashlytics.android.ndk.CrashlyticsNdk;
import p024io.fabric.sdk.android.C0102l;
import p024io.fabric.sdk.android.C13920f;
import p024io.fabric.sdk.android.p348a.p350b.C13867x;

public class CrashlyticsInitProvider extends ContentProvider {

    /* renamed from: com.crashlytics.android.CrashlyticsInitProvider$a */
    interface C6358a {
        /* renamed from: a */
        boolean mo19339a(Context context);
    }

    public boolean onCreate() {
        Context context = getContext();
        String str = "CrashlyticsInitProvider";
        if (mo19332a(context, new C13867x(), new C6404b())) {
            try {
                C13920f.m44236a(context, m12277a(context.getApplicationContext()));
                C13920f.m44245e().mo43328d(str, "CrashlyticsInitProvider initialization successful");
            } catch (IllegalStateException e) {
                C13920f.m44245e().mo43328d(str, "CrashlyticsInitProvider initialization unsuccessful");
                return false;
            }
        } else {
            C13920f.m44245e().mo43328d(str, "CrashlyticsInitProvider skipping initialization");
        }
        return true;
    }

    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }

    /* renamed from: a */
    private C0102l[] m12277a(Context applicationContext) {
        String str = "Fabric";
        boolean useNdk = false;
        try {
            Bundle manifestMetaData = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128).metaData;
            useNdk = manifestMetaData != null && manifestMetaData.getBoolean("firebase_crashlytics_ndk_enabled", false);
        } catch (NameNotFoundException e) {
            C13920f.m44245e().mo43327c(str, "Unable to get PackageManager while determining if Crashlytics NDK should be initialized", e);
        }
        C0102l crashlyticsKit = new C0075a();
        if (useNdk) {
            try {
                C13920f.m44245e().mo43328d(str, "Crashlytics is initializing NDK crash reporter.");
                return new C0102l[]{crashlyticsKit, new CrashlyticsNdk()};
            } catch (Throwable e2) {
                C13920f.m44245e().mo43325b(str, "Crashlytics failed to initialize NDK crash reporting. Attempting to intialize SDK...", e2);
            }
        }
        return new C0102l[]{crashlyticsKit};
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo19332a(Context context, C13867x firebaseInfo, C6358a enabledCheckStrategy) {
        if (firebaseInfo.mo43258e(context)) {
            return enabledCheckStrategy.mo19339a(context);
        }
        return firebaseInfo.mo43257d(context);
    }
}
