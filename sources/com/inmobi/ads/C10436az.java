package com.inmobi.ads;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.util.Locale;

/* renamed from: com.inmobi.ads.az */
/* compiled from: NativeTextAsset */
public class C10436az extends C10400ak {

    /* renamed from: com.inmobi.ads.az$a */
    /* compiled from: NativeTextAsset */
    static class C10437a extends C10401al {

        /* renamed from: l */
        protected int f31749l;

        /* renamed from: m */
        protected String f31750m;

        /* renamed from: n */
        protected int f31751n = MoPubClientPositioning.NO_REPEAT;

        /* renamed from: o */
        protected String[] f31752o;

        /* renamed from: p */
        int f31753p;

        public C10437a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, String str, String str2, String str3, String str4, C10441ba baVar) {
            int i9 = i;
            int i10 = i2;
            int i11 = i3;
            int i12 = i4;
            int i13 = i5;
            int i14 = i6;
            int i15 = i7;
            int i16 = i8;
            String str5 = str;
            String str6 = str2;
            String str7 = str3;
            String str8 = str4;
            C10441ba baVar2 = baVar;
            String[] strArr = new String[1];
            String[] strArr2 = strArr;
            strArr[0] = "none";
            this(i9, i10, i11, i12, i13, i14, i15, i16, str5, str6, str7, str8, 12, 0, MoPubClientPositioning.NO_REPEAT, "#ff000000", strArr2, baVar2);
        }

        public C10437a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, String str, String str2, String str3, String str4, int i9, int i10, int i11, String str5, String[] strArr, C10441ba baVar) {
            String[] strArr2 = strArr;
            super(i, i2, i3, i4, i5, i6, i7, i8, str, str2, str3, str4, baVar);
            this.f31749l = i9;
            this.f31750m = str5.length() == 0 ? "#ff000000" : str5;
            this.f31751n = i11;
            int min = Math.min(strArr2.length, 4);
            this.f31752o = new String[min];
            this.f31753p = i10;
            System.arraycopy(strArr2, 0, this.f31752o, 0, min);
        }

        /* renamed from: h */
        public final int mo34139h() {
            return this.f31749l;
        }

        /* renamed from: i */
        public final String mo34140i() {
            return this.f31750m.toLowerCase(Locale.US);
        }

        /* renamed from: j */
        public final String[] mo34141j() {
            return this.f31752o;
        }

        /* renamed from: e */
        public final String mo34095e() {
            return this.f31642j.toLowerCase(Locale.US);
        }
    }

    public C10436az(String str, String str2, C10401al alVar, String str3) {
        super(str, str2, "TEXT", alVar);
        this.f31612e = str3;
    }

    public C10436az(String str, String str2, String str3, C10401al alVar, String str4) {
        super(str, str2, str3, alVar);
        this.f31612e = str4;
    }
}
