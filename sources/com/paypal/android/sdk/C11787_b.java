package com.paypal.android.sdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import p005cm.aptoide.p006pt.deprecated.tables.Repo;

/* renamed from: com.paypal.android.sdk._b */
public final class C11787_b {

    /* renamed from: a */
    private ViewGroup f37098a;

    /* renamed from: b */
    private ViewGroup f37099b;

    /* renamed from: c */
    private C11821fc f37100c;

    /* renamed from: d */
    private LinearLayout f37101d = C11715Da.m38772a(this.f37099b);

    /* renamed from: e */
    private TextView f37102e;

    /* renamed from: f */
    private LinearLayout f37103f;

    /* renamed from: g */
    private TextView f37104g;

    /* renamed from: h */
    private TextView f37105h;

    /* renamed from: i */
    private C11811ec f37106i;

    /* renamed from: j */
    private C11767Tb f37107j;

    /* renamed from: k */
    private C11821fc f37108k;

    /* renamed from: l */
    private C11841kc f37109l;

    /* renamed from: m */
    private C11841kc f37110m;

    /* renamed from: n */
    private C11795bc f37111n;

    public C11787_b(Context context, boolean z) {
        this.f37099b = C11715Da.m38769a(context);
        LinearLayout b = C11715Da.m38787b((ViewGroup) this.f37101d);
        this.f37102e = new TextView(context);
        String str = "0dip";
        C11715Da.m38781a(this.f37102e, str, str, str, "14dip");
        this.f37102e.setTextSize(24.0f);
        this.f37102e.setTextColor(C11711Ca.f36616e);
        b.addView(this.f37102e);
        C11715Da.m38777a((View) this.f37102e, -2, -2);
        this.f37100c = new C11821fc(context, Repo.COLUMN_DESCRIPTION);
        this.f37100c.f37208d.setTypeface(C11711Ca.f36609E);
        b.addView(this.f37100c.f37205a);
        C11715Da.m38775a((View) this.f37100c.f37205a);
        C11715Da.m38767a(b);
        if (z) {
            this.f37111n = new C11795bc(context);
            b.addView(this.f37111n.mo38704a());
            C11715Da.m38767a(b);
            this.f37109l = new C11841kc(context);
            b.addView(this.f37109l.mo38817a());
        } else {
            this.f37106i = new C11811ec(context);
            b.addView(this.f37106i.f37180a);
            C11715Da.m38775a((View) this.f37106i.f37180a);
            C11715Da.m38767a(b);
            this.f37108k = new C11821fc(context, "00 / 0000");
            b.addView(this.f37108k.f37205a);
            C11715Da.m38775a((View) this.f37108k.f37205a);
        }
        this.f37110m = new C11841kc(context);
        this.f37110m.mo38818a(context, new C11825gc());
        b.addView(this.f37110m.mo38817a());
        this.f37104g = new TextView(context);
        this.f37104g.setId(43002);
        C11715Da.m38790b(this.f37104g);
        b.addView(this.f37104g);
        C11715Da.m38777a((View) this.f37104g, -1, -2);
        C11715Da.m38789b(this.f37104g, null, "20dip", null, "10dip");
        this.f37104g.setVisibility(8);
        this.f37103f = C11715Da.m38771a(context, true, 43001, b);
        this.f37105h = new TextView(context);
        C11715Da.m38784a(this.f37105h);
        this.f37105h.setText("init");
        this.f37103f.addView(this.f37105h);
        this.f37107j = new C11767Tb(context);
        this.f37101d.addView(this.f37107j.f37034a);
        C11715Da.m38777a((View) this.f37107j.f37034a, -2, -2);
        C11715Da.m38776a((View) this.f37107j.f37034a, 17, 1.0f);
        this.f37098a = this.f37099b;
    }

    /* renamed from: a */
    public final View mo38671a() {
        return this.f37098a;
    }

