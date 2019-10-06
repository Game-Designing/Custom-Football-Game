package com.fyber.inneractive.sdk.p165f;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.util.C8005i;
import com.fyber.inneractive.sdk.util.IAlog;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.fyber.inneractive.sdk.f.b */
public final class C7730b implements C7731c {

    /* renamed from: a */
    URL f15435a;

    /* renamed from: b */
    HttpURLConnection f15436b;

    /* renamed from: c */
    public int f15437c;

    /* renamed from: d */
    public StringBuffer f15438d;

    /* renamed from: e */
    String f15439e;

    /* renamed from: f */
    private final String f15440f;

    /* renamed from: g */
    private int f15441g;

    public C7730b(String str) throws Exception {
        this(str, false, null);
    }

    public C7730b(String str, boolean z) throws Exception {
        this(str, z, null);
    }

    public C7730b(String str, String str2) throws Exception {
        this(str, false, str2);
    }

    private C7730b(String str, boolean z, String str2) throws Exception {
        this.f15437c = 5000;
        this.f15441g = 0;
        this.f15435a = null;
        this.f15440f = str2;
        StringBuilder sb = new StringBuilder("IAHttpConnection: created. url = ");
        sb.append(str);
        IAlog.m18021b(sb.toString());
        StringBuilder sb2 = new StringBuilder("IAHttpConnection: created. decodeEncodeUrl = ");
        sb2.append(z);
        IAlog.m18021b(sb2.toString());
        if (!z) {
            this.f15435a = new URL(str);
        } else if (!m17135c(str)) {
            try {
                this.f15435a = new URL(str);
            } catch (Exception e) {
                StringBuilder sb3 = new StringBuilder("IAHttpConnection: Failed to create valid Url: ");
                sb3.append(str);
                IAlog.m18021b(sb3.toString());
                throw e;
            }
        } else if (m17136d(str)) {
            this.f15435a = m17134b(str);
        } else {
            this.f15435a = new URI(str).toURL();
        }
        if (this.f15435a == null) {
            StringBuilder sb4 = new StringBuilder("IAHttpConnection: Could not encode url! ");
            sb4.append(this.f15435a);
            IAlog.m18021b(sb4.toString());
        }
    }

    /* renamed from: a */
    private void m17133a(String str, String str2) {
        HttpURLConnection httpURLConnection = this.f15436b;
        if (httpURLConnection != null) {
            httpURLConnection.addRequestProperty(str, str2);
        }
    }

