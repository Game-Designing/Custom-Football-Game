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
import java.util.ArrayList;
import java.util.Locale;

/* renamed from: com.paypal.android.sdk.hc */
public final class C11829hc extends ArrayAdapter {

    /* renamed from: a */
    private int f37230a;

    public C11829hc(Context context, ArrayList arrayList, int i) {
        super(context, 0, arrayList);
        this.f37230a = i;
    }

    /* renamed from: a */
    private static int m39169a(Context context, RelativeLayout relativeLayout, String str, int i) {
        if (C11723Fa.m38818a((CharSequence) str)) {
            return i;
        }
        TextView textView = new TextView(context);
        int i2 = i + 1;
        textView.setId(i2);
        LayoutParams a = C11715Da.m38773a(-2, -2, 1, 2301);
        a.addRule(0, 2302);
        a.addRule(3, i);
        textView.setText(str);
        C11715Da.m38794d(textView, 83);
        String str2 = "6dip";
        C11715Da.m38789b(textView, str2, null, str2, null);
        relativeLayout.addView(textView, a);
        textView.setEllipsize(TruncateAt.END);
        return i2;
    }

    /* renamed from: a */
    public final void mo38803a(int i) {
        this.f37230a = i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C11825gc gcVar = (C11825gc) getItem(i);
        Context context = viewGroup.getContext();
        LinearLayout linearLayout = new LinearLayout(viewGroup.getContext());
        RelativeLayout relativeLayout = new RelativeLayout(context);
        linearLayout.addView(relativeLayout);
        String str = "6dip";
        C11715Da.m38781a(relativeLayout, null, str, null, str);
        String str2 = "";
        ImageView a = C11715Da.m38770a(viewGroup.getContext(), gcVar.mo38634a(), str2);
        a.setId(2301);
        String str3 = "40dip";
        LayoutParams a2 = C11715Da.m38774a(context, str3, str3, 9);
        a2.addRule(10);
        relativeLayout.addView(a, a2);
        C11715Da.m38781a(a, str, null, null, null);
        ImageView a3 = C11715Da.m38770a(viewGroup.getContext(), "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", "checked");
        a3.setId(2302);
        String str4 = "20dip";
        LayoutParams a4 = C11715Da.m38774a(context, str4, str4, 11);
        a4.addRule(10);
        relativeLayout.addView(a3, a4);
        a3.setColorFilter(C11711Ca.f36617f);
        C11715Da.m38781a(a3, null, null, "8dip", null);
        a3.setVisibility(i == this.f37230a ? 0 : 4);
        TextView textView = new TextView(context);
        textView.setId(2303);
        textView.setText(gcVar.mo38793f());
        C11715Da.m38791b(textView, 83);
        C11715Da.m38789b(textView, str, null, str, null);
        relativeLayout.addView(textView, C11715Da.m38773a(-2, -2, 1, 2301));
        int a5 = m39169a(context, relativeLayout, gcVar.mo38795h(), m39169a(context, relativeLayout, gcVar.mo38794g(), 2303));
        StringBuilder sb = new StringBuilder();
        sb.append(gcVar.mo38796i());
        sb.append(" ");
        sb.append(gcVar.mo38797j());
        String str5 = "  ";
        if (C11723Fa.m38822b((CharSequence) gcVar.mo38798k())) {
            sb.append(str5);
            sb.append(gcVar.mo38798k());
        }
        if (C11723Fa.m38822b((CharSequence) gcVar.mo38799l())) {
            sb.append(str5);
            String l = gcVar.mo38799l();
            if (!C11723Fa.m38818a((CharSequence) l)) {
                String lowerCase = Locale.getDefault().getCountry().toLowerCase(Locale.US);
                if (C11723Fa.m38818a((CharSequence) lowerCase) || !lowerCase.equals(l.toLowerCase(Locale.US))) {
                    StringBuilder sb2 = new StringBuilder("[");
                    sb2.append(l);
                    sb2.append("]");
                    str2 = sb2.toString();
                }
            }
            sb.append(str2);
        }
        m39169a(context, relativeLayout, sb.toString(), a5);
        return linearLayout;
    }
}
