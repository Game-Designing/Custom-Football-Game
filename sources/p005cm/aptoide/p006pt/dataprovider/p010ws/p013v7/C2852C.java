package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7;

import android.util.Pair;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetStoreWidgets.WSWidget;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.ListComments;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseRequestWithStore.StoreCredentials;
import p026rx.p027b.C0129b;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.C */
/* compiled from: lambda */
public final /* synthetic */ class C2852C implements C0129b {

    /* renamed from: a */
    private final /* synthetic */ WSWidget f6107a;

    /* renamed from: b */
    private final /* synthetic */ StoreCredentials f6108b;

    public /* synthetic */ C2852C(WSWidget wSWidget, StoreCredentials storeCredentials) {
        this.f6107a = wSWidget;
        this.f6108b = storeCredentials;
    }

    public final void call(Object obj) {
        this.f6107a.setViewObject(new Pair((ListComments) obj, this.f6108b));
    }
}
