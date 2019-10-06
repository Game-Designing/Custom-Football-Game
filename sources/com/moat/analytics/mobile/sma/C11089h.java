package com.moat.analytics.mobile.sma;

import android.support.p001v7.widget.LinearLayoutManager;
import android.view.View;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.moat.analytics.mobile.sma.h */
abstract class C11089h<PlayerOrIMAAd> extends C11080c<PlayerOrIMAAd> {

    /* renamed from: l */
    int f33888l = LinearLayoutManager.INVALID_OFFSET;

    /* renamed from: m */
    private C11091a f33889m = C11091a.UNINITIALIZED;

    /* renamed from: n */
    private int f33890n = LinearLayoutManager.INVALID_OFFSET;

    /* renamed from: o */
    private double f33891o = Double.NaN;

    /* renamed from: p */
    private int f33892p = LinearLayoutManager.INVALID_OFFSET;

    /* renamed from: q */
    private int f33893q = 0;

    /* renamed from: com.moat.analytics.mobile.sma.h$a */
    protected enum C11091a {
        UNINITIALIZED,
        PAUSED,
        PLAYING,
        STOPPED,
        COMPLETED
    }

    C11089h(String str) {
        super(str);
    }

    /* renamed from: q */
    private void m36480q() {
        this.f33867h.postDelayed(new Runnable() {
            public void run() {
                C11089h hVar;
                try {
                    if (C11089h.this.f33869j.get() == null || C11089h.this.mo36201k()) {
                        hVar = C11089h.this;
                    } else if (Boolean.valueOf(C11089h.this.mo36213p()).booleanValue()) {
                        C11089h.this.f33867h.postDelayed(this, 200);
                        return;
                    } else {
                        hVar = C11089h.this;
                    }
                    hVar.mo36200j();
                } catch (Exception e) {
                    C11089h.this.mo36200j();
                    C11102m.m36543a(e);
                }
            }
        }, 200);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public JSONObject mo36193a(MoatAdEvent moatAdEvent) {
        Integer num;
        if (!moatAdEvent.f33839b.equals(MoatAdEvent.f33837a)) {
            num = moatAdEvent.f33839b;
        } else {
            try {
                num = mo36210m();
            } catch (Exception e) {
                num = Integer.valueOf(this.f33890n);
            }
            moatAdEvent.f33839b = num;
        }
        if (moatAdEvent.f33839b.intValue() < 0 || (moatAdEvent.f33839b.intValue() == 0 && moatAdEvent.f33842e == MoatAdEventType.AD_EVT_COMPLETE && this.f33890n > 0)) {
            num = Integer.valueOf(this.f33890n);
            moatAdEvent.f33839b = num;
        }
        if (moatAdEvent.f33842e == MoatAdEventType.AD_EVT_COMPLETE) {
            if (num.intValue() != Integer.MIN_VALUE) {
                int i = this.f33888l;
                if (i != Integer.MIN_VALUE && mo36194a(num, Integer.valueOf(i))) {
                    this.f33889m = C11091a.COMPLETED;
                }
            }
            this.f33889m = C11091a.STOPPED;
            moatAdEvent.f33842e = MoatAdEventType.AD_EVT_STOPPED;
        }
        return super.mo36193a(moatAdEvent);
    }

    /* renamed from: a */
    public boolean mo36195a(Map<String, String> map, PlayerOrIMAAd playerorimaad, View view) {
        try {
            if (!this.f33860e && mo36209l()) {
                m36480q();
            }
        } catch (Exception e) {
            C11102m.m36543a(e);
        }
        return super.mo36195a(map, playerorimaad, view);
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public boolean mo36209l() {
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public abstract Integer mo36210m();

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public abstract boolean mo36211n();

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public abstract Integer mo36212o();

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x009f A[Catch:{ Exception -> 0x00d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00a1 A[Catch:{ Exception -> 0x00d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00c1 A[Catch:{ Exception -> 0x00d6 }] */
    /* renamed from: p */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo36213p() {
        /*
            r12 = this;
            java.lang.ref.WeakReference<PlayerOrIMAAd> r0 = r12.f33869j
            java.lang.Object r0 = r0.get()
            r1 = 0
            if (r0 == 0) goto L_0x00e3
            boolean r0 = r12.mo36201k()
            if (r0 == 0) goto L_0x0011
            goto L_0x00e3
        L_0x0011:
            r0 = 1
            java.lang.Integer r2 = r12.mo36210m()     // Catch:{ Exception -> 0x00d6 }
            int r2 = r2.intValue()     // Catch:{ Exception -> 0x00d6 }
            int r3 = r12.f33890n     // Catch:{ Exception -> 0x00d6 }
            if (r3 < 0) goto L_0x0021
            if (r2 >= 0) goto L_0x0021
            return r1
        L_0x0021:
            r12.f33890n = r2     // Catch:{ Exception -> 0x00d6 }
            if (r2 != 0) goto L_0x0026
            return r0
        L_0x0026:
            java.lang.Integer r3 = r12.mo36212o()     // Catch:{ Exception -> 0x00d6 }
            int r3 = r3.intValue()     // Catch:{ Exception -> 0x00d6 }
            boolean r4 = r12.mo36211n()     // Catch:{ Exception -> 0x00d6 }
            double r5 = (double) r3
            r7 = 4616189618054758400(0x4010000000000000, double:4.0)
            java.lang.Double.isNaN(r5)
            double r5 = r5 / r7
            java.lang.Double r7 = r12.mo36198h()     // Catch:{ Exception -> 0x00d6 }
            double r7 = r7.doubleValue()     // Catch:{ Exception -> 0x00d6 }
            r9 = 0
            int r10 = r12.f33892p     // Catch:{ Exception -> 0x00d6 }
            if (r2 <= r10) goto L_0x0048
            r12.f33892p = r2     // Catch:{ Exception -> 0x00d6 }
        L_0x0048:
            int r10 = r12.f33888l     // Catch:{ Exception -> 0x00d6 }
            r11 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r10 != r11) goto L_0x0050
            r12.f33888l = r3     // Catch:{ Exception -> 0x00d6 }
        L_0x0050:
            if (r4 == 0) goto L_0x0092
            com.moat.analytics.mobile.sma.h$a r3 = r12.f33889m     // Catch:{ Exception -> 0x00d6 }
            com.moat.analytics.mobile.sma.h$a r4 = com.moat.analytics.mobile.sma.C11089h.C11091a.UNINITIALIZED     // Catch:{ Exception -> 0x00d6 }
            if (r3 != r4) goto L_0x005f
            com.moat.analytics.mobile.sma.MoatAdEventType r9 = com.moat.analytics.mobile.sma.MoatAdEventType.AD_EVT_START     // Catch:{ Exception -> 0x00d6 }
            com.moat.analytics.mobile.sma.h$a r3 = com.moat.analytics.mobile.sma.C11089h.C11091a.PLAYING     // Catch:{ Exception -> 0x00d6 }
        L_0x005c:
            r12.f33889m = r3     // Catch:{ Exception -> 0x00d6 }
            goto L_0x009d
        L_0x005f:
            com.moat.analytics.mobile.sma.h$a r3 = r12.f33889m     // Catch:{ Exception -> 0x00d6 }
            com.moat.analytics.mobile.sma.h$a r4 = com.moat.analytics.mobile.sma.C11089h.C11091a.PAUSED     // Catch:{ Exception -> 0x00d6 }
            if (r3 != r4) goto L_0x006a
            com.moat.analytics.mobile.sma.MoatAdEventType r9 = com.moat.analytics.mobile.sma.MoatAdEventType.AD_EVT_PLAYING     // Catch:{ Exception -> 0x00d6 }
            com.moat.analytics.mobile.sma.h$a r3 = com.moat.analytics.mobile.sma.C11089h.C11091a.PLAYING     // Catch:{ Exception -> 0x00d6 }
            goto L_0x005c
        L_0x006a:
            double r3 = (double) r2
            java.lang.Double.isNaN(r3)
            double r3 = r3 / r5
            double r3 = java.lang.Math.floor(r3)     // Catch:{ Exception -> 0x00d6 }
            int r3 = (int) r3     // Catch:{ Exception -> 0x00d6 }
            int r3 = r3 - r0
            r4 = -1
            if (r3 <= r4) goto L_0x009d
            r4 = 3
            if (r3 >= r4) goto L_0x009d
            com.moat.analytics.mobile.sma.MoatAdEventType[] r4 = com.moat.analytics.mobile.sma.C11080c.f33865f     // Catch:{ Exception -> 0x00d6 }
            r3 = r4[r3]     // Catch:{ Exception -> 0x00d6 }
            java.util.Map<com.moat.analytics.mobile.sma.MoatAdEventType, java.lang.Integer> r4 = r12.f33866g     // Catch:{ Exception -> 0x00d6 }
            boolean r4 = r4.containsKey(r3)     // Catch:{ Exception -> 0x00d6 }
            if (r4 != 0) goto L_0x009d
            java.util.Map<com.moat.analytics.mobile.sma.MoatAdEventType, java.lang.Integer> r4 = r12.f33866g     // Catch:{ Exception -> 0x00d6 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x00d6 }
            r4.put(r3, r5)     // Catch:{ Exception -> 0x00d6 }
            r9 = r3
            goto L_0x009d
        L_0x0092:
            com.moat.analytics.mobile.sma.h$a r3 = r12.f33889m     // Catch:{ Exception -> 0x00d6 }
            com.moat.analytics.mobile.sma.h$a r4 = com.moat.analytics.mobile.sma.C11089h.C11091a.PAUSED     // Catch:{ Exception -> 0x00d6 }
            if (r3 == r4) goto L_0x009d
            com.moat.analytics.mobile.sma.MoatAdEventType r9 = com.moat.analytics.mobile.sma.MoatAdEventType.AD_EVT_PAUSED     // Catch:{ Exception -> 0x00d6 }
            com.moat.analytics.mobile.sma.h$a r3 = com.moat.analytics.mobile.sma.C11089h.C11091a.PAUSED     // Catch:{ Exception -> 0x00d6 }
            goto L_0x005c
        L_0x009d:
            if (r9 == 0) goto L_0x00a1
            r3 = 1
            goto L_0x00a2
        L_0x00a1:
            r3 = 0
        L_0x00a2:
            if (r3 != 0) goto L_0x00bf
            double r4 = r12.f33891o     // Catch:{ Exception -> 0x00d6 }
            boolean r4 = java.lang.Double.isNaN(r4)     // Catch:{ Exception -> 0x00d6 }
            if (r4 != 0) goto L_0x00bf
            double r4 = r12.f33891o     // Catch:{ Exception -> 0x00d6 }
            double r4 = r4 - r7
            double r4 = java.lang.Math.abs(r4)     // Catch:{ Exception -> 0x00d6 }
            r10 = 4587366580439587226(0x3fa999999999999a, double:0.05)
            int r6 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r6 <= 0) goto L_0x00bf
            com.moat.analytics.mobile.sma.MoatAdEventType r9 = com.moat.analytics.mobile.sma.MoatAdEventType.AD_EVT_VOLUME_CHANGE     // Catch:{ Exception -> 0x00d6 }
            r3 = 1
        L_0x00bf:
            if (r3 == 0) goto L_0x00d1
            com.moat.analytics.mobile.sma.MoatAdEvent r3 = new com.moat.analytics.mobile.sma.MoatAdEvent     // Catch:{ Exception -> 0x00d6 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x00d6 }
            java.lang.Double r4 = r12.mo36199i()     // Catch:{ Exception -> 0x00d6 }
            r3.<init>(r9, r2, r4)     // Catch:{ Exception -> 0x00d6 }
            r12.dispatchEvent(r3)     // Catch:{ Exception -> 0x00d6 }
        L_0x00d1:
            r12.f33891o = r7     // Catch:{ Exception -> 0x00d6 }
            r12.f33893q = r1     // Catch:{ Exception -> 0x00d6 }
            return r0
        L_0x00d6:
            r2 = move-exception
            int r2 = r12.f33893q
            int r3 = r2 + 1
            r12.f33893q = r3
            r3 = 5
            if (r2 >= r3) goto L_0x00e1
            goto L_0x00e2
        L_0x00e1:
            r0 = 0
        L_0x00e2:
            return r0
        L_0x00e3:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moat.analytics.mobile.sma.C11089h.mo36213p():boolean");
    }

    public void setPlayerVolume(Double d) {
        super.setPlayerVolume(d);
        this.f33891o = mo36198h().doubleValue();
    }

    public void stopTracking() {
        try {
            dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_COMPLETE));
            StringBuilder sb = new StringBuilder();
            sb.append(mo36181a());
            sb.append(" stopTracking succeeded for ");
            sb.append(mo36188e());
            C11111p.m36579a("[SUCCESS] ", sb.toString());
        } catch (Exception e) {
            C11102m.m36543a(e);
        }
    }
}
