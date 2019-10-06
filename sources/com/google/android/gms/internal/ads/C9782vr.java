package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.io.IOException;

@SuppressLint({"HandlerLeak"})
/* renamed from: com.google.android.gms.internal.ads.vr */
final class C9782vr extends Handler implements Runnable {

    /* renamed from: a */
    private final zzkc f23341a;

    /* renamed from: b */
    private final zzka f23342b;

    /* renamed from: c */
    private final int f23343c = 0;

    /* renamed from: d */
    private volatile Thread f23344d;

    /* renamed from: e */
    private final /* synthetic */ zzjz f23345e;

    public C9782vr(zzjz zzjz, Looper looper, zzkc zzkc, zzka zzka, int i) {
        this.f23345e = zzjz;
        super(looper);
        this.f23341a = zzkc;
        this.f23342b = zzka;
    }

    /* renamed from: a */
    public final void mo29238a() {
        this.f23341a.mo28837b();
        if (this.f23344d != null) {
            this.f23344d.interrupt();
        }
    }

    public final void run() {
        String str = "LoadTask";
        try {
            this.f23344d = Thread.currentThread();
            if (this.f23343c > 0) {
                Thread.sleep((long) this.f23343c);
            }
            if (!this.f23341a.mo28836a()) {
                this.f23341a.mo28838c();
            }
            sendEmptyMessage(0);
        } catch (IOException e) {
            obtainMessage(1, e).sendToTarget();
        } catch (InterruptedException e2) {
            zzkh.m30537b(this.f23341a.mo28836a());
            sendEmptyMessage(0);
        } catch (Exception e3) {
            Log.e(str, "Unexpected exception loading stream", e3);
            obtainMessage(1, new zzkd(e3)).sendToTarget();
        } catch (Error e4) {
            Log.e(str, "Unexpected error loading stream", e4);
            obtainMessage(2, e4).sendToTarget();
            throw e4;
        }
    }

    public final void handleMessage(Message message) {
        if (message.what != 2) {
            this.f23345e.f28732c = false;
            this.f23345e.f28731b = null;
            if (this.f23341a.mo28836a()) {
                this.f23342b.mo31864b(this.f23341a);
                return;
            }
            int i = message.what;
            if (i != 0) {
                if (i == 1) {
                    this.f23342b.mo31863a(this.f23341a, (IOException) message.obj);
                }
                return;
            }
            this.f23342b.mo31862a(this.f23341a);
            return;
        }
        throw ((Error) message.obj);
    }
}
