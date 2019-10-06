package p005cm.aptoide.p006pt.networking;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p026rx.C0117M;

/* renamed from: cm.aptoide.pt.networking.NoOpTokenInvalidator */
public class NoOpTokenInvalidator implements TokenInvalidator {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2159254360887757037L, "cm/aptoide/pt/networking/NoOpTokenInvalidator", 2);
        $jacocoData = probes;
        return probes;
    }

    public NoOpTokenInvalidator() {
        $jacocoInit()[0] = true;
    }

    public C0117M invalidateAccessToken() {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M b = C0117M.m590b();
        $jacocoInit[1] = true;
        return b;
    }
}
