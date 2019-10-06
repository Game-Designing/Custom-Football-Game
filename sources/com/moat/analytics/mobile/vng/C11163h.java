package com.moat.analytics.mobile.vng;

import android.support.p001v7.widget.LinearLayoutManager;
import android.view.View;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.moat.analytics.mobile.vng.h */
abstract class C11163h<PlayerOrIMAAd> extends C11154c<PlayerOrIMAAd> {

    /* renamed from: l */
    int f34075l = LinearLayoutManager.INVALID_OFFSET;

    /* renamed from: m */
    private C11165a f34076m = C11165a.UNINITIALIZED;

    /* renamed from: n */
    private int f34077n = LinearLayoutManager.INVALID_OFFSET;

    /* renamed from: o */
    private double f34078o = Double.NaN;

    /* renamed from: p */
    private int f34079p = LinearLayoutManager.INVALID_OFFSET;

    /* renamed from: q */
    private int f34080q = 0;

    /* renamed from: com.moat.analytics.mobile.vng.h$a */
    protected enum C11165a {
        UNINITIALIZED,
        PAUSED,
        PLAYING,
        STOPPED,
        COMPLETED
    }

    C11163h(String str) {
        super(str);
    }

    /* renamed from: n */
    private void m36721n() {
        this.f34054h.postDelayed(new Runnable() {
            public void run() {
                C11163h hVar;
                try {
                    if (C11163h.this.f34056j.get() == null || C11163h.this.mo36334i()) {
                        hVar = C11163h.this;
                    } else if (Boolean.valueOf(C11163h.this.mo36345m()).booleanValue()) {
                        C11163h.this.f34054h.postDelayed(this, 200);
                        return;
                    } else {
                        hVar = C11163h.this;
                    }
                    hVar.mo36333h();
                } catch (Exception e) {
                    C11163h.this.mo36333h();
                    C11176m.m36783a(e);
                }
            }
        }, 200);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public JSONObject mo36328a(MoatAdEvent moatAdEvent) {
        Integer num;
        if (!moatAdEvent.f34024b.equals(MoatAdEvent.f34022a)) {
            num = moatAdEvent.f34024b;
        } else {
            try {
                num = mo36342j();
            } catch (Exception e) {
                num = Integer.valueOf(this.f34077n);
            }
            moatAdEvent.f34024b = num;
        }
        if (moatAdEvent.f34024b.intValue() < 0 || (moatAdEvent.f34024b.intValue() == 0 && moatAdEvent.f34026d == MoatAdEventType.AD_EVT_COMPLETE && this.f34077n > 0)) {
            num = Integer.valueOf(this.f34077n);
            moatAdEvent.f34024b = num;
        }
        if (moatAdEvent.f34026d == MoatAdEventType.AD_EVT_COMPLETE) {
            if (num.intValue() != Integer.MIN_VALUE) {
                int i = this.f34075l;
                if (i != Integer.MIN_VALUE && mo36329a(num, Integer.valueOf(i))) {
                    this.f34076m = C11165a.COMPLETED;
                }
            }
            this.f34076m = C11165a.STOPPED;
            moatAdEvent.f34026d = MoatAdEventType.AD_EVT_STOPPED;
        }
        return super.mo36328a(moatAdEvent);
    }

    /* renamed from: a */
    public boolean mo36330a(Map<String, String> map, PlayerOrIMAAd playerorimaad, View view) {
        try {
            if (!this.f34047e) {
                m36721n();
            }
        } catch (Exception e) {
            C11176m.m36783a(e);
        }
        return super.mo36330a(map, playerorimaad, view);
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public abstract Integer mo36342j();

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public abstract boolean mo36343k();

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public abstract Integer mo36344l();

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x009b A[Catch:{ Exception -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x009d A[Catch:{ Exception -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00bd A[Catch:{ Exception -> 0x00d2 }] */
    /* renamed from: m */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo36345m() {
        /*
            r12 = this;
            java.lang.ref.WeakReference<PlayerOrIMAAd> r0 = r12.f34056j
            java.lang.Object r0 = r0.get()
            r1 = 0
            if (r0 == 0) goto L_0x00df
            boolean r0 = r12.mo36334i()
            if (r0 == 0) goto L_0x0011
            goto L_0x00df
        L_0x0011:
            r0 = 1
            java.lang.Integer r2 = r12.mo36342j()     // Catch:{ Exception -> 0x00d2 }
            int r2 = r2.intValue()     // Catch:{ Exception -> 0x00d2 }
            int r3 = r12.f34077n     // Catch:{ Exception -> 0x00d2 }
            if (r3 < 0) goto L_0x0021
            if (r2 >= 0) goto L_0x0021
            return r1
        L_0x0021:
            r12.f34077n = r2     // Catch:{ Exception -> 0x00d2 }
            if (r2 != 0) goto L_0x0026
            return r0
        L_0x0026:
            java.lang.Integer r3 = r12.mo36344l()     // Catch:{ Exception -> 0x00d2 }
            int r3 = r3.intValue()     // Catch:{ Exception -> 0x00d2 }
            boolean r4 = r12.mo36343k()     // Catch:{ Exception -> 0x00d2 }
            double r5 = (double) r3
            r7 = 4616189618054758400(0x4010000000000000, double:4.0)
            java.lang.Double.isNaN(r5)
            double r5 = r5 / r7
            double r7 = com.moat.analytics.mobile.vng.C11187s.m36823a()     // Catch:{ Exception -> 0x00d2 }
            r9 = 0
            int r10 = r12.f34079p     // Catch:{ Exception -> 0x00d2 }
            if (r2 <= r10) goto L_0x0044
            r12.f34079p = r2     // Catch:{ Exception -> 0x00d2 }
        L_0x0044:
            int r10 = r12.f34075l     // Catch:{ Exception -> 0x00d2 }
            r11 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r10 != r11) goto L_0x004c
            r12.f34075l = r3     // Catch:{ Exception -> 0x00d2 }
        L_0x004c:
            if (r4 == 0) goto L_0x008e
            com.moat.analytics.mobile.vng.h$a r3 = r12.f34076m     // Catch:{ Exception -> 0x00d2 }
            com.moat.analytics.mobile.vng.h$a r4 = com.moat.analytics.mobile.vng.C11163h.C11165a.UNINITIALIZED     // Catch:{ Exception -> 0x00d2 }
            if (r3 != r4) goto L_0x005b
            com.moat.analytics.mobile.vng.MoatAdEventType r9 = com.moat.analytics.mobile.vng.MoatAdEventType.AD_EVT_START     // Catch:{ Exception -> 0x00d2 }
            com.moat.analytics.mobile.vng.h$a r3 = com.moat.analytics.mobile.vng.C11163h.C11165a.PLAYING     // Catch:{ Exception -> 0x00d2 }
        L_0x0058:
            r12.f34076m = r3     // Catch:{ Exception -> 0x00d2 }
            goto L_0x0099
        L_0x005b:
            com.moat.analytics.mobile.vng.h$a r3 = r12.f34076m     // Catch:{ Exception -> 0x00d2 }
            com.moat.analytics.mobile.vng.h$a r4 = com.moat.analytics.mobile.vng.C11163h.C11165a.PAUSED     // Catch:{ Exception -> 0x00d2 }
            if (r3 != r4) goto L_0x0066
            com.moat.analytics.mobile.vng.MoatAdEventType r9 = com.moat.analytics.mobile.vng.MoatAdEventType.AD_EVT_PLAYING     // Catch:{ Exception -> 0x00d2 }
            com.moat.analytics.mobile.vng.h$a r3 = com.moat.analytics.mobile.vng.C11163h.C11165a.PLAYING     // Catch:{ Exception -> 0x00d2 }
            goto L_0x0058
        L_0x0066:
            double r3 = (double) r2
            java.lang.Double.isNaN(r3)
            double r3 = r3 / r5
            double r3 = java.lang.Math.floor(r3)     // Catch:{ Exception -> 0x00d2 }
            int r3 = (int) r3     // Catch:{ Exception -> 0x00d2 }
            int r3 = r3 - r0
            r4 = -1
            if (r3 <= r4) goto L_0x0099
            r4 = 3
            if (r3 >= r4) goto L_0x0099
            com.moat.analytics.mobile.vng.MoatAdEventType[] r4 = com.moat.analytics.mobile.vng.C11154c.f34052f     // Catch:{ Exception -> 0x00d2 }
            r3 = r4[r3]     // Catch:{ Exception -> 0x00d2 }
            java.util.Map<com.moat.analytics.mobile.vng.MoatAdEventType, java.lang.Integer> r4 = r12.f34053g     // Catch:{ Exception -> 0x00d2 }
            boolean r4 = r4.containsKey(r3)     // Catch:{ Exception -> 0x00d2 }
            if (r4 != 0) goto L_0x0099
            java.util.Map<com.moat.analytics.mobile.vng.MoatAdEventType, java.lang.Integer> r4 = r12.f34053g     // Catch:{ Exception -> 0x00d2 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x00d2 }
            r4.put(r3, r5)     // Catch:{ Exception -> 0x00d2 }
            r9 = r3
            goto L_0x0099
        L_0x008e:
            com.moat.analytics.mobile.vng.h$a r3 = r12.f34076m     // Catch:{ Exception -> 0x00d2 }
            com.moat.analytics.mobile.vng.h$a r4 = com.moat.analytics.mobile.vng.C11163h.C11165a.PAUSED     // Catch:{ Exception -> 0x00d2 }
            if (r3 == r4) goto L_0x0099
            com.moat.analytics.mobile.vng.MoatAdEventType r9 = com.moat.analytics.mobile.vng.MoatAdEventType.AD_EVT_PAUSED     // Catch:{ Exception -> 0x00d2 }
            com.moat.analytics.mobile.vng.h$a r3 = com.moat.analytics.mobile.vng.C11163h.C11165a.PAUSED     // Catch:{ Exception -> 0x00d2 }
            goto L_0x0058
        L_0x0099:
            if (r9 == 0) goto L_0x009d
            r3 = 1
            goto L_0x009e
        L_0x009d:
            r3 = 0
        L_0x009e:
            if (r3 != 0) goto L_0x00bb
            double r4 = r12.f34078o     // Catch:{ Exception -> 0x00d2 }
            boolean r4 = java.lang.Double.isNaN(r4)     // Catch:{ Exception -> 0x00d2 }
            if (r4 != 0) goto L_0x00bb
            double r4 = r12.f34078o     // Catch:{ Exception -> 0x00d2 }
            double r4 = r4 - r7
            double r4 = java.lang.Math.abs(r4)     // Catch:{ Exception -> 0x00d2 }
            r10 = 4587366580439587226(0x3fa999999999999a, double:0.05)
            int r6 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r6 <= 0) goto L_0x00bb
            com.moat.analytics.mobile.vng.MoatAdEventType r9 = com.moat.analytics.mobile.vng.MoatAdEventType.AD_EVT_VOLUME_CHANGE     // Catch:{ Exception -> 0x00d2 }
            r3 = 1
        L_0x00bb:
            if (r3 == 0) goto L_0x00cd
            com.moat.analytics.mobile.vng.MoatAdEvent r3 = new com.moat.analytics.mobile.vng.MoatAdEvent     // Catch:{ Exception -> 0x00d2 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x00d2 }
            java.lang.Double r4 = java.lang.Double.valueOf(r7)     // Catch:{ Exception -> 0x00d2 }
            r3.<init>(r9, r2, r4)     // Catch:{ Exception -> 0x00d2 }
            r12.dispatchEvent(r3)     // Catch:{ Exception -> 0x00d2 }
        L_0x00cd:
            r12.f34078o = r7     // Catch:{ Exception -> 0x00d2 }
            r12.f34080q = r1     // Catch:{ Exception -> 0x00d2 }
            return r0
        L_0x00d2:
            r2 = move-exception
            int r2 = r12.f34080q
            int r3 = r2 + 1
            r12.f34080q = r3
            r3 = 5
            if (r2 >= r3) goto L_0x00dd
            goto L_0x00de
        L_0x00dd:
            r0 = 0
        L_0x00de:
            return r0
        L_0x00df:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moat.analytics.mobile.vng.C11163h.mo36345m():boolean");
    }

    public void stopTracking() {
        try {
            dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_COMPLETE));
            StringBuilder sb = new StringBuilder();
            sb.append(mo36311a());
            sb.append(" stopTracking succeeded for ");
            sb.append(mo36323e());
            C11185p.m36819a("[SUCCESS] ", sb.toString());
        } catch (Exception e) {
            C11176m.m36783a(e);
        }
    }
}
