package p005cm.aptoide.p006pt.home;

import p005cm.aptoide.p006pt.reactions.data.ReactionType;
import p005cm.aptoide.p006pt.reactions.p078ui.ReactionsPopup;
import p005cm.aptoide.p006pt.reactions.p078ui.ReactionsPopup.OnReactionClickListener;

/* renamed from: cm.aptoide.pt.home.r */
/* compiled from: lambda */
public final /* synthetic */ class C3921r implements OnReactionClickListener {

    /* renamed from: a */
    private final /* synthetic */ EditorialBundleViewHolder f7381a;

    /* renamed from: b */
    private final /* synthetic */ String f7382b;

    /* renamed from: c */
    private final /* synthetic */ String f7383c;

    /* renamed from: d */
    private final /* synthetic */ int f7384d;

    /* renamed from: e */
    private final /* synthetic */ ReactionsPopup f7385e;

    public /* synthetic */ C3921r(EditorialBundleViewHolder editorialBundleViewHolder, String str, String str2, int i, ReactionsPopup reactionsPopup) {
        this.f7381a = editorialBundleViewHolder;
        this.f7382b = str;
        this.f7383c = str2;
        this.f7384d = i;
        this.f7385e = reactionsPopup;
    }

    public final void onReactionItemClick(ReactionType reactionType) {
        this.f7381a.mo14255a(this.f7382b, this.f7383c, this.f7384d, this.f7385e, reactionType);
    }
}
