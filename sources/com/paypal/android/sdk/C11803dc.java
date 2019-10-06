package com.paypal.android.sdk;

import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

/* renamed from: com.paypal.android.sdk.dc */
public final class C11803dc {

    /* renamed from: a */
    public LinearLayout f37157a;

    /* renamed from: b */
    private final TableLayout f37158b;

    /* renamed from: c */
    public RelativeLayout f37159c;

    /* renamed from: d */
    private ImageView f37160d;

    /* renamed from: e */
    private TextView f37161e;

    /* renamed from: f */
    private TextView f37162f;

    /* renamed from: g */
    public final Button f37163g;

    public C11803dc(Context context) {
        this.f37157a = new LinearLayout(context);
        this.f37157a.setLayoutParams(C11715Da.m38768a());
        this.f37157a.setOrientation(1);
        C11715Da.m38767a(this.f37157a);
        this.f37158b = new TableLayout(context);
        this.f37158b.setColumnShrinkable(0, false);
        this.f37158b.setColumnStretchable(0, false);
        this.f37158b.setColumnStretchable(1, false);
        this.f37158b.setColumnShrinkable(1, false);
        TableRow tableRow = new TableRow(context);
        this.f37158b.addView(tableRow);
        this.f37157a.addView(this.f37158b);
        this.f37159c = new RelativeLayout(context);
        tableRow.addView(this.f37159c);
        C11715Da.m38776a((View) this.f37159c, 19, 1.0f);
        C11715Da.m38789b(this.f37159c, null, null, "10dip", null);
        this.f37162f = new TextView(context);
        C11715Da.m38794d(this.f37162f, 0);
        this.f37162f.setId(2301);
        this.f37159c.addView(this.f37162f);
        String str = "6dip";
        C11715Da.m38789b(this.f37162f, str, null, null, null);
        this.f37161e = new TextView(context);
        C11715Da.m38791b(this.f37161e, 0);
        this.f37161e.setId(2302);
        this.f37159c.addView(this.f37161e, C11715Da.m38773a(-2, -2, 3, 2301));
        C11715Da.m38789b(this.f37161e, str, null, null, null);
        this.f37160d = C11715Da.m38770a(context, "iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAYAAABXAvmHAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAATZJREFUeNrsmMENgkAQRVnPUoAWQB0WoAVoAViA3tW7FEADUIDebUAaoAELwDv+TcaEkFUOsDhj5ieTTdgQ5jHLZ3aDQKVSqVSqAVTX9Q4RSUw8RKSIO+KGmI/5fNMzeZvsGdF88yVia4ypxgCY9Lx/ipi1rkUExb8CVIXFh4SvqMKRPQBBrDAcHFMJIHL2AG8XwrB2TJ0AcWEPQBB2ySwdUxtAlBIAQgxpy5WsKnKmkjVAAyJzuJMXezU+ykp/ZFuJsA0BgA17gAZE5ttevQF02GsOiIQ9AEHEGGJf9uodoMNe7UddsAcgiMyHvU4C4dIl9NcfsWgbFf0jE91KiG7mxLfTojc0oreUojf1oo9VvthlgeS3Y7QpfZu5J+LhsMu9mG7w14e7Q4LIPF5XqVQqlWi9BBgAacm2vqgEoPIAAAAASUVORK5CYII=", "go to selection");
        this.f37160d.setId(2307);
        this.f37160d.setColorFilter(C11711Ca.f36631t);
        String str2 = "20dip";
        LayoutParams a = C11715Da.m38774a(context, str2, str2, 15);
        a.addRule(1, 2302);
        a.addRule(1, 2301);
        this.f37159c.addView(this.f37160d, a);
        this.f37163g = new Button(context);
        this.f37163g.setId(2305);
        C11715Da.m38785a((TextView) this.f37163g, 21);
        this.f37163g.setTextSize(18.0f);
        tableRow.addView(this.f37163g);
        C11715Da.m38789b(this.f37163g, null, null, str, null);
        C11715Da.m38776a((View) this.f37163g, 21, 1.0f);
        C11715Da.m38767a(this.f37157a);
        this.f37157a.setVisibility(0);
    }

    /* renamed from: a */
    public final void mo38714a(String str) {
        this.f37161e.setText(str);
        C11715Da.m38777a((View) this.f37161e, -2, -1);
        this.f37161e.setEllipsize(TruncateAt.START);
    }

    /* renamed from: a */
    public final void mo38715a(boolean z) {
        this.f37159c.setClickable(z);
        this.f37160d.setVisibility(z ? 0 : 8);
    }

    /* renamed from: b */
    public final void mo38716b(String str) {
        this.f37162f.setText(str);
    }
}
