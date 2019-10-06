package com.smaato.soma.p239c.p246f;

import android.os.AsyncTask;
import com.smaato.soma.C12064Na;
import com.smaato.soma.exception.BannerHttpRequestFailed;
import com.smaato.soma.exception.ParserException;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import com.smaato.soma.p239c.p250g.C12262i;
import com.smaato.soma.p239c.p250g.C12263j;
import com.smaato.soma.p239c.p252i.C12275a;
import com.smaato.soma.p239c.p252i.C12280f;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

/* renamed from: com.smaato.soma.c.f.t */
/* compiled from: HttpConnector */
public class C12248t implements C12250u {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static String f38370a = C12248t.class.getSimpleName();

    /* renamed from: b */
    private final C12262i f38371b;

    /* renamed from: c */
    private final C12263j f38372c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C12275a f38373d;

    /* renamed from: com.smaato.soma.c.f.t$a */
    /* compiled from: HttpConnector */
    private class C12249a extends AsyncTask<URL, Void, C12064Na> {
        private C12249a() {
        }

        /* synthetic */ C12249a(C12248t x0, C12244p x1) {
            this();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public C12064Na doInBackground(URL... params) {
            return (C12064Na) new C12246r(this, params).execute();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(C12064Na result) {
            new C12247s(this, result).execute();
            super.onPostExecute(result);
        }
    }

    public C12248t(C12262i jsonBodyParser, C12263j xmlBodyParser) {
        this.f38371b = jsonBodyParser;
        this.f38372c = xmlBodyParser;
    }

    /* JADX WARNING: type inference failed for: r5v6, types: [com.smaato.soma.Na] */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00c8, code lost:
        if (r1 == null) goto L_0x010a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00ca, code lost:
        r1.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00ea, code lost:
        if (r1 == null) goto L_0x010a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0107, code lost:
        if (r1 == null) goto L_0x010a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x010a, code lost:
        return r0;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    @com.mopub.common.VisibleForTesting
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.smaato.soma.C12064Na mo39615b(java.net.URL r8) throws java.lang.Exception {
        /*
            r7 = this;
            com.smaato.soma.c.f.p r0 = new com.smaato.soma.c.f.p
            r0.<init>(r7)
            com.smaato.soma.p238b.C12146d.m39966a(r0)
            com.smaato.soma.c.d r0 = new com.smaato.soma.c.d
            r0.<init>()
            r1 = 0
            r2 = 0
            com.smaato.soma.c.f.w r3 = com.smaato.soma.p239c.p246f.C12252w.m40307b()     // Catch:{ ParserException -> 0x00ed, SocketTimeoutException -> 0x00d2, UnknownHostException -> 0x00d0 }
            java.net.Proxy r3 = r3.mo39627c()     // Catch:{ ParserException -> 0x00ed, SocketTimeoutException -> 0x00d2, UnknownHostException -> 0x00d0 }
            if (r3 != 0) goto L_0x0021
            java.net.URLConnection r3 = r8.openConnection()     // Catch:{ ParserException -> 0x00ed, SocketTimeoutException -> 0x00d2, UnknownHostException -> 0x00d0 }
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch:{ ParserException -> 0x00ed, SocketTimeoutException -> 0x00d2, UnknownHostException -> 0x00d0 }
            r1 = r3
            goto L_0x0030
        L_0x0021:
            com.smaato.soma.c.f.w r3 = com.smaato.soma.p239c.p246f.C12252w.m40307b()     // Catch:{ ParserException -> 0x00ed, SocketTimeoutException -> 0x00d2, UnknownHostException -> 0x00d0 }
            java.net.Proxy r3 = r3.mo39627c()     // Catch:{ ParserException -> 0x00ed, SocketTimeoutException -> 0x00d2, UnknownHostException -> 0x00d0 }
            java.net.URLConnection r3 = r8.openConnection(r3)     // Catch:{ ParserException -> 0x00ed, SocketTimeoutException -> 0x00d2, UnknownHostException -> 0x00d0 }
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch:{ ParserException -> 0x00ed, SocketTimeoutException -> 0x00d2, UnknownHostException -> 0x00d0 }
            r1 = r3
        L_0x0030:
            java.lang.String r3 = "GET"
            r1.setRequestMethod(r3)     // Catch:{ ParserException -> 0x00ed, SocketTimeoutException -> 0x00d2, UnknownHostException -> 0x00d0 }
            r3 = 5000(0x1388, float:7.006E-42)
            r1.setConnectTimeout(r3)     // Catch:{ ParserException -> 0x00ed, SocketTimeoutException -> 0x00d2, UnknownHostException -> 0x00d0 }
            r1.setReadTimeout(r3)     // Catch:{ ParserException -> 0x00ed, SocketTimeoutException -> 0x00d2, UnknownHostException -> 0x00d0 }
            java.lang.String r3 = "User-Agent"
            com.smaato.soma.c.f.w r4 = com.smaato.soma.p239c.p246f.C12252w.m40307b()     // Catch:{ ParserException -> 0x00ed, SocketTimeoutException -> 0x00d2, UnknownHostException -> 0x00d0 }
            java.lang.String r4 = r4.mo39629e()     // Catch:{ ParserException -> 0x00ed, SocketTimeoutException -> 0x00d2, UnknownHostException -> 0x00d0 }
            r1.setRequestProperty(r3, r4)     // Catch:{ ParserException -> 0x00ed, SocketTimeoutException -> 0x00d2, UnknownHostException -> 0x00d0 }
            r1.connect()     // Catch:{ ParserException -> 0x00ed, SocketTimeoutException -> 0x00d2, UnknownHostException -> 0x00d0 }
            int r3 = r1.getResponseCode()     // Catch:{ ParserException -> 0x00ed, SocketTimeoutException -> 0x00d2, UnknownHostException -> 0x00d0 }
            java.util.Map r4 = r1.getHeaderFields()     // Catch:{ ParserException -> 0x00ed, SocketTimeoutException -> 0x00d2, UnknownHostException -> 0x00d0 }
            r5 = 200(0xc8, float:2.8E-43)
            if (r3 == r5) goto L_0x00a8
            r5 = 204(0xcc, float:2.86E-43)
            if (r3 == r5) goto L_0x009d
            r5 = 400(0x190, float:5.6E-43)
            if (r3 < r5) goto L_0x0083
            r5 = 500(0x1f4, float:7.0E-43)
            if (r3 >= r5) goto L_0x0083
            com.smaato.soma.ia r5 = com.smaato.soma.C12408ia.INVALID_REQUEST     // Catch:{ ParserException -> 0x00ed, SocketTimeoutException -> 0x00d2, UnknownHostException -> 0x00d0 }
            r0.mo39280a(r5)     // Catch:{ ParserException -> 0x00ed, SocketTimeoutException -> 0x00d2, UnknownHostException -> 0x00d0 }
            java.lang.String r5 = "X-SMT-MESSAGE"
            java.lang.Object r5 = r4.get(r5)     // Catch:{ ParserException -> 0x00ed, SocketTimeoutException -> 0x00d2, UnknownHostException -> 0x00d0 }
            java.util.List r5 = (java.util.List) r5     // Catch:{ ParserException -> 0x00ed, SocketTimeoutException -> 0x00d2, UnknownHostException -> 0x00d0 }
            java.lang.String r5 = com.smaato.soma.p239c.p252i.C12280f.m40427a(r5)     // Catch:{ ParserException -> 0x00ed, SocketTimeoutException -> 0x00d2, UnknownHostException -> 0x00d0 }
            boolean r6 = com.smaato.soma.p239c.p252i.C12280f.m40428a(r5)     // Catch:{ ParserException -> 0x00ed, SocketTimeoutException -> 0x00d2, UnknownHostException -> 0x00d0 }
            if (r6 == 0) goto L_0x007f
            java.lang.String r6 = "Invalid Request: Empty error message"
            r5 = r6
        L_0x007f:
            r0.mo39506d(r5)     // Catch:{ ParserException -> 0x00ed, SocketTimeoutException -> 0x00d2, UnknownHostException -> 0x00d0 }
            goto L_0x00b3
        L_0x0083:
            com.smaato.soma.ia r5 = com.smaato.soma.C12408ia.GENERAL_ERROR     // Catch:{ ParserException -> 0x00ed, SocketTimeoutException -> 0x00d2, UnknownHostException -> 0x00d0 }
            r0.mo39280a(r5)     // Catch:{ ParserException -> 0x00ed, SocketTimeoutException -> 0x00d2, UnknownHostException -> 0x00d0 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ ParserException -> 0x00ed, SocketTimeoutException -> 0x00d2, UnknownHostException -> 0x00d0 }
            r5.<init>()     // Catch:{ ParserException -> 0x00ed, SocketTimeoutException -> 0x00d2, UnknownHostException -> 0x00d0 }
            java.lang.String r6 = "Unexpected HTTP response code: "
            r5.append(r6)     // Catch:{ ParserException -> 0x00ed, SocketTimeoutException -> 0x00d2, UnknownHostException -> 0x00d0 }
            r5.append(r3)     // Catch:{ ParserException -> 0x00ed, SocketTimeoutException -> 0x00d2, UnknownHostException -> 0x00d0 }
            java.lang.String r5 = r5.toString()     // Catch:{ ParserException -> 0x00ed, SocketTimeoutException -> 0x00d2, UnknownHostException -> 0x00d0 }
            r0.mo39506d(r5)     // Catch:{ ParserException -> 0x00ed, SocketTimeoutException -> 0x00d2, UnknownHostException -> 0x00d0 }
            goto L_0x00b3
        L_0x009d:
            com.smaato.soma.ia r5 = com.smaato.soma.C12408ia.NO_AD_AVAILABLE     // Catch:{ ParserException -> 0x00ed, SocketTimeoutException -> 0x00d2, UnknownHostException -> 0x00d0 }
            r0.mo39280a(r5)     // Catch:{ ParserException -> 0x00ed, SocketTimeoutException -> 0x00d2, UnknownHostException -> 0x00d0 }
            java.lang.String r5 = "No ad is currently available matching the requesting parameter."
            r0.mo39506d(r5)     // Catch:{ ParserException -> 0x00ed, SocketTimeoutException -> 0x00d2, UnknownHostException -> 0x00d0 }
            goto L_0x00b3
        L_0x00a8:
            java.io.InputStream r5 = r1.getInputStream()     // Catch:{ ParserException -> 0x00ed, SocketTimeoutException -> 0x00d2, UnknownHostException -> 0x00d0 }
            r2 = r5
            com.smaato.soma.Na r5 = r7.m40293a(r1, r2)     // Catch:{ ParserException -> 0x00ed, SocketTimeoutException -> 0x00d2, UnknownHostException -> 0x00d0 }
            r0 = r5
        L_0x00b3:
            java.lang.String r5 = r7.m40296a(r4)     // Catch:{ ParserException -> 0x00ed, SocketTimeoutException -> 0x00d2, UnknownHostException -> 0x00d0 }
            r0.mo39285b(r5)     // Catch:{ ParserException -> 0x00ed, SocketTimeoutException -> 0x00d2, UnknownHostException -> 0x00d0 }
            java.lang.String r5 = r7.m40298b(r4)     // Catch:{ ParserException -> 0x00ed, SocketTimeoutException -> 0x00d2, UnknownHostException -> 0x00d0 }
            r0.setSessionId(r5)     // Catch:{ ParserException -> 0x00ed, SocketTimeoutException -> 0x00d2, UnknownHostException -> 0x00d0 }
            if (r2 == 0) goto L_0x00c8
            r2.close()     // Catch:{ IOException -> 0x00c7 }
            goto L_0x00c8
        L_0x00c7:
            r3 = move-exception
        L_0x00c8:
            if (r1 == 0) goto L_0x010a
        L_0x00ca:
            r1.disconnect()
            goto L_0x010a
        L_0x00ce:
            r3 = move-exception
            goto L_0x010b
        L_0x00d0:
            r3 = move-exception
            goto L_0x00d3
        L_0x00d2:
            r3 = move-exception
        L_0x00d3:
            r3.printStackTrace()     // Catch:{ all -> 0x00ce }
            com.smaato.soma.ia r4 = com.smaato.soma.C12408ia.f38748c     // Catch:{ all -> 0x00ce }
            r0.mo39280a(r4)     // Catch:{ all -> 0x00ce }
            r4 = r0
            com.smaato.soma.c.d r4 = (com.smaato.soma.p239c.C12203d) r4     // Catch:{ all -> 0x00ce }
            java.lang.String r5 = "Can't connect to the Server for ad fetching."
            r4.mo39506d(r5)     // Catch:{ all -> 0x00ce }
            if (r2 == 0) goto L_0x00ea
            r2.close()     // Catch:{ IOException -> 0x00e9 }
            goto L_0x00ea
        L_0x00e9:
            r3 = move-exception
        L_0x00ea:
            if (r1 == 0) goto L_0x010a
            goto L_0x00ca
        L_0x00ed:
            r3 = move-exception
            r3.printStackTrace()     // Catch:{ all -> 0x00ce }
            com.smaato.soma.ia r4 = com.smaato.soma.C12408ia.f38751f     // Catch:{ all -> 0x00ce }
            r0.mo39280a(r4)     // Catch:{ all -> 0x00ce }
            r4 = r0
            com.smaato.soma.c.d r4 = (com.smaato.soma.p239c.C12203d) r4     // Catch:{ all -> 0x00ce }
            java.lang.String r5 = r3.getMessage()     // Catch:{ all -> 0x00ce }
            r4.mo39506d(r5)     // Catch:{ all -> 0x00ce }
            if (r2 == 0) goto L_0x0107
            r2.close()     // Catch:{ IOException -> 0x0106 }
            goto L_0x0107
        L_0x0106:
            r3 = move-exception
        L_0x0107:
            if (r1 == 0) goto L_0x010a
            goto L_0x00ca
        L_0x010a:
            return r0
        L_0x010b:
            if (r2 == 0) goto L_0x0112
            r2.close()     // Catch:{ IOException -> 0x0111 }
            goto L_0x0112
        L_0x0111:
            r4 = move-exception
        L_0x0112:
            if (r1 == 0) goto L_0x0117
            r1.disconnect()
        L_0x0117:
            goto L_0x0119
        L_0x0118:
            throw r3
        L_0x0119:
            goto L_0x0118
        */
        throw new UnsupportedOperationException("Method not decompiled: com.smaato.soma.p239c.p246f.C12248t.mo39615b(java.net.URL):com.smaato.soma.Na");
    }

    /* renamed from: a */
    public final boolean mo39614a(URL url) throws BannerHttpRequestFailed {
        String str = "";
        try {
            C12146d.m39966a((Object) new C12245q(this));
            String str2 = f38370a;
            StringBuilder sb = new StringBuilder();
            sb.append("Load async: ");
            sb.append(url);
            C12146d.m39965a(new C12147e(str2, sb.toString(), 1, C12143a.DEBUG));
            if (url != null) {
                new C12249a(this, null).execute(new URL[]{url});
            }
            return true;
        } catch (RuntimeException e) {
            String str3 = f38370a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Ex@asyncLoadNewBanner: ");
            sb2.append(e.getMessage());
            sb2.append("Url: ");
            sb2.append(url);
            C12146d.m39965a(new C12147e(str3, sb2.toString(), 1, C12143a.ERROR));
            StringBuilder sb3 = new StringBuilder();
            sb3.append(url);
            if (e.getMessage() != null) {
                str = e.getMessage();
            }
            sb3.append(str);
            throw new BannerHttpRequestFailed(sb3.toString(), e);
        } catch (Exception e2) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(url);
            if (e2.getMessage() != null) {
                str = e2.getMessage();
            }
            sb4.append(str);
            throw new BannerHttpRequestFailed(sb4.toString(), e2);
        }
    }

