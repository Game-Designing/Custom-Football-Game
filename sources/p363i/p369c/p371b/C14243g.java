package p363i.p369c.p371b;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Queue;
import p363i.p369c.C14236b;
import p363i.p369c.p370a.C14232a;
import p363i.p369c.p370a.C14234c;
import p363i.p369c.p370a.C14235d;

/* renamed from: i.c.b.g */
/* compiled from: SubstituteLogger */
public class C14243g implements C14236b {

    /* renamed from: a */
    private final String f43172a;

    /* renamed from: b */
    private volatile C14236b f43173b;

    /* renamed from: c */
    private Boolean f43174c;

    /* renamed from: d */
    private Method f43175d;

    /* renamed from: e */
    private C14232a f43176e;

    /* renamed from: f */
    private Queue<C14235d> f43177f;

    /* renamed from: g */
    private final boolean f43178g;

    public C14243g(String name, Queue<C14235d> eventQueue, boolean createdPostInitialization) {
        this.f43172a = name;
        this.f43177f = eventQueue;
        this.f43178g = createdPostInitialization;
    }

    /* renamed from: b */
    public String mo44367b() {
        return this.f43172a;
    }

    public boolean isTraceEnabled() {
        return mo44364a().isTraceEnabled();
    }

    /* renamed from: c */
    public void mo44345c(String msg) {
        mo44364a().mo44345c(msg);
    }

    public boolean isDebugEnabled() {
        return mo44364a().isDebugEnabled();
    }

    /* renamed from: a */
    public void mo44340a(String msg) {
        mo44364a().mo44340a(msg);
    }

    /* renamed from: a */
    public void mo44341a(String format, Object arg1, Object arg2) {
        mo44364a().mo44341a(format, arg1, arg2);
    }

    /* renamed from: c */
    public void mo44346c(String msg, Throwable t) {
        mo44364a().mo44346c(msg, t);
    }

    /* renamed from: a */
    public void mo44342a(String msg, Throwable t) {
        mo44364a().mo44342a(msg, t);
    }

    /* renamed from: b */
    public void mo44343b(String msg) {
        mo44364a().mo44343b(msg);
    }

    /* renamed from: b */
    public void mo44344b(String msg, Throwable t) {
        mo44364a().mo44344b(msg, t);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!this.f43172a.equals(((C14243g) o).f43172a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f43172a.hashCode();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C14236b mo44364a() {
        if (this.f43173b != null) {
            return this.f43173b;
        }
        if (this.f43178g) {
            return C14240d.f43170b;
        }
        return m45827f();
    }

    /* renamed from: f */
    private C14236b m45827f() {
        if (this.f43176e == null) {
            this.f43176e = new C14232a(this, this.f43177f);
        }
        return this.f43176e;
    }

    /* renamed from: a */
    public void mo44366a(C14236b delegate) {
        this.f43173b = delegate;
    }

    /* renamed from: c */
    public boolean mo44368c() {
        Boolean bool = this.f43174c;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            this.f43175d = this.f43173b.getClass().getMethod("log", new Class[]{C14234c.class});
            this.f43174c = Boolean.TRUE;
        } catch (NoSuchMethodException e) {
            this.f43174c = Boolean.FALSE;
        }
        return this.f43174c.booleanValue();
    }

    /* renamed from: a */
    public void mo44365a(C14234c event) {
        if (mo44368c()) {
            try {
                this.f43175d.invoke(this.f43173b, new Object[]{event});
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            }
        }
    }

    /* renamed from: e */
    public boolean mo44370e() {
        return this.f43173b == null;
    }

    /* renamed from: d */
    public boolean mo44369d() {
        return this.f43173b instanceof C14240d;
    }
}
