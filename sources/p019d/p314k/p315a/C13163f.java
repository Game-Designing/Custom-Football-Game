package p019d.p314k.p315a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.p000v4.content.C0515e;
import com.tonyodev.fetch.exception.EnqueueException;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import p019d.p314k.p315a.p316a.C13155a;
import p019d.p314k.p315a.p317b.C13158b;
import p019d.p314k.p315a.p317b.C13159c;

/* renamed from: d.k.a.f */
/* compiled from: Fetch */
public final class C13163f implements C13166h {

    /* renamed from: a */
    private static final Handler f40218a = new Handler(Looper.getMainLooper());

    /* renamed from: b */
    private static final ConcurrentMap<C13158b, Object> f40219b = new ConcurrentHashMap();

    /* renamed from: c */
    private static final C13165g f40220c = new C13160c();

    /* renamed from: d */
    private final Context f40221d;

    /* renamed from: e */
    private final C0515e f40222e;

    /* renamed from: f */
    private final List<C13155a> f40223f = new ArrayList();

    /* renamed from: g */
    private final C13154a f40224g;

    /* renamed from: h */
    private volatile boolean f40225h = false;

    /* renamed from: i */
    private final BroadcastReceiver f40226i = new C13161d(this);

    /* renamed from: j */
    private final BroadcastReceiver f40227j = new C13162e(this);

    /* renamed from: d.k.a.f$a */
    /* compiled from: Fetch */
    public static class C13164a {

        /* renamed from: a */
        private final Context f40228a;

        /* renamed from: b */
        private final List<Bundle> f40229b = new ArrayList();

        public C13164a(Context context) {
            if (context != null) {
                this.f40228a = context;
                return;
            }
            throw new NullPointerException("Context cannot be null");
        }

        /* renamed from: a */
        public C13164a mo42224a(boolean enabled) {
            Bundle extras = new Bundle();
            extras.putInt("com.tonyodev.fetch.action_type", 320);
            extras.putBoolean("com.tonyodev.fetch.extra_logging_id", enabled);
            this.f40229b.add(extras);
            return this;
        }

        /* renamed from: a */
        public C13164a mo42223a(int limit) {
            Bundle extras = new Bundle();
            extras.putInt("com.tonyodev.fetch.action_type", 321);
            extras.putInt("com.tonyodev.fetch.extra_concurrent_download_limit", limit);
            this.f40229b.add(extras);
            return this;
        }

        /* renamed from: a */
        public void mo42225a() {
            for (Bundle setting : this.f40229b) {
                C13177s.m43031a(this.f40228a, setting);
            }
        }
    }

