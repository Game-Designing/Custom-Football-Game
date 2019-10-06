package android.support.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.support.p000v4.view.C0646w;
import android.support.transition.Transition.AnimationInfo;
import android.support.transition.Transition.TransitionListener;
import android.support.v4.util.ArrayMap;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p002b.p003c.p053g.p061f.C1253b;
import p002b.p003c.p053g.p061f.C1259h;
import p002b.p003c.p053g.p061f.C1273q;

/* renamed from: android.support.transition.M */
/* compiled from: Transition */
public abstract class C0334M implements Cloneable {

    /* renamed from: a */
    private static final int[] f1159a = {2, 1, 3, 4};

    /* renamed from: b */
    private static final C0322A f1160b = new C0331J();

    /* renamed from: c */
    private static ThreadLocal<C1253b<Animator, C0335a>> f1161c = new ThreadLocal<>();
    /* access modifiers changed from: private */

    /* renamed from: A */
    public ArrayList<Animator> f1162A = new ArrayList<>();

    /* renamed from: B */
    private int f1163B = 0;

    /* renamed from: C */
    private boolean f1164C = false;

    /* renamed from: D */
    private boolean f1165D = false;

    /* renamed from: E */
    private ArrayList<C0337c> f1166E = null;

    /* renamed from: F */
    private ArrayList<Animator> f1167F = new ArrayList<>();

    /* renamed from: G */
    C0342Q f1168G;

    /* renamed from: H */
    private C0336b f1169H;

    /* renamed from: I */
    private C1253b<String, String> f1170I;

    /* renamed from: J */
    private C0322A f1171J = f1160b;

    /* renamed from: d */
    private String f1172d = getClass().getName();

    /* renamed from: e */
    private long f1173e = -1;

    /* renamed from: f */
    long f1174f = -1;

    /* renamed from: g */
    private TimeInterpolator f1175g = null;

    /* renamed from: h */
    ArrayList<Integer> f1176h = new ArrayList<>();

    /* renamed from: i */
    ArrayList<View> f1177i = new ArrayList<>();

    /* renamed from: j */
    private ArrayList<String> f1178j = null;

    /* renamed from: k */
    private ArrayList<Class> f1179k = null;

    /* renamed from: l */
    private ArrayList<Integer> f1180l = null;

    /* renamed from: m */
    private ArrayList<View> f1181m = null;

    /* renamed from: n */
    private ArrayList<Class> f1182n = null;

    /* renamed from: o */
    private ArrayList<String> f1183o = null;

    /* renamed from: p */
    private ArrayList<Integer> f1184p = null;

    /* renamed from: q */
    private ArrayList<View> f1185q = null;

    /* renamed from: r */
    private ArrayList<Class> f1186r = null;

    /* renamed from: s */
    private C0348W f1187s = new C0348W();

    /* renamed from: t */
    private C0348W f1188t = new C0348W();

    /* renamed from: u */
    C0344T f1189u = null;

    /* renamed from: v */
    private int[] f1190v = f1159a;

    /* renamed from: w */
    private ArrayList<C0347V> f1191w;

    /* renamed from: x */
    private ArrayList<C0347V> f1192x;

    /* renamed from: y */
    private ViewGroup f1193y = null;

    /* renamed from: z */
    boolean f1194z = false;

    /* renamed from: android.support.transition.M$a */
    /* compiled from: Transition */
    private static class C0335a {

        /* renamed from: a */
        View f1195a;

        /* renamed from: b */
        String f1196b;

        /* renamed from: c */
        C0347V f1197c;

        /* renamed from: d */
        C0401va f1198d;

        /* renamed from: e */
        C0334M f1199e;

        C0335a(View view, String name, C0334M transition, C0401va windowId, C0347V values) {
            this.f1195a = view;
            this.f1196b = name;
            this.f1197c = values;
            this.f1198d = windowId;
            this.f1199e = transition;
        }
    }

    /* renamed from: android.support.transition.M$b */
    /* compiled from: Transition */
    public static abstract class C0336b {
    }

    /* renamed from: android.support.transition.M$c */
    /* compiled from: Transition */
    public interface C0337c {
        /* renamed from: a */
        void mo4784a(C0334M m);

        /* renamed from: b */
        void mo4785b(C0334M m);

        /* renamed from: c */
        void mo4786c(C0334M m);

        /* renamed from: d */
        void mo4787d(C0334M m);
    }

    /* renamed from: a */
    public abstract void mo4153a(C0347V v);

    /* renamed from: c */
    public abstract void mo4154c(C0347V v);

    /* renamed from: a */
    public C0334M mo4748a(long duration) {
        this.f1174f = duration;
        return this;
    }

    /* renamed from: b */
    public long mo4762b() {
        return this.f1174f;
    }

    /* renamed from: b */
    public C0334M mo4763b(long startDelay) {
        this.f1173e = startDelay;
        return this;
    }

