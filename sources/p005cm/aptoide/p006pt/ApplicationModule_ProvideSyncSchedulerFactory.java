package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.sync.SyncScheduler;
import p005cm.aptoide.p006pt.sync.alarm.SyncStorage;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideSyncSchedulerFactory */
public final class ApplicationModule_ProvideSyncSchedulerFactory implements C13181b<SyncScheduler> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;
    private final Provider<SyncStorage> syncStorageProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4707874401438092606L, "cm/aptoide/pt/ApplicationModule_ProvideSyncSchedulerFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideSyncSchedulerFactory(ApplicationModule module2, Provider<SyncStorage> syncStorageProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.syncStorageProvider = syncStorageProvider2;
        $jacocoInit[0] = true;
    }

    public SyncScheduler get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<SyncStorage> provider = this.syncStorageProvider;
        $jacocoInit[1] = true;
        SyncScheduler provideSyncScheduler = applicationModule.provideSyncScheduler((SyncStorage) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(provideSyncScheduler, "Cannot return null from a non-@Nullable @Provides method");
        SyncScheduler syncScheduler = provideSyncScheduler;
        $jacocoInit[3] = true;
        return syncScheduler;
    }

    public static C13181b<SyncScheduler> create(ApplicationModule module2, Provider<SyncStorage> syncStorageProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideSyncSchedulerFactory applicationModule_ProvideSyncSchedulerFactory = new ApplicationModule_ProvideSyncSchedulerFactory(module2, syncStorageProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvideSyncSchedulerFactory;
    }

    public static SyncScheduler proxyProvideSyncScheduler(ApplicationModule instance, SyncStorage syncStorage) {
        boolean[] $jacocoInit = $jacocoInit();
        SyncScheduler provideSyncScheduler = instance.provideSyncScheduler(syncStorage);
        $jacocoInit[5] = true;
        return provideSyncScheduler;
    }
}
