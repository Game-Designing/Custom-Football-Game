package p005cm.aptoide.p006pt.app.view;

import p005cm.aptoide.p006pt.app.AppViewViewModel;
import p005cm.aptoide.p006pt.view.app.FlagsVote.VoteType;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.app.view.oa */
/* compiled from: lambda */
public final /* synthetic */ class C2162oa implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ AppViewPresenter f5227a;

    /* renamed from: b */
    private final /* synthetic */ VoteType f5228b;

    public /* synthetic */ C2162oa(AppViewPresenter appViewPresenter, VoteType voteType) {
        this.f5227a = appViewPresenter;
        this.f5228b = voteType;
    }

    public final Object call(Object obj) {
        return this.f5227a.mo10602a(this.f5228b, (AppViewViewModel) obj);
    }
}
