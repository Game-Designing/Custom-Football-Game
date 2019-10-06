package p024io.reactivex.exceptions;

import p320f.p321a.p327d.p340j.C13748j;

/* renamed from: io.reactivex.exceptions.a */
/* compiled from: Exceptions */
public final class C13980a {
    /* renamed from: a */
    public static RuntimeException m44461a(Throwable t) {
        throw C13748j.m43761a(t);
    }

    /* renamed from: b */
    public static void m44462b(Throwable t) {
        if (t instanceof VirtualMachineError) {
            throw ((VirtualMachineError) t);
        } else if (t instanceof ThreadDeath) {
            throw ((ThreadDeath) t);
        } else if (t instanceof LinkageError) {
            throw ((LinkageError) t);
        }
    }
}
