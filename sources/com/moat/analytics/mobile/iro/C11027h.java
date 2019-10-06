package com.moat.analytics.mobile.iro;

import android.content.Context;
import android.content.Intent;
import android.support.p000v4.content.C0515e;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* renamed from: com.moat.analytics.mobile.iro.h */
final class C11027h {

    /* renamed from: ˎ */
    private static final C11027h f33710 = new C11027h();
    /* access modifiers changed from: private */

    /* renamed from: ʽ */
    public ScheduledFuture<?> f33711;

    /* renamed from: ˊ */
    private final ScheduledExecutorService f33712 = Executors.newScheduledThreadPool(1);
    /* access modifiers changed from: private */

    /* renamed from: ˋ */
    public final Map<C11019f, String> f33713 = new WeakHashMap();
    /* access modifiers changed from: private */

    /* renamed from: ˏ */
    public ScheduledFuture<?> f33714;
    /* access modifiers changed from: private */

    /* renamed from: ॱ */
    public final Map<C11015c, String> f33715 = new WeakHashMap();

    /* renamed from: ˋ */
    static C11027h m36301() {
        return f33710;
    }

    private C11027h() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˎ */
    public final void mo36097(final Context context, C11019f fVar) {
        if (fVar != null) {
            this.f33713.put(fVar, "");
            ScheduledFuture<?> scheduledFuture = this.f33711;
            if (scheduledFuture == null || scheduledFuture.isDone()) {
                C11011b.m36234(3, "JSUpdateLooper", this, "Starting metadata reporting loop");
                this.f33711 = this.f33712.scheduleWithFixedDelay(new Runnable() {
                    public final void run() {
                        try {
                            C0515e.m2597a(context.getApplicationContext()).mo5314a(new Intent("UPDATE_METADATA"));
                            if (C11027h.this.f33713.isEmpty()) {
                                C11027h.this.f33711.cancel(true);
                            }
                        } catch (Exception e) {
                            C11043o.m36351(e);
                        }
                    }
                }, 0, 50, TimeUnit.MILLISECONDS);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˎ */
    public final void mo36098(C11019f fVar) {
        if (fVar != null) {
            StringBuilder sb = new StringBuilder("removeSetupNeededBridge");
            sb.append(fVar.hashCode());
            C11011b.m36234(3, "JSUpdateLooper", this, sb.toString());
            this.f33713.remove(fVar);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˋ */
    public final void mo36096(final Context context, C11015c cVar) {
        if (cVar != null) {
            StringBuilder sb = new StringBuilder("addActiveTracker");
            sb.append(cVar.hashCode());
            String str = "JSUpdateLooper";
            C11011b.m36234(3, str, this, sb.toString());
            if (!this.f33715.containsKey(cVar)) {
                this.f33715.put(cVar, "");
                ScheduledFuture<?> scheduledFuture = this.f33714;
                if (scheduledFuture == null || scheduledFuture.isDone()) {
                    C11011b.m36234(3, str, this, "Starting view update loop");
                    this.f33714 = this.f33712.scheduleWithFixedDelay(new Runnable() {
                        public final void run() {
                            try {
                                C0515e.m2597a(context.getApplicationContext()).mo5314a(new Intent("UPDATE_VIEW_INFO"));
                                if (C11027h.this.f33715.isEmpty()) {
                                    C11011b.m36234(3, "JSUpdateLooper", C11027h.this, "No more active trackers");
                                    C11027h.this.f33714.cancel(true);
                                }
                            } catch (Exception e) {
                                C11043o.m36351(e);
                            }
                        }
                    }, 0, (long) C11054t.m36390().f33799, TimeUnit.MILLISECONDS);
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ॱ */
    public final void mo36099(C11015c cVar) {
        if (cVar != null) {
            StringBuilder sb = new StringBuilder("removeActiveTracker");
            sb.append(cVar.hashCode());
            C11011b.m36234(3, "JSUpdateLooper", this, sb.toString());
            this.f33715.remove(cVar);
        }
    }
}
