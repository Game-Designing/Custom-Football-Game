package android.arch.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: android.arch.lifecycle.j */
/* compiled from: Lifecycling */
public class C0155j {

    /* renamed from: a */
    private static Map<Class, Integer> f222a = new HashMap();

    /* renamed from: b */
    private static Map<Class, List<Constructor<? extends C0147c>>> f223b = new HashMap();

    /* renamed from: a */
    static GenericLifecycleObserver m859a(Object object) {
        if (object instanceof FullLifecycleObserver) {
            return new FullLifecycleObserverAdapter((FullLifecycleObserver) object);
        }
        if (object instanceof GenericLifecycleObserver) {
            return (GenericLifecycleObserver) object;
        }
        Class<?> klass = object.getClass();
        if (m863b(klass) != 2) {
            return new ReflectiveGenericLifecycleObserver(object);
        }
        List<Constructor<? extends GeneratedAdapter>> constructors = (List) f223b.get(klass);
        if (constructors.size() == 1) {
            return new SingleGeneratedAdapterObserver(m860a((Constructor) constructors.get(0), object));
        }
        C0147c[] adapters = new C0147c[constructors.size()];
        for (int i = 0; i < constructors.size(); i++) {
            adapters[i] = m860a((Constructor) constructors.get(i), object);
        }
        return new CompositeGeneratedAdaptersObserver(adapters);
    }

    /* renamed from: a */
    private static C0147c m860a(Constructor<? extends C0147c> constructor, Object object) {
        try {
            return (C0147c) constructor.newInstance(new Object[]{object});
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    /* renamed from: a */
    private static Constructor<? extends C0147c> m862a(Class<?> klass) {
        String str;
        String str2;
        try {
            Package aPackage = klass.getPackage();
            String name = klass.getCanonicalName();
            String fullPackage = aPackage != null ? aPackage.getName() : "";
            if (fullPackage.isEmpty()) {
                str = name;
            } else {
                str = name.substring(fullPackage.length() + 1);
            }
            String adapterName = m861a(str);
            if (fullPackage.isEmpty()) {
                str2 = adapterName;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(fullPackage);
                sb.append(".");
                sb.append(adapterName);
                str2 = sb.toString();
            }
            Constructor<? extends GeneratedAdapter> constructor = Class.forName(str2).getDeclaredConstructor(new Class[]{klass});
            if (!constructor.isAccessible()) {
                constructor.setAccessible(true);
            }
            return constructor;
        } catch (ClassNotFoundException e) {
            return null;
        } catch (NoSuchMethodException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* renamed from: b */
    private static int m863b(Class<?> klass) {
        if (f222a.containsKey(klass)) {
            return ((Integer) f222a.get(klass)).intValue();
        }
        int type = m865d(klass);
        f222a.put(klass, Integer.valueOf(type));
        return type;
    }

    /* renamed from: d */
    private static int m865d(Class<?> klass) {
        Class<?>[] interfaces;
        if (klass.getCanonicalName() == null) {
            return 1;
        }
        Constructor<? extends GeneratedAdapter> constructor = m862a(klass);
        if (constructor != null) {
            f223b.put(klass, Collections.singletonList(constructor));
            return 2;
        } else if (C0143a.f197a.mo3744b(klass)) {
            return 1;
        } else {
            Class<?> superclass = klass.getSuperclass();
            List<Constructor<? extends GeneratedAdapter>> adapterConstructors = null;
            if (m864c(superclass)) {
                if (m863b(superclass) == 1) {
                    return 1;
                }
                adapterConstructors = new ArrayList<>((Collection) f223b.get(superclass));
            }
            for (Class<?> intrface : klass.getInterfaces()) {
                if (m864c(intrface)) {
                    if (m863b(intrface) == 1) {
                        return 1;
                    }
                    if (adapterConstructors == null) {
                        adapterConstructors = new ArrayList<>();
                    }
                    adapterConstructors.addAll((Collection) f223b.get(intrface));
                }
            }
            if (adapterConstructors == null) {
                return 1;
            }
            f223b.put(klass, adapterConstructors);
            return 2;
        }
    }

    /* renamed from: c */
    private static boolean m864c(Class<?> klass) {
        return klass != null && C0150e.class.isAssignableFrom(klass);
    }

    /* renamed from: a */
    public static String m861a(String className) {
        StringBuilder sb = new StringBuilder();
        sb.append(className.replace(".", "_"));
        sb.append("_LifecycleAdapter");
        return sb.toString();
    }
}
