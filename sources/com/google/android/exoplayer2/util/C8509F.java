package com.google.android.exoplayer2.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Parcel;
import android.support.p001v7.widget.LinearLayoutManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.google.android.exoplayer2.C8096B;
import com.google.android.exoplayer2.upstream.C8487i;
import java.io.Closeable;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.google.android.exoplayer2.util.F */
/* compiled from: Util */
public final class C8509F {

    /* renamed from: a */
    public static final int f18793a = VERSION.SDK_INT;

    /* renamed from: b */
    public static final String f18794b = Build.DEVICE;

    /* renamed from: c */
    public static final String f18795c = Build.MANUFACTURER;

    /* renamed from: d */
    public static final String f18796d = Build.MODEL;

    /* renamed from: e */
    public static final String f18797e;

    /* renamed from: f */
    public static final byte[] f18798f = new byte[0];

    /* renamed from: g */
    private static final Pattern f18799g = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");

    /* renamed from: h */
    private static final Pattern f18800h = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");

    /* renamed from: i */
    private static final Pattern f18801i = Pattern.compile("%([A-Fa-f0-9]{2})");

    /* renamed from: j */
    private static final int[] f18802j;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f18794b);
        String str = ", ";
        sb.append(str);
        sb.append(f18796d);
        sb.append(str);
        sb.append(f18795c);
        sb.append(str);
        sb.append(f18793a);
        f18797e = sb.toString();
        int[] iArr = new int[Opcodes.ACC_NATIVE];
        // fill-array-data instruction
        iArr[0] = 0;
        iArr[1] = 79764919;
        iArr[2] = 159529838;
        iArr[3] = 222504665;
        iArr[4] = 319059676;
        iArr[5] = 398814059;
        iArr[6] = 445009330;
        iArr[7] = 507990021;
        iArr[8] = 638119352;
        iArr[9] = 583659535;
        iArr[10] = 797628118;
        iArr[11] = 726387553;
        iArr[12] = 890018660;
        iArr[13] = 835552979;
        iArr[14] = 1015980042;
        iArr[15] = 944750013;
        iArr[16] = 1276238704;
        iArr[17] = 1221641927;
        iArr[18] = 1167319070;
        iArr[19] = 1095957929;
        iArr[20] = 1595256236;
        iArr[21] = 1540665371;
        iArr[22] = 1452775106;
        iArr[23] = 1381403509;
        iArr[24] = 1780037320;
        iArr[25] = 1859660671;
        iArr[26] = 1671105958;
        iArr[27] = 1733955601;
        iArr[28] = 2031960084;
        iArr[29] = 2111593891;
        iArr[30] = 1889500026;
        iArr[31] = 1952343757;
        iArr[32] = -1742489888;
        iArr[33] = -1662866601;
        iArr[34] = -1851683442;
        iArr[35] = -1788833735;
        iArr[36] = -1960329156;
        iArr[37] = -1880695413;
        iArr[38] = -2103051438;
        iArr[39] = -2040207643;
        iArr[40] = -1104454824;
        iArr[41] = -1159051537;
        iArr[42] = -1213636554;
        iArr[43] = -1284997759;
        iArr[44] = -1389417084;
        iArr[45] = -1444007885;
        iArr[46] = -1532160278;
        iArr[47] = -1603531939;
        iArr[48] = -734892656;
        iArr[49] = -789352409;
        iArr[50] = -575645954;
        iArr[51] = -646886583;
        iArr[52] = -952755380;
        iArr[53] = -1007220997;
        iArr[54] = -827056094;
        iArr[55] = -898286187;
        iArr[56] = -231047128;
        iArr[57] = -151282273;
        iArr[58] = -71779514;
        iArr[59] = -8804623;
        iArr[60] = -515967244;
        iArr[61] = -436212925;
        iArr[62] = -390279782;
        iArr[63] = -327299027;
        iArr[64] = 881225847;
        iArr[65] = 809987520;
        iArr[66] = 1023691545;
        iArr[67] = 969234094;
        iArr[68] = 662832811;
        iArr[69] = 591600412;
        iArr[70] = 771767749;
        iArr[71] = 717299826;
        iArr[72] = 311336399;
        iArr[73] = 374308984;
        iArr[74] = 453813921;
        iArr[75] = 533576470;
        iArr[76] = 25881363;
        iArr[77] = 88864420;
        iArr[78] = 134795389;
        iArr[79] = 214552010;
        iArr[80] = 2023205639;
        iArr[81] = 2086057648;
        iArr[82] = 1897238633;
        iArr[83] = 1976864222;
        iArr[84] = 1804852699;
        iArr[85] = 1867694188;
        iArr[86] = 1645340341;
        iArr[87] = 1724971778;
        iArr[88] = 1587496639;
        iArr[89] = 1516133128;
        iArr[90] = 1461550545;
        iArr[91] = 1406951526;
        iArr[92] = 1302016099;
        iArr[93] = 1230646740;
        iArr[94] = 1142491917;
        iArr[95] = 1087903418;
        iArr[96] = -1398421865;
        iArr[97] = -1469785312;
        iArr[98] = -1524105735;
        iArr[99] = -1578704818;
        iArr[100] = -1079922613;
        iArr[101] = -1151291908;
        iArr[102] = -1239184603;
        iArr[103] = -1293773166;
        iArr[104] = -1968362705;
        iArr[105] = -1905510760;
        iArr[106] = -2094067647;
        iArr[107] = -2014441994;
        iArr[108] = -1716953613;
        iArr[109] = -1654112188;
        iArr[110] = -1876203875;
        iArr[111] = -1796572374;
        iArr[112] = -525066777;
        iArr[113] = -462094256;
        iArr[114] = -382327159;
        iArr[115] = -302564546;
        iArr[116] = -206542021;
        iArr[117] = -143559028;
        iArr[118] = -97365931;
        iArr[119] = -17609246;
        iArr[120] = -960696225;
        iArr[121] = -1031934488;
        iArr[122] = -817968335;
        iArr[123] = -872425850;
        iArr[124] = -709327229;
        iArr[125] = -780559564;
        iArr[126] = -600130067;
        iArr[127] = -654598054;
        iArr[128] = 1762451694;
        iArr[129] = 1842216281;
        iArr[130] = 1619975040;
        iArr[131] = 1682949687;
        iArr[132] = 2047383090;
        iArr[133] = 2127137669;
        iArr[134] = 1938468188;
        iArr[135] = 2001449195;
        iArr[136] = 1325665622;
        iArr[137] = 1271206113;
        iArr[138] = 1183200824;
        iArr[139] = 1111960463;
        iArr[140] = 1543535498;
        iArr[141] = 1489069629;
        iArr[142] = 1434599652;
        iArr[143] = 1363369299;
        iArr[144] = 622672798;
        iArr[145] = 568075817;
        iArr[146] = 748617968;
        iArr[147] = 677256519;
        iArr[148] = 907627842;
        iArr[149] = 853037301;
        iArr[150] = 1067152940;
        iArr[151] = 995781531;
        iArr[152] = 51762726;
        iArr[153] = 131386257;
        iArr[154] = 177728840;
        iArr[155] = 240578815;
        iArr[156] = 269590778;
        iArr[157] = 349224269;
        iArr[158] = 429104020;
        iArr[159] = 491947555;
        iArr[160] = -248556018;
        iArr[161] = -168932423;
        iArr[162] = -122852000;
        iArr[163] = -60002089;
        iArr[164] = -500490030;
        iArr[165] = -420856475;
        iArr[166] = -341238852;
        iArr[167] = -278395381;
        iArr[168] = -685261898;
        iArr[169] = -739858943;
        iArr[170] = -559578920;
        iArr[171] = -630940305;
        iArr[172] = -1004286614;
        iArr[173] = -1058877219;
        iArr[174] = -845023740;
        iArr[175] = -916395085;
        iArr[176] = -1119974018;
        iArr[177] = -1174433591;
        iArr[178] = -1262701040;
        iArr[179] = -1333941337;
        iArr[180] = -1371866206;
        iArr[181] = -1426332139;
        iArr[182] = -1481064244;
        iArr[183] = -1552294533;
        iArr[184] = -1690935098;
        iArr[185] = -1611170447;
        iArr[186] = -1833673816;
        iArr[187] = -1770699233;
        iArr[188] = -2009983462;
        iArr[189] = -1930228819;
        iArr[190] = -2119160460;
        iArr[191] = -2056179517;
        iArr[192] = 1569362073;
        iArr[193] = 1498123566;
        iArr[194] = 1409854455;
        iArr[195] = 1355396672;
        iArr[196] = 1317987909;
        iArr[197] = 1246755826;
        iArr[198] = 1192025387;
        iArr[199] = 1137557660;
        iArr[200] = 2072149281;
        iArr[201] = 2135122070;
        iArr[202] = 1912620623;
        iArr[203] = 1992383480;
        iArr[204] = 1753615357;
        iArr[205] = 1816598090;
        iArr[206] = 1627664531;
        iArr[207] = 1707420964;
        iArr[208] = 295390185;
        iArr[209] = 358241886;
        iArr[210] = 404320391;
        iArr[211] = 483945776;
        iArr[212] = 43990325;
        iArr[213] = 106832002;
        iArr[214] = 186451547;
        iArr[215] = 266083308;
        iArr[216] = 932423249;
        iArr[217] = 861060070;
        iArr[218] = 1041341759;
        iArr[219] = 986742920;
        iArr[220] = 613929101;
        iArr[221] = 542559546;
        iArr[222] = 756411363;
        iArr[223] = 701822548;
        iArr[224] = -978770311;
        iArr[225] = -1050133554;
        iArr[226] = -869589737;
        iArr[227] = -924188512;
        iArr[228] = -693284699;
        iArr[229] = -764654318;
        iArr[230] = -550540341;
        iArr[231] = -605129092;
        iArr[232] = -475935807;
        iArr[233] = -413084042;
        iArr[234] = -366743377;
        iArr[235] = -287118056;
        iArr[236] = -257573603;
        iArr[237] = -194731862;
        iArr[238] = -114850189;
        iArr[239] = -35218492;
        iArr[240] = -1984365303;
        iArr[241] = -1921392450;
        iArr[242] = -2143631769;
        iArr[243] = -2063868976;
        iArr[244] = -1698919467;
        iArr[245] = -1635936670;
        iArr[246] = -1824608069;
        iArr[247] = -1744851700;
        iArr[248] = -1347415887;
        iArr[249] = -1418654458;
        iArr[250] = -1506661409;
        iArr[251] = -1561119128;
        iArr[252] = -1129027987;
        iArr[253] = -1200260134;
        iArr[254] = -1254728445;
        iArr[255] = -1309196108;
        f18802j = iArr;
    }

    /* renamed from: a */
    public static boolean m20455a(Object o1, Object o2) {
        if (o1 == null) {
            return o2 == null;
        }
        return o1.equals(o2);
    }

    /* renamed from: a */
    public static <T> T m20443a(T value) {
        return value;
    }

    /* renamed from: a */
    public static <T> T[] m20458a(T[] value) {
        return value;
    }

    /* renamed from: a */
    public static <T> T[] m20459a(T[] input, int length) {
        C8514e.m20488a(length <= input.length);
        return Arrays.copyOf(input, length);
    }

    /* renamed from: a */
    public static Handler m20441a(Looper looper, Callback callback) {
        return new Handler(looper, callback);
    }

    /* renamed from: a */
    public static Looper m20442a() {
        Looper myLooper = Looper.myLooper();
        return myLooper != null ? myLooper : Looper.getMainLooper();
    }

    /* renamed from: a */
    static /* synthetic */ Thread m20448a(String threadName, Runnable runnable) {
        return new Thread(runnable, threadName);
    }

    /* renamed from: d */
    public static ExecutorService m20475d(String threadName) {
        return Executors.newSingleThreadExecutor(new C8513d(threadName));
    }

    /* renamed from: a */
    public static void m20450a(C8487i dataSource) {
        if (dataSource != null) {
            try {
                dataSource.close();
            } catch (IOException e) {
            }
        }
    }

    /* renamed from: a */
    public static void m20451a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    /* renamed from: a */
    public static boolean m20454a(Parcel parcel) {
        return parcel.readInt() != 0;
    }

    /* renamed from: a */
    public static void m20449a(Parcel parcel, boolean value) {
        parcel.writeInt(value);
    }

    /* renamed from: e */
    public static String m20476e(String language) {
        String str;
        if (language == null) {
            str = null;
        } else {
            try {
                str = new Locale(language).getISO3Language();
            } catch (MissingResourceException e) {
                return m20480g(language);
            }
        }
        return str;
    }

    /* renamed from: a */
    public static String m20447a(byte[] bytes, int offset, int length) {
        return new String(bytes, offset, length, Charset.forName("UTF-8"));
    }

    /* renamed from: c */
    public static byte[] m20472c(String value) {
        return value.getBytes(Charset.forName("UTF-8"));
    }

    /* renamed from: a */
    public static String[] m20460a(String value, String regex) {
        return value.split(regex, -1);
    }

    /* renamed from: g */
    public static String m20480g(String text) {
        return text == null ? text : text.toLowerCase(Locale.US);
    }

    /* renamed from: h */
    public static String m20481h(String text) {
        return text == null ? text : text.toUpperCase(Locale.US);
    }

    /* renamed from: a */
    public static String m20445a(String format, Object... args) {
        return String.format(Locale.US, format, args);
    }

    /* renamed from: a */
    public static int m20432a(int numerator, int denominator) {
        return ((numerator + denominator) - 1) / denominator;
    }

    /* renamed from: a */
    public static int m20433a(int value, int min, int max) {
        return Math.max(min, Math.min(value, max));
    }

    /* renamed from: b */
    public static long m20467b(long value, long min, long max) {
        return Math.max(min, Math.min(value, max));
    }

    /* renamed from: a */
    public static float m20430a(float value, float min, float max) {
        return Math.max(min, Math.min(value, max));
    }

    /* renamed from: a */
    public static long m20439a(long x, long y, long overflowResult) {
        long result = x + y;
        if (((x ^ result) & (y ^ result)) < 0) {
            return overflowResult;
        }
        return result;
    }

    /* renamed from: d */
    public static long m20474d(long x, long y, long overflowResult) {
        long result = x - y;
        if (((x ^ y) & (x ^ result)) < 0) {
            return overflowResult;
        }
        return result;
    }

    /* renamed from: b */
    public static int m20465b(long[] array, long value, boolean inclusive, boolean stayInBounds) {
        int index = Arrays.binarySearch(array, value);
        if (index < 0) {
            index = -(index + 2);
        } else {
            do {
                index--;
                if (index < 0) {
                    break;
                }
            } while (array[index] == value);
            if (inclusive) {
                index++;
            }
        }
        return stayInBounds ? Math.max(0, index) : index;
    }

    /* renamed from: a */
    public static int m20437a(long[] array, long value, boolean inclusive, boolean stayInBounds) {
        int index = Arrays.binarySearch(array, value);
        if (index < 0) {
            index ^= -1;
        } else {
            do {
                index++;
                if (index >= array.length) {
                    break;
                }
            } while (array[index] == value);
            if (inclusive) {
                index--;
            }
        }
        return stayInBounds ? Math.min(array.length - 1, index) : index;
    }

    /* renamed from: a */
    public static int m20434a(long left, long right) {
        if (left < right) {
            return -1;
        }
        return left == right ? 0 : 1;
    }

    /* renamed from: c */
    public static long m20471c(long timestamp, long multiplier, long divisor) {
        if (divisor >= multiplier && divisor % multiplier == 0) {
            return timestamp / (divisor / multiplier);
        }
        if (divisor < multiplier && multiplier % divisor == 0) {
            return timestamp * (multiplier / divisor);
        }
        double d = (double) multiplier;
        double d2 = (double) divisor;
        Double.isNaN(d);
        Double.isNaN(d2);
        double multiplicationFactor = d / d2;
        double d3 = (double) timestamp;
        Double.isNaN(d3);
        return (long) (d3 * multiplicationFactor);
    }

    /* renamed from: a */
    public static void m20453a(long[] timestamps, long multiplier, long divisor) {
        if (divisor >= multiplier && divisor % multiplier == 0) {
            long divisionFactor = divisor / multiplier;
            for (int i = 0; i < timestamps.length; i++) {
                timestamps[i] = timestamps[i] / divisionFactor;
            }
        } else if (divisor >= multiplier || multiplier % divisor != 0) {
            double d = (double) multiplier;
            double d2 = (double) divisor;
            Double.isNaN(d);
            Double.isNaN(d2);
            double multiplicationFactor = d / d2;
            for (int i2 = 0; i2 < timestamps.length; i2++) {
                double d3 = (double) timestamps[i2];
                Double.isNaN(d3);
                timestamps[i2] = (long) (d3 * multiplicationFactor);
            }
        } else {
            long multiplicationFactor2 = multiplier / divisor;
            for (int i3 = 0; i3 < timestamps.length; i3++) {
                timestamps[i3] = timestamps[i3] * multiplicationFactor2;
            }
        }
    }

    /* renamed from: a */
    public static long m20438a(long playoutDuration, float speed) {
        if (speed == 1.0f) {
            return playoutDuration;
        }
        double d = (double) playoutDuration;
        double d2 = (double) speed;
        Double.isNaN(d);
        Double.isNaN(d2);
        return Math.round(d * d2);
    }

    /* renamed from: b */
    public static long m20466b(long mediaDuration, float speed) {
        if (speed == 1.0f) {
            return mediaDuration;
        }
        double d = (double) mediaDuration;
        double d2 = (double) speed;
        Double.isNaN(d);
        Double.isNaN(d2);
        return Math.round(d / d2);
    }

    /* renamed from: a */
    public static long m20440a(long positionUs, C8096B seekParameters, long firstSyncUs, long secondSyncUs) {
        C8096B b = seekParameters;
        if (C8096B.f16472a.equals(seekParameters)) {
            return positionUs;
        }
        long j = positionUs;
        long minPositionUs = m20474d(j, b.f16477f, Long.MIN_VALUE);
        long maxPositionUs = m20439a(j, b.f16478g, Long.MAX_VALUE);
        boolean secondSyncPositionValid = true;
        boolean firstSyncPositionValid = minPositionUs <= firstSyncUs && firstSyncUs <= maxPositionUs;
        if (minPositionUs > secondSyncUs || secondSyncUs > maxPositionUs) {
            secondSyncPositionValid = false;
        }
        if (!firstSyncPositionValid || !secondSyncPositionValid) {
            if (firstSyncPositionValid) {
                return firstSyncUs;
            }
            if (secondSyncPositionValid) {
                return secondSyncUs;
            }
            return minPositionUs;
        } else if (Math.abs(firstSyncUs - positionUs) <= Math.abs(secondSyncUs - positionUs)) {
            return firstSyncUs;
        } else {
            return secondSyncUs;
        }
    }

    /* renamed from: a */
    public static int[] m20457a(List<Integer> list) {
        if (list == null) {
            return null;
        }
        int length = list.size();
        int[] intArray = new int[length];
        for (int i = 0; i < length; i++) {
            intArray[i] = ((Integer) list.get(i)).intValue();
        }
        return intArray;
    }

    /* renamed from: b */
    public static int m20464b(String string) {
        int length = string.length();
        C8514e.m20488a(length <= 4);
        int result = 0;
        for (int i = 0; i < length; i++) {
            result = (result << 8) | string.charAt(i);
        }
        return result;
    }

    /* renamed from: a */
    public static byte[] m20456a(String hexString) {
        byte[] data = new byte[(hexString.length() / 2)];
        for (int i = 0; i < data.length; i++) {
            int stringOffset = i * 2;
            data[i] = (byte) ((Character.digit(hexString.charAt(stringOffset), 16) << 4) + Character.digit(hexString.charAt(stringOffset + 1), 16));
        }
        return data;
    }

    /* renamed from: b */
    public static String m20468b(Object[] objects) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < objects.length; i++) {
            stringBuilder.append(objects[i].getClass().getSimpleName());
            if (i < objects.length - 1) {
                stringBuilder.append(", ");
            }
        }
        return stringBuilder.toString();
    }

    /* renamed from: f */
    public static String[] m20479f(String codecs) {
        if (TextUtils.isEmpty(codecs)) {
            return new String[0];
        }
        return m20460a(codecs.trim(), "(\\s*,\\s*)");
    }

    /* renamed from: c */
    public static int m20470c(int bitDepth) {
        if (bitDepth == 8) {
            return 3;
        }
        if (bitDepth == 16) {
            return 2;
        }
        if (bitDepth == 24) {
            return LinearLayoutManager.INVALID_OFFSET;
        }
        if (bitDepth != 32) {
            return 0;
        }
        return 1073741824;
    }

    /* renamed from: f */
    public static boolean m20478f(int encoding) {
        return encoding == 3 || encoding == 2 || encoding == Integer.MIN_VALUE || encoding == 1073741824 || encoding == 4;
    }

    /* renamed from: e */
    public static boolean m20477e(int encoding) {
        return encoding == Integer.MIN_VALUE || encoding == 1073741824;
    }

    /* renamed from: a */
    public static int m20431a(int channelCount) {
        switch (channelCount) {
            case 1:
                return 4;
            case 2:
                return 12;
            case 3:
                return 28;
            case 4:
                return 204;
            case 5:
                return 220;
            case 6:
                return 252;
            case 7:
                return 1276;
            case 8:
                int i = f18793a;
                if (i < 23 && i < 21) {
                    return 0;
                }
                return 6396;
            default:
                return 0;
        }
    }

    /* renamed from: b */
    public static int m20462b(int pcmEncoding, int channelCount) {
        if (pcmEncoding == Integer.MIN_VALUE) {
            return channelCount * 3;
        }
        if (pcmEncoding != 1073741824) {
            if (pcmEncoding == 2) {
                return channelCount * 2;
            }
            if (pcmEncoding == 3) {
                return channelCount;
            }
            if (pcmEncoding != 4) {
                throw new IllegalArgumentException();
            }
        }
        return channelCount * 4;
    }

    /* renamed from: d */
    public static int m20473d(int usage) {
        switch (usage) {
            case 1:
            case 12:
            case 14:
                return 3;
            case 2:
                return 0;
            case 3:
                return 8;
            case 4:
                return 4;
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
                return 5;
            case 6:
                return 2;
            case 13:
                return 1;
            default:
                return 3;
        }
    }

    /* renamed from: a */
    public static String m20446a(StringBuilder builder, Formatter formatter, long timeMs) {
        long timeMs2;
        Formatter formatter2 = formatter;
        if (timeMs == -9223372036854775807L) {
            timeMs2 = 0;
        } else {
            timeMs2 = timeMs;
        }
        long totalSeconds = (500 + timeMs2) / 1000;
        long seconds = totalSeconds % 60;
        long minutes = (totalSeconds / 60) % 60;
        long hours = totalSeconds / 3600;
        builder.setLength(0);
        if (hours > 0) {
            return formatter2.format("%d:%02d:%02d", new Object[]{Long.valueOf(hours), Long.valueOf(minutes), Long.valueOf(seconds)}).toString();
        }
        return formatter2.format("%02d:%02d", new Object[]{Long.valueOf(minutes), Long.valueOf(seconds)}).toString();
    }

    /* renamed from: b */
    public static int m20461b(int trackType) {
        switch (trackType) {
            case 0:
                return 16777216;
            case 1:
                return 3538944;
            case 2:
                return 13107200;
            case 3:
                return Opcodes.ACC_DEPRECATED;
            case 4:
                return Opcodes.ACC_DEPRECATED;
            case 5:
                return Opcodes.ACC_DEPRECATED;
            case 6:
                return 0;
            default:
                throw new IllegalArgumentException();
        }
    }

    /* renamed from: i */
    public static String m20482i(String fileName) {
        int length = fileName.length();
        int percentCharacterCount = 0;
        for (int i = 0; i < length; i++) {
            if (fileName.charAt(i) == '%') {
                percentCharacterCount++;
            }
        }
        if (percentCharacterCount == 0) {
            return fileName;
        }
        int expectedLength = length - (percentCharacterCount * 2);
        StringBuilder builder = new StringBuilder(expectedLength);
        Matcher matcher = f18801i.matcher(fileName);
        int startOfNotEscaped = 0;
        while (percentCharacterCount > 0 && matcher.find()) {
            char unescapedCharacter = (char) Integer.parseInt(matcher.group(1), 16);
            builder.append(fileName, startOfNotEscaped, matcher.start());
            builder.append(unescapedCharacter);
            startOfNotEscaped = matcher.end();
            percentCharacterCount--;
        }
        if (startOfNotEscaped < length) {
            builder.append(fileName, startOfNotEscaped, length);
        }
        if (builder.length() != expectedLength) {
            return null;
        }
        return builder.toString();
    }

    /* renamed from: a */
    public static void m20452a(Throwable t) {
        m20469b(t);
        throw null;
    }

    /* renamed from: b */
    private static <T extends Throwable> void m20469b(Throwable t) throws Throwable {
        throw t;
    }

    /* renamed from: a */
    public static int m20436a(byte[] bytes, int start, int end, int initialValue) {
        for (int i = start; i < end; i++) {
            initialValue = (initialValue << 8) ^ f18802j[((initialValue >>> 24) ^ (bytes[i] & 255)) & 255];
        }
        return initialValue;
    }

    /* renamed from: b */
    public static int m20463b(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return 0;
            }
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo == null || !networkInfo.isConnected()) {
                return 1;
            }
            int type = networkInfo.getType();
            if (type != 0) {
                if (type == 1) {
                    return 2;
                }
                if (!(type == 4 || type == 5)) {
                    if (type == 6) {
                        return 5;
                    }
                    if (type != 9) {
                        return 8;
                    }
                    return 7;
                }
            }
            return m20435a(networkInfo);
        } catch (SecurityException e) {
            return 0;
        }
    }

    /* renamed from: a */
    public static String m20444a(Context context) {
        if (context != null) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                String countryCode = telephonyManager.getNetworkCountryIso();
                if (!TextUtils.isEmpty(countryCode)) {
                    return m20481h(countryCode);
                }
            }
        }
        return m20481h(Locale.getDefault().getCountry());
    }

    /* renamed from: a */
    private static int m20435a(NetworkInfo networkInfo) {
        switch (networkInfo.getSubtype()) {
            case 1:
            case 2:
                return 3;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 14:
            case 15:
            case 17:
                return 4;
            case 13:
                return 5;
            case 18:
                return 2;
            default:
                return 6;
        }
    }
}
