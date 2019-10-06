package android.support.constraint;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.support.constraint.p034a.C0200f;
import android.support.constraint.p034a.p035a.C0170a;
import android.support.constraint.p034a.p035a.C0175f;
import android.support.constraint.p034a.p035a.C0175f.C0177b;
import android.support.constraint.p034a.p035a.C0175f.C0178c;
import android.support.constraint.p034a.p035a.C0180h;
import android.support.constraint.p034a.p035a.C0180h.C0181a;
import android.support.constraint.p034a.p035a.C0182i;
import android.support.constraint.p034a.p035a.C0185l;
import android.support.constraint.p034a.p035a.C0189p;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.util.ArrayList;
import java.util.HashMap;

public class ConstraintLayout extends ViewGroup {

    /* renamed from: a */
    SparseArray<View> f230a = new SparseArray<>();

    /* renamed from: b */
    private ArrayList<C0205b> f231b = new ArrayList<>(4);

    /* renamed from: c */
    private final ArrayList<C0180h> f232c = new ArrayList<>(100);

    /* renamed from: d */
    C0182i f233d = new C0182i();

    /* renamed from: e */
    private int f234e = 0;

    /* renamed from: f */
    private int f235f = 0;

    /* renamed from: g */
    private int f236g = MoPubClientPositioning.NO_REPEAT;

    /* renamed from: h */
    private int f237h = MoPubClientPositioning.NO_REPEAT;

    /* renamed from: i */
    private boolean f238i = true;

    /* renamed from: j */
    private int f239j = 7;

    /* renamed from: k */
    private C0207d f240k = null;

    /* renamed from: l */
    private int f241l = -1;

    /* renamed from: m */
    private HashMap<String, Integer> f242m = new HashMap<>();

    /* renamed from: n */
    private int f243n = -1;

    /* renamed from: o */
    private int f244o = -1;

    /* renamed from: p */
    int f245p = -1;

    /* renamed from: q */
    int f246q = -1;

    /* renamed from: r */
    int f247r = 0;

    /* renamed from: s */
    int f248s = 0;

    /* renamed from: t */
    private C0200f f249t;

    /* renamed from: android.support.constraint.ConstraintLayout$a */
    public static class C0166a extends MarginLayoutParams {

        /* renamed from: A */
        public float f250A;

        /* renamed from: B */
        public String f251B;

        /* renamed from: C */
        float f252C;

        /* renamed from: D */
        int f253D;

        /* renamed from: E */
        public float f254E;

        /* renamed from: F */
        public float f255F;

        /* renamed from: G */
        public int f256G;

        /* renamed from: H */
        public int f257H;

        /* renamed from: I */
        public int f258I;

        /* renamed from: J */
        public int f259J;

        /* renamed from: K */
        public int f260K;

        /* renamed from: L */
        public int f261L;

        /* renamed from: M */
        public int f262M;

        /* renamed from: N */
        public int f263N;

        /* renamed from: O */
        public float f264O;

        /* renamed from: P */
        public float f265P;

        /* renamed from: Q */
        public int f266Q;

        /* renamed from: R */
        public int f267R;

        /* renamed from: S */
        public int f268S;

        /* renamed from: T */
        public boolean f269T;

        /* renamed from: U */
        public boolean f270U;

        /* renamed from: V */
        boolean f271V;

        /* renamed from: W */
        boolean f272W;

        /* renamed from: X */
        boolean f273X;

        /* renamed from: Y */
        boolean f274Y;

        /* renamed from: Z */
        boolean f275Z;

        /* renamed from: a */
        public int f276a;

        /* renamed from: aa */
        boolean f277aa;

        /* renamed from: b */
        public int f278b;

        /* renamed from: ba */
        int f279ba;

        /* renamed from: c */
        public float f280c;

        /* renamed from: ca */
        int f281ca;

        /* renamed from: d */
        public int f282d;

        /* renamed from: da */
        int f283da;

        /* renamed from: e */
        public int f284e;

        /* renamed from: ea */
        int f285ea;

        /* renamed from: f */
        public int f286f;

        /* renamed from: fa */
        int f287fa;

        /* renamed from: g */
        public int f288g;

        /* renamed from: ga */
        int f289ga;

        /* renamed from: h */
        public int f290h;

        /* renamed from: ha */
        float f291ha;

        /* renamed from: i */
        public int f292i;

        /* renamed from: ia */
        int f293ia;

        /* renamed from: j */
        public int f294j;

        /* renamed from: ja */
        int f295ja;

        /* renamed from: k */
        public int f296k;

        /* renamed from: ka */
        float f297ka;

        /* renamed from: l */
        public int f298l;

        /* renamed from: la */
        C0180h f299la;

        /* renamed from: m */
        public int f300m;

        /* renamed from: ma */
        public boolean f301ma;

        /* renamed from: n */
        public int f302n;

        /* renamed from: o */
        public float f303o;

        /* renamed from: p */
        public int f304p;

        /* renamed from: q */
        public int f305q;

        /* renamed from: r */
        public int f306r;

        /* renamed from: s */
        public int f307s;

        /* renamed from: t */
        public int f308t;

        /* renamed from: u */
        public int f309u;

        /* renamed from: v */
        public int f310v;

        /* renamed from: w */
        public int f311w;

        /* renamed from: x */
        public int f312x;

        /* renamed from: y */
        public int f313y;

        /* renamed from: z */
        public float f314z;

        /* renamed from: android.support.constraint.ConstraintLayout$a$a */
        private static class C0167a {

            /* renamed from: a */
            public static final SparseIntArray f315a = new SparseIntArray();

