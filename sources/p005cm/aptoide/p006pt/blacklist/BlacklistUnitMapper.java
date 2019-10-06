package p005cm.aptoide.p006pt.blacklist;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.blacklist.BlacklistUnitMapper */
public class BlacklistUnitMapper {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3160621037628828203L, "cm/aptoide/pt/blacklist/BlacklistUnitMapper", 11);
        $jacocoData = probes;
        return probes;
    }

    public BlacklistUnitMapper() {
        $jacocoInit()[0] = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0071  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p005cm.aptoide.p006pt.blacklist.BlacklistUnit mapActionCardToBlacklistUnit(java.lang.String r7, java.lang.String r8) {
        /*
            r6 = this;
            boolean[] r0 = $jacocoInit()
            int r1 = r7.hashCode()
            r2 = -1817393869(0xffffffff93acc533, float:-4.3613358E-27)
            r3 = 1
            if (r1 == r2) goto L_0x0027
            r2 = -174115577(0xfffffffff59f3507, float:-4.0363805E32)
            if (r1 == r2) goto L_0x0016
            r0[r3] = r3
            goto L_0x0032
        L_0x0016:
            java.lang.String r1 = "WALLET_ADS_OFFER"
            boolean r1 = r7.equals(r1)
            if (r1 != 0) goto L_0x0022
            r1 = 2
            r0[r1] = r3
            goto L_0x0032
        L_0x0022:
            r1 = 0
            r2 = 3
            r0[r2] = r3
            goto L_0x0038
        L_0x0027:
            java.lang.String r1 = "INFO_BUNDLE"
            boolean r1 = r7.equals(r1)
            if (r1 != 0) goto L_0x0034
            r1 = 4
            r0[r1] = r3
        L_0x0032:
            r1 = -1
            goto L_0x0038
        L_0x0034:
            r1 = 5
            r0[r1] = r3
            r1 = 1
        L_0x0038:
            if (r1 == 0) goto L_0x0071
            if (r1 != r3) goto L_0x0065
            cm.aptoide.pt.blacklist.BlacklistUnit r1 = new cm.aptoide.pt.blacklist.BlacklistUnit
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            cm.aptoide.pt.blacklist.BlacklistManager$BlacklistType r4 = p005cm.aptoide.p006pt.blacklist.BlacklistManager.BlacklistType.APPC_CARD_INFO
            java.lang.String r4 = r4.getType()
            r2.append(r4)
            r2.append(r8)
            java.lang.String r2 = r2.toString()
            cm.aptoide.pt.blacklist.BlacklistManager$BlacklistType r4 = p005cm.aptoide.p006pt.blacklist.BlacklistManager.BlacklistType.APPC_CARD_INFO
            r5 = 8
            r0[r5] = r3
            int r4 = r4.getMaxPossibleImpressions()
            r1.<init>(r2, r4)
            r2 = 9
            r0[r2] = r3
            return r1
        L_0x0065:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Wrong blacklist key. Please, make sure you are passing the correct action card type and id."
            r1.<init>(r2)
            r2 = 10
            r0[r2] = r3
            throw r1
        L_0x0071:
            cm.aptoide.pt.blacklist.BlacklistUnit r1 = new cm.aptoide.pt.blacklist.BlacklistUnit
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            cm.aptoide.pt.blacklist.BlacklistManager$BlacklistType r4 = p005cm.aptoide.p006pt.blacklist.BlacklistManager.BlacklistType.WALLET_ADS_OFFER
            java.lang.String r4 = r4.getType()
            r2.append(r4)
            r2.append(r8)
            java.lang.String r2 = r2.toString()
            cm.aptoide.pt.blacklist.BlacklistManager$BlacklistType r4 = p005cm.aptoide.p006pt.blacklist.BlacklistManager.BlacklistType.WALLET_ADS_OFFER
            r5 = 6
            r0[r5] = r3
            int r4 = r4.getMaxPossibleImpressions()
            r1.<init>(r2, r4)
            r2 = 7
            r0[r2] = r3
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.blacklist.BlacklistUnitMapper.mapActionCardToBlacklistUnit(java.lang.String, java.lang.String):cm.aptoide.pt.blacklist.BlacklistUnit");
    }
}
