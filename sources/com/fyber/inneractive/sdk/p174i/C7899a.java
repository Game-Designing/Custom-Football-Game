package com.fyber.inneractive.sdk.p174i;

/* renamed from: com.fyber.inneractive.sdk.i.a */
public final class C7899a {

    /* renamed from: a */
    public String f15980a;

    /* renamed from: b */
    public C7900a f15981b;

    /* renamed from: c */
    public String f15982c;

    /* renamed from: d */
    public int f15983d;

    /* renamed from: e */
    public int f15984e;

    /* renamed from: f */
    public int f15985f;

    /* renamed from: g */
    boolean f15986g;

    /* renamed from: h */
    boolean f15987h;

    /* renamed from: i */
    public String f15988i;

    /* renamed from: j */
    C7901b f15989j;

    /* renamed from: k */
    Object f15990k;

    /* renamed from: com.fyber.inneractive.sdk.i.a$a */
    enum C7900a {
        streaming,
        progressive
    }

    /* renamed from: com.fyber.inneractive.sdk.i.a$b */
    enum C7901b {
        BITRATE_NOT_IN_RANGE(1),
        UNSUPPORTED_MIME_TYPE(2),
        UNSUPPORTED_DELIVERY(3),
        UNSECURED_VIDEO_URL(4),
        VERTICAL_VIDEO_EXPECTED(5),
        FILTERED_BY_APP_OR_UNIT(6);
        

        /* renamed from: g */
        int f16001g;

        private C7901b(int i) {
            this.f16001g = i;
        }
    }

    /* renamed from: com.fyber.inneractive.sdk.i.a$c */
    public enum C7902c {
        MEDIA_TYPE_MP4("video/mp4"),
        MEDIA_TYPE_3GPP("video/3gpp"),
        MEDIA_TYPE_WEBM("video/webm"),
        MEDIA_TYPE_JAVASCRIPT("application/javascript");
        

        /* renamed from: e */
        final String f16007e;

        private C7902c(String str) {
            this.f16007e = str;
        }
    }

    C7899a(String str, String str2, C7900a aVar, int i, int i2) {
        this.f15980a = str;
        this.f15981b = aVar;
        this.f15983d = i;
        this.f15984e = i2;
        this.f15982c = str2;
    }

    /* renamed from: a */
    public final Integer mo24710a() {
        if (this.f15982c.compareToIgnoreCase(C7902c.MEDIA_TYPE_MP4.f16007e) == 0) {
            return Integer.valueOf(3);
        }
        if (this.f15982c.compareToIgnoreCase(C7902c.MEDIA_TYPE_3GPP.f16007e) == 0) {
            return Integer.valueOf(2);
        }
        if (this.f15982c.compareToIgnoreCase(C7902c.MEDIA_TYPE_WEBM.f16007e) == 0) {
            return Integer.valueOf(1);
        }
        return Integer.valueOf(-1);
    }
}
