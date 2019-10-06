package com.mopub.volley;

import android.os.Handler;
import java.util.concurrent.Executor;

public class ExecutorDelivery implements ResponseDelivery {

    /* renamed from: a */
    private final Executor f36421a;

    /* renamed from: com.mopub.volley.ExecutorDelivery$a */
    private static class C11682a implements Runnable {

        /* renamed from: a */
        private final Request f36422a;

        /* renamed from: b */
        private final Response f36423b;

        /* renamed from: c */
        private final Runnable f36424c;

        public C11682a(Request request, Response response, Runnable runnable) {
            this.f36422a = request;
            this.f36423b = response;
            this.f36424c = runnable;
        }

        public void run() {
            if (this.f36422a.isCanceled()) {
                this.f36422a.mo38379a("canceled-at-delivery");
                return;
            }
            if (this.f36423b.isSuccess()) {
                this.f36422a.deliverResponse(this.f36423b.result);
            } else {
                this.f36422a.deliverError(this.f36423b.error);
            }
            if (this.f36423b.intermediate) {
                this.f36422a.addMarker("intermediate-response");
            } else {
                this.f36422a.mo38379a("done");
            }
            Runnable runnable = this.f36424c;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public ExecutorDelivery(Handler handler) {
        this.f36421a = new C11687b(this, handler);
    }

    public ExecutorDelivery(Executor executor) {
        this.f36421a = executor;
    }

    public void postResponse(Request<?> request, Response<?> response) {
        postResponse(request, response, null);
    }

    public void postResponse(Request<?> request, Response<?> response, Runnable runnable) {
        request.markDelivered();
        request.addMarker("post-response");
        this.f36421a.execute(new C11682a(request, response, runnable));
    }

    public void postError(Request<?> request, VolleyError error) {
        request.addMarker("post-error");
        this.f36421a.execute(new C11682a(request, Response.error(error), null));
    }
}
