package com.smaato.soma.p236a.p237a;

import android.os.Build.VERSION;

/* renamed from: com.smaato.soma.a.a.a */
/* compiled from: BannerHtmlUtils */
public class C12110a {
    /* renamed from: a */
    public static String m39907a() {
        if (VERSION.SDK_INT < 19) {
            return "display: -webkit-box;-webkit-box-align: center;-webkit-box-pack: center;";
        }
        return "display: flex;align-items: center;justify-content: center;";
    }
}
