package p005cm.aptoide.p006pt.dataprovider.cache;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.ResponseBody;
import p362h.C14194i;

/* renamed from: cm.aptoide.pt.dataprovider.cache.ResponseCacheEntry */
public class ResponseCacheEntry {
    private static final String DEFAULT_CHARSET = "UTF-8";
    private String body;
    private String bodyMediaType;
    private int code;
    private Map<String, List<String>> headers;
    private String message;
    private String protocol;
    private long validity;

    public ResponseCacheEntry() {
    }

    public ResponseCacheEntry(Response response, int secondsToPersist) {
        this.validity = System.currentTimeMillis() + ((long) (secondsToPersist * 1000));
        this.code = response.code();
        this.message = response.message();
        this.protocol = response.protocol().toString();
        this.headers = response.headers().toMultimap();
        ResponseBody responseBody = response.body();
        this.bodyMediaType = responseBody.contentType().toString();
        Charset charset = responseBody.contentType().charset(Charset.forName(DEFAULT_CHARSET));
        try {
            C14194i source = responseBody.source();
            source.request(Long.MAX_VALUE);
            this.body = source.mo44238k().clone().mo44213a(charset);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getDefaultCharset() {
        return DEFAULT_CHARSET;
    }

    public Response getResponse(Request request) {
        Builder builder = new Builder();
        builder.code(this.code);
        builder.message(this.message);
        try {
            builder.protocol(Protocol.get(this.protocol));
        } catch (IOException e) {
            e.printStackTrace();
        }
        builder.body(ResponseBody.create(MediaType.parse(this.bodyMediaType), this.body));
        Headers.Builder headersBuilders = new Headers.Builder();
        for (Entry<String, List<String>> entry : this.headers.entrySet()) {
            for (String entryValue : (List) entry.getValue()) {
                headersBuilders.add((String) entry.getKey(), entryValue);
            }
        }
        builder.headers(headersBuilders.build());
        builder.request(request);
        return builder.build();
    }

    /* access modifiers changed from: 0000 */
    @JsonIgnore
    public boolean isValid() {
        return System.currentTimeMillis() <= this.validity;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code2) {
        this.code = code2;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message2) {
        this.message = message2;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public void setProtocol(String protocol2) {
        this.protocol = protocol2;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String body2) {
        this.body = body2;
    }

    public String getBodyMediaType() {
        return this.bodyMediaType;
    }

    public void setBodyMediaType(String bodyMediaType2) {
        this.bodyMediaType = bodyMediaType2;
    }

    public Map<String, List<String>> getHeaders() {
        return this.headers;
    }

    public void setHeaders(Map<String, List<String>> headers2) {
        this.headers = headers2;
    }

    public long getValidity() {
        return this.validity;
    }

    public void setValidity(long validity2) {
        this.validity = validity2;
    }
}
