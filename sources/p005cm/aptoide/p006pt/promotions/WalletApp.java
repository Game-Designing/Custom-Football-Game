package p005cm.aptoide.p006pt.promotions;

import kotlin.p376c.p378b.C14281f;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p005cm.aptoide.p006pt.app.DownloadModel;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Obb;

/* renamed from: cm.aptoide.pt.promotions.WalletApp */
/* compiled from: WalletApp.kt */
public final class WalletApp {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String appName;
    private final String developer;
    private DownloadModel downloadModel;
    private final String icon;

    /* renamed from: id */
    private final long f8105id;
    private boolean isInstalled;
    private final String md5sum;
    private final Obb obb;
    private final String packageName;
    private final String path;
    private final String pathAlt;
    private final long size;
    private final int versionCode;
    private final String versionName;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7455481621443099611L, "cm/aptoide/pt/promotions/WalletApp", Opcodes.I2S);
        $jacocoData = probes;
        return probes;
    }

    public WalletApp() {
        boolean[] $jacocoInit = $jacocoInit();
        this(null, false, null, null, 0, null, null, 0, null, null, null, null, 0, null, 16383, null);
        $jacocoInit[51] = true;
    }

    public static /* synthetic */ WalletApp copy$default(WalletApp walletApp, DownloadModel downloadModel2, boolean z, String str, String str2, long j, String str3, String str4, int i, String str5, String str6, String str7, Obb obb2, long j2, String str8, int i2, Object obj) {
        DownloadModel downloadModel3;
        boolean z2;
        String str9;
        String str10;
        long j3;
        String str11;
        String str12;
        int i3;
        String str13;
        String str14;
        String str15;
        boolean z3;
        Obb obb3;
        String str16;
        String str17;
        long j4;
        String str18;
        WalletApp walletApp2 = walletApp;
        int i4 = i2;
        boolean[] $jacocoInit = $jacocoInit();
        if ((i4 & 1) == 0) {
            $jacocoInit[67] = true;
            downloadModel3 = downloadModel2;
        } else {
            downloadModel3 = walletApp2.downloadModel;
            $jacocoInit[68] = true;
        }
        if ((i4 & 2) == 0) {
            $jacocoInit[69] = true;
            z2 = z;
        } else {
            z2 = walletApp2.isInstalled;
            $jacocoInit[70] = true;
        }
        if ((i4 & 4) == 0) {
            $jacocoInit[71] = true;
            str9 = str;
        } else {
            str9 = walletApp2.appName;
            $jacocoInit[72] = true;
        }
        if ((i4 & 8) == 0) {
            $jacocoInit[73] = true;
            str10 = str2;
        } else {
            str10 = walletApp2.icon;
            $jacocoInit[74] = true;
        }
        if ((i4 & 16) == 0) {
            $jacocoInit[75] = true;
            j3 = j;
        } else {
            j3 = walletApp2.f8105id;
            $jacocoInit[76] = true;
        }
        if ((i4 & 32) == 0) {
            $jacocoInit[77] = true;
            str11 = str3;
        } else {
            str11 = walletApp2.packageName;
            $jacocoInit[78] = true;
        }
        if ((i4 & 64) == 0) {
            $jacocoInit[79] = true;
            str12 = str4;
        } else {
            str12 = walletApp2.md5sum;
            $jacocoInit[80] = true;
        }
        if ((i4 & 128) == 0) {
            $jacocoInit[81] = true;
            i3 = i;
        } else {
            i3 = walletApp2.versionCode;
            $jacocoInit[82] = true;
        }
        if ((i4 & Opcodes.ACC_NATIVE) == 0) {
            $jacocoInit[83] = true;
            str13 = str5;
        } else {
            str13 = walletApp2.versionName;
            $jacocoInit[84] = true;
        }
        if ((i4 & 512) == 0) {
            $jacocoInit[85] = true;
            str14 = str6;
        } else {
            str14 = walletApp2.path;
            $jacocoInit[86] = true;
        }
        if ((i4 & Opcodes.ACC_ABSTRACT) == 0) {
            $jacocoInit[87] = true;
            str15 = str7;
        } else {
            str15 = walletApp2.pathAlt;
            $jacocoInit[88] = true;
        }
        if ((i4 & Opcodes.ACC_STRICT) == 0) {
            z3 = true;
            $jacocoInit[89] = true;
            obb3 = obb2;
        } else {
            z3 = true;
            obb3 = walletApp2.obb;
            $jacocoInit[90] = true;
        }
        Obb obb4 = obb3;
        if ((i4 & Opcodes.ACC_SYNTHETIC) == 0) {
            $jacocoInit[91] = z3;
            str17 = str14;
            str16 = str15;
            j4 = j2;
        } else {
            str17 = str14;
            str16 = str15;
            j4 = walletApp2.size;
            $jacocoInit[92] = z3;
        }
        if ((i4 & Opcodes.ACC_ANNOTATION) == 0) {
            $jacocoInit[93] = z3;
            str18 = str8;
        } else {
            str18 = walletApp2.developer;
            $jacocoInit[94] = z3;
        }
        WalletApp copy = walletApp.copy(downloadModel3, z2, str9, str10, j3, str11, str12, i3, str13, str17, str16, obb4, j4, str18);
        $jacocoInit[95] = true;
        return copy;
    }

    public final DownloadModel component1() {
        boolean[] $jacocoInit = $jacocoInit();
        DownloadModel downloadModel2 = this.downloadModel;
        $jacocoInit[52] = true;
        return downloadModel2;
    }

    public final String component10() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.path;
        $jacocoInit[61] = true;
        return str;
    }

    public final String component11() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.pathAlt;
        $jacocoInit[62] = true;
        return str;
    }

    public final Obb component12() {
        boolean[] $jacocoInit = $jacocoInit();
        Obb obb2 = this.obb;
        $jacocoInit[63] = true;
        return obb2;
    }

    public final long component13() {
        boolean[] $jacocoInit = $jacocoInit();
        long j = this.size;
        $jacocoInit[64] = true;
        return j;
    }

    public final String component14() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.developer;
        $jacocoInit[65] = true;
        return str;
    }

    public final boolean component2() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.isInstalled;
        $jacocoInit[53] = true;
        return z;
    }

    public final String component3() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.appName;
        $jacocoInit[54] = true;
        return str;
    }

    public final String component4() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.icon;
        $jacocoInit[55] = true;
        return str;
    }

    public final long component5() {
        boolean[] $jacocoInit = $jacocoInit();
        long j = this.f8105id;
        $jacocoInit[56] = true;
        return j;
    }

    public final String component6() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.packageName;
        $jacocoInit[57] = true;
        return str;
    }

    public final String component7() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.md5sum;
        $jacocoInit[58] = true;
        return str;
    }

    public final int component8() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.versionCode;
        $jacocoInit[59] = true;
        return i;
    }

    public final String component9() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.versionName;
        $jacocoInit[60] = true;
        return str;
    }

    public final WalletApp copy(DownloadModel downloadModel2, boolean z, String str, String str2, long j, String str3, String str4, int i, String str5, String str6, String str7, Obb obb2, long j2, String str8) {
        DownloadModel downloadModel3 = downloadModel2;
        boolean z2 = z;
        String str9 = str;
        String str10 = str2;
        long j3 = j;
        String str11 = str3;
        String str12 = str4;
        int i2 = i;
        String str13 = str5;
        String str14 = str6;
        String str15 = str7;
        Obb obb3 = obb2;
        long j4 = j2;
        String str16 = str8;
        boolean[] $jacocoInit = $jacocoInit();
        DownloadModel downloadModel4 = downloadModel3;
        C14281f.m45916b(str, "appName");
        C14281f.m45916b(str2, "icon");
        C14281f.m45916b(str3, "packageName");
        C14281f.m45916b(str8, "developer");
        WalletApp walletApp = new WalletApp(downloadModel4, z2, str9, str10, j3, str11, str12, i2, str13, str14, str15, obb3, j4, str16);
        $jacocoInit[66] = true;
        return walletApp;
    }

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean[] $jacocoInit = $jacocoInit();
        if (this == obj) {
            $jacocoInit[120] = true;
        } else {
            if (!(obj instanceof WalletApp)) {
                $jacocoInit[121] = true;
            } else {
                WalletApp walletApp = (WalletApp) obj;
                if (!C14281f.m45915a((Object) this.downloadModel, (Object) walletApp.downloadModel)) {
                    $jacocoInit[122] = true;
                } else {
                    if (this.isInstalled == walletApp.isInstalled) {
                        $jacocoInit[123] = true;
                        z = true;
                    } else {
                        $jacocoInit[124] = true;
                        z = false;
                    }
                    if (!z) {
                        $jacocoInit[125] = true;
                    } else if (!C14281f.m45915a((Object) this.appName, (Object) walletApp.appName)) {
                        $jacocoInit[126] = true;
                    } else if (!C14281f.m45915a((Object) this.icon, (Object) walletApp.icon)) {
                        $jacocoInit[127] = true;
                    } else {
                        if (this.f8105id == walletApp.f8105id) {
                            $jacocoInit[128] = true;
                            z2 = true;
                        } else {
                            $jacocoInit[129] = true;
                            z2 = false;
                        }
                        if (!z2) {
                            $jacocoInit[130] = true;
                        } else if (!C14281f.m45915a((Object) this.packageName, (Object) walletApp.packageName)) {
                            $jacocoInit[131] = true;
                        } else if (!C14281f.m45915a((Object) this.md5sum, (Object) walletApp.md5sum)) {
                            $jacocoInit[132] = true;
                        } else {
                            if (this.versionCode == walletApp.versionCode) {
                                $jacocoInit[133] = true;
                                z3 = true;
                            } else {
                                $jacocoInit[134] = true;
                                z3 = false;
                            }
                            if (!z3) {
                                $jacocoInit[135] = true;
                            } else if (!C14281f.m45915a((Object) this.versionName, (Object) walletApp.versionName)) {
                                $jacocoInit[136] = true;
                            } else if (!C14281f.m45915a((Object) this.path, (Object) walletApp.path)) {
                                $jacocoInit[137] = true;
                            } else if (!C14281f.m45915a((Object) this.pathAlt, (Object) walletApp.pathAlt)) {
                                $jacocoInit[138] = true;
                            } else if (!C14281f.m45915a((Object) this.obb, (Object) walletApp.obb)) {
                                $jacocoInit[139] = true;
                            } else {
                                if (this.size == walletApp.size) {
                                    $jacocoInit[140] = true;
                                    z4 = true;
                                } else {
                                    $jacocoInit[141] = true;
                                    z4 = false;
                                }
                                if (!z4) {
                                    $jacocoInit[142] = true;
                                } else if (!C14281f.m45915a((Object) this.developer, (Object) walletApp.developer)) {
                                    $jacocoInit[143] = true;
                                } else {
                                    $jacocoInit[144] = true;
                                }
                            }
                        }
                    }
                }
            }
            $jacocoInit[146] = true;
            return false;
        }
        $jacocoInit[145] = true;
        return true;
    }

    public int hashCode() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean[] $jacocoInit = $jacocoInit();
        DownloadModel downloadModel2 = this.downloadModel;
        int i10 = 0;
        if (downloadModel2 != null) {
            i = downloadModel2.hashCode();
            $jacocoInit[97] = true;
        } else {
            $jacocoInit[98] = true;
            i = 0;
        }
        int i11 = i * 31;
        boolean z = this.isInstalled;
        if (!z) {
            $jacocoInit[99] = true;
        } else {
            $jacocoInit[100] = true;
            z = true;
        }
        int i12 = (i11 + (z ? 1 : 0)) * 31;
        String str = this.appName;
        if (str != null) {
            i2 = str.hashCode();
            $jacocoInit[101] = true;
        } else {
            $jacocoInit[102] = true;
            i2 = 0;
        }
        int i13 = (i12 + i2) * 31;
        String str2 = this.icon;
        if (str2 != null) {
            i3 = str2.hashCode();
            $jacocoInit[103] = true;
        } else {
            $jacocoInit[104] = true;
            i3 = 0;
        }
        int i14 = (i13 + i3) * 31;
        long j = this.f8105id;
        int i15 = (i14 + ((int) (j ^ (j >>> 32)))) * 31;
        String str3 = this.packageName;
        if (str3 != null) {
            i4 = str3.hashCode();
            $jacocoInit[105] = true;
        } else {
            $jacocoInit[106] = true;
            i4 = 0;
        }
        int i16 = (i15 + i4) * 31;
        String str4 = this.md5sum;
        if (str4 != null) {
            i5 = str4.hashCode();
            $jacocoInit[107] = true;
        } else {
            $jacocoInit[108] = true;
            i5 = 0;
        }
        int i17 = (((i16 + i5) * 31) + this.versionCode) * 31;
        String str5 = this.versionName;
        if (str5 != null) {
            i6 = str5.hashCode();
            $jacocoInit[109] = true;
        } else {
            $jacocoInit[110] = true;
            i6 = 0;
        }
        int i18 = (i17 + i6) * 31;
        String str6 = this.path;
        if (str6 != null) {
            i7 = str6.hashCode();
            $jacocoInit[111] = true;
        } else {
            $jacocoInit[112] = true;
            i7 = 0;
        }
        int i19 = (i18 + i7) * 31;
        String str7 = this.pathAlt;
        if (str7 != null) {
            i8 = str7.hashCode();
            $jacocoInit[113] = true;
        } else {
            $jacocoInit[114] = true;
            i8 = 0;
        }
        int i20 = (i19 + i8) * 31;
        Obb obb2 = this.obb;
        if (obb2 != null) {
            i9 = obb2.hashCode();
            $jacocoInit[115] = true;
        } else {
            $jacocoInit[116] = true;
            i9 = 0;
        }
        int i21 = (i20 + i9) * 31;
        long j2 = this.size;
        int i22 = (i21 + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        String str8 = this.developer;
        if (str8 != null) {
            i10 = str8.hashCode();
            $jacocoInit[117] = true;
        } else {
            $jacocoInit[118] = true;
        }
        int i23 = i22 + i10;
        $jacocoInit[119] = true;
        return i23;
    }

    public String toString() {
        boolean[] $jacocoInit = $jacocoInit();
        StringBuilder sb = new StringBuilder();
        sb.append("WalletApp(downloadModel=");
        sb.append(this.downloadModel);
        sb.append(", isInstalled=");
        sb.append(this.isInstalled);
        sb.append(", appName=");
        sb.append(this.appName);
        sb.append(", icon=");
        sb.append(this.icon);
        sb.append(", id=");
        sb.append(this.f8105id);
        sb.append(", packageName=");
        sb.append(this.packageName);
        sb.append(", md5sum=");
        sb.append(this.md5sum);
        sb.append(", versionCode=");
        sb.append(this.versionCode);
        sb.append(", versionName=");
        sb.append(this.versionName);
        sb.append(", path=");
        sb.append(this.path);
        sb.append(", pathAlt=");
        sb.append(this.pathAlt);
        sb.append(", obb=");
        sb.append(this.obb);
        sb.append(", size=");
        sb.append(this.size);
        sb.append(", developer=");
        sb.append(this.developer);
        sb.append(")");
        String sb2 = sb.toString();
        $jacocoInit[96] = true;
        return sb2;
    }

    public WalletApp(DownloadModel downloadModel2, boolean isInstalled2, String appName2, String icon2, long id, String packageName2, String md5sum2, int versionCode2, String versionName2, String path2, String pathAlt2, Obb obb2, long size2, String developer2) {
        String str = appName2;
        String str2 = icon2;
        String str3 = packageName2;
        String str4 = developer2;
        boolean[] $jacocoInit = $jacocoInit();
        C14281f.m45916b(str, "appName");
        C14281f.m45916b(str2, "icon");
        C14281f.m45916b(str3, "packageName");
        C14281f.m45916b(str4, "developer");
        $jacocoInit[19] = true;
        this.downloadModel = downloadModel2;
        this.isInstalled = isInstalled2;
        this.appName = str;
        this.icon = str2;
        this.f8105id = id;
        this.packageName = str3;
        this.md5sum = md5sum2;
        this.versionCode = versionCode2;
        this.versionName = versionName2;
        this.path = path2;
        this.pathAlt = pathAlt2;
        this.obb = obb2;
        this.size = size2;
        this.developer = str4;
        $jacocoInit[20] = true;
    }

    public /* synthetic */ WalletApp(DownloadModel downloadModel2, boolean z, String str, String str2, long j, String str3, String str4, int i, String str5, String str6, String str7, Obb obb2, long j2, String str8, int i2, C14280e eVar) {
        DownloadModel downloadModel3;
        boolean z2;
        String str9;
        String str10;
        long j3;
        String str11;
        String str12;
        int i3;
        String str13;
        String str14;
        String str15;
        boolean z3;
        Obb obb3;
        long j4;
        String str16;
        int i4 = i2;
        boolean[] $jacocoInit = $jacocoInit();
        if ((i4 & 1) == 0) {
            $jacocoInit[21] = true;
            downloadModel3 = downloadModel2;
        } else {
            $jacocoInit[22] = true;
            downloadModel3 = null;
        }
        if ((i4 & 2) == 0) {
            $jacocoInit[23] = true;
            z2 = z;
        } else {
            z2 = false;
            $jacocoInit[24] = true;
        }
        String str17 = "";
        if ((i4 & 4) == 0) {
            $jacocoInit[25] = true;
            str9 = str;
        } else {
            $jacocoInit[26] = true;
            str9 = str17;
        }
        if ((i4 & 8) == 0) {
            $jacocoInit[27] = true;
            str10 = str2;
        } else {
            $jacocoInit[28] = true;
            str10 = str17;
        }
        if ((i4 & 16) == 0) {
            $jacocoInit[29] = true;
            j3 = j;
        } else {
            j3 = -1;
            $jacocoInit[30] = true;
        }
        if ((i4 & 32) == 0) {
            $jacocoInit[31] = true;
            str11 = str3;
        } else {
            $jacocoInit[32] = true;
            str11 = str17;
        }
        if ((i4 & 64) == 0) {
            $jacocoInit[33] = true;
            str12 = str4;
        } else {
            $jacocoInit[34] = true;
            str12 = null;
        }
        if ((i4 & 128) == 0) {
            $jacocoInit[35] = true;
            i3 = i;
        } else {
            i3 = -1;
            $jacocoInit[36] = true;
        }
        if ((i4 & Opcodes.ACC_NATIVE) == 0) {
            $jacocoInit[37] = true;
            str13 = str5;
        } else {
            $jacocoInit[38] = true;
            str13 = null;
        }
        if ((i4 & 512) == 0) {
            $jacocoInit[39] = true;
            str14 = str6;
        } else {
            $jacocoInit[40] = true;
            str14 = null;
        }
        if ((i4 & Opcodes.ACC_ABSTRACT) == 0) {
            $jacocoInit[41] = true;
            str15 = str7;
        } else {
            $jacocoInit[42] = true;
            str15 = null;
        }
        if ((i4 & Opcodes.ACC_STRICT) == 0) {
            z3 = true;
            $jacocoInit[43] = true;
            obb3 = obb2;
        } else {
            z3 = true;
            $jacocoInit[44] = true;
            obb3 = null;
        }
        String str18 = str17;
        if ((i4 & Opcodes.ACC_SYNTHETIC) == 0) {
            $jacocoInit[45] = z3;
            j4 = j2;
        } else {
            j4 = 0;
            $jacocoInit[46] = z3;
        }
        if ((i4 & Opcodes.ACC_ANNOTATION) == 0) {
            $jacocoInit[47] = z3;
            str16 = str8;
        } else {
            $jacocoInit[48] = z3;
            $jacocoInit[49] = z3;
            str16 = str18;
        }
        this(downloadModel3, z2, str9, str10, j3, str11, str12, i3, str13, str14, str15, obb3, j4, str16);
        $jacocoInit[50] = true;
    }

    public final DownloadModel getDownloadModel() {
        boolean[] $jacocoInit = $jacocoInit();
        DownloadModel downloadModel2 = this.downloadModel;
        $jacocoInit[3] = true;
        return downloadModel2;
    }

    public final void setDownloadModel(DownloadModel downloadModel2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.downloadModel = downloadModel2;
        $jacocoInit[4] = true;
    }

    public final boolean isInstalled() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.isInstalled;
        $jacocoInit[5] = true;
        return z;
    }

    public final void setInstalled(boolean z) {
        boolean[] $jacocoInit = $jacocoInit();
        this.isInstalled = z;
        $jacocoInit[6] = true;
    }

    public final String getAppName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.appName;
        $jacocoInit[7] = true;
        return str;
    }

    public final String getIcon() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.icon;
        $jacocoInit[8] = true;
        return str;
    }

    public final long getId() {
        boolean[] $jacocoInit = $jacocoInit();
        long j = this.f8105id;
        $jacocoInit[9] = true;
        return j;
    }

    public final String getPackageName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.packageName;
        $jacocoInit[10] = true;
        return str;
    }

    public final String getMd5sum() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.md5sum;
        $jacocoInit[11] = true;
        return str;
    }

    public final int getVersionCode() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.versionCode;
        $jacocoInit[12] = true;
        return i;
    }

    public final String getVersionName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.versionName;
        $jacocoInit[13] = true;
        return str;
    }

    public final String getPath() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.path;
        $jacocoInit[14] = true;
        return str;
    }

    public final String getPathAlt() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.pathAlt;
        $jacocoInit[15] = true;
        return str;
    }

    public final Obb getObb() {
        boolean[] $jacocoInit = $jacocoInit();
        Obb obb2 = this.obb;
        $jacocoInit[16] = true;
        return obb2;
    }

    public final long getSize() {
        boolean[] $jacocoInit = $jacocoInit();
        long j = this.size;
        $jacocoInit[17] = true;
        return j;
    }

    public final String getDeveloper() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.developer;
        $jacocoInit[18] = true;
        return str;
    }

    public final boolean exists() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = false;
        if (this.f8105id != -1) {
            $jacocoInit[0] = true;
            z = true;
        } else {
            $jacocoInit[1] = true;
        }
        $jacocoInit[2] = true;
        return z;
    }
}
