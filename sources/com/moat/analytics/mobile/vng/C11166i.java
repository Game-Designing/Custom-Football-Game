package com.moat.analytics.mobile.vng;

import android.content.Context;
import android.content.Intent;
import android.support.p000v4.content.C0515e;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* renamed from: com.moat.analytics.mobile.vng.i */
class C11166i {

    /* renamed from: a */
    private static final C11166i f34088a = new C11166i();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Map<C11169j, String> f34089b = new WeakHashMap();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Map<C11153b, String> f34090c = new WeakHashMap();

    /* renamed from: d */
    private final ScheduledExecutorService f34091d = Executors.newScheduledThreadPool(1);
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ScheduledFuture<?> f34092e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ScheduledFuture<?> f34093f;

    private C11166i() {
    }

    /* renamed from: a */
    static C11166i m36728a() {
        return f34088a;
    }

    /* renamed from: a */
    private void m36730a(final Context context) {
        ScheduledFuture<?> scheduledFuture = this.f34093f;
        if (scheduledFuture == null || scheduledFuture.isDone()) {
            C11185p.m36817a(3, "JSUpdateLooper", (Object) this, "Starting metadata reporting loop");
            this.f34093f = this.f34091d.scheduleWithFixedDelay(new Runnable() {
                public void run() {
                    try {
                        C0515e.m2597a(context.getApplicationContext()).mo5314a(new Intent("UPDATE_METADATA"));
                        if (C11166i.this.f34089b.isEmpty()) {
                            C11166i.this.f34093f.cancel(true);
                        }
                    } catch (Exception e) {
                        C11176m.m36783a(e);
                    }
                }
            }, 0, 50, TimeUnit.MILLISECONDS);
        }
    }

    /* renamed from: b */
    private void m36732b(final Context context) {
        ScheduledFuture<?> scheduledFuture = this.f34092e;
        if (scheduledFuture == null || scheduledFuture.isDone()) {
            C11185p.m36817a(3, "JSUpdateLooper", (Object) this, "Starting view update loop");
            this.f34092e = this.f34091d.scheduleWithFixedDelay(new Runnable() {
                public void run() {
                    try {
                        C0515e.m2597a(context.getApplicationContext()).mo5314a(new Intent("UPDATE_VIEW_INFO"));
                        if (C11166i.this.f34090c.isEmpty()) {
                            C11185p.m36817a(3, "JSUpdateLooper", (Object) C11166i.this, "No more active trackers");
                            C11166i.this.f34092e.cancel(true);
                        }
                    } catch (Exception e) {
                        C11176m.m36783a(e);
                    }
                }
            }, 0, (long) C11198w.m36845a().f34161d, TimeUnit.MILLISECONDS);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo36347a(Context context, C11153b bVar) {
        if (bVar != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("addActiveTracker");
            sb.append(bVar.hashCode());
            C11185p.m36817a(3, "JSUpdateLooper", (Object) this, sb.toString());
            Map<C11153b, String> map = this.f34090c;
            if (map != null && !map.containsKey(bVar)) {
                this.f34090c.put(bVar, "");
                m36732b(context);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo36348a(Context context, C11169j jVar) {
        Map<C11169j, String> map = this.f34089b;
        if (map != null && jVar != null) {
            map.put(jVar, "");
            m36730a(context);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo36349a(C11153b bVar) {
        if (bVar != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("removeActiveTracker");
            sb.append(bVar.hashCode());
            C11185p.m36817a(3, "JSUpdateLooper", (Object) this, sb.toString());
            Map<C11153b, String> map = this.f34090c;
            if (map != null) {
                map.remove(bVar);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo36350a(C11169j jVar) {
        if (jVar != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("removeSetupNeededBridge");
            sb.append(jVar.hashCode());
            C11185p.m36817a(3, "JSUpdateLooper", (Object) this, sb.toString());
            Map<C11169j, String> map = this.f34089b;
            if (map != null) {
                map.remove(jVar);
            }
        }
    }
}
