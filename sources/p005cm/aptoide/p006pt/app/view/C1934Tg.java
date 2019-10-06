package p005cm.aptoide.p006pt.app.view;

import android.view.View;
import android.view.View.OnClickListener;
import p005cm.aptoide.p006pt.app.AppViewSimilarApp;
import p005cm.aptoide.p006pt.app.view.AppViewSimilarAppsAdapter.SimilarAppType;

/* renamed from: cm.aptoide.pt.app.view.Tg */
/* compiled from: lambda */
public final /* synthetic */ class C1934Tg implements OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ AppViewSimilarAppViewHolder f4953a;

    /* renamed from: b */
    private final /* synthetic */ AppViewSimilarApp f4954b;

    /* renamed from: c */
    private final /* synthetic */ SimilarAppType f4955c;

    public /* synthetic */ C1934Tg(AppViewSimilarAppViewHolder appViewSimilarAppViewHolder, AppViewSimilarApp appViewSimilarApp, SimilarAppType similarAppType) {
        this.f4953a = appViewSimilarAppViewHolder;
        this.f4954b = appViewSimilarApp;
        this.f4955c = similarAppType;
    }

    public final void onClick(View view) {
        this.f4953a.mo10751a(this.f4954b, this.f4955c, view);
    }
}
