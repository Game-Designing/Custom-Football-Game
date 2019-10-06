package p005cm.aptoide.p006pt.editorial;

import p005cm.aptoide.p006pt.reactions.data.ReactionType;
import p005cm.aptoide.p006pt.reactions.p078ui.ReactionsPopup;
import p005cm.aptoide.p006pt.reactions.p078ui.ReactionsPopup.OnReactionClickListener;

/* renamed from: cm.aptoide.pt.editorial.q */
/* compiled from: lambda */
public final /* synthetic */ class C3203q implements OnReactionClickListener {

    /* renamed from: a */
    private final /* synthetic */ EditorialFragment f6570a;

    /* renamed from: b */
    private final /* synthetic */ String f6571b;

    /* renamed from: c */
    private final /* synthetic */ String f6572c;

    /* renamed from: d */
    private final /* synthetic */ ReactionsPopup f6573d;

    public /* synthetic */ C3203q(EditorialFragment editorialFragment, String str, String str2, ReactionsPopup reactionsPopup) {
        this.f6570a = editorialFragment;
        this.f6571b = str;
        this.f6572c = str2;
        this.f6573d = reactionsPopup;
    }

    public final void onReactionItemClick(ReactionType reactionType) {
        this.f6570a.mo13791a(this.f6571b, this.f6572c, this.f6573d, reactionType);
    }
}
