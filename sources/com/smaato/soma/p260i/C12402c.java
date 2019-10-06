package com.smaato.soma.p260i;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.smaato.soma.C12056Ja;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p239c.p252i.C12278d;

/* renamed from: com.smaato.soma.i.c */
/* compiled from: CloseButtonView */
public class C12402c extends ImageView {
    public C12402c(Context mContext) {
        super(mContext);
        new C12400a(this).execute();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m40784a() {
        C12146d.m39966a((Object) new C12401b(this));
        setImageResource(C12056Ja.ic_browser_close_40dp);
        int wh = C12278d.m40415a().mo39670a(30);
        LayoutParams layoutParams = new LayoutParams(wh, wh);
        layoutParams.addRule(11);
        setLayoutParams(layoutParams);
    }
}
