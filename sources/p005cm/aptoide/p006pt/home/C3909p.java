package p005cm.aptoide.p006pt.home;

import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: cm.aptoide.pt.home.p */
/* compiled from: lambda */
public final /* synthetic */ class C3909p implements OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ EditorialBundleViewHolder f7360a;

    /* renamed from: b */
    private final /* synthetic */ String f7361b;

    /* renamed from: c */
    private final /* synthetic */ String f7362c;

    /* renamed from: d */
    private final /* synthetic */ HomeBundle f7363d;

    /* renamed from: e */
    private final /* synthetic */ int f7364e;

    public /* synthetic */ C3909p(EditorialBundleViewHolder editorialBundleViewHolder, String str, String str2, HomeBundle homeBundle, int i) {
        this.f7360a = editorialBundleViewHolder;
        this.f7361b = str;
        this.f7362c = str2;
        this.f7363d = homeBundle;
        this.f7364e = i;
    }

    public final void onClick(View view) {
        this.f7360a.mo14259c(this.f7361b, this.f7362c, this.f7363d, this.f7364e, view);
    }
}
