package p005cm.aptoide.p006pt.notification;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.p000v4.app.C0448aa.C0451c;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.BaseService;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.DeepLinkIntentReceiver.DeepLinksTargets;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.database.realm.Update;
import p005cm.aptoide.p006pt.download.DownloadFactory;
import p005cm.aptoide.p006pt.install.InstallManager;
import p005cm.aptoide.p006pt.preferences.managed.ManagerPreferences;
import p005cm.aptoide.p006pt.repository.RepositoryFactory;
import p005cm.aptoide.p006pt.updates.UpdateRepository;
import p005cm.aptoide.p006pt.utils.AptoideUtils.StringU;
import p005cm.aptoide.p006pt.view.ActivityProvider;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.C0137ja;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.p029i.C0136c;
import p026rx.schedulers.Schedulers;

/* renamed from: cm.aptoide.pt.notification.PullingContentService */
public class PullingContentService extends BaseService {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final String BOOT_COMPLETED_ACTION = "BOOT_COMPLETED_ACTION";
    public static final String PUSH_NOTIFICATIONS_ACTION = "PUSH_NOTIFICATIONS_ACTION";
    public static final String UPDATES_ACTION = "UPDATES_ACTION";
    public static final long UPDATES_INTERVAL = 86400000;
    public static final int UPDATE_NOTIFICATION_ID = 123;
    private AptoideApplication application;
    @Inject
    DownloadFactory downloadFactory;
    private InstallManager installManager;
    @Inject
    String marketName;
    private NotificationAnalytics notificationAnalytics;
    private SharedPreferences sharedPreferences;
    private C0136c subscriptions;
    private UpdateRepository updateRepository;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8849207380472457594L, "cm/aptoide/pt/notification/PullingContentService", Opcodes.IAND);
        $jacocoData = probes;
        return probes;
    }

    public PullingContentService() {
        $jacocoInit()[0] = true;
    }

    public void setAlarm(AlarmManager am, Context context, String action, long time) {
        Context context2 = context;
        long j = time;
        boolean[] $jacocoInit = $jacocoInit();
        Intent intent = new Intent(context2, PullingContentService.class);
        $jacocoInit[1] = true;
        intent.setAction(action);
        $jacocoInit[2] = true;
        PendingIntent pendingIntent = PendingIntent.getService(context2, 0, intent, 134217728);
        $jacocoInit[3] = true;
        long elapsedRealtimeTrigger = getElapsedRealtimeTrigger(j);
        $jacocoInit[4] = true;
        long elapsedRealtimeTrigger2 = getElapsedRealtimeTrigger(j);
        $jacocoInit[5] = true;
        am.setInexactRepeating(3, elapsedRealtimeTrigger, elapsedRealtimeTrigger2, pendingIntent);
        $jacocoInit[6] = true;
    }

    public void onCreate() {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate();
        $jacocoInit[7] = true;
        getApplicationComponent().inject(this);
        $jacocoInit[8] = true;
        this.application = (AptoideApplication) getApplicationContext();
        $jacocoInit[9] = true;
        this.sharedPreferences = this.application.getDefaultSharedPreferences();
        $jacocoInit[10] = true;
        this.installManager = this.application.getInstallManager();
        $jacocoInit[11] = true;
        this.updateRepository = RepositoryFactory.getUpdateRepository(this, this.sharedPreferences);
        $jacocoInit[12] = true;
        this.notificationAnalytics = this.application.getNotificationAnalytics();
        $jacocoInit[13] = true;
        this.subscriptions = new C0136c();
        $jacocoInit[14] = true;
        AlarmManager alarm = (AlarmManager) getSystemService("alarm");
        $jacocoInit[15] = true;
        if (isAlarmUp(this, UPDATES_ACTION)) {
            $jacocoInit[16] = true;
        } else {
            $jacocoInit[17] = true;
            setAlarm(alarm, this, UPDATES_ACTION, UPDATES_INTERVAL);
            $jacocoInit[18] = true;
        }
        $jacocoInit[19] = true;
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        String action;
        boolean[] $jacocoInit = $jacocoInit();
        if (intent == null) {
            action = null;
            $jacocoInit[20] = true;
        } else {
            action = intent.getAction();
            $jacocoInit[21] = true;
        }
        if (action == null) {
            $jacocoInit[22] = true;
        } else {
            $jacocoInit[23] = true;
            char c = 65535;
            int hashCode = action.hashCode();
            if (hashCode != 307586167) {
                if (hashCode != 1100369771) {
                    $jacocoInit[24] = true;
                } else if (!action.equals(UPDATES_ACTION)) {
                    $jacocoInit[25] = true;
                } else {
                    c = 0;
                    $jacocoInit[26] = true;
                }
            } else if (!action.equals(BOOT_COMPLETED_ACTION)) {
                $jacocoInit[27] = true;
            } else {
                $jacocoInit[28] = true;
                c = 1;
            }
            if (c == 0 || c == 1) {
                setUpdatesAction(startId);
                $jacocoInit[30] = true;
            } else {
                $jacocoInit[29] = true;
            }
        }
        $jacocoInit[31] = true;
        return 2;
    }

    public void onDestroy() {
        boolean[] $jacocoInit = $jacocoInit();
        this.subscriptions.mo3712a();
        $jacocoInit[32] = true;
        super.onDestroy();
        $jacocoInit[33] = true;
    }

    public IBinder onBind(Intent intent) {
        $jacocoInit()[34] = true;
        return null;
    }

    private boolean isAlarmUp(Context context, String action) {
        boolean[] $jacocoInit = $jacocoInit();
        Intent intent = new Intent(context, PullingContentService.class);
        $jacocoInit[35] = true;
        intent.setAction(action);
        $jacocoInit[36] = true;
        boolean z = false;
        if (PendingIntent.getService(context, 0, intent, 536870912) != null) {
            $jacocoInit[37] = true;
            z = true;
        } else {
            $jacocoInit[38] = true;
        }
        $jacocoInit[39] = true;
        return z;
    }

    private long getElapsedRealtimeTrigger(long trigger) {
        long elapsedRealtime = SystemClock.elapsedRealtime() + trigger;
        $jacocoInit()[40] = true;
        return elapsedRealtime;
    }

    private void setUpdatesAction(int startId) {
        boolean[] $jacocoInit = $jacocoInit();
        C0136c cVar = this.subscriptions;
        C0117M sync = this.updateRepository.sync(true, false);
        UpdateRepository updateRepository2 = this.updateRepository;
        $jacocoInit[41] = true;
        C0120S a = sync.mo3586a(updateRepository2.getAll(false));
        C4175O o = C4175O.f7728a;
        $jacocoInit[42] = true;
        C0120S f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) o);
        $jacocoInit[43] = true;
        C0120S d = f.mo3647d();
        $jacocoInit[44] = true;
        C0120S a2 = d.mo3616a(Schedulers.computation());
        C4181V v = new C4181V(this);
        $jacocoInit[45] = true;
        C0120S f2 = a2.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) v);
        C4184Y y = new C4184Y(this);
        $jacocoInit[46] = true;
        C0120S d2 = f2.mo3653d((C0132p<? super T, Boolean>) y);
        $jacocoInit[47] = true;
        C0120S a3 = d2.mo3616a(Schedulers.m776io());
        C4185Z z = new C4185Z(this, startId);
        $jacocoInit[48] = true;
        C0120S b = a3.mo3636b((C0129b<? super T>) z);
        C4182W w = C4182W.f7736a;
        C4174N n = C4174N.f7727a;
        $jacocoInit[49] = true;
        C0137ja a4 = b.mo3626a((C0129b<? super T>) w, (C0129b<Throwable>) n);
        $jacocoInit[50] = true;
        cVar.mo3713a(a4);
        $jacocoInit[51] = true;
    }

    /* renamed from: c */
    static /* synthetic */ C0120S m8625c(List updates) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S c = C0120S.m652c(updates);
        C4180U u = C4180U.f7734a;
        $jacocoInit[118] = true;
        C0120S h = c.mo3666h((C0132p<? super T, ? extends Iterable<? extends R>>) u);
        C4178S s = C4178S.f7732a;
        $jacocoInit[119] = true;
        C0120S d = h.mo3653d((C0132p<? super T, Boolean>) s);
        $jacocoInit[120] = true;
        C0120S m = d.mo3675m();
        $jacocoInit[121] = true;
        return m;
    }

    /* renamed from: a */
    static /* synthetic */ Iterable m8622a(List list) {
        $jacocoInit()[125] = true;
        return list;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m8621a(Update update) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!update.isAppcUpgrade()) {
            $jacocoInit[122] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[123] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[124] = true;
        return valueOf;
    }

    /* renamed from: d */
    public /* synthetic */ C0120S mo15303d(List updates) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S f = autoUpdate(updates).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C4183X<Object,Object>(updates));
        $jacocoInit[114] = true;
        return f;
    }

    /* renamed from: b */
    static /* synthetic */ C0120S m8624b(List updates, Boolean autoUpdateRunned) {
        boolean[] $jacocoInit = $jacocoInit();
        if (autoUpdateRunned.booleanValue()) {
            $jacocoInit[115] = true;
            C0120S c = C0120S.m651c();
            $jacocoInit[116] = true;
            return c;
        }
        C0120S c2 = C0120S.m652c(updates);
        $jacocoInit[117] = true;
        return c2;
    }

    /* renamed from: e */
    public /* synthetic */ Boolean mo15304e(List __) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(ManagerPreferences.isUpdateNotificationEnable(this.sharedPreferences));
        $jacocoInit[113] = true;
        return valueOf;
    }

    /* renamed from: a */
    public /* synthetic */ void mo15301a(int startId, List updates) {
        boolean[] $jacocoInit = $jacocoInit();
        this.notificationAnalytics.sendUpdatesNotificationReceivedEvent();
        $jacocoInit[111] = true;
        setUpdatesNotification(updates, startId);
        $jacocoInit[112] = true;
    }

    /* renamed from: f */
    static /* synthetic */ void m8626f(List __) {
        $jacocoInit()[110] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m8623a(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        throwable.printStackTrace();
        $jacocoInit[107] = true;
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[108] = true;
        instance.log(throwable);
        $jacocoInit[109] = true;
    }

    private C0120S<Boolean> autoUpdate(List<Update> updateList) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!ManagerPreferences.isAutoUpdateEnable(this.sharedPreferences)) {
            $jacocoInit[52] = true;
        } else {
            SharedPreferences sharedPreferences2 = this.sharedPreferences;
            $jacocoInit[53] = true;
            if (!ManagerPreferences.allowRootInstallation(sharedPreferences2)) {
                $jacocoInit[54] = true;
            } else {
                $jacocoInit[55] = true;
                z = true;
                C0120S c = C0120S.m652c(Boolean.valueOf(z));
                C4176P p = new C4176P(this, updateList);
                $jacocoInit[57] = true;
                C0120S<Boolean> f = c.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) p);
                $jacocoInit[58] = true;
                return f;
            }
        }
        z = false;
        $jacocoInit[56] = true;
        C0120S c2 = C0120S.m652c(Boolean.valueOf(z));
        C4176P p2 = new C4176P(this, updateList);
        $jacocoInit[57] = true;
        C0120S<Boolean> f2 = c2.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) p2);
        $jacocoInit[58] = true;
        return f2;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo15300a(List updateList, Boolean shouldAutoUpdateRun) {
        boolean[] $jacocoInit = $jacocoInit();
        if (shouldAutoUpdateRun.booleanValue()) {
            $jacocoInit[95] = true;
            C0120S c = C0120S.m652c(updateList);
            $jacocoInit[96] = true;
            C0120S a = c.mo3616a(Schedulers.m776io());
            C4177Q q = new C4177Q(this);
            $jacocoInit[97] = true;
            C0120S j = a.mo3669j(q);
            C4179T t = new C4179T(this);
            $jacocoInit[98] = true;
            C0120S f = j.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) t);
            $jacocoInit[99] = true;
            return f;
        }
        C0120S c2 = C0120S.m652c(Boolean.valueOf(false));
        $jacocoInit[100] = true;
        return c2;
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<cm.aptoide.pt.database.realm.Update>, for r8v0, types: [java.util.List, java.util.List<cm.aptoide.pt.database.realm.Update>] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ java.util.ArrayList mo15302b(java.util.List<p005cm.aptoide.p006pt.database.realm.Update> r8) {
        /*
            r7 = this;
            boolean[] r0 = $jacocoInit()
            java.util.ArrayList r1 = new java.util.ArrayList
            int r2 = r8.size()
            r1.<init>(r2)
            r2 = 1
            r3 = 102(0x66, float:1.43E-43)
            r0[r3] = r2
            java.util.Iterator r3 = r8.iterator()
            r4 = 103(0x67, float:1.44E-43)
            r0[r4] = r2
        L_0x001a:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0039
            java.lang.Object r4 = r3.next()
            cm.aptoide.pt.database.realm.Update r4 = (p005cm.aptoide.p006pt.database.realm.Update) r4
            r5 = 104(0x68, float:1.46E-43)
            r0[r5] = r2
            cm.aptoide.pt.download.DownloadFactory r5 = r7.downloadFactory
            r6 = 0
            cm.aptoide.pt.database.realm.Download r5 = r5.create(r4, r6)
            r1.add(r5)
            r4 = 105(0x69, float:1.47E-43)
            r0[r4] = r2
            goto L_0x001a
        L_0x0039:
            r3 = 106(0x6a, float:1.49E-43)
            r0[r3] = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.notification.PullingContentService.mo15302b(java.util.List):java.util.ArrayList");
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo15299a(ArrayList downloads) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S startInstalls = this.installManager.startInstalls(downloads);
        $jacocoInit[101] = true;
        return startInstalls;
    }

    private void setUpdatesNotification(List<Update> updates, int startId) {
        boolean[] $jacocoInit = $jacocoInit();
        Context applicationContext = getApplicationContext();
        $jacocoInit[59] = true;
        ActivityProvider activityProvider = AptoideApplication.getActivityProvider();
        $jacocoInit[60] = true;
        Intent resultIntent = new Intent(applicationContext, activityProvider.getMainActivityFragmentClass());
        $jacocoInit[61] = true;
        resultIntent.putExtra(DeepLinksTargets.NEW_UPDATES, true);
        $jacocoInit[62] = true;
        PendingIntent resultPendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, resultIntent, 134217728);
        $jacocoInit[63] = true;
        int numberUpdates = updates.size();
        if (numberUpdates <= 0) {
            $jacocoInit[64] = true;
        } else {
            SharedPreferences sharedPreferences2 = this.sharedPreferences;
            $jacocoInit[65] = true;
            if (numberUpdates == ManagerPreferences.getLastUpdates(sharedPreferences2)) {
                $jacocoInit[66] = true;
            } else {
                SharedPreferences sharedPreferences3 = this.sharedPreferences;
                $jacocoInit[67] = true;
                if (!ManagerPreferences.isUpdateNotificationEnable(sharedPreferences3)) {
                    $jacocoInit[68] = true;
                } else {
                    $jacocoInit[69] = true;
                    Resources resources = getResources();
                    $jacocoInit[70] = true;
                    Object[] objArr = {getString(C1375R.string.app_name)};
                    $jacocoInit[71] = true;
                    CharSequence tickerText = StringU.getFormattedString(C1375R.string.has_updates, resources, objArr);
                    $jacocoInit[72] = true;
                    CharSequence contentTitle = getString(C1375R.string.app_name);
                    $jacocoInit[73] = true;
                    Resources resources2 = getResources();
                    $jacocoInit[74] = true;
                    Object[] objArr2 = {Integer.valueOf(numberUpdates)};
                    $jacocoInit[75] = true;
                    CharSequence contentText = StringU.getFormattedString(C1375R.string.new_updates, resources2, objArr2);
                    if (numberUpdates != 1) {
                        $jacocoInit[76] = true;
                    } else {
                        $jacocoInit[77] = true;
                        Resources resources3 = getResources();
                        $jacocoInit[78] = true;
                        Object[] objArr3 = {Integer.valueOf(numberUpdates)};
                        $jacocoInit[79] = true;
                        contentText = StringU.getFormattedString(C1375R.string.one_new_update, resources3, objArr3);
                        $jacocoInit[80] = true;
                    }
                    $jacocoInit[81] = true;
                    C0451c cVar = new C0451c(getApplicationContext());
                    cVar.mo5110a(resultPendingIntent);
                    $jacocoInit[82] = true;
                    cVar.mo5122c(false);
                    $jacocoInit[83] = true;
                    cVar.mo5120c((int) C1375R.drawable.ic_stat_aptoide_notification);
                    $jacocoInit[84] = true;
                    cVar.mo5111a(BitmapFactory.decodeResource(getApplicationContext().getResources(), C1375R.mipmap.ic_launcher));
                    $jacocoInit[85] = true;
                    cVar.mo5121c(contentTitle);
                    $jacocoInit[86] = true;
                    cVar.mo5118b(contentText);
                    $jacocoInit[87] = true;
                    cVar.mo5123d(tickerText);
                    $jacocoInit[88] = true;
                    Notification notification = cVar.mo5105a();
                    notification.flags = 20;
                    $jacocoInit[89] = true;
                    NotificationManager managerNotification = (NotificationManager) getApplicationContext().getSystemService("notification");
                    $jacocoInit[90] = true;
                    this.notificationAnalytics.sendUpdatesNotificationImpressionEvent();
                    $jacocoInit[91] = true;
                    managerNotification.notify(123, notification);
                    $jacocoInit[92] = true;
                    ManagerPreferences.setLastUpdates(numberUpdates, this.sharedPreferences);
                    $jacocoInit[93] = true;
                }
            }
        }
        stopSelf(startId);
        $jacocoInit[94] = true;
    }
}
