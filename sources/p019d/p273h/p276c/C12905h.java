package p019d.p273h.p276c;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: d.h.c.h */
/* compiled from: AuctionResponseItem */
public class C12905h {

    /* renamed from: a */
    private String f39621a;

    /* renamed from: b */
    private String f39622b;

    /* renamed from: c */
    private List<String> f39623c;

    /* renamed from: d */
    private boolean f39624d = false;

    public C12905h(JSONObject json) {
        String str = "adMarkup";
        try {
            this.f39621a = json.getString("instance");
            if (json.has(str)) {
                this.f39622b = json.getString(str);
            } else {
                this.f39622b = "";
            }
            this.f39623c = new ArrayList();
            JSONArray urls = json.getJSONArray("winURLs");
            for (int i = 0; i < urls.length(); i++) {
                this.f39623c.add(urls.getString(i));
            }
            this.f39624d = true;
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    public String mo41673a() {
        return this.f39621a;
    }

    /* renamed from: b */
    public String mo41674b() {
        return this.f39622b;
    }

    /* renamed from: c */
    public List<String> mo41675c() {
        return this.f39623c;
    }

    /* renamed from: d */
    public boolean mo41676d() {
        return this.f39624d;
    }
}
