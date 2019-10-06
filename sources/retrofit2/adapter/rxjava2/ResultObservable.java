package retrofit2.adapter.rxjava2;

import p024io.reactivex.exceptions.C13980a;
import p024io.reactivex.exceptions.CompositeException;
import p320f.p321a.C13797m;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p343g.C13774a;
import retrofit2.Response;

final class ResultObservable<T> extends C13797m<Result<T>> {
    private final C13797m<Response<T>> upstream;

    private static class ResultObserver<R> implements C13804t<Response<R>> {
        private final C13804t<? super Result<R>> observer;

        ResultObserver(C13804t<? super Result<R>> observer2) {
            this.observer = observer2;
        }

        public void onSubscribe(C13194b disposable) {
            this.observer.onSubscribe(disposable);
        }

        public void onNext(Response<R> response) {
            this.observer.onNext(Result.response(response));
        }

        public void onError(Throwable throwable) {
            try {
                this.observer.onNext(Result.error(throwable));
                this.observer.onComplete();
            } catch (Throwable inner) {
                C13980a.m44462b(inner);
                C13774a.m43836b((Throwable) new CompositeException(t, inner));
            }
        }

        public void onComplete() {
            this.observer.onComplete();
        }
    }

    ResultObservable(C13797m<Response<T>> upstream2) {
        this.upstream = upstream2;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(C13804t<? super Result<T>> observer) {
        this.upstream.subscribe((C13804t<? super T>) new ResultObserver<Object>(observer));
    }
}
