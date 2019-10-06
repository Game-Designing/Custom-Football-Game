package p026rx.p390c.p395e;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import p026rx.exceptions.CompositeException;

/* renamed from: rx.c.e.e */
/* compiled from: ExceptionsUtils */
public enum C14869e {
    ;
    

    /* renamed from: a */
    private static final Throwable f44151a = null;

    static {
        f44151a = new Throwable("Terminated");
    }

    /* renamed from: a */
    public static boolean m46587a(AtomicReference<Throwable> field, Throwable error) {
        Throwable current;
        Throwable next;
        do {
            current = (Throwable) field.get();
            if (current == f44151a) {
                return false;
            }
            if (current == null) {
                next = error;
            } else if (current instanceof CompositeException) {
                List<Throwable> list = new ArrayList<>(((CompositeException) current).mo46124a());
                list.add(error);
                next = new CompositeException((Collection<? extends Throwable>) list);
            } else {
                next = new CompositeException(current, error);
            }
        } while (!field.compareAndSet(current, next));
        return true;
    }

    /* renamed from: a */
    public static Throwable m46585a(AtomicReference<Throwable> field) {
        Throwable current = (Throwable) field.get();
        Throwable th = f44151a;
        if (current != th) {
            return (Throwable) field.getAndSet(th);
        }
        return current;
    }

    /* renamed from: a */
    public static boolean m46586a(Throwable error) {
        return error == f44151a;
    }
}
