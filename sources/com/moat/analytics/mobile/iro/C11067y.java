package com.moat.analytics.mobile.iro;

import android.graphics.Rect;
import android.location.Location;
import android.support.p001v7.widget.LinearLayoutManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import org.json.JSONObject;

/* renamed from: com.moat.analytics.mobile.iro.y */
final class C11067y {

    /* renamed from: ˊॱ */
    private static int f33820 = 0;

    /* renamed from: ˏॱ */
    private static int f33821 = 1;

    /* renamed from: ʻ */
    private Location f33822;

    /* renamed from: ʼ */
    private Map<String, Object> f33823 = new HashMap();

    /* renamed from: ʽ */
    private JSONObject f33824;

    /* renamed from: ˊ */
    private C11069a f33825 = new C11069a();

    /* renamed from: ˋ */
    private Rect f33826;

    /* renamed from: ˎ */
    String f33827 = "{}";

    /* renamed from: ˏ */
    private JSONObject f33828;

    /* renamed from: ॱ */
    private Rect f33829;

    /* renamed from: ᐝ */
    private JSONObject f33830;

    /* renamed from: com.moat.analytics.mobile.iro.y$a */
    static class C11069a {

        /* renamed from: ˊ */
        Rect f33831 = new Rect(0, 0, 0, 0);

        /* renamed from: ˋ */
        double f33832 = 0.0d;

        /* renamed from: ˎ */
        double f33833 = 0.0d;

        C11069a() {
        }
    }

    /* renamed from: com.moat.analytics.mobile.iro.y$b */
    static class C11070b {

        /* renamed from: ˊ */
        final View f33834;

        /* renamed from: ˋ */
        final boolean f33835;

        /* renamed from: ॱ */
        final int f33836;

        C11070b(View view, int i, boolean z) {
            this.f33834 = view;
            this.f33836 = i;
            this.f33835 = z;
        }
    }

