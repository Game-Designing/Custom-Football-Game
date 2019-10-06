package p005cm.aptoide.p006pt.sync.alarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.notification.LocalNotificationSyncPersistence;
import p005cm.aptoide.p006pt.notification.sync.LocalNotificationSync;
import p005cm.aptoide.p006pt.sync.Sync;
import p026rx.C0120S;
import p026rx.p398d.C14906b;

/* renamed from: cm.aptoide.pt.sync.alarm.SyncStorage */
public class SyncStorage {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final LocalNotificationSyncPersistence persistence;
    private final Map<String, Sync> syncs;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7927039005387259777L, "cm/aptoide/pt/sync/alarm/SyncStorage", 13);
        $jacocoData = probes;
        return probes;
    }

    public SyncStorage(Map<String, Sync> syncs2, LocalNotificationSyncPersistence persistence2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.syncs = syncs2;
        this.persistence = persistence2;
        $jacocoInit[0] = true;
    }

    public void save(Sync sync) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!(sync instanceof LocalNotificationSync)) {
            $jacocoInit[1] = true;
        } else {
            this.persistence.save((LocalNotificationSync) sync);
            $jacocoInit[2] = true;
        }
        this.syncs.put(sync.getId(), sync);
        $jacocoInit[3] = true;
    }

    public Sync get(String syncId) {
        boolean[] $jacocoInit = $jacocoInit();
        if (syncId.equals(LocalNotificationSync.APPC_CAMPAIGN_NOTIFICATION)) {
            $jacocoInit[4] = true;
            C0120S s = this.persistence.get();
            $jacocoInit[5] = true;
            C14906b k = s.mo3672k();
            $jacocoInit[6] = true;
            Sync sync = (Sync) k.mo46110a();
            $jacocoInit[7] = true;
            return sync;
        }
        Sync sync2 = (Sync) this.syncs.get(syncId);
        $jacocoInit[8] = true;
        return sync2;
    }

    public List<Sync> getAll() {
        boolean[] $jacocoInit = $jacocoInit();
        ArrayList arrayList = new ArrayList(this.syncs.values());
        $jacocoInit[9] = true;
        return arrayList;
    }

    public void remove(String syncId) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!syncId.equals(LocalNotificationSync.APPC_CAMPAIGN_NOTIFICATION)) {
            $jacocoInit[10] = true;
        } else {
            this.persistence.remove(syncId);
            $jacocoInit[11] = true;
        }
        this.syncs.remove(syncId);
        $jacocoInit[12] = true;
    }
}
