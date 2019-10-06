package com.moat.analytics.mobile.vng;

import com.moat.analytics.mobile.vng.p233a.p234a.C11146a;
import com.moat.analytics.mobile.vng.p233a.p235b.C11147a;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/* renamed from: com.moat.analytics.mobile.vng.x */
class C11208x<T> implements InvocationHandler {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final Object[] f34185a = new Object[0];

    /* renamed from: b */
    private final C11210a<T> f34186b;

    /* renamed from: c */
    private final Class<T> f34187c;

    /* renamed from: d */
    private final LinkedList<C11211b> f34188d = new LinkedList<>();

    /* renamed from: e */
    private boolean f34189e;

    /* renamed from: f */
    private T f34190f;

    /* renamed from: com.moat.analytics.mobile.vng.x$a */
    interface C11210a<T> {
        /* renamed from: a */
        C11147a<T> mo36294a();
    }

    /* renamed from: com.moat.analytics.mobile.vng.x$b */
    private class C11211b {
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final WeakReference[] f34193b;

        /* renamed from: c */
        private final LinkedList<Object> f34194c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public final Method f34195d;

        private C11211b(Method method, Object... objArr) {
            this.f34194c = new LinkedList<>();
            if (objArr == null) {
                objArr = C11208x.f34185a;
            }
            WeakReference[] weakReferenceArr = new WeakReference[objArr.length];
            int length = objArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                Object obj = objArr[i];
                if ((obj instanceof Map) || (obj instanceof Integer) || (obj instanceof Double)) {
                    this.f34194c.add(obj);
                }
                int i3 = i2 + 1;
                weakReferenceArr[i2] = new WeakReference(obj);
                i++;
                i2 = i3;
            }
            this.f34193b = weakReferenceArr;
            this.f34195d = method;
        }
    }

    C11208x(C11210a<T> aVar, Class<T> cls) {
        C11146a.m36681a(aVar);
        C11146a.m36681a(cls);
        this.f34186b = aVar;
        this.f34187c = cls;
        C11198w.m36845a().mo36385a((C11204b) new C11204b() {
            /* renamed from: b */
            public void mo36367b() {
                C11208x.this.m36873c();
            }

            /* renamed from: c */
            public void mo36368c() {
            }
        });
    }

    /* renamed from: a */
    static <T> T m36866a(C11210a<T> aVar, Class<T> cls) {
        ClassLoader classLoader = cls.getClassLoader();
        C11208x xVar = new C11208x(aVar, cls);
        return Proxy.newProxyInstance(classLoader, new Class[]{cls}, xVar);
    }

    /* renamed from: a */
    private Object m36867a(Method method) {
        try {
            if (Boolean.TYPE.equals(method.getReturnType())) {
                return Boolean.valueOf(true);
            }
        } catch (Exception e) {
            C11176m.m36783a(e);
        }
        return null;
    }

    /* renamed from: a */
    private Object m36868a(Method method, Object[] objArr) {
        Class declaringClass = method.getDeclaringClass();
        C11198w a = C11198w.m36845a();
        if (Object.class.equals(declaringClass)) {
            String name = method.getName();
            if ("getClass".equals(name)) {
                return this.f34187c;
            }
            if (!"toString".equals(name)) {
                return method.invoke(this, objArr);
            }
            Object invoke = method.invoke(this, objArr);
            String name2 = C11208x.class.getName();
            String name3 = this.f34187c.getName();
            StringBuilder sb = new StringBuilder();
            sb.append(invoke);
            sb.append("");
            return sb.toString().replace(name2, name3);
        } else if (!this.f34189e || this.f34190f != null) {
            if (a.f34158a == C11206d.ON) {
                m36873c();
                T t = this.f34190f;
                if (t != null) {
                    return method.invoke(t, objArr);
                }
            }
            if (a.f34158a == C11206d.OFF && (!this.f34189e || this.f34190f != null)) {
                m36872b(method, objArr);
            }
            return m36867a(method);
        } else {
            this.f34188d.clear();
            return m36867a(method);
        }
    }

    /* renamed from: b */
    private void m36871b() {
        if (!this.f34189e) {
            try {
                this.f34190f = this.f34186b.mo36294a().mo36306c(null);
            } catch (Exception e) {
                C11185p.m36818a("OnOffTrackerProxy", (Object) this, "Could not create instance", (Throwable) e);
                C11176m.m36783a(e);
            }
            this.f34189e = true;
        }
    }

    /* renamed from: b */
    private void m36872b(Method method, Object[] objArr) {
        if (this.f34188d.size() >= 15) {
            this.f34188d.remove(5);
        }
        this.f34188d.add(new C11211b(method, objArr));
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m36873c() {
        m36871b();
        if (this.f34190f != null) {
            Iterator it = this.f34188d.iterator();
            while (it.hasNext()) {
                C11211b bVar = (C11211b) it.next();
                try {
                    Object[] objArr = new Object[bVar.f34193b.length];
                    WeakReference[] a = bVar.f34193b;
                    int length = a.length;
                    int i = 0;
                    int i2 = 0;
                    while (i < length) {
                        int i3 = i2 + 1;
                        objArr[i2] = a[i].get();
                        i++;
                        i2 = i3;
                    }
                    bVar.f34195d.invoke(this.f34190f, objArr);
                } catch (Exception e) {
                    C11176m.m36783a(e);
                }
            }
            this.f34188d.clear();
        }
    }

    public Object invoke(Object obj, Method method, Object[] objArr) {
        try {
            return m36868a(method, objArr);
        } catch (Exception e) {
            C11176m.m36783a(e);
            return m36867a(method);
        }
    }
}
