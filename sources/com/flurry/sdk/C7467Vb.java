package com.flurry.sdk;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.util.Comparator;

/* renamed from: com.flurry.sdk.Vb */
public class C7467Vb implements Comparator<Runnable> {

    /* renamed from: a */
    private static final String f14711a = C7467Vb.class.getSimpleName();

    public /* synthetic */ int compare(Object obj, Object obj2) {
        Runnable runnable = (Runnable) obj2;
        int a = m16537a((Runnable) obj);
        int a2 = m16537a(runnable);
        if (a < a2) {
            return -1;
        }
        if (a > a2) {
            return 1;
        }
        return 0;
    }

    /* renamed from: a */
    private static int m16537a(Runnable runnable) {
        if (runnable == null) {
            return MoPubClientPositioning.NO_REPEAT;
        }
        if (runnable instanceof C7472Wb) {
            C7376Ed ed = (C7376Ed) ((C7472Wb) runnable).mo23915a();
            if (ed != null) {
                return ed.f14426d;
            }
            return MoPubClientPositioning.NO_REPEAT;
        } else if (runnable instanceof C7376Ed) {
            return ((C7376Ed) runnable).f14426d;
        } else {
            String str = f14711a;
            StringBuilder sb = new StringBuilder("Unknown runnable class: ");
            sb.append(runnable.getClass().getName());
            C7513ec.m16639a(6, str, sb.toString());
            return MoPubClientPositioning.NO_REPEAT;
        }
    }
}
