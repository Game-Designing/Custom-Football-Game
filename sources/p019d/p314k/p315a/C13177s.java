package p019d.p314k.p315a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.support.p000v4.content.C0515e;
import com.tonyodev.fetch.request.RequestInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import p019d.p314k.p315a.p317b.C13159c;

/* renamed from: d.k.a.s */
/* compiled from: FetchService */
public final class C13177s implements C13166h {

    /* renamed from: a */
    private static C13177s f40261a;

    /* renamed from: b */
    private final Context f40262b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C13154a f40263c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final C0515e f40264d;

    /* renamed from: e */
    private final SharedPreferences f40265e;

    /* renamed from: f */
    private final ExecutorService f40266f = Executors.newSingleThreadExecutor();
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final List<BroadcastReceiver> f40267g = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final ConcurrentHashMap<Long, C13167i> f40268h = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: i */
    public volatile boolean f40269i = false;

    /* renamed from: j */
    private volatile boolean f40270j = false;

    /* renamed from: k */
    private int f40271k = 1;

    /* renamed from: l */
    private boolean f40272l = true;

    /* renamed from: m */
    private long f40273m = 2000;

    /* renamed from: n */
    private int f40274n = 200;

    /* renamed from: o */
    private final BroadcastReceiver f40275o = new C13176r(this);

    /* renamed from: a */
    public static void m43031a(Context context, Bundle extras) {
        if (context != null) {
            if (extras == null) {
                extras = new Bundle();
            }
            m43024a(context).mo42238a(extras);
            return;
        }
        throw new NullPointerException("Context cannot be null");
    }

    /* renamed from: c */
    public static void m43054c(Context context) {
        if (context != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("com.tonyodev.fetch.action_type", 315);
            m43024a(context).mo42238a(bundle);
            return;
        }
        throw new NullPointerException("Context cannot be null");
    }

    /* renamed from: a */
    public static C13177s m43024a(Context context) {
        if (context != null) {
            C13177s sVar = f40261a;
            if (sVar == null || sVar.f40270j) {
                f40261a = new C13177s(context);
            }
            return f40261a;
        }
        throw new IllegalArgumentException("context cannot be null");
    }

    /* renamed from: a */
    public static IntentFilter m43022a() {
        return new IntentFilter("com.tonyodev.fetch.event_action_update");
    }

    private C13177s(Context context) {
        this.f40262b = context.getApplicationContext();
        this.f40264d = C0515e.m2597a(context);
        this.f40265e = this.f40262b.getSharedPreferences("com.tonyodev.fetch.shared_preferences", 0);
        this.f40263c = C13154a.m42947a(context);
        this.f40264d.mo5313a(this.f40275o, C13167i.m43011a());
        this.f40267g.add(this.f40275o);
        this.f40271k = m43057d();
        this.f40274n = m43052c();
        this.f40272l = m43072g();
        this.f40273m = m43061e();
        this.f40263c.mo42171a(this.f40272l);
        if (!this.f40266f.isShutdown()) {
            this.f40266f.execute(new C13168j(this));
        }
    }

    /* renamed from: a */
    public void mo42238a(Bundle bundle) {
        if (bundle != null) {
            m43045b(bundle);
            return;
        }
        throw new IllegalArgumentException("Bundle cannot be null");
    }

    /* renamed from: b */
    public void mo42239b() {
        this.f40270j = true;
        if (!this.f40266f.isShutdown()) {
            this.f40266f.shutdown();
        }
        m43066f();
        for (BroadcastReceiver registeredReceiver : this.f40267g) {
            this.f40264d.mo5312a(registeredReceiver);
        }
        this.f40267g.clear();
    }

