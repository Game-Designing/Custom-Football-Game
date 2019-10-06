package com.inmobi.commons.core.p221d;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.p001v7.widget.LinearLayoutManager;
import com.inmobi.commons.p217a.C10619a;
import java.util.HashMap;

/* renamed from: com.inmobi.commons.core.d.c */
/* compiled from: KeyValueStore */
public final class C10657c {

    /* renamed from: b */
    private static HashMap<String, C10657c> f32493b = new HashMap<>();

    /* renamed from: c */
    private static final Object f32494c = new Object();

    /* renamed from: a */
    public SharedPreferences f32495a;

    private C10657c(Context context, String str) {
        this.f32495a = context.getSharedPreferences(str, 0);
    }

    /* renamed from: a */
    public static String m34973a(String str) {
        StringBuilder sb = new StringBuilder("com.im.keyValueStore.");
        sb.append(str);
        return sb.toString();
    }

    /* renamed from: a */
    public static C10657c m34972a(Context context, String str) {
        String a = m34973a(str);
        C10657c cVar = (C10657c) f32493b.get(a);
        if (cVar != null) {
            return cVar;
        }
        synchronized (f32494c) {
            C10657c cVar2 = (C10657c) f32493b.get(a);
            if (cVar2 != null) {
                return cVar2;
            }
            C10657c cVar3 = new C10657c(context, a);
            f32493b.put(a, cVar3);
            return cVar3;
        }
    }

    /* renamed from: b */
    public static C10657c m34974b(String str) {
        return m34972a(C10619a.m34839b(), str);
    }

    /* renamed from: a */
    public final void mo34479a(String str, String str2) {
        Editor edit = this.f32495a.edit();
        edit.putString(str, str2);
        edit.apply();
    }

    /* renamed from: c */
    public final String mo34483c(String str) {
        return this.f32495a.getString(str, null);
    }

    /* renamed from: a */
    public final void mo34477a(String str, int i) {
        Editor edit = this.f32495a.edit();
        edit.putInt(str, i);
        edit.apply();
    }

    /* renamed from: d */
    public final int mo34484d(String str) {
        return this.f32495a.getInt(str, LinearLayoutManager.INVALID_OFFSET);
    }

    /* renamed from: a */
    public final void mo34478a(String str, long j) {
        Editor edit = this.f32495a.edit();
        edit.putLong(str, j);
        edit.apply();
    }

    /* renamed from: b */
    public final long mo34481b(String str, long j) {
        return this.f32495a.getLong(str, j);
    }

    /* renamed from: a */
    public final void mo34480a(String str, boolean z) {
        Editor edit = this.f32495a.edit();
        edit.putBoolean(str, z);
        edit.apply();
    }

    /* renamed from: b */
    public final boolean mo34482b(String str, boolean z) {
        return this.f32495a.getBoolean(str, z);
    }
}
