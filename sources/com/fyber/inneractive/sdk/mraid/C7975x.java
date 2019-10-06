package com.fyber.inneractive.sdk.mraid;

/* renamed from: com.fyber.inneractive.sdk.mraid.x */
public final class C7975x extends C7970s {

    /* renamed from: a */
    public boolean f16260a;

    /* renamed from: b */
    public boolean f16261b;

    /* renamed from: c */
    public boolean f16262c;

    /* renamed from: d */
    public boolean f16263d;

    /* renamed from: e */
    public boolean f16264e;

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final String mo24817a() {
        StringBuilder sb = new StringBuilder("supports: {sms: ");
        sb.append(String.valueOf(this.f16260a));
        sb.append(", tel: ");
        sb.append(String.valueOf(this.f16261b));
        sb.append(", calendar: ");
        sb.append(String.valueOf(this.f16262c));
        sb.append(", storePicture: ");
        sb.append(String.valueOf(this.f16263d));
        sb.append(", inlineVideo: ");
        sb.append(String.valueOf(this.f16264e));
        sb.append("}");
        return sb.toString();
    }
}
