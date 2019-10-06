package com.smaato.soma.p239c.p241b;

import android.os.Bundle;
import android.os.Message;
import com.smaato.soma.C12398ha;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import com.smaato.soma.p255d.C12316i;

/* renamed from: com.smaato.soma.c.b.h */
/* compiled from: MraidBridge */
class C12168h extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ int f38150a;

    /* renamed from: b */
    final /* synthetic */ int f38151b;

    /* renamed from: c */
    final /* synthetic */ int f38152c;

    /* renamed from: d */
    final /* synthetic */ int f38153d;

    /* renamed from: e */
    final /* synthetic */ String f38154e;

    /* renamed from: f */
    final /* synthetic */ boolean f38155f;

    /* renamed from: g */
    final /* synthetic */ C12173m f38156g;

    C12168h(C12173m this$0, int i, int i2, int i3, int i4, String str, boolean z) {
        this.f38156g = this$0;
        this.f38150a = i;
        this.f38151b = i2;
        this.f38152c = i3;
        this.f38153d = i4;
        this.f38154e = str;
        this.f38155f = z;
    }

    public Void process() throws Exception {
        String str = "resize";
        String str2 = "Mraid_Bridge";
        if (!this.f38156g.mo39410a(str)) {
            this.f38156g.m40008a(C12316i.AUTO_RESIZE, (String) null, str);
            C12146d.m39965a(new C12147e(str2, "Resizing ad failed. User click not detected", 1, C12143a.WARNING));
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("resize : width=");
            sb.append(this.f38150a);
            sb.append(" height=");
            sb.append(this.f38151b);
            C12146d.m39965a(new C12147e(str2, sb.toString(), 1, C12143a.INFO));
            Message msg = this.f38156g.f38167b.obtainMessage(103);
            Bundle resizeBundle = new Bundle();
            resizeBundle.putInt("width", this.f38150a);
            resizeBundle.putInt("height", this.f38151b);
            resizeBundle.putInt("offsetX", this.f38152c);
            resizeBundle.putInt("offsetY", this.f38153d);
            resizeBundle.putString("customClosePosition", this.f38154e);
            resizeBundle.putBoolean("allowOffscreen", this.f38155f);
            msg.setData(resizeBundle);
            this.f38156g.f38167b.sendMessage(msg);
        }
        return null;
    }
}
