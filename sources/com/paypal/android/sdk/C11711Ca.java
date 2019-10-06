package com.paypal.android.sdk;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RectShape;

/* renamed from: com.paypal.android.sdk.Ca */
public final class C11711Ca {

    /* renamed from: A */
    public static final Typeface f36605A;

    /* renamed from: B */
    public static final Typeface f36606B = Typeface.create("sans-serif-bold", 0);

    /* renamed from: C */
    public static final Typeface f36607C;

    /* renamed from: D */
    public static final Typeface f36608D;

    /* renamed from: E */
    public static final Typeface f36609E;

    /* renamed from: F */
    public static final Typeface f36610F;

    /* renamed from: G */
    public static final ColorStateList f36611G = new ColorStateList(new int[][]{f36612a, f36613b}, new int[]{f36624m, f36622k});

    /* renamed from: a */
    private static int[] f36612a = {16842919, 16842910};

    /* renamed from: b */
    private static int[] f36613b = {16842910};

    /* renamed from: c */
    private static int[] f36614c = {-16842910};

    /* renamed from: d */
    private static int[] f36615d = {16842908};

    /* renamed from: e */
    public static final int f36616e = Color.parseColor("#003087");

    /* renamed from: f */
    public static final int f36617f = Color.parseColor("#009CDE");

    /* renamed from: g */
    private static int f36618g = Color.parseColor("#aa009CDE");

    /* renamed from: h */
    public static final Drawable f36619h;

    /* renamed from: i */
    public static final int f36620i;

    /* renamed from: j */
    public static final int f36621j = Color.parseColor("#c4dceb");

    /* renamed from: k */
    private static int f36622k = f36617f;

    /* renamed from: l */
    private static int f36623l = f36618g;

    /* renamed from: m */
    private static int f36624m = f36616e;

    /* renamed from: n */
    private static int f36625n = Color.parseColor("#c5ddeb");

    /* renamed from: o */
    private static int f36626o;

    /* renamed from: p */
    private static int f36627p = Color.parseColor("#aa717074");

    /* renamed from: q */
    private static int f36628q = Color.parseColor("#5a5a5d");

    /* renamed from: r */
    private static int f36629r;

    /* renamed from: s */
    public static final int f36630s = Color.parseColor("#e5e5e5");

    /* renamed from: t */
    public static final int f36631t = Color.parseColor("#515151");

    /* renamed from: u */
    public static final int f36632u = Color.parseColor("#797979");

    /* renamed from: v */
    public static final int f36633v;

    /* renamed from: w */
    public static final int f36634w;

    /* renamed from: x */
    public static final int f36635x;

    /* renamed from: y */
    public static final int f36636y = f36632u;

    /* renamed from: z */
    public static final Typeface f36637z;

    static {
        Color.parseColor("#aa003087");
        String str = "#717074";
        f36619h = new ColorDrawable(Color.parseColor(str));
        String str2 = "#f5f5f5";
        f36620i = Color.parseColor(str2);
        f36626o = Color.parseColor(str);
        f36629r = Color.parseColor(str2);
        Color.parseColor("#333333");
        Color.parseColor("#b32317");
        int i = f36631t;
        f36633v = i;
        f36634w = i;
        f36635x = i;
        String str3 = "sans-serif-light";
        Typeface.create(str3, 0);
        f36637z = Typeface.create(str3, 0);
        f36605A = Typeface.create(str3, 0);
        String str4 = "sans-serif";
        f36607C = Typeface.create(str4, 2);
        f36608D = Typeface.create(str3, 0);
        f36609E = Typeface.create(str4, 0);
        f36610F = Typeface.create(str3, 0);
    }

    /* renamed from: a */
    private static Drawable m38743a(int i, float f) {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RectShape());
        shapeDrawable.getPaint().setStrokeWidth(f * 2.0f);
        shapeDrawable.getPaint().setStyle(Style.STROKE);
        shapeDrawable.getPaint().setColor(f36620i);
        return new LayerDrawable(new Drawable[]{new ColorDrawable(i), shapeDrawable});
    }

    /* renamed from: a */
    private static Drawable m38744a(int i, int i2, float f) {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RectShape());
        shapeDrawable.getPaint().setStrokeWidth(2.0f * f);
        shapeDrawable.getPaint().setStyle(Style.STROKE);
        shapeDrawable.getPaint().setColor(f36620i);
        ShapeDrawable shapeDrawable2 = new ShapeDrawable(new RectShape());
        shapeDrawable2.getPaint().setStrokeWidth(f);
        shapeDrawable2.getPaint().setStyle(Style.STROKE);
        shapeDrawable2.getPaint().setColor(i2);
        return new LayerDrawable(new Drawable[]{new ColorDrawable(i), shapeDrawable, shapeDrawable2});
    }

    /* renamed from: a */
    public static Drawable m38745a(Context context) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(f36612a, new ColorDrawable(f36624m));
        stateListDrawable.addState(f36614c, new ColorDrawable(f36625n));
        stateListDrawable.addState(f36615d, m38744a(f36622k, f36623l, m38748d(context)));
        stateListDrawable.addState(f36613b, m38743a(f36622k, m38748d(context)));
        return stateListDrawable;
    }

    /* renamed from: b */
    public static Drawable m38746b(Context context) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(f36612a, new ColorDrawable(f36628q));
        stateListDrawable.addState(f36614c, new ColorDrawable(f36629r));
        stateListDrawable.addState(f36615d, m38744a(f36626o, f36627p, m38748d(context)));
        stateListDrawable.addState(f36613b, m38743a(f36626o, m38748d(context)));
        return stateListDrawable;
    }

    /* renamed from: c */
    protected static Drawable m38747c(Context context) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(f36615d, m38744a(0, f36623l, m38748d(context)));
        stateListDrawable.addState(f36613b, new ColorDrawable(0));
        return stateListDrawable;
    }

    /* renamed from: d */
    private static float m38748d(Context context) {
        return (C11715Da.m38786b("4dip", context) / 2.0f) * context.getResources().getDisplayMetrics().density;
    }
}
