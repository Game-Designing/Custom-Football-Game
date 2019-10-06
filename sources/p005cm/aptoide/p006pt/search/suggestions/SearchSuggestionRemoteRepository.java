package p005cm.aptoide.p006pt.search.suggestions;

import p026rx.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

/* renamed from: cm.aptoide.pt.search.suggestions.SearchSuggestionRemoteRepository */
public interface SearchSuggestionRemoteRepository {
    @GET("suggestion/app/{query}")
    Single<Suggestions> getSuggestionForApp(@Path("query") String str);

    @GET("suggestion/store/{query}")
    Single<Suggestions> getSuggestionForStore(@Path("query") String str);
}
