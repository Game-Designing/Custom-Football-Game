package p005cm.aptoide.p006pt.comments.view;

import android.support.p000v4.app.C0486t;
import android.view.View;
import p005cm.aptoide.accountmanager.Account;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Comment;
import p026rx.C0120S;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.comments.view.ga */
/* compiled from: lambda */
public final /* synthetic */ class C2693ga implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ CommentListAdapter f5877a;

    /* renamed from: b */
    private final /* synthetic */ long f5878b;

    /* renamed from: c */
    private final /* synthetic */ Comment f5879c;

    /* renamed from: d */
    private final /* synthetic */ String f5880d;

    /* renamed from: e */
    private final /* synthetic */ C0486t f5881e;

    /* renamed from: f */
    private final /* synthetic */ C0120S f5882f;

    /* renamed from: g */
    private final /* synthetic */ View f5883g;

    public /* synthetic */ C2693ga(CommentListAdapter commentListAdapter, long j, Comment comment, String str, C0486t tVar, C0120S s, View view) {
        this.f5877a = commentListAdapter;
        this.f5878b = j;
        this.f5879c = comment;
        this.f5880d = str;
        this.f5881e = tVar;
        this.f5882f = s;
        this.f5883g = view;
    }

    public final Object call(Object obj) {
        return this.f5877a.mo11632a(this.f5878b, this.f5879c, this.f5880d, this.f5881e, this.f5882f, this.f5883g, (Account) obj);
    }
}
