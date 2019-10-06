package p026rx;

import java.util.concurrent.Callable;
import p026rx.Single.C0124a;
import p026rx.exceptions.C14927a;

/* renamed from: rx.ba */
/* compiled from: Single */
class C14550ba implements C0124a<T> {

    /* renamed from: a */
    final /* synthetic */ Callable f43356a;

    C14550ba(Callable callable) {
        this.f43356a = callable;
    }

    /* renamed from: a */
    public void call(C14972ha<? super T> singleSubscriber) {
        try {
            ((Single) this.f43356a.call()).mo3691a(singleSubscriber);
        } catch (Throwable t) {
            C14927a.m46678c(t);
            singleSubscriber.onError(t);
        }
    }
}
