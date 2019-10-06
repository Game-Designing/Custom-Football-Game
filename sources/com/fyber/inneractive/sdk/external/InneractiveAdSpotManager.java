package com.fyber.inneractive.sdk.external;

import com.fyber.inneractive.sdk.p161c.C7670h;
import java.util.HashMap;
import java.util.Map;

public class InneractiveAdSpotManager {

    /* renamed from: a */
    Map<String, InneractiveAdSpot> f15395a;

    /* renamed from: com.fyber.inneractive.sdk.external.InneractiveAdSpotManager$a */
    private static class C7728a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public static InneractiveAdSpotManager f15396a = new InneractiveAdSpotManager(0);
    }

    /* synthetic */ InneractiveAdSpotManager(byte b) {
        this();
    }

    private InneractiveAdSpotManager() {
        this.f15395a = new HashMap();
    }

    public static InneractiveAdSpotManager get() {
        return C7728a.f15396a;
    }

    public InneractiveAdSpot createSpot() {
        C7670h hVar = new C7670h();
        this.f15395a.put(hVar.getLocalUniqueId(), hVar);
        return hVar;
    }

    public void bindSpot(InneractiveAdSpot inneractiveAdSpot) {
        this.f15395a.put(inneractiveAdSpot.getLocalUniqueId(), inneractiveAdSpot);
    }

    public void removeSpot(InneractiveAdSpot inneractiveAdSpot) {
        Map<String, InneractiveAdSpot> map = this.f15395a;
        if (map != null) {
            map.remove(inneractiveAdSpot.getLocalUniqueId());
        }
    }

    public static void destroy() {
        Map<String, InneractiveAdSpot> map = get().f15395a;
        for (String str : map.keySet()) {
            ((InneractiveAdSpot) map.get(str)).destroy();
        }
        map.clear();
    }

    public InneractiveAdSpot getSpot(String str) {
        return (InneractiveAdSpot) this.f15395a.get(str);
    }
}
