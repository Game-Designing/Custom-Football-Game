package com.fyber.inneractive.sdk.mraid;

/* renamed from: com.fyber.inneractive.sdk.mraid.w */
public final class C7974w extends C7970s {

    /* renamed from: a */
    private final C7976y f16259a;

    private C7974w(C7976y yVar) {
        this.f16259a = yVar;
    }

    /* renamed from: a */
    public static C7974w m18004a(C7976y yVar) {
        return new C7974w(yVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final String mo24817a() {
        StringBuilder sb = new StringBuilder("state: '");
        sb.append(this.f16259a.toString().toLowerCase());
        sb.append("'");
        return sb.toString();
    }
}
