package p005cm.aptoide.p006pt.search.view;

import android.support.p001v7.widget.RecyclerView.C0970a;
import android.support.p001v7.widget.RecyclerView.C1000w;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.search.model.Suggestion;
import p005cm.aptoide.p006pt.search.suggestions.SearchQueryEvent;
import p005cm.aptoide.p006pt.search.view.item.SuggestionViewHolder;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.search.view.SearchSuggestionsAdapter */
public class SearchSuggestionsAdapter extends C0970a<SuggestionViewHolder> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private List<Suggestion> suggestions;
    private C14963c<SearchQueryEvent> suggestionsPublishSubject;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1170506716863240099L, "cm/aptoide/pt/search/view/SearchSuggestionsAdapter", 16);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void onBindViewHolder(C1000w wVar, int i) {
        boolean[] $jacocoInit = $jacocoInit();
        onBindViewHolder((SuggestionViewHolder) wVar, i);
        $jacocoInit[14] = true;
    }

    public SearchSuggestionsAdapter(List<Suggestion> suggestions2, C14963c<SearchQueryEvent> suggestionsPublishSubject2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.suggestions = suggestions2;
        this.suggestionsPublishSubject = suggestionsPublishSubject2;
        $jacocoInit[0] = true;
    }

    public SuggestionViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        boolean[] $jacocoInit = $jacocoInit();
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        $jacocoInit[1] = true;
        SuggestionViewHolder suggestionViewHolder = new SuggestionViewHolder(from.inflate(C1375R.layout.search_suggestion_item, parent, false), this.suggestionsPublishSubject);
        $jacocoInit[2] = true;
        return suggestionViewHolder;
    }

    public void onBindViewHolder(SuggestionViewHolder suggestionViewHolder, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        suggestionViewHolder.setSuggestion((Suggestion) this.suggestions.get(position), position);
        $jacocoInit[3] = true;
    }

    public int getItemCount() {
        boolean[] $jacocoInit = $jacocoInit();
        int size = this.suggestions.size();
        $jacocoInit[4] = true;
        return size;
    }

    public void addSuggestions(List<Suggestion> suggestions2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.suggestions = suggestions2;
        $jacocoInit[5] = true;
        notifyDataSetChanged();
        $jacocoInit[6] = true;
    }

    public List<Suggestion> getSuggestions() {
        boolean[] $jacocoInit = $jacocoInit();
        List<Suggestion> list = this.suggestions;
        $jacocoInit[7] = true;
        return list;
    }

    public void addSuggestionsFromString(List<String> suggestions2) {
        boolean[] $jacocoInit = $jacocoInit();
        List<Suggestion> result = new ArrayList<>();
        $jacocoInit[8] = true;
        $jacocoInit[9] = true;
        for (String suggestion : suggestions2) {
            $jacocoInit[10] = true;
            result.add(new Suggestion(suggestion, null));
            $jacocoInit[11] = true;
        }
        this.suggestions = result;
        $jacocoInit[12] = true;
        notifyDataSetChanged();
        $jacocoInit[13] = true;
    }
}
