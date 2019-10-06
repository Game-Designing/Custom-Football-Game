package android.support.constraint;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.constraint.C0209e.C0210a;
import android.support.constraint.ConstraintLayout.C0166a;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.View;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: android.support.constraint.d */
/* compiled from: ConstraintSet */
public class C0207d {

    /* renamed from: a */
    private static final int[] f613a = {0, 4, 8};

    /* renamed from: b */
    private static SparseIntArray f614b = new SparseIntArray();

    /* renamed from: c */
    private HashMap<Integer, C0208a> f615c = new HashMap<>();

    /* renamed from: android.support.constraint.d$a */
    /* compiled from: ConstraintSet */
    private static class C0208a {

        /* renamed from: A */
        public int f616A;

        /* renamed from: B */
        public int f617B;

        /* renamed from: C */
        public int f618C;

        /* renamed from: D */
        public int f619D;

        /* renamed from: E */
        public int f620E;

        /* renamed from: F */
        public int f621F;

        /* renamed from: G */
        public int f622G;

        /* renamed from: H */
        public int f623H;

        /* renamed from: I */
        public int f624I;

        /* renamed from: J */
        public int f625J;

        /* renamed from: K */
        public int f626K;

        /* renamed from: L */
        public int f627L;

        /* renamed from: M */
        public int f628M;

        /* renamed from: N */
        public int f629N;

        /* renamed from: O */
        public int f630O;

        /* renamed from: P */
        public int f631P;

        /* renamed from: Q */
        public float f632Q;

        /* renamed from: R */
        public float f633R;

        /* renamed from: S */
        public int f634S;

        /* renamed from: T */
        public int f635T;

        /* renamed from: U */
        public float f636U;

        /* renamed from: V */
        public boolean f637V;

        /* renamed from: W */
        public float f638W;

        /* renamed from: X */
        public float f639X;

        /* renamed from: Y */
        public float f640Y;

        /* renamed from: Z */
        public float f641Z;

        /* renamed from: a */
        boolean f642a;

        /* renamed from: aa */
        public float f643aa;

        /* renamed from: b */
        public int f644b;

        /* renamed from: ba */
        public float f645ba;

        /* renamed from: c */
        public int f646c;

        /* renamed from: ca */
        public float f647ca;

        /* renamed from: d */
        int f648d;

        /* renamed from: da */
        public float f649da;

        /* renamed from: e */
        public int f650e;

        /* renamed from: ea */
        public float f651ea;

        /* renamed from: f */
        public int f652f;

        /* renamed from: fa */
        public float f653fa;

        /* renamed from: g */
        public float f654g;

        /* renamed from: ga */
        public float f655ga;

        /* renamed from: h */
        public int f656h;

        /* renamed from: ha */
        public boolean f657ha;

        /* renamed from: i */
        public int f658i;

        /* renamed from: ia */
        public boolean f659ia;

        /* renamed from: j */
        public int f660j;

        /* renamed from: ja */
        public int f661ja;

        /* renamed from: k */
        public int f662k;

        /* renamed from: ka */
        public int f663ka;

        /* renamed from: l */
        public int f664l;

        /* renamed from: la */
        public int f665la;

        /* renamed from: m */
        public int f666m;

        /* renamed from: ma */
        public int f667ma;

        /* renamed from: n */
        public int f668n;

        /* renamed from: na */
        public int f669na;

        /* renamed from: o */
        public int f670o;

        /* renamed from: oa */
        public int f671oa;

        /* renamed from: p */
        public int f672p;

        /* renamed from: pa */
        public float f673pa;

        /* renamed from: q */
        public int f674q;

        /* renamed from: qa */
        public float f675qa;

        /* renamed from: r */
        public int f676r;

        /* renamed from: ra */
        public boolean f677ra;

        /* renamed from: s */
        public int f678s;

        /* renamed from: sa */
        public int f679sa;

        /* renamed from: t */
        public int f680t;

        /* renamed from: ta */
        public int f681ta;

        /* renamed from: u */
        public float f682u;

        /* renamed from: ua */
        public int[] f683ua;

        /* renamed from: v */
        public float f684v;

        /* renamed from: va */
        public String f685va;

        /* renamed from: w */
        public String f686w;

        /* renamed from: x */
        public int f687x;

        /* renamed from: y */
        public int f688y;

        /* renamed from: z */
        public float f689z;

