package p005cm.aptoide.p006pt.search.view.item;

import android.support.p001v7.widget.RecyclerView.C1000w;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.search.model.Suggestion;
import p005cm.aptoide.p006pt.search.suggestions.SearchQueryEvent;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.search.view.item.SuggestionViewHolder */
public class SuggestionViewHolder extends C1000w {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private ImageView suggestionIcon;
    private TextView suggestionName;
    private C14963c<SearchQueryEvent> suggestionPublishSubject;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7508755324410818952L, "cm/aptoide/pt/search/view/item/SuggestionViewHolder", 13);
        $jacocoData = probes;
        return probes;
    }

    public SuggestionViewHolder(View itemView, C14963c<SearchQueryEvent> suggestionPublishSubject2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        this.suggestionPublishSubject = suggestionPublishSubject2;
        $jacocoInit[0] = true;
        this.suggestionName = (TextView) itemView.findViewById(C1375R.C1376id.search_suggestion_app_name);
        $jacocoInit[1] = true;
        this.suggestionIcon = (ImageView) itemView.findViewById(C1375R.C1376id.search_suggestion_app_icon);
        $jacocoInit[2] = true;
    }

    public void setSuggestion(Suggestion suggestion, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        TextView textView = this.suggestionName;
        String name = suggestion.getName();
        $jacocoInit[3] = true;
        String trim = name.trim();
        $jacocoInit[4] = true;
        textView.setText(trim);
        $jacocoInit[5] = true;
        if (suggestion.getIcon() != null) {
            $jacocoInit[6] = true;
            this.suggestionIcon.setImageResource(C1375R.drawable.ic_suggestions_trending);
            $jacocoInit[7] = true;
        } else {
            this.suggestionIcon.setImageResource(C1375R.drawable.ic_stat_aptoide_notification);
            $jacocoInit[8] = true;
        }
        this.itemView.setOnClickListener(new C4836e(this, suggestion, position));
        $jacocoInit[9] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16396a(Suggestion suggestion, int position, View c) {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<SearchQueryEvent> cVar = this.suggestionPublishSubject;
        $jacocoInit[10] = true;
        SearchQueryEvent searchQueryEvent = new SearchQueryEvent(suggestion.getName(), position, true, true);
        $jacocoInit[11] = true;
        cVar.onNext(searchQueryEvent);
        $jacocoInit[12] = true;
    }
}
