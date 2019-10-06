package com.moat.analytics.mobile.sma;

import android.os.Handler;
import android.view.View;
import com.mopub.mobileads.VastIconXmlManager;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.moat.analytics.mobile.sma.c */
abstract class C11080c<PlayerOrIMAAd> extends C11079b {

    /* renamed from: f */
    static final MoatAdEventType[] f33865f = {MoatAdEventType.AD_EVT_FIRST_QUARTILE, MoatAdEventType.AD_EVT_MID_POINT, MoatAdEventType.AD_EVT_THIRD_QUARTILE};

    /* renamed from: g */
    final Map<MoatAdEventType, Integer> f33866g;

    /* renamed from: h */
    final Handler f33867h;

    /* renamed from: i */
    Map<String, String> f33868i;

    /* renamed from: j */
    WeakReference<PlayerOrIMAAd> f33869j;

    /* renamed from: k */
    WeakReference<View> f33870k;

    /* renamed from: l */
    private boolean f33871l;

    /* renamed from: m */
    private Double f33872m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public final C11085g f33873n = new C11085g(C11073a.m36432a(), C11088a.VIDEO);

    /* renamed from: o */
    private final String f33874o;

    C11080c(String str) {
        super(null, false, true);
        C11111p.m36577a(3, "BaseVideoTracker", (Object) this, "Initializing.");
        this.f33874o = str;
        this.f33873n.mo36205a(str);
        super.mo36183a(this.f33873n.f33879b);
        super.mo36182a(this.f33873n.f33878a);
        this.f33866g = new HashMap();
        this.f33867h = new Handler();
        this.f33871l = false;
        this.f33872m = Double.valueOf(1.0d);
    }

    /* renamed from: b */
    private void m36459b(MoatAdEvent moatAdEvent) {
        JSONObject a = mo36193a(moatAdEvent);
        String str = "BaseVideoTracker";
        C11111p.m36577a(3, str, (Object) this, String.format("Received event: %s", new Object[]{a.toString()}));
        StringBuilder sb = new StringBuilder();
        sb.append(mo36181a());
        sb.append(String.format(" Received event: %s", new Object[]{a.toString()}));
        C11111p.m36579a("[SUCCESS] ", sb.toString());
        this.f33856a.mo36224a(this.f33873n.f33880c, a);
        MoatAdEventType moatAdEventType = moatAdEvent.f33842e;
        if (moatAdEventType == MoatAdEventType.AD_EVT_COMPLETE || moatAdEventType == MoatAdEventType.AD_EVT_STOPPED || moatAdEventType == MoatAdEventType.AD_EVT_SKIPPED) {
            this.f33866g.put(moatAdEventType, Integer.valueOf(1));
            mo36200j();
        }
    }

