package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.implementation.loggers.HttpKnockEventLogger;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesknockEventLoggerFactory */
public final class ApplicationModule_ProvidesknockEventLoggerFactory implements C13181b<HttpKnockEventLogger> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<OkHttpClient> clientProvider;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7692113993445538528L, "cm/aptoide/pt/ApplicationModule_ProvidesknockEventLoggerFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesknockEventLoggerFactory(ApplicationModule module2, Provider<OkHttpClient> clientProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.clientProvider = clientProvider2;
        $jacocoInit[0] = true;
    }

    public HttpKnockEventLogger get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<OkHttpClient> provider = this.clientProvider;
        $jacocoInit[1] = true;
        HttpKnockEventLogger providesknockEventLogger = applicationModule.providesknockEventLogger((OkHttpClient) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesknockEventLogger, "Cannot return null from a non-@Nullable @Provides method");
        HttpKnockEventLogger httpKnockEventLogger = providesknockEventLogger;
        $jacocoInit[3] = true;
        return httpKnockEventLogger;
    }

    public static C13181b<HttpKnockEventLogger> create(ApplicationModule module2, Provider<OkHttpClient> clientProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesknockEventLoggerFactory applicationModule_ProvidesknockEventLoggerFactory = new ApplicationModule_ProvidesknockEventLoggerFactory(module2, clientProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesknockEventLoggerFactory;
    }

    public static HttpKnockEventLogger proxyProvidesknockEventLogger(ApplicationModule instance, OkHttpClient client) {
        boolean[] $jacocoInit = $jacocoInit();
        HttpKnockEventLogger providesknockEventLogger = instance.providesknockEventLogger(client);
        $jacocoInit[5] = true;
        return providesknockEventLogger;
    }
}
