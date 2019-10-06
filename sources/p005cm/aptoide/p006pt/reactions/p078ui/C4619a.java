package p005cm.aptoide.p006pt.reactions.p078ui;

import android.view.View;
import android.view.View.OnClickListener;
import p005cm.aptoide.p006pt.reactions.p078ui.ReactionsView.Callback;

/* renamed from: cm.aptoide.pt.reactions.ui.a */
/* compiled from: lambda */
public final /* synthetic */ class C4619a implements OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ Reaction f8258a;

    /* renamed from: b */
    private final /* synthetic */ Callback f8259b;

    public /* synthetic */ C4619a(Reaction reaction, Callback callback) {
        this.f8258a = reaction;
        this.f8259b = callback;
    }

    public final void onClick(View view) {
        this.f8258a.mo15900a(this.f8259b, view);
    }
}
