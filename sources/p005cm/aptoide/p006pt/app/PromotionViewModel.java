package p005cm.aptoide.p006pt.app;

import java.util.ArrayList;
import java.util.List;
import kotlin.p376c.p378b.C14281f;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.DeepLinkIntentReceiver.DeepLinksTargets;
import p005cm.aptoide.p006pt.promotions.Promotion;
import p005cm.aptoide.p006pt.promotions.WalletApp;
import p005cm.aptoide.p006pt.view.app.DetailedApp;

/* renamed from: cm.aptoide.pt.app.PromotionViewModel */
/* compiled from: PromotionViewModel.kt */
public final class PromotionViewModel {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private DetailedApp app;
    private DownloadModel appDownloadModel;
    private boolean isAppMigrated;
    private List<Promotion> promotions;
    private WalletApp walletApp;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-144523113787064509L, "cm/aptoide/pt/app/PromotionViewModel", 68);
        $jacocoData = probes;
        return probes;
    }

    public PromotionViewModel() {
        boolean[] $jacocoInit = $jacocoInit();
        this(null, null, null, null, false, 31, null);
        $jacocoInit[26] = true;
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<cm.aptoide.pt.promotions.Promotion>, for r10v0, types: [java.util.List] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ p005cm.aptoide.p006pt.app.PromotionViewModel copy$default(p005cm.aptoide.p006pt.app.PromotionViewModel r8, p005cm.aptoide.p006pt.promotions.WalletApp r9, java.util.List<p005cm.aptoide.p006pt.promotions.Promotion> r10, p005cm.aptoide.p006pt.app.DownloadModel r11, p005cm.aptoide.p006pt.view.app.DetailedApp r12, boolean r13, int r14, java.lang.Object r15) {
        /*
            boolean[] r15 = $jacocoInit()
            r0 = r14 & 1
            r1 = 1
            if (r0 != 0) goto L_0x000e
            r0 = 33
            r15[r0] = r1
            goto L_0x0014
        L_0x000e:
            cm.aptoide.pt.promotions.WalletApp r9 = r8.walletApp
            r0 = 34
            r15[r0] = r1
        L_0x0014:
            r3 = r9
            r9 = r14 & 2
            if (r9 != 0) goto L_0x001e
            r9 = 35
            r15[r9] = r1
            goto L_0x0024
        L_0x001e:
            java.util.List<cm.aptoide.pt.promotions.Promotion> r10 = r8.promotions
            r9 = 36
            r15[r9] = r1
        L_0x0024:
            r4 = r10
            r9 = r14 & 4
            if (r9 != 0) goto L_0x002e
            r9 = 37
            r15[r9] = r1
            goto L_0x0034
        L_0x002e:
            cm.aptoide.pt.app.DownloadModel r11 = r8.appDownloadModel
            r9 = 38
            r15[r9] = r1
        L_0x0034:
            r5 = r11
            r9 = r14 & 8
            if (r9 != 0) goto L_0x003e
            r9 = 39
            r15[r9] = r1
            goto L_0x0044
        L_0x003e:
            cm.aptoide.pt.view.app.DetailedApp r12 = r8.app
            r9 = 40
            r15[r9] = r1
        L_0x0044:
            r6 = r12
            r9 = r14 & 16
            if (r9 != 0) goto L_0x004e
            r9 = 41
            r15[r9] = r1
            goto L_0x0054
        L_0x004e:
            boolean r13 = r8.isAppMigrated
            r9 = 42
            r15[r9] = r1
        L_0x0054:
            r7 = r13
            r2 = r8
            cm.aptoide.pt.app.PromotionViewModel r8 = r2.copy(r3, r4, r5, r6, r7)
            r9 = 43
            r15[r9] = r1
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.app.PromotionViewModel.copy$default(cm.aptoide.pt.app.PromotionViewModel, cm.aptoide.pt.promotions.WalletApp, java.util.List, cm.aptoide.pt.app.DownloadModel, cm.aptoide.pt.view.app.DetailedApp, boolean, int, java.lang.Object):cm.aptoide.pt.app.PromotionViewModel");
    }

    public final WalletApp component1() {
        boolean[] $jacocoInit = $jacocoInit();
        WalletApp walletApp2 = this.walletApp;
        $jacocoInit[27] = true;
        return walletApp2;
    }

    public final List<Promotion> component2() {
        boolean[] $jacocoInit = $jacocoInit();
        List<Promotion> list = this.promotions;
        $jacocoInit[28] = true;
        return list;
    }

    public final DownloadModel component3() {
        boolean[] $jacocoInit = $jacocoInit();
        DownloadModel downloadModel = this.appDownloadModel;
        $jacocoInit[29] = true;
        return downloadModel;
    }

    public final DetailedApp component4() {
        boolean[] $jacocoInit = $jacocoInit();
        DetailedApp detailedApp = this.app;
        $jacocoInit[30] = true;
        return detailedApp;
    }

    public final boolean component5() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.isAppMigrated;
        $jacocoInit[31] = true;
        return z;
    }

    public final PromotionViewModel copy(WalletApp walletApp2, List<Promotion> list, DownloadModel downloadModel, DetailedApp detailedApp, boolean z) {
        boolean[] $jacocoInit = $jacocoInit();
        C14281f.m45916b(walletApp2, "walletApp");
        C14281f.m45916b(list, DeepLinksTargets.PROMOTIONS_DEEPLINK);
        PromotionViewModel promotionViewModel = new PromotionViewModel(walletApp2, list, downloadModel, detailedApp, z);
        $jacocoInit[32] = true;
        return promotionViewModel;
    }

    public boolean equals(Object obj) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (this == obj) {
            $jacocoInit[56] = true;
        } else {
            if (!(obj instanceof PromotionViewModel)) {
                $jacocoInit[57] = true;
            } else {
                PromotionViewModel promotionViewModel = (PromotionViewModel) obj;
                if (!C14281f.m45915a((Object) this.walletApp, (Object) promotionViewModel.walletApp)) {
                    $jacocoInit[58] = true;
                } else if (!C14281f.m45915a((Object) this.promotions, (Object) promotionViewModel.promotions)) {
                    $jacocoInit[59] = true;
                } else if (!C14281f.m45915a((Object) this.appDownloadModel, (Object) promotionViewModel.appDownloadModel)) {
                    $jacocoInit[60] = true;
                } else if (!C14281f.m45915a((Object) this.app, (Object) promotionViewModel.app)) {
                    $jacocoInit[61] = true;
                } else {
                    if (this.isAppMigrated == promotionViewModel.isAppMigrated) {
                        $jacocoInit[62] = true;
                        z = true;
                    } else {
                        $jacocoInit[63] = true;
                        z = false;
                    }
                    if (!z) {
                        $jacocoInit[64] = true;
                    } else {
                        $jacocoInit[65] = true;
                    }
                }
            }
            $jacocoInit[67] = true;
            return false;
        }
        $jacocoInit[66] = true;
        return true;
    }

    public int hashCode() {
        int i;
        int i2;
        int i3;
        boolean[] $jacocoInit = $jacocoInit();
        WalletApp walletApp2 = this.walletApp;
        int i4 = 0;
        if (walletApp2 != null) {
            i = walletApp2.hashCode();
            $jacocoInit[45] = true;
        } else {
            $jacocoInit[46] = true;
            i = 0;
        }
        int i5 = i * 31;
        List<Promotion> list = this.promotions;
        if (list != null) {
            i2 = list.hashCode();
            $jacocoInit[47] = true;
        } else {
            $jacocoInit[48] = true;
            i2 = 0;
        }
        int i6 = (i5 + i2) * 31;
        DownloadModel downloadModel = this.appDownloadModel;
        if (downloadModel != null) {
            i3 = downloadModel.hashCode();
            $jacocoInit[49] = true;
        } else {
            $jacocoInit[50] = true;
            i3 = 0;
        }
        int i7 = (i6 + i3) * 31;
        DetailedApp detailedApp = this.app;
        if (detailedApp != null) {
            i4 = detailedApp.hashCode();
            $jacocoInit[51] = true;
        } else {
            $jacocoInit[52] = true;
        }
        int i8 = (i7 + i4) * 31;
        boolean z = this.isAppMigrated;
        if (!z) {
            $jacocoInit[53] = true;
        } else {
            $jacocoInit[54] = true;
            z = true;
        }
        int i9 = i8 + (z ? 1 : 0);
        $jacocoInit[55] = true;
        return i9;
    }

    public String toString() {
        boolean[] $jacocoInit = $jacocoInit();
        StringBuilder sb = new StringBuilder();
        sb.append("PromotionViewModel(walletApp=");
        sb.append(this.walletApp);
        sb.append(", promotions=");
        sb.append(this.promotions);
        sb.append(", appDownloadModel=");
        sb.append(this.appDownloadModel);
        sb.append(", app=");
        sb.append(this.app);
        sb.append(", isAppMigrated=");
        sb.append(this.isAppMigrated);
        sb.append(")");
        String sb2 = sb.toString();
        $jacocoInit[44] = true;
        return sb2;
    }

    public PromotionViewModel(WalletApp walletApp2, List<Promotion> promotions2, DownloadModel appDownloadModel2, DetailedApp app2, boolean isAppMigrated2) {
        boolean[] $jacocoInit = $jacocoInit();
        C14281f.m45916b(walletApp2, "walletApp");
        C14281f.m45916b(promotions2, DeepLinksTargets.PROMOTIONS_DEEPLINK);
        $jacocoInit[10] = true;
        this.walletApp = walletApp2;
        this.promotions = promotions2;
        this.appDownloadModel = appDownloadModel2;
        this.app = app2;
        this.isAppMigrated = isAppMigrated2;
        $jacocoInit[11] = true;
    }

    public /* synthetic */ PromotionViewModel(WalletApp walletApp2, List list, DownloadModel downloadModel, DetailedApp detailedApp, boolean z, int i, C14280e eVar) {
        WalletApp walletApp3;
        List list2;
        DownloadModel downloadModel2;
        boolean z2;
        boolean[] $jacocoInit = $jacocoInit();
        if ((i & 1) == 0) {
            $jacocoInit[12] = true;
            walletApp3 = walletApp2;
        } else {
            $jacocoInit[13] = true;
            walletApp3 = new WalletApp(null, false, null, null, 0, null, null, 0, null, null, null, null, 0, null, 16383, null);
            $jacocoInit[14] = true;
        }
        if ((i & 2) == 0) {
            $jacocoInit[15] = true;
            list2 = list;
        } else {
            $jacocoInit[16] = true;
            list2 = new ArrayList();
            $jacocoInit[17] = true;
        }
        DetailedApp detailedApp2 = null;
        if ((i & 4) == 0) {
            $jacocoInit[18] = true;
            downloadModel2 = downloadModel;
        } else {
            $jacocoInit[19] = true;
            downloadModel2 = null;
        }
        if ((i & 8) == 0) {
            $jacocoInit[20] = true;
            detailedApp2 = detailedApp;
        } else {
            $jacocoInit[21] = true;
        }
        if ((i & 16) == 0) {
            $jacocoInit[22] = true;
            z2 = z;
        } else {
            $jacocoInit[23] = true;
            z2 = false;
            $jacocoInit[24] = true;
        }
        this(walletApp3, list2, downloadModel2, detailedApp2, z2);
        $jacocoInit[25] = true;
    }

    public final WalletApp getWalletApp() {
        boolean[] $jacocoInit = $jacocoInit();
        WalletApp walletApp2 = this.walletApp;
        $jacocoInit[0] = true;
        return walletApp2;
    }

    public final void setWalletApp(WalletApp walletApp2) {
        boolean[] $jacocoInit = $jacocoInit();
        C14281f.m45916b(walletApp2, "<set-?>");
        this.walletApp = walletApp2;
        $jacocoInit[1] = true;
    }

    public final List<Promotion> getPromotions() {
        boolean[] $jacocoInit = $jacocoInit();
        List<Promotion> list = this.promotions;
        $jacocoInit[2] = true;
        return list;
    }

    public final void setPromotions(List<Promotion> list) {
        boolean[] $jacocoInit = $jacocoInit();
        C14281f.m45916b(list, "<set-?>");
        this.promotions = list;
        $jacocoInit[3] = true;
    }

    public final DownloadModel getAppDownloadModel() {
        boolean[] $jacocoInit = $jacocoInit();
        DownloadModel downloadModel = this.appDownloadModel;
        $jacocoInit[4] = true;
        return downloadModel;
    }

    public final void setAppDownloadModel(DownloadModel downloadModel) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appDownloadModel = downloadModel;
        $jacocoInit[5] = true;
    }

    public final DetailedApp getApp() {
        boolean[] $jacocoInit = $jacocoInit();
        DetailedApp detailedApp = this.app;
        $jacocoInit[6] = true;
        return detailedApp;
    }

    public final void setApp(DetailedApp detailedApp) {
        boolean[] $jacocoInit = $jacocoInit();
        this.app = detailedApp;
        $jacocoInit[7] = true;
    }

    public final boolean isAppMigrated() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.isAppMigrated;
        $jacocoInit[8] = true;
        return z;
    }

    public final void setAppMigrated(boolean z) {
        boolean[] $jacocoInit = $jacocoInit();
        this.isAppMigrated = z;
        $jacocoInit[9] = true;
    }
}
