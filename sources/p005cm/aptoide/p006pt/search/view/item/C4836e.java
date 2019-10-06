package p005cm.aptoide.p006pt.search.view.item;

import android.view.View;
import android.view.View.OnClickListener;
import p005cm.aptoide.p006pt.search.model.Suggestion;

/* renamed from: cm.aptoide.pt.search.view.item.e */
/* compiled from: lambda */
public final /* synthetic */ class C4836e implements OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ SuggestionViewHolder f8472a;

    /* renamed from: b */
    private final /* synthetic */ Suggestion f8473b;

    /* renamed from: c */
    private final /* synthetic */ int f8474c;

    public /* synthetic */ C4836e(SuggestionViewHolder suggestionViewHolder, Suggestion suggestion, int i) {
        this.f8472a = suggestionViewHolder;
        this.f8473b = suggestion;
        this.f8474c = i;
    }

    public final void onClick(View view) {
        this.f8472a.mo16396a(this.f8473b, this.f8474c, view);
    }
}
