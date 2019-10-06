package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.Pm */
final class C9067Pm implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzda f21590a;

    C9067Pm(zzda zzda) {
        this.f21590a = zzda;
    }

    public final void run() {
        boolean z;
        if (this.f21590a.f27720e == null) {
            synchronized (zzda.f27716a) {
                if (this.f21590a.f27720e == null) {
                    boolean z2 = false;
                    try {
                        z = ((Boolean) zzyt.m31536e().mo29599a(zzacu.f24097gc)).booleanValue();
                    } catch (IllegalStateException e) {
                        z = false;
                    }
                    if (z) {
                        try {
                            zzda.f27717b = new zzwo(this.f21590a.f27719d.f28324b, "ADSHIELD", null);
                        } catch (Throwable th) {
                        }
                    }
                    z2 = z;
                    this.f21590a.f27720e = Boolean.valueOf(z2);
                    zzda.f27716a.open();
                }
            }
        }
    }
}
