package p005cm.aptoide.p006pt;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideNonNullObjectMapperFactory */
public final class ApplicationModule_ProvideNonNullObjectMapperFactory implements C13181b<ObjectMapper> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2403281544386754560L, "cm/aptoide/pt/ApplicationModule_ProvideNonNullObjectMapperFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideNonNullObjectMapperFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public ObjectMapper get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        ObjectMapper provideNonNullObjectMapper = applicationModule.provideNonNullObjectMapper();
        $jacocoInit[2] = true;
        C13182c.m43111a(provideNonNullObjectMapper, "Cannot return null from a non-@Nullable @Provides method");
        ObjectMapper objectMapper = provideNonNullObjectMapper;
        $jacocoInit[3] = true;
        return objectMapper;
    }

    public static C13181b<ObjectMapper> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideNonNullObjectMapperFactory applicationModule_ProvideNonNullObjectMapperFactory = new ApplicationModule_ProvideNonNullObjectMapperFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_ProvideNonNullObjectMapperFactory;
    }

    public static ObjectMapper proxyProvideNonNullObjectMapper(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        ObjectMapper provideNonNullObjectMapper = instance.provideNonNullObjectMapper();
        $jacocoInit[5] = true;
        return provideNonNullObjectMapper;
    }
}
