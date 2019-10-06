package com.fyber.inneractive.sdk.util;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;

/* renamed from: com.fyber.inneractive.sdk.util.y */
final class C8044y {

    /* renamed from: a */
    private transient C8045a[] f16397a;

    /* renamed from: b */
    private transient int f16398b;

    /* renamed from: c */
    private int f16399c;

    /* renamed from: d */
    private float f16400d;

    /* renamed from: com.fyber.inneractive.sdk.util.y$a */
    private static class C8045a {

        /* renamed from: a */
        int f16401a;

        /* renamed from: b */
        int f16402b;

        /* renamed from: c */
        Object f16403c;

        /* renamed from: d */
        C8045a f16404d;

        protected C8045a(int i, int i2, Object obj, C8045a aVar) {
            this.f16401a = i;
            this.f16402b = i2;
            this.f16403c = obj;
            this.f16404d = aVar;
        }
    }

    public C8044y() {
        this(0);
    }

    private C8044y(byte b) {
        this.f16400d = 0.75f;
        this.f16397a = new C8045a[20];
        this.f16399c = 15;
    }

    /* renamed from: a */
    public final Object mo24875a(int i, Object obj) {
        C8045a[] aVarArr = this.f16397a;
        int i2 = i & MoPubClientPositioning.NO_REPEAT;
        int length = i2 % aVarArr.length;
        for (C8045a aVar = aVarArr[length]; aVar != null; aVar = aVar.f16404d) {
            if (aVar.f16401a == i) {
                Object obj2 = aVar.f16403c;
                aVar.f16403c = obj;
                return obj2;
            }
        }
        if (this.f16398b >= this.f16399c) {
            C8045a[] aVarArr2 = this.f16397a;
            int length2 = aVarArr2.length;
            int i3 = (length2 * 2) + 1;
            C8045a[] aVarArr3 = new C8045a[i3];
            this.f16399c = (int) (((float) i3) * this.f16400d);
            this.f16397a = aVarArr3;
            while (true) {
                int i4 = length2 - 1;
                if (length2 <= 0) {
                    break;
                }
                C8045a aVar2 = aVarArr2[i4];
                while (aVar2 != null) {
                    C8045a aVar3 = aVar2.f16404d;
                    int i5 = (aVar2.f16401a & MoPubClientPositioning.NO_REPEAT) % i3;
                    aVar2.f16404d = aVarArr3[i5];
                    aVarArr3[i5] = aVar2;
                    aVar2 = aVar3;
                }
                length2 = i4;
            }
            aVarArr = this.f16397a;
            length = i2 % aVarArr.length;
        }
        aVarArr[length] = new C8045a(i, i, obj, aVarArr[length]);
        this.f16398b++;
        return null;
    }
}
