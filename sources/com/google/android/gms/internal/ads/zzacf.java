package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;

@zzard
public final class zzacf {

    /* renamed from: a */
    private final Context f23881a;

    public zzacf(Context context) {
        Preconditions.m21858a(context, (Object) "Context can not be null");
        this.f23881a = context;
    }

    /* renamed from: a */
    public final boolean mo29585a() {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:"));
        return m24749a(intent);
    }

    /* renamed from: b */
    public final boolean mo29586b() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("sms:"));
        return m24749a(intent);
    }

    /* renamed from: c */
    public final boolean mo29587c() {
        return ((Boolean) zzazl.m26284a(this.f23881a, new C9528k())).booleanValue() && Wrappers.m22139a(this.f23881a).mo27942a("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    @TargetApi(14)
    /* renamed from: d */
    public final boolean mo29588d() {
        return m24749a(new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.dir/event"));
    }

    /* renamed from: a */
    private final boolean m24749a(Intent intent) {
        Preconditions.m21858a(intent, (Object) "Intent can not be null");
        if (!this.f23881a.getPackageManager().queryIntentActivities(intent, 0).isEmpty()) {
            return true;
        }
        return false;
    }
}
