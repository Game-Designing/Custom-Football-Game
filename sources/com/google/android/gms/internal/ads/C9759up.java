package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob.zze;

/* renamed from: com.google.android.gms.internal.ads.up */
final class C9759up implements C9522jp {

    /* renamed from: a */
    private final zzdpk f23231a;

    /* renamed from: b */
    private final String f23232b;

    /* renamed from: c */
    private final Object[] f23233c;

    /* renamed from: d */
    private final int f23234d;

    C9759up(zzdpk zzdpk, String str, Object[] objArr) {
        this.f23231a = zzdpk;
        this.f23232b = str;
        this.f23233c = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.f23234d = charAt;
            return;
        }
        char c = charAt & 8191;
        int i = 13;
        int i2 = 1;
        while (true) {
            int i3 = i2 + 1;
            char charAt2 = str.charAt(i2);
            if (charAt2 >= 55296) {
                c |= (charAt2 & 8191) << i;
                i += 13;
                i2 = i3;
            } else {
                this.f23234d = c | (charAt2 << i);
                return;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public final String mo29214d() {
        return this.f23232b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public final Object[] mo29215e() {
        return this.f23233c;
    }

    /* renamed from: b */
    public final zzdpk mo28407b() {
        return this.f23231a;
    }

    /* renamed from: c */
    public final int mo28408c() {
        return (this.f23234d & 1) == 1 ? zze.f28078i : zze.f28079j;
    }

    /* renamed from: a */
    public final boolean mo28406a() {
        return (this.f23234d & 2) == 2;
    }
}
