package p005cm.aptoide.p006pt.billing.sync;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.billing.BillingSyncScheduler;
import p005cm.aptoide.p006pt.sync.Sync;
import p005cm.aptoide.p006pt.sync.SyncScheduler;

/* renamed from: cm.aptoide.pt.billing.sync.BillingSyncManager */
public class BillingSyncManager implements BillingSyncScheduler {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Map<String, String> authorizationSyncs;
    private final Set<String> currentSyncs;
    private final BillingSyncFactory syncFactory;
    private final SyncScheduler syncScheduler;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-52055263193252331L, "cm/aptoide/pt/billing/sync/BillingSyncManager", 24);
        $jacocoData = probes;
        return probes;
    }

    public BillingSyncManager(BillingSyncFactory syncFactory2, SyncScheduler syncScheduler2, Set<String> currentSyncs2, Map<String, String> authorizationSyncs2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.syncFactory = syncFactory2;
        this.syncScheduler = syncScheduler2;
        this.currentSyncs = currentSyncs2;
        this.authorizationSyncs = authorizationSyncs2;
        $jacocoInit[0] = true;
    }

    public void syncAuthorization(String transactionId) {
        boolean[] $jacocoInit = $jacocoInit();
        Sync sync = this.syncFactory.createAuthorizationSync(transactionId);
        $jacocoInit[1] = true;
        this.currentSyncs.add(sync.getId());
        $jacocoInit[2] = true;
        this.authorizationSyncs.put(transactionId, sync.getId());
        $jacocoInit[3] = true;
        this.syncScheduler.schedule(sync);
        $jacocoInit[4] = true;
    }

    public void syncTransaction(String productId) {
        boolean[] $jacocoInit = $jacocoInit();
        Sync sync = this.syncFactory.createTransactionSync(productId);
        $jacocoInit[5] = true;
        this.currentSyncs.add(sync.getId());
        $jacocoInit[6] = true;
        this.syncScheduler.schedule(sync);
        $jacocoInit[7] = true;
    }

    public void stopSyncs() {
        boolean[] $jacocoInit = $jacocoInit();
        Set<String> cancelledSyncIds = new HashSet<>();
        $jacocoInit[8] = true;
        $jacocoInit[9] = true;
        for (String syncId : this.currentSyncs) {
            $jacocoInit[10] = true;
            this.syncScheduler.cancel(syncId);
            $jacocoInit[11] = true;
            cancelledSyncIds.add(syncId);
            $jacocoInit[12] = true;
        }
        $jacocoInit[13] = true;
        for (String cancelledSyncId : cancelledSyncIds) {
            $jacocoInit[14] = true;
            this.currentSyncs.remove(cancelledSyncId);
            $jacocoInit[15] = true;
            this.authorizationSyncs.remove(cancelledSyncId);
            $jacocoInit[16] = true;
        }
        $jacocoInit[17] = true;
    }

    public void cancelAuthorizationSync(String transactionId) {
        boolean[] $jacocoInit = $jacocoInit();
        String syncId = (String) this.authorizationSyncs.get(transactionId);
        if (syncId == null) {
            $jacocoInit[18] = true;
        } else {
            $jacocoInit[19] = true;
            this.syncScheduler.cancel(syncId);
            $jacocoInit[20] = true;
            this.authorizationSyncs.remove(syncId);
            $jacocoInit[21] = true;
            this.currentSyncs.remove(syncId);
            $jacocoInit[22] = true;
        }
        $jacocoInit[23] = true;
    }
}
