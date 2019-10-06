package com.google.android.gms.internal.ads;

import android.util.Log;
import com.google.android.gms.internal.ads.zzpo.zza;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.google.android.gms.internal.ads.ss */
final class C9720ss {

    /* renamed from: A */
    private static final int f22971A = zzsy.m31156b("sosn");

    /* renamed from: B */
    private static final int f22972B = zzsy.m31156b("tvsh");

    /* renamed from: C */
    private static final int f22973C = zzsy.m31156b("----");

    /* renamed from: D */
    private static final String[] f22974D;

    /* renamed from: a */
    private static final int f22975a = zzsy.m31156b("nam");

    /* renamed from: b */
    private static final int f22976b = zzsy.m31156b("trk");

    /* renamed from: c */
    private static final int f22977c = zzsy.m31156b("cmt");

    /* renamed from: d */
    private static final int f22978d = zzsy.m31156b("day");

    /* renamed from: e */
    private static final int f22979e = zzsy.m31156b("ART");

    /* renamed from: f */
    private static final int f22980f = zzsy.m31156b("too");

    /* renamed from: g */
    private static final int f22981g = zzsy.m31156b("alb");

    /* renamed from: h */
    private static final int f22982h = zzsy.m31156b("com");

    /* renamed from: i */
    private static final int f22983i = zzsy.m31156b("wrt");

    /* renamed from: j */
    private static final int f22984j = zzsy.m31156b("lyr");

    /* renamed from: k */
    private static final int f22985k = zzsy.m31156b("gen");

    /* renamed from: l */
    private static final int f22986l = zzsy.m31156b("covr");

    /* renamed from: m */
    private static final int f22987m = zzsy.m31156b("gnre");

    /* renamed from: n */
    private static final int f22988n = zzsy.m31156b("grp");

    /* renamed from: o */
    private static final int f22989o = zzsy.m31156b("disk");

    /* renamed from: p */
    private static final int f22990p = zzsy.m31156b("trkn");

    /* renamed from: q */
    private static final int f22991q = zzsy.m31156b("tmpo");

    /* renamed from: r */
    private static final int f22992r = zzsy.m31156b("cpil");

    /* renamed from: s */
    private static final int f22993s = zzsy.m31156b("aART");

    /* renamed from: t */
    private static final int f22994t = zzsy.m31156b("sonm");

    /* renamed from: u */
    private static final int f22995u = zzsy.m31156b("soal");

    /* renamed from: v */
    private static final int f22996v = zzsy.m31156b("soar");

    /* renamed from: w */
    private static final int f22997w = zzsy.m31156b("soaa");

    /* renamed from: x */
    private static final int f22998x = zzsy.m31156b("soco");

    /* renamed from: y */
    private static final int f22999y = zzsy.m31156b("rtng");

    /* renamed from: z */
    private static final int f23000z = zzsy.m31156b("pgap");

