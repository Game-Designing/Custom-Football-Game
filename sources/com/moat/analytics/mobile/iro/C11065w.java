package com.moat.analytics.mobile.iro;

import android.view.View;
import com.mopub.mobileads.VastIconXmlManager;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.moat.analytics.mobile.iro.w */
final class C11065w extends C11016d implements ReactiveVideoTracker {

    /* renamed from: ˏॱ */
    private Integer f33819;

    public C11065w(String str) {
        super(str);
        C11011b.m36234(3, "ReactiveVideoTracker", this, "Initializing.");
        C11011b.m36232("[SUCCESS] ", "ReactiveVideoTracker created");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˊ */
    public final String mo36057() {
        return "ReactiveVideoTracker";
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˊॱ */
    public final Map<String, Object> mo36069() throws C11043o {
        Integer num;
        HashMap hashMap = new HashMap();
        View view = (View) this.f33660.get();
        Integer valueOf = Integer.valueOf(0);
        if (view != null) {
            valueOf = Integer.valueOf(view.getWidth());
            num = Integer.valueOf(view.getHeight());
        } else {
            num = valueOf;
        }
        hashMap.put(VastIconXmlManager.DURATION, this.f33819);
        hashMap.put("width", valueOf);
        hashMap.put("height", num);
        return hashMap;
    }

    public final boolean trackVideoAd(Map<String, String> map, Integer num, View view) {
        try {
            mo36058();
            mo36061();
            this.f33819 = num;
            return super.mo36071(map, view);
        } catch (Exception e) {
            mo36063("trackVideoAd", e);
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˋ */
    public final JSONObject mo36070(MoatAdEvent moatAdEvent) {
        if (moatAdEvent.f33624 == MoatAdEventType.AD_EVT_COMPLETE && !moatAdEvent.f33622.equals(MoatAdEvent.f33619) && !C11016d.m36252(moatAdEvent.f33622, this.f33819)) {
            moatAdEvent.f33624 = MoatAdEventType.AD_EVT_STOPPED;
        }
        return super.mo36070(moatAdEvent);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˏ */
    public final void mo36062(List<String> list) throws C11043o {
        if (this.f33819.intValue() >= 1000) {
            super.mo36062(list);
            return;
        }
        throw new C11043o(String.format(Locale.ROOT, "Invalid duration = %d. Please make sure duration is in milliseconds.", new Object[]{this.f33819}));
    }
}
