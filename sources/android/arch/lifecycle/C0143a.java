package android.arch.lifecycle;

import android.arch.lifecycle.C0148d.C0000a;
import android.arch.lifecycle.ClassesInfoCache.MethodReference;
import android.arch.lifecycle.Lifecycle.Event;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: android.arch.lifecycle.a */
/* compiled from: ClassesInfoCache */
class C0143a {

    /* renamed from: a */
    static C0143a f197a = new C0143a();

    /* renamed from: b */
    private final Map<Class, C0144a> f198b = new HashMap();

    /* renamed from: c */
    private final Map<Class, Boolean> f199c = new HashMap();

    /* renamed from: android.arch.lifecycle.a$a */
    /* compiled from: ClassesInfoCache */
    static class C0144a {

        /* renamed from: a */
        final Map<C0000a, List<C0145b>> f200a = new HashMap();

        /* renamed from: b */
        final Map<C0145b, C0000a> f201b;

        C0144a(Map<C0145b, C0000a> handlerToEvent) {
            this.f201b = handlerToEvent;
            for (Entry<MethodReference, Event> entry : handlerToEvent.entrySet()) {
                C0000a event = (C0000a) entry.getValue();
                List list = (List) this.f200a.get(event);
                if (list == null) {
                    list = new ArrayList();
                    this.f200a.put(event, list);
                }
                list.add(entry.getKey());
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo3745a(C0001f source, C0000a event, Object target) {
            m833a((List) this.f200a.get(event), source, event, target);
            m833a((List) this.f200a.get(C0000a.ON_ANY), source, event, target);
        }

        /* renamed from: a */
        private static void m833a(List<C0145b> handlers, C0001f source, C0000a event, Object mWrapped) {
            if (handlers != null) {
                for (int i = handlers.size() - 1; i >= 0; i--) {
                    ((C0145b) handlers.get(i)).mo3746a(source, event, mWrapped);
                }
            }
        }
    }

    /* renamed from: android.arch.lifecycle.a$b */
    /* compiled from: ClassesInfoCache */
    static class C0145b {

        /* renamed from: a */
        final int f202a;

        /* renamed from: b */
        final Method f203b;

        C0145b(int callType, Method method) {
            this.f202a = callType;
            this.f203b = method;
            this.f203b.setAccessible(true);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo3746a(C0001f source, C0000a event, Object target) {
            try {
                int i = this.f202a;
                if (i == 0) {
                    this.f203b.invoke(target, new Object[0]);
                } else if (i == 1) {
                    this.f203b.invoke(target, new Object[]{source});
                } else if (i == 2) {
                    this.f203b.invoke(target, new Object[]{source, event});
                }
            } catch (InvocationTargetException e) {
                throw new RuntimeException("Failed to call observer method", e.getCause());
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2);
            }
        }

        public boolean equals(Object o) {
            boolean z = true;
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            C0145b that = (C0145b) o;
            if (this.f202a != that.f202a || !this.f203b.getName().equals(that.f203b.getName())) {
                z = false;
            }
            return z;
        }

        public int hashCode() {
            return (this.f202a * 31) + this.f203b.getName().hashCode();
        }
    }

    C0143a() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo3744b(Class klass) {
        if (this.f199c.containsKey(klass)) {
            return ((Boolean) this.f199c.get(klass)).booleanValue();
        }
        Method[] methods = m830c(klass);
        for (Method method : methods) {
            if (((C0002o) method.getAnnotation(C0002o.class)) != null) {
                m828a(klass, methods);
                return true;
            }
        }
        this.f199c.put(klass, Boolean.valueOf(false));
        return false;
    }

    /* renamed from: c */
    private Method[] m830c(Class klass) {
        try {
            return klass.getDeclaredMethods();
        } catch (NoClassDefFoundError e) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C0144a mo3743a(Class klass) {
        C0144a existing = (C0144a) this.f198b.get(klass);
        if (existing != null) {
            return existing;
        }
        return m828a(klass, null);
    }

    /* renamed from: a */
    private void m829a(Map<C0145b, C0000a> handlers, C0145b newHandler, C0000a newEvent, Class klass) {
        C0000a event = (C0000a) handlers.get(newHandler);
        if (event != null && newEvent != event) {
            Method method = newHandler.f203b;
            StringBuilder sb = new StringBuilder();
            sb.append("Method ");
            sb.append(method.getName());
            sb.append(" in ");
            sb.append(klass.getName());
            sb.append(" already declared with different @OnLifecycleEvent value: previous");
            sb.append(" value ");
            sb.append(event);
            sb.append(", new value ");
            sb.append(newEvent);
            throw new IllegalArgumentException(sb.toString());
        } else if (event == null) {
            handlers.put(newHandler, newEvent);
        }
    }

    /* renamed from: a */
    private C0144a m828a(Class klass, Method[] declaredMethods) {
        Class cls = klass;
        Class superclass = klass.getSuperclass();
        Map<MethodReference, Event> handlerToEvent = new HashMap<>();
        if (superclass != null) {
            C0144a superInfo = mo3743a(superclass);
            if (superInfo != null) {
                handlerToEvent.putAll(superInfo.f201b);
            }
        }
        char c = 0;
        for (Class intrfc : klass.getInterfaces()) {
            for (Entry<MethodReference, Event> entry : mo3743a(intrfc).f201b.entrySet()) {
                m829a(handlerToEvent, (C0145b) entry.getKey(), (C0000a) entry.getValue(), cls);
            }
        }
        Method[] methods = declaredMethods != null ? declaredMethods : m830c(klass);
        int length = methods.length;
        boolean hasLifecycleMethods = false;
        int i = 0;
        while (i < length) {
            Method method = methods[i];
            C0002o annotation = (C0002o) method.getAnnotation(C0002o.class);
            if (annotation != null) {
                hasLifecycleMethods = true;
                Class<?>[] params = method.getParameterTypes();
                int callType = 0;
                if (params.length > 0) {
                    callType = 1;
                    if (!params[c].isAssignableFrom(C0001f.class)) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                }
                C0000a event = annotation.value();
                if (params.length > 1) {
                    callType = 2;
                    if (!params[1].isAssignableFrom(C0000a.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    } else if (event != C0000a.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                }
                if (params.length <= 2) {
                    m829a(handlerToEvent, new C0145b(callType, method), event, cls);
                } else {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
            }
            i++;
            c = 0;
        }
        C0144a info = new C0144a(handlerToEvent);
        this.f198b.put(cls, info);
        this.f199c.put(cls, Boolean.valueOf(hasLifecycleMethods));
        return info;
    }
}
