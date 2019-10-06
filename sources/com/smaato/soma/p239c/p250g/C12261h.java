package com.smaato.soma.p239c.p250g;

import com.smaato.soma.C12064Na;
import com.smaato.soma.C12431j;
import com.smaato.soma.exception.ParserException;
import com.smaato.soma.internal.nativead.EventTracker;
import com.smaato.soma.p236a.p237a.C12111b;
import com.smaato.soma.p239c.C12203d;
import com.smaato.soma.p239c.p244e.C12205a;
import com.smaato.soma.p239c.p244e.C12210b;
import com.smaato.soma.p239c.p244e.p245a.C12207b;
import com.smaato.soma.p239c.p244e.p245a.C12208c;
import com.smaato.soma.p239c.p244e.p245a.C12209d;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.app.view.donations.DonationsAnalytics;

/* renamed from: com.smaato.soma.c.g.h */
/* compiled from: NativeJsonResponseParser */
class C12261h extends C12257d {
    C12261h() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C12064Na mo39631a(JSONObject jsonResponse) throws ParserException {
        try {
            C12203d banner = new C12203d();
            C12205a ad = new C12205a();
            banner.mo39499a(ad);
            banner.mo39278a(C12111b.f37994b);
            banner.mo39501a(C12431j.NATIVE);
            JSONObject rootObject = jsonResponse.getJSONObject("native");
            ad.mo39523b(rootObject.optString("ver"));
            JSONObject linkObject = rootObject.getJSONObject("link");
            ad.mo39518a(linkObject.getString("url"));
            ad.mo39520a(mo39633a(linkObject.getJSONArray("clicktrackers")));
            ad.mo39519a(m40337c(rootObject));
            m40334a(rootObject, ad);
            banner.mo39504b(mo39634b(rootObject));
            return banner;
        } catch (JSONException e) {
            throw new ParserException("Could not parse Native JSON response due to missing or wrong properties.", e);
        }
    }

    /* renamed from: a */
    private void m40334a(JSONObject rootObject, C12205a ad) throws JSONException {
        JSONArray assetsArray = rootObject.getJSONArray("assets");
        for (int i = 0; i < assetsArray.length(); i++) {
            JSONObject assetObject = assetsArray.getJSONObject(i);
            int id = assetObject.getInt("id");
            if (assetObject.optJSONObject("img") != null) {
                ad.mo39515a(m40335b(assetObject, id));
            } else if (assetObject.optJSONObject("data") != null) {
                ad.mo39514a(m40333a(assetObject, id));
            } else if (assetObject.optJSONObject("title") != null) {
                ad.mo39516a(m40336c(assetObject, id));
            }
        }
    }

    /* renamed from: b */
    private C12208c m40335b(JSONObject assetObject, int id) throws JSONException {
        JSONObject imageObject = assetObject.getJSONObject("img");
        C12208c cVar = new C12208c(id, imageObject.optInt("type"), imageObject.getString("url"), imageObject.optInt("w"), imageObject.optInt("h"));
        return cVar;
    }

    /* renamed from: a */
    private C12207b m40333a(JSONObject assetObject, int id) throws JSONException {
        JSONObject dataObject = assetObject.getJSONObject("data");
        return new C12207b(id, dataObject.optInt("type"), dataObject.getString(DonationsAnalytics.VALUE));
    }

    /* renamed from: c */
    private C12209d m40336c(JSONObject assetObject, int id) throws JSONException {
        return new C12209d(id, assetObject.getJSONObject("title").getString(CommandHandler.TEXT));
    }

    /* renamed from: c */
    private List<C12210b> m40337c(JSONObject nativeRootObject) throws JSONException {
        List<EventTracker> trackersModel = new ArrayList<>();
        JSONArray eventTrackersArray = nativeRootObject.optJSONArray("eventtrackers");
        if (eventTrackersArray != null) {
            for (int i = 0; i < eventTrackersArray.length(); i++) {
                JSONObject trackerJson = eventTrackersArray.getJSONObject(i);
                trackersModel.add(new C12210b(trackerJson.getInt("event"), trackerJson.getInt("method"), trackerJson.optString("url")));
            }
        }
        return trackersModel;
    }
}
