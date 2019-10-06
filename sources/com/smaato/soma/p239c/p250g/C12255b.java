package com.smaato.soma.p239c.p250g;

import com.smaato.soma.C12064Na;
import com.smaato.soma.C12408ia;
import com.smaato.soma.exception.ParserException;
import com.smaato.soma.p236a.p237a.C12111b;
import com.smaato.soma.p239c.C12203d;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.runtime.AgentOptions;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.smaato.soma.c.g.b */
/* compiled from: ErrorJsonResponseParser */
class C12255b extends C12257d {
    C12255b() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C12064Na mo39631a(JSONObject jsonResponse) throws ParserException {
        try {
            C12203d banner = new C12203d();
            banner.setSessionId(jsonResponse.optString(AgentOptions.SESSIONID));
            banner.mo39278a(C12111b.f37995c);
            banner.mo39280a(C12408ia.m40800a(String.valueOf(jsonResponse.getInt("errorcode"))));
            banner.mo39506d(jsonResponse.getString("errormessage"));
            return banner;
        } catch (JSONException e) {
            throw new ParserException("Could not parse Error JSON response due to missing or wrong properties.", e);
        }
    }
}
