package com.moat.analytics.mobile.inm;

import android.content.Context;
import android.content.Intent;
import android.support.p000v4.content.C0515e;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* renamed from: com.moat.analytics.mobile.inm.i */
class C10950i {

    /* renamed from: a */
    private static final C10950i f33473a = new C10950i();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Map<C10953j, String> f33474b = new WeakHashMap();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Map<C10935b, String> f33475c = new WeakHashMap();

    /* renamed from: d */
    private final ScheduledExecutorService f33476d = Executors.newScheduledThreadPool(1);
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ScheduledFuture<?> f33477e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ScheduledFuture<?> f33478f;

    private C10950i() {
    }

    /* renamed from: a */
    static C10950i m36015a() {
        return f33473a;
    }

    /* renamed from: a */
    private void m36017a(final Context context) {
        ScheduledFuture<?> scheduledFuture = this.f33478f;
        if (scheduledFuture == null || scheduledFuture.isDone()) {
            C10969p.m36113a(3, "JSUpdateLooper", (Object) this, "Starting metadata reporting loop");
            this.f33478f = this.f33476d.scheduleWithFixedDelay(new Runnable() {
                public void run() {
                    try {
                        C0515e.m2597a(context.getApplicationContext()).mo5314a(new Intent("UPDATE_METADATA"));
                        if (C10950i.this.f33474b.isEmpty()) {
                            C10950i.this.f33478f.cancel(true);
                        }
                    } catch (Exception e) {
                        C10960m.m36077a(e);
                    }
                }
            }, 0, 50, TimeUnit.MILLISECONDS);
        }
    }

    /* renamed from: b */
    private void m36019b(final Context context) {
        ScheduledFuture<?> scheduledFuture = this.f33477e;
        if (scheduledFuture == null || scheduledFuture.isDone()) {
            C10969p.m36113a(3, "JSUpdateLooper", (Object) this, "Starting view update loop");
            this.f33477e = this.f33476d.scheduleWithFixedDelay(new Runnable() {
                public void run() {
                    try {
                        C0515e.m2597a(context.getApplicationContext()).mo5314a(new Intent("UPDATE_VIEW_INFO"));
                        if (C10950i.this.f33475c.isEmpty()) {
                            C10969p.m36113a(3, "JSUpdateLooper", (Object) C10950i.this, "No more active trackers");
                            C10950i.this.f33477e.cancel(true);
                        }
                    } catch (Exception e) {
                        C10960m.m36077a(e);
                    }
                }
            }, 0, (long) C10984w.m36151a().f33564d, TimeUnit.MILLISECONDS);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo35932a(Context context, C10935b bVar) {
        if (bVar != null) {
            StringBuilder sb = new StringBuilder("addActiveTracker");
            sb.append(bVar.hashCode());
            C10969p.m36113a(3, "JSUpdateLooper", (Object) this, sb.toString());
            Map<C10935b, String> map = this.f33475c;
            if (map != null && !map.containsKey(bVar)) {
                this.f33475c.put(bVar, "");
                m36019b(context);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo35933a(Context context, C10953j jVar) {
        Map<C10953j, String> map = this.f33474b;
        if (map != null && jVar != null) {
            map.put(jVar, "");
            m36017a(context);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo35934a(C10935b bVar) {
        if (bVar != null) {
            StringBuilder sb = new StringBuilder("removeActiveTracker");
            sb.append(bVar.hashCode());
            C10969p.m36113a(3, "JSUpdateLooper", (Object) this, sb.toString());
            Map<C10935b, String> map = this.f33475c;
            if (map != null) {
                map.remove(bVar);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo35935a(C10953j jVar) {
        if (jVar != null) {
            StringBuilder sb = new StringBuilder("removeSetupNeededBridge");
            sb.append(jVar.hashCode());
            C10969p.m36113a(3, "JSUpdateLooper", (Object) this, sb.toString());
            Map<C10953j, String> map = this.f33474b;
            if (map != null) {
                map.remove(jVar);
            }
        }
    }
}
