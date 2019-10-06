package com.google.android.gms.internal.ads;

public abstract class zzzg extends zzfn implements zzzf {
    public zzzg() {
        super("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    /* JADX WARNING: type inference failed for: r4v1 */
    /* JADX WARNING: type inference failed for: r4v2, types: [com.google.android.gms.internal.ads.zzyz] */
    /* JADX WARNING: type inference failed for: r4v4, types: [com.google.android.gms.internal.ads.zzzb] */
    /* JADX WARNING: type inference failed for: r4v6, types: [com.google.android.gms.internal.ads.zzyz] */
    /* JADX WARNING: type inference failed for: r4v9, types: [com.google.android.gms.internal.ads.zzzy] */
    /* JADX WARNING: type inference failed for: r4v11, types: [com.google.android.gms.internal.ads.zzaaa] */
    /* JADX WARNING: type inference failed for: r4v13, types: [com.google.android.gms.internal.ads.zzzy] */
    /* JADX WARNING: type inference failed for: r4v15 */
    /* JADX WARNING: type inference failed for: r4v16 */
    /* JADX WARNING: type inference failed for: r4v17 */
    /* JADX WARNING: type inference failed for: r4v18 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r4v1
      assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], com.google.android.gms.internal.ads.zzaaa, com.google.android.gms.internal.ads.zzzb, com.google.android.gms.internal.ads.zzyz, com.google.android.gms.internal.ads.zzzy]
      uses: [com.google.android.gms.internal.ads.zzyz, com.google.android.gms.internal.ads.zzzy]
      mth insns count: 78
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
    public final boolean mo29357a(int r1, android.os.Parcel r2, android.os.Parcel r3, int r4) throws android.os.RemoteException {
        /*
            r0 = this;
            r4 = 0
            switch(r1) {
                case 1: goto L_0x00eb;
                case 2: goto L_0x00c9;
                case 3: goto L_0x00ba;
                case 4: goto L_0x00ab;
                case 5: goto L_0x0090;
                case 6: goto L_0x0081;
                case 7: goto L_0x005e;
                case 8: goto L_0x0046;
                case 9: goto L_0x0036;
                case 10: goto L_0x0026;
                case 11: goto L_0x0004;
                case 12: goto L_0x0004;
                case 13: goto L_0x0016;
                case 14: goto L_0x0006;
                default: goto L_0x0004;
            }
        L_0x0004:
            r1 = 0
            return r1
        L_0x0006:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzaje r1 = com.google.android.gms.internal.ads.zzajf.m25099a(r1)
            r0.mo29498a(r1)
            r3.writeNoException()
            goto L_0x00f6
        L_0x0016:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzaiy> r1 = com.google.android.gms.internal.ads.zzaiy.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.ads.zzfo.m30220a(r2, r1)
            com.google.android.gms.internal.ads.zzaiy r1 = (com.google.android.gms.internal.ads.zzaiy) r1
            r0.mo29497a(r1)
            r3.writeNoException()
            goto L_0x00f6
        L_0x0026:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzafx r1 = com.google.android.gms.internal.ads.zzafy.m24963a(r1)
            r0.mo29496a(r1)
            r3.writeNoException()
            goto L_0x00f6
        L_0x0036:
            android.os.Parcelable$Creator<com.google.android.gms.ads.formats.PublisherAdViewOptions> r1 = com.google.android.gms.ads.formats.PublisherAdViewOptions.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.ads.zzfo.m30220a(r2, r1)
            com.google.android.gms.ads.formats.PublisherAdViewOptions r1 = (com.google.android.gms.ads.formats.PublisherAdViewOptions) r1
            r0.mo29491a(r1)
            r3.writeNoException()
            goto L_0x00f6
        L_0x0046:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzafu r1 = com.google.android.gms.internal.ads.zzafv.m24959a(r1)
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzyd> r4 = com.google.android.gms.internal.ads.zzyd.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzfo.m30220a(r2, r4)
            com.google.android.gms.internal.ads.zzyd r2 = (com.google.android.gms.internal.ads.zzyd) r2
            r0.mo29495a(r1, r2)
            r3.writeNoException()
            goto L_0x00f6
        L_0x005e:
            android.os.IBinder r1 = r2.readStrongBinder()
            if (r1 != 0) goto L_0x0065
            goto L_0x0078
        L_0x0065:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.ICorrelationIdProvider"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.ads.zzzy
            if (r4 == 0) goto L_0x0073
            r4 = r2
            com.google.android.gms.internal.ads.zzzy r4 = (com.google.android.gms.internal.ads.zzzy) r4
            goto L_0x0078
        L_0x0073:
            com.google.android.gms.internal.ads.zzaaa r4 = new com.google.android.gms.internal.ads.zzaaa
            r4.<init>(r1)
        L_0x0078:
            r0.mo29501b(r4)
            r3.writeNoException()
            goto L_0x00f6
        L_0x0081:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzady> r1 = com.google.android.gms.internal.ads.zzady.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.ads.zzfo.m30220a(r2, r1)
            com.google.android.gms.internal.ads.zzady r1 = (com.google.android.gms.internal.ads.zzady) r1
            r0.mo29492a(r1)
            r3.writeNoException()
            goto L_0x00f6
        L_0x0090:
            java.lang.String r1 = r2.readString()
            android.os.IBinder r4 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzafr r4 = com.google.android.gms.internal.ads.zzafs.m24955a(r4)
            android.os.IBinder r2 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzafo r2 = com.google.android.gms.internal.ads.zzafp.m24951a(r2)
            r0.mo29499a(r1, r4, r2)
            r3.writeNoException()
            goto L_0x00f6
        L_0x00ab:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzafl r1 = com.google.android.gms.internal.ads.zzafm.m24947a(r1)
            r0.mo29494a(r1)
            r3.writeNoException()
            goto L_0x00f6
        L_0x00ba:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzafi r1 = com.google.android.gms.internal.ads.zzafj.m24943a(r1)
            r0.mo29493a(r1)
            r3.writeNoException()
            goto L_0x00f6
        L_0x00c9:
            android.os.IBinder r1 = r2.readStrongBinder()
            if (r1 != 0) goto L_0x00d0
            goto L_0x00e3
        L_0x00d0:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAdListener"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.ads.zzyz
            if (r4 == 0) goto L_0x00de
            r4 = r2
            com.google.android.gms.internal.ads.zzyz r4 = (com.google.android.gms.internal.ads.zzyz) r4
            goto L_0x00e3
        L_0x00de:
            com.google.android.gms.internal.ads.zzzb r4 = new com.google.android.gms.internal.ads.zzzb
            r4.<init>(r1)
        L_0x00e3:
            r0.mo29500b(r4)
            r3.writeNoException()
            goto L_0x00f6
        L_0x00eb:
            com.google.android.gms.internal.ads.zzzc r1 = r0.mo29490Fa()
            r3.writeNoException()
            com.google.android.gms.internal.ads.zzfo.m30221a(r3, r1)
        L_0x00f6:
            r1 = 1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzzg.mo29357a(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
