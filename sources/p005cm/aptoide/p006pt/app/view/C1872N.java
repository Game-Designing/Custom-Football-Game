package p005cm.aptoide.p006pt.app.view;

import android.view.View;
import android.view.View.OnClickListener;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store;
import p005cm.aptoide.p006pt.view.app.AppMedia;

/* renamed from: cm.aptoide.pt.app.view.N */
/* compiled from: lambda */
public final /* synthetic */ class C1872N implements OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ AppViewFragment f4880a;

    /* renamed from: b */
    private final /* synthetic */ String f4881b;

    /* renamed from: c */
    private final /* synthetic */ AppMedia f4882c;

    /* renamed from: d */
    private final /* synthetic */ Store f4883d;

    public /* synthetic */ C1872N(AppViewFragment appViewFragment, String str, AppMedia appMedia, Store store) {
        this.f4880a = appViewFragment;
        this.f4881b = str;
        this.f4882c = appMedia;
        this.f4883d = store;
    }

    public final void onClick(View view) {
        this.f4880a.mo10412a(this.f4881b, this.f4882c, this.f4883d, view);
    }
}
