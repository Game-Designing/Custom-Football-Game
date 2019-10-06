package com.google.android.gms.internal.ads;

@zzard
/* renamed from: com.google.android.gms.internal.ads.ue */
final class C9748ue extends zzay {

    /* renamed from: c */
    static final C9748ue f23052c = new C9748ue();

    C9748ue() {
    }

    /* renamed from: a */
    public final zzbd mo29198a(String str, byte[] bArr, String str2) {
        if ("moov".equals(str)) {
            return new zzbf();
        }
        if ("mvhd".equals(str)) {
            return new zzbg();
        }
        return new zzbh(str);
    }
}
