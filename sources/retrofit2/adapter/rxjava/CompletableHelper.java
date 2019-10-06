package retrofit2.adapter.rxjava;

import java.lang.reflect.Type;
import p026rx.C0117M;
import p026rx.C0126V;
import p026rx.C0137ja;
import p026rx.exceptions.C14927a;
import p026rx.p027b.C0128a;
import p026rx.p029i.C14978f;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Response;
import rx.Completable.CompletableOnSubscribe;
import rx.Completable.CompletableSubscriber;

final class CompletableHelper {

    static class CompletableCallAdapter implements CallAdapter<C0117M> {
        private final C0126V scheduler;

        CompletableCallAdapter(C0126V scheduler2) {
            this.scheduler = scheduler2;
        }

        public Type responseType() {
            return Void.class;
        }

        public C0117M adapt(Call call) {
            C0117M completable = C0117M.create(new CompletableCallOnSubscribe(call));
            C0126V v = this.scheduler;
            if (v != null) {
                return completable.mo3593b(v);
            }
            return completable;
        }
    }

    private static final class CompletableCallOnSubscribe implements CompletableOnSubscribe {
        private final Call originalCall;

        CompletableCallOnSubscribe(Call originalCall2) {
            this.originalCall = originalCall2;
        }

        public void call(CompletableSubscriber subscriber) {
            final Call call = this.originalCall.clone();
            C0137ja subscription = C14978f.m46781a(new C0128a() {
                public void call() {
                    call.cancel();
                }
            });
            subscriber.onSubscribe(subscription);
            try {
                Response response = call.execute();
                if (subscription.isUnsubscribed()) {
                    return;
                }
                if (response.isSuccessful()) {
                    subscriber.onCompleted();
                } else {
                    subscriber.onError(new HttpException(response));
                }
            } catch (Throwable t) {
                C14927a.m46678c(t);
                if (!subscription.isUnsubscribed()) {
                    subscriber.onError(t);
                }
            }
        }
    }

    CompletableHelper() {
    }

    static CallAdapter<C0117M> createCallAdapter(C0126V scheduler) {
        return new CompletableCallAdapter(scheduler);
    }
}
