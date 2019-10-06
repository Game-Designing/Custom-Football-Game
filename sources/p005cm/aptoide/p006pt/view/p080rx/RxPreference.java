package p005cm.aptoide.p006pt.view.p080rx;

import android.support.p001v7.preference.CheckBoxPreference;
import android.support.p001v7.preference.Preference;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p019d.p022i.p296a.p297a.C13007b;
import p026rx.C0120S;
import p026rx.C0120S.C0122a;

/* renamed from: cm.aptoide.pt.view.rx.RxPreference */
public class RxPreference {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4109030390083181787L, "cm/aptoide/pt/view/rx/RxPreference", 6);
        $jacocoData = probes;
        return probes;
    }

    private RxPreference() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[0] = true;
        AssertionError assertionError = new AssertionError("No instances.");
        $jacocoInit[1] = true;
        throw assertionError;
    }

    public static C0120S<Preference> clicks(Preference preference) {
        boolean[] $jacocoInit = $jacocoInit();
        C13007b.m42471a(preference, "preference == null");
        $jacocoInit[2] = true;
        C0120S<Preference> a = C0120S.m634a((C0122a<T>) new PreferenceClickOnSubscribe<T>(preference));
        $jacocoInit[3] = true;
        return a;
    }

    public static C0120S<Boolean> checks(CheckBoxPreference preference) {
        boolean[] $jacocoInit = $jacocoInit();
        C13007b.m42471a(preference, "preference == null");
        $jacocoInit[4] = true;
        C0120S<Boolean> a = C0120S.m634a((C0122a<T>) new PreferenceOnCheckOnSubscribe<T>(preference));
        $jacocoInit[5] = true;
        return a;
    }
}
