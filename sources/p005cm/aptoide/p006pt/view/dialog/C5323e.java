package p005cm.aptoide.p006pt.view.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.support.design.widget.TextInputLayout;
import android.support.p001v7.widget.AppCompatRatingBar;
import android.view.View;
import android.view.View.OnClickListener;
import p026rx.C14980ia;

/* renamed from: cm.aptoide.pt.view.dialog.e */
/* compiled from: lambda */
public final /* synthetic */ class C5323e implements OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ DialogUtils f9100a;

    /* renamed from: b */
    private final /* synthetic */ Activity f9101b;

    /* renamed from: c */
    private final /* synthetic */ TextInputLayout f9102c;

    /* renamed from: d */
    private final /* synthetic */ AppCompatRatingBar f9103d;

    /* renamed from: e */
    private final /* synthetic */ View f9104e;

    /* renamed from: f */
    private final /* synthetic */ AlertDialog f9105f;

    /* renamed from: g */
    private final /* synthetic */ C14980ia f9106g;

    /* renamed from: h */
    private final /* synthetic */ String f9107h;

    /* renamed from: i */
    private final /* synthetic */ String f9108i;

    public /* synthetic */ C5323e(DialogUtils dialogUtils, Activity activity, TextInputLayout textInputLayout, AppCompatRatingBar appCompatRatingBar, View view, AlertDialog alertDialog, C14980ia iaVar, String str, String str2) {
        this.f9100a = dialogUtils;
        this.f9101b = activity;
        this.f9102c = textInputLayout;
        this.f9103d = appCompatRatingBar;
        this.f9104e = view;
        this.f9105f = alertDialog;
        this.f9106g = iaVar;
        this.f9107h = str;
        this.f9108i = str2;
    }

    public final void onClick(View view) {
        this.f9100a.mo17170a(this.f9101b, this.f9102c, this.f9103d, this.f9104e, this.f9105f, this.f9106g, this.f9107h, this.f9108i, view);
    }
}
