package p005cm.aptoide.p006pt.sync.alarm;

import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.IBinder;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.sync.Sync;
import p005cm.aptoide.p006pt.sync.SyncScheduler;
import p026rx.C0117M;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0129b;

/* renamed from: cm.aptoide.pt.sync.alarm.AlarmSyncService */
public class AlarmSyncService extends Service {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private CrashReport crashReport;
    private SyncScheduler scheduler;
    private SyncStorage storage;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6276062258137380214L, "cm/aptoide/pt/sync/alarm/AlarmSyncService", 24);
        $jacocoData = probes;
        return probes;
    }

    public AlarmSyncService() {
        $jacocoInit()[0] = true;
    }

    public void onCreate() {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate();
        $jacocoInit[1] = true;
        this.scheduler = ((AptoideApplication) getApplicationContext()).getAlarmSyncScheduler();
        $jacocoInit[2] = true;
        this.storage = ((AptoideApplication) getApplicationContext()).getSyncStorage();
        $jacocoInit[3] = true;
        this.crashReport = CrashReport.getInstance();
        $jacocoInit[4] = true;
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        boolean[] $jacocoInit = $jacocoInit();
        if (intent == null) {
            $jacocoInit[5] = true;
        } else {
            if (!AlarmSyncScheduler.ACTION_SYNC.equals(intent.getAction())) {
                $jacocoInit[6] = true;
            } else {
                $jacocoInit[7] = true;
                Uri data = intent.getData();
                $jacocoInit[8] = true;
                String syncId = data.getFragment();
                $jacocoInit[9] = true;
                Sync sync = this.storage.get(syncId);
                $jacocoInit[10] = true;
                boolean reschedule = intent.getBooleanExtra(AlarmSyncScheduler.EXTRA_RESCHEDULE, false);
                if (sync != null) {
                    $jacocoInit[11] = true;
                    C0117M execute = sync.execute();
                    C5103b bVar = new C5103b(this, reschedule, sync, startId);
                    $jacocoInit[12] = true;
                    C0117M b = execute.mo3594b((C0128a) bVar);
                    C5104c cVar = C5104c.f8830a;
                    C5102a aVar = new C5102a(this);
                    $jacocoInit[13] = true;
                    b.mo3588a((C0128a) cVar, (C0129b<? super Throwable>) aVar);
                    $jacocoInit[14] = true;
                } else {
                    this.scheduler.cancel(syncId);
                    $jacocoInit[15] = true;
                }
            }
        }
        $jacocoInit[16] = true;
        return 3;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16739a(boolean reschedule, Sync sync, int startId) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!reschedule) {
            $jacocoInit[20] = true;
        } else {
            $jacocoInit[21] = true;
            this.scheduler.reschedule(sync);
            $jacocoInit[22] = true;
        }
        stopSelf(startId);
        $jacocoInit[23] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m9419a() {
        $jacocoInit()[19] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16738a(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(throwable);
        $jacocoInit[18] = true;
    }

    public IBinder onBind(Intent intent) {
        $jacocoInit()[17] = true;
        return null;
    }
}
