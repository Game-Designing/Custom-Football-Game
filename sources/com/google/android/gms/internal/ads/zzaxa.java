package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.ads.internal.zzk;

@zzard
public final class zzaxa extends zzdbh {
    public zzaxa(Looper looper) {
        super(looper);
    }

    public final void handleMessage(Message message) {
        try {
            super.handleMessage(message);
        } catch (Exception e) {
            zzk.zzlk().mo30168a((Throwable) e, "AdMobHandler.handleMessage");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo30197a(Message message) {
        try {
            super.mo30197a(message);
        } catch (Throwable th) {
            zzk.zzlg();
            zzaxi.m26112a(zzk.zzlk().mo30165a(), th);
            throw th;
        }
    }
}
