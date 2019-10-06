package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.InternalFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.p183b.C8264k;
import com.google.android.exoplayer2.util.C8509F;
import com.google.android.exoplayer2.util.C8526n;
import com.google.android.exoplayer2.util.C8535t;
import java.nio.ByteBuffer;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.google.android.exoplayer2.extractor.mp4.j */
/* compiled from: MetadataUtil */
final class C8308j {

    /* renamed from: A */
    private static final int f17803A = C8509F.m20464b("sosn");

    /* renamed from: B */
    private static final int f17804B = C8509F.m20464b("tvsh");

    /* renamed from: C */
    private static final int f17805C = C8509F.m20464b("----");

    /* renamed from: D */
    private static final String[] f17806D;

    /* renamed from: a */
    private static final int f17807a = C8509F.m20464b("nam");

    /* renamed from: b */
    private static final int f17808b = C8509F.m20464b("trk");

    /* renamed from: c */
    private static final int f17809c = C8509F.m20464b("cmt");

    /* renamed from: d */
    private static final int f17810d = C8509F.m20464b("day");

    /* renamed from: e */
    private static final int f17811e = C8509F.m20464b("ART");

    /* renamed from: f */
    private static final int f17812f = C8509F.m20464b("too");

    /* renamed from: g */
    private static final int f17813g = C8509F.m20464b("alb");

    /* renamed from: h */
    private static final int f17814h = C8509F.m20464b("com");

    /* renamed from: i */
    private static final int f17815i = C8509F.m20464b("wrt");

    /* renamed from: j */
    private static final int f17816j = C8509F.m20464b("lyr");

    /* renamed from: k */
    private static final int f17817k = C8509F.m20464b("gen");

    /* renamed from: l */
    private static final int f17818l = C8509F.m20464b("covr");

    /* renamed from: m */
    private static final int f17819m = C8509F.m20464b("gnre");

    /* renamed from: n */
    private static final int f17820n = C8509F.m20464b("grp");

    /* renamed from: o */
    private static final int f17821o = C8509F.m20464b("disk");

    /* renamed from: p */
    private static final int f17822p = C8509F.m20464b("trkn");

    /* renamed from: q */
    private static final int f17823q = C8509F.m20464b("tmpo");

    /* renamed from: r */
    private static final int f17824r = C8509F.m20464b("cpil");

    /* renamed from: s */
    private static final int f17825s = C8509F.m20464b("aART");

    /* renamed from: t */
    private static final int f17826t = C8509F.m20464b("sonm");

    /* renamed from: u */
    private static final int f17827u = C8509F.m20464b("soal");

    /* renamed from: v */
    private static final int f17828v = C8509F.m20464b("soar");

    /* renamed from: w */
    private static final int f17829w = C8509F.m20464b("soaa");

    /* renamed from: x */
    private static final int f17830x = C8509F.m20464b("soco");

    /* renamed from: y */
    private static final int f17831y = C8509F.m20464b("rtng");

    /* renamed from: z */
    private static final int f17832z = C8509F.m20464b("pgap");

