package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.fr */
class C9436fr {

    /* renamed from: A */
    public static final int f22305A = zzkq.m30569b("mdhd");

    /* renamed from: B */
    public static final int f22306B = zzkq.m30569b("hdlr");

    /* renamed from: C */
    public static final int f22307C = zzkq.m30569b("stsd");

    /* renamed from: D */
    private static final int f22308D = zzkq.m30569b("pssh");

    /* renamed from: E */
    public static final int f22309E = zzkq.m30569b("sinf");

    /* renamed from: F */
    public static final int f22310F = zzkq.m30569b("schm");

    /* renamed from: G */
    public static final int f22311G = zzkq.m30569b("schi");

    /* renamed from: H */
    public static final int f22312H = zzkq.m30569b("tenc");

    /* renamed from: I */
    public static final int f22313I = zzkq.m30569b("encv");

    /* renamed from: J */
    public static final int f22314J = zzkq.m30569b("enca");

    /* renamed from: K */
    public static final int f22315K = zzkq.m30569b("frma");

    /* renamed from: L */
    private static final int f22316L = zzkq.m30569b("saiz");

    /* renamed from: M */
    private static final int f22317M = zzkq.m30569b("uuid");

    /* renamed from: N */
    private static final int f22318N = zzkq.m30569b("senc");

    /* renamed from: O */
    public static final int f22319O = zzkq.m30569b("pasp");

    /* renamed from: P */
    public static final int f22320P = zzkq.m30569b("TTML");

    /* renamed from: Q */
    public static final int f22321Q = zzkq.m30569b("vmhd");

    /* renamed from: R */
    public static final int f22322R = zzkq.m30569b("smhd");

    /* renamed from: S */
    public static final int f22323S = zzkq.m30569b("mp4v");

    /* renamed from: T */
    public static final int f22324T = zzkq.m30569b("stts");

    /* renamed from: U */
    public static final int f22325U = zzkq.m30569b("stss");

    /* renamed from: V */
    public static final int f22326V = zzkq.m30569b("ctts");

    /* renamed from: W */
    public static final int f22327W = zzkq.m30569b("stsc");

    /* renamed from: X */
    public static final int f22328X = zzkq.m30569b("stsz");

    /* renamed from: Y */
    public static final int f22329Y = zzkq.m30569b("stco");

    /* renamed from: Z */
    public static final int f22330Z = zzkq.m30569b("co64");

    /* renamed from: a */
    private static final int f22331a = zzkq.m30569b("ftyp");

    /* renamed from: b */
    public static final int f22332b = zzkq.m30569b("avc1");

    /* renamed from: c */
    public static final int f22333c = zzkq.m30569b("avc3");

    /* renamed from: d */
    public static final int f22334d = zzkq.m30569b("esds");

    /* renamed from: e */
    private static final int f22335e = zzkq.m30569b("mdat");

    /* renamed from: f */
    public static final int f22336f = zzkq.m30569b("mp4a");

    /* renamed from: g */
    public static final int f22337g = zzkq.m30569b("ac-3");

    /* renamed from: h */
    public static final int f22338h = zzkq.m30569b("dac3");

    /* renamed from: i */
    public static final int f22339i = zzkq.m30569b("ec-3");

    /* renamed from: j */
    public static final int f22340j = zzkq.m30569b("dec3");

    /* renamed from: k */
    private static final int f22341k = zzkq.m30569b("tfdt");

    /* renamed from: l */
    private static final int f22342l = zzkq.m30569b("tfhd");

    /* renamed from: m */
    private static final int f22343m = zzkq.m30569b("trex");

    /* renamed from: n */
    private static final int f22344n = zzkq.m30569b("trun");

    /* renamed from: o */
    private static final int f22345o = zzkq.m30569b("sidx");

    /* renamed from: p */
    public static final int f22346p = zzkq.m30569b("moov");

    /* renamed from: q */
    public static final int f22347q = zzkq.m30569b("mvhd");

    /* renamed from: r */
    public static final int f22348r = zzkq.m30569b("trak");

    /* renamed from: s */
    public static final int f22349s = zzkq.m30569b("mdia");

    /* renamed from: t */
    public static final int f22350t = zzkq.m30569b("minf");

    /* renamed from: u */
    public static final int f22351u = zzkq.m30569b("stbl");

    /* renamed from: v */
    public static final int f22352v = zzkq.m30569b("avcC");

    /* renamed from: w */
    private static final int f22353w = zzkq.m30569b("moof");

    /* renamed from: x */
    private static final int f22354x = zzkq.m30569b("traf");

    /* renamed from: y */
    private static final int f22355y = zzkq.m30569b("mvex");

    /* renamed from: z */
    public static final int f22356z = zzkq.m30569b("tkhd");

    /* renamed from: aa */
    public final int f22357aa;

    C9436fr(int i) {
        this.f22357aa = i;
    }

    public String toString() {
        return m23620b(this.f22357aa);
    }

    /* renamed from: a */
    public static int m23619a(int i) {
        return (i >> 24) & 255;
    }

    /* renamed from: b */
    public static String m23620b(int i) {
        char c = (char) (i >> 24);
        char c2 = (char) ((i >> 16) & 255);
        char c3 = (char) ((i >> 8) & 255);
        char c4 = (char) (i & 255);
        StringBuilder sb = new StringBuilder(4);
        sb.append(c);
        sb.append(c2);
        sb.append(c3);
        sb.append(c4);
        return sb.toString();
    }
}
