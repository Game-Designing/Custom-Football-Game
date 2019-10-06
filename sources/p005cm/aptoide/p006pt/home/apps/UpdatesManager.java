package p005cm.aptoide.p006pt.home.apps;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.database.realm.Installed;
import p005cm.aptoide.p006pt.database.realm.Update;
import p005cm.aptoide.p006pt.install.Install;
import p005cm.aptoide.p006pt.updates.UpdateRepository;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.home.apps.UpdatesManager */
public class UpdatesManager {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private UpdateRepository updateRepository;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8043432187977083103L, "cm/aptoide/pt/home/apps/UpdatesManager", 53);
        $jacocoData = probes;
        return probes;
    }

    public UpdatesManager(UpdateRepository updateRepository2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.updateRepository = updateRepository2;
        $jacocoInit[0] = true;
    }

    public C0120S<Installed> filterUpdates(Installed item) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S contains = this.updateRepository.contains(item.getPackageName(), false);
        C3715if ifVar = new C3715if(item);
        $jacocoInit[1] = true;
        C0120S<Installed> f = contains.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) ifVar);
        $jacocoInit[2] = true;
        return f;
    }

    /* renamed from: a */
    static /* synthetic */ C0120S m8520a(Installed item, Boolean isUpdate) {
        boolean[] $jacocoInit = $jacocoInit();
        if (isUpdate.booleanValue()) {
            $jacocoInit[50] = true;
            C0120S c = C0120S.m651c();
            $jacocoInit[51] = true;
            return c;
        }
        C0120S c2 = C0120S.m652c(item);
        $jacocoInit[52] = true;
        return c2;
    }

    public C0120S<Install> filterAppcUpgrade(Install item) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S contains = this.updateRepository.contains(item.getPackageName(), false, true);
        C3722jf jfVar = new C3722jf(item);
        $jacocoInit[3] = true;
        C0120S<Install> f = contains.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) jfVar);
        $jacocoInit[4] = true;
        return f;
    }

    /* renamed from: a */
    static /* synthetic */ C0120S m8521a(Install item, Boolean isUpgrade) {
        boolean[] $jacocoInit = $jacocoInit();
        if (isUpgrade.booleanValue()) {
            $jacocoInit[47] = true;
            C0120S c = C0120S.m651c();
            $jacocoInit[48] = true;
            return c;
        }
        C0120S c2 = C0120S.m652c(item);
        $jacocoInit[49] = true;
        return c2;
    }

    public C0120S<Install> filterNonAppcUpgrade(Install item) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S contains = this.updateRepository.contains(item.getPackageName(), false, true);
        C3708hf hfVar = new C3708hf(item);
        $jacocoInit[5] = true;
        C0120S<Install> f = contains.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) hfVar);
        $jacocoInit[6] = true;
        return f;
    }

    /* renamed from: b */
    static /* synthetic */ C0120S m8525b(Install item, Boolean isUpdate) {
        boolean[] $jacocoInit = $jacocoInit();
        if (isUpdate.booleanValue()) {
            $jacocoInit[44] = true;
            C0120S c = C0120S.m652c(item);
            $jacocoInit[45] = true;
            return c;
        }
        C0120S c2 = C0120S.m651c();
        $jacocoInit[46] = true;
        return c2;
    }

    public C0120S<List<Update>> getUpdatesList(boolean isExcluded, boolean excludeAppcUpgrades) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S all = this.updateRepository.getAll(isExcluded);
        C3680df dfVar = new C3680df(excludeAppcUpgrades);
        $jacocoInit[7] = true;
        C0120S f = all.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) dfVar);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        $jacocoInit[8] = true;
        C0120S<List<Update>> c = f.mo3641c(750, timeUnit);
        $jacocoInit[9] = true;
        return c;
    }

    /* renamed from: a */
    static /* synthetic */ C0120S m8523a(boolean excludeAppcUpgrades, List updates) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S c = C0120S.m652c(updates);
        C3736lf lfVar = C3736lf.f7144a;
        $jacocoInit[34] = true;
        C0120S h = c.mo3666h((C0132p<? super T, ? extends Iterable<? extends R>>) lfVar);
        C3659af afVar = new C3659af(excludeAppcUpgrades);
        $jacocoInit[35] = true;
        C0120S d = h.mo3653d((C0132p<? super T, Boolean>) afVar);
        $jacocoInit[36] = true;
        C0120S m = d.mo3675m();
        $jacocoInit[37] = true;
        return m;
    }

    /* renamed from: d */
    static /* synthetic */ Iterable m8528d(List list) {
        $jacocoInit()[43] = true;
        return list;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m8519a(boolean excludeAppcUpgrades, Update update) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!excludeAppcUpgrades) {
            $jacocoInit[38] = true;
        } else if (!update.isAppcUpgrade()) {
            $jacocoInit[39] = true;
        } else {
            z = false;
            $jacocoInit[41] = true;
            Boolean valueOf = Boolean.valueOf(z);
            $jacocoInit[42] = true;
            return valueOf;
        }
        $jacocoInit[40] = true;
        z = true;
        Boolean valueOf2 = Boolean.valueOf(z);
        $jacocoInit[42] = true;
        return valueOf2;
    }

    public C0120S<List<Update>> getAppcUpgradesList(boolean isExcluded) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S all = this.updateRepository.getAll(isExcluded);
        C3666bf bfVar = C3666bf.f7065a;
        $jacocoInit[10] = true;
        C0120S f = all.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) bfVar);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        $jacocoInit[11] = true;
        C0120S<List<Update>> c = f.mo3641c(750, timeUnit);
        $jacocoInit[12] = true;
        return c;
    }

    /* renamed from: b */
    static /* synthetic */ C0120S m8526b(List updates) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S c = C0120S.m652c(updates);
        C3694ff ffVar = C3694ff.f7097a;
        $jacocoInit[28] = true;
        C0120S h = c.mo3666h((C0132p<? super T, ? extends Iterable<? extends R>>) ffVar);
        C3701gf gfVar = C3701gf.f7104a;
        $jacocoInit[29] = true;
        C0120S d = h.mo3653d((C0132p<? super T, Boolean>) gfVar);
        $jacocoInit[30] = true;
        C0120S m = d.mo3675m();
        $jacocoInit[31] = true;
        return m;
    }

    /* renamed from: e */
    static /* synthetic */ Iterable m8529e(List list) {
        $jacocoInit()[33] = true;
        return list;
    }

    /* renamed from: b */
    static /* synthetic */ Boolean m8524b(Update update) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(update.isAppcUpgrade());
        $jacocoInit[32] = true;
        return valueOf;
    }

    public C0120S<Update> getUpdate(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Update> s = this.updateRepository.get(packageName);
        $jacocoInit[13] = true;
        return s;
    }

    public C0120S<List<Update>> getAllUpdates() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S all = this.updateRepository.getAll(false);
        C3673cf cfVar = C3673cf.f7073a;
        $jacocoInit[14] = true;
        C0120S<List<Update>> f = all.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) cfVar);
        $jacocoInit[15] = true;
        return f;
    }

    /* renamed from: a */
    static /* synthetic */ C0120S m8522a(List updates) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S c = C0120S.m652c(updates);
        C3729kf kfVar = C3729kf.f7137a;
        $jacocoInit[20] = true;
        C0120S h = c.mo3666h((C0132p<? super T, ? extends Iterable<? extends R>>) kfVar);
        C3743mf mfVar = C3743mf.f7152a;
        $jacocoInit[21] = true;
        C0120S d = h.mo3653d((C0132p<? super T, Boolean>) mfVar);
        $jacocoInit[22] = true;
        C0120S m = d.mo3675m();
        $jacocoInit[23] = true;
        return m;
    }

    /* renamed from: f */
    static /* synthetic */ Iterable m8530f(List list) {
        $jacocoInit()[27] = true;
        return list;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m8518a(Update update) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!update.isAppcUpgrade()) {
            $jacocoInit[24] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[25] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[26] = true;
        return valueOf;
    }

    public C0120S<Void> excludeUpdate(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> excluded = this.updateRepository.setExcluded(packageName, true);
        $jacocoInit[16] = true;
        return excluded;
    }

    public C0117M refreshUpdates() {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M sync = this.updateRepository.sync(true, false);
        $jacocoInit[17] = true;
        return sync;
    }

    /* renamed from: c */
    static /* synthetic */ Integer m8527c(List list) {
        boolean[] $jacocoInit = $jacocoInit();
        Integer valueOf = Integer.valueOf(list.size());
        $jacocoInit[19] = true;
        return valueOf;
    }

    public C0120S<Integer> getUpdatesNumber() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Integer> j = getUpdatesList(false, false).mo3669j(C3687ef.f7090a);
        $jacocoInit[18] = true;
        return j;
    }
}