    static {
        String[] strArr = new String[Opcodes.LCMP];
        strArr[0] = "Blues";
        strArr[1] = "Classic Rock";
        strArr[2] = "Country";
        strArr[3] = "Dance";
        strArr[4] = "Disco";
        strArr[5] = "Funk";
        strArr[6] = "Grunge";
        strArr[7] = "Hip-Hop";
        strArr[8] = "Jazz";
        strArr[9] = "Metal";
        strArr[10] = "New Age";
        strArr[11] = "Oldies";
        strArr[12] = "Other";
        strArr[13] = "Pop";
        strArr[14] = "R&B";
        strArr[15] = "Rap";
        strArr[16] = "Reggae";
        strArr[17] = "Rock";
        strArr[18] = "Techno";
        strArr[19] = "Industrial";
        strArr[20] = "Alternative";
        strArr[21] = "Ska";
        strArr[22] = "Death Metal";
        strArr[23] = "Pranks";
        strArr[24] = "Soundtrack";
        strArr[25] = "Euro-Techno";
        strArr[26] = "Ambient";
        strArr[27] = "Trip-Hop";
        strArr[28] = "Vocal";
        strArr[29] = "Jazz+Funk";
        strArr[30] = "Fusion";
        strArr[31] = "Trance";
        strArr[32] = "Classical";
        strArr[33] = "Instrumental";
        strArr[34] = "Acid";
        strArr[35] = "House";
        strArr[36] = "Game";
        strArr[37] = "Sound Clip";
        strArr[38] = "Gospel";
        strArr[39] = "Noise";
        strArr[40] = "AlternRock";
        strArr[41] = "Bass";
        strArr[42] = "Soul";
        strArr[43] = "Punk";
        strArr[44] = "Space";
        strArr[45] = "Meditative";
        strArr[46] = "Instrumental Pop";
        strArr[47] = "Instrumental Rock";
        strArr[48] = "Ethnic";
        strArr[49] = "Gothic";
        strArr[50] = "Darkwave";
        strArr[51] = "Techno-Industrial";
        strArr[52] = "Electronic";
        strArr[53] = "Pop-Folk";
        strArr[54] = "Eurodance";
        strArr[55] = "Dream";
        strArr[56] = "Southern Rock";
        strArr[57] = "Comedy";
        strArr[58] = "Cult";
        strArr[59] = "Gangsta";
        strArr[60] = "Top 40";
        strArr[61] = "Christian Rap";
        strArr[62] = "Pop/Funk";
        strArr[63] = "Jungle";
        strArr[64] = "Native American";
        strArr[65] = "Cabaret";
        strArr[66] = "New Wave";
        strArr[67] = "Psychadelic";
        strArr[68] = "Rave";
        strArr[69] = "Showtunes";
        strArr[70] = "Trailer";
        strArr[71] = "Lo-Fi";
        strArr[72] = "Tribal";
        strArr[73] = "Acid Punk";
        strArr[74] = "Acid Jazz";
        strArr[75] = "Polka";
        strArr[76] = "Retro";
        strArr[77] = "Musical";
        strArr[78] = "Rock & Roll";
        strArr[79] = "Hard Rock";
        strArr[80] = "Folk";
        strArr[81] = "Folk-Rock";
        strArr[82] = "National Folk";
        strArr[83] = "Swing";
        strArr[84] = "Fast Fusion";
        strArr[85] = "Bebob";
        strArr[86] = "Latin";
        strArr[87] = "Revival";
        strArr[88] = "Celtic";
        strArr[89] = "Bluegrass";
        strArr[90] = "Avantgarde";
        strArr[91] = "Gothic Rock";
        strArr[92] = "Progressive Rock";
        strArr[93] = "Psychedelic Rock";
        strArr[94] = "Symphonic Rock";
        strArr[95] = "Slow Rock";
        strArr[96] = "Big Band";
        strArr[97] = "Chorus";
        strArr[98] = "Easy Listening";
        strArr[99] = "Acoustic";
        strArr[100] = "Humour";
        strArr[101] = "Speech";
        strArr[102] = "Chanson";
        strArr[103] = "Opera";
        strArr[104] = "Chamber Music";
        strArr[105] = "Sonata";
        strArr[106] = "Symphony";
        strArr[107] = "Booty Bass";
        strArr[108] = "Primus";
        strArr[109] = "Porn Groove";
        strArr[110] = "Satire";
        strArr[111] = "Slow Jam";
        strArr[112] = "Club";
        strArr[113] = "Tango";
        strArr[114] = "Samba";
        strArr[115] = "Folklore";
        strArr[116] = "Ballad";
        strArr[117] = "Power Ballad";
        strArr[118] = "Rhythmic Soul";
        strArr[119] = "Freestyle";
        strArr[120] = "Duet";
        strArr[121] = "Punk Rock";
        strArr[122] = "Drum Solo";
        strArr[123] = "A capella";
        strArr[124] = "Euro-House";
        strArr[125] = "Dance Hall";
        strArr[126] = "Goa";
        strArr[127] = "Drum & Bass";
        strArr[128] = "Club-House";
        strArr[129] = "Hardcore";
        strArr[130] = "Terror";
        strArr[131] = "Indie";
        strArr[132] = "BritPop";
        strArr[133] = "Negerpunk";
        strArr[134] = "Polsk Punk";
        strArr[135] = "Beat";
        strArr[136] = "Christian Gangsta Rap";
        strArr[137] = "Heavy Metal";
        strArr[138] = "Black Metal";
        strArr[139] = "Crossover";
        strArr[140] = "Contemporary Christian";
        strArr[141] = "Christian Rock";
        strArr[142] = "Merengue";
        strArr[143] = "Salsa";
        strArr[144] = "Thrash Metal";
        strArr[145] = "Anime";
        strArr[146] = "Jpop";
        strArr[147] = "Synthpop";
        f17806D = strArr;
    }

