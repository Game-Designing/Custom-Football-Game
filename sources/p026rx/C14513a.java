package p026rx;

import p026rx.exceptions.MissingBackpressureException;

/* renamed from: rx.a */
/* compiled from: BackpressureOverflow */
public final class C14513a {

    /* renamed from: a */
    public static final C14517d f43327a = C14516c.f43333a;

    /* renamed from: b */
    public static final C14517d f43328b = f43327a;

    /* renamed from: c */
    public static final C14517d f43329c = C14515b.f43332a;

    /* renamed from: d */
    public static final C14517d f43330d = C14514a.f43331a;

    /* renamed from: rx.a$a */
    /* compiled from: BackpressureOverflow */
    static final class C14514a implements C14517d {

        /* renamed from: a */
        static final C14514a f43331a = new C14514a();

        private C14514a() {
        }

        /* renamed from: a */
        public boolean mo45715a() {
            return false;
        }
    }

    /* renamed from: rx.a$b */
    /* compiled from: BackpressureOverflow */
    static final class C14515b implements C14517d {

        /* renamed from: a */
        static final C14515b f43332a = new C14515b();

        private C14515b() {
        }

        /* renamed from: a */
        public boolean mo45715a() {
            return true;
        }
    }

    /* renamed from: rx.a$c */
    /* compiled from: BackpressureOverflow */
    static final class C14516c implements C14517d {

        /* renamed from: a */
        static final C14516c f43333a = new C14516c();

        private C14516c() {
        }

        /* renamed from: a */
        public boolean mo45715a() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }

    /* renamed from: rx.a$d */
    /* compiled from: BackpressureOverflow */
    public interface C14517d {
        /* renamed from: a */
        boolean mo45715a() throws MissingBackpressureException;
    }
}
