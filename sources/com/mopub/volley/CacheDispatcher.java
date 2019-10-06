package com.mopub.volley;

import android.os.Process;
import com.mopub.volley.Cache.Entry;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

public class CacheDispatcher extends Thread {

    /* renamed from: a */
    private static final boolean f36408a = VolleyLog.DEBUG;

    /* renamed from: b */
    private final BlockingQueue<Request<?>> f36409b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final BlockingQueue<Request<?>> f36410c;

    /* renamed from: d */
    private final Cache f36411d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final ResponseDelivery f36412e;

    /* renamed from: f */
    private volatile boolean f36413f = false;

    /* renamed from: g */
    private final C11681a f36414g;

    /* renamed from: com.mopub.volley.CacheDispatcher$a */
    private static class C11681a implements C11683a {

        /* renamed from: a */
        private final Map<String, List<Request<?>>> f36415a = new HashMap();

        /* renamed from: b */
        private final CacheDispatcher f36416b;

        C11681a(CacheDispatcher cacheDispatcher) {
            this.f36416b = cacheDispatcher;
        }

        public void onResponseReceived(Request<?> request, Response<?> response) {
            List<Request<?>> waitingRequests;
            Entry entry = response.cacheEntry;
            if (entry == null || entry.isExpired()) {
                onNoUsableResponseReceived(request);
                return;
            }
            String cacheKey = request.getCacheKey();
            synchronized (this) {
                waitingRequests = (List) this.f36415a.remove(cacheKey);
            }
            if (waitingRequests != null) {
                if (VolleyLog.DEBUG) {
                    VolleyLog.m38606v("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(waitingRequests.size()), cacheKey);
                }
                for (Request<?> waiting : waitingRequests) {
                    this.f36416b.f36412e.postResponse(waiting, response);
                }
            }
        }

        public synchronized void onNoUsableResponseReceived(Request<?> request) {
            String cacheKey = request.getCacheKey();
            List<Request<?>> waitingRequests = (List) this.f36415a.remove(cacheKey);
            if (waitingRequests != null && !waitingRequests.isEmpty()) {
                if (VolleyLog.DEBUG) {
                    VolleyLog.m38606v("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(waitingRequests.size()), cacheKey);
                }
                Request<?> nextInLine = (Request) waitingRequests.remove(0);
                this.f36415a.put(cacheKey, waitingRequests);
                nextInLine.mo38377a((C11683a) this);
                try {
                    this.f36416b.f36410c.put(nextInLine);
                } catch (InterruptedException iex) {
                    VolleyLog.m38604e("Couldn't add request to queue. %s", iex.toString());
                    Thread.currentThread().interrupt();
                    this.f36416b.quit();
                }
            }
            return;
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x003a, code lost:
            return true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0052, code lost:
            return false;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized boolean m38577a(com.mopub.volley.Request<?> r7) {
            /*
                r6 = this;
                monitor-enter(r6)
                java.lang.String r0 = r7.getCacheKey()     // Catch:{ all -> 0x0053 }
                java.util.Map<java.lang.String, java.util.List<com.mopub.volley.Request<?>>> r1 = r6.f36415a     // Catch:{ all -> 0x0053 }
                boolean r1 = r1.containsKey(r0)     // Catch:{ all -> 0x0053 }
                r2 = 1
                r3 = 0
                if (r1 == 0) goto L_0x003b
                java.util.Map<java.lang.String, java.util.List<com.mopub.volley.Request<?>>> r1 = r6.f36415a     // Catch:{ all -> 0x0053 }
                java.lang.Object r1 = r1.get(r0)     // Catch:{ all -> 0x0053 }
                java.util.List r1 = (java.util.List) r1     // Catch:{ all -> 0x0053 }
                if (r1 != 0) goto L_0x001f
                java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x0053 }
                r4.<init>()     // Catch:{ all -> 0x0053 }
                r1 = r4
            L_0x001f:
                java.lang.String r4 = "waiting-for-response"
                r7.addMarker(r4)     // Catch:{ all -> 0x0053 }
                r1.add(r7)     // Catch:{ all -> 0x0053 }
                java.util.Map<java.lang.String, java.util.List<com.mopub.volley.Request<?>>> r4 = r6.f36415a     // Catch:{ all -> 0x0053 }
                r4.put(r0, r1)     // Catch:{ all -> 0x0053 }
                boolean r4 = com.mopub.volley.VolleyLog.DEBUG     // Catch:{ all -> 0x0053 }
                if (r4 == 0) goto L_0x0039
                java.lang.String r4 = "Request for cacheKey=%s is in flight, putting on hold."
                java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch:{ all -> 0x0053 }
                r5[r3] = r0     // Catch:{ all -> 0x0053 }
                com.mopub.volley.VolleyLog.m38603d(r4, r5)     // Catch:{ all -> 0x0053 }
            L_0x0039:
                monitor-exit(r6)
                return r2
            L_0x003b:
                java.util.Map<java.lang.String, java.util.List<com.mopub.volley.Request<?>>> r1 = r6.f36415a     // Catch:{ all -> 0x0053 }
                r4 = 0
                r1.put(r0, r4)     // Catch:{ all -> 0x0053 }
                r7.mo38377a(r6)     // Catch:{ all -> 0x0053 }
                boolean r1 = com.mopub.volley.VolleyLog.DEBUG     // Catch:{ all -> 0x0053 }
                if (r1 == 0) goto L_0x0051
                java.lang.String r1 = "new request, sending to network %s"
                java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0053 }
                r2[r3] = r0     // Catch:{ all -> 0x0053 }
                com.mopub.volley.VolleyLog.m38603d(r1, r2)     // Catch:{ all -> 0x0053 }
            L_0x0051:
                monitor-exit(r6)
                return r3
            L_0x0053:
                r7 = move-exception
                monitor-exit(r6)
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mopub.volley.CacheDispatcher.C11681a.m38577a(com.mopub.volley.Request):boolean");
        }
    }

    public CacheDispatcher(BlockingQueue<Request<?>> cacheQueue, BlockingQueue<Request<?>> networkQueue, Cache cache, ResponseDelivery delivery) {
        this.f36409b = cacheQueue;
        this.f36410c = networkQueue;
        this.f36411d = cache;
        this.f36412e = delivery;
        this.f36414g = new C11681a(this);
    }

    public void quit() {
        this.f36413f = true;
        interrupt();
    }

    public void run() {
        if (f36408a) {
            VolleyLog.m38606v("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.f36411d.initialize();
        while (true) {
            try {
                m38573a();
            } catch (InterruptedException e) {
                if (this.f36413f) {
                    Thread.currentThread().interrupt();
                    return;
                } else {
                    VolleyLog.m38604e("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
                }
            }
        }
    }

    /* renamed from: a */
    private void m38573a() throws InterruptedException {
        mo38352a((Request) this.f36409b.take());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo38352a(Request<?> request) throws InterruptedException {
        request.addMarker("cache-queue-take");
        request.mo38376a(1);
        try {
            if (request.isCanceled()) {
                request.mo38379a("cache-discard-canceled");
                return;
            }
            Entry entry = this.f36411d.get(request.getCacheKey());
            if (entry == null) {
                request.addMarker("cache-miss");
                if (!this.f36414g.m38577a(request)) {
                    this.f36410c.put(request);
                }
                request.mo38376a(2);
            } else if (entry.isExpired()) {
                request.addMarker("cache-hit-expired");
                request.setCacheEntry(entry);
                if (!this.f36414g.m38577a(request)) {
                    this.f36410c.put(request);
                }
                request.mo38376a(2);
            } else {
                request.addMarker("cache-hit");
                Response<?> response = request.mo36680a(new NetworkResponse(entry.data, entry.responseHeaders));
                request.addMarker("cache-hit-parsed");
                if (!entry.refreshNeeded()) {
                    this.f36412e.postResponse(request, response);
                } else {
                    request.addMarker("cache-hit-refresh-needed");
                    request.setCacheEntry(entry);
                    response.intermediate = true;
                    if (!this.f36414g.m38577a(request)) {
                        this.f36412e.postResponse(request, response, new C11686a(this, request));
                    } else {
                        this.f36412e.postResponse(request, response);
                    }
                }
                request.mo38376a(2);
            }
        } finally {
            request.mo38376a(2);
        }
    }
}
