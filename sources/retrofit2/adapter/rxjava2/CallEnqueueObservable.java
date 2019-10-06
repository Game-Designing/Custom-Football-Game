package retrofit2.adapter.rxjava2;

import p024io.reactivex.exceptions.C13980a;
import p024io.reactivex.exceptions.CompositeException;
import p320f.p321a.C13797m;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p343g.C13774a;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

final class CallEnqueueObservable<T> extends C13797m<Response<T>> {
    private final Call<T> originalCall;

    private static final class CallCallback<T> implements C13194b, Callback<T> {
        private final Call<?> call;
        private volatile boolean disposed;
        private final C13804t<? super Response<T>> observer;
        boolean terminated = false;

        CallCallback(Call<?> call2, C13804t<? super Response<T>> observer2) {
            this.call = call2;
            this.observer = observer2;
        }

        public void onResponse(Call<T> call2, Response<T> response) {
            if (!this.disposed) {
                try {
                    this.observer.onNext(response);
                    if (!this.disposed) {
                        this.terminated = true;
                        this.observer.onComplete();
                    }
                } catch (Throwable inner) {
                    C13980a.m44462b(inner);
                    C13774a.m43836b((Throwable) new CompositeException(t, inner));
                }
            }
        }

        public void onFailure(Call<T> call2, Throwable t) {
            if (!call2.isCanceled()) {
                try {
                    this.observer.onError(t);
                } catch (Throwable inner) {
                    C13980a.m44462b(inner);
                    C13774a.m43836b((Throwable) new CompositeException(t, inner));
                }
            }
        }

        public void dispose() {
            this.disposed = true;
            this.call.cancel();
        }

        public boolean isDisposed() {
            return this.disposed;
        }
    }

    CallEnqueueObservable(Call<T> originalCall2) {
        this.originalCall = originalCall2;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(C13804t<? super Response<T>> observer) {
        Call<T> call = this.originalCall.clone();
        CallCallback<T> callback = new CallCallback<>(call, observer);
        observer.onSubscribe(callback);
        call.enqueue(callback);
    }
}
