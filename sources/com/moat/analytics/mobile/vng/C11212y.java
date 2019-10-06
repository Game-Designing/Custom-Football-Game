package com.moat.analytics.mobile.vng;

import android.view.View;
import com.mopub.mobileads.VastIconXmlManager;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.moat.analytics.mobile.vng.y */
class C11212y extends C11154c<Object> implements ReactiveVideoTracker {

    /* renamed from: l */
    private Integer f34196l;

    public C11212y(String str) {
        super(str);
        StringBuilder sb = new StringBuilder();
        sb.append(mo36311a());
        sb.append(" created");
        C11185p.m36819a("[SUCCESS] ", sb.toString());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo36311a() {
        return "ReactiveVideoTracker";
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public JSONObject mo36328a(MoatAdEvent moatAdEvent) {
        if (moatAdEvent.f34026d == MoatAdEventType.AD_EVT_COMPLETE && !moatAdEvent.f34024b.equals(MoatAdEvent.f34022a) && !mo36329a(moatAdEvent.f34024b, this.f34196l)) {
            moatAdEvent.f34026d = MoatAdEventType.AD_EVT_STOPPED;
        }
        return super.mo36328a(moatAdEvent);
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public Map<String, Object> mo36332g() {
        Integer num;
        HashMap hashMap = new HashMap();
        View view = (View) this.f34057k.get();
        Integer valueOf = Integer.valueOf(0);
        if (view != null) {
            valueOf = Integer.valueOf(view.getWidth());
            num = Integer.valueOf(view.getHeight());
        } else {
            num = valueOf;
        }
        hashMap.put(VastIconXmlManager.DURATION, this.f34196l);
        hashMap.put("width", valueOf);
        hashMap.put("height", num);
        return hashMap;
    }

    public boolean trackVideoAd(Map<String, String> map, Integer num, View view) {
        String str = "ReactiveVideoTracker";
        if (this.f34047e) {
            C11185p.m36817a(3, str, (Object) this, "trackVideoAd already called");
            StringBuilder sb = new StringBuilder();
            sb.append(mo36311a());
            sb.append(" trackVideoAd can't be called twice");
            C11185p.m36819a("[ERROR] ", sb.toString());
            return false;
        } else if (num.intValue() < 1000) {
            C11185p.m36817a(3, str, (Object) this, String.format(Locale.ROOT, "Invalid duration = %d. Please make sure duration is in milliseconds.", new Object[]{num}));
            return false;
        } else {
            this.f34196l = num;
            return super.mo36330a(map, new Object(), view);
        }
    }
}
