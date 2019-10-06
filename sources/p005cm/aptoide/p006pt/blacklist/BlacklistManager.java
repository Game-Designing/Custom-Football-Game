package p005cm.aptoide.p006pt.blacklist;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.blacklist.BlacklistManager */
public class BlacklistManager {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private BlacklistUnitMapper blacklistUnitMapper;
    private Blacklister blacklister;

    /* renamed from: cm.aptoide.pt.blacklist.BlacklistManager$BlacklistType */
    public enum BlacklistType {
        WALLET_ADS_OFFER("Wallet_Ads_Offer", 10),
        APPC_CARD_INFO("Appc_Card_Info", 10);
        
        private int maxPossibleImpressions;
        private String type;

        static {
            boolean[] $jacocoInit;
            $jacocoInit[5] = true;
        }

        private BlacklistType(String type2, int maxPossibleImpressions2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.type = type2;
            this.maxPossibleImpressions = maxPossibleImpressions2;
            $jacocoInit[2] = true;
        }

        public String getType() {
            boolean[] $jacocoInit = $jacocoInit();
            String str = this.type;
            $jacocoInit[3] = true;
            return str;
        }

        public int getMaxPossibleImpressions() {
            boolean[] $jacocoInit = $jacocoInit();
            int i = this.maxPossibleImpressions;
            $jacocoInit[4] = true;
            return i;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4574802937083445525L, "cm/aptoide/pt/blacklist/BlacklistManager", 6);
        $jacocoData = probes;
        return probes;
    }

    public BlacklistManager(Blacklister blacklister2, BlacklistUnitMapper blacklistUnitMapper2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.blacklister = blacklister2;
        this.blacklistUnitMapper = blacklistUnitMapper2;
        $jacocoInit[0] = true;
    }

    public boolean isBlacklisted(String actionCardType, String id) {
        boolean[] $jacocoInit = $jacocoInit();
        Blacklister blacklister2 = this.blacklister;
        BlacklistUnitMapper blacklistUnitMapper2 = this.blacklistUnitMapper;
        $jacocoInit[1] = true;
        BlacklistUnit mapActionCardToBlacklistUnit = blacklistUnitMapper2.mapActionCardToBlacklistUnit(actionCardType, id);
        $jacocoInit[2] = true;
        boolean isBlacklisted = blacklister2.isBlacklisted(mapActionCardToBlacklistUnit);
        $jacocoInit[3] = true;
        return isBlacklisted;
    }

    public void addImpression(String actionCardType, String id) {
        boolean[] $jacocoInit = $jacocoInit();
        this.blacklister.addImpression(this.blacklistUnitMapper.mapActionCardToBlacklistUnit(actionCardType, id));
        $jacocoInit[4] = true;
    }

    public void blacklist(String actionCardType, String id) {
        boolean[] $jacocoInit = $jacocoInit();
        this.blacklister.blacklist(this.blacklistUnitMapper.mapActionCardToBlacklistUnit(actionCardType, id));
        $jacocoInit[5] = true;
    }
}
