package p005cm.aptoide.p006pt.view.recycler.displayable;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Pair;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.MyStoreManager;
import p005cm.aptoide.p006pt.account.view.LoginDisplayable;
import p005cm.aptoide.p006pt.account.view.user.CreateStoreDisplayable;
import p005cm.aptoide.p006pt.ads.MinimalAdMapper;
import p005cm.aptoide.p006pt.app.view.GridAppDisplayable;
import p005cm.aptoide.p006pt.app.view.GridAppListDisplayable;
import p005cm.aptoide.p006pt.app.view.OfficialAppDisplayable;
import p005cm.aptoide.p006pt.database.AccessorFactory;
import p005cm.aptoide.p006pt.database.accessors.StoreAccessor;
import p005cm.aptoide.p006pt.database.realm.Store;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p007v2.GetAdsResponse;
import p005cm.aptoide.p006pt.dataprovider.model.p007v2.GetAdsResponse.C2842Ad;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.DataList;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Event;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Event.Name;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetAppMeta;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetStoreWidgets.WSWidget;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetStoreWidgets.WSWidget.Action;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetStoreWidgets.WSWidget.Data;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Layout;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.ListApps;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.ListComments;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.TimelineStats;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.TimelineStats.StatusData;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Type;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.listapp.App;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.GetHomeMeta;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.GetStoreDisplays;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.GetStoreDisplays.EventImage;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.GetStoreMeta;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.ListStores;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store.Appearance;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store.Stats;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseRequestWithStore.StoreCredentials;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.MyStore;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.StoreContext;
import p005cm.aptoide.p006pt.install.InstalledRepository;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.repository.StoreRepository;
import p005cm.aptoide.p006pt.store.StoreAnalytics;
import p005cm.aptoide.p006pt.store.StoreCredentialsProviderImpl;
import p005cm.aptoide.p006pt.store.StoreTheme;
import p005cm.aptoide.p006pt.store.StoreUtilsProxy;
import p005cm.aptoide.p006pt.store.view.BadgeDialogFactory;
import p005cm.aptoide.p006pt.store.view.GridDisplayDisplayable;
import p005cm.aptoide.p006pt.store.view.GridStoreDisplayable;
import p005cm.aptoide.p006pt.store.view.GridStoreMetaDisplayable;
import p005cm.aptoide.p006pt.store.view.StoreAddCommentDisplayable;
import p005cm.aptoide.p006pt.store.view.StoreGridHeaderDisplayable;
import p005cm.aptoide.p006pt.store.view.StoreGridHeaderDisplayable.Model;
import p005cm.aptoide.p006pt.store.view.StoreLatestCommentsDisplayable;
import p005cm.aptoide.p006pt.store.view.StoreTabNavigator;
import p005cm.aptoide.p006pt.store.view.featured.AppBrickDisplayable;
import p005cm.aptoide.p006pt.store.view.p079my.StoreDisplayable;
import p005cm.aptoide.p006pt.store.view.recommended.RecommendedStoreDisplayable;
import p026rx.C0120S;
import p026rx.p027b.C0132p;
import p026rx.schedulers.Schedulers;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.view.recycler.displayable.DisplayablesFactory */
public class DisplayablesFactory {
    private static transient /* synthetic */ boolean[] $jacocoData;

