package com.moat.analytics.mobile.inm;

import android.view.View;
import com.mopub.mobileads.VastIconXmlManager;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.moat.analytics.mobile.inm.y */
class C10998y extends C10936c implements ReactiveVideoTracker {

    /* renamed from: l */
    private Integer f33600l;

    public C10998y(String str) {
        super(str);
        C10969p.m36113a(3, "ReactiveVideoTracker", (Object) this, "Initializing.");
        StringBuilder sb = new StringBuilder();
        sb.append(mo35886a());
        sb.append(" created");
        C10969p.m36116a("[SUCCESS] ", sb.toString());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo35886a() {
        return "ReactiveVideoTracker";
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public JSONObject mo35904a(MoatAdEvent moatAdEvent) {
        if (moatAdEvent.f33405d == MoatAdEventType.AD_EVT_COMPLETE && !moatAdEvent.f33403b.equals(MoatAdEvent.f33401a) && !mo35905a(moatAdEvent.f33403b, this.f33600l)) {
            moatAdEvent.f33405d = MoatAdEventType.AD_EVT_STOPPED;
        }
        return super.mo35904a(moatAdEvent);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo35890a(List<String> list) {
        if (this.f33600l.intValue() >= 1000) {
            super.mo35890a(list);
            return;
        }
        throw new C10960m(String.format(Locale.ROOT, "Invalid duration = %d. Please make sure duration is in milliseconds.", new Object[]{this.f33600l}));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public Map<String, Object> mo35908i() {
        Integer num;
        HashMap hashMap = new HashMap();
        View view = (View) this.f33436k.get();
        Integer valueOf = Integer.valueOf(0);
        if (view != null) {
            valueOf = Integer.valueOf(view.getWidth());
            num = Integer.valueOf(view.getHeight());
        } else {
            num = valueOf;
        }
        hashMap.put(VastIconXmlManager.DURATION, this.f33600l);
        hashMap.put("width", valueOf);
        hashMap.put("height", num);
        return hashMap;
    }

    public boolean trackVideoAd(Map<String, String> map, Integer num, View view) {
        try {
            mo35892c();
            mo35894d();
            this.f33600l = num;
            return super.mo35906a(map, view);
        } catch (Exception e) {
            mo35889a("trackVideoAd", e);
            return false;
        }
    }
}
