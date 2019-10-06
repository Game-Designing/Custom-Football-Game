package p005cm.aptoide.p006pt.account.view;

import android.os.Bundle;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.account.view.LoginBottomSheet.State;
import p005cm.aptoide.p006pt.view.BackButtonActivity;
import p019d.p022i.p023b.C0099b;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.account.view.LoginBottomSheetActivity */
public abstract class LoginBottomSheetActivity extends BackButtonActivity implements LoginBottomSheet {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private C0099b<State> stateSubject;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1248100708233238549L, "cm/aptoide/pt/account/view/LoginBottomSheetActivity", 6);
        $jacocoData = probes;
        return probes;
    }

    public LoginBottomSheetActivity() {
        $jacocoInit()[0] = true;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[1] = true;
        this.stateSubject = C0099b.m564o();
        $jacocoInit[2] = true;
    }

    public void expand() {
        boolean[] $jacocoInit = $jacocoInit();
        this.stateSubject.call(State.EXPANDED);
        $jacocoInit[3] = true;
    }

    public void collapse() {
        boolean[] $jacocoInit = $jacocoInit();
        this.stateSubject.call(State.COLLAPSED);
        $jacocoInit[4] = true;
    }

    public C0120S<State> state() {
        boolean[] $jacocoInit = $jacocoInit();
        C0099b<State> bVar = this.stateSubject;
        $jacocoInit[5] = true;
        return bVar;
    }
}
