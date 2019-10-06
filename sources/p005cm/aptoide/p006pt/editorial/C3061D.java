package p005cm.aptoide.p006pt.editorial;

import android.view.View;
import android.view.View.OnClickListener;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Obb;

/* renamed from: cm.aptoide.pt.editorial.D */
/* compiled from: lambda */
public final /* synthetic */ class C3061D implements OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ EditorialItemsViewHolder f6391a;

    /* renamed from: b */
    private final /* synthetic */ String f6392b;

    /* renamed from: c */
    private final /* synthetic */ String f6393c;

    /* renamed from: d */
    private final /* synthetic */ String f6394d;

    /* renamed from: e */
    private final /* synthetic */ String f6395e;

    /* renamed from: f */
    private final /* synthetic */ String f6396f;

    /* renamed from: g */
    private final /* synthetic */ int f6397g;

    /* renamed from: h */
    private final /* synthetic */ String f6398h;

    /* renamed from: i */
    private final /* synthetic */ String f6399i;

    /* renamed from: j */
    private final /* synthetic */ Obb f6400j;

    /* renamed from: k */
    private final /* synthetic */ long f6401k;

    public /* synthetic */ C3061D(EditorialItemsViewHolder editorialItemsViewHolder, String str, String str2, String str3, String str4, String str5, int i, String str6, String str7, Obb obb, long j) {
        this.f6391a = editorialItemsViewHolder;
        this.f6392b = str;
        this.f6393c = str2;
        this.f6394d = str3;
        this.f6395e = str4;
        this.f6396f = str5;
        this.f6397g = i;
        this.f6398h = str6;
        this.f6399i = str7;
        this.f6400j = obb;
        this.f6401k = j;
    }

    public final void onClick(View view) {
        this.f6391a.mo13847c(this.f6392b, this.f6393c, this.f6394d, this.f6395e, this.f6396f, this.f6397g, this.f6398h, this.f6399i, this.f6400j, this.f6401k, view);
    }
}
