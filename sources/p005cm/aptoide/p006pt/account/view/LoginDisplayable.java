package p005cm.aptoide.p006pt.account.view;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable.Configs;

/* renamed from: cm.aptoide.pt.account.view.LoginDisplayable */
public class LoginDisplayable extends Displayable {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2757005497732858893L, "cm/aptoide/pt/account/view/LoginDisplayable", 3);
        $jacocoData = probes;
        return probes;
    }

    public LoginDisplayable() {
        $jacocoInit()[0] = true;
    }

    /* access modifiers changed from: protected */
    public Configs getConfig() {
        boolean[] $jacocoInit = $jacocoInit();
        Configs configs = new Configs(this, 1, true);
        $jacocoInit[1] = true;
        return configs;
    }

    public int getViewLayout() {
        $jacocoInit()[2] = true;
        return C1375R.layout.login_store_displayable_layout;
    }
}
