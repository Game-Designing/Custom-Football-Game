package com.mopub.network;

import com.mopub.common.util.ResponseHeader;
import com.mopub.volley.AuthFailureError;
import com.mopub.volley.Request;
import com.mopub.volley.toolbox.HttpResponse;
import com.mopub.volley.toolbox.HurlStack;
import com.mopub.volley.toolbox.HurlStack.UrlRewriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import javax.net.ssl.SSLSocketFactory;

public class RequestQueueHttpStack extends HurlStack {

    /* renamed from: c */
    private final String f36380c;

    public RequestQueueHttpStack(String userAgent) {
        this(userAgent, null);
    }

    public RequestQueueHttpStack(String userAgent, UrlRewriter urlRewriter) {
        this(userAgent, urlRewriter, null);
    }

    public RequestQueueHttpStack(String userAgent, UrlRewriter urlRewriter, SSLSocketFactory sslSocketFactory) {
        super(urlRewriter, sslSocketFactory);
        this.f36380c = userAgent;
    }

    public HttpResponse executeRequest(Request<?> request, Map<String, String> additionalHeaders) throws IOException, AuthFailureError {
        if (additionalHeaders == null || additionalHeaders.isEmpty()) {
            additionalHeaders = new TreeMap<>();
        }
        additionalHeaders.put(ResponseHeader.USER_AGENT.getKey(), this.f36380c);
        return super.executeRequest(request, additionalHeaders);
    }
}
