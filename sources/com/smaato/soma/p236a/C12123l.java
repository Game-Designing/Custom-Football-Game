package com.smaato.soma.p236a;

import android.app.AlertDialog;
import com.smaato.soma.p239c.p240a.C12152a;

/* renamed from: com.smaato.soma.a.l */
/* compiled from: AbstractBannerPackage */
class C12123l implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AlertDialog f38013a;

    /* renamed from: b */
    final /* synthetic */ C12152a f38014b;

    /* renamed from: c */
    final /* synthetic */ C12124m f38015c;

    C12123l(C12124m this$2, AlertDialog alertDialog, C12152a aVar) {
        this.f38015c = this$2;
        this.f38013a = alertDialog;
        this.f38014b = aVar;
    }

    public void run() {
        new C12122k(this).execute();
    }
}
