package p005cm.aptoide.p006pt.home.apps;

import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: cm.aptoide.pt.home.apps.a */
/* compiled from: lambda */
public final /* synthetic */ class C3653a implements OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ ActiveAppDownloadViewHolder f7050a;

    /* renamed from: b */
    private final /* synthetic */ App f7051b;

    public /* synthetic */ C3653a(ActiveAppDownloadViewHolder activeAppDownloadViewHolder, App app) {
        this.f7050a = activeAppDownloadViewHolder;
        this.f7051b = app;
    }

    public final void onClick(View view) {
        this.f7050a.mo14574b(this.f7051b, view);
    }
}
