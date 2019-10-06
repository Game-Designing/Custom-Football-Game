package com.mopub.mobileads;

import com.mopub.common.Preconditions;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.mopub.mobileads.Ja */
/* compiled from: VastResource */
class C11321Ja implements Serializable {

    /* renamed from: a */
    private static final List<String> f34812a = Arrays.asList(new String[]{"image/jpeg", "image/png", "image/bmp", "image/gif"});

    /* renamed from: b */
    private static final List<String> f34813b = Arrays.asList(new String[]{"application/x-javascript"});

    /* renamed from: c */
    private String f34814c;

    /* renamed from: d */
    private C11323b f34815d;

    /* renamed from: e */
    private C11322a f34816e;

    /* renamed from: f */
    private int f34817f;

    /* renamed from: g */
    private int f34818g;

    /* renamed from: com.mopub.mobileads.Ja$a */
    /* compiled from: VastResource */
    enum C11322a {
        NONE,
        IMAGE,
        JAVASCRIPT
    }

    /* renamed from: com.mopub.mobileads.Ja$b */
    /* compiled from: VastResource */
    enum C11323b {
        STATIC_RESOURCE,
        HTML_RESOURCE,
        IFRAME_RESOURCE
    }

    /* renamed from: a */
    static C11321Ja m37419a(VastResourceXmlManager resourceXmlManager, C11323b type, int width, int height) {
        C11322a creativeType;
        String resource;
        C11323b bVar = type;
        Preconditions.checkNotNull(resourceXmlManager);
        Preconditions.checkNotNull(type);
        String iFrameResource = resourceXmlManager.mo37245b();
        String htmlResource = resourceXmlManager.mo37244a();
        String staticResource = resourceXmlManager.mo37246c();
        String staticResourceType = resourceXmlManager.mo37247d();
        if (bVar == C11323b.STATIC_RESOURCE && staticResource != null && staticResourceType != null && (f34812a.contains(staticResourceType) || f34813b.contains(staticResourceType))) {
            String resource2 = staticResource;
            if (f34812a.contains(staticResourceType)) {
                resource = resource2;
                creativeType = C11322a.IMAGE;
            } else {
                resource = resource2;
                creativeType = C11322a.JAVASCRIPT;
            }
        } else if (bVar == C11323b.HTML_RESOURCE && htmlResource != null) {
            resource = htmlResource;
            creativeType = C11322a.NONE;
        } else if (bVar != C11323b.IFRAME_RESOURCE || iFrameResource == null) {
            return null;
        } else {
            resource = iFrameResource;
            creativeType = C11322a.NONE;
        }
        C11321Ja ja = new C11321Ja(resource, type, creativeType, width, height);
        return ja;
    }

    C11321Ja(String resource, C11323b type, C11322a creativeType, int width, int height) {
        Preconditions.checkNotNull(resource);
        Preconditions.checkNotNull(type);
        Preconditions.checkNotNull(creativeType);
        this.f34814c = resource;
        this.f34815d = type;
        this.f34816e = creativeType;
        this.f34817f = width;
        this.f34818g = height;
    }

    public String getResource() {
        return this.f34814c;
    }

    public C11323b getType() {
        return this.f34815d;
    }

    public C11322a getCreativeType() {
        return this.f34816e;
    }

    public void initializeWebView(C11372Ya webView) {
        Preconditions.checkNotNull(webView);
        C11323b bVar = this.f34815d;
        if (bVar == C11323b.IFRAME_RESOURCE) {
            StringBuilder sb = new StringBuilder();
            sb.append("<iframe frameborder=\"0\" scrolling=\"no\" marginheight=\"0\" marginwidth=\"0\" style=\"border: 0px; margin: 0px;\" width=\"");
            sb.append(this.f34817f);
            sb.append("\" height=\"");
            sb.append(this.f34818g);
            sb.append("\" src=\"");
            sb.append(this.f34814c);
            sb.append("\"></iframe>");
            webView.mo37433a(sb.toString());
        } else if (bVar == C11323b.HTML_RESOURCE) {
            webView.mo37433a(this.f34814c);
        } else if (bVar == C11323b.STATIC_RESOURCE) {
            C11322a aVar = this.f34816e;
            if (aVar == C11322a.IMAGE) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("<html><head></head><body style=\"margin:0;padding:0\"><img src=\"");
                sb2.append(this.f34814c);
                sb2.append("\" width=\"100%\" style=\"max-width:100%;max-height:100%;\" /></body></html>");
                webView.mo37433a(sb2.toString());
            } else if (aVar == C11322a.JAVASCRIPT) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("<script src=\"");
                sb3.append(this.f34814c);
                sb3.append("\"></script>");
                webView.mo37433a(sb3.toString());
            }
        }
    }

    public String getCorrectClickThroughUrl(String vastClickThroughUrl, String webViewClickThroughUrl) {
        int i = C11319Ia.f34794a[this.f34815d.ordinal()];
        if (i == 1) {
            C11322a aVar = C11322a.IMAGE;
            C11322a aVar2 = this.f34816e;
            if (aVar == aVar2) {
                return vastClickThroughUrl;
            }
            if (C11322a.JAVASCRIPT == aVar2) {
                return webViewClickThroughUrl;
            }
            return null;
        } else if (i == 2 || i == 3) {
            return webViewClickThroughUrl;
        } else {
            return null;
        }
    }
}
