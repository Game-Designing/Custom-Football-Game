package p019d.p143b.p144a.p146b;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import p019d.p143b.p144a.p147c.C7043Ac;
import p019d.p143b.p144a.p147c.C7086Lb;
import p019d.p143b.p144a.p147c.C7212tb;
import p019d.p143b.p150d.C7262l;
import p019d.p143b.p150d.C7267q;
import p019d.p143b.p150d.C7269s;

/* renamed from: d.b.a.b.v */
class C7030v extends Dialog implements C7028u {

    /* renamed from: a */
    private final Activity f13112a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C7267q f13113b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C7262l f13114c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final C6957Ga f13115d;

    /* renamed from: e */
    private final C7043Ac f13116e;

    /* renamed from: f */
    private final String f13117f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public RelativeLayout f13118g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public C7016o f13119h;

    C7030v(C7043Ac ac, String str, C6957Ga ga, Activity activity, C7267q qVar) {
        super(activity, 16973840);
        if (ac == null) {
            throw new IllegalArgumentException("No ad specified");
        } else if (ga == null) {
            throw new IllegalArgumentException("No main view specified");
        } else if (qVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else if (activity != null) {
            this.f13113b = qVar;
            this.f13114c = qVar.mo23049b();
            this.f13112a = activity;
            this.f13115d = ga;
            this.f13116e = ac;
            this.f13117f = str;
            requestWindowFeature(1);
            setCancelable(false);
        } else {
            throw new IllegalArgumentException("No activity specified");
        }
    }

    /* renamed from: a */
    private int m14550a(int i) {
        return C7269s.m15812a((Context) this.f13112a, i);
    }

    /* renamed from: a */
    private void m14552a(C7018p pVar) {
        if (this.f13119h != null) {
            this.f13114c.mo22913a("ExpandedAdDialog", "Attempting to create duplicate close button");
            return;
        }
        this.f13119h = C7016o.m14497a(this.f13113b, getContext(), pVar);
        this.f13119h.setVisibility(8);
        this.f13119h.setOnClickListener(new C7038z(this));
        this.f13119h.setClickable(false);
        C7212tb tbVar = new C7212tb(this.f13113b);
        int a = m14550a(tbVar.mo23321s());
        LayoutParams layoutParams = new LayoutParams(a, a);
        layoutParams.addRule(10);
        int i = 9;
        layoutParams.addRule(tbVar.mo23324v() ? 9 : 11);
        this.f13119h.mo22636a(a);
        int a2 = m14550a(tbVar.mo23323u());
        int a3 = m14550a(tbVar.mo23322t());
        layoutParams.setMargins(a3, a2, a3, 0);
        this.f13118g.addView(this.f13119h, layoutParams);
        this.f13119h.bringToFront();
        int a4 = m14550a(tbVar.mo23325w());
        View view = new View(this.f13112a);
        view.setBackgroundColor(0);
        int i2 = a + a4;
        LayoutParams layoutParams2 = new LayoutParams(i2, i2);
        layoutParams2.addRule(10);
        if (!tbVar.mo23324v()) {
            i = 11;
        }
        layoutParams2.addRule(i);
        layoutParams2.setMargins(a3 - m14550a(5), a2 - m14550a(5), a3 - m14550a(5), 0);
        view.setOnClickListener(new C6944A(this));
        this.f13118g.addView(view, layoutParams2);
        view.bringToFront();
    }

    /* renamed from: b */
    private void m14554b() {
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.f13115d.setLayoutParams(layoutParams);
        this.f13118g = new RelativeLayout(this.f13112a);
        this.f13118g.setLayoutParams(new LayoutParams(-1, -1));
        this.f13118g.setBackgroundColor(-1157627904);
        this.f13118g.addView(this.f13115d);
        if (!this.f13116e.mo22745ta()) {
            m14552a(this.f13116e.mo22746ua());
            m14557d();
        }
        setContentView(this.f13118g);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m14555c() {
        this.f13115d.mo22532a("javascript:al_onCloseTapped();", (Runnable) new C7032w(this));
    }

    /* renamed from: d */
    private void m14557d() {
        this.f13112a.runOnUiThread(new C6946B(this));
    }

    /* renamed from: a */
    public C7043Ac mo22713a() {
        return this.f13116e;
    }

    public void dismiss() {
        C7086Lb c = this.f13115d.mo22534c();
        if (c != null) {
            c.mo22891e();
        }
        this.f13112a.runOnUiThread(new C7036y(this));
    }

    public void onBackPressed() {
        this.f13115d.mo22532a("javascript:al_onBackPressed();", (Runnable) new C7034x(this));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m14554b();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        String str = "ExpandedAdDialog";
        super.onStart();
        try {
            Window window = getWindow();
            if (window != null) {
                window.setFlags(this.f13112a.getWindow().getAttributes().flags, this.f13112a.getWindow().getAttributes().flags);
                if (this.f13116e.mo23441w()) {
                    window.addFlags(16777216);
                    return;
                }
                return;
            }
            this.f13114c.mo22916b(str, "Unable to turn on hardware acceleration - window is null");
        } catch (Throwable th) {
            this.f13114c.mo22917b(str, "Setting window flags failed.", th);
        }
    }
}
