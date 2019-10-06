package com.flurry.sdk;

import com.flurry.sdk.C7607ud.C7608a;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.flurry.sdk.hd */
public class C7531hd implements C7608a {

    /* renamed from: a */
    private static final List<Class<?>> f14865a = new ArrayList();

    /* renamed from: b */
    private final String f14866b = C7531hd.class.getSimpleName();

    /* renamed from: c */
    private final Map<Class<?>, Object> f14867c = new LinkedHashMap();

    /* renamed from: d */
    long f14868d;

    /* renamed from: e */
    final Object f14869e = new Object();

    /* renamed from: f */
    private volatile int f14870f = C7532a.f14871a;

    /* renamed from: com.flurry.sdk.hd$a */
    public enum C7532a {
        ;
        

        /* renamed from: a */
        public static final int f14871a = 0;

        /* renamed from: b */
        public static final int f14872b = 0;

        /* renamed from: c */
        public static final int f14873c = 0;

        /* renamed from: a */
        public static int[] m16695a() {
            return (int[]) f14874d.clone();
        }

        static {
            f14871a = 1;
            f14872b = 2;
            f14873c = 3;
            f14874d = new int[]{f14871a, f14872b, f14873c};
        }
    }

    public C7531hd() {
        ArrayList<Class> arrayList;
        synchronized (f14865a) {
            arrayList = new ArrayList<>(f14865a);
        }
        for (Class cls : arrayList) {
            try {
                Object newInstance = cls.newInstance();
                synchronized (this.f14867c) {
                    this.f14867c.put(cls, newInstance);
                }
            } catch (Exception e) {
                String str = this.f14866b;
                StringBuilder sb = new StringBuilder("Module data ");
                sb.append(cls);
                sb.append(" is not available:");
                C7513ec.m16640a(5, str, sb.toString(), e);
            }
        }
        C7602td a = C7602td.m16825a();
        this.f14868d = ((Long) a.mo24023a("ContinueSessionMillis")).longValue();
        a.mo24024a("ContinueSessionMillis", (C7608a) this);
        String str2 = this.f14866b;
        StringBuilder sb2 = new StringBuilder("initSettings, ContinueSessionMillis = ");
        sb2.append(this.f14868d);
        C7513ec.m16639a(4, str2, sb2.toString());
    }

    /* renamed from: a */
    public static void m16688a(Class<?> cls) {
        synchronized (f14865a) {
            f14865a.add(cls);
        }
    }

    /* renamed from: b */
    public final Object mo23960b(Class<?> cls) {
        Object obj;
        synchronized (this.f14867c) {
            obj = this.f14867c.get(cls);
        }
        return obj;
    }

    /* renamed from: a */
    public boolean mo23956a() {
        return false;
    }

    /* renamed from: b */
    public long mo23957b() {
        return this.f14868d;
    }

    /* renamed from: a */
    public final void mo23959a(int i) {
        synchronized (this.f14869e) {
            this.f14870f = i;
        }
    }

    /* renamed from: c */
    public final int mo23961c() {
        int i;
        synchronized (this.f14869e) {
            i = this.f14870f;
        }
        return i;
    }

    /* renamed from: a */
    public final void mo23820a(String str, Object obj) {
        if (str.equals("ContinueSessionMillis")) {
            this.f14868d = ((Long) obj).longValue();
            String str2 = this.f14866b;
            StringBuilder sb = new StringBuilder("onSettingUpdate, ContinueSessionMillis = ");
            sb.append(this.f14868d);
            C7513ec.m16639a(4, str2, sb.toString());
            return;
        }
        C7513ec.m16639a(6, this.f14866b, "onSettingUpdate internal error!");
    }
}