    /* renamed from: k */
    public long mo4775k() {
        return this.f1173e;
    }

    /* renamed from: a */
    public C0334M mo4749a(TimeInterpolator interpolator) {
        this.f1175g = interpolator;
        return this;
    }

    /* renamed from: c */
    public TimeInterpolator mo4768c() {
        return this.f1175g;
    }

    /* renamed from: p */
    public String[] mo4780p() {
        return null;
    }

    /* renamed from: a */
    public Animator mo4152a(ViewGroup sceneRoot, C0347V startValues, C0347V endValues) {
        return null;
    }

    /* renamed from: b */
    private void m1775b(C1253b<View, C0347V> unmatchedStart, C1253b<View, C0347V> unmatchedEnd) {
        for (int i = unmatchedStart.size() - 1; i >= 0; i--) {
            View view = (View) unmatchedStart.mo9157b(i);
            if (view != null && mo4767b(view)) {
                C0347V end = (C0347V) unmatchedEnd.remove(view);
                if (end != null) {
                    View view2 = end.f1215b;
                    if (view2 != null && mo4767b(view2)) {
                        this.f1191w.add((C0347V) unmatchedStart.mo9158c(i));
                        this.f1192x.add(end);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m1773a(C1253b<View, C0347V> unmatchedStart, C1253b<View, C0347V> unmatchedEnd, C1259h<View> startItemIds, C1259h<View> endItemIds) {
        int numStartIds = startItemIds.mo9057b();
        for (int i = 0; i < numStartIds; i++) {
            View startView = (View) startItemIds.mo9062c(i);
            if (startView != null && mo4767b(startView)) {
                View endView = (View) endItemIds.mo9058b(startItemIds.mo9053a(i));
                if (endView != null && mo4767b(endView)) {
                    C0347V startValues = (C0347V) unmatchedStart.get(startView);
                    C0347V endValues = (C0347V) unmatchedEnd.get(endView);
                    if (!(startValues == null || endValues == null)) {
                        this.f1191w.add(startValues);
                        this.f1192x.add(endValues);
                        unmatchedStart.remove(startView);
                        unmatchedEnd.remove(endView);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m1771a(C1253b<View, C0347V> unmatchedStart, C1253b<View, C0347V> unmatchedEnd, SparseArray<View> startIds, SparseArray<View> endIds) {
        int numStartIds = startIds.size();
        for (int i = 0; i < numStartIds; i++) {
            View startView = (View) startIds.valueAt(i);
            if (startView != null && mo4767b(startView)) {
                View endView = (View) endIds.get(startIds.keyAt(i));
                if (endView != null && mo4767b(endView)) {
                    C0347V startValues = (C0347V) unmatchedStart.get(startView);
                    C0347V endValues = (C0347V) unmatchedEnd.get(endView);
                    if (!(startValues == null || endValues == null)) {
                        this.f1191w.add(startValues);
                        this.f1192x.add(endValues);
                        unmatchedStart.remove(startView);
                        unmatchedEnd.remove(endView);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m1772a(C1253b<View, C0347V> unmatchedStart, C1253b<View, C0347V> unmatchedEnd, C1253b<String, View> startNames, C1253b<String, View> endNames) {
        int numStartNames = startNames.size();
        for (int i = 0; i < numStartNames; i++) {
            View startView = (View) startNames.mo9162d(i);
            if (startView != null && mo4767b(startView)) {
                View endView = (View) endNames.get(startNames.mo9157b(i));
                if (endView != null && mo4767b(endView)) {
                    C0347V startValues = (C0347V) unmatchedStart.get(startView);
                    C0347V endValues = (C0347V) unmatchedEnd.get(endView);
                    if (!(startValues == null || endValues == null)) {
                        this.f1191w.add(startValues);
                        this.f1192x.add(endValues);
                        unmatchedStart.remove(startView);
                        unmatchedEnd.remove(endView);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m1770a(C1253b<View, C0347V> unmatchedStart, C1253b<View, C0347V> unmatchedEnd) {
        for (int i = 0; i < unmatchedStart.size(); i++) {
            C0347V start = (C0347V) unmatchedStart.mo9162d(i);
            if (mo4767b(start.f1215b)) {
                this.f1191w.add(start);
                this.f1192x.add(null);
            }
        }
        for (int i2 = 0; i2 < unmatchedEnd.size(); i2++) {
            C0347V end = (C0347V) unmatchedEnd.mo9162d(i2);
            if (mo4767b(end.f1215b)) {
                this.f1192x.add(end);
                this.f1191w.add(null);
            }
        }
    }

    /* renamed from: a */
    private void m1768a(C0348W startValues, C0348W endValues) {
        ArrayMap<View, TransitionValues> unmatchedStart = new C1253b<>((C1273q) startValues.f1217a);
        ArrayMap<View, TransitionValues> unmatchedEnd = new C1253b<>((C1273q) endValues.f1217a);
        int i = 0;
        while (true) {
            int[] iArr = this.f1190v;
            if (i < iArr.length) {
                int i2 = iArr[i];
                if (i2 == 1) {
                    m1775b((C1253b<View, C0347V>) unmatchedStart, (C1253b<View, C0347V>) unmatchedEnd);
                } else if (i2 == 2) {
                    m1772a((C1253b<View, C0347V>) unmatchedStart, (C1253b<View, C0347V>) unmatchedEnd, startValues.f1220d, endValues.f1220d);
                } else if (i2 == 3) {
                    m1771a((C1253b<View, C0347V>) unmatchedStart, (C1253b<View, C0347V>) unmatchedEnd, startValues.f1218b, endValues.f1218b);
                } else if (i2 == 4) {
                    m1773a((C1253b<View, C0347V>) unmatchedStart, (C1253b<View, C0347V>) unmatchedEnd, startValues.f1219c, endValues.f1219c);
                }
                i++;
            } else {
                m1770a((C1253b<View, C0347V>) unmatchedStart, (C1253b<View, C0347V>) unmatchedEnd);
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4758a(ViewGroup sceneRoot, C0348W startValues, C0348W endValues, ArrayList<C0347V> startValuesList, ArrayList<C0347V> endValuesList) {
        C0347V start;
        C0347V end;
        int i;
        int startValuesListCount;
        C0347V infoValues;
        View view;
        Animator animator;
        long minStartDelay;
        Animator animator2;
        Animator animator3;
        int i2;
        int numExistingAnims;
        ViewGroup viewGroup = sceneRoot;
        ArrayMap<Animator, AnimationInfo> runningAnimators = mo4797s();
        long minStartDelay2 = Long.MAX_VALUE;
        SparseIntArray startDelays = new SparseIntArray();
        int startValuesListCount2 = startValuesList.size();
        int i3 = 0;
        while (i3 < startValuesListCount2) {
            C0347V start2 = (C0347V) startValuesList.get(i3);
            C0347V end2 = (C0347V) endValuesList.get(i3);
            if (start2 == null || start2.f1216c.contains(this)) {
                start = start2;
            } else {
                start = null;
            }
            if (end2 == null || end2.f1216c.contains(this)) {
                end = end2;
            } else {
                end = null;
            }
            if (start == null && end == null) {
                startValuesListCount = startValuesListCount2;
                i = i3;
            } else {
                if (start == null || end == null || mo4761a(start, end)) {
                    Animator animator4 = mo4152a(viewGroup, start, end);
                    if (animator4 != null) {
                        C0347V infoValues2 = null;
                        if (end != null) {
                            View view2 = end.f1215b;
                            String[] properties = mo4780p();
                            if (view2 == null || properties == null) {
                                animator3 = animator4;
                                startValuesListCount = startValuesListCount2;
                                i2 = i3;
                            } else {
                                animator3 = animator4;
                                if (properties.length > 0) {
                                    infoValues2 = new C0347V();
                                    infoValues2.f1215b = view2;
                                    startValuesListCount = startValuesListCount2;
                                    C0347V newValues = (C0347V) endValues.f1217a.get(view2);
                                    if (newValues != null) {
                                        int j = 0;
                                        while (j < properties.length) {
                                            int i4 = i3;
                                            C0347V newValues2 = newValues;
                                            infoValues2.f1214a.put(properties[j], newValues.f1214a.get(properties[j]));
                                            j++;
                                            ArrayList<C0347V> arrayList = startValuesList;
                                            ArrayList<C0347V> arrayList2 = endValuesList;
                                            i3 = i4;
                                            newValues = newValues2;
                                        }
                                        i = i3;
                                    } else {
                                        i = i3;
                                    }
                                    int numExistingAnims2 = runningAnimators.size();
                                    int j2 = 0;
                                    while (true) {
                                        if (j2 >= numExistingAnims2) {
                                            animator2 = animator3;
                                            break;
                                        }
                                        C0335a info = (C0335a) runningAnimators.get((Animator) runningAnimators.mo9157b(j2));
                                        if (info.f1197c != null && info.f1195a == view2) {
                                            numExistingAnims = numExistingAnims2;
                                            if (info.f1196b.equals(mo4772d()) && info.f1197c.equals(infoValues2)) {
                                                animator2 = null;
                                                break;
                                            }
                                        } else {
                                            numExistingAnims = numExistingAnims2;
                                        }
                                        j2++;
                                        numExistingAnims2 = numExistingAnims;
                                    }
                                    animator = animator2;
                                    infoValues = infoValues2;
                                    view = view2;
                                } else {
                                    startValuesListCount = startValuesListCount2;
                                    i2 = i3;
                                }
                            }
                            animator2 = animator3;
                            animator = animator2;
                            infoValues = infoValues2;
                            view = view2;
                        } else {
                            Animator animator5 = animator4;
                            startValuesListCount = startValuesListCount2;
                            i = i3;
                            view = start.f1215b;
                            infoValues = null;
                            animator = animator5;
                        }
                        if (animator != null) {
                            C0342Q q = this.f1168G;
                            if (q != null) {
                                long delay = q.mo4791a(viewGroup, this, start, end);
                                startDelays.put(this.f1167F.size(), (int) delay);
                                minStartDelay = Math.min(delay, minStartDelay2);
                            } else {
                                minStartDelay = minStartDelay2;
                            }
                            C0335a info2 = new C0335a(view, mo4772d(), this, C0375ka.m1938d(sceneRoot), infoValues);
                            runningAnimators.put(animator, info2);
                            this.f1167F.add(animator);
                            minStartDelay2 = minStartDelay;
                        }
                    } else {
                        Animator animator6 = animator4;
                        startValuesListCount = startValuesListCount2;
                        i = i3;
                    }
                } else {
                    startValuesListCount = startValuesListCount2;
                    i = i3;
                }
            }
            i3 = i + 1;
            startValuesListCount2 = startValuesListCount;
        }
        int i5 = i3;
        if (minStartDelay2 != 0) {
            for (int i6 = 0; i6 < startDelays.size(); i6++) {
                Animator animator7 = (Animator) this.f1167F.get(startDelays.keyAt(i6));
                animator7.setStartDelay((((long) startDelays.valueAt(i6)) - minStartDelay2) + animator7.getStartDelay());
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo4767b(View target) {
        int targetId = target.getId();
        ArrayList<Integer> arrayList = this.f1180l;
        if (arrayList != null && arrayList.contains(Integer.valueOf(targetId))) {
            return false;
        }
        ArrayList<View> arrayList2 = this.f1181m;
        if (arrayList2 != null && arrayList2.contains(target)) {
            return false;
        }
        ArrayList<Class> arrayList3 = this.f1182n;
        if (arrayList3 != null) {
            int numTypes = arrayList3.size();
            for (int i = 0; i < numTypes; i++) {
                if (((Class) this.f1182n.get(i)).isInstance(target)) {
                    return false;
                }
            }
        }
        if (this.f1183o != null && C0646w.m2979m(target) != null && this.f1183o.contains(C0646w.m2979m(target))) {
            return false;
        }
        if (this.f1176h.size() == 0 && this.f1177i.size() == 0) {
            ArrayList<Class> arrayList4 = this.f1179k;
            if (arrayList4 == null || arrayList4.isEmpty()) {
                ArrayList<String> arrayList5 = this.f1178j;
                if (arrayList5 == null || arrayList5.isEmpty()) {
                    return true;
                }
            }
        }
        if (this.f1176h.contains(Integer.valueOf(targetId)) || this.f1177i.contains(target)) {
            return true;
        }
        ArrayList<String> arrayList6 = this.f1178j;
        if (arrayList6 != null && arrayList6.contains(C0646w.m2979m(target))) {
            return true;
        }
        if (this.f1179k != null) {
            for (int i2 = 0; i2 < this.f1179k.size(); i2++) {
                if (((Class) this.f1179k.get(i2)).isInstance(target)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: s */
    private static C1253b<Animator, C0335a> mo4797s() {
        ArrayMap<Animator, AnimationInfo> runningAnimators = (C1253b) f1161c.get();
        if (runningAnimators != null) {
            return runningAnimators;
        }
        C1253b bVar = new C1253b();
        f1161c.set(bVar);
        return bVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: q */
    public void mo4781q() {
        mo4782r();
        ArrayMap<Animator, AnimationInfo> runningAnimators = mo4797s();
        Iterator it = this.f1167F.iterator();
        while (it.hasNext()) {
            Animator anim = (Animator) it.next();
            if (runningAnimators.containsKey(anim)) {
                mo4782r();
                m1767a(anim, (C1253b<Animator, C0335a>) runningAnimators);
            }
        }
        this.f1167F.clear();
        mo4754a();
    }

    /* renamed from: a */
    private void m1767a(Animator animator, C1253b<Animator, C0335a> runningAnimators) {
        if (animator != null) {
            animator.addListener(new C0332K(this, runningAnimators));
            mo4755a(animator);
        }
    }

    /* renamed from: a */
    public C0334M mo4751a(View target) {
        this.f1177i.add(target);
        return this;
    }

    /* renamed from: d */
    public C0334M mo4771d(View target) {
        this.f1177i.remove(target);
        return this;
    }

    /* renamed from: l */
    public List<Integer> mo4776l() {
        return this.f1176h;
    }

    /* renamed from: o */
    public List<View> mo4779o() {
        return this.f1177i;
    }

    /* renamed from: m */
    public List<String> mo4777m() {
        return this.f1178j;
    }

    /* renamed from: n */
    public List<Class> mo4778n() {
        return this.f1179k;
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:62:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo4759a(android.view.ViewGroup r7, boolean r8) {
        /*
            r6 = this;
            r6.mo4760a(r8)
            java.util.ArrayList<java.lang.Integer> r0 = r6.f1176h
            int r0 = r0.size()
            if (r0 > 0) goto L_0x0013
            java.util.ArrayList<android.view.View> r0 = r6.f1177i
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0028
        L_0x0013:
            java.util.ArrayList<java.lang.String> r0 = r6.f1178j
            if (r0 == 0) goto L_0x001d
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0028
        L_0x001d:
            java.util.ArrayList<java.lang.Class> r0 = r6.f1179k
            if (r0 == 0) goto L_0x002d
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0028
            goto L_0x002d
        L_0x0028:
            r6.m1776c(r7, r8)
            goto L_0x00a9
        L_0x002d:
            r0 = 0
        L_0x002e:
            java.util.ArrayList<java.lang.Integer> r1 = r6.f1176h
            int r1 = r1.size()
            if (r0 >= r1) goto L_0x0070
            java.util.ArrayList<java.lang.Integer> r1 = r6.f1176h
            java.lang.Object r1 = r1.get(r0)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            android.view.View r2 = r7.findViewById(r1)
            if (r2 == 0) goto L_0x006d
            android.support.transition.V r3 = new android.support.transition.V
            r3.<init>()
            r3.f1215b = r2
            if (r8 == 0) goto L_0x0055
            r6.mo4154c(r3)
            goto L_0x0058
        L_0x0055:
            r6.mo4153a(r3)
        L_0x0058:
            java.util.ArrayList<android.support.transition.M> r4 = r3.f1216c
            r4.add(r6)
            r6.mo4766b(r3)
            if (r8 == 0) goto L_0x0068
            android.support.transition.W r4 = r6.f1187s
            m1769a(r4, r2, r3)
            goto L_0x006d
        L_0x0068:
            android.support.transition.W r4 = r6.f1188t
            m1769a(r4, r2, r3)
        L_0x006d:
            int r0 = r0 + 1
            goto L_0x002e
        L_0x0070:
            r0 = 0
        L_0x0071:
            java.util.ArrayList<android.view.View> r1 = r6.f1177i
            int r1 = r1.size()
            if (r0 >= r1) goto L_0x00a9
            java.util.ArrayList<android.view.View> r1 = r6.f1177i
            java.lang.Object r1 = r1.get(r0)
            android.view.View r1 = (android.view.View) r1
            android.support.transition.V r2 = new android.support.transition.V
            r2.<init>()
            r2.f1215b = r1
            if (r8 == 0) goto L_0x008e
            r6.mo4154c(r2)
            goto L_0x0091
        L_0x008e:
            r6.mo4153a(r2)
        L_0x0091:
            java.util.ArrayList<android.support.transition.M> r3 = r2.f1216c
            r3.add(r6)
            r6.mo4766b(r2)
            if (r8 == 0) goto L_0x00a1
            android.support.transition.W r3 = r6.f1187s
            m1769a(r3, r1, r2)
            goto L_0x00a6
        L_0x00a1:
            android.support.transition.W r3 = r6.f1188t
            m1769a(r3, r1, r2)
        L_0x00a6:
            int r0 = r0 + 1
            goto L_0x0071
        L_0x00a9:
            if (r8 != 0) goto L_0x00ee
            b.c.g.f.b<java.lang.String, java.lang.String> r0 = r6.f1170I
            if (r0 == 0) goto L_0x00ee
            int r0 = r0.size()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r0)
            r2 = 0
        L_0x00b9:
            if (r2 >= r0) goto L_0x00d1
            b.c.g.f.b<java.lang.String, java.lang.String> r3 = r6.f1170I
            java.lang.Object r3 = r3.mo9157b(r2)
            java.lang.String r3 = (java.lang.String) r3
            android.support.transition.W r4 = r6.f1187s
            b.c.g.f.b<java.lang.String, android.view.View> r4 = r4.f1220d
            java.lang.Object r4 = r4.remove(r3)
            r1.add(r4)
            int r2 = r2 + 1
            goto L_0x00b9
        L_0x00d1:
            r2 = 0
        L_0x00d2:
            if (r2 >= r0) goto L_0x00ee
            java.lang.Object r3 = r1.get(r2)
            android.view.View r3 = (android.view.View) r3
            if (r3 == 0) goto L_0x00eb
            b.c.g.f.b<java.lang.String, java.lang.String> r4 = r6.f1170I
            java.lang.Object r4 = r4.mo9162d(r2)
            java.lang.String r4 = (java.lang.String) r4
            android.support.transition.W r5 = r6.f1187s
            b.c.g.f.b<java.lang.String, android.view.View> r5 = r5.f1220d
            r5.put(r4, r3)
        L_0x00eb:
            int r2 = r2 + 1
            goto L_0x00d2
        L_0x00ee:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.C0334M.mo4759a(android.view.ViewGroup, boolean):void");
    }

    /* renamed from: a */
    private static void m1769a(C0348W transitionValuesMaps, View view, C0347V transitionValues) {
        transitionValuesMaps.f1217a.put(view, transitionValues);
        int id = view.getId();
        if (id >= 0) {
            if (transitionValuesMaps.f1218b.indexOfKey(id) >= 0) {
                transitionValuesMaps.f1218b.put(id, null);
            } else {
                transitionValuesMaps.f1218b.put(id, view);
            }
        }
        String name = C0646w.m2979m(view);
        if (name != null) {
            if (transitionValuesMaps.f1220d.containsKey(name)) {
                transitionValuesMaps.f1220d.put(name, null);
            } else {
                transitionValuesMaps.f1220d.put(name, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listview = (ListView) view.getParent();
            if (listview.getAdapter().hasStableIds()) {
                long itemId = listview.getItemIdAtPosition(listview.getPositionForView(view));
                if (transitionValuesMaps.f1219c.mo9061c(itemId) >= 0) {
                    View alreadyMatched = (View) transitionValuesMaps.f1219c.mo9058b(itemId);
                    if (alreadyMatched != null) {
                        C0646w.m2966b(alreadyMatched, false);
                        transitionValuesMaps.f1219c.mo9063c(itemId, null);
                        return;
                    }
                    return;
                }
                C0646w.m2966b(view, true);
                transitionValuesMaps.f1219c.mo9063c(itemId, view);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4760a(boolean start) {
        if (start) {
            this.f1187s.f1217a.clear();
            this.f1187s.f1218b.clear();
            this.f1187s.f1219c.mo9054a();
            return;
        }
        this.f1188t.f1217a.clear();
        this.f1188t.f1218b.clear();
        this.f1188t.f1219c.mo9054a();
    }

    /* renamed from: c */
    private void m1776c(View view, boolean start) {
        if (view != null) {
            int id = view.getId();
            ArrayList<Integer> arrayList = this.f1180l;
            if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
                ArrayList<View> arrayList2 = this.f1181m;
                if (arrayList2 == null || !arrayList2.contains(view)) {
                    ArrayList<Class> arrayList3 = this.f1182n;
                    if (arrayList3 != null) {
                        int numTypes = arrayList3.size();
                        int i = 0;
                        while (i < numTypes) {
                            if (!((Class) this.f1182n.get(i)).isInstance(view)) {
                                i++;
                            } else {
                                return;
                            }
                        }
                    }
                    if (view.getParent() instanceof ViewGroup) {
                        C0347V values = new C0347V();
                        values.f1215b = view;
                        if (start) {
                            mo4154c(values);
                        } else {
                            mo4153a(values);
                        }
                        values.f1216c.add(this);
                        mo4766b(values);
                        if (start) {
                            m1769a(this.f1187s, view, values);
                        } else {
                            m1769a(this.f1188t, view, values);
                        }
                    }
                    if (view instanceof ViewGroup) {
                        ArrayList<Integer> arrayList4 = this.f1184p;
                        if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                            ArrayList<View> arrayList5 = this.f1185q;
                            if (arrayList5 == null || !arrayList5.contains(view)) {
                                ArrayList<Class> arrayList6 = this.f1186r;
                                if (arrayList6 != null) {
                                    int numTypes2 = arrayList6.size();
                                    int i2 = 0;
                                    while (i2 < numTypes2) {
                                        if (!((Class) this.f1186r.get(i2)).isInstance(view)) {
                                            i2++;
                                        } else {
                                            return;
                                        }
                                    }
                                }
                                ViewGroup parent = (ViewGroup) view;
                                for (int i3 = 0; i3 < parent.getChildCount(); i3++) {
                                    m1776c(parent.getChildAt(i3), start);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public C0347V mo4765b(View view, boolean start) {
        C0344T t = this.f1189u;
        if (t != null) {
            return t.mo4765b(view, start);
        }
        return (C0347V) (start ? this.f1187s : this.f1188t).f1217a.get(view);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C0347V mo4752a(View view, boolean viewInStart) {
        C0344T t = this.f1189u;
        if (t != null) {
            return t.mo4752a(view, viewInStart);
        }
        ArrayList<C0347V> arrayList = viewInStart ? this.f1191w : this.f1192x;
        if (arrayList == null) {
            return null;
        }
        int count = arrayList.size();
        int index = -1;
        int i = 0;
        while (true) {
            if (i >= count) {
                break;
            }
            C0347V values = (C0347V) arrayList.get(i);
            if (values == null) {
                return null;
            }
            if (values.f1215b == view) {
                index = i;
                break;
            }
            i++;
        }
        C0347V values2 = null;
        if (index >= 0) {
            values2 = (C0347V) (viewInStart ? this.f1192x : this.f1191w).get(index);
        }
        return values2;
    }

    /* renamed from: c */
    public void mo4769c(View sceneRoot) {
        if (!this.f1165D) {
            ArrayMap<Animator, AnimationInfo> runningAnimators = mo4797s();
            int numOldAnims = runningAnimators.size();
            C0401va windowId = C0375ka.m1938d(sceneRoot);
            for (int i = numOldAnims - 1; i >= 0; i--) {
                C0335a info = (C0335a) runningAnimators.mo9162d(i);
                if (info.f1195a != null && windowId.equals(info.f1198d)) {
                    C0352a.m1878a((Animator) runningAnimators.mo9157b(i));
                }
            }
            ArrayList<C0337c> arrayList = this.f1166E;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList<TransitionListener> tmpListeners = (ArrayList) this.f1166E.clone();
                int numListeners = tmpListeners.size();
                for (int i2 = 0; i2 < numListeners; i2++) {
                    ((C0337c) tmpListeners.get(i2)).mo4785b(this);
                }
            }
            this.f1164C = true;
        }
    }

    /* renamed from: e */
    public void mo4773e(View sceneRoot) {
        if (this.f1164C) {
            if (!this.f1165D) {
                ArrayMap<Animator, AnimationInfo> runningAnimators = mo4797s();
                int numOldAnims = runningAnimators.size();
                C0401va windowId = C0375ka.m1938d(sceneRoot);
                for (int i = numOldAnims - 1; i >= 0; i--) {
                    C0335a info = (C0335a) runningAnimators.mo9162d(i);
                    if (info.f1195a != null && windowId.equals(info.f1198d)) {
                        C0352a.m1880b((Animator) runningAnimators.mo9157b(i));
                    }
                }
                ArrayList<C0337c> arrayList = this.f1166E;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList<TransitionListener> tmpListeners = (ArrayList) this.f1166E.clone();
                    int numListeners = tmpListeners.size();
                    for (int i2 = 0; i2 < numListeners; i2++) {
                        ((C0337c) tmpListeners.get(i2)).mo4784a(this);
                    }
                }
            }
            this.f1164C = false;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4757a(ViewGroup sceneRoot) {
        this.f1191w = new ArrayList<>();
        this.f1192x = new ArrayList<>();
        m1768a(this.f1187s, this.f1188t);
        ArrayMap<Animator, AnimationInfo> runningAnimators = mo4797s();
        int numOldAnims = runningAnimators.size();
        C0401va windowId = C0375ka.m1938d(sceneRoot);
        for (int i = numOldAnims - 1; i >= 0; i--) {
            Animator anim = (Animator) runningAnimators.mo9157b(i);
            if (anim != null) {
                C0335a oldInfo = (C0335a) runningAnimators.get(anim);
                if (!(oldInfo == null || oldInfo.f1195a == null || !windowId.equals(oldInfo.f1198d))) {
                    C0347V oldValues = oldInfo.f1197c;
                    View oldView = oldInfo.f1195a;
                    boolean cancel = true;
                    C0347V startValues = mo4765b(oldView, true);
                    C0347V endValues = mo4752a(oldView, true);
                    if ((startValues == null && endValues == null) || !oldInfo.f1199e.mo4761a(oldValues, endValues)) {
                        cancel = false;
                    }
                    if (cancel) {
                        if (anim.isRunning() || anim.isStarted()) {
                            anim.cancel();
                        } else {
                            runningAnimators.remove(anim);
                        }
                    }
                }
            }
        }
        mo4758a(sceneRoot, this.f1187s, this.f1188t, this.f1191w, this.f1192x);
        mo4781q();
    }

    /* renamed from: a */
    public boolean mo4761a(C0347V startValues, C0347V endValues) {
        if (startValues == null || endValues == null) {
            return false;
        }
        String[] properties = mo4780p();
        if (properties != null) {
            for (String property : properties) {
                if (m1774a(startValues, endValues, property)) {
                    return true;
                }
            }
            return false;
        }
        for (String key : startValues.f1214a.keySet()) {
            if (m1774a(startValues, endValues, key)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m1774a(C0347V oldValues, C0347V newValues, String key) {
        Object oldValue = oldValues.f1214a.get(key);
        Object newValue = newValues.f1214a.get(key);
        if (oldValue == null && newValue == null) {
            return false;
        }
        if (oldValue == null || newValue == null) {
            return true;
        }
        return !oldValue.equals(newValue);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4755a(Animator animator) {
        if (animator == null) {
            mo4754a();
            return;
        }
        if (mo4762b() >= 0) {
            animator.setDuration(mo4762b());
        }
        if (mo4775k() >= 0) {
            animator.setStartDelay(mo4775k());
        }
        if (mo4768c() != null) {
            animator.setInterpolator(mo4768c());
        }
        animator.addListener(new C0333L(this));
        animator.start();
    }

    /* access modifiers changed from: protected */
    /* renamed from: r */
    public void mo4782r() {
        if (this.f1163B == 0) {
            ArrayList<C0337c> arrayList = this.f1166E;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList<TransitionListener> tmpListeners = (ArrayList) this.f1166E.clone();
                int numListeners = tmpListeners.size();
                for (int i = 0; i < numListeners; i++) {
                    ((C0337c) tmpListeners.get(i)).mo4786c(this);
                }
            }
            this.f1165D = false;
        }
        this.f1163B++;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4754a() {
        this.f1163B--;
        if (this.f1163B == 0) {
            ArrayList<C0337c> arrayList = this.f1166E;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList<TransitionListener> tmpListeners = (ArrayList) this.f1166E.clone();
                int numListeners = tmpListeners.size();
                for (int i = 0; i < numListeners; i++) {
                    ((C0337c) tmpListeners.get(i)).mo4787d(this);
                }
            }
            for (int i2 = 0; i2 < this.f1187s.f1219c.mo9057b(); i2++) {
                View view = (View) this.f1187s.f1219c.mo9062c(i2);
                if (view != null) {
                    C0646w.m2966b(view, false);
                }
            }
            for (int i3 = 0; i3 < this.f1188t.f1219c.mo9057b(); i3++) {
                View view2 = (View) this.f1188t.f1219c.mo9062c(i3);
                if (view2 != null) {
                    C0646w.m2966b(view2, false);
                }
            }
            this.f1165D = true;
        }
    }

    /* renamed from: a */
    public C0334M mo4750a(C0337c listener) {
        if (this.f1166E == null) {
            this.f1166E = new ArrayList<>();
        }
        this.f1166E.add(listener);
        return this;
    }

    /* renamed from: b */
    public C0334M mo4764b(C0337c listener) {
        ArrayList<C0337c> arrayList = this.f1166E;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(listener);
        if (this.f1166E.size() == 0) {
            this.f1166E = null;
        }
        return this;
    }

    /* renamed from: h */
    public C0322A mo4774h() {
        return this.f1171J;
    }

    /* renamed from: a */
    public void mo4756a(C0336b epicenterCallback) {
        this.f1169H = epicenterCallback;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo4766b(C0347V transitionValues) {
        if (this.f1168G != null && !transitionValues.f1214a.isEmpty()) {
            String[] propertyNames = this.f1168G.mo4793a();
            if (propertyNames != null) {
                boolean containsAll = true;
                int i = 0;
                while (true) {
                    if (i >= propertyNames.length) {
                        break;
                    } else if (!transitionValues.f1214a.containsKey(propertyNames[i])) {
                        containsAll = false;
                        break;
                    } else {
                        i++;
                    }
                }
                if (!containsAll) {
                    this.f1168G.mo4792a(transitionValues);
                }
            }
        }
    }

    public String toString() {
        return mo4753a("");
    }

    public C0334M clone() {
        try {
            C0334M clone = (C0334M) super.clone();
            clone.f1167F = new ArrayList<>();
            clone.f1187s = new C0348W();
            clone.f1188t = new C0348W();
            clone.f1191w = null;
            clone.f1192x = null;
            return clone;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    /* renamed from: d */
    public String mo4772d() {
        return this.f1172d;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo4753a(String indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent);
        sb.append(getClass().getSimpleName());
        sb.append("@");
        sb.append(Integer.toHexString(hashCode()));
        sb.append(": ");
        String result = sb.toString();
        String str = ") ";
        if (this.f1174f != -1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(result);
            sb2.append("dur(");
            sb2.append(this.f1174f);
            sb2.append(str);
            result = sb2.toString();
        }
        if (this.f1173e != -1) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(result);
            sb3.append("dly(");
            sb3.append(this.f1173e);
            sb3.append(str);
            result = sb3.toString();
        }
        if (this.f1175g != null) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(result);
            sb4.append("interp(");
            sb4.append(this.f1175g);
            sb4.append(str);
            result = sb4.toString();
        }
        if (this.f1176h.size() <= 0 && this.f1177i.size() <= 0) {
            return result;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(result);
        sb5.append("tgts(");
        String result2 = sb5.toString();
        String str2 = ", ";
        if (this.f1176h.size() > 0) {
            for (int i = 0; i < this.f1176h.size(); i++) {
                if (i > 0) {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(result2);
                    sb6.append(str2);
                    result2 = sb6.toString();
                }
                StringBuilder sb7 = new StringBuilder();
                sb7.append(result2);
                sb7.append(this.f1176h.get(i));
                result2 = sb7.toString();
            }
        }
        if (this.f1177i.size() > 0) {
            for (int i2 = 0; i2 < this.f1177i.size(); i2++) {
                if (i2 > 0) {
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append(result2);
                    sb8.append(str2);
                    result2 = sb8.toString();
                }
                StringBuilder sb9 = new StringBuilder();
                sb9.append(result2);
                sb9.append(this.f1177i.get(i2));
                result2 = sb9.toString();
            }
        }
        StringBuilder sb10 = new StringBuilder();
        sb10.append(result2);
        sb10.append(")");
        return sb10.toString();
    }
}
