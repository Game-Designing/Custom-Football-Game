package com.unity3d.services.core.request;

import com.unity3d.services.core.log.DeviceLog;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

public class WebRequest {
    private String _body;
    private boolean _canceled;
    private int _connectTimeout;
    private long _contentLength;
    private Map<String, List<String>> _headers;
    private IWebRequestProgressListener _progressListener;
    private int _readTimeout;
    private String _requestType;
    private int _responseCode;
    private Map<String, List<String>> _responseHeaders;
    private URL _url;

    public enum RequestType {
        POST,
        GET,
        HEAD
    }

    public WebRequest(String url, String requestType, Map<String, List<String>> headers) throws MalformedURLException {
        this(url, requestType, headers, 30000, 30000);
    }

    public WebRequest(String url, String requestType, Map<String, List<String>> headers, int connectTimeout, int readTimeout) throws MalformedURLException {
        this._requestType = RequestType.GET.name();
        this._responseCode = -1;
        this._contentLength = -1;
        this._canceled = false;
        this._url = new URL(url);
        this._requestType = requestType;
        this._headers = headers;
        this._connectTimeout = connectTimeout;
        this._readTimeout = readTimeout;
    }

    public void cancel() {
        this._canceled = true;
    }

    public boolean isCanceled() {
        return this._canceled;
    }

    public URL getUrl() {
        return this._url;
    }

    public String getRequestType() {
        return this._requestType;
    }

    public String getBody() {
        return this._body;
    }

    public void setBody(String body) {
        this._body = body;
    }

    public String getQuery() {
        URL url = this._url;
        if (url != null) {
            return url.getQuery();
        }
        return null;
    }

    public Map<String, List<String>> getResponseHeaders() {
        return this._responseHeaders;
    }

    public Map<String, List<String>> getHeaders() {
        return this._headers;
    }

    public int getResponseCode() {
        return this._responseCode;
    }

    public long getContentLength() {
        return this._contentLength;
    }

    public int getConnectTimeout() {
        return this._connectTimeout;
    }

    public void setConnectTimeout(int timeout) {
        this._connectTimeout = timeout;
    }

    public int getReadTimeout() {
        return this._readTimeout;
    }

    public void setReadTimeout(int readTimeout) {
        this._readTimeout = readTimeout;
    }

    public void setProgressListener(IWebRequestProgressListener listener) {
        this._progressListener = listener;
    }

