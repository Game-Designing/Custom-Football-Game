package com.ironsource.sdk.controller;

import com.ironsource.sdk.controller.C10877y.C10880c;

/* renamed from: com.ironsource.sdk.controller.B */
/* compiled from: IronSourceWebView */
class C10812B implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f32984a;

    /* renamed from: b */
    final /* synthetic */ String f32985b;

    /* renamed from: c */
    final /* synthetic */ C10880c f32986c;

    C10812B(C10880c this$1, String str, String str2) {
        this.f32986c = this$1;
        this.f32984a = str;
        this.f32985b = str2;
    }

    public void run() {
        String toSend = this.f32984a;
        if (toSend == null) {
            toSend = "We're sorry, some error occurred. we will investigate it";
        }
        String z = 
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000a: INVOKE  (r1v2 'z' java.lang.String) = (wrap: com.ironsource.sdk.controller.y
              0x0008: IGET  (r1v1 com.ironsource.sdk.controller.y) = (wrap: com.ironsource.sdk.controller.y$c
              0x0006: IGET  (r1v0 com.ironsource.sdk.controller.y$c) = (r4v0 'this' com.ironsource.sdk.controller.B A[THIS]) com.ironsource.sdk.controller.B.c com.ironsource.sdk.controller.y$c) com.ironsource.sdk.controller.y.c.b com.ironsource.sdk.controller.y) com.ironsource.sdk.controller.y.z(com.ironsource.sdk.controller.y):java.lang.String type: STATIC in method: com.ironsource.sdk.controller.B.run():void, dex: classes3.dex
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
            Caused by: java.lang.ArrayIndexOutOfBoundsException: arraycopy: length -1 is negative
            	at java.base/java.lang.System.arraycopy(Native Method)
            	at java.base/java.util.ArrayList.shiftTailOverGap(ArrayList.java:777)
            	at java.base/java.util.ArrayList.removeIf(ArrayList.java:1720)
            	at java.base/java.util.ArrayList.removeIf(ArrayList.java:1689)
            	at jadx.core.dex.instructions.args.SSAVar.removeUse(SSAVar.java:86)
            	at jadx.core.utils.InsnRemover.unbindArgUsage(InsnRemover.java:90)
            	at jadx.core.dex.nodes.InsnNode.replaceArg(InsnNode.java:130)
            	at jadx.core.dex.nodes.InsnNode.replaceArg(InsnNode.java:134)
            	at jadx.core.codegen.InsnGen.inlineMethod(InsnGen.java:892)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:669)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:357)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:239)
            	... 19 more
            */
        /*
            this = this;
            java.lang.String r0 = r4.f32984a
            if (r0 != 0) goto L_0x0006
            java.lang.String r0 = "We're sorry, some error occurred. we will investigate it"
        L_0x0006:
            com.ironsource.sdk.controller.y$c r1 = r4.f32986c
            com.ironsource.sdk.controller.y r1 = com.ironsource.sdk.controller.C10877y.this
            java.lang.String r1 = r1.f33192o
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "onInterstitialInitFail(message:"
            r2.append(r3)
            r2.append(r0)
            java.lang.String r3 = ")"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            android.util.Log.d(r1, r2)
            com.ironsource.sdk.controller.y$c r1 = r4.f32986c
            com.ironsource.sdk.controller.y r1 = com.ironsource.sdk.controller.C10877y.this
            d.h.d.f.a.c r1 = r1.f33172P
            com.ironsource.sdk.data.h r2 = com.ironsource.sdk.data.C10895h.Interstitial
            java.lang.String r3 = r4.f32985b
            r1.mo41826a(r2, r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.controller.C10812B.run():void");
    }
}
