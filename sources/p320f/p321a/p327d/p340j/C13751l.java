package p320f.p321a.p327d.p340j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/* renamed from: f.a.d.j.l */
/* compiled from: HashMapSupplier */
public enum C13751l implements Callable<Map<Object, Object>> {
    INSTANCE;

    /* renamed from: e */
    public static <K, V> Callable<Map<K, V>> m43770e() {
        return INSTANCE;
    }

    public Map<Object, Object> call() throws Exception {
        return new HashMap();
    }
}
