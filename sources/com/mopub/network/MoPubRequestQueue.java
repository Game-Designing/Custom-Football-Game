package com.mopub.network;

import android.os.Handler;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.volley.Cache;
import com.mopub.volley.Network;
import com.mopub.volley.Request;
import com.mopub.volley.RequestQueue;
import com.mopub.volley.RequestQueue.RequestFilter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class MoPubRequestQueue extends RequestQueue {
    /* access modifiers changed from: private */

    /* renamed from: l */
    public final Map<Request<?>, C11665a> f36358l = new HashMap(10);

    /* renamed from: com.mopub.network.MoPubRequestQueue$a */
    class C11665a {

        /* renamed from: a */
        final int f36359a;

        /* renamed from: b */
        final Handler f36360b;

        /* renamed from: c */
        final Runnable f36361c;

        C11665a(MoPubRequestQueue this$0, Request<?> request, int delayMs) {
            this(request, delayMs, new Handler());
        }

        @VisibleForTesting
        C11665a(Request<?> request, int delayMs, Handler handler) {
            this.f36359a = delayMs;
            this.f36360b = handler;
            this.f36361c = new C11677j(this, MoPubRequestQueue.this, request);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo38305b() {
            this.f36360b.postDelayed(this.f36361c, (long) this.f36359a);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo38304a() {
            this.f36360b.removeCallbacks(this.f36361c);
        }
    }

    MoPubRequestQueue(Cache cache, Network network) {
        super(cache, network);
    }

    public void addDelayedRequest(Request<?> request, int delayMs) {
        Preconditions.checkNotNull(request);
        mo38299a(request, new C11665a(this, request, delayMs));
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: a */
    public void mo38299a(Request<?> request, C11665a delayedRequestHelper) {
        Preconditions.checkNotNull(delayedRequestHelper);
        if (this.f36358l.containsKey(request)) {
            cancel(request);
        }
        delayedRequestHelper.mo38305b();
        this.f36358l.put(request, delayedRequestHelper);
    }

    public void cancelAll(RequestFilter filter) {
        Preconditions.checkNotNull(filter);
        super.cancelAll(filter);
        Iterator<Entry<Request<?>, DelayedRequestHelper>> iterator = this.f36358l.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry<Request<?>, DelayedRequestHelper> entry = (Entry) iterator.next();
            if (filter.apply((Request) entry.getKey())) {
                ((Request) entry.getKey()).cancel();
                ((C11665a) entry.getValue()).mo38304a();
                iterator.remove();
            }
        }
    }

    public void cancelAll(Object tag) {
        Preconditions.checkNotNull(tag);
        super.cancelAll(tag);
        cancelAll((RequestFilter) new C11675h(this, tag));
    }

    public void cancel(Request<?> request) {
        Preconditions.checkNotNull(request);
        cancelAll((RequestFilter) new C11676i(this, request));
    }
}
