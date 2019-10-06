package com.bumptech.glide.load.p109a;

import com.bumptech.glide.load.p109a.C6044e.C6045a;
import com.bumptech.glide.p107h.C6024i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.bumptech.glide.load.a.g */
/* compiled from: DataRewinderRegistry */
public class C6047g {

    /* renamed from: a */
    private static final C6045a<?> f10716a = new C6046f();

    /* renamed from: b */
    private final Map<Class<?>, C6045a<?>> f10717b = new HashMap();

    /* renamed from: com.bumptech.glide.load.a.g$a */
    /* compiled from: DataRewinderRegistry */
    private static final class C6048a implements C6044e<Object> {

        /* renamed from: a */
        private final Object f10718a;

        C6048a(Object data) {
            this.f10718a = data;
        }

        /* renamed from: a */
        public Object mo18869a() {
            return this.f10718a;
        }

        /* renamed from: b */
        public void mo18870b() {
        }
    }

    /* renamed from: a */
    public synchronized void mo18874a(C6045a<?> factory) {
        this.f10717b.put(factory.mo18872a(), factory);
    }

    /* renamed from: a */
    public synchronized <T> C6044e<T> mo18873a(T data) {
        C6045a aVar;
        C6024i.m11264a(data);
        aVar = (C6045a) this.f10717b.get(data.getClass());
        if (aVar == null) {
            Iterator it = this.f10717b.values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                C6045a aVar2 = (C6045a) it.next();
                if (aVar2.mo18872a().isAssignableFrom(data.getClass())) {
                    aVar = aVar2;
                    break;
                }
            }
        }
        if (aVar == null) {
            aVar = f10716a;
        }
        return aVar.mo18871a(data);
    }
}
