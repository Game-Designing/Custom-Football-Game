package p005cm.aptoide.p006pt.notification;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.database.accessors.Database;
import p005cm.aptoide.p006pt.database.realm.RealmLocalNotificationSync;
import p005cm.aptoide.p006pt.notification.sync.LocalNotificationSync;
import p005cm.aptoide.p006pt.sync.Sync;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.notification.RealmLocalNotificationSyncPersistence */
public class RealmLocalNotificationSyncPersistence implements LocalNotificationSyncPersistence {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private Database database;
    private RealmLocalNotificationSyncMapper mapper;
    private NotificationProvider provider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7099106414052973876L, "cm/aptoide/pt/notification/RealmLocalNotificationSyncPersistence", 8);
        $jacocoData = probes;
        return probes;
    }

    public RealmLocalNotificationSyncPersistence(Database database2, RealmLocalNotificationSyncMapper mapper2, NotificationProvider provider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.database = database2;
        this.mapper = mapper2;
        this.provider = provider2;
        $jacocoInit[0] = true;
    }

    public void save(LocalNotificationSync notification) {
        boolean[] $jacocoInit = $jacocoInit();
        this.database.insert(this.mapper.map(notification));
        $jacocoInit[1] = true;
    }

    public C0120S<Sync> get() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S s = this.database.get(RealmLocalNotificationSync.class, RealmLocalNotificationSync.PRIMARY_KEY_NAME, LocalNotificationSync.APPC_CAMPAIGN_NOTIFICATION);
        C4187aa aaVar = new C4187aa(this);
        $jacocoInit[2] = true;
        C0120S<Sync> j = s.mo3669j(aaVar);
        $jacocoInit[3] = true;
        return j;
    }

    /* renamed from: a */
    public /* synthetic */ Sync mo15314a(RealmLocalNotificationSync sync) {
        boolean[] $jacocoInit = $jacocoInit();
        if (sync != null) {
            $jacocoInit[5] = true;
            LocalNotificationSync map = this.mapper.map(sync, this.provider);
            $jacocoInit[6] = true;
            return map;
        }
        $jacocoInit[7] = true;
        return null;
    }

    public void remove(String id) {
        boolean[] $jacocoInit = $jacocoInit();
        this.database.delete(RealmLocalNotificationSync.class, RealmLocalNotificationSync.PRIMARY_KEY_NAME, LocalNotificationSync.APPC_CAMPAIGN_NOTIFICATION);
        $jacocoInit[4] = true;
    }
}
