package com.mopub.mobileads.factories;

import android.content.Context;
import com.mopub.common.AdReport;
import com.mopub.common.VisibleForTesting;
import com.mopub.mraid.MraidController;
import com.mopub.mraid.PlacementType;

public class MraidControllerFactory {

    /* renamed from: a */
    protected static MraidControllerFactory f35266a = new MraidControllerFactory();

    @VisibleForTesting
    public static void setInstance(MraidControllerFactory factory) {
        f35266a = factory;
    }

    public static MraidController create(Context context, AdReport adReport, PlacementType placementType) {
        return f35266a.mo37468a(context, adReport, placementType);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public MraidController mo37468a(Context context, AdReport adReport, PlacementType placementType) {
        return new MraidController(context, adReport, placementType);
    }
}
