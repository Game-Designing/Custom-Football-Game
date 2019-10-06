package p005cm.aptoide.p006pt.sync.alarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.SystemClock;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.sync.Sync;
import p005cm.aptoide.p006pt.sync.SyncScheduler;

/* renamed from: cm.aptoide.pt.sync.alarm.AlarmSyncScheduler */
public class AlarmSyncScheduler implements SyncScheduler {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final String ACTION_SYNC = "cm.aptoide.pt.sync.alarm.action.SYNC";
    public static final String EXTRA_RESCHEDULE = "cm.aptoide.pt.sync.alarm.extra.RESCHEDULE";
    private static final String URI_SCHEME = "aptoide";
    private static final String URI_SCHEME_SPECIFIC_PART = "cm.aptoide.pt.sync.alarm";
    private final AlarmManager alarmManager;
    private final Context context;
    private final Class<?> serviceClass;
    private final SyncStorage syncStorage;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5836971352249219403L, "cm/aptoide/pt/sync/alarm/AlarmSyncScheduler", 60);
        $jacocoData = probes;
        return probes;
    }

    public AlarmSyncScheduler(Context context2, Class<?> serviceClass2, AlarmManager alarmManager2, SyncStorage syncStorage2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.context = context2;
        this.serviceClass = serviceClass2;
        this.alarmManager = alarmManager2;
        this.syncStorage = syncStorage2;
        $jacocoInit[0] = true;
    }

    public void schedule(Sync sync) {
        boolean[] $jacocoInit = $jacocoInit();
        if (sync.isPeriodic()) {
            $jacocoInit[1] = true;
            schedulePeriodicSync(sync);
            $jacocoInit[2] = true;
        } else {
            scheduleOneOffSync(sync);
            $jacocoInit[3] = true;
        }
        $jacocoInit[4] = true;
    }

    public void cancel(String syncId) {
        boolean[] $jacocoInit = $jacocoInit();
        PendingIntent pendingIntent = getPendingIntent(buildIntent(syncId, false));
        $jacocoInit[5] = true;
        this.alarmManager.cancel(pendingIntent);
        $jacocoInit[6] = true;
        pendingIntent.cancel();
        $jacocoInit[7] = true;
        this.syncStorage.remove(syncId);
        $jacocoInit[8] = true;
    }

    public void reschedule(Sync sync) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!isSyncScheduled(sync.getId())) {
            $jacocoInit[9] = true;
        } else {
            $jacocoInit[10] = true;
            cancel(sync.getId());
            $jacocoInit[11] = true;
            schedule(sync);
            $jacocoInit[12] = true;
        }
        $jacocoInit[13] = true;
    }

    private void scheduleOneOffSync(Sync sync) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!sync.isExact()) {
            AlarmManager alarmManager2 = this.alarmManager;
            long elapsedRealtimeTrigger = getElapsedRealtimeTrigger(sync.getTrigger());
            $jacocoInit[22] = true;
            PendingIntent pendingIntent = getPendingIntent(buildIntent(sync.getId(), false));
            $jacocoInit[23] = true;
            alarmManager2.set(3, elapsedRealtimeTrigger, pendingIntent);
            $jacocoInit[24] = true;
        } else if (VERSION.SDK_INT < 19) {
            AlarmManager alarmManager3 = this.alarmManager;
            $jacocoInit[14] = true;
            long elapsedRealtimeTrigger2 = getElapsedRealtimeTrigger(sync.getTrigger());
            $jacocoInit[15] = true;
            PendingIntent pendingIntent2 = getPendingIntent(buildIntent(sync.getId(), false));
            $jacocoInit[16] = true;
            alarmManager3.set(3, elapsedRealtimeTrigger2, pendingIntent2);
            $jacocoInit[17] = true;
        } else {
            AlarmManager alarmManager4 = this.alarmManager;
            $jacocoInit[18] = true;
            long elapsedRealtimeTrigger3 = getElapsedRealtimeTrigger(sync.getTrigger());
            $jacocoInit[19] = true;
            PendingIntent pendingIntent3 = getPendingIntent(buildIntent(sync.getId(), false));
            $jacocoInit[20] = true;
            alarmManager4.setExact(3, elapsedRealtimeTrigger3, pendingIntent3);
            $jacocoInit[21] = true;
        }
        this.syncStorage.save(sync);
        $jacocoInit[25] = true;
    }

    private void schedulePeriodicSync(Sync sync) {
        boolean[] $jacocoInit = $jacocoInit();
        if (sync.isExact()) {
            $jacocoInit[26] = true;
            scheduleExactPeriodicSync(sync);
            $jacocoInit[27] = true;
        } else {
            scheduleInexactPeriodicSync(sync);
            $jacocoInit[28] = true;
        }
        $jacocoInit[29] = true;
    }

    private void scheduleInexactPeriodicSync(Sync sync) {
        boolean[] $jacocoInit = $jacocoInit();
        if (isSyncScheduled(sync.getId())) {
            $jacocoInit[30] = true;
            return;
        }
        AlarmManager alarmManager2 = this.alarmManager;
        $jacocoInit[31] = true;
        long elapsedRealtimeTrigger = getElapsedRealtimeTrigger(sync.getTrigger());
        long interval = sync.getInterval();
        $jacocoInit[32] = true;
        PendingIntent pendingIntent = getPendingIntent(buildIntent(sync.getId(), false));
        $jacocoInit[33] = true;
        alarmManager2.setInexactRepeating(3, elapsedRealtimeTrigger, interval, pendingIntent);
        $jacocoInit[34] = true;
        this.syncStorage.save(sync);
        $jacocoInit[35] = true;
    }

    private void scheduleExactPeriodicSync(Sync sync) {
        boolean[] $jacocoInit = $jacocoInit();
        if (VERSION.SDK_INT < 19) {
            $jacocoInit[36] = true;
            if (isSyncScheduled(sync.getId())) {
                $jacocoInit[37] = true;
                return;
            }
            AlarmManager alarmManager2 = this.alarmManager;
            $jacocoInit[38] = true;
            long elapsedRealtimeTrigger = getElapsedRealtimeTrigger(sync.getTrigger());
            long interval = sync.getInterval();
            $jacocoInit[39] = true;
            PendingIntent pendingIntent = getPendingIntent(buildIntent(sync.getId(), false));
            $jacocoInit[40] = true;
            alarmManager2.setRepeating(3, elapsedRealtimeTrigger, interval, pendingIntent);
            $jacocoInit[41] = true;
            this.syncStorage.save(sync);
            $jacocoInit[42] = true;
        } else {
            long trigger = 0;
            if (sync instanceof OneOffSyncWrapper) {
                $jacocoInit[43] = true;
                trigger = sync.getTrigger();
                $jacocoInit[44] = true;
                this.syncStorage.save(sync);
                $jacocoInit[45] = true;
            } else {
                this.syncStorage.save(new OneOffSyncWrapper(sync, sync.getInterval()));
                $jacocoInit[46] = true;
            }
            AlarmManager alarmManager3 = this.alarmManager;
            long elapsedRealtimeTrigger2 = getElapsedRealtimeTrigger(trigger);
            $jacocoInit[47] = true;
            PendingIntent pendingIntent2 = getPendingIntent(buildIntent(sync.getId(), true));
            $jacocoInit[48] = true;
            alarmManager3.setExact(3, elapsedRealtimeTrigger2, pendingIntent2);
            $jacocoInit[49] = true;
        }
        $jacocoInit[50] = true;
    }

    private long getElapsedRealtimeTrigger(long trigger) {
        long elapsedRealtime = SystemClock.elapsedRealtime() + trigger;
        $jacocoInit()[51] = true;
        return elapsedRealtime;
    }

    private boolean isSyncScheduled(String syncId) {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = false;
        if (PendingIntent.getService(this.context, 0, buildIntent(syncId, false), 536870912) != null) {
            $jacocoInit[52] = true;
            z = true;
        } else {
            $jacocoInit[53] = true;
        }
        $jacocoInit[54] = true;
        return z;
    }

    private Intent buildIntent(String syncId, boolean reschedule) {
        boolean[] $jacocoInit = $jacocoInit();
        Intent intent = new Intent(this.context, this.serviceClass);
        $jacocoInit[55] = true;
        intent.setAction(ACTION_SYNC);
        $jacocoInit[56] = true;
        intent.setData(Uri.fromParts(URI_SCHEME, URI_SCHEME_SPECIFIC_PART, syncId));
        $jacocoInit[57] = true;
        intent.putExtra(EXTRA_RESCHEDULE, reschedule);
        $jacocoInit[58] = true;
        return intent;
    }

    private PendingIntent getPendingIntent(Intent intent) {
        boolean[] $jacocoInit = $jacocoInit();
        PendingIntent service = PendingIntent.getService(this.context, 0, intent, 134217728);
        $jacocoInit[59] = true;
        return service;
    }
}
