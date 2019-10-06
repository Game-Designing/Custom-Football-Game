package com.smaato.soma.p239c.p250g;

import com.smaato.soma.exception.ParserException;
import com.smaato.soma.p236a.p237a.C12111b;
import com.smaato.soma.p239c.p252i.C12280f;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.smaato.soma.c.g.f */
/* compiled from: JsonResponseParserCreator */
public class C12259f {
    /* renamed from: a */
    public C12257d mo39635a(Map<String, List<String>> headerFields, JSONObject jsonResponse) throws ParserException {
        C12254a adFormat = m40330a(headerFields);
        if (adFormat == null) {
            String str = "networks";
            if (jsonResponse.optJSONArray(str) != null && jsonResponse.optJSONArray(str).length() > 0 && !C12280f.m40428a((CharSequence) jsonResponse.optString("passback"))) {
                return new C12260g();
            }
            if (C12111b.m39908a(jsonResponse.optString("status")) == C12111b.f37995c && jsonResponse.has("errorcode")) {
                return new C12255b();
            }
            throw new ParserException("Could not parse ad format header, also the JSON response isn't mediation.");
        }
        int i = C12258e.f38389a[adFormat.ordinal()];
        if (i == 1) {
            return new C12256c();
        }
        if (i == 2) {
            return new C12264k();
        }
        if (i == 3) {
            return new C12261h();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Invalid ad format: ");
        sb.append(adFormat.mo39630e());
        throw new ParserException(sb.toString());
    }

    /* renamed from: a */
    private C12254a m40330a(Map<String, List<String>> headerFields) {
        if (headerFields != null) {
            List<String> adType = (List) headerFields.get("X-SMT-ADTYPE");
            if (adType != null && !adType.isEmpty()) {
                try {
                    return C12254a.m40321a((String) adType.get(0));
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return null;
    }
}
