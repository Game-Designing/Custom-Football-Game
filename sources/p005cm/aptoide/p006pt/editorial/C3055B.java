package p005cm.aptoide.p006pt.editorial;

import android.view.View;
import android.view.View.OnClickListener;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Obb;

/* renamed from: cm.aptoide.pt.editorial.B */
/* compiled from: lambda */
public final /* synthetic */ class C3055B implements OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ EditorialItemsViewHolder f6364a;

    /* renamed from: b */
    private final /* synthetic */ String f6365b;

    /* renamed from: c */
    private final /* synthetic */ String f6366c;

    /* renamed from: d */
    private final /* synthetic */ String f6367d;

    /* renamed from: e */
    private final /* synthetic */ String f6368e;

    /* renamed from: f */
    private final /* synthetic */ String f6369f;

    /* renamed from: g */
    private final /* synthetic */ int f6370g;

    /* renamed from: h */
    private final /* synthetic */ String f6371h;

    /* renamed from: i */
    private final /* synthetic */ String f6372i;

    /* renamed from: j */
    private final /* synthetic */ Obb f6373j;

    /* renamed from: k */
    private final /* synthetic */ long f6374k;

    public /* synthetic */ C3055B(EditorialItemsViewHolder editorialItemsViewHolder, String str, String str2, String str3, String str4, String str5, int i, String str6, String str7, Obb obb, long j) {
        this.f6364a = editorialItemsViewHolder;
        this.f6365b = str;
        this.f6366c = str2;
        this.f6367d = str3;
        this.f6368e = str4;
        this.f6369f = str5;
        this.f6370g = i;
        this.f6371h = str6;
        this.f6372i = str7;
        this.f6373j = obb;
        this.f6374k = j;
    }

    public final void onClick(View view) {
        this.f6364a.mo13846b(this.f6365b, this.f6366c, this.f6367d, this.f6368e, this.f6369f, this.f6370g, this.f6371h, this.f6372i, this.f6373j, this.f6374k, view);
    }
}
