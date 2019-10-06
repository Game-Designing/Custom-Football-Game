package p005cm.aptoide.p006pt.notification.view;

import android.view.View;
import android.view.View.OnClickListener;
import p005cm.aptoide.p006pt.notification.AptoideNotification;

/* renamed from: cm.aptoide.pt.notification.view.o */
/* compiled from: lambda */
public final /* synthetic */ class C4247o implements OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ InboxViewHolder f7823a;

    /* renamed from: b */
    private final /* synthetic */ AptoideNotification f7824b;

    public /* synthetic */ C4247o(InboxViewHolder inboxViewHolder, AptoideNotification aptoideNotification) {
        this.f7823a = inboxViewHolder;
        this.f7824b = aptoideNotification;
    }

    public final void onClick(View view) {
        this.f7823a.mo15338a(this.f7824b, view);
    }
}
