package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class zzcxn {

    /* renamed from: a */
    public final int f27576a;

    /* renamed from: b */
    public final int f27577b;

    /* renamed from: c */
    public final boolean f27578c;

    public zzcxn(int i, int i2, boolean z) {
        this.f27576a = i;
        this.f27577b = i2;
        this.f27578c = z;
    }

    /* renamed from: a */
    static List<zzcxn> m28951a(JsonReader jsonReader) throws IllegalStateException, IOException, NumberFormatException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            jsonReader.beginObject();
            int i = 0;
            int i2 = 0;
            boolean z = false;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if ("width".equals(nextName)) {
                    i = jsonReader.nextInt();
                } else if ("height".equals(nextName)) {
                    i2 = jsonReader.nextInt();
                } else if ("is_fluid_height".equals(nextName)) {
                    z = jsonReader.nextBoolean();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            arrayList.add(new zzcxn(i, i2, z));
        }
        jsonReader.endArray();
        return arrayList;
    }
}
