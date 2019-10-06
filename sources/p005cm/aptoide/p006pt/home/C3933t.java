package p005cm.aptoide.p006pt.home;

import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: cm.aptoide.pt.home.t */
/* compiled from: lambda */
public final /* synthetic */ class C3933t implements OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ EditorialBundleViewHolder f7403a;

    /* renamed from: b */
    private final /* synthetic */ String f7404b;

    /* renamed from: c */
    private final /* synthetic */ String f7405c;

    /* renamed from: d */
    private final /* synthetic */ HomeBundle f7406d;

    /* renamed from: e */
    private final /* synthetic */ int f7407e;

    public /* synthetic */ C3933t(EditorialBundleViewHolder editorialBundleViewHolder, String str, String str2, HomeBundle homeBundle, int i) {
        this.f7403a = editorialBundleViewHolder;
        this.f7404b = str;
        this.f7405c = str2;
        this.f7406d = homeBundle;
        this.f7407e = i;
    }

    public final void onClick(View view) {
        this.f7403a.mo14257a(this.f7404b, this.f7405c, this.f7406d, this.f7407e, view);
    }
}