    /* renamed from: cm.aptoide.pt.view.recycler.displayable.DisplayablesFactory$1 */
    static /* synthetic */ class C53641 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type = new int[Type.values().length];
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(-530987862785637692L, "cm/aptoide/pt/view/recycler/displayable/DisplayablesFactory$1", 24);
            $jacocoData = probes;
            return probes;
        }

        static {
            boolean[] $jacocoInit = $jacocoInit();
            try {
                $jacocoInit[0] = true;
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.APPS_GROUP.ordinal()] = 1;
                $jacocoInit[1] = true;
            } catch (NoSuchFieldError e) {
                try {
                    $jacocoInit[2] = true;
                } catch (NoSuchFieldError e2) {
                    try {
                        $jacocoInit[4] = true;
                    } catch (NoSuchFieldError e3) {
                        try {
                            $jacocoInit[6] = true;
                        } catch (NoSuchFieldError e4) {
                            try {
                                $jacocoInit[8] = true;
                            } catch (NoSuchFieldError e5) {
                                try {
                                    $jacocoInit[10] = true;
                                } catch (NoSuchFieldError e6) {
                                    try {
                                        $jacocoInit[12] = true;
                                    } catch (NoSuchFieldError e7) {
                                        try {
                                            $jacocoInit[14] = true;
                                        } catch (NoSuchFieldError e8) {
                                            try {
                                                $jacocoInit[16] = true;
                                            } catch (NoSuchFieldError e9) {
                                                try {
                                                    $jacocoInit[18] = true;
                                                } catch (NoSuchFieldError e10) {
                                                    try {
                                                        $jacocoInit[20] = true;
                                                    } catch (NoSuchFieldError e11) {
                                                        $jacocoInit[22] = true;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.MY_STORES_SUBSCRIBED.ordinal()] = 2;
            $jacocoInit[3] = true;
            $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.STORES_GROUP.ordinal()] = 3;
            $jacocoInit[5] = true;
            $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.DISPLAYS.ordinal()] = 4;
            $jacocoInit[7] = true;
            $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.ADS.ordinal()] = 5;
            $jacocoInit[9] = true;
            $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.HOME_META.ordinal()] = 6;
            $jacocoInit[11] = true;
            $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.MY_STORE_META.ordinal()] = 7;
            $jacocoInit[13] = true;
            $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.STORE_META.ordinal()] = 8;
            $jacocoInit[15] = true;
            $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.STORES_RECOMMENDED.ordinal()] = 9;
            $jacocoInit[17] = true;
            $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.COMMENTS_GROUP.ordinal()] = 10;
            $jacocoInit[19] = true;
            $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.APP_META.ordinal()] = 11;
            $jacocoInit[21] = true;
            $jacocoInit[23] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6157019599723177263L, "cm/aptoide/pt/view/recycler/displayable/DisplayablesFactory", 279);
        $jacocoData = probes;
        return probes;
    }

    public DisplayablesFactory() {
        $jacocoInit()[0] = true;
    }

    public static C0120S<Displayable> parse(String marketName, WSWidget widget, String storeTheme, StoreRepository storeRepository, StoreContext storeContext, Context context, AptoideAccountManager accountManager, StoreUtilsProxy storeUtilsProxy, WindowManager windowManager, Resources resources, InstalledRepository installedRepository, StoreAnalytics storeAnalytics, StoreTabNavigator storeTabNavigator, NavigationTracker navigationTracker, BadgeDialogFactory badgeDialogFactory, FragmentNavigator fragmentNavigator, StoreAccessor storeAccessor, BodyInterceptor<BaseBody> bodyInterceptorV7, OkHttpClient client, Factory converter, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        WSWidget wSWidget = widget;
        StoreContext storeContext2 = storeContext;
        boolean[] $jacocoInit = $jacocoInit();
        List<Displayable> linkedList = new LinkedList<>();
        $jacocoInit[1] = true;
        List<Displayable> list = linkedList;
        if (widget.getType() == null) {
            $jacocoInit[2] = true;
        } else if (widget.getViewObject() == null) {
            $jacocoInit[3] = true;
        } else {
            $jacocoInit[4] = true;
            switch (C53641.$SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[widget.getType().ordinal()]) {
                case 1:
                    LinkedList linkedList2 = list;
                    Context context2 = context;
                    $jacocoInit[6] = true;
                    Context applicationContext = context.getApplicationContext();
                    $jacocoInit[7] = true;
                    Resources resources2 = applicationContext.getResources();
                    $jacocoInit[8] = true;
                    C0120S<Displayable> c = C0120S.m652c(getApps(marketName, widget, storeTheme, storeContext, resources2, windowManager, storeTabNavigator, navigationTracker));
                    $jacocoInit[9] = true;
                    return c;
                case 2:
                    AptoideAccountManager aptoideAccountManager = accountManager;
                    LinkedList linkedList3 = list;
                    Context context3 = context;
                    C0120S<Displayable> myStores = getMyStores(marketName, widget, storeRepository, storeTheme, storeContext, windowManager, resources, context, storeAnalytics, storeTabNavigator, navigationTracker);
                    $jacocoInit[10] = true;
                    return myStores;
                case 3:
                    AptoideAccountManager aptoideAccountManager2 = accountManager;
                    StoreAnalytics storeAnalytics2 = storeAnalytics;
                    NavigationTracker navigationTracker2 = navigationTracker;
                    LinkedList linkedList4 = list;
                    Context context4 = context;
                    $jacocoInit[11] = true;
                    LinkedList linkedList5 = linkedList4;
                    Displayable stores = getStores(marketName, widget, storeTheme, storeContext, windowManager, resources, context, storeAnalytics, storeTabNavigator, navigationTracker);
                    $jacocoInit[12] = true;
                    C0120S<Displayable> c2 = C0120S.m652c(stores);
                    $jacocoInit[13] = true;
                    return c2;
                case 4:
                    AptoideAccountManager aptoideAccountManager3 = accountManager;
                    StoreAnalytics storeAnalytics3 = storeAnalytics;
                    NavigationTracker navigationTracker3 = navigationTracker;
                    LinkedList linkedList6 = list;
                    Context context5 = context;
                    $jacocoInit[14] = true;
                    Displayable displays = getDisplays(widget, storeTheme, storeContext, windowManager, resources, installedRepository);
                    $jacocoInit[15] = true;
                    C0120S<Displayable> c3 = C0120S.m652c(displays);
                    $jacocoInit[16] = true;
                    return c3;
                case 5:
                    AptoideAccountManager aptoideAccountManager4 = accountManager;
                    StoreAnalytics storeAnalytics4 = storeAnalytics;
                    List<Displayable> list2 = list;
                    Context context6 = context;
                    List<Displayable> adsList = getAds(wSWidget, new MinimalAdMapper(), navigationTracker);
                    $jacocoInit[17] = true;
                    if (adsList.size() > 0) {
                        $jacocoInit[18] = true;
                        DisplayableGroup displayableGroup = new DisplayableGroup(adsList, windowManager, resources);
                        $jacocoInit[19] = true;
                        DisplayableGroup ads = displayableGroup;
                        LinkedList linkedList7 = new LinkedList();
                        $jacocoInit[20] = true;
                        LinkedList linkedList8 = linkedList7;
                        Action action = new Action();
                        Event event = new Event();
                        Name name = Name.getAds;
                        $jacocoInit[21] = true;
                        Event name2 = event.setName(name);
                        $jacocoInit[22] = true;
                        linkedList8.add(action.setEvent(name2));
                        $jacocoInit[23] = true;
                        wSWidget.setActions(linkedList8);
                        $jacocoInit[24] = true;
                        LinkedList linkedList9 = linkedList8;
                        DisplayableGroup ads2 = ads;
                        List list3 = adsList;
                        StoreGridHeaderDisplayable storeGridHeaderDisplayable = new StoreGridHeaderDisplayable(marketName, widget, null, widget.getTag(), StoreContext.meta, storeTabNavigator, navigationTracker);
                        $jacocoInit[25] = true;
                        LinkedList linkedList10 = list2;
                        linkedList10.add(storeGridHeaderDisplayable);
                        $jacocoInit[26] = true;
                        linkedList10.add(ads2);
                        $jacocoInit[27] = true;
                        C0120S<Displayable> a = C0120S.m629a((Iterable<? extends T>) linkedList10);
                        $jacocoInit[28] = true;
                        return a;
                    }
                    List<Displayable> adsList2 = list2;
                    C0120S<Displayable> c4 = C0120S.m651c();
                    $jacocoInit[29] = true;
                    return c4;
                case 6:
                    AptoideAccountManager aptoideAccountManager5 = accountManager;
                    StoreAnalytics storeAnalytics5 = storeAnalytics;
                    LinkedList linkedList11 = list;
                    Context context7 = context;
                    GetHomeMeta getHomeMeta = (GetHomeMeta) widget.getViewObject();
                    $jacocoInit[30] = true;
                    Context applicationContext2 = context.getApplicationContext();
                    $jacocoInit[31] = true;
                    $jacocoInit[32] = true;
                    GridStoreMetaDisplayable gridStoreMetaDisplayable = new GridStoreMetaDisplayable(getHomeMeta, new StoreCredentialsProviderImpl((StoreAccessor) AccessorFactory.getAccessorFor(((AptoideApplication) applicationContext2.getApplicationContext()).getDatabase(), Store.class)), storeAnalytics, badgeDialogFactory, fragmentNavigator, storeAccessor, bodyInterceptorV7, client, converter, tokenInvalidator, sharedPreferences);
                    $jacocoInit[33] = true;
                    C0120S<Displayable> c5 = C0120S.m652c(gridStoreMetaDisplayable);
                    $jacocoInit[34] = true;
                    return c5;
                case 7:
                    LinkedList linkedList12 = list;
                    $jacocoInit[35] = true;
                    StoreAnalytics storeAnalytics6 = storeAnalytics;
                    List createMyStoreDisplayables = createMyStoreDisplayables(widget.getViewObject(), storeAnalytics6, storeContext2, accountManager, context);
                    $jacocoInit[36] = true;
                    C0120S<Displayable> a2 = C0120S.m629a((Iterable<? extends T>) createMyStoreDisplayables);
                    $jacocoInit[37] = true;
                    return a2;
                case 8:
                    LinkedList linkedList13 = list;
                    C0120S<Displayable> a3 = C0120S.m629a((Iterable<? extends T>) createStoreDisplayables(widget.getViewObject(), storeContext2));
                    $jacocoInit[38] = true;
                    return a3;
                case 9:
                    $jacocoInit[39] = true;
                    LinkedList linkedList14 = list;
                    Displayable createRecommendedStores = createRecommendedStores(marketName, widget, storeTheme, storeRepository, storeContext, context, accountManager, storeUtilsProxy, windowManager, resources, storeTabNavigator, navigationTracker);
                    $jacocoInit[40] = true;
                    C0120S<Displayable> c6 = C0120S.m652c(createRecommendedStores);
                    $jacocoInit[41] = true;
                    return c6;
                case 10:
                    $jacocoInit[42] = true;
                    List createCommentsGroup = createCommentsGroup(marketName, widget, storeTheme, widget.getTag(), storeContext, storeTabNavigator, navigationTracker);
                    $jacocoInit[43] = true;
                    C0120S<Displayable> a4 = C0120S.m629a((Iterable<? extends T>) createCommentsGroup);
                    $jacocoInit[44] = true;
                    return a4;
                case 11:
                    Data dataObj = widget.getData();
                    $jacocoInit[45] = true;
                    String message = dataObj.getMessage();
                    $jacocoInit[46] = true;
                    Pair pair = new Pair(message, (GetAppMeta) widget.getViewObject());
                    $jacocoInit[47] = true;
                    OfficialAppDisplayable officialAppDisplayable = new OfficialAppDisplayable(pair, StoreTheme.get(storeTheme));
                    $jacocoInit[48] = true;
                    C0120S<Displayable> c7 = C0120S.m652c(officialAppDisplayable);
                    $jacocoInit[49] = true;
                    return c7;
                default:
                    LinkedList linkedList15 = list;
                    Context context8 = context;
                    $jacocoInit[5] = true;
                    break;
            }
            C0120S<Displayable> c8 = C0120S.m651c();
            $jacocoInit[50] = true;
            return c8;
        }
        LinkedList linkedList16 = list;
        Context context9 = context;
        C0120S<Displayable> c82 = C0120S.m651c();
        $jacocoInit[50] = true;
        return c82;
    }

    private static Displayable getApps(String marketName, WSWidget wsWidget, String storeTheme, StoreContext storeContext, Resources resources, WindowManager windowManager, StoreTabNavigator storeTabNavigator, NavigationTracker navigationTracker) {
        Resources resources2 = resources;
        NavigationTracker navigationTracker2 = navigationTracker;
        boolean[] $jacocoInit = $jacocoInit();
        ListApps listApps = (ListApps) wsWidget.getViewObject();
        if (listApps == null) {
            $jacocoInit[51] = true;
            EmptyDisplayable emptyDisplayable = new EmptyDisplayable();
            $jacocoInit[52] = true;
            return emptyDisplayable;
        }
        DataList dataList = listApps.getDataList();
        $jacocoInit[53] = true;
        List<App> apps = dataList.getList();
        $jacocoInit[54] = true;
        List<Displayable> arrayList = new ArrayList<>(apps.size());
        $jacocoInit[55] = true;
        List<Displayable> displayables = arrayList;
        $jacocoInit[56] = true;
        for (App app : apps) {
            $jacocoInit[57] = true;
            p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store store = app.getStore();
            Appearance appearance = new Appearance(storeTheme, null);
            $jacocoInit[58] = true;
            store.setAppearance(appearance);
            $jacocoInit[59] = true;
        }
        String str = storeTheme;
        Layout layout = Layout.BRICK;
        Data data = wsWidget.getData();
        $jacocoInit[60] = true;
        Layout layout2 = data.getLayout();
        $jacocoInit[61] = true;
        if (layout.equals(layout2)) {
            $jacocoInit[62] = true;
            if (apps.size() <= 0) {
                $jacocoInit[63] = true;
            } else {
                $jacocoInit[64] = true;
                boolean useBigBrick = resources2.getBoolean(C1375R.bool.use_big_app_brick);
                $jacocoInit[65] = true;
                int nrAppBricks = resources2.getInteger(C1375R.integer.nr_small_app_bricks);
                $jacocoInit[66] = true;
                int nrAppBricks2 = Math.min(nrAppBricks, apps.size());
                $jacocoInit[67] = true;
                if (apps.size() == 1) {
                    useBigBrick = true;
                    $jacocoInit[68] = true;
                } else if (apps.size() != 2) {
                    $jacocoInit[69] = true;
                } else {
                    useBigBrick = false;
                    $jacocoInit[70] = true;
                }
                int i = 0;
                if (!useBigBrick) {
                    $jacocoInit[71] = true;
                } else {
                    $jacocoInit[72] = true;
                    AppBrickDisplayable appBrickDisplayable = new AppBrickDisplayable((App) apps.get(0), wsWidget.getTag(), navigationTracker2);
                    $jacocoInit[73] = true;
                    Displayable fullRow = appBrickDisplayable.setFullRow();
                    $jacocoInit[74] = true;
                    displayables.add(fullRow);
                    nrAppBricks2++;
                    $jacocoInit[75] = true;
                }
                if (apps.size() <= 1) {
                    $jacocoInit[76] = true;
                } else {
                    if (useBigBrick) {
                        $jacocoInit[77] = true;
                        i = 1;
                    } else {
                        $jacocoInit[78] = true;
                    }
                    $jacocoInit[79] = true;
                    while (i < nrAppBricks2) {
                        $jacocoInit[81] = true;
                        Displayable appDisplayablePojo = new AppBrickDisplayable((App) apps.get(i), wsWidget.getTag(), navigationTracker2);
                        $jacocoInit[82] = true;
                        displayables.add(appDisplayablePojo);
                        i++;
                        $jacocoInit[83] = true;
                    }
                    $jacocoInit[80] = true;
                }
                $jacocoInit[84] = true;
            }
        } else {
            Layout layout3 = Layout.LIST;
            Data data2 = wsWidget.getData();
            $jacocoInit[85] = true;
            Layout layout4 = data2.getLayout();
            $jacocoInit[86] = true;
            if (layout3.equals(layout4)) {
                $jacocoInit[87] = true;
                if (apps.size() <= 0) {
                    $jacocoInit[88] = true;
                    String str2 = marketName;
                    WSWidget wSWidget = wsWidget;
                    StoreTabNavigator storeTabNavigator2 = storeTabNavigator;
                } else {
                    $jacocoInit[89] = true;
                    displayables.add(new StoreGridHeaderDisplayable(marketName, wsWidget, storeTabNavigator, navigationTracker2));
                    $jacocoInit[90] = true;
                }
                $jacocoInit[91] = true;
                for (App app2 : apps) {
                    $jacocoInit[92] = true;
                    displayables.add(new GridAppListDisplayable(app2, wsWidget.getTag()));
                    $jacocoInit[93] = true;
                }
                $jacocoInit[94] = true;
            } else {
                String str3 = marketName;
                WSWidget wSWidget2 = wsWidget;
                StoreTabNavigator storeTabNavigator3 = storeTabNavigator;
                if (apps.size() <= 0) {
                    $jacocoInit[95] = true;
                } else {
                    $jacocoInit[96] = true;
                    StoreGridHeaderDisplayable storeGridHeaderDisplayable = r1;
                    StoreGridHeaderDisplayable storeGridHeaderDisplayable2 = new StoreGridHeaderDisplayable(marketName, wsWidget, storeTheme, wsWidget.getTag(), storeContext, storeTabNavigator, navigationTracker);
                    $jacocoInit[97] = true;
                    displayables.add(storeGridHeaderDisplayable);
                    $jacocoInit[98] = true;
                }
                $jacocoInit[99] = true;
                for (App app3 : apps) {
                    WindowManager windowManager2 = windowManager;
                    $jacocoInit[101] = true;
                    DisplayablePojo<App> diplayable = new GridAppDisplayable<>(app3, wsWidget.getTag(), navigationTracker2, storeContext);
                    $jacocoInit[102] = true;
                    displayables.add(diplayable);
                    $jacocoInit[103] = true;
                }
                $jacocoInit[100] = true;
            }
        }
        DisplayableGroup displayableGroup = new DisplayableGroup(displayables, windowManager, resources2);
        $jacocoInit[104] = true;
        return displayableGroup;
    }

    private static C0120S<Displayable> getMyStores(String marketName, WSWidget wsWidget, StoreRepository storeRepository, String storeTheme, StoreContext storeContext, WindowManager windowManager, Resources resources, Context context, StoreAnalytics storeAnalytics, StoreTabNavigator storeTabNavigator, NavigationTracker navigationTracker) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S loadLocalSubscribedStores = loadLocalSubscribedStores(storeRepository);
        C5365a aVar = new C5365a(wsWidget, storeAnalytics, marketName, storeTheme, storeContext, storeTabNavigator, navigationTracker, windowManager, resources);
        C0120S<Displayable> j = loadLocalSubscribedStores.mo3669j(aVar);
        $jacocoInit[105] = true;
        return j;
    }

    /* renamed from: a */
    static /* synthetic */ Displayable m9634a(WSWidget wsWidget, StoreAnalytics storeAnalytics, String marketName, String storeTheme, StoreContext storeContext, StoreTabNavigator storeTabNavigator, NavigationTracker navigationTracker, WindowManager windowManager, Resources resources, List stores) {
        int i;
        List list = stores;
        boolean[] $jacocoInit = $jacocoInit();
        List<Displayable> tmp = new ArrayList<>(stores.size());
        $jacocoInit[238] = true;
        int maxStoresToShow = stores.size();
        $jacocoInit[239] = true;
        if (!(wsWidget.getViewObject() instanceof ListStores)) {
            $jacocoInit[240] = true;
        } else {
            $jacocoInit[241] = true;
            ListStores listStores = (ListStores) wsWidget.getViewObject();
            $jacocoInit[242] = true;
            DataList dataList = listStores.getDataList();
            $jacocoInit[243] = true;
            List list2 = dataList.getList();
            $jacocoInit[244] = true;
            list.addAll(list2);
            $jacocoInit[245] = true;
            DataList dataList2 = listStores.getDataList();
            $jacocoInit[246] = true;
            Integer limit = dataList2.getLimit();
            $jacocoInit[247] = true;
            int intValue = limit.intValue();
            $jacocoInit[248] = true;
            if (intValue > stores.size()) {
                i = stores.size();
                $jacocoInit[249] = true;
            } else {
                DataList dataList3 = listStores.getDataList();
                $jacocoInit[250] = true;
                Integer limit2 = dataList3.getLimit();
                $jacocoInit[251] = true;
                i = limit2.intValue();
                $jacocoInit[252] = true;
            }
            maxStoresToShow = i;
            $jacocoInit[253] = true;
        }
        Collections.sort(list, C5366b.f9178a);
        $jacocoInit[254] = true;
        int i2 = 0;
        $jacocoInit[255] = true;
        while (true) {
            if (i2 >= stores.size()) {
                $jacocoInit[256] = true;
                break;
            } else if (tmp.size() >= maxStoresToShow) {
                $jacocoInit[257] = true;
                break;
            } else {
                WindowManager windowManager2 = windowManager;
                Resources resources2 = resources;
                if (i2 == 0) {
                    $jacocoInit[258] = true;
                } else {
                    int i3 = i2 - 1;
                    $jacocoInit[259] = true;
                    p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store store = (p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store) list.get(i3);
                    $jacocoInit[260] = true;
                    long id = store.getId();
                    p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store store2 = (p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store) list.get(i2);
                    $jacocoInit[261] = true;
                    if (id == store2.getId()) {
                        $jacocoInit[262] = true;
                        StoreAnalytics storeAnalytics2 = storeAnalytics;
                        i2++;
                        $jacocoInit[267] = true;
                    } else {
                        $jacocoInit[263] = true;
                    }
                }
                $jacocoInit[264] = true;
                StoreAnalytics storeAnalytics3 = storeAnalytics;
                GridStoreDisplayable diplayable = new GridStoreDisplayable((p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store) list.get(i2), "Open a Followed Store", storeAnalytics);
                $jacocoInit[265] = true;
                tmp.add(diplayable);
                $jacocoInit[266] = true;
                i2++;
                $jacocoInit[267] = true;
            }
        }
        if (tmp.size() <= 0) {
            $jacocoInit[268] = true;
        } else {
            $jacocoInit[269] = true;
            StoreGridHeaderDisplayable storeGridHeaderDisplayable = new StoreGridHeaderDisplayable(marketName, wsWidget, storeTheme, wsWidget.getTag(), storeContext, storeTabNavigator, navigationTracker);
            $jacocoInit[270] = true;
            if (stores.size() > maxStoresToShow) {
                $jacocoInit[271] = true;
            } else {
                $jacocoInit[272] = true;
                Model model = storeGridHeaderDisplayable.getModel();
                $jacocoInit[273] = true;
                model.setMoreVisible(false);
                $jacocoInit[274] = true;
            }
            tmp.add(0, storeGridHeaderDisplayable);
            $jacocoInit[275] = true;
        }
        DisplayableGroup displayableGroup = new DisplayableGroup(tmp, windowManager, resources);
        $jacocoInit[276] = true;
        return displayableGroup;
    }

    /* renamed from: a */
    static /* synthetic */ int m9632a(p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store store, p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store t1) {
        boolean[] $jacocoInit = $jacocoInit();
        String name = store.getName();
        $jacocoInit[277] = true;
        int compareTo = name.compareTo(t1.getName());
        $jacocoInit[278] = true;
        return compareTo;
    }

    private static Displayable getStores(String marketName, WSWidget wsWidget, String storeTheme, StoreContext storeContext, WindowManager windowManager, Resources resources, Context context, StoreAnalytics storeAnalytics, StoreTabNavigator storeTabNavigator, NavigationTracker navigationTracker) {
        boolean[] $jacocoInit = $jacocoInit();
        ListStores listStores = (ListStores) wsWidget.getViewObject();
        if (listStores == null) {
            $jacocoInit[106] = true;
            EmptyDisplayable emptyDisplayable = new EmptyDisplayable();
            $jacocoInit[107] = true;
            return emptyDisplayable;
        }
        DataList dataList = listStores.getDataList();
        $jacocoInit[108] = true;
        List<p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store> stores = dataList.getList();
        $jacocoInit[109] = true;
        List<Displayable> tmp = new ArrayList<>(stores.size());
        $jacocoInit[110] = true;
        StoreGridHeaderDisplayable storeGridHeaderDisplayable = new StoreGridHeaderDisplayable(marketName, wsWidget, storeTheme, wsWidget.getTag(), storeContext, storeTabNavigator, navigationTracker);
        tmp.add(storeGridHeaderDisplayable);
        $jacocoInit[111] = true;
        $jacocoInit[112] = true;
        for (p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store store : stores) {
            $jacocoInit[113] = true;
            GridStoreDisplayable diplayable = new GridStoreDisplayable(store, "Home", storeAnalytics);
            $jacocoInit[114] = true;
            tmp.add(diplayable);
            $jacocoInit[115] = true;
        }
        StoreAnalytics storeAnalytics2 = storeAnalytics;
        DisplayableGroup displayableGroup = new DisplayableGroup(tmp, windowManager, resources);
        $jacocoInit[116] = true;
        return displayableGroup;
    }

    private static Displayable getDisplays(WSWidget wsWidget, String storeTheme, StoreContext storeContext, WindowManager windowManager, Resources resources, InstalledRepository installedRepository) {
        boolean[] $jacocoInit = $jacocoInit();
        GetStoreDisplays getStoreDisplays = (GetStoreDisplays) wsWidget.getViewObject();
        if (getStoreDisplays == null) {
            $jacocoInit[117] = true;
            EmptyDisplayable emptyDisplayable = new EmptyDisplayable();
            $jacocoInit[118] = true;
            return emptyDisplayable;
        }
        List<EventImage> getStoreDisplaysList = getStoreDisplays.getList();
        $jacocoInit[119] = true;
        List<Displayable> tmp = new ArrayList<>(getStoreDisplaysList.size());
        $jacocoInit[120] = true;
        $jacocoInit[121] = true;
        for (EventImage eventImage : getStoreDisplaysList) {
            $jacocoInit[122] = true;
            GridDisplayDisplayable gridDisplayDisplayable = new GridDisplayDisplayable(eventImage, storeTheme, wsWidget.getTag(), storeContext, installedRepository);
            $jacocoInit[123] = true;
            GridDisplayDisplayable gridDisplayDisplayable2 = gridDisplayDisplayable;
            EventImage eventImage2 = (EventImage) gridDisplayDisplayable2.getPojo();
            $jacocoInit[124] = true;
            Event event = eventImage2.getEvent();
            $jacocoInit[125] = true;
            Name name = event.getName();
            $jacocoInit[126] = true;
            if (Name.facebook.equals(name)) {
                $jacocoInit[127] = true;
            } else {
                Name name2 = Name.twitch;
                $jacocoInit[128] = true;
                if (name2.equals(name)) {
                    $jacocoInit[129] = true;
                } else {
                    Name name3 = Name.youtube;
                    $jacocoInit[130] = true;
                    if (!name3.equals(name)) {
                        $jacocoInit[131] = true;
                        tmp.add(gridDisplayDisplayable2);
                        $jacocoInit[134] = true;
                    } else {
                        $jacocoInit[132] = true;
                    }
                }
            }
            gridDisplayDisplayable2.setFullRow();
            $jacocoInit[133] = true;
            tmp.add(gridDisplayDisplayable2);
            $jacocoInit[134] = true;
        }
        DisplayableGroup displayableGroup = new DisplayableGroup(tmp, windowManager, resources);
        $jacocoInit[135] = true;
        return displayableGroup;
    }

    private static List<Displayable> getAds(WSWidget wsWidget, MinimalAdMapper adMapper, NavigationTracker navigationTracker) {
        boolean[] $jacocoInit = $jacocoInit();
        GetAdsResponse getAdsResponse = (GetAdsResponse) wsWidget.getViewObject();
        if (getAdsResponse == null) {
            $jacocoInit[136] = true;
        } else {
            $jacocoInit[137] = true;
            if (getAdsResponse.getAds() == null) {
                $jacocoInit[138] = true;
            } else {
                $jacocoInit[139] = true;
                List ads = getAdsResponse.getAds();
                $jacocoInit[140] = true;
                if (ads.size() <= 0) {
                    $jacocoInit[141] = true;
                } else {
                    $jacocoInit[142] = true;
                    List<C2842Ad> ads2 = getAdsResponse.getAds();
                    $jacocoInit[143] = true;
                    List<Displayable> tmp = new ArrayList<>(ads2.size());
                    $jacocoInit[144] = true;
                    $jacocoInit[145] = true;
                    for (C2842Ad ad : ads2) {
                        $jacocoInit[146] = true;
                        GridAdDisplayable diplayable = new GridAdDisplayable(adMapper.map(ad), wsWidget.getTag(), navigationTracker);
                        $jacocoInit[147] = true;
                        tmp.add(diplayable);
                        $jacocoInit[148] = true;
                    }
                    $jacocoInit[149] = true;
                    return tmp;
                }
            }
        }
        List<Displayable> emptyList = Collections.emptyList();
        $jacocoInit[150] = true;
        return emptyList;
    }

    private static List<Displayable> createMyStoreDisplayables(Object viewObject, StoreAnalytics storeAnalytics, StoreContext storeContext, AptoideAccountManager accountManager, Context context) {
        Object obj = viewObject;
        boolean[] $jacocoInit = $jacocoInit();
        LinkedList<Displayable> displayables = new LinkedList<>();
        if (!(obj instanceof MyStore)) {
            $jacocoInit[151] = true;
            StoreAnalytics storeAnalytics2 = storeAnalytics;
        } else {
            MyStore store = (MyStore) obj;
            $jacocoInit[152] = true;
            if (!store.isCreateStore()) {
                $jacocoInit[153] = true;
                TimelineStats timelineStats = store.getTimelineStats();
                $jacocoInit[154] = true;
                StatusData followerStats = timelineStats.getData();
                $jacocoInit[155] = true;
                GetHomeMeta getHomeMeta = store.getGetHomeMeta();
                $jacocoInit[156] = true;
                GetHomeMeta.Data data = getHomeMeta.getData();
                $jacocoInit[157] = true;
                p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store store2 = data.getStore();
                long following = followerStats.getFollowing();
                long followers = followerStats.getFollowers();
                $jacocoInit[158] = true;
                GetHomeMeta getHomeMeta2 = store.getGetHomeMeta();
                $jacocoInit[159] = true;
                GetHomeMeta.Data data2 = getHomeMeta2.getData();
                $jacocoInit[160] = true;
                p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store store3 = data2.getStore();
                $jacocoInit[161] = true;
                StoreDisplayable storeDisplayable = new StoreDisplayable(store2, storeContext, following, followers, C1375R.string.storetab_short_followings, C1375R.string.storetab_short_followers, true, getStoreDescriptionMessage(context, store3));
                $jacocoInit[162] = true;
                displayables.add(storeDisplayable);
                $jacocoInit[163] = true;
                $jacocoInit[164] = true;
                StoreAnalytics storeAnalytics3 = storeAnalytics;
            } else if (accountManager.isLoggedIn()) {
                $jacocoInit[165] = true;
                if (!MyStoreManager.shouldShowCreateStore()) {
                    $jacocoInit[166] = true;
                    StoreAnalytics storeAnalytics4 = storeAnalytics;
                } else {
                    $jacocoInit[167] = true;
                    displayables.add(new CreateStoreDisplayable(storeAnalytics, store.getTimelineStats()));
                    $jacocoInit[168] = true;
                }
            } else {
                StoreAnalytics storeAnalytics5 = storeAnalytics;
                displayables.add(new LoginDisplayable());
                $jacocoInit[169] = true;
            }
        }
        $jacocoInit[170] = true;
        return displayables;
    }

    private static String getStoreDescriptionMessage(Context context, p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store store) {
        String message;
        boolean[] $jacocoInit = $jacocoInit();
        Appearance appearance = store.getAppearance();
        $jacocoInit[171] = true;
        String description = appearance.getDescription();
        $jacocoInit[172] = true;
        if (TextUtils.isEmpty(description)) {
            $jacocoInit[173] = true;
            message = context.getString(C1375R.string.create_store_displayable_empty_description_message);
            $jacocoInit[174] = true;
        } else {
            Appearance appearance2 = store.getAppearance();
            $jacocoInit[175] = true;
            message = appearance2.getDescription();
            $jacocoInit[176] = true;
        }
        $jacocoInit[177] = true;
        return message;
    }

    private static List<Displayable> createStoreDisplayables(Object viewObject, StoreContext storeContext) {
        Object obj = viewObject;
        boolean[] $jacocoInit = $jacocoInit();
        ArrayList<Displayable> displayables = new ArrayList<>();
        if (!(obj instanceof GetStoreMeta)) {
            $jacocoInit[178] = true;
        } else {
            $jacocoInit[179] = true;
            p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store store = ((GetStoreMeta) obj).getData();
            $jacocoInit[180] = true;
            Stats stats = store.getStats();
            $jacocoInit[181] = true;
            long apps = (long) stats.getApps();
            Stats stats2 = store.getStats();
            $jacocoInit[182] = true;
            long downloads = stats2.getDownloads();
            $jacocoInit[183] = true;
            Appearance appearance = store.getAppearance();
            $jacocoInit[184] = true;
            StoreDisplayable storeDisplayable = r5;
            StoreDisplayable storeDisplayable2 = new StoreDisplayable(store, storeContext, apps, downloads, C1375R.string.storehometab_short_apps, C1375R.string.storehometab_short_downloads, false, appearance.getDescription());
            $jacocoInit[185] = true;
            displayables.add(storeDisplayable);
            $jacocoInit[186] = true;
        }
        $jacocoInit[187] = true;
        return displayables;
    }

    private static Displayable createRecommendedStores(String marketName, WSWidget wsWidget, String storeTheme, StoreRepository storeRepository, StoreContext storeContext, Context context, AptoideAccountManager accountManager, StoreUtilsProxy storeUtilsProxy, WindowManager windowManager, Resources resources, StoreTabNavigator storeTabNavigator, NavigationTracker navigationTracker) {
        boolean[] $jacocoInit = $jacocoInit();
        ListStores listStores = (ListStores) wsWidget.getViewObject();
        if (listStores == null) {
            $jacocoInit[188] = true;
            EmptyDisplayable emptyDisplayable = new EmptyDisplayable();
            $jacocoInit[189] = true;
            return emptyDisplayable;
        }
        DataList dataList = listStores.getDataList();
        $jacocoInit[190] = true;
        List<p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store> stores = dataList.getList();
        $jacocoInit[191] = true;
        List<Displayable> displayables = new LinkedList<>();
        $jacocoInit[192] = true;
        StoreGridHeaderDisplayable storeGridHeaderDisplayable = new StoreGridHeaderDisplayable(marketName, wsWidget, storeTheme, wsWidget.getTag(), storeContext, storeTabNavigator, navigationTracker);
        $jacocoInit[193] = true;
        displayables.add(storeGridHeaderDisplayable);
        $jacocoInit[194] = true;
        $jacocoInit[195] = true;
        for (p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store store : stores) {
            $jacocoInit[196] = true;
            Data data = wsWidget.getData();
            $jacocoInit[197] = true;
            if (data.getLayout() == Layout.LIST) {
                $jacocoInit[198] = true;
                Context applicationContext = context.getApplicationContext();
                $jacocoInit[199] = true;
                $jacocoInit[200] = true;
                RecommendedStoreDisplayable recommendedStoreDisplayable = new RecommendedStoreDisplayable(store, storeRepository, accountManager, storeUtilsProxy, new StoreCredentialsProviderImpl((StoreAccessor) AccessorFactory.getAccessorFor(((AptoideApplication) applicationContext.getApplicationContext()).getDatabase(), Store.class)));
                $jacocoInit[201] = true;
                displayables.add(recommendedStoreDisplayable);
                $jacocoInit[202] = true;
            } else {
                displayables.add(new GridStoreDisplayable(store));
                $jacocoInit[203] = true;
            }
            $jacocoInit[204] = true;
        }
        DisplayableGroup displayableGroup = new DisplayableGroup(displayables, windowManager, resources);
        $jacocoInit[205] = true;
        return displayableGroup;
    }

    private static List<Displayable> createCommentsGroup(String marketName, WSWidget wsWidget, String storeTheme, String tag, StoreContext storeContext, StoreTabNavigator storeTabNavigator, NavigationTracker navigationTracker) {
        boolean[] $jacocoInit = $jacocoInit();
        List<Displayable> displayables = new LinkedList<>();
        $jacocoInit[206] = true;
        Pair<ListComments, StoreCredentials> data = (Pair) wsWidget.getViewObject();
        ListComments comments = (ListComments) data.first;
        $jacocoInit[207] = true;
        StoreGridHeaderDisplayable storeGridHeaderDisplayable = new StoreGridHeaderDisplayable(marketName, wsWidget, storeTheme, tag, storeContext, storeTabNavigator, navigationTracker);
        displayables.add(storeGridHeaderDisplayable);
        if (comments == null) {
            $jacocoInit[208] = true;
        } else {
            $jacocoInit[209] = true;
            if (comments.getDataList() == null) {
                $jacocoInit[210] = true;
            } else {
                $jacocoInit[211] = true;
                DataList dataList = comments.getDataList();
                $jacocoInit[212] = true;
                List list = dataList.getList();
                $jacocoInit[213] = true;
                if (list.size() <= 0) {
                    $jacocoInit[214] = true;
                } else {
                    StoreCredentials storeCredentials = (StoreCredentials) data.second;
                    $jacocoInit[215] = true;
                    long longValue = storeCredentials.getId().longValue();
                    String name = ((StoreCredentials) data.second).getName();
                    $jacocoInit[216] = true;
                    DataList dataList2 = comments.getDataList();
                    $jacocoInit[217] = true;
                    StoreLatestCommentsDisplayable storeLatestCommentsDisplayable = new StoreLatestCommentsDisplayable(longValue, name, dataList2.getList());
                    $jacocoInit[218] = true;
                    displayables.add(storeLatestCommentsDisplayable);
                    $jacocoInit[219] = true;
                    $jacocoInit[223] = true;
                    return displayables;
                }
            }
        }
        long longValue2 = ((StoreCredentials) data.second).getId().longValue();
        String name2 = ((StoreCredentials) data.second).getName();
        $jacocoInit[220] = true;
        StoreAddCommentDisplayable storeAddCommentDisplayable = new StoreAddCommentDisplayable(longValue2, name2, StoreTheme.get(storeTheme));
        $jacocoInit[221] = true;
        displayables.add(storeAddCommentDisplayable);
        $jacocoInit[222] = true;
        $jacocoInit[223] = true;
        return displayables;
    }

    public static C0120S<List<p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store>> loadLocalSubscribedStores(StoreRepository storeRepository) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S all = storeRepository.getAll();
        $jacocoInit[224] = true;
        C0120S d = all.mo3647d();
        $jacocoInit[225] = true;
        C0120S a = d.mo3616a(Schedulers.computation());
        C5367c cVar = C5367c.f9179a;
        $jacocoInit[226] = true;
        C0120S<List<p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store>> f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) cVar);
        $jacocoInit[227] = true;
        return f;
    }

    /* renamed from: a */
    static /* synthetic */ C0120S m9635a(List stores) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C0120S.m629a((Iterable<? extends T>) stores);
        C5368d dVar = C5368d.f9180a;
        $jacocoInit[228] = true;
        C0120S j = a.mo3669j(dVar);
        $jacocoInit[229] = true;
        C0120S m = j.mo3675m();
        $jacocoInit[230] = true;
        return m;
    }

    /* renamed from: a */
    static /* synthetic */ p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store m9633a(Store store) {
        boolean[] $jacocoInit = $jacocoInit();
        p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store nwStore = new p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store();
        $jacocoInit[231] = true;
        nwStore.setName(store.getStoreName());
        $jacocoInit[232] = true;
        nwStore.setId(store.getStoreId());
        $jacocoInit[233] = true;
        nwStore.setAvatar(store.getIconPath());
        $jacocoInit[234] = true;
        Appearance appearance = new Appearance();
        $jacocoInit[235] = true;
        appearance.setTheme(store.getTheme());
        $jacocoInit[236] = true;
        nwStore.setAppearance(appearance);
        $jacocoInit[237] = true;
        return nwStore;
    }
}
