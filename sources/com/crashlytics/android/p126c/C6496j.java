package com.crashlytics.android.p126c;

/* renamed from: com.crashlytics.android.c.j */
/* compiled from: CompositeCreateReportSpiCall */
class C6496j implements C6495ia {

    /* renamed from: a */
    private final C6501la f11665a;

    /* renamed from: b */
    private final C6531ya f11666b;

    public C6496j(C6501la javaReportSpiCall, C6531ya nativeReportSpiCall) {
        this.f11665a = javaReportSpiCall;
        this.f11666b = nativeReportSpiCall;
    }

    /* renamed from: a */
    public boolean mo19575a(C6493ha requestData) {
        int i = C6494i.f11664a[requestData.f11663b.getType().ordinal()];
        if (i == 1) {
            this.f11665a.mo19575a(requestData);
            return true;
        } else if (i != 2) {
            return false;
        } else {
            this.f11666b.mo19575a(requestData);
            return true;
        }
    }
}
