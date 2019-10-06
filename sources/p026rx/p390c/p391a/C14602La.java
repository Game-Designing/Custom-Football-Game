package p026rx.p390c.p391a;

import java.util.NoSuchElementException;
import p026rx.C0120S.C0123b;
import p026rx.C14980ia;
import p026rx.p390c.p392b.C14773d;
import p026rx.p400f.C14948s;
import rx.internal.operators.OperatorSingle.ParentSubscriber;

/* renamed from: rx.c.a.La */
/* compiled from: OperatorSingle */
public final class C14602La<T> implements C0123b<T, T> {

    /* renamed from: a */
    private final boolean f43494a;

    /* renamed from: b */
    private final T f43495b;

    /* renamed from: rx.c.a.La$a */
    /* compiled from: OperatorSingle */
    static final class C14603a {

        /* renamed from: a */
        static final C14602La<?> f43496a = new C14602La<>();
    }

    /* renamed from: rx.c.a.La$b */
    /* compiled from: OperatorSingle */
    static final class C14604b<T> extends C14980ia<T> {

        /* renamed from: a */
        private final C14980ia<? super T> f43497a;

        /* renamed from: b */
        private final boolean f43498b;

        /* renamed from: c */
        private final T f43499c;

        /* renamed from: d */
        private T f43500d;

        /* renamed from: e */
        private boolean f43501e;

        /* renamed from: f */
        private boolean f43502f;

        C14604b(C14980ia<? super T> child, boolean hasDefaultValue, T defaultValue) {
            this.f43497a = child;
            this.f43498b = hasDefaultValue;
            this.f43499c = defaultValue;
            request(2);
        }

        public void onNext(T value) {
            if (this.f43502f) {
                return;
            }
            if (this.f43501e) {
                this.f43502f = true;
                this.f43497a.onError(new IllegalArgumentException("Sequence contains too many elements"));
                unsubscribe();
                return;
            }
            this.f43500d = value;
            this.f43501e = true;
        }

        public void onCompleted() {
            if (this.f43502f) {
                return;
            }
            if (this.f43501e) {
                C14980ia<? super T> iaVar = this.f43497a;
                iaVar.setProducer(new C14773d(iaVar, this.f43500d));
            } else if (this.f43498b) {
                C14980ia<? super T> iaVar2 = this.f43497a;
                iaVar2.setProducer(new C14773d(iaVar2, this.f43499c));
            } else {
                this.f43497a.onError(new NoSuchElementException("Sequence contains no elements"));
            }
        }

        public void onError(Throwable e) {
            if (this.f43502f) {
                C14948s.m46719b(e);
            } else {
                this.f43497a.onError(e);
            }
        }
    }

    /* renamed from: a */
    public static <T> C14602La<T> m46246a() {
        return C14603a.f43496a;
    }

    C14602La() {
        this(false, null);
    }

    public C14602La(T defaultValue) {
        this(true, defaultValue);
    }

    private C14602La(boolean hasDefaultValue, T defaultValue) {
        this.f43494a = hasDefaultValue;
        this.f43495b = defaultValue;
    }

    /* renamed from: a */
    public C14980ia<? super T> call(C14980ia<? super T> child) {
        ParentSubscriber<T> parent = new C14604b<>(child, this.f43494a, this.f43495b);
        child.add(parent);
        return parent;
    }
}
