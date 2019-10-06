package com.paypal.android.sdk;

import android.content.Context;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

/* renamed from: com.paypal.android.sdk.Zb */
public final class C11785Zb {

    /* renamed from: a */
    public final ViewGroup f37080a;

    /* renamed from: b */
    private ViewGroup f37081b;

    /* renamed from: c */
    public final EditText f37082c;

    /* renamed from: d */
    public final C11767Tb f37083d;

    /* renamed from: e */
    public final EditText f37084e;

    /* renamed from: f */
    public final TableLayout f37085f;

    /* renamed from: g */
    public final TextView f37086g;

    /* renamed from: h */
    public final TextView f37087h;

    /* renamed from: i */
    private LinearLayout f37088i = C11715Da.m38772a(this.f37081b);

    /* renamed from: j */
    public final LinearLayout f37089j;

    /* renamed from: k */
    public final TextView f37090k;

    /* renamed from: l */
    private ImageView f37091l;

    /* renamed from: m */
    public final TextView f37092m;

    /* renamed from: n */
    public final TextView f37093n;

    /* renamed from: o */
    public final EditText f37094o;

    /* renamed from: p */
    public final LinearLayout f37095p;

    /* renamed from: q */
    public final TextView f37096q;

    /* renamed from: r */
    public final C11803dc f37097r;

