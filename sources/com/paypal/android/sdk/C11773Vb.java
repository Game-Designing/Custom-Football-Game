package com.paypal.android.sdk;

import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.mopub.volley.DefaultRetryPolicy;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.paypal.android.sdk.Vb */
public final class C11773Vb extends ArrayAdapter {

    /* renamed from: a */
    private int f37046a;

    public C11773Vb(Context context, ArrayList arrayList, int i) {
        super(context, 0, arrayList);
        this.f37046a = i;
    }

    /* renamed from: a */
    private static void m38996a(Context context, RelativeLayout relativeLayout, C11770Ub ub) {
        Context context2 = context;
        RelativeLayout relativeLayout2 = relativeLayout;
        LinearLayout linearLayout = new LinearLayout(context2);
        int i = 2304;
        linearLayout.setId(2304);
        int i2 = 0;
        linearLayout.setOrientation(0);
        int i3 = 2301;
        LayoutParams a = C11715Da.m38773a(-2, -2, 1, 2301);
        a.addRule(0, 2303);
        relativeLayout2.addView(linearLayout, a);
        TextView textView = new TextView(context2);
        textView.setId(2302);
        C11715Da.m38791b(textView, 83);
        linearLayout.addView(textView);
        String str = "6dip";
        C11715Da.m38789b(textView, str, null, null, null);
        TextView textView2 = new TextView(context2);
        C11715Da.m38794d(textView2, 83);
        linearLayout.addView(textView2);
        C11715Da.m38789b(textView2, str, null, str, null);
        if (ub.mo38638e()) {
            TextView textView3 = new TextView(context2);
            textView3.setId(2306);
            C11715Da.m38793c(textView3, 83);
            LayoutParams a2 = C11715Da.m38773a(-2, -2, 1, 2301);
            a2.addRule(0, 2303);
            a2.addRule(3, 2304);
            relativeLayout2.addView(textView3, a2);
            C11715Da.m38789b(textView3, str, null, null, null);
            textView3.setText(C11756Pb.m38949a(C11761Rb.PAY_AFTER_DELIVERY));
            i = 2306;
        }
        Iterator it = ub.mo38639f().iterator();
        int i4 = 2400;
        int i5 = DefaultRetryPolicy.DEFAULT_TIMEOUT_MS;
        while (it.hasNext()) {
            C11779Xb xb = (C11779Xb) it.next();
            TextView textView4 = new TextView(context2);
            textView4.setId(i4);
            StringBuilder sb = new StringBuilder();
            sb.append(xb.mo38652a());
            sb.append(" ");
            sb.append(xb.mo38653b());
            textView4.setText(sb.toString());
            LayoutParams a3 = C11715Da.m38773a(-2, -2, 1, i3);
            a3.addRule(i2, i5);
            if (textView4.getId() == 2400) {
                a3.addRule(3, i);
            } else {
                a3.addRule(3, textView4.getId() - 1);
            }
            relativeLayout2.addView(textView4, a3);
            C11715Da.m38795e(textView4, 83);
            C11715Da.m38789b(textView4, str, null, null, null);
            textView4.setEllipsize(TruncateAt.END);
            TextView textView5 = new TextView(context2);
            textView5.setId(i5);
            textView5.setText(xb.mo38654c());
            LayoutParams a4 = C11715Da.m38773a(-2, -2, i2, 2303);
            a4.addRule(8, i4);
            relativeLayout2.addView(textView5, a4);
            C11715Da.m38794d(textView5, 85);
            C11715Da.m38789b(textView5, str, null, str, null);
            i4++;
            i5++;
            i2 = 0;
            i3 = 2301;
        }
        textView.setText(ub.mo38636c());
        textView.setEllipsize(TruncateAt.END);
        textView2.setText(ub.mo38637d());
        textView2.setEllipsize(TruncateAt.END);
    }

    /* renamed from: a */
    public final void mo38641a(int i) {
        this.f37046a = i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        int i2;
        C11770Ub ub = (C11770Ub) getItem(i);
        LinearLayout linearLayout = new LinearLayout(viewGroup.getContext());
        RelativeLayout relativeLayout = new RelativeLayout(viewGroup.getContext());
        linearLayout.addView(relativeLayout);
        String str = "6dip";
        C11715Da.m38781a(relativeLayout, null, str, null, str);
        ImageView a = C11715Da.m38770a(viewGroup.getContext(), ub.mo38634a(), "");
        a.setId(2301);
        String str2 = "30dip";
        LayoutParams a2 = C11715Da.m38774a(viewGroup.getContext(), str2, str2, 9);
        a2.addRule(10);
        relativeLayout.addView(a, a2);
        C11715Da.m38781a(a, "4dip", null, null, null);
        ImageView a3 = C11715Da.m38770a(viewGroup.getContext(), "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", "checked");
        a3.setId(2303);
        String str3 = "20dip";
        LayoutParams a4 = C11715Da.m38774a(viewGroup.getContext(), str3, str3, 11);
        a4.addRule(10);
        relativeLayout.addView(a3, a4);
        a3.setColorFilter(C11711Ca.f36617f);
        C11715Da.m38781a(a3, null, null, "8dip", null);
        if (i != this.f37046a) {
            a3.setVisibility(4);
        }
        if (ub.mo38640g()) {
            Context context = viewGroup.getContext();
            TextView textView = new TextView(context);
            textView.setId(2302);
            C11715Da.m38791b(textView, 83);
            LayoutParams a5 = C11715Da.m38773a(-2, -2, 1, 2301);
            a5.addRule(0, 2303);
            relativeLayout.addView(textView, a5);
            C11715Da.m38789b(textView, str, null, null, null);
            if (ub.mo38638e()) {
                TextView textView2 = new TextView(context);
                textView2.setId(2306);
                C11715Da.m38793c(textView2, 83);
                LayoutParams a6 = C11715Da.m38773a(-2, -2, 1, 2301);
                a6.addRule(0, 2303);
                a6.addRule(3, 2302);
                relativeLayout.addView(textView2, a6);
                C11715Da.m38789b(textView2, str, null, null, null);
                textView2.setText(C11756Pb.m38949a(C11761Rb.PAY_AFTER_DELIVERY));
                i2 = 2306;
            } else {
                i2 = 2302;
            }
            TextView textView3 = new TextView(context);
            textView3.setId(2305);
            C11715Da.m38794d(textView3, 83);
            LayoutParams a7 = C11715Da.m38773a(-2, -2, 1, 2301);
            a7.addRule(3, i2);
            relativeLayout.addView(textView3, a7);
            C11715Da.m38789b(textView3, str, null, null, null);
            TextView textView4 = new TextView(context);
            LayoutParams a8 = C11715Da.m38773a(-2, -2, 0, 2303);
            a8.addRule(8, 2305);
            relativeLayout.addView(textView4, a8);
            C11715Da.m38794d(textView4, 85);
            C11715Da.m38789b(textView4, null, null, str, null);
            textView.setText(ub.mo38636c());
            textView3.setText(ub.mo38637d());
            textView4.setText(ub.mo38639f().mo38658a(0).mo38654c());
        } else {
            m38996a(viewGroup.getContext(), relativeLayout, ub);
        }
        return linearLayout;
    }
}
