package com.inmobi.ads.cache;

import android.net.Uri;
import com.inmobi.commons.core.p218a.C10621a;
import com.inmobi.commons.core.p222e.C10658a;
import com.inmobi.p207a.C10299n;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.ads.cache.c */
/* compiled from: AdAssetFetcher */
public final class C10516c {

    /* renamed from: b */
    private static final String f32075b = C10516c.class.getSimpleName();

    /* renamed from: a */
    C10518e f32076a;

    C10516c(C10518e eVar) {
        this.f32076a = eVar;
    }

    /* renamed from: a */
    static String m34427a(C10513a aVar, File file, long j, long j2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", aVar.f32048d);
            jSONObject.put("saved_url", Uri.fromFile(file));
            jSONObject.put("size_in_bytes", file.length());
            jSONObject.put("download_started_at", j);
            jSONObject.put("download_ended_at", j2);
        } catch (JSONException e) {
            C10621a.m34854a().mo34423a(new C10658a(e));
        }
        return jSONObject.toString().replace("\"", "\\\"");
    }

    /* renamed from: a */
    static void m34428a(long j, long j2, long j3) {
        try {
            C10299n.m33566a().mo33663a(0);
            C10299n.m33566a().mo33664b(j2);
            C10299n.m33566a().mo33665c(j3 - j);
        } catch (Exception e) {
            new StringBuilder("Error in setting request-response data size. ").append(e.getMessage());
            C10621a.m34854a().mo34423a(new C10658a(e));
        }
    }
}
