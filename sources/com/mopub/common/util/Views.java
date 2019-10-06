package com.mopub.common.util;

import android.app.Activity;
import android.content.Context;
import android.support.p000v4.view.C0646w;
import android.view.View;
import android.view.ViewGroup;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;

public class Views {
    public static void removeFromParent(View view) {
        if (!(view == null || view.getParent() == null || !(view.getParent() instanceof ViewGroup))) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    public static View getTopmostView(Context context, View view) {
        View rootViewFromActivity = m37198a(context);
        return rootViewFromActivity != null ? rootViewFromActivity : m37199a(view);
    }

    /* renamed from: a */
    private static View m37198a(Context context) {
        if (!(context instanceof Activity)) {
            return null;
        }
        return ((Activity) context).getWindow().getDecorView().findViewById(16908290);
    }

    /* renamed from: a */
    private static View m37199a(View view) {
        if (view == null) {
            return null;
        }
        if (!C0646w.m2986t(view)) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "Attempting to call View#getRootView() on an unattached View.");
        }
        View rootView = view.getRootView();
        if (rootView == null) {
            return null;
        }
        View rootContentView = rootView.findViewById(16908290);
        return rootContentView != null ? rootContentView : rootView;
    }
}
