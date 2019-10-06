package p005cm.aptoide.p006pt.navigator;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.content.C0510b;
import android.view.WindowManager;
import java.util.Map;
import javax.inject.Inject;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.runtime.AgentOptions;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.account.view.AccountNavigator;
import p005cm.aptoide.p006pt.billing.view.BillingNavigator;
import p005cm.aptoide.p006pt.billing.view.PurchaseBundleMapper;
import p005cm.aptoide.p006pt.orientation.ScreenOrientationManager;
import p005cm.aptoide.p006pt.store.StoreTheme;
import p005cm.aptoide.p006pt.view.fragment.FragmentView;
import p019d.p022i.p023b.C0099b;
import p019d.p022i.p023b.C0100e;
import p026rx.C0120S;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.navigator.ActivityResultNavigator */
public abstract class ActivityResultNavigator extends ActivityCustomTabsNavigator implements ActivityNavigator {
    private static transient /* synthetic */ boolean[] $jacocoData;
    @Inject
    AccountNavigator accountNavigator;
    private BillingNavigator billingNavigator;
    private FragmentNavigator fragmentNavigator;
    private Map<Integer, Result> fragmentResultMap;
    private C0099b<Map<Integer, Result>> fragmentResultRelay;
    @Inject
    String marketName;
    private C0100e<Result> resultRelay;
    private ScreenOrientationManager screenOrientationManager;
    @Inject
    String theme;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8888240591741716343L, "cm/aptoide/pt/navigator/ActivityResultNavigator", 75);
        $jacocoData = probes;
        return probes;
    }

    public ActivityResultNavigator() {
        $jacocoInit()[0] = true;
    }

    public C0099b<Map<Integer, Result>> getFragmentResultRelay() {
        boolean[] $jacocoInit = $jacocoInit();
        C0099b<Map<Integer, Result>> bVar = this.fragmentResultRelay;
        $jacocoInit[1] = true;
        return bVar;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        this.fragmentResultRelay = ((AptoideApplication) getApplicationContext()).getFragmentResultRelay();
        $jacocoInit[2] = true;
        this.fragmentResultMap = ((AptoideApplication) getApplicationContext()).getFragmentResulMap();
        $jacocoInit[3] = true;
        FragmentResultNavigator fragmentResultNavigator = new FragmentResultNavigator(getSupportFragmentManager(), C1375R.C1376id.fragment_placeholder, 17432576, 17432577, this.fragmentResultMap, this.fragmentResultRelay);
        this.fragmentNavigator = fragmentResultNavigator;
        $jacocoInit[4] = true;
        super.onCreate(savedInstanceState);
        $jacocoInit[5] = true;
        this.resultRelay = C0100e.m565o();
        $jacocoInit[6] = true;
        getActivityComponent().inject(this);
        $jacocoInit[7] = true;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onActivityResult(requestCode, resultCode, data);
        $jacocoInit[8] = true;
        this.resultRelay.call(new Result(requestCode, resultCode, data));
        $jacocoInit[9] = true;
        Fragment fragment = getFragmentNavigator().getFragment();
        if (fragment == null) {
            $jacocoInit[10] = true;
        } else if (!(fragment instanceof FragmentView)) {
            $jacocoInit[11] = true;
        } else {
            FragmentView fragmentView = (FragmentView) fragment;
            $jacocoInit[12] = true;
            if (fragmentView.isStartActivityForResultCalled()) {
                $jacocoInit[13] = true;
            } else {
                $jacocoInit[14] = true;
                fragment.onActivityResult(requestCode, resultCode, data);
                $jacocoInit[15] = true;
            }
        }
        $jacocoInit[16] = true;
    }

    public void navigateForResult(Class<? extends Activity> activityClass, int requestCode, Bundle bundle) {
        boolean[] $jacocoInit = $jacocoInit();
        Intent intent = new Intent();
        $jacocoInit[17] = true;
        intent.setComponent(new ComponentName(this, activityClass));
        $jacocoInit[18] = true;
        intent.putExtras(bundle);
        $jacocoInit[19] = true;
        startActivityForResult(intent, requestCode);
        $jacocoInit[20] = true;
    }

    public void navigateForResult(Intent intent, int requestCode) {
        boolean[] $jacocoInit = $jacocoInit();
        startActivityForResult(intent, requestCode);
        $jacocoInit[21] = true;
    }

    /* renamed from: c */
    static /* synthetic */ Boolean m402c(int requestCode, Result result) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (result.getRequestCode() == requestCode) {
            $jacocoInit[72] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[73] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[74] = true;
        return valueOf;
    }

    public C0120S<Result> results(int requestCode) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Result> d = this.resultRelay.mo3653d((C0132p<? super T, Boolean>) new C4139c<Object,Boolean>(requestCode));
        $jacocoInit[22] = true;
        return d;
    }

    public C0120S<Result> navigateForResult(String action, Uri uri, int requestCode) {
        boolean[] $jacocoInit = $jacocoInit();
        startActivityForResult(new Intent(action, uri), requestCode);
        $jacocoInit[23] = true;
        C0120S<Result> d = this.resultRelay.mo3653d((C0132p<? super T, Boolean>) new C4137a<Object,Boolean>(requestCode));
        $jacocoInit[24] = true;
        return d;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m400a(int requestCode, Result result) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (result.getRequestCode() == requestCode) {
            $jacocoInit[69] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[70] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[71] = true;
        return valueOf;
    }

    public void navigateForResult(String action, Uri uri, int requestCode, String extraId, String extraValue) {
        boolean[] $jacocoInit = $jacocoInit();
        Intent intent = new Intent(action);
        $jacocoInit[25] = true;
        intent.setData(uri);
        $jacocoInit[26] = true;
        intent.putExtra(extraId, extraValue);
        $jacocoInit[27] = true;
        startActivityForResult(intent, requestCode);
        $jacocoInit[28] = true;
    }

    public C0120S<Result> navigateForResultWithOutput(String action, Uri outputUri, int requestCode) {
        boolean[] $jacocoInit = $jacocoInit();
        Intent intent = new Intent(action);
        $jacocoInit[29] = true;
        if (intent.resolveActivity(getPackageManager()) != null) {
            $jacocoInit[30] = true;
            intent.putExtra(AgentOptions.OUTPUT, outputUri);
            $jacocoInit[31] = true;
            startActivityForResult(intent, requestCode);
            $jacocoInit[32] = true;
            C0120S<Result> d = this.resultRelay.mo3653d((C0132p<? super T, Boolean>) new C4138b<Object,Boolean>(requestCode));
            $jacocoInit[33] = true;
            return d;
        }
        C0120S<Result> c = C0120S.m651c();
        $jacocoInit[34] = true;
        return c;
    }

    /* renamed from: b */
    static /* synthetic */ Boolean m401b(int requestCode, Result result) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (result.getRequestCode() == requestCode) {
            $jacocoInit[66] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[67] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[68] = true;
        return valueOf;
    }

    public void navigateTo(Class<? extends Activity> activityClass) {
        boolean[] $jacocoInit = $jacocoInit();
        Intent intent = new Intent();
        $jacocoInit[35] = true;
        intent.setComponent(new ComponentName(this, activityClass));
        $jacocoInit[36] = true;
        startActivity(intent);
        $jacocoInit[37] = true;
    }

    public void navigateTo(Class<? extends Activity> activityClass, Bundle bundle) {
        boolean[] $jacocoInit = $jacocoInit();
        Intent intent = new Intent();
        $jacocoInit[38] = true;
        intent.setComponent(new ComponentName(this, activityClass));
        $jacocoInit[39] = true;
        intent.putExtras(bundle);
        $jacocoInit[40] = true;
        startActivity(intent);
        $jacocoInit[41] = true;
    }

    public void navigateBackWithResult(int resultCode, Bundle bundle) {
        boolean[] $jacocoInit = $jacocoInit();
        setResult(resultCode, new Intent().putExtras(bundle));
        $jacocoInit[42] = true;
        finish();
        $jacocoInit[43] = true;
    }

    public void navigateBack() {
        boolean[] $jacocoInit = $jacocoInit();
        finish();
        $jacocoInit[44] = true;
    }

    public void navigateTo(Uri uri) {
        boolean[] $jacocoInit = $jacocoInit();
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        $jacocoInit[45] = true;
        intent.setFlags(268435456);
        $jacocoInit[46] = true;
        startActivity(intent);
        $jacocoInit[47] = true;
    }

    public C0120S<Result> results() {
        boolean[] $jacocoInit = $jacocoInit();
        C0100e<Result> eVar = this.resultRelay;
        $jacocoInit[48] = true;
        return eVar;
    }

    public Activity getActivity() {
        $jacocoInit()[49] = true;
        return this;
    }

    public ActivityNavigator getActivityNavigator() {
        $jacocoInit()[50] = true;
        return this;
    }

    public FragmentNavigator getFragmentNavigator() {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentNavigator fragmentNavigator2 = this.fragmentNavigator;
        $jacocoInit[51] = true;
        return fragmentNavigator2;
    }

    public Map<Integer, Result> getFragmentResultMap() {
        boolean[] $jacocoInit = $jacocoInit();
        Map<Integer, Result> map = this.fragmentResultMap;
        $jacocoInit[52] = true;
        return map;
    }

    public AccountNavigator getAccountNavigator() {
        boolean[] $jacocoInit = $jacocoInit();
        AccountNavigator accountNavigator2 = this.accountNavigator;
        $jacocoInit[53] = true;
        return accountNavigator2;
    }

    public BillingNavigator getBillingNavigator() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.billingNavigator != null) {
            $jacocoInit[54] = true;
        } else {
            $jacocoInit[55] = true;
            StoreTheme storeTheme = StoreTheme.get(this.theme);
            $jacocoInit[56] = true;
            int toolbarColor = storeTheme.getPrimaryColor();
            $jacocoInit[57] = true;
            PurchaseBundleMapper purchaseBundleMapper = ((AptoideApplication) getApplicationContext()).getPurchaseBundleMapper();
            $jacocoInit[58] = true;
            ActivityNavigator activityNavigator = getActivityNavigator();
            FragmentNavigator fragmentNavigator2 = getFragmentNavigator();
            String str = this.marketName;
            $jacocoInit[59] = true;
            BillingNavigator billingNavigator2 = new BillingNavigator(purchaseBundleMapper, activityNavigator, fragmentNavigator2, str, this, C0510b.m2564a((Context) this, toolbarColor));
            this.billingNavigator = billingNavigator2;
            $jacocoInit[60] = true;
        }
        BillingNavigator billingNavigator3 = this.billingNavigator;
        $jacocoInit[61] = true;
        return billingNavigator3;
    }

    public ScreenOrientationManager getScreenOrientationManager() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.screenOrientationManager != null) {
            $jacocoInit[62] = true;
        } else {
            $jacocoInit[63] = true;
            this.screenOrientationManager = new ScreenOrientationManager(this, (WindowManager) getSystemService("window"));
            $jacocoInit[64] = true;
        }
        ScreenOrientationManager screenOrientationManager2 = this.screenOrientationManager;
        $jacocoInit[65] = true;
        return screenOrientationManager2;
    }
}
