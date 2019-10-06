package p026rx.p399e;

import java.util.Arrays;
import java.util.Collection;
import p026rx.C0125T;
import p026rx.C14980ia;
import p026rx.exceptions.C14927a;
import p026rx.exceptions.CompositeException;
import p026rx.exceptions.OnErrorFailedException;
import p026rx.exceptions.OnErrorNotImplementedException;
import p026rx.exceptions.UnsubscribeFailedException;
import p026rx.p400f.C14948s;
import p026rx.p400f.C14953x;

/* renamed from: rx.e.d */
/* compiled from: SafeSubscriber */
public class C14914d<T> extends C14980ia<T> {

    /* renamed from: a */
    private final C14980ia<? super T> f44229a;

    /* renamed from: b */
    boolean f44230b;

    public C14914d(C14980ia<? super T> actual) {
        super(actual);
        this.f44229a = actual;
    }

    public void onCompleted() {
        if (!this.f44230b) {
            this.f44230b = true;
            try {
                this.f44229a.onCompleted();
                try {
                    unsubscribe();
                } catch (Throwable e) {
                    C14948s.m46719b(e);
                    throw new UnsubscribeFailedException(e.getMessage(), e);
                }
            } catch (Throwable e2) {
                C14948s.m46719b(e2);
                throw new UnsubscribeFailedException(e2.getMessage(), e2);
            }
        }
    }

    public void onError(Throwable e) {
        C14927a.m46678c(e);
        if (!this.f44230b) {
            this.f44230b = true;
            mo46120b(e);
        }
    }

    public void onNext(T t) {
        try {
            if (!this.f44230b) {
                this.f44229a.onNext(t);
            }
        } catch (Throwable e) {
            C14927a.m46672a(e, (C0125T<?>) this);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo46120b(Throwable e) {
        C14953x.m46727c().mo46162b().mo46139a(e);
        try {
            this.f44229a.onError(e);
            try {
                unsubscribe();
            } catch (Throwable unsubscribeException) {
                C14948s.m46719b(unsubscribeException);
                throw new OnErrorFailedException(unsubscribeException);
            }
        } catch (OnErrorNotImplementedException e2) {
            unsubscribe();
            throw e2;
        } catch (Throwable unsubscribeException2) {
            C14948s.m46719b(unsubscribeException2);
            throw new OnErrorNotImplementedException("Observer.onError not implemented and error while unsubscribing.", new CompositeException((Collection<? extends Throwable>) Arrays.asList(new Throwable[]{e, unsubscribeException2})));
        }
    }
}
