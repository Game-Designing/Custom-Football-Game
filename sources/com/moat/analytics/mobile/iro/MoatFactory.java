package com.moat.analytics.mobile.iro;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import java.util.Map;

public abstract class MoatFactory {
    public abstract <T> T createCustomTracker(C11037m<T> mVar);

    public abstract NativeDisplayTracker createNativeDisplayTracker(View view, Map<String, String> map);

    public abstract NativeVideoTracker createNativeVideoTracker(String str);

    public abstract WebAdTracker createWebAdTracker(ViewGroup viewGroup);

    public abstract WebAdTracker createWebAdTracker(WebView webView);

    public static MoatFactory create() {
        try {
            return new C11038n();
        } catch (Exception e) {
            C11043o.m36351(e);
            return new com.moat.analytics.mobile.iro.NoOp.MoatFactory();
        }
    }
}
