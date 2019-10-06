package p005cm.aptoide.p006pt.preferences;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.AccountService;
import p005cm.aptoide.accountmanager.AdultContent;
import p026rx.C0117M;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.preferences.AdultContentManager */
public class AdultContentManager implements AdultContent {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AccountService accountService;
    private final LocalPersistenceAdultContent localContent;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3913859079348970530L, "cm/aptoide/pt/preferences/AdultContentManager", 14);
        $jacocoData = probes;
        return probes;
    }

    public AdultContentManager(LocalPersistenceAdultContent localContent2, AccountService accountService2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.localContent = localContent2;
        this.accountService = accountService2;
        $jacocoInit[0] = true;
    }

    public C0120S<Boolean> pinRequired() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Boolean> pinRequired = this.localContent.pinRequired();
        $jacocoInit[1] = true;
        return pinRequired;
    }

    public C0117M requirePin(int pin) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M requirePin = this.localContent.requirePin(pin);
        $jacocoInit[2] = true;
        return requirePin;
    }

    public C0117M removePin(int pin) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M removePin = this.localContent.removePin(pin);
        $jacocoInit[3] = true;
        return removePin;
    }

    public C0117M enable(boolean isLogged) {
        boolean[] $jacocoInit = $jacocoInit();
        if (isLogged) {
            $jacocoInit[4] = true;
            C0117M updateAccount = this.accountService.updateAccount(true);
            LocalPersistenceAdultContent localPersistenceAdultContent = this.localContent;
            $jacocoInit[5] = true;
            C0117M a = updateAccount.mo3580a(localPersistenceAdultContent.enable());
            $jacocoInit[6] = true;
            return a;
        }
        C0117M enable = this.localContent.enable();
        $jacocoInit[7] = true;
        return enable;
    }

    public C0117M disable(boolean isLogged) {
        boolean[] $jacocoInit = $jacocoInit();
        if (isLogged) {
            $jacocoInit[8] = true;
            C0117M updateAccount = this.accountService.updateAccount(false);
            LocalPersistenceAdultContent localPersistenceAdultContent = this.localContent;
            $jacocoInit[9] = true;
            C0117M a = updateAccount.mo3580a(localPersistenceAdultContent.disable());
            $jacocoInit[10] = true;
            return a;
        }
        C0117M disable = this.localContent.disable();
        $jacocoInit[11] = true;
        return disable;
    }

    public C0120S<Boolean> enabled() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Boolean> enabled = this.localContent.enabled();
        $jacocoInit[12] = true;
        return enabled;
    }

    public C0117M enable(int pin) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M enable = this.localContent.enable(pin);
        $jacocoInit[13] = true;
        return enable;
    }
}
