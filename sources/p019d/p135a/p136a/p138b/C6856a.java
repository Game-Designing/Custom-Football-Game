package p019d.p135a.p136a.p138b;

import com.adyen.core.exceptions.HttpAuthenticationException;
import com.adyen.core.exceptions.HttpAuthorizationException;
import com.adyen.core.exceptions.HttpDownForMaintenanceException;
import com.adyen.core.exceptions.HttpServerException;
import com.adyen.core.exceptions.UnexpectedException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSocketFactory;
import p019d.p135a.p136a.p138b.C6856a;
import p019d.p135a.p136a.p142e.C6913k;

/* renamed from: d.a.a.b.a */
/* compiled from: HttpClient */
public class C6856a<T extends C6856a> {

    /* renamed from: a */
    private SSLSocketFactory f12561a;

    /* renamed from: b */
    private int f12562b = ((int) TimeUnit.SECONDS.toMillis(60));

    /* renamed from: c */
    private int f12563c = ((int) TimeUnit.SECONDS.toMillis(60));

    public C6856a() {
        try {
            this.f12561a = new C6876u();
        } catch (KeyManagementException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            this.f12561a = null;
        }
    }

    /* renamed from: a */
    public byte[] mo22288a(String url, Map<String, String> headers, String data) throws Exception {
        HttpURLConnection connection = null;
        try {
            connection = m13936b(url, headers);
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            m13934a(connection.getOutputStream(), data);
            return m13935a(connection);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    /* renamed from: a */
    public byte[] mo22287a(String url, Map<String, String> headers) throws Exception {
        HttpURLConnection connection = null;
        try {
            connection = m13936b(url, headers);
            connection.setRequestMethod("GET");
            return m13935a(connection);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    /* renamed from: b */
    private HttpURLConnection m13936b(String url, Map<String, String> headers) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        if (connection instanceof HttpsURLConnection) {
            SSLSocketFactory sSLSocketFactory = this.f12561a;
            if (sSLSocketFactory != null) {
                ((HttpsURLConnection) connection).setSSLSocketFactory(sSLSocketFactory);
            } else {
                throw new SSLException("SSLSocketFactory failed to initialize");
            }
        }
        connection.setConnectTimeout(this.f12562b);
        connection.setReadTimeout(this.f12563c);
        if (headers != null && headers.size() > 0) {
            for (Entry<String, String> entry : headers.entrySet()) {
                connection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
        }
        return connection;
    }

    /* renamed from: a */
    private void m13934a(OutputStream outputStream, String data) throws IOException {
        outputStream.write(data.getBytes(Charset.forName("UTF-8")));
        outputStream.flush();
        outputStream.close();
    }

    /* renamed from: a */
    private byte[] m13935a(HttpURLConnection connection) throws Exception {
        int responseCode = connection.getResponseCode();
        if (responseCode == 401) {
            throw new HttpAuthenticationException(m13933a(connection.getErrorStream()));
        } else if (responseCode == 403) {
            throw new HttpAuthorizationException(m13933a(connection.getErrorStream()));
        } else if (responseCode == 500) {
            throw new HttpServerException(m13933a(connection.getErrorStream()));
        } else if (responseCode != 503) {
            switch (responseCode) {
                case 200:
                case 201:
                case 202:
                    return C6913k.m14063a(connection.getInputStream());
                default:
                    throw new UnexpectedException(m13933a(connection.getErrorStream()));
            }
        } else {
            throw new HttpDownForMaintenanceException(m13933a(connection.getErrorStream()));
        }
    }

    /* renamed from: a */
    private String m13933a(InputStream in) throws IOException {
        StringBuilder responseBuilder = new StringBuilder();
        BufferedReader connectionInputStream = new BufferedReader(new InputStreamReader(in, Charset.forName("UTF-8")));
        while (true) {
            String readLine = connectionInputStream.readLine();
            String inputLine = readLine;
            if (readLine != null) {
                responseBuilder.append(inputLine);
            } else {
                connectionInputStream.close();
                return responseBuilder.toString();
            }
        }
    }
}
