package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzasx extends zzfn implements zzasw {
    public zzasx() {
        super("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
    }

    /* renamed from: a */
    public static zzasw m25760a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
        if (queryLocalInterface instanceof zzasw) {
            return (zzasw) queryLocalInterface;
        }
        return new zzasy(iBinder);
    }

    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [com.google.android.gms.internal.ads.zzatb] */
    /* JADX WARNING: type inference failed for: r1v2, types: [com.google.android.gms.internal.ads.zzatd] */
    /* JADX WARNING: type inference failed for: r1v4, types: [com.google.android.gms.internal.ads.zzatb] */
    /* JADX WARNING: type inference failed for: r1v5, types: [com.google.android.gms.internal.ads.zzasu] */
    /* JADX WARNING: type inference failed for: r1v6, types: [com.google.android.gms.internal.ads.zzasv] */
    /* JADX WARNING: type inference failed for: r1v8, types: [com.google.android.gms.internal.ads.zzasu] */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v11 */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r1v0
      assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], com.google.android.gms.internal.ads.zzasv, com.google.android.gms.internal.ads.zzatd, com.google.android.gms.internal.ads.zzatb, com.google.android.gms.internal.ads.zzasu]
      uses: [com.google.android.gms.internal.ads.zzatb, com.google.android.gms.internal.ads.zzasu]
      mth insns count: 88
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
    public final boolean mo29357a(int r3, android.os.Parcel r4, android.os.Parcel r5, int r6) throws android.os.RemoteException {
        /*
            r2 = this;
            r6 = 1
            if (r3 == r6) goto L_0x0115
            r0 = 2
            if (r3 == r0) goto L_0x010e
            r0 = 3
            r1 = 0
            if (r3 == r0) goto L_0x00ec
            r0 = 34
            if (r3 == r0) goto L_0x00e1
            switch(r3) {
                case 5: goto L_0x00d6;
                case 6: goto L_0x00cf;
                case 7: goto L_0x00c8;
                case 8: goto L_0x00c1;
                case 9: goto L_0x00b2;
                case 10: goto L_0x00a2;
                case 11: goto L_0x0092;
                case 12: goto L_0x0086;
                case 13: goto L_0x007a;
                case 14: goto L_0x006a;
                case 15: goto L_0x005e;
                case 16: goto L_0x003b;
                case 17: goto L_0x002f;
                case 18: goto L_0x001f;
                case 19: goto L_0x0013;
                default: goto L_0x0011;
            }
        L_0x0011:
            r3 = 0
            return r3
        L_0x0013:
            java.lang.String r3 = r4.readString()
            r2.setCustomData(r3)
            r5.writeNoException()
            goto L_0x0124
        L_0x001f:
            android.os.IBinder r3 = r4.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.IObjectWrapper.Stub.m22186a(r3)
            r2.mo29557A(r3)
            r5.writeNoException()
            goto L_0x0124
        L_0x002f:
            java.lang.String r3 = r4.readString()
            r2.mo29568h(r3)
            r5.writeNoException()
            goto L_0x0124
        L_0x003b:
            android.os.IBinder r3 = r4.readStrongBinder()
            if (r3 != 0) goto L_0x0042
            goto L_0x0055
        L_0x0042:
            java.lang.String r4 = "com.google.android.gms.ads.internal.reward.client.IRewardedAdSkuListener"
            android.os.IInterface r4 = r3.queryLocalInterface(r4)
            boolean r0 = r4 instanceof com.google.android.gms.internal.ads.zzasu
            if (r0 == 0) goto L_0x0050
            r1 = r4
            com.google.android.gms.internal.ads.zzasu r1 = (com.google.android.gms.internal.ads.zzasu) r1
            goto L_0x0055
        L_0x0050:
            com.google.android.gms.internal.ads.zzasv r1 = new com.google.android.gms.internal.ads.zzasv
            r1.<init>(r3)
        L_0x0055:
            r2.mo29560a(r1)
            r5.writeNoException()
            goto L_0x0124
        L_0x005e:
            android.os.Bundle r3 = r2.getAdMetadata()
            r5.writeNoException()
            com.google.android.gms.internal.ads.zzfo.m30226b(r5, r3)
            goto L_0x0124
        L_0x006a:
            android.os.IBinder r3 = r4.readStrongBinder()
            com.google.android.gms.internal.ads.zzzp r3 = com.google.android.gms.internal.ads.zzzq.m31626a(r3)
            r2.mo29563a(r3)
            r5.writeNoException()
            goto L_0x0124
        L_0x007a:
            java.lang.String r3 = r4.readString()
            r2.setUserId(r3)
            r5.writeNoException()
            goto L_0x0124
        L_0x0086:
            java.lang.String r3 = r2.getMediationAdapterClassName()
            r5.writeNoException()
            r5.writeString(r3)
            goto L_0x0124
        L_0x0092:
            android.os.IBinder r3 = r4.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.IObjectWrapper.Stub.m22186a(r3)
            r2.mo29567h(r3)
            r5.writeNoException()
            goto L_0x0124
        L_0x00a2:
            android.os.IBinder r3 = r4.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.IObjectWrapper.Stub.m22186a(r3)
            r2.mo29558D(r3)
            r5.writeNoException()
            goto L_0x0124
        L_0x00b2:
            android.os.IBinder r3 = r4.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.IObjectWrapper.Stub.m22186a(r3)
            r2.mo29559G(r3)
            r5.writeNoException()
            goto L_0x0124
        L_0x00c1:
            r2.destroy()
            r5.writeNoException()
            goto L_0x0124
        L_0x00c8:
            r2.resume()
            r5.writeNoException()
            goto L_0x0124
        L_0x00cf:
            r2.pause()
            r5.writeNoException()
            goto L_0x0124
        L_0x00d6:
            boolean r3 = r2.isLoaded()
            r5.writeNoException()
            com.google.android.gms.internal.ads.zzfo.m30223a(r5, r3)
            goto L_0x0124
        L_0x00e1:
            boolean r3 = com.google.android.gms.internal.ads.zzfo.m30224a(r4)
            r2.setImmersiveMode(r3)
            r5.writeNoException()
            goto L_0x0124
        L_0x00ec:
            android.os.IBinder r3 = r4.readStrongBinder()
            if (r3 != 0) goto L_0x00f3
            goto L_0x0106
        L_0x00f3:
            java.lang.String r4 = "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener"
            android.os.IInterface r4 = r3.queryLocalInterface(r4)
            boolean r0 = r4 instanceof com.google.android.gms.internal.ads.zzatb
            if (r0 == 0) goto L_0x0101
            r1 = r4
            com.google.android.gms.internal.ads.zzatb r1 = (com.google.android.gms.internal.ads.zzatb) r1
            goto L_0x0106
        L_0x0101:
            com.google.android.gms.internal.ads.zzatd r1 = new com.google.android.gms.internal.ads.zzatd
            r1.<init>(r3)
        L_0x0106:
            r2.mo29561a(r1)
            r5.writeNoException()
            goto L_0x0124
        L_0x010e:
            r2.show()
            r5.writeNoException()
            goto L_0x0124
        L_0x0115:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzath> r3 = com.google.android.gms.internal.ads.zzath.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.ads.zzfo.m30220a(r4, r3)
            com.google.android.gms.internal.ads.zzath r3 = (com.google.android.gms.internal.ads.zzath) r3
            r2.mo29562a(r3)
            r5.writeNoException()
        L_0x0124:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzasx.mo29357a(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
