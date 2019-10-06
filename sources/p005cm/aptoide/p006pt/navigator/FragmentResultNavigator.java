package p005cm.aptoide.p006pt.navigator;

import android.os.Bundle;
import android.support.p000v4.app.C0424G;
import android.support.p000v4.app.C0478k;
import android.support.p000v4.app.C0486t;
import android.support.p000v4.app.C0486t.C0487a;
import android.support.p000v4.app.Fragment;
import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p019d.p022i.p023b.C0099b;
import p026rx.C0120S;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.navigator.FragmentResultNavigator */
public class FragmentResultNavigator implements FragmentNavigator {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final int containerId;
    private final int enterAnimation;
    private final int exitAnimation;
    private final C0486t fragmentManager;
    private final C0099b<Map<Integer, Result>> resultRelay;
    private final Map<Integer, Result> results;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4074420123955532453L, "cm/aptoide/pt/navigator/FragmentResultNavigator", 48);
        $jacocoData = probes;
        return probes;
    }

    public FragmentResultNavigator(C0486t fragmentManager2, int containerId2, int enterAnimation2, int exitAnimation2, Map<Integer, Result> resultMap, C0099b<Map<Integer, Result>> resultRelay2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.fragmentManager = fragmentManager2;
        this.containerId = containerId2;
        this.enterAnimation = enterAnimation2;
        this.exitAnimation = exitAnimation2;
        this.results = resultMap;
        this.resultRelay = resultRelay2;
        $jacocoInit[0] = true;
    }

    public void navigateForResult(Fragment fragment, int requestCode, boolean replace) {
        boolean[] $jacocoInit = $jacocoInit();
        setUpNavigationForResult(fragment, requestCode);
        $jacocoInit[1] = true;
        navigateTo(fragment, replace);
        $jacocoInit[2] = true;
    }

    public void navigateToWithoutBackSave(Fragment fragment, boolean replace) {
        C0424G fragmentTransaction;
        boolean[] $jacocoInit = $jacocoInit();
        C0424G a = this.fragmentManager.mo4909a();
        int i = this.enterAnimation;
        int i2 = this.exitAnimation;
        $jacocoInit[3] = true;
        C0424G fragmentTransaction2 = a.mo5033a(i, i2, i, i2);
        if (replace) {
            $jacocoInit[4] = true;
            fragmentTransaction = fragmentTransaction2.mo5040b(this.containerId, fragment);
            $jacocoInit[5] = true;
        } else {
            fragmentTransaction = fragmentTransaction2.mo5034a(this.containerId, fragment);
            $jacocoInit[6] = true;
        }
        fragmentTransaction.mo5032a();
        $jacocoInit[7] = true;
    }

    public void navigateToCleaningBackStack(Fragment fragment, boolean replace) {
        boolean[] $jacocoInit = $jacocoInit();
        cleanBackStack();
        $jacocoInit[8] = true;
        navigateToWithoutBackSave(fragment, replace);
        $jacocoInit[9] = true;
    }

    public String navigateTo(Fragment fragment, boolean replace) {
        C0424G fragmentTransaction;
        boolean[] $jacocoInit = $jacocoInit();
        String tag = Integer.toString(this.fragmentManager.mo4943c());
        $jacocoInit[10] = true;
        C0424G a = this.fragmentManager.mo4909a();
        int i = this.enterAnimation;
        int i2 = this.exitAnimation;
        $jacocoInit[11] = true;
        a.mo5033a(i, i2, i, i2);
        $jacocoInit[12] = true;
        C0424G fragmentTransaction2 = a.mo5038a(tag);
        if (replace) {
            $jacocoInit[13] = true;
            fragmentTransaction = fragmentTransaction2.mo5041b(this.containerId, fragment, tag);
            $jacocoInit[14] = true;
        } else {
            fragmentTransaction = fragmentTransaction2.mo5035a(this.containerId, fragment, tag);
            $jacocoInit[15] = true;
        }
        fragmentTransaction.mo5032a();
        $jacocoInit[16] = true;
        return tag;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m8610a(int requestCode, Map integerResultMap) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(integerResultMap.containsKey(Integer.valueOf(requestCode)));
        $jacocoInit[47] = true;
        return valueOf;
    }

    public C0120S<Result> results(int requestCode) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S d = this.resultRelay.mo3653d((C0132p<? super T, Boolean>) new C4142f<Object,Boolean>(requestCode));
        C4140d dVar = new C4140d(requestCode);
        $jacocoInit[17] = true;
        C0120S j = d.mo3669j(dVar);
        C4141e eVar = new C4141e(this, requestCode);
        $jacocoInit[18] = true;
        C0120S<Result> b = j.mo3636b((C0129b<? super T>) eVar);
        $jacocoInit[19] = true;
        return b;
    }

    /* renamed from: b */
    static /* synthetic */ Result m8611b(int requestCode, Map integerResultMap) {
        Result result = (Result) integerResultMap.get(Integer.valueOf(requestCode));
        $jacocoInit()[46] = true;
        return result;
    }

    /* renamed from: a */
    public /* synthetic */ void mo15209a(int requestCode, Result result) {
        Result result2 = (Result) this.results.remove(Integer.valueOf(requestCode));
        $jacocoInit()[45] = true;
    }

    public void popWithResult(Result result) {
        boolean[] $jacocoInit = $jacocoInit();
        handleNavigationResult(result);
        $jacocoInit[20] = true;
        popBackStack();
        $jacocoInit[21] = true;
    }

    public boolean popBackStack() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean g = this.fragmentManager.mo4961g();
        $jacocoInit[22] = true;
        return g;
    }

    public void cleanBackStack() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = 0;
        $jacocoInit[23] = true;
        while (i < this.fragmentManager.mo4943c()) {
            $jacocoInit[24] = true;
            this.fragmentManager.mo4956f();
            i++;
            $jacocoInit[25] = true;
        }
        this.fragmentManager.mo4940b();
        $jacocoInit[26] = true;
    }

    public Fragment peekLast() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.fragmentManager.mo4943c() > 0) {
            C0486t tVar = this.fragmentManager;
            $jacocoInit[27] = true;
            C0487a backStackEntry = tVar.mo4933b(tVar.mo4943c() - 1);
            $jacocoInit[28] = true;
            Fragment a = this.fragmentManager.mo4908a(backStackEntry.getName());
            $jacocoInit[29] = true;
            return a;
        }
        $jacocoInit[30] = true;
        return null;
    }

    public Fragment getFragment() {
        boolean[] $jacocoInit = $jacocoInit();
        Fragment a = this.fragmentManager.mo4906a(this.containerId);
        $jacocoInit[31] = true;
        return a;
    }

    public Fragment getFragment(String tag) {
        boolean[] $jacocoInit = $jacocoInit();
        Fragment a = this.fragmentManager.mo4908a(tag);
        $jacocoInit[32] = true;
        return a;
    }

    public void navigateToDialogFragment(C0478k fragment) {
        boolean[] $jacocoInit = $jacocoInit();
        String tag = Integer.toString(this.fragmentManager.mo4943c());
        $jacocoInit[33] = true;
        fragment.show(this.fragmentManager, tag);
        $jacocoInit[34] = true;
    }

    public void navigateToDialogForResult(C0478k fragment, int requestCode) {
        boolean[] $jacocoInit = $jacocoInit();
        setUpNavigationForResult(fragment, requestCode);
        $jacocoInit[35] = true;
        navigateToDialogFragment(fragment);
        $jacocoInit[36] = true;
    }

    public void popDialogWithResult(Result result) {
        boolean[] $jacocoInit = $jacocoInit();
        handleNavigationResult(result);
        $jacocoInit[37] = true;
    }

    private void setUpNavigationForResult(Fragment fragment, int requestCode) {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle extras = fragment.getArguments();
        if (extras != null) {
            $jacocoInit[38] = true;
        } else {
            $jacocoInit[39] = true;
            extras = new Bundle();
            $jacocoInit[40] = true;
        }
        extras.putInt(FragmentNavigator.REQUEST_CODE_EXTRA, requestCode);
        $jacocoInit[41] = true;
        fragment.setArguments(extras);
        $jacocoInit[42] = true;
    }

    private void handleNavigationResult(Result result) {
        boolean[] $jacocoInit = $jacocoInit();
        this.results.put(Integer.valueOf(result.getRequestCode()), result);
        $jacocoInit[43] = true;
        this.resultRelay.call(this.results);
        $jacocoInit[44] = true;
    }
}
