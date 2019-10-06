package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.view.WindowManager;
import java.util.LinkedList;
import java.util.List;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.exception.AptoideWsV7Exception;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p007v2.GetAdsResponse;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response.Error;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetAppMeta;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetStoreWidgets.WSWidget;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.ListAppCoinsCampaigns;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.ListApps;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.ListComments;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.ListFullReviews;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.TimelineStats;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.TimelineStats.StatusData;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Type;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.GetHomeMeta;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.GetHomeMeta.Data;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.GetStoreDisplays;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.GetStoreMeta;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.ListStores;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p011v2.aptwords.AdsApplicationVersionCodeProvider;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p011v2.aptwords.GetAdsRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseRequestWithStore.StoreCredentials;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.GetAppCoinsCampaignsRequest.Body;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.home.ActionItemResponse;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.home.GetActionItemRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.GetHomeMetaRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.GetMyStoreListRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.GetMyStoreMetaRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.GetStoreDisplaysRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.GetStoreMetaRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.ListStoresRequest;
import p026rx.C0120S;
import p026rx.p027b.C0129b;
import p026rx.p027b.C14541q;
import p026rx.schedulers.Schedulers;
import retrofit2.Converter.Factory;

@Deprecated
/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.WSWidgetsUtils */
public class WSWidgetsUtils {
    private static final String USER_DONT_HAVE_STORE_ERROR = "MYSTORE-1";
    private static final String USER_NOT_LOGGED_ERROR = "AUTH-5";

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.WSWidgetsUtils$1 */
    static /* synthetic */ class C28741 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type = new int[Type.values().length];

