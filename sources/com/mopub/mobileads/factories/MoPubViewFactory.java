package com.mopub.mobileads.factories;

import android.content.Context;
import com.mopub.common.VisibleForTesting;
import com.mopub.mobileads.MoPubView;

public class MoPubViewFactory {

    /* renamed from: a */
    protected static MoPubViewFactory f35265a = new MoPubViewFactory();

    @Deprecated
    @VisibleForTesting
    public static void setInstance(MoPubViewFactory factory) {
        f35265a = factory;
    }

    public static MoPubView create(Context context) {
        return f35265a.mo37467a(context);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public MoPubView mo37467a(Context context) {
        return new MoPubView(context);
    }
}