    /* renamed from: a */
    public static Format m19383a(int trackType, Format format, Metadata udtaMetadata, Metadata mdtaMetadata, C8264k gaplessInfoHolder) {
        if (trackType == 1) {
            if (gaplessInfoHolder.mo25354a()) {
                format = format.mo25009a(gaplessInfoHolder.f17493b, gaplessInfoHolder.f17494c);
            }
            if (udtaMetadata != null) {
                return format.mo25012a(udtaMetadata);
            }
            return format;
        } else if (trackType != 2 || mdtaMetadata == null) {
            return format;
        } else {
            for (int i = 0; i < mdtaMetadata.mo25541a(); i++) {
                Entry entry = mdtaMetadata.mo25542a(i);
                if (entry instanceof MdtaMetadataEntry) {
                    MdtaMetadataEntry mdtaMetadataEntry = (MdtaMetadataEntry) entry;
                    if ("com.android.capture.fps".equals(mdtaMetadataEntry.f17600a) && mdtaMetadataEntry.f17603d == 23) {
                        try {
                            format = format.mo25007a(ByteBuffer.wrap(mdtaMetadataEntry.f17601b).asFloatBuffer().get()).mo25012a(new Metadata(mdtaMetadataEntry));
                        } catch (NumberFormatException e) {
                            C8526n.m20534d("MetadataUtil", "Ignoring invalid framerate");
                        }
                    }
                }
            }
            return format;
        }
    }

    /* renamed from: a */
    public static Entry m19385a(C8535t ilst) {
        int endPosition = ilst.mo26119f() + ilst.mo26113c();
        int type = ilst.mo26119f();
        int typeTopByte = (type >> 24) & 255;
        if (typeTopByte == 169 || typeTopByte == 253) {
            int shortType = 16777215 & type;
            if (shortType == f17809c) {
                CommentFrame a = m19386a(type, ilst);
                ilst.mo26118e(endPosition);
                return a;
            }
            if (shortType != f17807a) {
                if (shortType != f17808b) {
                    if (shortType != f17814h) {
                        if (shortType != f17815i) {
                            if (shortType == f17810d) {
                                TextInformationFrame b = m19391b(type, "TDRC", ilst);
                                ilst.mo26118e(endPosition);
                                return b;
                            } else if (shortType == f17811e) {
                                TextInformationFrame b2 = m19391b(type, "TPE1", ilst);
                                ilst.mo26118e(endPosition);
                                return b2;
                            } else if (shortType == f17812f) {
                                TextInformationFrame b3 = m19391b(type, "TSSE", ilst);
                                ilst.mo26118e(endPosition);
                                return b3;
                            } else if (shortType == f17813g) {
                                TextInformationFrame b4 = m19391b(type, "TALB", ilst);
                                ilst.mo26118e(endPosition);
                                return b4;
                            } else if (shortType == f17816j) {
                                TextInformationFrame b5 = m19391b(type, "USLT", ilst);
                                ilst.mo26118e(endPosition);
                                return b5;
                            } else if (shortType == f17817k) {
                                TextInformationFrame b6 = m19391b(type, "TCON", ilst);
                                ilst.mo26118e(endPosition);
                                return b6;
                            } else if (shortType == f17820n) {
                                TextInformationFrame b7 = m19391b(type, "TIT1", ilst);
                                ilst.mo26118e(endPosition);
                                return b7;
                            }
                        }
                    }
                    TextInformationFrame b8 = m19391b(type, "TCOM", ilst);
                    ilst.mo26118e(endPosition);
                    return b8;
                }
            }
            TextInformationFrame b9 = m19391b(type, "TIT2", ilst);
            ilst.mo26118e(endPosition);
            return b9;
        }
        try {
            if (type == f17819m) {
                return m19392c(ilst);
            }
            if (type == f17821o) {
                TextInformationFrame a2 = m19389a(type, "TPOS", ilst);
                ilst.mo26118e(endPosition);
                return a2;
            } else if (type == f17822p) {
                TextInformationFrame a3 = m19389a(type, "TRCK", ilst);
                ilst.mo26118e(endPosition);
                return a3;
            } else if (type == f17823q) {
                Id3Frame a4 = m19387a(type, "TBPM", ilst, true, false);
                ilst.mo26118e(endPosition);
                return a4;
            } else if (type == f17824r) {
                Id3Frame a5 = m19387a(type, "TCMP", ilst, true, true);
                ilst.mo26118e(endPosition);
                return a5;
            } else if (type == f17818l) {
                ApicFrame b10 = m19390b(ilst);
                ilst.mo26118e(endPosition);
                return b10;
            } else if (type == f17825s) {
                TextInformationFrame b11 = m19391b(type, "TPE2", ilst);
                ilst.mo26118e(endPosition);
                return b11;
            } else if (type == f17826t) {
                TextInformationFrame b12 = m19391b(type, "TSOT", ilst);
                ilst.mo26118e(endPosition);
                return b12;
            } else if (type == f17827u) {
                TextInformationFrame b13 = m19391b(type, "TSO2", ilst);
                ilst.mo26118e(endPosition);
                return b13;
            } else if (type == f17828v) {
                TextInformationFrame b14 = m19391b(type, "TSOA", ilst);
                ilst.mo26118e(endPosition);
                return b14;
            } else if (type == f17829w) {
                TextInformationFrame b15 = m19391b(type, "TSOP", ilst);
                ilst.mo26118e(endPosition);
                return b15;
            } else if (type == f17830x) {
                TextInformationFrame b16 = m19391b(type, "TSOC", ilst);
                ilst.mo26118e(endPosition);
                return b16;
            } else if (type == f17831y) {
                Id3Frame a6 = m19387a(type, "ITUNESADVISORY", ilst, false, false);
                ilst.mo26118e(endPosition);
                return a6;
            } else if (type == f17832z) {
                Id3Frame a7 = m19387a(type, "ITUNESGAPLESS", ilst, false, true);
                ilst.mo26118e(endPosition);
                return a7;
            } else if (type == f17803A) {
                TextInformationFrame b17 = m19391b(type, "TVSHOWSORT", ilst);
                ilst.mo26118e(endPosition);
                return b17;
            } else if (type == f17804B) {
                TextInformationFrame b18 = m19391b(type, "TVSHOW", ilst);
                ilst.mo26118e(endPosition);
                return b18;
            } else if (type == f17805C) {
                Id3Frame a8 = m19388a(ilst, endPosition);
                ilst.mo26118e(endPosition);
                return a8;
            }
        } finally {
            ilst.mo26118e(endPosition);
        }
        String str = "MetadataUtil";
        StringBuilder sb = new StringBuilder();
        sb.append("Skipped unknown metadata entry: ");
        sb.append(C8290c.m19287a(type));
        C8526n.m20529a(str, sb.toString());
        ilst.mo26118e(endPosition);
        return null;
    }

