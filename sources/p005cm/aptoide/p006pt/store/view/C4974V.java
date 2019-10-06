package p005cm.aptoide.p006pt.store.view;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;

/* renamed from: cm.aptoide.pt.store.view.V */
/* compiled from: lambda */
public final /* synthetic */ class C4974V implements OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ GridStoreMetaWidget f8622a;

    /* renamed from: b */
    private final /* synthetic */ GridStoreMetaDisplayable f8623b;

    /* renamed from: c */
    private final /* synthetic */ Resources f8624c;

    /* renamed from: d */
    private final /* synthetic */ FragmentNavigator f8625d;

    public /* synthetic */ C4974V(GridStoreMetaWidget gridStoreMetaWidget, GridStoreMetaDisplayable gridStoreMetaDisplayable, Resources resources, FragmentNavigator fragmentNavigator) {
        this.f8622a = gridStoreMetaWidget;
        this.f8623b = gridStoreMetaDisplayable;
        this.f8624c = resources;
        this.f8625d = fragmentNavigator;
    }

    public final void onClick(View view) {
        this.f8622a.mo16534a(this.f8623b, this.f8624c, this.f8625d, view);
    }
}
