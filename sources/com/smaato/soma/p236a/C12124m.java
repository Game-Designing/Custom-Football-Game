package com.smaato.soma.p236a;

import android.app.AlertDialog.Builder;
import android.os.Handler;
import com.smaato.soma.C12398ha;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import com.smaato.soma.p239c.p240a.C12152a;
import com.smaato.soma.p239c.p251h.C12266b.C12267a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.smaato.soma.a.m */
/* compiled from: AbstractBannerPackage */
class C12124m extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ String f38016a;

    /* renamed from: b */
    final /* synthetic */ C12126a f38017b;

    C12124m(C12126a this$1, String str) {
        this.f38017b = this$1;
        this.f38016a = str;
    }

    public Void process() throws Exception {
        String str = "Banner_Package";
        String str2 = "property";
        String str3 = this.f38016a;
        if (str3 == null || str3.length() < 1 || C12125n.this.mo39355f().getBannerState().mo39638a() != C12267a.STATE_BANNEREXPANDED) {
            return null;
        }
        C12152a appLink = new C12152a();
        try {
            JSONArray links = new JSONArray(this.f38016a);
            for (int index = 0; index < links.length(); index++) {
                JSONObject jsonObject = links.getJSONObject(index);
                String str4 = "content";
                if (jsonObject.getString(str2).equalsIgnoreCase("al:android:package")) {
                    appLink.mo39394c(jsonObject.getString(str4).toString());
                } else if (jsonObject.getString(str2).equalsIgnoreCase("al:android:url")) {
                    appLink.mo39395d(jsonObject.getString(str4).toString());
                } else if (jsonObject.getString(str2).equalsIgnoreCase("al:android:class")) {
                    appLink.mo39389a(jsonObject.getString(str4).toString());
                } else if (jsonObject.getString(str2).equalsIgnoreCase("al:android:app_name")) {
                    appLink.mo39392b(jsonObject.getString(str4).toString());
                }
                C12146d.m39965a(new C12147e(str, appLink.toString(), 1, C12143a.DEBUG));
            }
            if (appLink.mo39390a(C12125n.this.mo39357h())) {
                Builder title = new Builder(C12125n.this.mo39357h()).setTitle("Redirecting ...");
                StringBuilder sb = new StringBuilder();
                sb.append("Opening ");
                sb.append(appLink.mo39388a());
                new Handler().postDelayed(new C12123l(this, title.setMessage(sb.toString()).show(), appLink), 3000);
            }
        } catch (JSONException e) {
            C12146d.m39965a(new C12147e(str, "JSON parsing exception", 1, C12143a.ERROR));
        }
        return null;
    }
}
