package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.upstream.HttpDataSource.C8453a;
import com.google.android.exoplayer2.upstream.HttpDataSource.HttpDataSourceException;
import com.google.android.exoplayer2.upstream.HttpDataSource.InvalidContentTypeException;
import com.google.android.exoplayer2.upstream.HttpDataSource.InvalidResponseCodeException;
import com.google.android.exoplayer2.util.C8509F;
import com.google.android.exoplayer2.util.C8514e;
import com.google.android.exoplayer2.util.C8526n;
import com.google.android.exoplayer2.util.C8537v;
import com.mopub.common.Constants;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.google.android.exoplayer2.upstream.n */
/* compiled from: DefaultHttpDataSource */
public class C8494n extends C8484f implements HttpDataSource {

    /* renamed from: e */
    private static final Pattern f18751e = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");

    /* renamed from: f */
    private static final AtomicReference<byte[]> f18752f = new AtomicReference<>();

    /* renamed from: g */
    private final boolean f18753g;

    /* renamed from: h */
    private final int f18754h;

    /* renamed from: i */
    private final int f18755i;

    /* renamed from: j */
    private final String f18756j;

    /* renamed from: k */
    private final C8537v<String> f18757k;

    /* renamed from: l */
    private final C8453a f18758l;

    /* renamed from: m */
    private final C8453a f18759m;

    /* renamed from: n */
    private C8489j f18760n;

    /* renamed from: o */
    private HttpURLConnection f18761o;

    /* renamed from: p */
    private InputStream f18762p;

    /* renamed from: q */
    private boolean f18763q;

    /* renamed from: r */
    private long f18764r;

    /* renamed from: s */
    private long f18765s;

    /* renamed from: t */
    private long f18766t;

    /* renamed from: u */
    private long f18767u;

    public C8494n(String userAgent, C8537v<String> contentTypePredicate) {
        this(userAgent, contentTypePredicate, 8000, 8000);
    }

    public C8494n(String userAgent, C8537v<String> contentTypePredicate, int connectTimeoutMillis, int readTimeoutMillis) {
        this(userAgent, contentTypePredicate, connectTimeoutMillis, readTimeoutMillis, false, null);
    }

    public C8494n(String userAgent, C8537v<String> contentTypePredicate, int connectTimeoutMillis, int readTimeoutMillis, boolean allowCrossProtocolRedirects, C8453a defaultRequestProperties) {
        super(true);
        C8514e.m20487a(userAgent);
        this.f18756j = userAgent;
        this.f18757k = contentTypePredicate;
        this.f18759m = new C8453a();
        this.f18754h = connectTimeoutMillis;
        this.f18755i = readTimeoutMillis;
        this.f18753g = allowCrossProtocolRedirects;
        this.f18758l = defaultRequestProperties;
    }

    public Uri getUri() {
        HttpURLConnection httpURLConnection = this.f18761o;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    /* renamed from: a */
    public Map<String, List<String>> mo25954a() {
        HttpURLConnection httpURLConnection = this.f18761o;
        return httpURLConnection == null ? Collections.emptyMap() : httpURLConnection.getHeaderFields();
    }

    /* renamed from: a */
    public long mo25917a(C8489j dataSpec) throws HttpDataSourceException {
        String str = "Unable to connect to ";
        this.f18760n = dataSpec;
        long j = 0;
        this.f18767u = 0;
        this.f18766t = 0;
        mo26014b(dataSpec);
        try {
            this.f18761o = m20365d(dataSpec);
            try {
                int responseCode = this.f18761o.getResponseCode();
                String responseMessage = this.f18761o.getResponseMessage();
                if (responseCode < 200 || responseCode > 299) {
                    Map<String, List<String>> headers = this.f18761o.getHeaderFields();
                    m20366d();
                    InvalidResponseCodeException exception = new InvalidResponseCodeException(responseCode, responseMessage, headers, dataSpec);
                    if (responseCode == 416) {
                        exception.initCause(new DataSourceException(0));
                    }
                    throw exception;
                }
                String contentType = this.f18761o.getContentType();
                C8537v<String> vVar = this.f18757k;
                if (vVar == null || vVar.evaluate(contentType)) {
                    if (responseCode == 200) {
                        long j2 = dataSpec.f18719f;
                        if (j2 != 0) {
                            j = j2;
                        }
                    }
                    this.f18764r = j;
                    if (!dataSpec.mo26019b(1)) {
                        long j3 = dataSpec.f18720g;
                        long j4 = -1;
                        if (j3 != -1) {
                            this.f18765s = j3;
                        } else {
                            long contentLength = m20361a(this.f18761o);
                            if (contentLength != -1) {
                                j4 = contentLength - this.f18764r;
                            }
                            this.f18765s = j4;
                        }
                    } else {
                        this.f18765s = dataSpec.f18720g;
                    }
                    try {
                        this.f18762p = this.f18761o.getInputStream();
                        this.f18763q = true;
                        mo26015c(dataSpec);
                        return this.f18765s;
                    } catch (IOException e) {
                        m20366d();
                        throw new HttpDataSourceException(e, dataSpec, 1);
                    }
                } else {
                    m20366d();
                    throw new InvalidContentTypeException(contentType, dataSpec);
                }
            } catch (IOException e2) {
                m20366d();
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(dataSpec.f18714a.toString());
                throw new HttpDataSourceException(sb.toString(), e2, dataSpec, 1);
            }
        } catch (IOException e3) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(dataSpec.f18714a.toString());
            throw new HttpDataSourceException(sb2.toString(), e3, dataSpec, 1);
        }
    }

