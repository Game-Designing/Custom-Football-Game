package p005cm.aptoide.p006pt.editorial;

import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: cm.aptoide.pt.editorial.E */
/* compiled from: lambda */
public final /* synthetic */ class C3064E implements OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ EditorialItemsViewHolder f6405a;

    /* renamed from: b */
    private final /* synthetic */ long f6406b;

    /* renamed from: c */
    private final /* synthetic */ String f6407c;

    public /* synthetic */ C3064E(EditorialItemsViewHolder editorialItemsViewHolder, long j, String str) {
        this.f6405a = editorialItemsViewHolder;
        this.f6406b = j;
        this.f6407c = str;
    }

    public final void onClick(View view) {
        this.f6405a.mo13842a(this.f6406b, this.f6407c, view);
    }
}
