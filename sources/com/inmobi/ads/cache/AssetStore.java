package com.inmobi.ads.cache;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.inmobi.ads.C10461bm;
import com.inmobi.ads.C10478c;
import com.inmobi.ads.C10478c.C10480b;
import com.inmobi.ads.C10478c.C10489k;
import com.inmobi.ads.cache.C10513a.C10514a;
import com.inmobi.commons.core.configs.C10639a;
import com.inmobi.commons.core.configs.C10641b;
import com.inmobi.commons.core.configs.C10641b.C10644c;
import com.inmobi.commons.core.network.C10677d;
import com.inmobi.commons.core.p218a.C10621a;
import com.inmobi.commons.core.p222e.C10658a;
import com.inmobi.commons.core.utilities.C10700d;
import com.inmobi.commons.core.utilities.C10703g;
import com.inmobi.commons.core.utilities.C10703g.C10706b;
import com.squareup.picasso.Callback;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public final class AssetStore implements C10644c {

    /* renamed from: e */
    public static final Object f32011e = new Object();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static final String f32012f = AssetStore.class.getSimpleName();

    /* renamed from: o */
    private static AssetStore f32013o;

    /* renamed from: p */
    private static final Object f32014p = new Object();

    /* renamed from: a */
    public C10517d f32015a;

    /* renamed from: b */
    public C10480b f32016b;

    /* renamed from: c */
    public ExecutorService f32017c;

    /* renamed from: d */
    public AtomicBoolean f32018d = new AtomicBoolean(false);

    /* renamed from: g */
    private C10489k f32019g;

    /* renamed from: h */
    private ExecutorService f32020h;

    /* renamed from: i */
    private C10511a f32021i;

    /* renamed from: j */
    private HandlerThread f32022j;

    /* renamed from: k */
    private AtomicBoolean f32023k = new AtomicBoolean(false);

    /* renamed from: l */
    private ConcurrentHashMap<String, C10513a> f32024l;

    /* renamed from: m */
    private C10706b f32025m;

    /* renamed from: n */
    private C10706b f32026n;

    /* renamed from: q */
    private List<C10515b> f32027q = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: r */
    public final C10518e f32028r = new C10518e() {
        /* renamed from: a */
        public final void mo34228a(C10677d dVar, String str, C10513a aVar) {
            AssetStore.f32012f;
            StringBuilder sb = new StringBuilder("Asset fetch succeeded for URL ");
            sb.append(aVar.f32048d);
            sb.append(" Updating location on disk (file://");
            sb.append(str);
            sb.append(")");
            C10513a a = new C10514a().mo34239a(aVar.f32048d, str, dVar, AssetStore.this.f32016b.f31916a, AssetStore.this.f32016b.f31920e).mo34240a();
            AssetStore.this.f32015a;
            C10517d.m34432b(a);
            a.f32055k = aVar.f32055k;
            a.f32045a = aVar.f32045a;
            AssetStore.this.m34376a(a, true);
            try {
                AssetStore.m34387c(AssetStore.this);
            } catch (Exception e) {
                AssetStore.f32012f;
                C10621a.m34854a().mo34423a(new C10658a(e));
            }
        }

        /* renamed from: a */
        public final void mo34227a(C10513a aVar) {
            AssetStore.f32012f;
            StringBuilder sb = new StringBuilder("Asset fetch failed for remote URL (");
            sb.append(aVar.f32048d);
            sb.append(")");
            AssetStore.this.m34390c(aVar.f32048d);
            if (aVar.f32047c <= 0) {
                AssetStore.f32012f;
                AssetStore.this.m34376a(aVar, false);
                AssetStore.this.f32015a;
                C10517d.m34436c(aVar);
            } else {
                AssetStore.f32012f;
                aVar.f32050f = System.currentTimeMillis();
                AssetStore.this.f32015a;
                C10517d.m34432b(aVar);
                if (!C10700d.m35146a()) {
                    AssetStore.this.m34376a(aVar, false);
                }
            }
            try {
                AssetStore.m34387c(AssetStore.this);
            } catch (Exception e) {
                AssetStore.f32012f;
                C10621a.m34854a().mo34423a(new C10658a(e));
            }
        }
    };

    private class PicassoCallback implements Callback {

        /* renamed from: b */
        private CountDownLatch f32039b;

        /* renamed from: c */
        private String f32040c;

        PicassoCallback(CountDownLatch countDownLatch, String str) {
            this.f32039b = countDownLatch;
            this.f32040c = str;
        }

        public void onSuccess() {
            AssetStore.this.m34377a(this.f32040c);
            this.f32039b.countDown();
        }

        public void onError() {
            AssetStore.this.m34385b(this.f32040c);
            this.f32039b.countDown();
        }
    }

    /* renamed from: com.inmobi.ads.cache.AssetStore$a */
    private static final class C10511a extends Handler {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public WeakReference<AssetStore> f32041a;

        /* renamed from: b */
        private final C10518e f32042b = new C10518e() {
            /* renamed from: a */
            public final void mo34228a(C10677d dVar, String str, C10513a aVar) {
                AssetStore assetStore = (AssetStore) C10511a.this.f32041a.get();
                if (assetStore != null) {
                    AssetStore.f32012f;
                    StringBuilder sb = new StringBuilder("Asset fetch succeeded for URL ");
                    sb.append(aVar.f32048d);
                    sb.append(" Updating location on disk (file://");
                    sb.append(str);
                    sb.append(")");
                    C10513a a = new C10514a().mo34239a(aVar.f32048d, str, dVar, assetStore.f32016b.f31916a, assetStore.f32016b.f31920e).mo34240a();
                    assetStore.f32015a;
                    C10517d.m34432b(a);
                    a.f32055k = aVar.f32055k;
                    a.f32045a = aVar.f32045a;
                    assetStore.m34376a(a, true);
                    C10511a.this.m34412a();
                    return;
                }
                AssetStore.f32012f;
            }

            /* renamed from: a */
            public final void mo34227a(C10513a aVar) {
                AssetStore assetStore = (AssetStore) C10511a.this.f32041a.get();
                if (assetStore != null) {
                    AssetStore.f32012f;
                    StringBuilder sb = new StringBuilder("Asset fetch failed for remote URL (");
                    sb.append(aVar.f32048d);
                    sb.append(")");
                    assetStore.m34390c(aVar.f32048d);
                    int i = aVar.f32047c;
                    if (i > 0) {
                        aVar.f32047c = i - 1;
                        aVar.f32050f = System.currentTimeMillis();
                        assetStore.f32015a;
                        C10517d.m34432b(aVar);
                        C10511a.this.m34415b();
                        return;
                    }
                    assetStore.m34376a(aVar, false);
                    C10511a.this.m34414a(aVar);
                    return;
                }
                AssetStore.f32012f;
            }
        };

        C10511a(Looper looper, AssetStore assetStore) {
            super(looper);
            this.f32041a = new WeakReference<>(assetStore);
        }

        public final void handleMessage(Message message) {
            try {
                AssetStore assetStore = (AssetStore) this.f32041a.get();
                int i = message.what;
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i == 4) {
                                if (assetStore != null) {
                                    C10513a aVar = (C10513a) message.obj;
                                    assetStore.f32015a;
                                    C10517d.m34436c(aVar);
                                }
                                m34415b();
                            } else {
                                return;
                            }
                        }
                        m34415b();
                    } else if (assetStore != null) {
                        String str = (String) message.obj;
                        assetStore.f32015a;
                        C10513a b = C10517d.m34433b(str);
                        if (b == null) {
                            m34415b();
                        } else if (!b.mo34234a()) {
                            int i2 = (assetStore.f32016b.f31916a - b.f32047c) + 1;
                            if (b.f32047c == 0) {
                                b.f32056l = 11;
                                assetStore.m34376a(b, false);
                                m34414a(b);
                            } else if (!C10700d.m35146a()) {
                                assetStore.m34376a(b, false);
                                assetStore.mo34226c();
                            } else if (assetStore.m34380a(b, this.f32042b)) {
                                AssetStore.f32012f;
                                new StringBuilder("Cache miss in handler; attempting to cache asset: ").append(b.f32048d);
                                AssetStore.f32012f;
                                StringBuilder sb = new StringBuilder("Download attempt # ");
                                sb.append(i2);
                                sb.append(" in handler  to cache asset (");
                                sb.append(b.f32048d);
                                sb.append(")");
                            } else {
                                AssetStore.f32012f;
                                new StringBuilder("Cache miss in handler; but already attempting: ").append(b.f32048d);
                                m34415b();
                            }
                        } else {
                            AssetStore.f32012f;
                            m34412a();
                            assetStore.m34376a(b, true);
                        }
                    }
                } else if (assetStore != null) {
                    C10480b h = assetStore.f32016b;
                    if (h == null) {
                        C10478c cVar = new C10478c();
                        C10641b.m34915a().mo34452a((C10639a) cVar, (C10644c) null);
                        h = cVar.f31902n;
                    }
                    assetStore.f32015a;
                    List e = C10517d.m34439e();
                    if (e.size() <= 0) {
                        AssetStore.f32012f;
                        assetStore.mo34226c();
                        return;
                    }
                    AssetStore.f32012f;
                    C10513a aVar2 = (C10513a) e.get(0);
                    Iterator it = e.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        C10513a aVar3 = (C10513a) it.next();
                        if (!assetStore.f32024l.containsKey(aVar2.f32048d)) {
                            aVar2 = aVar3;
                            break;
                        }
                    }
                    Message obtain = Message.obtain();
                    obtain.what = 2;
                    long currentTimeMillis = System.currentTimeMillis() - aVar2.f32050f;
                    try {
                        if (currentTimeMillis < ((long) (h.f31917b * 1000))) {
                            sendMessageDelayed(obtain, ((long) (h.f31917b * 1000)) - currentTimeMillis);
                        } else if (assetStore.f32024l.containsKey(aVar2.f32048d)) {
                            sendMessageDelayed(obtain, (long) (h.f31917b * 1000));
                        } else {
                            AssetStore.f32012f;
                            Message obtain2 = Message.obtain();
                            obtain2.what = 2;
                            obtain2.obj = aVar2.f32048d;
                            sendMessage(obtain2);
                        }
                    } catch (Exception e2) {
                        AssetStore.f32012f;
                        new StringBuilder("Encountered unexpected error in Asset fetch handler").append(e2.getMessage());
                    }
                }
            } catch (Exception e3) {
                AssetStore.f32012f;
                C10621a.m34854a().mo34423a(new C10658a(e3));
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m34414a(C10513a aVar) {
            try {
                Message obtain = Message.obtain();
                obtain.what = 4;
                obtain.obj = aVar;
                sendMessage(obtain);
            } catch (Exception e) {
                AssetStore.f32012f;
                new StringBuilder("Encountered unexpected error in Asset fetch handler").append(e.getMessage());
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m34412a() {
            try {
                sendEmptyMessage(3);
            } catch (Exception e) {
                AssetStore.f32012f;
                new StringBuilder("Encountered unexpected error in Asset fetch handler").append(e.getMessage());
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public void m34415b() {
            try {
                sendEmptyMessage(1);
            } catch (Exception e) {
                AssetStore.f32012f;
                new StringBuilder("Encountered unexpected error in Asset fetch handler").append(e.getMessage());
            }
        }
    }

    /* renamed from: c */
    static /* synthetic */ void m34387c(AssetStore assetStore) {
        if (!assetStore.f32018d.get()) {
            assetStore.mo34225b();
        }
    }

    private AssetStore() {
        C10478c cVar = new C10478c();
        C10641b.m34915a().mo34452a((C10639a) cVar, (C10644c) this);
        this.f32016b = cVar.f31902n;
        this.f32019g = cVar.f31901m;
        this.f32015a = C10517d.m34431a();
        this.f32017c = Executors.newCachedThreadPool();
        this.f32020h = Executors.newFixedThreadPool(1);
        this.f32022j = new HandlerThread("assetFetcher");
        this.f32022j.start();
        this.f32021i = new C10511a(this.f32022j.getLooper(), this);
        this.f32025m = new C10706b() {
            /* renamed from: a */
            public final void mo34229a(boolean z) {
                if (z) {
                    AssetStore.m34387c(AssetStore.this);
                } else {
                    AssetStore.this.mo34226c();
                }
            }
        };
        if (VERSION.SDK_INT >= 23) {
            this.f32026n = new C10706b() {
                /* renamed from: a */
                public final void mo34229a(boolean z) {
                    if (z) {
                        AssetStore.this.mo34226c();
                    } else {
                        AssetStore.m34387c(AssetStore.this);
                    }
                }
            };
        }
        this.f32024l = new ConcurrentHashMap<>(2, 0.9f, 2);
    }

    /* renamed from: a */
    public static AssetStore m34369a() {
        AssetStore assetStore = f32013o;
        if (assetStore == null) {
            synchronized (f32014p) {
                assetStore = f32013o;
                if (assetStore == null) {
                    assetStore = new AssetStore();
                    f32013o = assetStore;
                }
            }
        }
        return assetStore;
    }

    /* renamed from: a */
    public final void mo33666a(C10639a aVar) {
        C10478c cVar = (C10478c) aVar;
        this.f32016b = cVar.f31902n;
        this.f32019g = cVar.f31901m;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m34377a(String str) {
        boolean z;
        for (int i = 0; i < this.f32027q.size(); i++) {
            C10515b bVar = (C10515b) this.f32027q.get(i);
            Set<C10461bm> set = bVar.f32066b;
            Set<String> set2 = bVar.f32067c;
            Iterator it = set.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (((C10461bm) it.next()).f31824b.equals(str)) {
                    z = true;
                    break;
                }
            }
            if (z && !set2.contains(str)) {
                bVar.f32067c.add(str);
                bVar.f32068d++;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public synchronized void m34385b(String str) {
        boolean z;
        for (int i = 0; i < this.f32027q.size(); i++) {
            C10515b bVar = (C10515b) this.f32027q.get(i);
            Iterator it = bVar.f32066b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (((C10461bm) it.next()).f31824b.equals(str)) {
                    z = true;
                    break;
                }
            }
            if (z) {
                bVar.f32069e++;
            }
        }
    }

    /* renamed from: b */
    private synchronized void m34383b(C10513a aVar) {
        boolean z;
        for (int i = 0; i < this.f32027q.size(); i++) {
            C10515b bVar = (C10515b) this.f32027q.get(i);
            Iterator it = bVar.f32066b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (((C10461bm) it.next()).f31824b.equals(aVar.f32048d)) {
                    z = true;
                    break;
                }
            }
            if (z && !bVar.f32065a.contains(aVar)) {
                bVar.f32065a.add(aVar);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public synchronized void m34384b(C10515b bVar) {
        if (!this.f32027q.contains(bVar)) {
            this.f32027q.add(bVar);
        }
    }

    /* renamed from: a */
    private synchronized void m34378a(List<C10515b> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            this.f32027q.remove(list.get(i));
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0123, code lost:
        r8.f32056l = 7;
        r8.f32047c = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x012d, code lost:
        if (r11.exists() == false) goto L_0x0132;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x012f, code lost:
        r11.delete();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0132, code lost:
        r4.disconnect();
        com.inmobi.commons.core.utilities.C10700d.m35144a((java.io.Closeable) r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0139, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        com.inmobi.commons.core.p218a.C10621a.m34854a().mo34423a(new com.inmobi.commons.core.p222e.C10658a(r0));
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m34380a(com.inmobi.ads.cache.C10513a r24, com.inmobi.ads.cache.C10518e r25) {
        /*
            r23 = this;
            r1 = r23
            r8 = r24
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.inmobi.ads.cache.a> r0 = r1.f32024l
            java.lang.String r2 = r8.f32048d
            java.lang.Object r0 = r0.putIfAbsent(r2, r8)
            com.inmobi.ads.cache.a r0 = (com.inmobi.ads.cache.C10513a) r0
            r9 = 0
            if (r0 != 0) goto L_0x01de
            com.inmobi.ads.cache.c r10 = new com.inmobi.ads.cache.c
            r0 = r25
            r10.<init>(r0)
            com.inmobi.ads.c$k r0 = r1.f32019g
            long r2 = r0.f31961c
            java.util.ArrayList<java.lang.String> r0 = r0.f31963e
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "Fetching asset ("
            r4.<init>(r5)
            java.lang.String r5 = r8.f32048d
            r4.append(r5)
            java.lang.String r5 = ")"
            r4.append(r5)
            boolean r4 = com.inmobi.commons.core.utilities.C10700d.m35146a()
            r12 = 8
            if (r4 != 0) goto L_0x0044
            r8.f32056l = r12
            com.inmobi.ads.cache.e r0 = r10.f32076a
            r0.mo34227a(r8)
            goto L_0x01dc
        L_0x0044:
            java.lang.String r4 = r8.f32048d
            java.lang.String r5 = ""
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x01d2
            java.lang.String r4 = r8.f32048d
            boolean r4 = android.webkit.URLUtil.isValidUrl(r4)
            if (r4 != 0) goto L_0x0059
            goto L_0x01d2
        L_0x0059:
            int r4 = r0.size()
            java.lang.String[] r4 = new java.lang.String[r4]
            java.lang.Object[] r0 = r0.toArray(r4)
            java.lang.String[] r0 = (java.lang.String[]) r0
            long r21 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            java.net.URL r4 = new java.net.URL     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            java.lang.String r5 = r8.f32048d     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            r4.<init>(r5)     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            java.net.URLConnection r4 = r4.openConnection()     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            java.lang.String r5 = "GET"
            r4.setRequestMethod(r5)     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            r5 = 60000(0xea60, float:8.4078E-41)
            r4.setConnectTimeout(r5)     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            r4.setReadTimeout(r5)     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            int r5 = r4.getResponseCode()     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            r6 = 400(0x190, float:5.6E-43)
            if (r5 >= r6) goto L_0x00c1
            java.lang.String r5 = r4.getContentType()     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            int r6 = r0.length     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            r7 = 0
        L_0x0093:
            if (r7 >= r6) goto L_0x00b1
            r15 = r0[r7]     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            if (r5 == 0) goto L_0x00ae
            java.util.Locale r11 = java.util.Locale.ENGLISH     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            java.lang.String r11 = r15.toLowerCase(r11)     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            java.util.Locale r15 = java.util.Locale.ENGLISH     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            java.lang.String r15 = r5.toLowerCase(r15)     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            boolean r11 = r11.equals(r15)     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            if (r11 == 0) goto L_0x00ae
            r0 = 1
            goto L_0x00b2
        L_0x00ae:
            int r7 = r7 + 1
            goto L_0x0093
        L_0x00b1:
            r0 = 0
        L_0x00b2:
            if (r0 != 0) goto L_0x00c1
            r0 = 6
            r8.f32056l = r0     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            r8.f32047c = r9     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            com.inmobi.ads.cache.e r0 = r10.f32076a     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            r0.mo34227a(r8)     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            goto L_0x01dc
        L_0x00c1:
            int r0 = r4.getContentLength()     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            long r5 = (long) r0     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            r0 = 7
            r15 = 0
            int r7 = (r5 > r15 ? 1 : (r5 == r15 ? 0 : -1))
            if (r7 < 0) goto L_0x00ef
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            java.lang.String r11 = "ContentSize: "
            r7.<init>(r11)     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            r7.append(r5)     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            java.lang.String r11 = " max size: "
            r7.append(r11)     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            r7.append(r2)     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            int r7 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r7 <= 0) goto L_0x00ef
            r8.f32056l = r0     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            r8.f32047c = r9     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            com.inmobi.ads.cache.e r0 = r10.f32076a     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            r0.mo34227a(r8)     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            goto L_0x01dc
        L_0x00ef:
            r4.connect()     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            java.lang.String r5 = r8.f32048d     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            java.io.File r11 = com.inmobi.commons.p217a.C10619a.m34832a(r5)     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            boolean r5 = r11.exists()     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            if (r5 == 0) goto L_0x0102
            r11.delete()     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
        L_0x0102:
            java.io.InputStream r5 = r4.getInputStream()     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            java.io.BufferedOutputStream r6 = new java.io.BufferedOutputStream     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            r7.<init>(r11)     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            r6.<init>(r7)     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            r7 = 1024(0x400, float:1.435E-42)
            byte[] r7 = new byte[r7]     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            r17 = r15
        L_0x0116:
            int r15 = r5.read(r7)     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            if (r15 <= 0) goto L_0x015a
            long r13 = (long) r15     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            long r17 = r17 + r13
            int r13 = (r17 > r2 ? 1 : (r17 == r2 ? 0 : -1))
            if (r13 <= 0) goto L_0x0156
            r8.f32056l = r0     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            r8.f32047c = r9     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            boolean r0 = r11.exists()     // Catch:{ Exception -> 0x0139 }
            if (r0 == 0) goto L_0x0132
            r11.delete()     // Catch:{ Exception -> 0x0139 }
        L_0x0132:
            r4.disconnect()     // Catch:{ Exception -> 0x0139 }
            com.inmobi.commons.core.utilities.C10700d.m35144a(r6)     // Catch:{ Exception -> 0x0139 }
            goto L_0x0146
        L_0x0139:
            r0 = move-exception
            com.inmobi.commons.core.a.a r2 = com.inmobi.commons.core.p218a.C10621a.m34854a()     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            com.inmobi.commons.core.e.a r3 = new com.inmobi.commons.core.e.a     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            r3.<init>(r0)     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            r2.mo34423a(r3)     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
        L_0x0146:
            long r19 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            r15 = r21
            com.inmobi.ads.cache.C10516c.m34428a(r15, r17, r19)     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            com.inmobi.ads.cache.e r0 = r10.f32076a     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            r0.mo34227a(r8)     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            goto L_0x01dc
        L_0x0156:
            r6.write(r7, r9, r15)     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            goto L_0x0116
        L_0x015a:
            r6.flush()     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            r4.disconnect()     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            com.inmobi.commons.core.utilities.C10700d.m35144a(r6)     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            long r13 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            r15 = r21
            r19 = r13
            com.inmobi.ads.cache.C10516c.m34428a(r15, r17, r19)     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            com.inmobi.commons.core.network.d r0 = new com.inmobi.commons.core.network.d     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            r0.<init>()     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            java.util.Map r2 = r4.getHeaderFields()     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            r0.f32593d = r2     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            r2 = r24
            r3 = r11
            r4 = r21
            r6 = r13
            java.lang.String r2 = com.inmobi.ads.cache.C10516c.m34427a(r2, r3, r4, r6)     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            r8.f32055k = r2     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            long r13 = r13 - r21
            r8.f32045a = r13     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            com.inmobi.ads.cache.e r2 = r10.f32076a     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            java.lang.String r3 = r11.getAbsolutePath()     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            r2.mo34228a(r0, r3, r8)     // Catch:{ SocketTimeoutException -> 0x01c7, FileNotFoundException -> 0x01bc, MalformedURLException -> 0x01b1, ProtocolException -> 0x01a7, IOException -> 0x019d, Exception -> 0x0193 }
            goto L_0x01d1
        L_0x0193:
            r0 = move-exception
            r8.f32056l = r9
            com.inmobi.ads.cache.e r0 = r10.f32076a
            r0.mo34227a(r8)
            goto L_0x01dc
        L_0x019d:
            r0 = move-exception
            r8.f32056l = r12
            com.inmobi.ads.cache.e r0 = r10.f32076a
            r0.mo34227a(r8)
            goto L_0x01d1
        L_0x01a7:
            r0 = move-exception
            r8.f32056l = r12
            com.inmobi.ads.cache.e r0 = r10.f32076a
            r0.mo34227a(r8)
            goto L_0x01d1
        L_0x01b1:
            r0 = move-exception
            r2 = 3
            r8.f32056l = r2
            com.inmobi.ads.cache.e r0 = r10.f32076a
            r0.mo34227a(r8)
            goto L_0x01d1
        L_0x01bc:
            r0 = move-exception
            r2 = 4
            r8.f32056l = r2
            com.inmobi.ads.cache.e r0 = r10.f32076a
            r0.mo34227a(r8)
            goto L_0x01d1
        L_0x01c7:
            r0 = move-exception
            r2 = 4
            r8.f32056l = r2
            com.inmobi.ads.cache.e r0 = r10.f32076a
            r0.mo34227a(r8)
        L_0x01d1:
            goto L_0x01dc
        L_0x01d2:
            r2 = 3
            r8.f32056l = r2
            com.inmobi.ads.cache.e r0 = r10.f32076a
            r0.mo34227a(r8)
        L_0x01dc:
            r2 = 1
            return r2
        L_0x01de:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.ads.cache.AssetStore.m34380a(com.inmobi.ads.cache.a, com.inmobi.ads.cache.e):boolean");
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m34390c(String str) {
        this.f32024l.remove(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m34376a(C10513a aVar, boolean z) {
        m34383b(aVar);
        m34390c(aVar.f32048d);
        if (z) {
            m34377a(aVar.f32048d);
            m34394e();
            return;
        }
        m34385b(aVar.f32048d);
        m34396f();
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public synchronized void m34394e() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f32027q.size(); i++) {
            C10515b bVar = (C10515b) this.f32027q.get(i);
            if (bVar.f32068d == bVar.f32066b.size()) {
                try {
                    C10519f a = bVar.mo34241a();
                    if (a != null) {
                        a.mo34175b(bVar);
                    }
                    arrayList.add(bVar);
                } catch (Exception e) {
                    new StringBuilder("Encountered unexpected error in onAssetFetchSucceeded handler: ").append(e.getMessage());
                    C10621a.m34854a().mo34423a(new C10658a(e));
                }
            }
        }
        m34378a((List<C10515b>) arrayList);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public synchronized void m34396f() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f32027q.size(); i++) {
            C10515b bVar = (C10515b) this.f32027q.get(i);
            if (bVar.f32069e > 0) {
                try {
                    C10519f a = bVar.mo34241a();
                    if (a != null) {
                        a.mo34174a(bVar);
                    }
                    arrayList.add(bVar);
                } catch (Exception e) {
                    new StringBuilder("Encountered unexpected error in onAssetFetchFailed handler: ").append(e.getMessage());
                    C10621a.m34854a().mo34423a(new C10658a(e));
                }
            }
        }
        m34378a((List<C10515b>) arrayList);
    }

    /* renamed from: b */
    public final void mo34225b() {
        this.f32018d.set(false);
        if (!C10700d.m35146a()) {
            m34399g();
            m34401h();
            return;
        }
        synchronized (f32011e) {
            if (this.f32023k.compareAndSet(false, true)) {
                if (this.f32022j == null) {
                    this.f32022j = new HandlerThread("assetFetcher");
                    this.f32022j.start();
                }
                if (this.f32021i == null) {
                    this.f32021i = new C10511a(this.f32022j.getLooper(), this);
                }
                if (C10517d.m34439e().isEmpty()) {
                    mo34226c();
                } else {
                    m34399g();
                    m34401h();
                    this.f32021i.sendEmptyMessage(1);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m34375a(C10513a aVar) {
        C10517d.m34436c(aVar);
        File file = new File(aVar.f32049e);
        if (file.exists()) {
            file.delete();
        }
    }

    /* renamed from: a */
    public final void mo34224a(final C10515b bVar) {
        this.f32017c.execute(new Runnable() {
            public final void run() {
                AssetStore.this.m34384b(bVar);
                AssetStore.f32012f;
                StringBuilder sb = new StringBuilder("Attempting to cache ");
                sb.append(bVar.f32066b.size());
                sb.append("remote URLs ");
                ArrayList arrayList = new ArrayList();
                ArrayList<String> arrayList2 = new ArrayList<>();
                for (C10461bm bmVar : bVar.f32066b) {
                    if (bmVar.f31824b.trim().length() <= 0 || bmVar.f31823a != 2) {
                        arrayList2.add(bmVar.f31824b);
                    } else {
                        arrayList.add(bmVar.f31824b);
                    }
                }
                AssetStore.m34374a(AssetStore.this, (List) arrayList);
                AssetStore.this.m34394e();
                AssetStore.this.m34396f();
                for (String b : arrayList2) {
                    AssetStore.m34382b(AssetStore.this, b);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m34389c(C10513a aVar) {
        File file = new File(aVar.f32049e);
        long min = Math.min(System.currentTimeMillis() + (aVar.f32052h - aVar.f32050f), System.currentTimeMillis() + (this.f32016b.f31920e * 1000));
        C10514a aVar2 = new C10514a();
        String str = aVar.f32048d;
        String str2 = aVar.f32049e;
        int i = this.f32016b.f31916a;
        long j = aVar.f32053i;
        aVar2.f32059c = str;
        aVar2.f32060d = str2;
        aVar2.f32058b = i;
        aVar2.f32063g = min;
        aVar2.f32064h = j;
        C10513a a = aVar2.mo34240a();
        a.f32050f = System.currentTimeMillis();
        C10517d.m34432b(a);
        long j2 = aVar.f32050f;
        a.f32055k = C10516c.m34427a(aVar, file, j2, j2);
        a.f32054j = true;
        m34376a(a, true);
    }

    @TargetApi(23)
    /* renamed from: g */
    private void m34399g() {
        C10703g.m35152a();
        C10706b bVar = this.f32025m;
        if (VERSION.SDK_INT < 28) {
            C10703g.m35153a(bVar, "android.net.conn.CONNECTIVITY_CHANGE");
        } else {
            C10703g.m35153a(bVar, "SYSTEM_CONNECTIVITY_CHANGE");
        }
        if (VERSION.SDK_INT >= 23) {
            C10703g.m35152a();
            C10703g.m35153a(this.f32026n, "android.os.action.DEVICE_IDLE_MODE_CHANGED");
        }
    }

    @TargetApi(23)
    /* renamed from: h */
    private void m34401h() {
        C10703g.m35152a().mo34523a(this.f32025m);
        if (VERSION.SDK_INT >= 23) {
            C10703g.m35152a().mo34524a("android.os.action.DEVICE_IDLE_MODE_CHANGED", this.f32026n);
        }
    }

    /* renamed from: c */
    public final void mo34226c() {
        synchronized (f32011e) {
            this.f32023k.set(false);
            this.f32024l.clear();
            if (this.f32022j != null) {
                this.f32022j.getLooper().quit();
                this.f32022j.interrupt();
                this.f32022j = null;
                this.f32021i = null;
            }
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m34382b(AssetStore assetStore, final String str) {
        C10513a a = C10517d.m34430a(str);
        if (a == null || !a.mo34234a()) {
            C10514a aVar = new C10514a();
            C10480b bVar = assetStore.f32016b;
            C10513a a2 = aVar.mo34238a(str, bVar.f31916a, bVar.f31920e).mo34240a();
            if (C10517d.m34430a(str) == null) {
                assetStore.f32015a.mo34243a(a2);
            }
            assetStore.f32020h.execute(new Runnable() {
                public final void run() {
                    AssetStore.this.f32015a;
                    C10513a a = C10517d.m34430a(str);
                    if (a != null) {
                        if (a.mo34234a()) {
                            AssetStore.this.m34389c(a);
                            return;
                        }
                        AssetStore assetStore = AssetStore.this;
                        if (assetStore.m34380a(a, assetStore.f32028r)) {
                            AssetStore.f32012f;
                            new StringBuilder("Cache miss; attempting to cache asset: ").append(str);
                            return;
                        }
                        AssetStore.f32012f;
                        new StringBuilder("Cache miss; but already attempting: ").append(str);
                    }
                }
            });
            return;
        }
        StringBuilder sb = new StringBuilder("Cache hit; file exists location on disk (");
        sb.append(a.f32049e);
        sb.append(")");
        assetStore.m34389c(a);
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<java.lang.String>, for r5v0, types: [java.util.List, java.util.List<java.lang.String>] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void m34374a(com.inmobi.ads.cache.AssetStore r4, java.util.List<java.lang.String> r5) {
        /*
            java.util.concurrent.CountDownLatch r0 = new java.util.concurrent.CountDownLatch
            int r1 = r5.size()
            r0.<init>(r1)
            java.util.Iterator r5 = r5.iterator()
        L_0x000d:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L_0x0033
            java.lang.Object r1 = r5.next()
            java.lang.String r1 = (java.lang.String) r1
            android.content.Context r2 = com.inmobi.commons.p217a.C10619a.m34839b()     // Catch:{ Exception -> 0x002e }
            com.squareup.picasso.Picasso r2 = com.inmobi.ads.C10453bh.m34220a(r2)     // Catch:{ Exception -> 0x002e }
            com.squareup.picasso.RequestCreator r2 = r2.load(r1)     // Catch:{ Exception -> 0x002e }
            com.inmobi.ads.cache.AssetStore$PicassoCallback r3 = new com.inmobi.ads.cache.AssetStore$PicassoCallback     // Catch:{ Exception -> 0x002e }
            r3.<init>(r0, r1)     // Catch:{ Exception -> 0x002e }
            r2.fetch(r3)     // Catch:{ Exception -> 0x002e }
            goto L_0x000d
        L_0x002e:
            r1 = move-exception
            r0.countDown()
            goto L_0x000d
        L_0x0033:
            r0.await()     // Catch:{ InterruptedException -> 0x0037 }
            return
        L_0x0037:
            r4 = move-exception
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.ads.cache.AssetStore.m34374a(com.inmobi.ads.cache.AssetStore, java.util.List):void");
    }
}
