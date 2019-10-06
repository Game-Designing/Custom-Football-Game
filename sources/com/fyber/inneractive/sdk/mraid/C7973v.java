package com.fyber.inneractive.sdk.mraid;

/* renamed from: com.fyber.inneractive.sdk.mraid.v */
public final class C7973v extends C7970s {

    /* renamed from: a */
    private final int f16257a;

    /* renamed from: b */
    private final int f16258b;

    private C7973v(int i, int i2) {
        this.f16257a = i;
        this.f16258b = i2;
    }

    /* renamed from: a */
    public static C7973v m18002a(int i, int i2) {
        return new C7973v(i, i2);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final String mo24817a() {
        StringBuilder sb = new StringBuilder("screenSize: { width: ");
        sb.append(this.f16257a);
        sb.append(", height: ");
        sb.append(this.f16258b);
        sb.append(" }");
        return sb.toString();
    }
}
