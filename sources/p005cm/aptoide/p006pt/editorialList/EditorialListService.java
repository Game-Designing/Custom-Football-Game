package p005cm.aptoide.p006pt.editorialList;

import android.content.SharedPreferences;
import java.net.ConnectException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.exception.NoNetworkConnectionException;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.DataList;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.EditorialListData;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.EditorialListRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.EditorialListResponse;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.home.Appearance;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.home.Caption;
import p005cm.aptoide.p006pt.editorialList.EditorialListViewModel.Error;
import p026rx.C0120S;
import p026rx.Single;
import p026rx.p027b.C0128a;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.editorialList.EditorialListService */
public class EditorialListService {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final BodyInterceptor<BaseBody> bodyInterceptorPoolV7;
    private final Factory converterFactory;
    private final int limit;
    private boolean loading;
    private final OkHttpClient okHttpClient;
    private final SharedPreferences sharedPreferences;
    private final TokenInvalidator tokenInvalidator;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2600779077835653347L, "cm/aptoide/pt/editorialList/EditorialListService", 35);
        $jacocoData = probes;
        return probes;
    }

    public EditorialListService(BodyInterceptor<BaseBody> bodyInterceptorPoolV72, OkHttpClient okHttpClient2, TokenInvalidator tokenInvalidator2, Factory converterFactory2, SharedPreferences sharedPreferences2, int limit2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.bodyInterceptorPoolV7 = bodyInterceptorPoolV72;
        this.okHttpClient = okHttpClient2;
        this.tokenInvalidator = tokenInvalidator2;
        this.converterFactory = converterFactory2;
        this.sharedPreferences = sharedPreferences2;
        this.limit = limit2;
        $jacocoInit[0] = true;
    }

    public Single<EditorialListViewModel> loadEditorialListViewModel(int offset, boolean invalidateCache) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.loading) {
            $jacocoInit[1] = true;
            Single<EditorialListViewModel> a = Single.m734a(new EditorialListViewModel(true));
            $jacocoInit[2] = true;
            return a;
        }
        EditorialListRequest of = EditorialListRequest.m7459of(this.bodyInterceptorPoolV7, this.okHttpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences, this.limit, offset);
        $jacocoInit[3] = true;
        C0120S observe = of.observe(invalidateCache, false);
        C3260Ma ma = new C3260Ma(this);
        $jacocoInit[4] = true;
        C0120S b = observe.mo3635b((C0128a) ma);
        C3252Ia ia = new C3252Ia(this);
        $jacocoInit[5] = true;
        C0120S d = b.mo3652d((C0128a) ia);
        C3254Ja ja = new C3254Ja(this);
        $jacocoInit[6] = true;
        C0120S c = d.mo3644c((C0128a) ja);
        C3256Ka ka = new C3256Ka(this);
        $jacocoInit[7] = true;
        C0120S j = c.mo3669j(ka);
        $jacocoInit[8] = true;
        Single n = j.mo3678n();
        C3258La la = new C3258La(this);
        $jacocoInit[9] = true;
        Single<EditorialListViewModel> f = n.mo3700f(la);
        $jacocoInit[10] = true;
        return f;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14158a() {
        boolean[] $jacocoInit = $jacocoInit();
        this.loading = true;
        $jacocoInit[34] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo14159b() {
        boolean[] $jacocoInit = $jacocoInit();
        this.loading = false;
        $jacocoInit[33] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo14160c() {
        boolean[] $jacocoInit = $jacocoInit();
        this.loading = false;
        $jacocoInit[32] = true;
    }

    /* access modifiers changed from: private */
    public EditorialListViewModel mapEditorialListError(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        if (throwable instanceof NoNetworkConnectionException) {
            $jacocoInit[11] = true;
        } else if (throwable instanceof ConnectException) {
            $jacocoInit[12] = true;
        } else {
            EditorialListViewModel editorialListViewModel = new EditorialListViewModel(Error.GENERIC);
            $jacocoInit[14] = true;
            return editorialListViewModel;
        }
        EditorialListViewModel editorialListViewModel2 = new EditorialListViewModel(Error.NETWORK);
        $jacocoInit[13] = true;
        return editorialListViewModel2;
    }

    /* access modifiers changed from: private */
    public EditorialListViewModel mapEditorialList(EditorialListResponse actionItemResponse) {
        boolean[] $jacocoInit = $jacocoInit();
        DataList<EditorialListData> dataList = actionItemResponse.getDataList();
        $jacocoInit[15] = true;
        List<EditorialListData> items = dataList.getList();
        $jacocoInit[16] = true;
        List<CurationCard> curationCards = buildCurationCardList(items);
        $jacocoInit[17] = true;
        EditorialListViewModel editorialListViewModel = new EditorialListViewModel(curationCards, dataList.getNext(), dataList.getTotal());
        $jacocoInit[18] = true;
        return editorialListViewModel;
    }

    private List<CurationCard> buildCurationCardList(List<EditorialListData> items) {
        String str;
        boolean[] $jacocoInit = $jacocoInit();
        List<CurationCard> curationCards = new ArrayList<>();
        $jacocoInit[19] = true;
        $jacocoInit[20] = true;
        for (EditorialListData actionItemData : items) {
            $jacocoInit[21] = true;
            String id = actionItemData.getId();
            String caption = actionItemData.getCaption();
            $jacocoInit[22] = true;
            String icon = actionItemData.getIcon();
            String title = actionItemData.getTitle();
            String views = actionItemData.getViews();
            $jacocoInit[23] = true;
            String type = actionItemData.getType();
            String date = actionItemData.getDate();
            $jacocoInit[24] = true;
            if (actionItemData.getAppearance() != null) {
                Appearance appearance = actionItemData.getAppearance();
                $jacocoInit[25] = true;
                Caption caption2 = appearance.getCaption();
                $jacocoInit[26] = true;
                str = caption2.getTheme();
                $jacocoInit[27] = true;
            } else {
                $jacocoInit[28] = true;
                str = "";
            }
            CurationCard curationCard = new CurationCard(id, caption, icon, title, views, type, date, str);
            $jacocoInit[29] = true;
            curationCards.add(curationCard);
            $jacocoInit[30] = true;
        }
        $jacocoInit[31] = true;
        return curationCards;
    }
}
