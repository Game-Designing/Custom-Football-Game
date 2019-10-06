package p005cm.aptoide.p006pt.search.view;

import java.util.List;
import p005cm.aptoide.p006pt.presenter.View;
import p005cm.aptoide.p006pt.search.model.Suggestion;
import p005cm.aptoide.p006pt.search.suggestions.SearchQueryEvent;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.search.view.SearchSuggestionsView */
public interface SearchSuggestionsView extends View {
    void collapseSearchBar(boolean z);

    void focusInSearchBar();

    String getCurrentQuery();

    C0120S<SearchQueryEvent> onQueryTextChanged();

    void setSuggestionsList(List<String> list);

    void setTrendingCursor(List<String> list);

    void setTrendingList(List<Suggestion> list);
}