    /* renamed from: a */
    public static zza m24080a(zzst zzst) {
        zza zza;
        int b = zzst.mo32198b() + zzst.mo32202d();
        int d = zzst.mo32202d();
        int i = d >>> 24;
        String str = "und";
        String str2 = "TCON";
        String str3 = "MetadataUtil";
        zza zza2 = null;
        if (i == 169 || i == 65533) {
            int i2 = 16777215 & d;
            if (i2 == f22977c) {
                int d2 = zzst.mo32202d();
                if (zzst.mo32202d() == C9481hs.f22442Fa) {
                    zzst.mo32201c(8);
                    String e = zzst.mo32205e(d2 - 16);
                    zza2 = new zzps(str, e, e);
                } else {
                    String str4 = "Failed to parse comment attribute: ";
                    String valueOf = String.valueOf(C9481hs.m23683c(d));
                    Log.w(str3, valueOf.length() != 0 ? str4.concat(valueOf) : new String(str4));
                }
                zzst.mo32199b(b);
                return zza2;
            }
            if (i2 != f22975a) {
                if (i2 != f22976b) {
                    if (i2 != f22982h) {
                        if (i2 != f22983i) {
                            if (i2 == f22978d) {
                                zzpw a = m24082a(d, "TDRC", zzst);
                                zzst.mo32199b(b);
                                return a;
                            } else if (i2 == f22979e) {
                                zzpw a2 = m24082a(d, "TPE1", zzst);
                                zzst.mo32199b(b);
                                return a2;
                            } else if (i2 == f22980f) {
                                zzpw a3 = m24082a(d, "TSSE", zzst);
                                zzst.mo32199b(b);
                                return a3;
                            } else if (i2 == f22981g) {
                                zzpw a4 = m24082a(d, "TALB", zzst);
                                zzst.mo32199b(b);
                                return a4;
                            } else if (i2 == f22984j) {
                                zzpw a5 = m24082a(d, "USLT", zzst);
                                zzst.mo32199b(b);
                                return a5;
                            } else if (i2 == f22985k) {
                                zzpw a6 = m24082a(d, str2, zzst);
                                zzst.mo32199b(b);
                                return a6;
                            } else if (i2 == f22988n) {
                                zzpw a7 = m24082a(d, "TIT1", zzst);
                                zzst.mo32199b(b);
                                return a7;
                            }
                        }
                    }
                    zzpw a8 = m24082a(d, "TCOM", zzst);
                    zzst.mo32199b(b);
                    return a8;
                }
            }
            zzpw a9 = m24082a(d, "TIT2", zzst);
            zzst.mo32199b(b);
            return a9;
        }
        try {
            if (d == f22987m) {
                int b2 = m24083b(zzst);
                String str5 = (b2 <= 0 || b2 > f22974D.length) ? null : f22974D[b2 - 1];
                if (str5 != null) {
                    zza = new zzpw(str2, null, str5);
                } else {
                    Log.w(str3, "Failed to parse standard genre code");
                    zza = null;
                }
                return zza;
            } else if (d == f22989o) {
                zzpw b3 = m24084b(d, "TPOS", zzst);
                zzst.mo32199b(b);
                return b3;
            } else if (d == f22990p) {
                zzpw b4 = m24084b(d, "TRCK", zzst);
                zzst.mo32199b(b);
                return b4;
            } else if (d == f22991q) {
                zzpv a10 = m24081a(d, "TBPM", zzst, true, false);
                zzst.mo32199b(b);
                return a10;
            } else if (d == f22992r) {
                zzpv a11 = m24081a(d, "TCMP", zzst, true, true);
                zzst.mo32199b(b);
                return a11;
            } else if (d == f22986l) {
                int d3 = zzst.mo32202d();
                if (zzst.mo32202d() == C9481hs.f22442Fa) {
                    int a12 = C9481hs.m23681a(zzst.mo32202d());
                    String str6 = a12 == 13 ? "image/jpeg" : a12 == 14 ? "image/png" : null;
                    if (str6 == null) {
                        StringBuilder sb = new StringBuilder(41);
                        sb.append("Unrecognized cover art flags: ");
                        sb.append(a12);
                        Log.w(str3, sb.toString());
                    } else {
                        zzst.mo32201c(4);
                        byte[] bArr = new byte[(d3 - 16)];
                        zzst.mo32197a(bArr, 0, bArr.length);
                        zza2 = new zzpq(str6, null, 3, bArr);
                    }
                } else {
                    Log.w(str3, "Failed to parse cover art attribute");
                }
                zzst.mo32199b(b);
                return zza2;
            } else if (d == f22993s) {
                zzpw a13 = m24082a(d, "TPE2", zzst);
                zzst.mo32199b(b);
                return a13;
            } else if (d == f22994t) {
                zzpw a14 = m24082a(d, "TSOT", zzst);
                zzst.mo32199b(b);
                return a14;
            } else if (d == f22995u) {
                zzpw a15 = m24082a(d, "TSO2", zzst);
                zzst.mo32199b(b);
                return a15;
            } else if (d == f22996v) {
                zzpw a16 = m24082a(d, "TSOA", zzst);
                zzst.mo32199b(b);
                return a16;
            } else if (d == f22997w) {
                zzpw a17 = m24082a(d, "TSOP", zzst);
                zzst.mo32199b(b);
                return a17;
            } else if (d == f22998x) {
                zzpw a18 = m24082a(d, "TSOC", zzst);
                zzst.mo32199b(b);
                return a18;
            } else if (d == f22999y) {
                zzpv a19 = m24081a(d, "ITUNESADVISORY", zzst, false, false);
                zzst.mo32199b(b);
                return a19;
            } else if (d == f23000z) {
                zzpv a20 = m24081a(d, "ITUNESGAPLESS", zzst, false, true);
                zzst.mo32199b(b);
                return a20;
            } else if (d == f22971A) {
                zzpw a21 = m24082a(d, "TVSHOWSORT", zzst);
                zzst.mo32199b(b);
                return a21;
            } else if (d == f22972B) {
                zzpw a22 = m24082a(d, "TVSHOW", zzst);
                zzst.mo32199b(b);
                return a22;
            } else if (d == f22973C) {
                Object obj = null;
                String str7 = null;
                int i3 = -1;
                int i4 = -1;
                while (zzst.mo32198b() < b) {
                    int b5 = zzst.mo32198b();
                    int d4 = zzst.mo32202d();
                    int d5 = zzst.mo32202d();
                    zzst.mo32201c(4);
                    if (d5 == C9481hs.f22438Da) {
                        obj = zzst.mo32205e(d4 - 12);
                    } else if (d5 == C9481hs.f22440Ea) {
                        str7 = zzst.mo32205e(d4 - 12);
                    } else {
                        if (d5 == C9481hs.f22442Fa) {
                            i3 = b5;
                            i4 = d4;
                        }
                        zzst.mo32201c(d4 - 12);
                    }
                }
                if ("com.apple.iTunes".equals(obj) && "iTunSMPB".equals(str7)) {
                    if (i3 != -1) {
                        zzst.mo32199b(i3);
                        zzst.mo32201c(16);
                        zza2 = new zzps(str, str7, zzst.mo32205e(i4 - 16));
                    }
                }
                zzst.mo32199b(b);
                return zza2;
            }
        } finally {
            zzst.mo32199b(b);
        }
        String str8 = "Skipped unknown metadata entry: ";
        String valueOf2 = String.valueOf(C9481hs.m23683c(d));
        Log.d(str3, valueOf2.length() != 0 ? str8.concat(valueOf2) : new String(str8));
        zzst.mo32199b(b);
        return null;
    }

