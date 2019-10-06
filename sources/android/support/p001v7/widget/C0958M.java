package android.support.p001v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

/* renamed from: android.support.v7.widget.M */
/* compiled from: CardViewApi21Impl */
class C0958M implements C0967Q {
    C0958M() {
    }

    /* renamed from: a */
    public void mo7417a(C0965P cardView, Context context, ColorStateList backgroundColor, float radius, float elevation, float maxElevation) {
        cardView.mo7339a(new C0961Na(backgroundColor, radius));
        View view = cardView.mo7343d();
        view.setClipToOutline(true);
        view.setElevation(elevation);
        mo7420b(cardView, maxElevation);
    }

    /* renamed from: c */
    public void mo7422c(C0965P cardView, float radius) {
        m4602j(cardView).mo7474a(radius);
    }

    /* renamed from: a */
    public void mo7348a() {
    }

    /* renamed from: b */
    public void mo7420b(C0965P cardView, float maxElevation) {
        m4602j(cardView).mo7475a(maxElevation, cardView.mo7340a(), cardView.mo7342c());
        mo7428i(cardView);
    }

    /* renamed from: d */
    public float mo7423d(C0965P cardView) {
        return m4602j(cardView).mo7477b();
    }

    /* renamed from: c */
    public float mo7421c(C0965P cardView) {
        return mo7426g(cardView) * 2.0f;
    }

    /* renamed from: a */
    public float mo7415a(C0965P cardView) {
        return mo7426g(cardView) * 2.0f;
    }

    /* renamed from: g */
    public float mo7426g(C0965P cardView) {
        return m4602j(cardView).mo7478c();
    }

    /* renamed from: a */
    public void mo7416a(C0965P cardView, float elevation) {
        cardView.mo7343d().setElevation(elevation);
    }

    /* renamed from: e */
    public float mo7424e(C0965P cardView) {
        return cardView.mo7343d().getElevation();
    }

    /* renamed from: i */
    public void mo7428i(C0965P cardView) {
        if (!cardView.mo7340a()) {
            cardView.mo7338a(0, 0, 0, 0);
            return;
        }
        float elevation = mo7423d(cardView);
        float radius = mo7426g(cardView);
        int hPadding = (int) Math.ceil((double) C0963Oa.m4646a(elevation, radius, cardView.mo7342c()));
        int vPadding = (int) Math.ceil((double) C0963Oa.m4649b(elevation, radius, cardView.mo7342c()));
        cardView.mo7338a(hPadding, vPadding, hPadding, vPadding);
    }

    /* renamed from: h */
    public void mo7427h(C0965P cardView) {
        mo7420b(cardView, mo7423d(cardView));
    }

    /* renamed from: b */
    public void mo7419b(C0965P cardView) {
        mo7420b(cardView, mo7423d(cardView));
    }

    /* renamed from: a */
    public void mo7418a(C0965P cardView, ColorStateList color) {
        m4602j(cardView).mo7476a(color);
    }

    /* renamed from: f */
    public ColorStateList mo7425f(C0965P cardView) {
        return m4602j(cardView).mo7473a();
    }

    /* renamed from: j */
    private C0961Na m4602j(C0965P cardView) {
        return (C0961Na) cardView.mo7341b();
    }
}
