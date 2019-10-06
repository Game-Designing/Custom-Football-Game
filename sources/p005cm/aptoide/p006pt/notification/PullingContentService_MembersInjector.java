package p005cm.aptoide.p006pt.notification;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.download.DownloadFactory;
import p318e.C13183b;

/* renamed from: cm.aptoide.pt.notification.PullingContentService_MembersInjector */
public final class PullingContentService_MembersInjector implements C13183b<PullingContentService> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<DownloadFactory> downloadFactoryProvider;
    private final Provider<String> marketNameProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8484159010438160872L, "cm/aptoide/pt/notification/PullingContentService_MembersInjector", 7);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void injectMembers(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        injectMembers((PullingContentService) obj);
        $jacocoInit[6] = true;
    }

    public PullingContentService_MembersInjector(Provider<String> marketNameProvider2, Provider<DownloadFactory> downloadFactoryProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.marketNameProvider = marketNameProvider2;
        this.downloadFactoryProvider = downloadFactoryProvider2;
        $jacocoInit[0] = true;
    }

    public static C13183b<PullingContentService> create(Provider<String> marketNameProvider2, Provider<DownloadFactory> downloadFactoryProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        PullingContentService_MembersInjector pullingContentService_MembersInjector = new PullingContentService_MembersInjector(marketNameProvider2, downloadFactoryProvider2);
        $jacocoInit[1] = true;
        return pullingContentService_MembersInjector;
    }

    public void injectMembers(PullingContentService instance) {
        boolean[] $jacocoInit = $jacocoInit();
        injectMarketName(instance, (String) this.marketNameProvider.get());
        $jacocoInit[2] = true;
        injectDownloadFactory(instance, (DownloadFactory) this.downloadFactoryProvider.get());
        $jacocoInit[3] = true;
    }

    public static void injectMarketName(PullingContentService instance, String marketName) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.marketName = marketName;
        $jacocoInit[4] = true;
    }

    public static void injectDownloadFactory(PullingContentService instance, DownloadFactory downloadFactory) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.downloadFactory = downloadFactory;
        $jacocoInit[5] = true;
    }
}
