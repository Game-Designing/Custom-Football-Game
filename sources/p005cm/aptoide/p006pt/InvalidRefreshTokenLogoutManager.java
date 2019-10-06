package p005cm.aptoide.p006pt;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.p006pt.networking.RefreshTokenInvalidator;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.p027b.C0132p;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.InvalidRefreshTokenLogoutManager */
public class InvalidRefreshTokenLogoutManager {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private AptoideAccountManager aptoideAccountManager;
    private RefreshTokenInvalidator refreshTokenInvalidator;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8495528564489218820L, "cm/aptoide/pt/InvalidRefreshTokenLogoutManager", 5);
        $jacocoData = probes;
        return probes;
    }

    public InvalidRefreshTokenLogoutManager(AptoideAccountManager aptoideAccountManager2, RefreshTokenInvalidator refreshTokenInvalidator2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.aptoideAccountManager = aptoideAccountManager2;
        this.refreshTokenInvalidator = refreshTokenInvalidator2;
        $jacocoInit[0] = true;
    }

    public void start() {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c logoutSubject = this.refreshTokenInvalidator.getLogoutSubject();
        C1372H h = new C1372H(this);
        $jacocoInit[1] = true;
        C0120S g = logoutSubject.mo3663g((C0132p<? super T, ? extends C0117M>) h);
        $jacocoInit[2] = true;
        g.mo3670j();
        $jacocoInit[3] = true;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo758a(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M logout = this.aptoideAccountManager.logout();
        $jacocoInit[4] = true;
        return logout;
    }
}
