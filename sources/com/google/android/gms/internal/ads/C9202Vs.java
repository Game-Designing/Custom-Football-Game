package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.internal.ads.zzsh;
import java.io.IOException;

@SuppressLint({"HandlerLeak"})
/* renamed from: com.google.android.gms.internal.ads.Vs */
final class C9202Vs<T extends zzsh> extends Handler implements Runnable {

    /* renamed from: a */
    private final T f21866a;

    /* renamed from: b */
    private final zzsf<T> f21867b;

    /* renamed from: c */
    public final int f21868c;

    /* renamed from: d */
    private final long f21869d;

    /* renamed from: e */
    private IOException f21870e;

    /* renamed from: f */
    private int f21871f;

    /* renamed from: g */
    private volatile Thread f21872g;

    /* renamed from: h */
    private volatile boolean f21873h;

    /* renamed from: i */
    private final /* synthetic */ zzse f21874i;

    public C9202Vs(zzse zzse, Looper looper, T t, zzsf<T> zzsf, int i, long j) {
        this.f21874i = zzse;
        super(looper);
        this.f21866a = t;
        this.f21867b = zzsf;
        this.f21868c = i;
        this.f21869d = j;
    }

    /* renamed from: a */
    public final void mo28669a(int i) throws IOException {
        IOException iOException = this.f21870e;
        if (iOException != null && this.f21871f > i) {
            throw iOException;
        }
    }

    /* renamed from: a */
    public final void mo28670a(long j) {
        zzsk.m31082b(this.f21874i.f29308b == null);
        this.f21874i.f29308b = this;
        if (j > 0) {
            sendEmptyMessageDelayed(0, j);
        } else {
            m23158a();
        }
    }

    /* renamed from: a */
    public final void mo28671a(boolean z) {
        this.f21873h = z;
        this.f21870e = null;
        if (hasMessages(0)) {
            removeMessages(0);
            if (!z) {
                sendEmptyMessage(1);
            }
        } else {
            this.f21866a.mo28447b();
            if (this.f21872g != null) {
                this.f21872g.interrupt();
            }
        }
        if (z) {
            m23159b();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.f21867b.mo28292a(this.f21866a, elapsedRealtime, elapsedRealtime - this.f21869d, true);
        }
    }

    public final void run() {
        String str = "LoadTask";
        try {
            this.f21872g = Thread.currentThread();
            if (!this.f21866a.mo28446a()) {
                String str2 = "load:";
                String valueOf = String.valueOf(this.f21866a.getClass().getSimpleName());
                zzsx.m31142a(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                this.f21866a.mo28448c();
                zzsx.m31141a();
            }
            if (!this.f21873h) {
                sendEmptyMessage(2);
            }
        } catch (IOException e) {
            if (!this.f21873h) {
                obtainMessage(3, e).sendToTarget();
            }
        } catch (InterruptedException e2) {
            zzsk.m31082b(this.f21866a.mo28446a());
            if (!this.f21873h) {
                sendEmptyMessage(2);
            }
        } catch (Exception e3) {
            Log.e(str, "Unexpected exception loading stream", e3);
            if (!this.f21873h) {
                obtainMessage(3, new zzsi(e3)).sendToTarget();
            }
        } catch (OutOfMemoryError e4) {
            Log.e(str, "OutOfMemory error loading stream", e4);
            if (!this.f21873h) {
                obtainMessage(3, new zzsi(e4)).sendToTarget();
            }
        } catch (Error e5) {
            Log.e(str, "Unexpected error loading stream", e5);
            if (!this.f21873h) {
                obtainMessage(4, e5).sendToTarget();
            }
            throw e5;
        } catch (Throwable th) {
            zzsx.m31141a();
            throw th;
        }
    }

    public final void handleMessage(Message message) {
        if (!this.f21873h) {
            int i = message.what;
            if (i == 0) {
                m23158a();
            } else if (i != 4) {
                m23159b();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long j = elapsedRealtime - this.f21869d;
                if (this.f21866a.mo28446a()) {
                    this.f21867b.mo28292a(this.f21866a, elapsedRealtime, j, false);
                    return;
                }
                int i2 = message.what;
                if (i2 == 1) {
                    this.f21867b.mo28292a(this.f21866a, elapsedRealtime, j, false);
                } else if (i2 != 2) {
                    if (i2 == 3) {
                        this.f21870e = (IOException) message.obj;
                        int a = this.f21867b.mo28283a(this.f21866a, elapsedRealtime, j, this.f21870e);
                        if (a == 3) {
                            this.f21874i.f29309c = this.f21870e;
                        } else if (a != 2) {
                            this.f21871f = a == 1 ? 1 : this.f21871f + 1;
                            mo28670a((long) Math.min((this.f21871f - 1) * 1000, 5000));
                        }
                    }
                } else {
                    this.f21867b.mo28291a(this.f21866a, elapsedRealtime, j);
                }
            } else {
                throw ((Error) message.obj);
            }
        }
    }

    /* renamed from: a */
    private final void m23158a() {
        this.f21870e = null;
        this.f21874i.f29307a.execute(this.f21874i.f29308b);
    }

    /* renamed from: b */
    private final void m23159b() {
        this.f21874i.f29308b = null;
    }
}
