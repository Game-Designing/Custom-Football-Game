package p005cm.aptoide.p006pt.store.view;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;

/* renamed from: cm.aptoide.pt.store.view.BadgeDialogFactory */
public class BadgeDialogFactory {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final float MEDAL_SCALE = 1.25f;
    private final Context context;
    private int normalMedalSize;
    private int selectedMedalSize;

    /* renamed from: cm.aptoide.pt.store.view.BadgeDialogFactory$1 */
    static /* synthetic */ class C49451 {

        /* renamed from: $SwitchMap$cm$aptoide$pt$store$view$GridStoreMetaWidget$HomeMeta$Badge */
        static final /* synthetic */ int[] f8595x2685ebd = new int[Badge.values().length];
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(-1830274910819853618L, "cm/aptoide/pt/store/view/BadgeDialogFactory$1", 12);
            $jacocoData = probes;
            return probes;
        }

        static {
            boolean[] $jacocoInit = $jacocoInit();
            try {
                $jacocoInit[0] = true;
                f8595x2685ebd[Badge.NONE.ordinal()] = 1;
                $jacocoInit[1] = true;
            } catch (NoSuchFieldError e) {
                try {
                    $jacocoInit[2] = true;
                } catch (NoSuchFieldError e2) {
                    try {
                        $jacocoInit[4] = true;
                    } catch (NoSuchFieldError e3) {
                        try {
                            $jacocoInit[6] = true;
                        } catch (NoSuchFieldError e4) {
                            try {
                                $jacocoInit[8] = true;
                            } catch (NoSuchFieldError e5) {
                                $jacocoInit[10] = true;
                            }
                        }
                    }
                }
            }
            f8595x2685ebd[Badge.BRONZE.ordinal()] = 2;
            $jacocoInit[3] = true;
            f8595x2685ebd[Badge.SILVER.ordinal()] = 3;
            $jacocoInit[5] = true;
            f8595x2685ebd[Badge.GOLD.ordinal()] = 4;
            $jacocoInit[7] = true;
            f8595x2685ebd[Badge.PLATINUM.ordinal()] = 5;
            $jacocoInit[9] = true;
            $jacocoInit[11] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-638890159220071608L, "cm/aptoide/pt/store/view/BadgeDialogFactory", 215);
        $jacocoData = probes;
        return probes;
    }

    public BadgeDialogFactory(Context context2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.context = context2;
        $jacocoInit[0] = true;
    }

    public Dialog create(Badge badge, boolean storeOwner) {
        boolean[] $jacocoInit = $jacocoInit();
        LayoutInflater from = LayoutInflater.from(this.context);
        $jacocoInit[1] = true;
        View view = from.inflate(C1375R.layout.store_badge_dialog, null);
        $jacocoInit[2] = true;
        ImageView bronzeMedal = (ImageView) view.findViewById(C1375R.C1376id.bronze_medal);
        $jacocoInit[3] = true;
        this.normalMedalSize = bronzeMedal.getLayoutParams().width;
        this.selectedMedalSize = (int) (((float) this.normalMedalSize) * 1.25f);
        $jacocoInit[4] = true;
        Context context2 = view.getContext();
        $jacocoInit[5] = true;
        Resources resources = context2.getResources();
        $jacocoInit[6] = true;
        createViewModel(badge, resources, badge, view, storeOwner);
        $jacocoInit[7] = true;
        Builder view2 = new Builder(this.context).setView(view);
        $jacocoInit[8] = true;
        Dialog dialog = view2.create();
        $jacocoInit[9] = true;
        View okButton = view.findViewById(C1375R.C1376id.ok_button);
        $jacocoInit[10] = true;
        okButton.setOnClickListener(new C5086t(dialog));
        $jacocoInit[11] = true;
        return dialog;
    }

    /* renamed from: a */
    static /* synthetic */ void m9288a(Dialog dialog, View v) {
        boolean[] $jacocoInit = $jacocoInit();
        dialog.dismiss();
        $jacocoInit[214] = true;
    }

    /* JADX WARNING: type inference failed for: r36v2 */
    /* JADX WARNING: type inference failed for: r10v2, types: [int] */
    /* JADX WARNING: type inference failed for: r1v5, types: [int] */
    /* JADX WARNING: type inference failed for: r2v5, types: [int] */
    /* JADX WARNING: type inference failed for: r1v7, types: [int] */
    /* JADX WARNING: type inference failed for: r1v9, types: [int] */
    /* JADX WARNING: type inference failed for: r1v11, types: [int] */
    /* JADX WARNING: type inference failed for: r1v13, types: [int] */
    /* JADX WARNING: type inference failed for: r20v3 */
    /* JADX WARNING: type inference failed for: r12v6 */
    /* JADX WARNING: type inference failed for: r10v8 */
    /* JADX WARNING: type inference failed for: r36v4 */
    /* JADX WARNING: type inference failed for: r12v8 */
    /* JADX WARNING: type inference failed for: r10v14 */
    /* JADX WARNING: type inference failed for: r10v21 */
    /* JADX WARNING: type inference failed for: r12v11 */
    /* JADX WARNING: type inference failed for: r36v9 */
    /* JADX WARNING: type inference failed for: r16v12 */
    /* JADX WARNING: type inference failed for: r10v40 */
    /* JADX WARNING: type inference failed for: r16v13 */
    /* JADX WARNING: type inference failed for: r36v10 */
    /* JADX WARNING: type inference failed for: r16v14 */
    /* JADX WARNING: type inference failed for: r36v12 */
    /* JADX WARNING: type inference failed for: r36v13 */
    /* JADX WARNING: type inference failed for: r16v15 */
    /* JADX WARNING: type inference failed for: r10v70 */
    /* JADX WARNING: type inference failed for: r16v16 */
    /* JADX WARNING: type inference failed for: r36v14 */
    /* JADX WARNING: type inference failed for: r16v17 */
    /* JADX WARNING: type inference failed for: r36v16 */
    /* JADX WARNING: type inference failed for: r36v17 */
    /* JADX WARNING: type inference failed for: r16v18 */
    /* JADX WARNING: type inference failed for: r10v100 */
    /* JADX WARNING: type inference failed for: r16v19 */
    /* JADX WARNING: type inference failed for: r36v18 */
    /* JADX WARNING: type inference failed for: r16v20 */
    /* JADX WARNING: type inference failed for: r36v20 */
    /* JADX WARNING: type inference failed for: r36v22 */
    /* JADX WARNING: type inference failed for: r10v128 */
    /* JADX WARNING: type inference failed for: r10v129 */
    /* JADX WARNING: type inference failed for: r12v38 */
    /* JADX WARNING: type inference failed for: r36v23 */
    /* JADX WARNING: type inference failed for: r36v24 */
    /* JADX WARNING: type inference failed for: r36v25 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r10v8
      assigns: []
      uses: []
      mth insns count: 599
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
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 20 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void createViewModel(p005cm.aptoide.p006pt.store.view.GridStoreMetaWidget.HomeMeta.Badge r57, android.content.res.Resources r58, p005cm.aptoide.p006pt.store.view.GridStoreMetaWidget.HomeMeta.Badge r59, android.view.View r60, boolean r61) {
        /*
            r56 = this;
            r6 = r56
            r7 = r57
            r8 = r58
            r9 = r59
            r10 = r60
            boolean[] r11 = $jacocoInit()
            r0 = 2131296844(0x7f09024c, float:1.8211616E38)
            android.view.View r0 = r10.findViewById(r0)
            r12 = r0
            android.widget.ImageView r12 = (android.widget.ImageView) r12
            r13 = 1
            r0 = 12
            r11[r0] = r13
            r0 = 2131296766(0x7f0901fe, float:1.8211458E38)
            android.view.View r14 = r10.findViewById(r0)
            r0 = 13
            r11[r0] = r13
            r0 = 2131296967(0x7f0902c7, float:1.8211866E38)
            android.view.View r0 = r10.findViewById(r0)
            r15 = r0
            android.widget.ImageView r15 = (android.widget.ImageView) r15
            r0 = 14
            r11[r0] = r13
            r0 = 2131297282(0x7f090402, float:1.8212505E38)
            android.view.View r0 = r10.findViewById(r0)
            r5 = r0
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            r0 = 15
            r11[r0] = r13
            r0 = 2131296465(0x7f0900d1, float:1.8210847E38)
            android.view.View r0 = r10.findViewById(r0)
            r4 = r0
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            r0 = 16
            r11[r0] = r13
            r0 = 2131297207(0x7f0903b7, float:1.8212352E38)
            android.view.View r0 = r10.findViewById(r0)
            r3 = r0
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            r0 = 17
            r11[r0] = r13
            r0 = 2131296838(0x7f090246, float:1.8211604E38)
            android.view.View r0 = r10.findViewById(r0)
            r2 = r0
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            r0 = 18
            r11[r0] = r13
            r0 = 2131297063(0x7f090327, float:1.821206E38)
            android.view.View r0 = r10.findViewById(r0)
            r1 = r0
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            r0 = 19
            r11[r0] = r13
            r0 = 2131297283(0x7f090403, float:1.8212507E38)
            android.view.View r0 = r10.findViewById(r0)
            r16 = 20
            r11[r16] = r13
            r13 = 2131296466(0x7f0900d2, float:1.821085E38)
            android.view.View r13 = r10.findViewById(r13)
            r17 = 21
            r16 = 1
            r11[r17] = r16
            r17 = r0
            r0 = 2131297208(0x7f0903b8, float:1.8212354E38)
            android.view.View r0 = r10.findViewById(r0)
            r18 = 22
            r11[r18] = r16
            r18 = r0
            r0 = 2131296839(0x7f090247, float:1.8211606E38)
            android.view.View r0 = r10.findViewById(r0)
            r19 = 23
            r11[r19] = r16
            r19 = r0
            r0 = 2131297064(0x7f090328, float:1.8212062E38)
            android.view.View r0 = r10.findViewById(r0)
            r20 = 24
            r11[r20] = r16
            r20 = r0
            r0 = 2131296968(0x7f0902c8, float:1.8211868E38)
            android.view.View r0 = r10.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r21 = 25
            r11[r21] = r16
            r21 = r1
            r1 = 2131296563(0x7f090133, float:1.8211046E38)
            android.view.View r1 = r10.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r22 = 26
            r11[r22] = r16
            r22 = r2
            r2 = 2131297327(0x7f09042f, float:1.8212596E38)
            android.view.View r2 = r10.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r23 = 27
            r11[r23] = r16
            r23 = r3
            r3 = 2131296635(0x7f09017b, float:1.8211192E38)
            android.view.View r3 = r10.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            r24 = 28
            r11[r24] = r16
            r24 = r4
            r4 = 2131296765(0x7f0901fd, float:1.8211456E38)
            android.view.View r4 = r10.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r25 = 29
            r11[r25] = r16
            r25 = r5
            r5 = 2131297147(0x7f09037b, float:1.821223E38)
            android.view.View r5 = r10.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r26 = 30
            r11[r26] = r16
            r26 = r13
            r13 = 2131297079(0x7f090337, float:1.8212093E38)
            android.view.View r13 = r10.findViewById(r13)
            r27 = 31
            r11[r27] = r16
            r27 = r13
            r13 = 2131297080(0x7f090338, float:1.8212095E38)
            android.view.View r13 = r10.findViewById(r13)
            r28 = 32
            r11[r28] = r16
            r28 = r13
            r13 = 2131297081(0x7f090339, float:1.8212097E38)
            android.view.View r13 = r10.findViewById(r13)
            r29 = 33
            r11[r29] = r16
            r29 = r13
            r13 = 2131297082(0x7f09033a, float:1.8212099E38)
            android.view.View r13 = r10.findViewById(r13)
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 34
            r16 = 1
            r11[r35] = r16
            int[] r35 = p005cm.aptoide.p006pt.store.view.BadgeDialogFactory.C49451.f8595x2685ebd
            int r36 = r59.ordinal()
            r10 = r35[r36]
            r35 = r13
            java.lang.String r36 = " 💪"
            java.lang.String r38 = "🎉"
            r13 = 2
            if (r10 == r13) goto L_0x04b8
            r13 = 3
            if (r10 == r13) goto L_0x03ce
            r13 = 4
            if (r10 == r13) goto L_0x02e4
            r13 = 5
            if (r10 == r13) goto L_0x01fa
            r10 = 2131099961(0x7f060139, float:1.781229E38)
            r13 = 2131099962(0x7f06013a, float:1.7812292E38)
            r36 = 35
            r37 = r10
            r10 = 1
            r11[r36] = r10
            r10 = 2131231535(0x7f08032f, float:1.8079154E38)
            r15.setImageResource(r10)
            r10 = 36
            r36 = r13
            r13 = 1
            r11[r10] = r13
            r10 = 2131689687(0x7f0f00d7, float:1.9008396E38)
            java.lang.String r10 = r8.getString(r10)
            r0.setText(r10)
            java.lang.Object[] r10 = new java.lang.Object[r13]
            r39 = 0
            r10[r39] = r38
            r38 = 37
            r11[r38] = r13
            r13 = 2131689681(0x7f0f00d1, float:1.9008384E38)
            java.lang.String r10 = r8.getString(r13, r10)
            r13 = 38
            r40 = r12
            r12 = 1
            r11[r13] = r12
            r1.setText(r10)
            r10 = 39
            r11[r10] = r12
            r10 = 2131689682(0x7f0f00d2, float:1.9008386E38)
            java.lang.String r10 = r8.getString(r10)
            r2.setText(r10)
            r10 = 40
            r11[r10] = r12
            r10 = 0
            r2.setVisibility(r10)
            r10 = 41
            r11[r10] = r12
            r10 = 8
            r3.setVisibility(r10)
            r13 = 42
            r11[r13] = r12
            r4.setVisibility(r10)
            r13 = 43
            r11[r13] = r12
            r14.setVisibility(r10)
            r13 = 44
            r11[r13] = r12
            r5.setVisibility(r10)
            r30 = 1
            r10 = 45
            r11[r10] = r12
            r12 = r30
            r13 = r31
            r41 = r34
            r10 = r37
            r30 = r14
            r31 = r15
            r14 = r32
            r15 = r33
            goto L_0x05a4
        L_0x01fa:
            r40 = r12
            r12 = 1
            boolean r10 = r6.isRankLocked(r7, r9)
            if (r10 == 0) goto L_0x0238
            r10 = 97
            r11[r10] = r12
            r10 = 2131231398(0x7f0802a6, float:1.8078876E38)
            r15.setImageResource(r10)
            r10 = 2131099842(0x7f0600c2, float:1.7812049E38)
            r13 = 2131099843(0x7f0600c3, float:1.781205E38)
            r16 = r10
            java.lang.Object[] r10 = new java.lang.Object[r12]
            r38 = 0
            r10[r38] = r36
            r36 = 98
            r11[r36] = r12
            r12 = 2131689674(0x7f0f00ca, float:1.900837E38)
            java.lang.String r10 = r8.getString(r12, r10)
            r12 = 99
            r37 = r13
            r13 = 1
            r11[r12] = r13
            r1.setText(r10)
            r10 = 100
            r11[r10] = r13
            r36 = r37
            r12 = 1
            goto L_0x0266
        L_0x0238:
            r13 = 1
            r10 = 2131231466(0x7f0802ea, float:1.8079014E38)
            r15.setImageResource(r10)
            r10 = 2131099916(0x7f06010c, float:1.7812199E38)
            r12 = 2131099917(0x7f06010d, float:1.78122E38)
            r16 = r10
            java.lang.Object[] r10 = new java.lang.Object[r13]
            r37 = 0
            r10[r37] = r38
            r37 = 101(0x65, float:1.42E-43)
            r11[r37] = r13
            r13 = 2131689669(0x7f0f00c5, float:1.900836E38)
            java.lang.String r10 = r8.getString(r13, r10)
            r13 = 102(0x66, float:1.43E-43)
            r36 = r12
            r12 = 1
            r11[r13] = r12
            r1.setText(r10)
            r10 = 103(0x67, float:1.44E-43)
            r11[r10] = r12
        L_0x0266:
            r10 = 2131689685(0x7f0f00d5, float:1.9008392E38)
            java.lang.String r10 = r8.getString(r10)
            r0.setText(r10)
            r10 = 104(0x68, float:1.46E-43)
            r11[r10] = r12
            r10 = 2131689670(0x7f0f00c6, float:1.9008362E38)
            java.lang.String r10 = r8.getString(r10)
            r2.setText(r10)
            r10 = 105(0x69, float:1.47E-43)
            r11[r10] = r12
            r10 = 0
            r2.setVisibility(r10)
            r13 = 106(0x6a, float:1.49E-43)
            r11[r13] = r12
            r3.setVisibility(r10)
            r13 = 107(0x6b, float:1.5E-43)
            r11[r13] = r12
            r4.setVisibility(r10)
            r13 = 108(0x6c, float:1.51E-43)
            r11[r13] = r12
            r14.setVisibility(r10)
            r13 = 109(0x6d, float:1.53E-43)
            r11[r13] = r12
            r5.setVisibility(r10)
            r10 = 110(0x6e, float:1.54E-43)
            r11[r10] = r12
            r10 = 2131689671(0x7f0f00c7, float:1.9008364E38)
            java.lang.String r10 = r8.getString(r10)
            r3.setText(r10)
            r10 = 111(0x6f, float:1.56E-43)
            r11[r10] = r12
            r10 = 2131689672(0x7f0f00c8, float:1.9008366E38)
            java.lang.String r10 = r8.getString(r10)
            r4.setText(r10)
            r10 = 112(0x70, float:1.57E-43)
            r11[r10] = r12
            r10 = 2131689673(0x7f0f00c9, float:1.9008368E38)
            java.lang.String r10 = r8.getString(r10)
            r5.setText(r10)
            r34 = 1
            r10 = 113(0x71, float:1.58E-43)
            r11[r10] = r12
            r10 = r16
            r12 = r30
            r13 = r31
            r41 = r34
            r30 = r14
            r31 = r15
            r14 = r32
            r15 = r33
            goto L_0x05a4
        L_0x02e4:
            r40 = r12
            r12 = 1
            boolean r10 = r6.isRankLocked(r7, r9)
            if (r10 == 0) goto L_0x0322
            r10 = 80
            r11[r10] = r12
            r10 = 2131231398(0x7f0802a6, float:1.8078876E38)
            r15.setImageResource(r10)
            r10 = 2131099842(0x7f0600c2, float:1.7812049E38)
            r13 = 2131099843(0x7f0600c3, float:1.781205E38)
            r16 = r10
            java.lang.Object[] r10 = new java.lang.Object[r12]
            r38 = 0
            r10[r38] = r36
            r36 = 81
            r11[r36] = r12
            r12 = 2131689668(0x7f0f00c4, float:1.9008358E38)
            java.lang.String r10 = r8.getString(r12, r10)
            r12 = 82
            r37 = r13
            r13 = 1
            r11[r12] = r13
            r1.setText(r10)
            r10 = 83
            r11[r10] = r13
            r36 = r37
            r12 = 1
            goto L_0x0350
        L_0x0322:
            r13 = 1
            r10 = 2131231112(0x7f080188, float:1.8078296E38)
            r15.setImageResource(r10)
            r10 = 2131099829(0x7f0600b5, float:1.7812022E38)
            r12 = 2131099830(0x7f0600b6, float:1.7812024E38)
            r16 = r10
            java.lang.Object[] r10 = new java.lang.Object[r13]
            r37 = 0
            r10[r37] = r38
            r37 = 84
            r11[r37] = r13
            r13 = 2131689663(0x7f0f00bf, float:1.9008348E38)
            java.lang.String r10 = r8.getString(r13, r10)
            r13 = 85
            r36 = r12
            r12 = 1
            r11[r13] = r12
            r1.setText(r10)
            r10 = 86
            r11[r10] = r12
        L_0x0350:
            r10 = 2131689684(0x7f0f00d4, float:1.900839E38)
            java.lang.String r10 = r8.getString(r10)
            r0.setText(r10)
            r10 = 87
            r11[r10] = r12
            r10 = 2131689664(0x7f0f00c0, float:1.900835E38)
            java.lang.String r10 = r8.getString(r10)
            r2.setText(r10)
            r10 = 88
            r11[r10] = r12
            r10 = 0
            r2.setVisibility(r10)
            r13 = 89
            r11[r13] = r12
            r3.setVisibility(r10)
            r13 = 90
            r11[r13] = r12
            r4.setVisibility(r10)
            r13 = 91
            r11[r13] = r12
            r14.setVisibility(r10)
            r13 = 92
            r11[r13] = r12
            r5.setVisibility(r10)
            r10 = 93
            r11[r10] = r12
            r10 = 2131689665(0x7f0f00c1, float:1.9008352E38)
            java.lang.String r10 = r8.getString(r10)
            r3.setText(r10)
            r10 = 94
            r11[r10] = r12
            r10 = 2131689666(0x7f0f00c2, float:1.9008354E38)
            java.lang.String r10 = r8.getString(r10)
            r4.setText(r10)
            r10 = 95
            r11[r10] = r12
            r10 = 2131689667(0x7f0f00c3, float:1.9008356E38)
            java.lang.String r10 = r8.getString(r10)
            r5.setText(r10)
            r33 = 1
            r10 = 96
            r11[r10] = r12
            r10 = r16
            r12 = r30
            r13 = r31
            r41 = r34
            r30 = r14
            r31 = r15
            r14 = r32
            r15 = r33
            goto L_0x05a4
        L_0x03ce:
            r40 = r12
            r12 = 1
            boolean r10 = r6.isRankLocked(r7, r9)
            if (r10 == 0) goto L_0x040c
            r10 = 63
            r11[r10] = r12
            r10 = 2131231398(0x7f0802a6, float:1.8078876E38)
            r15.setImageResource(r10)
            r10 = 2131099842(0x7f0600c2, float:1.7812049E38)
            r13 = 2131099843(0x7f0600c3, float:1.781205E38)
            r16 = r10
            java.lang.Object[] r10 = new java.lang.Object[r12]
            r38 = 0
            r10[r38] = r36
            r36 = 64
            r11[r36] = r12
            r12 = 2131689680(0x7f0f00d0, float:1.9008382E38)
            java.lang.String r10 = r8.getString(r12, r10)
            r12 = 65
            r37 = r13
            r13 = 1
            r11[r12] = r13
            r1.setText(r10)
            r10 = 66
            r11[r10] = r13
            r36 = r37
            r12 = 1
            goto L_0x043a
        L_0x040c:
            r13 = 1
            r10 = 2131231508(0x7f080314, float:1.80791E38)
            r15.setImageResource(r10)
            r10 = 2131099948(0x7f06012c, float:1.7812264E38)
            r12 = 2131099949(0x7f06012d, float:1.7812266E38)
            r16 = r10
            java.lang.Object[] r10 = new java.lang.Object[r13]
            r37 = 0
            r10[r37] = r38
            r37 = 67
            r11[r37] = r13
            r13 = 2131689675(0x7f0f00cb, float:1.9008372E38)
            java.lang.String r10 = r8.getString(r13, r10)
            r13 = 68
            r36 = r12
            r12 = 1
            r11[r13] = r12
            r1.setText(r10)
            r10 = 69
            r11[r10] = r12
        L_0x043a:
            r10 = 2131689686(0x7f0f00d6, float:1.9008394E38)
            java.lang.String r10 = r8.getString(r10)
            r0.setText(r10)
            r10 = 70
            r11[r10] = r12
            r10 = 2131689676(0x7f0f00cc, float:1.9008374E38)
            java.lang.String r10 = r8.getString(r10)
            r2.setText(r10)
            r10 = 71
            r11[r10] = r12
            r10 = 2131689677(0x7f0f00cd, float:1.9008376E38)
            java.lang.String r10 = r8.getString(r10)
            r3.setText(r10)
            r10 = 72
            r11[r10] = r12
            r10 = 2131689678(0x7f0f00ce, float:1.9008378E38)
            java.lang.String r10 = r8.getString(r10)
            r4.setText(r10)
            r10 = 73
            r11[r10] = r12
            r10 = 2131689679(0x7f0f00cf, float:1.900838E38)
            java.lang.String r10 = r8.getString(r10)
            r5.setText(r10)
            r10 = 74
            r11[r10] = r12
            r10 = 0
            r2.setVisibility(r10)
            r13 = 75
            r11[r13] = r12
            r3.setVisibility(r10)
            r13 = 76
            r11[r13] = r12
            r4.setVisibility(r10)
            r13 = 77
            r11[r13] = r12
            r14.setVisibility(r10)
            r13 = 78
            r11[r13] = r12
            r5.setVisibility(r10)
            r32 = 1
            r10 = 79
            r11[r10] = r12
            r10 = r16
            r12 = r30
            r13 = r31
            r41 = r34
            r30 = r14
            r31 = r15
            r14 = r32
            r15 = r33
            goto L_0x05a4
        L_0x04b8:
            r40 = r12
            r12 = 1
            boolean r10 = r6.isRankLocked(r7, r9)
            if (r10 == 0) goto L_0x04f9
            r10 = 46
            r11[r10] = r12
            r10 = 2131231398(0x7f0802a6, float:1.8078876E38)
            r15.setImageResource(r10)
            r10 = 2131099842(0x7f0600c2, float:1.7812049E38)
            r13 = 2131099843(0x7f0600c3, float:1.781205E38)
            r16 = r10
            java.lang.Object[] r10 = new java.lang.Object[r12]
            r38 = 0
            r10[r38] = r36
            r36 = 47
            r11[r36] = r12
            r12 = 2131689662(0x7f0f00be, float:1.9008346E38)
            java.lang.String r10 = r8.getString(r12, r10)
            r12 = 48
            r36 = r13
            r13 = 1
            r11[r12] = r13
            r1.setText(r10)
            r10 = 49
            r11[r10] = r13
            r10 = r16
            r12 = r36
            r36 = 1
            goto L_0x0528
        L_0x04f9:
            r13 = 1
            r10 = 2131230902(0x7f0800b6, float:1.807787E38)
            r15.setImageResource(r10)
            r10 = 2131099718(0x7f060046, float:1.7811797E38)
            r12 = 2131099719(0x7f060047, float:1.78118E38)
            r16 = r10
            java.lang.Object[] r10 = new java.lang.Object[r13]
            r37 = 0
            r10[r37] = r38
            r37 = 50
            r11[r37] = r13
            r13 = 2131689657(0x7f0f00b9, float:1.9008336E38)
            java.lang.String r10 = r8.getString(r13, r10)
            r13 = 51
            r36 = 1
            r11[r13] = r36
            r1.setText(r10)
            r10 = 52
            r11[r10] = r36
            r10 = r16
        L_0x0528:
            r13 = 2131689683(0x7f0f00d3, float:1.9008388E38)
            java.lang.String r13 = r8.getString(r13)
            r0.setText(r13)
            r13 = 53
            r11[r13] = r36
            r13 = 2131689658(0x7f0f00ba, float:1.9008338E38)
            java.lang.String r13 = r8.getString(r13)
            r2.setText(r13)
            r13 = 54
            r11[r13] = r36
            r13 = 2131689659(0x7f0f00bb, float:1.900834E38)
            java.lang.String r13 = r8.getString(r13)
            r3.setText(r13)
            r13 = 55
            r11[r13] = r36
            r13 = 2131689660(0x7f0f00bc, float:1.9008342E38)
            java.lang.String r13 = r8.getString(r13)
            r4.setText(r13)
            r13 = 56
            r11[r13] = r36
            r13 = 2131689661(0x7f0f00bd, float:1.9008344E38)
            java.lang.String r13 = r8.getString(r13)
            r5.setText(r13)
            r13 = 57
            r11[r13] = r36
            r13 = 0
            r2.setVisibility(r13)
            r16 = 58
            r11[r16] = r36
            r3.setVisibility(r13)
            r16 = 59
            r11[r16] = r36
            r4.setVisibility(r13)
            r16 = 60
            r11[r16] = r36
            r14.setVisibility(r13)
            r16 = 61
            r11[r16] = r36
            r5.setVisibility(r13)
            r31 = 1
            r13 = 62
            r11[r13] = r36
            r36 = r12
            r12 = r30
            r13 = r31
            r41 = r34
            r30 = r14
            r31 = r15
            r14 = r32
            r15 = r33
        L_0x05a4:
            cm.aptoide.pt.store.view.GridStoreMetaWidget$HomeMeta$Badge r32 = p005cm.aptoide.p006pt.store.view.GridStoreMetaWidget.HomeMeta.Badge.NONE
            r42 = r17
            r43 = r18
            r44 = r19
            r45 = r20
            r17 = r0
            r0 = r56
            r47 = r1
            r46 = r21
            r1 = r10
            r18 = r15
            r15 = r2
            r2 = r36
            r19 = r14
            r14 = r3
            r3 = r57
            r20 = r13
            r13 = r4
            r4 = r59
            r21 = r12
            r12 = r5
            r5 = r32
            int r5 = r0.getProgressColor(r1, r2, r3, r4, r5)
            r0 = 114(0x72, float:1.6E-43)
            r1 = 1
            r11[r0] = r1
            cm.aptoide.pt.store.view.GridStoreMetaWidget$HomeMeta$Badge r32 = p005cm.aptoide.p006pt.store.view.GridStoreMetaWidget.HomeMeta.Badge.BRONZE
            r0 = r56
            r1 = r10
            r48 = r5
            r5 = r32
            int r5 = r0.getProgressColor(r1, r2, r3, r4, r5)
            r0 = 115(0x73, float:1.61E-43)
            r1 = 1
            r11[r0] = r1
            r4 = r5
            cm.aptoide.pt.store.view.GridStoreMetaWidget$HomeMeta$Badge r32 = p005cm.aptoide.p006pt.store.view.GridStoreMetaWidget.HomeMeta.Badge.SILVER
            r0 = r56
            r1 = r10
            r49 = r4
            r4 = r59
            r50 = r5
            r5 = r32
            int r5 = r0.getProgressColor(r1, r2, r3, r4, r5)
            r0 = 116(0x74, float:1.63E-43)
            r1 = 1
            r11[r0] = r1
            r4 = r5
            cm.aptoide.pt.store.view.GridStoreMetaWidget$HomeMeta$Badge r32 = p005cm.aptoide.p006pt.store.view.GridStoreMetaWidget.HomeMeta.Badge.GOLD
            r0 = r56
            r1 = r10
            r51 = r4
            r4 = r59
            r52 = r5
            r5 = r32
            int r5 = r0.getProgressColor(r1, r2, r3, r4, r5)
            r0 = 117(0x75, float:1.64E-43)
            r1 = 1
            r11[r0] = r1
            r4 = r5
            cm.aptoide.pt.store.view.GridStoreMetaWidget$HomeMeta$Badge r32 = p005cm.aptoide.p006pt.store.view.GridStoreMetaWidget.HomeMeta.Badge.PLATINUM
            r0 = r56
            r1 = r10
            r53 = r4
            r4 = r59
            r54 = r5
            r5 = r32
            int r5 = r0.getProgressColor(r1, r2, r3, r4, r5)
            r0 = 118(0x76, float:1.65E-43)
            r1 = 1
            r11[r0] = r1
            r4 = r5
            int r0 = r8.getColor(r10)
            r3 = r40
            r3.setBackgroundColor(r0)
            r0 = 119(0x77, float:1.67E-43)
            r11[r0] = r1
            boolean r0 = r6.isRankLocked(r7, r9)
            if (r0 != 0) goto L_0x0660
            r0 = 120(0x78, float:1.68E-43)
            r11[r0] = r1
            r6.setDrawableColor(r8, r10, r15)
            r0 = 121(0x79, float:1.7E-43)
            r11[r0] = r1
            r6.setDrawableColor(r8, r10, r14)
            r0 = 122(0x7a, float:1.71E-43)
            r11[r0] = r1
            r6.setDrawableColor(r8, r10, r13)
            r0 = 123(0x7b, float:1.72E-43)
            r11[r0] = r1
            r6.setDrawableColor(r8, r10, r12)
            r0 = 124(0x7c, float:1.74E-43)
            r11[r0] = r1
            goto L_0x0682
        L_0x0660:
            r0 = 2131099843(0x7f0600c3, float:1.781205E38)
            r6.setDrawableColor(r8, r0, r15)
            r2 = 125(0x7d, float:1.75E-43)
            r11[r2] = r1
            r2 = 2131099969(0x7f060141, float:1.7812306E38)
            r6.setDrawableColor(r8, r2, r14)
            r16 = 126(0x7e, float:1.77E-43)
            r11[r16] = r1
            r6.setDrawableColor(r8, r0, r13)
            r0 = 127(0x7f, float:1.78E-43)
            r11[r0] = r1
            r6.setDrawableColor(r8, r2, r12)
            r0 = 128(0x80, float:1.794E-43)
            r11[r0] = r1
        L_0x0682:
            r1 = r21
            r2 = r25
            r0 = r48
            r6.setupMedal(r2, r1, r0, r8)
            r21 = 129(0x81, float:1.81E-43)
            r16 = 1
            r11[r21] = r16
            r7 = r24
            r9 = r50
            r55 = r20
            r20 = r10
            r10 = r55
            r6.setupMedal(r7, r10, r9, r8)
            r21 = 130(0x82, float:1.82E-43)
            r11[r21] = r16
            r7 = r23
            r9 = r52
            r55 = r19
            r19 = r10
            r10 = r55
            r6.setupMedal(r7, r10, r9, r8)
            r21 = 131(0x83, float:1.84E-43)
            r11[r21] = r16
            r7 = r22
            r9 = r54
            r55 = r18
            r18 = r10
            r10 = r55
            r6.setupMedal(r7, r10, r9, r8)
            r21 = 132(0x84, float:1.85E-43)
            r11[r21] = r16
            r9 = r41
            r7 = r46
            r6.setupMedal(r7, r9, r5, r8)
            r21 = 133(0x85, float:1.86E-43)
            r11[r21] = r16
            cm.aptoide.pt.store.view.u r6 = new cm.aptoide.pt.store.view.u
            r21 = r0
            r0 = r6
            r25 = r1
            r1 = r56
            r32 = r2
            r2 = r57
            r33 = r3
            r3 = r58
            r7 = r4
            r4 = r60
            r34 = r5
            r5 = r61
            r0.<init>(r1, r2, r3, r4, r5)
            r5 = r42
            r5.setOnClickListener(r6)
            r0 = 134(0x86, float:1.88E-43)
            r1 = 1
            r11[r0] = r1
            cm.aptoide.pt.store.view.s r6 = new cm.aptoide.pt.store.view.s
            r0 = r6
            r1 = r56
            r37 = r9
            r9 = r5
            r5 = r61
            r0.<init>(r1, r2, r3, r4, r5)
            r5 = r26
            r5.setOnClickListener(r6)
            r0 = 135(0x87, float:1.89E-43)
            r1 = 1
            r11[r0] = r1
            cm.aptoide.pt.store.view.v r6 = new cm.aptoide.pt.store.view.v
            r0 = r6
            r1 = r56
            r26 = r10
            r10 = r5
            r5 = r61
            r0.<init>(r1, r2, r3, r4, r5)
            r5 = r43
            r5.setOnClickListener(r6)
            r0 = 136(0x88, float:1.9E-43)
            r1 = 1
            r11[r0] = r1
            cm.aptoide.pt.store.view.w r6 = new cm.aptoide.pt.store.view.w
            r0 = r6
            r1 = r56
            r38 = r12
            r12 = r5
            r5 = r61
            r0.<init>(r1, r2, r3, r4, r5)
            r5 = r44
            r5.setOnClickListener(r6)
            r0 = 137(0x89, float:1.92E-43)
            r1 = 1
            r11[r0] = r1
            cm.aptoide.pt.store.view.x r6 = new cm.aptoide.pt.store.view.x
            r0 = r6
            r1 = r56
            r39 = r13
            r13 = r5
            r5 = r61
            r0.<init>(r1, r2, r3, r4, r5)
            r0 = r45
            r0.setOnClickListener(r6)
            r1 = 138(0x8a, float:1.93E-43)
            r2 = 1
            r11[r1] = r2
            r1 = r49
            int r3 = r8.getColor(r1)
            r4 = r27
            r4.setBackgroundColor(r3)
            r3 = 139(0x8b, float:1.95E-43)
            r11[r3] = r2
            r3 = r51
            int r5 = r8.getColor(r3)
            r6 = r28
            r6.setBackgroundColor(r5)
            r5 = 140(0x8c, float:1.96E-43)
            r11[r5] = r2
            r5 = r53
            int r2 = r8.getColor(r5)
            r1 = r29
            r1.setBackgroundColor(r2)
            r2 = 141(0x8d, float:1.98E-43)
            r16 = 1
            r11[r2] = r16
            int r2 = r8.getColor(r7)
            r3 = r35
            r3.setBackgroundColor(r2)
            if (r61 == 0) goto L_0x07da
            r2 = 142(0x8e, float:1.99E-43)
            r11[r2] = r16
            r53 = r5
            r2 = r47
            r5 = 0
            r2.setVisibility(r5)
            r27 = 143(0x8f, float:2.0E-43)
            r11[r27] = r16
            r9.setVisibility(r5)
            r27 = 144(0x90, float:2.02E-43)
            r11[r27] = r16
            r10.setVisibility(r5)
            r27 = 145(0x91, float:2.03E-43)
            r11[r27] = r16
            r12.setVisibility(r5)
            r27 = 146(0x92, float:2.05E-43)
            r11[r27] = r16
            r13.setVisibility(r5)
            r27 = 147(0x93, float:2.06E-43)
            r11[r27] = r16
            r0.setVisibility(r5)
            r27 = 148(0x94, float:2.07E-43)
            r11[r27] = r16
            r4.setVisibility(r5)
            r27 = 149(0x95, float:2.09E-43)
            r11[r27] = r16
            r6.setVisibility(r5)
            r27 = 150(0x96, float:2.1E-43)
            r11[r27] = r16
            r1.setVisibility(r5)
            r27 = 151(0x97, float:2.12E-43)
            r11[r27] = r16
            r3.setVisibility(r5)
            r5 = 152(0x98, float:2.13E-43)
            r11[r5] = r16
            goto L_0x0826
        L_0x07da:
            r53 = r5
            r2 = r47
            r5 = 8
            r2.setVisibility(r5)
            r27 = 153(0x99, float:2.14E-43)
            r11[r27] = r16
            r9.setVisibility(r5)
            r27 = 154(0x9a, float:2.16E-43)
            r11[r27] = r16
            r10.setVisibility(r5)
            r27 = 155(0x9b, float:2.17E-43)
            r11[r27] = r16
            r12.setVisibility(r5)
            r27 = 156(0x9c, float:2.19E-43)
            r11[r27] = r16
            r13.setVisibility(r5)
            r27 = 157(0x9d, float:2.2E-43)
            r11[r27] = r16
            r0.setVisibility(r5)
            r27 = 158(0x9e, float:2.21E-43)
            r11[r27] = r16
            r4.setVisibility(r5)
            r27 = 159(0x9f, float:2.23E-43)
            r11[r27] = r16
            r6.setVisibility(r5)
            r27 = 160(0xa0, float:2.24E-43)
            r11[r27] = r16
            r1.setVisibility(r5)
            r27 = 161(0xa1, float:2.26E-43)
            r11[r27] = r16
            r3.setVisibility(r5)
            r5 = 162(0xa2, float:2.27E-43)
            r11[r5] = r16
        L_0x0826:
            r5 = 163(0xa3, float:2.28E-43)
            r11[r5] = r16
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.store.view.BadgeDialogFactory.createViewModel(cm.aptoide.pt.store.view.GridStoreMetaWidget$HomeMeta$Badge, android.content.res.Resources, cm.aptoide.pt.store.view.GridStoreMetaWidget$HomeMeta$Badge, android.view.View, boolean):void");
    }

    /* renamed from: a */
    public /* synthetic */ void mo16474a(Badge storeBadge, Resources resources, View view, boolean storeOwner, View v) {
        boolean[] $jacocoInit = $jacocoInit();
        createViewModel(storeBadge, resources, Badge.NONE, view, storeOwner);
        $jacocoInit[213] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo16475b(Badge storeBadge, Resources resources, View view, boolean storeOwner, View v) {
        boolean[] $jacocoInit = $jacocoInit();
        createViewModel(storeBadge, resources, Badge.BRONZE, view, storeOwner);
        $jacocoInit[212] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo16476c(Badge storeBadge, Resources resources, View view, boolean storeOwner, View v) {
        boolean[] $jacocoInit = $jacocoInit();
        createViewModel(storeBadge, resources, Badge.SILVER, view, storeOwner);
        $jacocoInit[211] = true;
    }

    /* renamed from: d */
    public /* synthetic */ void mo16478d(Badge storeBadge, Resources resources, View view, boolean storeOwner, View v) {
        boolean[] $jacocoInit = $jacocoInit();
        createViewModel(storeBadge, resources, Badge.GOLD, view, storeOwner);
        $jacocoInit[210] = true;
    }

    /* renamed from: e */
    public /* synthetic */ void mo16479e(Badge storeBadge, Resources resources, View view, boolean storeOwner, View v) {
        boolean[] $jacocoInit = $jacocoInit();
        createViewModel(storeBadge, resources, Badge.PLATINUM, view, storeOwner);
        $jacocoInit[209] = true;
    }

    private boolean isRankLocked(Badge storeBadge, Badge selectedBadge) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (storeBadge.ordinal() < selectedBadge.ordinal()) {
            $jacocoInit[164] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[165] = true;
        }
        $jacocoInit[166] = true;
        return z;
    }

    private int getProgressColor(int mainColor, int secondaryColor, Badge storeBadge, Badge selectedBadge, Badge currentSetup) {
        boolean[] $jacocoInit = $jacocoInit();
        int tinBadgeColor = C1375R.color.progress_bar_color;
        $jacocoInit[167] = true;
        if (currentSetup.ordinal() > storeBadge.ordinal()) {
            $jacocoInit[168] = true;
        } else {
            $jacocoInit[169] = true;
            if (currentSetup.ordinal() > selectedBadge.ordinal()) {
                $jacocoInit[170] = true;
            } else {
                tinBadgeColor = mainColor;
                $jacocoInit[171] = true;
                $jacocoInit[174] = true;
                return tinBadgeColor;
            }
        }
        if (currentSetup.ordinal() > storeBadge.ordinal()) {
            $jacocoInit[172] = true;
        } else {
            tinBadgeColor = secondaryColor;
            $jacocoInit[173] = true;
        }
        $jacocoInit[174] = true;
        return tinBadgeColor;
    }

    private void setBackground(ImageView view, int color) {
        boolean[] $jacocoInit = $jacocoInit();
        GradientDrawable shape = new GradientDrawable();
        $jacocoInit[175] = true;
        shape.setShape(1);
        $jacocoInit[176] = true;
        shape.setColor(color);
        if (VERSION.SDK_INT >= 16) {
            $jacocoInit[177] = true;
            view.setBackground(shape);
            $jacocoInit[178] = true;
        } else {
            view.setBackgroundDrawable(shape);
            $jacocoInit[179] = true;
        }
        $jacocoInit[180] = true;
    }

    private void setupMedal(ImageView badge, boolean isBadgeSelected, int badgeColor, Resources resources) {
        boolean[] $jacocoInit = $jacocoInit();
        if (isBadgeSelected) {
            $jacocoInit[181] = true;
            badge.getLayoutParams().width = this.selectedMedalSize;
            $jacocoInit[182] = true;
            badge.getLayoutParams().height = this.selectedMedalSize;
            $jacocoInit[183] = true;
            badge.setScaleType(ScaleType.FIT_XY);
            $jacocoInit[184] = true;
            badge.requestLayout();
            $jacocoInit[185] = true;
        } else {
            badge.getLayoutParams().width = this.normalMedalSize;
            $jacocoInit[186] = true;
            badge.getLayoutParams().height = this.normalMedalSize;
            $jacocoInit[187] = true;
            badge.setScaleType(ScaleType.FIT_XY);
            $jacocoInit[188] = true;
            badge.requestLayout();
            $jacocoInit[189] = true;
        }
        Drawable drawable = badge.getDrawable();
        $jacocoInit[190] = true;
        setDrawableColor(resources, badgeColor, drawable);
        $jacocoInit[191] = true;
        badge.setImageDrawable(drawable);
        $jacocoInit[192] = true;
        setBackground(badge, resources.getColor(C1375R.color.white));
        $jacocoInit[193] = true;
    }

    private void setDrawableColor(Resources resources, int color, TextView view) {
        boolean[] $jacocoInit = $jacocoInit();
        Drawable[] compoundDrawables = view.getCompoundDrawables();
        int i = 0;
        int compoundDrawablesLength = compoundDrawables.length;
        $jacocoInit[194] = true;
        while (i < compoundDrawablesLength) {
            Drawable drawable = compoundDrawables[i];
            if (drawable == null) {
                $jacocoInit[195] = true;
            } else {
                $jacocoInit[196] = true;
                drawable.mutate();
                $jacocoInit[197] = true;
                PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(resources.getColor(color), Mode.SRC_IN);
                $jacocoInit[198] = true;
                drawable.setColorFilter(porterDuffColorFilter);
                compoundDrawables[i] = drawable;
                $jacocoInit[199] = true;
            }
            i++;
            $jacocoInit[200] = true;
        }
        view.setCompoundDrawablesWithIntrinsicBounds(compoundDrawables[0], compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
        $jacocoInit[201] = true;
    }

    private void setDrawableColor(Resources resources, int color, Drawable... compoundDrawables) {
        boolean[] $jacocoInit = $jacocoInit();
        int length = compoundDrawables.length;
        $jacocoInit[202] = true;
        int i = 0;
        while (i < length) {
            Drawable drawable = compoundDrawables[i];
            if (drawable == null) {
                $jacocoInit[203] = true;
            } else {
                $jacocoInit[204] = true;
                PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(resources.getColor(color), Mode.SRC_IN);
                $jacocoInit[205] = true;
                drawable.setColorFilter(porterDuffColorFilter);
                $jacocoInit[206] = true;
            }
            i++;
            $jacocoInit[207] = true;
        }
        $jacocoInit[208] = true;
    }
}