    private C13163f(Context context) {
        this.f40221d = context.getApplicationContext();
        this.f40222e = C0515e.m2597a(this.f40221d);
        this.f40224g = C13154a.m42947a(this.f40221d);
        this.f40224g.mo42171a(m42995f());
        this.f40222e.mo5313a(this.f40226i, C13177s.m43022a());
        this.f40221d.registerReceiver(this.f40227j, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        m42993c(this.f40221d);
    }

    /* renamed from: c */
    public static void m42993c(Context context) {
        C13177s.m43054c(context);
    }

    /* renamed from: a */
    public static C13163f m42988a(Context context) {
        return m42991b(context);
    }

    /* renamed from: b */
    public static C13163f m42991b(Context context) {
        if (context != null) {
            return new C13163f(context);
        }
        throw new NullPointerException("Context cannot be null");
    }

    /* renamed from: c */
    public void mo42218c() {
        if (!mo42215a()) {
            m42990a(true);
            this.f40223f.clear();
            this.f40222e.mo5312a(this.f40226i);
            this.f40221d.unregisterReceiver(this.f40227j);
        }
    }

    /* renamed from: a */
    public void mo42214a(C13155a fetchListener) {
        C13178t.m43094a(this);
        if (fetchListener == null) {
            throw new NullPointerException("fetchListener cannot be null");
        } else if (!this.f40223f.contains(fetchListener)) {
            this.f40223f.add(fetchListener);
        }
    }

    /* renamed from: a */
    public long mo42212a(C13158b request) {
        long downloadedBytes;
        C13178t.m43094a(this);
        if (request != null) {
            long id = C13178t.m43088a();
            try {
                String url = request.mo42198d();
                String filePath = request.mo42195a();
                int priority = request.mo42197c();
                String headers = C13178t.m43099b(request.mo42196b(), m42995f());
                File file = C13178t.m43107f(filePath);
                if (file.exists()) {
                    downloadedBytes = file.length();
                } else {
                    downloadedBytes = 0;
                }
                if (this.f40224g.mo42180b(id, url, filePath, 900, headers, downloadedBytes, 0, priority, -1)) {
                    m42993c(this.f40221d);
                    return id;
                }
                throw new EnqueueException("could not insert request", -117);
            } catch (EnqueueException e) {
                if (m42995f()) {
                    e.printStackTrace();
                }
                return -1;
            }
        } else {
            throw new NullPointerException("Request cannot be null");
        }
    }

    /* renamed from: d */
    public void mo42220d() {
        C13178t.m43094a(this);
        Bundle extras = new Bundle();
        extras.putInt("com.tonyodev.fetch.action_type", 319);
        C13177s.m43031a(this.f40221d, extras);
    }

    /* renamed from: c */
    public void mo42219c(long id) {
        C13178t.m43094a(this);
        Bundle extras = new Bundle();
        extras.putInt("com.tonyodev.fetch.action_type", 311);
        extras.putLong("com.tonyodev.fetch.extra_id", id);
        C13177s.m43031a(this.f40221d, extras);
    }

    /* renamed from: d */
    public void mo42221d(long id) {
        C13178t.m43094a(this);
        Bundle extras = new Bundle();
        extras.putInt("com.tonyodev.fetch.action_type", 312);
        extras.putLong("com.tonyodev.fetch.extra_id", id);
        C13177s.m43031a(this.f40221d, extras);
    }

    /* renamed from: e */
    public void mo42222e(long id) {
        C13178t.m43094a(this);
        Bundle extras = new Bundle();
        extras.putInt("com.tonyodev.fetch.action_type", 318);
        extras.putLong("com.tonyodev.fetch.extra_id", id);
        C13177s.m43031a(this.f40221d, extras);
    }

    /* renamed from: a */
    public synchronized C13159c mo42213a(long id) {
        C13178t.m43094a(this);
        return C13178t.m43098b(this.f40224g.mo42178b(id), true, m42995f());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0032, code lost:
        return null;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.io.File mo42216b(long r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            p019d.p314k.p315a.C13178t.m43094a(r5)     // Catch:{ all -> 0x0033 }
            d.k.a.a r0 = r5.f40224g     // Catch:{ all -> 0x0033 }
            android.database.Cursor r0 = r0.mo42178b(r6)     // Catch:{ all -> 0x0033 }
            r1 = 1
            boolean r2 = r5.m42995f()     // Catch:{ all -> 0x0033 }
            d.k.a.b.c r1 = p019d.p314k.p315a.C13178t.m43098b(r0, r1, r2)     // Catch:{ all -> 0x0033 }
            r2 = 0
            if (r1 == 0) goto L_0x0031
            int r3 = r1.mo42207h()     // Catch:{ all -> 0x0033 }
            r4 = 903(0x387, float:1.265E-42)
            if (r3 == r4) goto L_0x001f
            goto L_0x0031
        L_0x001f:
            java.lang.String r3 = r1.mo42202c()     // Catch:{ all -> 0x0033 }
            java.io.File r3 = p019d.p314k.p315a.C13178t.m43107f(r3)     // Catch:{ all -> 0x0033 }
            boolean r4 = r3.exists()     // Catch:{ all -> 0x0033 }
            if (r4 == 0) goto L_0x002f
            monitor-exit(r5)
            return r3
        L_0x002f:
            monitor-exit(r5)
            return r2
        L_0x0031:
            monitor-exit(r5)
            return r2
        L_0x0033:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p314k.p315a.C13163f.mo42216b(long):java.io.File");
    }

    /* renamed from: b */
    public boolean mo42217b() {
        return !mo42215a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo42215a() {
        return this.f40225h;
    }

    /* renamed from: a */
    private void m42990a(boolean released) {
        this.f40225h = released;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public boolean m42995f() {
        return C13177s.m43051b(this.f40221d);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public Iterator<C13155a> m42994e() {
        return this.f40223f.iterator();
    }
}
