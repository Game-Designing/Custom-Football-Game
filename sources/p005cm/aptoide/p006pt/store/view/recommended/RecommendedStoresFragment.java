package p005cm.aptoide.p006pt.store.view.recommended;

import android.content.Context;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import com.trello.rxlifecycle.p263a.C12543b;
import java.util.ArrayList;
import java.util.List;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.database.AccessorFactory;
import p005cm.aptoide.p006pt.database.accessors.StoreAccessor;
import p005cm.aptoide.p006pt.database.realm.Store;
import p005cm.aptoide.p006pt.dataprovider.WebService;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.DataList;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.ListStores;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.Endless;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.GetRecommendedStoresRequest;
import p005cm.aptoide.p006pt.store.StoreCredentialsProvider;
import p005cm.aptoide.p006pt.store.StoreCredentialsProviderImpl;
import p005cm.aptoide.p006pt.store.StoreUtilsProxy;
import p005cm.aptoide.p006pt.store.view.GetStoreEndlessFragment;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p026rx.C0120S;
import p026rx.C0120S.C0121c;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.store.view.recommended.RecommendedStoresFragment */
public class RecommendedStoresFragment extends GetStoreEndlessFragment<ListStores> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private AptoideAccountManager accountManager;
    private StoreCredentialsProvider storeCredentialsProvider;
    private StoreUtilsProxy storeUtilsProxy;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8427267785391687702L, "cm/aptoide/pt/store/view/recommended/RecommendedStoresFragment", 27);
        $jacocoData = probes;
        return probes;
    }

    public RecommendedStoresFragment() {
        $jacocoInit()[0] = true;
    }

    public static Fragment newInstance() {
        boolean[] $jacocoInit = $jacocoInit();
        RecommendedStoresFragment recommendedStoresFragment = new RecommendedStoresFragment();
        $jacocoInit[1] = true;
        return recommendedStoresFragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[2] = true;
        Context applicationContext = getContext().getApplicationContext();
        $jacocoInit[3] = true;
        $jacocoInit[4] = true;
        this.storeCredentialsProvider = new StoreCredentialsProviderImpl((StoreAccessor) AccessorFactory.getAccessorFor(((AptoideApplication) applicationContext.getApplicationContext()).getDatabase(), Store.class));
        $jacocoInit[5] = true;
        this.accountManager = ((AptoideApplication) getContext().getApplicationContext()).getAccountManager();
        $jacocoInit[6] = true;
        BodyInterceptor<BaseBody> bodyInterceptor = ((AptoideApplication) getContext().getApplicationContext()).getAccountSettingsBodyInterceptorPoolV7();
        $jacocoInit[7] = true;
        OkHttpClient httpClient = ((AptoideApplication) getContext().getApplicationContext()).getDefaultClient();
        AptoideAccountManager aptoideAccountManager = this.accountManager;
        StoreCredentialsProvider storeCredentialsProvider2 = this.storeCredentialsProvider;
        $jacocoInit[8] = true;
        Context applicationContext2 = getContext().getApplicationContext();
        $jacocoInit[9] = true;
        $jacocoInit[10] = true;
        StoreAccessor storeAccessor = (StoreAccessor) AccessorFactory.getAccessorFor(((AptoideApplication) applicationContext2.getApplicationContext()).getDatabase(), Store.class);
        $jacocoInit[11] = true;
        Factory defaultConverter = WebService.getDefaultConverter();
        $jacocoInit[12] = true;
        TokenInvalidator tokenInvalidator = ((AptoideApplication) getContext().getApplicationContext()).getTokenInvalidator();
        $jacocoInit[13] = true;
        StoreUtilsProxy storeUtilsProxy2 = new StoreUtilsProxy(aptoideAccountManager, bodyInterceptor, storeCredentialsProvider2, storeAccessor, httpClient, defaultConverter, tokenInvalidator, ((AptoideApplication) getContext().getApplicationContext()).getDefaultSharedPreferences());
        this.storeUtilsProxy = storeUtilsProxy2;
        $jacocoInit[14] = true;
    }

    /* access modifiers changed from: protected */
    public C0044V7<ListStores, ? extends Endless> buildRequest(boolean refresh, String url) {
        boolean[] $jacocoInit = $jacocoInit();
        GetRecommendedStoresRequest newGetRecommendedStores = this.requestFactoryCdnPool.newGetRecommendedStores(url);
        $jacocoInit[15] = true;
        return newGetRecommendedStores;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16716a(ListStores listStores) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S c = C0120S.m652c(listStores);
        C5081j jVar = C5081j.f8776a;
        $jacocoInit[17] = true;
        C0120S h = c.mo3666h((C0132p<? super T, ? extends Iterable<? extends R>>) jVar);
        C5079h hVar = new C5079h(this);
        $jacocoInit[18] = true;
        C0120S j = h.mo3669j(hVar);
        $jacocoInit[19] = true;
        C0120S m = j.mo3675m();
        C12543b bVar = C12543b.DESTROY_VIEW;
        $jacocoInit[20] = true;
        C0120S a = m.mo3614a((C0121c<? super T, ? extends R>) bindUntilEvent(bVar));
        C5082k kVar = new C5082k(this);
        $jacocoInit[21] = true;
        a.mo3646c((C0129b<? super T>) kVar);
        $jacocoInit[22] = true;
    }

    /* access modifiers changed from: protected */
    public C0129b<ListStores> buildAction() {
        boolean[] $jacocoInit = $jacocoInit();
        C5080i iVar = new C5080i(this);
        $jacocoInit[16] = true;
        return iVar;
    }

    /* renamed from: b */
    static /* synthetic */ Iterable m9412b(ListStores getStoreWidgets) {
        boolean[] $jacocoInit = $jacocoInit();
        DataList dataList = getStoreWidgets.getDataList();
        $jacocoInit[25] = true;
        List list = dataList.getList();
        $jacocoInit[26] = true;
        return list;
    }

    /* renamed from: a */
    public /* synthetic */ RecommendedStoreDisplayable mo16715a(p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store store) {
        boolean[] $jacocoInit = $jacocoInit();
        RecommendedStoreDisplayable recommendedStoreDisplayable = new RecommendedStoreDisplayable(store, this.storeRepository, this.accountManager, this.storeUtilsProxy, this.storeCredentialsProvider, "Recommended Stores More");
        $jacocoInit[24] = true;
        return recommendedStoreDisplayable;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16717a(List disp) {
        boolean[] $jacocoInit = $jacocoInit();
        addDisplayables((List<? extends Displayable>) new ArrayList<Object>(disp), true);
        $jacocoInit[23] = true;
    }
}
