package retrofit2.adapter.rxjava2;

import java.lang.reflect.Type;
import p320f.p321a.C13184a;
import p320f.p321a.C13797m;
import p320f.p321a.C13805u;
import retrofit2.Call;
import retrofit2.CallAdapter;

final class RxJava2CallAdapter<R> implements CallAdapter<R, Object> {
    private final boolean isAsync;
    private final boolean isBody;
    private final boolean isCompletable;
    private final boolean isFlowable;
    private final boolean isMaybe;
    private final boolean isResult;
    private final boolean isSingle;
    private final Type responseType;
    private final C13805u scheduler;

    RxJava2CallAdapter(Type responseType2, C13805u scheduler2, boolean isAsync2, boolean isResult2, boolean isBody2, boolean isFlowable2, boolean isSingle2, boolean isMaybe2, boolean isCompletable2) {
        this.responseType = responseType2;
        this.scheduler = scheduler2;
        this.isAsync = isAsync2;
        this.isResult = isResult2;
        this.isBody = isBody2;
        this.isFlowable = isFlowable2;
        this.isSingle = isSingle2;
        this.isMaybe = isMaybe2;
        this.isCompletable = isCompletable2;
    }

    public Type responseType() {
        return this.responseType;
    }

    public Object adapt(Call<R> call) {
        C13797m mVar;
        C13797m mVar2;
        if (this.isAsync) {
            mVar = new CallEnqueueObservable(call);
        } else {
            mVar = new CallExecuteObservable(call);
        }
        if (this.isResult) {
            mVar2 = new ResultObservable(mVar);
        } else if (this.isBody) {
            mVar2 = new BodyObservable(mVar);
        } else {
            mVar2 = mVar;
        }
        C13805u uVar = this.scheduler;
        if (uVar != null) {
            mVar2 = mVar2.subscribeOn(uVar);
        }
        if (this.isFlowable) {
            return mVar2.toFlowable(C13184a.LATEST);
        }
        if (this.isSingle) {
            return mVar2.singleOrError();
        }
        if (this.isMaybe) {
            return mVar2.singleElement();
        }
        if (this.isCompletable) {
            return mVar2.ignoreElements();
        }
        return mVar2;
    }
}