    /* renamed from: a */
    public final Object mo24294a() {
        HttpURLConnection httpURLConnection = this.f15436b;
        if (httpURLConnection == null) {
            return null;
        }
        try {
            return httpURLConnection.getContent();
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: b */
    public final Map<String, String> mo24298b() {
        HashMap hashMap = new HashMap();
        Map headerFields = this.f15436b.getHeaderFields();
        if (headerFields != null) {
            for (String str : headerFields.keySet()) {
                if (str != null) {
                    List list = (List) headerFields.get(str);
                    if (list != null && list.size() > 0) {
                        hashMap.put(str, ((List) headerFields.get(str)).get(0));
                    }
                }
            }
        }
        return hashMap;
    }

    /* renamed from: a */
    public final String mo24295a(String str) {
        HttpURLConnection httpURLConnection = this.f15436b;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderField(str);
    }

    /* renamed from: c */
    public final StringBuffer mo24299c() {
        return this.f15438d;
    }

    /* renamed from: d */
    public final int mo24300d() {
        HttpURLConnection httpURLConnection = this.f15436b;
        if (httpURLConnection == null) {
            return this.f15441g;
        }
        try {
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 0) {
                return this.f15441g;
            }
            return responseCode;
        } catch (Exception e) {
            return this.f15441g;
        }
    }

    /* renamed from: a */
    public final boolean mo24296a(int i, Map<String, String> map) {
        boolean z = true;
        try {
            if (!TextUtils.isEmpty(this.f15439e)) {
                StringBuilder sb = new StringBuilder("IAHttpConnection: Hitting POST URL ");
                sb.append(this.f15435a.toString());
                sb.append(" body: ");
                sb.append(this.f15439e);
                IAlog.m18021b(sb.toString());
            } else {
                StringBuilder sb2 = new StringBuilder("IAHttpConnection: Hitting GET URL ");
                sb2.append(this.f15435a.toString());
                IAlog.m18021b(sb2.toString());
            }
            this.f15436b = (HttpURLConnection) this.f15435a.openConnection();
            this.f15436b.setConnectTimeout(i);
            this.f15436b.setReadTimeout(this.f15437c);
            m17133a("User-Agent", C8005i.m18060i());
            if (this.f15440f != null) {
                m17133a("If-Modified-Since", this.f15440f);
            }
            m17133a("Accept-Encoding", "gzip");
            if (!TextUtils.isEmpty(this.f15439e)) {
                this.f15436b.setRequestMethod("POST");
                this.f15436b.setDoInput(true);
                this.f15436b.setDoOutput(true);
                StringBuilder sb3 = new StringBuilder();
                sb3.append(Integer.toString(this.f15439e.getBytes().length));
                this.f15436b.setRequestProperty("Content-Length", sb3.toString());
                this.f15436b.getOutputStream().write(this.f15439e.getBytes("UTF-8"));
            }
            if (map != null) {
                for (String str : map.keySet()) {
                    m17133a(str, (String) map.get(str));
                }
            }
            this.f15436b.connect();
        } catch (Exception e) {
            z = false;
            if (IAlog.f16291a == 2) {
                e.printStackTrace();
            }
            StringBuilder sb4 = new StringBuilder("IAHttpConnection: Exception during connect to: ");
            sb4.append(this.f15435a.toString());
            IAlog.m18021b(sb4.toString());
            m17137f();
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003b A[Catch:{ Exception -> 0x00af, all -> 0x00ad }] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0047 A[Catch:{ Exception -> 0x00af, all -> 0x00ad }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0074 A[Catch:{ Exception -> 0x00af, all -> 0x00ad }, LOOP:0: B:16:0x0071->B:18:0x0074, LOOP_END] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean mo24297a(boolean r8) {
        /*
            r7 = this;
            java.lang.String r0 = "IAHttpConnection: getInputStream for url "
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "IAHttpConnection: getInputStream called with fillBuffer = "
            r1.<init>(r2)
            r1.append(r8)
            java.lang.String r1 = r1.toString()
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r1)
            r1 = 1
            r2 = 0
            r3 = 0
            java.net.HttpURLConnection r4 = r7.f15436b     // Catch:{ Exception -> 0x00af }
            java.io.InputStream r4 = r4.getInputStream()     // Catch:{ Exception -> 0x00af }
            java.net.HttpURLConnection r5 = r7.f15436b     // Catch:{ Exception -> 0x00af }
            if (r5 == 0) goto L_0x0038
            java.net.HttpURLConnection r5 = r7.f15436b     // Catch:{ Exception -> 0x00af }
            java.lang.String r5 = r5.getContentEncoding()     // Catch:{ Exception -> 0x00af }
            if (r5 != 0) goto L_0x002b
            goto L_0x0038
        L_0x002b:
            java.net.HttpURLConnection r5 = r7.f15436b     // Catch:{ Exception -> 0x00af }
            java.lang.String r5 = r5.getContentEncoding()     // Catch:{ Exception -> 0x00af }
            java.lang.String r6 = "gzip"
            boolean r5 = r5.contains(r6)     // Catch:{ Exception -> 0x00af }
            goto L_0x0039
        L_0x0038:
            r5 = 0
        L_0x0039:
            if (r5 == 0) goto L_0x0047
            java.lang.String r5 = "IAHttpConnection: getInputStream found gzip encoding"
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r5)     // Catch:{ Exception -> 0x00af }
            java.util.zip.GZIPInputStream r5 = new java.util.zip.GZIPInputStream     // Catch:{ Exception -> 0x00af }
            r5.<init>(r4)     // Catch:{ Exception -> 0x00af }
            r3 = r5
            goto L_0x0052
        L_0x0047:
            java.lang.String r5 = "IAHttpConnection: getInputStream no gzip encoding"
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r5)     // Catch:{ Exception -> 0x00af }
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x00af }
            r5.<init>(r4)     // Catch:{ Exception -> 0x00af }
            r3 = r5
        L_0x0052:
            java.net.HttpURLConnection r4 = r7.f15436b     // Catch:{ Exception -> 0x00af }
            int r4 = r4.getResponseCode()     // Catch:{ Exception -> 0x00af }
            r7.f15441g = r4     // Catch:{ Exception -> 0x00af }
            int r4 = r7.f15441g     // Catch:{ Exception -> 0x00af }
            r5 = 200(0xc8, float:2.8E-43)
            if (r4 != r5) goto L_0x0083
            if (r1 != r8) goto L_0x0083
            java.lang.StringBuffer r8 = new java.lang.StringBuffer     // Catch:{ Exception -> 0x00af }
            r8.<init>()     // Catch:{ Exception -> 0x00af }
            r7.f15438d = r8     // Catch:{ Exception -> 0x00af }
            r8 = 4096(0x1000, float:5.74E-42)
            byte[] r8 = new byte[r8]     // Catch:{ Exception -> 0x00af }
            r4 = 0
        L_0x0071:
            r5 = -1
            if (r4 == r5) goto L_0x0083
            java.lang.StringBuffer r5 = r7.f15438d     // Catch:{ Exception -> 0x00af }
            java.lang.String r6 = new java.lang.String     // Catch:{ Exception -> 0x00af }
            r6.<init>(r8, r2, r4)     // Catch:{ Exception -> 0x00af }
            r5.append(r6)     // Catch:{ Exception -> 0x00af }
            int r4 = r3.read(r8)     // Catch:{ Exception -> 0x00af }
            goto L_0x0071
        L_0x0083:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00af }
            r8.<init>(r0)     // Catch:{ Exception -> 0x00af }
            java.net.URL r4 = r7.f15435a     // Catch:{ Exception -> 0x00af }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00af }
            r8.append(r4)     // Catch:{ Exception -> 0x00af }
            java.lang.String r4 = " succeeded! ("
            r8.append(r4)     // Catch:{ Exception -> 0x00af }
            int r4 = r7.f15441g     // Catch:{ Exception -> 0x00af }
            r8.append(r4)     // Catch:{ Exception -> 0x00af }
            java.lang.String r4 = ")"
            r8.append(r4)     // Catch:{ Exception -> 0x00af }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x00af }
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r8)     // Catch:{ Exception -> 0x00af }
            r3.close()     // Catch:{ Exception -> 0x00ab }
        L_0x00aa:
            goto L_0x00dc
        L_0x00ab:
            r8 = move-exception
            goto L_0x00aa
        L_0x00ad:
            r8 = move-exception
            goto L_0x00dd
        L_0x00af:
            r8 = move-exception
            int r1 = com.fyber.inneractive.sdk.util.IAlog.f16291a     // Catch:{ all -> 0x00ad }
            r4 = 2
            if (r1 != r4) goto L_0x00b9
            r8.printStackTrace()     // Catch:{ all -> 0x00ad }
        L_0x00b9:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ad }
            r8.<init>(r0)     // Catch:{ all -> 0x00ad }
            java.net.URL r0 = r7.f15435a     // Catch:{ all -> 0x00ad }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00ad }
            r8.append(r0)     // Catch:{ all -> 0x00ad }
            java.lang.String r0 = " failed!"
            r8.append(r0)     // Catch:{ all -> 0x00ad }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x00ad }
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r8)     // Catch:{ all -> 0x00ad }
            if (r3 == 0) goto L_0x00db
            r3.close()     // Catch:{ Exception -> 0x00d9 }
        L_0x00d8:
            goto L_0x00db
        L_0x00d9:
            r8 = move-exception
            goto L_0x00d8
        L_0x00db:
            r1 = 0
        L_0x00dc:
            return r1
        L_0x00dd:
            if (r3 == 0) goto L_0x00e4
            r3.close()     // Catch:{ Exception -> 0x00e3 }
            goto L_0x00e4
        L_0x00e3:
            r0 = move-exception
        L_0x00e4:
            goto L_0x00e6
        L_0x00e5:
            throw r8
        L_0x00e6:
            goto L_0x00e5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.p165f.C7730b.mo24297a(boolean):boolean");
    }

    /* renamed from: e */
    public final void mo24301e() {
        if (this.f15436b != null) {
            m17137f();
        }
        this.f15436b = null;
        this.f15438d = null;
    }

    /* renamed from: f */
    private void m17137f() {
        if (this.f15436b != null) {
            StringBuilder sb = new StringBuilder("IAHttpConnection: disconnect: ");
            sb.append(this.f15435a.toString());
            IAlog.m18021b(sb.toString());
            try {
                this.f15436b.disconnect();
            } catch (Exception e) {
                StringBuilder sb2 = new StringBuilder("IAHttpConnection: exception during disconnect: ");
                sb2.append(this.f15435a.toString());
                IAlog.m18021b(sb2.toString());
            }
        }
        this.f15436b = null;
    }

    /* renamed from: b */
    private static URL m17134b(String str) {
        URL url;
        try {
            url = new URL(str.replace("%2B", "+"));
            try {
                URI uri = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef());
                return uri.toURL();
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder("getEncodedUrl: invalid url detected - ");
                sb.append(str);
                IAlog.m18021b(sb.toString());
                return url;
            }
        } catch (Exception e2) {
            url = null;
            StringBuilder sb2 = new StringBuilder("getEncodedUrl: invalid url detected - ");
            sb2.append(str);
            IAlog.m18021b(sb2.toString());
            return url;
        }
    }

    /* renamed from: c */
    private static boolean m17135c(String str) {
        try {
            URLDecoder.decode(str, "UTF-8");
            return true;
        } catch (UnsupportedEncodingException e) {
            StringBuilder sb = new StringBuilder("Failed to decode Url: ");
            sb.append(str);
            IAlog.m18021b(sb.toString());
            return false;
        }
    }

    /* renamed from: d */
    private static boolean m17136d(String str) {
        try {
            new URI(str);
            return false;
        } catch (URISyntaxException e) {
            return true;
        }
    }
}
