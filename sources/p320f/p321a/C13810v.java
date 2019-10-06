package p320f.p321a;

import io.reactivex.SingleObserver;
import io.reactivex.internal.observers.BlockingMultiObserver;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.p326c.C13201c;
import p320f.p321a.p326c.C13204f;
import p320f.p321a.p326c.C13212n;
import p320f.p321a.p327d.p329b.C13226a;
import p320f.p321a.p327d.p329b.C13264b;
import p320f.p321a.p327d.p330c.C13266a;
import p320f.p321a.p327d.p331d.C13281g;
import p320f.p321a.p327d.p332e.p335c.C13686a;
import p320f.p321a.p327d.p332e.p335c.C13688b;
import p320f.p321a.p327d.p332e.p335c.C13690c;
import p320f.p321a.p327d.p332e.p335c.C13691d;
import p320f.p321a.p327d.p332e.p335c.C13693e;
import p320f.p321a.p327d.p332e.p335c.C13695f;
import p320f.p321a.p327d.p332e.p335c.C13697g;
import p320f.p321a.p327d.p332e.p335c.C13699h;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.v */
/* compiled from: Single */
public abstract class C13810v<T> implements C13814z<T> {
    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo42365b(C13812x<? super T> xVar);

    /* renamed from: a */
    public static <T> C13810v<T> m43897a(C13813y<T> source) {
        C13264b.m43226a(source, "source is null");
        return C13774a.m43826a((C13810v<T>) new C13686a<T>(source));
    }

    /* renamed from: a */
    public static <T> C13810v<T> m43900a(Callable<? extends Throwable> errorSupplier) {
        C13264b.m43226a(errorSupplier, "errorSupplier is null");
        return C13774a.m43826a((C13810v<T>) new C13690c<T>(errorSupplier));
    }

    /* renamed from: a */
    public static <T> C13810v<T> m43899a(Throwable exception) {
        C13264b.m43226a(exception, "error is null");
        return m43900a(C13226a.m43196b(exception));
    }

    /* renamed from: a */
    public static <T1, T2, R> C13810v<R> m43898a(C13814z<? extends T1> source1, C13814z<? extends T2> source2, C13201c<? super T1, ? super T2, ? extends R> zipper) {
        C13264b.m43226a(source1, "source1 is null");
        C13264b.m43226a(source2, "source2 is null");
        return m43896a(C13226a.m43178a(zipper), source1, source2);
    }

    /* renamed from: a */
    public static <T, R> C13810v<R> m43896a(C13212n<? super Object[], ? extends R> zipper, C13814z<? extends T>... sources) {
        C13264b.m43226a(zipper, "zipper is null");
        C13264b.m43226a(sources, "sources is null");
        if (sources.length == 0) {
            return m43899a((Throwable) new NoSuchElementException());
        }
        return C13774a.m43826a((C13810v<T>) new C13699h<T>(sources, zipper));
    }

    /* renamed from: a */
    public final C13810v<T> mo43153a(C13204f<? super T> onSuccess) {
        C13264b.m43226a(onSuccess, "onSuccess is null");
        return C13774a.m43826a((C13810v<T>) new C13688b<T>(this, onSuccess));
    }

    /* renamed from: b */
    public final T mo43158b() {
        BlockingMultiObserver<T> observer = new C13281g<>();
        mo43156a((C13812x<? super T>) observer);
        return observer.mo42323a();
    }

    /* renamed from: a */
    public final <R> C13810v<R> mo43154a(C13212n<? super T, ? extends R> mapper) {
        C13264b.m43226a(mapper, "mapper is null");
        return C13774a.m43826a((C13810v<T>) new C13691d<T>(this, mapper));
    }

    /* renamed from: a */
    public final C13810v<T> mo43155a(C13805u scheduler) {
        C13264b.m43226a(scheduler, "scheduler is null");
        return C13774a.m43826a((C13810v<T>) new C13693e<T>(this, scheduler));
    }

    /* renamed from: a */
    public final void mo43156a(C13812x<? super T> subscriber) {
        C13264b.m43226a(subscriber, "subscriber is null");
        SingleObserver<? super T> subscriber2 = C13774a.m43827a(this, subscriber);
        C13264b.m43226a(subscriber2, "subscriber returned by the RxJavaPlugins hook is null");
        try {
            mo42365b((C13812x<? super T>) subscriber2);
        } catch (NullPointerException ex) {
            throw ex;
        } catch (Throwable ex2) {
            C13980a.m44462b(ex2);
            NullPointerException npe = new NullPointerException("subscribeActual failed");
            npe.initCause(ex2);
            throw npe;
        }
    }

    /* renamed from: b */
    public final C13810v<T> mo43157b(C13805u scheduler) {
        C13264b.m43226a(scheduler, "scheduler is null");
        return C13774a.m43826a((C13810v<T>) new C13695f<T>(this, scheduler));
    }

    /* renamed from: c */
    public final C13797m<T> mo43159c() {
        if (this instanceof C13266a) {
            return ((C13266a) this).mo42316a();
        }
        return C13774a.m43821a((C13797m<T>) new C13697g<T>(this));
    }
}