    public int read(byte[] buffer, int offset, int readLength) throws HttpDataSourceException {
        try {
            m20367e();
            return m20360a(buffer, offset, readLength);
        } catch (IOException e) {
            throw new HttpDataSourceException(e, this.f18760n, 2);
        }
    }

    public void close() throws HttpDataSourceException {
        try {
            if (this.f18762p != null) {
                m20364a(this.f18761o, mo26030c());
                this.f18762p.close();
            }
            this.f18762p = null;
            m20366d();
            if (this.f18763q) {
                this.f18763q = false;
                mo26013b();
            }
        } catch (IOException e) {
            throw new HttpDataSourceException(e, this.f18760n, 3);
        } catch (Throwable th) {
            this.f18762p = null;
            m20366d();
            if (this.f18763q) {
                this.f18763q = false;
                mo26013b();
            }
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final long mo26030c() {
        long j = this.f18765s;
        return j == -1 ? j : j - this.f18767u;
    }

    /* renamed from: d */
    private HttpURLConnection m20365d(C8489j dataSpec) throws IOException {
        HttpURLConnection connection;
        C8489j jVar = dataSpec;
        URL url = new URL(jVar.f18714a.toString());
        int httpMethod = jVar.f18715b;
        byte[] httpBody = jVar.f18716c;
        long position = jVar.f18719f;
        long length = jVar.f18720g;
        boolean allowGzip = jVar.mo26019b(1);
        if (!this.f18753g) {
            long j = length;
            return m20362a(url, httpMethod, httpBody, position, length, allowGzip, true);
        }
        long length2 = length;
        int redirectCount = 0;
        while (true) {
            int redirectCount2 = redirectCount + 1;
            if (redirectCount <= 20) {
                long position2 = position;
                connection = m20362a(url, httpMethod, httpBody, position2, length2, allowGzip, false);
                int responseCode = connection.getResponseCode();
                String location = connection.getHeaderField("Location");
                if ((httpMethod == 1 || httpMethod == 3) && (responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303 || responseCode == 307 || responseCode == 308)) {
                    connection.disconnect();
                    url = m20363a(url, location);
                } else if (httpMethod != 2 || (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303)) {
                    return connection;
                } else {
                    connection.disconnect();
                    url = m20363a(url, location);
                    httpMethod = 1;
                    httpBody = null;
                }
                redirectCount = redirectCount2;
                position = position2;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Too many redirects: ");
                sb.append(redirectCount2);
                throw new NoRouteToHostException(sb.toString());
            }
        }
        return connection;
    }

    /* renamed from: a */
    private HttpURLConnection m20362a(URL url, int httpMethod, byte[] httpBody, long position, long length, boolean allowGzip, boolean followRedirects) throws IOException {
        byte[] bArr = httpBody;
        long j = position;
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setConnectTimeout(this.f18754h);
        connection.setReadTimeout(this.f18755i);
        C8453a aVar = this.f18758l;
        if (aVar != null) {
            for (Entry<String, String> property : aVar.mo25921a().entrySet()) {
                connection.setRequestProperty((String) property.getKey(), (String) property.getValue());
            }
        }
        for (Entry<String, String> property2 : this.f18759m.mo25921a().entrySet()) {
            connection.setRequestProperty((String) property2.getKey(), (String) property2.getValue());
        }
        if (!(j == 0 && length == -1)) {
            StringBuilder sb = new StringBuilder();
            sb.append("bytes=");
            sb.append(j);
            sb.append("-");
            String rangeRequest = sb.toString();
            if (length != -1) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(rangeRequest);
                sb2.append((j + length) - 1);
                rangeRequest = sb2.toString();
            }
            connection.setRequestProperty("Range", rangeRequest);
        }
        connection.setRequestProperty("User-Agent", this.f18756j);
        if (!allowGzip) {
            connection.setRequestProperty("Accept-Encoding", "identity");
        }
        connection.setInstanceFollowRedirects(followRedirects);
        connection.setDoOutput(bArr != null);
        connection.setRequestMethod(C8489j.m20335a(httpMethod));
        if (bArr != null) {
            connection.setFixedLengthStreamingMode(bArr.length);
            connection.connect();
            OutputStream os = connection.getOutputStream();
            os.write(httpBody);
            os.close();
        } else {
            connection.connect();
        }
        return connection;
    }

    /* renamed from: a */
    private static URL m20363a(URL originalUrl, String location) throws IOException {
        if (location != null) {
            URL url = new URL(originalUrl, location);
            String protocol = url.getProtocol();
            if ("https".equals(protocol) || Constants.HTTP.equals(protocol)) {
                return url;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Unsupported protocol redirect: ");
            sb.append(protocol);
            throw new ProtocolException(sb.toString());
        }
        throw new ProtocolException("Null location redirect");
    }

    /* renamed from: a */
    private static long m20361a(HttpURLConnection connection) {
        long contentLength = -1;
        String contentLengthHeader = connection.getHeaderField("Content-Length");
        String str = "]";
        String str2 = "DefaultHttpDataSource";
        if (!TextUtils.isEmpty(contentLengthHeader)) {
            try {
                contentLength = Long.parseLong(contentLengthHeader);
            } catch (NumberFormatException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unexpected Content-Length [");
                sb.append(contentLengthHeader);
                sb.append(str);
                C8526n.m20531b(str2, sb.toString());
            }
        }
        String contentRangeHeader = connection.getHeaderField("Content-Range");
        if (TextUtils.isEmpty(contentRangeHeader)) {
            return contentLength;
        }
        Matcher matcher = f18751e.matcher(contentRangeHeader);
        if (!matcher.find()) {
            return contentLength;
        }
        try {
            long contentLengthFromRange = (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
            if (contentLength < 0) {
                return contentLengthFromRange;
            }
            if (contentLength == contentLengthFromRange) {
                return contentLength;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Inconsistent headers [");
            sb2.append(contentLengthHeader);
            sb2.append("] [");
            sb2.append(contentRangeHeader);
            sb2.append(str);
            C8526n.m20534d(str2, sb2.toString());
            return Math.max(contentLength, contentLengthFromRange);
        } catch (NumberFormatException e2) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Unexpected Content-Range [");
            sb3.append(contentRangeHeader);
            sb3.append(str);
            C8526n.m20531b(str2, sb3.toString());
            return contentLength;
        }
    }

    /* renamed from: e */
    private void m20367e() throws IOException {
        if (this.f18766t != this.f18764r) {
            byte[] skipBuffer = (byte[]) f18752f.getAndSet(null);
            if (skipBuffer == null) {
                skipBuffer = new byte[Opcodes.ACC_SYNTHETIC];
            }
            while (true) {
                long j = this.f18766t;
                long j2 = this.f18764r;
                if (j != j2) {
                    int read = this.f18762p.read(skipBuffer, 0, (int) Math.min(j2 - j, (long) skipBuffer.length));
                    if (Thread.currentThread().isInterrupted()) {
                        throw new InterruptedIOException();
                    } else if (read != -1) {
                        this.f18766t += (long) read;
                        mo26012a(read);
                    } else {
                        throw new EOFException();
                    }
                } else {
                    f18752f.set(skipBuffer);
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    private int m20360a(byte[] buffer, int offset, int readLength) throws IOException {
        if (readLength == 0) {
            return 0;
        }
        long j = this.f18765s;
        if (j != -1) {
            long bytesRemaining = j - this.f18767u;
            if (bytesRemaining == 0) {
                return -1;
            }
            readLength = (int) Math.min((long) readLength, bytesRemaining);
        }
        int read = this.f18762p.read(buffer, offset, readLength);
        if (read != -1) {
            this.f18767u += (long) read;
            mo26012a(read);
            return read;
        } else if (this.f18765s == -1) {
            return -1;
        } else {
            throw new EOFException();
        }
    }

    /* renamed from: a */
    private static void m20364a(HttpURLConnection connection, long bytesRemaining) {
        int i = C8509F.f18793a;
        if (i == 19 || i == 20) {
            try {
                InputStream inputStream = connection.getInputStream();
                if (bytesRemaining == -1) {
                    if (inputStream.read() == -1) {
                        return;
                    }
                } else if (bytesRemaining <= 2048) {
                    return;
                }
                String className = inputStream.getClass().getName();
                if ("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream".equals(className) || "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream".equals(className)) {
                    Method unexpectedEndOfInput = inputStream.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                    unexpectedEndOfInput.setAccessible(true);
                    unexpectedEndOfInput.invoke(inputStream, new Object[0]);
                }
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: d */
    private void m20366d() {
        HttpURLConnection httpURLConnection = this.f18761o;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                C8526n.m20530a("DefaultHttpDataSource", "Unexpected error while disconnecting", e);
            }
            this.f18761o = null;
        }
    }
}
