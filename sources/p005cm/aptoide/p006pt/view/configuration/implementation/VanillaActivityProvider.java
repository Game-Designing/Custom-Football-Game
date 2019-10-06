package p005cm.aptoide.p006pt.view.configuration.implementation;

import android.support.p001v7.app.C0019n;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.view.ActivityProvider;
import p005cm.aptoide.p006pt.view.MainActivity;

/* renamed from: cm.aptoide.pt.view.configuration.implementation.VanillaActivityProvider */
public class VanillaActivityProvider implements ActivityProvider {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(940850606194130547L, "cm/aptoide/pt/view/configuration/implementation/VanillaActivityProvider", 2);
        $jacocoData = probes;
        return probes;
    }

    public VanillaActivityProvider() {
        $jacocoInit()[0] = true;
    }

    public Class<? extends C0019n> getMainActivityFragmentClass() {
        Class<MainActivity> cls = MainActivity.class;
        $jacocoInit()[1] = true;
        return cls;
    }
}
