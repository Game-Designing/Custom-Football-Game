package p005cm.aptoide.p006pt.store.view;

import android.content.SharedPreferences;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetStoreWidgets.WSWidget;
import p005cm.aptoide.p006pt.store.view.StoreGridHeaderDisplayable.Model;
import p026rx.p027b.C0129b;

/* renamed from: cm.aptoide.pt.store.view.ya */
/* compiled from: lambda */
public final /* synthetic */ class C5099ya implements C0129b {

    /* renamed from: a */
    private final /* synthetic */ WSWidget f8818a;

    /* renamed from: b */
    private final /* synthetic */ Model f8819b;

    /* renamed from: c */
    private final /* synthetic */ SharedPreferences f8820c;

    /* renamed from: d */
    private final /* synthetic */ StoreGridHeaderDisplayable f8821d;

    public /* synthetic */ C5099ya(WSWidget wSWidget, Model model, SharedPreferences sharedPreferences, StoreGridHeaderDisplayable storeGridHeaderDisplayable) {
        this.f8818a = wSWidget;
        this.f8819b = model;
        this.f8820c = sharedPreferences;
        this.f8821d = storeGridHeaderDisplayable;
    }

    public final void call(Object obj) {
        StoreGridHeaderWidget.m9345a(this.f8818a, this.f8819b, this.f8820c, this.f8821d, (Void) obj);
    }
}
