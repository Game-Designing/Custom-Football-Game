package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.ArrayList;
import java.util.WeakHashMap;

@zzard
public final class zztz {

    /* renamed from: a */
    private final Object f29426a = new Object();

    /* renamed from: b */
    private final WeakHashMap<Object, Object> f29427b = new WeakHashMap<>();

    /* renamed from: c */
    private final ArrayList<Object> f29428c = new ArrayList<>();

    /* renamed from: d */
    private final Context f29429d;

    /* renamed from: e */
    private final zzbai f29430e;

    /* renamed from: f */
    private final zzakh f29431f;

    public zztz(Context context, zzbai zzbai) {
        this.f29429d = context.getApplicationContext();
        this.f29430e = zzbai;
        this.f29431f = new zzakh(context.getApplicationContext(), zzbai, (String) zzyt.m31536e().mo29599a(zzacu.f24076d));
    }
}
