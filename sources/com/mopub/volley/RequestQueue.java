package com.mopub.volley;

import android.os.Handler;
import android.os.Looper;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class RequestQueue {

    /* renamed from: a */
    private final AtomicInteger f36449a;

    /* renamed from: b */
    private final Set<Request<?>> f36450b;

    /* renamed from: c */
    private final PriorityBlockingQueue<Request<?>> f36451c;

    /* renamed from: d */
    private final PriorityBlockingQueue<Request<?>> f36452d;

    /* renamed from: e */
    private final Cache f36453e;

    /* renamed from: f */
    private final Network f36454f;

    /* renamed from: g */
    private final ResponseDelivery f36455g;

    /* renamed from: h */
    private final NetworkDispatcher[] f36456h;

    /* renamed from: i */
    private CacheDispatcher f36457i;

    /* renamed from: j */
    private final List<RequestFinishedListener> f36458j;

    /* renamed from: k */
    private final List<RequestEventListener> f36459k;

    @Retention(RetentionPolicy.SOURCE)
    public @interface RequestEvent {
        public static final int REQUEST_CACHE_LOOKUP_FINISHED = 2;
        public static final int REQUEST_CACHE_LOOKUP_STARTED = 1;
        public static final int REQUEST_FINISHED = 5;
        public static final int REQUEST_NETWORK_DISPATCH_FINISHED = 4;
        public static final int REQUEST_NETWORK_DISPATCH_STARTED = 3;
        public static final int REQUEST_QUEUED = 0;
    }

    public interface RequestEventListener {
        void onRequestEvent(Request<?> request, int i);
    }

    public interface RequestFilter {
        boolean apply(Request<?> request);
    }

    @Deprecated
    public interface RequestFinishedListener<T> {
        void onRequestFinished(Request<T> request);
    }

    public RequestQueue(Cache cache, Network network, int threadPoolSize, ResponseDelivery delivery) {
        this.f36449a = new AtomicInteger();
        this.f36450b = new HashSet();
        this.f36451c = new PriorityBlockingQueue<>();
        this.f36452d = new PriorityBlockingQueue<>();
        this.f36458j = new ArrayList();
        this.f36459k = new ArrayList();
        this.f36453e = cache;
        this.f36454f = network;
        this.f36456h = new NetworkDispatcher[threadPoolSize];
        this.f36455g = delivery;
    }

    public RequestQueue(Cache cache, Network network, int threadPoolSize) {
        this(cache, network, threadPoolSize, new ExecutorDelivery(new Handler(Looper.getMainLooper())));
    }

    public RequestQueue(Cache cache, Network network) {
        this(cache, network, 4);
    }

    public void start() {
        stop();
        this.f36457i = new CacheDispatcher(this.f36451c, this.f36452d, this.f36453e, this.f36455g);
        this.f36457i.start();
        for (int i = 0; i < this.f36456h.length; i++) {
            NetworkDispatcher networkDispatcher = new NetworkDispatcher(this.f36452d, this.f36454f, this.f36453e, this.f36455g);
            this.f36456h[i] = networkDispatcher;
            networkDispatcher.start();
        }
    }

    public void stop() {
        NetworkDispatcher[] networkDispatcherArr;
        CacheDispatcher cacheDispatcher = this.f36457i;
        if (cacheDispatcher != null) {
            cacheDispatcher.quit();
        }
        for (NetworkDispatcher mDispatcher : this.f36456h) {
            if (mDispatcher != null) {
                mDispatcher.quit();
            }
        }
    }

    public int getSequenceNumber() {
        return this.f36449a.incrementAndGet();
    }

    public Cache getCache() {
        return this.f36453e;
    }

    public void cancelAll(RequestFilter filter) {
        synchronized (this.f36450b) {
            for (Request<?> request : this.f36450b) {
                if (filter.apply(request)) {
                    request.cancel();
                }
            }
        }
    }

    public void cancelAll(Object tag) {
        if (tag != null) {
            cancelAll((RequestFilter) new C11689d(this, tag));
            return;
        }
        throw new IllegalArgumentException("Cannot cancelAll with a null tag");
    }

    public <T> Request<T> add(Request<T> request) {
        request.setRequestQueue(this);
        synchronized (this.f36450b) {
            this.f36450b.add(request);
        }
        request.setSequence(getSequenceNumber());
        request.addMarker("add-to-queue");
        mo38415a(request, 0);
        if (!request.shouldCache()) {
            this.f36452d.add(request);
            return request;
        }
        this.f36451c.add(request);
        return request;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public <T> void mo38414a(Request<T> request) {
        synchronized (this.f36450b) {
            this.f36450b.remove(request);
        }
        synchronized (this.f36458j) {
            for (RequestFinishedListener<T> listener : this.f36458j) {
                listener.onRequestFinished(request);
            }
        }
        mo38415a(request, 5);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo38415a(Request<?> request, int event) {
        synchronized (this.f36459k) {
            for (RequestEventListener listener : this.f36459k) {
                listener.onRequestEvent(request, event);
            }
        }
    }

    public void addRequestEventListener(RequestEventListener listener) {
        synchronized (this.f36459k) {
            this.f36459k.add(listener);
        }
    }

    public void removeRequestEventListener(RequestEventListener listener) {
        synchronized (this.f36459k) {
            this.f36459k.remove(listener);
        }
    }

    @Deprecated
    public <T> void addRequestFinishedListener(RequestFinishedListener<T> listener) {
        synchronized (this.f36458j) {
            this.f36458j.add(listener);
        }
    }

    @Deprecated
    public <T> void removeRequestFinishedListener(RequestFinishedListener<T> listener) {
        synchronized (this.f36458j) {
            this.f36458j.remove(listener);
        }
    }
}
