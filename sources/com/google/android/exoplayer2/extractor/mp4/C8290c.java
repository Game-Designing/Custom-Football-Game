package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.util.C8509F;
import com.google.android.exoplayer2.util.C8535t;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.extractor.mp4.c */
/* compiled from: Atom */
abstract class C8290c {

    /* renamed from: A */
    public static final int f17606A = C8509F.m20464b("sidx");

    /* renamed from: Aa */
    public static final int f17607Aa = C8509F.m20464b("udta");

    /* renamed from: B */
    public static final int f17608B = C8509F.m20464b("moov");

    /* renamed from: Ba */
    public static final int f17609Ba = C8509F.m20464b("meta");

    /* renamed from: C */
    public static final int f17610C = C8509F.m20464b("mvhd");

    /* renamed from: Ca */
    public static final int f17611Ca = C8509F.m20464b("keys");

    /* renamed from: D */
    public static final int f17612D = C8509F.m20464b("trak");

    /* renamed from: Da */
    public static final int f17613Da = C8509F.m20464b("ilst");

    /* renamed from: E */
    public static final int f17614E = C8509F.m20464b("mdia");

    /* renamed from: Ea */
    public static final int f17615Ea = C8509F.m20464b("mean");

    /* renamed from: F */
    public static final int f17616F = C8509F.m20464b("minf");

    /* renamed from: Fa */
    public static final int f17617Fa = C8509F.m20464b("name");

    /* renamed from: G */
    public static final int f17618G = C8509F.m20464b("stbl");

    /* renamed from: Ga */
    public static final int f17619Ga = C8509F.m20464b("data");

    /* renamed from: H */
    public static final int f17620H = C8509F.m20464b("avcC");

    /* renamed from: Ha */
    public static final int f17621Ha = C8509F.m20464b("emsg");

    /* renamed from: I */
    public static final int f17622I = C8509F.m20464b("hvcC");

    /* renamed from: Ia */
    public static final int f17623Ia = C8509F.m20464b("st3d");

    /* renamed from: J */
    public static final int f17624J = C8509F.m20464b("esds");

    /* renamed from: Ja */
    public static final int f17625Ja = C8509F.m20464b("sv3d");

    /* renamed from: K */
    public static final int f17626K = C8509F.m20464b("moof");

    /* renamed from: Ka */
    public static final int f17627Ka = C8509F.m20464b("proj");

    /* renamed from: L */
    public static final int f17628L = C8509F.m20464b("traf");

    /* renamed from: La */
    public static final int f17629La = C8509F.m20464b("vp08");

    /* renamed from: M */
    public static final int f17630M = C8509F.m20464b("mvex");

    /* renamed from: Ma */
    public static final int f17631Ma = C8509F.m20464b("vp09");

    /* renamed from: N */
    public static final int f17632N = C8509F.m20464b("mehd");

    /* renamed from: Na */
    public static final int f17633Na = C8509F.m20464b("vpcC");

    /* renamed from: O */
    public static final int f17634O = C8509F.m20464b("tkhd");

    /* renamed from: Oa */
    public static final int f17635Oa = C8509F.m20464b("camm");

    /* renamed from: P */
    public static final int f17636P = C8509F.m20464b("edts");

    /* renamed from: Pa */
    public static final int f17637Pa = C8509F.m20464b("alac");

    /* renamed from: Q */
    public static final int f17638Q = C8509F.m20464b("elst");

    /* renamed from: Qa */
    public static final int f17639Qa = C8509F.m20464b("alaw");

    /* renamed from: R */
    public static final int f17640R = C8509F.m20464b("mdhd");

    /* renamed from: Ra */
    public static final int f17641Ra = C8509F.m20464b("ulaw");

    /* renamed from: S */
    public static final int f17642S = C8509F.m20464b("hdlr");

    /* renamed from: Sa */
    public static final int f17643Sa = C8509F.m20464b("Opus");

    /* renamed from: T */
    public static final int f17644T = C8509F.m20464b("stsd");

    /* renamed from: Ta */
    public static final int f17645Ta = C8509F.m20464b("dOps");

    /* renamed from: U */
    public static final int f17646U = C8509F.m20464b("pssh");

