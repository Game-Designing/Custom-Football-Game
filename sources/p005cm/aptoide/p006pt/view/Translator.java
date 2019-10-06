package p005cm.aptoide.p006pt.view;

import android.content.Context;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;

@Deprecated
/* renamed from: cm.aptoide.pt.view.Translator */
public final class Translator {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4929393324449559483L, "cm/aptoide/pt/view/Translator", 316);
        $jacocoData = probes;
        return probes;
    }

    public Translator() {
        $jacocoInit()[0] = true;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String translate(java.lang.String r21, android.content.Context r22, java.lang.String r23) {
        /*
            r0 = r21
            r1 = r22
            boolean[] r2 = $jacocoInit()
            r3 = 1
            if (r0 != 0) goto L_0x000e
            r2[r3] = r3
            return r0
        L_0x000e:
            r4 = 0
            r5 = 2
            r2[r5] = r3
            r6 = -1
            int r7 = r21.hashCode()
            r8 = 22
            r9 = 71
            r10 = 51
            r11 = 16
            r12 = 17
            r13 = 6
            r14 = 92
            r15 = 67
            r16 = 95
            r17 = 86
            r18 = 87
            r19 = 41
            r20 = 3
            switch(r7) {
                case -2137395588: goto L_0x0890;
                case -2118305922: goto L_0x087c;
                case -2061360222: goto L_0x0868;
                case -2031379405: goto L_0x0854;
                case -2012006303: goto L_0x0845;
                case -1892828066: goto L_0x0830;
                case -1854741650: goto L_0x081a;
                case -1813183603: goto L_0x0804;
                case -1811893345: goto L_0x07ee;
                case -1808199726: goto L_0x07da;
                case -1791609619: goto L_0x07c4;
                case -1790955542: goto L_0x07ae;
                case -1781830854: goto L_0x0798;
                case -1781592413: goto L_0x0782;
                case -1689537935: goto L_0x076c;
                case -1644804512: goto L_0x0756;
                case -1546396700: goto L_0x0740;
                case -1530360837: goto L_0x072a;
                case -1524721952: goto L_0x0714;
                case -1406873644: goto L_0x06fe;
                case -1283672907: goto L_0x06e8;
                case -1249904381: goto L_0x06d2;
                case -1238034679: goto L_0x06be;
                case -1113305055: goto L_0x06aa;
                case -1112902953: goto L_0x0694;
                case -1094268730: goto L_0x067e;
                case -1082186784: goto L_0x066a;
                case -1073649596: goto L_0x0654;
                case -1062937150: goto L_0x063e;
                case -1049499468: goto L_0x0628;
                case -1039412629: goto L_0x0612;
                case -978294581: goto L_0x05fd;
                case -961061219: goto L_0x05e7;
                case -955424387: goto L_0x05d3;
                case -897418454: goto L_0x05bd;
                case -857147262: goto L_0x05a7;
                case -733713896: goto L_0x0591;
                case -704707964: goto L_0x057b;
                case -658248308: goto L_0x0565;
                case -579226340: goto L_0x054f;
                case -570295317: goto L_0x0539;
                case -559276497: goto L_0x0524;
                case -352711613: goto L_0x050e;
                case -335032828: goto L_0x04f8;
                case -279816824: goto L_0x04e2;
                case -236322890: goto L_0x04cc;
                case -226683580: goto L_0x04b6;
                case -161518821: goto L_0x04a0;
                case -140581837: goto L_0x048a;
                case 65921: goto L_0x0474;
                case 2092848: goto L_0x045e;
                case 2126339: goto L_0x0448;
                case 2255103: goto L_0x0435;
                case 2702122: goto L_0x041f;
                case 64356038: goto L_0x0409;
                case 68567713: goto L_0x03f3;
                case 74710533: goto L_0x03dd;
                case 80992699: goto L_0x03c7;
                case 111439712: goto L_0x03b1;
                case 276964342: goto L_0x039b;
                case 357128477: goto L_0x0385;
                case 471515264: goto L_0x036f;
                case 523718601: goto L_0x035a;
                case 640838532: goto L_0x0344;
                case 701694503: goto L_0x032e;
                case 710918574: goto L_0x0318;
                case 811395002: goto L_0x0302;
                case 857024639: goto L_0x02ec;
                case 891620482: goto L_0x02d7;
                case 927605132: goto L_0x02c1;
                case 983921684: goto L_0x02ab;
                case 994268114: goto L_0x0295;
                case 1078812459: goto L_0x027f;
                case 1101527363: goto L_0x026b;
                case 1188177138: goto L_0x0257;
                case 1298968424: goto L_0x0241;
                case 1309873904: goto L_0x022b;
                case 1413249359: goto L_0x0215;
                case 1423561139: goto L_0x01ff;
                case 1430223018: goto L_0x01ed;
                case 1459599685: goto L_0x01d7;
                case 1529205357: goto L_0x01c1;
                case 1559628443: goto L_0x01ab;
                case 1639783301: goto L_0x0195;
                case 1713211272: goto L_0x017f;
                case 1716292629: goto L_0x016b;
                case 1753516375: goto L_0x0155;
                case 1785707127: goto L_0x013f;
                case 1852442515: goto L_0x0129;
                case 1855032658: goto L_0x0113;
                case 1887347784: goto L_0x00fd;
                case 1942241885: goto L_0x00e7;
                case 1955883606: goto L_0x00d1;
                case 1969221936: goto L_0x00bb;
                case 2011265045: goto L_0x00a5;
                case 2011276171: goto L_0x008f;
                case 2024015256: goto L_0x0079;
                case 2043863915: goto L_0x0063;
                case 2060928108: goto L_0x004d;
                case 2096973700: goto L_0x0037;
                default: goto L_0x0033;
            }
        L_0x0033:
            r2[r20] = r3
            goto L_0x08a0
        L_0x0037:
            java.lang.String r5 = "Family"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x0045
            r5 = 114(0x72, float:1.6E-43)
            r2[r5] = r3
            goto L_0x08a0
        L_0x0045:
            r5 = 55
            r6 = 115(0x73, float:1.61E-43)
            r2[r6] = r3
            goto L_0x08a1
        L_0x004d:
            java.lang.String r5 = "Spend your AppCoins"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x005b
            r5 = 186(0xba, float:2.6E-43)
            r2[r5] = r3
            goto L_0x08a0
        L_0x005b:
            r5 = 91
            r6 = 187(0xbb, float:2.62E-43)
            r2[r6] = r3
            goto L_0x08a1
        L_0x0063:
            java.lang.String r5 = "Latest Apps"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x0071
            r5 = 150(0x96, float:2.1E-43)
            r2[r5] = r3
            goto L_0x08a0
        L_0x0071:
            r5 = 73
            r6 = 151(0x97, float:2.12E-43)
            r2[r6] = r3
            goto L_0x08a1
        L_0x0079:
            java.lang.String r5 = "Comics"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x0087
            r5 = 64
            r2[r5] = r3
            goto L_0x08a0
        L_0x0087:
            r5 = 30
            r6 = 65
            r2[r6] = r3
            goto L_0x08a1
        L_0x008f:
            java.lang.String r5 = "Casual"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x009d
            r5 = 142(0x8e, float:1.99E-43)
            r2[r5] = r3
            goto L_0x08a0
        L_0x009d:
            r5 = 69
            r6 = 143(0x8f, float:2.0E-43)
            r2[r6] = r3
            goto L_0x08a1
        L_0x00a5:
            java.lang.String r5 = "Casino"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x00b3
            r5 = 108(0x6c, float:1.51E-43)
            r2[r5] = r3
            goto L_0x08a0
        L_0x00b3:
            r5 = 52
            r6 = 109(0x6d, float:1.53E-43)
            r2[r6] = r3
            goto L_0x08a1
        L_0x00bb:
            java.lang.String r5 = "Arcade"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x00c9
            r5 = 122(0x7a, float:1.71E-43)
            r2[r5] = r3
            goto L_0x08a0
        L_0x00c9:
            r5 = 59
            r6 = 123(0x7b, float:1.72E-43)
            r2[r6] = r3
            goto L_0x08a1
        L_0x00d1:
            java.lang.String r5 = "Action"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x00df
            r5 = 110(0x6e, float:1.54E-43)
            r2[r5] = r3
            goto L_0x08a0
        L_0x00df:
            r5 = 53
            r6 = 111(0x6f, float:1.56E-43)
            r2[r6] = r3
            goto L_0x08a1
        L_0x00e7:
            java.lang.String r5 = "Play-it!"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x00f5
            r5 = 166(0xa6, float:2.33E-43)
            r2[r5] = r3
            goto L_0x08a0
        L_0x00f5:
            r5 = 81
            r6 = 167(0xa7, float:2.34E-43)
            r2[r6] = r3
            goto L_0x08a1
        L_0x00fd:
            java.lang.String r5 = "Editor's Choice"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x010b
            r5 = 170(0xaa, float:2.38E-43)
            r2[r5] = r3
            goto L_0x08a0
        L_0x010b:
            r5 = 83
            r6 = 171(0xab, float:2.4E-43)
            r2[r6] = r3
            goto L_0x08a1
        L_0x0113:
            java.lang.String r5 = "Apps for Kids"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x0121
            r5 = 156(0x9c, float:2.19E-43)
            r2[r5] = r3
            goto L_0x08a0
        L_0x0121:
            r5 = 76
            r6 = 157(0x9d, float:2.2E-43)
            r2[r6] = r3
            goto L_0x08a1
        L_0x0129:
            java.lang.String r5 = "Strategy"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x0137
            r5 = 112(0x70, float:1.57E-43)
            r2[r5] = r3
            goto L_0x08a0
        L_0x0137:
            r5 = 54
            r6 = 113(0x71, float:1.58E-43)
            r2[r6] = r3
            goto L_0x08a1
        L_0x013f:
            java.lang.String r5 = "Top Apps in this store"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x014d
            r5 = 154(0x9a, float:2.16E-43)
            r2[r5] = r3
            goto L_0x08a0
        L_0x014d:
            r5 = 75
            r6 = 155(0x9b, float:2.17E-43)
            r2[r6] = r3
            goto L_0x08a1
        L_0x0155:
            java.lang.String r5 = "Recommended Stores"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x0163
            r5 = 180(0xb4, float:2.52E-43)
            r2[r5] = r3
            goto L_0x08a0
        L_0x0163:
            r5 = 88
            r6 = 181(0xb5, float:2.54E-43)
            r2[r6] = r3
            goto L_0x08a1
        L_0x016b:
            java.lang.String r5 = "Lifestyle"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x0177
            r2[r14] = r3
            goto L_0x08a0
        L_0x0177:
            r5 = 44
            r6 = 93
            r2[r6] = r3
            goto L_0x08a1
        L_0x017f:
            java.lang.String r5 = "Education"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x018d
            r5 = 102(0x66, float:1.43E-43)
            r2[r5] = r3
            goto L_0x08a0
        L_0x018d:
            r5 = 49
            r6 = 103(0x67, float:1.44E-43)
            r2[r6] = r3
            goto L_0x08a1
        L_0x0195:
            java.lang.String r5 = "Media & Video"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x01a3
            r5 = 98
            r2[r5] = r3
            goto L_0x08a0
        L_0x01a3:
            r5 = 47
            r6 = 99
            r2[r6] = r3
            goto L_0x08a1
        L_0x01ab:
            java.lang.String r5 = "Editors Choice"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x01b9
            r5 = 168(0xa8, float:2.35E-43)
            r2[r5] = r3
            goto L_0x08a0
        L_0x01b9:
            r5 = 82
            r6 = 169(0xa9, float:2.37E-43)
            r2[r6] = r3
            goto L_0x08a1
        L_0x01c1:
            java.lang.String r5 = "Latest Comments"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x01cf
            r5 = 20
            r2[r5] = r3
            goto L_0x08a0
        L_0x01cf:
            r5 = 8
            r6 = 21
            r2[r6] = r3
            goto L_0x08a1
        L_0x01d7:
            java.lang.String r5 = "Trending"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x01e5
            r5 = 28
            r2[r5] = r3
            goto L_0x08a0
        L_0x01e5:
            r5 = 12
            r6 = 29
            r2[r6] = r3
            goto L_0x08a1
        L_0x01ed:
            java.lang.String r5 = "Updates"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x01f9
            r2[r13] = r3
            goto L_0x08a0
        L_0x01f9:
            r5 = 7
            r2[r5] = r3
            r5 = 1
            goto L_0x08a1
        L_0x01ff:
            java.lang.String r5 = "Educational"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x020d
            r5 = 132(0x84, float:1.85E-43)
            r2[r5] = r3
            goto L_0x08a0
        L_0x020d:
            r5 = 64
            r6 = 133(0x85, float:1.86E-43)
            r2[r6] = r3
            goto L_0x08a1
        L_0x0215:
            java.lang.String r5 = "You can get AppCoins now!"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x0223
            r5 = 190(0xbe, float:2.66E-43)
            r2[r5] = r3
            goto L_0x08a0
        L_0x0223:
            r5 = 93
            r6 = 191(0xbf, float:2.68E-43)
            r2[r6] = r3
            goto L_0x08a1
        L_0x022b:
            java.lang.String r5 = "Adventure"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x0239
            r5 = 118(0x76, float:1.65E-43)
            r2[r5] = r3
            goto L_0x08a0
        L_0x0239:
            r5 = 57
            r6 = 119(0x77, float:1.67E-43)
            r2[r6] = r3
            goto L_0x08a1
        L_0x0241:
            java.lang.String r5 = "Entertainment"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x024f
            r5 = 82
            r2[r5] = r3
            goto L_0x08a0
        L_0x024f:
            r5 = 39
            r6 = 83
            r2[r6] = r3
            goto L_0x08a1
        L_0x0257:
            java.lang.String r5 = "Productivity"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x0265
            r5 = 40
            r2[r5] = r3
            goto L_0x08a0
        L_0x0265:
            r5 = 18
            r2[r19] = r3
            goto L_0x08a1
        L_0x026b:
            java.lang.String r5 = "Applications"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x0277
            r2[r8] = r3
            goto L_0x08a0
        L_0x0277:
            r5 = 9
            r6 = 23
            r2[r6] = r3
            goto L_0x08a1
        L_0x027f:
            java.lang.String r5 = "Reference"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x028d
            r5 = 44
            r2[r5] = r3
            goto L_0x08a0
        L_0x028d:
            r5 = 20
            r6 = 45
            r2[r6] = r3
            goto L_0x08a1
        L_0x0295:
            java.lang.String r5 = "Local Top Apps"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x02a3
            r5 = 30
            r2[r5] = r3
            goto L_0x08a0
        L_0x02a3:
            r5 = 13
            r6 = 31
            r2[r6] = r3
            goto L_0x08a1
        L_0x02ab:
            java.lang.String r5 = "The cryptocurrency for the app economy is here! Get free AppCoins by using your favorite apps."
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x02b9
            r5 = 192(0xc0, float:2.69E-43)
            r2[r5] = r3
            goto L_0x08a0
        L_0x02b9:
            r5 = 94
            r6 = 193(0xc1, float:2.7E-43)
            r2[r6] = r3
            goto L_0x08a1
        L_0x02c1:
            java.lang.String r5 = "Transportation"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x02cf
            r5 = 78
            r2[r5] = r3
            goto L_0x08a0
        L_0x02cf:
            r5 = 37
            r6 = 79
            r2[r6] = r3
            goto L_0x08a1
        L_0x02d7:
            java.lang.String r5 = "Latest Reviews"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x02e5
            r5 = 18
            r2[r5] = r3
            goto L_0x08a0
        L_0x02e5:
            r5 = 7
            r6 = 19
            r2[r6] = r3
            goto L_0x08a1
        L_0x02ec:
            java.lang.String r5 = "Featured AppCoins Apps"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x02fa
            r5 = 202(0xca, float:2.83E-43)
            r2[r5] = r3
            goto L_0x08a0
        L_0x02fa:
            r5 = 99
            r6 = 203(0xcb, float:2.84E-43)
            r2[r6] = r3
            goto L_0x08a1
        L_0x0302:
            java.lang.String r5 = "Finance"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x0310
            r5 = 84
            r2[r5] = r3
            goto L_0x08a0
        L_0x0310:
            r5 = 40
            r6 = 85
            r2[r6] = r3
            goto L_0x08a1
        L_0x0318:
            java.lang.String r5 = "Comments in this store"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x0326
            r5 = 174(0xae, float:2.44E-43)
            r2[r5] = r3
            goto L_0x08a0
        L_0x0326:
            r5 = 85
            r6 = 175(0xaf, float:2.45E-43)
            r2[r6] = r3
            goto L_0x08a1
        L_0x032e:
            java.lang.String r5 = "Simulation"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x033c
            r5 = 116(0x74, float:1.63E-43)
            r2[r5] = r3
            goto L_0x08a0
        L_0x033c:
            r5 = 56
            r6 = 117(0x75, float:1.64E-43)
            r2[r6] = r3
            goto L_0x08a1
        L_0x0344:
            java.lang.String r5 = "Mysterious Donor"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x0352
            r5 = 196(0xc4, float:2.75E-43)
            r2[r5] = r3
            goto L_0x08a0
        L_0x0352:
            r5 = 96
            r6 = 197(0xc5, float:2.76E-43)
            r2[r6] = r3
            goto L_0x08a1
        L_0x035a:
            java.lang.String r5 = "Community"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x0368
            r5 = 12
            r2[r5] = r3
            goto L_0x08a0
        L_0x0368:
            r5 = 4
            r6 = 13
            r2[r6] = r3
            goto L_0x08a1
        L_0x036f:
            java.lang.String r5 = "Arcade & Action"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x037d
            r5 = 124(0x7c, float:1.74E-43)
            r2[r5] = r3
            goto L_0x08a0
        L_0x037d:
            r5 = 60
            r6 = 125(0x7d, float:1.75E-43)
            r2[r6] = r3
            goto L_0x08a1
        L_0x0385:
            java.lang.String r5 = "Top Stores"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x0393
            r5 = 32
            r2[r5] = r3
            goto L_0x08a0
        L_0x0393:
            r5 = 14
            r6 = 33
            r2[r6] = r3
            goto L_0x08a1
        L_0x039b:
            java.lang.String r5 = "Top Games"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x03a9
            r5 = 34
            r2[r5] = r3
            goto L_0x08a0
        L_0x03a9:
            r5 = 15
            r6 = 35
            r2[r6] = r3
            goto L_0x08a1
        L_0x03b1:
            java.lang.String r5 = "Software Libraries"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x03bf
            r5 = 60
            r2[r5] = r3
            goto L_0x08a0
        L_0x03bf:
            r5 = 28
            r6 = 61
            r2[r6] = r3
            goto L_0x08a1
        L_0x03c7:
            java.lang.String r5 = "Tools"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x03d5
            r5 = 56
            r2[r5] = r3
            goto L_0x08a0
        L_0x03d5:
            r5 = 26
            r6 = 57
            r2[r6] = r3
            goto L_0x08a1
        L_0x03dd:
            java.lang.String r5 = "Music"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x03eb
            r5 = 134(0x86, float:1.88E-43)
            r2[r5] = r3
            goto L_0x08a0
        L_0x03eb:
            r5 = 65
            r6 = 135(0x87, float:1.89E-43)
            r2[r6] = r3
            goto L_0x08a1
        L_0x03f3:
            java.lang.String r5 = "Games"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x0401
            r5 = 24
            r2[r5] = r3
            goto L_0x08a0
        L_0x0401:
            r5 = 10
            r6 = 25
            r2[r6] = r3
            goto L_0x08a1
        L_0x0409:
            java.lang.String r5 = "Board"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x0417
            r5 = 136(0x88, float:1.9E-43)
            r2[r5] = r3
            goto L_0x08a0
        L_0x0417:
            r5 = 66
            r6 = 137(0x89, float:1.92E-43)
            r2[r6] = r3
            goto L_0x08a1
        L_0x041f:
            java.lang.String r5 = "Word"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x042d
            r5 = 120(0x78, float:1.68E-43)
            r2[r5] = r3
            goto L_0x08a0
        L_0x042d:
            r5 = 58
            r6 = 121(0x79, float:1.7E-43)
            r2[r6] = r3
            goto L_0x08a1
        L_0x0435:
            java.lang.String r5 = "Home"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x0442
            r5 = 4
            r2[r5] = r3
            goto L_0x08a0
        L_0x0442:
            r5 = 0
            r6 = 5
            r2[r6] = r3
            goto L_0x08a1
        L_0x0448:
            java.lang.String r5 = "Demo"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x0456
            r5 = 62
            r2[r5] = r3
            goto L_0x08a0
        L_0x0456:
            r5 = 29
            r6 = 63
            r2[r6] = r3
            goto L_0x08a1
        L_0x045e:
            java.lang.String r5 = "Card"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x046c
            r5 = 128(0x80, float:1.794E-43)
            r2[r5] = r3
            goto L_0x08a0
        L_0x046c:
            r5 = 62
            r6 = 129(0x81, float:1.81E-43)
            r2[r6] = r3
            goto L_0x08a1
        L_0x0474:
            java.lang.String r5 = "All"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x0482
            r5 = 104(0x68, float:1.46E-43)
            r2[r5] = r3
            goto L_0x08a0
        L_0x0482:
            r5 = 50
            r6 = 105(0x69, float:1.47E-43)
            r2[r6] = r3
            goto L_0x08a1
        L_0x048a:
            java.lang.String r5 = "Highlighted"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x0498
            r5 = 26
            r2[r5] = r3
            goto L_0x08a0
        L_0x0498:
            r5 = 11
            r6 = 27
            r2[r6] = r3
            goto L_0x08a1
        L_0x04a0:
            java.lang.String r5 = "Books & Reference"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x04ae
            r5 = 90
            r2[r5] = r3
            goto L_0x08a0
        L_0x04ae:
            r5 = 43
            r6 = 91
            r2[r6] = r3
            goto L_0x08a1
        L_0x04b6:
            java.lang.String r5 = "Libraries & Demo"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x04c4
            r5 = 88
            r2[r5] = r3
            goto L_0x08a0
        L_0x04c4:
            r5 = 42
            r6 = 89
            r2[r6] = r3
            goto L_0x08a1
        L_0x04cc:
            java.lang.String r5 = "Communication"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x04da
            r5 = 72
            r2[r5] = r3
            goto L_0x08a0
        L_0x04da:
            r5 = 34
            r6 = 73
            r2[r6] = r3
            goto L_0x08a1
        L_0x04e2:
            java.lang.String r5 = "Shopping"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x04f0
            r5 = 46
            r2[r5] = r3
            goto L_0x08a0
        L_0x04f0:
            r5 = 21
            r6 = 47
            r2[r6] = r3
            goto L_0x08a1
        L_0x04f8:
            java.lang.String r5 = "Personalization"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x0506
            r5 = 74
            r2[r5] = r3
            goto L_0x08a0
        L_0x0506:
            r5 = 35
            r6 = 75
            r2[r6] = r3
            goto L_0x08a1
        L_0x050e:
            java.lang.String r5 = "Summer Apps"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x051c
            r5 = 164(0xa4, float:2.3E-43)
            r2[r5] = r3
            goto L_0x08a0
        L_0x051c:
            r5 = 80
            r6 = 165(0xa5, float:2.31E-43)
            r2[r6] = r3
            goto L_0x08a1
        L_0x0524:
            java.lang.String r5 = "Apps Timeline"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x0532
            r5 = 14
            r2[r5] = r3
            goto L_0x08a0
        L_0x0532:
            r5 = 5
            r6 = 15
            r2[r6] = r3
            goto L_0x08a1
        L_0x0539:
            java.lang.String r5 = "Travel & Local"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x0547
            r5 = 76
            r2[r5] = r3
            goto L_0x08a0
        L_0x0547:
            r5 = 36
            r6 = 77
            r2[r6] = r3
            goto L_0x08a1
        L_0x054f:
            java.lang.String r5 = "Latest Applications"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x055d
            r5 = 152(0x98, float:2.13E-43)
            r2[r5] = r3
            goto L_0x08a0
        L_0x055d:
            r5 = 74
            r6 = 153(0x99, float:2.14E-43)
            r2[r6] = r3
            goto L_0x08a1
        L_0x0565:
            java.lang.String r5 = "Cards & Casino"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x0573
            r5 = 140(0x8c, float:1.96E-43)
            r2[r5] = r3
            goto L_0x08a0
        L_0x0573:
            r5 = 68
            r6 = 141(0x8d, float:1.98E-43)
            r2[r6] = r3
            goto L_0x08a1
        L_0x057b:
            java.lang.String r5 = "Role Playing"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x0589
            r5 = 130(0x82, float:1.82E-43)
            r2[r5] = r3
            goto L_0x08a0
        L_0x0589:
            r5 = 63
            r6 = 131(0x83, float:1.84E-43)
            r2[r6] = r3
            goto L_0x08a1
        L_0x0591:
            java.lang.String r5 = "News & Magazines"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x059f
            r5 = 42
            r2[r5] = r3
            goto L_0x08a0
        L_0x059f:
            r5 = 19
            r6 = 43
            r2[r6] = r3
            goto L_0x08a1
        L_0x05a7:
            java.lang.String r5 = "AppCoins Enabled"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x05b5
            r5 = 184(0xb8, float:2.58E-43)
            r2[r5] = r3
            goto L_0x08a0
        L_0x05b5:
            r5 = 90
            r6 = 185(0xb9, float:2.59E-43)
            r2[r6] = r3
            goto L_0x08a1
        L_0x05bd:
            java.lang.String r5 = "Health & Fitness"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x05cb
            r5 = 96
            r2[r5] = r3
            goto L_0x08a0
        L_0x05cb:
            r5 = 46
            r6 = 97
            r2[r6] = r3
            goto L_0x08a1
        L_0x05d3:
            java.lang.String r5 = "Photography"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x05e1
            r5 = 70
            r2[r5] = r3
            goto L_0x08a0
        L_0x05e1:
            r5 = 33
            r2[r9] = r3
            goto L_0x08a1
        L_0x05e7:
            java.lang.String r5 = "Top Apps"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x05f5
            r5 = 148(0x94, float:2.07E-43)
            r2[r5] = r3
            goto L_0x08a0
        L_0x05f5:
            r5 = 72
            r6 = 149(0x95, float:2.09E-43)
            r2[r6] = r3
            goto L_0x08a1
        L_0x05fd:
            java.lang.String r5 = "Downloads"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x060b
            r5 = 10
            r2[r5] = r3
            goto L_0x08a0
        L_0x060b:
            r5 = 11
            r2[r5] = r3
            r5 = 3
            goto L_0x08a1
        L_0x0612:
            java.lang.String r5 = "Multimedia"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x0620
            r5 = 100
            r2[r5] = r3
            goto L_0x08a0
        L_0x0620:
            r5 = 48
            r6 = 101(0x65, float:1.42E-43)
            r2[r6] = r3
            goto L_0x08a1
        L_0x0628:
            java.lang.String r5 = "Comments on this store"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x0636
            r5 = 176(0xb0, float:2.47E-43)
            r2[r5] = r3
            goto L_0x08a0
        L_0x0636:
            r5 = 177(0xb1, float:2.48E-43)
            r2[r5] = r3
            r5 = 86
            goto L_0x08a1
        L_0x063e:
            java.lang.String r5 = "Followed Stores"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x064c
            r5 = 178(0xb2, float:2.5E-43)
            r2[r5] = r3
            goto L_0x08a0
        L_0x064c:
            r5 = 179(0xb3, float:2.51E-43)
            r2[r5] = r3
            r5 = 87
            goto L_0x08a1
        L_0x0654:
            java.lang.String r5 = "Essential Apps"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x0662
            r5 = 162(0xa2, float:2.27E-43)
            r2[r5] = r3
            goto L_0x08a0
        L_0x0662:
            r5 = 79
            r6 = 163(0xa3, float:2.28E-43)
            r2[r6] = r3
            goto L_0x08a1
        L_0x066a:
            java.lang.String r5 = "Business"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x0678
            r5 = 50
            r2[r5] = r3
            goto L_0x08a0
        L_0x0678:
            r5 = 23
            r2[r10] = r3
            goto L_0x08a1
        L_0x067e:
            java.lang.String r5 = "Music & Video"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x068c
            r5 = 160(0xa0, float:2.24E-43)
            r2[r5] = r3
            goto L_0x08a0
        L_0x068c:
            r5 = 78
            r6 = 161(0xa1, float:2.26E-43)
            r2[r6] = r3
            goto L_0x08a1
        L_0x0694:
            java.lang.String r5 = "Aptoide Publishers"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x06a2
            r5 = 158(0x9e, float:2.21E-43)
            r2[r5] = r3
            goto L_0x08a0
        L_0x06a2:
            r5 = 77
            r6 = 159(0x9f, float:2.23E-43)
            r2[r6] = r3
            goto L_0x08a1
        L_0x06aa:
            java.lang.String r5 = "Music & Audio"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x06b8
            r5 = 66
            r2[r5] = r3
            goto L_0x08a0
        L_0x06b8:
            r5 = 31
            r2[r15] = r3
            goto L_0x08a1
        L_0x06be:
            java.lang.String r5 = "Transport"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x06cc
            r5 = 94
            r2[r5] = r3
            goto L_0x08a0
        L_0x06cc:
            r5 = 45
            r2[r16] = r3
            goto L_0x08a1
        L_0x06d2:
            java.lang.String r5 = "Earn AppCoins Credits"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x06e0
            r5 = 200(0xc8, float:2.8E-43)
            r2[r5] = r3
            goto L_0x08a0
        L_0x06e0:
            r5 = 98
            r6 = 201(0xc9, float:2.82E-43)
            r2[r6] = r3
            goto L_0x08a1
        L_0x06e8:
            java.lang.String r5 = "Use Your AppCoins"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x06f6
            r5 = 198(0xc6, float:2.77E-43)
            r2[r5] = r3
            goto L_0x08a0
        L_0x06f6:
            r5 = 97
            r6 = 199(0xc7, float:2.79E-43)
            r2[r6] = r3
            goto L_0x08a1
        L_0x06fe:
            java.lang.String r5 = "Weather"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x070c
            r5 = 68
            r2[r5] = r3
            goto L_0x08a0
        L_0x070c:
            r5 = 32
            r6 = 69
            r2[r6] = r3
            goto L_0x08a1
        L_0x0714:
            java.lang.String r5 = "Sports Games"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x0722
            r5 = 144(0x90, float:2.02E-43)
            r2[r5] = r3
            goto L_0x08a0
        L_0x0722:
            r5 = 70
            r6 = 145(0x91, float:2.03E-43)
            r2[r6] = r3
            goto L_0x08a1
        L_0x072a:
            java.lang.String r5 = "Reviews"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x0738
            r5 = 36
            r2[r5] = r3
            goto L_0x08a0
        L_0x0738:
            r5 = 37
            r2[r5] = r3
            r5 = 16
            goto L_0x08a1
        L_0x0740:
            java.lang.String r5 = "Featured Stores"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x074e
            r5 = 182(0xb6, float:2.55E-43)
            r2[r5] = r3
            goto L_0x08a0
        L_0x074e:
            r5 = 89
            r6 = 183(0xb7, float:2.56E-43)
            r2[r6] = r3
            goto L_0x08a1
        L_0x0756:
            java.lang.String r5 = "Editors' Choice"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x0764
            r5 = 172(0xac, float:2.41E-43)
            r2[r5] = r3
            goto L_0x08a0
        L_0x0764:
            r5 = 84
            r6 = 173(0xad, float:2.42E-43)
            r2[r6] = r3
            goto L_0x08a1
        L_0x076c:
            java.lang.String r5 = "Medical"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x077a
            r5 = 80
            r2[r5] = r3
            goto L_0x08a0
        L_0x077a:
            r5 = 38
            r6 = 81
            r2[r6] = r3
            goto L_0x08a1
        L_0x0782:
            java.lang.String r5 = "Trivia"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x0790
            r5 = 126(0x7e, float:1.77E-43)
            r2[r5] = r3
            goto L_0x08a0
        L_0x0790:
            r5 = 61
            r6 = 127(0x7f, float:1.78E-43)
            r2[r6] = r3
            goto L_0x08a1
        L_0x0798:
            java.lang.String r5 = "Travel"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x07a6
            r5 = 58
            r2[r5] = r3
            goto L_0x08a0
        L_0x07a6:
            r5 = 27
            r6 = 59
            r2[r6] = r3
            goto L_0x08a1
        L_0x07ae:
            java.lang.String r5 = "Themes"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x07bc
            r5 = 54
            r2[r5] = r3
            goto L_0x08a0
        L_0x07bc:
            r5 = 25
            r6 = 55
            r2[r6] = r3
            goto L_0x08a1
        L_0x07c4:
            java.lang.String r5 = "News & Weather"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x07d2
            r5 = 38
            r2[r5] = r3
            goto L_0x08a0
        L_0x07d2:
            r5 = 39
            r2[r5] = r3
            r5 = 17
            goto L_0x08a1
        L_0x07da:
            java.lang.String r7 = "Stores"
            boolean r7 = r0.equals(r7)
            if (r7 != 0) goto L_0x07e8
            r5 = 8
            r2[r5] = r3
            goto L_0x08a0
        L_0x07e8:
            r6 = 9
            r2[r6] = r3
            goto L_0x08a1
        L_0x07ee:
            java.lang.String r5 = "Sports"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x07fc
            r5 = 52
            r2[r5] = r3
            goto L_0x08a0
        L_0x07fc:
            r5 = 24
            r6 = 53
            r2[r6] = r3
            goto L_0x08a1
        L_0x0804:
            java.lang.String r5 = "Social"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x0812
            r5 = 48
            r2[r5] = r3
            goto L_0x08a0
        L_0x0812:
            r5 = 49
            r2[r5] = r3
            r5 = 22
            goto L_0x08a1
        L_0x081a:
            java.lang.String r5 = "Racing"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x0828
            r5 = 146(0x92, float:2.05E-43)
            r2[r5] = r3
            goto L_0x08a0
        L_0x0828:
            r5 = 147(0x93, float:2.06E-43)
            r2[r5] = r3
            r5 = 71
            goto L_0x08a1
        L_0x0830:
            java.lang.String r5 = "Puzzle"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x083e
            r5 = 106(0x6a, float:1.49E-43)
            r2[r5] = r3
            goto L_0x08a0
        L_0x083e:
            r5 = 107(0x6b, float:1.5E-43)
            r2[r5] = r3
            r5 = 51
            goto L_0x08a1
        L_0x0845:
            java.lang.String r5 = "Timeline"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x0850
            r2[r11] = r3
            goto L_0x08a0
        L_0x0850:
            r2[r12] = r3
            r5 = 6
            goto L_0x08a1
        L_0x0854:
            java.lang.String r5 = "Get rewarded with AppCoins"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x0861
            r5 = 188(0xbc, float:2.63E-43)
            r2[r5] = r3
            goto L_0x08a0
        L_0x0861:
            r5 = 189(0xbd, float:2.65E-43)
            r2[r5] = r3
            r5 = 92
            goto L_0x08a1
        L_0x0868:
            java.lang.String r5 = "Brain & Puzzle"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x0875
            r5 = 138(0x8a, float:1.93E-43)
            r2[r5] = r3
            goto L_0x08a0
        L_0x0875:
            r5 = 139(0x8b, float:1.95E-43)
            r2[r5] = r3
            r5 = 67
            goto L_0x08a1
        L_0x087c:
            java.lang.String r5 = "Game of the Week"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x0889
            r5 = 194(0xc2, float:2.72E-43)
            r2[r5] = r3
            goto L_0x08a0
        L_0x0889:
            r5 = 195(0xc3, float:2.73E-43)
            r2[r5] = r3
            r5 = 95
            goto L_0x08a1
        L_0x0890:
            java.lang.String r5 = "Health"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x089b
            r2[r17] = r3
            goto L_0x08a0
        L_0x089b:
            r2[r18] = r3
            r5 = 41
            goto L_0x08a1
        L_0x08a0:
            r5 = -1
        L_0x08a1:
            switch(r5) {
                case 0: goto L_0x0d7a;
                case 1: goto L_0x0d6e;
                case 2: goto L_0x0d62;
                case 3: goto L_0x0d56;
                case 4: goto L_0x0d4a;
                case 5: goto L_0x0d3e;
                case 6: goto L_0x0d32;
                case 7: goto L_0x0d26;
                case 8: goto L_0x0d1a;
                case 9: goto L_0x0d0e;
                case 10: goto L_0x0d01;
                case 11: goto L_0x0cf4;
                case 12: goto L_0x0ce7;
                case 13: goto L_0x0cda;
                case 14: goto L_0x0ccd;
                case 15: goto L_0x0cc0;
                case 16: goto L_0x0cb3;
                case 17: goto L_0x0ca6;
                case 18: goto L_0x0c99;
                case 19: goto L_0x0c8c;
                case 20: goto L_0x0c7f;
                case 21: goto L_0x0c72;
                case 22: goto L_0x0c65;
                case 23: goto L_0x0c58;
                case 24: goto L_0x0c4b;
                case 25: goto L_0x0c3e;
                case 26: goto L_0x0c31;
                case 27: goto L_0x0c24;
                case 28: goto L_0x0c17;
                case 29: goto L_0x0c0a;
                case 30: goto L_0x0bfd;
                case 31: goto L_0x0bf0;
                case 32: goto L_0x0be3;
                case 33: goto L_0x0bd6;
                case 34: goto L_0x0bc9;
                case 35: goto L_0x0bbc;
                case 36: goto L_0x0baf;
                case 37: goto L_0x0ba2;
                case 38: goto L_0x0b95;
                case 39: goto L_0x0b88;
                case 40: goto L_0x0b7b;
                case 41: goto L_0x0b6e;
                case 42: goto L_0x0b61;
                case 43: goto L_0x0b54;
                case 44: goto L_0x0b47;
                case 45: goto L_0x0b3a;
                case 46: goto L_0x0b2d;
                case 47: goto L_0x0b20;
                case 48: goto L_0x0b13;
                case 49: goto L_0x0b06;
                case 50: goto L_0x0af9;
                case 51: goto L_0x0aec;
                case 52: goto L_0x0adf;
                case 53: goto L_0x0ad2;
                case 54: goto L_0x0ac5;
                case 55: goto L_0x0ab8;
                case 56: goto L_0x0aab;
                case 57: goto L_0x0a9e;
                case 58: goto L_0x0a91;
                case 59: goto L_0x0a84;
                case 60: goto L_0x0a77;
                case 61: goto L_0x0a6a;
                case 62: goto L_0x0a5d;
                case 63: goto L_0x0a50;
                case 64: goto L_0x0a43;
                case 65: goto L_0x0a36;
                case 66: goto L_0x0a29;
                case 67: goto L_0x0a1c;
                case 68: goto L_0x0a0f;
                case 69: goto L_0x0a02;
                case 70: goto L_0x09f5;
                case 71: goto L_0x09e8;
                case 72: goto L_0x09db;
                case 73: goto L_0x09ce;
                case 74: goto L_0x09ce;
                case 75: goto L_0x09c1;
                case 76: goto L_0x09b4;
                case 77: goto L_0x0996;
                case 78: goto L_0x0989;
                case 79: goto L_0x097c;
                case 80: goto L_0x096f;
                case 81: goto L_0x0962;
                case 82: goto L_0x0955;
                case 83: goto L_0x0955;
                case 84: goto L_0x0955;
                case 85: goto L_0x0948;
                case 86: goto L_0x0948;
                case 87: goto L_0x093b;
                case 88: goto L_0x092e;
                case 89: goto L_0x0921;
                case 90: goto L_0x0914;
                case 91: goto L_0x0914;
                case 92: goto L_0x0907;
                case 93: goto L_0x08fa;
                case 94: goto L_0x08ed;
                case 95: goto L_0x08e0;
                case 96: goto L_0x08d3;
                case 97: goto L_0x08c6;
                case 98: goto L_0x08b9;
                case 99: goto L_0x08ac;
                default: goto L_0x08a4;
            }
        L_0x08a4:
            r4 = r21
            r5 = 301(0x12d, float:4.22E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x08ac:
            r5 = 2131689572(0x7f0f0064, float:1.9008163E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 300(0x12c, float:4.2E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x08b9:
            r5 = 2131689547(0x7f0f004b, float:1.9008112E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 299(0x12b, float:4.19E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x08c6:
            r5 = 2131689546(0x7f0f004a, float:1.900811E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 298(0x12a, float:4.18E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x08d3:
            r5 = 2131689638(0x7f0f00a6, float:1.9008297E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 297(0x129, float:4.16E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x08e0:
            r5 = 2131690101(0x7f0f0275, float:1.9009236E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 296(0x128, float:4.15E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x08ed:
            r5 = 2131689564(0x7f0f005c, float:1.9008147E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 295(0x127, float:4.13E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x08fa:
            r5 = 2131689573(0x7f0f0065, float:1.9008165E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 294(0x126, float:4.12E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0907:
            r5 = 2131689569(0x7f0f0061, float:1.9008157E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 293(0x125, float:4.1E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0914:
            r5 = 2131689574(0x7f0f0066, float:1.9008167E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 292(0x124, float:4.09E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0921:
            r5 = 2131690009(0x7f0f0219, float:1.900905E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 291(0x123, float:4.08E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x092e:
            r5 = 2131690302(0x7f0f033e, float:1.9009644E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 290(0x122, float:4.06E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x093b:
            r5 = 2131690022(0x7f0f0226, float:1.9009076E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 289(0x121, float:4.05E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0948:
            r5 = 2131689768(0x7f0f0128, float:1.900856E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 288(0x120, float:4.04E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0955:
            r5 = 2131690103(0x7f0f0277, float:1.900924E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 287(0x11f, float:4.02E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0962:
            r5 = 2131690481(0x7f0f03f1, float:1.9010007E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 286(0x11e, float:4.01E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x096f:
            r5 = 2131690467(0x7f0f03e3, float:1.9009978E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 285(0x11d, float:4.0E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x097c:
            r5 = 2131689965(0x7f0f01ed, float:1.900896E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 284(0x11c, float:3.98E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0989:
            r5 = 2131690174(0x7f0f02be, float:1.9009384E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 283(0x11b, float:3.97E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0996:
            r5 = 2131689650(0x7f0f00b2, float:1.9008321E38)
            r6 = 280(0x118, float:3.92E-43)
            r2[r6] = r3
            android.content.res.Resources r6 = r22.getResources()
            java.lang.Object[] r7 = new java.lang.Object[r3]
            r8 = 0
            r7[r8] = r23
            r8 = 281(0x119, float:3.94E-43)
            r2[r8] = r3
            java.lang.String r4 = p005cm.aptoide.p006pt.utils.AptoideUtils.StringU.getFormattedString(r5, r6, r7)
            r5 = 282(0x11a, float:3.95E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x09b4:
            r5 = 2131689582(0x7f0f006e, float:1.9008183E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 279(0x117, float:3.91E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x09c1:
            r5 = 2131690487(0x7f0f03f7, float:1.901002E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 278(0x116, float:3.9E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x09ce:
            r5 = 2131690149(0x7f0f02a5, float:1.9009333E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 277(0x115, float:3.88E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x09db:
            r5 = 2131690486(0x7f0f03f6, float:1.9010017E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 276(0x114, float:3.87E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x09e8:
            r5 = 2131690298(0x7f0f033a, float:1.9009636E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 275(0x113, float:3.85E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x09f5:
            r5 = 2131690442(0x7f0f03ca, float:1.9009928E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 274(0x112, float:3.84E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0a02:
            r5 = 2131689737(0x7f0f0109, float:1.9008498E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 273(0x111, float:3.83E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0a0f:
            r5 = 2131689735(0x7f0f0107, float:1.9008494E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 272(0x110, float:3.81E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0a1c:
            r5 = 2131689702(0x7f0f00e6, float:1.9008427E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 271(0x10f, float:3.8E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0a29:
            r5 = 2131689691(0x7f0f00db, float:1.9008405E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 270(0x10e, float:3.78E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0a36:
            r5 = 2131690172(0x7f0f02bc, float:1.900938E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 269(0x10d, float:3.77E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0a43:
            r5 = 2131689882(0x7f0f019a, float:1.9008792E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 268(0x10c, float:3.76E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0a50:
            r5 = 2131690352(0x7f0f0370, float:1.9009745E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 267(0x10b, float:3.74E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0a5d:
            r5 = 2131689731(0x7f0f0103, float:1.9008486E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 266(0x10a, float:3.73E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0a6a:
            r5 = 2131690496(0x7f0f0400, float:1.9010037E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 265(0x109, float:3.71E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0a77:
            r5 = 2131689653(0x7f0f00b5, float:1.9008327E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 264(0x108, float:3.7E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0a84:
            r5 = 2131689652(0x7f0f00b4, float:1.9008325E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 263(0x107, float:3.69E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0a91:
            r5 = 2131690551(0x7f0f0437, float:1.9010149E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 262(0x106, float:3.67E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0a9e:
            r5 = 2131689530(0x7f0f003a, float:1.9008078E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 261(0x105, float:3.66E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0aab:
            r5 = 2131690428(0x7f0f03bc, float:1.90099E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 260(0x104, float:3.64E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0ab8:
            r5 = 2131690008(0x7f0f0218, float:1.9009047E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 259(0x103, float:3.63E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0ac5:
            r5 = 2131690463(0x7f0f03df, float:1.900997E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 258(0x102, float:3.62E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0ad2:
            r5 = 2131689524(0x7f0f0034, float:1.9008066E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 257(0x101, float:3.6E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0adf:
            r5 = 2131689736(0x7f0f0108, float:1.9008496E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 256(0x100, float:3.59E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0aec:
            r5 = 2131690297(0x7f0f0339, float:1.9009634E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 255(0xff, float:3.57E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0af9:
            r5 = 2131689531(0x7f0f003b, float:1.900808E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 254(0xfe, float:3.56E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0b06:
            r5 = 2131689881(0x7f0f0199, float:1.900879E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 253(0xfd, float:3.55E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0b13:
            r5 = 2131690171(0x7f0f02bb, float:1.9009378E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 252(0xfc, float:3.53E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0b20:
            r5 = 2131690160(0x7f0f02b0, float:1.9009356E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 251(0xfb, float:3.52E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0b2d:
            r5 = 2131690043(0x7f0f023b, float:1.9009118E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 250(0xfa, float:3.5E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0b3a:
            r5 = 2131690491(0x7f0f03fb, float:1.9010027E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 249(0xf9, float:3.49E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0b47:
            r5 = 2131690153(0x7f0f02a9, float:1.9009342E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 248(0xf8, float:3.48E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0b54:
            r5 = 2131689692(0x7f0f00dc, float:1.9008407E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 247(0xf7, float:3.46E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0b61:
            r5 = 2131690152(0x7f0f02a8, float:1.900934E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 246(0xf6, float:3.45E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0b6e:
            r5 = 2131690042(0x7f0f023a, float:1.9009116E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 245(0xf5, float:3.43E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0b7b:
            r5 = 2131690015(0x7f0f021f, float:1.9009062E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 244(0xf4, float:3.42E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0b88:
            r5 = 2131689883(0x7f0f019b, float:1.9008794E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 243(0xf3, float:3.4E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0b95:
            r5 = 2131690161(0x7f0f02b1, float:1.9009358E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 242(0xf2, float:3.39E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0ba2:
            r5 = 2131690492(0x7f0f03fc, float:1.901003E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 241(0xf1, float:3.38E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0baf:
            r5 = 2131690494(0x7f0f03fe, float:1.9010033E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 240(0xf0, float:3.36E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0bbc:
            r5 = 2131690241(0x7f0f0301, float:1.900952E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 239(0xef, float:3.35E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0bc9:
            r5 = 2131689790(0x7f0f013e, float:1.9008605E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 238(0xee, float:3.34E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0bd6:
            r5 = 2131690242(0x7f0f0302, float:1.9009522E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 237(0xed, float:3.32E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0be3:
            r5 = 2131690545(0x7f0f0431, float:1.9010137E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 236(0xec, float:3.31E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0bf0:
            r5 = 2131690173(0x7f0f02bd, float:1.9009382E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 235(0xeb, float:3.3E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0bfd:
            r5 = 2131689766(0x7f0f0126, float:1.9008557E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 234(0xea, float:3.28E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0c0a:
            r5 = 2131689837(0x7f0f016d, float:1.90087E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 233(0xe9, float:3.27E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0c17:
            r5 = 2131690439(0x7f0f03c7, float:1.9009922E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 232(0xe8, float:3.25E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0c24:
            r5 = 2131690493(0x7f0f03fd, float:1.9010031E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 231(0xe7, float:3.24E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0c31:
            r5 = 2131690485(0x7f0f03f5, float:1.9010015E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 230(0xe6, float:3.22E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0c3e:
            r5 = 2131690471(0x7f0f03e7, float:1.9009987E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 229(0xe5, float:3.21E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0c4b:
            r5 = 2131690441(0x7f0f03c9, float:1.9009926E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 228(0xe4, float:3.2E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0c58:
            r5 = 2131689725(0x7f0f00fd, float:1.9008473E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 227(0xe3, float:3.18E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0c65:
            r5 = 2131690430(0x7f0f03be, float:1.9009903E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 226(0xe2, float:3.17E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0c72:
            r5 = 2131690421(0x7f0f03b5, float:1.9009885E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 225(0xe1, float:3.15E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0c7f:
            r5 = 2131690304(0x7f0f0340, float:1.9009648E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 224(0xe0, float:3.14E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0c8c:
            r5 = 2131690197(0x7f0f02d5, float:1.900943E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 223(0xdf, float:3.12E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0c99:
            r5 = 2131690254(0x7f0f030e, float:1.9009546E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 222(0xde, float:3.11E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0ca6:
            r5 = 2131690198(0x7f0f02d6, float:1.9009433E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 221(0xdd, float:3.1E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0cb3:
            r5 = 2131690350(0x7f0f036e, float:1.9009741E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 220(0xdc, float:3.08E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0cc0:
            r5 = 2131690489(0x7f0f03f9, float:1.9010023E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 219(0xdb, float:3.07E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0ccd:
            r5 = 2131690490(0x7f0f03fa, float:1.9010025E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 218(0xda, float:3.05E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0cda:
            r5 = 2131690156(0x7f0f02ac, float:1.9009348E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 217(0xd9, float:3.04E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0ce7:
            r5 = 2131690495(0x7f0f03ff, float:1.9010035E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 216(0xd8, float:3.03E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0cf4:
            r5 = 2131690046(0x7f0f023e, float:1.9009125E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 215(0xd7, float:3.01E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0d01:
            r5 = 2131690030(0x7f0f022e, float:1.9009092E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 214(0xd6, float:3.0E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0d0e:
            r5 = 2131689577(0x7f0f0069, float:1.9008173E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 213(0xd5, float:2.98E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0d1a:
            r5 = 2131690150(0x7f0f02a6, float:1.9009335E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 212(0xd4, float:2.97E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0d26:
            r5 = 2131690151(0x7f0f02a7, float:1.9009338E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 211(0xd3, float:2.96E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0d32:
            r5 = 2131690473(0x7f0f03e9, float:1.900999E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 210(0xd2, float:2.94E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0d3e:
            r5 = 2131689592(0x7f0f0078, float:1.9008204E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 209(0xd1, float:2.93E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0d4a:
            r5 = 2131689791(0x7f0f013f, float:1.9008607E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 208(0xd0, float:2.91E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0d56:
            r5 = 2131689862(0x7f0f0186, float:1.9008751E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 207(0xcf, float:2.9E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0d62:
            r5 = 2131690458(0x7f0f03da, float:1.900996E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 206(0xce, float:2.89E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0d6e:
            r5 = 2131690507(0x7f0f040b, float:1.901006E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 205(0xcd, float:2.87E-43)
            r2[r5] = r3
            goto L_0x0d85
        L_0x0d7a:
            r5 = 2131690102(0x7f0f0276, float:1.9009238E38)
            java.lang.String r4 = r1.getString(r5)
            r5 = 204(0xcc, float:2.86E-43)
            r2[r5] = r3
        L_0x0d85:
            r5 = 302(0x12e, float:4.23E-43)
            r2[r5] = r3
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.view.Translator.translate(java.lang.String, android.content.Context, java.lang.String):java.lang.String");
    }

    public static String[] translateToMultiple(String string, Context context) {
        boolean[] $jacocoInit = $jacocoInit();
        String[] result = null;
        if (string == null) {
            $jacocoInit[303] = true;
            return null;
        }
        char c = 65535;
        int hashCode = string.hashCode();
        if (hashCode != -1846398218) {
            if (hashCode != 1904461492) {
                $jacocoInit[304] = true;
            } else if (!string.equals("Your store doesn't have any applications yet. Install Aptoide Uploader and upload apps to share them with the world!")) {
                $jacocoInit[305] = true;
            } else {
                $jacocoInit[306] = true;
                c = 0;
            }
        } else if (!string.equals("Your store does not have any applications yet. Install Aptoide Uploader and upload apps to share them with the world!")) {
            $jacocoInit[307] = true;
        } else {
            $jacocoInit[308] = true;
            c = 1;
        }
        if (c == 0 || c == 1) {
            $jacocoInit[310] = true;
            $jacocoInit[311] = true;
            $jacocoInit[312] = true;
            $jacocoInit[313] = true;
            result = new String[]{context.getString(C1375R.string.install_app_outter_pt1), context.getString(C1375R.string.install_app_outter_pt2), context.getString(C1375R.string.install_app_inner), context.getString(C1375R.string.open_app_inner)};
            $jacocoInit[314] = true;
        } else {
            $jacocoInit[309] = true;
        }
        $jacocoInit[315] = true;
        return result;
    }
}
