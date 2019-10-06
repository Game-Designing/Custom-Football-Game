package com.flurry.sdk;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.flurry.sdk.Hb */
public class C7389Hb {

    /* renamed from: a */
    private static final String f14479a = C7389Hb.class.getSimpleName();

    /* renamed from: b */
    private static final HashMap<String, Map<String, String>> f14480b = new HashMap<>();

    /* renamed from: c */
    private static C7389Hb f14481c;

    /* renamed from: a */
    public static synchronized C7389Hb m16355a() {
        C7389Hb hb;
        synchronized (C7389Hb.class) {
            if (f14481c == null) {
                f14481c = new C7389Hb();
            }
            hb = f14481c;
        }
        return hb;
    }

    /* renamed from: b */
    public final synchronized HashMap<String, Map<String, String>> mo23826b() {
        HashMap<String, Map<String, String>> hashMap;
        synchronized (f14480b) {
            hashMap = new HashMap<>(f14480b);
        }
        return hashMap;
    }
}
