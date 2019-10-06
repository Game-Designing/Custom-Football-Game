package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.util.JsonReader;
import com.google.android.gms.ads.internal.zzk;
import java.io.IOException;
import org.json.JSONException;

public final class zzcrc {

    /* renamed from: a */
    public final String f27262a;

    /* renamed from: b */
    public String f27263b;

    public zzcrc(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException, NumberFormatException {
        jsonReader.beginObject();
        String str = "";
        String str2 = str;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName == null) {
                nextName = str;
            }
            char c = 65535;
            if (nextName.hashCode() == -995427962 && nextName.equals("params")) {
                c = 0;
            }
            if (c != 0) {
                jsonReader.skipValue();
            } else {
                str2 = jsonReader.nextString();
            }
        }
        this.f27262a = str2;
        jsonReader.endObject();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final zzcrc mo31250a(Bundle bundle) {
        try {
            this.f27263b = zzk.zzlg().mo30228a(bundle).toString();
        } catch (JSONException e) {
            this.f27263b = "{}";
        }
        return this;
    }
}
