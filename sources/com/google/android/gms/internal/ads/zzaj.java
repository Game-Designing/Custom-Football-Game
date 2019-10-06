package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

public abstract class zzaj implements zzas {
    /* renamed from: b */
    public abstract zzar mo28471b(zzr<?> zzr, Map<String, String> map) throws IOException, zza;

    @Deprecated
    /* renamed from: a */
    public final HttpResponse mo29763a(zzr<?> zzr, Map<String, String> map) throws IOException, zza {
        zzar b = mo28471b(zzr, map);
        BasicHttpResponse basicHttpResponse = new BasicHttpResponse(new BasicStatusLine(new ProtocolVersion("HTTP", 1, 1), b.mo30010c(), ""));
        ArrayList arrayList = new ArrayList();
        for (zzl zzl : b.mo30011d()) {
            arrayList.add(new BasicHeader(zzl.mo31933a(), zzl.mo31934b()));
        }
        basicHttpResponse.setHeaders((Header[]) arrayList.toArray(new Header[arrayList.size()]));
        InputStream a = b.mo30008a();
        if (a != null) {
            BasicHttpEntity basicHttpEntity = new BasicHttpEntity();
            basicHttpEntity.setContent(a);
            basicHttpEntity.setContentLength((long) b.mo30009b());
            basicHttpResponse.setEntity(basicHttpEntity);
        }
        return basicHttpResponse;
    }
}
