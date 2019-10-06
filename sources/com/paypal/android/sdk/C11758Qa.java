package com.paypal.android.sdk;

/* renamed from: com.paypal.android.sdk.Qa */
public final class C11758Qa {

    /* renamed from: a */
    private static /* synthetic */ boolean f36879a = (!C11758Qa.class.desiredAssertionStatus());

    /* renamed from: b */
    private C11788a f36880b;

    /* renamed from: c */
    private String f36881c;

    public C11758Qa(C11788a aVar, String str) {
        if (f36879a || aVar != null) {
            this.f36880b = aVar;
            StringBuilder sb = new StringBuilder("com.paypal.android.sdk.encr.");
            sb.append(str);
            sb.append(".");
            this.f36881c = sb.toString();
            return;
        }
        throw new AssertionError();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0070 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0071 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0061  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.paypal.android.sdk.C11804dl mo38614a() {
        /*
            r6 = this;
            com.paypal.android.sdk.a r0 = r6.f36880b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r6.f36881c
            r1.append(r2)
            java.lang.String r2 = "loginPhoneNumber"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r0 = r0.mo38689a(r1)
            r1 = 0
            if (r0 == 0) goto L_0x0026
            com.paypal.android.sdk.Ja r2 = com.paypal.android.sdk.C11737Ja.m38864a()     // Catch:{ en -> 0x0025 }
            com.paypal.android.sdk.eu r0 = com.paypal.android.sdk.C11816eu.m39129a(r2, r0)     // Catch:{ en -> 0x0025 }
            goto L_0x0027
        L_0x0025:
            r0 = move-exception
        L_0x0026:
            r0 = r1
        L_0x0027:
            com.paypal.android.sdk.a r2 = r6.f36880b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r6.f36881c
            r3.append(r4)
            java.lang.String r4 = "loginEmail"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.String r2 = r2.mo38689a(r3)
            com.paypal.android.sdk.a r3 = r6.f36880b
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = r6.f36881c
            r4.append(r5)
            java.lang.String r5 = "loginTypePrevious"
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.String r3 = r3.mo38689a(r4)
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 == 0) goto L_0x0061
            r3 = r1
            goto L_0x0065
        L_0x0061:
            com.paypal.android.sdk.Sa r3 = com.paypal.android.sdk.C11763Sa.valueOf(r3)
        L_0x0065:
            com.paypal.android.sdk.dl r4 = new com.paypal.android.sdk.dl
            r4.<init>(r2, r0, r3)
            boolean r0 = r4.mo38723d()
            if (r0 == 0) goto L_0x0071
            return r4
        L_0x0071:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paypal.android.sdk.C11758Qa.mo38614a():com.paypal.android.sdk.dl");
    }

    /* renamed from: a */
    public final C11805ds mo38615a(String str) {
        C11788a aVar = this.f36880b;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f36881c);
        sb.append("tokenizedRedactedCardNumber");
        String a = aVar.mo38689a(sb.toString());
        C11788a aVar2 = this.f36880b;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f36881c);
        sb2.append("token");
        String a2 = aVar2.mo38689a(sb2.toString());
        C11788a aVar3 = this.f36880b;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(this.f36881c);
        sb3.append("tokenPayerID");
        String a3 = aVar3.mo38689a(sb3.toString());
        C11788a aVar4 = this.f36880b;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(this.f36881c);
        sb4.append("tokenValidUntil");
        String a4 = aVar4.mo38689a(sb4.toString());
        C11788a aVar5 = this.f36880b;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.f36881c);
        sb5.append("tokenizedCardType");
        String a5 = aVar5.mo38689a(sb5.toString());
        C11788a aVar6 = this.f36880b;
        StringBuilder sb6 = new StringBuilder();
        sb6.append(this.f36881c);
        sb6.append("tokenizedCardExpiryMonth");
        String a6 = aVar6.mo38689a(sb6.toString());
        int parseInt = a6 != null ? Integer.parseInt(a6) : 0;
        C11788a aVar7 = this.f36880b;
        StringBuilder sb7 = new StringBuilder();
        sb7.append(this.f36881c);
        sb7.append("tokenizedCardExpiryYear");
        String a7 = aVar7.mo38689a(sb7.toString());
        int parseInt2 = a7 != null ? Integer.parseInt(a7) : 0;
        C11788a aVar8 = this.f36880b;
        StringBuilder sb8 = new StringBuilder();
        sb8.append(this.f36881c);
        sb8.append("tokenClientId");
        String c = aVar8.mo38695c(aVar8.mo38689a(sb8.toString()));
        if (!C11723Fa.m38818a((CharSequence) c) && c.equals(str)) {
            C11805ds dsVar = new C11805ds(a2, a3, a4, a, a5, parseInt, parseInt2);
            if (dsVar.mo38726b()) {
                return dsVar;
            }
        }
        return null;
    }

    /* renamed from: a */
    public final void mo38616a(C11804dl dlVar) {
        String str = null;
        String b = dlVar.mo38717a() != null ? dlVar.mo38717a().mo38786b() : null;
        C11788a aVar = this.f36880b;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f36881c);
        sb.append("loginPhoneNumber");
        aVar.mo38690a(sb.toString(), b);
        C11788a aVar2 = this.f36880b;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f36881c);
        sb2.append("loginEmail");
        aVar2.mo38690a(sb2.toString(), dlVar.mo38721b());
        if (dlVar.mo38722c() != null) {
            str = dlVar.mo38722c().toString();
        }
        C11788a aVar3 = this.f36880b;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(this.f36881c);
        sb3.append("loginTypePrevious");
        aVar3.mo38690a(sb3.toString(), str);
    }

    /* renamed from: a */
    public final void mo38617a(C11805ds dsVar, String str) {
        C11788a aVar = this.f36880b;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f36881c);
        sb.append("token");
        aVar.mo38690a(sb.toString(), dsVar.mo38730e());
        C11788a aVar2 = this.f36880b;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f36881c);
        sb2.append("tokenPayerID");
        aVar2.mo38690a(sb2.toString(), dsVar.mo38631a());
        String str2 = null;
        String format = dsVar.mo38727c() != null ? new C12004sb().format(dsVar.mo38727c()) : null;
        C11788a aVar3 = this.f36880b;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(this.f36881c);
        sb3.append("tokenValidUntil");
        aVar3.mo38690a(sb3.toString(), format);
        C11788a aVar4 = this.f36880b;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(this.f36881c);
        sb4.append("tokenizedRedactedCardNumber");
        aVar4.mo38690a(sb4.toString(), dsVar.mo38728d());
        if (dsVar.mo38733h() != null) {
            str2 = dsVar.mo38733h().toString();
        }
        C11788a aVar5 = this.f36880b;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.f36881c);
        sb5.append("tokenizedCardType");
        aVar5.mo38690a(sb5.toString(), str2);
        C11788a aVar6 = this.f36880b;
        StringBuilder sb6 = new StringBuilder();
        sb6.append(this.f36881c);
        sb6.append("tokenizedCardExpiryMonth");
        aVar6.mo38690a(sb6.toString(), String.valueOf(dsVar.mo38731f()));
        C11788a aVar7 = this.f36880b;
        StringBuilder sb7 = new StringBuilder();
        sb7.append(this.f36881c);
        sb7.append("tokenizedCardExpiryYear");
        aVar7.mo38690a(sb7.toString(), String.valueOf(dsVar.mo38732g()));
        C11788a aVar8 = this.f36880b;
        StringBuilder sb8 = new StringBuilder();
        sb8.append(this.f36881c);
        sb8.append("tokenClientId");
        aVar8.mo38690a(sb8.toString(), this.f36880b.mo38693b(str));
    }

    /* renamed from: b */
    public final void mo38618b() {
        mo38616a(new C11804dl());
    }

    /* renamed from: c */
    public final void mo38619c() {
        mo38617a(new C11805ds(), null);
    }
}
