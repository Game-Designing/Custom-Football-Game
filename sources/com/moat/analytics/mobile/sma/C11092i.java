package com.moat.analytics.mobile.sma;

import android.content.Context;
import android.content.Intent;
import android.support.p000v4.content.C0515e;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* renamed from: com.moat.analytics.mobile.sma.i */
class C11092i {

    /* renamed from: a */
    private static final C11092i f33901a = new C11092i();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Map<C11095j, String> f33902b = new WeakHashMap();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Map<C11079b, String> f33903c = new WeakHashMap();

    /* renamed from: d */
    private final ScheduledExecutorService f33904d = Executors.newScheduledThreadPool(1);
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ScheduledFuture<?> f33905e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ScheduledFuture<?> f33906f;

    private C11092i() {
    }

    /* renamed from: a */
    static C11092i m36488a() {
        return f33901a;
    }

    /* renamed from: a */
    private void m36490a(final Context context) {
        ScheduledFuture<?> scheduledFuture = this.f33906f;
        if (scheduledFuture == null || scheduledFuture.isDone()) {
            C11111p.m36577a(3, "JSUpdateLooper", (Object) this, "Starting metadata reporting loop");
            this.f33906f = this.f33904d.scheduleWithFixedDelay(new Runnable() {
                public void run() {
                    try {
                        C0515e.m2597a(context.getApplicationContext()).mo5314a(new Intent("UPDATE_METADATA"));
                        if (C11092i.this.f33902b.isEmpty()) {
                            C11092i.this.f33906f.cancel(true);
                        }
                    } catch (Exception e) {
                        C11102m.m36543a(e);
                    }
                }
            }, 0, 50, TimeUnit.MILLISECONDS);
        }
    }

    /* renamed from: b */
    private void m36492b(final Context context) {
        ScheduledFuture<?> scheduledFuture = this.f33905e;
        if (scheduledFuture == null || scheduledFuture.isDone()) {
            C11111p.m36577a(3, "JSUpdateLooper", (Object) this, "Starting view update loop");
            this.f33905e = this.f33904d.scheduleWithFixedDelay(new Runnable() {
                public void run() {
                    try {
                        C0515e.m2597a(context.getApplicationContext()).mo5314a(new Intent("UPDATE_VIEW_INFO"));
                        if (C11092i.this.f33903c.isEmpty()) {
                            C11111p.m36577a(3, "JSUpdateLooper", (Object) C11092i.this, "No more active trackers");
                            C11092i.this.f33905e.cancel(true);
                        }
                    } catch (Exception e) {
                        C11102m.m36543a(e);
                    }
                }
            }, 0, (long) C11124w.m36605a().f33974d, TimeUnit.MILLISECONDS);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo36215a(Context context, C11079b bVar) {
        if (bVar != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("addActiveTracker");
            sb.append(bVar.hashCode());
            C11111p.m36577a(3, "JSUpdateLooper", (Object) this, sb.toString());
            Map<C11079b, String> map = this.f33903c;
            if (map != null && !map.containsKey(bVar)) {
                this.f33903c.put(bVar, "");
                m36492b(context);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo36216a(Context context, C11095j jVar) {
        Map<C11095j, String> map = this.f33902b;
        if (map != null && jVar != null) {
            map.put(jVar, "");
            m36490a(context);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo36217a(C11079b bVar) {
        if (bVar != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("removeActiveTracker");
            sb.append(bVar.hashCode());
            C11111p.m36577a(3, "JSUpdateLooper", (Object) this, sb.toString());
            Map<C11079b, String> map = this.f33903c;
            if (map != null) {
                map.remove(bVar);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo36218a(C11095j jVar) {
        if (jVar != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("removeSetupNeededBridge");
            sb.append(jVar.hashCode());
            C11111p.m36577a(3, "JSUpdateLooper", (Object) this, sb.toString());
            Map<C11095j, String> map = this.f33902b;
            if (map != null) {
                map.remove(jVar);
            }
        }
    }
}
