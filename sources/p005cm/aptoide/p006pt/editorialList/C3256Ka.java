package p005cm.aptoide.p006pt.editorialList;

import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.EditorialListResponse;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.editorialList.Ka */
/* compiled from: lambda */
public final /* synthetic */ class C3256Ka implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ EditorialListService f6633a;

    public /* synthetic */ C3256Ka(EditorialListService editorialListService) {
        this.f6633a = editorialListService;
    }

    public final Object call(Object obj) {
        return this.f6633a.mapEditorialList((EditorialListResponse) obj);
    }
}
