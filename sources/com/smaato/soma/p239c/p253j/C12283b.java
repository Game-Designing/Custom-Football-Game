package com.smaato.soma.p239c.p253j;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.smaato.soma.C12056Ja;
import com.smaato.soma.p239c.p252i.C12278d;

/* renamed from: com.smaato.soma.c.j.b */
/* compiled from: SkipAdButtonView */
public class C12283b extends ImageView {
    public C12283b(Context mContext, boolean isRewardedVideo) {
        super(mContext);
        m40444a(isRewardedVideo);
    }

    /* renamed from: a */
    private void m40444a(boolean isRewardedVideo) {
        int height;
        int width;
        if (isRewardedVideo) {
            setImageResource(C12056Ja.ic_browser_close_40dp);
            width = C12278d.m40415a().mo39670a(40);
            height = width;
        } else {
            setImageResource(C12056Ja.skip_ad);
            width = C12278d.m40415a().mo39670a(150);
            height = C12278d.m40415a().mo39670a(50);
        }
        LayoutParams layoutParams = new LayoutParams(width, height);
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        setLayoutParams(layoutParams);
    }
}
