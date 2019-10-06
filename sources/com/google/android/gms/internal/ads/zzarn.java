package com.google.android.gms.internal.ads;

public abstract class zzarn extends zzfn implements zzarm {
    public zzarn() {
        super("com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [com.google.android.gms.internal.ads.zzarp] */
    /* JADX WARNING: type inference failed for: r1v3, types: [com.google.android.gms.internal.ads.zzarq] */
    /* JADX WARNING: type inference failed for: r1v5, types: [com.google.android.gms.internal.ads.zzarp] */
    /* JADX WARNING: type inference failed for: r1v6, types: [com.google.android.gms.internal.ads.zzarr] */
    /* JADX WARNING: type inference failed for: r1v8, types: [com.google.android.gms.internal.ads.zzart] */
    /* JADX WARNING: type inference failed for: r1v10, types: [com.google.android.gms.internal.ads.zzarr] */
    /* JADX WARNING: type inference failed for: r1v11, types: [com.google.android.gms.internal.ads.zzarr] */
    /* JADX WARNING: type inference failed for: r1v13, types: [com.google.android.gms.internal.ads.zzart] */
    /* JADX WARNING: type inference failed for: r1v15, types: [com.google.android.gms.internal.ads.zzarr] */
    /* JADX WARNING: type inference failed for: r1v16 */
    /* JADX WARNING: type inference failed for: r1v17 */
    /* JADX WARNING: type inference failed for: r1v18 */
    /* JADX WARNING: type inference failed for: r1v19 */
    /* JADX WARNING: type inference failed for: r1v20 */
    /* JADX WARNING: type inference failed for: r1v21 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r1v0
      assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], com.google.android.gms.internal.ads.zzart, com.google.android.gms.internal.ads.zzarq, com.google.android.gms.internal.ads.zzarp, com.google.android.gms.internal.ads.zzarr]
      uses: [com.google.android.gms.internal.ads.zzarp, com.google.android.gms.internal.ads.zzarr]
      mth insns count: 60
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
    /* JADX WARNING: Unknown variable types count: 7 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean mo29357a(int r4, android.os.Parcel r5, android.os.Parcel r6, int r7) throws android.os.RemoteException {
        /*
            r3 = this;
            r7 = 1
            if (r4 == r7) goto L_0x008b
            r0 = 2
            r1 = 0
            if (r4 == r0) goto L_0x0061
            r0 = 4
            java.lang.String r2 = "com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener"
            if (r4 == r0) goto L_0x0039
            r0 = 5
            if (r4 == r0) goto L_0x0011
            r4 = 0
            return r4
        L_0x0011:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzarx> r4 = com.google.android.gms.internal.ads.zzarx.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.ads.zzfo.m30220a(r5, r4)
            com.google.android.gms.internal.ads.zzarx r4 = (com.google.android.gms.internal.ads.zzarx) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x0020
            goto L_0x0031
        L_0x0020:
            android.os.IInterface r0 = r5.queryLocalInterface(r2)
            boolean r1 = r0 instanceof com.google.android.gms.internal.ads.zzarr
            if (r1 == 0) goto L_0x002c
            r1 = r0
            com.google.android.gms.internal.ads.zzarr r1 = (com.google.android.gms.internal.ads.zzarr) r1
            goto L_0x0031
        L_0x002c:
            com.google.android.gms.internal.ads.zzart r1 = new com.google.android.gms.internal.ads.zzart
            r1.<init>(r5)
        L_0x0031:
            r3.mo30024b(r4, r1)
            r6.writeNoException()
            goto L_0x009e
        L_0x0039:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzarx> r4 = com.google.android.gms.internal.ads.zzarx.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.ads.zzfo.m30220a(r5, r4)
            com.google.android.gms.internal.ads.zzarx r4 = (com.google.android.gms.internal.ads.zzarx) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x0048
            goto L_0x0059
        L_0x0048:
            android.os.IInterface r0 = r5.queryLocalInterface(r2)
            boolean r1 = r0 instanceof com.google.android.gms.internal.ads.zzarr
            if (r1 == 0) goto L_0x0054
            r1 = r0
            com.google.android.gms.internal.ads.zzarr r1 = (com.google.android.gms.internal.ads.zzarr) r1
            goto L_0x0059
        L_0x0054:
            com.google.android.gms.internal.ads.zzart r1 = new com.google.android.gms.internal.ads.zzart
            r1.<init>(r5)
        L_0x0059:
            r3.mo30023a(r4, r1)
            r6.writeNoException()
            goto L_0x009e
        L_0x0061:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzarg> r4 = com.google.android.gms.internal.ads.zzarg.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.ads.zzfo.m30220a(r5, r4)
            com.google.android.gms.internal.ads.zzarg r4 = (com.google.android.gms.internal.ads.zzarg) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x0070
            goto L_0x0083
        L_0x0070:
            java.lang.String r0 = "com.google.android.gms.ads.internal.request.IAdResponseListener"
            android.os.IInterface r0 = r5.queryLocalInterface(r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.ads.zzarp
            if (r1 == 0) goto L_0x007e
            r1 = r0
            com.google.android.gms.internal.ads.zzarp r1 = (com.google.android.gms.internal.ads.zzarp) r1
            goto L_0x0083
        L_0x007e:
            com.google.android.gms.internal.ads.zzarq r1 = new com.google.android.gms.internal.ads.zzarq
            r1.<init>(r5)
        L_0x0083:
            r3.mo30022a(r4, r1)
            r6.writeNoException()
            goto L_0x009e
        L_0x008b:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzarg> r4 = com.google.android.gms.internal.ads.zzarg.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.ads.zzfo.m30220a(r5, r4)
            com.google.android.gms.internal.ads.zzarg r4 = (com.google.android.gms.internal.ads.zzarg) r4
            com.google.android.gms.internal.ads.zzari r4 = r3.mo30021a(r4)
            r6.writeNoException()
            com.google.android.gms.internal.ads.zzfo.m30226b(r6, r4)
        L_0x009e:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzarn.mo29357a(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
