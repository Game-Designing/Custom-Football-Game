package com.google.android.gms.measurement.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.measurement.zzea;
import com.google.android.gms.measurement.internal.zzcx;
import com.google.android.gms.measurement.internal.zzcy;
import java.util.List;
import java.util.Map;

@KeepForSdk
public class AppMeasurementSdk {

    /* renamed from: a */
    private final zzea f30545a;

    @KeepForSdk
    public static final class ConditionalUserProperty {
        private ConditionalUserProperty() {
        }
    }

    @ShowFirstParty
    @KeepForSdk
    public interface EventInterceptor extends zzcx {
    }

    @ShowFirstParty
    @KeepForSdk
    public interface OnEventListener extends zzcy {
    }

    @KeepForSdk
    /* renamed from: a */
    public static AppMeasurementSdk m32696a(Context context, String str, String str2, String str3, Bundle bundle) {
        return zzea.m32328a(context, str, str2, str3, bundle).mo32819f();
    }

    public AppMeasurementSdk(zzea zzea) {
        this.f30545a = zzea;
    }

    @KeepForSdk
    /* renamed from: b */
    public void mo33111b(String str, String str2, Bundle bundle) {
        this.f30545a.mo32814b(str, str2, bundle);
    }

    @KeepForSdk
    /* renamed from: a */
    public void mo33107a(String str, String str2, Object obj) {
        this.f30545a.mo32811a(str, str2, obj, true);
    }

    @KeepForSdk
    /* renamed from: a */
    public Map<String, Object> mo33102a(String str, String str2, boolean z) {
        return this.f30545a.mo32805a(str, str2, z);
    }

    @KeepForSdk
    /* renamed from: c */
    public void mo33114c(Bundle bundle) {
        this.f30545a.mo32808a(bundle);
    }

    @KeepForSdk
    /* renamed from: a */
    public void mo33106a(String str, String str2, Bundle bundle) {
        this.f30545a.mo32810a(str, str2, bundle);
    }

    @KeepForSdk
    /* renamed from: a */
    public List<Bundle> mo33101a(String str, String str2) {
        return this.f30545a.mo32804a(str, str2);
    }

    @KeepForSdk
    /* renamed from: e */
    public String mo33116e() {
        return this.f30545a.mo32817d();
    }

    @KeepForSdk
    /* renamed from: d */
    public String mo33115d() {
        return this.f30545a.mo32816c();
    }

    @KeepForSdk
    /* renamed from: c */
    public String mo33113c() {
        return this.f30545a.mo32820g();
    }

    @KeepForSdk
    /* renamed from: f */
    public String mo33117f() {
        return this.f30545a.mo32818e();
    }

    @KeepForSdk
    /* renamed from: a */
    public long mo33100a() {
        return this.f30545a.mo32801a();
    }

    @KeepForSdk
    /* renamed from: a */
    public void mo33105a(String str) {
        this.f30545a.mo32809a(str);
    }

    @KeepForSdk
    /* renamed from: b */
    public void mo33110b(String str) {
        this.f30545a.mo32813b(str);
    }

    @KeepForSdk
    /* renamed from: b */
    public Bundle mo33108b(Bundle bundle) {
        return this.f30545a.mo32802a(bundle, true);
    }

    @KeepForSdk
    /* renamed from: a */
    public void mo33104a(Bundle bundle) {
        this.f30545a.mo32802a(bundle, false);
    }

    @KeepForSdk
    /* renamed from: c */
    public int mo33112c(String str) {
        return this.f30545a.mo32815c(str);
    }

    @KeepForSdk
    /* renamed from: a */
    public void mo33103a(Activity activity, String str, String str2) {
        this.f30545a.mo32807a(activity, str, str2);
    }

    @KeepForSdk
    /* renamed from: b */
    public String mo33109b() {
        return this.f30545a.mo32812b();
    }
}
