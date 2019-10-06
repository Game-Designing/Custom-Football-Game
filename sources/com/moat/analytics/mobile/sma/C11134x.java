package com.moat.analytics.mobile.sma;

import com.moat.analytics.mobile.sma.p230a.p231a.C11075a;
import com.moat.analytics.mobile.sma.p230a.p232b.C11076a;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/* renamed from: com.moat.analytics.mobile.sma.x */
class C11134x<T> implements InvocationHandler {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final Object[] f33998a = new Object[0];

    /* renamed from: b */
    private final C11136a<T> f33999b;

    /* renamed from: c */
    private final Class<T> f34000c;

    /* renamed from: d */
    private final LinkedList<C11137b> f34001d = new LinkedList<>();

    /* renamed from: e */
    private boolean f34002e;

    /* renamed from: f */
    private T f34003f;

    /* renamed from: com.moat.analytics.mobile.sma.x$a */
    interface C11136a<T> {
        /* renamed from: a */
        C11076a<T> mo36164a();
    }

    /* renamed from: com.moat.analytics.mobile.sma.x$b */
    private class C11137b {
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final WeakReference[] f34006b;

        /* renamed from: c */
        private final LinkedList<Object> f34007c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public final Method f34008d;

        private C11137b(Method method, Object... objArr) {
            this.f34007c = new LinkedList<>();
            if (objArr == null) {
                objArr = C11134x.f33998a;
            }
            WeakReference[] weakReferenceArr = new WeakReference[objArr.length];
            int length = objArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                Object obj = objArr[i];
                if ((obj instanceof Map) || (obj instanceof Integer) || (obj instanceof Double)) {
                    this.f34007c.add(obj);
                }
                int i3 = i2 + 1;
                weakReferenceArr[i2] = new WeakReference(obj);
                i++;
                i2 = i3;
            }
            this.f34006b = weakReferenceArr;
            this.f34008d = method;
        }
    }

    C11134x(C11136a<T> aVar, Class<T> cls) {
        C11075a.m36440a(aVar);
        C11075a.m36440a(cls);
        this.f33999b = aVar;
        this.f34000c = cls;
        C11124w.m36605a().mo36253a((C11130b) new C11130b() {
            /* renamed from: b */
            public void mo36235b() {
                C11134x.this.m36633c();
            }

            /* renamed from: c */
            public void mo36236c() {
            }
        });
    }

    /* renamed from: a */
    static <T> T m36626a(C11136a<T> aVar, Class<T> cls) {
        ClassLoader classLoader = cls.getClassLoader();
        C11134x xVar = new C11134x(aVar, cls);
        return Proxy.newProxyInstance(classLoader, new Class[]{cls}, xVar);
    }

    /* renamed from: a */
    private Object m36627a(Method method) {
        try {
            if (Boolean.TYPE.equals(method.getReturnType())) {
                return Boolean.valueOf(true);
            }
        } catch (Exception e) {
            C11102m.m36543a(e);
        }
        return null;
    }

    /* renamed from: a */
    private Object m36628a(Method method, Object[] objArr) {
        Class declaringClass = method.getDeclaringClass();
        C11124w a = C11124w.m36605a();
        if (Object.class.equals(declaringClass)) {
            String name = method.getName();
            if ("getClass".equals(name)) {
                return this.f34000c;
            }
            if (!"toString".equals(name)) {
                return method.invoke(this, objArr);
            }
            Object invoke = method.invoke(this, objArr);
            String name2 = C11134x.class.getName();
            String name3 = this.f34000c.getName();
            StringBuilder sb = new StringBuilder();
            sb.append(invoke);
            sb.append("");
            return sb.toString().replace(name2, name3);
        } else if (!this.f34002e || this.f34003f != null) {
            if (a.f33971a == C11132d.ON) {
                m36633c();
                T t = this.f34003f;
                if (t != null) {
                    return method.invoke(t, objArr);
                }
            }
            if (a.f33971a == C11132d.OFF && (!this.f34002e || this.f34003f != null)) {
                m36632b(method, objArr);
            }
            return m36627a(method);
        } else {
            this.f34001d.clear();
            return m36627a(method);
        }
    }

    /* renamed from: b */
    private void m36631b() {
        if (!this.f34002e) {
            try {
                this.f34003f = this.f33999b.mo36164a().mo36176c(null);
            } catch (Exception e) {
                C11111p.m36578a("OnOffTrackerProxy", (Object) this, "Could not create instance", (Throwable) e);
                C11102m.m36543a(e);
            }
            this.f34002e = true;
        }
    }

    /* renamed from: b */
    private void m36632b(Method method, Object[] objArr) {
        if (this.f34001d.size() >= 15) {
            this.f34001d.remove(5);
        }
        this.f34001d.add(new C11137b(method, objArr));
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m36633c() {
        m36631b();
        if (this.f34003f != null) {
            Iterator it = this.f34001d.iterator();
            while (it.hasNext()) {
                C11137b bVar = (C11137b) it.next();
                try {
                    Object[] objArr = new Object[bVar.f34006b.length];
                    WeakReference[] a = bVar.f34006b;
                    int length = a.length;
                    int i = 0;
                    int i2 = 0;
                    while (i < length) {
                        int i3 = i2 + 1;
                        objArr[i2] = a[i].get();
                        i++;
                        i2 = i3;
                    }
                    bVar.f34008d.invoke(this.f34003f, objArr);
                } catch (Exception e) {
                    C11102m.m36543a(e);
                }
            }
            this.f34001d.clear();
        }
    }

    public Object invoke(Object obj, Method method, Object[] objArr) {
        try {
            return m36628a(method, objArr);
        } catch (Exception e) {
            C11102m.m36543a(e);
            return m36627a(method);
        }
    }
}
