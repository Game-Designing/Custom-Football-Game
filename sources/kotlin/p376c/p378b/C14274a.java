package kotlin.p376c.p378b;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import kotlin.p376c.C14273b;
import kotlin.p381e.C14298b;
import kotlin.p381e.C14301e;
import kotlin.p381e.C14312k;
import kotlin.p381e.C14313l;

/* renamed from: kotlin.c.b.a */
/* compiled from: CallableReference */
public abstract class C14274a implements C14298b, Serializable {
    public static final Object NO_RECEIVER = C14275a.f43214a;
    protected final Object receiver;
    private transient C14298b reflected;

    /* renamed from: kotlin.c.b.a$a */
    /* compiled from: CallableReference */
    private static class C14275a implements Serializable {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public static final C14275a f43214a = new C14275a();

        private C14275a() {
        }

        private Object readResolve() throws ObjectStreamException {
            return f43214a;
        }
    }

    /* access modifiers changed from: protected */
    public abstract C14298b computeReflected();

    public C14274a() {
        this(NO_RECEIVER);
    }

    protected C14274a(Object receiver2) {
        this.receiver = receiver2;
    }

    public Object getBoundReceiver() {
        return this.receiver;
    }

    public C14298b compute() {
        C14298b result = this.reflected;
        if (result != null) {
            return result;
        }
        C14298b result2 = computeReflected();
        this.reflected = result2;
        return result2;
    }

    /* access modifiers changed from: protected */
    public C14298b getReflected() {
        C14298b result = compute();
        if (result != this) {
            return result;
        }
        throw new C14273b();
    }

    public C14301e getOwner() {
        throw new AbstractMethodError();
    }

    public String getName() {
        throw new AbstractMethodError();
    }

    public String getSignature() {
        throw new AbstractMethodError();
    }

    public List<Object> getParameters() {
        return getReflected().getParameters();
    }

    public C14312k getReturnType() {
        return getReflected().getReturnType();
    }

    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    public List<Object> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    public Object call(Object... args) {
        return getReflected().call(args);
    }

    public Object callBy(Map args) {
        return getReflected().callBy(args);
    }

    public C14313l getVisibility() {
        return getReflected().getVisibility();
    }

    public boolean isFinal() {
        return getReflected().isFinal();
    }

    public boolean isOpen() {
        return getReflected().isOpen();
    }

    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    public boolean isSuspend() {
        return getReflected().isSuspend();
    }
}