    /* renamed from: Ua */
    public static final int f17647Ua = C8509F.m20464b("fLaC");

    /* renamed from: V */
    public static final int f17648V = C8509F.m20464b("sinf");

    /* renamed from: Va */
    public static final int f17649Va = C8509F.m20464b("dfLa");

    /* renamed from: W */
    public static final int f17650W = C8509F.m20464b("schm");

    /* renamed from: X */
    public static final int f17651X = C8509F.m20464b("schi");

    /* renamed from: Y */
    public static final int f17652Y = C8509F.m20464b("tenc");

    /* renamed from: Z */
    public static final int f17653Z = C8509F.m20464b("encv");

    /* renamed from: a */
    public static final int f17654a = C8509F.m20464b("ftyp");

    /* renamed from: aa */
    public static final int f17655aa = C8509F.m20464b("enca");

    /* renamed from: b */
    public static final int f17656b = C8509F.m20464b("avc1");

    /* renamed from: ba */
    public static final int f17657ba = C8509F.m20464b("frma");

    /* renamed from: c */
    public static final int f17658c = C8509F.m20464b("avc3");

    /* renamed from: ca */
    public static final int f17659ca = C8509F.m20464b("saiz");

    /* renamed from: d */
    public static final int f17660d = C8509F.m20464b("hvc1");

    /* renamed from: da */
    public static final int f17661da = C8509F.m20464b("saio");

    /* renamed from: e */
    public static final int f17662e = C8509F.m20464b("hev1");

    /* renamed from: ea */
    public static final int f17663ea = C8509F.m20464b("sbgp");

    /* renamed from: f */
    public static final int f17664f = C8509F.m20464b("s263");

    /* renamed from: fa */
    public static final int f17665fa = C8509F.m20464b("sgpd");

    /* renamed from: g */
    public static final int f17666g = C8509F.m20464b("d263");

    /* renamed from: ga */
    public static final int f17667ga = C8509F.m20464b("uuid");

    /* renamed from: h */
    public static final int f17668h = C8509F.m20464b("mdat");

    /* renamed from: ha */
    public static final int f17669ha = C8509F.m20464b("senc");

    /* renamed from: i */
    public static final int f17670i = C8509F.m20464b("mp4a");

    /* renamed from: ia */
    public static final int f17671ia = C8509F.m20464b("pasp");

    /* renamed from: j */
    public static final int f17672j = C8509F.m20464b(".mp3");

    /* renamed from: ja */
    public static final int f17673ja = C8509F.m20464b("TTML");

    /* renamed from: k */
    public static final int f17674k = C8509F.m20464b("wave");

    /* renamed from: ka */
    public static final int f17675ka = C8509F.m20464b("vmhd");

    /* renamed from: l */
    public static final int f17676l = C8509F.m20464b("lpcm");

    /* renamed from: la */
    public static final int f17677la = C8509F.m20464b("mp4v");

    /* renamed from: m */
    public static final int f17678m = C8509F.m20464b("sowt");

    /* renamed from: ma */
    public static final int f17679ma = C8509F.m20464b("stts");

    /* renamed from: n */
    public static final int f17680n = C8509F.m20464b("ac-3");

    /* renamed from: na */
    public static final int f17681na = C8509F.m20464b("stss");

    /* renamed from: o */
    public static final int f17682o = C8509F.m20464b("dac3");

    /* renamed from: oa */
    public static final int f17683oa = C8509F.m20464b("ctts");

    /* renamed from: p */
    public static final int f17684p = C8509F.m20464b("ec-3");

    /* renamed from: pa */
    public static final int f17685pa = C8509F.m20464b("stsc");

    /* renamed from: q */
    public static final int f17686q = C8509F.m20464b("dec3");

    /* renamed from: qa */
    public static final int f17687qa = C8509F.m20464b("stsz");

    /* renamed from: r */
    public static final int f17688r = C8509F.m20464b("dtsc");

    /* renamed from: ra */
    public static final int f17689ra = C8509F.m20464b("stz2");

    /* renamed from: s */
    public static final int f17690s = C8509F.m20464b("dtsh");

    /* renamed from: sa */
    public static final int f17691sa = C8509F.m20464b("stco");

