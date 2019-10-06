package p005cm.aptoide.p006pt.editorialList;

import p005cm.aptoide.p006pt.reactions.network.LoadReactionModel;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.editorialList.o */
/* compiled from: lambda */
public final /* synthetic */ class C3304o implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ EditorialListManager f6683a;

    /* renamed from: b */
    private final /* synthetic */ LoadReactionModel f6684b;

    /* renamed from: c */
    private final /* synthetic */ String f6685c;

    public /* synthetic */ C3304o(EditorialListManager editorialListManager, LoadReactionModel loadReactionModel, String str) {
        this.f6683a = editorialListManager;
        this.f6684b = loadReactionModel;
        this.f6685c = str;
    }

    public final Object call(Object obj) {
        return this.f6683a.mo14089a(this.f6684b, this.f6685c, (EditorialListViewModel) obj);
    }
}
