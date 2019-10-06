package com.crashlytics.android.p126c;

/* renamed from: com.crashlytics.android.c.Pa */
/* compiled from: TrimmedThrowableData */
class C6444Pa {

    /* renamed from: a */
    public final String f11542a;

    /* renamed from: b */
    public final String f11543b;

    /* renamed from: c */
    public final StackTraceElement[] f11544c;

    /* renamed from: d */
    public final C6444Pa f11545d;

    public C6444Pa(Throwable ex, C6442Oa trimmingStrategy) {
        this.f11542a = ex.getLocalizedMessage();
        this.f11543b = ex.getClass().getName();
        this.f11544c = trimmingStrategy.mo19452a(ex.getStackTrace());
        Throwable exCause = ex.getCause();
        this.f11545d = exCause != null ? new C6444Pa(exCause, trimmingStrategy) : null;
    }
}
