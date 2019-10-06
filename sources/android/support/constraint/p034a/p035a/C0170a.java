package android.support.constraint.p034a.p035a;

import android.support.constraint.p034a.p035a.C0180h.C0181a;
import android.support.constraint.solver.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: android.support.constraint.a.a.a */
/* compiled from: Analyzer */
public class C0170a {
    /* renamed from: a */
    public static void m920a(C0182i layoutWidget) {
        if ((layoutWidget.mo3931M() & 32) != 32) {
            m925b(layoutWidget);
            return;
        }
        layoutWidget.f472Oa = true;
        layoutWidget.f466Ia = false;
        layoutWidget.f467Ja = false;
        layoutWidget.f468Ka = false;
        List<ConstraintWidget> widgets = layoutWidget.f530va;
        List<C0183j> list = layoutWidget.f465Ha;
        boolean horizontalWrapContent = layoutWidget.mo3902j() == C0181a.WRAP_CONTENT;
        boolean verticalWrapContent = layoutWidget.mo3916q() == C0181a.WRAP_CONTENT;
        boolean hasWrapContent = horizontalWrapContent || verticalWrapContent;
        list.clear();
        Iterator it = widgets.iterator();
        while (it.hasNext()) {
            C0180h widget = (C0180h) it.next();
            widget.f442s = null;
            widget.f429la = false;
            widget.mo3828F();
        }
        Iterator it2 = widgets.iterator();
        while (it2.hasNext()) {
            C0180h widget2 = (C0180h) it2.next();
            if (widget2.f442s == null && !m924a(widget2, list, hasWrapContent)) {
                m925b(layoutWidget);
                layoutWidget.f472Oa = false;
                return;
            }
        }
        int measuredWidth = 0;
        int measuredHeight = 0;
        for (C0183j group : list) {
            measuredWidth = Math.max(measuredWidth, m917a(group, 0));
            measuredHeight = Math.max(measuredHeight, m917a(group, 1));
        }
        if (horizontalWrapContent) {
            layoutWidget.mo3865a(C0181a.FIXED);
            layoutWidget.mo3913o(measuredWidth);
            layoutWidget.f466Ia = true;
            layoutWidget.f467Ja = true;
            layoutWidget.f469La = measuredWidth;
        }
        if (verticalWrapContent) {
            layoutWidget.mo3878b(C0181a.FIXED);
            layoutWidget.mo3897g(measuredHeight);
            layoutWidget.f466Ia = true;
            layoutWidget.f468Ka = true;
            layoutWidget.f470Ma = measuredHeight;
        }
        m922a(list, 0, layoutWidget.mo3920s());
        m922a(list, 1, layoutWidget.mo3900i());
    }

