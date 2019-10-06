package com.moat.analytics.mobile.iro;

import com.moat.analytics.mobile.iro.base.asserts.Asserts;
import com.moat.analytics.mobile.iro.base.functional.Optional;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/* renamed from: com.moat.analytics.mobile.iro.s */
class C11050s<T> implements InvocationHandler {
    /* access modifiers changed from: private */

    /* renamed from: ˊ */
    public static final Object[] f33778 = new Object[0];

    /* renamed from: ˋ */
    private final LinkedList<C11053e> f33779 = new LinkedList<>();

    /* renamed from: ˎ */
    private final Class<T> f33780;

    /* renamed from: ˏ */
    private boolean f33781;

    /* renamed from: ॱ */
    private final C11052a<T> f33782;

    /* renamed from: ᐝ */
    private T f33783;

    /* renamed from: com.moat.analytics.mobile.iro.s$a */
    interface C11052a<T> {
        /* renamed from: ˏ */
        Optional<T> mo36029() throws C11043o;
    }

    /* renamed from: com.moat.analytics.mobile.iro.s$e */
    class C11053e {
        /* access modifiers changed from: private */

        /* renamed from: ˊ */
        public final Method f33785;

        /* renamed from: ˋ */
        private final LinkedList<Object> f33786;
        /* access modifiers changed from: private */

        /* renamed from: ˎ */
        public final WeakReference[] f33787;

        /* synthetic */ C11053e(C11050s sVar, Method method, Object[] objArr, byte b) {
            this(method, objArr);
        }

        private C11053e(Method method, Object... objArr) {
            this.f33786 = new LinkedList<>();
            if (objArr == null) {
                objArr = C11050s.f33778;
            }
            WeakReference[] weakReferenceArr = new WeakReference[objArr.length];
            int length = objArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                Object obj = objArr[i];
                if ((obj instanceof Map) || (obj instanceof Integer) || (obj instanceof Double)) {
                    this.f33786.add(obj);
                }
                int i3 = i2 + 1;
                weakReferenceArr[i2] = new WeakReference(obj);
                i++;
                i2 = i3;
            }
            this.f33787 = weakReferenceArr;
            this.f33785 = method;
        }
    }

    private C11050s(C11052a<T> aVar, Class<T> cls) throws C11043o {
        Asserts.checkNotNull(aVar);
        Asserts.checkNotNull(cls);
        this.f33782 = aVar;
        this.f33780 = cls;
        C11054t.m36390().mo36126((C11058a) new C11058a() {
            /* renamed from: ॱ */
            public final void mo36109() throws C11043o {
                C11050s.this.m36381();
            }
        });
    }

    /* renamed from: ˊ */
    static <T> T m36379(C11052a<T> aVar, Class<T> cls) throws C11043o {
        ClassLoader classLoader = cls.getClassLoader();
        C11050s sVar = new C11050s(aVar, cls);
        return Proxy.newProxyInstance(classLoader, new Class[]{cls}, sVar);
    }

    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        try {
            Class declaringClass = method.getDeclaringClass();
            C11054t r0 = C11054t.m36390();
            if (Object.class.equals(declaringClass)) {
                String name = method.getName();
                if ("getClass".equals(name)) {
                    return this.f33780;
                }
                if (!"toString".equals(name)) {
                    return method.invoke(this, objArr);
                }
                Object invoke = method.invoke(this, objArr);
                return String.valueOf(invoke).replace(C11050s.class.getName(), this.f33780.getName());
            } else if (!this.f33781 || this.f33783 != null) {
                if (r0.f33794 == C11060c.f33811) {
                    m36381();
                    if (this.f33783 != null) {
                        return method.invoke(this.f33783, objArr);
                    }
                }
                if (r0.f33794 == C11060c.f33810 && (!this.f33781 || this.f33783 != null)) {
                    if (this.f33779.size() >= 15) {
                        this.f33779.remove(5);
                    }
                    this.f33779.add(new C11053e(this, method, objArr, 0));
                }
                return m36378(method);
            } else {
                this.f33779.clear();
                return m36378(method);
            }
        } catch (Exception e) {
            C11043o.m36351(e);
            return m36378(method);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ˋ */
    public void m36381() throws C11043o {
        if (!this.f33781) {
            try {
                this.f33783 = this.f33782.mo36029().orElse(null);
            } catch (Exception e) {
                C11011b.m36230("OnOffTrackerProxy", this, "Could not create instance", e);
                C11043o.m36351(e);
            }
            this.f33781 = true;
        }
        if (this.f33783 != null) {
            Iterator it = this.f33779.iterator();
            while (it.hasNext()) {
                C11053e eVar = (C11053e) it.next();
                try {
                    Object[] objArr = new Object[eVar.f33787.length];
                    WeakReference[] r3 = eVar.f33787;
                    int length = r3.length;
                    int i = 0;
                    int i2 = 0;
                    while (i < length) {
                        int i3 = i2 + 1;
                        objArr[i2] = r3[i].get();
                        i++;
                        i2 = i3;
                    }
                    eVar.f33785.invoke(this.f33783, objArr);
                } catch (Exception e2) {
                    C11043o.m36351(e2);
                }
            }
            this.f33779.clear();
        }
    }

    /* renamed from: ˊ */
    private static Boolean m36378(Method method) {
        try {
            if (Boolean.TYPE.equals(method.getReturnType())) {
                return Boolean.valueOf(true);
            }
        } catch (Exception e) {
            C11043o.m36351(e);
        }
        return null;
    }
}
