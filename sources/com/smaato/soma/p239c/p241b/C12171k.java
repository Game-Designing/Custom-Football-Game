package com.smaato.soma.p239c.p241b;

import android.os.Bundle;
import android.os.Message;
import com.smaato.soma.C12398ha;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;

/* renamed from: com.smaato.soma.c.b.k */
/* compiled from: MraidBridge */
class C12171k extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ boolean f38162a;

    /* renamed from: b */
    final /* synthetic */ C12173m f38163b;

    C12171k(C12173m this$0, boolean z) {
        this.f38163b = this$0;
        this.f38162a = z;
    }

    public Void process() {
        StringBuilder sb = new StringBuilder();
        sb.append("useCustomClose = ");
        sb.append(this.f38162a);
        C12146d.m39965a(new C12147e("Mraid_Bridge", sb.toString(), 1, C12143a.INFO));
        Message msg = this.f38163b.f38167b.obtainMessage(107);
        Bundle resizeBundle = new Bundle();
        resizeBundle.putBoolean("useCustomClose", this.f38162a);
        msg.setData(resizeBundle);
        this.f38163b.f38167b.sendMessage(msg);
        return null;
    }
}
