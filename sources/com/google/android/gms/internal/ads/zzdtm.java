package com.google.android.gms.internal.ads;

import java.util.LinkedHashMap;
import p005cm.aptoide.p006pt.database.realm.Notification;

public final class zzdtm<K, V> {

    /* renamed from: a */
    private final LinkedHashMap<K, zzdtu<V>> f28307a;

    private zzdtm(int i) {
        this.f28307a = zzdtf.m30104c(i);
    }

    /* renamed from: a */
    public final zzdtm<K, V> mo31700a(K k, zzdtu<V> zzdtu) {
        LinkedHashMap<K, zzdtu<V>> linkedHashMap = this.f28307a;
        zzdto.m30114a(k, Notification.KEY);
        zzdto.m30114a(zzdtu, "provider");
        linkedHashMap.put(k, zzdtu);
        return this;
    }

    /* renamed from: a */
    public final zzdtk<K, V> mo31699a() {
        return new zzdtk<>(this.f28307a);
    }
}
