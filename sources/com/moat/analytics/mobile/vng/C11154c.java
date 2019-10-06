package com.moat.analytics.mobile.vng;

import android.os.Handler;
import android.view.View;
import com.mopub.mobileads.VastIconXmlManager;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.moat.analytics.mobile.vng.c */
abstract class C11154c<PlayerOrIMAAd> extends C11153b {

    /* renamed from: f */
    static final MoatAdEventType[] f34052f = {MoatAdEventType.AD_EVT_FIRST_QUARTILE, MoatAdEventType.AD_EVT_MID_POINT, MoatAdEventType.AD_EVT_THIRD_QUARTILE};

    /* renamed from: g */
    final Map<MoatAdEventType, Integer> f34053g;

    /* renamed from: h */
    final Handler f34054h;

    /* renamed from: i */
    Map<String, String> f34055i;

    /* renamed from: j */
    WeakReference<PlayerOrIMAAd> f34056j;

    /* renamed from: k */
    WeakReference<View> f34057k;

    /* renamed from: l */
    private boolean f34058l;

    /* renamed from: m */
    private Double f34059m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public final C11159g f34060n = new C11159g(C11144a.m36673a(), C11162a.VIDEO);

    /* renamed from: o */
    private final String f34061o;

    C11154c(String str) {
        super(null, false, true);
        C11185p.m36817a(3, "BaseVideoTracker", (Object) this, "Initializing.");
        this.f34061o = str;
        this.f34060n.mo36338a(str);
        super.mo36318a(this.f34060n.f34066b);
        super.mo36317a(this.f34060n.f34065a);
        this.f34053g = new HashMap();
        this.f34054h = new Handler();
        this.f34058l = false;
        this.f34059m = Double.valueOf(1.0d);
    }

    /* renamed from: b */
    private void m36702b(MoatAdEvent moatAdEvent) {
        JSONObject a = mo36328a(moatAdEvent);
        String str = "BaseVideoTracker";
        C11185p.m36817a(3, str, (Object) this, String.format("Received event: %s", new Object[]{a.toString()}));
        StringBuilder sb = new StringBuilder();
        sb.append(mo36311a());
        sb.append(String.format(" Received event: %s", new Object[]{a.toString()}));
        C11185p.m36819a("[SUCCESS] ", sb.toString());
        this.f34043a.mo36356a(this.f34060n.f34067c, a);
        MoatAdEventType moatAdEventType = moatAdEvent.f34026d;
        if (moatAdEventType == MoatAdEventType.AD_EVT_COMPLETE || moatAdEventType == MoatAdEventType.AD_EVT_STOPPED || moatAdEventType == MoatAdEventType.AD_EVT_SKIPPED) {
            this.f34053g.put(moatAdEventType, Integer.valueOf(1));
            mo36333h();
        }
    }

