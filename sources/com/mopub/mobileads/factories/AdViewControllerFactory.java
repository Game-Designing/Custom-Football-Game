package com.mopub.mobileads.factories;

import android.content.Context;
import com.mopub.mobileads.AdViewController;
import com.mopub.mobileads.MoPubView;

public class AdViewControllerFactory {

    /* renamed from: a */
    protected static AdViewControllerFactory f35258a = new AdViewControllerFactory();

    @Deprecated
    public static void setInstance(AdViewControllerFactory factory) {
        f35258a = factory;
    }

    public static AdViewController create(Context context, MoPubView moPubView) {
        return f35258a.mo37460a(context, moPubView);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public AdViewController mo37460a(Context context, MoPubView moPubView) {
        return new AdViewController(context, moPubView);
    }
}
