package android.support.p001v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.p000v4.view.C0587I;
import android.support.p001v7.view.menu.C0873l.C0874a;
import android.support.p001v7.view.menu.C0890v.C0891a;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.Window.Callback;

/* renamed from: android.support.v7.widget.U */
/* compiled from: DecorToolbar */
public interface C1021U {
    /* renamed from: a */
    C0587I mo8316a(int i, long j);

    /* renamed from: a */
    void mo8317a(int i);

    /* renamed from: a */
    void mo8318a(Drawable drawable);

    /* renamed from: a */
    void mo8319a(C0891a aVar, C0874a aVar2);

    /* renamed from: a */
    void mo8320a(C1004Sa sa);

    /* renamed from: a */
    void mo8321a(Menu menu, C0891a aVar);

    /* renamed from: a */
    void mo8322a(boolean z);

    /* renamed from: a */
    boolean mo8323a();

    /* renamed from: b */
    void mo8324b(int i);

    /* renamed from: b */
    void mo8325b(boolean z);

    /* renamed from: b */
    boolean mo8326b();

    /* renamed from: c */
    void mo8327c(int i);

    /* renamed from: c */
    boolean mo8328c();

    void collapseActionView();

    /* renamed from: d */
    boolean mo8330d();

    /* renamed from: e */
    void mo8331e();

    /* renamed from: f */
    boolean mo8332f();

    /* renamed from: g */
    boolean mo8333g();

    Context getContext();

    CharSequence getTitle();

    /* renamed from: h */
    Menu mo8336h();

    /* renamed from: i */
    int mo8337i();

    /* renamed from: j */
    ViewGroup mo8338j();

    /* renamed from: k */
    void mo8339k();

    /* renamed from: l */
    void mo8340l();

    /* renamed from: m */
    int mo8341m();

    /* renamed from: n */
    void mo8342n();

    void setIcon(int i);

    void setIcon(Drawable drawable);

    void setTitle(CharSequence charSequence);

    void setWindowCallback(Callback callback);

    void setWindowTitle(CharSequence charSequence);
}
