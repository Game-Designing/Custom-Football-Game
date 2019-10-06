package com.crashlytics.android.p124a;

import android.content.Context;
import io.fabric.sdk.android.services.common.IdManager.DeviceIdentifierType;
import java.util.Map;
import java.util.UUID;
import p024io.fabric.sdk.android.p348a.p350b.C13852l;
import p024io.fabric.sdk.android.p348a.p350b.C13868y;
import p024io.fabric.sdk.android.p348a.p350b.C13868y.C13869a;

/* renamed from: com.crashlytics.android.a.P */
/* compiled from: SessionMetadataCollector */
class C6376P {

    /* renamed from: a */
    private final Context f11394a;

    /* renamed from: b */
    private final C13868y f11395b;

    /* renamed from: c */
    private final String f11396c;

    /* renamed from: d */
    private final String f11397d;

    public C6376P(Context context, C13868y idManager, String versionCode, String versionName) {
        this.f11394a = context;
        this.f11395b = idManager;
        this.f11396c = versionCode;
        this.f11397d = versionName;
    }

    /* renamed from: a */
    public C6374N mo19375a() {
        Map<DeviceIdentifierType, String> deviceIdentifiers = this.f11395b.mo43263e();
        String appBundleId = this.f11395b.mo43261c();
        String installationId = this.f11395b.mo43262d();
        Boolean limitAdTrackingEnabled = this.f11395b.mo43269k();
        String betaDeviceToken = (String) deviceIdentifiers.get(C13869a.FONT_TOKEN);
        String buildId = C13852l.m44062n(this.f11394a);
        String osVersion = this.f11395b.mo43268j();
        String deviceModel = this.f11395b.mo43265g();
        C6374N n = new C6374N(appBundleId, UUID.randomUUID().toString(), installationId, limitAdTrackingEnabled, betaDeviceToken, buildId, osVersion, deviceModel, this.f11396c, this.f11397d);
        return n;
    }
}
