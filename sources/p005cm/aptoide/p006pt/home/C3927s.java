package p005cm.aptoide.p006pt.home;

import p005cm.aptoide.p006pt.reactions.p078ui.ReactionsPopup;
import p005cm.aptoide.p006pt.reactions.p078ui.ReactionsPopup.OnDismissListener;
import p005cm.aptoide.p006pt.reactions.p078ui.ReactionsView;

/* renamed from: cm.aptoide.pt.home.s */
/* compiled from: lambda */
public final /* synthetic */ class C3927s implements OnDismissListener {

    /* renamed from: a */
    private final /* synthetic */ EditorialBundleViewHolder f7392a;

    /* renamed from: b */
    private final /* synthetic */ String f7393b;

    /* renamed from: c */
    private final /* synthetic */ String f7394c;

    /* renamed from: d */
    private final /* synthetic */ int f7395d;

    /* renamed from: e */
    private final /* synthetic */ ReactionsPopup f7396e;

    public /* synthetic */ C3927s(EditorialBundleViewHolder editorialBundleViewHolder, String str, String str2, int i, ReactionsPopup reactionsPopup) {
        this.f7392a = editorialBundleViewHolder;
        this.f7393b = str;
        this.f7394c = str2;
        this.f7395d = i;
        this.f7396e = reactionsPopup;
    }

    public final void onDismiss(ReactionsView reactionsView) {
        this.f7392a.mo14256a(this.f7393b, this.f7394c, this.f7395d, this.f7396e, reactionsView);
    }
}