    /* renamed from: a */
    private static zzpw m24082a(int i, String str, zzst zzst) {
        int d = zzst.mo32202d();
        if (zzst.mo32202d() == C9481hs.f22442Fa) {
            zzst.mo32201c(8);
            return new zzpw(str, null, zzst.mo32205e(d - 16));
        }
        String str2 = "Failed to parse text attribute: ";
        String valueOf = String.valueOf(C9481hs.m23683c(i));
        Log.w("MetadataUtil", valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        return null;
    }

    /* renamed from: a */
    private static zzpv m24081a(int i, String str, zzst zzst, boolean z, boolean z2) {
        int b = m24083b(zzst);
        if (z2) {
            b = Math.min(1, b);
        }
        if (b < 0) {
            String str2 = "Failed to parse uint8 attribute: ";
            String valueOf = String.valueOf(C9481hs.m23683c(i));
            Log.w("MetadataUtil", valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            return null;
        } else if (z) {
            return new zzpw(str, null, Integer.toString(b));
        } else {
            return new zzps("und", str, Integer.toString(b));
        }
    }

    /* renamed from: b */
    private static zzpw m24084b(int i, String str, zzst zzst) {
        int d = zzst.mo32202d();
        if (zzst.mo32202d() == C9481hs.f22442Fa && d >= 22) {
            zzst.mo32201c(10);
            int h = zzst.mo32208h();
            if (h > 0) {
                StringBuilder sb = new StringBuilder(11);
                sb.append(h);
                String sb2 = sb.toString();
                int h2 = zzst.mo32208h();
                if (h2 > 0) {
                    String valueOf = String.valueOf(sb2);
                    StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf).length() + 12);
                    sb3.append(valueOf);
                    sb3.append("/");
                    sb3.append(h2);
                    sb2 = sb3.toString();
                }
                return new zzpw(str, null, sb2);
            }
        }
        String str2 = "Failed to parse index/count attribute: ";
        String valueOf2 = String.valueOf(C9481hs.m23683c(i));
        Log.w("MetadataUtil", valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2));
        return null;
    }

    /* renamed from: b */
    private static int m24083b(zzst zzst) {
        zzst.mo32201c(4);
        if (zzst.mo32202d() == C9481hs.f22442Fa) {
            zzst.mo32201c(8);
            return zzst.mo32207g();
        }
        Log.w("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }

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
        f22974D = strArr;
    }
}
