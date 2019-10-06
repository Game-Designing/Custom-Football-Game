package com.mopub.volley.toolbox;

import com.mopub.volley.AuthFailureError;
import com.mopub.volley.Header;
import com.mopub.volley.Request;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public class HurlStack extends BaseHttpStack {

    /* renamed from: a */
    private final UrlRewriter f36505a;

    /* renamed from: b */
    private final SSLSocketFactory f36506b;

    public interface UrlRewriter {
        String rewriteUrl(String str);
    }

    /* renamed from: com.mopub.volley.toolbox.HurlStack$a */
    static class C11692a extends FilterInputStream {

        /* renamed from: a */
        private final HttpURLConnection f36507a;

        C11692a(HttpURLConnection connection) {
            super(HurlStack.m38646b(connection));
            this.f36507a = connection;
        }

        public void close() throws IOException {
            super.close();
            this.f36507a.disconnect();
        }
    }

    public HurlStack() {
        this(null);
    }

    public HurlStack(UrlRewriter urlRewriter) {
        this(urlRewriter, null);
    }

    public HurlStack(UrlRewriter urlRewriter, SSLSocketFactory sslSocketFactory) {
        this.f36505a = urlRewriter;
        this.f36506b = sslSocketFactory;
    }

    /* JADX INFO: finally extract failed */
    public HttpResponse executeRequest(Request<?> request, Map<String, String> additionalHeaders) throws IOException, AuthFailureError {
        String url = request.getUrl();
        HashMap<String, String> map = new HashMap<>();
        map.putAll(additionalHeaders);
        map.putAll(request.getHeaders());
        UrlRewriter urlRewriter = this.f36505a;
        if (urlRewriter != null) {
            String rewritten = urlRewriter.rewriteUrl(url);
            if (rewritten != null) {
                url = rewritten;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("URL blocked by rewriter: ");
                sb.append(url);
                throw new IOException(sb.toString());
            }
        }
        HttpURLConnection connection = m38641a(new URL(url), request);
        boolean keepConnectionOpen = false;
        try {
            for (String headerName : map.keySet()) {
                connection.setRequestProperty(headerName, (String) map.get(headerName));
            }
            m38643a(connection, request);
            int responseCode = connection.getResponseCode();
            if (responseCode == -1) {
                throw new IOException("Could not retrieve response code from HttpUrlConnection.");
            } else if (!m38645a(request.getMethod(), responseCode)) {
                HttpResponse httpResponse = new HttpResponse(responseCode, m38642a(connection.getHeaderFields()));
                if (0 == 0) {
                    connection.disconnect();
                }
                return httpResponse;
            } else {
                keepConnectionOpen = true;
                HttpResponse httpResponse2 = new HttpResponse(responseCode, m38642a(connection.getHeaderFields()), connection.getContentLength(), new C11692a(connection));
                if (1 == 0) {
                    connection.disconnect();
                }
                return httpResponse2;
            }
        } catch (Throwable th) {
            if (!keepConnectionOpen) {
                connection.disconnect();
            }
            throw th;
        }
    }

    /* renamed from: a */
    static List<Header> m38642a(Map<String, List<String>> responseHeaders) {
        List<Header> headerList = new ArrayList<>(responseHeaders.size());
        for (Entry<String, List<String>> entry : responseHeaders.entrySet()) {
            if (entry.getKey() != null) {
                for (String value : (List) entry.getValue()) {
                    headerList.add(new Header((String) entry.getKey(), value));
                }
            }
        }
        return headerList;
    }

    /* renamed from: a */
    private static boolean m38645a(int requestMethod, int responseCode) {
        return (requestMethod == 4 || (100 <= responseCode && responseCode < 200) || responseCode == 204 || responseCode == 304) ? false : true;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static InputStream m38646b(HttpURLConnection connection) {
        try {
            return connection.getInputStream();
        } catch (IOException e) {
            return connection.getErrorStream();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public HttpURLConnection mo38454a(URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        return connection;
    }

    /* renamed from: a */
    private HttpURLConnection m38641a(URL url, Request<?> request) throws IOException {
        HttpURLConnection connection = mo38454a(url);
        int timeoutMs = request.getTimeoutMs();
        connection.setConnectTimeout(timeoutMs);
        connection.setReadTimeout(timeoutMs);
        connection.setUseCaches(false);
        connection.setDoInput(true);
        if ("https".equals(url.getProtocol())) {
            SSLSocketFactory sSLSocketFactory = this.f36506b;
            if (sSLSocketFactory != null) {
                ((HttpsURLConnection) connection).setSSLSocketFactory(sSLSocketFactory);
            }
        }
        return connection;
    }

    /* renamed from: a */
    static void m38643a(HttpURLConnection connection, Request<?> request) throws IOException, AuthFailureError {
        String str = "POST";
        switch (request.getMethod()) {
            case -1:
                byte[] postBody = request.getPostBody();
                if (postBody != null) {
                    connection.setRequestMethod(str);
                    m38644a(connection, request, postBody);
                    return;
                }
                return;
            case 0:
                connection.setRequestMethod("GET");
                return;
            case 1:
                connection.setRequestMethod(str);
                m38647b(connection, request);
                return;
            case 2:
                connection.setRequestMethod("PUT");
                m38647b(connection, request);
                return;
            case 3:
                connection.setRequestMethod("DELETE");
                return;
            case 4:
                connection.setRequestMethod("HEAD");
                return;
            case 5:
                connection.setRequestMethod("OPTIONS");
                return;
            case 6:
                connection.setRequestMethod("TRACE");
                return;
            case 7:
                connection.setRequestMethod("PATCH");
                m38647b(connection, request);
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    /* renamed from: b */
    private static void m38647b(HttpURLConnection connection, Request<?> request) throws IOException, AuthFailureError {
        byte[] body = request.getBody();
        if (body != null) {
            m38644a(connection, request, body);
        }
    }

    /* renamed from: a */
    private static void m38644a(HttpURLConnection connection, Request<?> request, byte[] body) throws IOException {
        connection.setDoOutput(true);
        String str = "Content-Type";
        if (!connection.getRequestProperties().containsKey(str)) {
            connection.setRequestProperty(str, request.getBodyContentType());
        }
        DataOutputStream out = new DataOutputStream(connection.getOutputStream());
        out.write(body);
        out.close();
    }
}
