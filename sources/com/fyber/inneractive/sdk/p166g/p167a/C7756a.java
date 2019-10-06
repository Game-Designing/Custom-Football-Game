package com.fyber.inneractive.sdk.p166g.p167a;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.fyber.inneractive.sdk.g.a.a */
public final class C7756a {

    /* renamed from: a */
    File f15552a;

    /* renamed from: b */
    String f15553b;

    /* renamed from: c */
    boolean f15554c;

    /* renamed from: d */
    String f15555d;

    /* renamed from: e */
    public Object f15556e = new Object();

    /* renamed from: f */
    Map<String, String> f15557f = new HashMap();

    /* renamed from: g */
    final String f15558g;

    /* renamed from: h */
    volatile boolean f15559h = false;

    private C7756a(String str, String str2, File file, boolean z, String str3) {
        this.f15552a = file;
        this.f15553b = str2;
        this.f15554c = z;
        this.f15555d = str3;
        this.f15558g = str;
    }

    /* renamed from: a */
    public static C7756a m17218a(String str, String str2, File file, boolean z, String str3) {
        C7756a aVar = new C7756a(str, str2, file, z, str3);
        return aVar;
    }

    /* renamed from: a */
    public final File mo24359a() {
        File file;
        synchronized (this.f15556e) {
            file = this.f15552a;
        }
        return file;
    }

    /* renamed from: a */
    public final void mo24361a(Map<String, String> map) {
        this.f15557f.putAll(map);
    }

    /* renamed from: a */
    public final String mo24360a(String str) {
        return (String) this.f15557f.get(str);
    }
}
