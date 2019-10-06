package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class zzbzt {

    /* renamed from: a */
    private final Context f26219a;

    /* renamed from: b */
    private final zzcdn f26220b;

    /* renamed from: c */
    private final zzccj f26221c;

    /* renamed from: d */
    private final zzbmy f26222d;

    /* renamed from: e */
    private final zzbzb f26223e;

    public zzbzt(Context context, zzcdn zzcdn, zzccj zzccj, zzbmy zzbmy, zzbzb zzbzb) {
        this.f26219a = context;
        this.f26220b = zzcdn;
        this.f26221c = zzccj;
        this.f26222d = zzbmy;
        this.f26223e = zzbzb;
    }

    /* renamed from: a */
    public final View mo31077a() throws zzbhj {
        zzbgz a = this.f26220b.mo31124a(zzyd.m31511a(this.f26219a));
        a.getView().setVisibility(8);
        a.mo28726a("/sendMessageToSdk", (zzaho<? super zzbgz>) new C9814xh<Object>(this));
        a.mo28726a("/adMuted", (zzaho<? super zzbgz>) new C9835yh<Object>(this));
        this.f26221c.mo31116a(new WeakReference<>(a), "/loadHtml", (zzaho<T>) new C9856zh<T>(this));
        this.f26221c.mo31116a(new WeakReference<>(a), "/showOverlay", (zzaho<T>) new C8747Ah<T>(this));
        this.f26221c.mo31116a(new WeakReference<>(a), "/hideOverlay", (zzaho<T>) new C8768Bh<T>(this));
        return a.getView();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ void mo31078a(zzbgz zzbgz, Map map) {
        zzbgz.getView().setVisibility(8);
        this.f26222d.mo30748f(false);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final /* synthetic */ void mo31080b(zzbgz zzbgz, Map map) {
        zzbgz.getView().setVisibility(0);
        this.f26222d.mo30748f(true);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ void mo31079a(Map map, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("messageType", "htmlLoaded");
        String str = "id";
        hashMap.put(str, (String) map.get(str));
        this.f26221c.mo31115a("sendMessageToNativeJs", (Map<String, ?>) hashMap);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public final /* synthetic */ void mo31081c(zzbgz zzbgz, Map map) {
        this.f26223e.mo30956c();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public final /* synthetic */ void mo31082d(zzbgz zzbgz, Map map) {
        this.f26221c.mo31115a("sendMessageToNativeJs", map);
    }
}
