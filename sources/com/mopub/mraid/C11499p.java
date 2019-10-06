package com.mopub.mraid;

/* renamed from: com.mopub.mraid.p */
/* compiled from: MraidController */
class C11499p implements Runnable {

    /* renamed from: a */
    final /* synthetic */ MraidController f35576a;

    C11499p(MraidController this$0) {
        this.f35576a = this$0;
    }

    public void run() {
        MraidBridge i = this.f35576a.f35509q;
        boolean b = this.f35576a.f35515w.mo37682b(
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0012: INVOKE  (r2v2 'b' boolean) = (wrap: com.mopub.mraid.MraidNativeCommandHandler
              0x0008: INVOKE  (r0v2 com.mopub.mraid.MraidNativeCommandHandler) = (wrap: com.mopub.mraid.MraidController
              0x0006: IGET  (r0v1 com.mopub.mraid.MraidController) = (r7v0 'this' com.mopub.mraid.p A[THIS]) com.mopub.mraid.p.a com.mopub.mraid.MraidController) com.mopub.mraid.MraidController.l(com.mopub.mraid.MraidController):com.mopub.mraid.MraidNativeCommandHandler type: STATIC), (wrap: android.content.Context
              0x000e: INVOKE  (r2v1 android.content.Context) = (wrap: com.mopub.mraid.MraidController
              0x000c: IGET  (r2v0 com.mopub.mraid.MraidController) = (r7v0 'this' com.mopub.mraid.p A[THIS]) com.mopub.mraid.p.a com.mopub.mraid.MraidController) com.mopub.mraid.MraidController.k(com.mopub.mraid.MraidController):android.content.Context type: STATIC) com.mopub.mraid.MraidNativeCommandHandler.b(android.content.Context):boolean type: VIRTUAL in method: com.mopub.mraid.p.run():void, dex: classes3.dex
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
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000e: INVOKE  (r2v1 android.content.Context) = (wrap: com.mopub.mraid.MraidController
              0x000c: IGET  (r2v0 com.mopub.mraid.MraidController) = (r7v0 'this' com.mopub.mraid.p A[THIS]) com.mopub.mraid.p.a com.mopub.mraid.MraidController) com.mopub.mraid.MraidController.k(com.mopub.mraid.MraidController):android.content.Context type: STATIC in method: com.mopub.mraid.p.run():void, dex: classes3.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:245)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:105)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:773)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:713)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:357)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:239)
            	... 19 more
            Caused by: java.lang.ArrayIndexOutOfBoundsException: Index -1 out of bounds for length 2
            	at java.base/java.util.ArrayList.add(ArrayList.java:486)
            	at java.base/java.util.ArrayList.add(ArrayList.java:498)
            	at jadx.core.dex.instructions.args.SSAVar.use(SSAVar.java:82)
            	at jadx.core.dex.nodes.InsnNode.attachArg(InsnNode.java:87)
            	at jadx.core.dex.nodes.InsnNode.addArg(InsnNode.java:73)
            	at jadx.core.dex.nodes.InsnNode.copyCommonParams(InsnNode.java:335)
            	at jadx.core.dex.instructions.IndexInsnNode.copy(IndexInsnNode.java:24)
            	at jadx.core.dex.instructions.IndexInsnNode.copy(IndexInsnNode.java:9)
            	at jadx.core.dex.nodes.InsnNode.copyCommonParams(InsnNode.java:333)
            	at jadx.core.dex.nodes.InsnNode.copy(InsnNode.java:350)
            	at jadx.core.codegen.InsnGen.inlineMethod(InsnGen.java:880)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:669)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:357)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:223)
            	... 24 more
            */
        /*
            this = this;
            com.mopub.mraid.MraidController r0 = r7.f35576a
            com.mopub.mraid.MraidBridge r1 = r0.f35509q
            com.mopub.mraid.MraidController r0 = r7.f35576a
            com.mopub.mraid.MraidNativeCommandHandler r0 = r0.f35515w
            com.mopub.mraid.MraidController r2 = r7.f35576a
            android.content.Context r2 = 
            // error: 0x000e: INVOKE  (r2 I:android.content.Context) = (r2 I:com.mopub.mraid.MraidController) com.mopub.mraid.MraidController.k(com.mopub.mraid.MraidController):android.content.Context type: STATIC
            boolean r2 = r0.mo37682b(r2)
            com.mopub.mraid.MraidController r0 = r7.f35576a
            com.mopub.mraid.MraidNativeCommandHandler r0 = r0.f35515w
            com.mopub.mraid.MraidController r3 = r7.f35576a
            android.content.Context r3 = 
            // error: 0x001e: INVOKE  (r3 I:android.content.Context) = (r3 I:com.mopub.mraid.MraidController) com.mopub.mraid.MraidController.k(com.mopub.mraid.MraidController):android.content.Context type: STATIC
            boolean r3 = r0.mo37683c(r3)
            com.mopub.mraid.MraidController r0 = r7.f35576a
            r0.f35515w
            com.mopub.mraid.MraidController r0 = r7.f35576a
            android.content.Context r0 = 
            // error: 0x002d: INVOKE  (r0 I:android.content.Context) = (r0 I:com.mopub.mraid.MraidController) com.mopub.mraid.MraidController.k(com.mopub.mraid.MraidController):android.content.Context type: STATIC
            boolean r4 = com.mopub.mraid.MraidNativeCommandHandler.m38040a(r0)
            com.mopub.mraid.MraidController r0 = r7.f35576a
            r0.f35515w
            com.mopub.mraid.MraidController r0 = r7.f35576a
            android.content.Context r0 = 
            // error: 0x003c: INVOKE  (r0 I:android.content.Context) = (r0 I:com.mopub.mraid.MraidController) com.mopub.mraid.MraidController.k(com.mopub.mraid.MraidController):android.content.Context type: STATIC
            boolean r5 = com.mopub.mraid.MraidNativeCommandHandler.isStorePictureSupported(r0)
            com.mopub.mraid.MraidController r0 = r7.f35576a
            boolean r6 = r0.mo37655f()
            r1.mo37608a(r2, r3, r4, r5, r6)
            com.mopub.mraid.MraidController r0 = r7.f35576a
            com.mopub.mraid.MraidBridge r0 = r0.f35509q
            com.mopub.mraid.MraidController r1 = r7.f35576a
            com.mopub.mraid.ViewState r1 = r1.f35502j
            r0.mo37606a(r1)
            com.mopub.mraid.MraidController r0 = r7.f35576a
            com.mopub.mraid.MraidBridge r0 = r0.f35509q
            com.mopub.mraid.MraidController r1 = r7.f35576a
            com.mopub.mraid.PlacementType r1 = r1.f35496d
            r0.mo37605a(r1)
            com.mopub.mraid.MraidController r0 = r7.f35576a
            com.mopub.mraid.MraidBridge r0 = r0.f35509q
            com.mopub.mraid.MraidController r1 = r7.f35576a
            com.mopub.mraid.MraidBridge r1 = r1.f35509q
            boolean r1 = r1.mo37614e()
            r0.mo37607a(r1)
            com.mopub.mraid.MraidController r0 = r7.f35576a
            com.mopub.mraid.MraidBridge r0 = r0.f35509q
            r0.mo37615f()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.mraid.C11499p.run():void");
    }
}
