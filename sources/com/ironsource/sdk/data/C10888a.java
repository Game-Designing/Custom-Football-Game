package com.ironsource.sdk.data;

/* renamed from: com.ironsource.sdk.data.a */
/* compiled from: AdUnitsReady */
public class C10888a extends C10897j {

    /* renamed from: b */
    private static String f33233b = "type";

    /* renamed from: c */
    private static String f33234c = "numOfAdUnits";

    /* renamed from: d */
    private static String f33235d = "firstCampaignCredits";

    /* renamed from: e */
    private static String f33236e = "totalNumberCredits";

    /* renamed from: f */
    private static String f33237f = "productType";

    /* renamed from: g */
    private String f33238g;

    /* renamed from: h */
    private String f33239h;

    /* renamed from: i */
    private String f33240i;

    /* renamed from: j */
    private String f33241j;

    /* renamed from: k */
    private String f33242k;

    /* renamed from: l */
    private boolean f33243l;

    public C10888a(String value) {
        super(value);
        if (mo35670a(f33233b)) {
            mo35644j(mo35673d(f33233b));
        }
        if (mo35670a(f33234c)) {
            mo35641g(mo35673d(f33234c));
            m35636a(true);
        } else {
            m35636a(false);
        }
        if (mo35670a(f33235d)) {
            mo35640f(mo35673d(f33235d));
        }
        if (mo35670a(f33236e)) {
            mo35643i(mo35673d(f33236e));
        }
        if (mo35670a(f33237f)) {
            mo35642h(mo35673d(f33237f));
        }
    }

    /* renamed from: j */
    public void mo35644j(String type) {
        this.f33238g = type;
    }

    /* renamed from: b */
    public String mo35637b() {
        return this.f33240i;
    }

    /* renamed from: g */
    public void mo35641g(String numOfAdUnits) {
        this.f33240i = numOfAdUnits;
    }

    /* renamed from: f */
    public void mo35640f(String firstCampaignCredits) {
        this.f33241j = firstCampaignCredits;
    }

    /* renamed from: i */
    public void mo35643i(String totalNumberCredits) {
        this.f33242k = totalNumberCredits;
    }

    /* renamed from: a */
    private void m35636a(boolean value) {
        this.f33243l = value;
    }

    /* renamed from: d */
    public boolean mo35639d() {
        return this.f33243l;
    }

    /* renamed from: c */
    public String mo35638c() {
        return this.f33239h;
    }

    /* renamed from: h */
    public void mo35642h(String productType) {
        this.f33239h = productType;
    }
}