    /* renamed from: j */
    private void mo36342j() {
        Map g = mo36332g();
        Integer num = (Integer) g.get("width");
        Integer num2 = (Integer) g.get("height");
        Integer num3 = (Integer) g.get(VastIconXmlManager.DURATION);
        C11185p.m36817a(3, "BaseVideoTracker", (Object) this, String.format(Locale.ROOT, "Player metadata: height = %d, width = %d, duration = %d", new Object[]{num2, num, num3}));
        this.f34060n.mo36339a(this.f34061o, this.f34055i, num, num2, num3);
        super.changeTargetView((View) this.f34057k.get());
        super.mo36319b();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public JSONObject mo36328a(MoatAdEvent moatAdEvent) {
        if (Double.isNaN(moatAdEvent.f34025c.doubleValue())) {
            try {
                moatAdEvent.f34025c = Double.valueOf(C11187s.m36823a());
            } catch (Exception e) {
                moatAdEvent.f34025c = Double.valueOf(1.0d);
            }
        }
        String format = String.format(Locale.ROOT, "adVolume before adjusting for player volume %f", new Object[]{moatAdEvent.f34025c});
        String str = "BaseVideoTracker";
        C11185p.m36817a(3, str, (Object) this, format);
        moatAdEvent.f34025c = Double.valueOf(moatAdEvent.f34025c.doubleValue() * this.f34059m.doubleValue());
        C11185p.m36817a(3, str, (Object) this, String.format(Locale.ROOT, "adVolume after adjusting for player volume %f", new Object[]{moatAdEvent.f34025c}));
        return new JSONObject(moatAdEvent.mo36264a());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo36329a(Integer num, Integer num2) {
        int abs = Math.abs(num2.intValue() - num.intValue());
        double intValue = (double) num2.intValue();
        Double.isNaN(intValue);
        return ((double) abs) <= Math.min(750.0d, intValue * 0.05d);
    }

    /* renamed from: a */
    public boolean mo36330a(Map<String, String> map, PlayerOrIMAAd playerorimaad, View view) {
        boolean z;
        String str;
        Map<String, String> map2 = map;
        PlayerOrIMAAd playerorimaad2 = playerorimaad;
        View view2 = view;
        String str2 = "BaseVideoTracker";
        boolean z2 = false;
        try {
            String str3 = "[ERROR] ";
            if (this.f34047e) {
                C11185p.m36817a(3, str2, (Object) this, "trackVideoAd already called");
                StringBuilder sb = new StringBuilder();
                sb.append(mo36311a());
                sb.append(" trackVideoAd can't be called twice");
                C11185p.m36819a(str3, sb.toString());
                z = false;
            } else {
                z = true;
            }
            if (map2 == null) {
                C11185p.m36817a(3, str2, (Object) this, "trackVideoAd received null adIds object. Not tracking.");
                StringBuilder sb2 = new StringBuilder();
                sb2.append(mo36311a());
                sb2.append(" trackVideoAd failed, received null adIds object");
                C11185p.m36819a(str3, sb2.toString());
                z = false;
            }
            if (view2 == null) {
                C11185p.m36817a(3, str2, (Object) this, "trackVideoAd received null video view instance");
            }
            if (playerorimaad2 == null) {
                C11185p.m36817a(3, str2, (Object) this, "trackVideoAd received null ad instance. Not tracking.");
                StringBuilder sb3 = new StringBuilder();
                sb3.append(mo36311a());
                sb3.append(" trackVideoAd failed, received null ad instance");
                C11185p.m36819a(str3, sb3.toString());
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
                C11185p.m36817a(3, str2, (Object) this, String.format(str4, objArr));
                String str7 = "[SUCCESS] ";
                StringBuilder sb5 = new StringBuilder();
                sb5.append(mo36311a());
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
                C11185p.m36819a(str7, sb5.toString());
                this.f34055i = map2;
                this.f34056j = new WeakReference<>(playerorimaad2);
                this.f34057k = new WeakReference<>(view2);
                mo36342j();
            }
            z2 = z;
        } catch (Exception e) {
            C11176m.m36783a(e);
        }
        StringBuilder sb7 = new StringBuilder();
        sb7.append("Attempt to start tracking ad was ");
        sb7.append(z2 ? "" : "un");
        sb7.append("successful.");
        C11185p.m36817a(3, str2, (Object) this, sb7.toString());
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
        C11185p.m36817a(3, "BaseVideoTracker", (Object) this, sb2.toString());
        this.f34057k = new WeakReference<>(view);
        try {
            super.changeTargetView(view);
        } catch (Exception e) {
            C11176m.m36783a(e);
        }
    }

    public void dispatchEvent(MoatAdEvent moatAdEvent) {
        try {
            m36702b(moatAdEvent);
        } catch (Exception e) {
            C11176m.m36783a(e);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public abstract Map<String, Object> mo36332g();

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public void mo36333h() {
        if (!this.f34058l) {
            this.f34054h.postDelayed(new Runnable() {
                public void run() {
                    try {
                        C11185p.m36817a(3, "BaseVideoTracker", (Object) this, "Shutting down.");
                        C11154c.this.f34060n.mo36337a();
                    } catch (Exception e) {
                        C11176m.m36783a(e);
                    }
                }
            }, 500);
            this.f34058l = true;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public boolean mo36334i() {
        return this.f34053g.containsKey(MoatAdEventType.AD_EVT_COMPLETE) || this.f34053g.containsKey(MoatAdEventType.AD_EVT_STOPPED) || this.f34053g.containsKey(MoatAdEventType.AD_EVT_SKIPPED);
    }

    public void setPlayerVolume(Double d) {
        if (!d.equals(this.f34059m)) {
            C11185p.m36817a(3, "BaseVideoTracker", (Object) this, String.format(Locale.ROOT, "player volume changed to %f ", new Object[]{d}));
            this.f34059m = d;
            dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_VOLUME_CHANGE, MoatAdEvent.f34022a));
        }
    }

    public void stopTracking() {
        try {
            boolean c = super.mo36320c();
            String str = c ? "[SUCCESS] " : "[ERROR] ";
            StringBuilder sb = new StringBuilder();
            sb.append(mo36311a());
            sb.append(" stopTracking ");
            sb.append(c ? "succeeded" : "failed");
            sb.append(" for ");
            sb.append(mo36323e());
            C11185p.m36819a(str, sb.toString());
            mo36333h();
        } catch (Exception e) {
            C11176m.m36783a(e);
        }
    }
}
