package retrofit2.adapter.rxjava2;

import p024io.reactivex.exceptions.C13980a;
import p024io.reactivex.exceptions.CompositeException;
import p320f.p321a.C13797m;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p343g.C13774a;
import retrofit2.Call;
import retrofit2.Response;

final class CallExecuteObservable<T> extends C13797m<Response<T>> {
    private final Call<T> originalCall;

    private static final class CallDisposable implements C13194b {
        private final Call<?> call;
        private volatile boolean disposed;

        CallDisposable(Call<?> call2) {
            this.call = call2;
        }

        public void dispose() {
            this.disposed = true;
            this.call.cancel();
        }

        public boolean isDisposed() {
            return this.disposed;
        }
    }

    CallExecuteObservable(Call<T> originalCall2) {
        this.originalCall = originalCall2;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(C13804t<? super Response<T>> observer) {
        Call<T> call = this.originalCall.clone();
        CallDisposable disposable = new CallDisposable(call);
        observer.onSubscribe(disposable);
        try {
            Response<T> response = call.execute();
            if (!disposable.isDisposed()) {
                observer.onNext(response);
            }
            if (!disposable.isDisposed()) {
                observer.onComplete();
            }
        } catch (Throwable inner) {
            C13980a.m44462b(inner);
            C13774a.m43836b((Throwable) new CompositeException(t, inner));
        }
    }
}