        static {
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.APPS_TOP_GROUP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.APPS_GROUP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.STORES_GROUP.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.DISPLAYS.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.ADS.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.APPCOINS_ADS.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.HOME_META.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.COMMENTS_GROUP.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.REVIEWS_GROUP.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.MY_STORES_SUBSCRIBED.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.STORES_RECOMMENDED.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.MY_STORE_META.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.STORE_META.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.APP_META.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.ACTION_ITEM.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
        }
    }

    @Deprecated
    public C0120S<WSWidget> loadWidgetNode(WSWidget wsWidget, StoreCredentials storeCredentials, boolean bypassCache, String clientUniqueId, boolean googlePlayServicesAvailable, String oemid, boolean mature, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, String q, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences, Resources resources, WindowManager windowManager, ConnectivityManager connectivityManager, AdsApplicationVersionCodeProvider versionCodeProvider, boolean bypassServerCache, int limit, List<String> list) {
        String url;
        WSWidget wSWidget = wsWidget;
        boolean z = bypassCache;
        boolean z2 = bypassServerCache;
        if (wsWidget.getType() == null) {
            return C0120S.m651c();
        }
        if (wsWidget.getView() != null) {
            url = wsWidget.getView().replace(C0044V7.getHost(sharedPreferences), "");
        } else {
            url = null;
        }
        switch (C28741.$SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[wsWidget.getType().ordinal()]) {
            case 1:
            case 2:
                StoreCredentials storeCredentials2 = storeCredentials;
                int i = limit;
                return ListAppsRequest.ofAction(url, storeCredentials, bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences, resources, windowManager).observe(z, z2).mo3616a(Schedulers.m776io()).mo3636b((C0129b<? super T>) new C2863M<Object>(wSWidget)).mo3671k(C2858H.f6114a).mo3669j(new C2889j(wSWidget));
            case 3:
                StoreCredentials storeCredentials3 = storeCredentials;
                int i2 = limit;
                return ListStoresRequest.ofAction(url, bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences).observe(z, z2).mo3616a(Schedulers.m776io()).mo3636b((C0129b<? super T>) new C2926y<Object>(wSWidget)).mo3671k(C2854E.f6110a).mo3669j(new C2850A(wSWidget));
            case 4:
                StoreCredentials storeCredentials4 = storeCredentials;
                int i3 = limit;
                return GetStoreDisplaysRequest.ofAction(url, storeCredentials, bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences).observe(z, z2).mo3616a(Schedulers.m776io()).mo3636b((C0129b<? super T>) new C2868S<Object>(wSWidget)).mo3671k(C2912s.f6188a).mo3669j(new C2891l(wSWidget));
            case 5:
                StoreCredentials storeCredentials5 = storeCredentials;
                int i4 = limit;
                return GetAdsRequest.ofHomepage(clientUniqueId, googlePlayServicesAvailable, oemid, mature, httpClient, converterFactory, q, sharedPreferences, resources, connectivityManager, versionCodeProvider, limit).observe(z).mo3616a(Schedulers.m776io()).mo3636b((C0129b<? super T>) new C2907n<Object>(wSWidget)).mo3671k(C2864N.f6120a).mo3669j(new C2862L(wSWidget));
            case 6:
                StoreCredentials storeCredentials6 = storeCredentials;
                GetAppCoinsCampaignsRequest getAppCoinsCampaignsRequest = new GetAppCoinsCampaignsRequest(new Body(0, limit), httpClient, converterFactory, bodyInterceptor, tokenInvalidator, sharedPreferences);
                return getAppCoinsCampaignsRequest.observe(z, z2).mo3616a(Schedulers.m776io()).mo3636b((C0129b<? super T>) new C2923v<Object>(wSWidget)).mo3671k(C2888i.f6158a).mo3669j(new C2875X(wSWidget));
            case 7:
                StoreCredentials storeCredentials7 = storeCredentials;
                return GetHomeMetaRequest.ofAction(url, storeCredentials, bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences).observe(z, z2).mo3616a(Schedulers.m776io()).mo3636b((C0129b<? super T>) new C2924w<Object>(wSWidget)).mo3671k(C2911r.f6187a).mo3669j(new C2910q(wSWidget));
            case 8:
                return ListCommentsRequest.ofStoreAction(url, bypassCache, storeCredentials, bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences).observe(z, z2).mo3616a(Schedulers.m776io()).mo3636b((C0129b<? super T>) new C2852C<Object>(wSWidget, storeCredentials)).mo3671k(C2881f.f6148a).mo3669j(new C2882g(wSWidget));
            case 9:
                BodyInterceptor<BaseBody> bodyInterceptor2 = bodyInterceptor;
                OkHttpClient okHttpClient = httpClient;
                TokenInvalidator tokenInvalidator2 = tokenInvalidator;
                SharedPreferences sharedPreferences2 = sharedPreferences;
                return ListFullReviewsRequest.ofAction(url, bypassCache, storeCredentials, bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences).observe(z, z2).mo3616a(Schedulers.m776io()).mo3636b((C0129b<? super T>) new C2853D<Object>(wSWidget)).mo3671k(C2906m.f6182a).mo3669j(new C2871U(wSWidget));
            case 10:
            case 11:
                BodyInterceptor<BaseBody> bodyInterceptor3 = bodyInterceptor;
                OkHttpClient okHttpClient2 = httpClient;
                Factory factory = converterFactory;
                TokenInvalidator tokenInvalidator3 = tokenInvalidator;
                SharedPreferences sharedPreferences3 = sharedPreferences;
                return GetMyStoreListRequest.m7580of(url, bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences, resources, windowManager).observe(z, z2).mo3616a(Schedulers.m776io()).mo3636b((C0129b<? super T>) new C2859I<Object>(wSWidget)).mo3621a((C0129b<? super Throwable>) new C2921t<Object>(this, wSWidget)).mo3671k(C2861K.f6117a).mo3669j(new C2873W(wSWidget));
            case 12:
                return C0120S.m650b(GetTimelineStatsRequest.m7466of(bodyInterceptor, null, httpClient, converterFactory, tokenInvalidator, sharedPreferences).observe(z, z2).mo3674l(new C2872V(this)), GetMyStoreMetaRequest.m7582of(bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences).observe(z, z2).mo3616a(Schedulers.m776io()).mo3669j(C2856G.f6113a).mo3671k(new C2922u(this)), (C14541q<? super T1, ? super T2, ? extends R>) new C2851B<Object,Object,Object>(this)).mo3636b((C0129b<? super T>) new C2870T<Object>(wSWidget)).mo3671k(C2927z.f6206a).mo3669j(new C2890k(wSWidget));
            case 13:
                return GetStoreMetaRequest.ofAction(url, bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences).observe(z, z2).mo3636b((C0129b<? super T>) new C2925x<Object>(wSWidget)).mo3671k(C2866P.f6122a).mo3669j(new C2883h(wSWidget));
            case 14:
                return GetAppMetaRequest.ofAction(url, bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences).observe(z, z2).mo3616a(Schedulers.m776io()).mo3636b((C0129b<? super T>) new C2860J<Object>(wSWidget)).mo3671k(C2865O.f6121a).mo3669j(new C2909p(wSWidget));
            case 15:
                return GetActionItemRequest.ofAction(url, bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences).observe(z, z2).mo3616a(Schedulers.m776io()).mo3636b((C0129b<? super T>) new C2855F<Object>(wSWidget)).mo3671k(C2908o.f6184a).mo3669j(new C2867Q(wSWidget));
            default:
                return C0120S.m651c();
        }
    }

    /* renamed from: b */
    static /* synthetic */ WSWidget m7508b(WSWidget wsWidget, ListApps listApps) {
        return wsWidget;
    }

    /* renamed from: d */
    static /* synthetic */ WSWidget m7520d(WSWidget wsWidget, ListStores listApps) {
        return wsWidget;
    }

    /* renamed from: b */
    static /* synthetic */ WSWidget m7511b(WSWidget wsWidget, GetStoreDisplays listApps) {
        return wsWidget;
    }

    /* renamed from: a */
    static /* synthetic */ WSWidget m7491a(WSWidget wsWidget, GetAdsResponse listApps) {
        return wsWidget;
    }

    /* renamed from: b */
    static /* synthetic */ WSWidget m7507b(WSWidget wsWidget, ListAppCoinsCampaigns listAppCoinsRewardApps) {
        return wsWidget;
    }

    /* renamed from: b */
    static /* synthetic */ WSWidget m7510b(WSWidget wsWidget, GetHomeMeta listApps) {
        return wsWidget;
    }

    /* renamed from: a */
    static /* synthetic */ WSWidget m7492a(WSWidget wsWidget, ListComments listApps) {
        return wsWidget;
    }

    /* renamed from: b */
    static /* synthetic */ WSWidget m7509b(WSWidget wsWidget, ListFullReviews listApps) {
        return wsWidget;
    }

    /* renamed from: a */
    public /* synthetic */ void mo13157a(WSWidget wsWidget, Throwable throwable) {
        LinkedList<String> errorsList = new LinkedList<>();
        errorsList.add(USER_NOT_LOGGED_ERROR);
        if ((throwable instanceof AptoideWsV7Exception) && shouldAddObjectView(errorsList, throwable)) {
            wsWidget.setViewObject(((AptoideWsV7Exception) throwable).getBaseResponse());
        }
    }

    /* renamed from: b */
    static /* synthetic */ WSWidget m7513b(WSWidget wsWidget, ListStores listApps) {
        return wsWidget;
    }

    /* renamed from: h */
    public /* synthetic */ TimelineStats mo13158h(Throwable throwable) {
        return createErrorTimelineStatus();
    }

    /* renamed from: a */
    static /* synthetic */ GetHomeMeta m7493a(GetStoreMeta getStoreMeta) {
        Data data = new Data();
        data.setStore(getStoreMeta.getData());
        GetHomeMeta homeMeta = new GetHomeMeta();
        homeMeta.setData(data);
        return homeMeta;
    }

    /* renamed from: i */
    public /* synthetic */ C0120S mo13159i(Throwable throwable) {
        LinkedList<String> errorsList = new LinkedList<>();
        errorsList.add(USER_NOT_LOGGED_ERROR);
        errorsList.add(USER_DONT_HAVE_STORE_ERROR);
        if (shouldAddObjectView(errorsList, throwable)) {
            return C0120S.m652c(null);
        }
        return C0120S.m631a(throwable);
    }

    /* renamed from: a */
    public /* synthetic */ MyStore mo13156a(TimelineStats timelineStats, GetHomeMeta getHomeMeta) {
        if (timelineStats.getData() == null) {
            return new MyStore(createErrorTimelineStatus(), getHomeMeta);
        }
        return new MyStore(timelineStats, getHomeMeta);
    }

    /* renamed from: b */
    static /* synthetic */ WSWidget m7514b(WSWidget wsWidget, MyStore myStore) {
        return wsWidget;
    }

    /* renamed from: b */
    static /* synthetic */ WSWidget m7512b(WSWidget wsWidget, GetStoreMeta myStore) {
        return wsWidget;
    }

    /* renamed from: b */
    static /* synthetic */ WSWidget m7506b(WSWidget wsWidget, GetAppMeta listApps) {
        return wsWidget;
    }

    /* renamed from: b */
    static /* synthetic */ WSWidget m7515b(WSWidget wsWidget, ActionItemResponse actionItemResponse) {
        return wsWidget;
    }

    private TimelineStats createErrorTimelineStatus() {
        TimelineStats timelineStats = new TimelineStats();
        StatusData data = new StatusData();
        data.setFollowers(0);
        data.setFollowing(0);
        timelineStats.setData(data);
        return timelineStats;
    }

    @Deprecated
    public boolean shouldAddObjectView(List<String> list, Throwable throwable) {
        if (throwable instanceof AptoideWsV7Exception) {
            for (Error error : ((AptoideWsV7Exception) throwable).getBaseResponse().getErrors()) {
                if (list.contains(error.getCode())) {
                    return true;
                }
            }
        }
        return false;
    }
}
