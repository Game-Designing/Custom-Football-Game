package com.moat.analytics.mobile.sma;

import android.view.View;
import com.mopub.mobileads.VastIconXmlManager;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.moat.analytics.mobile.sma.y */
class C11138y extends C11080c<Object> implements ReactiveVideoTracker {

    /* renamed from: l */
    private Integer f34009l;

    public C11138y(String str) {
        super(str);
        C11111p.m36577a(3, "ReactiveVideoTracker", (Object) this, "Initializing.");
        StringBuilder sb = new StringBuilder();
        sb.append(mo36181a());
        sb.append(" created");
        C11111p.m36579a("[SUCCESS] ", sb.toString());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo36181a() {
        return "ReactiveVideoTracker";
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public JSONObject mo36193a(MoatAdEvent moatAdEvent) {
        if (moatAdEvent.f33842e == MoatAdEventType.AD_EVT_COMPLETE && !moatAdEvent.f33839b.equals(MoatAdEvent.f33837a) && !mo36194a(moatAdEvent.f33839b, this.f34009l)) {
            moatAdEvent.f33842e = MoatAdEventType.AD_EVT_STOPPED;
        }
        return super.mo36193a(moatAdEvent);
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public Map<String, Object> mo36197g() {
        Integer num;
        HashMap hashMap = new HashMap();
        View view = (View) this.f33870k.get();
        Integer valueOf = Integer.valueOf(0);
        if (view != null) {
            valueOf = Integer.valueOf(view.getWidth());
            num = Integer.valueOf(view.getHeight());
        } else {
            num = valueOf;
        }
        hashMap.put(VastIconXmlManager.DURATION, this.f34009l);
        hashMap.put("width", valueOf);
        hashMap.put("height", num);
        return hashMap;
    }

    public boolean trackVideoAd(Map<String, String> map, Integer num, View view) {
        String str = "ReactiveVideoTracker";
        if (this.f33860e) {
            C11111p.m36577a(3, str, (Object) this, "trackVideoAd already called");
            StringBuilder sb = new StringBuilder();
            sb.append(mo36181a());
            sb.append(" trackVideoAd can't be called twice");
            C11111p.m36579a("[ERROR] ", sb.toString());
            return false;
        } else if (num.intValue() < 1000) {
            C11111p.m36577a(3, str, (Object) this, String.format(Locale.ROOT, "Invalid duration = %d. Please make sure duration is in milliseconds.", new Object[]{num}));
            return false;
        } else {
            this.f34009l = num;
            return super.mo36195a(map, new Object(), view);
        }
    }
}
