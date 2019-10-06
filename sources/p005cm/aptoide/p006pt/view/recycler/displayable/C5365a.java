package p005cm.aptoide.p006pt.view.recycler.displayable;

import android.content.res.Resources;
import android.view.WindowManager;
import java.util.List;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetStoreWidgets.WSWidget;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.StoreContext;
import p005cm.aptoide.p006pt.store.StoreAnalytics;
import p005cm.aptoide.p006pt.store.view.StoreTabNavigator;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.view.recycler.displayable.a */
/* compiled from: lambda */
public final /* synthetic */ class C5365a implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ WSWidget f9169a;

    /* renamed from: b */
    private final /* synthetic */ StoreAnalytics f9170b;

    /* renamed from: c */
    private final /* synthetic */ String f9171c;

    /* renamed from: d */
    private final /* synthetic */ String f9172d;

    /* renamed from: e */
    private final /* synthetic */ StoreContext f9173e;

    /* renamed from: f */
    private final /* synthetic */ StoreTabNavigator f9174f;

    /* renamed from: g */
    private final /* synthetic */ NavigationTracker f9175g;

    /* renamed from: h */
    private final /* synthetic */ WindowManager f9176h;

    /* renamed from: i */
    private final /* synthetic */ Resources f9177i;

    public /* synthetic */ C5365a(WSWidget wSWidget, StoreAnalytics storeAnalytics, String str, String str2, StoreContext storeContext, StoreTabNavigator storeTabNavigator, NavigationTracker navigationTracker, WindowManager windowManager, Resources resources) {
        this.f9169a = wSWidget;
        this.f9170b = storeAnalytics;
        this.f9171c = str;
        this.f9172d = str2;
        this.f9173e = storeContext;
        this.f9174f = storeTabNavigator;
        this.f9175g = navigationTracker;
        this.f9176h = windowManager;
        this.f9177i = resources;
    }

    public final Object call(Object obj) {
        return DisplayablesFactory.m9634a(this.f9169a, this.f9170b, this.f9171c, this.f9172d, this.f9173e, this.f9174f, this.f9175g, this.f9176h, this.f9177i, (List) obj);
    }
}
