package p005cm.aptoide.p006pt.app.view;

import p005cm.aptoide.p006pt.dataprovider.interfaces.SuccessRequestListener;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.listapp.ListAppVersions;

/* renamed from: cm.aptoide.pt.app.view.li */
/* compiled from: lambda */
public final /* synthetic */ class C2140li implements SuccessRequestListener {

    /* renamed from: a */
    private final /* synthetic */ OtherVersionsFragment f5203a;

    public /* synthetic */ C2140li(OtherVersionsFragment otherVersionsFragment) {
        this.f5203a = otherVersionsFragment;
    }

    public final void call(Object obj) {
        this.f5203a.mo10850a((ListAppVersions) obj);
    }
}
