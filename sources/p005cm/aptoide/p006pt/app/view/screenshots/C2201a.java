package p005cm.aptoide.p006pt.app.view.screenshots;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.ArrayList;

/* renamed from: cm.aptoide.pt.app.view.screenshots.a */
/* compiled from: lambda */
public final /* synthetic */ class C2201a implements OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ ScreenshotViewHolder f5269a;

    /* renamed from: b */
    private final /* synthetic */ ArrayList f5270b;

    /* renamed from: c */
    private final /* synthetic */ int f5271c;

    public /* synthetic */ C2201a(ScreenshotViewHolder screenshotViewHolder, ArrayList arrayList, int i) {
        this.f5269a = screenshotViewHolder;
        this.f5270b = arrayList;
        this.f5271c = i;
    }

    public final void onClick(View view) {
        this.f5269a.mo11001a(this.f5270b, this.f5271c, view);
    }
}
