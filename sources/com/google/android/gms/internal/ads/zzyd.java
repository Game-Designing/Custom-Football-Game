package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@zzard
public final class zzyd extends AbstractSafeParcelable {
    public static final Creator<zzyd> CREATOR = new zzye();

    /* renamed from: a */
    public final String f29768a;

    /* renamed from: b */
    public final int f29769b;

    /* renamed from: c */
    public final int f29770c;

    /* renamed from: d */
    public final boolean f29771d;

    /* renamed from: e */
    public final int f29772e;

    /* renamed from: f */
    public final int f29773f;

    /* renamed from: g */
    public final zzyd[] f29774g;

    /* renamed from: h */
    public final boolean f29775h;

    /* renamed from: i */
    public final boolean f29776i;

    /* renamed from: j */
    public boolean f29777j;

    /* renamed from: a */
    public static int m31509a(DisplayMetrics displayMetrics) {
        return displayMetrics.widthPixels;
    }

    /* renamed from: b */
    public static int m31512b(DisplayMetrics displayMetrics) {
        return (int) (((float) m31513c(displayMetrics)) * displayMetrics.density);
    }

    /* renamed from: c */
    private static int m31513c(DisplayMetrics displayMetrics) {
        int i = (int) (((float) displayMetrics.heightPixels) / displayMetrics.density);
        if (i <= 400) {
            return 32;
        }
        if (i <= 720) {
            return 50;
        }
        return 90;
    }

    /* renamed from: a */
    public static zzyd m31511a(Context context) {
        zzyd zzyd = new zzyd("320x50_mb", 0, 0, false, 0, 0, null, true, false, false);
        return zzyd;
    }

    /* renamed from: a */
    public static zzyd m31510a() {
        zzyd zzyd = new zzyd("reward_mb", 0, 0, true, 0, 0, null, false, false, false);
        return zzyd;
    }

    public zzyd() {
        this("interstitial_mb", 0, 0, true, 0, 0, null, false, false, false);
    }