        private C0208a() {
            this.f642a = false;
            this.f650e = -1;
            this.f652f = -1;
            this.f654g = -1.0f;
            this.f656h = -1;
            this.f658i = -1;
            this.f660j = -1;
            this.f662k = -1;
            this.f664l = -1;
            this.f666m = -1;
            this.f668n = -1;
            this.f670o = -1;
            this.f672p = -1;
            this.f674q = -1;
            this.f676r = -1;
            this.f678s = -1;
            this.f680t = -1;
            this.f682u = 0.5f;
            this.f684v = 0.5f;
            this.f686w = null;
            this.f687x = -1;
            this.f688y = 0;
            this.f689z = 0.0f;
            this.f616A = -1;
            this.f617B = -1;
            this.f618C = -1;
            this.f619D = -1;
            this.f620E = -1;
            this.f621F = -1;
            this.f622G = -1;
            this.f623H = -1;
            this.f624I = -1;
            this.f625J = 0;
            this.f626K = -1;
            this.f627L = -1;
            this.f628M = -1;
            this.f629N = -1;
            this.f630O = -1;
            this.f631P = -1;
            this.f632Q = 0.0f;
            this.f633R = 0.0f;
            this.f634S = 0;
            this.f635T = 0;
            this.f636U = 1.0f;
            this.f637V = false;
            this.f638W = 0.0f;
            this.f639X = 0.0f;
            this.f640Y = 0.0f;
            this.f641Z = 0.0f;
            this.f643aa = 1.0f;
            this.f645ba = 1.0f;
            this.f647ca = Float.NaN;
            this.f649da = Float.NaN;
            this.f651ea = 0.0f;
            this.f653fa = 0.0f;
            this.f655ga = 0.0f;
            this.f657ha = false;
            this.f659ia = false;
            this.f661ja = 0;
            this.f663ka = 0;
            this.f665la = -1;
            this.f667ma = -1;
            this.f669na = -1;
            this.f671oa = -1;
            this.f673pa = 1.0f;
            this.f675qa = 1.0f;
            this.f677ra = false;
            this.f679sa = -1;
            this.f681ta = -1;
        }

