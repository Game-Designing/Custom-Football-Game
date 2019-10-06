package p005cm.aptoide.p006pt.view.wizard;

import android.support.p000v4.app.C0421D;
import android.support.p000v4.app.C0486t;
import android.support.p000v4.app.Fragment;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.NavigationTrackerPagerAdapterHelper;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.StoreContext;

/* renamed from: cm.aptoide.pt.view.wizard.WizardPagerAdapter */
public class WizardPagerAdapter extends C0421D implements NavigationTrackerPagerAdapterHelper {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final boolean isLoggedIn;
    private final WizardFragmentProvider wizardFragmentProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7275776738216015181L, "cm/aptoide/pt/view/wizard/WizardPagerAdapter", 9);
        $jacocoData = probes;
        return probes;
    }

    public WizardPagerAdapter(C0486t fragmentManager, Boolean isLoggedIn2, WizardFragmentProvider wizardFragmentProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(fragmentManager);
        $jacocoInit[0] = true;
        this.isLoggedIn = isLoggedIn2.booleanValue();
        this.wizardFragmentProvider = wizardFragmentProvider2;
        $jacocoInit[1] = true;
    }

    public Fragment getItem(int position) {
        boolean[] $jacocoInit = $jacocoInit();
        Fragment item = this.wizardFragmentProvider.getItem(position);
        $jacocoInit[2] = true;
        return item;
    }

    public int getCount() {
        boolean[] $jacocoInit = $jacocoInit();
        int count = this.wizardFragmentProvider.getCount(Boolean.valueOf(this.isLoggedIn));
        $jacocoInit[3] = true;
        return count;
    }

    public boolean isLoggedIn() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.isLoggedIn;
        $jacocoInit[4] = true;
        return z;
    }

    public String getItemName(int position) {
        boolean[] $jacocoInit = $jacocoInit();
        Class cls = getItem(position).getClass();
        $jacocoInit[5] = true;
        String simpleName = cls.getSimpleName();
        $jacocoInit[6] = true;
        return simpleName;
    }

    public String getItemTag(int position) {
        boolean[] $jacocoInit = $jacocoInit();
        String valueOf = String.valueOf(position);
        $jacocoInit[7] = true;
        return valueOf;
    }

    public StoreContext getItemStore() {
        boolean[] $jacocoInit = $jacocoInit();
        StoreContext storeContext = StoreContext.home;
        $jacocoInit[8] = true;
        return storeContext;
    }
}
