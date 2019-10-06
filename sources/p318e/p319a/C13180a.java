package p318e.p319a;

import javax.inject.Provider;
import p318e.C13179a;

/* renamed from: e.a.a */
/* compiled from: DoubleCheck */
public final class C13180a<T> implements Provider<T>, C13179a<T> {

    /* renamed from: a */
    private static final Object f40276a = new Object();

    /* renamed from: b */
    private volatile Provider<T> f40277b;

    /* renamed from: c */
    private volatile Object f40278c = f40276a;

    private C13180a(Provider<T> provider) {
        this.f40277b = provider;
    }

    public T get() {
        Object result = this.f40278c;
        if (result == f40276a) {
            synchronized (this) {
                result = this.f40278c;
                if (result == f40276a) {
                    result = this.f40277b.get();
                    Object currentInstance = this.f40278c;
                    if (currentInstance != f40276a) {
                        if (currentInstance != result) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Scoped provider was invoked recursively returning different results: ");
                            sb.append(currentInstance);
                            sb.append(" & ");
                            sb.append(result);
                            sb.append(". This is likely due to a circular dependency.");
                            throw new IllegalStateException(sb.toString());
                        }
                    }
                    this.f40278c = result;
                    this.f40277b = null;
                }
            }
        }
        return result;
    }

    /* renamed from: a */
    public static <T> Provider<T> m43109a(Provider<T> delegate) {
        C13182c.m43110a(delegate);
        if (delegate instanceof C13180a) {
            return delegate;
        }
        return new C13180a(delegate);
    }
}
