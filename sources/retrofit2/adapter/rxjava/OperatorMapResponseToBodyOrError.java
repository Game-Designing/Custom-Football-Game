package retrofit2.adapter.rxjava;

import p026rx.C0120S.C0123b;
import p026rx.C14980ia;
import retrofit2.Response;

final class OperatorMapResponseToBodyOrError<T> implements C0123b<T, Response<T>> {
    private static final OperatorMapResponseToBodyOrError<Object> INSTANCE = new OperatorMapResponseToBodyOrError<>();

    OperatorMapResponseToBodyOrError() {
    }

    static <R> OperatorMapResponseToBodyOrError<R> instance() {
        return INSTANCE;
    }

    public C14980ia<? super Response<T>> call(final C14980ia<? super T> child) {
        return new C14980ia<Response<T>>(child) {
            public void onNext(Response<T> response) {
                if (response.isSuccessful()) {
                    child.onNext(response.body());
                } else {
                    child.onError(new HttpException(response));
                }
            }

            public void onCompleted() {
                child.onCompleted();
            }

            public void onError(Throwable e) {
                child.onError(e);
            }
        };
    }
}
