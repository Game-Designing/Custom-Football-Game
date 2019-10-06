package p320f.p321a.p327d.p340j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import p320f.p321a.p326c.C13212n;

/* renamed from: f.a.d.j.b */
/* compiled from: ArrayListSupplier */
public enum C13740b implements Callable<List<Object>>, C13212n<Object, List<Object>> {
    INSTANCE;

    /* renamed from: e */
    public static <T> Callable<List<T>> m43745e() {
        return INSTANCE;
    }

    /* renamed from: f */
    public static <T, O> C13212n<O, List<T>> m43746f() {
        return INSTANCE;
    }

    public List<Object> call() throws Exception {
        return new ArrayList();
    }

    public List<Object> apply(Object o) throws Exception {
        return new ArrayList();
    }
}
