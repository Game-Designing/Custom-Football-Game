package p005cm.aptoide.p006pt.store.view;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.List;
import p005cm.aptoide.p006pt.store.StoreTheme;

/* renamed from: cm.aptoide.pt.store.view.Z */
/* compiled from: lambda */
public final /* synthetic */ class C4978Z implements OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ GridStoreMetaWidget f8634a;

    /* renamed from: b */
    private final /* synthetic */ long f8635b;

    /* renamed from: c */
    private final /* synthetic */ StoreTheme f8636c;

    /* renamed from: d */
    private final /* synthetic */ String f8637d;

    /* renamed from: e */
    private final /* synthetic */ String f8638e;

    /* renamed from: f */
    private final /* synthetic */ String f8639f;

    /* renamed from: g */
    private final /* synthetic */ List f8640g;

    /* renamed from: h */
    private final /* synthetic */ int f8641h;

    public /* synthetic */ C4978Z(GridStoreMetaWidget gridStoreMetaWidget, long j, StoreTheme storeTheme, String str, String str2, String str3, List list, int i) {
        this.f8634a = gridStoreMetaWidget;
        this.f8635b = j;
        this.f8636c = storeTheme;
        this.f8637d = str;
        this.f8638e = str2;
        this.f8639f = str3;
        this.f8640g = list;
        this.f8641h = i;
    }

    public final void onClick(View view) {
        this.f8634a.mo16532a(this.f8635b, this.f8636c, this.f8637d, this.f8638e, this.f8639f, this.f8640g, this.f8641h, view);
    }
}
