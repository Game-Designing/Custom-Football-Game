package com.google.android.gms.internal.ads;

import java.util.HashSet;
import java.util.concurrent.Executor;
import org.json.JSONObject;

public final class zzcxf implements zzdti<zzcvb<JSONObject>> {
    /* renamed from: a */
    public static zzcvb<JSONObject> m28942a(Object obj, zzcvu zzcvu, zzcwn zzcwn, zzdte<zzcvo> zzdte, zzdte<zzcvy> zzdte2, zzdte<zzcwc> zzdte3, zzdte<zzcwj> zzdte4, zzdte<zzcwq> zzdte5, zzdte<zzcwu> zzdte6, zzdte<zzcxh> zzdte7, Executor executor) {
        C9343bm bmVar = (C9343bm) obj;
        HashSet hashSet = new HashSet();
        hashSet.add(bmVar);
        hashSet.add(zzcvu);
        hashSet.add(zzcwn);
        if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f24195we)).booleanValue()) {
            hashSet.add((zzcva) zzdte.get());
        }
        if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f24201xe)).booleanValue()) {
            hashSet.add((zzcva) zzdte2.get());
        }
        if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f24207ye)).booleanValue()) {
            hashSet.add((zzcva) zzdte3.get());
        }
        if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f24213ze)).booleanValue()) {
            hashSet.add((zzcva) zzdte4.get());
        }
        if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f23913Ce)).booleanValue()) {
            hashSet.add((zzcva) zzdte5.get());
        }
        if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f23925Ee)).booleanValue()) {
            hashSet.add((zzcva) zzdte6.get());
        }
        if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f23931Fe)).booleanValue()) {
            hashSet.add((zzcva) zzdte7.get());
        }
        zzcvb<JSONObject> zzcvb = new zzcvb<>(executor, hashSet);
        zzdto.m30114a(zzcvb, "Cannot return null from a non-@Nullable @Provides method");
        return zzcvb;
    }

    public final /* synthetic */ Object get() {
        throw new NoSuchMethodError();
    }
}
