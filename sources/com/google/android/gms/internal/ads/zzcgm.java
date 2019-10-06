package com.google.android.gms.internal.ads;

public class zzcgm extends Exception {

    /* renamed from: a */
    private final int f26584a;

    /* renamed from: a */
    public static int m28419a(Throwable th) {
        if (th instanceof zzcgm) {
            return ((zzcgm) th).f26584a;
        }
        if (th instanceof zzayn) {
            return ((zzayn) th).mo30284a();
        }
        return 0;
    }

    public zzcgm(int i) {
        this.f26584a = i;
    }

    public zzcgm(String str, int i) {
        super(str);
        this.f26584a = i;
    }

    public zzcgm(String str, Throwable th, int i) {
        super(str, th);
        this.f26584a = 0;
    }

    /* renamed from: a */
    public final int mo31157a() {
        return this.f26584a;
    }
}
