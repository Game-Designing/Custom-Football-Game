package p005cm.aptoide.p006pt.view.p080rx;

import android.support.p001v7.widget.SwitchCompat;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p019d.p022i.p296a.p297a.C13007b;
import p026rx.C0120S;
import p026rx.C0120S.C0122a;

/* renamed from: cm.aptoide.pt.view.rx.RxSwitch */
public class RxSwitch {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2826085434345927208L, "cm/aptoide/pt/view/rx/RxSwitch", 4);
        $jacocoData = probes;
        return probes;
    }

    private RxSwitch() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[0] = true;
        AssertionError assertionError = new AssertionError("No instances.");
        $jacocoInit[1] = true;
        throw assertionError;
    }

    public static C0120S<Boolean> checks(SwitchCompat switchCompat) {
        boolean[] $jacocoInit = $jacocoInit();
        C13007b.m42471a(switchCompat, "switchCompat == null");
        $jacocoInit[2] = true;
        C0120S<Boolean> a = C0120S.m634a((C0122a<T>) new SwitchOnCheckOnSubscribe<T>(switchCompat));
        $jacocoInit[3] = true;
        return a;
    }
}
