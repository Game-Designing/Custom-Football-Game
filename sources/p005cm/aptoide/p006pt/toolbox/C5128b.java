package p005cm.aptoide.p006pt.toolbox;

import android.content.Context;
import java.util.Map.Entry;

/* renamed from: cm.aptoide.pt.toolbox.b */
/* compiled from: lambda */
public final /* synthetic */ class C5128b implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ Context f8862a;

    /* renamed from: b */
    private final /* synthetic */ Entry f8863b;

    public /* synthetic */ C5128b(Context context, Entry entry) {
        this.f8862a = context;
        this.f8863b = entry;
    }

    public final void run() {
        ToolboxContentProvider.m9435a(this.f8862a, this.f8863b);
    }
}
