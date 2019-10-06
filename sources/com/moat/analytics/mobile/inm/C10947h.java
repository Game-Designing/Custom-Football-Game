package com.moat.analytics.mobile.inm;

import android.support.p001v7.widget.LinearLayoutManager;
import android.view.View;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.moat.analytics.mobile.inm.h */
abstract class C10947h extends C10936c {

    /* renamed from: l */
    int f33460l = LinearLayoutManager.INVALID_OFFSET;

    /* renamed from: m */
    private C10949a f33461m = C10949a.UNINITIALIZED;

    /* renamed from: n */
    private int f33462n = LinearLayoutManager.INVALID_OFFSET;

    /* renamed from: o */
    private double f33463o = Double.NaN;

    /* renamed from: p */
    private int f33464p = LinearLayoutManager.INVALID_OFFSET;

    /* renamed from: q */
    private int f33465q = 0;

    /* renamed from: com.moat.analytics.mobile.inm.h$a */
    enum C10949a {
        UNINITIALIZED,
        PAUSED,
        PLAYING,
        STOPPED,
        COMPLETED
    }

    C10947h(String str) {
        super(str);
    }

    /* renamed from: t */
    private void m36006t() {
        this.f33434i.postDelayed(new Runnable() {
            public void run() {
                try {
                    if (!C10947h.this.mo35925n() || C10947h.this.mo35912m()) {
                        C10947h.this.mo35911l();
                    } else if (Boolean.valueOf(C10947h.this.mo35930s()).booleanValue()) {
                        C10947h.this.f33434i.postDelayed(this, 200);
                    } else {
                        C10947h.this.mo35911l();
                    }
                } catch (Exception e) {
                    C10947h.this.mo35911l();
                    C10960m.m36077a(e);
                }
            }
        }, 200);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public JSONObject mo35904a(MoatAdEvent moatAdEvent) {
        Integer num;
        if (!moatAdEvent.f33403b.equals(MoatAdEvent.f33401a)) {
            num = moatAdEvent.f33403b;
        } else {
            try {
                num = mo35926o();
            } catch (Exception e) {
                num = Integer.valueOf(this.f33462n);
            }
            moatAdEvent.f33403b = num;
        }
        if (moatAdEvent.f33403b.intValue() < 0 || (moatAdEvent.f33403b.intValue() == 0 && moatAdEvent.f33405d == MoatAdEventType.AD_EVT_COMPLETE && this.f33462n > 0)) {
            num = Integer.valueOf(this.f33462n);
            moatAdEvent.f33403b = num;
        }
        if (moatAdEvent.f33405d == MoatAdEventType.AD_EVT_COMPLETE) {
            if (num.intValue() != Integer.MIN_VALUE) {
                int i = this.f33460l;
                if (i != Integer.MIN_VALUE && mo35905a(num, Integer.valueOf(i))) {
                    this.f33461m = C10949a.COMPLETED;
                }
            }
            this.f33461m = C10949a.STOPPED;
            moatAdEvent.f33405d = MoatAdEventType.AD_EVT_STOPPED;
        }
        return super.mo35904a(moatAdEvent);
    }

    /* renamed from: a */
    public boolean mo35906a(Map<String, String> map, View view) {
        try {
            boolean a = super.mo35906a(map, view);
            if (!a || !mo35927p()) {
                return a;
            }
            m36006t();
            return a;
        } catch (Exception e) {
            C10969p.m36113a(3, "IntervalVideoTracker", (Object) this, "Problem with video loop");
            mo35889a("trackVideoAd", e);
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: n */
    public abstract boolean mo35925n();

    /* access modifiers changed from: 0000 */
    /* renamed from: o */
    public abstract Integer mo35926o();

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public boolean mo35927p() {
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: q */
    public abstract boolean mo35928q();

    /* access modifiers changed from: 0000 */
    /* renamed from: r */
    public abstract Integer mo35929r();

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x009c A[Catch:{ Exception -> 0x00d3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x009e A[Catch:{ Exception -> 0x00d3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00be A[Catch:{ Exception -> 0x00d3 }] */
    /* renamed from: s */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo35930s() {
        /*
            r12 = this;
            boolean r0 = r12.mo35925n()
            r1 = 0
            if (r0 == 0) goto L_0x00de
            boolean r0 = r12.mo35912m()
            if (r0 == 0) goto L_0x000f
            goto L_0x00de
        L_0x000f:
            r0 = 1
            java.lang.Integer r2 = r12.mo35926o()     // Catch:{ Exception -> 0x00d3 }
            int r2 = r2.intValue()     // Catch:{ Exception -> 0x00d3 }
            int r3 = r12.f33462n     // Catch:{ Exception -> 0x00d3 }
            if (r3 < 0) goto L_0x001f
            if (r2 >= 0) goto L_0x001f
            return r1
        L_0x001f:
            r12.f33462n = r2     // Catch:{ Exception -> 0x00d3 }
            if (r2 != 0) goto L_0x0024
            return r0
        L_0x0024:
            java.lang.Integer r3 = r12.mo35929r()     // Catch:{ Exception -> 0x00d3 }
            int r3 = r3.intValue()     // Catch:{ Exception -> 0x00d3 }
            boolean r4 = r12.mo35928q()     // Catch:{ Exception -> 0x00d3 }
            double r5 = (double) r3
            r7 = 4616189618054758400(0x4010000000000000, double:4.0)
            java.lang.Double.isNaN(r5)
            double r5 = r5 / r7
            java.lang.Double r7 = r12.mo35909j()     // Catch:{ Exception -> 0x00d3 }
            double r7 = r7.doubleValue()     // Catch:{ Exception -> 0x00d3 }
            r9 = 0
            int r10 = r12.f33464p     // Catch:{ Exception -> 0x00d3 }
            if (r2 <= r10) goto L_0x0046
            r12.f33464p = r2     // Catch:{ Exception -> 0x00d3 }
        L_0x0046:
            int r10 = r12.f33460l     // Catch:{ Exception -> 0x00d3 }
            r11 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r10 != r11) goto L_0x004e
            r12.f33460l = r3     // Catch:{ Exception -> 0x00d3 }
        L_0x004e:
            if (r4 == 0) goto L_0x008f
            com.moat.analytics.mobile.inm.h$a r3 = r12.f33461m     // Catch:{ Exception -> 0x00d3 }
            com.moat.analytics.mobile.inm.h$a r4 = com.moat.analytics.mobile.inm.C10947h.C10949a.UNINITIALIZED     // Catch:{ Exception -> 0x00d3 }
            if (r3 != r4) goto L_0x005d
            com.moat.analytics.mobile.inm.MoatAdEventType r9 = com.moat.analytics.mobile.inm.MoatAdEventType.AD_EVT_START     // Catch:{ Exception -> 0x00d3 }
            com.moat.analytics.mobile.inm.h$a r3 = com.moat.analytics.mobile.inm.C10947h.C10949a.PLAYING     // Catch:{ Exception -> 0x00d3 }
        L_0x005a:
            r12.f33461m = r3     // Catch:{ Exception -> 0x00d3 }
            goto L_0x009a
        L_0x005d:
            com.moat.analytics.mobile.inm.h$a r3 = r12.f33461m     // Catch:{ Exception -> 0x00d3 }
            com.moat.analytics.mobile.inm.h$a r4 = com.moat.analytics.mobile.inm.C10947h.C10949a.PAUSED     // Catch:{ Exception -> 0x00d3 }
            if (r3 != r4) goto L_0x0068
            com.moat.analytics.mobile.inm.MoatAdEventType r9 = com.moat.analytics.mobile.inm.MoatAdEventType.AD_EVT_PLAYING     // Catch:{ Exception -> 0x00d3 }
            com.moat.analytics.mobile.inm.h$a r3 = com.moat.analytics.mobile.inm.C10947h.C10949a.PLAYING     // Catch:{ Exception -> 0x00d3 }
            goto L_0x005a
        L_0x0068:
            double r3 = (double) r2
            java.lang.Double.isNaN(r3)
            double r3 = r3 / r5
            double r3 = java.lang.Math.floor(r3)     // Catch:{ Exception -> 0x00d3 }
            int r3 = (int) r3     // Catch:{ Exception -> 0x00d3 }
            int r3 = r3 - r0
            if (r3 < 0) goto L_0x009a
            r4 = 3
            if (r3 >= r4) goto L_0x009a
            com.moat.analytics.mobile.inm.MoatAdEventType[] r4 = com.moat.analytics.mobile.inm.C10936c.f33432g     // Catch:{ Exception -> 0x00d3 }
            r3 = r4[r3]     // Catch:{ Exception -> 0x00d3 }
            java.util.Map<com.moat.analytics.mobile.inm.MoatAdEventType, java.lang.Integer> r4 = r12.f33433h     // Catch:{ Exception -> 0x00d3 }
            boolean r4 = r4.containsKey(r3)     // Catch:{ Exception -> 0x00d3 }
            if (r4 != 0) goto L_0x009a
            java.util.Map<com.moat.analytics.mobile.inm.MoatAdEventType, java.lang.Integer> r4 = r12.f33433h     // Catch:{ Exception -> 0x00d3 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x00d3 }
            r4.put(r3, r5)     // Catch:{ Exception -> 0x00d3 }
            r9 = r3
            goto L_0x009a
        L_0x008f:
            com.moat.analytics.mobile.inm.h$a r3 = r12.f33461m     // Catch:{ Exception -> 0x00d3 }
            com.moat.analytics.mobile.inm.h$a r4 = com.moat.analytics.mobile.inm.C10947h.C10949a.PAUSED     // Catch:{ Exception -> 0x00d3 }
            if (r3 == r4) goto L_0x009a
            com.moat.analytics.mobile.inm.MoatAdEventType r9 = com.moat.analytics.mobile.inm.MoatAdEventType.AD_EVT_PAUSED     // Catch:{ Exception -> 0x00d3 }
            com.moat.analytics.mobile.inm.h$a r3 = com.moat.analytics.mobile.inm.C10947h.C10949a.PAUSED     // Catch:{ Exception -> 0x00d3 }
            goto L_0x005a
        L_0x009a:
            if (r9 == 0) goto L_0x009e
            r3 = 1
            goto L_0x009f
        L_0x009e:
            r3 = 0
        L_0x009f:
            if (r3 != 0) goto L_0x00bc
            double r4 = r12.f33463o     // Catch:{ Exception -> 0x00d3 }
            boolean r4 = java.lang.Double.isNaN(r4)     // Catch:{ Exception -> 0x00d3 }
            if (r4 != 0) goto L_0x00bc
            double r4 = r12.f33463o     // Catch:{ Exception -> 0x00d3 }
            double r4 = r4 - r7
            double r4 = java.lang.Math.abs(r4)     // Catch:{ Exception -> 0x00d3 }
            r10 = 4587366580439587226(0x3fa999999999999a, double:0.05)
            int r6 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r6 <= 0) goto L_0x00bc
            com.moat.analytics.mobile.inm.MoatAdEventType r9 = com.moat.analytics.mobile.inm.MoatAdEventType.AD_EVT_VOLUME_CHANGE     // Catch:{ Exception -> 0x00d3 }
            r3 = 1
        L_0x00bc:
            if (r3 == 0) goto L_0x00ce
            com.moat.analytics.mobile.inm.MoatAdEvent r3 = new com.moat.analytics.mobile.inm.MoatAdEvent     // Catch:{ Exception -> 0x00d3 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x00d3 }
            java.lang.Double r4 = r12.mo35910k()     // Catch:{ Exception -> 0x00d3 }
            r3.<init>(r9, r2, r4)     // Catch:{ Exception -> 0x00d3 }
            r12.dispatchEvent(r3)     // Catch:{ Exception -> 0x00d3 }
        L_0x00ce:
            r12.f33463o = r7     // Catch:{ Exception -> 0x00d3 }
            r12.f33465q = r1     // Catch:{ Exception -> 0x00d3 }
            return r0
        L_0x00d3:
            r2 = move-exception
            int r2 = r12.f33465q
            int r3 = r2 + 1
            r12.f33465q = r3
            r3 = 5
            if (r2 >= r3) goto L_0x00de
            return r0
        L_0x00de:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moat.analytics.mobile.inm.C10947h.mo35930s():boolean");
    }

    public void setPlayerVolume(Double d) {
        super.setPlayerVolume(d);
        this.f33463o = mo35909j().doubleValue();
    }

    public void stopTracking() {
        try {
            dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_COMPLETE));
            super.stopTracking();
        } catch (Exception e) {
            C10960m.m36077a(e);
        }
    }
}
