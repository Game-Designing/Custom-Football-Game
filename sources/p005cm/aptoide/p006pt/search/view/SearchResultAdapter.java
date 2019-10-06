package p005cm.aptoide.p006pt.search.view;

import android.content.Context;
import android.support.p001v7.widget.RecyclerView;
import android.support.p001v7.widget.RecyclerView.C0970a;
import android.support.p001v7.widget.RecyclerView.C1000w;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.search.model.SearchAdResult;
import p005cm.aptoide.p006pt.search.model.SearchAdResultWrapper;
import p005cm.aptoide.p006pt.search.model.SearchAppResult;
import p005cm.aptoide.p006pt.search.model.SearchAppResultWrapper;
import p005cm.aptoide.p006pt.search.view.item.SearchLoadingViewHolder;
import p005cm.aptoide.p006pt.search.view.item.SearchResultAdViewHolder;
import p005cm.aptoide.p006pt.search.view.item.SearchResultItemView;
import p005cm.aptoide.p006pt.search.view.item.SearchResultViewHolder;
import p019d.p022i.p023b.C0100e;

/* renamed from: cm.aptoide.pt.search.view.SearchResultAdapter */
public class SearchResultAdapter extends C0970a<SearchResultItemView> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private boolean adsLoaded = false;
    private CrashReport crashReport;
    private boolean isLoadingMore = false;
    private final C0100e<SearchAdResultWrapper> onAdClickRelay;
    private final C0100e<SearchAppResultWrapper> onItemViewClick;
    private String query;
    private final List<SearchAdResult> searchAdResults;
    private final List<SearchAppResult> searchResults;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6740207141347700976L, "cm/aptoide/pt/search/view/SearchResultAdapter", 56);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void onBindViewHolder(C1000w wVar, int i) {
        boolean[] $jacocoInit = $jacocoInit();
        onBindViewHolder((SearchResultItemView) wVar, i);
        $jacocoInit[54] = true;
    }

    public SearchResultAdapter(C0100e<SearchAdResultWrapper> onAdClickRelay2, C0100e<SearchAppResultWrapper> onItemViewClick2, List<SearchAppResult> searchResults2, List<SearchAdResult> searchAdResults2, CrashReport crashReport2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.onAdClickRelay = onAdClickRelay2;
        this.onItemViewClick = onItemViewClick2;
        this.searchResults = searchResults2;
        this.searchAdResults = searchAdResults2;
        this.crashReport = crashReport2;
        $jacocoInit[0] = true;
    }

    public SearchResultItemView onCreateViewHolder(ViewGroup parent, int viewType) {
        boolean[] $jacocoInit = $jacocoInit();
        Context context = parent.getContext();
        $jacocoInit[1] = true;
        LayoutInflater from = LayoutInflater.from(context);
        $jacocoInit[2] = true;
        View view = from.inflate(viewType, parent, false);
        if (viewType == C1375R.layout.search_ad) {
            SearchResultAdViewHolder searchResultAdViewHolder = new SearchResultAdViewHolder(view, this.onAdClickRelay);
            $jacocoInit[4] = true;
            return searchResultAdViewHolder;
        } else if (viewType != C1375R.layout.search_app_row) {
            SearchLoadingViewHolder searchLoadingViewHolder = new SearchLoadingViewHolder(view);
            $jacocoInit[5] = true;
            return searchLoadingViewHolder;
        } else {
            SearchResultViewHolder searchResultViewHolder = new SearchResultViewHolder(view, this.onItemViewClick, this.query);
            $jacocoInit[3] = true;
            return searchResultViewHolder;
        }
    }

    public void onBindViewHolder(SearchResultItemView holder, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        try {
            holder.setup(getItem(position));
            $jacocoInit[6] = true;
        } catch (ClassCastException e) {
            $jacocoInit[7] = true;
            this.crashReport.log(e);
            $jacocoInit[8] = true;
        }
        $jacocoInit[9] = true;
    }

    public int getItemViewType(int position) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.adsLoaded) {
            $jacocoInit[10] = true;
        } else if (position != 0) {
            $jacocoInit[11] = true;
        } else {
            $jacocoInit[12] = true;
            return C1375R.layout.search_ad_loading_list_item;
        }
        int totalItems = this.searchAdResults.size() + this.searchResults.size();
        if (!this.isLoadingMore) {
            $jacocoInit[13] = true;
        } else if (position < totalItems) {
            $jacocoInit[14] = true;
        } else {
            $jacocoInit[15] = true;
            return C1375R.layout.search_ad_loading_list_item;
        }
        if (!this.adsLoaded) {
            $jacocoInit[16] = true;
        } else if (position >= this.searchAdResults.size()) {
            $jacocoInit[17] = true;
        } else {
            $jacocoInit[18] = true;
            return C1375R.layout.search_ad;
        }
        $jacocoInit[19] = true;
        return C1375R.layout.search_app_row;
    }

    public int getItemCount() {
        int i;
        boolean[] $jacocoInit = $jacocoInit();
        int itemCount = this.searchAdResults.size() + this.searchResults.size();
        if (this.isLoadingMore) {
            i = itemCount + 1;
            $jacocoInit[20] = true;
        } else {
            $jacocoInit[21] = true;
            i = itemCount;
        }
        $jacocoInit[22] = true;
        return i;
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onDetachedFromRecyclerView(recyclerView);
        $jacocoInit[23] = true;
        int i = 0;
        $jacocoInit[24] = true;
        while (i < getItemCount()) {
            try {
                $jacocoInit[25] = true;
                ((SearchResultItemView) getItem(i)).prepareToRecycle();
                $jacocoInit[26] = true;
            } catch (ClassCastException | NullPointerException e) {
                $jacocoInit[27] = true;
            }
            i++;
            $jacocoInit[28] = true;
        }
        $jacocoInit[29] = true;
    }

    private Object getItem(int position) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.adsLoaded) {
            $jacocoInit[30] = true;
        } else if (position != 0) {
            $jacocoInit[31] = true;
        } else {
            $jacocoInit[32] = true;
            return null;
        }
        int totalItems = this.searchAdResults.size() + this.searchResults.size();
        if (!this.isLoadingMore) {
            $jacocoInit[33] = true;
        } else if (position < totalItems) {
            $jacocoInit[34] = true;
        } else {
            $jacocoInit[35] = true;
            return null;
        }
        if (!this.adsLoaded) {
            $jacocoInit[36] = true;
        } else if (position >= this.searchAdResults.size()) {
            $jacocoInit[37] = true;
        } else {
            $jacocoInit[38] = true;
            Object obj = this.searchAdResults.get(position);
            $jacocoInit[39] = true;
            return obj;
        }
        Object obj2 = this.searchResults.get(position - this.searchAdResults.size());
        $jacocoInit[40] = true;
        return obj2;
    }

    public void addResultForSearch(String query2, List<SearchAppResult> dataList) {
        boolean[] $jacocoInit = $jacocoInit();
        this.query = query2;
        $jacocoInit[41] = true;
        this.searchResults.addAll(dataList);
        $jacocoInit[42] = true;
        notifyDataSetChanged();
        $jacocoInit[43] = true;
    }

    public void setResultForAd(SearchAdResult searchAd) {
        boolean[] $jacocoInit = $jacocoInit();
        this.searchAdResults.add(searchAd);
        $jacocoInit[44] = true;
        setAdsLoaded();
        $jacocoInit[45] = true;
    }

    public void setAdsLoaded() {
        boolean[] $jacocoInit = $jacocoInit();
        this.adsLoaded = true;
        $jacocoInit[46] = true;
        notifyDataSetChanged();
        $jacocoInit[47] = true;
    }

    public void setIsLoadingMore(boolean isLoadingMore2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.isLoadingMore = isLoadingMore2;
        $jacocoInit[48] = true;
        notifyDataSetChanged();
        $jacocoInit[49] = true;
    }

    public void restoreState(List<SearchAppResult> apps, List<SearchAdResult> ads) {
        boolean[] $jacocoInit = $jacocoInit();
        this.searchResults.clear();
        $jacocoInit[50] = true;
        this.searchResults.addAll(apps);
        $jacocoInit[51] = true;
        this.searchAdResults.clear();
        $jacocoInit[52] = true;
        this.searchAdResults.addAll(ads);
        this.adsLoaded = true;
        this.isLoadingMore = false;
        $jacocoInit[53] = true;
    }
}
