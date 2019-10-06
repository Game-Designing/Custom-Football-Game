package com.paypal.android.sdk;

import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

/* renamed from: com.paypal.android.sdk.kc */
public final class C11841kc {

    /* renamed from: a */
    private LinearLayout f37251a;

    /* renamed from: b */
    private RelativeLayout f37252b;

    /* renamed from: c */
    private ImageView f37253c;

    /* renamed from: d */
    private ImageView f37254d;

    /* renamed from: e */
    private TextView f37255e;

    /* renamed from: f */
    private TextView f37256f;

    /* renamed from: g */
    private TextView f37257g;

    /* renamed from: h */
    private TextView f37258h;

    public C11841kc(Context context) {
        this.f37251a = new LinearLayout(context);
        this.f37251a.setOrientation(1);
        this.f37252b = new RelativeLayout(context);
        this.f37251a.addView(this.f37252b);
        this.f37253c = new ImageView(context);
        this.f37253c.setId(2301);
        this.f37252b.addView(this.f37253c);
        String str = "35dip";
        C11715Da.m38788b(this.f37253c, str, str);
        C11715Da.m38789b(this.f37253c, null, "4dip", null, null);
        this.f37254d = C11715Da.m38770a(context, "iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAYAAABXAvmHAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAATZJREFUeNrsmMENgkAQRVnPUoAWQB0WoAVoAViA3tW7FEADUIDebUAaoAELwDv+TcaEkFUOsDhj5ieTTdgQ5jHLZ3aDQKVSqVSqAVTX9Q4RSUw8RKSIO+KGmI/5fNMzeZvsGdF88yVia4ypxgCY9Lx/ipi1rkUExb8CVIXFh4SvqMKRPQBBrDAcHFMJIHL2AG8XwrB2TJ0AcWEPQBB2ySwdUxtAlBIAQgxpy5WsKnKmkjVAAyJzuJMXezU+ykp/ZFuJsA0BgA17gAZE5ttevQF02GsOiIQ9AEHEGGJf9uodoMNe7UddsAcgiMyHvU4C4dIl9NcfsWgbFf0jE91KiG7mxLfTojc0oreUojf1oo9VvthlgeS3Y7QpfZu5J+LhsMu9mG7w14e7Q4LIPF5XqVQqlWi9BBgAacm2vqgEoPIAAAAASUVORK5CYII=", "go to selection");
        this.f37254d.setId(2304);
        this.f37254d.setColorFilter(C11711Ca.f36631t);
        String str2 = "20dip";
        LayoutParams a = C11715Da.m38774a(context, str2, str2, 11);
        a.addRule(15);
        this.f37252b.addView(this.f37254d, a);
        this.f37255e = new TextView(context);
        C11715Da.m38794d(this.f37255e, 83);
        this.f37255e.setId(2302);
        LayoutParams a2 = C11715Da.m38773a(-2, -2, 1, 2301);
        a2.addRule(0, 2304);
        this.f37252b.addView(this.f37255e, a2);
        String str3 = "6dip";
        C11715Da.m38789b(this.f37255e, str3, null, null, null);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setId(2306);
        LayoutParams a3 = C11715Da.m38773a(-2, -2, 1, 2301);
        a3.addRule(3, 2302);
        a3.addRule(0, 2304);
        this.f37252b.addView(linearLayout, a3);
        this.f37256f = new TextView(context);
        C11715Da.m38791b(this.f37256f, 83);
        linearLayout.addView(this.f37256f);
        C11715Da.m38789b(this.f37256f, str3, null, null, null);
        this.f37257g = new TextView(context);
        this.f37257g.setId(2305);
        C11715Da.m38794d(this.f37257g, 83);
        linearLayout.addView(this.f37257g);
        C11715Da.m38789b(this.f37257g, str3, null, null, null);
        this.f37258h = new TextView(context);
        this.f37258h.setId(2307);
        C11715Da.m38793c(this.f37258h, 83);
        LayoutParams a4 = C11715Da.m38773a(-2, -2, 1, 2301);
        a4.addRule(3, 2306);
        a4.addRule(0, 2304);
        this.f37252b.addView(this.f37258h, a4);
        this.f37258h.setText(C11756Pb.m38949a(C11761Rb.PAY_AFTER_DELIVERY));
        C11715Da.m38789b(this.f37258h, str3, null, null, null);
        this.f37258h.setVisibility(8);
        C11715Da.m38767a(this.f37251a);
        this.f37251a.setVisibility(8);
    }

    /* renamed from: a */
    public final View mo38817a() {
        return this.f37251a;
    }

    /* renamed from: a */
    public final void mo38818a(Context context, C11837jc jcVar) {
        TextView textView;
        int i;
        this.f37253c.setImageBitmap(C11715Da.m38792c(jcVar.mo38634a(), context));
        this.f37255e.setText(jcVar.mo38635b());
        C11715Da.m38777a((View) this.f37255e, -2, -1);
        this.f37256f.setText(jcVar.mo38636c());
        C11715Da.m38777a((View) this.f37256f, -2, -1);
        this.f37256f.setEllipsize(TruncateAt.END);
        this.f37257g.setText(jcVar.mo38637d());
        C11715Da.m38777a((View) this.f37257g, -2, -1);
        this.f37257g.setEllipsize(TruncateAt.END);
        if (jcVar.mo38638e()) {
            textView = this.f37258h;
            i = 0;
        } else {
            textView = this.f37258h;
            i = 8;
        }
        textView.setVisibility(i);
    }

    /* renamed from: a */
    public final void mo38819a(OnClickListener onClickListener) {
        this.f37251a.setOnClickListener(onClickListener);
    }
}
