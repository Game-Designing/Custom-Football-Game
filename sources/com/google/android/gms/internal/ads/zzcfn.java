package com.google.android.gms.internal.ads;

import android.util.JsonWriter;
import com.google.android.gms.common.util.Clock;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

public final class zzcfn {

    /* renamed from: a */
    private final Clock f26535a;

    public zzcfn(Clock clock) {
        this.f26535a = clock;
    }

    /* renamed from: a */
    public final void mo31145a(List<Object> list, String str, String str2, Object... objArr) {
        if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f23970Mb)).booleanValue()) {
            long b = this.f26535a.mo27935b();
            StringWriter stringWriter = new StringWriter();
            JsonWriter jsonWriter = new JsonWriter(stringWriter);
            try {
                jsonWriter.beginObject();
                jsonWriter.name("timestamp").value(b);
                jsonWriter.name("source").value(str);
                jsonWriter.name("event").value(str2);
                jsonWriter.name("components").beginArray();
                for (Object obj : list) {
                    jsonWriter.value(obj.toString());
                }
                jsonWriter.endArray();
                jsonWriter.name("params").beginArray();
                int length = objArr.length;
                for (int i = 0; i < length; i++) {
                    Object obj2 = objArr[i];
                    jsonWriter.value(obj2 != null ? obj2.toString() : null);
                }
                jsonWriter.endArray();
                jsonWriter.endObject();
                jsonWriter.flush();
                jsonWriter.close();
            } catch (IOException e) {
                zzbad.m26356b("unable to log", e);
            }
            String str3 = "AD-DBG ";
            String valueOf = String.valueOf(stringWriter.toString());
            zzbad.m26357c(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
        }
    }
}
