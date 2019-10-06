package com.mopub.mraid;

import android.util.DisplayMetrics;
import android.view.View;

/* renamed from: com.mopub.mraid.q */
/* compiled from: MraidController */
class C11500q implements Runnable {

    /* renamed from: a */
    final /* synthetic */ View f35577a;

    /* renamed from: b */
    final /* synthetic */ Runnable f35578b;

    /* renamed from: c */
    final /* synthetic */ MraidController f35579c;

    C11500q(MraidController this$0, View view, Runnable runnable) {
        this.f35579c = this$0;
        this.f35577a = view;
        this.f35578b = runnable;
    }

    public void run() {
        DisplayMetrics displayMetrics = 
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000a: INVOKE  (r0v3 'displayMetrics' android.util.DisplayMetrics) = (wrap: android.content.res.Resources
              0x0006: INVOKE  (r0v2 android.content.res.Resources) = (wrap: android.content.Context
              0x0002: INVOKE  (r0v1 android.content.Context) = (wrap: com.mopub.mraid.MraidController
              0x0000: IGET  (r0v0 com.mopub.mraid.MraidController) = (r10v0 'this' com.mopub.mraid.q A[THIS]) com.mopub.mraid.q.c com.mopub.mraid.MraidController) com.mopub.mraid.MraidController.k(com.mopub.mraid.MraidController):android.content.Context type: STATIC) android.content.Context.getResources():android.content.res.Resources type: VIRTUAL) android.content.res.Resources.getDisplayMetrics():android.util.DisplayMetrics type: VIRTUAL in method: com.mopub.mraid.q.run():void, dex: classes3.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:245)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:213)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:210)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:203)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:316)
            	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:262)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:225)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:110)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:76)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:32)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:20)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
            	at jadx.api.JavaClass.decompile(JavaClass.java:62)
            	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0006: INVOKE  (r0v2 android.content.res.Resources) = (wrap: android.content.Context
              0x0002: INVOKE  (r0v1 android.content.Context) = (wrap: com.mopub.mraid.MraidController
              0x0000: IGET  (r0v0 com.mopub.mraid.MraidController) = (r10v0 'this' com.mopub.mraid.q A[THIS]) com.mopub.mraid.q.c com.mopub.mraid.MraidController) com.mopub.mraid.MraidController.k(com.mopub.mraid.MraidController):android.content.Context type: STATIC) android.content.Context.getResources():android.content.res.Resources type: VIRTUAL in method: com.mopub.mraid.q.run():void, dex: classes3.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:245)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:105)
            	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:88)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:682)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:357)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:239)
            	... 19 more
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0002: INVOKE  (r0v1 android.content.Context) = (wrap: com.mopub.mraid.MraidController
              0x0000: IGET  (r0v0 com.mopub.mraid.MraidController) = (r10v0 'this' com.mopub.mraid.q A[THIS]) com.mopub.mraid.q.c com.mopub.mraid.MraidController) com.mopub.mraid.MraidController.k(com.mopub.mraid.MraidController):android.content.Context type: STATIC in method: com.mopub.mraid.q.run():void, dex: classes3.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:245)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:105)
            	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:88)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:682)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:357)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:223)
            	... 24 more
            Caused by: java.lang.ArrayIndexOutOfBoundsException: Index -1 out of bounds for length 2
            	at java.base/java.util.ArrayList.shiftTailOverGap(ArrayList.java:779)
            	at java.base/java.util.ArrayList.removeIf(ArrayList.java:1720)
            	at java.base/java.util.ArrayList.removeIf(ArrayList.java:1689)
            	at jadx.core.dex.instructions.args.SSAVar.removeUse(SSAVar.java:86)
            	at jadx.core.utils.InsnRemover.unbindArgUsage(InsnRemover.java:90)
            	at jadx.core.dex.nodes.InsnNode.replaceArg(InsnNode.java:130)
            	at jadx.core.dex.nodes.InsnNode.replaceArg(InsnNode.java:134)
            	at jadx.core.codegen.InsnGen.inlineMethod(InsnGen.java:892)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:669)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:357)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:223)
            	... 29 more
            */
        /*
            this = this;
            com.mopub.mraid.MraidController r0 = r10.f35579c
            android.content.Context r0 = 
            // error: 0x0002: INVOKE  (r0 I:android.content.Context) = (r0 I:com.mopub.mraid.MraidController) com.mopub.mraid.MraidController.k(com.mopub.mraid.MraidController):android.content.Context type: STATIC
            android.content.res.Resources r0 = r0.getResources()
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            com.mopub.mraid.MraidController r1 = r10.f35579c
            com.mopub.mraid.C r1 = r1.f35501i
            int r2 = r0.widthPixels
            int r3 = r0.heightPixels
            r1.mo37586a(r2, r3)
            r1 = 2
            int[] r1 = new int[r1]
            com.mopub.mraid.MraidController r2 = r10.f35579c
            android.view.ViewGroup r2 = r2.m38002l()
            r2.getLocationOnScreen(r1)
            com.mopub.mraid.MraidController r3 = r10.f35579c
            com.mopub.mraid.C r3 = r3.f35501i
            r4 = 0
            r5 = r1[r4]
            r6 = 1
            r7 = r1[r6]
            int r8 = r2.getWidth()
            int r9 = r2.getHeight()
            r3.mo37591c(r5, r7, r8, r9)
            com.mopub.mraid.MraidController r3 = r10.f35579c
            android.widget.FrameLayout r3 = r3.f35497e
            r3.getLocationOnScreen(r1)
            com.mopub.mraid.MraidController r3 = r10.f35579c
            com.mopub.mraid.C r3 = r3.f35501i
            r5 = r1[r4]
            r7 = r1[r6]
            com.mopub.mraid.MraidController r8 = r10.f35579c
            android.widget.FrameLayout r8 = r8.f35497e
            int r8 = r8.getWidth()
            com.mopub.mraid.MraidController r9 = r10.f35579c
            android.widget.FrameLayout r9 = r9.f35497e
            int r9 = r9.getHeight()
            r3.mo37589b(r5, r7, r8, r9)
            android.view.View r3 = r10.f35577a
            r3.getLocationOnScreen(r1)
            com.mopub.mraid.MraidController r3 = r10.f35579c
            com.mopub.mraid.C r3 = r3.f35501i
            r4 = r1[r4]
            r5 = r1[r6]
            android.view.View r6 = r10.f35577a
            int r6 = r6.getWidth()
            android.view.View r7 = r10.f35577a
            int r7 = r7.getHeight()
            r3.mo37587a(r4, r5, r6, r7)
            com.mopub.mraid.MraidController r3 = r10.f35579c
            com.mopub.mraid.MraidBridge r3 = r3.f35508p
            com.mopub.mraid.MraidController r4 = r10.f35579c
            com.mopub.mraid.C r4 = r4.f35501i
            r3.notifyScreenMetrics(r4)
            com.mopub.mraid.MraidController r3 = r10.f35579c
            com.mopub.mraid.MraidBridge r3 = r3.f35509q
            boolean r3 = r3.mo37611b()
            if (r3 == 0) goto L_0x00b0
            com.mopub.mraid.MraidController r3 = r10.f35579c
            com.mopub.mraid.MraidBridge r3 = r3.f35509q
            com.mopub.mraid.MraidController r4 = r10.f35579c
            com.mopub.mraid.C r4 = r4.f35501i
            r3.notifyScreenMetrics(r4)
        L_0x00b0:
            java.lang.Runnable r3 = r10.f35578b
            if (r3 == 0) goto L_0x00b7
            r3.run()
        L_0x00b7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.mraid.C11500q.run():void");
    }
}
