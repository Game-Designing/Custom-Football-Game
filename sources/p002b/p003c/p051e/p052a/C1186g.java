package p002b.p003c.p051e.p052a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Build.VERSION;
import android.support.p000v4.content.p036a.C0509e;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import com.mopub.mobileads.VastIconXmlManager;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p002b.p003c.p053g.p054a.C1210b;
import p002b.p003c.p053g.p054a.C1210b.C1212b;
import p005cm.aptoide.p006pt.app.view.donations.DonationsAnalytics;

/* renamed from: b.c.e.a.g */
/* compiled from: AnimatorInflaterCompat */
public class C1186g {

    /* renamed from: b.c.e.a.g$a */
    /* compiled from: AnimatorInflaterCompat */
    private static class C1187a implements TypeEvaluator<C1212b[]> {

        /* renamed from: a */
        private C1212b[] f3850a;

        private C1187a() {
        }

        /* renamed from: a */
        public C1212b[] evaluate(float fraction, C1212b[] startPathData, C1212b[] endPathData) {
            if (C1210b.m5758a(startPathData, endPathData)) {
                C1212b[] bVarArr = this.f3850a;
                if (bVarArr == null || !C1210b.m5758a(bVarArr, startPathData)) {
                    this.f3850a = C1210b.m5761a(startPathData);
                }
                for (int i = 0; i < startPathData.length; i++) {
                    this.f3850a[i].mo8975a(startPathData[i], endPathData[i], fraction);
                }
                return this.f3850a;
            }
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }
    }

    /* renamed from: a */
    public static Animator m5655a(Context context, int id) throws NotFoundException {
        if (VERSION.SDK_INT >= 24) {
            return AnimatorInflater.loadAnimator(context, id);
        }
        return m5656a(context, context.getResources(), context.getTheme(), id);
    }

    /* renamed from: a */
    public static Animator m5656a(Context context, Resources resources, Theme theme, int id) throws NotFoundException {
        return m5657a(context, resources, theme, id, 1.0f);
    }

