package p019d.p143b.p144a.p147c;

import java.util.Timer;
import java.util.TimerTask;

/* renamed from: d.b.a.c.pc */
public class C7197pc {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C7142c f13917a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Timer f13918b;

    /* renamed from: c */
    private long f13919c;

    /* renamed from: d */
    private long f13920d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final Runnable f13921e;

    /* renamed from: f */
    private long f13922f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final Object f13923g = new Object();

    private C7197pc(C7142c cVar, Runnable runnable) {
        this.f13917a = cVar;
        this.f13921e = runnable;
    }

    /* renamed from: a */
    public static C7197pc m15387a(long j, C7142c cVar, Runnable runnable) {
        if (j < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot create a scheduled timer. Invalid fire time passed in: ");
            sb.append(j);
            sb.append(".");
            throw new IllegalArgumentException(sb.toString());
        } else if (runnable != null) {
            C7197pc pcVar = new C7197pc(cVar, runnable);
            pcVar.f13919c = System.currentTimeMillis();
            pcVar.f13920d = j;
            pcVar.f13918b = new Timer();
            pcVar.f13918b.schedule(pcVar.m15392c(), j);
            return pcVar;
        } else {
            throw new IllegalArgumentException("Cannot create a scheduled timer. Runnable is null.");
        }
    }

    /* renamed from: c */
    private TimerTask m15392c() {
        return new C7201qc(this);
    }

    /* renamed from: a */
    public void mo23229a() {
        synchronized (this.f13923g) {
            if (this.f13918b != null) {
                try {
                    this.f13918b.cancel();
                    this.f13922f = System.currentTimeMillis() - this.f13919c;
                } catch (Throwable th) {
                    try {
                        if (this.f13917a != null) {
                            this.f13917a.mo23049b().mo22917b("Timer", "Encountered error while pausing timer", th);
                        }
                    } catch (Throwable th2) {
                        this.f13918b = null;
                        throw th2;
                    }
                }
                this.f13918b = null;
            }
        }
    }

    /* renamed from: b */
    public void mo23230b() {
        synchronized (this.f13923g) {
            if (this.f13922f > 0) {
                try {
                    this.f13920d -= this.f13922f;
                    if (this.f13920d < 0) {
                        this.f13920d = 0;
                    }
                    this.f13918b = new Timer();
                    this.f13918b.schedule(m15392c(), this.f13920d);
                    this.f13919c = System.currentTimeMillis();
                } catch (Throwable th) {
                    try {
                        if (this.f13917a != null) {
                            this.f13917a.mo23049b().mo22917b("Timer", "Encountered error while resuming timer", th);
                        }
                    } catch (Throwable th2) {
                        this.f13922f = 0;
                        throw th2;
                    }
                }
                this.f13922f = 0;
            }
        }
    }
}
