package com.fyber.inneractive.sdk.util;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.fyber.inneractive.sdk.util.x */
public final class C8040x {

    /* renamed from: a */
    static final String[][] f16386a = {new String[]{"nbsp", "160"}, new String[]{"iexcl", "161"}, new String[]{"cent", "162"}, new String[]{"pound", "163"}, new String[]{"curren", "164"}, new String[]{"yen", "165"}, new String[]{"brvbar", "166"}, new String[]{"sect", "167"}, new String[]{"uml", "168"}, new String[]{"copy", "169"}, new String[]{"ordf", "170"}, new String[]{"laquo", "171"}, new String[]{"not", "172"}, new String[]{"shy", "173"}, new String[]{"reg", "174"}, new String[]{"macr", "175"}, new String[]{"deg", "176"}, new String[]{"plusmn", "177"}, new String[]{"sup2", "178"}, new String[]{"sup3", "179"}, new String[]{"acute", "180"}, new String[]{"micro", "181"}, new String[]{"para", "182"}, new String[]{"middot", "183"}, new String[]{"cedil", "184"}, new String[]{"sup1", "185"}, new String[]{"ordm", "186"}, new String[]{"raquo", "187"}, new String[]{"frac14", "188"}, new String[]{"frac12", "189"}, new String[]{"frac34", "190"}, new String[]{"iquest", "191"}, new String[]{"Agrave", "192"}, new String[]{"Aacute", "193"}, new String[]{"Acirc", "194"}, new String[]{"Atilde", "195"}, new String[]{"Auml", "196"}, new String[]{"Aring", "197"}, new String[]{"AElig", "198"}, new String[]{"Ccedil", "199"}, new String[]{"Egrave", "200"}, new String[]{"Eacute", "201"}, new String[]{"Ecirc", "202"}, new String[]{"Euml", "203"}, new String[]{"Igrave", "204"}, new String[]{"Iacute", "205"}, new String[]{"Icirc", "206"}, new String[]{"Iuml", "207"}, new String[]{"ETH", "208"}, new String[]{"Ntilde", "209"}, new String[]{"Ograve", "210"}, new String[]{"Oacute", "211"}, new String[]{"Ocirc", "212"}, new String[]{"Otilde", "213"}, new String[]{"Ouml", "214"}, new String[]{"times", "215"}, new String[]{"Oslash", "216"}, new String[]{"Ugrave", "217"}, new String[]{"Uacute", "218"}, new String[]{"Ucirc", "219"}, new String[]{"Uuml", "220"}, new String[]{"Yacute", "221"}, new String[]{"THORN", "222"}, new String[]{"szlig", "223"}, new String[]{"agrave", "224"}, new String[]{"aacute", "225"}, new String[]{"acirc", "226"}, new String[]{"atilde", "227"}, new String[]{"auml", "228"}, new String[]{"aring", "229"}, new String[]{"aelig", "230"}, new String[]{"ccedil", "231"}, new String[]{"egrave", "232"}, new String[]{"eacute", "233"}, new String[]{"ecirc", "234"}, new String[]{"euml", "235"}, new String[]{"igrave", "236"}, new String[]{"iacute", "237"}, new String[]{"icirc", "238"}, new String[]{"iuml", "239"}, new String[]{"eth", "240"}, new String[]{"ntilde", "241"}, new String[]{"ograve", "242"}, new String[]{"oacute", "243"}, new String[]{"ocirc", "244"}, new String[]{"otilde", "245"}, new String[]{"ouml", "246"}, new String[]{"divide", "247"}, new String[]{"oslash", "248"}, new String[]{"ugrave", "249"}, new String[]{"uacute", "250"}, new String[]{"ucirc", "251"}, new String[]{"uuml", "252"}, new String[]{"yacute", "253"}, new String[]{"thorn", "254"}, new String[]{"yuml", "255"}};

    /* renamed from: b */
    static final String[][] f16387b;

    /* renamed from: c */
    public static final C8040x f16388c;

    /* renamed from: d */
    public static final C8040x f16389d;

    /* renamed from: e */
    public static final C8040x f16390e;

    /* renamed from: g */
    private static final String[][] f16391g = {new String[]{"quot", "34"}, new String[]{"amp", "38"}, new String[]{"lt", "60"}, new String[]{"gt", "62"}};

    /* renamed from: h */
    private static final String[][] f16392h = {new String[]{"apos", "39"}};

    /* renamed from: f */
    C8041a f16393f = new C8042b();

    /* renamed from: com.fyber.inneractive.sdk.util.x$a */
    interface C8041a {
        /* renamed from: a */
        int mo24873a(String str);

        /* renamed from: a */
        void mo24874a(String str, int i);
    }

