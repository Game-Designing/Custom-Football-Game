package com.smaato.soma.p239c.p250g;

import com.smaato.soma.C12064Na;
import com.smaato.soma.C12431j;
import com.smaato.soma.exception.ParserException;
import com.smaato.soma.p236a.p237a.C12111b;
import com.smaato.soma.p239c.C12203d;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.smaato.soma.c.g.c */
/* compiled from: ImgJsonResponseParser */
class C12256c extends C12257d {
    C12256c() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C12064Na mo39631a(JSONObject jsonResponse) throws ParserException {
        try {
            C12203d banner = new C12203d();
            banner.mo39278a(C12111b.f37994b);
            banner.mo39501a(C12431j.IMAGE);
            JSONObject imageObject = jsonResponse.getJSONObject("image");
            JSONObject imgObject = imageObject.getJSONObject("img");
            banner.mo39507e(imgObject.getString("url"));
            banner.mo39505c(imgObject.getString("ctaurl"));
            banner.mo39503a(mo39633a(imageObject.getJSONArray("clicktrackers")));
            banner.mo39502a((List<String>) mo39633a(imageObject.getJSONArray("impressiontrackers")));
            banner.mo39504b(mo39634b(imageObject));
            return banner;
        } catch (JSONException e) {
            throw new ParserException("Could not parse IMG JSON response due to missing or wrong properties.", e);
        }
    }
}
