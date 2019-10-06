package p024io.fabric.sdk.android.services.network;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.zip.GZIPInputStream;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: io.fabric.sdk.android.services.network.HttpRequest */
public class HttpRequest {

    /* renamed from: a */
    private static final String[] f42316a = new String[0];

    /* renamed from: b */
    private static C13962b f42317b = C13962b.f42330a;

    /* renamed from: c */
    private HttpURLConnection f42318c = null;

    /* renamed from: d */
    public final URL f42319d;

    /* renamed from: e */
    private final String f42320e;

    /* renamed from: f */
    private C13964d f42321f;

    /* renamed from: g */
    private boolean f42322g;

    /* renamed from: h */
    private boolean f42323h = true;

    /* renamed from: i */
    private boolean f42324i = false;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public int f42325j = Opcodes.ACC_ANNOTATION;

    /* renamed from: k */
    private String f42326k;

    /* renamed from: l */
    private int f42327l;

    /* renamed from: io.fabric.sdk.android.services.network.HttpRequest$HttpRequestException */
    public static class HttpRequestException extends RuntimeException {
        protected HttpRequestException(IOException cause) {
            super(cause);
        }

        public IOException getCause() {
            return (IOException) super.getCause();
        }
    }

    /* renamed from: io.fabric.sdk.android.services.network.HttpRequest$a */
    protected static abstract class C13961a<V> extends C13963c<V> {

        /* renamed from: a */
        private final Closeable f42328a;

        /* renamed from: b */
        private final boolean f42329b;

        protected C13961a(Closeable closeable, boolean ignoreCloseExceptions) {
            this.f42328a = closeable;
            this.f42329b = ignoreCloseExceptions;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo43463a() throws IOException {
            Closeable closeable = this.f42328a;
            if (closeable instanceof Flushable) {
                ((Flushable) closeable).flush();
            }
            if (this.f42329b) {
                try {
                    this.f42328a.close();
                } catch (IOException e) {
                }
            } else {
                this.f42328a.close();
            }
        }
    }

    /* renamed from: io.fabric.sdk.android.services.network.HttpRequest$b */
    public interface C13962b {

        /* renamed from: a */
        public static final C13962b f42330a = new C13970f();

        /* renamed from: a */
        HttpURLConnection mo43464a(URL url) throws IOException;

        /* renamed from: a */
        HttpURLConnection mo43465a(URL url, Proxy proxy) throws IOException;
    }

    /* renamed from: io.fabric.sdk.android.services.network.HttpRequest$c */
    protected static abstract class C13963c<V> implements Callable<V> {
        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract void mo43463a() throws IOException;

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public abstract V mo43466b() throws HttpRequestException, IOException;

        protected C13963c() {
        }

        public V call() throws HttpRequestException {
            boolean thrown = false;
            try {
                V b = mo43466b();
                try {
                    mo43463a();
                } catch (IOException e) {
                    if (0 == 0) {
                        throw new HttpRequestException(e);
                    }
                }
                return b;
            } catch (HttpRequestException e2) {
                throw e2;
            } catch (IOException e3) {
                thrown = true;
                throw new HttpRequestException(e3);
            } catch (Throwable th) {
                try {
                    mo43463a();
                } catch (IOException e4) {
                    if (!thrown) {
                        throw new HttpRequestException(e4);
                    }
                }
                throw th;
            }
        }
    }

    /* renamed from: io.fabric.sdk.android.services.network.HttpRequest$d */
    public static class C13964d extends BufferedOutputStream {

        /* renamed from: a */
        private final CharsetEncoder f42331a;

        public C13964d(OutputStream stream, String charset, int bufferSize) {
            super(stream, bufferSize);
            this.f42331a = Charset.forName(HttpRequest.m44378f(charset)).newEncoder();
        }

