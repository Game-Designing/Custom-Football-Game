package com.moat.analytics.mobile.inm;

import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.mopub.mobileads.VastIconXmlManager;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* renamed from: com.moat.analytics.mobile.inm.c */
abstract class C10936c extends C10935b {

    /* renamed from: g */
    static final MoatAdEventType[] f33432g = {MoatAdEventType.AD_EVT_FIRST_QUARTILE, MoatAdEventType.AD_EVT_MID_POINT, MoatAdEventType.AD_EVT_THIRD_QUARTILE};

    /* renamed from: h */
    final Map<MoatAdEventType, Integer> f33433h;

    /* renamed from: i */
    final Handler f33434i;

    /* renamed from: j */
    Map<String, String> f33435j;

    /* renamed from: k */
    WeakReference<View> f33436k;

    /* renamed from: l */
    private final Set<MoatAdEventType> f33437l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public VideoTrackerListener f33438m;

    /* renamed from: n */
    private boolean f33439n;

    /* renamed from: o */
    private Double f33440o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public final C10941g f33441p = new C10941g(C10929a.m35944a(), C10946a.VIDEO);

    /* renamed from: q */
    private final String f33442q;

    C10936c(String str) {
        super(null, false, true);
        C10969p.m36113a(3, "BaseVideoTracker", (Object) this, "Initializing.");
        this.f33442q = str;
        super.mo35888a(this.f33441p.f33447b);
        try {
            super.mo35887a(this.f33441p.f33446a);
        } catch (C10960m e) {
            this.f33421a = e;
        }
        this.f33433h = new HashMap();
        this.f33437l = new HashSet();
        this.f33434i = new Handler();
        this.f33439n = false;
        this.f33440o = Double.valueOf(1.0d);
    }

    /* renamed from: a */
    private static boolean m35980a(MoatAdEventType moatAdEventType) {
        return moatAdEventType == MoatAdEventType.AD_EVT_COMPLETE || moatAdEventType == MoatAdEventType.AD_EVT_STOPPED || moatAdEventType == MoatAdEventType.AD_EVT_SKIPPED;
    }

