package com.google.android.gms.internal.ads;

import android.os.Build.VERSION;
import android.os.ConditionVariable;
import com.google.android.gms.internal.ads.zzbi.zza;
import com.google.android.gms.internal.ads.zzbi.zza.C15003zza;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class zzda {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final ConditionVariable f27716a = new ConditionVariable();

    /* renamed from: b */
    protected static volatile zzwo f27717b = null;

    /* renamed from: c */
    private static volatile Random f27718c = null;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public zzdy f27719d;

    /* renamed from: e */
    protected volatile Boolean f27720e;

    public zzda(zzdy zzdy) {
        this.f27719d = zzdy;
        zzdy.mo31716d().execute(new C9067Pm(this));
    }

    /* renamed from: a */
    public final void mo31337a(int i, int i2, long j) {
        mo31338a(i, i2, j, null);
    }

    /* renamed from: a */
    public final void mo31338a(int i, int i2, long j, Exception exc) {
        try {
            f27716a.block();
            if (this.f27720e.booleanValue() && f27717b != null) {
                C15003zza a = zza.m26977l().mo30639a(this.f27719d.f28324b.getPackageName()).mo30638a(j);
                if (exc != null) {
                    StringWriter stringWriter = new StringWriter();
                    zzdmb.m29636a((Throwable) exc, new PrintWriter(stringWriter));
                    a.mo30640b(stringWriter.toString()).mo30641c(exc.getClass().getName());
                }
                zzws a2 = f27717b.mo32331a(((zza) ((zzdob) a.mo31612g())).toByteArray());
                a2.mo32334b(i);
                if (i2 != -1) {
                    a2.mo32332a(i2);
                }
                a2.mo32333a();
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    public static int m29063a() {
        try {
            if (VERSION.SDK_INT >= 21) {
                return ThreadLocalRandom.current().nextInt();
            }
            return m29066c().nextInt();
        } catch (RuntimeException e) {
            return m29066c().nextInt();
        }
    }

    /* renamed from: c */
    private static Random m29066c() {
        if (f27718c == null) {
            synchronized (zzda.class) {
                if (f27718c == null) {
                    f27718c = new Random();
                }
            }
        }
        return f27718c;
    }
}
