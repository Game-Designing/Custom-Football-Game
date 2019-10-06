package p005cm.aptoide.p006pt.view.feedback;

import android.content.Intent;
import p005cm.aptoide.p006pt.database.realm.Installed;
import p026rx.p027b.C0129b;

/* renamed from: cm.aptoide.pt.view.feedback.c */
/* compiled from: lambda */
public final /* synthetic */ class C5340c implements C0129b {

    /* renamed from: a */
    private final /* synthetic */ SendFeedbackFragment f9139a;

    /* renamed from: b */
    private final /* synthetic */ Intent f9140b;

    /* renamed from: c */
    private final /* synthetic */ String f9141c;

    public /* synthetic */ C5340c(SendFeedbackFragment sendFeedbackFragment, Intent intent, String str) {
        this.f9139a = sendFeedbackFragment;
        this.f9140b = intent;
        this.f9141c = str;
    }

    public final void call(Object obj) {
        this.f9139a.mo17216a(this.f9140b, this.f9141c, (Installed) obj);
    }
}
