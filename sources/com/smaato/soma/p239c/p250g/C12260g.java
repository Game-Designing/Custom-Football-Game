package com.smaato.soma.p239c.p250g;

import com.smaato.soma.C12064Na;
import com.smaato.soma.C12431j;
import com.smaato.soma.exception.ParserException;
import com.smaato.soma.mediation.MediationNetworkInfo;
import com.smaato.soma.p236a.p237a.C12111b;
import com.smaato.soma.p239c.C12203d;
import com.smaato.soma.p239c.p252i.C12280f;
import com.smaato.soma.p256e.C12360w;
import java.util.TreeMap;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.runtime.AgentOptions;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.smaato.soma.c.g.g */
/* compiled from: MediationJsonResponseParser */
class C12260g extends C12257d {
    C12260g() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C12064Na mo39631a(JSONObject jsonResponse) throws ParserException {
        try {
            C12203d banner = new C12203d();
            banner.mo39278a(C12111b.f37994b);
            banner.mo39501a(C12431j.DISPLAY);
            banner.setSessionId(jsonResponse.getString(AgentOptions.SESSIONID));
            banner.mo39281a(jsonResponse.getString("passback"));
            JSONArray networksArray = jsonResponse.getJSONArray("networks");
            TreeMap<Integer, MediationNetworkInfo> networksMap = new TreeMap<>();
            for (int i = 0; i < networksArray.length(); i++) {
                JSONObject networkObject = networksArray.getJSONObject(i);
                C12360w networkInfo = new C12360w();
                int priority = networkObject.getInt("priority");
                networkInfo.mo39787b(priority);
                networkInfo.mo39799g(networkObject.getString("name"));
                networkInfo.mo39790c(networkObject.getInt("width"));
                networkInfo.mo39783a(networkObject.getInt("height"));
                networkInfo.mo39795e(C12280f.m40426a(networkObject.getString("impression")));
                networkInfo.mo39793d(C12280f.m40426a(networkObject.getString("clickurl")));
                networkInfo.mo39784a(C12280f.m40426a(networkObject.getString("adunitid")));
                networkInfo.mo39788b(C12280f.m40426a(networkObject.optString("appid")));
                networkInfo.mo39791c(C12280f.m40426a(networkObject.optString("classname")));
                networkInfo.mo39797f(C12280f.m40426a(networkObject.optString("methodname")));
                networkInfo.mo39785a(mo39632a(networkObject.optString("customdata")));
                networksMap.put(Integer.valueOf(priority), networkInfo);
            }
            banner.mo39282a(networksMap);
            return banner;
        } catch (JSONException e) {
            throw new ParserException("Could not parse Mediation JSON response due to missing or wrong properties.", e);
        }
    }
}
