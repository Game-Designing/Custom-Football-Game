package com.moat.analytics.mobile.iro;

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

/* renamed from: com.moat.analytics.mobile.iro.d */
abstract class C11016d extends C11015c {

    /* renamed from: ʽ */
    static final MoatAdEventType[] f33658 = {MoatAdEventType.AD_EVT_FIRST_QUARTILE, MoatAdEventType.AD_EVT_MID_POINT, MoatAdEventType.AD_EVT_THIRD_QUARTILE};

    /* renamed from: ʻ */
    final Map<MoatAdEventType, Integer> f33659;

    /* renamed from: ʼ */
    WeakReference<View> f33660;

    /* renamed from: ˊॱ */
    final Handler f33661;

    /* renamed from: ˋॱ */
    private Double f33662;

    /* renamed from: ˏॱ */
    private Map<String, String> f33663;

    /* renamed from: ͺ */
    private boolean f33664;
    /* access modifiers changed from: private */

    /* renamed from: ॱˊ */
    public VideoTrackerListener f33665;

    /* renamed from: ॱˋ */
    private final Set<MoatAdEventType> f33666;

    /* renamed from: ॱˎ */
    private final String f33667;
    /* access modifiers changed from: private */

    /* renamed from: ᐝॱ */
    public final C11011b f33668 = new C11011b(C11009a.m36225(), C11014a.f33643);

    /* access modifiers changed from: 0000 */
    /* renamed from: ˊॱ */
    public abstract Map<String, Object> mo36069() throws C11043o;

    C11016d(String str) {
        super(null, false, true);
        C11011b.m36234(3, "BaseVideoTracker", this, "Initializing.");
        this.f33667 = str;
        C11011b bVar = this.f33668;
        this.f33654 = bVar.f33637;
        try {
            super.mo36059(bVar.f33639);
        } catch (C11043o e) {
            this.f33652 = e;
        }
        this.f33659 = new HashMap();
        this.f33666 = new HashSet();
        this.f33661 = new Handler();
        this.f33664 = false;
        this.f33662 = Double.valueOf(1.0d);
    }

    public void setVideoListener(VideoTrackerListener videoTrackerListener) {
        this.f33665 = videoTrackerListener;
    }

    public void removeVideoListener() {
        this.f33665 = null;
    }

    /* renamed from: ˋ */
    public boolean mo36071(Map<String, String> map, View view) {
        try {
            mo36058();
            mo36061();
            String str = "BaseVideoTracker";
            if (view == null) {
                C11011b.m36234(3, str, this, "trackVideoAd received null video view instance");
            }
            this.f33663 = map;
            this.f33660 = new WeakReference<>(view);
            mo36060();
            String format = String.format("trackVideoAd tracking ids: %s | view: %s", new Object[]{new JSONObject(map).toString(), C11011b.m36236(view)});
            C11011b.m36234(3, str, this, format);
            StringBuilder sb = new StringBuilder();
            sb.append(mo36057());
            sb.append(" ");
            sb.append(format);
            C11011b.m36232("[SUCCESS] ", sb.toString());
            if (this.f33650 != null) {
                this.f33650.onTrackingStarted(mo36056());
            }
            return true;
        } catch (Exception e) {
            mo36063("trackVideoAd", e);
            return false;
        }
    }

