package p005cm.aptoide.p006pt.store.view;

import android.view.View;
import android.view.View.OnClickListener;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store.SocialChannel;

/* renamed from: cm.aptoide.pt.store.view.ia */
/* compiled from: lambda */
public final /* synthetic */ class C5022ia implements OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ MetaStoresBaseWidget f8702a;

    /* renamed from: b */
    private final /* synthetic */ SocialChannel f8703b;

    public /* synthetic */ C5022ia(MetaStoresBaseWidget metaStoresBaseWidget, SocialChannel socialChannel) {
        this.f8702a = metaStoresBaseWidget;
        this.f8703b = socialChannel;
    }

    public final void onClick(View view) {
        this.f8702a.mo16566a(this.f8703b, view);
    }
}
