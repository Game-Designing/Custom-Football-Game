package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import org.json.JSONObject;

@zzard
public abstract class zzacj<T> {

    /* renamed from: a */
    private final int f23882a;

    /* renamed from: b */
    private final String f23883b;

    /* renamed from: c */
    private final T f23884c;

    private zzacj(int i, String str, T t) {
        this.f23882a = i;
        this.f23883b = str;
        this.f23884c = t;
        zzyt.m31535d().mo29595a(this);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract T mo29053a(SharedPreferences sharedPreferences);

    /* renamed from: a */
    public abstract T mo29054a(Bundle bundle);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract T mo29055a(JSONObject jSONObject);

    /* renamed from: a */
    public abstract void mo29056a(Editor editor, T t);

    /* renamed from: a */
    public final String mo29590a() {
        return this.f23883b;
    }

    /* renamed from: c */
    public final T mo29592c() {
        return this.f23884c;
    }

    /* renamed from: a */
    public static zzacj<Boolean> m24760a(int i, String str, Boolean bool) {
        return new C9550l(i, str, bool);
    }

    /* renamed from: a */
    public static zzacj<Integer> m24758a(int i, String str, int i2) {
        return new C9572m(i, str, Integer.valueOf(i2));
    }

    /* renamed from: a */
    public static zzacj<Long> m24759a(int i, String str, long j) {
        return new C9594n(i, str, Long.valueOf(j));
    }

    /* renamed from: a */
    public static zzacj<Float> m24757a(int i, String str, float f) {
        return new C9616o(i, str, Float.valueOf(f));
    }

    /* renamed from: a */
    public static zzacj<String> m24761a(int i, String str, String str2) {
        return new C9638p(i, str, str2);
    }

    /* renamed from: a */
    public static zzacj<String> m24756a(int i, String str) {
        zzacj<String> a = m24761a(i, str, (String) null);
        zzyt.m31535d().mo29597b(a);
        return a;
    }

    /* renamed from: b */
    public static zzacj<String> m24762b(int i, String str) {
        zzacj<String> a = m24761a(i, str, (String) null);
        zzyt.m31535d().mo29598c(a);
        return a;
    }

    /* renamed from: b */
    public final int mo29591b() {
        return this.f23882a;
    }

    /* synthetic */ zzacj(int i, String str, Object obj, C9550l lVar) {
        this(i, str, obj);
    }
}
