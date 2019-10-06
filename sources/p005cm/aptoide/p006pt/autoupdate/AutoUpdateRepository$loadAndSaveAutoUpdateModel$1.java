package p005cm.aptoide.p006pt.autoupdate;

import kotlin.p376c.p378b.C14281f;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p026rx.p027b.C0129b;

/* renamed from: cm.aptoide.pt.autoupdate.AutoUpdateRepository$loadAndSaveAutoUpdateModel$1 */
/* compiled from: AutoUpdateRepository.kt */
final class AutoUpdateRepository$loadAndSaveAutoUpdateModel$1<T> implements C0129b<AutoUpdateModel> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    final /* synthetic */ AutoUpdateRepository this$0;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-693998092131475286L, "cm/aptoide/pt/autoupdate/AutoUpdateRepository$loadAndSaveAutoUpdateModel$1", 3);
        $jacocoData = probes;
        return probes;
    }

    AutoUpdateRepository$loadAndSaveAutoUpdateModel$1(AutoUpdateRepository autoUpdateRepository) {
        boolean[] $jacocoInit = $jacocoInit();
        this.this$0 = autoUpdateRepository;
        $jacocoInit[2] = true;
    }

    public /* bridge */ /* synthetic */ void call(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        call((AutoUpdateModel) obj);
        $jacocoInit[0] = true;
    }

    public final void call(AutoUpdateModel it) {
        boolean[] $jacocoInit = $jacocoInit();
        AutoUpdateRepository autoUpdateRepository = this.this$0;
        C14281f.m45913a((Object) it, "it");
        AutoUpdateRepository.access$setAutoUpdateModel$p(autoUpdateRepository, it);
        $jacocoInit[1] = true;
    }
}