    /* renamed from: a */
    public void mo39613a(C12275a connectionListener) {
        this.f38373d = connectionListener;
    }

    /* renamed from: a */
    private C12064Na m40293a(HttpURLConnection connection, InputStream responseBody) throws ParserException {
        String contentType = connection.getContentType();
        if (!C12280f.m40428a((CharSequence) contentType)) {
            String contentType2 = contentType.toLowerCase();
            Map<String, List<String>> headerFields = connection.getHeaderFields();
            if (contentType2.contains("json")) {
                return this.f38371b.mo39636a(responseBody, headerFields);
            }
            if (contentType2.contains("xml")) {
                return this.f38372c.mo39637a(responseBody);
            }
            throw m40297b();
        }
        throw m40297b();
    }

    /* renamed from: b */
    private ParserException m40297b() {
        return new ParserException("Could not parse Content-Type header or it's missing.");
    }

    /* renamed from: a */
    private String m40296a(Map<String, List<String>> headerFields) {
        if (headerFields != null) {
            List<String> sciItems = (List) headerFields.get("SCI");
            if (sciItems != null && !sciItems.isEmpty()) {
                return (String) sciItems.get(0);
            }
        }
        return null;
    }

    /* renamed from: b */
    private String m40298b(Map<String, List<String>> headerFields) {
        if (headerFields != null) {
            List<String> sessionIds = (List) headerFields.get("X-SMT-SessionId");
            if (sessionIds != null && !sessionIds.isEmpty()) {
                return (String) sessionIds.get(0);
            }
        }
        return null;
    }
}
