package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzatu extends zzfn implements zzatt {
    public zzatu() {
        super("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
    }

    /* renamed from: a */
    public static zzatt m25820a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
        if (queryLocalInterface instanceof zzatt) {
            return (zzatt) queryLocalInterface;
        }
        return new zzatv(iBinder);
    }

    /* JADX WARNING: type inference failed for: r5v1 */
    /* JADX WARNING: type inference failed for: r5v2, types: [com.google.android.gms.internal.ads.zzaub] */
    /* JADX WARNING: type inference failed for: r5v5, types: [com.google.android.gms.internal.ads.zzaud] */
    /* JADX WARNING: type inference failed for: r5v6, types: [com.google.android.gms.internal.ads.zzaub] */
    /* JADX WARNING: type inference failed for: r5v7, types: [com.google.android.gms.internal.ads.zzatw] */
    /* JADX WARNING: type inference failed for: r5v9, types: [com.google.android.gms.internal.ads.zzaty] */
    /* JADX WARNING: type inference failed for: r5v11, types: [com.google.android.gms.internal.ads.zzatw] */
    /* JADX WARNING: type inference failed for: r5v12, types: [com.google.android.gms.internal.ads.zzaue] */
    /* JADX WARNING: type inference failed for: r5v14, types: [com.google.android.gms.internal.ads.zzauf] */
    /* JADX WARNING: type inference failed for: r5v16, types: [com.google.android.gms.internal.ads.zzaue] */
    /* JADX WARNING: type inference failed for: r5v17 */
    /* JADX WARNING: type inference failed for: r5v18 */
    /* JADX WARNING: type inference failed for: r5v19 */
    /* JADX WARNING: type inference failed for: r5v20 */
    /* JADX WARNING: type inference failed for: r5v21 */
    /* JADX WARNING: type inference failed for: r5v22 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r5v1
      assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], com.google.android.gms.internal.ads.zzaty, com.google.android.gms.internal.ads.zzaud, com.google.android.gms.internal.ads.zzaub, com.google.android.gms.internal.ads.zzatw, com.google.android.gms.internal.ads.zzauf, com.google.android.gms.internal.ads.zzaue]
      uses: [com.google.android.gms.internal.ads.zzaub, com.google.android.gms.internal.ads.zzatw, com.google.android.gms.internal.ads.zzaue]
      mth insns count: 75
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
    /* JADX WARNING: Unknown variable types count: 7 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean mo29357a(int r2, android.os.Parcel r3, android.os.Parcel r4, int r5) throws android.os.RemoteException {
        /*
            r1 = this;
            r5 = 0
            switch(r2) {
                case 1: goto L_0x00bc;
                case 2: goto L_0x009a;
                case 3: goto L_0x008f;
                case 4: goto L_0x0084;
                case 5: goto L_0x0075;
                case 6: goto L_0x0052;
                case 7: goto L_0x0042;
                case 8: goto L_0x0032;
                case 9: goto L_0x0026;
                case 10: goto L_0x0012;
                case 11: goto L_0x0006;
                default: goto L_0x0004;
            }
        L_0x0004:
            r2 = 0
            return r2
        L_0x0006:
            com.google.android.gms.internal.ads.zzatq r2 = r1.mo29556xa()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzfo.m30221a(r4, r2)
            goto L_0x00e5
        L_0x0012:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.IObjectWrapper.Stub.m22186a(r2)
            boolean r3 = com.google.android.gms.internal.ads.zzfo.m30224a(r3)
            r1.mo29547a(r2, r3)
            r4.writeNoException()
            goto L_0x00e5
        L_0x0026:
            android.os.Bundle r2 = r1.getAdMetadata()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzfo.m30226b(r4, r2)
            goto L_0x00e5
        L_0x0032:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.internal.ads.zzaao r2 = com.google.android.gms.internal.ads.zzaap.m24514a(r2)
            r1.mo29548a(r2)
            r4.writeNoException()
            goto L_0x00e5
        L_0x0042:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzaum> r2 = com.google.android.gms.internal.ads.zzaum.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzfo.m30220a(r3, r2)
            com.google.android.gms.internal.ads.zzaum r2 = (com.google.android.gms.internal.ads.zzaum) r2
            r1.mo29551a(r2)
            r4.writeNoException()
            goto L_0x00e5
        L_0x0052:
            android.os.IBinder r2 = r3.readStrongBinder()
            if (r2 != 0) goto L_0x0059
            goto L_0x006c
        L_0x0059:
            java.lang.String r3 = "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdSkuListener"
            android.os.IInterface r3 = r2.queryLocalInterface(r3)
            boolean r5 = r3 instanceof com.google.android.gms.internal.ads.zzaue
            if (r5 == 0) goto L_0x0067
            r5 = r3
            com.google.android.gms.internal.ads.zzaue r5 = (com.google.android.gms.internal.ads.zzaue) r5
            goto L_0x006c
        L_0x0067:
            com.google.android.gms.internal.ads.zzauf r5 = new com.google.android.gms.internal.ads.zzauf
            r5.<init>(r2)
        L_0x006c:
            r1.mo29550a(r5)
            r4.writeNoException()
            goto L_0x00e5
        L_0x0075:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.IObjectWrapper.Stub.m22186a(r2)
            r1.mo29546C(r2)
            r4.writeNoException()
            goto L_0x00e5
        L_0x0084:
            java.lang.String r2 = r1.getMediationAdapterClassName()
            r4.writeNoException()
            r4.writeString(r2)
            goto L_0x00e5
        L_0x008f:
            boolean r2 = r1.isLoaded()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzfo.m30223a(r4, r2)
            goto L_0x00e5
        L_0x009a:
            android.os.IBinder r2 = r3.readStrongBinder()
            if (r2 != 0) goto L_0x00a1
            goto L_0x00b4
        L_0x00a1:
            java.lang.String r3 = "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback"
            android.os.IInterface r3 = r2.queryLocalInterface(r3)
            boolean r5 = r3 instanceof com.google.android.gms.internal.ads.zzatw
            if (r5 == 0) goto L_0x00af
            r5 = r3
            com.google.android.gms.internal.ads.zzatw r5 = (com.google.android.gms.internal.ads.zzatw) r5
            goto L_0x00b4
        L_0x00af:
            com.google.android.gms.internal.ads.zzaty r5 = new com.google.android.gms.internal.ads.zzaty
            r5.<init>(r2)
        L_0x00b4:
            r1.mo29549a(r5)
            r4.writeNoException()
            goto L_0x00e5
        L_0x00bc:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzxz> r2 = com.google.android.gms.internal.ads.zzxz.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzfo.m30220a(r3, r2)
            com.google.android.gms.internal.ads.zzxz r2 = (com.google.android.gms.internal.ads.zzxz) r2
            android.os.IBinder r3 = r3.readStrongBinder()
            if (r3 != 0) goto L_0x00cb
            goto L_0x00dd
        L_0x00cb:
            java.lang.String r5 = "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback"
            android.os.IInterface r5 = r3.queryLocalInterface(r5)
            boolean r0 = r5 instanceof com.google.android.gms.internal.ads.zzaub
            if (r0 == 0) goto L_0x00d8
            com.google.android.gms.internal.ads.zzaub r5 = (com.google.android.gms.internal.ads.zzaub) r5
            goto L_0x00dd
        L_0x00d8:
            com.google.android.gms.internal.ads.zzaud r5 = new com.google.android.gms.internal.ads.zzaud
            r5.<init>(r3)
        L_0x00dd:
            r1.mo29552a(r2, r5)
            r4.writeNoException()
        L_0x00e5:
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzatu.mo29357a(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