    /* renamed from: b */
    private void m35981b(MoatAdEvent moatAdEvent) {
        JSONObject a = mo35904a(moatAdEvent);
        String str = "BaseVideoTracker";
        C10969p.m36113a(3, str, (Object) this, String.format("Received event: %s", new Object[]{a.toString()}));
        StringBuilder sb = new StringBuilder();
        sb.append(mo35886a());
        sb.append(String.format(" Received event: %s", new Object[]{a.toString()}));
        C10969p.m36116a("[SUCCESS] ", sb.toString());
        if (mo35895e()) {
            C10953j jVar = this.f33423c;
            if (jVar != null) {
                jVar.mo35941a(this.f33441p.f33448c, a);
                if (!this.f33437l.contains(moatAdEvent.f33405d)) {
                    this.f33437l.add(moatAdEvent.f33405d);
                    VideoTrackerListener videoTrackerListener = this.f33438m;
                    if (videoTrackerListener != null) {
                        videoTrackerListener.onVideoEventReported(moatAdEvent.f33405d);
                    }
                }
            }
        }
        MoatAdEventType moatAdEventType = moatAdEvent.f33405d;
        if (m35980a(moatAdEventType)) {
            this.f33433h.put(moatAdEventType, Integer.valueOf(1));
            C10953j jVar2 = this.f33423c;
            if (jVar2 != null) {
                jVar2.mo35945c((C10935b) this);
            }
            mo35911l();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public JSONObject mo35904a(MoatAdEvent moatAdEvent) {
        if (Double.isNaN(moatAdEvent.f33404c.doubleValue())) {
            moatAdEvent.f33404c = this.f33440o;
        }
        return new JSONObject(moatAdEvent.mo35823a());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo35890a(List<String> list) {
        if (this.f33435j == null) {
            list.add("Null adIds object");
        }
        if (list.isEmpty()) {
            super.mo35890a(list);
            return;
        }
        throw new C10960m(TextUtils.join(" and ", list));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo35905a(Integer num, Integer num2) {
        int abs = Math.abs(num2.intValue() - num.intValue());
        double intValue = (double) num2.intValue();
        Double.isNaN(intValue);
        return ((double) abs) <= Math.min(750.0d, intValue * 0.05d);
    }

    /* renamed from: a */
    public boolean mo35906a(Map<String, String> map, View view) {
        try {
            mo35892c();
            mo35894d();
            String str = "BaseVideoTracker";
            if (view == null) {
                C10969p.m36113a(3, str, (Object) this, "trackVideoAd received null video view instance");
            }
            this.f33435j = map;
            this.f33436k = new WeakReference<>(view);
            mo35891b();
            String format = String.format("trackVideoAd tracking ids: %s | view: %s", new Object[]{new JSONObject(map).toString(), C10969p.m36111a(view)});
            C10969p.m36113a(3, str, (Object) this, format);
            StringBuilder sb = new StringBuilder();
            sb.append(mo35886a());
            sb.append(" ");
            sb.append(format);
            C10969p.m36116a("[SUCCESS] ", sb.toString());
            if (this.f33424d != null) {
                this.f33424d.onTrackingStarted(mo35897g());
            }
            return true;
        } catch (Exception e) {
            mo35889a("trackVideoAd", e);
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo35891b() {
        super.changeTargetView((View) this.f33436k.get());
        super.mo35891b();
        Map i = mo35908i();
        Integer num = (Integer) i.get("width");
        Integer num2 = (Integer) i.get("height");
        Integer num3 = (Integer) i.get(VastIconXmlManager.DURATION);
        C10969p.m36113a(3, "BaseVideoTracker", (Object) this, String.format(Locale.ROOT, "Player metadata: height = %d, width = %d, duration = %d", new Object[]{num2, num, num3}));
        this.f33441p.mo35919a(this.f33442q, this.f33435j, num, num2, num3);
    }

    public void changeTargetView(View view) {
        StringBuilder sb = new StringBuilder("changing view to ");
        sb.append(C10969p.m36111a(view));
        C10969p.m36113a(3, "BaseVideoTracker", (Object) this, sb.toString());
        this.f33436k = new WeakReference<>(view);
        try {
            super.changeTargetView(view);
        } catch (Exception e) {
            C10960m.m36077a(e);
        }
    }

    public void dispatchEvent(MoatAdEvent moatAdEvent) {
        try {
            m35981b(moatAdEvent);
        } catch (Exception e) {
            C10960m.m36077a(e);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public abstract Map<String, Object> mo35908i();

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public Double mo35909j() {
        return Double.valueOf(mo35910k().doubleValue() * C10972s.m36121a());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: k */
    public Double mo35910k() {
        return this.f33440o;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: l */
    public void mo35911l() {
        if (!this.f33439n) {
            this.f33439n = true;
            this.f33434i.postDelayed(new Runnable() {
                public void run() {
                    try {
                        C10969p.m36113a(3, "BaseVideoTracker", (Object) this, "Shutting down.");
                        C10936c.this.f33441p.mo35917a();
                        C10936c.this.f33438m = null;
                    } catch (Exception e) {
                        C10960m.m36077a(e);
                    }
                }
            }, 500);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: m */
    public boolean mo35912m() {
        return this.f33433h.containsKey(MoatAdEventType.AD_EVT_COMPLETE) || this.f33433h.containsKey(MoatAdEventType.AD_EVT_STOPPED) || this.f33433h.containsKey(MoatAdEventType.AD_EVT_SKIPPED);
    }

    public void removeVideoListener() {
        this.f33438m = null;
    }

    public void setPlayerVolume(Double d) {
        Double j = mo35909j();
        if (!d.equals(this.f33440o)) {
            C10969p.m36113a(3, "BaseVideoTracker", (Object) this, String.format(Locale.ROOT, "player volume changed to %f ", new Object[]{d}));
            this.f33440o = d;
            if (!j.equals(mo35909j())) {
                dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_VOLUME_CHANGE, MoatAdEvent.f33401a, this.f33440o));
            }
        }
    }

    public void setVideoListener(VideoTrackerListener videoTrackerListener) {
        this.f33438m = videoTrackerListener;
    }

    public void stopTracking() {
        try {
            super.stopTracking();
            mo35911l();
            if (this.f33438m != null) {
                this.f33438m = null;
            }
        } catch (Exception e) {
            C10960m.m36077a(e);
        }
    }
}
