package p005cm.aptoide.p006pt.view.dialog;

import android.app.Activity;
import android.view.View;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;

/* renamed from: cm.aptoide.pt.view.dialog.f */
/* compiled from: lambda */
public final /* synthetic */ class C5324f implements OnRatingBarChangeListener {

    /* renamed from: a */
    private final /* synthetic */ View f9109a;

    /* renamed from: b */
    private final /* synthetic */ Activity f9110b;

    public /* synthetic */ C5324f(View view, Activity activity) {
        this.f9109a = view;
        this.f9110b = activity;
    }

    public final void onRatingChanged(RatingBar ratingBar, float f, boolean z) {
        DialogUtils.m9603a(this.f9109a, this.f9110b, ratingBar, f, z);
    }
}
