package p005cm.aptoide.p006pt.store.view.p079my;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.support.p001v7.widget.LinearLayoutManager;
import android.support.p001v7.widget.RecyclerView;
import android.support.p001v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.trello.rxlifecycle.p263a.C12543b;
import java.util.List;
import javax.inject.Inject;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.Account;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.bottomNavigation.BottomNavigationActivity;
import p005cm.aptoide.p006pt.bottomNavigation.BottomNavigationItem;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.database.realm.Store;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Event;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.GetStoreWidgetsRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.StoreContext;
import p005cm.aptoide.p006pt.home.HomeEvent.Type;
import p005cm.aptoide.p006pt.logger.Logger;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p005cm.aptoide.p006pt.store.view.GridStoreDisplayable;
import p005cm.aptoide.p006pt.store.view.StoreTabGridRecyclerFragment;
import p005cm.aptoide.p006pt.store.view.StoreTabWidgetsGridRecyclerFragment;
import p005cm.aptoide.p006pt.timeline.view.displayable.FollowStoreDisplayable;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p005cm.aptoide.p006pt.view.recycler.displayable.DisplayableGroup;
import p019d.p022i.p296a.p305c.C13034a;
import p026rx.C0120S;
import p026rx.C0120S.C0121c;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.p387a.p389b.C14522a;
import p026rx.schedulers.Schedulers;
import rx.Observable;

