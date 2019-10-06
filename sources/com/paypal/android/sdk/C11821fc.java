package com.paypal.android.sdk;

import android.content.Context;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

/* renamed from: com.paypal.android.sdk.fc */
public final class C11821fc {

    /* renamed from: a */
    public TableLayout f37205a;

    /* renamed from: b */
    public TableLayout f37206b;

    /* renamed from: c */
    public TextView f37207c;

    /* renamed from: d */
    public TextView f37208d;

    /* renamed from: e */
    private int f37209e;

    /* renamed from: f */
    private boolean f37210f = false;

    public C11821fc(Context context, String str) {
        this.f37206b = new TableLayout(context);
        this.f37206b.setColumnShrinkable(0, false);
        this.f37206b.setColumnStretchable(0, false);
        this.f37206b.setColumnStretchable(1, false);
        this.f37206b.setColumnShrinkable(1, false);
        TableRow tableRow = new TableRow(context);
        this.f37206b.addView(tableRow);
        this.f37208d = new TextView(context);
        this.f37208d.setTextColor(C11711Ca.f36633v);
        this.f37208d.setText("Item");
        this.f37208d.setSingleLine(true);
        this.f37208d.setGravity(83);
        this.f37208d.setTextSize(18.0f);
        this.f37208d.setTextColor(C11711Ca.f36633v);
        this.f37208d.setTypeface(C11711Ca.f36608D);
        tableRow.addView(this.f37208d);
        C11715Da.m38776a((View) this.f37208d, 16, 1.0f);
        String str2 = "10dip";
        this.f37209e = C11715Da.m38765a(str2, context);
        C11715Da.m38789b(this.f37208d, null, null, str2, null);
        this.f37207c = new TextView(context);
        this.f37207c.setTextSize(18.0f);
        this.f37207c.setTypeface(C11711Ca.f36609E);
        this.f37207c.setText(str);
        this.f37207c.setSingleLine(true);
        this.f37207c.setGravity(85);
        this.f37207c.setTextColor(C11711Ca.f36634w);
        tableRow.addView(this.f37207c);
        C11715Da.m38776a((View) this.f37207c, 5, 1.0f);
        this.f37205a = this.f37206b;
    }

    /* renamed from: a */
    public final void mo38792a() {
        TextView textView = this.f37207c;
        TextView textView2 = this.f37208d;
        int width = (this.f37206b.getWidth() - ((int) textView.getPaint().measureText(textView.getText().toString()))) - this.f37209e;
        CharSequence ellipsize = TextUtils.ellipsize(textView2.getText(), textView2.getPaint(), (float) width, TruncateAt.END);
        textView2.setWidth(width);
        textView2.setText(ellipsize);
    }
}
