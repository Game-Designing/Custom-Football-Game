package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7;

import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetAppMeta;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetStoreWidgets.WSWidget;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.p */
/* compiled from: lambda */
public final /* synthetic */ class C2909p implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ WSWidget f6185a;

    public /* synthetic */ C2909p(WSWidget wSWidget) {
        this.f6185a = wSWidget;
    }

    public final Object call(Object obj) {
        WSWidget wSWidget = this.f6185a;
        WSWidgetsUtils.m7506b(wSWidget, (GetAppMeta) obj);
        return wSWidget;
    }
}