    /* renamed from: a */
    public final void mo38672a(Context context, C11770Ub ub) {
        C11841kc kcVar = this.f37109l;
        if (kcVar != null) {
            kcVar.mo38818a(context, ub);
        }
    }

    /* renamed from: a */
    public final void mo38673a(Context context, C11825gc gcVar) {
        C11841kc kcVar = this.f37110m;
        if (kcVar != null) {
            kcVar.mo38818a(context, gcVar);
        }
    }

    /* renamed from: a */
    public final void mo38674a(SpannableString spannableString) {
        TextView textView;
        int i;
        if (C11723Fa.m38822b((CharSequence) spannableString)) {
            this.f37104g.setText(spannableString);
            textView = this.f37104g;
            i = 0;
        } else {
            textView = this.f37104g;
            i = 8;
        }
        textView.setVisibility(i);
    }

    /* renamed from: a */
    public final void mo38675a(OnClickListener onClickListener) {
        C11795bc bcVar = this.f37111n;
        if (bcVar != null) {
            bcVar.mo38705a(onClickListener);
        }
    }

    /* renamed from: a */
    public final void mo38676a(String str) {
        this.f37111n.mo38706a(str);
    }

    /* renamed from: a */
    public final void mo38677a(String str, Bitmap bitmap, String str2) {
        this.f37106i.f37182c.setText(str);
        this.f37106i.f37183d.setImageBitmap(bitmap);
        this.f37108k.f37207c.setText(str2);
    }

    /* renamed from: a */
    public final void mo38678a(String str, String str2) {
        this.f37100c.f37208d.setText(str);
        this.f37100c.f37207c.setText(str2);
    }

    /* renamed from: a */
    public final void mo38679a(boolean z) {
        TextView textView;
        C11761Rb rb;
        if (z) {
            if (C11723Fa.m38823c()) {
                textView = this.f37105h;
                rb = C11761Rb.AGREE_AND_PAY;
            } else {
                textView = this.f37105h;
                rb = C11761Rb.CONFIRM_SEND_PAYMENT;
            }
            textView.setText(C11756Pb.m38949a(rb));
            this.f37111n.mo38707b();
            return;
        }
        this.f37105h.setText(C11756Pb.m38949a(C11761Rb.CONFIRM_CHARGE_CREDIT_CARD));
        this.f37106i.f37180a.setVisibility(0);
        this.f37108k.f37205a.setVisibility(0);
        this.f37108k.f37208d.setText(C11756Pb.m38949a(C11761Rb.EXPIRES_ON_DATE));
    }

    /* renamed from: b */
    public final TextView mo38680b() {
        return this.f37102e;
    }

    /* renamed from: b */
    public final void mo38681b(OnClickListener onClickListener) {
        this.f37103f.setOnClickListener(onClickListener);
    }

    /* renamed from: b */
    public final void mo38682b(boolean z) {
        LinearLayout linearLayout = this.f37103f;
        if (linearLayout != null) {
            linearLayout.setEnabled(z);
        }
    }

    /* renamed from: c */
    public final void mo38683c() {
        this.f37100c.mo38792a();
    }

    /* renamed from: c */
    public final void mo38684c(OnClickListener onClickListener) {
        C11841kc kcVar = this.f37109l;
        if (kcVar != null) {
            kcVar.mo38819a(onClickListener);
        }
    }

    /* renamed from: d */
    public final TextView mo38685d() {
        return this.f37107j.f37036c;
    }

    /* renamed from: d */
    public final void mo38686d(OnClickListener onClickListener) {
        C11841kc kcVar = this.f37110m;
        if (kcVar != null) {
            kcVar.mo38819a(onClickListener);
        }
    }

    /* renamed from: e */
    public final View mo38687e() {
        C11841kc kcVar = this.f37109l;
        if (kcVar != null) {
            return kcVar.mo38817a();
        }
        return null;
    }

    /* renamed from: f */
    public final View mo38688f() {
        C11841kc kcVar = this.f37110m;
        if (kcVar != null) {
            return kcVar.mo38817a();
        }
        return null;
    }
}
