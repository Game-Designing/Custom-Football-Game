package p005cm.aptoide.p006pt;

import com.fasterxml.jackson.databind.ObjectMapper;
import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.analytics.analytics.RealmEventMapper;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesRealmEventMapperFactory */
public final class ApplicationModule_ProvidesRealmEventMapperFactory implements C13181b<RealmEventMapper> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;
    private final Provider<ObjectMapper> objectMapperProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2701980606984618803L, "cm/aptoide/pt/ApplicationModule_ProvidesRealmEventMapperFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesRealmEventMapperFactory(ApplicationModule module2, Provider<ObjectMapper> objectMapperProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.objectMapperProvider = objectMapperProvider2;
        $jacocoInit[0] = true;
    }

    public RealmEventMapper get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<ObjectMapper> provider = this.objectMapperProvider;
        $jacocoInit[1] = true;
        RealmEventMapper providesRealmEventMapper = applicationModule.providesRealmEventMapper((ObjectMapper) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesRealmEventMapper, "Cannot return null from a non-@Nullable @Provides method");
        RealmEventMapper realmEventMapper = providesRealmEventMapper;
        $jacocoInit[3] = true;
        return realmEventMapper;
    }

    public static C13181b<RealmEventMapper> create(ApplicationModule module2, Provider<ObjectMapper> objectMapperProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesRealmEventMapperFactory applicationModule_ProvidesRealmEventMapperFactory = new ApplicationModule_ProvidesRealmEventMapperFactory(module2, objectMapperProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesRealmEventMapperFactory;
    }

    public static RealmEventMapper proxyProvidesRealmEventMapper(ApplicationModule instance, ObjectMapper objectMapper) {
        boolean[] $jacocoInit = $jacocoInit();
        RealmEventMapper providesRealmEventMapper = instance.providesRealmEventMapper(objectMapper);
        $jacocoInit[5] = true;
        return providesRealmEventMapper;
    }
}