    public void setPlayerVolume(Double d) {
        Double valueOf = Double.valueOf(this.f33662.doubleValue() * C11044p.m36362());
        if (!d.equals(this.f33662)) {
            C11011b.m36234(3, "BaseVideoTracker", this, String.format(Locale.ROOT, "player volume changed to %f ", new Object[]{d}));
            this.f33662 = d;
            if (!valueOf.equals(Double.valueOf(this.f33662.doubleValue() * C11044p.m36362()))) {
                dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_VOLUME_CHANGE, MoatAdEvent.f33619, this.f33662));
            }
        }
    }

    public void changeTargetView(View view) {
        StringBuilder sb = new StringBuilder("changing view to ");
        sb.append(C11011b.m36236(view));
        C11011b.m36234(3, "BaseVideoTracker", this, sb.toString());
        this.f33660 = new WeakReference<>(view);
        try {
            super.changeTargetView(view);
        } catch (Exception e) {
            C11043o.m36351(e);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˏ */
    public void mo36062(List<String> list) throws C11043o {
        if (this.f33663 == null) {
            list.add("Null adIds object");
        }
        if (list.isEmpty()) {
            super.mo36062(list);
            return;
        }
        throw new C11043o(TextUtils.join(" and ", list));
    }

    public void stopTracking() {
        try {
            super.stopTracking();
            mo36074();
            if (this.f33665 != null) {
                this.f33665 = null;
            }
        } catch (Exception e) {
            C11043o.m36351(e);
        }
    }

    public void dispatchEvent(MoatAdEvent moatAdEvent) {
        try {
            JSONObject r0 = mo36070(moatAdEvent);
            boolean z = false;
            C11011b.m36234(3, "BaseVideoTracker", this, String.format("Received event: %s", new Object[]{r0.toString()}));
            StringBuilder sb = new StringBuilder();
            sb.append(mo36057());
            sb.append(String.format(" Received event: %s", new Object[]{r0.toString()}));
            C11011b.m36232("[SUCCESS] ", sb.toString());
            if (mo36064() && this.f33654 != null) {
                this.f33654.mo36080(this.f33668.f33636, r0);
                if (!this.f33666.contains(moatAdEvent.f33624)) {
                    this.f33666.add(moatAdEvent.f33624);
                    if (this.f33665 != null) {
                        this.f33665.onVideoEventReported(moatAdEvent.f33624);
                    }
                }
            }
            MoatAdEventType moatAdEventType = moatAdEvent.f33624;
            if (moatAdEventType == MoatAdEventType.AD_EVT_COMPLETE || moatAdEventType == MoatAdEventType.AD_EVT_STOPPED || moatAdEventType == MoatAdEventType.AD_EVT_SKIPPED) {
                z = true;
            }
            if (z) {
                this.f33659.put(moatAdEventType, Integer.valueOf(1));
                if (this.f33654 != null) {
                    this.f33654.mo36083((C11015c) this);
                }
                mo36074();
            }
        } catch (Exception e) {
            C11043o.m36351(e);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ᐝ */
    public final Double mo36075() {
        return Double.valueOf(this.f33662.doubleValue() * C11044p.m36362());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˏॱ */
    public final Double mo36072() {
        return this.f33662;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˎ */
    public final void mo36060() throws C11043o {
        super.changeTargetView((View) this.f33660.get());
        super.mo36060();
        HashMap r0 = mo36069();
        Integer num = (Integer) r0.get("width");
        Integer num2 = (Integer) r0.get("height");
        Integer num3 = (Integer) r0.get(VastIconXmlManager.DURATION);
        C11011b.m36234(3, "BaseVideoTracker", this, String.format(Locale.ROOT, "Player metadata: height = %d, width = %d, duration = %d", new Object[]{num2, num, num3}));
        this.f33668.mo36039(this.f33667, this.f33663, num, num2, num3);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˋ */
    public JSONObject mo36070(MoatAdEvent moatAdEvent) {
        if (Double.isNaN(moatAdEvent.f33623.doubleValue())) {
            moatAdEvent.f33623 = this.f33662;
        }
        return new JSONObject(moatAdEvent.mo35986());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ॱˋ */
    public final void mo36074() {
        if (!this.f33664) {
            this.f33664 = true;
            this.f33661.postDelayed(new Runnable() {
                public final void run() {
                    try {
                        C11011b.m36234(3, "BaseVideoTracker", this, "Shutting down.");
                        C11011b r0 = C11016d.this.f33668;
                        C11011b.m36234(3, "GlobalWebView", r0, "Cleaning up");
                        r0.f33637.mo36078();
                        r0.f33637 = null;
                        r0.f33639.destroy();
                        r0.f33639 = null;
                        C11016d.this.f33665 = null;
                    } catch (Exception e) {
                        C11043o.m36351(e);
                    }
                }
            }, 500);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ͺ */
    public final boolean mo36073() {
        return this.f33659.containsKey(MoatAdEventType.AD_EVT_COMPLETE) || this.f33659.containsKey(MoatAdEventType.AD_EVT_STOPPED) || this.f33659.containsKey(MoatAdEventType.AD_EVT_SKIPPED);
    }

    /* renamed from: ˋ */
    static boolean m36252(Integer num, Integer num2) {
        int abs = Math.abs(num2.intValue() - num.intValue());
        double intValue = (double) num2.intValue();
        Double.isNaN(intValue);
        return ((double) abs) <= Math.min(750.0d, intValue * 0.05d);
    }
}
