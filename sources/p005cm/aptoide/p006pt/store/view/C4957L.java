package p005cm.aptoide.p006pt.store.view;

import android.content.Context;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.store.view.L */
/* compiled from: lambda */
public final /* synthetic */ class C4957L implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ GridStoreMetaDisplayable f8610a;

    /* renamed from: b */
    private final /* synthetic */ AptoideAccountManager f8611b;

    /* renamed from: c */
    private final /* synthetic */ Context f8612c;

    public /* synthetic */ C4957L(GridStoreMetaDisplayable gridStoreMetaDisplayable, AptoideAccountManager aptoideAccountManager, Context context) {
        this.f8610a = gridStoreMetaDisplayable;
        this.f8611b = aptoideAccountManager;
        this.f8612c = context;
    }

    public final Object call(Object obj) {
        return this.f8610a.mo16504a(this.f8611b, this.f8612c, (Boolean) obj);
    }
}
