package p320f.p321a.p327d.p340j;

import java.util.concurrent.atomic.AtomicReference;
import p024io.reactivex.exceptions.CompositeException;

/* renamed from: f.a.d.j.j */
/* compiled from: ExceptionHelper */
public final class C13748j {

    /* renamed from: a */
    public static final Throwable f41857a = new C13749a();

    /* renamed from: f.a.d.j.j$a */
    /* compiled from: ExceptionHelper */
    static final class C13749a extends Throwable {
        C13749a() {
            super("No further exceptions");
        }

        public Throwable fillInStackTrace() {
            return this;
        }
    }

    /* renamed from: a */
    public static RuntimeException m43761a(Throwable error) {
        if (error instanceof Error) {
            throw ((Error) error);
        } else if (error instanceof RuntimeException) {
            return (RuntimeException) error;
        } else {
            return new RuntimeException(error);
        }
    }

    /* renamed from: a */
    public static <T> boolean m43763a(AtomicReference<Throwable> field, Throwable exception) {
        Throwable current;
        Throwable update;
        do {
            current = (Throwable) field.get();
            if (current == f41857a) {
                return false;
            }
            if (current == null) {
                update = exception;
            } else {
                update = new CompositeException(current, exception);
            }
        } while (!field.compareAndSet(current, update));
        return true;
    }

    /* renamed from: a */
    public static <T> Throwable m43762a(AtomicReference<Throwable> field) {
        Throwable current = (Throwable) field.get();
        Throwable th = f41857a;
        if (current != th) {
            return (Throwable) field.getAndSet(th);
        }
        return current;
    }
}
