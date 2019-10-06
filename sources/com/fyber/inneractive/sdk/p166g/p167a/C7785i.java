package com.fyber.inneractive.sdk.p166g.p167a;

import com.fyber.inneractive.sdk.util.C7996c;
import com.fyber.inneractive.sdk.util.IAlog;
import com.mopub.volley.DefaultRetryPolicy;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;

/* renamed from: com.fyber.inneractive.sdk.g.a.i */
final class C7785i implements Closeable {

    /* renamed from: a */
    final Executor f15650a;

    /* renamed from: b */
    private final Socket f15651b;

    /* renamed from: c */
    private final C7767d f15652c;

    /* renamed from: d */
    private InputStream f15653d;

    /* renamed from: e */
    private OutputStream f15654e;

    /* renamed from: f */
    private C7756a f15655f;

    /* renamed from: g */
    private int f15656g = 0;

    /* renamed from: h */
    private int f15657h = -1;

    /* renamed from: i */
    private boolean f15658i = false;

    /* renamed from: j */
    private boolean f15659j = false;

    /* JADX WARNING: type inference failed for: r7v1, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r7v2, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r0v16, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r7v3 */
    /* JADX WARNING: type inference failed for: r0v19 */
    /* JADX WARNING: type inference failed for: r10v0 */
    /* JADX WARNING: type inference failed for: r7v4 */
    /* JADX WARNING: type inference failed for: r0v20 */
    /* JADX WARNING: type inference failed for: r0v21 */
    /* JADX WARNING: type inference failed for: r0v24, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r0v27 */
    /* JADX WARNING: type inference failed for: r0v28 */
    /* JADX WARNING: type inference failed for: r10v1 */
    /* JADX WARNING: type inference failed for: r7v5 */
    /* JADX WARNING: type inference failed for: r0v32 */
    /* JADX WARNING: type inference failed for: r7v7 */
    /* JADX WARNING: type inference failed for: r7v8 */
    /* JADX WARNING: type inference failed for: r7v9 */
    /* JADX WARNING: type inference failed for: r0v40 */
    /* JADX WARNING: type inference failed for: r0v41 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00c6 A[SYNTHETIC, Splitter:B:49:0x00c6] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00ce A[SYNTHETIC, Splitter:B:53:0x00ce] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00e8 A[SYNTHETIC, Splitter:B:64:0x00e8] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00f0 A[SYNTHETIC, Splitter:B:68:0x00f0] */
    /* JADX WARNING: Unknown variable types count: 8 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void m17284a(com.fyber.inneractive.sdk.p166g.p167a.C7785i r11) throws java.lang.Throwable {
        /*
            boolean r0 = r11.m17285a()
            if (r0 == 0) goto L_0x019c
            com.fyber.inneractive.sdk.g.a.a r0 = r11.f15655f
            boolean r1 = r0.f15554c
            if (r1 == 0) goto L_0x0014
            java.lang.String r1 = "http.file.length"
            java.lang.String r0 = r0.mo24360a(r1)
            goto L_0x0020
        L_0x0014:
            java.io.File r0 = r0.mo24359a()
            long r0 = r0.length()
            java.lang.String r0 = java.lang.String.valueOf(r0)
        L_0x0020:
            r1 = -1
            if (r0 != 0) goto L_0x0025
            r2 = -1
            goto L_0x0029
        L_0x0025:
            int r2 = java.lang.Integer.parseInt(r0)
        L_0x0029:
            if (r0 != 0) goto L_0x002d
            r0 = -1
            goto L_0x0031
        L_0x002d:
            int r0 = java.lang.Integer.parseInt(r0)
        L_0x0031:
            boolean r3 = r11.f15658i
            if (r3 == 0) goto L_0x018a
            com.fyber.inneractive.sdk.g.a.a r3 = r11.f15655f
            java.io.File r3 = r3.mo24359a()
            long r3 = r3.length()
            int r4 = (int) r3
            r11.f15657h = r4
            int r3 = r11.f15656g
            int r4 = r11.f15657h
            r5 = 0
            r6 = 1
            if (r3 <= r4) goto L_0x00f7
            com.fyber.inneractive.sdk.g.a.a r0 = r11.f15655f
            java.lang.String r0 = r0.f15553b
            java.io.OutputStream r2 = r11.f15654e
            com.fyber.inneractive.sdk.util.c r4 = com.fyber.inneractive.sdk.util.C7996c.m18038a()
            java.nio.ByteBuffer r4 = r4.mo24838b()
            r7 = 0
            java.net.URL r8 = new java.net.URL     // Catch:{ IOException -> 0x00df, Throwable -> 0x00c2, all -> 0x00bf }
            r8.<init>(r0)     // Catch:{ IOException -> 0x00df, Throwable -> 0x00c2, all -> 0x00bf }
            java.net.URLConnection r0 = r8.openConnection()     // Catch:{ IOException -> 0x00df, Throwable -> 0x00c2, all -> 0x00bf }
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ IOException -> 0x00df, Throwable -> 0x00c2, all -> 0x00bf }
            java.lang.String r8 = "Range"
            java.lang.String r9 = "bytes=%d-"
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ IOException -> 0x00ba, Throwable -> 0x00ae, all -> 0x00b8 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ IOException -> 0x00ba, Throwable -> 0x00ae, all -> 0x00b8 }
            r6[r5] = r3     // Catch:{ IOException -> 0x00ba, Throwable -> 0x00ae, all -> 0x00b8 }
            java.lang.String r3 = java.lang.String.format(r9, r6)     // Catch:{ IOException -> 0x00ba, Throwable -> 0x00ae, all -> 0x00b8 }
            r0.setRequestProperty(r8, r3)     // Catch:{ IOException -> 0x00ba, Throwable -> 0x00ae, all -> 0x00b8 }
            r0.connect()     // Catch:{ IOException -> 0x00ba, Throwable -> 0x00ae, all -> 0x00b8 }
            int r3 = r0.getResponseCode()     // Catch:{ IOException -> 0x00ba, Throwable -> 0x00ae, all -> 0x00b8 }
            r5 = 206(0xce, float:2.89E-43)
            if (r3 != r5) goto L_0x00b0
            java.io.InputStream r7 = r0.getInputStream()     // Catch:{ IOException -> 0x00ba, Throwable -> 0x00ae, all -> 0x00b8 }
            byte[] r3 = r4.array()     // Catch:{ IOException -> 0x00ba, Throwable -> 0x00ae, all -> 0x00b8 }
        L_0x008d:
            int r4 = r7.read(r3)     // Catch:{ IOException -> 0x00ba, Throwable -> 0x00ae, all -> 0x00b8 }
            if (r4 == r1) goto L_0x0097
            r2.write(r3)     // Catch:{ IOException -> 0x00ba, Throwable -> 0x00ae, all -> 0x00b8 }
            goto L_0x008d
        L_0x0097:
            r7.close()     // Catch:{ IOException -> 0x00ba, Throwable -> 0x00ae, all -> 0x00b8 }
            r0.disconnect()     // Catch:{ IOException -> 0x00ba, Throwable -> 0x00ae, all -> 0x00b8 }
            if (r0 == 0) goto L_0x00a6
            r0.disconnect()     // Catch:{ Exception -> 0x00a4 }
        L_0x00a3:
            goto L_0x00a6
        L_0x00a4:
            r0 = move-exception
            goto L_0x00a3
        L_0x00a6:
            if (r7 == 0) goto L_0x00d1
            r7.close()     // Catch:{ Exception -> 0x00ac }
            goto L_0x00d1
        L_0x00ac:
            r0 = move-exception
            goto L_0x00d1
        L_0x00ae:
            r1 = move-exception
            goto L_0x00c4
        L_0x00b0:
            java.io.IOException r1 = new java.io.IOException     // Catch:{ IOException -> 0x00ba, Throwable -> 0x00ae, all -> 0x00b8 }
            java.lang.String r2 = "Server did not reply with proper range."
            r1.<init>(r2)     // Catch:{ IOException -> 0x00ba, Throwable -> 0x00ae, all -> 0x00b8 }
            throw r1     // Catch:{ IOException -> 0x00ba, Throwable -> 0x00ae, all -> 0x00b8 }
        L_0x00b8:
            r11 = move-exception
            goto L_0x00e6
        L_0x00ba:
            r11 = move-exception
            r10 = r7
            r7 = r0
            r0 = r10
            goto L_0x00e1
        L_0x00bf:
            r11 = move-exception
            r0 = r7
            goto L_0x00e6
        L_0x00c2:
            r0 = move-exception
            r0 = r7
        L_0x00c4:
            if (r0 == 0) goto L_0x00cc
            r0.disconnect()     // Catch:{ Exception -> 0x00ca }
        L_0x00c9:
            goto L_0x00cc
        L_0x00ca:
            r0 = move-exception
            goto L_0x00c9
        L_0x00cc:
            if (r7 == 0) goto L_0x00d1
            r7.close()     // Catch:{ Exception -> 0x00ac }
        L_0x00d1:
            java.lang.String r0 = "StreamingHandler flushing, http serve"
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r0)
            java.io.OutputStream r0 = r11.f15654e
            r0.flush()
            r11.close()
            return
        L_0x00df:
            r11 = move-exception
            r0 = r7
        L_0x00e1:
            throw r11     // Catch:{ all -> 0x00e2 }
        L_0x00e2:
            r11 = move-exception
            r10 = r7
            r7 = r0
            r0 = r10
        L_0x00e6:
            if (r0 == 0) goto L_0x00ee
            r0.disconnect()     // Catch:{ Exception -> 0x00ec }
        L_0x00eb:
            goto L_0x00ee
        L_0x00ec:
            r0 = move-exception
            goto L_0x00eb
        L_0x00ee:
            if (r7 == 0) goto L_0x00f6
            r7.close()     // Catch:{ Exception -> 0x00f4 }
        L_0x00f3:
            goto L_0x00f6
        L_0x00f4:
            r0 = move-exception
            goto L_0x00f3
        L_0x00f6:
            throw r11
        L_0x00f7:
            int r3 = r11.f15656g
            int r4 = r11.f15657h
            r11.m17283a(r3, r4)
            if (r0 != r1) goto L_0x0110
            com.fyber.inneractive.sdk.g.a.a r3 = r11.f15655f
            boolean r4 = r3.f15554c
            if (r4 != 0) goto L_0x0132
            java.io.File r0 = r3.mo24359a()
            long r3 = r0.length()
            int r0 = (int) r3
            goto L_0x0132
        L_0x0110:
            com.fyber.inneractive.sdk.g.a.a r3 = r11.f15655f
            boolean r3 = r3.f15554c
            if (r3 != 0) goto L_0x0132
            int r3 = r11.f15657h
            int r4 = r0 + -1
            if (r3 < r4) goto L_0x0132
            java.lang.Object[] r0 = new java.lang.Object[r6]
            r0[r5] = r11
            java.lang.String r1 = "StreamingHandler[%s] end range exceeds total, dieing"
            java.lang.String r0 = java.lang.String.format(r1, r0)
            com.fyber.inneractive.sdk.util.IAlog.m18019a(r0)
            java.io.OutputStream r0 = r11.f15654e
            r0.flush()
            r11.close()
            return
        L_0x0132:
            int r3 = r11.f15657h
            r11.f15656g = r3
            com.fyber.inneractive.sdk.g.a.a r3 = r11.f15655f
            java.io.File r3 = r3.mo24359a()
            long r3 = r3.length()
            int r4 = (int) r3
            r11.f15657h = r4
        L_0x0143:
            int r3 = r11.f15656g
            int r4 = r11.f15657h
            if (r3 < r4) goto L_0x0174
            com.fyber.inneractive.sdk.g.a.a r3 = r11.f15655f
            java.io.File r3 = r3.mo24359a()
            long r3 = r3.length()
            int r4 = (int) r3
            r11.f15657h = r4
            r3 = 0
            r7 = 10
            java.lang.Thread.sleep(r3, r7)     // Catch:{ Exception -> 0x015e }
            goto L_0x015f
        L_0x015e:
            r3 = move-exception
        L_0x015f:
            int r3 = r11.f15656g
            int r4 = r11.f15657h
            if (r3 != r4) goto L_0x0143
            if (r4 != r2) goto L_0x0143
            java.lang.String r3 = "StreamingHandler flushing, range has reached fSize"
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r3)
            java.io.OutputStream r3 = r11.f15654e
            r3.flush()
            r11.close()
        L_0x0174:
            java.net.Socket r3 = r11.f15651b
            boolean r3 = r3.isConnected()
            if (r3 != 0) goto L_0x00f7
            java.lang.Object[] r0 = new java.lang.Object[r6]
            r0[r5] = r11
            java.lang.String r11 = "StreamingHandler[%s] socket is not connected, dieing"
            java.lang.String r11 = java.lang.String.format(r11, r0)
            com.fyber.inneractive.sdk.util.IAlog.m18019a(r11)
            return
        L_0x018a:
            int r1 = r11.f15656g
            r11.m17283a(r1, r0)
            java.lang.String r0 = "StreamingHandler flushing, vanilla serve"
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r0)
            java.io.OutputStream r0 = r11.f15654e
            r0.flush()
            r11.close()
        L_0x019c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.p166g.p167a.C7785i.m17284a(com.fyber.inneractive.sdk.g.a.i):void");
    }

    C7785i(C7767d dVar, Socket socket) {
        this.f15651b = socket;
        this.f15652c = dVar;
        this.f15650a = dVar.f15607g;
        try {
            this.f15651b.setKeepAlive(false);
        } catch (SocketException e) {
        }
        try {
            this.f15651b.setSoTimeout(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS);
        } catch (SocketException e2) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00eb  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m17285a() throws java.io.IOException {
        /*
            r10 = this;
            java.net.Socket r0 = r10.f15651b
            java.io.InputStream r0 = r0.getInputStream()
            r10.f15653d = r0
            java.io.BufferedOutputStream r0 = new java.io.BufferedOutputStream
            java.net.Socket r1 = r10.f15651b
            java.io.OutputStream r1 = r1.getOutputStream()
            r0.<init>(r1)
            r10.f15654e = r0
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.io.BufferedReader r1 = new java.io.BufferedReader
            java.io.InputStreamReader r2 = new java.io.InputStreamReader
            java.io.InputStream r3 = r10.f15653d
            r2.<init>(r3)
            r1.<init>(r2)
            r2 = 1
            r3 = 1
        L_0x0029:
            r4 = 0
            if (r3 == 0) goto L_0x0056
            java.lang.String r3 = r1.readLine()
            r0.add(r3)
            if (r3 == 0) goto L_0x0046
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "StreamingHandler lineReader - "
            r5.<init>(r6)
            r5.append(r3)
            java.lang.String r5 = r5.toString()
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r5)
        L_0x0046:
            if (r3 == 0) goto L_0x0054
            java.lang.String r3 = r3.trim()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x0054
            r3 = 1
            goto L_0x0055
        L_0x0054:
            r3 = 0
        L_0x0055:
            goto L_0x0029
        L_0x0056:
            int r1 = r0.size()
            if (r1 != r2) goto L_0x0065
            java.lang.Object r1 = r0.get(r4)
            if (r1 != 0) goto L_0x0065
            r1 = 1
            goto L_0x0066
        L_0x0065:
            r1 = 0
        L_0x0066:
            int r3 = r0.size()
            if (r3 <= 0) goto L_0x0093
            java.lang.Object r3 = r0.get(r4)
            java.lang.String r3 = (java.lang.String) r3
            if (r3 != 0) goto L_0x0077
            java.lang.String[] r3 = new java.lang.String[r4]
            goto L_0x0081
        L_0x0077:
            java.lang.String r3 = r3.trim()
            java.lang.String r5 = "\\s+"
            java.lang.String[] r3 = r3.split(r5)
        L_0x0081:
            int r5 = r3.length
            r6 = 3
            if (r5 != r6) goto L_0x0093
            r3 = r3[r2]
            com.fyber.inneractive.sdk.g.a.d r5 = r10.f15652c
            com.fyber.inneractive.sdk.g.a.a r3 = r5.mo24387a(r3)
            if (r3 == 0) goto L_0x0093
            r10.f15655f = r3
            r3 = 1
            goto L_0x0094
        L_0x0093:
            r3 = 0
        L_0x0094:
            int r5 = r0.size()
            if (r5 <= r2) goto L_0x00e9
            com.fyber.inneractive.sdk.g.a.a r5 = r10.f15655f
            if (r5 == 0) goto L_0x00e9
            java.lang.String r5 = "[Rr]{1}ange:{1}\\s*bytes=(\\d*)-"
            java.util.regex.Pattern r5 = java.util.regex.Pattern.compile(r5)
            r6 = 1
        L_0x00a6:
            int r7 = r0.size()
            int r7 = r7 - r2
            if (r6 >= r7) goto L_0x00e9
            java.lang.Object r7 = r0.get(r6)
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            java.util.regex.Matcher r7 = r5.matcher(r7)
            boolean r8 = r7.matches()
            if (r8 == 0) goto L_0x00e6
            java.lang.String r7 = r7.group(r2)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "StreamingHandler Found start range of "
            r8.<init>(r9)
            r8.append(r7)
            java.lang.String r8 = r8.toString()
            com.fyber.inneractive.sdk.util.IAlog.m18019a(r8)
            boolean r8 = android.text.TextUtils.isEmpty(r7)
            if (r8 != 0) goto L_0x00e6
            boolean r8 = android.text.TextUtils.isDigitsOnly(r7)
            if (r8 == 0) goto L_0x00e6
            int r7 = java.lang.Integer.parseInt(r7)
            r10.f15656g = r7
            r10.f15659j = r2
        L_0x00e6:
            int r6 = r6 + 1
            goto L_0x00a6
        L_0x00e9:
            if (r1 != 0) goto L_0x01bf
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            com.fyber.inneractive.sdk.g.a.a r1 = r10.f15655f
            if (r1 == 0) goto L_0x0181
            boolean r1 = r10.f15659j
            if (r1 == 0) goto L_0x00fc
            java.lang.String r1 = "HTTP/1.1 206 PARTIAL CONTENT\n"
            goto L_0x00fe
        L_0x00fc:
            java.lang.String r1 = "HTTP/1.1 200 OK\n"
        L_0x00fe:
            r0.append(r1)
            com.fyber.inneractive.sdk.g.a.a r1 = r10.f15655f
            boolean r5 = r1.f15554c
            if (r5 == 0) goto L_0x010e
            java.lang.String r5 = "http.file.length"
            java.lang.String r1 = r1.mo24360a(r5)
            goto L_0x011a
        L_0x010e:
            java.io.File r1 = r1.mo24359a()
            long r5 = r1.length()
            java.lang.String r1 = java.lang.String.valueOf(r5)
        L_0x011a:
            java.lang.String r5 = "Connection: close\n"
            r0.append(r5)
            java.lang.String r5 = "Accept-Ranges: bytes\n"
            r0.append(r5)
            java.lang.String r5 = "Cache-Control: no-cache, no-store, must-revalidate\n"
            r0.append(r5)
            java.lang.String r5 = "Server: StreamingHandler/1.0\n"
            r0.append(r5)
            if (r1 == 0) goto L_0x016f
            int r5 = java.lang.Integer.parseInt(r1)
            boolean r6 = r10.f15659j
            java.lang.String r7 = "Content-Length: "
            java.lang.String r8 = "\n"
            if (r6 == 0) goto L_0x0166
            r0.append(r7)
            int r6 = r10.f15656g
            int r5 = r5 - r6
            r0.append(r5)
            r0.append(r8)
            java.lang.String r5 = "Content-Range: bytes "
            r0.append(r5)
            int r5 = r10.f15656g
            r0.append(r5)
            java.lang.String r5 = "-"
            r0.append(r5)
            r0.append(r1)
            java.lang.String r5 = "/"
            r0.append(r5)
            r0.append(r1)
            r0.append(r8)
            goto L_0x016f
        L_0x0166:
            r0.append(r7)
            r0.append(r1)
            r0.append(r8)
        L_0x016f:
            java.lang.String r1 = "Content-Type: "
            r0.append(r1)
            com.fyber.inneractive.sdk.g.a.a r1 = r10.f15655f
            java.lang.String r1 = r1.f15555d
            r0.append(r1)
            java.lang.String r1 = "\n\n"
            r0.append(r1)
            goto L_0x0186
        L_0x0181:
            java.lang.String r1 = "HTTP/1.1 404 Not Found\n\nContent-Type: text/html; charset=UTF-8\nContent-Length: 2\n\n{}"
            r0.append(r1)
        L_0x0186:
            com.fyber.inneractive.sdk.g.a.a r1 = r10.f15655f
            if (r1 == 0) goto L_0x0190
            boolean r1 = r1.f15554c
            if (r1 == 0) goto L_0x0190
            r1 = 1
            goto L_0x0191
        L_0x0190:
            r1 = 0
        L_0x0191:
            r10.f15658i = r1
            java.lang.Object[] r1 = new java.lang.Object[r2]
            java.lang.String r2 = r0.toString()
            r1[r4] = r2
            java.lang.String r2 = "StreamingHandler replying with %s"
            java.lang.String r1 = java.lang.String.format(r2, r1)
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "US-ASCII"
            java.nio.charset.Charset r1 = java.nio.charset.Charset.forName(r1)
            byte[] r0 = r0.getBytes(r1)
            java.io.OutputStream r1 = r10.f15654e     // Catch:{ IOException -> 0x01be }
            r1.write(r0)     // Catch:{ IOException -> 0x01be }
            java.io.OutputStream r0 = r10.f15654e     // Catch:{ IOException -> 0x01be }
            r0.flush()     // Catch:{ IOException -> 0x01be }
            goto L_0x01bf
        L_0x01be:
            r0 = move-exception
        L_0x01bf:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.p166g.p167a.C7785i.m17285a():boolean");
    }

    /* renamed from: a */
    private void m17283a(int i, int i2) throws IOException {
        String str;
        IAlog.m18019a(String.format("StreamingHandler serveContent from %d to %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        synchronized (this.f15655f.f15556e) {
            FileInputStream fileInputStream = new FileInputStream(this.f15655f.mo24359a());
            ByteBuffer b = C7996c.m18038a().mo24838b();
            try {
                C7996c.m18038a();
                byte[] b2 = C7996c.m18039b(b);
                if (i > 0) {
                    fileInputStream.skip((long) i);
                }
                int i3 = i2 - i;
                int min = Math.min(b2.length, i3);
                int i4 = i3;
                int i5 = 0;
                do {
                    int read = fileInputStream.read(b2, 0, min);
                    if (read == -1) {
                        break;
                    }
                    this.f15654e.write(b2, 0, read);
                    i5 += read;
                    i4 -= read;
                    min = Math.min(b2.length, i4);
                } while (min != 0);
                IAlog.m18019a(String.format("StreamingHandler wrote %d to socket", new Object[]{Integer.valueOf(i5)}));
                C7996c.m18038a().mo24837a(b);
                C7789k.m17288a((Closeable) fileInputStream);
                str = String.format("StreamingHandler servedContent from %d to %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            } catch (SocketException e) {
                throw e;
            } catch (Throwable th) {
                C7996c.m18038a().mo24837a(b);
                C7789k.m17288a((Closeable) fileInputStream);
                IAlog.m18019a(String.format("StreamingHandler servedContent from %d to %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
                throw th;
            }
            IAlog.m18019a(str);
        }
    }

    public final void close() throws IOException {
        IAlog.m18021b("StreamingHandler closing socket connection");
        C7789k.m17288a((Closeable) this.f15654e);
        C7789k.m17288a((Closeable) this.f15653d);
        C7789k.m17290a(this.f15651b);
        C7767d dVar = this.f15652c;
        if (dVar != null) {
            dVar.f15608h.remove(this);
        }
    }
}