    C11067y() {
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x012d, code lost:
        if (r14 != 'E') goto L_0x012f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x013d, code lost:
        if (r11 != '4') goto L_0x0140;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x0226, code lost:
        if (r4 != true) goto L_0x0238;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x0235, code lost:
        if (r4 != 'Z') goto L_0x0238;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x0238, code lost:
        if (r13 == false) goto L_0x023c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x023a, code lost:
        r4 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x023c, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x023d, code lost:
        if (r4 == true) goto L_0x031f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x023f, code lost:
        if (r11 != false) goto L_0x0244;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x0241, code lost:
        r4 = 18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x0244, code lost:
        r4 = '[';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x0248, code lost:
        if (r4 == '[') goto L_0x031f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x024a, code lost:
        r4 = f33821 + 17;
        f33820 = r4 % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x0255, code lost:
        if ((r4 % 2) == 0) goto L_0x0257;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x0257, code lost:
        if (r15 <= 0) goto L_0x025b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x0259, code lost:
        r4 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x025b, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x025c, code lost:
        if (r4 == true) goto L_0x031f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x025e, code lost:
        r4 = f33821 + org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes.LSHL;
        f33820 = r4 % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x0268, code lost:
        if ((r4 % 2) == 0) goto L_0x026a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:?, code lost:
        r4 = new android.graphics.Rect(0, 0, 0, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x0274, code lost:
        if (r0.getGlobalVisibleRect(r4) == false) goto L_0x0278;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x0276, code lost:
        r6 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x0278, code lost:
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x0279, code lost:
        if (r6 == true) goto L_0x027c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x0285, code lost:
        r6 = r4.width() * r4.height();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x0288, code lost:
        if (r6 >= r15) goto L_0x028c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x028a, code lost:
        r11 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x028c, code lost:
        r11 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x028d, code lost:
        if (r11 == false) goto L_0x0290;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x0290, code lost:
        r11 = f33821 + 39;
        f33820 = r11 % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x029a, code lost:
        if ((r11 % 2) == 0) goto L_0x029c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:?, code lost:
        com.moat.analytics.mobile.iro.C11011b.m36235("VisibilityInfo", null, "Ad is clipped");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x02a3, code lost:
        r11 = new java.util.HashSet();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x02ae, code lost:
        if ((r20.getRootView() instanceof android.view.ViewGroup) == false) goto L_0x02b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x02b0, code lost:
        r13 = ')';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x02b3, code lost:
        r13 = 'T';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:0x02b7, code lost:
        if (r13 == ')') goto L_0x02bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x02bb, code lost:
        r5 = f33820 + 49;
        f33821 = r5 % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:0x02c5, code lost:
        if ((r5 % 2) != 0) goto L_0x02c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:?, code lost:
        r12.f33831 = r4;
        r0 = m36418(r4, r0, (java.util.Set<android.graphics.Rect>) r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:0x02cd, code lost:
        if (r0 == false) goto L_0x02d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x02cf, code lost:
        r5 = 'Y';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:223:0x02d2, code lost:
        r5 = '\\';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:0x02d6, code lost:
        if (r5 == '\\') goto L_0x02dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x02d8, code lost:
        r12.f33833 = 1.0d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x02dc, code lost:
        if (r0 != false) goto L_0x02e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x02de, code lost:
        r0 = 21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x02e1, code lost:
        r0 = 18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x02e5, code lost:
        if (r0 == 21) goto L_0x02e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:233:0x02e9, code lost:
        r0 = m36414(r4, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:234:0x02ed, code lost:
        if (r0 <= 0) goto L_0x02f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:235:0x02ef, code lost:
        r4 = ']';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x02f2, code lost:
        r4 = 26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:0x02f6, code lost:
        if (r4 == ']') goto L_0x02fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:0x02f8, code lost:
        r11 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x02fa, code lost:
        r4 = f33820 + 87;
        f33821 = r4 % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:0x0304, code lost:
        if ((r4 % 2) != 0) goto L_0x0306;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x0306, code lost:
        r7 = (double) r0;
        r11 = r3;
        r3 = (double) r6;
        java.lang.Double.isNaN(r7);
        java.lang.Double.isNaN(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:?, code lost:
        r12.f33833 = r7 / r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:0x0312, code lost:
        r3 = (double) (r6 - r0);
        r6 = (double) r15;
        java.lang.Double.isNaN(r3);
        java.lang.Double.isNaN(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:247:?, code lost:
        r12.f33832 = r3 / r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:265:0x034e, code lost:
        if (r0 != false) goto L_0x0350;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:301:0x03d3, code lost:
        if (r14.equals(r1.f33829) == false) goto L_0x03d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:310:0x03f7, code lost:
        if (r9.equals(r1.f33826) == false) goto L_0x03f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x006b, code lost:
        if (r10 != ';') goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:379:0x0529, code lost:
        r0 = e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x015e A[SYNTHETIC, Splitter:B:121:0x015e] */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0188  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x018b  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x01a5 A[Catch:{ Exception -> 0x052b }] */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x01a7 A[Catch:{ Exception -> 0x052b }] */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x01aa A[Catch:{ Exception -> 0x052b }] */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x01ac A[Catch:{ Exception -> 0x052b }] */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x01b8 A[Catch:{ Exception -> 0x052b }] */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x01ba A[Catch:{ Exception -> 0x052b }] */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x01bd A[Catch:{ Exception -> 0x052b }] */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x01bf A[Catch:{ Exception -> 0x052b }] */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x01de A[Catch:{ Exception -> 0x052b }] */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x01e0 A[Catch:{ Exception -> 0x052b }] */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x01e3 A[Catch:{ Exception -> 0x052b }] */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x01e8 A[Catch:{ Exception -> 0x052b }] */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x0202  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0207  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0210  */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x0326  */
    /* JADX WARNING: Removed duplicated region for block: B:252:0x0328  */
    /* JADX WARNING: Removed duplicated region for block: B:254:0x032c  */
    /* JADX WARNING: Removed duplicated region for block: B:287:0x03ab  */
    /* JADX WARNING: Removed duplicated region for block: B:288:0x03ad  */
    /* JADX WARNING: Removed duplicated region for block: B:290:0x03b0  */
    /* JADX WARNING: Removed duplicated region for block: B:305:0x03eb A[Catch:{ Exception -> 0x0529 }] */
    /* JADX WARNING: Removed duplicated region for block: B:306:0x03ed A[Catch:{ Exception -> 0x0529 }] */
    /* JADX WARNING: Removed duplicated region for block: B:308:0x03f0 A[Catch:{ Exception -> 0x0529 }] */
    /* JADX WARNING: Removed duplicated region for block: B:309:0x03f1 A[Catch:{ Exception -> 0x0529 }] */
    /* JADX WARNING: Removed duplicated region for block: B:314:0x040f  */
    /* JADX WARNING: Removed duplicated region for block: B:315:0x0411  */
    /* JADX WARNING: Removed duplicated region for block: B:317:0x0415  */
    /* JADX WARNING: Removed duplicated region for block: B:333:0x044c  */
    /* JADX WARNING: Removed duplicated region for block: B:334:0x044e  */
    /* JADX WARNING: Removed duplicated region for block: B:336:0x0451  */
    /* JADX WARNING: Removed duplicated region for block: B:342:0x0463  */
    /* JADX WARNING: Removed duplicated region for block: B:343:0x0465  */
    /* JADX WARNING: Removed duplicated region for block: B:345:0x046a  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a7 A[Catch:{ Exception -> 0x052b }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00a9 A[Catch:{ Exception -> 0x052b }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00b0 A[Catch:{ Exception -> 0x052b }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00cc A[Catch:{ Exception -> 0x052b }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00ef A[Catch:{ Exception -> 0x052b }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00f1 A[Catch:{ Exception -> 0x052b }] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00f5 A[Catch:{ Exception -> 0x052b }] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x010e  */
    /* renamed from: ˎ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo36132(java.lang.String r19, android.view.View r20) {
        /*
            r18 = this;
            r1 = r18
            r0 = r20
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            java.lang.String r3 = "{}"
            r4 = 78
            r5 = 0
            if (r0 == 0) goto L_0x0014
            r6 = 78
            goto L_0x0015
        L_0x0014:
            r6 = 0
        L_0x0015:
            if (r6 == r4) goto L_0x0019
        L_0x0017:
            goto L_0x0528
        L_0x0019:
            int r4 = f33821
            int r4 = r4 + 31
            int r6 = r4 % 128
            f33820 = r6
            int r4 = r4 % 2
            if (r4 == 0) goto L_0x0025
        L_0x0025:
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x052b }
            r6 = 17
            r7 = 1
            if (r4 < r6) goto L_0x002f
            r4 = 0
            goto L_0x0030
        L_0x002f:
            r4 = 1
        L_0x0030:
            r9 = 93
            if (r4 == 0) goto L_0x0035
        L_0x0034:
            goto L_0x0093
        L_0x0035:
            int r4 = f33820
            int r4 = r4 + r9
            int r10 = r4 % 128
            f33821 = r10
            int r4 = r4 % 2
            if (r4 != 0) goto L_0x0040
        L_0x0040:
            java.lang.ref.WeakReference<android.app.Activity> r4 = com.moat.analytics.mobile.iro.C11009a.f33631     // Catch:{ Exception -> 0x052b }
            if (r4 == 0) goto L_0x0046
            r4 = 0
            goto L_0x0047
        L_0x0046:
            r4 = 1
        L_0x0047:
            if (r4 == r7) goto L_0x0034
            int r4 = f33821
            int r4 = r4 + 85
            int r10 = r4 % 128
            f33820 = r10
            int r4 = r4 % 2
            if (r4 == 0) goto L_0x0057
            r4 = 1
            goto L_0x0058
        L_0x0057:
            r4 = 0
        L_0x0058:
            if (r4 == r7) goto L_0x006e
            java.lang.ref.WeakReference<android.app.Activity> r4 = com.moat.analytics.mobile.iro.C11009a.f33631     // Catch:{ Exception -> 0x052b }
            java.lang.Object r4 = r4.get()     // Catch:{ Exception -> 0x052b }
            android.app.Activity r4 = (android.app.Activity) r4     // Catch:{ Exception -> 0x052b }
            if (r4 == 0) goto L_0x0067
            r10 = 96
            goto L_0x0069
        L_0x0067:
            r10 = 59
        L_0x0069:
            r11 = 59
            if (r10 == r11) goto L_0x0034
        L_0x006d:
            goto L_0x0082
        L_0x006e:
            java.lang.ref.WeakReference<android.app.Activity> r4 = com.moat.analytics.mobile.iro.C11009a.f33631     // Catch:{ Exception -> 0x052b }
            java.lang.Object r4 = r4.get()     // Catch:{ Exception -> 0x052b }
            android.app.Activity r4 = (android.app.Activity) r4     // Catch:{ Exception -> 0x052b }
            if (r4 == 0) goto L_0x007b
            r10 = 86
            goto L_0x007d
        L_0x007b:
            r10 = 91
        L_0x007d:
            r11 = 86
            if (r10 == r11) goto L_0x006d
            goto L_0x0034
        L_0x0082:
            android.util.DisplayMetrics r10 = new android.util.DisplayMetrics     // Catch:{ Exception -> 0x052b }
            r10.<init>()     // Catch:{ Exception -> 0x052b }
            android.view.WindowManager r4 = r4.getWindowManager()     // Catch:{ Exception -> 0x052b }
            android.view.Display r4 = r4.getDefaultDisplay()     // Catch:{ Exception -> 0x052b }
            r4.getRealMetrics(r10)     // Catch:{ Exception -> 0x052b }
            goto L_0x009f
        L_0x0093:
            android.content.Context r4 = r20.getContext()     // Catch:{ Exception -> 0x052b }
            android.content.res.Resources r4 = r4.getResources()     // Catch:{ Exception -> 0x052b }
            android.util.DisplayMetrics r10 = r4.getDisplayMetrics()     // Catch:{ Exception -> 0x052b }
        L_0x009f:
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x052b }
            r11 = 19
            if (r4 < r11) goto L_0x00a9
            r4 = 0
            goto L_0x00aa
        L_0x00a9:
            r4 = 1
        L_0x00aa:
            r11 = 26
            r12 = 66
            if (r4 == 0) goto L_0x00cc
            if (r0 == 0) goto L_0x00b5
            r4 = 25
            goto L_0x00b7
        L_0x00b5:
            r4 = 26
        L_0x00b7:
            if (r4 == r11) goto L_0x00ca
            android.os.IBinder r4 = r20.getWindowToken()     // Catch:{ Exception -> 0x052b }
            r13 = 38
            if (r4 == 0) goto L_0x00c4
            r4 = 66
            goto L_0x00c6
        L_0x00c4:
            r4 = 38
        L_0x00c6:
            if (r4 == r13) goto L_0x00ca
            r4 = 1
            goto L_0x00eb
        L_0x00ca:
            r4 = 0
            goto L_0x00eb
        L_0x00cc:
            r4 = 12
            if (r0 == 0) goto L_0x00d3
            r13 = 12
            goto L_0x00d5
        L_0x00d3:
            r13 = 43
        L_0x00d5:
            if (r13 == r4) goto L_0x00d8
        L_0x00d7:
            goto L_0x00e8
        L_0x00d8:
            boolean r4 = r20.isAttachedToWindow()     // Catch:{ Exception -> 0x052b }
            if (r4 == 0) goto L_0x00e1
            r4 = 33
            goto L_0x00e3
        L_0x00e1:
            r4 = 50
        L_0x00e3:
            r13 = 33
            if (r4 == r13) goto L_0x00ea
            goto L_0x00d7
        L_0x00e8:
            r4 = 0
            goto L_0x00eb
        L_0x00ea:
            r4 = 1
        L_0x00eb:
            if (r0 == 0) goto L_0x00f1
            r13 = 1
            goto L_0x00f2
        L_0x00f1:
            r13 = 0
        L_0x00f2:
            if (r13 == r7) goto L_0x00f5
        L_0x00f4:
            goto L_0x0101
        L_0x00f5:
            boolean r13 = r20.hasWindowFocus()     // Catch:{ Exception -> 0x052b }
            if (r13 == 0) goto L_0x00fd
            r13 = 1
            goto L_0x00fe
        L_0x00fd:
            r13 = 0
        L_0x00fe:
            if (r13 == r7) goto L_0x0103
            goto L_0x00f4
        L_0x0101:
            r13 = 0
            goto L_0x0104
        L_0x0103:
            r13 = 1
        L_0x0104:
            if (r0 == 0) goto L_0x010a
            r14 = 0
            goto L_0x010b
        L_0x010a:
            r14 = 1
        L_0x010b:
            if (r14 == 0) goto L_0x010e
        L_0x010d:
            goto L_0x0140
        L_0x010e:
            int r14 = f33820
            r11 = 69
            int r14 = r14 + r11
            int r15 = r14 % 128
            f33821 = r15
            int r14 = r14 % 2
            if (r14 != 0) goto L_0x011e
            r14 = 66
            goto L_0x0120
        L_0x011e:
            r14 = 46
        L_0x0120:
            if (r14 == r12) goto L_0x0130
            boolean r14 = r20.isShown()     // Catch:{ Exception -> 0x052b }
            if (r14 != 0) goto L_0x012b
            r14 = 69
            goto L_0x012d
        L_0x012b:
            r14 = 89
        L_0x012d:
            if (r14 == r11) goto L_0x010d
        L_0x012f:
            goto L_0x0142
        L_0x0130:
            boolean r11 = r20.isShown()     // Catch:{ Exception -> 0x052b }
            if (r11 != 0) goto L_0x0139
            r11 = 87
            goto L_0x013b
        L_0x0139:
            r11 = 52
        L_0x013b:
            r14 = 52
            if (r11 == r14) goto L_0x012f
            goto L_0x010d
        L_0x0140:
            r11 = 1
            goto L_0x0143
        L_0x0142:
            r11 = 0
        L_0x0143:
            if (r0 != 0) goto L_0x014a
            r14 = 48
            goto L_0x014c
        L_0x014a:
            r14 = 37
        L_0x014c:
            r15 = 37
            if (r14 == r15) goto L_0x015e
            int r14 = f33821
            int r14 = r14 + 67
            int r15 = r14 % 128
            f33820 = r15
            int r14 = r14 % 2
            if (r14 == 0) goto L_0x015c
        L_0x015c:
            r14 = 0
            goto L_0x0162
        L_0x015e:
            float r14 = m36413(r20)     // Catch:{ Exception -> 0x052b }
        L_0x0162:
            java.lang.String r15 = "dr"
            float r12 = r10.density     // Catch:{ Exception -> 0x052b }
            java.lang.Float r12 = java.lang.Float.valueOf(r12)     // Catch:{ Exception -> 0x052b }
            r2.put(r15, r12)     // Catch:{ Exception -> 0x052b }
            java.lang.String r12 = "dv"
            double r16 = com.moat.analytics.mobile.iro.C11044p.m36362()     // Catch:{ Exception -> 0x052b }
            java.lang.Double r15 = java.lang.Double.valueOf(r16)     // Catch:{ Exception -> 0x052b }
            r2.put(r12, r15)     // Catch:{ Exception -> 0x052b }
            java.lang.String r12 = "adKey"
            r15 = r19
            r2.put(r12, r15)     // Catch:{ Exception -> 0x052b }
            java.lang.String r12 = "isAttached"
            if (r4 == 0) goto L_0x0188
            r15 = 1
            goto L_0x0189
        L_0x0188:
            r15 = 0
        L_0x0189:
            if (r15 == r7) goto L_0x018d
            r9 = 0
            goto L_0x019a
        L_0x018d:
            int r15 = f33820
            int r15 = r15 + 77
            int r9 = r15 % 128
            f33821 = r9
            int r15 = r15 % 2
            if (r15 != 0) goto L_0x0199
        L_0x0199:
            r9 = 1
        L_0x019a:
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ Exception -> 0x052b }
            r2.put(r12, r9)     // Catch:{ Exception -> 0x052b }
            java.lang.String r9 = "inFocus"
            if (r13 == 0) goto L_0x01a7
            r12 = 1
            goto L_0x01a8
        L_0x01a7:
            r12 = 0
        L_0x01a8:
            if (r12 == r7) goto L_0x01ac
            r12 = 0
            goto L_0x01ad
        L_0x01ac:
            r12 = 1
        L_0x01ad:
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ Exception -> 0x052b }
            r2.put(r9, r12)     // Catch:{ Exception -> 0x052b }
            java.lang.String r9 = "isHidden"
            if (r11 == 0) goto L_0x01ba
            r12 = 1
            goto L_0x01bb
        L_0x01ba:
            r12 = 0
        L_0x01bb:
            if (r12 == r7) goto L_0x01bf
            r12 = 0
            goto L_0x01c0
        L_0x01bf:
            r12 = 1
        L_0x01c0:
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ Exception -> 0x052b }
            r2.put(r9, r12)     // Catch:{ Exception -> 0x052b }
            java.lang.String r9 = "opacity"
            java.lang.Float r12 = java.lang.Float.valueOf(r14)     // Catch:{ Exception -> 0x052b }
            r2.put(r9, r12)     // Catch:{ Exception -> 0x052b }
            int r9 = r10.widthPixels     // Catch:{ Exception -> 0x052b }
            int r12 = r10.heightPixels     // Catch:{ Exception -> 0x052b }
            android.graphics.Rect r14 = new android.graphics.Rect     // Catch:{ Exception -> 0x052b }
            r14.<init>(r5, r5, r9, r12)     // Catch:{ Exception -> 0x052b }
            if (r0 == 0) goto L_0x01e0
            r9 = 0
            goto L_0x01e1
        L_0x01e0:
            r9 = 1
        L_0x01e1:
            if (r9 == r7) goto L_0x01e8
            android.graphics.Rect r9 = m36419(r20)     // Catch:{ Exception -> 0x052b }
            goto L_0x01ed
        L_0x01e8:
            android.graphics.Rect r9 = new android.graphics.Rect     // Catch:{ Exception -> 0x052b }
            r9.<init>(r5, r5, r5, r5)     // Catch:{ Exception -> 0x052b }
        L_0x01ed:
            com.moat.analytics.mobile.iro.y$a r12 = new com.moat.analytics.mobile.iro.y$a     // Catch:{ Exception -> 0x052b }
            r12.<init>()     // Catch:{ Exception -> 0x052b }
            int r15 = r9.width()     // Catch:{ Exception -> 0x052b }
            int r17 = r9.height()     // Catch:{ Exception -> 0x052b }
            int r15 = r15 * r17
            if (r0 == 0) goto L_0x0207
            r17 = 34
            r5 = 34
            goto L_0x020b
        L_0x0207:
            r17 = 55
            r5 = 55
        L_0x020b:
            r6 = 55
            r8 = 0
            if (r5 == r6) goto L_0x031f
            int r5 = f33820
            int r5 = r5 + 45
            int r6 = r5 % 128
            f33821 = r6
            int r5 = r5 % 2
            if (r5 != 0) goto L_0x021e
            r5 = 1
            goto L_0x021f
        L_0x021e:
            r5 = 0
        L_0x021f:
            if (r5 == 0) goto L_0x022c
            if (r4 == 0) goto L_0x0225
            r4 = 0
            goto L_0x0226
        L_0x0225:
            r4 = 1
        L_0x0226:
            if (r4 == r7) goto L_0x0229
        L_0x0228:
            goto L_0x0238
        L_0x0229:
            r11 = r3
            goto L_0x0320
        L_0x022c:
            if (r4 == 0) goto L_0x0231
            r4 = 72
            goto L_0x0233
        L_0x0231:
            r4 = 90
        L_0x0233:
            r5 = 90
            if (r4 == r5) goto L_0x031f
            goto L_0x0228
        L_0x0238:
            if (r13 == 0) goto L_0x023c
            r4 = 0
            goto L_0x023d
        L_0x023c:
            r4 = 1
        L_0x023d:
            if (r4 == r7) goto L_0x031f
            if (r11 != 0) goto L_0x0244
            r4 = 18
            goto L_0x0246
        L_0x0244:
            r4 = 91
        L_0x0246:
            r5 = 91
            if (r4 == r5) goto L_0x031f
            int r4 = f33821
            r5 = 17
            int r4 = r4 + r5
            int r5 = r4 % 128
            f33820 = r5
            int r4 = r4 % 2
            if (r4 == 0) goto L_0x0257
        L_0x0257:
            if (r15 <= 0) goto L_0x025b
            r4 = 0
            goto L_0x025c
        L_0x025b:
            r4 = 1
        L_0x025c:
            if (r4 == r7) goto L_0x031f
            int r4 = f33821
            int r4 = r4 + 121
            int r5 = r4 % 128
            f33820 = r5
            int r4 = r4 % 2
            if (r4 == 0) goto L_0x026a
        L_0x026a:
            android.graphics.Rect r4 = new android.graphics.Rect     // Catch:{ Exception -> 0x052b }
            r5 = 0
            r4.<init>(r5, r5, r5, r5)     // Catch:{ Exception -> 0x052b }
            boolean r6 = r0.getGlobalVisibleRect(r4)     // Catch:{ Exception -> 0x052b }
            if (r6 == 0) goto L_0x0278
            r6 = 1
            goto L_0x0279
        L_0x0278:
            r6 = 0
        L_0x0279:
            if (r6 == r7) goto L_0x027c
            goto L_0x0229
        L_0x027c:
            int r6 = r4.width()     // Catch:{ Exception -> 0x052b }
            int r11 = r4.height()     // Catch:{ Exception -> 0x052b }
            int r6 = r6 * r11
            if (r6 >= r15) goto L_0x028c
            r11 = 0
            goto L_0x028d
        L_0x028c:
            r11 = 1
        L_0x028d:
            if (r11 == 0) goto L_0x0290
            goto L_0x02a3
        L_0x0290:
            int r11 = f33821
            int r11 = r11 + 39
            int r13 = r11 % 128
            f33820 = r13
            int r11 = r11 % 2
            if (r11 == 0) goto L_0x029c
        L_0x029c:
            java.lang.String r11 = "VisibilityInfo"
            java.lang.String r13 = "Ad is clipped"
            com.moat.analytics.mobile.iro.C11011b.m36235(r11, r8, r13)     // Catch:{ Exception -> 0x052b }
        L_0x02a3:
            java.util.HashSet r11 = new java.util.HashSet     // Catch:{ Exception -> 0x052b }
            r11.<init>()     // Catch:{ Exception -> 0x052b }
            android.view.View r13 = r20.getRootView()     // Catch:{ Exception -> 0x052b }
            boolean r13 = r13 instanceof android.view.ViewGroup     // Catch:{ Exception -> 0x052b }
            if (r13 == 0) goto L_0x02b3
            r13 = 41
            goto L_0x02b5
        L_0x02b3:
            r13 = 84
        L_0x02b5:
            r5 = 41
            if (r13 == r5) goto L_0x02bb
            goto L_0x0229
        L_0x02bb:
            int r5 = f33820
            int r5 = r5 + 49
            int r13 = r5 % 128
            f33821 = r13
            int r5 = r5 % 2
            if (r5 != 0) goto L_0x02c7
        L_0x02c7:
            r12.f33831 = r4     // Catch:{ Exception -> 0x052b }
            boolean r0 = m36418(r4, r0, (java.util.Set<android.graphics.Rect>) r11)     // Catch:{ Exception -> 0x052b }
            if (r0 == 0) goto L_0x02d2
            r5 = 89
            goto L_0x02d4
        L_0x02d2:
            r5 = 92
        L_0x02d4:
            r13 = 92
            if (r5 == r13) goto L_0x02dc
            r7 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r12.f33833 = r7     // Catch:{ Exception -> 0x052b }
        L_0x02dc:
            if (r0 != 0) goto L_0x02e1
            r0 = 21
            goto L_0x02e3
        L_0x02e1:
            r0 = 18
        L_0x02e3:
            r7 = 21
            if (r0 == r7) goto L_0x02e9
            goto L_0x0229
        L_0x02e9:
            int r0 = m36414(r4, r11)     // Catch:{ Exception -> 0x052b }
            if (r0 <= 0) goto L_0x02f2
            r4 = 93
            goto L_0x02f4
        L_0x02f2:
            r4 = 26
        L_0x02f4:
            r7 = 93
            if (r4 == r7) goto L_0x02fa
            r11 = r3
            goto L_0x0312
        L_0x02fa:
            int r4 = f33820
            int r4 = r4 + 87
            int r7 = r4 % 128
            f33821 = r7
            int r4 = r4 % 2
            if (r4 != 0) goto L_0x0306
        L_0x0306:
            double r7 = (double) r0
            r11 = r3
            double r3 = (double) r6
            java.lang.Double.isNaN(r7)
            java.lang.Double.isNaN(r3)
            double r7 = r7 / r3
            r12.f33833 = r7     // Catch:{ Exception -> 0x0529 }
        L_0x0312:
            int r6 = r6 - r0
            double r3 = (double) r6
            double r6 = (double) r15
            java.lang.Double.isNaN(r3)
            java.lang.Double.isNaN(r6)
            double r3 = r3 / r6
            r12.f33832 = r3     // Catch:{ Exception -> 0x0529 }
            goto L_0x0320
        L_0x031f:
            r11 = r3
        L_0x0320:
            org.json.JSONObject r0 = r1.f33828     // Catch:{ Exception -> 0x0529 }
            if (r0 == 0) goto L_0x0328
            r0 = 0
            goto L_0x0329
        L_0x0328:
            r0 = 1
        L_0x0329:
            if (r0 == 0) goto L_0x032c
        L_0x032b:
            goto L_0x0386
        L_0x032c:
            int r0 = f33820
            int r0 = r0 + 99
            int r3 = r0 % 128
            f33821 = r3
            int r0 = r0 % 2
            if (r0 != 0) goto L_0x033b
            r0 = 66
            goto L_0x033d
        L_0x033b:
            r0 = 16
        L_0x033d:
            r3 = 66
            if (r0 == r3) goto L_0x0351
            double r6 = r12.f33832     // Catch:{ Exception -> 0x0529 }
            com.moat.analytics.mobile.iro.y$a r0 = r1.f33825     // Catch:{ Exception -> 0x0529 }
            double r3 = r0.f33832     // Catch:{ Exception -> 0x0529 }
            int r0 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x034d
            r0 = 1
            goto L_0x034e
        L_0x034d:
            r0 = 0
        L_0x034e:
            if (r0 == 0) goto L_0x032b
        L_0x0350:
            goto L_0x0364
        L_0x0351:
            double r3 = r12.f33832     // Catch:{ Exception -> 0x0529 }
            com.moat.analytics.mobile.iro.y$a r0 = r1.f33825     // Catch:{ Exception -> 0x0529 }
            double r6 = r0.f33832     // Catch:{ Exception -> 0x0529 }
            int r0 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r0 != 0) goto L_0x035e
            r0 = 82
            goto L_0x035f
        L_0x035e:
            r0 = 3
        L_0x035f:
            r3 = 82
            if (r0 == r3) goto L_0x0350
            goto L_0x032b
        L_0x0364:
            android.graphics.Rect r0 = r12.f33831     // Catch:{ Exception -> 0x0529 }
            com.moat.analytics.mobile.iro.y$a r3 = r1.f33825     // Catch:{ Exception -> 0x0529 }
            android.graphics.Rect r3 = r3.f33831     // Catch:{ Exception -> 0x0529 }
            boolean r0 = r0.equals(r3)     // Catch:{ Exception -> 0x0529 }
            if (r0 == 0) goto L_0x0373
            r0 = 24
            goto L_0x0375
        L_0x0373:
            r0 = 42
        L_0x0375:
            r3 = 42
            if (r0 == r3) goto L_0x032b
            double r3 = r12.f33833     // Catch:{ Exception -> 0x0529 }
            com.moat.analytics.mobile.iro.y$a r0 = r1.f33825     // Catch:{ Exception -> 0x0529 }
            double r6 = r0.f33833     // Catch:{ Exception -> 0x0529 }
            int r0 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x0384
            goto L_0x0386
        L_0x0384:
            r7 = 0
            goto L_0x039c
        L_0x0386:
            r1.f33825 = r12     // Catch:{ Exception -> 0x0529 }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0529 }
            com.moat.analytics.mobile.iro.y$a r3 = r1.f33825     // Catch:{ Exception -> 0x0529 }
            android.graphics.Rect r3 = r3.f33831     // Catch:{ Exception -> 0x0529 }
            android.graphics.Rect r3 = m36415(r3, r10)     // Catch:{ Exception -> 0x0529 }
            java.util.HashMap r3 = m36420(r3)     // Catch:{ Exception -> 0x0529 }
            r0.<init>(r3)     // Catch:{ Exception -> 0x0529 }
            r1.f33828 = r0     // Catch:{ Exception -> 0x0529 }
            r7 = 1
        L_0x039c:
            java.lang.String r0 = "coveredPercent"
            double r3 = r12.f33833     // Catch:{ Exception -> 0x0529 }
            java.lang.Double r3 = java.lang.Double.valueOf(r3)     // Catch:{ Exception -> 0x0529 }
            r2.put(r0, r3)     // Catch:{ Exception -> 0x0529 }
            org.json.JSONObject r0 = r1.f33824     // Catch:{ Exception -> 0x0529 }
            if (r0 == 0) goto L_0x03ad
            r0 = 1
            goto L_0x03ae
        L_0x03ad:
            r0 = 0
        L_0x03ae:
            if (r0 == 0) goto L_0x03d5
            int r0 = f33820
            int r0 = r0 + 9
            int r3 = r0 % 128
            f33821 = r3
            int r0 = r0 % 2
            if (r0 != 0) goto L_0x03be
            r15 = 7
            goto L_0x03c0
        L_0x03be:
            r15 = 89
        L_0x03c0:
            r0 = 89
            if (r15 == r0) goto L_0x03cd
            android.graphics.Rect r0 = r1.f33829     // Catch:{ Exception -> 0x0529 }
            boolean r0 = r14.equals(r0)     // Catch:{ Exception -> 0x0529 }
            if (r0 != 0) goto L_0x03e7
            goto L_0x03d5
        L_0x03cd:
            android.graphics.Rect r0 = r1.f33829     // Catch:{ Exception -> 0x0529 }
            boolean r0 = r14.equals(r0)     // Catch:{ Exception -> 0x0529 }
            if (r0 != 0) goto L_0x03e7
        L_0x03d5:
            r1.f33829 = r14     // Catch:{ Exception -> 0x0529 }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0529 }
            android.graphics.Rect r3 = m36415(r14, r10)     // Catch:{ Exception -> 0x0529 }
            java.util.HashMap r3 = m36420(r3)     // Catch:{ Exception -> 0x0529 }
            r0.<init>(r3)     // Catch:{ Exception -> 0x0529 }
            r1.f33824 = r0     // Catch:{ Exception -> 0x0529 }
            r7 = 1
        L_0x03e7:
            org.json.JSONObject r0 = r1.f33830     // Catch:{ Exception -> 0x0529 }
            if (r0 == 0) goto L_0x03ed
            r0 = 0
            goto L_0x03ee
        L_0x03ed:
            r0 = 1
        L_0x03ee:
            if (r0 == 0) goto L_0x03f1
            goto L_0x03f9
        L_0x03f1:
            android.graphics.Rect r0 = r1.f33826     // Catch:{ Exception -> 0x0529 }
            boolean r0 = r9.equals(r0)     // Catch:{ Exception -> 0x0529 }
            if (r0 != 0) goto L_0x040b
        L_0x03f9:
            r1.f33826 = r9     // Catch:{ Exception -> 0x0529 }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0529 }
            android.graphics.Rect r3 = m36415(r9, r10)     // Catch:{ Exception -> 0x0529 }
            java.util.HashMap r3 = m36420(r3)     // Catch:{ Exception -> 0x0529 }
            r0.<init>(r3)     // Catch:{ Exception -> 0x0529 }
            r1.f33830 = r0     // Catch:{ Exception -> 0x0529 }
            r7 = 1
        L_0x040b:
            java.util.Map<java.lang.String, java.lang.Object> r0 = r1.f33823     // Catch:{ Exception -> 0x0529 }
            if (r0 == 0) goto L_0x0411
            r0 = 0
            goto L_0x0412
        L_0x0411:
            r0 = 1
        L_0x0412:
            if (r0 == 0) goto L_0x0415
        L_0x0414:
            goto L_0x0439
        L_0x0415:
            int r0 = f33821
            int r0 = r0 + 99
            int r3 = r0 % 128
            f33820 = r3
            int r0 = r0 % 2
            if (r0 == 0) goto L_0x042a
            java.util.Map<java.lang.String, java.lang.Object> r0 = r1.f33823     // Catch:{ Exception -> 0x0529 }
            boolean r0 = r2.equals(r0)     // Catch:{ Exception -> 0x0529 }
            if (r0 != 0) goto L_0x043c
            goto L_0x0439
        L_0x042a:
            java.util.Map<java.lang.String, java.lang.Object> r0 = r1.f33823     // Catch:{ Exception -> 0x0529 }
            boolean r0 = r2.equals(r0)     // Catch:{ Exception -> 0x0529 }
            if (r0 != 0) goto L_0x0434
            r0 = 1
            goto L_0x0435
        L_0x0434:
            r0 = 0
        L_0x0435:
            r3 = 1
            if (r0 == r3) goto L_0x0414
            goto L_0x043c
        L_0x0439:
            r1.f33823 = r2     // Catch:{ Exception -> 0x0529 }
            r7 = 1
        L_0x043c:
            com.moat.analytics.mobile.iro.k r0 = com.moat.analytics.mobile.iro.C11032k.m36332()     // Catch:{ Exception -> 0x0529 }
            android.location.Location r0 = r0.mo36116()     // Catch:{ Exception -> 0x0529 }
            android.location.Location r2 = r1.f33822     // Catch:{ Exception -> 0x0529 }
            boolean r2 = com.moat.analytics.mobile.iro.C11032k.m36333(r0, r2)     // Catch:{ Exception -> 0x0529 }
            if (r2 != 0) goto L_0x044e
            r2 = 1
            goto L_0x044f
        L_0x044e:
            r2 = 0
        L_0x044f:
            if (r2 == 0) goto L_0x0461
            int r2 = f33821
            int r2 = r2 + 103
            int r3 = r2 % 128
            f33820 = r3
            int r2 = r2 % 2
            if (r2 == 0) goto L_0x045d
        L_0x045d:
            r1.f33822 = r0     // Catch:{ Exception -> 0x0529 }
            r7 = 1
        L_0x0461:
            if (r7 == 0) goto L_0x0465
            r2 = 0
            goto L_0x0466
        L_0x0465:
            r2 = 1
        L_0x0466:
            if (r2 == 0) goto L_0x046a
            goto L_0x0017
        L_0x046a:
            int r2 = f33820
            int r2 = r2 + 57
            int r3 = r2 % 128
            f33821 = r3
            int r2 = r2 % 2
            if (r2 != 0) goto L_0x0476
        L_0x0476:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x0529 }
            java.util.Map<java.lang.String, java.lang.Object> r3 = r1.f33823     // Catch:{ Exception -> 0x0529 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0529 }
            java.lang.String r3 = "screen"
            org.json.JSONObject r4 = r1.f33824     // Catch:{ Exception -> 0x0529 }
            r2.accumulate(r3, r4)     // Catch:{ Exception -> 0x0529 }
            java.lang.String r3 = "view"
            org.json.JSONObject r4 = r1.f33830     // Catch:{ Exception -> 0x0529 }
            r2.accumulate(r3, r4)     // Catch:{ Exception -> 0x0529 }
            java.lang.String r3 = "visible"
            org.json.JSONObject r4 = r1.f33828     // Catch:{ Exception -> 0x0529 }
            r2.accumulate(r3, r4)     // Catch:{ Exception -> 0x0529 }
            java.lang.String r3 = "maybe"
            org.json.JSONObject r4 = r1.f33828     // Catch:{ Exception -> 0x0529 }
            r2.accumulate(r3, r4)     // Catch:{ Exception -> 0x0529 }
            java.lang.String r3 = "visiblePercent"
            com.moat.analytics.mobile.iro.y$a r4 = r1.f33825     // Catch:{ Exception -> 0x0529 }
            double r6 = r4.f33832     // Catch:{ Exception -> 0x0529 }
            java.lang.Double r4 = java.lang.Double.valueOf(r6)     // Catch:{ Exception -> 0x0529 }
            r2.accumulate(r3, r4)     // Catch:{ Exception -> 0x0529 }
            if (r0 == 0) goto L_0x04aa
            r3 = 1
            goto L_0x04ab
        L_0x04aa:
            r3 = 0
        L_0x04ab:
            r4 = 1
            if (r3 == r4) goto L_0x04b0
            goto L_0x0522
        L_0x04b0:
            java.lang.String r3 = "location"
            if (r0 != 0) goto L_0x04b8
            r12 = 66
            goto L_0x04ba
        L_0x04b8:
            r12 = 88
        L_0x04ba:
            r4 = 88
            if (r12 == r4) goto L_0x04cc
            int r0 = f33821
            int r0 = r0 + 95
            int r4 = r0 % 128
            f33820 = r4
            int r0 = r0 % 2
            if (r0 == 0) goto L_0x04ca
        L_0x04ca:
            r8 = 0
            goto L_0x0506
        L_0x04cc:
            java.util.HashMap r8 = new java.util.HashMap     // Catch:{ Exception -> 0x0529 }
            r8.<init>()     // Catch:{ Exception -> 0x0529 }
            java.lang.String r4 = "latitude"
            double r6 = r0.getLatitude()     // Catch:{ Exception -> 0x0529 }
            java.lang.String r6 = java.lang.Double.toString(r6)     // Catch:{ Exception -> 0x0529 }
            r8.put(r4, r6)     // Catch:{ Exception -> 0x0529 }
            java.lang.String r4 = "longitude"
            double r6 = r0.getLongitude()     // Catch:{ Exception -> 0x0529 }
            java.lang.String r6 = java.lang.Double.toString(r6)     // Catch:{ Exception -> 0x0529 }
            r8.put(r4, r6)     // Catch:{ Exception -> 0x0529 }
            java.lang.String r4 = "timestamp"
            long r6 = r0.getTime()     // Catch:{ Exception -> 0x0529 }
            java.lang.String r6 = java.lang.Long.toString(r6)     // Catch:{ Exception -> 0x0529 }
            r8.put(r4, r6)     // Catch:{ Exception -> 0x0529 }
            java.lang.String r4 = "horizontalAccuracy"
            float r0 = r0.getAccuracy()     // Catch:{ Exception -> 0x0529 }
            java.lang.String r0 = java.lang.Float.toString(r0)     // Catch:{ Exception -> 0x0529 }
            r8.put(r4, r0)     // Catch:{ Exception -> 0x0529 }
        L_0x0506:
            if (r8 != 0) goto L_0x050b
            r0 = 0
            goto L_0x050c
        L_0x050b:
            r0 = 1
        L_0x050c:
            r4 = 1
            if (r0 == r4) goto L_0x051a
            int r0 = f33820
            int r0 = r0 + r4
            int r4 = r0 % 128
            f33821 = r4
            int r0 = r0 % 2
            r0 = 0
            goto L_0x051f
        L_0x051a:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0529 }
            r0.<init>(r8)     // Catch:{ Exception -> 0x0529 }
        L_0x051f:
            r2.accumulate(r3, r0)     // Catch:{ Exception -> 0x0529 }
        L_0x0522:
            java.lang.String r3 = r2.toString()     // Catch:{ Exception -> 0x0529 }
            r1.f33827 = r3     // Catch:{ Exception -> 0x052b }
        L_0x0528:
            return
        L_0x0529:
            r0 = move-exception
            goto L_0x052d
        L_0x052b:
            r0 = move-exception
            r11 = r3
        L_0x052d:
            com.moat.analytics.mobile.iro.C11043o.m36351(r0)
            r1.f33827 = r11
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moat.analytics.mobile.iro.C11067y.mo36132(java.lang.String, android.view.View):void");
    }

    /* renamed from: ˊ */
    private static float m36413(View view) {
        char c;
        char c2;
        char c3;
        char c4;
        float alpha = view.getAlpha();
        while (true) {
            if (view != null) {
                c = 'S';
            } else {
                c = 'c';
            }
            if (c != 'S') {
                break;
            }
            if (view.getParent() != null) {
                c2 = 13;
            } else {
                c2 = 18;
            }
            if (c2 != 18) {
                if (((double) alpha) != 0.0d) {
                    c3 = 'D';
                } else {
                    c3 = 5;
                }
                if (c3 == 5) {
                    break;
                }
                int i = f33820 + Opcodes.LSHL;
                f33821 = i % 128;
                if (i % 2 == 0) {
                }
                if (view.getParent() instanceof View) {
                    c4 = 'H';
                } else {
                    c4 = 1;
                }
                if (c4 != 'H') {
                    break;
                }
                int i2 = f33820 + 117;
                f33821 = i2 % 128;
                if (i2 % 2 == 0) {
                }
                alpha *= ((View) view.getParent()).getAlpha();
                view = (View) view.getParent();
            } else {
                break;
            }
        }
        return alpha;
    }

    /* renamed from: ˏ */
    static Rect m36416(View view) {
        return (view != null ? 10 : 'Z') != 'Z' ? m36419(view) : new Rect(0, 0, 0, 0);
    }

    /* renamed from: ˏ */
    private static void m36417(ArrayDeque<C11070b> arrayDeque, C11070b bVar, boolean z) {
        if ((bVar.f33834 instanceof ViewGroup ? '?' : '/') != '/') {
            int i = f33821 + 107;
            f33820 = i % 128;
            if (i % 2 != 0) {
            }
            if (!(bVar.f33834 instanceof ListView)) {
                ViewGroup viewGroup = (ViewGroup) bVar.f33834;
                for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                    arrayDeque.add(new C11070b(viewGroup.getChildAt(childCount), bVar.f33836 + 1, z));
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:136:0x01ad, code lost:
        if (r3 != false) goto L_0x01af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x01c3, code lost:
        if (r3 != '>') goto L_0x01af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x01c8, code lost:
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x020a, code lost:
        if (r3 != 29) goto L_0x020c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:0x02a7, code lost:
        if (r3 != 'I') goto L_0x02a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x00de, code lost:
        if (r5 != false) goto L_0x00e0;
     */
    /* renamed from: ˏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m36418(android.graphics.Rect r19, android.view.View r20, java.util.Set<android.graphics.Rect> r21) {
        /*
            r0 = r19
            r1 = r20
            java.lang.String r2 = "VisibilityInfo"
            r3 = 0
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ Exception -> 0x039b }
            r4.<init>()     // Catch:{ Exception -> 0x039b }
            r5 = r1
            r6 = 0
        L_0x0011:
            android.view.ViewParent r7 = r5.getParent()     // Catch:{ Exception -> 0x039b }
            r8 = 58
            if (r7 != 0) goto L_0x001c
            r7 = 58
            goto L_0x001e
        L_0x001c:
            r7 = 30
        L_0x001e:
            r9 = 50
            r10 = 13
            r12 = 9
            r13 = 37
            r14 = 1
            if (r7 == r8) goto L_0x002a
        L_0x0029:
            goto L_0x0053
        L_0x002a:
            int r7 = f33821
            int r7 = r7 + r12
            int r8 = r7 % 128
            f33820 = r8
            int r7 = r7 % 2
            if (r7 == 0) goto L_0x0037
            r7 = 0
            goto L_0x0038
        L_0x0037:
            r7 = 1
        L_0x0038:
            if (r7 == r14) goto L_0x0047
            android.view.View r7 = r20.getRootView()     // Catch:{ Exception -> 0x039b }
            if (r5 != r7) goto L_0x0042
            r7 = 1
            goto L_0x0043
        L_0x0042:
            r7 = 0
        L_0x0043:
            if (r7 == r14) goto L_0x0029
        L_0x0045:
            goto L_0x00a8
        L_0x0047:
            android.view.View r7 = r20.getRootView()     // Catch:{ Exception -> 0x039b }
            if (r5 != r7) goto L_0x004f
            r7 = 1
            goto L_0x0050
        L_0x004f:
            r7 = 0
        L_0x0050:
            if (r7 == r14) goto L_0x0029
            goto L_0x0045
        L_0x0053:
            int r6 = r6 + r14
            r7 = 93
            if (r6 <= r9) goto L_0x005b
            r8 = 97
            goto L_0x005d
        L_0x005b:
            r8 = 93
        L_0x005d:
            if (r8 == r7) goto L_0x0078
            int r4 = f33821
            int r4 = r4 + 115
            int r5 = r4 % 128
            f33820 = r5
            int r4 = r4 % 2
            if (r4 == 0) goto L_0x006e
            r4 = 20
            goto L_0x0070
        L_0x006e:
            r4 = 37
        L_0x0070:
            r5 = 20
            if (r4 == r5) goto L_0x0076
            r4 = 0
            goto L_0x00a9
        L_0x0076:
            r4 = 0
            goto L_0x00a9
        L_0x0078:
            r4.add(r3, r5)     // Catch:{ Exception -> 0x039b }
            android.view.ViewParent r7 = r5.getParent()     // Catch:{ Exception -> 0x039b }
            boolean r7 = r7 instanceof android.view.View     // Catch:{ Exception -> 0x039b }
            if (r7 == 0) goto L_0x0086
            r7 = 39
            goto L_0x0088
        L_0x0086:
            r7 = 13
        L_0x0088:
            if (r7 == r10) goto L_0x0045
            int r7 = f33821
            int r7 = r7 + 67
            int r8 = r7 % 128
            f33820 = r8
            int r7 = r7 % 2
            if (r7 == 0) goto L_0x0098
            r14 = 0
            goto L_0x0099
        L_0x0098:
        L_0x0099:
            if (r14 == 0) goto L_0x00a3
            android.view.ViewParent r5 = r5.getParent()     // Catch:{ Exception -> 0x039b }
        L_0x009f:
            android.view.View r5 = (android.view.View) r5     // Catch:{ Exception -> 0x039b }
            goto L_0x0011
        L_0x00a3:
            android.view.ViewParent r5 = r5.getParent()     // Catch:{ Exception -> 0x039b }
            goto L_0x009f
        L_0x00a8:
        L_0x00a9:
            if (r4 == 0) goto L_0x00af
            r5 = 9
            goto L_0x00b1
        L_0x00af:
            r5 = 77
        L_0x00b1:
            r6 = 77
            if (r5 == r6) goto L_0x0399
            int r5 = f33820
            int r5 = r5 + 81
            int r6 = r5 % 128
            f33821 = r6
            int r5 = r5 % 2
            if (r5 != 0) goto L_0x00c4
            r5 = 94
            goto L_0x00c6
        L_0x00c4:
            r5 = 37
        L_0x00c6:
            if (r5 == r13) goto L_0x00d5
            boolean r5 = r4.isEmpty()     // Catch:{ Exception -> 0x039b }
            if (r5 == 0) goto L_0x00d0
            r5 = 1
            goto L_0x00d1
        L_0x00d0:
            r5 = 0
        L_0x00d1:
            if (r5 == 0) goto L_0x00e0
            goto L_0x0399
        L_0x00d5:
            boolean r5 = r4.isEmpty()     // Catch:{ Exception -> 0x039b }
            if (r5 == 0) goto L_0x00dd
            r5 = 0
            goto L_0x00de
        L_0x00dd:
            r5 = 1
        L_0x00de:
            if (r5 == 0) goto L_0x0399
        L_0x00e0:
            android.view.View r5 = r20.getRootView()     // Catch:{ Exception -> 0x039b }
            java.util.ArrayDeque r6 = new java.util.ArrayDeque     // Catch:{ Exception -> 0x039b }
            r6.<init>()     // Catch:{ Exception -> 0x039b }
            com.moat.analytics.mobile.iro.y$b r7 = new com.moat.analytics.mobile.iro.y$b     // Catch:{ Exception -> 0x039b }
            r7.<init>(r5, r3, r14)     // Catch:{ Exception -> 0x039b }
            r6.add(r7)     // Catch:{ Exception -> 0x039b }
            java.lang.String r5 = "starting covering rect search"
            com.moat.analytics.mobile.iro.C11011b.m36235(r2, r1, r5)     // Catch:{ Exception -> 0x039b }
            r5 = 0
            r7 = 0
        L_0x00f8:
            boolean r8 = r6.isEmpty()     // Catch:{ Exception -> 0x039b }
            if (r8 != 0) goto L_0x0101
            r8 = 40
            goto L_0x0103
        L_0x0101:
            r8 = 53
        L_0x0103:
            r9 = 53
            if (r8 == r9) goto L_0x039f
            int r8 = f33821
            int r8 = r8 + 25
            int r9 = r8 % 128
            f33820 = r9
            int r8 = r8 % 2
            if (r8 == 0) goto L_0x0113
        L_0x0113:
            r8 = 250(0xfa, float:3.5E-43)
            if (r5 >= r8) goto L_0x011a
            r9 = 22
            goto L_0x011c
        L_0x011a:
            r9 = 50
        L_0x011c:
            r8 = 22
            if (r9 == r8) goto L_0x0122
            goto L_0x039f
        L_0x0122:
            int r5 = r5 + 1
            java.lang.Object r8 = r6.pollLast()     // Catch:{ Exception -> 0x039b }
            com.moat.analytics.mobile.iro.y$b r8 = (com.moat.analytics.mobile.iro.C11067y.C11070b) r8     // Catch:{ Exception -> 0x039b }
            android.view.View r9 = r8.f33834     // Catch:{ Exception -> 0x039b }
            boolean r9 = r9.equals(r1)     // Catch:{ Exception -> 0x039b }
            if (r9 == 0) goto L_0x0135
            r9 = 64
            goto L_0x0137
        L_0x0135:
            r9 = 65
        L_0x0137:
            r11 = 64
            if (r9 == r11) goto L_0x037a
            boolean r9 = r8.f33835     // Catch:{ Exception -> 0x039b }
            if (r9 == 0) goto L_0x0141
            r9 = 0
            goto L_0x0142
        L_0x0141:
            r9 = 1
        L_0x0142:
            if (r9 == 0) goto L_0x0147
            r15 = r4
            goto L_0x026e
        L_0x0147:
            int r9 = r4.size()     // Catch:{ Exception -> 0x039b }
            int r11 = r8.f33836     // Catch:{ Exception -> 0x039b }
            if (r9 <= r11) goto L_0x0152
            r9 = 1
            goto L_0x0153
        L_0x0152:
            r9 = 0
        L_0x0153:
            if (r9 == 0) goto L_0x015f
            int r9 = r8.f33836     // Catch:{ Exception -> 0x039b }
            java.lang.Object r9 = r4.get(r9)     // Catch:{ Exception -> 0x039b }
            r11 = r9
            android.view.View r11 = (android.view.View) r11     // Catch:{ Exception -> 0x039b }
            goto L_0x0160
        L_0x015f:
            r11 = 0
        L_0x0160:
            android.view.View r9 = r8.f33834     // Catch:{ Exception -> 0x039b }
            if (r9 != r11) goto L_0x0167
            r9 = 0
            goto L_0x0168
        L_0x0167:
            r9 = 1
        L_0x0168:
            if (r9 == r14) goto L_0x0172
            m36417(r6, r8, r14)     // Catch:{ Exception -> 0x039b }
            r15 = r4
            r4 = r21
            goto L_0x0372
        L_0x0172:
            android.view.View r9 = r8.f33834     // Catch:{ Exception -> 0x039b }
            boolean r16 = r9.isShown()     // Catch:{ Exception -> 0x039b }
            if (r16 == 0) goto L_0x017f
            r16 = 16
            r13 = 16
            goto L_0x0183
        L_0x017f:
            r16 = 47
            r13 = 47
        L_0x0183:
            r15 = 16
            if (r13 == r15) goto L_0x0189
            r15 = r4
            goto L_0x01c6
        L_0x0189:
            int r13 = f33821
            int r13 = r13 + 121
            int r15 = r13 % 128
            f33820 = r15
            int r13 = r13 % 2
            if (r13 == 0) goto L_0x0198
            r13 = 18
            goto L_0x019a
        L_0x0198:
            r13 = 34
        L_0x019a:
            r15 = 34
            if (r13 == r15) goto L_0x01b0
            float r9 = r9.getAlpha()     // Catch:{ Exception -> 0x039b }
            r15 = r4
            double r3 = (double) r9     // Catch:{ Exception -> 0x039b }
            r17 = 0
            int r9 = (r3 > r17 ? 1 : (r3 == r17 ? 0 : -1))
            if (r9 <= 0) goto L_0x01ac
            r3 = 0
            goto L_0x01ad
        L_0x01ac:
            r3 = 1
        L_0x01ad:
            if (r3 == 0) goto L_0x01c8
        L_0x01af:
            goto L_0x01c6
        L_0x01b0:
            r15 = r4
            float r3 = r9.getAlpha()     // Catch:{ Exception -> 0x039b }
            double r3 = (double) r3
            r17 = 0
            int r9 = (r3 > r17 ? 1 : (r3 == r17 ? 0 : -1))
            if (r9 <= 0) goto L_0x01bf
            r3 = 62
            goto L_0x01c1
        L_0x01bf:
            r3 = 68
        L_0x01c1:
            r4 = 62
            if (r3 == r4) goto L_0x01c8
            goto L_0x01af
        L_0x01c6:
            r3 = 0
            goto L_0x01c9
        L_0x01c8:
            r3 = 1
        L_0x01c9:
            if (r3 == 0) goto L_0x01ce
            r3 = 84
            goto L_0x01d0
        L_0x01ce:
            r3 = 36
        L_0x01d0:
            r4 = 84
            if (r3 == r4) goto L_0x01d6
            goto L_0x02aa
        L_0x01d6:
            int r3 = f33821
            int r3 = r3 + 43
            int r4 = r3 % 128
            f33820 = r4
            int r3 = r3 % 2
            if (r3 == 0) goto L_0x01e2
        L_0x01e2:
            if (r7 == 0) goto L_0x01e7
            r3 = 82
            goto L_0x01e9
        L_0x01e7:
            r3 = 23
        L_0x01e9:
            r4 = 23
            r9 = 21
            if (r3 == r4) goto L_0x0229
            int r3 = f33821
            int r3 = r3 + r12
            int r4 = r3 % 128
            f33820 = r4
            int r3 = r3 % 2
            if (r3 == 0) goto L_0x01fc
            r3 = 0
            goto L_0x01fd
        L_0x01fc:
            r3 = 1
        L_0x01fd:
            if (r3 == 0) goto L_0x020d
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x039b }
            if (r3 < r9) goto L_0x0206
            r3 = 73
            goto L_0x0208
        L_0x0206:
            r3 = 29
        L_0x0208:
            r4 = 29
            if (r3 == r4) goto L_0x026e
        L_0x020c:
            goto L_0x0217
        L_0x020d:
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x039b }
            if (r3 < r9) goto L_0x0213
            r3 = 1
            goto L_0x0214
        L_0x0213:
            r3 = 0
        L_0x0214:
            if (r3 == 0) goto L_0x026e
            goto L_0x020c
        L_0x0217:
            android.view.View r3 = r8.f33834     // Catch:{ Exception -> 0x039b }
            float r3 = r3.getElevation()     // Catch:{ Exception -> 0x039b }
            float r4 = r11.getElevation()     // Catch:{ Exception -> 0x039b }
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 >= 0) goto L_0x026e
            r4 = r21
            goto L_0x0372
        L_0x0229:
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x039b }
            if (r3 < r9) goto L_0x022f
            r3 = 0
            goto L_0x0230
        L_0x022f:
            r3 = 1
        L_0x0230:
            if (r3 == r14) goto L_0x036f
            int r3 = f33820
            int r3 = r3 + r10
            int r4 = r3 % 128
            f33821 = r4
            int r3 = r3 % 2
            if (r3 != 0) goto L_0x0240
            r3 = 26
            goto L_0x0242
        L_0x0240:
            r3 = 92
        L_0x0242:
            r4 = 92
            if (r3 == r4) goto L_0x025a
            android.view.View r3 = r8.f33834     // Catch:{ Exception -> 0x039b }
            float r3 = r3.getElevation()     // Catch:{ Exception -> 0x039b }
            float r4 = r11.getElevation()     // Catch:{ Exception -> 0x039b }
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 <= 0) goto L_0x0256
            r3 = 1
            goto L_0x0257
        L_0x0256:
            r3 = 0
        L_0x0257:
            if (r3 == 0) goto L_0x02aa
            goto L_0x026e
        L_0x025a:
            android.view.View r3 = r8.f33834     // Catch:{ Exception -> 0x039b }
            float r3 = r3.getElevation()     // Catch:{ Exception -> 0x039b }
            float r4 = r11.getElevation()     // Catch:{ Exception -> 0x039b }
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 <= 0) goto L_0x026a
            r3 = 0
            goto L_0x026b
        L_0x026a:
            r3 = 1
        L_0x026b:
            if (r3 == 0) goto L_0x026e
            goto L_0x02aa
        L_0x026e:
            r3 = 0
            m36417(r6, r8, r3)     // Catch:{ Exception -> 0x039b }
            java.lang.Class<android.view.ViewGroup> r3 = android.view.ViewGroup.class
            android.view.View r4 = r8.f33834     // Catch:{ Exception -> 0x039b }
            java.lang.Class r4 = r4.getClass()     // Catch:{ Exception -> 0x039b }
            java.lang.Class r4 = r4.getSuperclass()     // Catch:{ Exception -> 0x039b }
            boolean r3 = r3.equals(r4)     // Catch:{ Exception -> 0x039b }
            if (r3 == 0) goto L_0x0286
            r3 = 1
            goto L_0x0287
        L_0x0286:
            r3 = 0
        L_0x0287:
            if (r3 == 0) goto L_0x030a
            int r3 = f33820
            int r3 = r3 + 17
            int r4 = r3 % 128
            f33821 = r4
            int r3 = r3 % 2
            if (r3 != 0) goto L_0x0297
            r3 = 1
            goto L_0x0298
        L_0x0297:
            r3 = 0
        L_0x0298:
            if (r3 == 0) goto L_0x02ae
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x039b }
            r4 = 19
            if (r3 < r4) goto L_0x02a3
            r3 = 42
            goto L_0x02a5
        L_0x02a3:
            r3 = 73
        L_0x02a5:
            r4 = 73
            if (r3 == r4) goto L_0x02aa
        L_0x02a9:
            goto L_0x02ba
        L_0x02aa:
            r4 = r21
            goto L_0x0372
        L_0x02ae:
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x039b }
            r4 = 19
            if (r3 < r4) goto L_0x02b6
            r3 = 0
            goto L_0x02b7
        L_0x02b6:
            r3 = 1
        L_0x02b7:
            if (r3 == r14) goto L_0x0307
            goto L_0x02a9
        L_0x02ba:
            android.view.View r3 = r8.f33834     // Catch:{ Exception -> 0x039b }
            android.graphics.drawable.Drawable r3 = r3.getBackground()     // Catch:{ Exception -> 0x039b }
            if (r3 == 0) goto L_0x02c4
            r3 = 1
            goto L_0x02c5
        L_0x02c4:
            r3 = 0
        L_0x02c5:
            if (r3 == 0) goto L_0x0307
            int r3 = f33821
            int r3 = r3 + 71
            int r4 = r3 % 128
            f33820 = r4
            int r3 = r3 % 2
            if (r3 == 0) goto L_0x02d6
            r3 = 11
            goto L_0x02d8
        L_0x02d6:
            r3 = 37
        L_0x02d8:
            r4 = 11
            if (r3 == r4) goto L_0x02f1
            android.view.View r3 = r8.f33834     // Catch:{ Exception -> 0x039b }
            android.graphics.drawable.Drawable r3 = r3.getBackground()     // Catch:{ Exception -> 0x039b }
            int r3 = r3.getAlpha()     // Catch:{ Exception -> 0x039b }
            if (r3 == 0) goto L_0x02ea
            r3 = 1
            goto L_0x02eb
        L_0x02ea:
            r3 = 0
        L_0x02eb:
            if (r3 == r14) goto L_0x02ee
            goto L_0x02aa
        L_0x02ee:
            r4 = 37
            goto L_0x030c
        L_0x02f1:
            android.view.View r3 = r8.f33834     // Catch:{ Exception -> 0x039b }
            android.graphics.drawable.Drawable r3 = r3.getBackground()     // Catch:{ Exception -> 0x039b }
            int r3 = r3.getAlpha()     // Catch:{ Exception -> 0x039b }
            if (r3 == 0) goto L_0x0300
            r3 = 37
            goto L_0x0302
        L_0x0300:
            r3 = 89
        L_0x0302:
            r4 = 37
            if (r3 == r4) goto L_0x030c
            goto L_0x02aa
        L_0x0307:
            r4 = 37
            goto L_0x02aa
        L_0x030a:
            r4 = 37
        L_0x030c:
            android.view.View r3 = r8.f33834     // Catch:{ Exception -> 0x039b }
            android.graphics.Rect r3 = m36419(r3)     // Catch:{ Exception -> 0x039b }
            boolean r9 = r3.setIntersect(r0, r3)     // Catch:{ Exception -> 0x039b }
            if (r9 == 0) goto L_0x036c
            android.view.View r9 = r8.f33834     // Catch:{ Exception -> 0x039b }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x039b }
            java.lang.String r4 = "Covered by "
            r11.<init>(r4)     // Catch:{ Exception -> 0x039b }
            android.view.View r4 = r8.f33834     // Catch:{ Exception -> 0x039b }
            java.lang.Class r4 = r4.getClass()     // Catch:{ Exception -> 0x039b }
            java.lang.String r4 = r4.getSimpleName()     // Catch:{ Exception -> 0x039b }
            r11.append(r4)     // Catch:{ Exception -> 0x039b }
            java.lang.String r4 = "-"
            r11.append(r4)     // Catch:{ Exception -> 0x039b }
            java.lang.String r4 = r3.toString()     // Catch:{ Exception -> 0x039b }
            r11.append(r4)     // Catch:{ Exception -> 0x039b }
            java.lang.String r4 = r11.toString()     // Catch:{ Exception -> 0x039b }
            com.moat.analytics.mobile.iro.C11011b.m36235(r2, r9, r4)     // Catch:{ Exception -> 0x039b }
            r4 = r21
            r4.add(r3)     // Catch:{ Exception -> 0x039b }
            boolean r3 = r3.contains(r0)     // Catch:{ Exception -> 0x039b }
            if (r3 == 0) goto L_0x034f
            r3 = 40
            goto L_0x0351
        L_0x034f:
            r3 = 68
        L_0x0351:
            r8 = 40
            if (r3 == r8) goto L_0x0356
            goto L_0x036e
        L_0x0356:
            int r0 = f33821
            int r0 = r0 + 85
            int r1 = r0 % 128
            f33820 = r1
            int r0 = r0 % 2
            if (r0 == 0) goto L_0x0365
            r0 = 36
            goto L_0x0367
        L_0x0365:
            r0 = 69
        L_0x0367:
            r1 = 69
            if (r0 == r1) goto L_0x036b
        L_0x036b:
            return r14
        L_0x036c:
            r4 = r21
        L_0x036e:
            goto L_0x0372
        L_0x036f:
            r4 = r21
            goto L_0x036e
        L_0x0372:
            r4 = r15
            r3 = 0
            r9 = 50
            r13 = 37
            goto L_0x00f8
        L_0x037a:
            r15 = r4
            r4 = r21
            int r3 = f33821
            r7 = 73
            int r3 = r3 + r7
            int r7 = r3 % 128
            f33820 = r7
            int r3 = r3 % 2
            if (r3 == 0) goto L_0x038a
        L_0x038a:
            java.lang.String r3 = "found target"
            com.moat.analytics.mobile.iro.C11011b.m36235(r2, r0, r3)     // Catch:{ Exception -> 0x039b }
            r4 = r15
            r3 = 0
            r7 = 1
            r9 = 50
            r13 = 37
            goto L_0x00f8
        L_0x0399:
            r1 = 0
            return r1
        L_0x039b:
            r0 = move-exception
            com.moat.analytics.mobile.iro.C11043o.m36351(r0)
        L_0x039f:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moat.analytics.mobile.iro.C11067y.m36418(android.graphics.Rect, android.view.View, java.util.HashSet):boolean");
    }

    /* renamed from: ˊ */
    private static int m36414(Rect rect, Set<Rect> set) {
        boolean z;
        boolean z2;
        char c;
        char c2;
        boolean z3;
        char c3;
        if (set.isEmpty()) {
            return 0;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(set);
        Collections.sort(arrayList, new Comparator<Rect>() {
            public final /* synthetic */ int compare(Object obj, Object obj2) {
                return Integer.valueOf(((Rect) obj).top).compareTo(Integer.valueOf(((Rect) obj2).top));
            }
        });
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (true) {
            if (it.hasNext()) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                break;
            }
            int i = f33820 + 101;
            f33821 = i % 128;
            if (i % 2 == 0) {
            }
            Rect rect2 = (Rect) it.next();
            arrayList2.add(Integer.valueOf(rect2.left));
            arrayList2.add(Integer.valueOf(rect2.right));
        }
        Collections.sort(arrayList2);
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 < arrayList2.size() - 1) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                return i3;
            }
            int i4 = f33821 + 99;
            f33820 = i4 % 128;
            if (i4 % 2 != 0) {
            }
            int i5 = i2 + 1;
            if (!((Integer) arrayList2.get(i2)).equals(arrayList2.get(i5))) {
                c = 'a';
            } else {
                c = '1';
            }
            if (c != '1') {
                Rect rect3 = new Rect(((Integer) arrayList2.get(i2)).intValue(), rect.top, ((Integer) arrayList2.get(i5)).intValue(), rect.bottom);
                int i6 = rect.top;
                Iterator it2 = arrayList.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        c2 = '^';
                    } else {
                        c2 = 17;
                    }
                    if (c2 == 17) {
                        break;
                    }
                    Rect rect4 = (Rect) it2.next();
                    if (Rect.intersects(rect4, rect3)) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z3) {
                        if (rect4.bottom > i6) {
                            c3 = 3;
                        } else {
                            c3 = '/';
                        }
                        if (c3 == 3) {
                            i3 += rect3.width() * (rect4.bottom - Math.max(i6, rect4.top));
                            i6 = rect4.bottom;
                        }
                        if (rect4.bottom == rect3.bottom) {
                            break;
                        }
                    }
                }
            }
            i2 = i5;
        }
    }

    /* renamed from: ॱ */
    private static Map<String, String> m36420(Rect rect) {
        HashMap hashMap = new HashMap();
        hashMap.put("x", String.valueOf(rect.left));
        hashMap.put("y", String.valueOf(rect.top));
        hashMap.put("w", String.valueOf(rect.right - rect.left));
        hashMap.put("h", String.valueOf(rect.bottom - rect.top));
        return hashMap;
    }

    /* renamed from: ˎ */
    private static Rect m36415(Rect rect, DisplayMetrics displayMetrics) {
        boolean z;
        float f = displayMetrics.density;
        if (f == 0.0f) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            return rect;
        }
        return new Rect(Math.round(((float) rect.left) / f), Math.round(((float) rect.top) / f), Math.round(((float) rect.right) / f), Math.round(((float) rect.bottom) / f));
    }

    /* renamed from: ॱ */
    private static Rect m36419(View view) {
        int[] iArr = {LinearLayoutManager.INVALID_OFFSET, LinearLayoutManager.INVALID_OFFSET};
        view.getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        return new Rect(i, i2, view.getWidth() + i, view.getHeight() + i2);
    }
}
