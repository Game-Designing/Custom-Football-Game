package com.flurry.sdk;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

/* renamed from: com.flurry.sdk.Bb */
class C7357Bb extends LinkedHashMap<String, String> {

    /* renamed from: a */
    final /* synthetic */ C7374Eb f14377a;

    C7357Bb(C7374Eb eb) {
        this.f14377a = eb;
    }

    /* access modifiers changed from: protected */
    public final boolean removeEldestEntry(Entry<String, String> entry) {
        return size() > 10;
    }
}
