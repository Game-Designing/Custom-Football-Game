package com.fyber.inneractive.sdk.mraid;

/* renamed from: com.fyber.inneractive.sdk.mraid.t */
public final class C7971t extends C7970s {

    /* renamed from: a */
    private final int f16254a;

    /* renamed from: b */
    private final int f16255b;

    private C7971t(int i, int i2) {
        this.f16254a = i;
        this.f16255b = i2;
    }

    /* renamed from: a */
    public static C7971t m17998a(int i, int i2) {
        return new C7971t(i, i2);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final String mo24817a() {
        StringBuilder sb = new StringBuilder("maxSize: { width: ");
        sb.append(this.f16254a);
        sb.append(", height: ");
        sb.append(this.f16255b);
        sb.append(" }");
        return sb.toString();
    }
}
