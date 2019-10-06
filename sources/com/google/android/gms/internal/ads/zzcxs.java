package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import com.google.android.gms.common.util.IOUtils;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

public final class zzcxs {

    /* renamed from: a */
    public final List<zzcxm> f27590a;

    /* renamed from: b */
    public final zzcxo f27591b;

    /* renamed from: c */
    public final List<zzcxt> f27592c;

    /* renamed from: a */
    public static zzcxs m28953a(Reader reader) throws zzcxp {
        try {
            zzcxs zzcxs = new zzcxs(new JsonReader(reader));
            IOUtils.m22102a(reader);
            return zzcxs;
        } catch (IOException | IllegalStateException | NumberFormatException | JSONException e) {
            throw new zzcxp("unable to parse ServerResponse", e);
        } catch (Throwable th) {
            IOUtils.m22102a(reader);
            throw th;
        }
    }

    private zzcxs(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException, NumberFormatException {
        List<zzcxm> emptyList = Collections.emptyList();
        ArrayList arrayList = new ArrayList();
        jsonReader.beginObject();
        zzcxo zzcxo = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if ("responses".equals(nextName)) {
                jsonReader.beginArray();
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String nextName2 = jsonReader.nextName();
                    if ("ad_configs".equals(nextName2)) {
                        emptyList = new ArrayList<>();
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            emptyList.add(new zzcxm(jsonReader));
                        }
                        jsonReader.endArray();
                    } else if (nextName2.equals("common")) {
                        zzcxo = new zzcxo(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
                jsonReader.endArray();
            } else if (nextName.equals("actions")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    jsonReader.beginObject();
                    String str = null;
                    Map map = null;
                    while (jsonReader.hasNext()) {
                        String nextName3 = jsonReader.nextName();
                        if ("name".equals(nextName3)) {
                            str = jsonReader.nextString();
                        } else if ("info".equals(nextName3)) {
                            map = zzazc.m26271b(jsonReader);
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    if (str != null) {
                        arrayList.add(new zzcxt(str, map));
                    }
                    jsonReader.endObject();
                }
                jsonReader.endArray();
            }
        }
        this.f27592c = arrayList;
        this.f27590a = emptyList;
        if (zzcxo == null) {
            zzcxo = new zzcxo(new JsonReader(new StringReader("{}")));
        }
        this.f27591b = zzcxo;
    }
}
