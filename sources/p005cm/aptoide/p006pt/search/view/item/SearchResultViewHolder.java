package p005cm.aptoide.p006pt.search.view.item;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.text.DecimalFormat;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.home.AppSecondaryInfoViewHolder;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p005cm.aptoide.p006pt.search.model.SearchAppResult;
import p005cm.aptoide.p006pt.search.model.SearchAppResultWrapper;
import p005cm.aptoide.p006pt.utils.AptoideUtils.StringU;
import p019d.p022i.p023b.C0100e;
import p019d.p022i.p296a.p305c.C13034a;
import p026rx.C0120S;
import p026rx.C0137ja;
import p026rx.p027b.C0129b;
import p026rx.p029i.C0136c;

/* renamed from: cm.aptoide.pt.search.view.item.SearchResultViewHolder */
public class SearchResultViewHolder extends SearchResultItemView<SearchAppResult> {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final int LAYOUT = 2131427624;
    private final AppSecondaryInfoViewHolder appInfoViewHolder;
    private View bottomView;
    private TextView downloadsTextView;
    private ImageView iconImageView;
    private TextView nameTextView;
    private final C0100e<SearchAppResultWrapper> onItemViewClick;
    private final String query;
    private TextView ratingBar;
    private SearchAppResult searchApp;
    private TextView storeTextView;
    private C0136c subscriptions = new C0136c();

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2080676624160962810L, "cm/aptoide/pt/search/view/item/SearchResultViewHolder", 45);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void setup(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        setup((SearchAppResult) obj);
        $jacocoInit[40] = true;
    }

    public SearchResultViewHolder(View itemView, C0100e<SearchAppResultWrapper> onItemViewClick2, String query2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        $jacocoInit[0] = true;
        this.onItemViewClick = onItemViewClick2;
        this.query = query2;
        $jacocoInit[1] = true;
        this.appInfoViewHolder = new AppSecondaryInfoViewHolder(itemView, new DecimalFormat("0.0"));
        $jacocoInit[2] = true;
        bindViews(itemView);
        $jacocoInit[3] = true;
    }

    public void setup(SearchAppResult result) {
        boolean[] $jacocoInit = $jacocoInit();
        this.searchApp = result;
        $jacocoInit[4] = true;
        this.appInfoViewHolder.setInfo(result.hasAppcBilling(), result.getAverageRating(), false, false);
        $jacocoInit[5] = true;
        setAppName();
        $jacocoInit[6] = true;
        setDownloadCount();
        $jacocoInit[7] = true;
        setAverageValue();
        $jacocoInit[8] = true;
        setStoreName();
        $jacocoInit[9] = true;
        setIconView();
        $jacocoInit[10] = true;
    }

    public void prepareToRecycle() {
        boolean[] $jacocoInit = $jacocoInit();
        if (!this.subscriptions.mo3715b()) {
            $jacocoInit[11] = true;
        } else if (this.subscriptions.isUnsubscribed()) {
            $jacocoInit[12] = true;
        } else {
            $jacocoInit[13] = true;
            this.subscriptions.unsubscribe();
            $jacocoInit[14] = true;
        }
        $jacocoInit[15] = true;
    }

    private void setIconView() {
        boolean[] $jacocoInit = $jacocoInit();
        ImageLoader with = ImageLoader.with(this.iconImageView.getContext());
        SearchAppResult searchAppResult = this.searchApp;
        $jacocoInit[16] = true;
        with.load(searchAppResult.getIcon(), this.iconImageView);
        $jacocoInit[17] = true;
    }

    private void setStoreName() {
        boolean[] $jacocoInit = $jacocoInit();
        this.storeTextView.setText(this.searchApp.getStoreName());
        $jacocoInit[18] = true;
    }

    private void setAverageValue() {
        boolean[] $jacocoInit = $jacocoInit();
        float avg = this.searchApp.getAverageRating();
        if (avg <= 0.0f) {
            $jacocoInit[19] = true;
            this.ratingBar.setText(C1375R.string.appcardview_title_no_stars);
            $jacocoInit[20] = true;
        } else {
            this.ratingBar.setVisibility(0);
            $jacocoInit[21] = true;
            this.ratingBar.setText(new DecimalFormat("0.0").format((double) avg));
            $jacocoInit[22] = true;
        }
        $jacocoInit[23] = true;
    }

    private void setDownloadCount() {
        boolean[] $jacocoInit = $jacocoInit();
        SearchAppResult searchAppResult = this.searchApp;
        $jacocoInit[24] = true;
        View view = this.bottomView;
        $jacocoInit[25] = true;
        Context context = view.getContext();
        $jacocoInit[26] = true;
        Object[] objArr = {StringU.withSuffix(searchAppResult.getTotalDownloads()), context.getString(C1375R.string.downloads)};
        $jacocoInit[27] = true;
        String downloadNumber = String.format("%s %s", objArr);
        $jacocoInit[28] = true;
        this.downloadsTextView.setText(downloadNumber);
        $jacocoInit[29] = true;
    }

    private void setAppName() {
        boolean[] $jacocoInit = $jacocoInit();
        this.nameTextView.setText(this.searchApp.getAppName());
        $jacocoInit[30] = true;
    }

    private void bindViews(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        this.nameTextView = (TextView) itemView.findViewById(C1375R.C1376id.app_name);
        $jacocoInit[31] = true;
        this.iconImageView = (ImageView) itemView.findViewById(C1375R.C1376id.app_icon);
        $jacocoInit[32] = true;
        this.downloadsTextView = (TextView) itemView.findViewById(C1375R.C1376id.downloads);
        $jacocoInit[33] = true;
        this.ratingBar = (TextView) itemView.findViewById(C1375R.C1376id.rating);
        $jacocoInit[34] = true;
        this.storeTextView = (TextView) itemView.findViewById(C1375R.C1376id.store_name);
        this.bottomView = itemView;
        $jacocoInit[35] = true;
        C0136c cVar = this.subscriptions;
        C0120S a = C13034a.m42490a(itemView);
        C4834c cVar2 = new C4834c(this);
        $jacocoInit[36] = true;
        C0120S j = a.mo3669j(cVar2);
        C4835d dVar = new C4835d(this);
        $jacocoInit[37] = true;
        C0137ja c = j.mo3646c((C0129b<? super T>) dVar);
        $jacocoInit[38] = true;
        cVar.mo3713a(c);
        $jacocoInit[39] = true;
    }

    /* renamed from: a */
    public /* synthetic */ SearchAppResult mo16393a(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        SearchAppResult searchAppResult = this.searchApp;
        $jacocoInit[44] = true;
        return searchAppResult;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16394a(SearchAppResult data) {
        boolean[] $jacocoInit = $jacocoInit();
        C0100e<SearchAppResultWrapper> eVar = this.onItemViewClick;
        String str = this.query;
        $jacocoInit[41] = true;
        SearchAppResultWrapper searchAppResultWrapper = new SearchAppResultWrapper(str, data, getAdapterPosition());
        $jacocoInit[42] = true;
        eVar.call(searchAppResultWrapper);
        $jacocoInit[43] = true;
    }
}