    /* renamed from: com.fyber.inneractive.sdk.util.x$b */
    static class C8042b extends C8043c {

        /* renamed from: a */
        private int f16394a = Opcodes.ACC_NATIVE;

        C8042b() {
        }
    }

    /* renamed from: com.fyber.inneractive.sdk.util.x$c */
    static class C8043c implements C8041a {

        /* renamed from: a */
        private Map f16395a = new HashMap();

        /* renamed from: b */
        private C8044y f16396b = new C8044y();

        C8043c() {
        }

        /* renamed from: a */
        public final void mo24874a(String str, int i) {
            this.f16395a.put(str, Integer.valueOf(i));
            this.f16396b.mo24875a(i, str);
        }

        /* renamed from: a */
        public final int mo24873a(String str) {
            Object obj = this.f16395a.get(str);
            if (obj == null) {
                return -1;
            }
            return ((Integer) obj).intValue();
        }
    }

    static {
        String[][] strArr = new String[Opcodes.DCMPL][];
        strArr[0] = new String[]{"fnof", "402"};
        strArr[1] = new String[]{"Alpha", "913"};
        strArr[2] = new String[]{"Beta", "914"};
        strArr[3] = new String[]{"Gamma", "915"};
        strArr[4] = new String[]{"Delta", "916"};
        strArr[5] = new String[]{"Epsilon", "917"};
        strArr[6] = new String[]{"Zeta", "918"};
        strArr[7] = new String[]{"Eta", "919"};
        strArr[8] = new String[]{"Theta", "920"};
        strArr[9] = new String[]{"Iota", "921"};
        strArr[10] = new String[]{"Kappa", "922"};
        strArr[11] = new String[]{"Lambda", "923"};
        strArr[12] = new String[]{"Mu", "924"};
        strArr[13] = new String[]{"Nu", "925"};
        strArr[14] = new String[]{"Xi", "926"};
        strArr[15] = new String[]{"Omicron", "927"};
        strArr[16] = new String[]{"Pi", "928"};
        strArr[17] = new String[]{"Rho", "929"};
        strArr[18] = new String[]{"Sigma", "931"};
        strArr[19] = new String[]{"Tau", "932"};
        strArr[20] = new String[]{"Upsilon", "933"};
        strArr[21] = new String[]{"Phi", "934"};
        strArr[22] = new String[]{"Chi", "935"};
        strArr[23] = new String[]{"Psi", "936"};
        strArr[24] = new String[]{"Omega", "937"};
        strArr[25] = new String[]{"alpha", "945"};
        strArr[26] = new String[]{"beta", "946"};
        strArr[27] = new String[]{"gamma", "947"};
        strArr[28] = new String[]{"delta", "948"};
        strArr[29] = new String[]{"epsilon", "949"};
        strArr[30] = new String[]{"zeta", "950"};
        strArr[31] = new String[]{"eta", "951"};
        strArr[32] = new String[]{"theta", "952"};
        strArr[33] = new String[]{"iota", "953"};
        strArr[34] = new String[]{"kappa", "954"};
        strArr[35] = new String[]{"lambda", "955"};
        strArr[36] = new String[]{"mu", "956"};
        strArr[37] = new String[]{"nu", "957"};
        strArr[38] = new String[]{"xi", "958"};
        strArr[39] = new String[]{"omicron", "959"};
        strArr[40] = new String[]{"pi", "960"};
        strArr[41] = new String[]{"rho", "961"};
        strArr[42] = new String[]{"sigmaf", "962"};
        strArr[43] = new String[]{"sigma", "963"};
        strArr[44] = new String[]{"tau", "964"};
        strArr[45] = new String[]{"upsilon", "965"};
        strArr[46] = new String[]{"phi", "966"};
        strArr[47] = new String[]{"chi", "967"};
        strArr[48] = new String[]{"psi", "968"};
        strArr[49] = new String[]{"omega", "969"};
        strArr[50] = new String[]{"thetasym", "977"};
        strArr[51] = new String[]{"upsih", "978"};
        strArr[52] = new String[]{"piv", "982"};
        strArr[53] = new String[]{"bull", "8226"};
        strArr[54] = new String[]{"hellip", "8230"};
        strArr[55] = new String[]{"prime", "8242"};
        strArr[56] = new String[]{"Prime", "8243"};
        strArr[57] = new String[]{"oline", "8254"};
        strArr[58] = new String[]{"frasl", "8260"};
        strArr[59] = new String[]{"weierp", "8472"};
        strArr[60] = new String[]{"image", "8465"};
        strArr[61] = new String[]{"real", "8476"};
        strArr[62] = new String[]{"trade", "8482"};
        strArr[63] = new String[]{"alefsym", "8501"};
        strArr[64] = new String[]{"larr", "8592"};
        strArr[65] = new String[]{"uarr", "8593"};
        strArr[66] = new String[]{"rarr", "8594"};
        strArr[67] = new String[]{"darr", "8595"};
        strArr[68] = new String[]{"harr", "8596"};
        strArr[69] = new String[]{"crarr", "8629"};
        strArr[70] = new String[]{"lArr", "8656"};
        strArr[71] = new String[]{"uArr", "8657"};
        strArr[72] = new String[]{"rArr", "8658"};
        strArr[73] = new String[]{"dArr", "8659"};
        strArr[74] = new String[]{"hArr", "8660"};
        strArr[75] = new String[]{"forall", "8704"};
        strArr[76] = new String[]{"part", "8706"};
        strArr[77] = new String[]{"exist", "8707"};
        strArr[78] = new String[]{"empty", "8709"};
        strArr[79] = new String[]{"nabla", "8711"};
        strArr[80] = new String[]{"isin", "8712"};
        strArr[81] = new String[]{"notin", "8713"};
        strArr[82] = new String[]{"ni", "8715"};
        strArr[83] = new String[]{"prod", "8719"};
        strArr[84] = new String[]{"sum", "8721"};
        strArr[85] = new String[]{"minus", "8722"};
        strArr[86] = new String[]{"lowast", "8727"};
        strArr[87] = new String[]{"radic", "8730"};
        strArr[88] = new String[]{"prop", "8733"};
        strArr[89] = new String[]{"infin", "8734"};
        strArr[90] = new String[]{"ang", "8736"};
        strArr[91] = new String[]{"and", "8743"};
        strArr[92] = new String[]{"or", "8744"};
        strArr[93] = new String[]{"cap", "8745"};
        strArr[94] = new String[]{"cup", "8746"};
        strArr[95] = new String[]{"int", "8747"};
        strArr[96] = new String[]{"there4", "8756"};
        strArr[97] = new String[]{"sim", "8764"};
        strArr[98] = new String[]{"cong", "8773"};
        strArr[99] = new String[]{"asymp", "8776"};
        strArr[100] = new String[]{"ne", "8800"};
        strArr[101] = new String[]{"equiv", "8801"};
        strArr[102] = new String[]{"le", "8804"};
        strArr[103] = new String[]{"ge", "8805"};
        strArr[104] = new String[]{"sub", "8834"};
        strArr[105] = new String[]{"sup", "8835"};
        strArr[106] = new String[]{"sube", "8838"};
        strArr[107] = new String[]{"supe", "8839"};
        strArr[108] = new String[]{"oplus", "8853"};
        strArr[109] = new String[]{"otimes", "8855"};
        strArr[110] = new String[]{"perp", "8869"};
        strArr[111] = new String[]{"sdot", "8901"};
        strArr[112] = new String[]{"lceil", "8968"};
        strArr[113] = new String[]{"rceil", "8969"};
        strArr[114] = new String[]{"lfloor", "8970"};
        strArr[115] = new String[]{"rfloor", "8971"};
        strArr[116] = new String[]{"lang", "9001"};
        strArr[117] = new String[]{"rang", "9002"};
        strArr[118] = new String[]{"loz", "9674"};
        strArr[119] = new String[]{"spades", "9824"};
        strArr[120] = new String[]{"clubs", "9827"};
        strArr[121] = new String[]{"hearts", "9829"};
        strArr[122] = new String[]{"diams", "9830"};
        strArr[123] = new String[]{"OElig", "338"};
        strArr[124] = new String[]{"oelig", "339"};
        strArr[125] = new String[]{"Scaron", "352"};
        strArr[126] = new String[]{"scaron", "353"};
        strArr[127] = new String[]{"Yuml", "376"};
        strArr[128] = new String[]{"circ", "710"};
        strArr[129] = new String[]{"tilde", "732"};
        strArr[130] = new String[]{"ensp", "8194"};
        strArr[131] = new String[]{"emsp", "8195"};
        strArr[132] = new String[]{"thinsp", "8201"};
        strArr[133] = new String[]{"zwnj", "8204"};
        strArr[134] = new String[]{"zwj", "8205"};
        strArr[135] = new String[]{"lrm", "8206"};
        strArr[136] = new String[]{"rlm", "8207"};
        strArr[137] = new String[]{"ndash", "8211"};
        strArr[138] = new String[]{"mdash", "8212"};
        strArr[139] = new String[]{"lsquo", "8216"};
        strArr[140] = new String[]{"rsquo", "8217"};
        strArr[141] = new String[]{"sbquo", "8218"};
        strArr[142] = new String[]{"ldquo", "8220"};
        strArr[143] = new String[]{"rdquo", "8221"};
        strArr[144] = new String[]{"bdquo", "8222"};
        strArr[145] = new String[]{"dagger", "8224"};
        strArr[146] = new String[]{"Dagger", "8225"};
        strArr[147] = new String[]{"permil", "8240"};
        strArr[148] = new String[]{"lsaquo", "8249"};
        strArr[149] = new String[]{"rsaquo", "8250"};
        strArr[150] = new String[]{"euro", "8364"};
        f16387b = strArr;
        C8040x xVar = new C8040x();
        f16388c = xVar;
        xVar.m18133a(f16391g);
        f16388c.m18133a(f16392h);
        C8040x xVar2 = new C8040x();
        f16389d = xVar2;
        xVar2.m18133a(f16391g);
        f16389d.m18133a(f16386a);
        C8040x xVar3 = new C8040x();
        f16390e = xVar3;
        xVar3.m18133a(f16391g);
        xVar3.m18133a(f16386a);
        xVar3.m18133a(f16387b);
        xVar3.m18133a(f16392h);
    }