            static {
                f315a.append(C0214i.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                f315a.append(C0214i.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                f315a.append(C0214i.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                f315a.append(C0214i.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                f315a.append(C0214i.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                f315a.append(C0214i.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                f315a.append(C0214i.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                f315a.append(C0214i.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                f315a.append(C0214i.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                f315a.append(C0214i.ConstraintLayout_Layout_layout_constraintCircle, 2);
                f315a.append(C0214i.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                f315a.append(C0214i.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                f315a.append(C0214i.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                f315a.append(C0214i.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                f315a.append(C0214i.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                f315a.append(C0214i.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                f315a.append(C0214i.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                f315a.append(C0214i.ConstraintLayout_Layout_android_orientation, 1);
                f315a.append(C0214i.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                f315a.append(C0214i.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                f315a.append(C0214i.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                f315a.append(C0214i.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                f315a.append(C0214i.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                f315a.append(C0214i.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                f315a.append(C0214i.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                f315a.append(C0214i.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                f315a.append(C0214i.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                f315a.append(C0214i.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                f315a.append(C0214i.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                f315a.append(C0214i.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                f315a.append(C0214i.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                f315a.append(C0214i.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                f315a.append(C0214i.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                f315a.append(C0214i.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                f315a.append(C0214i.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                f315a.append(C0214i.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                f315a.append(C0214i.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                f315a.append(C0214i.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                f315a.append(C0214i.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                f315a.append(C0214i.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                f315a.append(C0214i.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                f315a.append(C0214i.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                f315a.append(C0214i.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                f315a.append(C0214i.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                f315a.append(C0214i.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                f315a.append(C0214i.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                f315a.append(C0214i.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                f315a.append(C0214i.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                f315a.append(C0214i.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                f315a.append(C0214i.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
            }
        }

        public C0166a(Context c, AttributeSet attrs) {
            int commaIndex;
            super(c, attrs);
            int i = -1;
            this.f276a = -1;
            this.f278b = -1;
            this.f280c = -1.0f;
            this.f282d = -1;
            this.f284e = -1;
            this.f286f = -1;
            this.f288g = -1;
            this.f290h = -1;
            this.f292i = -1;
            this.f294j = -1;
            this.f296k = -1;
            this.f298l = -1;
            this.f300m = -1;
            int i2 = 0;
            this.f302n = 0;
            this.f303o = 0.0f;
            this.f304p = -1;
            this.f305q = -1;
            this.f306r = -1;
            this.f307s = -1;
            this.f308t = -1;
            this.f309u = -1;
            this.f310v = -1;
            this.f311w = -1;
            this.f312x = -1;
            this.f313y = -1;
            this.f314z = 0.5f;
            this.f250A = 0.5f;
            this.f251B = null;
            this.f252C = 0.0f;
            this.f253D = 1;
            this.f254E = -1.0f;
            this.f255F = -1.0f;
            this.f256G = 0;
            this.f257H = 0;
            this.f258I = 0;
            this.f259J = 0;
            this.f260K = 0;
            this.f261L = 0;
            this.f262M = 0;
            this.f263N = 0;
            this.f264O = 1.0f;
            this.f265P = 1.0f;
            this.f266Q = -1;
            this.f267R = -1;
            this.f268S = -1;
            this.f269T = false;
            this.f270U = false;
            this.f271V = true;
            this.f272W = true;
            this.f273X = false;
            this.f274Y = false;
            this.f275Z = false;
            this.f277aa = false;
            this.f279ba = -1;
            this.f281ca = -1;
            this.f283da = -1;
            this.f285ea = -1;
            this.f287fa = -1;
            this.f289ga = -1;
            this.f291ha = 0.5f;
            this.f299la = new C0180h();
            this.f301ma = false;
            TypedArray a = c.obtainStyledAttributes(attrs, C0214i.ConstraintLayout_Layout);
            int N = a.getIndexCount();
            int i3 = 0;
            while (i3 < N) {
                int attr = a.getIndex(i3);
                String str = "ConstraintLayout";
                switch (C0167a.f315a.get(attr)) {
                    case 0:
                        break;
                    case 1:
                        this.f268S = a.getInt(attr, this.f268S);
                        break;
                    case 2:
                        this.f300m = a.getResourceId(attr, this.f300m);
                        if (this.f300m != -1) {
                            break;
                        } else {
                            this.f300m = a.getInt(attr, -1);
                            break;
                        }
                    case 3:
                        this.f302n = a.getDimensionPixelSize(attr, this.f302n);
                        break;
                    case 4:
                        this.f303o = a.getFloat(attr, this.f303o) % 360.0f;
                        float f = this.f303o;
                        if (f >= 0.0f) {
                            break;
                        } else {
                            this.f303o = (360.0f - f) % 360.0f;
                            break;
                        }
                    case 5:
                        this.f276a = a.getDimensionPixelOffset(attr, this.f276a);
                        break;
                    case 6:
                        this.f278b = a.getDimensionPixelOffset(attr, this.f278b);
                        break;
                    case 7:
                        this.f280c = a.getFloat(attr, this.f280c);
                        break;
                    case 8:
                        this.f282d = a.getResourceId(attr, this.f282d);
                        if (this.f282d != -1) {
                            break;
                        } else {
                            this.f282d = a.getInt(attr, -1);
                            break;
                        }
                    case 9:
                        this.f284e = a.getResourceId(attr, this.f284e);
                        if (this.f284e != -1) {
                            break;
                        } else {
                            this.f284e = a.getInt(attr, -1);
                            break;
                        }
                    case 10:
                        this.f286f = a.getResourceId(attr, this.f286f);
                        if (this.f286f != -1) {
                            break;
                        } else {
                            this.f286f = a.getInt(attr, -1);
                            break;
                        }
                    case 11:
                        this.f288g = a.getResourceId(attr, this.f288g);
                        if (this.f288g != -1) {
                            break;
                        } else {
                            this.f288g = a.getInt(attr, -1);
                            break;
                        }
                    case 12:
                        this.f290h = a.getResourceId(attr, this.f290h);
                        if (this.f290h != -1) {
                            break;
                        } else {
                            this.f290h = a.getInt(attr, -1);
                            break;
                        }
                    case 13:
                        this.f292i = a.getResourceId(attr, this.f292i);
                        if (this.f292i != -1) {
                            break;
                        } else {
                            this.f292i = a.getInt(attr, -1);
                            break;
                        }
                    case 14:
                        this.f294j = a.getResourceId(attr, this.f294j);
                        if (this.f294j != -1) {
                            break;
                        } else {
                            this.f294j = a.getInt(attr, -1);
                            break;
                        }
                    case 15:
                        this.f296k = a.getResourceId(attr, this.f296k);
                        if (this.f296k != -1) {
                            break;
                        } else {
                            this.f296k = a.getInt(attr, -1);
                            break;
                        }
                    case 16:
                        this.f298l = a.getResourceId(attr, this.f298l);
                        if (this.f298l != -1) {
                            break;
                        } else {
                            this.f298l = a.getInt(attr, -1);
                            break;
                        }
                    case 17:
                        this.f304p = a.getResourceId(attr, this.f304p);
                        if (this.f304p != -1) {
                            break;
                        } else {
                            this.f304p = a.getInt(attr, -1);
                            break;
                        }
                    case 18:
                        this.f305q = a.getResourceId(attr, this.f305q);
                        if (this.f305q != -1) {
                            break;
                        } else {
                            this.f305q = a.getInt(attr, -1);
                            break;
                        }
                    case 19:
                        this.f306r = a.getResourceId(attr, this.f306r);
                        if (this.f306r != -1) {
                            break;
                        } else {
                            this.f306r = a.getInt(attr, -1);
                            break;
                        }
                    case 20:
                        this.f307s = a.getResourceId(attr, this.f307s);
                        if (this.f307s != -1) {
                            break;
                        } else {
                            this.f307s = a.getInt(attr, -1);
                            break;
                        }
                    case 21:
                        this.f308t = a.getDimensionPixelSize(attr, this.f308t);
                        break;
                    case 22:
                        this.f309u = a.getDimensionPixelSize(attr, this.f309u);
                        break;
                    case 23:
                        this.f310v = a.getDimensionPixelSize(attr, this.f310v);
                        break;
                    case 24:
                        this.f311w = a.getDimensionPixelSize(attr, this.f311w);
                        break;
                    case 25:
                        this.f312x = a.getDimensionPixelSize(attr, this.f312x);
                        break;
                    case 26:
                        this.f313y = a.getDimensionPixelSize(attr, this.f313y);
                        break;
                    case 27:
                        this.f269T = a.getBoolean(attr, this.f269T);
                        break;
                    case 28:
                        this.f270U = a.getBoolean(attr, this.f270U);
                        break;
                    case 29:
                        this.f314z = a.getFloat(attr, this.f314z);
                        break;
                    case 30:
                        this.f250A = a.getFloat(attr, this.f250A);
                        break;
                    case 31:
                        this.f258I = a.getInt(attr, 0);
                        if (this.f258I != 1) {
                            break;
                        } else {
                            Log.e(str, "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                            break;
                        }
                    case 32:
                        this.f259J = a.getInt(attr, 0);
                        if (this.f259J != 1) {
                            break;
                        } else {
                            Log.e(str, "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                            break;
                        }
                    case 33:
                        try {
                            this.f260K = a.getDimensionPixelSize(attr, this.f260K);
                            break;
                        } catch (Exception e) {
                            if (a.getInt(attr, this.f260K) == -2) {
                                this.f260K = -2;
                            }
                            break;
                        }
                    case 34:
                        try {
                            this.f262M = a.getDimensionPixelSize(attr, this.f262M);
                            break;
                        } catch (Exception e2) {
                            if (a.getInt(attr, this.f262M) == -2) {
                                this.f262M = -2;
                            }
                            break;
                        }
                    case 35:
                        this.f264O = Math.max(0.0f, a.getFloat(attr, this.f264O));
                        break;
                    case 36:
                        try {
                            this.f261L = a.getDimensionPixelSize(attr, this.f261L);
                            break;
                        } catch (Exception e3) {
                            if (a.getInt(attr, this.f261L) == -2) {
                                this.f261L = -2;
                            }
                            break;
                        }
                    case 37:
                        try {
                            this.f263N = a.getDimensionPixelSize(attr, this.f263N);
                            break;
                        } catch (Exception e4) {
                            if (a.getInt(attr, this.f263N) == -2) {
                                this.f263N = -2;
                            }
                            break;
                        }
                    case 38:
                        this.f265P = Math.max(0.0f, a.getFloat(attr, this.f265P));
                        break;
                    case 39:
                        break;
                    case 40:
                        break;
                    case 41:
                        break;
                    case 42:
                        break;
                    case 44:
                        this.f251B = a.getString(attr);
                        this.f252C = Float.NaN;
                        this.f253D = i;
                        String str2 = this.f251B;
                        if (str2 == null) {
                            break;
                        } else {
                            int len = str2.length();
                            int commaIndex2 = this.f251B.indexOf(44);
                            if (commaIndex2 <= 0 || commaIndex2 >= len - 1) {
                                commaIndex = 0;
                            } else {
                                String dimension = this.f251B.substring(i2, commaIndex2);
                                if (dimension.equalsIgnoreCase("W")) {
                                    this.f253D = i2;
                                } else if (dimension.equalsIgnoreCase("H")) {
                                    this.f253D = 1;
                                }
                                commaIndex = commaIndex2 + 1;
                            }
                            int colonIndex = this.f251B.indexOf(58);
                            if (colonIndex < 0 || colonIndex >= len - 1) {
                                String r = this.f251B.substring(commaIndex);
                                if (r.length() > 0) {
                                    try {
                                        this.f252C = Float.parseFloat(r);
                                    } catch (NumberFormatException e5) {
                                    }
                                }
                            } else {
                                String nominator = this.f251B.substring(commaIndex, colonIndex);
                                String denominator = this.f251B.substring(colonIndex + 1);
                                if (nominator.length() > 0 && denominator.length() > 0) {
                                    try {
                                        float nominatorValue = Float.parseFloat(nominator);
                                        float denominatorValue = Float.parseFloat(denominator);
                                        if (nominatorValue > 0.0f && denominatorValue > 0.0f) {
                                            if (this.f253D == 1) {
                                                this.f252C = Math.abs(denominatorValue / nominatorValue);
                                            } else {
                                                this.f252C = Math.abs(nominatorValue / denominatorValue);
                                            }
                                        }
                                    } catch (NumberFormatException e6) {
                                    }
                                }
                            }
                            break;
                        }
                        break;
                    case 45:
                        this.f254E = a.getFloat(attr, this.f254E);
                        break;
                    case 46:
                        this.f255F = a.getFloat(attr, this.f255F);
                        break;
                    case 47:
                        this.f256G = a.getInt(attr, i2);
                        break;
                    case 48:
                        this.f257H = a.getInt(attr, i2);
                        break;
                    case 49:
                        this.f266Q = a.getDimensionPixelOffset(attr, this.f266Q);
                        break;
                    case 50:
                        this.f267R = a.getDimensionPixelOffset(attr, this.f267R);
                        break;
                }
                i3++;
                i = -1;
                i2 = 0;
            }
            a.recycle();
            mo3805a();
        }

        /* renamed from: a */
        public void mo3805a() {
            this.f274Y = false;
            this.f271V = true;
            this.f272W = true;
            if (this.width == -2 && this.f269T) {
                this.f271V = false;
                this.f258I = 1;
            }
            if (this.height == -2 && this.f270U) {
                this.f272W = false;
                this.f259J = 1;
            }
            if (this.width == 0 || this.width == -1) {
                this.f271V = false;
                if (this.width == 0 && this.f258I == 1) {
                    this.width = -2;
                    this.f269T = true;
                }
            }
            if (this.height == 0 || this.height == -1) {
                this.f272W = false;
                if (this.height == 0 && this.f259J == 1) {
                    this.height = -2;
                    this.f270U = true;
                }
            }
            if (this.f280c != -1.0f || this.f276a != -1 || this.f278b != -1) {
                this.f274Y = true;
                this.f271V = true;
                this.f272W = true;
                if (!(this.f299la instanceof C0185l)) {
                    this.f299la = new C0185l();
                }
                ((C0185l) this.f299la).mo3954v(this.f268S);
            }
        }

        public C0166a(int width, int height) {
            super(width, height);
            this.f276a = -1;
            this.f278b = -1;
            this.f280c = -1.0f;
            this.f282d = -1;
            this.f284e = -1;
            this.f286f = -1;
            this.f288g = -1;
            this.f290h = -1;
            this.f292i = -1;
            this.f294j = -1;
            this.f296k = -1;
            this.f298l = -1;
            this.f300m = -1;
            this.f302n = 0;
            this.f303o = 0.0f;
            this.f304p = -1;
            this.f305q = -1;
            this.f306r = -1;
            this.f307s = -1;
            this.f308t = -1;
            this.f309u = -1;
            this.f310v = -1;
            this.f311w = -1;
            this.f312x = -1;
            this.f313y = -1;
            this.f314z = 0.5f;
            this.f250A = 0.5f;
            this.f251B = null;
            this.f252C = 0.0f;
            this.f253D = 1;
            this.f254E = -1.0f;
            this.f255F = -1.0f;
            this.f256G = 0;
            this.f257H = 0;
            this.f258I = 0;
            this.f259J = 0;
            this.f260K = 0;
            this.f261L = 0;
            this.f262M = 0;
            this.f263N = 0;
            this.f264O = 1.0f;
            this.f265P = 1.0f;
            this.f266Q = -1;
            this.f267R = -1;
            this.f268S = -1;
            this.f269T = false;
            this.f270U = false;
            this.f271V = true;
            this.f272W = true;
            this.f273X = false;
            this.f274Y = false;
            this.f275Z = false;
            this.f277aa = false;
            this.f279ba = -1;
            this.f281ca = -1;
            this.f283da = -1;
            this.f285ea = -1;
            this.f287fa = -1;
            this.f289ga = -1;
            this.f291ha = 0.5f;
            this.f299la = new C0180h();
            this.f301ma = false;
        }

        public C0166a(LayoutParams source) {
            super(source);
            this.f276a = -1;
            this.f278b = -1;
            this.f280c = -1.0f;
            this.f282d = -1;
            this.f284e = -1;
            this.f286f = -1;
            this.f288g = -1;
            this.f290h = -1;
            this.f292i = -1;
            this.f294j = -1;
            this.f296k = -1;
            this.f298l = -1;
            this.f300m = -1;
            this.f302n = 0;
            this.f303o = 0.0f;
            this.f304p = -1;
            this.f305q = -1;
            this.f306r = -1;
            this.f307s = -1;
            this.f308t = -1;
            this.f309u = -1;
            this.f310v = -1;
            this.f311w = -1;
            this.f312x = -1;
            this.f313y = -1;
            this.f314z = 0.5f;
            this.f250A = 0.5f;
            this.f251B = null;
            this.f252C = 0.0f;
            this.f253D = 1;
            this.f254E = -1.0f;
            this.f255F = -1.0f;
            this.f256G = 0;
            this.f257H = 0;
            this.f258I = 0;
            this.f259J = 0;
            this.f260K = 0;
            this.f261L = 0;
            this.f262M = 0;
            this.f263N = 0;
            this.f264O = 1.0f;
            this.f265P = 1.0f;
            this.f266Q = -1;
            this.f267R = -1;
            this.f268S = -1;
            this.f269T = false;
            this.f270U = false;
            this.f271V = true;
            this.f272W = true;
            this.f273X = false;
            this.f274Y = false;
            this.f275Z = false;
            this.f277aa = false;
            this.f279ba = -1;
            this.f281ca = -1;
            this.f283da = -1;
            this.f285ea = -1;
            this.f287fa = -1;
            this.f289ga = -1;
            this.f291ha = 0.5f;
            this.f299la = new C0180h();
            this.f301ma = false;
        }

        @TargetApi(17)
        public void resolveLayoutDirection(int layoutDirection) {
            int preLeftMargin = this.leftMargin;
            int preRightMargin = this.rightMargin;
            super.resolveLayoutDirection(layoutDirection);
            this.f283da = -1;
            this.f285ea = -1;
            this.f279ba = -1;
            this.f281ca = -1;
            this.f287fa = -1;
            this.f289ga = -1;
            this.f287fa = this.f308t;
            this.f289ga = this.f310v;
            this.f291ha = this.f314z;
            this.f293ia = this.f276a;
            this.f295ja = this.f278b;
            this.f297ka = this.f280c;
            if (1 == getLayoutDirection()) {
                boolean startEndDefined = false;
                int i = this.f304p;
                if (i != -1) {
                    this.f283da = i;
                    startEndDefined = true;
                } else {
                    int i2 = this.f305q;
                    if (i2 != -1) {
                        this.f285ea = i2;
                        startEndDefined = true;
                    }
                }
                int i3 = this.f306r;
                if (i3 != -1) {
                    this.f281ca = i3;
                    startEndDefined = true;
                }
                int i4 = this.f307s;
                if (i4 != -1) {
                    this.f279ba = i4;
                    startEndDefined = true;
                }
                int i5 = this.f312x;
                if (i5 != -1) {
                    this.f289ga = i5;
                }
                int i6 = this.f313y;
                if (i6 != -1) {
                    this.f287fa = i6;
                }
                if (startEndDefined) {
                    this.f291ha = 1.0f - this.f314z;
                }
                if (this.f274Y && this.f268S == 1) {
                    float f = this.f280c;
                    if (f != -1.0f) {
                        this.f297ka = 1.0f - f;
                        this.f293ia = -1;
                        this.f295ja = -1;
                    } else {
                        int i7 = this.f276a;
                        if (i7 != -1) {
                            this.f295ja = i7;
                            this.f293ia = -1;
                            this.f297ka = -1.0f;
                        } else {
                            int i8 = this.f278b;
                            if (i8 != -1) {
                                this.f293ia = i8;
                                this.f295ja = -1;
                                this.f297ka = -1.0f;
                            }
                        }
                    }
                }
            } else {
                int i9 = this.f304p;
                if (i9 != -1) {
                    this.f281ca = i9;
                }
                int i10 = this.f305q;
                if (i10 != -1) {
                    this.f279ba = i10;
                }
                int i11 = this.f306r;
                if (i11 != -1) {
                    this.f283da = i11;
                }
                int i12 = this.f307s;
                if (i12 != -1) {
                    this.f285ea = i12;
                }
                int i13 = this.f312x;
                if (i13 != -1) {
                    this.f287fa = i13;
                }
                int i14 = this.f313y;
                if (i14 != -1) {
                    this.f289ga = i14;
                }
            }
            if (this.f306r == -1 && this.f307s == -1 && this.f305q == -1 && this.f304p == -1) {
                int i15 = this.f286f;
                if (i15 != -1) {
                    this.f283da = i15;
                    if (this.rightMargin <= 0 && preRightMargin > 0) {
                        this.rightMargin = preRightMargin;
                    }
                } else {
                    int i16 = this.f288g;
                    if (i16 != -1) {
                        this.f285ea = i16;
                        if (this.rightMargin <= 0 && preRightMargin > 0) {
                            this.rightMargin = preRightMargin;
                        }
                    }
                }
                int i17 = this.f282d;
                if (i17 != -1) {
                    this.f279ba = i17;
                    if (this.leftMargin <= 0 && preLeftMargin > 0) {
                        this.leftMargin = preLeftMargin;
                        return;
                    }
                    return;
                }
                int i18 = this.f284e;
                if (i18 != -1) {
                    this.f281ca = i18;
                    if (this.leftMargin <= 0 && preLeftMargin > 0) {
                        this.leftMargin = preLeftMargin;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public void mo3778a(int type, Object value1, Object value2) {
        if (type == 0 && (value1 instanceof String) && (value2 instanceof Integer)) {
            if (this.f242m == null) {
                this.f242m = new HashMap<>();
            }
            String name = (String) value1;
            int index = name.indexOf("/");
            if (index != -1) {
                name = name.substring(index + 1);
            }
            this.f242m.put(name, Integer.valueOf(((Integer) value2).intValue()));
        }
    }

    /* renamed from: a */
    public Object mo3777a(int type, Object value) {
        if (type == 0 && (value instanceof String)) {
            String name = (String) value;
            HashMap<String, Integer> hashMap = this.f242m;
            if (hashMap != null && hashMap.containsKey(name)) {
                return this.f242m.get(name);
            }
        }
        return null;
    }

    public ConstraintLayout(Context context) {
        super(context);
        m883a((AttributeSet) null);
    }

    public ConstraintLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        m883a(attrs);
    }

    public ConstraintLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        m883a(attrs);
    }

    public void setId(int id) {
        this.f230a.remove(getId());
        super.setId(id);
        this.f230a.put(getId(), this);
    }

    /* renamed from: a */
    private void m883a(AttributeSet attrs) {
        this.f233d.mo3869a((Object) this);
        this.f230a.put(getId(), this);
        this.f240k = null;
        if (attrs != null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs, C0214i.ConstraintLayout_Layout);
            int N = a.getIndexCount();
            for (int i = 0; i < N; i++) {
                int attr = a.getIndex(i);
                if (attr == C0214i.ConstraintLayout_Layout_android_minWidth) {
                    this.f234e = a.getDimensionPixelOffset(attr, this.f234e);
                } else if (attr == C0214i.ConstraintLayout_Layout_android_minHeight) {
                    this.f235f = a.getDimensionPixelOffset(attr, this.f235f);
                } else if (attr == C0214i.ConstraintLayout_Layout_android_maxWidth) {
                    this.f236g = a.getDimensionPixelOffset(attr, this.f236g);
                } else if (attr == C0214i.ConstraintLayout_Layout_android_maxHeight) {
                    this.f237h = a.getDimensionPixelOffset(attr, this.f237h);
                } else if (attr == C0214i.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.f239j = a.getInt(attr, this.f239j);
                } else if (attr == C0214i.ConstraintLayout_Layout_constraintSet) {
                    int id = a.getResourceId(attr, 0);
                    try {
                        this.f240k = new C0207d();
                        this.f240k.mo4047a(getContext(), id);
                    } catch (NotFoundException e) {
                        this.f240k = null;
                    }
                    this.f241l = id;
                }
            }
            a.recycle();
        }
        this.f233d.mo3945u(this.f239j);
    }

    public void addView(View child, int index, LayoutParams params) {
        super.addView(child, index, params);
        if (VERSION.SDK_INT < 14) {
            onViewAdded(child);
        }
    }

    public void removeView(View view) {
        super.removeView(view);
        if (VERSION.SDK_INT < 14) {
            onViewRemoved(view);
        }
    }

    public void onViewAdded(View view) {
        if (VERSION.SDK_INT >= 14) {
            super.onViewAdded(view);
        }
        C0180h widget = mo3775a(view);
        if ((view instanceof C0211f) && !(widget instanceof C0185l)) {
            C0166a layoutParams = (C0166a) view.getLayoutParams();
            layoutParams.f299la = new C0185l();
            layoutParams.f274Y = true;
            ((C0185l) layoutParams.f299la).mo3954v(layoutParams.f268S);
        }
        if (view instanceof C0205b) {
            C0205b helper = (C0205b) view;
            helper.mo4040a();
            ((C0166a) view.getLayoutParams()).f275Z = true;
            if (!this.f231b.contains(helper)) {
                this.f231b.add(helper);
            }
        }
        this.f230a.put(view.getId(), view);
        this.f238i = true;
    }

    public void onViewRemoved(View view) {
        if (VERSION.SDK_INT >= 14) {
            super.onViewRemoved(view);
        }
        this.f230a.remove(view.getId());
        C0180h widget = mo3775a(view);
        this.f233d.mo3982c(widget);
        this.f231b.remove(view);
        this.f232c.remove(widget);
        this.f238i = true;
    }

    public void setMinWidth(int value) {
        if (value != this.f234e) {
            this.f234e = value;
            requestLayout();
        }
    }

    public void setMinHeight(int value) {
        if (value != this.f235f) {
            this.f235f = value;
            requestLayout();
        }
    }

    public int getMinWidth() {
        return this.f234e;
    }

    public int getMinHeight() {
        return this.f235f;
    }

    public void setMaxWidth(int value) {
        if (value != this.f236g) {
            this.f236g = value;
            requestLayout();
        }
    }

    public void setMaxHeight(int value) {
        if (value != this.f237h) {
            this.f237h = value;
            requestLayout();
        }
    }

    public int getMaxWidth() {
        return this.f236g;
    }

    public int getMaxHeight() {
        return this.f237h;
    }

    /* renamed from: b */
    private void m885b() {
        int count = getChildCount();
        boolean recompute = false;
        int i = 0;
        while (true) {
            if (i >= count) {
                break;
            } else if (getChildAt(i).isLayoutRequested()) {
                recompute = true;
                break;
            } else {
                i++;
            }
        }
        if (recompute) {
            this.f232c.clear();
            m881a();
        }
    }

    /* renamed from: a */
    private void m881a() {
        int helperCount;
        int count;
        int resolvedLeftToLeft;
        int resolveGoneLeftMargin;
        float resolvedHorizontalBias;
        int resolveGoneLeftMargin2;
        int resolveGoneRightMargin;
        int resolvedLeftToLeft2;
        C0166a layoutParams;
        int helperCount2;
        int resolvedRightToRight;
        float resolvedHorizontalBias2;
        int resolvedLeftToLeft3;
        int resolvedLeftToLeft4;
        int resolvedLeftToLeft5;
        boolean isInEditMode = isInEditMode();
        int count2 = getChildCount();
        boolean z = false;
        int i = -1;
        if (isInEditMode) {
            for (int i2 = 0; i2 < count2; i2++) {
                View view = getChildAt(i2);
                try {
                    String IdAsString = getResources().getResourceName(view.getId());
                    mo3778a(0, IdAsString, Integer.valueOf(view.getId()));
                    int slashIndex = IdAsString.indexOf(47);
                    if (slashIndex != -1) {
                        IdAsString = IdAsString.substring(slashIndex + 1);
                    }
                    m884b(view.getId()).mo3870a(IdAsString);
                } catch (NotFoundException e) {
                }
            }
        }
        for (int i3 = 0; i3 < count2; i3++) {
            C0180h widget = mo3775a(getChildAt(i3));
            if (widget != null) {
                widget.mo3854D();
            }
        }
        if (this.f241l != -1) {
            for (int i4 = 0; i4 < count2; i4++) {
                View child = getChildAt(i4);
                if (child.getId() == this.f241l && (child instanceof C0209e)) {
                    this.f240k = ((C0209e) child).getConstraintSet();
                }
            }
        }
        C0207d dVar = this.f240k;
        if (dVar != null) {
            dVar.mo4048a(this);
        }
        this.f233d.mo3980L();
        int helperCount3 = this.f231b.size();
        if (helperCount3 > 0) {
            for (int i5 = 0; i5 < helperCount3; i5++) {
                ((C0205b) this.f231b.get(i5)).mo3809c(this);
            }
        }
        for (int i6 = 0; i6 < count2; i6++) {
            View child2 = getChildAt(i6);
            if (child2 instanceof C0212g) {
                ((C0212g) child2).mo4064b(this);
            }
        }
        int i7 = 0;
        while (i7 < count2) {
            View child3 = getChildAt(i7);
            C0180h widget2 = mo3775a(child3);
            if (widget2 == null) {
                count = count2;
                helperCount = helperCount3;
            } else {
                C0166a layoutParams2 = (C0166a) child3.getLayoutParams();
                layoutParams2.mo3805a();
                if (layoutParams2.f301ma) {
                    layoutParams2.f301ma = z;
                } else if (isInEditMode) {
                    try {
                        String IdAsString2 = getResources().getResourceName(child3.getId());
                        mo3778a(z ? 1 : 0, IdAsString2, Integer.valueOf(child3.getId()));
                        m884b(child3.getId()).mo3870a(IdAsString2.substring(IdAsString2.indexOf("id/") + 3));
                    } catch (NotFoundException e2) {
                    }
                }
                widget2.mo3911n(child3.getVisibility());
                if (layoutParams2.f277aa) {
                    widget2.mo3911n(8);
                }
                widget2.mo3869a((Object) child3);
                this.f233d.mo3981b(widget2);
                if (!layoutParams2.f272W || !layoutParams2.f271V) {
                    this.f232c.add(widget2);
                }
                if (layoutParams2.f274Y) {
                    C0185l guideline = (C0185l) widget2;
                    int resolvedGuideBegin = layoutParams2.f293ia;
                    int resolvedGuideEnd = layoutParams2.f295ja;
                    float resolvedGuidePercent = layoutParams2.f297ka;
                    if (VERSION.SDK_INT < 17) {
                        resolvedGuideBegin = layoutParams2.f276a;
                        resolvedGuideEnd = layoutParams2.f278b;
                        resolvedGuidePercent = layoutParams2.f280c;
                    }
                    if (resolvedGuidePercent != -1.0f) {
                        guideline.mo3952e(resolvedGuidePercent);
                    } else if (resolvedGuideBegin != i) {
                        guideline.mo3834t(resolvedGuideBegin);
                    } else if (resolvedGuideEnd != i) {
                        guideline.mo3953u(resolvedGuideEnd);
                    }
                } else if (!(layoutParams2.f282d == i && layoutParams2.f284e == i && layoutParams2.f286f == i && layoutParams2.f288g == i && layoutParams2.f305q == i && layoutParams2.f304p == i && layoutParams2.f306r == i && layoutParams2.f307s == i && layoutParams2.f290h == i && layoutParams2.f292i == i && layoutParams2.f294j == i && layoutParams2.f296k == i && layoutParams2.f298l == i && layoutParams2.f266Q == i && layoutParams2.f267R == i && layoutParams2.f300m == i && layoutParams2.width != i && layoutParams2.height != i)) {
                    int resolvedLeftToLeft6 = layoutParams2.f279ba;
                    int resolvedLeftToRight = layoutParams2.f281ca;
                    int resolvedRightToLeft = layoutParams2.f283da;
                    int resolvedRightToRight2 = layoutParams2.f285ea;
                    int resolveGoneLeftMargin3 = layoutParams2.f287fa;
                    int resolveGoneRightMargin2 = layoutParams2.f289ga;
                    float resolvedHorizontalBias3 = layoutParams2.f291ha;
                    int resolvedLeftToLeft7 = resolvedLeftToLeft6;
                    if (VERSION.SDK_INT < 17) {
                        int resolvedLeftToLeft8 = layoutParams2.f282d;
                        int resolvedLeftToRight2 = layoutParams2.f284e;
                        int resolvedRightToLeft2 = layoutParams2.f286f;
                        resolvedRightToRight2 = layoutParams2.f288g;
                        int resolveGoneLeftMargin4 = layoutParams2.f308t;
                        int resolveGoneRightMargin3 = layoutParams2.f310v;
                        float resolvedHorizontalBias4 = layoutParams2.f314z;
                        if (resolvedLeftToLeft8 == -1 && resolvedLeftToRight2 == -1) {
                            resolvedLeftToLeft5 = resolvedLeftToLeft8;
                            if (layoutParams2.f305q != -1) {
                                resolvedLeftToLeft3 = layoutParams2.f305q;
                            } else if (layoutParams2.f304p != -1) {
                                resolvedLeftToRight2 = layoutParams2.f304p;
                                resolvedLeftToLeft3 = resolvedLeftToLeft5;
                            }
                            if (resolvedRightToLeft2 == -1 || resolvedRightToRight2 != -1) {
                                resolvedLeftToLeft4 = resolvedLeftToLeft3;
                            } else {
                                resolvedLeftToLeft4 = resolvedLeftToLeft3;
                                if (layoutParams2.f306r != -1) {
                                    resolveGoneLeftMargin = layoutParams2.f306r;
                                    resolvedLeftToLeft2 = resolvedLeftToLeft4;
                                    resolvedLeftToLeft = resolveGoneRightMargin3;
                                    resolvedHorizontalBias = resolvedHorizontalBias4;
                                    resolveGoneRightMargin = resolvedLeftToRight2;
                                    resolveGoneLeftMargin2 = resolveGoneLeftMargin4;
                                } else if (layoutParams2.f307s != -1) {
                                    resolvedRightToRight2 = layoutParams2.f307s;
                                    resolveGoneLeftMargin = resolvedRightToLeft2;
                                    resolvedLeftToLeft2 = resolvedLeftToLeft4;
                                    resolvedLeftToLeft = resolveGoneRightMargin3;
                                    resolvedHorizontalBias = resolvedHorizontalBias4;
                                    resolveGoneRightMargin = resolvedLeftToRight2;
                                    resolveGoneLeftMargin2 = resolveGoneLeftMargin4;
                                }
                            }
                            resolveGoneLeftMargin = resolvedRightToLeft2;
                            resolvedLeftToLeft2 = resolvedLeftToLeft4;
                            resolvedLeftToLeft = resolveGoneRightMargin3;
                            resolvedHorizontalBias = resolvedHorizontalBias4;
                            resolveGoneRightMargin = resolvedLeftToRight2;
                            resolveGoneLeftMargin2 = resolveGoneLeftMargin4;
                        } else {
                            resolvedLeftToLeft5 = resolvedLeftToLeft8;
                        }
                        resolvedLeftToLeft3 = resolvedLeftToLeft5;
                        if (resolvedRightToLeft2 == -1) {
                        }
                        resolvedLeftToLeft4 = resolvedLeftToLeft3;
                        resolveGoneLeftMargin = resolvedRightToLeft2;
                        resolvedLeftToLeft2 = resolvedLeftToLeft4;
                        resolvedLeftToLeft = resolveGoneRightMargin3;
                        resolvedHorizontalBias = resolvedHorizontalBias4;
                        resolveGoneRightMargin = resolvedLeftToRight2;
                        resolveGoneLeftMargin2 = resolveGoneLeftMargin4;
                    } else {
                        resolvedLeftToLeft2 = resolvedLeftToLeft7;
                        resolvedLeftToLeft = resolveGoneRightMargin2;
                        resolveGoneRightMargin = resolvedLeftToRight;
                        int i8 = resolvedRightToLeft;
                        resolvedHorizontalBias = resolvedHorizontalBias3;
                        resolveGoneLeftMargin2 = resolveGoneLeftMargin3;
                        resolveGoneLeftMargin = i8;
                    }
                    int i9 = layoutParams2.f300m;
                    if (i9 != -1) {
                        C0180h target = m884b(i9);
                        if (target != null) {
                            count = count2;
                            widget2.mo3867a(target, layoutParams2.f303o, layoutParams2.f302n);
                        } else {
                            count = count2;
                        }
                        int i10 = resolvedLeftToLeft2;
                        helperCount = helperCount3;
                        View view2 = child3;
                        float f = resolvedHorizontalBias;
                        int i11 = resolvedRightToRight2;
                        int helperCount4 = resolveGoneLeftMargin;
                        layoutParams = layoutParams2;
                    } else {
                        count = count2;
                        if (resolvedLeftToLeft2 != -1) {
                            C0180h target2 = m884b(resolvedLeftToLeft2);
                            if (target2 != null) {
                                C0178c cVar = C0178c.LEFT;
                                C0178c cVar2 = cVar;
                                int i12 = resolvedLeftToLeft2;
                                resolvedHorizontalBias2 = resolvedHorizontalBias;
                                C0180h hVar = target2;
                                C0180h hVar2 = target2;
                                resolvedRightToRight = resolvedRightToRight2;
                                C0178c cVar3 = cVar;
                                helperCount = helperCount3;
                                helperCount2 = resolveGoneLeftMargin;
                                int resolvedRightToLeft3 = layoutParams2.leftMargin;
                                View view3 = child3;
                                layoutParams = layoutParams2;
                                widget2.mo3864a(cVar2, hVar, cVar3, resolvedRightToLeft3, resolveGoneLeftMargin2);
                            } else {
                                C0180h hVar3 = target2;
                                helperCount = helperCount3;
                                View view4 = child3;
                                resolvedHorizontalBias2 = resolvedHorizontalBias;
                                resolvedRightToRight = resolvedRightToRight2;
                                helperCount2 = resolveGoneLeftMargin;
                                layoutParams = layoutParams2;
                            }
                        } else {
                            helperCount = helperCount3;
                            View view5 = child3;
                            resolvedHorizontalBias2 = resolvedHorizontalBias;
                            resolvedRightToRight = resolvedRightToRight2;
                            helperCount2 = resolveGoneLeftMargin;
                            layoutParams = layoutParams2;
                            if (resolveGoneRightMargin != -1) {
                                C0180h target3 = m884b(resolveGoneRightMargin);
                                if (target3 != null) {
                                    widget2.mo3864a(C0178c.LEFT, target3, C0178c.RIGHT, layoutParams.leftMargin, resolveGoneLeftMargin2);
                                }
                            }
                        }
                        if (helperCount2 != -1) {
                            C0180h target4 = m884b(helperCount2);
                            if (target4 != null) {
                                widget2.mo3864a(C0178c.RIGHT, target4, C0178c.LEFT, layoutParams.rightMargin, resolvedLeftToLeft);
                            }
                        } else if (resolvedRightToRight != -1) {
                            C0180h target5 = m884b(resolvedRightToRight);
                            if (target5 != null) {
                                C0178c cVar4 = C0178c.RIGHT;
                                widget2.mo3864a(cVar4, target5, cVar4, layoutParams.rightMargin, resolvedLeftToLeft);
                            }
                        }
                        int i13 = layoutParams.f290h;
                        if (i13 != -1) {
                            C0180h target6 = m884b(i13);
                            if (target6 != null) {
                                C0178c cVar5 = C0178c.TOP;
                                widget2.mo3864a(cVar5, target6, cVar5, layoutParams.topMargin, layoutParams.f309u);
                            }
                        } else {
                            int i14 = layoutParams.f292i;
                            if (i14 != -1) {
                                C0180h target7 = m884b(i14);
                                if (target7 != null) {
                                    widget2.mo3864a(C0178c.TOP, target7, C0178c.BOTTOM, layoutParams.topMargin, layoutParams.f309u);
                                }
                            }
                        }
                        int i15 = layoutParams.f294j;
                        if (i15 != -1) {
                            C0180h target8 = m884b(i15);
                            if (target8 != null) {
                                widget2.mo3864a(C0178c.BOTTOM, target8, C0178c.TOP, layoutParams.bottomMargin, layoutParams.f311w);
                            }
                        } else {
                            int i16 = layoutParams.f296k;
                            if (i16 != -1) {
                                C0180h target9 = m884b(i16);
                                if (target9 != null) {
                                    C0178c cVar6 = C0178c.BOTTOM;
                                    widget2.mo3864a(cVar6, target9, cVar6, layoutParams.bottomMargin, layoutParams.f311w);
                                }
                            }
                        }
                        int i17 = layoutParams.f298l;
                        if (i17 != -1) {
                            View view6 = (View) this.f230a.get(i17);
                            C0180h target10 = m884b(layoutParams.f298l);
                            if (!(target10 == null || view6 == null || !(view6.getLayoutParams() instanceof C0166a))) {
                                C0166a targetParams = (C0166a) view6.getLayoutParams();
                                layoutParams.f273X = true;
                                targetParams.f273X = true;
                                C0175f baseline = widget2.mo3858a(C0178c.BASELINE);
                                baseline.mo3839a(target10.mo3858a(C0178c.BASELINE), 0, -1, C0177b.STRONG, 0, true);
                                widget2.mo3858a(C0178c.TOP).mo3849j();
                                widget2.mo3858a(C0178c.BOTTOM).mo3849j();
                            }
                        }
                        if (resolvedHorizontalBias2 >= 0.0f && resolvedHorizontalBias2 != 0.5f) {
                            widget2.mo3859a(resolvedHorizontalBias2);
                        }
                        float f2 = layoutParams.f250A;
                        if (f2 >= 0.0f && f2 != 0.5f) {
                            widget2.mo3884c(f2);
                        }
                    }
                    if (isInEditMode && !(layoutParams.f266Q == -1 && layoutParams.f267R == -1)) {
                        widget2.mo3885c(layoutParams.f266Q, layoutParams.f267R);
                    }
                    if (layoutParams.f271V) {
                        widget2.mo3865a(C0181a.FIXED);
                        widget2.mo3913o(layoutParams.width);
                    } else if (layoutParams.width == -1) {
                        widget2.mo3865a(C0181a.MATCH_PARENT);
                        widget2.mo3858a(C0178c.LEFT).f355e = layoutParams.leftMargin;
                        widget2.mo3858a(C0178c.RIGHT).f355e = layoutParams.rightMargin;
                    } else {
                        widget2.mo3865a(C0181a.MATCH_CONSTRAINT);
                        widget2.mo3913o(0);
                    }
                    if (layoutParams.f272W) {
                        widget2.mo3878b(C0181a.FIXED);
                        widget2.mo3897g(layoutParams.height);
                    } else if (layoutParams.height == -1) {
                        widget2.mo3878b(C0181a.MATCH_PARENT);
                        widget2.mo3858a(C0178c.TOP).f355e = layoutParams.topMargin;
                        widget2.mo3858a(C0178c.BOTTOM).f355e = layoutParams.bottomMargin;
                    } else {
                        widget2.mo3878b(C0181a.MATCH_CONSTRAINT);
                        widget2.mo3897g(0);
                    }
                    String str = layoutParams.f251B;
                    if (str != null) {
                        widget2.mo3880b(str);
                    }
                    widget2.mo3875b(layoutParams.f254E);
                    widget2.mo3889d(layoutParams.f255F);
                    widget2.mo3899h(layoutParams.f256G);
                    widget2.mo3909m(layoutParams.f257H);
                    widget2.mo3862a(layoutParams.f258I, layoutParams.f260K, layoutParams.f262M, layoutParams.f264O);
                    widget2.mo3877b(layoutParams.f259J, layoutParams.f261L, layoutParams.f263N, layoutParams.f265P);
                }
                count = count2;
                helperCount = helperCount3;
            }
            i7++;
            count2 = count;
            helperCount3 = helperCount;
            z = false;
            i = -1;
        }
        int i18 = helperCount3;
    }

    /* renamed from: b */
    private final C0180h m884b(int id) {
        if (id == 0) {
            return this.f233d;
        }
        View view = (View) this.f230a.get(id);
        if (view == null) {
            view = findViewById(id);
            if (!(view == null || view == this || view.getParent() != this)) {
                onViewAdded(view);
            }
        }
        if (view == this) {
            return this.f233d;
        }
        return view == null ? null : ((C0166a) view.getLayoutParams()).f299la;
    }

    /* renamed from: a */
    public final C0180h mo3775a(View view) {
        if (view == this) {
            return this.f233d;
        }
        return view == null ? null : ((C0166a) view.getLayoutParams()).f299la;
    }

    /* renamed from: a */
    private void m882a(int parentWidthSpec, int parentHeightSpec) {
        boolean didWrapMeasureWidth;
        int childWidthMeasureSpec;
        int childHeightMeasureSpec;
        ConstraintLayout constraintLayout = this;
        int i = parentWidthSpec;
        int i2 = parentHeightSpec;
        int heightPadding = getPaddingTop() + getPaddingBottom();
        int widthPadding = getPaddingLeft() + getPaddingRight();
        int widgetsCount = getChildCount();
        int i3 = 0;
        while (i3 < widgetsCount) {
            View child = constraintLayout.getChildAt(i3);
            if (child.getVisibility() != 8) {
                C0166a params = (C0166a) child.getLayoutParams();
                C0180h widget = params.f299la;
                if (!params.f274Y && !params.f275Z) {
                    widget.mo3911n(child.getVisibility());
                    int width = params.width;
                    int height = params.height;
                    boolean z = params.f271V;
                    boolean didWrapMeasureWidth2 = false;
                    boolean didWrapMeasureHeight = false;
                    if (z || params.f272W || (!z && params.f258I == 1) || params.width == -1 || (!params.f272W && (params.f259J == 1 || params.height == -1))) {
                        if (width == 0) {
                            didWrapMeasureWidth = true;
                            childWidthMeasureSpec = ViewGroup.getChildMeasureSpec(i, widthPadding, -2);
                        } else if (width == -1) {
                            didWrapMeasureWidth = false;
                            childWidthMeasureSpec = ViewGroup.getChildMeasureSpec(i, widthPadding, -1);
                        } else {
                            if (width == -2) {
                                didWrapMeasureWidth2 = true;
                            }
                            didWrapMeasureWidth = didWrapMeasureWidth2;
                            childWidthMeasureSpec = ViewGroup.getChildMeasureSpec(i, widthPadding, width);
                        }
                        if (height == 0) {
                            didWrapMeasureHeight = true;
                            childHeightMeasureSpec = ViewGroup.getChildMeasureSpec(i2, heightPadding, -2);
                        } else if (height == -1) {
                            childHeightMeasureSpec = ViewGroup.getChildMeasureSpec(i2, heightPadding, -1);
                        } else {
                            if (height == -2) {
                                didWrapMeasureHeight = true;
                            }
                            childHeightMeasureSpec = ViewGroup.getChildMeasureSpec(i2, heightPadding, height);
                        }
                        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
                        C0200f fVar = constraintLayout.f249t;
                        if (fVar != null) {
                            fVar.f558a++;
                        }
                        widget.mo3881b(width == -2);
                        widget.mo3871a(height == -2);
                        width = child.getMeasuredWidth();
                        height = child.getMeasuredHeight();
                        didWrapMeasureWidth2 = didWrapMeasureWidth;
                    }
                    widget.mo3913o(width);
                    widget.mo3897g(height);
                    if (didWrapMeasureWidth2) {
                        widget.mo3917q(width);
                    }
                    if (didWrapMeasureHeight) {
                        widget.mo3915p(height);
                    }
                    if (params.f273X) {
                        int baseline = child.getBaseline();
                        if (baseline != -1) {
                            widget.mo3895f(baseline);
                        }
                    }
                }
            }
            i3++;
            constraintLayout = this;
            i = parentWidthSpec;
        }
    }

    /* renamed from: c */
    private void m887c() {
        int widgetsCount = getChildCount();
        for (int i = 0; i < widgetsCount; i++) {
            View child = getChildAt(i);
            if (child instanceof C0212g) {
                ((C0212g) child).mo4063a(this);
            }
        }
        int helperCount = this.f231b.size();
        if (helperCount > 0) {
            for (int i2 = 0; i2 < helperCount; i2++) {
                ((C0205b) this.f231b.get(i2)).mo4041b(this);
            }
        }
    }

    /* renamed from: b */
    private void m886b(int parentWidthSpec, int parentHeightSpec) {
        int i;
        int widthPadding;
        int i2;
        int widgetsCount;
        int childWidthMeasureSpec;
        boolean resolveHeight;
        int childHeightMeasureSpec;
        int heightPadding;
        int heightPadding2;
        ConstraintLayout constraintLayout = this;
        int i3 = parentWidthSpec;
        int i4 = parentHeightSpec;
        int heightPadding3 = getPaddingTop() + getPaddingBottom();
        int widthPadding2 = getPaddingLeft() + getPaddingRight();
        int widgetsCount2 = getChildCount();
        int i5 = 0;
        while (true) {
            i = 8;
            if (i5 >= widgetsCount2) {
                break;
            }
            View child = constraintLayout.getChildAt(i5);
            if (child.getVisibility() == 8) {
                heightPadding = heightPadding3;
            } else {
                C0166a params = (C0166a) child.getLayoutParams();
                C0180h widget = params.f299la;
                if (params.f274Y) {
                    heightPadding = heightPadding3;
                } else if (params.f275Z) {
                    heightPadding = heightPadding3;
                } else {
                    widget.mo3911n(child.getVisibility());
                    int width = params.width;
                    int height = params.height;
                    if (width == 0) {
                        heightPadding2 = heightPadding3;
                    } else if (height == 0) {
                        heightPadding2 = heightPadding3;
                    } else {
                        boolean didWrapMeasureWidth = false;
                        boolean didWrapMeasureHeight = false;
                        if (width == -2) {
                            didWrapMeasureWidth = true;
                        }
                        int childWidthMeasureSpec2 = ViewGroup.getChildMeasureSpec(i3, widthPadding2, width);
                        if (height == -2) {
                            didWrapMeasureHeight = true;
                        }
                        child.measure(childWidthMeasureSpec2, ViewGroup.getChildMeasureSpec(i4, heightPadding3, height));
                        C0200f fVar = constraintLayout.f249t;
                        if (fVar != null) {
                            heightPadding = heightPadding3;
                            fVar.f558a++;
                        } else {
                            heightPadding = heightPadding3;
                        }
                        widget.mo3881b(width == -2);
                        widget.mo3871a(height == -2);
                        int width2 = child.getMeasuredWidth();
                        int height2 = child.getMeasuredHeight();
                        widget.mo3913o(width2);
                        widget.mo3897g(height2);
                        if (didWrapMeasureWidth) {
                            widget.mo3917q(width2);
                        }
                        if (didWrapMeasureHeight) {
                            widget.mo3915p(height2);
                        }
                        if (params.f273X) {
                            int baseline = child.getBaseline();
                            if (baseline != -1) {
                                widget.mo3895f(baseline);
                            }
                        }
                        if (params.f271V != 0 && params.f272W) {
                            widget.mo3908m().mo3970a(width2);
                            widget.mo3906l().mo3970a(height2);
                        }
                    }
                    widget.mo3908m().mo3974b();
                    widget.mo3906l().mo3974b();
                }
            }
            i5++;
            i4 = parentHeightSpec;
            heightPadding3 = heightPadding;
        }
        int heightPadding4 = heightPadding3;
        constraintLayout.f233d.mo3939U();
        int i6 = 0;
        while (i6 < widgetsCount2) {
            View child2 = constraintLayout.getChildAt(i6);
            if (child2.getVisibility() == i) {
                i2 = i6;
                widthPadding = widthPadding2;
                widgetsCount = widgetsCount2;
            } else {
                C0166a params2 = (C0166a) child2.getLayoutParams();
                C0180h widget2 = params2.f299la;
                if (params2.f274Y) {
                    i2 = i6;
                    widthPadding = widthPadding2;
                    widgetsCount = widgetsCount2;
                    C0166a aVar = params2;
                } else if (params2.f275Z) {
                    i2 = i6;
                    widthPadding = widthPadding2;
                    widgetsCount = widgetsCount2;
                } else {
                    widget2.mo3911n(child2.getVisibility());
                    int width3 = params2.width;
                    int height3 = params2.height;
                    if (width3 == 0 || height3 == 0) {
                        C0189p left = widget2.mo3858a(C0178c.LEFT).mo3843d();
                        C0189p right = widget2.mo3858a(C0178c.RIGHT).mo3843d();
                        boolean bothHorizontal = (widget2.mo3858a(C0178c.LEFT).mo3846g() == null || widget2.mo3858a(C0178c.RIGHT).mo3846g() == null) ? false : true;
                        C0189p top = widget2.mo3858a(C0178c.TOP).mo3843d();
                        C0189p bottom = widget2.mo3858a(C0178c.BOTTOM).mo3843d();
                        widgetsCount = widgetsCount2;
                        boolean bothVertical = (widget2.mo3858a(C0178c.TOP).mo3846g() == null || widget2.mo3858a(C0178c.BOTTOM).mo3846g() == null) ? false : true;
                        if (width3 != 0 || height3 != 0 || !bothHorizontal || !bothVertical) {
                            boolean didWrapMeasureWidth2 = false;
                            boolean didWrapMeasureHeight2 = false;
                            i2 = i6;
                            C0166a params3 = params2;
                            boolean resolveWidth = constraintLayout.f233d.mo3902j() != C0181a.WRAP_CONTENT;
                            boolean resolveHeight2 = constraintLayout.f233d.mo3916q() != C0181a.WRAP_CONTENT;
                            if (!resolveWidth) {
                                widget2.mo3908m().mo3974b();
                            }
                            if (!resolveHeight2) {
                                widget2.mo3906l().mo3974b();
                            }
                            if (width3 == 0) {
                                if (!resolveWidth || !widget2.mo3853C() || !bothHorizontal || !left.mo3975c() || !right.mo3975c()) {
                                    didWrapMeasureWidth2 = true;
                                    resolveWidth = false;
                                    childWidthMeasureSpec = ViewGroup.getChildMeasureSpec(i3, widthPadding2, -2);
                                } else {
                                    width3 = (int) (right.mo3967f() - left.mo3967f());
                                    widget2.mo3908m().mo3970a(width3);
                                    childWidthMeasureSpec = ViewGroup.getChildMeasureSpec(i3, widthPadding2, width3);
                                }
                            } else if (width3 == -1) {
                                childWidthMeasureSpec = ViewGroup.getChildMeasureSpec(i3, widthPadding2, -1);
                            } else {
                                if (width3 == -2) {
                                    didWrapMeasureWidth2 = true;
                                }
                                childWidthMeasureSpec = ViewGroup.getChildMeasureSpec(i3, widthPadding2, width3);
                            }
                            if (height3 != 0) {
                                resolveHeight = resolveHeight2;
                                int i7 = parentHeightSpec;
                                if (height3 == -1) {
                                    childHeightMeasureSpec = ViewGroup.getChildMeasureSpec(i7, heightPadding4, -1);
                                } else {
                                    if (height3 == -2) {
                                        didWrapMeasureHeight2 = true;
                                    }
                                    childHeightMeasureSpec = ViewGroup.getChildMeasureSpec(i7, heightPadding4, height3);
                                }
                            } else if (!resolveHeight2 || !widget2.mo3852B() || !bothVertical || !top.mo3975c() || !bottom.mo3975c()) {
                                didWrapMeasureHeight2 = true;
                                resolveHeight = false;
                                childHeightMeasureSpec = ViewGroup.getChildMeasureSpec(parentHeightSpec, heightPadding4, -2);
                            } else {
                                resolveHeight = resolveHeight2;
                                height3 = (int) (bottom.mo3967f() - top.mo3967f());
                                widget2.mo3906l().mo3970a(height3);
                                childHeightMeasureSpec = ViewGroup.getChildMeasureSpec(parentHeightSpec, heightPadding4, height3);
                            }
                            child2.measure(childWidthMeasureSpec, childHeightMeasureSpec);
                            constraintLayout = this;
                            int i8 = childHeightMeasureSpec;
                            C0200f fVar2 = constraintLayout.f249t;
                            if (fVar2 != null) {
                                widthPadding = widthPadding2;
                                boolean z = bothVertical;
                                fVar2.f558a++;
                            } else {
                                widthPadding = widthPadding2;
                                boolean z2 = bothVertical;
                            }
                            widget2.mo3881b(width3 == -2);
                            widget2.mo3871a(height3 == -2);
                            int width4 = child2.getMeasuredWidth();
                            int height4 = child2.getMeasuredHeight();
                            widget2.mo3913o(width4);
                            widget2.mo3897g(height4);
                            if (didWrapMeasureWidth2) {
                                widget2.mo3917q(width4);
                            }
                            if (didWrapMeasureHeight2) {
                                widget2.mo3915p(height4);
                            }
                            if (resolveWidth) {
                                widget2.mo3908m().mo3970a(width4);
                            } else {
                                widget2.mo3908m().mo3971f();
                            }
                            if (resolveHeight) {
                                widget2.mo3906l().mo3970a(height4);
                            } else {
                                widget2.mo3906l().mo3971f();
                            }
                            if (params3.f273X) {
                                int baseline2 = child2.getBaseline();
                                if (baseline2 != -1) {
                                    widget2.mo3895f(baseline2);
                                }
                            }
                        } else {
                            i2 = i6;
                            widthPadding = widthPadding2;
                        }
                    } else {
                        i2 = i6;
                        widthPadding = widthPadding2;
                        widgetsCount = widgetsCount2;
                    }
                }
            }
            i6 = i2 + 1;
            i3 = parentWidthSpec;
            widgetsCount2 = widgetsCount;
            widthPadding2 = widthPadding;
            i = 8;
        }
        int i9 = i6;
        int i10 = widthPadding2;
        int i11 = widgetsCount2;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int REMEASURES_A;
        int REMEASURES_B;
        int childState;
        int startingWidth;
        int startingWidth2;
        boolean containerWrapWidth;
        boolean needSolverPass;
        int startingWidth3;
        int startingHeight;
        int i;
        int widthSpec;
        int heightSpec;
        int i2 = widthMeasureSpec;
        int i3 = heightMeasureSpec;
        long time = System.currentTimeMillis();
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        this.f233d.mo3919r(paddingLeft);
        this.f233d.mo3921s(paddingTop);
        this.f233d.mo3903j(this.f236g);
        this.f233d.mo3901i(this.f237h);
        if (VERSION.SDK_INT >= 17) {
            this.f233d.mo3942c(getLayoutDirection() == 1);
        }
        m888c(widthMeasureSpec, heightMeasureSpec);
        int startingWidth4 = this.f233d.mo3920s();
        int startingHeight2 = this.f233d.mo3900i();
        boolean runAnalyzer = false;
        if (this.f238i) {
            this.f238i = false;
            m885b();
            runAnalyzer = true;
        }
        long j = time;
        boolean optimiseDimensions = (this.f239j & 8) == 8;
        if (optimiseDimensions) {
            this.f233d.mo3938T();
            this.f233d.mo3944f(startingWidth4, startingHeight2);
            m886b(widthMeasureSpec, heightMeasureSpec);
        } else {
            m882a(widthMeasureSpec, heightMeasureSpec);
        }
        m887c();
        if (getChildCount() > 0 && runAnalyzer) {
            C0170a.m920a(this.f233d);
        }
        C0182i iVar = this.f233d;
        if (iVar.f466Ia) {
            REMEASURES_A = 0;
            if (iVar.f467Ja && widthMode == Integer.MIN_VALUE) {
                int i4 = iVar.f469La;
                if (i4 < widthSize) {
                    iVar.mo3913o(i4);
                }
                this.f233d.mo3865a(C0181a.FIXED);
            }
            C0182i iVar2 = this.f233d;
            if (iVar2.f468Ka && heightMode == Integer.MIN_VALUE) {
                int i5 = iVar2.f470Ma;
                if (i5 < heightSize) {
                    iVar2.mo3897g(i5);
                }
                this.f233d.mo3878b(C0181a.FIXED);
            }
        } else {
            REMEASURES_A = 0;
        }
        if ((this.f239j & 32) == 32) {
            int width = this.f233d.mo3920s();
            int height = this.f233d.mo3900i();
            if (this.f243n == width || widthMode != 1073741824) {
                REMEASURES_B = 0;
            } else {
                REMEASURES_B = 0;
                C0170a.m922a(this.f233d.f465Ha, 0, width);
            }
            if (this.f244o != height && heightMode == 1073741824) {
                C0170a.m922a(this.f233d.f465Ha, 1, height);
            }
            C0182i iVar3 = this.f233d;
            if (iVar3.f467Ja && iVar3.f469La > widthSize) {
                C0170a.m922a(iVar3.f465Ha, 0, widthSize);
            }
            C0182i iVar4 = this.f233d;
            if (iVar4.f468Ka && iVar4.f470Ma > heightSize) {
                C0170a.m922a(iVar4.f465Ha, 1, heightSize);
            }
        } else {
            REMEASURES_B = 0;
        }
        if (getChildCount() > 0) {
            mo3779a("First pass");
        }
        int sizeDependentWidgetsCount = this.f232c.size();
        int heightPadding = getPaddingBottom() + paddingTop;
        int widthPadding = paddingLeft + getPaddingRight();
        if (sizeDependentWidgetsCount > 0) {
            boolean needSolverPass2 = false;
            int i6 = widthMode;
            boolean containerWrapWidth2 = this.f233d.mo3902j() == C0181a.WRAP_CONTENT;
            int i7 = widthSize;
            boolean containerWrapHeight = this.f233d.mo3916q() == C0181a.WRAP_CONTENT;
            int i8 = heightMode;
            int minWidth = Math.max(this.f233d.mo3920s(), this.f234e);
            int i9 = 0;
            int i10 = paddingLeft;
            childState = 0;
            int i11 = heightSize;
            int minHeight = Math.max(this.f233d.mo3900i(), this.f235f);
            int minWidth2 = minWidth;
            int minWidth3 = i11;
            while (i9 < sizeDependentWidgetsCount) {
                int paddingTop2 = paddingTop;
                C0180h widget = (C0180h) this.f232c.get(i9);
                int sizeDependentWidgetsCount2 = sizeDependentWidgetsCount;
                View child = (View) widget.mo3892e();
                if (child == null) {
                    i = i9;
                    startingWidth3 = startingWidth4;
                    startingHeight = startingHeight2;
                } else {
                    startingHeight = startingHeight2;
                    C0166a params = (C0166a) child.getLayoutParams();
                    startingWidth3 = startingWidth4;
                    if (params.f275Z != 0) {
                        i = i9;
                    } else if (params.f274Y) {
                        i = i9;
                    } else {
                        i = i9;
                        if (child.getVisibility() != 8 && (!optimiseDimensions || !widget.mo3908m().mo3975c() || !widget.mo3906l().mo3975c())) {
                            if (params.width != -2 || !params.f271V) {
                                widthSpec = MeasureSpec.makeMeasureSpec(widget.mo3920s(), 1073741824);
                            } else {
                                widthSpec = ViewGroup.getChildMeasureSpec(i2, widthPadding, params.width);
                            }
                            if (params.height != -2 || !params.f272W) {
                                heightSpec = MeasureSpec.makeMeasureSpec(widget.mo3900i(), 1073741824);
                            } else {
                                heightSpec = ViewGroup.getChildMeasureSpec(i3, heightPadding, params.height);
                            }
                            child.measure(widthSpec, heightSpec);
                            C0200f fVar = this.f249t;
                            if (fVar != null) {
                                int i12 = heightSpec;
                                fVar.f559b++;
                            }
                            REMEASURES_A++;
                            int measuredWidth = child.getMeasuredWidth();
                            int measuredHeight = child.getMeasuredHeight();
                            if (measuredWidth != widget.mo3920s()) {
                                widget.mo3913o(measuredWidth);
                                if (optimiseDimensions) {
                                    widget.mo3908m().mo3970a(measuredWidth);
                                }
                                if (!containerWrapWidth2 || widget.mo3910n() <= minWidth2) {
                                } else {
                                    int i13 = measuredWidth;
                                    minWidth2 = Math.max(minWidth2, widget.mo3910n() + widget.mo3858a(C0178c.RIGHT).mo3841b());
                                }
                                needSolverPass2 = true;
                            }
                            if (measuredHeight != widget.mo3900i()) {
                                widget.mo3897g(measuredHeight);
                                if (optimiseDimensions) {
                                    widget.mo3906l().mo3970a(measuredHeight);
                                }
                                if (containerWrapHeight && widget.mo3887d() > minHeight) {
                                    minHeight = Math.max(minHeight, widget.mo3887d() + widget.mo3858a(C0178c.BOTTOM).mo3841b());
                                }
                                needSolverPass2 = true;
                            }
                            if (params.f273X) {
                                int baseline = child.getBaseline();
                                if (!(baseline == -1 || baseline == widget.mo3882c())) {
                                    widget.mo3895f(baseline);
                                    needSolverPass2 = true;
                                }
                            }
                            if (VERSION.SDK_INT >= 11) {
                                childState = ViewGroup.combineMeasuredStates(childState, child.getMeasuredState());
                            }
                        }
                    }
                }
                i9 = i + 1;
                i2 = widthMeasureSpec;
                i3 = heightMeasureSpec;
                paddingTop = paddingTop2;
                sizeDependentWidgetsCount = sizeDependentWidgetsCount2;
                startingHeight2 = startingHeight;
                startingWidth4 = startingWidth3;
            }
            int sizeDependentWidgetsCount3 = sizeDependentWidgetsCount;
            int i14 = i9;
            int i15 = paddingTop;
            int startingWidth5 = startingWidth4;
            int startingHeight3 = startingHeight2;
            if (needSolverPass2) {
                startingWidth = startingWidth5;
                this.f233d.mo3913o(startingWidth);
                this.f233d.mo3897g(startingHeight3);
                if (optimiseDimensions) {
                    this.f233d.mo3939U();
                }
                mo3779a("2nd pass");
                boolean needSolverPass3 = false;
                if (this.f233d.mo3920s() < minWidth2) {
                    this.f233d.mo3913o(minWidth2);
                    needSolverPass3 = true;
                }
                if (this.f233d.mo3900i() < minHeight) {
                    this.f233d.mo3897g(minHeight);
                    needSolverPass = true;
                } else {
                    needSolverPass = needSolverPass3;
                }
                if (needSolverPass) {
                    mo3779a("3rd pass");
                }
            } else {
                startingWidth = startingWidth5;
            }
            int i16 = 0;
            while (true) {
                int sizeDependentWidgetsCount4 = sizeDependentWidgetsCount3;
                if (i16 >= sizeDependentWidgetsCount4) {
                    break;
                }
                C0180h widget2 = (C0180h) this.f232c.get(i16);
                View child2 = (View) widget2.mo3892e();
                if (child2 == null) {
                    startingWidth2 = startingWidth;
                    containerWrapWidth = containerWrapWidth2;
                } else {
                    startingWidth2 = startingWidth;
                    if (child2.getMeasuredWidth() == widget2.mo3920s() && child2.getMeasuredHeight() == widget2.mo3900i()) {
                        containerWrapWidth = containerWrapWidth2;
                    } else if (widget2.mo3918r() != 8) {
                        int widthSpec2 = MeasureSpec.makeMeasureSpec(widget2.mo3920s(), 1073741824);
                        containerWrapWidth = containerWrapWidth2;
                        int heightSpec2 = MeasureSpec.makeMeasureSpec(widget2.mo3900i(), 1073741824);
                        child2.measure(widthSpec2, heightSpec2);
                        C0200f fVar2 = this.f249t;
                        if (fVar2 != null) {
                            int i17 = widthSpec2;
                            int i18 = heightSpec2;
                            fVar2.f559b++;
                        } else {
                            int i19 = heightSpec2;
                        }
                        REMEASURES_B++;
                    } else {
                        containerWrapWidth = containerWrapWidth2;
                    }
                }
                i16++;
                sizeDependentWidgetsCount3 = sizeDependentWidgetsCount4;
                containerWrapWidth2 = containerWrapWidth;
                startingWidth = startingWidth2;
            }
            boolean z = containerWrapWidth2;
        } else {
            int i20 = widthSize;
            int i21 = heightMode;
            int i22 = heightSize;
            int i23 = paddingLeft;
            int i24 = paddingTop;
            int i25 = startingWidth4;
            int heightMode2 = sizeDependentWidgetsCount;
            int sizeDependentWidgetsCount5 = startingHeight2;
            childState = 0;
        }
        int androidLayoutWidth = this.f233d.mo3920s() + widthPadding;
        int androidLayoutHeight = this.f233d.mo3900i() + heightPadding;
        if (VERSION.SDK_INT >= 11) {
            int resolvedHeightSize = ViewGroup.resolveSizeAndState(androidLayoutHeight, heightMeasureSpec, childState << 16) & 16777215;
            int resolvedWidthSize = Math.min(this.f236g, ViewGroup.resolveSizeAndState(androidLayoutWidth, widthMeasureSpec, childState) & 16777215);
            int resolvedHeightSize2 = Math.min(this.f237h, resolvedHeightSize);
            if (this.f233d.mo3935Q()) {
                resolvedWidthSize |= 16777216;
            }
            if (this.f233d.mo3933O()) {
                resolvedHeightSize2 |= 16777216;
            }
            setMeasuredDimension(resolvedWidthSize, resolvedHeightSize2);
            this.f243n = resolvedWidthSize;
            this.f244o = resolvedHeightSize2;
            return;
        }
        int i26 = widthMeasureSpec;
        int i27 = heightMeasureSpec;
        setMeasuredDimension(androidLayoutWidth, androidLayoutHeight);
        this.f243n = androidLayoutWidth;
        this.f244o = androidLayoutHeight;
    }

    /* renamed from: c */
    private void m888c(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightPadding = getPaddingTop() + getPaddingBottom();
        int widthPadding = getPaddingLeft() + getPaddingRight();
        C0181a widthBehaviour = C0181a.FIXED;
        C0181a heightBehaviour = C0181a.FIXED;
        int desiredWidth = 0;
        int desiredHeight = 0;
        LayoutParams layoutParams = getLayoutParams();
        if (widthMode == Integer.MIN_VALUE) {
            widthBehaviour = C0181a.WRAP_CONTENT;
            desiredWidth = widthSize;
        } else if (widthMode == 0) {
            widthBehaviour = C0181a.WRAP_CONTENT;
        } else if (widthMode == 1073741824) {
            desiredWidth = Math.min(this.f236g, widthSize) - widthPadding;
        }
        if (heightMode == Integer.MIN_VALUE) {
            heightBehaviour = C0181a.WRAP_CONTENT;
            desiredHeight = heightSize;
        } else if (heightMode == 0) {
            heightBehaviour = C0181a.WRAP_CONTENT;
        } else if (heightMode == 1073741824) {
            desiredHeight = Math.min(this.f237h, heightSize) - heightPadding;
        }
        this.f233d.mo3907l(0);
        this.f233d.mo3905k(0);
        this.f233d.mo3865a(widthBehaviour);
        this.f233d.mo3913o(desiredWidth);
        this.f233d.mo3878b(heightBehaviour);
        this.f233d.mo3897g(desiredHeight);
        this.f233d.mo3907l((this.f234e - getPaddingLeft()) - getPaddingRight());
        this.f233d.mo3905k((this.f235f - getPaddingTop()) - getPaddingBottom());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3779a(String reason) {
        this.f233d.mo3930K();
        C0200f fVar = this.f249t;
        if (fVar != null) {
            fVar.f560c++;
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int widgetsCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i = 0; i < widgetsCount; i++) {
            View child = getChildAt(i);
            C0166a params = (C0166a) child.getLayoutParams();
            C0180h widget = params.f299la;
            if ((child.getVisibility() != 8 || params.f274Y || params.f275Z || isInEditMode) && !params.f277aa) {
                int l = widget.mo3896g();
                int t = widget.mo3898h();
                int r = widget.mo3920s() + l;
                int b = widget.mo3900i() + t;
                child.layout(l, t, r, b);
                if (child instanceof C0212g) {
                    View content = ((C0212g) child).getContent();
                    if (content != null) {
                        content.setVisibility(0);
                        content.layout(l, t, r, b);
                    }
                }
            }
        }
        int helperCount = this.f231b.size();
        if (helperCount > 0) {
            for (int i2 = 0; i2 < helperCount; i2++) {
                ((C0205b) this.f231b.get(i2)).mo3807a(this);
            }
        }
    }

    public void setOptimizationLevel(int level) {
        this.f233d.mo3945u(level);
    }

    public int getOptimizationLevel() {
        return this.f233d.mo3931M();
    }

    public C0166a generateLayoutParams(AttributeSet attrs) {
        return new C0166a(getContext(), attrs);
    }

    /* access modifiers changed from: protected */
    public C0166a generateDefaultLayoutParams() {
        return new C0166a(-2, -2);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateLayoutParams(LayoutParams p) {
        return new C0166a(p);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(LayoutParams p) {
        return p instanceof C0166a;
    }

    public void setConstraintSet(C0207d set) {
        this.f240k = set;
    }

    /* renamed from: a */
    public View mo3776a(int id) {
        return (View) this.f230a.get(id);
    }

    public void dispatchDraw(Canvas canvas) {
        float ow;
        float ch;
        float cw;
        int count;
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int count2 = getChildCount();
            float cw2 = (float) getWidth();
            float ch2 = (float) getHeight();
            float ow2 = 1080.0f;
            int i = 0;
            while (i < count2) {
                View child = getChildAt(i);
                if (child.getVisibility() == 8) {
                    count = count2;
                    cw = cw2;
                    ch = ch2;
                    ow = ow2;
                } else {
                    Object tag = child.getTag();
                    if (tag == null || !(tag instanceof String)) {
                        count = count2;
                        cw = cw2;
                        ch = ch2;
                        ow = ow2;
                    } else {
                        String[] split = ((String) tag).split(",");
                        if (split.length == 4) {
                            int x = Integer.parseInt(split[0]);
                            int y = Integer.parseInt(split[1]);
                            int x2 = (int) ((((float) x) / ow2) * cw2);
                            int y2 = (int) ((((float) y) / 1920.0f) * ch2);
                            int w = (int) ((((float) Integer.parseInt(split[2])) / ow2) * cw2);
                            int h = (int) ((((float) Integer.parseInt(split[3])) / 1920.0f) * ch2);
                            Paint paint = new Paint();
                            count = count2;
                            paint.setColor(-65536);
                            cw = cw2;
                            ch = ch2;
                            ow = ow2;
                            Canvas canvas2 = canvas;
                            Paint paint2 = paint;
                            canvas2.drawLine((float) x2, (float) y2, (float) (x2 + w), (float) y2, paint2);
                            canvas2.drawLine((float) (x2 + w), (float) y2, (float) (x2 + w), (float) (y2 + h), paint2);
                            canvas2.drawLine((float) (x2 + w), (float) (y2 + h), (float) x2, (float) (y2 + h), paint2);
                            canvas2.drawLine((float) x2, (float) (y2 + h), (float) x2, (float) y2, paint2);
                            paint.setColor(-16711936);
                            canvas2.drawLine((float) x2, (float) y2, (float) (x2 + w), (float) (y2 + h), paint2);
                            canvas2.drawLine((float) x2, (float) (y2 + h), (float) (x2 + w), (float) y2, paint2);
                        } else {
                            count = count2;
                            cw = cw2;
                            ch = ch2;
                            ow = ow2;
                        }
                    }
                }
                i++;
                count2 = count;
                cw2 = cw;
                ch2 = ch;
                ow2 = ow;
            }
            int i2 = count2;
            float f = cw2;
            float f2 = ch2;
            float f3 = ow2;
            return;
        }
    }

    public void requestLayout() {
        super.requestLayout();
        this.f238i = true;
        this.f243n = -1;
        this.f244o = -1;
        this.f245p = -1;
        this.f246q = -1;
        this.f247r = 0;
        this.f248s = 0;
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
