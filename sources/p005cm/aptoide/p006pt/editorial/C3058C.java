package p005cm.aptoide.p006pt.editorial;

import android.view.View;
import android.view.View.OnClickListener;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Obb;

/* renamed from: cm.aptoide.pt.editorial.C */
/* compiled from: lambda */
public final /* synthetic */ class C3058C implements OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ EditorialItemsViewHolder f6377a;

    /* renamed from: b */
    private final /* synthetic */ String f6378b;

    /* renamed from: c */
    private final /* synthetic */ String f6379c;

    /* renamed from: d */
    private final /* synthetic */ String f6380d;

    /* renamed from: e */
    private final /* synthetic */ String f6381e;

    /* renamed from: f */
    private final /* synthetic */ String f6382f;

    /* renamed from: g */
    private final /* synthetic */ int f6383g;

    /* renamed from: h */
    private final /* synthetic */ String f6384h;

    /* renamed from: i */
    private final /* synthetic */ String f6385i;

    /* renamed from: j */
    private final /* synthetic */ Obb f6386j;

    /* renamed from: k */
    private final /* synthetic */ long f6387k;

    public /* synthetic */ C3058C(EditorialItemsViewHolder editorialItemsViewHolder, String str, String str2, String str3, String str4, String str5, int i, String str6, String str7, Obb obb, long j) {
        this.f6377a = editorialItemsViewHolder;
        this.f6378b = str;
        this.f6379c = str2;
        this.f6380d = str3;
        this.f6381e = str4;
        this.f6382f = str5;
        this.f6383g = i;
        this.f6384h = str6;
        this.f6385i = str7;
        this.f6386j = obb;
        this.f6387k = j;
    }

    public final void onClick(View view) {
        this.f6377a.mo13848d(this.f6378b, this.f6379c, this.f6380d, this.f6381e, this.f6382f, this.f6383g, this.f6384h, this.f6385i, this.f6386j, this.f6387k, view);
    }
}
