package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzzl extends zzfn implements zzzk {
    public zzzl() {
        super("com.google.android.gms.ads.internal.client.IAdManager");
    }

    /* renamed from: a */
    public static zzzk m31603a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
        if (queryLocalInterface instanceof zzzk) {
            return (zzzk) queryLocalInterface;
        }
        return new zzzm(iBinder);
    }

    /* JADX WARNING: type inference failed for: r4v1 */
    /* JADX WARNING: type inference failed for: r4v2, types: [com.google.android.gms.internal.ads.zzyz] */
    /* JADX WARNING: type inference failed for: r4v4, types: [com.google.android.gms.internal.ads.zzzb] */
    /* JADX WARNING: type inference failed for: r4v6, types: [com.google.android.gms.internal.ads.zzyz] */
    /* JADX WARNING: type inference failed for: r4v7, types: [com.google.android.gms.internal.ads.zzzs] */
    /* JADX WARNING: type inference failed for: r4v9, types: [com.google.android.gms.internal.ads.zzzu] */
    /* JADX WARNING: type inference failed for: r4v11, types: [com.google.android.gms.internal.ads.zzzs] */
    /* JADX WARNING: type inference failed for: r4v12, types: [com.google.android.gms.internal.ads.zzyw] */
    /* JADX WARNING: type inference failed for: r4v14, types: [com.google.android.gms.internal.ads.zzyy] */
    /* JADX WARNING: type inference failed for: r4v16, types: [com.google.android.gms.internal.ads.zzyw] */
    /* JADX WARNING: type inference failed for: r4v17, types: [com.google.android.gms.internal.ads.zzzy] */
    /* JADX WARNING: type inference failed for: r4v19, types: [com.google.android.gms.internal.ads.zzaaa] */
    /* JADX WARNING: type inference failed for: r4v21, types: [com.google.android.gms.internal.ads.zzzy] */
    /* JADX WARNING: type inference failed for: r4v22, types: [com.google.android.gms.internal.ads.zzzp] */
    /* JADX WARNING: type inference failed for: r4v24, types: [com.google.android.gms.internal.ads.zzzr] */
    /* JADX WARNING: type inference failed for: r4v26, types: [com.google.android.gms.internal.ads.zzzp] */
    /* JADX WARNING: type inference failed for: r4v27 */
    /* JADX WARNING: type inference failed for: r4v28 */
    /* JADX WARNING: type inference failed for: r4v29 */
    /* JADX WARNING: type inference failed for: r4v30 */
    /* JADX WARNING: type inference failed for: r4v31 */
    /* JADX WARNING: type inference failed for: r4v32 */
    /* JADX WARNING: type inference failed for: r4v33 */
    /* JADX WARNING: type inference failed for: r4v34 */
    /* JADX WARNING: type inference failed for: r4v35 */
    /* JADX WARNING: type inference failed for: r4v36 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r4v1
      assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], com.google.android.gms.internal.ads.zzzu, com.google.android.gms.internal.ads.zzzb, com.google.android.gms.internal.ads.zzyz, com.google.android.gms.internal.ads.zzzs, com.google.android.gms.internal.ads.zzyy, com.google.android.gms.internal.ads.zzyw, com.google.android.gms.internal.ads.zzaaa, com.google.android.gms.internal.ads.zzzy, com.google.android.gms.internal.ads.zzzr, com.google.android.gms.internal.ads.zzzp]
      uses: [com.google.android.gms.internal.ads.zzyz, com.google.android.gms.internal.ads.zzzs, com.google.android.gms.internal.ads.zzyw, com.google.android.gms.internal.ads.zzzy, com.google.android.gms.internal.ads.zzzp]
      mth insns count: 164
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
    /* JADX WARNING: Unknown variable types count: 11 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean mo29357a(int r1, android.os.Parcel r2, android.os.Parcel r3, int r4) throws android.os.RemoteException {
        /*
            r0 = this;
            r4 = 0
            switch(r1) {
                case 1: goto L_0x020e;
                case 2: goto L_0x0207;
                case 3: goto L_0x01fc;
                case 4: goto L_0x01e9;
                case 5: goto L_0x01e2;
                case 6: goto L_0x01db;
                case 7: goto L_0x01b9;
                case 8: goto L_0x0197;
                case 9: goto L_0x018f;
                case 10: goto L_0x0187;
                case 11: goto L_0x017f;
                case 12: goto L_0x0173;
                case 13: goto L_0x0163;
                case 14: goto L_0x0153;
                case 15: goto L_0x013f;
                case 16: goto L_0x0004;
                case 17: goto L_0x0004;
                case 18: goto L_0x0133;
                case 19: goto L_0x0123;
                case 20: goto L_0x0100;
                case 21: goto L_0x00dd;
                case 22: goto L_0x00d1;
                case 23: goto L_0x00c5;
                case 24: goto L_0x00b5;
                case 25: goto L_0x00a9;
                case 26: goto L_0x009d;
                case 27: goto L_0x0004;
                case 28: goto L_0x0004;
                case 29: goto L_0x008d;
                case 30: goto L_0x007d;
                case 31: goto L_0x0071;
                case 32: goto L_0x0065;
                case 33: goto L_0x0059;
                case 34: goto L_0x004d;
                case 35: goto L_0x0041;
                case 36: goto L_0x001e;
                case 37: goto L_0x0012;
                case 38: goto L_0x0006;
                default: goto L_0x0004;
            }
        L_0x0004:
            r1 = 0
            return r1
        L_0x0006:
            java.lang.String r1 = r2.readString()
            r0.mo29525e(r1)
            r3.writeNoException()
            goto L_0x0219
        L_0x0012:
            android.os.Bundle r1 = r0.getAdMetadata()
            r3.writeNoException()
            com.google.android.gms.internal.ads.zzfo.m30226b(r3, r1)
            goto L_0x0219
        L_0x001e:
            android.os.IBinder r1 = r2.readStrongBinder()
            if (r1 != 0) goto L_0x0025
            goto L_0x0038
        L_0x0025:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAdMetadataListener"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.ads.zzzp
            if (r4 == 0) goto L_0x0033
            r4 = r2
            com.google.android.gms.internal.ads.zzzp r4 = (com.google.android.gms.internal.ads.zzzp) r4
            goto L_0x0038
        L_0x0033:
            com.google.android.gms.internal.ads.zzzr r4 = new com.google.android.gms.internal.ads.zzzr
            r4.<init>(r1)
        L_0x0038:
            r0.mo29518a(r4)
            r3.writeNoException()
            goto L_0x0219
        L_0x0041:
            java.lang.String r1 = r0.mo29505L()
            r3.writeNoException()
            r3.writeString(r1)
            goto L_0x0219
        L_0x004d:
            boolean r1 = com.google.android.gms.internal.ads.zzfo.m30224a(r2)
            r0.setImmersiveMode(r1)
            r3.writeNoException()
            goto L_0x0219
        L_0x0059:
            com.google.android.gms.internal.ads.zzyz r1 = r0.mo29507Ya()
            r3.writeNoException()
            com.google.android.gms.internal.ads.zzfo.m30221a(r3, r1)
            goto L_0x0219
        L_0x0065:
            com.google.android.gms.internal.ads.zzzs r1 = r0.mo29506Ta()
            r3.writeNoException()
            com.google.android.gms.internal.ads.zzfo.m30221a(r3, r1)
            goto L_0x0219
        L_0x0071:
            java.lang.String r1 = r0.mo29522cb()
            r3.writeNoException()
            r3.writeString(r1)
            goto L_0x0219
        L_0x007d:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzaax> r1 = com.google.android.gms.internal.ads.zzaax.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.ads.zzfo.m30220a(r2, r1)
            com.google.android.gms.internal.ads.zzaax r1 = (com.google.android.gms.internal.ads.zzaax) r1
            r0.mo29509a(r1)
            r3.writeNoException()
            goto L_0x0219
        L_0x008d:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzacd> r1 = com.google.android.gms.internal.ads.zzacd.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.ads.zzfo.m30220a(r2, r1)
            com.google.android.gms.internal.ads.zzacd r1 = (com.google.android.gms.internal.ads.zzacd) r1
            r0.mo29510a(r1)
            r3.writeNoException()
            goto L_0x0219
        L_0x009d:
            com.google.android.gms.internal.ads.zzaar r1 = r0.getVideoController()
            r3.writeNoException()
            com.google.android.gms.internal.ads.zzfo.m30221a(r3, r1)
            goto L_0x0219
        L_0x00a9:
            java.lang.String r1 = r2.readString()
            r0.setUserId(r1)
            r3.writeNoException()
            goto L_0x0219
        L_0x00b5:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzatb r1 = com.google.android.gms.internal.ads.zzatc.m25776a(r1)
            r0.mo29514a(r1)
            r3.writeNoException()
            goto L_0x0219
        L_0x00c5:
            boolean r1 = r0.mo29503I()
            r3.writeNoException()
            com.google.android.gms.internal.ads.zzfo.m30223a(r3, r1)
            goto L_0x0219
        L_0x00d1:
            boolean r1 = com.google.android.gms.internal.ads.zzfo.m30224a(r2)
            r0.mo29530m(r1)
            r3.writeNoException()
            goto L_0x0219
        L_0x00dd:
            android.os.IBinder r1 = r2.readStrongBinder()
            if (r1 != 0) goto L_0x00e4
            goto L_0x00f7
        L_0x00e4:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.ICorrelationIdProvider"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.ads.zzzy
            if (r4 == 0) goto L_0x00f2
            r4 = r2
            com.google.android.gms.internal.ads.zzzy r4 = (com.google.android.gms.internal.ads.zzzy) r4
            goto L_0x00f7
        L_0x00f2:
            com.google.android.gms.internal.ads.zzaaa r4 = new com.google.android.gms.internal.ads.zzaaa
            r4.<init>(r1)
        L_0x00f7:
            r0.mo29520a(r4)
            r3.writeNoException()
            goto L_0x0219
        L_0x0100:
            android.os.IBinder r1 = r2.readStrongBinder()
            if (r1 != 0) goto L_0x0107
            goto L_0x011a
        L_0x0107:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAdClickListener"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.ads.zzyw
            if (r4 == 0) goto L_0x0115
            r4 = r2
            com.google.android.gms.internal.ads.zzyw r4 = (com.google.android.gms.internal.ads.zzyw) r4
            goto L_0x011a
        L_0x0115:
            com.google.android.gms.internal.ads.zzyy r4 = new com.google.android.gms.internal.ads.zzyy
            r4.<init>(r1)
        L_0x011a:
            r0.mo29516a(r4)
            r3.writeNoException()
            goto L_0x0219
        L_0x0123:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzado r1 = com.google.android.gms.internal.ads.zzadp.m24821a(r1)
            r0.mo29511a(r1)
            r3.writeNoException()
            goto L_0x0219
        L_0x0133:
            java.lang.String r1 = r0.getMediationAdapterClassName()
            r3.writeNoException()
            r3.writeString(r1)
            goto L_0x0219
        L_0x013f:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzaqt r1 = com.google.android.gms.internal.ads.zzaqu.m25682a(r1)
            java.lang.String r2 = r2.readString()
            r0.mo29513a(r1, r2)
            r3.writeNoException()
            goto L_0x0219
        L_0x0153:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzaqn r1 = com.google.android.gms.internal.ads.zzaqo.m25681a(r1)
            r0.mo29512a(r1)
            r3.writeNoException()
            goto L_0x0219
        L_0x0163:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzyd> r1 = com.google.android.gms.internal.ads.zzyd.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.ads.zzfo.m30220a(r2, r1)
            com.google.android.gms.internal.ads.zzyd r1 = (com.google.android.gms.internal.ads.zzyd) r1
            r0.mo29515a(r1)
            r3.writeNoException()
            goto L_0x0219
        L_0x0173:
            com.google.android.gms.internal.ads.zzyd r1 = r0.mo29508Za()
            r3.writeNoException()
            com.google.android.gms.internal.ads.zzfo.m30226b(r3, r1)
            goto L_0x0219
        L_0x017f:
            r0.mo29523db()
            r3.writeNoException()
            goto L_0x0219
        L_0x0187:
            r0.mo29504Ka()
            r3.writeNoException()
            goto L_0x0219
        L_0x018f:
            r0.showInterstitial()
            r3.writeNoException()
            goto L_0x0219
        L_0x0197:
            android.os.IBinder r1 = r2.readStrongBinder()
            if (r1 != 0) goto L_0x019e
            goto L_0x01b1
        L_0x019e:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAppEventListener"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.ads.zzzs
            if (r4 == 0) goto L_0x01ac
            r4 = r2
            com.google.android.gms.internal.ads.zzzs r4 = (com.google.android.gms.internal.ads.zzzs) r4
            goto L_0x01b1
        L_0x01ac:
            com.google.android.gms.internal.ads.zzzu r4 = new com.google.android.gms.internal.ads.zzzu
            r4.<init>(r1)
        L_0x01b1:
            r0.mo29519a(r4)
            r3.writeNoException()
            goto L_0x0219
        L_0x01b9:
            android.os.IBinder r1 = r2.readStrongBinder()
            if (r1 != 0) goto L_0x01c0
            goto L_0x01d3
        L_0x01c0:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAdListener"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.ads.zzyz
            if (r4 == 0) goto L_0x01ce
            r4 = r2
            com.google.android.gms.internal.ads.zzyz r4 = (com.google.android.gms.internal.ads.zzyz) r4
            goto L_0x01d3
        L_0x01ce:
            com.google.android.gms.internal.ads.zzzb r4 = new com.google.android.gms.internal.ads.zzzb
            r4.<init>(r1)
        L_0x01d3:
            r0.mo29517a(r4)
            r3.writeNoException()
            goto L_0x0219
        L_0x01db:
            r0.resume()
            r3.writeNoException()
            goto L_0x0219
        L_0x01e2:
            r0.pause()
            r3.writeNoException()
            goto L_0x0219
        L_0x01e9:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzxz> r1 = com.google.android.gms.internal.ads.zzxz.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.ads.zzfo.m30220a(r2, r1)
            com.google.android.gms.internal.ads.zzxz r1 = (com.google.android.gms.internal.ads.zzxz) r1
            boolean r1 = r0.mo29521b(r1)
            r3.writeNoException()
            com.google.android.gms.internal.ads.zzfo.m30223a(r3, r1)
            goto L_0x0219
        L_0x01fc:
            boolean r1 = r0.isReady()
            r3.writeNoException()
            com.google.android.gms.internal.ads.zzfo.m30223a(r3, r1)
            goto L_0x0219
        L_0x0207:
            r0.destroy()
            r3.writeNoException()
            goto L_0x0219
        L_0x020e:
            com.google.android.gms.dynamic.IObjectWrapper r1 = r0.mo29502Aa()
            r3.writeNoException()
            com.google.android.gms.internal.ads.zzfo.m30221a(r3, r1)
        L_0x0219:
            r1 = 1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzzl.mo29357a(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
