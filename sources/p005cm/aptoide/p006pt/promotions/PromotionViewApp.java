package p005cm.aptoide.p006pt.promotions;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.app.DownloadModel;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Obb;

/* renamed from: cm.aptoide.pt.promotions.PromotionViewApp */
public class PromotionViewApp {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String alternativePath;
    private final String appIcon;
    private final long appId;
    private final float appcValue;
    private final String description;
    private DownloadModel downloadModel;
    private final String downloadPath;
    private final boolean hasAppc;
    private boolean isClaimed;
    private final String md5;
    private final String name;
    private final int numberOfDownloads;
    private final Obb obb;
    private final String packageName;
    private final float rating;
    private final String signature;
    private final long size;
    private final int versionCode;
    private final String versionName;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6475930184369703490L, "cm/aptoide/pt/promotions/PromotionViewApp", 68);
        $jacocoData = probes;
        return probes;
    }

    public PromotionViewApp(DownloadModel downloadModel2, String name2, String packageName2, long appId2, String downloadPath2, String alternativePath2, String appIcon2, boolean isClaimed2, String description2, long size2, float rating2, int numberOfDownloads2, String md52, int versionCode2, String versionName2, Obb obb2, float appcValue2, String signature2, boolean hasAppc2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.downloadModel = downloadModel2;
        this.name = name2;
        this.packageName = packageName2;
        this.appId = appId2;
        this.downloadPath = downloadPath2;
        this.alternativePath = alternativePath2;
        this.appIcon = appIcon2;
        this.isClaimed = isClaimed2;
        this.description = description2;
        this.size = size2;
        this.rating = rating2;
        this.numberOfDownloads = numberOfDownloads2;
        this.md5 = md52;
        this.versionCode = versionCode2;
        this.versionName = versionName2;
        this.obb = obb2;
        this.appcValue = appcValue2;
        this.signature = signature2;
        this.hasAppc = hasAppc2;
        $jacocoInit[0] = true;
    }

    public String getName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.name;
        $jacocoInit[1] = true;
        return str;
    }

    public String getPackageName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.packageName;
        $jacocoInit[2] = true;
        return str;
    }

    public long getAppId() {
        boolean[] $jacocoInit = $jacocoInit();
        long j = this.appId;
        $jacocoInit[3] = true;
        return j;
    }

    public String getDownloadPath() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.downloadPath;
        $jacocoInit[4] = true;
        return str;
    }

    public String getAlternativePath() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.alternativePath;
        $jacocoInit[5] = true;
        return str;
    }

    public String getAppIcon() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.appIcon;
        $jacocoInit[6] = true;
        return str;
    }

    public String getDescription() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.description;
        $jacocoInit[7] = true;
        return str;
    }

    public long getSize() {
        boolean[] $jacocoInit = $jacocoInit();
        long j = this.size;
        $jacocoInit[8] = true;
        return j;
    }

    public float getRating() {
        boolean[] $jacocoInit = $jacocoInit();
        float f = this.rating;
        $jacocoInit[9] = true;
        return f;
    }

    public int getNumberOfDownloads() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.numberOfDownloads;
        $jacocoInit[10] = true;
        return i;
    }

    public String getMd5() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.md5;
        $jacocoInit[11] = true;
        return str;
    }

    public int getVersionCode() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.versionCode;
        $jacocoInit[12] = true;
        return i;
    }

    public DownloadModel getDownloadModel() {
        boolean[] $jacocoInit = $jacocoInit();
        DownloadModel downloadModel2 = this.downloadModel;
        $jacocoInit[13] = true;
        return downloadModel2;
    }

    public void setDownloadModel(DownloadModel downloadModel2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.downloadModel = downloadModel2;
        $jacocoInit[14] = true;
    }

    public boolean isClaimed() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.isClaimed;
        $jacocoInit[15] = true;
        return z;
    }

    public void setClaimed() {
        boolean[] $jacocoInit = $jacocoInit();
        this.isClaimed = true;
        $jacocoInit[16] = true;
    }

    public String getVersionName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.versionName;
        $jacocoInit[17] = true;
        return str;
    }

    public Obb getObb() {
        boolean[] $jacocoInit = $jacocoInit();
        Obb obb2 = this.obb;
        $jacocoInit[18] = true;
        return obb2;
    }

    public int hashCode() {
        int result;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean[] $jacocoInit = $jacocoInit();
        DownloadModel downloadModel2 = this.downloadModel;
        int i11 = 0;
        if (downloadModel2 != null) {
            result = downloadModel2.hashCode();
            $jacocoInit[19] = true;
        } else {
            $jacocoInit[20] = true;
            result = 0;
        }
        $jacocoInit[21] = true;
        int i12 = result * 31;
        String str = this.name;
        if (str != null) {
            i = str.hashCode();
            $jacocoInit[22] = true;
        } else {
            $jacocoInit[23] = true;
            i = 0;
        }
        int result2 = i12 + i;
        $jacocoInit[24] = true;
        int i13 = result2 * 31;
        String str2 = this.packageName;
        if (str2 != null) {
            i2 = str2.hashCode();
            $jacocoInit[25] = true;
        } else {
            $jacocoInit[26] = true;
            i2 = 0;
        }
        int result3 = (i13 + i2) * 31;
        long j = this.appId;
        int result4 = result3 + ((int) (j ^ (j >>> 32)));
        $jacocoInit[27] = true;
        int i14 = result4 * 31;
        String str3 = this.downloadPath;
        if (str3 != null) {
            i3 = str3.hashCode();
            $jacocoInit[28] = true;
        } else {
            $jacocoInit[29] = true;
            i3 = 0;
        }
        int result5 = i14 + i3;
        $jacocoInit[30] = true;
        int i15 = result5 * 31;
        String str4 = this.alternativePath;
        if (str4 != null) {
            i4 = str4.hashCode();
            $jacocoInit[31] = true;
        } else {
            $jacocoInit[32] = true;
            i4 = 0;
        }
        int result6 = i15 + i4;
        $jacocoInit[33] = true;
        int i16 = result6 * 31;
        String str5 = this.appIcon;
        if (str5 != null) {
            i5 = str5.hashCode();
            $jacocoInit[34] = true;
        } else {
            $jacocoInit[35] = true;
            i5 = 0;
        }
        int result7 = (i16 + i5) * 31;
        if (this.isClaimed) {
            $jacocoInit[36] = true;
            i6 = 1;
        } else {
            $jacocoInit[37] = true;
            i6 = 0;
        }
        int result8 = result7 + i6;
        $jacocoInit[38] = true;
        int i17 = result8 * 31;
        String str6 = this.description;
        if (str6 != null) {
            i7 = str6.hashCode();
            $jacocoInit[39] = true;
        } else {
            $jacocoInit[40] = true;
            i7 = 0;
        }
        int result9 = (i17 + i7) * 31;
        long j2 = this.size;
        int result10 = result9 + ((int) (j2 ^ (j2 >>> 32)));
        $jacocoInit[41] = true;
        int i18 = result10 * 31;
        float f = this.rating;
        if (f != 0.0f) {
            i8 = Float.floatToIntBits(f);
            $jacocoInit[42] = true;
        } else {
            $jacocoInit[43] = true;
            i8 = 0;
        }
        int result11 = ((i18 + i8) * 31) + this.numberOfDownloads;
        $jacocoInit[44] = true;
        int i19 = result11 * 31;
        String str7 = this.md5;
        if (str7 != null) {
            i9 = str7.hashCode();
            $jacocoInit[45] = true;
        } else {
            $jacocoInit[46] = true;
            i9 = 0;
        }
        int result12 = ((i19 + i9) * 31) + this.versionCode;
        $jacocoInit[47] = true;
        int i20 = result12 * 31;
        String str8 = this.versionName;
        if (str8 != null) {
            i10 = str8.hashCode();
            $jacocoInit[48] = true;
        } else {
            $jacocoInit[49] = true;
            i10 = 0;
        }
        int result13 = i20 + i10;
        $jacocoInit[50] = true;
        int i21 = result13 * 31;
        Obb obb2 = this.obb;
        if (obb2 != null) {
            i11 = obb2.hashCode();
            $jacocoInit[51] = true;
        } else {
            $jacocoInit[52] = true;
        }
        int result14 = i21 + i11;
        $jacocoInit[53] = true;
        return result14;
    }

    public boolean equals(Object o) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this == o) {
            $jacocoInit[54] = true;
            return true;
        }
        if (o == null) {
            $jacocoInit[55] = true;
        } else if (getClass() != o.getClass()) {
            $jacocoInit[56] = true;
        } else {
            PromotionViewApp that = (PromotionViewApp) o;
            $jacocoInit[58] = true;
            String str = this.md5;
            if (str != null) {
                if (str.equals(that.md5)) {
                    $jacocoInit[59] = true;
                } else {
                    $jacocoInit[60] = true;
                    $jacocoInit[63] = true;
                    return false;
                }
            } else if (that.md5 == null) {
                $jacocoInit[61] = true;
            } else {
                $jacocoInit[62] = true;
                $jacocoInit[63] = true;
                return false;
            }
            $jacocoInit[64] = true;
            return true;
        }
        $jacocoInit[57] = true;
        return false;
    }

    public float getAppcValue() {
        boolean[] $jacocoInit = $jacocoInit();
        float f = this.appcValue;
        $jacocoInit[65] = true;
        return f;
    }

    public String getSignature() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.signature;
        $jacocoInit[66] = true;
        return str;
    }

    public boolean hasAppc() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.hasAppc;
        $jacocoInit[67] = true;
        return z;
    }
}
