package retrofit2.adapter.rxjava2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import p320f.p321a.C13192b;
import p320f.p321a.C13764f;
import p320f.p321a.C13775h;
import p320f.p321a.C13797m;
import p320f.p321a.C13805u;
import p320f.p321a.C13810v;
import retrofit2.CallAdapter;
import retrofit2.CallAdapter.Factory;
import retrofit2.Response;
import retrofit2.Retrofit;

public final class RxJava2CallAdapterFactory extends Factory {
    private final boolean isAsync;
    private final C13805u scheduler;

    public static RxJava2CallAdapterFactory create() {
        return new RxJava2CallAdapterFactory(null, false);
    }

    public static RxJava2CallAdapterFactory createAsync() {
        return new RxJava2CallAdapterFactory(null, true);
    }

    public static RxJava2CallAdapterFactory createWithScheduler(C13805u scheduler2) {
        if (scheduler2 != null) {
            return new RxJava2CallAdapterFactory(scheduler2, false);
        }
        throw new NullPointerException("scheduler == null");
    }

    private RxJava2CallAdapterFactory(C13805u scheduler2, boolean isAsync2) {
        this.scheduler = scheduler2;
        this.isAsync = isAsync2;
    }

    public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
        boolean isBody;
        boolean isResult;
        Type responseType;
        Type type = returnType;
        Class<?> rawType = Factory.getRawType(returnType);
        if (rawType == C13192b.class) {
            RxJava2CallAdapter rxJava2CallAdapter = new RxJava2CallAdapter(Void.class, this.scheduler, this.isAsync, false, true, false, false, false, true);
            return rxJava2CallAdapter;
        }
        boolean isMaybe = true;
        boolean isFlowable = rawType == C13764f.class;
        boolean isSingle = rawType == C13810v.class;
        if (rawType != C13775h.class) {
            isMaybe = false;
        }
        if (rawType != C13797m.class && !isFlowable && !isSingle && !isMaybe) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            String name = !isFlowable ? !isSingle ? isMaybe ? "Maybe" : "Observable" : "Single" : "Flowable";
            StringBuilder sb = new StringBuilder();
            sb.append(name);
            sb.append(" return type must be parameterized as ");
            sb.append(name);
            sb.append("<Foo> or ");
            sb.append(name);
            sb.append("<? extends Foo>");
            throw new IllegalStateException(sb.toString());
        }
        Type observableType = Factory.getParameterUpperBound(0, (ParameterizedType) type);
        Class<?> rawObservableType = Factory.getRawType(observableType);
        if (rawObservableType == Response.class) {
            if (observableType instanceof ParameterizedType) {
                responseType = Factory.getParameterUpperBound(0, (ParameterizedType) observableType);
                isResult = false;
                isBody = false;
            } else {
                throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
            }
        } else if (rawObservableType != Result.class) {
            responseType = observableType;
            isResult = false;
            isBody = true;
        } else if (observableType instanceof ParameterizedType) {
            responseType = Factory.getParameterUpperBound(0, (ParameterizedType) observableType);
            isResult = true;
            isBody = false;
        } else {
            throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
        }
        Class cls = rawObservableType;
        Type type2 = observableType;
        RxJava2CallAdapter rxJava2CallAdapter2 = new RxJava2CallAdapter(responseType, this.scheduler, this.isAsync, isResult, isBody, isFlowable, isSingle, isMaybe, false);
        return rxJava2CallAdapter2;
    }
}
