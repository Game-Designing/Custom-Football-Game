package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.database.accessors.Database;
import p005cm.aptoide.p006pt.notification.NotificationProvider;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesNotificationProviderFactory */
public final class ApplicationModule_ProvidesNotificationProviderFactory implements C13181b<NotificationProvider> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<Database> databaseProvider;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-587635153240939105L, "cm/aptoide/pt/ApplicationModule_ProvidesNotificationProviderFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesNotificationProviderFactory(ApplicationModule module2, Provider<Database> databaseProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.databaseProvider = databaseProvider2;
        $jacocoInit[0] = true;
    }

    public NotificationProvider get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<Database> provider = this.databaseProvider;
        $jacocoInit[1] = true;
        NotificationProvider providesNotificationProvider = applicationModule.providesNotificationProvider((Database) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesNotificationProvider, "Cannot return null from a non-@Nullable @Provides method");
        NotificationProvider notificationProvider = providesNotificationProvider;
        $jacocoInit[3] = true;
        return notificationProvider;
    }

    public static C13181b<NotificationProvider> create(ApplicationModule module2, Provider<Database> databaseProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesNotificationProviderFactory applicationModule_ProvidesNotificationProviderFactory = new ApplicationModule_ProvidesNotificationProviderFactory(module2, databaseProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesNotificationProviderFactory;
    }

    public static NotificationProvider proxyProvidesNotificationProvider(ApplicationModule instance, Database database) {
        boolean[] $jacocoInit = $jacocoInit();
        NotificationProvider providesNotificationProvider = instance.providesNotificationProvider(database);
        $jacocoInit[5] = true;
        return providesNotificationProvider;
    }
}
