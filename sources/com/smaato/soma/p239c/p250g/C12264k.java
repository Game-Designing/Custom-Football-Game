package com.smaato.soma.p239c.p250g;

import com.smaato.soma.C12064Na;
import com.smaato.soma.C12431j;
import com.smaato.soma.exception.ParserException;
import com.smaato.soma.p236a.p237a.C12111b;
import com.smaato.soma.p239c.C12203d;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.smaato.soma.c.g.k */
/* compiled from: RichMediaJsonResponseParser */
class C12264k extends C12257d {
    C12264k() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C12064Na mo39631a(JSONObject jsonResponse) throws ParserException {
        try {
            C12203d banner = new C12203d();
            banner.mo39278a(C12111b.f37994b);
            banner.mo39501a(C12431j.RICH_MEDIA);
            JSONObject rootObject = jsonResponse.getJSONObject("richmedia");
            banner.mo39508f(rootObject.getJSONObject("mediadata").getString("content"));
            banner.mo39503a(mo39633a(rootObject.getJSONArray("clicktrackers")));
            banner.mo39502a((List<String>) mo39633a(rootObject.getJSONArray("impressiontrackers")));
            banner.mo39504b(mo39634b(rootObject));
            return banner;
        } catch (JSONException e) {
            throw new ParserException("Could not parse RichMedia JSON response due to missing or wrong properties.", e);
        }
    }
}