    /* renamed from: a */
    private static boolean m924a(C0180h widget, List<C0183j> widgetGroups, boolean hasWrapContent) {
        C0183j traverseList = new C0183j(new ArrayList(), true);
        widgetGroups.add(traverseList);
        return m923a(widget, traverseList, widgetGroups, hasWrapContent);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:126:0x018b, code lost:
        if (r3.f352b == r4) goto L_0x018d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0132, code lost:
        if (r3.f352b == r4) goto L_0x0134;
     */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x017d  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x01aa  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x01cc  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m923a(android.support.constraint.p034a.p035a.C0180h r8, android.support.constraint.p034a.p035a.C0183j r9, java.util.List<android.support.constraint.p034a.p035a.C0183j> r10, boolean r11) {
        /*
            r0 = 1
            if (r8 != 0) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 0
            r8.f427ka = r1
            android.support.constraint.a.a.h r2 = r8.mo3904k()
            android.support.constraint.a.a.i r2 = (android.support.constraint.p034a.p035a.C0182i) r2
            android.support.constraint.a.a.j r3 = r8.f442s
            if (r3 != 0) goto L_0x01fa
            r8.f425ja = r0
            java.util.List<android.support.constraint.a.a.h> r3 = r9.f480a
            r3.add(r8)
            r8.f442s = r9
            android.support.constraint.a.a.f r3 = r8.f448v
            android.support.constraint.a.a.f r3 = r3.f354d
            if (r3 != 0) goto L_0x0044
            android.support.constraint.a.a.f r3 = r8.f450x
            android.support.constraint.a.a.f r3 = r3.f354d
            if (r3 != 0) goto L_0x0044
            android.support.constraint.a.a.f r3 = r8.f449w
            android.support.constraint.a.a.f r3 = r3.f354d
            if (r3 != 0) goto L_0x0044
            android.support.constraint.a.a.f r3 = r8.f451y
            android.support.constraint.a.a.f r3 = r3.f354d
            if (r3 != 0) goto L_0x0044
            android.support.constraint.a.a.f r3 = r8.f452z
            android.support.constraint.a.a.f r3 = r3.f354d
            if (r3 != 0) goto L_0x0044
            android.support.constraint.a.a.f r3 = r8.f383C
            android.support.constraint.a.a.f r3 = r3.f354d
            if (r3 != 0) goto L_0x0044
            m921a(r2, r8, r9)
            if (r11 == 0) goto L_0x0044
            return r1
        L_0x0044:
            android.support.constraint.a.a.f r3 = r8.f449w
            android.support.constraint.a.a.f r3 = r3.f354d
            if (r3 == 0) goto L_0x007c
            android.support.constraint.a.a.f r3 = r8.f451y
            android.support.constraint.a.a.f r3 = r3.f354d
            if (r3 == 0) goto L_0x007c
            android.support.constraint.a.a.h$a r3 = r2.mo3916q()
            android.support.constraint.a.a.h$a r4 = android.support.constraint.p034a.p035a.C0180h.C0181a.WRAP_CONTENT
            if (r3 != r4) goto L_0x005a
            r3 = 1
            goto L_0x005b
        L_0x005a:
            r3 = 0
        L_0x005b:
            if (r11 == 0) goto L_0x0061
            m921a(r2, r8, r9)
            return r1
        L_0x0061:
            android.support.constraint.a.a.f r4 = r8.f449w
            android.support.constraint.a.a.f r4 = r4.f354d
            android.support.constraint.a.a.h r4 = r4.f352b
            android.support.constraint.a.a.h r5 = r8.mo3904k()
            if (r4 != r5) goto L_0x0079
            android.support.constraint.a.a.f r4 = r8.f451y
            android.support.constraint.a.a.f r4 = r4.f354d
            android.support.constraint.a.a.h r4 = r4.f352b
            android.support.constraint.a.a.h r5 = r8.mo3904k()
            if (r4 == r5) goto L_0x007c
        L_0x0079:
            m921a(r2, r8, r9)
        L_0x007c:
            android.support.constraint.a.a.f r3 = r8.f448v
            android.support.constraint.a.a.f r3 = r3.f354d
            if (r3 == 0) goto L_0x00b4
            android.support.constraint.a.a.f r3 = r8.f450x
            android.support.constraint.a.a.f r3 = r3.f354d
            if (r3 == 0) goto L_0x00b4
            android.support.constraint.a.a.h$a r3 = r2.mo3902j()
            android.support.constraint.a.a.h$a r4 = android.support.constraint.p034a.p035a.C0180h.C0181a.WRAP_CONTENT
            if (r3 != r4) goto L_0x0092
            r3 = 1
            goto L_0x0093
        L_0x0092:
            r3 = 0
        L_0x0093:
            if (r11 == 0) goto L_0x0099
            m921a(r2, r8, r9)
            return r1
        L_0x0099:
            android.support.constraint.a.a.f r4 = r8.f448v
            android.support.constraint.a.a.f r4 = r4.f354d
            android.support.constraint.a.a.h r4 = r4.f352b
            android.support.constraint.a.a.h r5 = r8.mo3904k()
            if (r4 != r5) goto L_0x00b1
            android.support.constraint.a.a.f r4 = r8.f450x
            android.support.constraint.a.a.f r4 = r4.f354d
            android.support.constraint.a.a.h r4 = r4.f352b
            android.support.constraint.a.a.h r5 = r8.mo3904k()
            if (r4 == r5) goto L_0x00b4
        L_0x00b1:
            m921a(r2, r8, r9)
        L_0x00b4:
            android.support.constraint.a.a.h$a r3 = r8.mo3902j()
            android.support.constraint.a.a.h$a r4 = android.support.constraint.p034a.p035a.C0180h.C0181a.MATCH_CONSTRAINT
            if (r3 != r4) goto L_0x00be
            r3 = 1
            goto L_0x00bf
        L_0x00be:
            r3 = 0
        L_0x00bf:
            android.support.constraint.a.a.h$a r4 = r8.mo3916q()
            android.support.constraint.a.a.h$a r5 = android.support.constraint.p034a.p035a.C0180h.C0181a.MATCH_CONSTRAINT
            if (r4 != r5) goto L_0x00c9
            r4 = 1
            goto L_0x00ca
        L_0x00c9:
            r4 = 0
        L_0x00ca:
            r3 = r3 ^ r4
            if (r3 == 0) goto L_0x00d8
            float r3 = r8.f390J
            r4 = 0
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 == 0) goto L_0x00d8
            m914a(r8)
            goto L_0x00ee
        L_0x00d8:
            android.support.constraint.a.a.h$a r3 = r8.mo3902j()
            android.support.constraint.a.a.h$a r4 = android.support.constraint.p034a.p035a.C0180h.C0181a.MATCH_CONSTRAINT
            if (r3 == r4) goto L_0x00e8
            android.support.constraint.a.a.h$a r3 = r8.mo3916q()
            android.support.constraint.a.a.h$a r4 = android.support.constraint.p034a.p035a.C0180h.C0181a.MATCH_CONSTRAINT
            if (r3 != r4) goto L_0x00ee
        L_0x00e8:
            m921a(r2, r8, r9)
            if (r11 == 0) goto L_0x00ee
            return r1
        L_0x00ee:
            android.support.constraint.a.a.f r3 = r8.f448v
            android.support.constraint.a.a.f r3 = r3.f354d
            if (r3 != 0) goto L_0x00fa
            android.support.constraint.a.a.f r3 = r8.f450x
            android.support.constraint.a.a.f r3 = r3.f354d
            if (r3 == 0) goto L_0x0134
        L_0x00fa:
            android.support.constraint.a.a.f r3 = r8.f448v
            android.support.constraint.a.a.f r3 = r3.f354d
            if (r3 == 0) goto L_0x010c
            android.support.constraint.a.a.h r3 = r3.f352b
            android.support.constraint.a.a.h r4 = r8.f387G
            if (r3 != r4) goto L_0x010c
            android.support.constraint.a.a.f r3 = r8.f450x
            android.support.constraint.a.a.f r3 = r3.f354d
            if (r3 == 0) goto L_0x0134
        L_0x010c:
            android.support.constraint.a.a.f r3 = r8.f450x
            android.support.constraint.a.a.f r3 = r3.f354d
            if (r3 == 0) goto L_0x011e
            android.support.constraint.a.a.h r3 = r3.f352b
            android.support.constraint.a.a.h r4 = r8.f387G
            if (r3 != r4) goto L_0x011e
            android.support.constraint.a.a.f r3 = r8.f448v
            android.support.constraint.a.a.f r3 = r3.f354d
            if (r3 == 0) goto L_0x0134
        L_0x011e:
            android.support.constraint.a.a.f r3 = r8.f448v
            android.support.constraint.a.a.f r3 = r3.f354d
            if (r3 == 0) goto L_0x0147
            android.support.constraint.a.a.h r3 = r3.f352b
            android.support.constraint.a.a.h r4 = r8.f387G
            if (r3 != r4) goto L_0x0147
            android.support.constraint.a.a.f r3 = r8.f450x
            android.support.constraint.a.a.f r3 = r3.f354d
            if (r3 == 0) goto L_0x0147
            android.support.constraint.a.a.h r3 = r3.f352b
            if (r3 != r4) goto L_0x0147
        L_0x0134:
            android.support.constraint.a.a.f r3 = r8.f383C
            android.support.constraint.a.a.f r3 = r3.f354d
            if (r3 != 0) goto L_0x0147
            boolean r3 = r8 instanceof android.support.constraint.p034a.p035a.C0185l
            if (r3 != 0) goto L_0x0147
            boolean r3 = r8 instanceof android.support.constraint.p034a.p035a.C0186m
            if (r3 != 0) goto L_0x0147
            java.util.List<android.support.constraint.a.a.h> r3 = r9.f485f
            r3.add(r8)
        L_0x0147:
            android.support.constraint.a.a.f r3 = r8.f449w
            android.support.constraint.a.a.f r3 = r3.f354d
            if (r3 != 0) goto L_0x0153
            android.support.constraint.a.a.f r3 = r8.f451y
            android.support.constraint.a.a.f r3 = r3.f354d
            if (r3 == 0) goto L_0x018d
        L_0x0153:
            android.support.constraint.a.a.f r3 = r8.f449w
            android.support.constraint.a.a.f r3 = r3.f354d
            if (r3 == 0) goto L_0x0165
            android.support.constraint.a.a.h r3 = r3.f352b
            android.support.constraint.a.a.h r4 = r8.f387G
            if (r3 != r4) goto L_0x0165
            android.support.constraint.a.a.f r3 = r8.f451y
            android.support.constraint.a.a.f r3 = r3.f354d
            if (r3 == 0) goto L_0x018d
        L_0x0165:
            android.support.constraint.a.a.f r3 = r8.f451y
            android.support.constraint.a.a.f r3 = r3.f354d
            if (r3 == 0) goto L_0x0177
            android.support.constraint.a.a.h r3 = r3.f352b
            android.support.constraint.a.a.h r4 = r8.f387G
            if (r3 != r4) goto L_0x0177
            android.support.constraint.a.a.f r3 = r8.f449w
            android.support.constraint.a.a.f r3 = r3.f354d
            if (r3 == 0) goto L_0x018d
        L_0x0177:
            android.support.constraint.a.a.f r3 = r8.f449w
            android.support.constraint.a.a.f r3 = r3.f354d
            if (r3 == 0) goto L_0x01a6
            android.support.constraint.a.a.h r3 = r3.f352b
            android.support.constraint.a.a.h r4 = r8.f387G
            if (r3 != r4) goto L_0x01a6
            android.support.constraint.a.a.f r3 = r8.f451y
            android.support.constraint.a.a.f r3 = r3.f354d
            if (r3 == 0) goto L_0x01a6
            android.support.constraint.a.a.h r3 = r3.f352b
            if (r3 != r4) goto L_0x01a6
        L_0x018d:
            android.support.constraint.a.a.f r3 = r8.f383C
            android.support.constraint.a.a.f r3 = r3.f354d
            if (r3 != 0) goto L_0x01a6
            android.support.constraint.a.a.f r3 = r8.f452z
            android.support.constraint.a.a.f r3 = r3.f354d
            if (r3 != 0) goto L_0x01a6
            boolean r3 = r8 instanceof android.support.constraint.p034a.p035a.C0185l
            if (r3 != 0) goto L_0x01a6
            boolean r3 = r8 instanceof android.support.constraint.p034a.p035a.C0186m
            if (r3 != 0) goto L_0x01a6
            java.util.List<android.support.constraint.a.a.h> r3 = r9.f486g
            r3.add(r8)
        L_0x01a6:
            boolean r3 = r8 instanceof android.support.constraint.p034a.p035a.C0186m
            if (r3 == 0) goto L_0x01c6
            m921a(r2, r8, r9)
            if (r11 == 0) goto L_0x01b0
            return r1
        L_0x01b0:
            r3 = r8
            android.support.constraint.a.a.m r3 = (android.support.constraint.p034a.p035a.C0186m) r3
            r4 = 0
        L_0x01b4:
            int r5 = r3.f502wa
            if (r4 >= r5) goto L_0x01c6
            android.support.constraint.a.a.h[] r5 = r3.f501va
            r5 = r5[r4]
            boolean r5 = m923a(r5, r9, r10, r11)
            if (r5 != 0) goto L_0x01c3
            return r1
        L_0x01c3:
            int r4 = r4 + 1
            goto L_0x01b4
        L_0x01c6:
            android.support.constraint.a.a.f[] r3 = r8.f384D
            int r3 = r3.length
            r4 = 0
        L_0x01ca:
            if (r4 >= r3) goto L_0x01f9
            android.support.constraint.a.a.f[] r5 = r8.f384D
            r5 = r5[r4]
            android.support.constraint.a.a.f r6 = r5.f354d
            if (r6 == 0) goto L_0x01f6
            android.support.constraint.a.a.h r6 = r6.f352b
            android.support.constraint.a.a.h r7 = r8.mo3904k()
            if (r6 == r7) goto L_0x01f6
            android.support.constraint.a.a.f$c r6 = r5.f353c
            android.support.constraint.a.a.f$c r7 = android.support.constraint.p034a.p035a.C0175f.C0178c.CENTER
            if (r6 != r7) goto L_0x01e8
            m921a(r2, r8, r9)
            if (r11 == 0) goto L_0x01eb
            return r1
        L_0x01e8:
            m918a(r5)
        L_0x01eb:
            android.support.constraint.a.a.f r6 = r5.f354d
            android.support.constraint.a.a.h r6 = r6.f352b
            boolean r6 = m923a(r6, r9, r10, r11)
            if (r6 != 0) goto L_0x01f6
            return r1
        L_0x01f6:
            int r4 = r4 + 1
            goto L_0x01ca
        L_0x01f9:
            return r0
        L_0x01fa:
            if (r3 == r9) goto L_0x0239
            java.util.List<android.support.constraint.a.a.h> r4 = r9.f480a
            java.util.List<android.support.constraint.a.a.h> r3 = r3.f480a
            r4.addAll(r3)
            java.util.List<android.support.constraint.a.a.h> r3 = r9.f485f
            android.support.constraint.a.a.j r4 = r8.f442s
            java.util.List<android.support.constraint.a.a.h> r4 = r4.f485f
            r3.addAll(r4)
            java.util.List<android.support.constraint.a.a.h> r3 = r9.f486g
            android.support.constraint.a.a.j r4 = r8.f442s
            java.util.List<android.support.constraint.a.a.h> r4 = r4.f486g
            r3.addAll(r4)
            android.support.constraint.a.a.j r3 = r8.f442s
            boolean r3 = r3.f483d
            if (r3 != 0) goto L_0x021d
            r9.f483d = r1
        L_0x021d:
            android.support.constraint.a.a.j r1 = r8.f442s
            r10.remove(r1)
            android.support.constraint.a.a.j r1 = r8.f442s
            java.util.List<android.support.constraint.a.a.h> r1 = r1.f480a
            java.util.Iterator r1 = r1.iterator()
        L_0x022a:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0239
            java.lang.Object r3 = r1.next()
            android.support.constraint.a.a.h r3 = (android.support.constraint.p034a.p035a.C0180h) r3
            r3.f442s = r9
            goto L_0x022a
        L_0x0239:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.p034a.p035a.C0170a.m923a(android.support.constraint.a.a.h, android.support.constraint.a.a.j, java.util.List, boolean):boolean");
    }

    /* renamed from: a */
    private static void m921a(C0182i layoutWidget, C0180h widget, C0183j group) {
        group.f483d = false;
        layoutWidget.f472Oa = false;
        widget.f425ja = false;
    }

    /* renamed from: a */
    private static int m917a(C0183j group, int orientation) {
        int dimension = 0;
        int offset = orientation * 2;
        List<ConstraintWidget> startWidgets = group.mo3947a(orientation);
        int size = startWidgets.size();
        for (int i = 0; i < size; i++) {
            C0180h widget = (C0180h) startWidgets.get(i);
            C0175f[] fVarArr = widget.f384D;
            dimension = Math.max(dimension, m916a(widget, orientation, fVarArr[offset + 1].f354d == null || !(fVarArr[offset].f354d == null || fVarArr[offset + 1].f354d == null), 0));
        }
        group.f484e[orientation] = dimension;
        return dimension;
    }

    /* renamed from: a */
    private static int m916a(C0180h widget, int orientation, boolean topLeftFlow, int depth) {
        int endOffset;
        int startOffset;
        int baselinePostDistance;
        int baselinePreDistance;
        int flow;
        int depth2;
        int dimensionPost;
        int postTemp;
        int startOffset2;
        int postTemp2;
        C0180h hVar = widget;
        int i = orientation;
        boolean z = topLeftFlow;
        boolean hasBaseline = false;
        if (!hVar.f425ja) {
            return 0;
        }
        int dimensionPre = 0;
        int dimensionPost2 = 0;
        if (hVar.f452z.f354d != null && i == 1) {
            hasBaseline = true;
        }
        if (z) {
            baselinePreDistance = widget.mo3882c();
            baselinePostDistance = widget.mo3900i() - widget.mo3882c();
            startOffset = i * 2;
            endOffset = startOffset + 1;
        } else {
            baselinePreDistance = widget.mo3900i() - widget.mo3882c();
            baselinePostDistance = widget.mo3882c();
            endOffset = i * 2;
            startOffset = endOffset + 1;
        }
        C0175f[] fVarArr = hVar.f384D;
        if (fVarArr[endOffset].f354d == null || fVarArr[startOffset].f354d != null) {
            flow = 1;
        } else {
            flow = -1;
            int aux = startOffset;
            startOffset = endOffset;
            endOffset = aux;
        }
        if (hasBaseline) {
            depth2 = depth - baselinePreDistance;
        } else {
            depth2 = depth;
        }
        int dimension = (hVar.f384D[startOffset].mo3841b() * flow) + m915a(widget, orientation);
        int downDepth = dimension + depth2;
        int postTemp3 = (i == 0 ? widget.mo3920s() : widget.mo3900i()) * flow;
        Iterator it = hVar.f384D[startOffset].mo3843d().f518a.iterator();
        while (it.hasNext()) {
            int dimensionPost3 = dimensionPost2;
            Iterator it2 = it;
            dimensionPre = Math.max(dimensionPre, m916a(((C0189p) it.next()).f504c.f352b, i, z, downDepth));
            it = it2;
            dimensionPost2 = dimensionPost3;
        }
        int dimensionPost4 = dimensionPost2;
        Iterator it3 = hVar.f384D[endOffset].mo3843d().f518a.iterator();
        int dimensionPost5 = dimensionPost4;
        while (it3.hasNext()) {
            Iterator it4 = it3;
            C0189p anchor = (C0189p) it3.next();
            int endOffset2 = endOffset;
            C0189p pVar = anchor;
            dimensionPost5 = Math.max(dimensionPost5, m916a(anchor.f504c.f352b, i, z, postTemp3 + downDepth));
            it3 = it4;
            endOffset = endOffset2;
        }
        int endOffset3 = endOffset;
        if (hasBaseline) {
            dimensionPre -= baselinePreDistance;
            dimensionPost = dimensionPost5 + baselinePostDistance;
        } else {
            dimensionPost = dimensionPost5 + ((i == 0 ? widget.mo3920s() : widget.mo3900i()) * flow);
        }
        int dimensionBaseline = 0;
        if (i == 1) {
            Iterator it5 = hVar.f452z.mo3843d().f518a.iterator();
            while (it5.hasNext()) {
                Iterator it6 = it5;
                C0189p anchor2 = (C0189p) it5.next();
                int startOffset3 = startOffset;
                if (flow == 1) {
                    postTemp2 = postTemp3;
                    dimensionBaseline = Math.max(dimensionBaseline, m916a(anchor2.f504c.f352b, i, z, baselinePreDistance + downDepth));
                } else {
                    postTemp2 = postTemp3;
                    dimensionBaseline = Math.max(dimensionBaseline, m916a(anchor2.f504c.f352b, i, z, (baselinePostDistance * flow) + downDepth));
                }
                it5 = it6;
                startOffset = startOffset3;
                postTemp3 = postTemp2;
            }
            startOffset2 = startOffset;
            postTemp = postTemp3;
            if (hVar.f452z.mo3843d().f518a.size() > 0 && !hasBaseline) {
                if (flow == 1) {
                    dimensionBaseline += baselinePreDistance;
                } else {
                    dimensionBaseline -= baselinePostDistance;
                }
            }
        } else {
            startOffset2 = startOffset;
            postTemp = postTemp3;
        }
        int startOffset4 = dimension;
        int dimension2 = dimension + Math.max(dimensionPre, Math.max(dimensionPost, dimensionBaseline));
        int leftTop = depth2 + startOffset4;
        int end = leftTop + postTemp;
        int i2 = downDepth;
        if (flow == -1) {
            int aux2 = end;
            end = leftTop;
            leftTop = aux2;
        }
        if (z) {
            C0187n.m1081a(hVar, i, leftTop);
            hVar.mo3861a(leftTop, end, i);
        } else {
            hVar.f442s.mo3948a(hVar, i);
            hVar.mo3890d(leftTop, i);
        }
        if (widget.mo3883c(orientation) == C0181a.MATCH_CONSTRAINT && hVar.f390J != 0.0f) {
            hVar.f442s.mo3948a(hVar, i);
        }
        C0175f[] fVarArr2 = hVar.f384D;
        if (fVarArr2[startOffset2].f354d == null || fVarArr2[endOffset3].f354d == null) {
        } else {
            C0180h parent = widget.mo3904k();
            C0175f[] fVarArr3 = hVar.f384D;
            boolean z2 = hasBaseline;
            if (fVarArr3[startOffset2].f354d.f352b == parent && fVarArr3[endOffset3].f354d.f352b == parent) {
                hVar.f442s.mo3948a(hVar, i);
            }
        }
        return dimension2;
    }

    /* renamed from: a */
    private static void m918a(C0175f originAnchor) {
        C0191r originNode = originAnchor.mo3843d();
        C0175f fVar = originAnchor.f354d;
        if (fVar != null && fVar.f354d != originAnchor) {
            fVar.mo3843d().mo3973a(originNode);
        }
    }

    /* renamed from: b */
    private static void m925b(C0182i layoutWidget) {
        layoutWidget.f465Ha.clear();
        layoutWidget.f465Ha.add(0, new C0183j(layoutWidget.f530va));
    }

    /* renamed from: a */
    public static void m922a(List<C0183j> groups, int orientation, int containerLength) {
        int groupsSize = groups.size();
        for (int i = 0; i < groupsSize; i++) {
            for (C0180h widget : ((C0183j) groups.get(i)).mo3949b(orientation)) {
                if (widget.f425ja) {
                    m919a(widget, orientation, containerLength);
                }
            }
        }
    }

    /* renamed from: a */
    private static void m919a(C0180h widget, int orientation, int containerLength) {
        int offset = orientation * 2;
        C0175f[] fVarArr = widget.f384D;
        C0175f startAnchor = fVarArr[offset];
        C0175f endAnchor = fVarArr[offset + 1];
        if ((startAnchor.f354d == null || endAnchor.f354d == null) ? false : true) {
            C0187n.m1081a(widget, orientation, m915a(widget, orientation) + startAnchor.mo3841b());
        } else if (widget.f390J == 0.0f || widget.mo3883c(orientation) != C0181a.MATCH_CONSTRAINT) {
            int end = containerLength - widget.mo3891e(orientation);
            int start = end - widget.mo3888d(orientation);
            widget.mo3861a(start, end, orientation);
            C0187n.m1081a(widget, orientation, start);
        } else {
            int length = m914a(widget);
            int start2 = (int) widget.f384D[offset].mo3843d().f509h;
            int end2 = start2 + length;
            endAnchor.mo3843d().f508g = startAnchor.mo3843d();
            endAnchor.mo3843d().f509h = (float) length;
            endAnchor.mo3843d().f519b = 1;
            widget.mo3861a(start2, end2, orientation);
        }
    }

    /* renamed from: a */
    private static int m915a(C0180h widget, int orientation) {
        int offset = orientation * 2;
        C0175f[] fVarArr = widget.f384D;
        C0175f startAnchor = fVarArr[offset];
        C0175f endAnchor = fVarArr[offset + 1];
        C0175f fVar = startAnchor.f354d;
        if (fVar != null) {
            C0180h hVar = fVar.f352b;
            C0180h hVar2 = widget.f387G;
            if (hVar == hVar2) {
                C0175f fVar2 = endAnchor.f354d;
                if (fVar2 != null && fVar2.f352b == hVar2) {
                    return (int) (((float) (((hVar2.mo3888d(orientation) - startAnchor.mo3841b()) - endAnchor.mo3841b()) - widget.mo3888d(orientation))) * (orientation == 0 ? widget.f407aa : widget.f409ba));
                }
            }
        }
        return 0;
    }

    /* renamed from: a */
    private static int m914a(C0180h widget) {
        int length;
        int length2 = -1;
        if (widget.mo3902j() == C0181a.MATCH_CONSTRAINT) {
            if (widget.f391K == 0) {
                length2 = (int) (((float) widget.mo3900i()) * widget.f390J);
            } else {
                length2 = (int) (((float) widget.mo3900i()) / widget.f390J);
            }
            widget.mo3913o(length2);
        } else if (widget.mo3916q() == C0181a.MATCH_CONSTRAINT) {
            if (widget.f391K == 1) {
                length = (int) (((float) widget.mo3920s()) * widget.f390J);
            } else {
                length = (int) (((float) widget.mo3920s()) / widget.f390J);
            }
            widget.mo3897g(length2);
        }
        return length2;
    }
}
