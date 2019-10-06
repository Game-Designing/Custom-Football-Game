package p005cm.aptoide.p006pt.promotions;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.app.DownloadModel;
import p005cm.aptoide.p006pt.app.DownloadModel.Action;
import p005cm.aptoide.p006pt.app.DownloadStateParser;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Obb;
import p005cm.aptoide.p006pt.install.Install;
import p005cm.aptoide.p006pt.install.Install.InstallationStatus;
import p005cm.aptoide.p006pt.install.Install.InstallationType;

/* renamed from: cm.aptoide.pt.promotions.PromotionViewAppMapper */
public class PromotionViewAppMapper {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final DownloadStateParser downloadStateParser;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4466800082614286060L, "cm/aptoide/pt/promotions/PromotionViewAppMapper", 12);
        $jacocoData = probes;
        return probes;
    }

    public PromotionViewAppMapper(DownloadStateParser downloadStateParser2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.downloadStateParser = downloadStateParser2;
        $jacocoInit[0] = true;
    }

    public PromotionViewApp mapInstallToPromotionApp(Install install, PromotionApp promotionApp) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[1] = true;
        DownloadModel downloadModel = getDownloadModel(install.getType(), install.getProgress(), install.getState());
        $jacocoInit[2] = true;
        String name = promotionApp.getName();
        String packageName = promotionApp.getPackageName();
        long appId = promotionApp.getAppId();
        $jacocoInit[3] = true;
        String downloadPath = promotionApp.getDownloadPath();
        String alternativePath = promotionApp.getAlternativePath();
        $jacocoInit[4] = true;
        String appIcon = promotionApp.getAppIcon();
        boolean isClaimed = promotionApp.isClaimed();
        String description = promotionApp.getDescription();
        $jacocoInit[5] = true;
        long size = promotionApp.getSize();
        float rating = promotionApp.getRating();
        int numberOfDownloads = promotionApp.getNumberOfDownloads();
        $jacocoInit[6] = true;
        String md5 = promotionApp.getMd5();
        int versionCode = promotionApp.getVersionCode();
        String versionName = promotionApp.getVersionName();
        $jacocoInit[7] = true;
        Obb obb = promotionApp.getObb();
        float appcValue = promotionApp.getAppcValue();
        String signature = promotionApp.getSignature();
        $jacocoInit[8] = true;
        PromotionViewApp promotionViewApp = new PromotionViewApp(downloadModel, name, packageName, appId, downloadPath, alternativePath, appIcon, isClaimed, description, size, rating, numberOfDownloads, md5, versionCode, versionName, obb, appcValue, signature, promotionApp.hasAppc());
        $jacocoInit[9] = true;
        return promotionViewApp;
    }

    private DownloadModel getDownloadModel(InstallationType type, int progress, InstallationStatus state) {
        boolean[] $jacocoInit = $jacocoInit();
        Action parseDownloadType = this.downloadStateParser.parseDownloadType(type, false, false, false);
        DownloadStateParser downloadStateParser2 = this.downloadStateParser;
        $jacocoInit[10] = true;
        DownloadModel downloadModel = new DownloadModel(parseDownloadType, progress, downloadStateParser2.parseDownloadState(state), null);
        $jacocoInit[11] = true;
        return downloadModel;
    }
}
