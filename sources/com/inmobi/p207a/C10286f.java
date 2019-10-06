package com.inmobi.p207a;

import com.inmobi.commons.core.network.C10676c;
import com.inmobi.commons.core.utilities.uid.C10711d;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* renamed from: com.inmobi.a.f */
/* compiled from: CarbPostListNetworkRequest */
public final class C10286f extends C10676c {

    /* renamed from: a */
    int f31165a;

    /* renamed from: b */
    int f31166b;

    /* renamed from: c */
    private C10283c f31167c;

    /* renamed from: d */
    private List<C10284d> f31168d;

    C10286f(String str, int i, int i2, C10711d dVar, List<C10284d> list, C10283c cVar) {
        super("POST", str, true, dVar);
        this.f31165a = i;
        this.f31166b = i2;
        this.f31168d = list;
        this.f31167c = cVar;
        this.f32577o.put("req_id", this.f31167c.f31159c);
        this.f32577o.put("i_till", Integer.toString(this.f31167c.f31160d));
        Map<String, String> map = this.f32577o;
        JSONArray jSONArray = new JSONArray();
        for (int i3 = 0; i3 < this.f31168d.size(); i3++) {
            jSONArray.put(((C10284d) this.f31168d.get(i3)).f31163b);
        }
        map.put("p_a_apps", jSONArray.toString());
    }
}
