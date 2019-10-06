package retrofit2.adapter.rxjava;

import java.lang.reflect.Type;
import p026rx.C0120S;
import p026rx.Single;
import retrofit2.Call;
import retrofit2.CallAdapter;

final class SingleHelper {
    SingleHelper() {
    }

    static CallAdapter<Single<?>> makeSingle(final CallAdapter<C0120S<?>> callAdapter) {
        return new CallAdapter<Single<?>>() {
            public Type responseType() {
                return callAdapter.responseType();
            }

            public <R> Single<?> adapt(Call<R> call) {
                return ((C0120S) callAdapter.adapt(call)).mo3678n();
            }
        };
    }
}