        /* renamed from: a */
        public C13964d mo43468a(String value) throws IOException {
            ByteBuffer bytes = this.f42331a.encode(CharBuffer.wrap(value));
            super.write(bytes.array(), 0, bytes.limit());
            return this;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public static String m44378f(String charset) {
        if (charset == null || charset.length() <= 0) {
            return "UTF-8";
        }
        return charset;
    }

    /* renamed from: b */
    private static StringBuilder m44374b(String baseUrl, StringBuilder result) {
        if (baseUrl.indexOf(58) + 2 == baseUrl.lastIndexOf(47)) {
            result.append('/');
        }
        return result;
    }

    /* renamed from: a */
    private static StringBuilder m44371a(String baseUrl, StringBuilder result) {
        int queryStart = baseUrl.indexOf(63);
        int lastChar = result.length() - 1;
        if (queryStart == -1) {
            result.append('?');
        } else if (queryStart < lastChar && baseUrl.charAt(lastChar) != '&') {
            result.append('&');
        }
        return result;
    }

    /* renamed from: b */
    public static String m44373b(CharSequence url) throws HttpRequestException {
        try {
            URL parsed = new URL(url.toString());
            String host = parsed.getHost();
            int port = parsed.getPort();
            if (port != -1) {
                StringBuilder sb = new StringBuilder();
                sb.append(host);
                sb.append(':');
                sb.append(Integer.toString(port));
                host = sb.toString();
            }
            try {
                URI uri = new URI(parsed.getProtocol(), host, parsed.getPath(), parsed.getQuery(), parsed.getRef());
                String encoded = uri.toASCIIString();
                int paramsStart = encoded.indexOf(63);
                if (paramsStart <= 0 || paramsStart + 1 >= encoded.length()) {
                    return encoded;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(encoded.substring(0, paramsStart + 1));
                sb2.append(encoded.substring(paramsStart + 1).replace("+", "%2B").replace("#", "%23"));
                return sb2.toString();
            } catch (URISyntaxException e) {
                IOException io = new IOException("Parsing URI failed");
                io.initCause(e);
                throw new HttpRequestException(io);
            }
        } catch (IOException e2) {
            throw new HttpRequestException(e2);
        }
    }

    /* renamed from: a */
    public static String m44369a(CharSequence url, Map<?, ?> params) {
        String baseUrl = url.toString();
        if (params == null || params.isEmpty()) {
            return baseUrl;
        }
        StringBuilder result = new StringBuilder(baseUrl);
        m44374b(baseUrl, result);
        m44371a(baseUrl, result);
        Iterator<?> iterator = params.entrySet().iterator();
        Entry<?, ?> entry = (Entry) iterator.next();
        result.append(entry.getKey().toString());
        result.append('=');
        Object value = entry.getValue();
        if (value != null) {
            result.append(value);
        }
        while (iterator.hasNext()) {
            result.append('&');
            Entry<?, ?> entry2 = (Entry) iterator.next();
            result.append(entry2.getKey().toString());
            result.append('=');
            Object value2 = entry2.getValue();
            if (value2 != null) {
                result.append(value2);
            }
        }
        return result.toString();
    }

    /* renamed from: c */
    public static HttpRequest m44375c(CharSequence url) throws HttpRequestException {
        return new HttpRequest(url, "GET");
    }

    /* renamed from: a */
    public static HttpRequest m44368a(CharSequence baseUrl, Map<?, ?> params, boolean encode) {
        String url = m44369a(baseUrl, params);
        return m44375c((CharSequence) encode ? m44373b((CharSequence) url) : url);
    }

    /* renamed from: d */
    public static HttpRequest m44376d(CharSequence url) throws HttpRequestException {
        return new HttpRequest(url, "POST");
    }

    /* renamed from: b */
    public static HttpRequest m44372b(CharSequence baseUrl, Map<?, ?> params, boolean encode) {
        String url = m44369a(baseUrl, params);
        return m44376d((CharSequence) encode ? m44373b((CharSequence) url) : url);
    }

    /* renamed from: e */
    public static HttpRequest m44377e(CharSequence url) throws HttpRequestException {
        return new HttpRequest(url, "PUT");
    }

    /* renamed from: a */
    public static HttpRequest m44367a(CharSequence url) throws HttpRequestException {
        return new HttpRequest(url, "DELETE");
    }

    public HttpRequest(CharSequence url, String method) throws HttpRequestException {
        try {
            this.f42319d = new URL(url.toString());
            this.f42320e = method;
        } catch (MalformedURLException e) {
            throw new HttpRequestException(e);
        }
    }

    /* renamed from: q */
    private Proxy m44380q() {
        return new Proxy(Type.HTTP, new InetSocketAddress(this.f42326k, this.f42327l));
    }

    /* renamed from: p */
    private HttpURLConnection m44379p() {
        HttpURLConnection connection;
        try {
            if (this.f42326k != null) {
                connection = f42317b.mo43465a(this.f42319d, m44380q());
            } else {
                connection = f42317b.mo43464a(this.f42319d);
            }
            connection.setRequestMethod(this.f42320e);
            return connection;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(mo43456k());
        sb.append(' ');
        sb.append(mo43460o());
        return sb.toString();
    }

    /* renamed from: j */
    public HttpURLConnection mo43455j() {
        if (this.f42318c == null) {
            this.f42318c = m44379p();
        }
        return this.f42318c;
    }

    /* renamed from: g */
    public int mo43452g() throws HttpRequestException {
        try {
            mo43447e();
            return mo43455j().getResponseCode();
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public ByteArrayOutputStream mo43442c() {
        int size = mo43454i();
        if (size > 0) {
            return new ByteArrayOutputStream(size);
        }
        return new ByteArrayOutputStream();
    }

    /* renamed from: b */
    public String mo43438b(String charset) throws HttpRequestException {
        ByteArrayOutputStream output = mo43442c();
        try {
            mo43425a((InputStream) mo43437b(), (OutputStream) output);
            return output.toString(m44378f(charset));
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    /* renamed from: a */
    public String mo43435a() throws HttpRequestException {
        return mo43438b(mo43443d());
    }

    /* renamed from: b */
    public BufferedInputStream mo43437b() throws HttpRequestException {
        return new BufferedInputStream(mo43459n(), this.f42325j);
    }

    /* renamed from: n */
    public InputStream mo43459n() throws HttpRequestException {
        InputStream stream;
        if (mo43452g() < 400) {
            try {
                stream = mo43455j().getInputStream();
            } catch (IOException e) {
                throw new HttpRequestException(e);
            }
        } else {
            stream = mo43455j().getErrorStream();
            if (stream == null) {
                try {
                    stream = mo43455j().getInputStream();
                } catch (IOException e2) {
                    throw new HttpRequestException(e2);
                }
            }
        }
        if (this.f42324i) {
            if ("gzip".equals(mo43453h())) {
                try {
                    return new GZIPInputStream(stream);
                } catch (IOException e3) {
                    throw new HttpRequestException(e3);
                }
            }
        }
        return stream;
    }

    /* renamed from: a */
    public HttpRequest mo43424a(int timeout) {
        mo43455j().setConnectTimeout(timeout);
        return this;
    }

    /* renamed from: c */
    public HttpRequest mo43441c(String name, String value) {
        mo43455j().setRequestProperty(name, value);
        return this;
    }

    /* renamed from: a */
    public HttpRequest mo43433a(Entry<String, String> header) {
        mo43441c((String) header.getKey(), (String) header.getValue());
        return this;
    }

    /* renamed from: d */
    public String mo43444d(String name) throws HttpRequestException {
        mo43449f();
        return mo43455j().getHeaderField(name);
    }

    /* renamed from: e */
    public int mo43446e(String name) throws HttpRequestException {
        return mo43423a(name, -1);
    }

    /* renamed from: a */
    public int mo43423a(String name, int defaultValue) throws HttpRequestException {
        mo43449f();
        return mo43455j().getHeaderFieldInt(name, defaultValue);
    }

    /* renamed from: d */
    public String mo43445d(String headerName, String paramName) {
        return mo43439b(mo43444d(headerName), paramName);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public String mo43439b(String value, String paramName) {
        int end;
        if (value == null || value.length() == 0) {
            return null;
        }
        int length = value.length();
        int start = value.indexOf(59) + 1;
        if (start == 0 || start == length) {
            return null;
        }
        int end2 = value.indexOf(59, start);
        if (end2 == -1) {
            end2 = length;
        }
        while (start < end) {
            int nameEnd = value.indexOf(61, start);
            if (nameEnd != -1 && nameEnd < end && paramName.equals(value.substring(start, nameEnd).trim())) {
                String paramValue = value.substring(nameEnd + 1, end).trim();
                int valueLength = paramValue.length();
                if (valueLength != 0) {
                    if (valueLength > 2 && '\"' == paramValue.charAt(0) && '\"' == paramValue.charAt(valueLength - 1)) {
                        return paramValue.substring(1, valueLength - 1);
                    }
                    return paramValue;
                }
            }
            start = end + 1;
            end = value.indexOf(59, start);
            if (end == -1) {
                end = length;
            }
        }
        return null;
    }

    /* renamed from: d */
    public String mo43443d() {
        return mo43445d("Content-Type", "charset");
    }

    /* renamed from: a */
    public HttpRequest mo43434a(boolean useCaches) {
        mo43455j().setUseCaches(useCaches);
        return this;
    }

    /* renamed from: h */
    public String mo43453h() {
        return mo43444d("Content-Encoding");
    }

    /* renamed from: c */
    public HttpRequest mo43440c(String contentType) {
        mo43427a(contentType, (String) null);
        return this;
    }

    /* renamed from: a */
    public HttpRequest mo43427a(String contentType, String charset) {
        String str = "Content-Type";
        if (charset == null || charset.length() <= 0) {
            mo43441c(str, contentType);
            return this;
        }
        String str2 = "; charset=";
        StringBuilder sb = new StringBuilder();
        sb.append(contentType);
        sb.append("; charset=");
        sb.append(charset);
        mo43441c(str, sb.toString());
        return this;
    }

    /* renamed from: i */
    public int mo43454i() {
        return mo43446e("Content-Length");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public HttpRequest mo43425a(InputStream input, OutputStream output) throws IOException {
        C13969e eVar = new C13969e(this, input, this.f42323h, input, output);
        return (HttpRequest) eVar.call();
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public HttpRequest mo43447e() throws IOException {
        C13964d dVar = this.f42321f;
        if (dVar == null) {
            return this;
        }
        if (this.f42322g) {
            dVar.mo43468a("\r\n--00content0boundary00--\r\n");
        }
        if (this.f42323h) {
            try {
                this.f42321f.close();
            } catch (IOException e) {
            }
        } else {
            this.f42321f.close();
        }
        this.f42321f = null;
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public HttpRequest mo43449f() throws HttpRequestException {
        try {
            mo43447e();
            return this;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public HttpRequest mo43457l() throws IOException {
        if (this.f42321f != null) {
            return this;
        }
        mo43455j().setDoOutput(true);
        this.f42321f = new C13964d(mo43455j().getOutputStream(), mo43439b(mo43455j().getRequestProperty("Content-Type"), "charset"), this.f42325j);
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public HttpRequest mo43458m() throws IOException {
        if (!this.f42322g) {
            this.f42322g = true;
            mo43440c("multipart/form-data; boundary=00content0boundary00");
            mo43457l();
            this.f42321f.mo43468a("--00content0boundary00\r\n");
        } else {
            this.f42321f.mo43468a("\r\n--00content0boundary00\r\n");
        }
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public HttpRequest mo43436b(String name, String filename, String contentType) throws IOException {
        StringBuilder partBuffer = new StringBuilder();
        partBuffer.append("form-data; name=\"");
        partBuffer.append(name);
        if (filename != null) {
            partBuffer.append("\"; filename=\"");
            partBuffer.append(filename);
        }
        partBuffer.append('\"');
        mo43451f("Content-Disposition", partBuffer.toString());
        if (contentType != null) {
            mo43451f("Content-Type", contentType);
        }
        mo43450f((CharSequence) "\r\n");
        return this;
    }

    /* renamed from: e */
    public HttpRequest mo43448e(String name, String part) {
        mo43429a(name, (String) null, part);
        return this;
    }

    /* renamed from: a */
    public HttpRequest mo43429a(String name, String filename, String part) throws HttpRequestException {
        mo43432a(name, filename, (String) null, part);
        return this;
    }

    /* renamed from: a */
    public HttpRequest mo43432a(String name, String filename, String contentType, String part) throws HttpRequestException {
        try {
            mo43458m();
            mo43436b(name, filename, contentType);
            this.f42321f.mo43468a(part);
            return this;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    /* renamed from: a */
    public HttpRequest mo43426a(String name, Number part) throws HttpRequestException {
        mo43428a(name, (String) null, part);
        return this;
    }

    /* renamed from: a */
    public HttpRequest mo43428a(String name, String filename, Number part) throws HttpRequestException {
        mo43429a(name, filename, part != null ? part.toString() : null);
        return this;
    }

    /* renamed from: a */
    public HttpRequest mo43430a(String name, String filename, String contentType, File part) throws HttpRequestException {
        BufferedInputStream bufferedInputStream = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(part));
            mo43431a(name, filename, contentType, (InputStream) bufferedInputStream);
            try {
                bufferedInputStream.close();
            } catch (IOException e) {
            }
            return this;
        } catch (IOException e2) {
            throw new HttpRequestException(e2);
        } catch (Throwable th) {
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e3) {
                }
            }
            throw th;
        }
    }

    /* renamed from: a */
    public HttpRequest mo43431a(String name, String filename, String contentType, InputStream part) throws HttpRequestException {
        try {
            mo43458m();
            mo43436b(name, filename, contentType);
            mo43425a(part, (OutputStream) this.f42321f);
            return this;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    /* renamed from: f */
    public HttpRequest mo43451f(String name, String value) throws HttpRequestException {
        mo43450f((CharSequence) name);
        mo43450f((CharSequence) ": ");
        mo43450f((CharSequence) value);
        mo43450f((CharSequence) "\r\n");
        return this;
    }

    /* renamed from: f */
    public HttpRequest mo43450f(CharSequence value) throws HttpRequestException {
        try {
            mo43457l();
            this.f42321f.mo43468a(value.toString());
            return this;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    /* renamed from: o */
    public URL mo43460o() {
        return mo43455j().getURL();
    }

    /* renamed from: k */
    public String mo43456k() {
        return mo43455j().getRequestMethod();
    }
}
