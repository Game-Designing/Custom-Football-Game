package com.mopub.volley.toolbox;

import com.mopub.volley.Cache.Entry;
import com.mopub.volley.Header;
import com.mopub.volley.Network;
import com.mopub.volley.Request;
import com.mopub.volley.RetryPolicy;
import com.mopub.volley.ServerError;
import com.mopub.volley.VolleyError;
import com.mopub.volley.VolleyLog;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

public class BasicNetwork implements Network {

    /* renamed from: a */
    protected static final boolean f36477a = VolleyLog.DEBUG;

    /* renamed from: b */
    private final BaseHttpStack f36478b;

    /* renamed from: c */
    protected final ByteArrayPool f36479c;

    public BasicNetwork(BaseHttpStack httpStack) {
        this(httpStack, new ByteArrayPool(Opcodes.ACC_SYNTHETIC));
    }

    public BasicNetwork(BaseHttpStack httpStack, ByteArrayPool pool) {
        this.f36478b = httpStack;
        this.f36479c = pool;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00bf, code lost:
        throw new java.io.IOException();
     */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0176 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00f6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.mopub.volley.NetworkResponse performRequest(com.mopub.volley.Request<?> r30) throws com.mopub.volley.VolleyError {
        /*
            r29 = this;
            r7 = r29
            r8 = r30
            long r9 = android.os.SystemClock.elapsedRealtime()
        L_0x0008:
            r1 = 0
            r2 = 0
            java.util.List r3 = java.util.Collections.emptyList()
            r11 = 0
            com.mopub.volley.Cache$Entry r0 = r30.getCacheEntry()     // Catch:{ SocketTimeoutException -> 0x0199, MalformedURLException -> 0x017c, IOException -> 0x00f2 }
            java.util.Map r0 = r7.m38609a(r0)     // Catch:{ SocketTimeoutException -> 0x0199, MalformedURLException -> 0x017c, IOException -> 0x00f2 }
            com.mopub.volley.toolbox.BaseHttpStack r4 = r7.f36478b     // Catch:{ SocketTimeoutException -> 0x0199, MalformedURLException -> 0x017c, IOException -> 0x00f2 }
            com.mopub.volley.toolbox.HttpResponse r4 = r4.executeRequest(r8, r0)     // Catch:{ SocketTimeoutException -> 0x0199, MalformedURLException -> 0x017c, IOException -> 0x00f2 }
            r12 = r4
            int r1 = r12.getStatusCode()     // Catch:{ SocketTimeoutException -> 0x00ef, MalformedURLException -> 0x00ec, IOException -> 0x00ea }
            r15 = r1
            java.util.List r1 = r12.getHeaders()     // Catch:{ SocketTimeoutException -> 0x00ef, MalformedURLException -> 0x00ec, IOException -> 0x00ea }
            r14 = r1
            r1 = 304(0x130, float:4.26E-43)
            if (r15 != r1) goto L_0x006f
            com.mopub.volley.Cache$Entry r1 = r30.getCacheEntry()     // Catch:{ SocketTimeoutException -> 0x006b, MalformedURLException -> 0x0067, IOException -> 0x0063 }
            if (r1 != 0) goto L_0x0049
            com.mopub.volley.NetworkResponse r3 = new com.mopub.volley.NetworkResponse     // Catch:{ SocketTimeoutException -> 0x006b, MalformedURLException -> 0x0067, IOException -> 0x0063 }
            r17 = 304(0x130, float:4.26E-43)
            r18 = 0
            r19 = 1
            long r4 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x006b, MalformedURLException -> 0x0067, IOException -> 0x0063 }
            long r20 = r4 - r9
            r16 = r3
            r22 = r14
            r16.<init>(r17, r18, r19, r20, r22)     // Catch:{ SocketTimeoutException -> 0x006b, MalformedURLException -> 0x0067, IOException -> 0x0063 }
            return r3
        L_0x0049:
            java.util.List r28 = m38608a(r14, r1)     // Catch:{ SocketTimeoutException -> 0x006b, MalformedURLException -> 0x0067, IOException -> 0x0063 }
            com.mopub.volley.NetworkResponse r3 = new com.mopub.volley.NetworkResponse     // Catch:{ SocketTimeoutException -> 0x006b, MalformedURLException -> 0x0067, IOException -> 0x0063 }
            r23 = 304(0x130, float:4.26E-43)
            byte[] r4 = r1.data     // Catch:{ SocketTimeoutException -> 0x006b, MalformedURLException -> 0x0067, IOException -> 0x0063 }
            r25 = 1
            long r5 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x006b, MalformedURLException -> 0x0067, IOException -> 0x0063 }
            long r26 = r5 - r9
            r22 = r3
            r24 = r4
            r22.<init>(r23, r24, r25, r26, r28)     // Catch:{ SocketTimeoutException -> 0x006b, MalformedURLException -> 0x0067, IOException -> 0x0063 }
            return r3
        L_0x0063:
            r0 = move-exception
            r3 = r14
            goto L_0x00f4
        L_0x0067:
            r0 = move-exception
            r3 = r14
            goto L_0x017e
        L_0x006b:
            r0 = move-exception
            r3 = r14
            goto L_0x019b
        L_0x006f:
            java.io.InputStream r1 = r12.getContent()     // Catch:{ SocketTimeoutException -> 0x00e6, MalformedURLException -> 0x00e2, IOException -> 0x00df }
            r13 = r1
            if (r13 == 0) goto L_0x0082
            int r1 = r12.getContentLength()     // Catch:{ SocketTimeoutException -> 0x006b, MalformedURLException -> 0x0067, IOException -> 0x0063 }
            byte[] r1 = r7.m38612a(r13, r1)     // Catch:{ SocketTimeoutException -> 0x006b, MalformedURLException -> 0x0067, IOException -> 0x0063 }
            r20 = r1
            goto L_0x0086
        L_0x0082:
            byte[] r1 = new byte[r11]     // Catch:{ SocketTimeoutException -> 0x00e6, MalformedURLException -> 0x00e2, IOException -> 0x00df }
            r20 = r1
        L_0x0086:
            long r1 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x00d9, MalformedURLException -> 0x00d3, IOException -> 0x00ce }
            long r21 = r1 - r9
            r1 = r29
            r2 = r21
            r4 = r30
            r5 = r20
            r6 = r15
            r1.m38610a(r2, r4, r5, r6)     // Catch:{ SocketTimeoutException -> 0x00d9, MalformedURLException -> 0x00d3, IOException -> 0x00ce }
            r1 = 200(0xc8, float:2.8E-43)
            if (r15 < r1) goto L_0x00b7
            r1 = 299(0x12b, float:4.19E-43)
            if (r15 > r1) goto L_0x00b7
            com.mopub.volley.NetworkResponse r1 = new com.mopub.volley.NetworkResponse     // Catch:{ SocketTimeoutException -> 0x00d9, MalformedURLException -> 0x00d3, IOException -> 0x00ce }
            r16 = 0
            long r2 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x00d9, MalformedURLException -> 0x00d3, IOException -> 0x00ce }
            long r17 = r2 - r9
            r2 = r13
            r13 = r1
            r3 = r14
            r14 = r15
            r4 = r15
            r15 = r20
            r19 = r3
            r13.<init>(r14, r15, r16, r17, r19)     // Catch:{ SocketTimeoutException -> 0x00c9, MalformedURLException -> 0x00c4, IOException -> 0x00c0 }
            return r1
        L_0x00b7:
            r2 = r13
            r3 = r14
            r4 = r15
            java.io.IOException r1 = new java.io.IOException     // Catch:{ SocketTimeoutException -> 0x00c9, MalformedURLException -> 0x00c4, IOException -> 0x00c0 }
            r1.<init>()     // Catch:{ SocketTimeoutException -> 0x00c9, MalformedURLException -> 0x00c4, IOException -> 0x00c0 }
            throw r1     // Catch:{ SocketTimeoutException -> 0x00c9, MalformedURLException -> 0x00c4, IOException -> 0x00c0 }
        L_0x00c0:
            r0 = move-exception
            r2 = r20
            goto L_0x00f4
        L_0x00c4:
            r0 = move-exception
            r2 = r20
            goto L_0x017e
        L_0x00c9:
            r0 = move-exception
            r2 = r20
            goto L_0x019b
        L_0x00ce:
            r0 = move-exception
            r3 = r14
            r2 = r20
            goto L_0x00f4
        L_0x00d3:
            r0 = move-exception
            r3 = r14
            r2 = r20
            goto L_0x017e
        L_0x00d9:
            r0 = move-exception
            r3 = r14
            r2 = r20
            goto L_0x019b
        L_0x00df:
            r0 = move-exception
            r3 = r14
            goto L_0x00f4
        L_0x00e2:
            r0 = move-exception
            r3 = r14
            goto L_0x017e
        L_0x00e6:
            r0 = move-exception
            r3 = r14
            goto L_0x019b
        L_0x00ea:
            r0 = move-exception
            goto L_0x00f4
        L_0x00ec:
            r0 = move-exception
            goto L_0x017e
        L_0x00ef:
            r0 = move-exception
            goto L_0x019b
        L_0x00f2:
            r0 = move-exception
            r12 = r1
        L_0x00f4:
            if (r12 == 0) goto L_0x0176
            int r1 = r12.getStatusCode()
            r4 = 2
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.Integer r5 = java.lang.Integer.valueOf(r1)
            r4[r11] = r5
            r5 = 1
            java.lang.String r6 = r30.getUrl()
            r4[r5] = r6
            java.lang.String r5 = "Unexpected response code %d for %s"
            com.mopub.volley.VolleyLog.m38604e(r5, r4)
            if (r2 == 0) goto L_0x016b
            com.mopub.volley.NetworkResponse r4 = new com.mopub.volley.NetworkResponse
            r16 = 0
            long r5 = android.os.SystemClock.elapsedRealtime()
            long r17 = r5 - r9
            r13 = r4
            r14 = r1
            r15 = r2
            r19 = r3
            r13.<init>(r14, r15, r16, r17, r19)
            r5 = 401(0x191, float:5.62E-43)
            if (r1 == r5) goto L_0x0160
            r5 = 403(0x193, float:5.65E-43)
            if (r1 != r5) goto L_0x012c
            goto L_0x0160
        L_0x012c:
            r5 = 400(0x190, float:5.6E-43)
            if (r1 < r5) goto L_0x013b
            r5 = 499(0x1f3, float:6.99E-43)
            if (r1 <= r5) goto L_0x0135
            goto L_0x013b
        L_0x0135:
            com.mopub.volley.ClientError r5 = new com.mopub.volley.ClientError
            r5.<init>(r4)
            throw r5
        L_0x013b:
            r5 = 500(0x1f4, float:7.0E-43)
            if (r1 < r5) goto L_0x015a
            r5 = 599(0x257, float:8.4E-43)
            if (r1 > r5) goto L_0x015a
            boolean r5 = r30.shouldRetryServerErrors()
            if (r5 == 0) goto L_0x0154
            com.mopub.volley.ServerError r5 = new com.mopub.volley.ServerError
            r5.<init>(r4)
            java.lang.String r6 = "server"
            m38611a(r6, r8, r5)
            goto L_0x01a6
        L_0x0154:
            com.mopub.volley.ServerError r5 = new com.mopub.volley.ServerError
            r5.<init>(r4)
            throw r5
        L_0x015a:
            com.mopub.volley.ServerError r5 = new com.mopub.volley.ServerError
            r5.<init>(r4)
            throw r5
        L_0x0160:
            com.mopub.volley.AuthFailureError r5 = new com.mopub.volley.AuthFailureError
            r5.<init>(r4)
            java.lang.String r6 = "auth"
            m38611a(r6, r8, r5)
            goto L_0x01a6
        L_0x016b:
            com.mopub.volley.NetworkError r4 = new com.mopub.volley.NetworkError
            r4.<init>()
            java.lang.String r5 = "network"
            m38611a(r5, r8, r4)
            goto L_0x01a6
        L_0x0176:
            com.mopub.volley.NoConnectionError r1 = new com.mopub.volley.NoConnectionError
            r1.<init>(r0)
            throw r1
        L_0x017c:
            r0 = move-exception
            r12 = r1
        L_0x017e:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Bad URL "
            r4.append(r5)
            java.lang.String r5 = r30.getUrl()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r1.<init>(r4, r0)
            throw r1
        L_0x0199:
            r0 = move-exception
            r12 = r1
        L_0x019b:
            com.mopub.volley.TimeoutError r1 = new com.mopub.volley.TimeoutError
            r1.<init>()
            java.lang.String r4 = "socket"
            m38611a(r4, r8, r1)
        L_0x01a6:
            goto L_0x0008
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.volley.toolbox.BasicNetwork.performRequest(com.mopub.volley.Request):com.mopub.volley.NetworkResponse");
    }

    /* renamed from: a */
    private void m38610a(long requestLifetime, Request<?> request, byte[] responseContents, int statusCode) {
        if (f36477a || requestLifetime > 3000) {
            Object[] objArr = new Object[5];
            objArr[0] = request;
            objArr[1] = Long.valueOf(requestLifetime);
            objArr[2] = responseContents != null ? Integer.valueOf(responseContents.length) : "null";
            objArr[3] = Integer.valueOf(statusCode);
            objArr[4] = Integer.valueOf(request.getRetryPolicy().getCurrentRetryCount());
            VolleyLog.m38603d("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
        }
    }

    /* renamed from: a */
    private static void m38611a(String logPrefix, Request<?> request, VolleyError exception) throws VolleyError {
        RetryPolicy retryPolicy = request.getRetryPolicy();
        int oldTimeout = request.getTimeoutMs();
        try {
            retryPolicy.retry(exception);
            request.addMarker(String.format("%s-retry [timeout=%s]", new Object[]{logPrefix, Integer.valueOf(oldTimeout)}));
        } catch (VolleyError e) {
            request.addMarker(String.format("%s-timeout-giveup [timeout=%s]", new Object[]{logPrefix, Integer.valueOf(oldTimeout)}));
            throw e;
        }
    }

    /* renamed from: a */
    private Map<String, String> m38609a(Entry entry) {
        if (entry == null) {
            return Collections.emptyMap();
        }
        Map<String, String> headers = new HashMap<>();
        String str = entry.etag;
        if (str != null) {
            headers.put("If-None-Match", str);
        }
        long j = entry.lastModified;
        if (j > 0) {
            headers.put("If-Modified-Since", HttpHeaderParser.m38636a(j));
        }
        return headers;
    }

    /* renamed from: a */
    private byte[] m38612a(InputStream in, int contentLength) throws IOException, ServerError {
        PoolingByteArrayOutputStream bytes = new PoolingByteArrayOutputStream(this.f36479c, contentLength);
        byte[] buffer = null;
        String str = "Error occurred when closing InputStream";
        if (in != null) {
            try {
                buffer = this.f36479c.getBuf(Opcodes.ACC_ABSTRACT);
                while (true) {
                    int read = in.read(buffer);
                    int count = read;
                    if (read == -1) {
                        break;
                    }
                    bytes.write(buffer, 0, count);
                }
                byte[] byteArray = bytes.toByteArray();
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        VolleyLog.m38606v(str, new Object[0]);
                    }
                }
                return byteArray;
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e2) {
                        VolleyLog.m38606v(str, new Object[0]);
                    }
                }
                this.f36479c.returnBuf(buffer);
                bytes.close();
            }
        } else {
            throw new ServerError();
        }
    }

    /* renamed from: a */
    private static List<Header> m38608a(List<Header> responseHeaders, Entry entry) {
        Set<String> headerNamesFromNetworkResponse = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        if (!responseHeaders.isEmpty()) {
            for (Header header : responseHeaders) {
                headerNamesFromNetworkResponse.add(header.getName());
            }
        }
        List<Header> combinedHeaders = new ArrayList<>(responseHeaders);
        List<Header> list = entry.allResponseHeaders;
        if (list != null) {
            if (!list.isEmpty()) {
                for (Header header2 : entry.allResponseHeaders) {
                    if (!headerNamesFromNetworkResponse.contains(header2.getName())) {
                        combinedHeaders.add(header2);
                    }
                }
            }
        } else if (!entry.responseHeaders.isEmpty()) {
            for (Map.Entry<String, String> header3 : entry.responseHeaders.entrySet()) {
                if (!headerNamesFromNetworkResponse.contains(header3.getKey())) {
                    combinedHeaders.add(new Header((String) header3.getKey(), (String) header3.getValue()));
                }
            }
        }
        return combinedHeaders;
    }
}
