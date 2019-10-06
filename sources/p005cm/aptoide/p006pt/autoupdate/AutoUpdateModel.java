package p005cm.aptoide.p006pt.autoupdate;

import kotlin.p376c.p378b.C14281f;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p005cm.aptoide.p006pt.DeepLinkIntentReceiver.DeepLinksKeys;

/* renamed from: cm.aptoide.pt.autoupdate.AutoUpdateModel */
/* compiled from: AutoUpdateModel.kt */
public final class AutoUpdateModel {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private boolean loading;
    private final String md5;
    private final String minSdk;
    private final String packageName;
    private final boolean shouldUpdate;
    private Status status;
    private final String uri;
    private final int versionCode;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-81761879104039597L, "cm/aptoide/pt/autoupdate/AutoUpdateModel", 87);
        $jacocoData = probes;
        return probes;
    }

    public static /* synthetic */ AutoUpdateModel copy$default(AutoUpdateModel autoUpdateModel, int i, String str, String str2, String str3, String str4, boolean z, Status status2, boolean z2, int i2, Object obj) {
        int i3;
        String str5;
        String str6;
        String str7;
        String str8;
        boolean z3;
        Status status3;
        boolean z4;
        AutoUpdateModel autoUpdateModel2 = autoUpdateModel;
        int i4 = i2;
        boolean[] $jacocoInit = $jacocoInit();
        if ((i4 & 1) == 0) {
            $jacocoInit[35] = true;
            i3 = i;
        } else {
            i3 = autoUpdateModel2.versionCode;
            $jacocoInit[36] = true;
        }
        if ((i4 & 2) == 0) {
            $jacocoInit[37] = true;
            str5 = str;
        } else {
            str5 = autoUpdateModel2.uri;
            $jacocoInit[38] = true;
        }
        if ((i4 & 4) == 0) {
            $jacocoInit[39] = true;
            str6 = str2;
        } else {
            str6 = autoUpdateModel2.md5;
            $jacocoInit[40] = true;
        }
        if ((i4 & 8) == 0) {
            $jacocoInit[41] = true;
            str7 = str3;
        } else {
            str7 = autoUpdateModel2.minSdk;
            $jacocoInit[42] = true;
        }
        if ((i4 & 16) == 0) {
            $jacocoInit[43] = true;
            str8 = str4;
        } else {
            str8 = autoUpdateModel2.packageName;
            $jacocoInit[44] = true;
        }
        if ((i4 & 32) == 0) {
            $jacocoInit[45] = true;
            z3 = z;
        } else {
            z3 = autoUpdateModel2.shouldUpdate;
            $jacocoInit[46] = true;
        }
        if ((i4 & 64) == 0) {
            $jacocoInit[47] = true;
            status3 = status2;
        } else {
            status3 = autoUpdateModel2.status;
            $jacocoInit[48] = true;
        }
        if ((i4 & 128) == 0) {
            $jacocoInit[49] = true;
            z4 = z2;
        } else {
            z4 = autoUpdateModel2.loading;
            $jacocoInit[50] = true;
        }
        AutoUpdateModel copy = autoUpdateModel.copy(i3, str5, str6, str7, str8, z3, status3, z4);
        $jacocoInit[51] = true;
        return copy;
    }

    public final int component1() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.versionCode;
        $jacocoInit[26] = true;
        return i;
    }

    public final String component2() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.uri;
        $jacocoInit[27] = true;
        return str;
    }

    public final String component3() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.md5;
        $jacocoInit[28] = true;
        return str;
    }

    public final String component4() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.minSdk;
        $jacocoInit[29] = true;
        return str;
    }

    public final String component5() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.packageName;
        $jacocoInit[30] = true;
        return str;
    }

    public final boolean component6() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.shouldUpdate;
        $jacocoInit[31] = true;
        return z;
    }

    public final Status component7() {
        boolean[] $jacocoInit = $jacocoInit();
        Status status2 = this.status;
        $jacocoInit[32] = true;
        return status2;
    }

    public final boolean component8() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.loading;
        $jacocoInit[33] = true;
        return z;
    }

    public final AutoUpdateModel copy(int i, String str, String str2, String str3, String str4, boolean z, Status status2, boolean z2) {
        boolean[] $jacocoInit = $jacocoInit();
        C14281f.m45916b(str, DeepLinksKeys.URI);
        C14281f.m45916b(str2, "md5");
        C14281f.m45916b(str3, "minSdk");
        C14281f.m45916b(str4, "packageName");
        C14281f.m45916b(status2, "status");
        AutoUpdateModel autoUpdateModel = new AutoUpdateModel(i, str, str2, str3, str4, z, status2, z2);
        $jacocoInit[34] = true;
        return autoUpdateModel;
    }

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean[] $jacocoInit = $jacocoInit();
        if (this == obj) {
            $jacocoInit[68] = true;
        } else {
            if (!(obj instanceof AutoUpdateModel)) {
                $jacocoInit[69] = true;
            } else {
                AutoUpdateModel autoUpdateModel = (AutoUpdateModel) obj;
                if (this.versionCode == autoUpdateModel.versionCode) {
                    $jacocoInit[70] = true;
                    z = true;
                } else {
                    $jacocoInit[71] = true;
                    z = false;
                }
                if (!z) {
                    $jacocoInit[72] = true;
                } else if (!C14281f.m45915a((Object) this.uri, (Object) autoUpdateModel.uri)) {
                    $jacocoInit[73] = true;
                } else if (!C14281f.m45915a((Object) this.md5, (Object) autoUpdateModel.md5)) {
                    $jacocoInit[74] = true;
                } else if (!C14281f.m45915a((Object) this.minSdk, (Object) autoUpdateModel.minSdk)) {
                    $jacocoInit[75] = true;
                } else if (!C14281f.m45915a((Object) this.packageName, (Object) autoUpdateModel.packageName)) {
                    $jacocoInit[76] = true;
                } else {
                    if (this.shouldUpdate == autoUpdateModel.shouldUpdate) {
                        $jacocoInit[77] = true;
                        z2 = true;
                    } else {
                        $jacocoInit[78] = true;
                        z2 = false;
                    }
                    if (!z2) {
                        $jacocoInit[79] = true;
                    } else if (!C14281f.m45915a((Object) this.status, (Object) autoUpdateModel.status)) {
                        $jacocoInit[80] = true;
                    } else {
                        if (this.loading == autoUpdateModel.loading) {
                            $jacocoInit[81] = true;
                            z3 = true;
                        } else {
                            $jacocoInit[82] = true;
                            z3 = false;
                        }
                        if (!z3) {
                            $jacocoInit[83] = true;
                        } else {
                            $jacocoInit[84] = true;
                        }
                    }
                }
            }
            $jacocoInit[86] = true;
            return false;
        }
        $jacocoInit[85] = true;
        return true;
    }

    public int hashCode() {
        int i;
        int i2;
        int i3;
        int i4;
        boolean[] $jacocoInit = $jacocoInit();
        int i5 = this.versionCode * 31;
        String str = this.uri;
        int i6 = 0;
        if (str != null) {
            i = str.hashCode();
            $jacocoInit[53] = true;
        } else {
            $jacocoInit[54] = true;
            i = 0;
        }
        int i7 = (i5 + i) * 31;
        String str2 = this.md5;
        if (str2 != null) {
            i2 = str2.hashCode();
            $jacocoInit[55] = true;
        } else {
            $jacocoInit[56] = true;
            i2 = 0;
        }
        int i8 = (i7 + i2) * 31;
        String str3 = this.minSdk;
        if (str3 != null) {
            i3 = str3.hashCode();
            $jacocoInit[57] = true;
        } else {
            $jacocoInit[58] = true;
            i3 = 0;
        }
        int i9 = (i8 + i3) * 31;
        String str4 = this.packageName;
        if (str4 != null) {
            i4 = str4.hashCode();
            $jacocoInit[59] = true;
        } else {
            $jacocoInit[60] = true;
            i4 = 0;
        }
        int i10 = (i9 + i4) * 31;
        boolean z = this.shouldUpdate;
        if (!z) {
            $jacocoInit[61] = true;
        } else {
            $jacocoInit[62] = true;
            z = true;
        }
        int i11 = (i10 + (z ? 1 : 0)) * 31;
        Status status2 = this.status;
        if (status2 != null) {
            i6 = status2.hashCode();
            $jacocoInit[63] = true;
        } else {
            $jacocoInit[64] = true;
        }
        int i12 = (i11 + i6) * 31;
        boolean z2 = this.loading;
        if (!z2) {
            $jacocoInit[65] = true;
        } else {
            $jacocoInit[66] = true;
            z2 = true;
        }
        int i13 = i12 + (z2 ? 1 : 0);
        $jacocoInit[67] = true;
        return i13;
    }

    public String toString() {
        boolean[] $jacocoInit = $jacocoInit();
        StringBuilder sb = new StringBuilder();
        sb.append("AutoUpdateModel(versionCode=");
        sb.append(this.versionCode);
        sb.append(", uri=");
        sb.append(this.uri);
        sb.append(", md5=");
        sb.append(this.md5);
        sb.append(", minSdk=");
        sb.append(this.minSdk);
        sb.append(", packageName=");
        sb.append(this.packageName);
        sb.append(", shouldUpdate=");
        sb.append(this.shouldUpdate);
        sb.append(", status=");
        sb.append(this.status);
        sb.append(", loading=");
        sb.append(this.loading);
        sb.append(")");
        String sb2 = sb.toString();
        $jacocoInit[52] = true;
        return sb2;
    }

    public AutoUpdateModel(int versionCode2, String uri2, String md52, String minSdk2, String packageName2, boolean shouldUpdate2, Status status2, boolean loading2) {
        boolean[] $jacocoInit = $jacocoInit();
        C14281f.m45916b(uri2, DeepLinksKeys.URI);
        C14281f.m45916b(md52, "md5");
        C14281f.m45916b(minSdk2, "minSdk");
        C14281f.m45916b(packageName2, "packageName");
        C14281f.m45916b(status2, "status");
        $jacocoInit[13] = true;
        this.versionCode = versionCode2;
        this.uri = uri2;
        this.md5 = md52;
        this.minSdk = minSdk2;
        this.packageName = packageName2;
        this.shouldUpdate = shouldUpdate2;
        this.status = status2;
        this.loading = loading2;
        $jacocoInit[14] = true;
    }

    public final String getMd5() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.md5;
        $jacocoInit[5] = true;
        return str;
    }

    public final String getUri() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.uri;
        $jacocoInit[4] = true;
        return str;
    }

    public final int getVersionCode() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.versionCode;
        $jacocoInit[3] = true;
        return i;
    }

    public final String getMinSdk() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.minSdk;
        $jacocoInit[6] = true;
        return str;
    }

    public final String getPackageName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.packageName;
        $jacocoInit[7] = true;
        return str;
    }

    public /* synthetic */ AutoUpdateModel(int i, String str, String str2, String str3, String str4, boolean z, Status status2, boolean z2, int i2, C14280e eVar) {
        boolean z3;
        Status status3;
        boolean z4;
        int i3 = i2;
        boolean[] $jacocoInit = $jacocoInit();
        if ((i3 & 32) == 0) {
            $jacocoInit[15] = true;
            z3 = z;
        } else {
            $jacocoInit[16] = true;
            z3 = false;
        }
        if ((i3 & 64) == 0) {
            $jacocoInit[17] = true;
            status3 = status2;
        } else {
            Status status4 = Status.SUCCESS;
            $jacocoInit[18] = true;
            status3 = status4;
        }
        if ((i3 & 128) == 0) {
            $jacocoInit[19] = true;
            z4 = z2;
        } else {
            $jacocoInit[20] = true;
            $jacocoInit[21] = true;
            z4 = false;
        }
        this(i, str, str2, str3, str4, z3, status3, z4);
        $jacocoInit[22] = true;
    }

    public final boolean getShouldUpdate() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.shouldUpdate;
        $jacocoInit[8] = true;
        return z;
    }

    public final Status getStatus() {
        boolean[] $jacocoInit = $jacocoInit();
        Status status2 = this.status;
        $jacocoInit[9] = true;
        return status2;
    }

    public final void setStatus(Status status2) {
        boolean[] $jacocoInit = $jacocoInit();
        C14281f.m45916b(status2, "<set-?>");
        this.status = status2;
        $jacocoInit[10] = true;
    }

    public final boolean getLoading() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.loading;
        $jacocoInit[11] = true;
        return z;
    }

    public final void setLoading(boolean z) {
        boolean[] $jacocoInit = $jacocoInit();
        this.loading = z;
        $jacocoInit[12] = true;
    }

    public AutoUpdateModel(Status status2) {
        boolean[] $jacocoInit = $jacocoInit();
        C14281f.m45916b(status2, "status");
        $jacocoInit[23] = true;
        this(-1, "", "", "", "", false, status2, false, Opcodes.IF_ICMPNE, null);
        $jacocoInit[24] = true;
    }

    public AutoUpdateModel(boolean loading2) {
        boolean[] $jacocoInit = $jacocoInit();
        this(-1, "", "", "", "", false, null, loading2, 96, null);
        $jacocoInit[25] = true;
    }

    public final boolean wasSuccess() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = false;
        if (this.status == Status.SUCCESS) {
            $jacocoInit[0] = true;
            z = true;
        } else {
            $jacocoInit[1] = true;
        }
        $jacocoInit[2] = true;
        return z;
    }
}
