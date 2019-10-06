package p005cm.aptoide.p006pt.store.view;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;

/* renamed from: cm.aptoide.pt.store.view.Y */
/* compiled from: lambda */
public final /* synthetic */ class C4977Y implements OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ GridStoreMetaWidget f8630a;

    /* renamed from: b */
    private final /* synthetic */ GridStoreMetaDisplayable f8631b;

    /* renamed from: c */
    private final /* synthetic */ FragmentNavigator f8632c;

    /* renamed from: d */
    private final /* synthetic */ Resources f8633d;

    public /* synthetic */ C4977Y(GridStoreMetaWidget gridStoreMetaWidget, GridStoreMetaDisplayable gridStoreMetaDisplayable, FragmentNavigator fragmentNavigator, Resources resources) {
        this.f8630a = gridStoreMetaWidget;
        this.f8631b = gridStoreMetaDisplayable;
        this.f8632c = fragmentNavigator;
        this.f8633d = resources;
    }

    public final void onClick(View view) {
        this.f8630a.mo16535a(this.f8631b, this.f8632c, this.f8633d, view);
    }
}
