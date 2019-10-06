package p005cm.aptoide.p006pt.install;

import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.database.accessors.InstalledAccessor;
import p005cm.aptoide.p006pt.database.realm.Installation;
import p005cm.aptoide.p006pt.database.realm.Installed;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.p398d.C14906b;
import p026rx.schedulers.Schedulers;

/* renamed from: cm.aptoide.pt.install.InstalledRepository */
public class InstalledRepository {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final InstalledAccessor accessor;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8860513428568857799L, "cm/aptoide/pt/install/InstalledRepository", 19);
        $jacocoData = probes;
        return probes;
    }

    public InstalledRepository(InstalledAccessor accessor2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.accessor = accessor2;
        $jacocoInit[0] = true;
    }

    public void save(Installed installed) {
        boolean[] $jacocoInit = $jacocoInit();
        this.accessor.insert(installed);
        $jacocoInit[1] = true;
    }

    public boolean contains(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S isInstalled = this.accessor.isInstalled(packageName);
        $jacocoInit[2] = true;
        C14906b k = isInstalled.mo3672k();
        $jacocoInit[3] = true;
        boolean booleanValue = ((Boolean) k.mo46110a()).booleanValue();
        $jacocoInit[4] = true;
        return booleanValue;
    }

    public C0120S<List<Installed>> getAllInstalled() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<List<Installed>> allInstalled = this.accessor.getAllInstalled();
        $jacocoInit[5] = true;
        return allInstalled;
    }

    public C0120S<Installed> getAsList(String packageName, int versionCode) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S asList = this.accessor.getAsList(packageName, versionCode);
        $jacocoInit[6] = true;
        C0120S a = asList.mo3616a(Schedulers.m776io());
        C4006Pa pa = C4006Pa.f7499a;
        $jacocoInit[7] = true;
        C0120S<Installed> j = a.mo3669j(pa);
        $jacocoInit[8] = true;
        return j;
    }

    /* renamed from: a */
    static /* synthetic */ Installed m8575a(List installeds) {
        boolean[] $jacocoInit = $jacocoInit();
        if (installeds.isEmpty()) {
            $jacocoInit[17] = true;
            return null;
        }
        Installed installed = (Installed) installeds.get(0);
        $jacocoInit[18] = true;
        return installed;
    }

    public C0120S<List<Installed>> getAsList(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<List<Installed>> allAsList = this.accessor.getAllAsList(packageName);
        $jacocoInit[9] = true;
        return allAsList;
    }

    public C0120S<Installed> getInstalled(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Installed> installed = this.accessor.getInstalled(packageName);
        $jacocoInit[10] = true;
        return installed;
    }

    public C0117M remove(String packageName, int versionCode) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M remove = this.accessor.remove(packageName, versionCode);
        $jacocoInit[11] = true;
        return remove;
    }

    public C0120S<Boolean> isInstalled(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Boolean> isInstalled = this.accessor.isInstalled(packageName);
        $jacocoInit[12] = true;
        return isInstalled;
    }

    public C0120S<List<Installed>> getAllInstalledSorted() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<List<Installed>> allInstalledSorted = this.accessor.getAllInstalledSorted();
        $jacocoInit[13] = true;
        return allInstalledSorted;
    }

    public C0120S<Installed> get(String packageName, int versionCode) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Installed> s = this.accessor.get(packageName, versionCode);
        $jacocoInit[14] = true;
        return s;
    }

    public C0120S<List<Installation>> getInstallationsHistory() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<List<Installation>> installationsHistory = this.accessor.getInstallationsHistory();
        $jacocoInit[15] = true;
        return installationsHistory;
    }

    public C0120S<List<Installed>> getInstalled(String[] packageNames) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<List<Installed>> installed = this.accessor.getInstalled(packageNames);
        $jacocoInit[16] = true;
        return installed;
    }
}
