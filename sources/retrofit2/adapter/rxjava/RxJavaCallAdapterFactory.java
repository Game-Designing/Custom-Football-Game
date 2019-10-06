package retrofit2.adapter.rxjava;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicBoolean;
import p026rx.C0120S;
import p026rx.C0120S.C0122a;
import p026rx.C0120S.C0123b;
import p026rx.C0126V;
import p026rx.C0137ja;
import p026rx.C14508U;
import p026rx.C14980ia;
import p026rx.exceptions.C14927a;
import p026rx.p027b.C0132p;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.CallAdapter.Factory;
import retrofit2.Response;
import retrofit2.Retrofit;
import rx.Observable;

public final class RxJavaCallAdapterFactory extends Factory {
    private final C0126V scheduler;

    static final class CallOnSubscribe<T> implements C0122a<Response<T>> {
        private final Call<T> originalCall;

        CallOnSubscribe(Call<T> originalCall2) {
            this.originalCall = originalCall2;
        }

        public void call(C14980ia<? super Response<T>> subscriber) {
            RequestArbiter<T> requestArbiter = new RequestArbiter<>(this.originalCall.clone(), subscriber);
            subscriber.add(requestArbiter);
            subscriber.setProducer(requestArbiter);
        }
    }

    static final class RequestArbiter<T> extends AtomicBoolean implements C0137ja, C14508U {
        private final Call<T> call;
        private final C14980ia<? super Response<T>> subscriber;

        RequestArbiter(Call<T> call2, C14980ia<? super Response<T>> subscriber2) {
            this.call = call2;
            this.subscriber = subscriber2;
        }

        public void request(long n) {
            if (n < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("n < 0: ");
                sb.append(n);
                throw new IllegalArgumentException(sb.toString());
            } else if (n != 0 && compareAndSet(false, true)) {
                try {
                    Response<T> response = this.call.execute();
                    if (!this.subscriber.isUnsubscribed()) {
                        this.subscriber.onNext(response);
                    }
                    if (!this.subscriber.isUnsubscribed()) {
                        this.subscriber.onCompleted();
                    }
                } catch (Throwable t) {
                    C14927a.m46678c(t);
                    if (!this.subscriber.isUnsubscribed()) {
                        this.subscriber.onError(t);
                    }
                }
            }
        }

        public void unsubscribe() {
            this.call.cancel();
        }

        public boolean isUnsubscribed() {
            return this.call.isCanceled();
        }
    }

    static final class ResponseCallAdapter implements CallAdapter<C0120S<?>> {
        private final Type responseType;
        private final C0126V scheduler;

        ResponseCallAdapter(Type responseType2, C0126V scheduler2) {
            this.responseType = responseType2;
            this.scheduler = scheduler2;
        }

        public Type responseType() {
            return this.responseType;
        }

        public <R> C0120S<Response<R>> adapt(Call<R> call) {
            Observable<Response<R>> observable = C0120S.m634a((C0122a<T>) new CallOnSubscribe<T>(call));
            C0126V v = this.scheduler;
            if (v != null) {
                return observable.mo3634b(v);
            }
            return observable;
        }
    }

    static final class ResultCallAdapter implements CallAdapter<C0120S<?>> {
        private final Type responseType;
        private final C0126V scheduler;

        ResultCallAdapter(Type responseType2, C0126V scheduler2) {
            this.responseType = responseType2;
            this.scheduler = scheduler2;
        }

        public Type responseType() {
            return this.responseType;
        }

        public <R> C0120S<Result<R>> adapt(Call<R> call) {
            Observable<Result<R>> observable = C0120S.m634a((C0122a<T>) new CallOnSubscribe<T>(call)).mo3669j(new C0132p<Response<R>, Result<R>>() {
                public Result<R> call(Response<R> response) {
                    return Result.response(response);
                }
            }).mo3674l(new C0132p<Throwable, Result<R>>() {
                public Result<R> call(Throwable throwable) {
                    return Result.error(throwable);
                }
            });
            C0126V v = this.scheduler;
            if (v != null) {
                return observable.mo3634b(v);
            }
            return observable;
        }
    }

    static final class SimpleCallAdapter implements CallAdapter<C0120S<?>> {
        private final Type responseType;
        private final C0126V scheduler;

        SimpleCallAdapter(Type responseType2, C0126V scheduler2) {
            this.responseType = responseType2;
            this.scheduler = scheduler2;
        }

        public Type responseType() {
            return this.responseType;
        }

        public <R> C0120S<R> adapt(Call<R> call) {
            Observable<R> observable = C0120S.m634a((C0122a<T>) new CallOnSubscribe<T>(call)).mo3613a((C0123b<? extends R, ? super T>) OperatorMapResponseToBodyOrError.instance());
            C0126V v = this.scheduler;
            if (v != null) {
                return observable.mo3634b(v);
            }
            return observable;
        }
    }

    public static RxJavaCallAdapterFactory create() {
        return new RxJavaCallAdapterFactory(null);
    }

    public static RxJavaCallAdapterFactory createWithScheduler(C0126V scheduler2) {
        if (scheduler2 != null) {
            return new RxJavaCallAdapterFactory(scheduler2);
        }
        throw new NullPointerException("scheduler == null");
    }

    private RxJavaCallAdapterFactory(C0126V scheduler2) {
        this.scheduler = scheduler2;
    }

    public CallAdapter<?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
        Class<?> rawType = Factory.getRawType(returnType);
        String canonicalName = rawType.getCanonicalName();
        boolean isSingle = "rx.Single".equals(canonicalName);
        boolean isCompletable = "rx.Completable".equals(canonicalName);
        if (rawType != C0120S.class && !isSingle && !isCompletable) {
            return null;
        }
        if (!isCompletable && !(returnType instanceof ParameterizedType)) {
            String name = isSingle ? "Single" : "Observable";
            StringBuilder sb = new StringBuilder();
            sb.append(name);
            sb.append(" return type must be parameterized as ");
            sb.append(name);
            sb.append("<Foo> or ");
            sb.append(name);
            sb.append("<? extends Foo>");
            throw new IllegalStateException(sb.toString());
        } else if (isCompletable) {
            return CompletableHelper.createCallAdapter(this.scheduler);
        } else {
            CallAdapter<Observable<?>> callAdapter = getCallAdapter(returnType, this.scheduler);
            if (isSingle) {
                return SingleHelper.makeSingle(callAdapter);
            }
            return callAdapter;
        }
    }

    private CallAdapter<C0120S<?>> getCallAdapter(Type returnType, C0126V scheduler2) {
        Type observableType = Factory.getParameterUpperBound(0, (ParameterizedType) returnType);
        Class<?> rawObservableType = Factory.getRawType(observableType);
        if (rawObservableType == Response.class) {
            if (observableType instanceof ParameterizedType) {
                return new ResponseCallAdapter(Factory.getParameterUpperBound(0, (ParameterizedType) observableType), scheduler2);
            }
            throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
        } else if (rawObservableType != Result.class) {
            return new SimpleCallAdapter(observableType, scheduler2);
        } else {
            if (observableType instanceof ParameterizedType) {
                return new ResultCallAdapter(Factory.getParameterUpperBound(0, (ParameterizedType) observableType), scheduler2);
            }
            throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
        }
    }
}