    /* renamed from: l */
    private void mo36209l() {
        Map g = mo36197g();
        Integer num = (Integer) g.get("width");
        Integer num2 = (Integer) g.get("height");
        Integer num3 = (Integer) g.get(VastIconXmlManager.DURATION);
        C11111p.m36577a(3, "BaseVideoTracker", (Object) this, String.format(Locale.ROOT, "Player metadata: height = %d, width = %d, duration = %d", new Object[]{num2, num, num3}));
        this.f33873n.mo36206a(this.f33874o, this.f33868i, num, num2, num3);
        super.changeTargetView((View) this.f33870k.get());
        super.mo36184b();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public JSONObject mo36193a(MoatAdEvent moatAdEvent) {
        if (Double.isNaN(moatAdEvent.f33840c.doubleValue())) {
            moatAdEvent.f33840c = this.f33872m;
        }
        return new JSONObject(moatAdEvent.mo36134a());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo36194a(Integer num, Integer num2) {
        int abs = Math.abs(num2.intValue() - num.intValue());
        double intValue = (double) num2.intValue();
        Double.isNaN(intValue);
        return ((double) abs) <= Math.min(750.0d, intValue * 0.05d);
    }

    /* renamed from: a */
    public boolean mo36195a(Map<String, String> map, PlayerOrIMAAd playerorimaad, View view) {
        boolean z;
        String str;
        Map<String, String> map2 = map;
        PlayerOrIMAAd playerorimaad2 = playerorimaad;
        View view2 = view;
        String str2 = "BaseVideoTracker";
        boolean z2 = false;
        try {
            String str3 = "[ERROR] ";
            if (this.f33860e) {
                C11111p.m36577a(3, str2, (Object) this, "trackVideoAd already called");
                StringBuilder sb = new StringBuilder();
                sb.append(mo36181a());
                sb.append(" trackVideoAd can't be called twice");
                C11111p.m36579a(str3, sb.toString());
                z = false;
            } else {
                z = true;
            }
            if (map2 == null) {
                C11111p.m36577a(3, str2, (Object) this, "trackVideoAd received null adIds object. Not tracking.");
                StringBuilder sb2 = new StringBuilder();
                sb2.append(mo36181a());
                sb2.append(" trackVideoAd failed, received null adIds object");
                C11111p.m36579a(str3, sb2.toString());
                z = false;
            }
            if (view2 == null) {
                C11111p.m36577a(3, str2, (Object) this, "trackVideoAd received null video view instance");
            }
            if (playerorimaad2 == null) {
                C11111p.m36577a(3, str2, (Object) this, "trackVideoAd received null ad instance. Not tracking.");
                StringBuilder sb3 = new StringBuilder();
                sb3.append(mo36181a());
                sb3.append(" trackVideoAd failed, received null ad instance");
                C11111p.m36579a(str3, sb3.toString());
                z = false;
            }
            if (z) {
                String str4 = "trackVideoAd tracking ids: %s | ad: %s | view: %s";
                Object[] objArr = new Object[3];
                objArr[0] = new JSONObject(map2).toString();
                objArr[1] = playerorimaad.toString();
                String str5 = "@";
                String str6 = "null";
                if (view2 != null) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(view.getClass().getSimpleName());
                    sb4.append(str5);
                    sb4.append(view.hashCode());
                    str = sb4.toString();
                } else {
                    str = str6;
                }
                objArr[2] = str;
                C11111p.m36577a(3, str2, (Object) this, String.format(str4, objArr));
                String str7 = "[SUCCESS] ";
                StringBuilder sb5 = new StringBuilder();
                sb5.append(mo36181a());
                String str8 = " trackVideoAd succeeded with ids: %s | ad: %s | view: %s";
                Object[] objArr2 = new Object[3];
                objArr2[0] = new JSONObject(map2).toString();
                objArr2[1] = playerorimaad.toString();
                if (view2 != null) {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(view.getClass().getSimpleName());
                    sb6.append(str5);
                    sb6.append(view.hashCode());
                    str6 = sb6.toString();
                }
                objArr2[2] = str6;
                sb5.append(String.format(str8, objArr2));
                C11111p.m36579a(str7, sb5.toString());
                this.f33868i = map2;
                this.f33869j = new WeakReference<>(playerorimaad2);
                this.f33870k = new WeakReference<>(view2);
                mo36209l();
            }
            z2 = z;
        } catch (Exception e) {
            C11102m.m36543a(e);
        }
        StringBuilder sb7 = new StringBuilder();
        sb7.append("Attempt to start tracking ad was ");
        sb7.append(z2 ? "" : "un");
        sb7.append("successful.");
        C11111p.m36577a(3, str2, (Object) this, sb7.toString());
        return z2;
    }

    public void changeTargetView(View view) {
        String str;
        if (view != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(view.getClass().getSimpleName());
            sb.append("@");
            sb.append(view.hashCode());
            str = sb.toString();
        } else {
            str = "null";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("changing view to ");
        sb2.append(str);
        C11111p.m36577a(3, "BaseVideoTracker", (Object) this, sb2.toString());
        this.f33870k = new WeakReference<>(view);
        try {
            super.changeTargetView(view);
        } catch (Exception e) {
            C11102m.m36543a(e);
        }
    }

    public void dispatchEvent(MoatAdEvent moatAdEvent) {
        try {
            m36459b(moatAdEvent);
        } catch (Exception e) {
            C11102m.m36543a(e);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public abstract Map<String, Object> mo36197g();

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public Double mo36198h() {
        return Double.valueOf(mo36199i().doubleValue() * C11113s.m36583a());
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public Double mo36199i() {
        return this.f33872m;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public void mo36200j() {
        if (!this.f33871l) {
            this.f33867h.postDelayed(new Runnable() {
                public void run() {
                    try {
                        C11111p.m36577a(3, "BaseVideoTracker", (Object) this, "Shutting down.");
                        C11080c.this.f33873n.mo36204a();
                    } catch (Exception e) {
                        C11102m.m36543a(e);
                    }
                }
            }, 500);
            this.f33871l = true;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: k */
    public boolean mo36201k() {
        return this.f33866g.containsKey(MoatAdEventType.AD_EVT_COMPLETE) || this.f33866g.containsKey(MoatAdEventType.AD_EVT_STOPPED) || this.f33866g.containsKey(MoatAdEventType.AD_EVT_SKIPPED);
    }

    public void setPlayerVolume(Double d) {
        Double h = mo36198h();
        if (!d.equals(this.f33872m)) {
            C11111p.m36577a(3, "BaseVideoTracker", (Object) this, String.format(Locale.ROOT, "player volume changed to %f ", new Object[]{d}));
            this.f33872m = d;
            if (!h.equals(mo36198h())) {
                dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_VOLUME_CHANGE, MoatAdEvent.f33837a, this.f33872m));
            }
        }
    }

    public void stopTracking() {
        try {
            boolean c = super.mo36185c();
            String str = c ? "[SUCCESS] " : "[ERROR] ";
            StringBuilder sb = new StringBuilder();
            sb.append(mo36181a());
            sb.append(" stopTracking ");
            sb.append(c ? "succeeded" : "failed");
            sb.append(" for ");
            sb.append(mo36188e());
            C11111p.m36579a(str, sb.toString());
            mo36200j();
        } catch (Exception e) {
            C11102m.m36543a(e);
        }
    }
}