        public C0208a clone() {
            C0208a clone = new C0208a();
            clone.f642a = this.f642a;
            clone.f644b = this.f644b;
            clone.f646c = this.f646c;
            clone.f650e = this.f650e;
            clone.f652f = this.f652f;
            clone.f654g = this.f654g;
            clone.f656h = this.f656h;
            clone.f658i = this.f658i;
            clone.f660j = this.f660j;
            clone.f662k = this.f662k;
            clone.f664l = this.f664l;
            clone.f666m = this.f666m;
            clone.f668n = this.f668n;
            clone.f670o = this.f670o;
            clone.f672p = this.f672p;
            clone.f674q = this.f674q;
            clone.f676r = this.f676r;
            clone.f678s = this.f678s;
            clone.f680t = this.f680t;
            clone.f682u = this.f682u;
            clone.f684v = this.f684v;
            clone.f686w = this.f686w;
            clone.f616A = this.f616A;
            clone.f617B = this.f617B;
            clone.f682u = this.f682u;
            clone.f682u = this.f682u;
            clone.f682u = this.f682u;
            clone.f682u = this.f682u;
            clone.f682u = this.f682u;
            clone.f618C = this.f618C;
            clone.f619D = this.f619D;
            clone.f620E = this.f620E;
            clone.f621F = this.f621F;
            clone.f622G = this.f622G;
            clone.f623H = this.f623H;
            clone.f624I = this.f624I;
            clone.f625J = this.f625J;
            clone.f626K = this.f626K;
            clone.f627L = this.f627L;
            clone.f628M = this.f628M;
            clone.f629N = this.f629N;
            clone.f630O = this.f630O;
            clone.f631P = this.f631P;
            clone.f632Q = this.f632Q;
            clone.f633R = this.f633R;
            clone.f634S = this.f634S;
            clone.f635T = this.f635T;
            clone.f636U = this.f636U;
            clone.f637V = this.f637V;
            clone.f638W = this.f638W;
            clone.f639X = this.f639X;
            clone.f640Y = this.f640Y;
            clone.f641Z = this.f641Z;
            clone.f643aa = this.f643aa;
            clone.f645ba = this.f645ba;
            clone.f647ca = this.f647ca;
            clone.f649da = this.f649da;
            clone.f651ea = this.f651ea;
            clone.f653fa = this.f653fa;
            clone.f655ga = this.f655ga;
            clone.f657ha = this.f657ha;
            clone.f659ia = this.f659ia;
            clone.f661ja = this.f661ja;
            clone.f663ka = this.f663ka;
            clone.f665la = this.f665la;
            clone.f667ma = this.f667ma;
            clone.f669na = this.f669na;
            clone.f671oa = this.f671oa;
            clone.f673pa = this.f673pa;
            clone.f675qa = this.f675qa;
            clone.f679sa = this.f679sa;
            clone.f681ta = this.f681ta;
            int[] iArr = this.f683ua;
            if (iArr != null) {
                clone.f683ua = Arrays.copyOf(iArr, iArr.length);
            }
            clone.f687x = this.f687x;
            clone.f688y = this.f688y;
            clone.f689z = this.f689z;
            clone.f677ra = this.f677ra;
            return clone;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m1207a(C0205b helper, int viewId, C0210a param) {
            m1206a(viewId, param);
            if (helper instanceof C0168a) {
                this.f681ta = 1;
                C0168a barrier = (C0168a) helper;
                this.f679sa = barrier.getType();
                this.f683ua = barrier.getReferencedIds();
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m1206a(int viewId, C0210a param) {
            m1205a(viewId, (C0166a) param);
            this.f636U = param.f691na;
            this.f639X = param.f694qa;
            this.f640Y = param.f695ra;
            this.f641Z = param.f696sa;
            this.f643aa = param.f697ta;
            this.f645ba = param.f698ua;
            this.f647ca = param.f699va;
            this.f649da = param.f700wa;
            this.f651ea = param.f701xa;
            this.f653fa = param.f702ya;
            this.f655ga = param.f703za;
            this.f638W = param.f693pa;
            this.f637V = param.f692oa;
        }

        /* renamed from: a */
        private void m1205a(int viewId, C0166a param) {
            this.f648d = viewId;
            this.f656h = param.f282d;
            this.f658i = param.f284e;
            this.f660j = param.f286f;
            this.f662k = param.f288g;
            this.f664l = param.f290h;
            this.f666m = param.f292i;
            this.f668n = param.f294j;
            this.f670o = param.f296k;
            this.f672p = param.f298l;
            this.f674q = param.f304p;
            this.f676r = param.f305q;
            this.f678s = param.f306r;
            this.f680t = param.f307s;
            this.f682u = param.f314z;
            this.f684v = param.f250A;
            this.f686w = param.f251B;
            this.f687x = param.f300m;
            this.f688y = param.f302n;
            this.f689z = param.f303o;
            this.f616A = param.f266Q;
            this.f617B = param.f267R;
            this.f618C = param.f268S;
            this.f654g = param.f280c;
            this.f650e = param.f276a;
            this.f652f = param.f278b;
            this.f644b = param.width;
            this.f646c = param.height;
            this.f619D = param.leftMargin;
            this.f620E = param.rightMargin;
            this.f621F = param.topMargin;
            this.f622G = param.bottomMargin;
            this.f632Q = param.f255F;
            this.f633R = param.f254E;
            this.f635T = param.f257H;
            this.f634S = param.f256G;
            boolean z = param.f269T;
            this.f657ha = z;
            this.f659ia = param.f270U;
            this.f661ja = param.f258I;
            this.f663ka = param.f259J;
            this.f657ha = z;
            this.f665la = param.f262M;
            this.f667ma = param.f263N;
            this.f669na = param.f260K;
            this.f671oa = param.f261L;
            this.f673pa = param.f264O;
            this.f675qa = param.f265P;
            if (VERSION.SDK_INT >= 17) {
                this.f623H = param.getMarginEnd();
                this.f624I = param.getMarginStart();
            }
        }

        /* renamed from: a */
        public void mo4050a(C0166a param) {
            param.f282d = this.f656h;
            param.f284e = this.f658i;
            param.f286f = this.f660j;
            param.f288g = this.f662k;
            param.f290h = this.f664l;
            param.f292i = this.f666m;
            param.f294j = this.f668n;
            param.f296k = this.f670o;
            param.f298l = this.f672p;
            param.f304p = this.f674q;
            param.f305q = this.f676r;
            param.f306r = this.f678s;
            param.f307s = this.f680t;
            param.leftMargin = this.f619D;
            param.rightMargin = this.f620E;
            param.topMargin = this.f621F;
            param.bottomMargin = this.f622G;
            param.f312x = this.f631P;
            param.f313y = this.f630O;
            param.f314z = this.f682u;
            param.f250A = this.f684v;
            param.f300m = this.f687x;
            param.f302n = this.f688y;
            param.f303o = this.f689z;
            param.f251B = this.f686w;
            param.f266Q = this.f616A;
            param.f267R = this.f617B;
            param.f255F = this.f632Q;
            param.f254E = this.f633R;
            param.f257H = this.f635T;
            param.f256G = this.f634S;
            param.f269T = this.f657ha;
            param.f270U = this.f659ia;
            param.f258I = this.f661ja;
            param.f259J = this.f663ka;
            param.f262M = this.f665la;
            param.f263N = this.f667ma;
            param.f260K = this.f669na;
            param.f261L = this.f671oa;
            param.f264O = this.f673pa;
            param.f265P = this.f675qa;
            param.f268S = this.f618C;
            param.f280c = this.f654g;
            param.f276a = this.f650e;
            param.f278b = this.f652f;
            param.width = this.f644b;
            param.height = this.f646c;
            if (VERSION.SDK_INT >= 17) {
                param.setMarginStart(this.f624I);
                param.setMarginEnd(this.f623H);
            }
            param.mo3805a();
        }
    }

    static {
        f614b.append(C0214i.ConstraintSet_layout_constraintLeft_toLeftOf, 25);
        f614b.append(C0214i.ConstraintSet_layout_constraintLeft_toRightOf, 26);
        f614b.append(C0214i.ConstraintSet_layout_constraintRight_toLeftOf, 29);
        f614b.append(C0214i.ConstraintSet_layout_constraintRight_toRightOf, 30);
        f614b.append(C0214i.ConstraintSet_layout_constraintTop_toTopOf, 36);
        f614b.append(C0214i.ConstraintSet_layout_constraintTop_toBottomOf, 35);
        f614b.append(C0214i.ConstraintSet_layout_constraintBottom_toTopOf, 4);
        f614b.append(C0214i.ConstraintSet_layout_constraintBottom_toBottomOf, 3);
        f614b.append(C0214i.ConstraintSet_layout_constraintBaseline_toBaselineOf, 1);
        f614b.append(C0214i.ConstraintSet_layout_editor_absoluteX, 6);
        f614b.append(C0214i.ConstraintSet_layout_editor_absoluteY, 7);
        f614b.append(C0214i.ConstraintSet_layout_constraintGuide_begin, 17);
        f614b.append(C0214i.ConstraintSet_layout_constraintGuide_end, 18);
        f614b.append(C0214i.ConstraintSet_layout_constraintGuide_percent, 19);
        f614b.append(C0214i.ConstraintSet_android_orientation, 27);
        f614b.append(C0214i.ConstraintSet_layout_constraintStart_toEndOf, 32);
        f614b.append(C0214i.ConstraintSet_layout_constraintStart_toStartOf, 33);
        f614b.append(C0214i.ConstraintSet_layout_constraintEnd_toStartOf, 10);
        f614b.append(C0214i.ConstraintSet_layout_constraintEnd_toEndOf, 9);
        f614b.append(C0214i.ConstraintSet_layout_goneMarginLeft, 13);
        f614b.append(C0214i.ConstraintSet_layout_goneMarginTop, 16);
        f614b.append(C0214i.ConstraintSet_layout_goneMarginRight, 14);
        f614b.append(C0214i.ConstraintSet_layout_goneMarginBottom, 11);
        f614b.append(C0214i.ConstraintSet_layout_goneMarginStart, 15);
        f614b.append(C0214i.ConstraintSet_layout_goneMarginEnd, 12);
        f614b.append(C0214i.ConstraintSet_layout_constraintVertical_weight, 40);
        f614b.append(C0214i.ConstraintSet_layout_constraintHorizontal_weight, 39);
        f614b.append(C0214i.ConstraintSet_layout_constraintHorizontal_chainStyle, 41);
        f614b.append(C0214i.ConstraintSet_layout_constraintVertical_chainStyle, 42);
        f614b.append(C0214i.ConstraintSet_layout_constraintHorizontal_bias, 20);
        f614b.append(C0214i.ConstraintSet_layout_constraintVertical_bias, 37);
        f614b.append(C0214i.ConstraintSet_layout_constraintDimensionRatio, 5);
        f614b.append(C0214i.ConstraintSet_layout_constraintLeft_creator, 75);
        f614b.append(C0214i.ConstraintSet_layout_constraintTop_creator, 75);
        f614b.append(C0214i.ConstraintSet_layout_constraintRight_creator, 75);
        f614b.append(C0214i.ConstraintSet_layout_constraintBottom_creator, 75);
        f614b.append(C0214i.ConstraintSet_layout_constraintBaseline_creator, 75);
        f614b.append(C0214i.ConstraintSet_android_layout_marginLeft, 24);
        f614b.append(C0214i.ConstraintSet_android_layout_marginRight, 28);
        f614b.append(C0214i.ConstraintSet_android_layout_marginStart, 31);
        f614b.append(C0214i.ConstraintSet_android_layout_marginEnd, 8);
        f614b.append(C0214i.ConstraintSet_android_layout_marginTop, 34);
        f614b.append(C0214i.ConstraintSet_android_layout_marginBottom, 2);
        f614b.append(C0214i.ConstraintSet_android_layout_width, 23);
        f614b.append(C0214i.ConstraintSet_android_layout_height, 21);
        f614b.append(C0214i.ConstraintSet_android_visibility, 22);
        f614b.append(C0214i.ConstraintSet_android_alpha, 43);
        f614b.append(C0214i.ConstraintSet_android_elevation, 44);
        f614b.append(C0214i.ConstraintSet_android_rotationX, 45);
        f614b.append(C0214i.ConstraintSet_android_rotationY, 46);
        f614b.append(C0214i.ConstraintSet_android_rotation, 60);
        f614b.append(C0214i.ConstraintSet_android_scaleX, 47);
        f614b.append(C0214i.ConstraintSet_android_scaleY, 48);
        f614b.append(C0214i.ConstraintSet_android_transformPivotX, 49);
        f614b.append(C0214i.ConstraintSet_android_transformPivotY, 50);
        f614b.append(C0214i.ConstraintSet_android_translationX, 51);
        f614b.append(C0214i.ConstraintSet_android_translationY, 52);
        f614b.append(C0214i.ConstraintSet_android_translationZ, 53);
        f614b.append(C0214i.ConstraintSet_layout_constraintWidth_default, 54);
        f614b.append(C0214i.ConstraintSet_layout_constraintHeight_default, 55);
        f614b.append(C0214i.ConstraintSet_layout_constraintWidth_max, 56);
        f614b.append(C0214i.ConstraintSet_layout_constraintHeight_max, 57);
        f614b.append(C0214i.ConstraintSet_layout_constraintWidth_min, 58);
        f614b.append(C0214i.ConstraintSet_layout_constraintHeight_min, 59);
        f614b.append(C0214i.ConstraintSet_layout_constraintCircle, 61);
        f614b.append(C0214i.ConstraintSet_layout_constraintCircleRadius, 62);
        f614b.append(C0214i.ConstraintSet_layout_constraintCircleAngle, 63);
        f614b.append(C0214i.ConstraintSet_android_id, 38);
        f614b.append(C0214i.ConstraintSet_layout_constraintWidth_percent, 69);
        f614b.append(C0214i.ConstraintSet_layout_constraintHeight_percent, 70);
        f614b.append(C0214i.ConstraintSet_chainUseRtl, 71);
        f614b.append(C0214i.ConstraintSet_barrierDirection, 72);
        f614b.append(C0214i.ConstraintSet_constraint_referenced_ids, 73);
        f614b.append(C0214i.ConstraintSet_barrierAllowsGoneWidgets, 74);
    }

    /* renamed from: a */
    public void mo4049a(C0209e constraints) {
        int count = constraints.getChildCount();
        this.f615c.clear();
        int i = 0;
        while (i < count) {
            View view = constraints.getChildAt(i);
            C0210a param = (C0210a) view.getLayoutParams();
            int id = view.getId();
            if (id != -1) {
                if (!this.f615c.containsKey(Integer.valueOf(id))) {
                    this.f615c.put(Integer.valueOf(id), new C0208a());
                }
                C0208a constraint = (C0208a) this.f615c.get(Integer.valueOf(id));
                if (view instanceof C0205b) {
                    constraint.m1207a((C0205b) view, id, param);
                }
                constraint.m1206a(id, param);
                i++;
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4048a(ConstraintLayout constraintLayout) {
        int count = constraintLayout.getChildCount();
        HashSet<Integer> used = new HashSet<>(this.f615c.keySet());
        int i = 0;
        while (i < count) {
            View view = constraintLayout.getChildAt(i);
            int id = view.getId();
            if (id != -1) {
                if (this.f615c.containsKey(Integer.valueOf(id))) {
                    used.remove(Integer.valueOf(id));
                    C0208a constraint = (C0208a) this.f615c.get(Integer.valueOf(id));
                    if (view instanceof C0168a) {
                        constraint.f681ta = 1;
                    }
                    int i2 = constraint.f681ta;
                    if (i2 != -1 && i2 == 1) {
                        C0168a barrier = (C0168a) view;
                        barrier.setId(id);
                        barrier.setType(constraint.f679sa);
                        barrier.setAllowsGoneWidget(constraint.f677ra);
                        int[] iArr = constraint.f683ua;
                        if (iArr != null) {
                            barrier.setReferencedIds(iArr);
                        } else {
                            String str = constraint.f685va;
                            if (str != null) {
                                constraint.f683ua = m1201a((View) barrier, str);
                                barrier.setReferencedIds(constraint.f683ua);
                            }
                        }
                    }
                    C0166a param = (C0166a) view.getLayoutParams();
                    constraint.mo4050a(param);
                    view.setLayoutParams(param);
                    view.setVisibility(constraint.f625J);
                    if (VERSION.SDK_INT >= 17) {
                        view.setAlpha(constraint.f636U);
                        view.setRotation(constraint.f639X);
                        view.setRotationX(constraint.f640Y);
                        view.setRotationY(constraint.f641Z);
                        view.setScaleX(constraint.f643aa);
                        view.setScaleY(constraint.f645ba);
                        if (!Float.isNaN(constraint.f647ca)) {
                            view.setPivotX(constraint.f647ca);
                        }
                        if (!Float.isNaN(constraint.f649da)) {
                            view.setPivotY(constraint.f649da);
                        }
                        view.setTranslationX(constraint.f651ea);
                        view.setTranslationY(constraint.f653fa);
                        if (VERSION.SDK_INT >= 21) {
                            view.setTranslationZ(constraint.f655ga);
                            if (constraint.f637V) {
                                view.setElevation(constraint.f638W);
                            }
                        }
                    }
                }
                i++;
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
        Iterator it = used.iterator();
        while (it.hasNext()) {
            Integer id2 = (Integer) it.next();
            C0208a constraint2 = (C0208a) this.f615c.get(id2);
            int i3 = constraint2.f681ta;
            if (i3 != -1 && i3 == 1) {
                C0168a barrier2 = new C0168a(constraintLayout.getContext());
                barrier2.setId(id2.intValue());
                int[] iArr2 = constraint2.f683ua;
                if (iArr2 != null) {
                    barrier2.setReferencedIds(iArr2);
                } else {
                    String str2 = constraint2.f685va;
                    if (str2 != null) {
                        constraint2.f683ua = m1201a((View) barrier2, str2);
                        barrier2.setReferencedIds(constraint2.f683ua);
                    }
                }
                barrier2.setType(constraint2.f679sa);
                C0166a param2 = constraintLayout.generateDefaultLayoutParams();
                barrier2.mo4040a();
                constraint2.mo4050a(param2);
                constraintLayout.addView(barrier2, param2);
            }
            if (constraint2.f642a) {
                C0211f g = new C0211f(constraintLayout.getContext());
                g.setId(id2.intValue());
                C0166a param3 = constraintLayout.generateDefaultLayoutParams();
                constraint2.mo4050a(param3);
                constraintLayout.addView(g, param3);
            }
        }
    }

    /* renamed from: a */
    public void mo4047a(Context context, int resourceId) {
        XmlPullParser parser = context.getResources().getXml(resourceId);
        try {
            for (int eventType = parser.getEventType(); eventType != 1; eventType = parser.next()) {
                if (eventType == 0) {
                    String document = parser.getName();
                } else if (eventType == 2) {
                    String tagName = parser.getName();
                    C0208a constraint = m1199a(context, Xml.asAttributeSet(parser));
                    if (tagName.equalsIgnoreCase("Guideline")) {
                        constraint.f642a = true;
                    }
                    this.f615c.put(Integer.valueOf(constraint.f648d), constraint);
                } else if (eventType != 3) {
                }
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: a */
    private static int m1198a(TypedArray a, int index, int def) {
        int ret = a.getResourceId(index, def);
        if (ret == -1) {
            return a.getInt(index, -1);
        }
        return ret;
    }

    /* renamed from: a */
    private C0208a m1199a(Context context, AttributeSet attrs) {
        C0208a c = new C0208a();
        TypedArray a = context.obtainStyledAttributes(attrs, C0214i.ConstraintSet);
        m1200a(c, a);
        a.recycle();
        return c;
    }

    /* renamed from: a */
    private void m1200a(C0208a c, TypedArray a) {
        int N = a.getIndexCount();
        for (int i = 0; i < N; i++) {
            int attr = a.getIndex(i);
            int i2 = f614b.get(attr);
            switch (i2) {
                case 1:
                    c.f672p = m1198a(a, attr, c.f672p);
                    break;
                case 2:
                    c.f622G = a.getDimensionPixelSize(attr, c.f622G);
                    break;
                case 3:
                    c.f670o = m1198a(a, attr, c.f670o);
                    break;
                case 4:
                    c.f668n = m1198a(a, attr, c.f668n);
                    break;
                case 5:
                    c.f686w = a.getString(attr);
                    break;
                case 6:
                    c.f616A = a.getDimensionPixelOffset(attr, c.f616A);
                    break;
                case 7:
                    c.f617B = a.getDimensionPixelOffset(attr, c.f617B);
                    break;
                case 8:
                    c.f623H = a.getDimensionPixelSize(attr, c.f623H);
                    break;
                case 9:
                    c.f680t = m1198a(a, attr, c.f680t);
                    break;
                case 10:
                    c.f678s = m1198a(a, attr, c.f678s);
                    break;
                case 11:
                    c.f629N = a.getDimensionPixelSize(attr, c.f629N);
                    break;
                case 12:
                    c.f630O = a.getDimensionPixelSize(attr, c.f630O);
                    break;
                case 13:
                    c.f626K = a.getDimensionPixelSize(attr, c.f626K);
                    break;
                case 14:
                    c.f628M = a.getDimensionPixelSize(attr, c.f628M);
                    break;
                case 15:
                    c.f631P = a.getDimensionPixelSize(attr, c.f631P);
                    break;
                case 16:
                    c.f627L = a.getDimensionPixelSize(attr, c.f627L);
                    break;
                case 17:
                    c.f650e = a.getDimensionPixelOffset(attr, c.f650e);
                    break;
                case 18:
                    c.f652f = a.getDimensionPixelOffset(attr, c.f652f);
                    break;
                case 19:
                    c.f654g = a.getFloat(attr, c.f654g);
                    break;
                case 20:
                    c.f682u = a.getFloat(attr, c.f682u);
                    break;
                case 21:
                    c.f646c = a.getLayoutDimension(attr, c.f646c);
                    break;
                case 22:
                    c.f625J = a.getInt(attr, c.f625J);
                    c.f625J = f613a[c.f625J];
                    break;
                case 23:
                    c.f644b = a.getLayoutDimension(attr, c.f644b);
                    break;
                case 24:
                    c.f619D = a.getDimensionPixelSize(attr, c.f619D);
                    break;
                case 25:
                    c.f656h = m1198a(a, attr, c.f656h);
                    break;
                case 26:
                    c.f658i = m1198a(a, attr, c.f658i);
                    break;
                case 27:
                    c.f618C = a.getInt(attr, c.f618C);
                    break;
                case 28:
                    c.f620E = a.getDimensionPixelSize(attr, c.f620E);
                    break;
                case 29:
                    c.f660j = m1198a(a, attr, c.f660j);
                    break;
                case 30:
                    c.f662k = m1198a(a, attr, c.f662k);
                    break;
                case 31:
                    c.f624I = a.getDimensionPixelSize(attr, c.f624I);
                    break;
                case 32:
                    c.f674q = m1198a(a, attr, c.f674q);
                    break;
                case 33:
                    c.f676r = m1198a(a, attr, c.f676r);
                    break;
                case 34:
                    c.f621F = a.getDimensionPixelSize(attr, c.f621F);
                    break;
                case 35:
                    c.f666m = m1198a(a, attr, c.f666m);
                    break;
                case 36:
                    c.f664l = m1198a(a, attr, c.f664l);
                    break;
                case 37:
                    c.f684v = a.getFloat(attr, c.f684v);
                    break;
                case 38:
                    c.f648d = a.getResourceId(attr, c.f648d);
                    break;
                case 39:
                    c.f633R = a.getFloat(attr, c.f633R);
                    break;
                case 40:
                    c.f632Q = a.getFloat(attr, c.f632Q);
                    break;
                case 41:
                    c.f634S = a.getInt(attr, c.f634S);
                    break;
                case 42:
                    c.f635T = a.getInt(attr, c.f635T);
                    break;
                case 43:
                    c.f636U = a.getFloat(attr, c.f636U);
                    break;
                case 44:
                    c.f637V = true;
                    c.f638W = a.getDimension(attr, c.f638W);
                    break;
                case 45:
                    c.f640Y = a.getFloat(attr, c.f640Y);
                    break;
                case 46:
                    c.f641Z = a.getFloat(attr, c.f641Z);
                    break;
                case 47:
                    c.f643aa = a.getFloat(attr, c.f643aa);
                    break;
                case 48:
                    c.f645ba = a.getFloat(attr, c.f645ba);
                    break;
                case 49:
                    c.f647ca = a.getFloat(attr, c.f647ca);
                    break;
                case 50:
                    c.f649da = a.getFloat(attr, c.f649da);
                    break;
                case 51:
                    c.f651ea = a.getDimension(attr, c.f651ea);
                    break;
                case 52:
                    c.f653fa = a.getDimension(attr, c.f653fa);
                    break;
                case 53:
                    c.f655ga = a.getDimension(attr, c.f655ga);
                    break;
                default:
                    switch (i2) {
                        case 60:
                            c.f639X = a.getFloat(attr, c.f639X);
                            break;
                        case 61:
                            c.f687x = m1198a(a, attr, c.f687x);
                            break;
                        case 62:
                            c.f688y = a.getDimensionPixelSize(attr, c.f688y);
                            break;
                        case 63:
                            c.f689z = a.getFloat(attr, c.f689z);
                            break;
                        default:
                            String str = "   ";
                            String str2 = "ConstraintSet";
                            switch (i2) {
                                case 69:
                                    c.f673pa = a.getFloat(attr, 1.0f);
                                    break;
                                case 70:
                                    c.f675qa = a.getFloat(attr, 1.0f);
                                    break;
                                case 71:
                                    Log.e(str2, "CURRENTLY UNSUPPORTED");
                                    break;
                                case 72:
                                    c.f679sa = a.getInt(attr, c.f679sa);
                                    break;
                                case 73:
                                    c.f685va = a.getString(attr);
                                    break;
                                case 74:
                                    c.f677ra = a.getBoolean(attr, c.f677ra);
                                    break;
                                case 75:
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("unused attribute 0x");
                                    sb.append(Integer.toHexString(attr));
                                    sb.append(str);
                                    sb.append(f614b.get(attr));
                                    Log.w(str2, sb.toString());
                                    break;
                                default:
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append("Unknown attribute 0x");
                                    sb2.append(Integer.toHexString(attr));
                                    sb2.append(str);
                                    sb2.append(f614b.get(attr));
                                    Log.w(str2, sb2.toString());
                                    break;
                            }
                    }
            }
        }
    }

    /* renamed from: a */
    private int[] m1201a(View view, String referenceIdString) {
        String[] split = referenceIdString.split(",");
        Context context = view.getContext();
        int[] tags = new int[split.length];
        int count = 0;
        int i = 0;
        while (i < split.length) {
            String idString = split[i].trim();
            int tag = 0;
            try {
                tag = C0213h.class.getField(idString).getInt(null);
            } catch (Exception e) {
            }
            if (tag == 0) {
                tag = context.getResources().getIdentifier(idString, "id", context.getPackageName());
            }
            if (tag == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout)) {
                Object value = ((ConstraintLayout) view.getParent()).mo3777a(0, (Object) idString);
                if (value != null && (value instanceof Integer)) {
                    tag = ((Integer) value).intValue();
                }
            }
            int count2 = count + 1;
            tags[count] = tag;
            i++;
            count = count2;
        }
        if (count != split.length) {
            return Arrays.copyOf(tags, count);
        }
        return tags;
    }
}
