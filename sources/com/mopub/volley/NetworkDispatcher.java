package com.mopub.volley;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Build.VERSION;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

public class NetworkDispatcher extends Thread {

    /* renamed from: a */
    private final BlockingQueue<Request<?>> f36427a;

    /* renamed from: b */
    private final Network f36428b;

    /* renamed from: c */
    private final Cache f36429c;

    /* renamed from: d */
    private final ResponseDelivery f36430d;

    /* renamed from: e */
    private volatile boolean f36431e = false;

    public NetworkDispatcher(BlockingQueue<Request<?>> queue, Network network, Cache cache, ResponseDelivery delivery) {
        this.f36427a = queue;
        this.f36428b = network;
        this.f36429c = cache;
        this.f36430d = delivery;
    }

    public void quit() {
        this.f36431e = true;
        interrupt();
    }

    @TargetApi(14)
    /* renamed from: b */
    private void m38581b(Request<?> request) {
        if (VERSION.SDK_INT >= 14) {
            TrafficStats.setThreadStatsTag(request.getTrafficStatsTag());
        }
    }

    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                m38579a();
            } catch (InterruptedException e) {
                if (this.f36431e) {
                    Thread.currentThread().interrupt();
                    return;
                } else {
                    VolleyLog.m38604e("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
                }
            }
        }
    }

    /* renamed from: a */
    private void m38579a() throws InterruptedException {
        mo38372a((Request) this.f36427a.take());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo38372a(Request<?> request) {
        long startTimeMs = SystemClock.elapsedRealtime();
        request.mo38376a(3);
        try {
            request.addMarker("network-queue-take");
            if (request.isCanceled()) {
                request.mo38379a("network-discard-cancelled");
                request.mo38402j();
                request.mo38376a(4);
                return;
            }
            m38581b(request);
            NetworkResponse networkResponse = this.f36428b.performRequest(request);
            request.addMarker("network-http-complete");
            if (!networkResponse.notModified || !request.hasHadResponseDelivered()) {
                Response<?> response = request.mo36680a(networkResponse);
                request.addMarker("network-parse-complete");
                if (request.shouldCache() && response.cacheEntry != null) {
                    this.f36429c.put(request.getCacheKey(), response.cacheEntry);
                    request.addMarker("network-cache-written");
                }
                request.markDelivered();
                this.f36430d.postResponse(request, response);
                request.mo38378a(response);
                request.mo38376a(4);
                return;
            }
            request.mo38379a("not-modified");
            request.mo38402j();
            request.mo38376a(4);
        } catch (VolleyError volleyError) {
            volleyError.mo38428a(SystemClock.elapsedRealtime() - startTimeMs);
            m38580a(request, volleyError);
            request.mo38402j();
        } catch (Exception e) {
            VolleyLog.m38605e(e, "Unhandled exception %s", e.toString());
            VolleyError volleyError2 = new VolleyError((Throwable) e);
            volleyError2.mo38428a(SystemClock.elapsedRealtime() - startTimeMs);
            this.f36430d.postError(request, volleyError2);
            request.mo38402j();
        } catch (Throwable th) {
            request.mo38376a(4);
            throw th;
        }
    }

    /* renamed from: a */
    private void m38580a(Request<?> request, VolleyError error) {
        this.f36430d.postError(request, request.mo38375a(error));
    }
}
