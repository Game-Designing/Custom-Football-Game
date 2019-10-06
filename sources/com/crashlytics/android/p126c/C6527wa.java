package com.crashlytics.android.p126c;

/* renamed from: com.crashlytics.android.c.wa */
/* compiled from: MiddleOutFallbackStrategy */
class C6527wa implements C6442Oa {

    /* renamed from: a */
    private final int f11717a;

    /* renamed from: b */
    private final C6442Oa[] f11718b;

    /* renamed from: c */
    private final C6529xa f11719c;

    public C6527wa(int maximumStackSize, C6442Oa... strategies) {
        this.f11717a = maximumStackSize;
        this.f11718b = strategies;
        this.f11719c = new C6529xa(maximumStackSize);
    }

    /* renamed from: a */
    public StackTraceElement[] mo19452a(StackTraceElement[] stacktrace) {
        C6442Oa[] oaArr;
        if (stacktrace.length <= this.f11717a) {
            return stacktrace;
        }
        StackTraceElement[] trimmed = stacktrace;
        for (C6442Oa strategy : this.f11718b) {
            if (trimmed.length <= this.f11717a) {
                break;
            }
            trimmed = strategy.mo19452a(stacktrace);
        }
        if (trimmed.length > this.f11717a) {
            trimmed = this.f11719c.mo19452a(trimmed);
        }
        return trimmed;
    }
}