    /* renamed from: a */
    public static MdtaMetadataEntry m19384a(C8535t ilst, int endPosition, String key) {
        while (true) {
            int c = ilst.mo26113c();
            int atomPosition = c;
            if (c >= endPosition) {
                return null;
            }
            int atomSize = ilst.mo26119f();
            if (ilst.mo26119f() == C8290c.f17619Ga) {
                int typeIndicator = ilst.mo26119f();
                int localeIndicator = ilst.mo26119f();
                int dataSize = atomSize - 16;
                byte[] value = new byte[dataSize];
                ilst.mo26110a(value, 0, dataSize);
                return new MdtaMetadataEntry(key, value, localeIndicator, typeIndicator);
            }
            ilst.mo26118e(atomPosition + atomSize);
        }
    }

    /* renamed from: b */
    private static TextInformationFrame m19391b(int type, String id, C8535t data) {
        int atomSize = data.mo26119f();
        if (data.mo26119f() == C8290c.f17619Ga) {
            data.mo26120f(8);
            return new TextInformationFrame(id, null, data.mo26105a(atomSize - 16));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Failed to parse text attribute: ");
        sb.append(C8290c.m19287a(type));
        C8526n.m20534d("MetadataUtil", sb.toString());
        return null;
    }

    /* renamed from: a */
    private static CommentFrame m19386a(int type, C8535t data) {
        int atomSize = data.mo26119f();
        if (data.mo26119f() == C8290c.f17619Ga) {
            data.mo26120f(8);
            String value = data.mo26105a(atomSize - 16);
            return new CommentFrame("und", value, value);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Failed to parse comment attribute: ");
        sb.append(C8290c.m19287a(type));
        C8526n.m20534d("MetadataUtil", sb.toString());
        return null;
    }

    /* renamed from: a */
    private static Id3Frame m19387a(int type, String id, C8535t data, boolean isTextInformationFrame, boolean isBoolean) {
        Id3Frame id3Frame;
        int value = m19393d(data);
        if (isBoolean) {
            value = Math.min(1, value);
        }
        if (value >= 0) {
            if (isTextInformationFrame) {
                id3Frame = new TextInformationFrame(id, null, Integer.toString(value));
            } else {
                id3Frame = new CommentFrame("und", id, Integer.toString(value));
            }
            return id3Frame;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Failed to parse uint8 attribute: ");
        sb.append(C8290c.m19287a(type));
        C8526n.m20534d("MetadataUtil", sb.toString());
        return null;
    }

    /* renamed from: a */
    private static TextInformationFrame m19389a(int type, String attributeName, C8535t data) {
        int atomSize = data.mo26119f();
        if (data.mo26119f() == C8290c.f17619Ga && atomSize >= 22) {
            data.mo26120f(10);
            int index = data.mo26137w();
            if (index > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(index);
                String value = sb.toString();
                int count = data.mo26137w();
                if (count > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(value);
                    sb2.append("/");
                    sb2.append(count);
                    value = sb2.toString();
                }
                return new TextInformationFrame(attributeName, null, value);
            }
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Failed to parse index/count attribute: ");
        sb3.append(C8290c.m19287a(type));
        C8526n.m20534d("MetadataUtil", sb3.toString());
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001c  */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.exoplayer2.metadata.id3.TextInformationFrame m19392c(com.google.android.exoplayer2.util.C8535t r5) {
        /*
            int r0 = m19393d(r5)
            r1 = 0
            if (r0 <= 0) goto L_0x0011
            java.lang.String[] r2 = f17806D
            int r3 = r2.length
            if (r0 > r3) goto L_0x0011
            int r3 = r0 + -1
            r2 = r2[r3]
            goto L_0x0012
        L_0x0011:
            r2 = r1
        L_0x0012:
            if (r2 == 0) goto L_0x001c
            com.google.android.exoplayer2.metadata.id3.TextInformationFrame r3 = new com.google.android.exoplayer2.metadata.id3.TextInformationFrame
            java.lang.String r4 = "TCON"
            r3.<init>(r4, r1, r2)
            return r3
        L_0x001c:
            java.lang.String r3 = "MetadataUtil"
            java.lang.String r4 = "Failed to parse standard genre code"
            com.google.android.exoplayer2.util.C8526n.m20534d(r3, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.C8308j.m19392c(com.google.android.exoplayer2.util.t):com.google.android.exoplayer2.metadata.id3.TextInformationFrame");
    }

    /* renamed from: b */
    private static ApicFrame m19390b(C8535t data) {
        int atomSize = data.mo26119f();
        String str = "MetadataUtil";
        if (data.mo26119f() == C8290c.f17619Ga) {
            int flags = C8290c.m19288b(data.mo26119f());
            String mimeType = flags == 13 ? "image/jpeg" : flags == 14 ? "image/png" : null;
            if (mimeType == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unrecognized cover art flags: ");
                sb.append(flags);
                C8526n.m20534d(str, sb.toString());
                return null;
            }
            data.mo26120f(4);
            byte[] pictureData = new byte[(atomSize - 16)];
            data.mo26110a(pictureData, 0, pictureData.length);
            return new ApicFrame(mimeType, null, 3, pictureData);
        }
        C8526n.m20534d(str, "Failed to parse cover art attribute");
        return null;
    }

    /* renamed from: a */
    private static Id3Frame m19388a(C8535t data, int endPosition) {
        String domain = null;
        String name = null;
        int dataAtomPosition = -1;
        int dataAtomSize = -1;
        while (data.mo26113c() < endPosition) {
            int atomPosition = data.mo26113c();
            int atomSize = data.mo26119f();
            int atomType = data.mo26119f();
            data.mo26120f(4);
            if (atomType == C8290c.f17615Ea) {
                domain = data.mo26105a(atomSize - 12);
            } else if (atomType == C8290c.f17617Fa) {
                name = data.mo26105a(atomSize - 12);
            } else {
                if (atomType == C8290c.f17619Ga) {
                    dataAtomPosition = atomPosition;
                    dataAtomSize = atomSize;
                }
                data.mo26120f(atomSize - 12);
            }
        }
        if (domain == null || name == null || dataAtomPosition == -1) {
            return null;
        }
        data.mo26118e(dataAtomPosition);
        data.mo26120f(16);
        return new InternalFrame(domain, name, data.mo26105a(dataAtomSize - 16));
    }

    /* renamed from: d */
    private static int m19393d(C8535t data) {
        data.mo26120f(4);
        if (data.mo26119f() == C8290c.f17619Ga) {
            data.mo26120f(8);
            return data.mo26131q();
        }
        C8526n.m20534d("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }
}