/* renamed from: cm.aptoide.pt.store.view.my.MyStoresFragment */
public class MyStoresFragment extends StoreTabWidgetsGridRecyclerFragment implements MyStoresView {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private static final BottomNavigationItem BOTTOM_NAVIGATION_ITEM = BottomNavigationItem.STORES;
    private static final String TAG = MyStoresFragment.class.getSimpleName();
    private BottomNavigationActivity bottomNavigationActivity;
    @Inject
    MyStoresPresenter myStoresPresenter;
    private ImageView userAvatar;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2251844672135886497L, "cm/aptoide/pt/store/view/my/MyStoresFragment", 89);
        $jacocoData = probes;
        return probes;
    }

    public MyStoresFragment() {
        $jacocoInit()[0] = true;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[88] = true;
    }

    public static MyStoresFragment newInstance(Event event, String storeTheme, String tag, StoreContext storeContext) {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle args = StoreTabGridRecyclerFragment.buildBundle(event, Type.NO_OP, null, storeTheme, tag, storeContext);
        $jacocoInit[1] = true;
        MyStoresFragment fragment = new MyStoresFragment();
        $jacocoInit[2] = true;
        fragment.setArguments(args);
        $jacocoInit[3] = true;
        return fragment;
    }

    public static Fragment newInstance() {
        boolean[] $jacocoInit = $jacocoInit();
        MyStoresFragment myStoresFragment = new MyStoresFragment();
        $jacocoInit[4] = true;
        return myStoresFragment;
    }

    public void onAttach(Activity activity) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onAttach(activity);
        if (!(activity instanceof BottomNavigationActivity)) {
            $jacocoInit[5] = true;
        } else {
            this.bottomNavigationActivity = (BottomNavigationActivity) activity;
            $jacocoInit[6] = true;
        }
        $jacocoInit[7] = true;
    }

    public void onDetach() {
        boolean[] $jacocoInit = $jacocoInit();
        this.bottomNavigationActivity = null;
        $jacocoInit[8] = true;
        super.onDetach();
        $jacocoInit[9] = true;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[10] = true;
        getFragmentComponent(savedInstanceState).inject(this);
        $jacocoInit[11] = true;
    }

    public void onDestroyView() {
        boolean[] $jacocoInit = $jacocoInit();
        this.userAvatar = null;
        $jacocoInit[12] = true;
        super.onDestroyView();
        $jacocoInit[13] = true;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onViewCreated(view, savedInstanceState);
        BottomNavigationActivity bottomNavigationActivity2 = this.bottomNavigationActivity;
        if (bottomNavigationActivity2 == null) {
            $jacocoInit[14] = true;
        } else {
            $jacocoInit[15] = true;
            bottomNavigationActivity2.requestFocus(BOTTOM_NAVIGATION_ITEM);
            $jacocoInit[16] = true;
        }
        registerForViewChanges();
        $jacocoInit[17] = true;
        if (getView() == null) {
            $jacocoInit[18] = true;
        } else {
            $jacocoInit[19] = true;
            this.userAvatar = (ImageView) getView().findViewById(C1375R.C1376id.user_actionbar_icon);
            $jacocoInit[20] = true;
        }
        attachPresenter(this.myStoresPresenter);
        $jacocoInit[21] = true;
    }

    /* access modifiers changed from: protected */
    public C0120S<List<Displayable>> buildDisplayables(boolean refresh, String url, boolean bypassServerCache) {
        boolean[] $jacocoInit = $jacocoInit();
        GetStoreWidgetsRequest newStoreWidgets = this.requestFactoryCdnPool.newStoreWidgets(url);
        $jacocoInit[22] = true;
        C0120S observe = newStoreWidgets.observe(refresh, bypassServerCache);
        $jacocoInit[23] = true;
        C0120S a = observe.mo3616a(Schedulers.m776io());
        C5032B b = new C5032B(this);
        $jacocoInit[24] = true;
        C0120S f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) b);
        C5040e eVar = new C5040e(this);
        $jacocoInit[25] = true;
        C0120S<List<Displayable>> j = f.mo3669j(eVar);
        $jacocoInit[26] = true;
        return j;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreateView(inflater, container, savedInstanceState);
        $jacocoInit[27] = true;
        View inflate = inflater.inflate(C1375R.layout.my_stores, container, false);
        $jacocoInit[28] = true;
        return inflate;
    }

    /* access modifiers changed from: protected */
    public boolean displayHomeUpAsEnabled() {
        $jacocoInit()[29] = true;
        return false;
    }

    public void setupToolbarDetails(Toolbar toolbar) {
        boolean[] $jacocoInit = $jacocoInit();
        toolbar.setTitle((CharSequence) null);
        $jacocoInit[30] = true;
        toolbar.setLogo((Drawable) null);
        $jacocoInit[31] = true;
    }

    /* access modifiers changed from: private */
    public List<Displayable> addFollowStoreDisplayable(List<Displayable> displayables) {
        int groupPosition;
        boolean[] $jacocoInit = $jacocoInit();
        int gridStoreDisplayablePosition = 0;
        $jacocoInit[32] = true;
        int i = 0;
        $jacocoInit[33] = true;
        while (true) {
            if (i >= displayables.size()) {
                $jacocoInit[34] = true;
                groupPosition = 0;
                break;
            }
            $jacocoInit[35] = true;
            if (displayables.get(i) instanceof DisplayableGroup) {
                int groupPosition2 = i;
                $jacocoInit[36] = true;
                groupPosition = groupPosition2;
                break;
            }
            i++;
            $jacocoInit[37] = true;
        }
        DisplayableGroup displayableGroup = (DisplayableGroup) displayables.get(groupPosition);
        $jacocoInit[38] = true;
        List<Displayable> displayableList = displayableGroup.getChildren();
        $jacocoInit[39] = true;
        int i2 = 0;
        $jacocoInit[40] = true;
        while (true) {
            if (i2 >= displayableList.size()) {
                $jacocoInit[41] = true;
                break;
            }
            $jacocoInit[42] = true;
            if (displayableList.get(i2) instanceof GridStoreDisplayable) {
                gridStoreDisplayablePosition = i2;
                $jacocoInit[43] = true;
                break;
            }
            i2++;
            $jacocoInit[44] = true;
        }
        List children = ((DisplayableGroup) displayables.get(groupPosition)).getChildren();
        FollowStoreDisplayable followStoreDisplayable = new FollowStoreDisplayable();
        $jacocoInit[45] = true;
        children.add(gridStoreDisplayablePosition, followStoreDisplayable);
        $jacocoInit[46] = true;
        if (displayableList.size() <= 6) {
            $jacocoInit[47] = true;
        } else {
            $jacocoInit[48] = true;
            List children2 = ((DisplayableGroup) displayables.get(groupPosition)).getChildren();
            $jacocoInit[49] = true;
            children2.remove(displayableList.size() - 1);
            $jacocoInit[50] = true;
        }
        $jacocoInit[51] = true;
        return displayables;
    }

    private void registerForViewChanges() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[52] = true;
        AptoideAccountManager accountManager = ((AptoideApplication) getContext().getApplicationContext()).getAccountManager();
        $jacocoInit[53] = true;
        C0120S accountStatus = accountManager.accountStatus();
        C5036a aVar = new C5036a(this);
        $jacocoInit[54] = true;
        Observable<Account> loginObservable = accountStatus.mo3636b((C0129b<? super T>) aVar);
        $jacocoInit[55] = true;
        C0120S all = this.storeRepository.getAll();
        $jacocoInit[56] = true;
        C0120S a = all.mo3606a(1);
        C5039d dVar = new C5039d(this);
        $jacocoInit[57] = true;
        Observable<List<Store>> storesObservable = a.mo3636b((C0129b<? super T>) dVar);
        $jacocoInit[58] = true;
        C0120S b = C0120S.m649b((C0120S<? extends T>) loginObservable, (C0120S<? extends T>) storesObservable);
        $jacocoInit[59] = true;
        C0120S a2 = b.mo3616a(C14522a.m46170a());
        C12543b bVar = C12543b.DESTROY_VIEW;
        $jacocoInit[60] = true;
        C0120S a3 = a2.mo3614a((C0121c<? super T, ? extends R>) bindUntilEvent(bVar));
        C5037b bVar2 = C5037b.f8725a;
        C5038c cVar = C5038c.f8726a;
        $jacocoInit[61] = true;
        a3.mo3626a((C0129b<? super T>) bVar2, (C0129b<Throwable>) cVar);
        $jacocoInit[62] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16664a(Account __) {
        boolean[] $jacocoInit = $jacocoInit();
        reloadData();
        $jacocoInit[87] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16665a(List __) {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        String str = TAG;
        $jacocoInit[84] = true;
        instance.mo2136d(str, "Store database changed, reloading...");
        $jacocoInit[85] = true;
        reloadData();
        $jacocoInit[86] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m9376a(Object __) {
        $jacocoInit()[83] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m9377b(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[81] = true;
        instance.log(err);
        $jacocoInit[82] = true;
    }

    private void reloadData() {
        boolean[] $jacocoInit = $jacocoInit();
        super.load(false, true, null);
        $jacocoInit[63] = true;
    }

    public void scrollToTop() {
        boolean[] $jacocoInit = $jacocoInit();
        RecyclerView view = getRecyclerView();
        $jacocoInit[64] = true;
        LinearLayoutManager layoutManager = (LinearLayoutManager) view.getLayoutManager();
        $jacocoInit[65] = true;
        if (layoutManager.findLastVisibleItemPosition() <= 10) {
            $jacocoInit[66] = true;
        } else {
            $jacocoInit[67] = true;
            view.mo7618i(10);
            $jacocoInit[68] = true;
        }
        view.mo7622j(0);
        $jacocoInit[69] = true;
    }

    public void setUserImage(String userAvatarUrl) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.userAvatar == null) {
            $jacocoInit[70] = true;
        } else {
            $jacocoInit[71] = true;
            ImageLoader with = ImageLoader.with(getContext());
            ImageView imageView = this.userAvatar;
            $jacocoInit[72] = true;
            with.loadWithShadowCircleTransformWithPlaceholder(userAvatarUrl, imageView, C1375R.drawable.ic_account_circle);
            $jacocoInit[73] = true;
        }
        $jacocoInit[74] = true;
    }

    public C0120S<Void> imageClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13034a.m42490a(this.userAvatar);
        $jacocoInit[75] = true;
        return a;
    }

    public void showAvatar() {
        boolean[] $jacocoInit = $jacocoInit();
        ImageView imageView = this.userAvatar;
        if (imageView == null) {
            $jacocoInit[76] = true;
        } else {
            imageView.setVisibility(0);
            $jacocoInit[77] = true;
        }
        $jacocoInit[78] = true;
    }

    public void setDefaultUserImage() {
        boolean[] $jacocoInit = $jacocoInit();
        ImageLoader with = ImageLoader.with(getContext());
        ImageView imageView = this.userAvatar;
        $jacocoInit[79] = true;
        with.loadUsingCircleTransform((int) C1375R.drawable.ic_account_circle, imageView);
        $jacocoInit[80] = true;
    }
}