    public C11785Zb(Context context) {
        Context context2 = context;
        this.f37081b = C11715Da.m38769a(context);
        LinearLayout b = C11715Da.m38787b((ViewGroup) this.f37088i);
        this.f37091l = new ImageView(context2);
        this.f37091l.setImageBitmap(C11715Da.m38792c("iVBORw0KGgoAAAANSUhEUgAAAY8AAAB5CAYAAADBJq1XAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyRpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMy1jMDExIDY2LjE0NTY2MSwgMjAxMi8wMi8wNi0xNDo1NjoyNyAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENTNiAoTWFjaW50b3NoKSIgeG1wTU06SW5zdGFuY2VJRD0ieG1wLmlpZDozOEY4NzVDOUM2MTIxMUUzOURBQ0E3QTY0NjU3OUI5QiIgeG1wTU06RG9jdW1lbnRJRD0ieG1wLmRpZDozOEY4NzVDQUM2MTIxMUUzOURBQ0E3QTY0NjU3OUI5QiI+IDx4bXBNTTpEZXJpdmVkRnJvbSBzdFJlZjppbnN0YW5jZUlEPSJ4bXAuaWlkOjI1QTRDN0EwQzVGRjExRTM5REFDQTdBNjQ2NTc5QjlCIiBzdFJlZjpkb2N1bWVudElEPSJ4bXAuZGlkOjM4Rjg3NUM4QzYxMjExRTM5REFDQTdBNjQ2NTc5QjlCIi8+IDwvcmRmOkRlc2NyaXB0aW9uPiA8L3JkZjpSREY+IDwveDp4bXBtZXRhPiA8P3hwYWNrZXQgZW5kPSJyIj8+QAv3/QAAHRlJREFUeNrsXQmY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", context2));
        this.f37091l.setContentDescription("PayPal");
        b.addView(this.f37091l);
        C11715Da.m38778a((View) this.f37091l, -1, "40dip");
        String str = "10dip";
        C11715Da.m38789b(this.f37091l, null, null, null, str);
        this.f37082c = new EditText(context2);
        this.f37082c.setId(43020);
        this.f37082c.setInputType(1);
        this.f37082c.setTextColor(C11711Ca.f36635x);
        this.f37082c.setTypeface(C11711Ca.f36610F);
        this.f37082c.setSingleLine(true);
        b.addView(this.f37082c);
        C11715Da.m38777a((View) this.f37082c, -1, -2);
        C11715Da.m38789b(this.f37082c, null, null, null, str);
        this.f37084e = new EditText(context2);
        this.f37084e.setId(43021);
        this.f37084e.setInputType(128);
        this.f37084e.setTextColor(C11711Ca.f36635x);
        this.f37084e.setTypeface(C11711Ca.f36610F);
        this.f37084e.setSingleLine(true);
        b.addView(this.f37084e);
        C11715Da.m38777a((View) this.f37084e, -1, -2);
        C11715Da.m38789b(this.f37084e, null, null, null, str);
        this.f37089j = C11715Da.m38771a(context2, true, 43022, b);
        this.f37090k = new TextView(context2);
        C11715Da.m38784a(this.f37090k);
        String str2 = "init";
        this.f37090k.setText(str2);
        this.f37089j.addView(this.f37090k);
        this.f37085f = new TableLayout(context2);
        this.f37085f.setColumnStretchable(1, true);
        this.f37085f.setColumnShrinkable(0, true);
        b.addView(this.f37085f);
        C11715Da.m38777a((View) this.f37085f, -1, -2);
        TableRow tableRow = new TableRow(context2);
        this.f37085f.addView(tableRow);
        C11715Da.m38777a((View) tableRow, -1, -2);
        this.f37087h = new TextView(context2);
        this.f37087h.setId(43023);
        tableRow.addView(this.f37087h);
        C11715Da.m38785a(this.f37087h, 3);
        String str3 = "0dp";
        C11715Da.m38779a((View) this.f37087h, str3, -2);
        C11715Da.m38776a((View) this.f37087h, 3, 0.5f);
        String str4 = "2dip";
        String str5 = "5dip";
        C11715Da.m38781a(this.f37087h, "4dip", str5, str4, str5);
        this.f37092m = new TextView(context2);
        this.f37092m.setId(43024);
        tableRow.addView(this.f37092m);
        C11715Da.m38785a(this.f37092m, 5);
        C11715Da.m38779a((View) this.f37092m, str3, -2);
        C11715Da.m38776a((View) this.f37092m, 5, 0.5f);
        C11715Da.m38781a(this.f37092m, str4, str5, "4dip", str5);
        TableRow tableRow2 = new TableRow(context2);
        this.f37085f.addView(tableRow2);
        C11715Da.m38777a((View) tableRow2, -1, -2);
        this.f37086g = new TextView(context2);
        this.f37086g.setId(43027);
        tableRow2.addView(this.f37086g);
        C11715Da.m38785a(this.f37086g, 1);
        C11715Da.m38779a((View) this.f37086g, str3, -2);
        C11715Da.m38776a((View) this.f37086g, 1, 0.5f);
        C11715Da.m38781a(this.f37086g, str4, str5, str4, str5);
        this.f37093n = new TextView(context2);
        this.f37093n.setTextSize(16.0f);
        this.f37093n.setTypeface(C11711Ca.f36607C);
        this.f37093n.setGravity(51);
        this.f37093n.setTextColor(C11711Ca.f36631t);
        b.addView(this.f37093n);
        C11715Da.m38777a((View) this.f37093n, -2, -2);
        C11715Da.m38781a(this.f37093n, "6dip", str4, "6dip", str4);
        C11715Da.m38789b(this.f37093n, null, null, null, str);
        this.f37097r = new C11803dc(context2);
        C11715Da.m38789b(this.f37097r.f37157a, null, null, null, str);
        b.addView(this.f37097r.f37157a);
        this.f37094o = new EditText(context2);
        this.f37094o.setId(43025);
        this.f37094o.setInputType(2);
        this.f37094o.setTextColor(C11711Ca.f36635x);
        this.f37094o.setTypeface(C11711Ca.f36610F);
        this.f37094o.setSingleLine(true);
        this.f37094o.setFilters(new InputFilter[]{new LengthFilter(6)});
        b.addView(this.f37094o);
        C11715Da.m38777a((View) this.f37094o, -1, -2);
        C11715Da.m38789b(this.f37094o, null, null, null, str);
        this.f37095p = C11715Da.m38771a(context2, true, 43026, b);
        this.f37096q = new TextView(context2);
        C11715Da.m38784a(this.f37096q);
        this.f37096q.setText(str2);
        this.f37095p.addView(this.f37096q);
        this.f37083d = new C11767Tb(context2);
        this.f37088i.addView(this.f37083d.f37034a);
        C11715Da.m38777a((View) this.f37083d.f37034a, -2, -2);
        C11715Da.m38776a((View) this.f37083d.f37034a, 17, 1.0f);
        this.f37082c.setNextFocusDownId(43021);
        this.f37082c.setNextFocusLeftId(43020);
        this.f37082c.setNextFocusRightId(43020);
        this.f37084e.setNextFocusUpId(43020);
        this.f37084e.setNextFocusDownId(43022);
        this.f37084e.setNextFocusLeftId(43021);
        this.f37084e.setNextFocusRightId(43021);
        this.f37089j.setNextFocusUpId(43021);
        mo38668a(true);
        this.f37087h.setNextFocusUpId(43022);
        this.f37087h.setNextFocusRightId(43024);
        this.f37087h.setNextFocusDownId(43027);
        this.f37086g.setNextFocusUpId(43022);
        this.f37092m.setNextFocusUpId(43022);
        this.f37092m.setNextFocusDownId(43027);
        this.f37080a = this.f37081b;
    }

    /* renamed from: a */
    public final void mo38668a(boolean z) {
        TextView textView;
        int i;
        if (z) {
            i = 43023;
            this.f37089j.setNextFocusDownId(43023);
            textView = this.f37092m;
        } else {
            this.f37089j.setNextFocusDownId(43024);
            textView = this.f37092m;
            i = 43022;
        }
        textView.setNextFocusLeftId(i);
    }
}