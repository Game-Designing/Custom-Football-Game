package com.flurry.sdk;

import com.flurry.sdk.C7607ud.C7608a;

/* renamed from: com.flurry.sdk.wa */
public class C7616wa extends C7390Hc implements C7608a {
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static final String f15120f = C7616wa.class.getSimpleName();

    /* renamed from: g */
    private String f15121g;

    /* renamed from: h */
    private boolean f15122h;

    public C7616wa() {
        this(0);
    }

    private C7616wa(byte b) {
        super("Analytics", C7616wa.class.getSimpleName());
        this.f14483b = "AnalyticsData_";
        C7602td a = C7602td.m16825a();
        String str = "UseHttps";
        this.f15122h = ((Boolean) a.mo24023a(str)).booleanValue();
        a.mo24024a(str, (C7608a) this);
        String str2 = f15120f;
        StringBuilder sb = new StringBuilder("initSettings, UseHttps = ");
        sb.append(this.f15122h);
        C7513ec.m16639a(4, str2, sb.toString());
        String str3 = "ReportUrl";
        String str4 = (String) a.mo24023a(str3);
        a.mo24024a(str3, (C7608a) this);
        m16842a(str4);
        C7513ec.m16639a(4, f15120f, "initSettings, ReportUrl = ".concat(String.valueOf(str4)));
        mo23827a();
    }

    /* renamed from: a */
    private void m16842a(String str) {
        if (str != null && !str.endsWith(".do")) {
            C7513ec.m16639a(5, f15120f, "overriding analytics agent report URL without an endpoint, are you sure?");
        }
        this.f15121g = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0048  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo23820a(java.lang.String r4, java.lang.Object r5) {
        /*
            r3 = this;
            int r0 = r4.hashCode()
            r1 = -239660092(0xfffffffff1b713c4, float:-1.8131089E30)
            r2 = 1
            if (r0 == r1) goto L_0x001a
            r1 = 1650629499(0x62629b7b, float:1.0450419E21)
            if (r0 == r1) goto L_0x0010
        L_0x000f:
            goto L_0x0024
        L_0x0010:
            java.lang.String r0 = "ReportUrl"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x000f
            r4 = 1
            goto L_0x0025
        L_0x001a:
            java.lang.String r0 = "UseHttps"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x000f
            r4 = 0
            goto L_0x0025
        L_0x0024:
            r4 = -1
        L_0x0025:
            r0 = 4
            if (r4 == 0) goto L_0x0048
            if (r4 == r2) goto L_0x0033
            r4 = 6
            java.lang.String r5 = f15120f
            java.lang.String r0 = "onSettingUpdate internal error!"
            com.flurry.sdk.C7513ec.m16639a(r4, r5, r0)
            return
        L_0x0033:
            java.lang.String r5 = (java.lang.String) r5
            r3.m16842a(r5)
            java.lang.String r4 = f15120f
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.String r1 = "onSettingUpdate, ReportUrl = "
            java.lang.String r5 = r1.concat(r5)
            com.flurry.sdk.C7513ec.m16639a(r0, r4, r5)
            return
        L_0x0048:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r4 = r5.booleanValue()
            r3.f15122h = r4
            java.lang.String r4 = f15120f
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r1 = "onSettingUpdate, UseHttps = "
            r5.<init>(r1)
            boolean r1 = r3.f15122h
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            com.flurry.sdk.C7513ec.m16639a(r0, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.C7616wa.mo23820a(java.lang.String, java.lang.Object):void");
    }

    /* JADX WARNING: type inference failed for: r7v0, types: [byte[], RequestObjectType] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte[], code=null, for r7v0, types: [byte[], RequestObjectType] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo23829a(byte[] r7, java.lang.String r8, java.lang.String r9) {
        /*
            r6 = this;
            java.lang.String r0 = r6.f15121g
            if (r0 == 0) goto L_0x0006
            goto L_0x000f
        L_0x0006:
            boolean r0 = r6.f15122h
            if (r0 == 0) goto L_0x000d
            java.lang.String r0 = "https://data.flurry.com/aap.do"
            goto L_0x000f
        L_0x000d:
            java.lang.String r0 = "http://data.flurry.com/aap.do"
        L_0x000f:
            long r1 = java.lang.System.currentTimeMillis()
            java.lang.String r1 = java.lang.Long.toString(r1)
            r2 = 4
            java.lang.String r3 = f15120f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "FlurryDataSender: id = "
            r4.<init>(r5)
            r4.append(r8)
            java.lang.String r5 = " to "
            r4.append(r5)
            r4.append(r0)
            java.lang.String r5 = " at "
            r4.append(r5)
            r4.append(r1)
            java.lang.String r4 = r4.toString()
            com.flurry.sdk.C7513ec.m16639a(r2, r3, r4)
            com.flurry.sdk.lc r2 = new com.flurry.sdk.lc
            r2.<init>()
            r2.f15002i = r0
            r0 = 100000(0x186a0, float:1.4013E-40)
            r2.f14426d = r0
            com.flurry.sdk.pc$a r0 = com.flurry.sdk.C7577pc.C7578a.kPost
            r2.f15003j = r0
            java.lang.String r0 = "Content-Type"
            java.lang.String r3 = "application/octet-stream"
            r2.mo23988a(r0, r3)
            java.lang.String r0 = "X-Flurry-Sdk-Clock"
            r2.mo23988a(r0, r1)
            com.flurry.sdk.Vc r0 = new com.flurry.sdk.Vc
            r0.<init>()
            r2.f14937F = r0
            r2.f14935D = r7
            com.flurry.sdk.ua r7 = new com.flurry.sdk.ua
            r7.<init>(r6, r8, r9)
            r2.f14934C = r7
            com.flurry.sdk.zb r7 = com.flurry.sdk.C7633zb.m16869a()
            r7.mo23939a(r6, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.C7616wa.mo23829a(byte[], java.lang.String, java.lang.String):void");
    }

    /* renamed from: a */
    public final void mo23828a(String str, String str2, int i) {
        C7379Fb.m16300a().mo23817b(new C7610va(this, i));
        super.mo23828a(str, str2, i);
    }
}
