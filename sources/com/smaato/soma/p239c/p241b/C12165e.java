package com.smaato.soma.p239c.p241b;

import android.os.Bundle;
import android.os.Message;
import com.smaato.soma.C12398ha;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import com.smaato.soma.p255d.C12316i;

/* renamed from: com.smaato.soma.c.b.e */
/* compiled from: MraidBridge */
class C12165e extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ String f38143a;

    /* renamed from: b */
    final /* synthetic */ boolean f38144b;

    /* renamed from: c */
    final /* synthetic */ C12173m f38145c;

    C12165e(C12173m this$0, String str, boolean z) {
        this.f38145c = this$0;
        this.f38143a = str;
        this.f38144b = z;
    }

    public Void process() throws Exception {
        if (!this.f38145c.mo39410a(this.f38143a)) {
            this.f38145c.m40008a(C12316i.AUTO_EXPAND, this.f38143a, "expand");
        } else {
            Message msg = this.f38145c.f38167b.obtainMessage(101);
            Bundle resizeBundle = new Bundle();
            resizeBundle.putBoolean("useCustomClose", this.f38144b);
            msg.setData(resizeBundle);
            this.f38145c.f38167b.sendMessage(msg);
            StringBuilder sb = new StringBuilder();
            sb.append("expanding to match parent useCustomClose");
            sb.append(this.f38144b);
            C12146d.m39965a(new C12147e("Mraid_Bridge", sb.toString(), 1, C12143a.INFO));
        }
        return null;
    }
}
