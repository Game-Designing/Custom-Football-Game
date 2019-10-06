package com.fyber.inneractive.sdk.mraid;

/* renamed from: com.fyber.inneractive.sdk.mraid.r */
public final class C7969r extends C7970s {

    /* renamed from: a */
    private final int f16252a;

    /* renamed from: b */
    private final int f16253b;

    private C7969r(int i, int i2) {
        this.f16252a = i;
        this.f16253b = i2;
    }

    /* renamed from: a */
    public static C7969r m17995a(int i, int i2) {
        return new C7969r(i, i2);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final String mo24817a() {
        StringBuilder sb = new StringBuilder("adSize: { width: ");
        sb.append(this.f16252a);
        sb.append(", height: ");
        sb.append(this.f16253b);
        sb.append(" }");
        return sb.toString();
    }
}
