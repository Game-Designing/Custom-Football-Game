package p005cm.aptoide.p006pt.autoupdate;

import kotlin.p376c.p378b.C14282g;
import kotlin.p376c.p378b.C14285j;
import kotlin.p381e.C14299c;
import kotlin.p381e.C14301e;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.autoupdate.AutoUpdateRepository$loadAutoUpdateModel$1 */
/* compiled from: AutoUpdateRepository.kt */
final /* synthetic */ class AutoUpdateRepository$loadAutoUpdateModel$1 extends C14282g {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2242532248318320174L, "cm/aptoide/pt/autoupdate/AutoUpdateRepository$loadAutoUpdateModel$1", 8);
        $jacocoData = probes;
        return probes;
    }

    AutoUpdateRepository$loadAutoUpdateModel$1(AutoUpdateRepository autoUpdateRepository) {
        boolean[] $jacocoInit = $jacocoInit();
        super(autoUpdateRepository);
        $jacocoInit[0] = true;
    }

    public String getName() {
        $jacocoInit()[1] = true;
        return "autoUpdateModel";
    }

    public C14301e getOwner() {
        boolean[] $jacocoInit = $jacocoInit();
        C14299c a = C14285j.m45919a(AutoUpdateRepository.class);
        $jacocoInit[3] = true;
        return a;
    }

    public String getSignature() {
        $jacocoInit()[2] = true;
        return "getAutoUpdateModel()Lcm/aptoide/pt/autoupdate/AutoUpdateModel;";
    }

    public Object get() {
        boolean[] $jacocoInit = $jacocoInit();
        AutoUpdateRepository autoUpdateRepository = (AutoUpdateRepository) this.receiver;
        $jacocoInit[4] = true;
        AutoUpdateModel access$getAutoUpdateModel$p = AutoUpdateRepository.access$getAutoUpdateModel$p(autoUpdateRepository);
        $jacocoInit[5] = true;
        return access$getAutoUpdateModel$p;
    }

    public void set(Object value) {
        boolean[] $jacocoInit = $jacocoInit();
        AutoUpdateRepository autoUpdateRepository = (AutoUpdateRepository) this.receiver;
        $jacocoInit[6] = true;
        AutoUpdateRepository.access$setAutoUpdateModel$p(autoUpdateRepository, (AutoUpdateModel) value);
        $jacocoInit[7] = true;
    }
}
