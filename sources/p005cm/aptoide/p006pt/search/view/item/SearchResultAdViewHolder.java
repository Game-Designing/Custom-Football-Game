package p005cm.aptoide.p006pt.search.view.item;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p005cm.aptoide.p006pt.search.model.SearchAdResult;
import p005cm.aptoide.p006pt.search.model.SearchAdResultWrapper;
import p005cm.aptoide.p006pt.utils.AptoideUtils.StringU;
import p019d.p022i.p023b.C0100e;
import p019d.p022i.p296a.p305c.C13034a;
import p026rx.C0120S;
import p026rx.p027b.C0129b;

/* renamed from: cm.aptoide.pt.search.view.item.SearchResultAdViewHolder */
public class SearchResultAdViewHolder extends SearchResultItemView<SearchAdResult> {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final int LAYOUT = 2131427622;
    private SearchAdResult adResult;
    private TextView downloadsTextView;
    private ImageView icon;
    private TextView name;
    private final C0100e<SearchAdResultWrapper> onItemViewClickRelay;
    private TextView ratingBar;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-671229639367782837L, "cm/aptoide/pt/search/view/item/SearchResultAdViewHolder", 31);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void setup(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        setup((SearchAdResult) obj);
        $jacocoInit[26] = true;
    }

    public SearchResultAdViewHolder(View itemView, C0100e<SearchAdResultWrapper> onItemViewClickRelay2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        this.onItemViewClickRelay = onItemViewClickRelay2;
        $jacocoInit[0] = true;
        bind(itemView);
        $jacocoInit[1] = true;
    }

    private void bind(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        this.name = (TextView) itemView.findViewById(C1375R.C1376id.app_name);
        $jacocoInit[2] = true;
        this.icon = (ImageView) itemView.findViewById(C1375R.C1376id.app_icon);
        $jacocoInit[3] = true;
        this.downloadsTextView = (TextView) itemView.findViewById(C1375R.C1376id.downloads);
        $jacocoInit[4] = true;
        this.ratingBar = (TextView) itemView.findViewById(C1375R.C1376id.rating);
        $jacocoInit[5] = true;
        C0120S a = C13034a.m42490a(itemView);
        C4832a aVar = new C4832a(this);
        $jacocoInit[6] = true;
        C0120S j = a.mo3669j(aVar);
        C4833b bVar = new C4833b(this);
        $jacocoInit[7] = true;
        j.mo3646c((C0129b<? super T>) bVar);
        $jacocoInit[8] = true;
    }

    /* renamed from: a */
    public /* synthetic */ SearchAdResult mo16388a(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        SearchAdResult searchAdResult = this.adResult;
        $jacocoInit[30] = true;
        return searchAdResult;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16389a(SearchAdResult data) {
        boolean[] $jacocoInit = $jacocoInit();
        C0100e<SearchAdResultWrapper> eVar = this.onItemViewClickRelay;
        $jacocoInit[27] = true;
        SearchAdResultWrapper searchAdResultWrapper = new SearchAdResultWrapper(data, getAdapterPosition());
        $jacocoInit[28] = true;
        eVar.call(searchAdResultWrapper);
        $jacocoInit[29] = true;
    }

    public void setup(SearchAdResult searchAd) {
        boolean[] $jacocoInit = $jacocoInit();
        Context context = this.itemView.getContext();
        $jacocoInit[9] = true;
        Resources resources = this.itemView.getResources();
        this.adResult = searchAd;
        $jacocoInit[10] = true;
        setName(searchAd);
        $jacocoInit[11] = true;
        setIcon(searchAd, context);
        $jacocoInit[12] = true;
        setDownloadsCount(searchAd, resources);
        $jacocoInit[13] = true;
        setRatingStars(searchAd);
        $jacocoInit[14] = true;
    }

    private void setIcon(SearchAdResult searchAd, Context context) {
        boolean[] $jacocoInit = $jacocoInit();
        ImageLoader with = ImageLoader.with(context);
        $jacocoInit[15] = true;
        with.load(searchAd.getIcon(), this.icon);
        $jacocoInit[16] = true;
    }

    private void setName(SearchAdResult searchAd) {
        boolean[] $jacocoInit = $jacocoInit();
        this.name.setText(searchAd.getAppName());
        $jacocoInit[17] = true;
    }

    private void setDownloadsCount(SearchAdResult searchAd, Resources resources) {
        boolean[] $jacocoInit = $jacocoInit();
        StringBuilder sb = new StringBuilder();
        $jacocoInit[18] = true;
        sb.append(StringU.withSuffix(searchAd.getTotalDownloads()));
        sb.append(" ");
        sb.append(resources.getString(C1375R.string.downloads));
        String downloadNumber = sb.toString();
        $jacocoInit[19] = true;
        this.downloadsTextView.setText(downloadNumber);
        $jacocoInit[20] = true;
    }

    private void setRatingStars(SearchAdResult searchAd) {
        boolean[] $jacocoInit = $jacocoInit();
        float avg = searchAd.getStarRating();
        if (avg <= 0.0f) {
            $jacocoInit[21] = true;
            this.ratingBar.setText(C1375R.string.appcardview_title_no_stars);
            $jacocoInit[22] = true;
        } else {
            this.ratingBar.setVisibility(0);
            $jacocoInit[23] = true;
            this.ratingBar.setText(Float.toString(avg));
            $jacocoInit[24] = true;
        }
        $jacocoInit[25] = true;
    }
}
