package com.crashlytics.android.p124a;

/* renamed from: com.crashlytics.android.a.N */
/* compiled from: SessionEventMetadata */
final class C6374N {

    /* renamed from: a */
    public final String f11383a;

    /* renamed from: b */
    public final String f11384b;

    /* renamed from: c */
    public final String f11385c;

    /* renamed from: d */
    public final Boolean f11386d;

    /* renamed from: e */
    public final String f11387e;

    /* renamed from: f */
    public final String f11388f;

    /* renamed from: g */
    public final String f11389g;

    /* renamed from: h */
    public final String f11390h;

    /* renamed from: i */
    public final String f11391i;

    /* renamed from: j */
    public final String f11392j;

    /* renamed from: k */
    private String f11393k;

    public C6374N(String appBundleId, String executionId, String installationId, Boolean limitAdTrackingEnabled, String betaDeviceToken, String buildId, String osVersion, String deviceModel, String appVersionCode, String appVersionName) {
        this.f11383a = appBundleId;
        this.f11384b = executionId;
        this.f11385c = installationId;
        this.f11386d = limitAdTrackingEnabled;
        this.f11387e = betaDeviceToken;
        this.f11388f = buildId;
        this.f11389g = osVersion;
        this.f11390h = deviceModel;
        this.f11391i = appVersionCode;
        this.f11392j = appVersionName;
    }

    public String toString() {
        if (this.f11393k == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("appBundleId=");
            sb.append(this.f11383a);
            sb.append(", executionId=");
            sb.append(this.f11384b);
            sb.append(", installationId=");
            sb.append(this.f11385c);
            sb.append(", limitAdTrackingEnabled=");
            sb.append(this.f11386d);
            sb.append(", betaDeviceToken=");
            sb.append(this.f11387e);
            sb.append(", buildId=");
            sb.append(this.f11388f);
            sb.append(", osVersion=");
            sb.append(this.f11389g);
            sb.append(", deviceModel=");
            sb.append(this.f11390h);
            sb.append(", appVersionCode=");
            sb.append(this.f11391i);
            sb.append(", appVersionName=");
            this.f11393k = sb.append(this.f11392j).toString();
        }
        return this.f11393k;
    }
}
