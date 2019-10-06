package com.smaato.soma.p239c.p241b;

import android.os.Bundle;
import android.os.Message;
import com.smaato.soma.C12398ha;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;

/* renamed from: com.smaato.soma.c.b.i */
/* compiled from: MraidBridge */
class C12169i extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ boolean f38157a;

    /* renamed from: b */
    final /* synthetic */ String f38158b;

    /* renamed from: c */
    final /* synthetic */ C12173m f38159c;

    C12169i(C12173m this$0, boolean z, String str) {
        this.f38159c = this$0;
        this.f38157a = z;
        this.f38158b = str;
    }

    public Void process() {
        StringBuilder sb = new StringBuilder();
        sb.append("setOrientationProperties: allowOrientationChange = ");
        sb.append(this.f38157a);
        sb.append(" forceOrientation = ");
        sb.append(this.f38158b);
        C12146d.m39965a(new C12147e("Mraid_Bridge", sb.toString(), 1, C12143a.INFO));
        Message msg = this.f38159c.f38167b.obtainMessage(106);
        Bundle resizeBundle = new Bundle();
        resizeBundle.putBoolean("allowOrientationChange", this.f38157a);
        resizeBundle.putString("forceOrientation", this.f38158b);
        msg.setData(resizeBundle);
        this.f38159c.f38167b.sendMessage(msg);
        return null;
    }
}