    /* renamed from: a */
    public static Animator m5657a(Context context, Resources resources, Theme theme, int id, float pathErrorScale) throws NotFoundException {
        String str = "Can't load animation resource ID #0x";
        XmlResourceParser parser = null;
        try {
            XmlResourceParser parser2 = resources.getAnimation(id);
            Animator animator = m5658a(context, resources, theme, (XmlPullParser) parser2, pathErrorScale);
            if (parser2 != null) {
                parser2.close();
            }
            return animator;
        } catch (XmlPullParserException ex) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(Integer.toHexString(id));
            NotFoundException rnf = new NotFoundException(sb.toString());
            rnf.initCause(ex);
            throw rnf;
        } catch (IOException ex2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(Integer.toHexString(id));
            NotFoundException rnf2 = new NotFoundException(sb2.toString());
            rnf2.initCause(ex2);
            throw rnf2;
        } catch (Throwable th) {
            if (parser != null) {
                parser.close();
            }
            throw th;
        }
    }

    /* renamed from: a */
    private static PropertyValuesHolder m5664a(TypedArray styledAttributes, int valueType, int valueFromId, int valueToId, String propertyName) {
        int valueType2;
        PropertyValuesHolder returnValue;
        PropertyValuesHolder returnValue2;
        int valueTo;
        char c;
        int valueFrom;
        int valueTo2;
        char c2;
        float valueTo3;
        float valueFrom2;
        float valueTo4;
        int toType;
        PropertyValuesHolder propertyValuesHolder;
        TypedArray typedArray = styledAttributes;
        int i = valueFromId;
        int i2 = valueToId;
        String str = propertyName;
        TypedValue tvFrom = typedArray.peekValue(i);
        boolean hasFrom = tvFrom != null;
        int fromType = hasFrom ? tvFrom.type : 0;
        TypedValue tvTo = typedArray.peekValue(i2);
        boolean hasTo = tvTo != null;
        int toType2 = hasTo ? tvTo.type : 0;
        int i3 = valueType;
        if (i3 != 4) {
            valueType2 = i3;
        } else if ((!hasFrom || !m5670a(fromType)) && (!hasTo || !m5670a(toType2))) {
            valueType2 = 0;
        } else {
            valueType2 = 3;
        }
        boolean getFloats = valueType2 == 0;
        if (valueType2 == 2) {
            String fromString = typedArray.getString(i);
            String toString = typedArray.getString(i2);
            C1212b[] nodesFrom = C1210b.m5760a(fromString);
            TypedValue typedValue = tvFrom;
            C1212b[] nodesTo = C1210b.m5760a(toString);
            if (nodesFrom == null && nodesTo == null) {
                TypedValue typedValue2 = tvTo;
                toType = toType2;
                propertyValuesHolder = null;
            } else {
                TypedValue typedValue3 = tvTo;
                if (nodesFrom != null) {
                    TypeEvaluator evaluator = new C1187a();
                    if (nodesTo == null) {
                        toType = toType2;
                        returnValue = PropertyValuesHolder.ofObject(str, evaluator, new Object[]{nodesFrom});
                    } else if (C1210b.m5758a(nodesFrom, nodesTo)) {
                        returnValue = PropertyValuesHolder.ofObject(str, evaluator, new Object[]{nodesFrom, nodesTo});
                        toType = toType2;
                    } else {
                        StringBuilder sb = new StringBuilder();
                        int i4 = toType2;
                        sb.append(" Can't morph from ");
                        sb.append(fromString);
                        sb.append(" to ");
                        sb.append(toString);
                        throw new InflateException(sb.toString());
                    }
                } else {
                    toType = toType2;
                    propertyValuesHolder = null;
                    if (nodesTo != null) {
                        returnValue = PropertyValuesHolder.ofObject(str, new C1187a(), new Object[]{nodesTo});
                    }
                }
                int toType3 = valueToId;
                int i5 = toType;
            }
            returnValue = propertyValuesHolder;
            int toType32 = valueToId;
            int i52 = toType;
        } else {
            TypedValue typedValue4 = tvTo;
            int toType4 = toType2;
            TypeEvaluator evaluator2 = null;
            if (valueType2 == 3) {
                evaluator2 = C1188h.m5673a();
            }
            if (!getFloats) {
                int i6 = valueToId;
                int toType5 = toType4;
                if (hasFrom) {
                    if (fromType == 5) {
                        valueFrom = (int) typedArray.getDimension(i, 0.0f);
                    } else if (m5670a(fromType) != 0) {
                        valueFrom = typedArray.getColor(i, 0);
                    } else {
                        valueFrom = typedArray.getInt(i, 0);
                    }
                    if (hasTo) {
                        if (toType5 == 5) {
                            valueTo2 = (int) typedArray.getDimension(i6, 0.0f);
                            c2 = 0;
                        } else if (m5670a(toType5) != 0) {
                            c2 = 0;
                            valueTo2 = typedArray.getColor(i6, 0);
                        } else {
                            c2 = 0;
                            valueTo2 = typedArray.getInt(i6, 0);
                        }
                        int[] iArr = new int[2];
                        iArr[c2] = valueFrom;
                        iArr[1] = valueTo2;
                        returnValue2 = PropertyValuesHolder.ofInt(str, iArr);
                    } else {
                        returnValue2 = PropertyValuesHolder.ofInt(str, new int[]{valueFrom});
                    }
                } else if (hasTo) {
                    if (toType5 == 5) {
                        valueTo = (int) typedArray.getDimension(i6, 0.0f);
                        c = 0;
                    } else if (m5670a(toType5) != 0) {
                        c = 0;
                        valueTo = typedArray.getColor(i6, 0);
                    } else {
                        c = 0;
                        valueTo = typedArray.getInt(i6, 0);
                    }
                    int[] iArr2 = new int[1];
                    iArr2[c] = valueTo;
                    returnValue2 = PropertyValuesHolder.ofInt(str, iArr2);
                } else {
                    returnValue2 = null;
                }
            } else if (hasFrom) {
                if (fromType == 5) {
                    valueFrom2 = typedArray.getDimension(i, 0.0f);
                } else {
                    valueFrom2 = typedArray.getFloat(i, 0.0f);
                }
                if (hasTo) {
                    if (toType4 == 5) {
                        valueTo4 = typedArray.getDimension(valueToId, 0.0f);
                    } else {
                        valueTo4 = typedArray.getFloat(valueToId, 0.0f);
                    }
                    returnValue2 = PropertyValuesHolder.ofFloat(str, new float[]{valueFrom2, valueTo4});
                } else {
                    int i7 = valueToId;
                    int i8 = toType4;
                    returnValue2 = PropertyValuesHolder.ofFloat(str, new float[]{valueFrom2});
                }
            } else {
                int i9 = valueToId;
                if (toType4 == 5) {
                    valueTo3 = typedArray.getDimension(i9, 0.0f);
                } else {
                    valueTo3 = typedArray.getFloat(i9, 0.0f);
                }
                returnValue2 = PropertyValuesHolder.ofFloat(str, new float[]{valueTo3});
            }
            if (!(returnValue == null || evaluator2 == null)) {
                returnValue.setEvaluator(evaluator2);
            }
        }
        return returnValue;
    }

    /* renamed from: a */
    private static void m5667a(ValueAnimator anim, TypedArray arrayAnimator, TypedArray arrayObjectAnimator, float pixelSize, XmlPullParser parser) {
        long duration = (long) C0509e.m2558b(arrayAnimator, parser, VastIconXmlManager.DURATION, 1, 300);
        long startDelay = (long) C0509e.m2558b(arrayAnimator, parser, "startOffset", 2, 0);
        int valueType = C0509e.m2558b(arrayAnimator, parser, "valueType", 7, 4);
        if (C0509e.m2556a(parser, "valueFrom") && C0509e.m2556a(parser, "valueTo")) {
            if (valueType == 4) {
                valueType = m5654a(arrayAnimator, 5, 6);
            }
            PropertyValuesHolder pvh = m5664a(arrayAnimator, valueType, 5, 6, "");
            if (pvh != null) {
                anim.setValues(new PropertyValuesHolder[]{pvh});
            }
        }
        anim.setDuration(duration);
        anim.setStartDelay(startDelay);
        anim.setRepeatCount(C0509e.m2558b(arrayAnimator, parser, "repeatCount", 3, 0));
        anim.setRepeatMode(C0509e.m2558b(arrayAnimator, parser, "repeatMode", 4, 1));
        if (arrayObjectAnimator != null) {
            m5666a(anim, arrayObjectAnimator, valueType, pixelSize, parser);
        }
    }

    /* renamed from: a */
    private static void m5666a(ValueAnimator anim, TypedArray arrayObjectAnimator, int valueType, float pixelSize, XmlPullParser parser) {
        ObjectAnimator oa = (ObjectAnimator) anim;
        String pathData = C0509e.m2553a(arrayObjectAnimator, parser, "pathData", 1);
        if (pathData != null) {
            String propertyXName = C0509e.m2553a(arrayObjectAnimator, parser, "propertyXName", 2);
            String propertyYName = C0509e.m2553a(arrayObjectAnimator, parser, "propertyYName", 3);
            if (valueType == 2 || valueType == 4) {
            }
            if (propertyXName == null && propertyYName == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(arrayObjectAnimator.getPositionDescription());
                sb.append(" propertyXName or propertyYName is needed for PathData");
                throw new InflateException(sb.toString());
            }
            m5668a(C1210b.m5762b(pathData), oa, 0.5f * pixelSize, propertyXName, propertyYName);
            return;
        }
        oa.setPropertyName(C0509e.m2553a(arrayObjectAnimator, parser, "propertyName", 0));
    }

    /* renamed from: a */
    private static void m5668a(Path path, ObjectAnimator oa, float precision, String propertyXName, String propertyYName) {
        Path path2 = path;
        ObjectAnimator objectAnimator = oa;
        String str = propertyXName;
        String str2 = propertyYName;
        boolean z = false;
        PathMeasure measureForTotalLength = new PathMeasure(path2, false);
        float totalLength = 0.0f;
        ArrayList<Float> contourLengths = new ArrayList<>();
        contourLengths.add(Float.valueOf(0.0f));
        while (true) {
            totalLength += measureForTotalLength.getLength();
            contourLengths.add(Float.valueOf(totalLength));
            if (!measureForTotalLength.nextContour()) {
                break;
            }
            z = false;
            path2 = path;
        }
        PathMeasure pathMeasure = new PathMeasure(path2, z);
        int numPoints = Math.min(100, ((int) (totalLength / precision)) + 1);
        float[] mX = new float[numPoints];
        float[] mY = new float[numPoints];
        float[] position = new float[2];
        float step = totalLength / ((float) (numPoints - 1));
        float currentDistance = 0.0f;
        int contourIndex = 0;
        int i = 0;
        while (i < numPoints) {
            pathMeasure.getPosTan(currentDistance, position, null);
            mX[i] = position[0];
            mY[i] = position[1];
            currentDistance += step;
            if (contourIndex + 1 < contourLengths.size() && currentDistance > ((Float) contourLengths.get(contourIndex + 1)).floatValue()) {
                currentDistance -= ((Float) contourLengths.get(contourIndex + 1)).floatValue();
                contourIndex++;
                pathMeasure.nextContour();
            }
            i++;
            Path path3 = path;
        }
        PropertyValuesHolder x = null;
        PropertyValuesHolder y = null;
        if (str != null) {
            x = PropertyValuesHolder.ofFloat(str, mX);
        }
        if (str2 != null) {
            y = PropertyValuesHolder.ofFloat(str2, mY);
        }
        if (x == null) {
            objectAnimator.setValues(new PropertyValuesHolder[]{y});
        } else if (y == null) {
            objectAnimator.setValues(new PropertyValuesHolder[]{x});
        } else {
            objectAnimator.setValues(new PropertyValuesHolder[]{x, y});
        }
    }

    /* renamed from: a */
    private static Animator m5658a(Context context, Resources res, Theme theme, XmlPullParser parser, float pixelSize) throws XmlPullParserException, IOException {
        return m5659a(context, res, theme, parser, Xml.asAttributeSet(parser), null, 0, pixelSize);
    }

    /* JADX WARNING: type inference failed for: r7v0 */
    /* JADX WARNING: type inference failed for: r7v2 */
    /* JADX WARNING: type inference failed for: r7v3, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r5v1, types: [android.animation.AnimatorSet] */
    /* JADX WARNING: type inference failed for: r7v6 */
    /* JADX WARNING: type inference failed for: r0v22, types: [android.animation.ValueAnimator] */
    /* JADX WARNING: type inference failed for: r7v7 */
    /* JADX WARNING: type inference failed for: r0v24, types: [android.animation.ObjectAnimator] */
    /* JADX WARNING: type inference failed for: r7v8 */
    /* JADX WARNING: type inference failed for: r7v9 */
    /* JADX WARNING: type inference failed for: r7v10 */
    /* JADX WARNING: type inference failed for: r7v11 */
    /* JADX WARNING: type inference failed for: r7v12 */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0010, code lost:
        r7 = r7;
     */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r7v2
      assigns: []
      uses: []
      mth insns count: 113
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 5 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.animation.Animator m5659a(android.content.Context r19, android.content.res.Resources r20, android.content.res.Resources.Theme r21, org.xmlpull.v1.XmlPullParser r22, android.util.AttributeSet r23, android.animation.AnimatorSet r24, int r25, float r26) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r8 = r20
            r9 = r21
            r10 = r22
            r11 = r24
            r0 = 0
            r1 = 0
            int r12 = r22.getDepth()
            r7 = r0
            r13 = r1
        L_0x0010:
            int r0 = r22.next()
            r14 = r0
            r1 = 3
            if (r0 != r1) goto L_0x0023
            int r0 = r22.getDepth()
            if (r0 <= r12) goto L_0x001f
            goto L_0x0023
        L_0x001f:
            r1 = r19
            goto L_0x00f4
        L_0x0023:
            r0 = 1
            if (r14 == r0) goto L_0x00f2
            r0 = 2
            if (r14 == r0) goto L_0x002a
            goto L_0x0010
        L_0x002a:
            java.lang.String r15 = r22.getName()
            r16 = 0
            java.lang.String r0 = "objectAnimator"
            boolean r0 = r15.equals(r0)
            if (r0 == 0) goto L_0x004d
            r0 = r19
            r1 = r20
            r2 = r21
            r3 = r23
            r4 = r26
            r5 = r22
            android.animation.ObjectAnimator r0 = m5662a(r0, r1, r2, r3, r4, r5)
            r1 = r19
            r7 = r0
            goto L_0x00c4
        L_0x004d:
            java.lang.String r0 = "animator"
            boolean r0 = r15.equals(r0)
            if (r0 == 0) goto L_0x006a
            r4 = 0
            r0 = r19
            r1 = r20
            r2 = r21
            r3 = r23
            r5 = r26
            r6 = r22
            android.animation.ValueAnimator r0 = m5665a(r0, r1, r2, r3, r4, r5, r6)
            r1 = r19
            r7 = r0
            goto L_0x00c4
        L_0x006a:
            java.lang.String r0 = "set"
            boolean r0 = r15.equals(r0)
            if (r0 == 0) goto L_0x00a0
            android.animation.AnimatorSet r5 = new android.animation.AnimatorSet
            r5.<init>()
            int[] r0 = p002b.p003c.p051e.p052a.C1178a.f3832h
            r7 = r23
            android.content.res.TypedArray r6 = android.support.p000v4.content.p036a.C0509e.m2551a(r8, r9, r7, r0)
            r0 = 0
            java.lang.String r1 = "ordering"
            int r17 = android.support.p000v4.content.p036a.C0509e.m2558b(r6, r10, r1, r0, r0)
            r0 = r19
            r1 = r20
            r2 = r21
            r3 = r22
            r4 = r23
            r18 = r6
            r6 = r17
            r7 = r26
            m5659a(r0, r1, r2, r3, r4, r5, r6, r7)
            r18.recycle()
            r1 = r19
            r7 = r5
            goto L_0x00c4
        L_0x00a0:
            java.lang.String r0 = "propertyValuesHolder"
            boolean r0 = r15.equals(r0)
            if (r0 == 0) goto L_0x00d5
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r22)
            r1 = r19
            android.animation.PropertyValuesHolder[] r0 = m5671a(r1, r8, r9, r10, r0)
            if (r0 == 0) goto L_0x00c1
            if (r7 == 0) goto L_0x00c1
            boolean r2 = r7 instanceof android.animation.ValueAnimator
            if (r2 == 0) goto L_0x00c1
            r2 = r7
            android.animation.ValueAnimator r2 = (android.animation.ValueAnimator) r2
            r2.setValues(r0)
        L_0x00c1:
            r16 = 1
        L_0x00c4:
            if (r11 == 0) goto L_0x00d3
            if (r16 != 0) goto L_0x00d3
            if (r13 != 0) goto L_0x00d0
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r13 = r0
        L_0x00d0:
            r13.add(r7)
        L_0x00d3:
            goto L_0x0010
        L_0x00d5:
            r1 = r19
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Unknown animator name: "
            r2.append(r3)
            java.lang.String r3 = r22.getName()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        L_0x00f2:
            r1 = r19
        L_0x00f4:
            if (r11 == 0) goto L_0x011e
            if (r13 == 0) goto L_0x011e
            int r0 = r13.size()
            android.animation.Animator[] r0 = new android.animation.Animator[r0]
            r2 = 0
            java.util.Iterator r3 = r13.iterator()
        L_0x0103:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0115
            java.lang.Object r4 = r3.next()
            android.animation.Animator r4 = (android.animation.Animator) r4
            int r5 = r2 + 1
            r0[r2] = r4
            r2 = r5
            goto L_0x0103
        L_0x0115:
            if (r25 != 0) goto L_0x011b
            r11.playTogether(r0)
            goto L_0x011e
        L_0x011b:
            r11.playSequentially(r0)
        L_0x011e:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: p002b.p003c.p051e.p052a.C1186g.m5659a(android.content.Context, android.content.res.Resources, android.content.res.Resources$Theme, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.animation.AnimatorSet, int, float):android.animation.Animator");
    }

    /* renamed from: a */
    private static PropertyValuesHolder[] m5671a(Context context, Resources res, Theme theme, XmlPullParser parser, AttributeSet attrs) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParser = parser;
        ArrayList arrayList = null;
        while (true) {
            int eventType = parser.getEventType();
            int type = eventType;
            if (eventType == 3 || type == 1) {
                Resources resources = res;
                Theme theme2 = theme;
                AttributeSet attributeSet = attrs;
                PropertyValuesHolder[] valuesArray = null;
            } else if (type != 2) {
                parser.next();
            } else {
                if (parser.getName().equals("propertyValuesHolder")) {
                    TypedArray a = C0509e.m2551a(res, theme, attrs, C1178a.f3833i);
                    String propertyName = C0509e.m2553a(a, xmlPullParser, "propertyName", 3);
                    int valueType = C0509e.m2558b(a, xmlPullParser, "valueType", 2, 4);
                    int valueType2 = valueType;
                    PropertyValuesHolder pvh = m5663a(context, res, theme, parser, propertyName, valueType);
                    if (pvh == null) {
                        pvh = m5664a(a, valueType2, 0, 1, propertyName);
                    }
                    if (pvh != null) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(pvh);
                    }
                    a.recycle();
                } else {
                    Resources resources2 = res;
                    Theme theme3 = theme;
                    AttributeSet attributeSet2 = attrs;
                }
                parser.next();
            }
        }
        Resources resources3 = res;
        Theme theme22 = theme;
        AttributeSet attributeSet3 = attrs;
        PropertyValuesHolder[] valuesArray2 = null;
        if (arrayList != null) {
            int count = arrayList.size();
            valuesArray2 = new PropertyValuesHolder[count];
            for (int i = 0; i < count; i++) {
                valuesArray2[i] = (PropertyValuesHolder) arrayList.get(i);
            }
        }
        return valuesArray2;
    }

    /* renamed from: a */
    private static int m5653a(Resources res, Theme theme, AttributeSet attrs, XmlPullParser parser) {
        int valueType;
        TypedArray a = C0509e.m2551a(res, theme, attrs, C1178a.f3834j);
        boolean hasValue = false;
        TypedValue keyframeValue = C0509e.m2559b(a, parser, DonationsAnalytics.VALUE, 0);
        if (keyframeValue != null) {
            hasValue = true;
        }
        if (!hasValue || !m5670a(keyframeValue.type)) {
            valueType = 0;
        } else {
            valueType = 3;
        }
        a.recycle();
        return valueType;
    }

    /* renamed from: a */
    private static int m5654a(TypedArray styledAttributes, int valueFromId, int valueToId) {
        TypedValue tvFrom = styledAttributes.peekValue(valueFromId);
        boolean hasTo = true;
        int toType = 0;
        boolean hasFrom = tvFrom != null;
        int fromType = hasFrom ? tvFrom.type : 0;
        TypedValue tvTo = styledAttributes.peekValue(valueToId);
        if (tvTo == null) {
            hasTo = false;
        }
        if (hasTo) {
            toType = tvTo.type;
        }
        if ((!hasFrom || !m5670a(fromType)) && (!hasTo || !m5670a(toType))) {
            return 0;
        }
        return 3;
    }

    /* renamed from: a */
    private static PropertyValuesHolder m5663a(Context context, Resources res, Theme theme, XmlPullParser parser, String propertyName, int valueType) throws XmlPullParserException, IOException {
        int type;
        PropertyValuesHolder value;
        Object obj;
        int type2;
        ArrayList arrayList;
        Object obj2 = null;
        ArrayList arrayList2 = null;
        int valueType2 = valueType;
        while (true) {
            int next = parser.next();
            type = next;
            if (next == 3 || type == 1) {
                Resources resources = res;
                Theme theme2 = theme;
                XmlPullParser xmlPullParser = parser;
            } else if (parser.getName().equals("keyframe")) {
                if (valueType2 == 4) {
                    valueType2 = m5653a(res, theme, Xml.asAttributeSet(parser), parser);
                } else {
                    Resources resources2 = res;
                    Theme theme3 = theme;
                    XmlPullParser xmlPullParser2 = parser;
                }
                Keyframe keyframe = m5661a(context, res, theme, Xml.asAttributeSet(parser), valueType2, parser);
                if (keyframe != null) {
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                    }
                    arrayList2.add(keyframe);
                }
                parser.next();
            } else {
                Resources resources3 = res;
                Theme theme4 = theme;
                XmlPullParser xmlPullParser3 = parser;
            }
        }
        Resources resources4 = res;
        Theme theme22 = theme;
        XmlPullParser xmlPullParser4 = parser;
        if (arrayList2 != null) {
            int size = arrayList2.size();
            int count = size;
            if (size > 0) {
                Keyframe firstKeyframe = (Keyframe) arrayList2.get(0);
                Keyframe lastKeyframe = (Keyframe) arrayList2.get(count - 1);
                float endFraction = lastKeyframe.getFraction();
                float f = 0.0f;
                if (endFraction < 1.0f) {
                    if (endFraction < 0.0f) {
                        lastKeyframe.setFraction(1.0f);
                    } else {
                        arrayList2.add(arrayList2.size(), m5660a(lastKeyframe, 1.0f));
                        count++;
                    }
                }
                float startFraction = firstKeyframe.getFraction();
                if (startFraction != 0.0f) {
                    if (startFraction < 0.0f) {
                        firstKeyframe.setFraction(0.0f);
                    } else {
                        arrayList2.add(0, m5660a(firstKeyframe, 0.0f));
                        count++;
                    }
                }
                Keyframe[] keyframeArray = new Keyframe[count];
                arrayList2.toArray(keyframeArray);
                int i = 0;
                while (i < count) {
                    Keyframe keyframe2 = keyframeArray[i];
                    if (keyframe2.getFraction() >= f) {
                        obj = obj2;
                        arrayList = arrayList2;
                        type2 = type;
                    } else if (i == 0) {
                        keyframe2.setFraction(f);
                        obj = obj2;
                        arrayList = arrayList2;
                        type2 = type;
                    } else if (i == count - 1) {
                        keyframe2.setFraction(1.0f);
                        obj = obj2;
                        arrayList = arrayList2;
                        type2 = type;
                    } else {
                        int startIndex = i;
                        obj = obj2;
                        int j = startIndex + 1;
                        arrayList = arrayList2;
                        int endIndex = i;
                        while (true) {
                            type2 = type;
                            if (j >= count - 1) {
                                break;
                            } else if (keyframeArray[j].getFraction() >= 0.0f) {
                                break;
                            } else {
                                endIndex = j;
                                j++;
                                type = type2;
                            }
                        }
                        m5669a(keyframeArray, keyframeArray[endIndex + 1].getFraction() - keyframeArray[startIndex - 1].getFraction(), startIndex, endIndex);
                    }
                    i++;
                    arrayList2 = arrayList;
                    type = type2;
                    obj2 = obj;
                    f = 0.0f;
                }
                Object obj3 = obj2;
                ArrayList arrayList3 = arrayList2;
                int i2 = type;
                PropertyValuesHolder value2 = PropertyValuesHolder.ofKeyframe(propertyName, keyframeArray);
                if (valueType2 != 3) {
                    return value2;
                }
                value2.setEvaluator(C1188h.m5673a());
                return value2;
            }
            value = null;
            ArrayList arrayList4 = arrayList2;
            int i3 = type;
            String str = propertyName;
        } else {
            value = null;
            ArrayList arrayList5 = arrayList2;
            int i4 = type;
            String str2 = propertyName;
        }
        return value;
    }

    /* renamed from: a */
    private static Keyframe m5660a(Keyframe sampleKeyframe, float fraction) {
        if (sampleKeyframe.getType() == Float.TYPE) {
            return Keyframe.ofFloat(fraction);
        }
        if (sampleKeyframe.getType() == Integer.TYPE) {
            return Keyframe.ofInt(fraction);
        }
        return Keyframe.ofObject(fraction);
    }

    /* renamed from: a */
    private static void m5669a(Keyframe[] keyframes, float gap, int startIndex, int endIndex) {
        float increment = gap / ((float) ((endIndex - startIndex) + 2));
        for (int i = startIndex; i <= endIndex; i++) {
            keyframes[i].setFraction(keyframes[i - 1].getFraction() + increment);
        }
    }

    /* renamed from: a */
    private static Keyframe m5661a(Context context, Resources res, Theme theme, AttributeSet attrs, int valueType, XmlPullParser parser) throws XmlPullParserException, IOException {
        Keyframe keyframe;
        TypedArray a = C0509e.m2551a(res, theme, attrs, C1178a.f3834j);
        Keyframe keyframe2 = null;
        float fraction = C0509e.m2547a(a, parser, "fraction", 3, -1.0f);
        String str = DonationsAnalytics.VALUE;
        TypedValue keyframeValue = C0509e.m2559b(a, parser, str, 0);
        boolean hasValue = keyframeValue != null;
        if (valueType == 4) {
            if (!hasValue || !m5670a(keyframeValue.type)) {
                valueType = 0;
            } else {
                valueType = 3;
            }
        }
        if (!hasValue) {
            if (valueType == 0) {
                keyframe = Keyframe.ofFloat(fraction);
            } else {
                keyframe = Keyframe.ofInt(fraction);
            }
            keyframe2 = keyframe;
        } else if (valueType == 0) {
            keyframe2 = Keyframe.ofFloat(fraction, C0509e.m2547a(a, parser, str, 0, 0.0f));
        } else if (valueType == 1 || valueType == 3) {
            keyframe2 = Keyframe.ofInt(fraction, C0509e.m2558b(a, parser, str, 0, 0));
        }
        int resID = C0509e.m2561c(a, parser, "interpolator", 1, 0);
        if (resID > 0) {
            keyframe2.setInterpolator(C1184e.m5651a(context, resID));
        }
        a.recycle();
        return keyframe2;
    }

    /* renamed from: a */
    private static ObjectAnimator m5662a(Context context, Resources res, Theme theme, AttributeSet attrs, float pathErrorScale, XmlPullParser parser) throws NotFoundException {
        ObjectAnimator anim = new ObjectAnimator();
        m5665a(context, res, theme, attrs, anim, pathErrorScale, parser);
        return anim;
    }

    /* renamed from: a */
    private static ValueAnimator m5665a(Context context, Resources res, Theme theme, AttributeSet attrs, ValueAnimator anim, float pathErrorScale, XmlPullParser parser) throws NotFoundException {
        TypedArray arrayAnimator = C0509e.m2551a(res, theme, attrs, C1178a.f3831g);
        TypedArray arrayObjectAnimator = C0509e.m2551a(res, theme, attrs, C1178a.f3835k);
        if (anim == null) {
            anim = new ValueAnimator();
        }
        m5667a(anim, arrayAnimator, arrayObjectAnimator, pathErrorScale, parser);
        int resID = C0509e.m2561c(arrayAnimator, parser, "interpolator", 0, 0);
        if (resID > 0) {
            anim.setInterpolator(C1184e.m5651a(context, resID));
        }
        arrayAnimator.recycle();
        if (arrayObjectAnimator != null) {
            arrayObjectAnimator.recycle();
        }
        return anim;
    }

    /* renamed from: a */
    private static boolean m5670a(int type) {
        return type >= 28 && type <= 31;
    }
}
