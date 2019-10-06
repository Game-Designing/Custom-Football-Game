package com.moat.analytics.mobile.inm;

import com.moat.analytics.mobile.inm.p227a.p228a.C10931a;
import com.moat.analytics.mobile.inm.p227a.p229b.C10932a;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/* renamed from: com.moat.analytics.mobile.inm.x */
class C10994x<T> implements InvocationHandler {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final Object[] f33589a = new Object[0];

    /* renamed from: b */
    private final C10996a<T> f33590b;

    /* renamed from: c */
    private final Class<T> f33591c;

    /* renamed from: d */
    private final LinkedList<C10997b> f33592d = new LinkedList<>();

    /* renamed from: e */
    private boolean f33593e;

    /* renamed from: f */
    private T f33594f;

    /* renamed from: com.moat.analytics.mobile.inm.x$a */
    interface C10996a<T> {
        /* renamed from: a */
        C10932a<T> mo35863a();
    }

    /* renamed from: com.moat.analytics.mobile.inm.x$b */
    private class C10997b {
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final WeakReference[] f33597b;

        /* renamed from: c */
        private final LinkedList<Object> f33598c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public final Method f33599d;

        private C10997b(Method method, Object... objArr) {
            this.f33598c = new LinkedList<>();
            if (objArr == null) {
                objArr = C10994x.f33589a;
            }
            WeakReference[] weakReferenceArr = new WeakReference[objArr.length];
            int length = objArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                Object obj = objArr[i];
                if ((obj instanceof Map) || (obj instanceof Integer) || (obj instanceof Double)) {
                    this.f33598c.add(obj);
                }
                int i3 = i2 + 1;
                weakReferenceArr[i2] = new WeakReference(obj);
                i++;
                i2 = i3;
            }
            this.f33597b = weakReferenceArr;
            this.f33599d = method;
        }
    }

    C10994x(C10996a<T> aVar, Class<T> cls) {
        C10931a.m35952a(aVar);
        C10931a.m35952a(cls);
        this.f33590b = aVar;
        this.f33591c = cls;
        C10984w.m36151a().mo35975a((C10990b) new C10990b() {
            /* renamed from: c */
            public void mo35954c() {
                C10994x.this.m36179c();
            }

            /* renamed from: d */
            public void mo35955d() {
            }
        });
    }

    /* renamed from: a */
    static <T> T m36172a(C10996a<T> aVar, Class<T> cls) {
        ClassLoader classLoader = cls.getClassLoader();
        C10994x xVar = new C10994x(aVar, cls);
        return Proxy.newProxyInstance(classLoader, new Class[]{cls}, xVar);
    }

    /* renamed from: a */
    private Object m36173a(Method method) {
        try {
            if (Boolean.TYPE.equals(method.getReturnType())) {
                return Boolean.valueOf(true);
            }
        } catch (Exception e) {
            C10960m.m36077a(e);
        }
        return null;
    }

    /* renamed from: a */
    private Object m36174a(Method method, Object[] objArr) {
        Class declaringClass = method.getDeclaringClass();
        C10984w a = C10984w.m36151a();
        if (Object.class.equals(declaringClass)) {
            String name = method.getName();
            if ("getClass".equals(name)) {
                return this.f33591c;
            }
            if (!"toString".equals(name)) {
                return method.invoke(this, objArr);
            }
            Object invoke = method.invoke(this, objArr);
            return String.valueOf(invoke).replace(C10994x.class.getName(), this.f33591c.getName());
        } else if (!this.f33593e || this.f33594f != null) {
            if (a.f33561a == C10992d.ON) {
                m36179c();
                T t = this.f33594f;
                if (t != null) {
                    return method.invoke(t, objArr);
                }
            }
            if (a.f33561a == C10992d.OFF && (!this.f33593e || this.f33594f != null)) {
                m36178b(method, objArr);
            }
            return m36173a(method);
        } else {
            this.f33592d.clear();
            return m36173a(method);
        }
    }

    /* renamed from: b */
    private void m36177b() {
        if (!this.f33593e) {
            try {
                this.f33594f = this.f33590b.mo35863a().mo35881c(null);
            } catch (Exception e) {
                C10969p.m36115a("OnOffTrackerProxy", (Object) this, "Could not create instance", (Throwable) e);
                C10960m.m36077a(e);
            }
            this.f33593e = true;
        }
    }

    /* renamed from: b */
    private void m36178b(Method method, Object[] objArr) {
        if (this.f33592d.size() >= 15) {
            this.f33592d.remove(5);
        }
        this.f33592d.add(new C10997b(method, objArr));
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m36179c() {
        m36177b();
        if (this.f33594f != null) {
            Iterator it = this.f33592d.iterator();
            while (it.hasNext()) {
                C10997b bVar = (C10997b) it.next();
                try {
                    Object[] objArr = new Object[bVar.f33597b.length];
                    WeakReference[] a = bVar.f33597b;
                    int length = a.length;
                    int i = 0;
                    int i2 = 0;
                    while (i < length) {
                        int i3 = i2 + 1;
                        objArr[i2] = a[i].get();
                        i++;
                        i2 = i3;
                    }
                    bVar.f33599d.invoke(this.f33594f, objArr);
                } catch (Exception e) {
                    C10960m.m36077a(e);
                }
            }
            this.f33592d.clear();
        }
    }

    public Object invoke(Object obj, Method method, Object[] objArr) {
        try {
            return m36174a(method, objArr);
        } catch (Exception e) {
            C10960m.m36077a(e);
            return m36173a(method);
        }
    }
}
