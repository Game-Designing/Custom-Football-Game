package com.smaato.soma.p261j;

import android.media.MediaPlayer;

/* renamed from: com.smaato.soma.j.L */
/* compiled from: Video */
class C12444L implements Runnable {

    /* renamed from: a */
    final /* synthetic */ MediaPlayer f38846a;

    /* renamed from: b */
    final /* synthetic */ C12445M f38847b;

    C12444L(C12445M this$1, MediaPlayer mediaPlayer) {
        this.f38847b = this$1;
        this.f38846a = mediaPlayer;
    }

    public void run() {
        this.f38846a.release();
        Runtime.getRuntime().gc();
    }
}