    /* renamed from: t */
    public static final int f17692t = C8509F.m20464b("dtsl");

    /* renamed from: ta */
    public static final int f17693ta = C8509F.m20464b("co64");

    /* renamed from: u */
    public static final int f17694u = C8509F.m20464b("dtse");

    /* renamed from: ua */
    public static final int f17695ua = C8509F.m20464b("tx3g");

    /* renamed from: v */
    public static final int f17696v = C8509F.m20464b("ddts");

    /* renamed from: va */
    public static final int f17697va = C8509F.m20464b("wvtt");

    /* renamed from: w */
    public static final int f17698w = C8509F.m20464b("tfdt");

    /* renamed from: wa */
    public static final int f17699wa = C8509F.m20464b("stpp");

    /* renamed from: x */
    public static final int f17700x = C8509F.m20464b("tfhd");

    /* renamed from: xa */
    public static final int f17701xa = C8509F.m20464b("c608");

    /* renamed from: y */
    public static final int f17702y = C8509F.m20464b("trex");

    /* renamed from: ya */
    public static final int f17703ya = C8509F.m20464b("samr");

    /* renamed from: z */
    public static final int f17704z = C8509F.m20464b("trun");

    /* renamed from: za */
    public static final int f17705za = C8509F.m20464b("sawb");

    /* renamed from: Wa */
    public final int f17706Wa;

    /* renamed from: com.google.android.exoplayer2.extractor.mp4.c$a */
    /* compiled from: Atom */
    static final class C8291a extends C8290c {

        /* renamed from: Xa */
        public final long f17707Xa;

        /* renamed from: Ya */
        public final List<C8292b> f17708Ya = new ArrayList();

        /* renamed from: Za */
        public final List<C8291a> f17709Za = new ArrayList();

        public C8291a(int type, long endPosition) {
            super(type);
            this.f17707Xa = endPosition;
        }

        /* renamed from: a */
        public void mo25434a(C8292b atom) {
            this.f17708Ya.add(atom);
        }

        /* renamed from: a */
        public void mo25433a(C8291a atom) {
            this.f17709Za.add(atom);
        }

        /* renamed from: e */
        public C8292b mo25436e(int type) {
            int childrenSize = this.f17708Ya.size();
            for (int i = 0; i < childrenSize; i++) {
                C8292b atom = (C8292b) this.f17708Ya.get(i);
                if (atom.f17706Wa == type) {
                    return atom;
                }
            }
            return null;
        }

        /* renamed from: d */
        public C8291a mo25435d(int type) {
            int childrenSize = this.f17709Za.size();
            for (int i = 0; i < childrenSize; i++) {
                C8291a atom = (C8291a) this.f17709Za.get(i);
                if (atom.f17706Wa == type) {
                    return atom;
                }
            }
            return null;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(C8290c.m19287a(this.f17706Wa));
            sb.append(" leaves: ");
            sb.append(Arrays.toString(this.f17708Ya.toArray()));
            sb.append(" containers: ");
            sb.append(Arrays.toString(this.f17709Za.toArray()));
            return sb.toString();
        }
    }

    /* renamed from: com.google.android.exoplayer2.extractor.mp4.c$b */
    /* compiled from: Atom */
    static final class C8292b extends C8290c {

        /* renamed from: Xa */
        public final C8535t f17710Xa;

        public C8292b(int type, C8535t data) {
            super(type);
            this.f17710Xa = data;
        }
    }

    public C8290c(int type) {
        this.f17706Wa = type;
    }

    public String toString() {
        return m19287a(this.f17706Wa);
    }

    /* renamed from: c */
    public static int m19289c(int fullAtomInt) {
        return (fullAtomInt >> 24) & 255;
    }

    /* renamed from: b */
    public static int m19288b(int fullAtomInt) {
        return 16777215 & fullAtomInt;
    }

    /* renamed from: a */
    public static String m19287a(int type) {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append((char) ((type >> 24) & 255));
        sb.append((char) ((type >> 16) & 255));
        sb.append((char) ((type >> 8) & 255));
        sb.append((char) (type & 255));
        return sb.toString();
    }
}
