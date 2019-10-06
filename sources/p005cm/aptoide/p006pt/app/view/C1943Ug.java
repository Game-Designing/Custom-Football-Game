package p005cm.aptoide.p006pt.app.view;

import android.view.View;
import android.view.View.OnClickListener;
import p005cm.aptoide.p006pt.app.AppViewSimilarApp;
import p005cm.aptoide.p006pt.app.view.AppViewSimilarAppsAdapter.SimilarAppType;

/* renamed from: cm.aptoide.pt.app.view.Ug */
/* compiled from: lambda */
public final /* synthetic */ class C1943Ug implements OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ AppViewSimilarAppViewHolder f4965a;

    /* renamed from: b */
    private final /* synthetic */ AppViewSimilarApp f4966b;

    /* renamed from: c */
    private final /* synthetic */ SimilarAppType f4967c;

    public /* synthetic */ C1943Ug(AppViewSimilarAppViewHolder appViewSimilarAppViewHolder, AppViewSimilarApp appViewSimilarApp, SimilarAppType similarAppType) {
        this.f4965a = appViewSimilarAppViewHolder;
        this.f4966b = appViewSimilarApp;
        this.f4967c = similarAppType;
    }

    public final void onClick(View view) {
        this.f4965a.mo10752b(this.f4966b, this.f4967c, view);
    }
}
