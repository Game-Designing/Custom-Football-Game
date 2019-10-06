package p005cm.aptoide.p006pt.home;

import android.view.View;
import android.view.View.OnLongClickListener;

/* renamed from: cm.aptoide.pt.home.q */
/* compiled from: lambda */
public final /* synthetic */ class C3915q implements OnLongClickListener {

    /* renamed from: a */
    private final /* synthetic */ EditorialBundleViewHolder f7371a;

    /* renamed from: b */
    private final /* synthetic */ String f7372b;

    /* renamed from: c */
    private final /* synthetic */ String f7373c;

    /* renamed from: d */
    private final /* synthetic */ HomeBundle f7374d;

    /* renamed from: e */
    private final /* synthetic */ int f7375e;

    public /* synthetic */ C3915q(EditorialBundleViewHolder editorialBundleViewHolder, String str, String str2, HomeBundle homeBundle, int i) {
        this.f7371a = editorialBundleViewHolder;
        this.f7372b = str;
        this.f7373c = str2;
        this.f7374d = homeBundle;
        this.f7375e = i;
    }

    public final boolean onLongClick(View view) {
        return this.f7371a.mo14258b(this.f7372b, this.f7373c, this.f7374d, this.f7375e, view);
    }
}