    /* renamed from: a */
    private void m18133a(String[][] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            this.f16393f.mo24874a(strArr[i][0], Integer.parseInt(strArr[i][1]));
        }
    }

    /* renamed from: a */
    public final String mo24872a(String str) {
        int indexOf = str.indexOf(38);
        if (indexOf < 0) {
            return str;
        }
        double length = (double) str.length();
        double length2 = (double) str.length();
        Double.isNaN(length2);
        double d = length2 * 0.1d;
        Double.isNaN(length);
        StringWriter stringWriter = new StringWriter((int) (length + d));
        try {
            m18132a(stringWriter, str, indexOf);
        } catch (IOException e) {
        }
        return stringWriter.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0088  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m18132a(java.io.Writer r11, java.lang.String r12, int r13) throws java.io.IOException {
        /*
            r10 = this;
            r0 = 0
            r11.write(r12, r0, r13)
            int r1 = r12.length()
        L_0x0008:
            if (r13 >= r1) goto L_0x0094
            char r2 = r12.charAt(r13)
            r3 = 38
            r4 = 1
            if (r2 != r3) goto L_0x008e
            int r5 = r13 + 1
            r6 = 59
            int r7 = r12.indexOf(r6, r5)
            r8 = -1
            if (r7 != r8) goto L_0x0023
            r11.write(r2)
            goto L_0x0091
        L_0x0023:
            int r9 = r12.indexOf(r3, r5)
            if (r9 == r8) goto L_0x002f
            if (r9 >= r7) goto L_0x002f
            r11.write(r2)
            goto L_0x0091
        L_0x002f:
            java.lang.String r13 = r12.substring(r5, r7)
            int r2 = r13.length()
            if (r2 <= 0) goto L_0x007b
            char r5 = r13.charAt(r0)
            r9 = 35
            if (r5 != r9) goto L_0x0073
            if (r2 <= r4) goto L_0x007b
            char r2 = r13.charAt(r4)
            r5 = 88
            if (r2 == r5) goto L_0x005d
            r5 = 120(0x78, float:1.68E-43)
            if (r2 == r5) goto L_0x005d
            java.lang.String r2 = r13.substring(r4)     // Catch:{ NumberFormatException -> 0x005b }
            r5 = 10
            int r2 = java.lang.Integer.parseInt(r2, r5)     // Catch:{ NumberFormatException -> 0x005b }
            goto L_0x0069
        L_0x005b:
            r2 = move-exception
            goto L_0x0070
        L_0x005d:
            r2 = 2
            java.lang.String r2 = r13.substring(r2)     // Catch:{ NumberFormatException -> 0x005b }
            r5 = 16
            int r2 = java.lang.Integer.parseInt(r2, r5)     // Catch:{ NumberFormatException -> 0x005b }
        L_0x0069:
            r5 = 65535(0xffff, float:9.1834E-41)
            if (r2 <= r5) goto L_0x006f
            r2 = -1
        L_0x006f:
            goto L_0x007c
        L_0x0070:
            r2 = -1
            goto L_0x007c
        L_0x0073:
            com.fyber.inneractive.sdk.util.x$a r2 = r10.f16393f
            int r2 = r2.mo24873a(r13)
            goto L_0x007c
        L_0x007b:
            r2 = -1
        L_0x007c:
            if (r2 != r8) goto L_0x0088
            r11.write(r3)
            r11.write(r13)
            r11.write(r6)
            goto L_0x008b
        L_0x0088:
            r11.write(r2)
        L_0x008b:
            r13 = r7
            goto L_0x0091
        L_0x008e:
            r11.write(r2)
        L_0x0091:
            int r13 = r13 + r4
            goto L_0x0008
        L_0x0094:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.util.C8040x.m18132a(java.io.Writer, java.lang.String, int):void");
    }
}
