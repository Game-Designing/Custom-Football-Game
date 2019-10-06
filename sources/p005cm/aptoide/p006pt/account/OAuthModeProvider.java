package p005cm.aptoide.p006pt.account;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.account.OAuthModeProvider */
public class OAuthModeProvider {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2783371698976173671L, "cm/aptoide/pt/account/OAuthModeProvider", 12);
        $jacocoData = probes;
        return probes;
    }

    public OAuthModeProvider() {
        $jacocoInit()[0] = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0068  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getAuthMode(java.lang.String r6) {
        /*
            r5 = this;
            boolean[] r0 = $jacocoInit()
            int r1 = r6.hashCode()
            r2 = 2001934(0x1e8c0e, float:2.805307E-39)
            r3 = 2
            r4 = 1
            if (r1 == r2) goto L_0x003d
            r2 = 1279756998(0x4c478ac6, float:5.230876E7)
            if (r1 == r2) goto L_0x002c
            r2 = 2108052025(0x7da65239, float:2.7634846E37)
            if (r1 == r2) goto L_0x001c
            r0[r4] = r4
            goto L_0x0048
        L_0x001c:
            java.lang.String r1 = "GOOGLE"
            boolean r1 = r6.equals(r1)
            if (r1 != 0) goto L_0x0027
            r0[r3] = r4
            goto L_0x0048
        L_0x0027:
            r1 = 0
            r2 = 3
            r0[r2] = r4
            goto L_0x004e
        L_0x002c:
            java.lang.String r1 = "FACEBOOK"
            boolean r1 = r6.equals(r1)
            if (r1 != 0) goto L_0x0038
            r1 = 4
            r0[r1] = r4
            goto L_0x0048
        L_0x0038:
            r1 = 5
            r0[r1] = r4
            r1 = 1
            goto L_0x004e
        L_0x003d:
            java.lang.String r1 = "ABAN"
            boolean r1 = r6.equals(r1)
            if (r1 != 0) goto L_0x004a
            r1 = 6
            r0[r1] = r4
        L_0x0048:
            r1 = -1
            goto L_0x004e
        L_0x004a:
            r1 = 7
            r0[r1] = r4
            r1 = 2
        L_0x004e:
            if (r1 == 0) goto L_0x0068
            if (r1 == r4) goto L_0x0061
            if (r1 == r3) goto L_0x005a
            r1 = 0
            r2 = 11
            r0[r2] = r4
            return r1
        L_0x005a:
            r1 = 10
            r0[r1] = r4
            java.lang.String r0 = "aban"
            return r0
        L_0x0061:
            r1 = 9
            r0[r1] = r4
            java.lang.String r0 = "facebook"
            return r0
        L_0x0068:
            r1 = 8
            r0[r1] = r4
            java.lang.String r0 = "google"
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.account.OAuthModeProvider.getAuthMode(java.lang.String):java.lang.String");
    }
}
