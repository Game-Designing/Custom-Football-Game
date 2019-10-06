package com.paypal.android.sdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.ColorDrawable;
import android.text.method.LinkMovementMethod;
import android.util.Base64;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.paypal.android.sdk.Da */
public final class C11715Da {

    /* renamed from: a */
    private static final Map f36648a;

    /* renamed from: b */
    private static Pattern f36649b = Pattern.compile("^\\s*(\\d+(\\.\\d+)*)\\s*([a-zA-Z]+)\\s*$");

    /* renamed from: c */
    private static HashMap f36650c = new HashMap();

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("px", Integer.valueOf(0));
        Integer valueOf = Integer.valueOf(1);
        hashMap.put("dip", valueOf);
        hashMap.put("dp", valueOf);
        hashMap.put("sp", Integer.valueOf(2));
        hashMap.put("pt", Integer.valueOf(3));
        hashMap.put("in", Integer.valueOf(4));
        hashMap.put("mm", Integer.valueOf(5));
        f36648a = Collections.unmodifiableMap(hashMap);
    }

    /* renamed from: a */
    public static int m38765a(String str, Context context) {
        if (str == null) {
            return 0;
        }
        return (int) m38786b(str, context);
    }

    /* renamed from: a */
    public static Bitmap m38766a(String str, Context context, int i) {
        Options options = new Options();
        options.inTargetDensity = context != null ? context.getResources().getDisplayMetrics().densityDpi : Opcodes.IF_ICMPNE;
        options.inDensity = 240;
        options.inScaled = false;
        byte[] decode = Base64.decode(str, 0);
        return BitmapFactory.decodeByteArray(decode, 0, decode.length, options);
    }

    /* renamed from: a */
    public static View m38767a(LinearLayout linearLayout) {
        View view = new View(linearLayout.getContext());
        linearLayout.addView(view);
        view.setBackground(new ColorDrawable(C11711Ca.f36630s));
        m38778a(view, -1, "1dip");
        String str = "12dip";
        m38789b(view, null, str, null, str);
        return view;
    }

    /* renamed from: a */
    public static LayoutParams m38768a() {
        return new LayoutParams(-1, -2);
    }

    /* renamed from: a */
    public static ViewGroup m38769a(Context context) {
        ScrollView scrollView = new ScrollView(context);
        scrollView.setBackgroundColor(C11711Ca.f36620i);
        return scrollView;
    }

    /* renamed from: a */
    public static ImageView m38770a(Context context, String str, String str2) {
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ScaleType.CENTER_INSIDE);
        imageView.setImageBitmap(m38792c(str, context));
        imageView.setAdjustViewBounds(true);
        imageView.setContentDescription(str2);
        return imageView;
    }

    /* renamed from: a */
    public static LinearLayout m38771a(Context context, boolean z, int i, LinearLayout linearLayout) {
        LinearLayout linearLayout2 = new LinearLayout(context);
        if (i != 0) {
            linearLayout2.setId(i);
        }
        linearLayout.addView(linearLayout2);
        linearLayout2.setGravity(17);
        linearLayout2.setOrientation(0);
        m38782a((View) linearLayout2, z, context);
        m38778a((View) linearLayout2, -1, "58dip");
        m38789b(linearLayout2, null, null, null, "4dip");
        return linearLayout2;
    }

    /* renamed from: a */
    public static LinearLayout m38772a(ViewGroup viewGroup) {
        LinearLayout linearLayout = new LinearLayout(viewGroup.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(C11711Ca.f36620i);
        viewGroup.addView(linearLayout);
        m38777a((View) linearLayout, -1, -2);
        return linearLayout;
    }

    /* renamed from: a */
    public static RelativeLayout.LayoutParams m38773a(int i, int i2, int i3, int i4) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(i3, i4);
        return layoutParams;
    }

    /* renamed from: a */
    public static RelativeLayout.LayoutParams m38774a(Context context, String str, String str2, int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(m38765a(str, context), m38765a(str2, context));
        layoutParams.addRule(i);
        return layoutParams;
    }

    /* renamed from: a */
    public static void m38775a(View view) {
        String str = "4dip";
        m38789b(view, str, null, str, null);
    }

    /* renamed from: a */
    public static void m38776a(View view, int i, float f) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            layoutParams2.gravity = i;
            layoutParams2.weight = f;
        }
    }

    /* renamed from: a */
    public static void m38777a(View view, int i, int i2) {
        LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
    }

    /* renamed from: a */
    public static void m38778a(View view, int i, String str) {
        m38777a(view, i, m38765a(str, view.getContext()));
    }

    /* renamed from: a */
    public static void m38779a(View view, String str, int i) {
        m38777a(view, m38765a(str, view.getContext()), -2);
    }

    /* renamed from: a */
    public static void m38780a(View view, String str, String str2) {
        String str3 = "4dip";
        m38789b(view, str3, str, str3, str2);
    }

    /* renamed from: a */
    public static void m38781a(View view, String str, String str2, String str3, String str4) {
        Context context = view.getContext();
        view.setPadding(m38765a(str, context), m38765a(str2, context), m38765a(str3, context), m38765a(str4, context));
    }

    /* renamed from: a */
    public static void m38782a(View view, boolean z, Context context) {
        m38777a(view, -1, -2);
        String str = "0dip";
        String str2 = "10dip";
        m38781a(view, str2, str, str2, str);
        view.setBackground(z ? C11711Ca.m38745a(context) : C11711Ca.m38746b(context));
        view.setFocusable(true);
        view.setMinimumHeight(m38765a("54dip", context));
        if (view instanceof TextView) {
            m38784a((TextView) view);
        }
        if (!(view instanceof Button)) {
            view.setClickable(true);
        }
    }

    /* renamed from: a */
    public static void m38783a(Button button) {
        m38785a((TextView) button, 17);
    }

    /* renamed from: a */
    public static void m38784a(TextView textView) {
        textView.setGravity(17);
        textView.setTextColor(-1);
        textView.setTextSize(20.0f);
        textView.setTypeface(C11711Ca.f36637z);
    }

    /* renamed from: a */
    public static void m38785a(TextView textView, int i) {
        String str = "2dip";
        m38781a(textView, str, str, str, str);
        textView.setTypeface(C11711Ca.f36605A);
        textView.setTextColor(C11711Ca.f36611G);
        textView.setBackground(C11711Ca.m38747c(textView.getContext()));
        textView.setAutoLinkMask(15);
        textView.setTextSize(14.0f);
        textView.setTextColor(C11711Ca.f36611G);
        textView.setGravity(i);
    }

    /* renamed from: b */
    public static float m38786b(String str, Context context) {
        if (str == null) {
            return 0.0f;
        }
        String lowerCase = str.toLowerCase();
        if (f36650c.containsKey(lowerCase)) {
            return ((Float) f36650c.get(lowerCase)).floatValue();
        }
        Matcher matcher = f36649b.matcher(lowerCase);
        if (matcher.matches()) {
            float parseFloat = Float.parseFloat(matcher.group(1));
            Integer num = (Integer) f36648a.get(matcher.group(3).toLowerCase());
            if (num == null) {
                num = Integer.valueOf(1);
            }
            float applyDimension = TypedValue.applyDimension(num.intValue(), parseFloat, context.getResources().getDisplayMetrics());
            f36650c.put(lowerCase, Float.valueOf(applyDimension));
            return applyDimension;
        }
        throw new NumberFormatException();
    }

    /* renamed from: b */
    public static LinearLayout m38787b(ViewGroup viewGroup) {
        LinearLayout linearLayout = new LinearLayout(viewGroup.getContext());
        linearLayout.setOrientation(1);
        String str = "14dip";
        String str2 = "10dip";
        m38781a(linearLayout, str2, str, str2, str);
        viewGroup.addView(linearLayout, m38768a());
        return linearLayout;
    }

    /* renamed from: b */
    public static void m38788b(View view, String str, String str2) {
        Context context = view.getContext();
        m38777a(view, m38765a(str, context), m38765a(str2, context));
    }

    /* renamed from: b */
    public static void m38789b(View view, String str, String str2, String str3, String str4) {
        Context context = view.getContext();
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof MarginLayoutParams) {
            ((MarginLayoutParams) layoutParams).setMargins(m38765a(str, context), m38765a(str2, context), m38765a(str3, context), m38765a(str4, context));
        }
    }

    /* renamed from: b */
    public static void m38790b(TextView textView) {
        textView.setTextColor(C11711Ca.f36635x);
        textView.setLinkTextColor(C11711Ca.f36611G);
        textView.setTypeface(C11711Ca.f36610F);
        textView.setTextSize(13.0f);
        textView.setSingleLine(false);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* renamed from: b */
    public static void m38791b(TextView textView, int i) {
        textView.setTextSize(18.0f);
        textView.setTypeface(C11711Ca.f36606B);
        textView.setSingleLine(true);
        textView.setGravity(i);
        textView.setTextColor(C11711Ca.f36631t);
    }

    /* renamed from: c */
    public static Bitmap m38792c(String str, Context context) {
        return m38766a(str, context, 240);
    }

    /* renamed from: c */
    public static void m38793c(TextView textView, int i) {
        textView.setTextSize(16.0f);
        textView.setTypeface(C11711Ca.f36607C);
        textView.setSingleLine(true);
        textView.setGravity(83);
        textView.setTextColor(C11711Ca.f36631t);
    }

    /* renamed from: d */
    public static void m38794d(TextView textView, int i) {
        textView.setTextSize(14.0f);
        textView.setTypeface(C11711Ca.f36608D);
        textView.setSingleLine(true);
        textView.setGravity(i);
        textView.setTextColor(C11711Ca.f36631t);
    }

    /* renamed from: e */
    public static void m38795e(TextView textView, int i) {
        textView.setTextSize(13.0f);
        textView.setTypeface(C11711Ca.f36608D);
        textView.setSingleLine(true);
        textView.setGravity(83);
        textView.setTextColor(C11711Ca.f36631t);
    }
}