    public long makeStreamRequest(OutputStream outputStream) throws NetworkIOException, IOException, IllegalStateException {
        InputStream input;
        String str = "Error closing writer";
        HttpURLConnection connection = getHttpUrlConnectionWithHeaders();
        connection.setDoInput(true);
        if (getRequestType().equals(RequestType.POST.name())) {
            connection.setDoOutput(true);
            PrintWriter pout = null;
            try {
                PrintWriter pout2 = new PrintWriter(new OutputStreamWriter(connection.getOutputStream(), "UTF-8"), true);
                if (getBody() == null) {
                    pout2.print(getQuery());
                } else {
                    pout2.print(getBody());
                }
                pout2.flush();
                try {
                    pout2.close();
                } catch (Exception e) {
                    Exception e2 = e;
                    DeviceLog.exception(str, e2);
                    throw e2;
                }
            } catch (IOException e3) {
                DeviceLog.exception("Error while writing POST params", e3);
                StringBuilder sb = new StringBuilder();
                sb.append("Error writing POST params: ");
                sb.append(e3.getMessage());
                throw new NetworkIOException(sb.toString());
            } catch (Throwable e4) {
                if (pout != null) {
                    try {
                        pout.close();
                    } catch (Exception e5) {
                        Exception e6 = e5;
                        DeviceLog.exception(str, e6);
                        throw e6;
                    }
                }
                throw e4;
            }
        }
        try {
            this._responseCode = connection.getResponseCode();
            this._contentLength = (long) connection.getContentLength();
            if (connection.getHeaderFields() != null) {
                this._responseHeaders = connection.getHeaderFields();
            }
            try {
                input = connection.getInputStream();
            } catch (IOException e7) {
                IOException e8 = e7;
                input = connection.getErrorStream();
                if (input == null) {
                    OutputStream outputStream2 = outputStream;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Can't open error stream: ");
                    sb2.append(e8.getMessage());
                    throw new NetworkIOException(sb2.toString());
                }
            }
            IWebRequestProgressListener iWebRequestProgressListener = this._progressListener;
            if (iWebRequestProgressListener != null) {
                iWebRequestProgressListener.onRequestStart(getUrl().toString(), this._contentLength, this._responseCode, this._responseHeaders);
            }
            BufferedInputStream binput = new BufferedInputStream(input);
            byte[] readTarget = new byte[Opcodes.ACC_SYNTHETIC];
            long total = 0;
            int bytesRead = 0;
            while (isCanceled() == 0 && bytesRead != -1) {
                try {
                    bytesRead = binput.read(readTarget);
                    if (bytesRead > 0) {
                        outputStream.write(readTarget, 0, bytesRead);
                        total += (long) bytesRead;
                        IWebRequestProgressListener iWebRequestProgressListener2 = this._progressListener;
                        if (iWebRequestProgressListener2 != null) {
                            iWebRequestProgressListener2.onRequestProgress(getUrl().toString(), total, this._contentLength);
                        }
                    } else {
                        OutputStream outputStream3 = outputStream;
                    }
                } catch (IOException e9) {
                    OutputStream outputStream4 = outputStream;
                    IOException e10 = e9;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Network exception: ");
                    sb3.append(e10.getMessage());
                    throw new NetworkIOException(sb3.toString());
                }
            }
            OutputStream outputStream5 = outputStream;
            connection.disconnect();
            outputStream.flush();
            return total;
        } catch (IOException | RuntimeException e11) {
            OutputStream outputStream6 = outputStream;
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Response code: ");
            sb4.append(e11.getMessage());
            throw new NetworkIOException(sb4.toString());
        }
    }

    public String makeRequest() throws NetworkIOException, IOException, IllegalStateException, IllegalArgumentException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        makeStreamRequest(baos);
        return baos.toString("UTF-8");
    }

    private HttpURLConnection getHttpUrlConnectionWithHeaders() throws NetworkIOException, IllegalArgumentException {
        HttpURLConnection connection;
        if (getUrl().toString().startsWith("https://")) {
            try {
                connection = (HttpsURLConnection) getUrl().openConnection();
            } catch (IOException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Open HTTPS connection: ");
                sb.append(e.getMessage());
                throw new NetworkIOException(sb.toString());
            }
        } else if (getUrl().toString().startsWith("http://")) {
            try {
                connection = (HttpURLConnection) getUrl().openConnection();
            } catch (IOException e2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Open HTTP connection: ");
                sb2.append(e2.getMessage());
                throw new NetworkIOException(sb2.toString());
            }
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Invalid url-protocol in url: ");
            sb3.append(getUrl().toString());
            throw new IllegalArgumentException(sb3.toString());
        }
        connection.setInstanceFollowRedirects(false);
        connection.setConnectTimeout(getConnectTimeout());
        connection.setReadTimeout(getReadTimeout());
        try {
            connection.setRequestMethod(getRequestType());
            if (getHeaders() != null && getHeaders().size() > 0) {
                for (String k : getHeaders().keySet()) {
                    for (String value : (List) getHeaders().get(k)) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("Setting header: ");
                        sb4.append(k);
                        sb4.append("=");
                        sb4.append(value);
                        DeviceLog.debug(sb4.toString());
                        connection.setRequestProperty(k, value);
                    }
                }
            }
            return connection;
        } catch (ProtocolException e3) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Set Request Method: ");
            sb5.append(getRequestType());
            sb5.append(", ");
            sb5.append(e3.getMessage());
            throw new NetworkIOException(sb5.toString());
        }
    }
}