    public zzyd(Context context, AdSize adSize) {
        this(context, new AdSize[]{adSize});
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0088  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzyd(android.content.Context r13, com.google.android.gms.ads.AdSize[] r14) {
        /*
            r12 = this;
            r12.<init>()
            r0 = 0
            r1 = r14[r0]
            r12.f29771d = r0
            boolean r2 = r1.isFluid()
            r12.f29776i = r2
            boolean r2 = r12.f29776i
            if (r2 == 0) goto L_0x0023
            com.google.android.gms.ads.AdSize r2 = com.google.android.gms.ads.AdSize.BANNER
            int r2 = r2.getWidth()
            r12.f29772e = r2
            com.google.android.gms.ads.AdSize r2 = com.google.android.gms.ads.AdSize.BANNER
            int r2 = r2.getHeight()
            r12.f29769b = r2
            goto L_0x002f
        L_0x0023:
            int r2 = r1.getWidth()
            r12.f29772e = r2
            int r2 = r1.getHeight()
            r12.f29769b = r2
        L_0x002f:
            int r2 = r12.f29772e
            r3 = -1
            r4 = 1
            if (r2 != r3) goto L_0x0037
            r2 = 1
            goto L_0x0038
        L_0x0037:
            r2 = 0
        L_0x0038:
            int r3 = r12.f29769b
            r5 = -2
            if (r3 != r5) goto L_0x003f
            r3 = 1
            goto L_0x0040
        L_0x003f:
            r3 = 0
        L_0x0040:
            android.content.res.Resources r5 = r13.getResources()
            android.util.DisplayMetrics r5 = r5.getDisplayMetrics()
            if (r2 == 0) goto L_0x008b
            com.google.android.gms.internal.ads.zzyt.m31532a()
            boolean r6 = com.google.android.gms.internal.ads.zzazt.m26319d(r13)
            if (r6 == 0) goto L_0x006a
            com.google.android.gms.internal.ads.zzyt.m31532a()
            boolean r6 = com.google.android.gms.internal.ads.zzazt.m26320e(r13)
            if (r6 == 0) goto L_0x006a
            int r6 = r5.widthPixels
            com.google.android.gms.internal.ads.zzyt.m31532a()
            int r7 = com.google.android.gms.internal.ads.zzazt.m26321f(r13)
            int r6 = r6 - r7
            r12.f29773f = r6
            goto L_0x006f
        L_0x006a:
            int r6 = r5.widthPixels
            r12.f29773f = r6
        L_0x006f:
            int r6 = r12.f29773f
            float r6 = (float) r6
            float r7 = r5.density
            float r6 = r6 / r7
            double r6 = (double) r6
            int r8 = (int) r6
            double r9 = (double) r8
            java.lang.Double.isNaN(r6)
            java.lang.Double.isNaN(r9)
            double r6 = r6 - r9
            r9 = 4576918229304087675(0x3f847ae147ae147b, double:0.01)
            int r11 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r11 < 0) goto L_0x008a
            int r8 = r8 + 1
        L_0x008a:
            goto L_0x0098
        L_0x008b:
            int r8 = r12.f29772e
            com.google.android.gms.internal.ads.zzyt.m31532a()
            int r6 = r12.f29772e
            int r6 = com.google.android.gms.internal.ads.zzazt.m26303a(r5, r6)
            r12.f29773f = r6
        L_0x0098:
            if (r3 == 0) goto L_0x009f
            int r6 = m31513c(r5)
            goto L_0x00a1
        L_0x009f:
            int r6 = r12.f29769b
        L_0x00a1:
            com.google.android.gms.internal.ads.zzyt.m31532a()
            int r5 = com.google.android.gms.internal.ads.zzazt.m26303a(r5, r6)
            r12.f29770c = r5
            if (r2 != 0) goto L_0x00bf
            if (r3 == 0) goto L_0x00af
            goto L_0x00bf
        L_0x00af:
            boolean r2 = r12.f29776i
            if (r2 == 0) goto L_0x00b8
            java.lang.String r1 = "320x50_mb"
            r12.f29768a = r1
            goto L_0x00dc
        L_0x00b8:
            java.lang.String r1 = r1.toString()
            r12.f29768a = r1
            goto L_0x00dc
        L_0x00bf:
            r1 = 26
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            r2.append(r8)
            java.lang.String r1 = "x"
            r2.append(r1)
            r2.append(r6)
            java.lang.String r1 = "_as"
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r12.f29768a = r1
        L_0x00dc:
            int r1 = r14.length
            if (r1 <= r4) goto L_0x00f7
            int r1 = r14.length
            com.google.android.gms.internal.ads.zzyd[] r1 = new com.google.android.gms.internal.ads.zzyd[r1]
            r12.f29774g = r1
            r1 = 0
        L_0x00e5:
            int r2 = r14.length
            if (r1 >= r2) goto L_0x00f6
            com.google.android.gms.internal.ads.zzyd[] r2 = r12.f29774g
            com.google.android.gms.internal.ads.zzyd r3 = new com.google.android.gms.internal.ads.zzyd
            r4 = r14[r1]
            r3.<init>(r13, r4)
            r2[r1] = r3
            int r1 = r1 + 1
            goto L_0x00e5
        L_0x00f6:
            goto L_0x00fa
        L_0x00f7:
            r13 = 0
            r12.f29774g = r13
        L_0x00fa:
            r12.f29775h = r0
            r12.f29777j = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzyd.<init>(android.content.Context, com.google.android.gms.ads.AdSize[]):void");
    }

    @Constructor
    zzyd(@Param(id = 2) String str, @Param(id = 3) int i, @Param(id = 4) int i2, @Param(id = 5) boolean z, @Param(id = 6) int i3, @Param(id = 7) int i4, @Param(id = 8) zzyd[] zzydArr, @Param(id = 9) boolean z2, @Param(id = 10) boolean z3, @Param(id = 11) boolean z4) {
        this.f29768a = str;
        this.f29769b = i;
        this.f29770c = i2;
        this.f29771d = z;
        this.f29772e = i3;
        this.f29773f = i4;
        this.f29774g = zzydArr;
        this.f29775h = z2;
        this.f29776i = z3;
        this.f29777j = z4;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21965a(parcel, 2, this.f29768a, false);
        SafeParcelWriter.m21957a(parcel, 3, this.f29769b);
        SafeParcelWriter.m21957a(parcel, 4, this.f29770c);
        SafeParcelWriter.m21968a(parcel, 5, this.f29771d);
        SafeParcelWriter.m21957a(parcel, 6, this.f29772e);
        SafeParcelWriter.m21957a(parcel, 7, this.f29773f);
        SafeParcelWriter.m21970a(parcel, 8, (T[]) this.f29774g, i, false);
        SafeParcelWriter.m21968a(parcel, 9, this.f29775h);
        SafeParcelWriter.m21968a(parcel, 10, this.f29776i);
        SafeParcelWriter.m21968a(parcel, 11, this.f29777j);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
