package com.google.android.gms.ads;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.internal.ads.zzabh;

@KeepForSdkWithMembers
public class MobileAdsInitProvider extends ContentProvider {

    /* renamed from: a */
    private final zzabh f19023a = new zzabh();

    public void attachInfo(Context context, ProviderInfo providerInfo) {
        this.f19023a.attachInfo(context, providerInfo);
    }

    public boolean onCreate() {
        return this.f19023a.onCreate();
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return this.f19023a.query(uri, strArr, str, strArr2, str2);
    }

    public String getType(Uri uri) {
        return this.f19023a.getType(uri);
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return this.f19023a.insert(uri, contentValues);
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return this.f19023a.delete(uri, str, strArr);
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return this.f19023a.update(uri, contentValues, str, strArr);
    }
}
