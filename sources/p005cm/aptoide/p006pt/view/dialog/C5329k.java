package p005cm.aptoide.p006pt.view.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.support.design.widget.TextInputLayout;
import android.support.p001v7.widget.AppCompatRatingBar;
import android.view.View;
import android.view.View.OnClickListener;
import p026rx.p027b.C0128a;

/* renamed from: cm.aptoide.pt.view.dialog.k */
/* compiled from: lambda */
public final /* synthetic */ class C5329k implements OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ DialogUtils f9115a;

    /* renamed from: b */
    private final /* synthetic */ Activity f9116b;

    /* renamed from: c */
    private final /* synthetic */ TextInputLayout f9117c;

    /* renamed from: d */
    private final /* synthetic */ AppCompatRatingBar f9118d;

    /* renamed from: e */
    private final /* synthetic */ AlertDialog f9119e;

    /* renamed from: f */
    private final /* synthetic */ C0128a f9120f;

    /* renamed from: g */
    private final /* synthetic */ String f9121g;

    /* renamed from: h */
    private final /* synthetic */ String f9122h;

    public /* synthetic */ C5329k(DialogUtils dialogUtils, Activity activity, TextInputLayout textInputLayout, AppCompatRatingBar appCompatRatingBar, AlertDialog alertDialog, C0128a aVar, String str, String str2) {
        this.f9115a = dialogUtils;
        this.f9116b = activity;
        this.f9117c = textInputLayout;
        this.f9118d = appCompatRatingBar;
        this.f9119e = alertDialog;
        this.f9120f = aVar;
        this.f9121g = str;
        this.f9122h = str2;
    }

    public final void onClick(View view) {
        this.f9115a.mo17169a(this.f9116b, this.f9117c, this.f9118d, this.f9119e, this.f9120f, this.f9121g, this.f9122h, view);
    }
}
