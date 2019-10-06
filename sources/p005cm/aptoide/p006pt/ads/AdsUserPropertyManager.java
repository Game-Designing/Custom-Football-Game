package p005cm.aptoide.p006pt.ads;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.ads.WalletAdsOfferManager.OfferResponseStatus;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.install.InstalledRepository;
import p026rx.C0120S;
import p026rx.C0126V;
import p026rx.Single;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.ads.AdsUserPropertyManager */
public class AdsUserPropertyManager {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String WALLET_PACKAGE = "com.appcoins.wallet";
    private final CrashReport crashReport;
    private final InstalledRepository installedRepository;
    private final C0126V ioScheduler;
    private final MoPubAdsManager moPubAdsManager;
    private final MoPubAnalytics moPubAnalytics;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2515877910452307262L, "cm/aptoide/pt/ads/AdsUserPropertyManager", 15);
        $jacocoData = probes;
        return probes;
    }

    public AdsUserPropertyManager(MoPubAdsManager moPubAdsManager2, InstalledRepository installedRepository2, MoPubAnalytics moPubAnalytics2, CrashReport crashReport2, C0126V ioScheduler2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.moPubAdsManager = moPubAdsManager2;
        this.installedRepository = installedRepository2;
        this.crashReport = crashReport2;
        this.moPubAnalytics = moPubAnalytics2;
        this.ioScheduler = ioScheduler2;
        $jacocoInit[0] = true;
    }

    public void start() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S isInstalled = this.installedRepository.isInstalled(WALLET_PACKAGE);
        C0126V v = this.ioScheduler;
        $jacocoInit[1] = true;
        C0120S a = isInstalled.mo3616a(v);
        $jacocoInit[2] = true;
        C0120S b = a.mo3628b();
        C1670s sVar = new C1670s(this);
        $jacocoInit[3] = true;
        C0120S f = b.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) sVar);
        MoPubAnalytics moPubAnalytics2 = this.moPubAnalytics;
        moPubAnalytics2.getClass();
        C1647D d = new C1647D(moPubAnalytics2);
        $jacocoInit[4] = true;
        C0120S b2 = f.mo3636b((C0129b<? super T>) d);
        C1671t tVar = C1671t.f4624a;
        $jacocoInit[5] = true;
        C0120S q = b2.mo3681q(tVar);
        C1669r rVar = C1669r.f4622a;
        C1668q qVar = new C1668q(this);
        $jacocoInit[6] = true;
        q.mo3626a((C0129b<? super T>) rVar, (C0129b<Throwable>) qVar);
        $jacocoInit[7] = true;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo796a(Boolean __) {
        boolean[] $jacocoInit = $jacocoInit();
        Single adsVisibilityStatus = this.moPubAdsManager.getAdsVisibilityStatus();
        $jacocoInit[13] = true;
        C0120S c = adsVisibilityStatus.mo3696c();
        $jacocoInit[14] = true;
        return c;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m140a(OfferResponseStatus offerResponseStatus) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (offerResponseStatus != OfferResponseStatus.NO_ADS) {
            $jacocoInit[10] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[11] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[12] = true;
        return valueOf;
    }

    /* renamed from: b */
    static /* synthetic */ void m141b(OfferResponseStatus created) {
        $jacocoInit()[9] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo797a(Throwable error) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(error);
        $jacocoInit[8] = true;
    }
}
