package p005cm.aptoide.analytics.implementation.network;

import p026rx.Single;

/* renamed from: cm.aptoide.analytics.implementation.network.AnalyticsBodyInterceptor */
public interface AnalyticsBodyInterceptor<T> {
    Single<T> intercept(T t);
}