    /* renamed from: b */
    private void m43045b(Bundle bundle) {
        try {
            if (!this.f40266f.isShutdown()) {
                this.f40266f.execute(new C13169k(this, bundle));
            }
        } catch (Exception e) {
            if (this.f40272l) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00f3, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00f5, code lost:
        return;
     */
    /* renamed from: l */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void m43084l() {
        /*
            r20 = this;
            r1 = r20
            monitor-enter(r20)
            boolean r0 = r1.f40270j     // Catch:{ all -> 0x00f6 }
            if (r0 != 0) goto L_0x00f4
            boolean r0 = r1.f40269i     // Catch:{ all -> 0x00f6 }
            if (r0 == 0) goto L_0x000d
            goto L_0x00f4
        L_0x000d:
            android.content.Context r0 = r1.f40262b     // Catch:{ all -> 0x00f6 }
            boolean r0 = p019d.p314k.p315a.C13178t.m43096a(r0)     // Catch:{ all -> 0x00f6 }
            r2 = r0
            android.content.Context r0 = r1.f40262b     // Catch:{ all -> 0x00f6 }
            boolean r0 = p019d.p314k.p315a.C13178t.m43101b(r0)     // Catch:{ all -> 0x00f6 }
            r3 = r0
            r4 = 0
            r0 = 1
            if (r2 == 0) goto L_0x0027
            int r5 = r1.f40274n     // Catch:{ all -> 0x00f6 }
            r6 = 201(0xc9, float:2.82E-43)
            if (r5 != r6) goto L_0x0038
            if (r3 != 0) goto L_0x0038
        L_0x0027:
            java.util.concurrent.ConcurrentHashMap<java.lang.Long, d.k.a.i> r5 = r1.f40268h     // Catch:{ all -> 0x00f6 }
            int r5 = r5.size()     // Catch:{ all -> 0x00f6 }
            if (r5 <= 0) goto L_0x0038
            r1.f40269i = r0     // Catch:{ all -> 0x00f6 }
            r20.m43066f()     // Catch:{ all -> 0x00f6 }
            r1.f40269i = r4     // Catch:{ all -> 0x00f6 }
            goto L_0x00f2
        L_0x0038:
            if (r2 == 0) goto L_0x00d9
            boolean r5 = r1.f40269i     // Catch:{ all -> 0x00f6 }
            if (r5 != 0) goto L_0x00d9
            java.util.concurrent.ConcurrentHashMap<java.lang.Long, d.k.a.i> r5 = r1.f40268h     // Catch:{ all -> 0x00f6 }
            int r5 = r5.size()     // Catch:{ all -> 0x00f6 }
            int r6 = r1.f40271k     // Catch:{ all -> 0x00f6 }
            if (r5 >= r6) goto L_0x00d9
            d.k.a.a r5 = r1.f40263c     // Catch:{ all -> 0x00f6 }
            boolean r5 = r5.mo42188g()     // Catch:{ all -> 0x00f6 }
            if (r5 == 0) goto L_0x00d9
            r1.f40269i = r0     // Catch:{ all -> 0x00f6 }
            d.k.a.a r5 = r1.f40263c     // Catch:{ Exception -> 0x00b8 }
            android.database.Cursor r5 = r5.mo42187f()     // Catch:{ Exception -> 0x00b8 }
            if (r5 == 0) goto L_0x00b5
            boolean r6 = r5.isClosed()     // Catch:{ Exception -> 0x00b8 }
            if (r6 != 0) goto L_0x00b5
            int r6 = r5.getCount()     // Catch:{ Exception -> 0x00b8 }
            if (r6 <= 0) goto L_0x00b5
            boolean r6 = r1.f40272l     // Catch:{ Exception -> 0x00b8 }
            d.k.a.b.c r0 = p019d.p314k.p315a.C13178t.m43098b(r5, r0, r6)     // Catch:{ Exception -> 0x00b8 }
            d.k.a.i r18 = new d.k.a.i     // Catch:{ Exception -> 0x00b8 }
            android.content.Context r7 = r1.f40262b     // Catch:{ Exception -> 0x00b8 }
            long r8 = r0.mo42205f()     // Catch:{ Exception -> 0x00b8 }
            java.lang.String r10 = r0.mo42208i()     // Catch:{ Exception -> 0x00b8 }
            java.lang.String r11 = r0.mo42202c()     // Catch:{ Exception -> 0x00b8 }
            java.util.List r12 = r0.mo42204e()     // Catch:{ Exception -> 0x00b8 }
            long r13 = r0.mo42203d()     // Catch:{ Exception -> 0x00b8 }
            boolean r15 = r1.f40272l     // Catch:{ Exception -> 0x00b8 }
            r19 = r5
            long r4 = r1.f40273m     // Catch:{ Exception -> 0x00b8 }
            r6 = r18
            r16 = r4
            r6.<init>(r7, r8, r10, r11, r12, r13, r15, r16)     // Catch:{ Exception -> 0x00b8 }
            r4 = r18
            d.k.a.a r5 = r1.f40263c     // Catch:{ Exception -> 0x00b8 }
            long r6 = r0.mo42205f()     // Catch:{ Exception -> 0x00b8 }
            r8 = 901(0x385, float:1.263E-42)
            r9 = -1
            r5.mo42174a(r6, r8, r9)     // Catch:{ Exception -> 0x00b8 }
            java.util.concurrent.ConcurrentHashMap<java.lang.Long, d.k.a.i> r5 = r1.f40268h     // Catch:{ Exception -> 0x00b8 }
            long r6 = r4.mo42226b()     // Catch:{ Exception -> 0x00b8 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ Exception -> 0x00b8 }
            r5.put(r6, r4)     // Catch:{ Exception -> 0x00b8 }
            java.lang.Thread r5 = new java.lang.Thread     // Catch:{ Exception -> 0x00b8 }
            r5.<init>(r4)     // Catch:{ Exception -> 0x00b8 }
            r5.start()     // Catch:{ Exception -> 0x00b8 }
            goto L_0x00b7
        L_0x00b5:
            r19 = r5
        L_0x00b7:
            goto L_0x00c0
        L_0x00b8:
            r0 = move-exception
            boolean r4 = r1.f40272l     // Catch:{ all -> 0x00f6 }
            if (r4 == 0) goto L_0x00c0
            r0.printStackTrace()     // Catch:{ all -> 0x00f6 }
        L_0x00c0:
            r4 = 0
            r1.f40269i = r4     // Catch:{ all -> 0x00f6 }
            java.util.concurrent.ConcurrentHashMap<java.lang.Long, d.k.a.i> r0 = r1.f40268h     // Catch:{ all -> 0x00f6 }
            int r0 = r0.size()     // Catch:{ all -> 0x00f6 }
            int r4 = r1.f40271k     // Catch:{ all -> 0x00f6 }
            if (r0 >= r4) goto L_0x00f2
            d.k.a.a r0 = r1.f40263c     // Catch:{ all -> 0x00f6 }
            boolean r0 = r0.mo42188g()     // Catch:{ all -> 0x00f6 }
            if (r0 == 0) goto L_0x00f2
            r20.m43084l()     // Catch:{ all -> 0x00f6 }
            goto L_0x00f2
        L_0x00d9:
            boolean r4 = r1.f40269i     // Catch:{ all -> 0x00f6 }
            if (r4 != 0) goto L_0x00f2
            java.util.concurrent.ConcurrentHashMap<java.lang.Long, d.k.a.i> r4 = r1.f40268h     // Catch:{ all -> 0x00f6 }
            int r4 = r4.size()     // Catch:{ all -> 0x00f6 }
            if (r4 != 0) goto L_0x00f2
            d.k.a.a r4 = r1.f40263c     // Catch:{ all -> 0x00f6 }
            boolean r4 = r4.mo42188g()     // Catch:{ all -> 0x00f6 }
            if (r4 != 0) goto L_0x00f2
            r1.f40270j = r0     // Catch:{ all -> 0x00f6 }
            r20.mo42239b()     // Catch:{ all -> 0x00f6 }
        L_0x00f2:
            monitor-exit(r20)
            return
        L_0x00f4:
            monitor-exit(r20)
            return
        L_0x00f6:
            r0 = move-exception
            monitor-exit(r20)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p314k.p315a.C13177s.m43084l():void");
    }

    /* renamed from: f */
    private void m43066f() {
        for (Long id : this.f40268h.keySet()) {
            C13167i fetchRunnable = (C13167i) this.f40268h.get(id);
            if (fetchRunnable != null) {
                fetchRunnable.mo42227c();
            }
        }
    }

    /* renamed from: a */
    private void m43027a(long id) {
        if (this.f40268h.containsKey(Long.valueOf(id))) {
            C13167i fetchRunnable = (C13167i) this.f40268h.get(Long.valueOf(id));
            if (fetchRunnable != null) {
                fetchRunnable.mo42227c();
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00e0 A[Catch:{ all -> 0x00fe }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m43039a(java.lang.String r31, java.lang.String r32, java.util.ArrayList<android.os.Bundle> r33, int r34) {
        /*
            r30 = this;
            r11 = r30
            r10 = r31
            r9 = r32
            if (r10 == 0) goto L_0x00a9
            if (r9 == 0) goto L_0x00a9
            if (r33 != 0) goto L_0x0021
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ EnqueueException -> 0x001a, all -> 0x0013 }
            r0.<init>()     // Catch:{ EnqueueException -> 0x001a, all -> 0x0013 }
            r8 = r0
            goto L_0x0023
        L_0x0013:
            r0 = move-exception
            r15 = r33
            r12 = r9
            r13 = r10
            goto L_0x00ff
        L_0x001a:
            r0 = move-exception
            r15 = r33
            r12 = r9
            r13 = r10
            goto L_0x00dc
        L_0x0021:
            r8 = r33
        L_0x0023:
            long r13 = p019d.p314k.p315a.C13178t.m43088a()     // Catch:{ EnqueueException -> 0x00a3, all -> 0x009d }
            boolean r0 = r11.f40272l     // Catch:{ EnqueueException -> 0x00a3, all -> 0x009d }
            java.lang.String r18 = p019d.p314k.p315a.C13178t.m43090a(r8, r0)     // Catch:{ EnqueueException -> 0x00a3, all -> 0x009d }
            r25 = 0
            r0 = 0
            java.io.File r2 = p019d.p314k.p315a.C13178t.m43107f(r32)     // Catch:{ EnqueueException -> 0x00a3, all -> 0x009d }
            r27 = r2
            boolean r2 = r27.exists()     // Catch:{ EnqueueException -> 0x00a3, all -> 0x009d }
            if (r2 == 0) goto L_0x0051
            long r2 = r27.length()     // Catch:{ EnqueueException -> 0x004b, all -> 0x0045 }
            r0 = r2
            r28 = r0
            goto L_0x0053
        L_0x0045:
            r0 = move-exception
            r15 = r8
            r12 = r9
            r13 = r10
            goto L_0x00ff
        L_0x004b:
            r0 = move-exception
            r15 = r8
            r12 = r9
            r13 = r10
            goto L_0x00dc
        L_0x0051:
            r28 = r0
        L_0x0053:
            d.k.a.a r12 = r11.f40263c     // Catch:{ EnqueueException -> 0x00a3, all -> 0x009d }
            r17 = 900(0x384, float:1.261E-42)
            r24 = -1
            r15 = r31
            r16 = r32
            r19 = r28
            r21 = r25
            r23 = r34
            boolean r0 = r12.mo42180b(r13, r15, r16, r17, r18, r19, r21, r23, r24)     // Catch:{ EnqueueException -> 0x00a3, all -> 0x009d }
            if (r0 == 0) goto L_0x0086
            java.lang.String r2 = "com.tonyodev.fetch.event_action_enqueued"
            r7 = 900(0x384, float:1.261E-42)
            r12 = -1
            r1 = r30
            r3 = r13
            r5 = r31
            r6 = r32
            r15 = r8
            r9 = r34
            r16 = r13
            r13 = r10
            r10 = r12
            r1.m43038a(r2, r3, r5, r6, r7, r8, r9, r10)     // Catch:{ EnqueueException -> 0x0099, all -> 0x0094 }
            r30.m43084l()
            r12 = r32
            goto L_0x00fd
        L_0x0086:
            r15 = r8
            r16 = r13
            r13 = r10
            com.tonyodev.fetch.exception.EnqueueException r1 = new com.tonyodev.fetch.exception.EnqueueException     // Catch:{ EnqueueException -> 0x0099, all -> 0x0094 }
            java.lang.String r2 = "could not enqueue request"
            r3 = -117(0xffffffffffffff8b, float:NaN)
            r1.<init>(r2, r3)     // Catch:{ EnqueueException -> 0x0099, all -> 0x0094 }
            throw r1     // Catch:{ EnqueueException -> 0x0099, all -> 0x0094 }
        L_0x0094:
            r0 = move-exception
            r12 = r32
            goto L_0x00ff
        L_0x0099:
            r0 = move-exception
            r12 = r32
            goto L_0x00dc
        L_0x009d:
            r0 = move-exception
            r15 = r8
            r13 = r10
            r12 = r32
            goto L_0x00ff
        L_0x00a3:
            r0 = move-exception
            r15 = r8
            r13 = r10
            r12 = r32
            goto L_0x00dc
        L_0x00a9:
            r13 = r10
            com.tonyodev.fetch.exception.EnqueueException r0 = new com.tonyodev.fetch.exception.EnqueueException     // Catch:{ EnqueueException -> 0x00d7, all -> 0x00d1 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ EnqueueException -> 0x00d7, all -> 0x00d1 }
            r1.<init>()     // Catch:{ EnqueueException -> 0x00d7, all -> 0x00d1 }
            java.lang.String r2 = "Request was not properly formatted. url:"
            r1.append(r2)     // Catch:{ EnqueueException -> 0x00d7, all -> 0x00d1 }
            r1.append(r13)     // Catch:{ EnqueueException -> 0x00d7, all -> 0x00d1 }
            java.lang.String r2 = ", filePath:"
            r1.append(r2)     // Catch:{ EnqueueException -> 0x00d7, all -> 0x00d1 }
            r12 = r32
            r1.append(r12)     // Catch:{ EnqueueException -> 0x00cf, all -> 0x00cd }
            java.lang.String r1 = r1.toString()     // Catch:{ EnqueueException -> 0x00cf, all -> 0x00cd }
            r2 = -116(0xffffffffffffff8c, float:NaN)
            r0.<init>(r1, r2)     // Catch:{ EnqueueException -> 0x00cf, all -> 0x00cd }
            throw r0     // Catch:{ EnqueueException -> 0x00cf, all -> 0x00cd }
        L_0x00cd:
            r0 = move-exception
            goto L_0x00d4
        L_0x00cf:
            r0 = move-exception
            goto L_0x00da
        L_0x00d1:
            r0 = move-exception
            r12 = r32
        L_0x00d4:
            r15 = r33
            goto L_0x00ff
        L_0x00d7:
            r0 = move-exception
            r12 = r32
        L_0x00da:
            r15 = r33
        L_0x00dc:
            boolean r1 = r11.f40272l     // Catch:{ all -> 0x00fe }
            if (r1 == 0) goto L_0x00e3
            r0.printStackTrace()     // Catch:{ all -> 0x00fe }
        L_0x00e3:
            java.lang.String r2 = "com.tonyodev.fetch.event_action_enqueue_failed"
            r3 = -1
            r7 = -900(0xfffffffffffffc7c, float:NaN)
            int r10 = r0.mo40286a()     // Catch:{ all -> 0x00fe }
            r1 = r30
            r5 = r31
            r6 = r32
            r8 = r15
            r9 = r34
            r1.m43038a(r2, r3, r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x00fe }
            r30.m43084l()
        L_0x00fd:
            return
        L_0x00fe:
            r0 = move-exception
        L_0x00ff:
            r30.m43084l()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p314k.p315a.C13177s.m43039a(java.lang.String, java.lang.String, java.util.ArrayList, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m43074h(long id) {
        if (!this.f40268h.containsKey(Long.valueOf(id))) {
            if (this.f40263c.mo42184d(id)) {
                C13159c requestInfo = C13178t.m43098b(this.f40263c.mo42178b(id), true, this.f40272l);
                if (requestInfo != null) {
                    C13178t.m43093a(this.f40264d, requestInfo.mo42205f(), requestInfo.mo42207h(), requestInfo.mo42206g(), requestInfo.mo42200a(), requestInfo.mo42203d(), requestInfo.mo42201b());
                }
            }
            m43084l();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m43043b(long id) {
        if (this.f40268h.containsKey(Long.valueOf(id))) {
            this.f40269i = true;
            BroadcastReceiver broadcastReceiver = new C13170l(this, id);
            this.f40267g.add(broadcastReceiver);
            this.f40264d.mo5313a(broadcastReceiver, C13167i.m43011a());
            m43027a(id);
            return;
        }
        m43053c(id);
        m43084l();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m43053c(long id) {
        if (this.f40263c.mo42182c(id)) {
            C13159c requestInfo = C13178t.m43098b(this.f40263c.mo42178b(id), true, this.f40272l);
            if (requestInfo != null) {
                C13178t.m43093a(this.f40264d, requestInfo.mo42205f(), requestInfo.mo42207h(), requestInfo.mo42206g(), requestInfo.mo42200a(), requestInfo.mo42203d(), requestInfo.mo42201b());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m43059d(long id) {
        if (this.f40268h.containsKey(Long.valueOf(id))) {
            this.f40269i = true;
            BroadcastReceiver broadcastReceiver = new C13171m(this, id);
            this.f40267g.add(broadcastReceiver);
            this.f40264d.mo5313a(broadcastReceiver, C13167i.m43011a());
            m43027a(id);
            return;
        }
        m43063e(id);
        m43084l();
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m43063e(long id) {
        C13159c request = C13178t.m43098b(this.f40263c.mo42178b(id), true, this.f40272l);
        if (request != null && this.f40263c.mo42172a(id)) {
            C13178t.m43105d(request.mo42202c());
            C13178t.m43093a(this.f40264d, id, 905, 0, 0, 0, -1);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m43073h() {
        if (this.f40268h.size() > 0) {
            this.f40269i = true;
            BroadcastReceiver broadcastReceiver = new C13172n(this);
            this.f40267g.add(broadcastReceiver);
            this.f40264d.mo5313a(broadcastReceiver, C13167i.m43011a());
            m43066f();
            return;
        }
        m43077i();
        m43084l();
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m43077i() {
        List<RequestInfo> requests = C13178t.m43103c(this.f40263c.mo42181c(), true, this.f40272l);
        if (requests != null && this.f40263c.mo42179b()) {
            Iterator it = requests.iterator();
            while (it.hasNext()) {
                C13159c request = (C13159c) it.next();
                C13178t.m43105d(request.mo42202c());
                C13178t.m43093a(this.f40264d, request.mo42205f(), 905, 0, 0, 0, -1);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m43081j() {
        if (this.f40268h.size() > 0) {
            this.f40269i = true;
            BroadcastReceiver broadcastReceiver = new C13173o(this);
            this.f40267g.add(broadcastReceiver);
            this.f40264d.mo5313a(broadcastReceiver, C13167i.m43011a());
            m43066f();
            return;
        }
        m43083k();
        m43084l();
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public void m43083k() {
        List<RequestInfo> requests = C13178t.m43103c(this.f40263c.mo42181c(), true, this.f40272l);
        if (requests != null && this.f40263c.mo42179b()) {
            Iterator it = requests.iterator();
            while (it.hasNext()) {
                C13159c request = (C13159c) it.next();
                C13178t.m43093a(this.f40264d, request.mo42205f(), 905, request.mo42206g(), request.mo42200a(), request.mo42203d(), -1);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m43067f(long id) {
        if (this.f40268h.containsKey(Long.valueOf(id))) {
            this.f40269i = true;
            BroadcastReceiver broadcastReceiver = new C13174p(this, id);
            this.f40267g.add(broadcastReceiver);
            this.f40264d.mo5313a(broadcastReceiver, C13167i.m43011a());
            m43027a(id);
            return;
        }
        m43069g(id);
        m43084l();
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m43069g(long id) {
        C13159c request = C13178t.m43098b(this.f40263c.mo42178b(id), true, this.f40272l);
        if (request != null && this.f40263c.mo42172a(id)) {
            C13178t.m43093a(this.f40264d, id, 905, request.mo42206g(), request.mo42200a(), request.mo42203d(), -1);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m43026a(int queryType, long queryId, long requestId, int status) {
        Cursor cursor;
        if (queryType == 480) {
            cursor = this.f40263c.mo42178b(requestId);
        } else if (queryType != 482) {
            cursor = this.f40263c.mo42181c();
        } else {
            cursor = this.f40263c.mo42168a(status);
        }
        m43030a(queryId, C13178t.m43091a(cursor, true, this.f40272l));
        m43084l();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m43028a(long id, int priority) {
        if (this.f40263c.mo42173a(id, priority) && this.f40268h.size() > 0) {
            m43066f();
        }
        m43084l();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m43025a(int networkType) {
        this.f40274n = networkType;
        this.f40265e.edit().putInt("com.tonyodev.fetch.extra_network_id", networkType).apply();
        if (this.f40268h.size() > 0) {
            m43066f();
        }
        m43084l();
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m43078i(long id) {
        if (!this.f40268h.containsKey(Long.valueOf(id))) {
            if (this.f40263c.mo42186e(id)) {
                C13159c requestInfo = C13178t.m43098b(this.f40263c.mo42178b(id), true, this.f40272l);
                if (requestInfo != null) {
                    C13178t.m43093a(this.f40264d, requestInfo.mo42205f(), requestInfo.mo42207h(), requestInfo.mo42206g(), requestInfo.mo42200a(), requestInfo.mo42203d(), requestInfo.mo42201b());
                }
            }
            m43084l();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m43029a(long id, String url) {
        if (this.f40268h.containsKey(Long.valueOf(id))) {
            this.f40269i = true;
            BroadcastReceiver broadcastReceiver = new C13175q(this, id, url);
            this.f40267g.add(broadcastReceiver);
            this.f40264d.mo5313a(broadcastReceiver, C13167i.m43011a());
            m43027a(id);
            return;
        }
        m43044b(id, url);
        m43084l();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m43044b(long id, String url) {
        this.f40263c.mo42176a(id, url);
        this.f40263c.mo42186e(id);
    }

    /* renamed from: c */
    private int m43052c() {
        return this.f40265e.getInt("com.tonyodev.fetch.extra_network_id", 200);
    }

    /* renamed from: a */
    private void m43038a(String action, long id, String url, String filePath, int status, ArrayList<Bundle> headers, int priority, int error) {
        Intent intent = new Intent(action);
        intent.putExtra("com.tonyodev.fetch.extra_id", id);
        intent.putExtra("com.tonyodev.fetch.extra_status", status);
        intent.putExtra("com.tonyodev.fetch.extra_url", url);
        intent.putExtra("com.tonyodev.fetch.extra_file_path", filePath);
        intent.putExtra("com.tonyodev.fetch.extra_headers", headers);
        intent.putExtra("com.tonyodev.fetch.extra_progress", 0);
        intent.putExtra("com.tonyodev.fetch.extra_file_size", 0);
        intent.putExtra("com.tonyodev.fetch.extra_error", error);
        intent.putExtra("com.tonyodev.fetch.extra_priority", priority);
        this.f40264d.mo5314a(intent);
    }

    /* renamed from: a */
    private void m43030a(long queryId, ArrayList<Bundle> results) {
        Intent intent = new Intent("com.tonyodev.fetch.event_action_query");
        intent.putExtra("com.tonyodev.fetch.extra_query_id", queryId);
        intent.putExtra("com.tonyodev.fetch.extra_query_result", results);
        this.f40264d.mo5314a(intent);
    }

    /* renamed from: d */
    private int m43057d() {
        return this.f40265e.getInt("com.tonyodev.fetch.extra_concurrent_download_limit", 1);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m43042b(int limit) {
        if (limit < 1) {
            limit = 1;
        }
        this.f40271k = limit;
        this.f40265e.edit().putInt("com.tonyodev.fetch.extra_concurrent_download_limit", limit).apply();
        if (this.f40268h.size() > 0) {
            m43066f();
        }
        m43084l();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m43040a(boolean enabled) {
        this.f40272l = enabled;
        this.f40265e.edit().putBoolean("com.tonyodev.fetch.extra_logging_id", enabled).apply();
        this.f40263c.mo42171a(this.f40272l);
        m43084l();
    }

    /* renamed from: g */
    private boolean m43072g() {
        return this.f40265e.getBoolean("com.tonyodev.fetch.extra_logging_id", true);
    }

    /* renamed from: b */
    static boolean m43051b(Context context) {
        return context.getSharedPreferences("com.tonyodev.fetch.shared_preferences", 0).getBoolean("com.tonyodev.fetch.extra_logging_id", true);
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m43082j(long intervalMs) {
        this.f40273m = intervalMs;
        this.f40265e.edit().putLong("com.tonyodev.fetch.extra_on_update_interval", intervalMs).apply();
        if (this.f40268h.size() > 0) {
            m43066f();
        }
        m43084l();
    }

    /* renamed from: e */
    private long m43061e() {
        this.f40273m = this.f40265e.getLong("com.tonyodev.fetch.extra_on_update_interval", 2000);
        return this.f40273m;
    }
}
