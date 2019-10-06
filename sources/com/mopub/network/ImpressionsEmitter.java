package com.mopub.network;

import com.mopub.common.Preconditions;
import java.util.HashSet;
import java.util.Set;

public class ImpressionsEmitter {

    /* renamed from: a */
    private static final HashSet<ImpressionListener> f36351a = new HashSet<>();

    public static void addListener(ImpressionListener listener) {
        Preconditions.checkNotNull(listener);
        synchronized (ImpressionsEmitter.class) {
            f36351a.add(listener);
        }
    }

    public static void removeListener(ImpressionListener listener) {
        Preconditions.checkNotNull(listener);
        synchronized (ImpressionsEmitter.class) {
            f36351a.remove(listener);
        }
    }

    /* renamed from: a */
    static void m38536a(String adUnitId, ImpressionData impressionData) {
        Preconditions.checkNotNull(adUnitId);
        for (ImpressionListener listener : m38535a()) {
            listener.onImpression(adUnitId, impressionData);
        }
    }

    /* renamed from: a */
    private static Set<ImpressionListener> m38535a() {
        HashSet hashSet;
        synchronized (ImpressionsEmitter.class) {
            hashSet = new HashSet(f36351a);
        }
        return hashSet;
    }
}
