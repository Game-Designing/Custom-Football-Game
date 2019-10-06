package p026rx.exceptions;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import p026rx.C0125T;
import p026rx.C14972ha;

/* renamed from: rx.exceptions.a */
/* compiled from: Exceptions */
public final class C14927a {
    /* renamed from: b */
    public static RuntimeException m46677b(Throwable t) {
        if (t instanceof RuntimeException) {
            throw ((RuntimeException) t);
        } else if (t instanceof Error) {
            throw ((Error) t);
        } else {
            throw new RuntimeException(t);
        }
    }

    /* renamed from: c */
    public static void m46678c(Throwable t) {
        if (t instanceof OnErrorNotImplementedException) {
            throw ((OnErrorNotImplementedException) t);
        } else if (t instanceof OnErrorFailedException) {
            throw ((OnErrorFailedException) t);
        } else if (t instanceof OnCompletedFailedException) {
            throw ((OnCompletedFailedException) t);
        } else if (t instanceof VirtualMachineError) {
            throw ((VirtualMachineError) t);
        } else if (t instanceof ThreadDeath) {
            throw ((ThreadDeath) t);
        } else if (t instanceof LinkageError) {
            throw ((LinkageError) t);
        }
    }

    /* renamed from: a */
    public static void m46671a(Throwable e, Throwable cause) {
        Set<Throwable> seenCauses = new HashSet<>();
        int i = 0;
        while (true) {
            if (e.getCause() != null) {
                int i2 = i + 1;
                if (i < 25) {
                    e = e.getCause();
                    if (seenCauses.contains(e.getCause())) {
                        int i3 = i2;
                        break;
                    } else {
                        seenCauses.add(e.getCause());
                        i = i2;
                    }
                } else {
                    return;
                }
            }
        }
        try {
            e.initCause(cause);
        } catch (Throwable th) {
        }
    }

    /* renamed from: a */
    public static Throwable m46670a(Throwable e) {
        int i = 0;
        while (e.getCause() != null) {
            int i2 = i + 1;
            if (i >= 25) {
                return new RuntimeException("Stack too deep to get final cause");
            }
            e = e.getCause();
            i = i2;
        }
        return e;
    }

    /* renamed from: a */
    public static void m46676a(List<? extends Throwable> exceptions) {
        if (exceptions != null && !exceptions.isEmpty()) {
            if (exceptions.size() == 1) {
                Throwable t = (Throwable) exceptions.get(0);
                if (t instanceof RuntimeException) {
                    throw ((RuntimeException) t);
                } else if (t instanceof Error) {
                    throw ((Error) t);
                } else {
                    throw new RuntimeException(t);
                }
            } else {
                throw new CompositeException((Collection<? extends Throwable>) exceptions);
            }
        }
    }

    /* renamed from: a */
    public static void m46673a(Throwable t, C0125T<?> o, Object value) {
        m46678c(t);
        o.onError(OnErrorThrowable.m46666a(t, value));
    }

    /* renamed from: a */
    public static void m46675a(Throwable t, C14972ha<?> o, Object value) {
        m46678c(t);
        o.onError(OnErrorThrowable.m46666a(t, value));
    }

    /* renamed from: a */
    public static void m46672a(Throwable t, C0125T<?> o) {
        m46678c(t);
        o.onError(t);
    }

    /* renamed from: a */
    public static void m46674a(Throwable throwable, C14972ha<?> subscriber) {
        m46678c(throwable);
        subscriber.onError(throwable);
    }
}
