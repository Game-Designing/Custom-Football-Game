package p005cm.aptoide.p006pt.editorial;

import android.view.View;
import android.view.View.OnClickListener;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Obb;

/* renamed from: cm.aptoide.pt.editorial.A */
/* compiled from: lambda */
public final /* synthetic */ class C3052A implements OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ EditorialItemsViewHolder f6351a;

    /* renamed from: b */
    private final /* synthetic */ String f6352b;

    /* renamed from: c */
    private final /* synthetic */ String f6353c;

    /* renamed from: d */
    private final /* synthetic */ String f6354d;

    /* renamed from: e */
    private final /* synthetic */ String f6355e;

    /* renamed from: f */
    private final /* synthetic */ String f6356f;

    /* renamed from: g */
    private final /* synthetic */ int f6357g;

    /* renamed from: h */
    private final /* synthetic */ String f6358h;

    /* renamed from: i */
    private final /* synthetic */ String f6359i;

    /* renamed from: j */
    private final /* synthetic */ Obb f6360j;

    /* renamed from: k */
    private final /* synthetic */ long f6361k;

    public /* synthetic */ C3052A(EditorialItemsViewHolder editorialItemsViewHolder, String str, String str2, String str3, String str4, String str5, int i, String str6, String str7, Obb obb, long j) {
        this.f6351a = editorialItemsViewHolder;
        this.f6352b = str;
        this.f6353c = str2;
        this.f6354d = str3;
        this.f6355e = str4;
        this.f6356f = str5;
        this.f6357g = i;
        this.f6358h = str6;
        this.f6359i = str7;
        this.f6360j = obb;
        this.f6361k = j;
    }

    public final void onClick(View view) {
        this.f6351a.mo13845a(this.f6352b, this.f6353c, this.f6354d, this.f6355e, this.f6356f, this.f6357g, this.f6358h, this.f6359i, this.f6360j, this.f6361k, view);
    }
}
