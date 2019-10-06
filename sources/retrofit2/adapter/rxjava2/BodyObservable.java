package retrofit2.adapter.rxjava2;

import p024io.reactivex.exceptions.C13980a;
import p024io.reactivex.exceptions.CompositeException;
import p320f.p321a.C13797m;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p343g.C13774a;
import retrofit2.Response;

final class BodyObservable<T> extends C13797m<T> {
    private final C13797m<Response<T>> upstream;

    private static class BodyObserver<R> implements C13804t<Response<R>> {
        private final C13804t<? super R> observer;
        private boolean terminated;

        BodyObserver(C13804t<? super R> observer2) {
            this.observer = observer2;
        }

        public void onSubscribe(C13194b disposable) {
            this.observer.onSubscribe(disposable);
        }

        public void onNext(Response<R> response) {
            if (response.isSuccessful()) {
                this.observer.onNext(response.body());
                return;
            }
            this.terminated = true;
            Throwable t = new HttpException(response);
            try {
                this.observer.onError(t);
            } catch (Throwable inner) {
                C13980a.m44462b(inner);
                C13774a.m43836b((Throwable) new CompositeException(t, inner));
            }
        }

        public void onComplete() {
            if (!this.terminated) {
                this.observer.onComplete();
            }
        }

        public void onError(Throwable throwable) {
            if (!this.terminated) {
                this.observer.onError(throwable);
                return;
            }
            Throwable broken = new AssertionError("This should never happen! Report as a bug with the full stacktrace.");
            broken.initCause(throwable);
            C13774a.m43836b(broken);
        }
    }

    BodyObservable(C13797m<Response<T>> upstream2) {
        this.upstream = upstream2;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(C13804t<? super T> observer) {
        this.upstream.subscribe((C13804t<? super T>) new BodyObserver<Object>(observer));
    }
}
