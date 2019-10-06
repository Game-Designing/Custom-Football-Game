package p005cm.aptoide.p006pt.autoupdate;

import kotlin.p376c.p378b.C14281f;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p026rx.C0120S;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.autoupdate.AutoUpdateService$loadAutoUpdateModel$4 */
/* compiled from: AutoUpdateService.kt */
final class AutoUpdateService$loadAutoUpdateModel$4<T, R> implements C0132p<T, C0120S<? extends R>> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    final /* synthetic */ AutoUpdateService this$0;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3227017305044980301L, "cm/aptoide/pt/autoupdate/AutoUpdateService$loadAutoUpdateModel$4", 3);
        $jacocoData = probes;
        return probes;
    }

    AutoUpdateService$loadAutoUpdateModel$4(AutoUpdateService autoUpdateService) {
        boolean[] $jacocoInit = $jacocoInit();
        this.this$0 = autoUpdateService;
        $jacocoInit[2] = true;
    }

    public /* bridge */ /* synthetic */ Object call(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S call = call((AutoUpdateJsonResponse) obj);
        $jacocoInit[0] = true;
        return call;
    }

    public final C0120S<AutoUpdateModel> call(AutoUpdateJsonResponse it) {
        boolean[] $jacocoInit = $jacocoInit();
        C14281f.m45913a((Object) it, "it");
        int versioncode = it.getVersioncode();
        String uri = it.getUri();
        C14281f.m45913a((Object) uri, "it.uri");
        String md5 = it.getMd5();
        C14281f.m45913a((Object) md5, "it.md5");
        String minSdk = it.getMinSdk();
        C14281f.m45913a((Object) minSdk, "it.minSdk");
        AutoUpdateModel autoUpdateModel = new AutoUpdateModel(versioncode, uri, md5, minSdk, AutoUpdateService.access$getPackageName$p(this.this$0), false, null, false, 224, null);
        C0120S<AutoUpdateModel> c = C0120S.m652c(autoUpdateModel);
        $jacocoInit[1] = true;
        return c;
    }
}
