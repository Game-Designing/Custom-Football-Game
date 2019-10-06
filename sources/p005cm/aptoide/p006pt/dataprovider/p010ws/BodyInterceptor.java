package p005cm.aptoide.p006pt.dataprovider.p010ws;

import p026rx.Single;

/* renamed from: cm.aptoide.pt.dataprovider.ws.BodyInterceptor */
public interface BodyInterceptor<T> {
    Single<T> intercept(T t);
}
