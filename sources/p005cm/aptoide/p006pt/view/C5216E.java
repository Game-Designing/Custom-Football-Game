package p005cm.aptoide.p006pt.view;

import java.util.List;
import p005cm.aptoide.p006pt.database.realm.Store;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.view.E */
/* compiled from: lambda */
public final /* synthetic */ class C5216E implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ List f8987a;

    public /* synthetic */ C5216E(List list) {
        this.f8987a = list;
    }

    public final Object call(Object obj) {
        List list = this.f8987a;
        DeepLinkManager.m9498a(list, (Store) obj);
        return list;
    }
}
