package p005cm.aptoide.p006pt.app.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout.C0227b;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.p001v7.widget.RecyclerView;
import android.support.p001v7.widget.RecyclerView.C0988n;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory.Builder;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.app.view.displayable.OtherVersionDisplayable;
import p005cm.aptoide.p006pt.database.AccessorFactory;
import p005cm.aptoide.p006pt.database.accessors.StoreAccessor;
import p005cm.aptoide.p006pt.database.realm.Store;
import p005cm.aptoide.p006pt.dataprovider.WebService;
import p005cm.aptoide.p006pt.dataprovider.interfaces.SuccessRequestListener;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.listapp.App;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.listapp.ListAppVersions;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.listapps.ListAppVersionsRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.StoreContext;
import p005cm.aptoide.p006pt.dataprovider.util.HashMapNotNull;
import p005cm.aptoide.p006pt.logger.Logger;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p005cm.aptoide.p006pt.preferences.managed.ManagerPreferences;
import p005cm.aptoide.p006pt.store.StoreUtils;
import p005cm.aptoide.p006pt.util.AppBarStateChangeListener;
import p005cm.aptoide.p006pt.util.AppBarStateChangeListener.State;
import p005cm.aptoide.p006pt.view.fragment.AptoideBaseFragment;
import p005cm.aptoide.p006pt.view.recycler.BaseAdapter;
import p005cm.aptoide.p006pt.view.recycler.EndlessRecyclerOnScrollListener;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.app.view.OtherVersionsFragment */
public class OtherVersionsFragment extends AptoideBaseFragment<BaseAdapter> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private static final String TAG = OtherVersionsFragment.class.getSimpleName();
    private String appImgUrl;
    private String appName;
    private String appPackge;
    private BodyInterceptor<BaseBody> baseBodyInterceptor;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private Factory converterFactory;
    private EndlessRecyclerOnScrollListener endlessRecyclerOnScrollListener;
    private ViewHeader header;
    private OkHttpClient httpClient;
    private SharedPreferences sharedPreferences;

    /* renamed from: cm.aptoide.pt.app.view.OtherVersionsFragment$1 */
    static /* synthetic */ class C18901 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$util$AppBarStateChangeListener$State = new int[State.values().length];
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(3079627368838947979L, "cm/aptoide/pt/app/view/OtherVersionsFragment$1", 8);
            $jacocoData = probes;
            return probes;
        }

        static {
            boolean[] $jacocoInit = $jacocoInit();
            try {
                $jacocoInit[0] = true;
                $SwitchMap$cm$aptoide$pt$util$AppBarStateChangeListener$State[State.EXPANDED.ordinal()] = 1;
                $jacocoInit[1] = true;
            } catch (NoSuchFieldError e) {
                try {
                    $jacocoInit[2] = true;
                } catch (NoSuchFieldError e2) {
                    try {
                        $jacocoInit[4] = true;
                    } catch (NoSuchFieldError e3) {
                        $jacocoInit[6] = true;
                    }
                }
            }
            $SwitchMap$cm$aptoide$pt$util$AppBarStateChangeListener$State[State.IDLE.ordinal()] = 2;
            $jacocoInit[3] = true;
            $SwitchMap$cm$aptoide$pt$util$AppBarStateChangeListener$State[State.MOVING.ordinal()] = 3;
            $jacocoInit[5] = true;
            $jacocoInit[7] = true;
        }
    }

    /* renamed from: cm.aptoide.pt.app.view.OtherVersionsFragment$BundleCons */
    public class BundleCons {
        private static transient /* synthetic */ boolean[] $jacocoData = null;
        public static final String APP_IMG_URL = "app_img_url";
        public static final String APP_NAME = "app_name";
        public static final String APP_PACKAGE = "app_package";
        final /* synthetic */ OtherVersionsFragment this$0;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(-8296765674335549809L, "cm/aptoide/pt/app/view/OtherVersionsFragment$BundleCons", 1);
            $jacocoData = probes;
            return probes;
        }

        public BundleCons(OtherVersionsFragment this$02) {
            boolean[] $jacocoInit = $jacocoInit();
            this.this$0 = this$02;
            $jacocoInit[0] = true;
        }
    }

    /* renamed from: cm.aptoide.pt.app.view.OtherVersionsFragment$ViewHeader */
    private static final class ViewHeader {
        private static transient /* synthetic */ boolean[] $jacocoData;
        private final boolean animationsEnabled;
        private final AppBarLayout appBarLayout;
        private final ImageView appIcon;
        private final TextView otherVersionsTitle;
        private final View view;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(2060218266065889037L, "cm/aptoide/pt/app/view/OtherVersionsFragment$ViewHeader", 12);
            $jacocoData = probes;
            return probes;
        }

        static /* synthetic */ void access$000(ViewHeader x0, String x1) {
            boolean[] $jacocoInit = $jacocoInit();
            x0.setImage(x1);
            $jacocoInit[8] = true;
        }

        static /* synthetic */ boolean access$100(ViewHeader x0) {
            boolean[] $jacocoInit = $jacocoInit();
            boolean z = x0.animationsEnabled;
            $jacocoInit[9] = true;
            return z;
        }

        static /* synthetic */ ImageView access$200(ViewHeader x0) {
            boolean[] $jacocoInit = $jacocoInit();
            ImageView imageView = x0.appIcon;
            $jacocoInit[10] = true;
            return imageView;
        }

        static /* synthetic */ TextView access$300(ViewHeader x0) {
            boolean[] $jacocoInit = $jacocoInit();
            TextView textView = x0.otherVersionsTitle;
            $jacocoInit[11] = true;
            return textView;
        }

        ViewHeader(View view2, SharedPreferences sharedPreferences) {
            boolean[] $jacocoInit = $jacocoInit();
            this.view = view2;
            $jacocoInit[0] = true;
            this.animationsEnabled = ManagerPreferences.getAnimationsEnabledStatus(sharedPreferences);
            $jacocoInit[1] = true;
            this.otherVersionsTitle = (TextView) view2.findViewById(C1375R.C1376id.other_versions_title);
            $jacocoInit[2] = true;
            this.appBarLayout = (AppBarLayout) view2.findViewById(C1375R.C1376id.app_bar);
            $jacocoInit[3] = true;
            this.appIcon = (ImageView) view2.findViewById(C1375R.C1376id.app_icon);
            $jacocoInit[4] = true;
            this.appBarLayout.mo4186a((C0227b) new AppBarStateChangeListener(this) {
                private static transient /* synthetic */ boolean[] $jacocoData;
                final /* synthetic */ ViewHeader this$0;

                private static /* synthetic */ boolean[] $jacocoInit() {
                    boolean[] zArr = $jacocoData;
                    if (zArr != null) {
                        return zArr;
                    }
                    boolean[] probes = Offline.getProbes(842316813976076609L, "cm/aptoide/pt/app/view/OtherVersionsFragment$ViewHeader$1", 14);
                    $jacocoData = probes;
                    return probes;
                }

                {
                    boolean[] $jacocoInit = $jacocoInit();
                    this.this$0 = this$0;
                    $jacocoInit[0] = true;
                }

                public void onStateChanged(AppBarLayout appBarLayout, State state) {
                    boolean[] $jacocoInit = $jacocoInit();
                    if (C18901.$SwitchMap$cm$aptoide$pt$util$AppBarStateChangeListener$State[state.ordinal()] != 1) {
                        if (ViewHeader.access$100(this.this$0)) {
                            $jacocoInit[7] = true;
                            ViewPropertyAnimator animate = ViewHeader.access$200(this.this$0).animate();
                            $jacocoInit[8] = true;
                            ViewPropertyAnimator alpha = animate.alpha(0.0f);
                            $jacocoInit[9] = true;
                            alpha.start();
                            $jacocoInit[10] = true;
                        } else {
                            ViewHeader.access$200(this.this$0).setVisibility(4);
                            $jacocoInit[11] = true;
                        }
                        ViewHeader.access$300(this.this$0).setVisibility(4);
                        $jacocoInit[12] = true;
                    } else {
                        if (ViewHeader.access$100(this.this$0)) {
                            $jacocoInit[1] = true;
                            ViewPropertyAnimator animate2 = ViewHeader.access$200(this.this$0).animate();
                            $jacocoInit[2] = true;
                            ViewPropertyAnimator alpha2 = animate2.alpha(1.0f);
                            $jacocoInit[3] = true;
                            alpha2.start();
                            $jacocoInit[4] = true;
                        } else {
                            ViewHeader.access$200(this.this$0).setVisibility(0);
                            $jacocoInit[5] = true;
                        }
                        ViewHeader.access$300(this.this$0).setVisibility(0);
                        $jacocoInit[6] = true;
                    }
                    $jacocoInit[13] = true;
                }
            });
            $jacocoInit[5] = true;
        }

        private void setImage(String imgUrl) {
            boolean[] $jacocoInit = $jacocoInit();
            ImageLoader with = ImageLoader.with(this.view.getContext());
            ImageView imageView = this.appIcon;
            $jacocoInit[6] = true;
            with.load(imgUrl, imageView);
            $jacocoInit[7] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2379099314710009872L, "cm/aptoide/pt/app/view/OtherVersionsFragment", 72);
        $jacocoData = probes;
        return probes;
    }

    public OtherVersionsFragment() {
        $jacocoInit()[0] = true;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[71] = true;
    }

    public static OtherVersionsFragment newInstance(String appName2, String appImgUrl2, String appPackage) {
        boolean[] $jacocoInit = $jacocoInit();
        OtherVersionsFragment fragment = new OtherVersionsFragment();
        $jacocoInit[1] = true;
        Bundle args = new Bundle();
        $jacocoInit[2] = true;
        args.putString("app_name", appName2);
        $jacocoInit[3] = true;
        args.putString(BundleCons.APP_IMG_URL, appImgUrl2);
        $jacocoInit[4] = true;
        args.putString(BundleCons.APP_PACKAGE, appPackage);
        $jacocoInit[5] = true;
        fragment.setArguments(args);
        $jacocoInit[6] = true;
        return fragment;
    }

    public ScreenTagHistory getHistoryTracker() {
        boolean[] $jacocoInit = $jacocoInit();
        Class cls = getClass();
        $jacocoInit[7] = true;
        String simpleName = cls.getSimpleName();
        $jacocoInit[8] = true;
        ScreenTagHistory build = Builder.build(simpleName);
        $jacocoInit[9] = true;
        return build;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[10] = true;
        this.sharedPreferences = ((AptoideApplication) getContext().getApplicationContext()).getDefaultSharedPreferences();
        $jacocoInit[11] = true;
        this.baseBodyInterceptor = ((AptoideApplication) getContext().getApplicationContext()).getAccountSettingsBodyInterceptorPoolV7();
        $jacocoInit[12] = true;
        this.httpClient = ((AptoideApplication) getContext().getApplicationContext()).getDefaultClient();
        $jacocoInit[13] = true;
        this.converterFactory = WebService.getDefaultConverter();
        $jacocoInit[14] = true;
        setHasOptionsMenu(true);
        $jacocoInit[15] = true;
    }

    public void loadExtras(Bundle args) {
        boolean[] $jacocoInit = $jacocoInit();
        super.loadExtras(args);
        $jacocoInit[16] = true;
        this.appName = args.getString("app_name");
        $jacocoInit[17] = true;
        this.appImgUrl = args.getString(BundleCons.APP_IMG_URL);
        $jacocoInit[18] = true;
        this.appPackge = args.getString(BundleCons.APP_PACKAGE);
        $jacocoInit[19] = true;
    }

    public int getContentViewId() {
        $jacocoInit()[20] = true;
        return C1375R.layout.fragment_other_versions;
    }

    public void onDestroyView() {
        boolean[] $jacocoInit = $jacocoInit();
        RecyclerView recyclerView = getRecyclerView();
        if (recyclerView == null) {
            $jacocoInit[21] = true;
        } else {
            EndlessRecyclerOnScrollListener endlessRecyclerOnScrollListener2 = this.endlessRecyclerOnScrollListener;
            if (endlessRecyclerOnScrollListener2 == null) {
                $jacocoInit[22] = true;
            } else {
                $jacocoInit[23] = true;
                recyclerView.mo7549b((C0988n) endlessRecyclerOnScrollListener2);
                $jacocoInit[24] = true;
            }
        }
        this.endlessRecyclerOnScrollListener = null;
        this.header = null;
        this.collapsingToolbarLayout = null;
        $jacocoInit[25] = true;
        super.onDestroyView();
        $jacocoInit[26] = true;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        this.header = new ViewHeader(view, this.sharedPreferences);
        $jacocoInit[27] = true;
        this.collapsingToolbarLayout = (CollapsingToolbarLayout) view.findViewById(C1375R.C1376id.collapsing_toolbar);
        $jacocoInit[28] = true;
        super.onViewCreated(view, savedInstanceState);
        $jacocoInit[29] = true;
    }

    public void load(boolean create, boolean refresh, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("Other versions should refresh? ");
        sb.append(create);
        String sb2 = sb.toString();
        $jacocoInit[30] = true;
        instance.mo2136d(str, sb2);
        $jacocoInit[31] = true;
        fetchOtherVersions();
        $jacocoInit[32] = true;
        setHeader();
        $jacocoInit[33] = true;
    }

    public void onResume() {
        boolean[] $jacocoInit = $jacocoInit();
        super.onResume();
        $jacocoInit[34] = true;
    }

    /* access modifiers changed from: protected */
    public void fetchOtherVersions() {
        boolean[] $jacocoInit = $jacocoInit();
        SuccessRequestListener<ListAppVersions> otherVersionsSuccessRequestListener = new C2140li<>(this);
        $jacocoInit[35] = true;
        BaseAdapter adapter = getAdapter();
        String str = this.appPackge;
        $jacocoInit[36] = true;
        Context applicationContext = getContext().getApplicationContext();
        $jacocoInit[37] = true;
        $jacocoInit[38] = true;
        StoreAccessor storeAccessor = (StoreAccessor) AccessorFactory.getAccessorFor(((AptoideApplication) applicationContext.getApplicationContext()).getDatabase(), Store.class);
        $jacocoInit[39] = true;
        HashMapNotNull subscribedStoresAuthMap = StoreUtils.getSubscribedStoresAuthMap(storeAccessor);
        BodyInterceptor<BaseBody> bodyInterceptor = this.baseBodyInterceptor;
        OkHttpClient okHttpClient = this.httpClient;
        Factory factory = this.converterFactory;
        $jacocoInit[40] = true;
        TokenInvalidator tokenInvalidator = ((AptoideApplication) getContext().getApplicationContext()).getTokenInvalidator();
        $jacocoInit[41] = true;
        SharedPreferences defaultSharedPreferences = ((AptoideApplication) getContext().getApplicationContext()).getDefaultSharedPreferences();
        $jacocoInit[42] = true;
        Resources resources = getContext().getResources();
        $jacocoInit[43] = true;
        this.endlessRecyclerOnScrollListener = new EndlessRecyclerOnScrollListener(adapter, ListAppVersionsRequest.m7553of(str, subscribedStoresAuthMap, bodyInterceptor, okHttpClient, factory, tokenInvalidator, defaultSharedPreferences, resources), otherVersionsSuccessRequestListener, C2130ki.f5193a);
        $jacocoInit[44] = true;
        getRecyclerView().mo7530a((C0988n) this.endlessRecyclerOnScrollListener);
        $jacocoInit[45] = true;
        this.endlessRecyclerOnScrollListener.onLoadMore(false, false);
        $jacocoInit[46] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo10850a(ListAppVersions listAppVersions) {
        boolean[] $jacocoInit = $jacocoInit();
        List<App> apps = listAppVersions.getList();
        $jacocoInit[64] = true;
        ArrayList<Displayable> displayables = new ArrayList<>(apps.size());
        $jacocoInit[65] = true;
        $jacocoInit[66] = true;
        for (App app : apps) {
            $jacocoInit[67] = true;
            displayables.add(new OtherVersionDisplayable(app, StoreContext.home));
            $jacocoInit[68] = true;
        }
        addDisplayables(displayables);
        $jacocoInit[69] = true;
        getRecyclerView().setVisibility(0);
        $jacocoInit[70] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m6960a(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        err.printStackTrace();
        $jacocoInit[63] = true;
    }

    /* access modifiers changed from: protected */
    public void setHeader() {
        boolean[] $jacocoInit = $jacocoInit();
        ViewHeader viewHeader = this.header;
        if (viewHeader == null) {
            $jacocoInit[47] = true;
        } else {
            $jacocoInit[48] = true;
            ViewHeader.access$000(viewHeader, this.appImgUrl);
            $jacocoInit[49] = true;
            setTitle(this.appName);
            $jacocoInit[50] = true;
        }
        $jacocoInit[51] = true;
    }

    private void setTitle(String title) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!hasToolbar()) {
            $jacocoInit[52] = true;
        } else {
            $jacocoInit[53] = true;
            getToolbar().setTitle((CharSequence) title);
            $jacocoInit[54] = true;
            this.collapsingToolbarLayout.setTitle(title);
            $jacocoInit[55] = true;
        }
        $jacocoInit[56] = true;
    }

    /* access modifiers changed from: protected */
    public boolean displayHomeUpAsEnabled() {
        $jacocoInit()[57] = true;
        return true;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreateOptionsMenu(menu, inflater);
        $jacocoInit[58] = true;
        inflater.inflate(C1375R.C1377menu.menu_empty, menu);
        $jacocoInit[59] = true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        boolean[] $jacocoInit = $jacocoInit();
        if (item.getItemId() == 16908332) {
            $jacocoInit[60] = true;
            getActivity().onBackPressed();
            $jacocoInit[61] = true;
            return true;
        }
        boolean onOptionsItemSelected = super.onOptionsItemSelected(item);
        $jacocoInit[62] = true;
        return onOptionsItemSelected;
    }
}
