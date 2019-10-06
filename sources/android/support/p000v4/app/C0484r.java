package android.support.p000v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* renamed from: android.support.v4.app.r */
/* compiled from: FragmentController */
public class C0484r {

    /* renamed from: a */
    private final C0485s<?> f1613a;

    /* renamed from: a */
    public static C0484r m2425a(C0485s<?> callbacks) {
        return new C0484r(callbacks);
    }

    private C0484r(C0485s<?> callbacks) {
        this.f1613a = callbacks;
    }

    /* renamed from: k */
    public C0486t mo5222k() {
        return this.f1613a.mo5228d();
    }

    /* renamed from: a */
    public Fragment mo5200a(String who) {
        return this.f1613a.f1618e.mo4932b(who);
    }

    /* renamed from: a */
    public void mo5205a(Fragment parent) {
        C0485s<?> sVar = this.f1613a;
        sVar.f1618e.mo4923a((C0485s) sVar, (C0483q) sVar, parent);
    }

    /* renamed from: a */
    public View mo5201a(View parent, String name, Context context, AttributeSet attrs) {
        return this.f1613a.f1618e.onCreateView(parent, name, context, attrs);
    }

    /* renamed from: l */
    public void mo5223l() {
        this.f1613a.f1618e.mo4989v();
    }

    /* renamed from: n */
    public Parcelable mo5225n() {
        return this.f1613a.f1618e.mo4992y();
    }

    /* renamed from: a */
    public void mo5204a(Parcelable state, C0419B nonConfig) {
        this.f1613a.f1618e.mo4915a(state, nonConfig);
    }

    /* renamed from: m */
    public C0419B mo5224m() {
        return this.f1613a.f1618e.mo4991x();
    }

    /* renamed from: b */
    public void mo5210b() {
        this.f1613a.f1618e.mo4965i();
    }

    /* renamed from: a */
    public void mo5202a() {
        this.f1613a.f1618e.mo4962h();
    }

    /* renamed from: h */
    public void mo5219h() {
        this.f1613a.f1618e.mo4981p();
    }

    /* renamed from: g */
    public void mo5218g() {
        this.f1613a.f1618e.mo4977o();
    }

    /* renamed from: e */
    public void mo5216e() {
        this.f1613a.f1618e.mo4974m();
    }

    /* renamed from: i */
    public void mo5220i() {
        this.f1613a.f1618e.mo4983q();
    }

    /* renamed from: f */
    public void mo5217f() {
        this.f1613a.f1618e.mo4975n();
    }

    /* renamed from: c */
    public void mo5214c() {
        this.f1613a.f1618e.mo4967j();
    }

    /* renamed from: a */
    public void mo5207a(boolean isInMultiWindowMode) {
        this.f1613a.f1618e.mo4926a(isInMultiWindowMode);
    }

    /* renamed from: b */
    public void mo5211b(boolean isInPictureInPictureMode) {
        this.f1613a.f1618e.mo4939b(isInPictureInPictureMode);
    }

    /* renamed from: a */
    public void mo5203a(Configuration newConfig) {
        this.f1613a.f1618e.mo4913a(newConfig);
    }

    /* renamed from: d */
    public void mo5215d() {
        this.f1613a.f1618e.mo4971l();
    }

    /* renamed from: a */
    public boolean mo5208a(Menu menu, MenuInflater inflater) {
        return this.f1613a.f1618e.mo4927a(menu, inflater);
    }

    /* renamed from: b */
    public boolean mo5212b(Menu menu) {
        return this.f1613a.f1618e.mo4941b(menu);
    }

    /* renamed from: b */
    public boolean mo5213b(MenuItem item) {
        return this.f1613a.f1618e.mo4942b(item);
    }

    /* renamed from: a */
    public boolean mo5209a(MenuItem item) {
        return this.f1613a.f1618e.mo4928a(item);
    }

    /* renamed from: a */
    public void mo5206a(Menu menu) {
        this.f1613a.f1618e.mo4924a(menu);
    }

    /* renamed from: j */
    public boolean mo5221j() {
        return this.f1613a.f1618e.mo4985s();
    }
}
