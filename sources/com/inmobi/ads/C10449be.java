package com.inmobi.ads;

import android.support.p001v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import com.inmobi.ads.AdContainer.RenderingProperties.PlacementType;
import com.inmobi.commons.p217a.C10619a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.inmobi.ads.be */
/* compiled from: NativeVideoAsset */
public final class C10449be extends C10400ak {

    /* renamed from: A */
    boolean f31784A;

    /* renamed from: B */
    boolean f31785B;

    /* renamed from: C */
    boolean f31786C;

    /* renamed from: D */
    boolean f31787D;

    /* renamed from: E */
    int f31788E;

    /* renamed from: F */
    int f31789F;

    /* renamed from: G */
    public Map<String, Object> f31790G;

    /* renamed from: H */
    private boolean f31791H;

    /* renamed from: z */
    List<C10400ak> f31792z;

    /* renamed from: com.inmobi.ads.be$a */
    /* compiled from: NativeVideoAsset */
    static class C10450a extends C10401al {
        public C10450a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, C10441ba baVar) {
            super(i, i2, i3, i4, i5, i6, i7, i8, "none", "straight", "#ff000000", "#00000000", baVar);
        }
    }

    public C10449be(String str, String str2, C10401al alVar, C10476by byVar, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, List<NativeTracker> list, JSONObject jSONObject, boolean z6) {
        super(str, str2, "VIDEO", alVar);
        this.f31612e = byVar;
        this.f31784A = z;
        this.f31785B = z2;
        this.f31786C = z3;
        this.f31787D = z4;
        this.f31792z = new ArrayList();
        this.f31791H = z6;
        if (byVar != null) {
            this.f31625r = byVar.mo34195a();
            List<NativeTracker> d = byVar.mo34200d();
            Map<String, String> map = null;
            if (list != null) {
                for (NativeTracker nativeTracker : list) {
                    if (TrackerEventType.TRACKER_EVENT_TYPE_IAS == nativeTracker.f31378b) {
                        map = nativeTracker.f31379c;
                        if (!TextUtils.isEmpty(nativeTracker.f31377a)) {
                            d.add(nativeTracker);
                        }
                    } else {
                        d.add(nativeTracker);
                    }
                }
            }
            for (NativeTracker nativeTracker2 : d) {
                if (TrackerEventType.TRACKER_EVENT_TYPE_IAS == nativeTracker2.f31378b) {
                    nativeTracker2.f31379c = map;
                }
            }
            if (!d.isEmpty()) {
                mo34088a(d);
            }
        }
        if (jSONObject != null) {
            this.f31613f = jSONObject;
        }
        this.f31629v.put("placementType", PlacementType.PLACEMENT_TYPE_INLINE);
        this.f31629v.put("lastVisibleTimestamp", Integer.valueOf(LinearLayoutManager.INVALID_OFFSET));
        this.f31629v.put("visible", Boolean.valueOf(false));
        this.f31629v.put("seekPosition", Integer.valueOf(0));
        this.f31629v.put("didStartPlaying", Boolean.valueOf(false));
        this.f31629v.put("didPause", Boolean.valueOf(false));
        this.f31629v.put("didCompleteQ1", Boolean.valueOf(false));
        this.f31629v.put("didCompleteQ2", Boolean.valueOf(false));
        this.f31629v.put("didCompleteQ3", Boolean.valueOf(false));
        this.f31629v.put("didCompleteQ4", Boolean.valueOf(false));
        this.f31629v.put("didRequestFullScreen", Boolean.valueOf(false));
        this.f31629v.put("isFullScreen", Boolean.valueOf(false));
        this.f31629v.put("didImpressionFire", Boolean.valueOf(false));
        this.f31629v.put("mapViewabilityParams", new HashMap());
        this.f31629v.put("didSignalVideoCompleted", Boolean.valueOf(false));
        this.f31629v.put("shouldAutoPlay", Boolean.valueOf(z5));
        this.f31629v.put("lastMediaVolume", Integer.valueOf(0));
        this.f31629v.put("currentMediaVolume", Integer.valueOf(0));
        this.f31629v.put("didQ4Fire", Boolean.valueOf(false));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final boolean mo34157a() {
        if (this.f31791H) {
            return this.f31784A && !C10619a.m34846d();
        }
        return this.f31784A;
    }

    /* renamed from: b */
    public final C10476by mo34158b() {
        Object obj = this.f31612e;
        if (obj == null) {
            return null;
        }
        return (C10476by) obj;
    }

    /* renamed from: a */
    public final void mo34156a(C10449be beVar) {
        this.f31629v.putAll(beVar.f31629v);
        this.f31790G.putAll(beVar.f31790G);
        this.f31628u = beVar.f31628u;
    }
}
