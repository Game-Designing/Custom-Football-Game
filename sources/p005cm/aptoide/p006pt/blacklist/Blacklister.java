package p005cm.aptoide.p006pt.blacklist;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.blacklist.Blacklister */
public class Blacklister {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private BlacklistPersistence blacklistPersistence;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3771036367884248222L, "cm/aptoide/pt/blacklist/Blacklister", 6);
        $jacocoData = probes;
        return probes;
    }

    public Blacklister(BlacklistPersistence blacklistPersistence2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.blacklistPersistence = blacklistPersistence2;
        $jacocoInit[0] = true;
    }

    public boolean isBlacklisted(BlacklistUnit blacklistUnit) {
        boolean[] $jacocoInit = $jacocoInit();
        BlacklistPersistence blacklistPersistence2 = this.blacklistPersistence;
        String id = blacklistUnit.getId();
        $jacocoInit[1] = true;
        int maxImpressions = blacklistUnit.getMaxImpressions();
        $jacocoInit[2] = true;
        boolean isBlacklisted = blacklistPersistence2.isBlacklisted(id, maxImpressions);
        $jacocoInit[3] = true;
        return isBlacklisted;
    }

    public void addImpression(BlacklistUnit blacklistUnit) {
        boolean[] $jacocoInit = $jacocoInit();
        this.blacklistPersistence.addImpression(blacklistUnit.getId(), blacklistUnit.getMaxImpressions());
        $jacocoInit[4] = true;
    }

    public void blacklist(BlacklistUnit blacklistUnit) {
        boolean[] $jacocoInit = $jacocoInit();
        this.blacklistPersistence.blacklist(blacklistUnit.getId());
        $jacocoInit[5] = true;
    }
}
