package p005cm.aptoide.p006pt.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.p000v4.app.C0448aa.C0451c;
import android.support.p000v4.content.C0510b;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.bumptech.glide.C5926c;
import com.bumptech.glide.C6029k;
import com.bumptech.glide.C6354n;
import com.bumptech.glide.p103f.C5980b;
import com.bumptech.glide.p103f.p104a.C5973f;
import java.util.concurrent.Callable;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory.Builder;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.NotificationApplicationView;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.install.installer.RootInstallErrorNotification;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p005cm.aptoide.p006pt.presenter.Presenter;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.C0137ja;
import p026rx.Single;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0131o;
import p026rx.p027b.C0132p;
import p026rx.p029i.C0136c;
import p026rx.p387a.p389b.C14522a;
import p026rx.schedulers.Schedulers;

/* renamed from: cm.aptoide.pt.notification.SystemNotificationShower */
public class SystemNotificationShower implements Presenter {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private Context context;
    private CrashReport crashReport;
    private final NavigationTracker navigationTracker;
    private NotificationAnalytics notificationAnalytics;
    private NotificationCenter notificationCenter;
    private NotificationIdsMapper notificationIdsMapper;
    private NotificationManager notificationManager;
    private NotificationProvider notificationProvider;
    private C0136c subscriptions;
    private NotificationApplicationView view;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7681435745503209825L, "cm/aptoide/pt/notification/SystemNotificationShower", Opcodes.MULTIANEWARRAY);
        $jacocoData = probes;
        return probes;
    }

    public SystemNotificationShower(Context context2, NotificationManager notificationManager2, NotificationIdsMapper notificationIdsMapper2, NotificationCenter notificationCenter2, NotificationAnalytics notificationAnalytics2, CrashReport crashReport2, NotificationProvider notificationProvider2, NotificationApplicationView notificationApplicationView, C0136c subscriptions2, NavigationTracker navigationTracker2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.context = context2;
        this.notificationManager = notificationManager2;
        this.notificationIdsMapper = notificationIdsMapper2;
        this.notificationCenter = notificationCenter2;
        this.notificationAnalytics = notificationAnalytics2;
        this.crashReport = crashReport2;
        this.notificationProvider = notificationProvider2;
        this.subscriptions = subscriptions2;
        this.view = notificationApplicationView;
        this.navigationTracker = navigationTracker2;
        $jacocoInit[0] = true;
    }

    public void present() {
        boolean[] $jacocoInit = $jacocoInit();
        setNotificationPressSubscribe();
        $jacocoInit[1] = true;
        setNotificationDismissSubscribe();
        $jacocoInit[2] = true;
        setNotificationBootCompletedSubscribe();
        $jacocoInit[3] = true;
        showNewNotification();
        $jacocoInit[4] = true;
    }

    private void showNewNotification() {
        boolean[] $jacocoInit = $jacocoInit();
        C0136c cVar = this.subscriptions;
        C0120S newNotifications = this.notificationCenter.getNewNotifications();
        C4201ha haVar = new C4201ha(this);
        $jacocoInit[5] = true;
        C0120S g = newNotifications.mo3663g((C0132p<? super T, ? extends C0117M>) haVar);
        C4159Ba ba = C4159Ba.f7706a;
        C4209la laVar = new C4209la(this);
        $jacocoInit[6] = true;
        C0137ja a = g.mo3626a((C0129b<? super T>) ba, (C0129b<Throwable>) laVar);
        $jacocoInit[7] = true;
        cVar.mo3713a(a);
        $jacocoInit[8] = true;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo2254a(AptoideNotification aptoideNotification) {
        boolean[] $jacocoInit = $jacocoInit();
        NotificationIdsMapper notificationIdsMapper2 = this.notificationIdsMapper;
        $jacocoInit[184] = true;
        int notificationId = notificationIdsMapper2.getNotificationId(aptoideNotification.getType());
        $jacocoInit[185] = true;
        if (aptoideNotification.getType() != 7) {
            $jacocoInit[186] = true;
            NotificationAnalytics notificationAnalytics2 = this.notificationAnalytics;
            int type = aptoideNotification.getType();
            $jacocoInit[187] = true;
            String abTestingGroup = aptoideNotification.getAbTestingGroup();
            int campaignId = aptoideNotification.getCampaignId();
            $jacocoInit[188] = true;
            String url = aptoideNotification.getUrl();
            $jacocoInit[189] = true;
            notificationAnalytics2.sendPushNotficationImpressionEvent(type, abTestingGroup, campaignId, url);
            $jacocoInit[190] = true;
            Single b = mapToAndroidNotification(aptoideNotification, notificationId).mo3695b((C0129b<? super T>) new C4215oa<Object>(this, notificationId));
            $jacocoInit[191] = true;
            C0117M b2 = b.mo3692b();
            $jacocoInit[192] = true;
            return b2;
        }
        Single b3 = mapLocalToAndroidNotification(aptoideNotification, notificationId).mo3695b((C0129b<? super T>) new C4230ua<Object>(this, notificationId));
        $jacocoInit[193] = true;
        C0117M b4 = b3.mo3692b();
        $jacocoInit[194] = true;
        return b4;
    }

    /* renamed from: a */
    public /* synthetic */ void mo2256a(int notificationId, Notification notification) {
        boolean[] $jacocoInit = $jacocoInit();
        this.notificationManager.notify(notificationId, notification);
        $jacocoInit[196] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo2262b(int notificationId, Notification notification) {
        boolean[] $jacocoInit = $jacocoInit();
        this.notificationManager.notify(notificationId, notification);
        $jacocoInit[195] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m452b(AptoideNotification notification) {
        $jacocoInit()[183] = true;
    }

    /* renamed from: d */
    public /* synthetic */ void mo2266d(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(throwable);
        $jacocoInit[182] = true;
    }

    private Single<Notification> mapToAndroidNotification(AptoideNotification aptoideNotification, int notificationId) {
        boolean[] $jacocoInit = $jacocoInit();
        Single pressIntentAction = getPressIntentAction(aptoideNotification.getUrlTrack(), aptoideNotification.getUrl(), notificationId, this.context);
        C4223ra raVar = new C4223ra(this, aptoideNotification, notificationId);
        $jacocoInit[9] = true;
        Single<Notification> a = pressIntentAction.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) raVar);
        $jacocoInit[10] = true;
        return a;
    }

    /* renamed from: b */
    public /* synthetic */ Single mo2261b(AptoideNotification aptoideNotification, int notificationId, PendingIntent pressIntentAction) {
        boolean[] $jacocoInit = $jacocoInit();
        Context context2 = this.context;
        String title = aptoideNotification.getTitle();
        $jacocoInit[177] = true;
        String body = aptoideNotification.getBody();
        String img = aptoideNotification.getImg();
        $jacocoInit[178] = true;
        PendingIntent onDismissAction = getOnDismissAction(notificationId);
        String appName = aptoideNotification.getAppName();
        $jacocoInit[179] = true;
        String graphic = aptoideNotification.getGraphic();
        $jacocoInit[180] = true;
        Single buildNotification = buildNotification(context2, title, body, img, pressIntentAction, notificationId, onDismissAction, appName, graphic);
        $jacocoInit[181] = true;
        return buildNotification;
    }

    private Single<Notification> mapLocalToAndroidNotification(AptoideNotification aptoideNotification, int notificationId) {
        boolean[] $jacocoInit = $jacocoInit();
        Single pressIntentAction = getPressIntentAction(aptoideNotification.getUrlTrack(), aptoideNotification.getUrl(), notificationId, this.context);
        C4199ga gaVar = new C4199ga(this, aptoideNotification, notificationId);
        $jacocoInit[11] = true;
        Single<Notification> a = pressIntentAction.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) gaVar);
        $jacocoInit[12] = true;
        return a;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo2255a(AptoideNotification aptoideNotification, int notificationId, PendingIntent pressIntentAction) {
        boolean[] $jacocoInit = $jacocoInit();
        Context context2 = this.context;
        String title = aptoideNotification.getTitle();
        $jacocoInit[173] = true;
        String body = aptoideNotification.getBody();
        String img = aptoideNotification.getImg();
        $jacocoInit[174] = true;
        PendingIntent onDismissAction = getOnDismissAction(notificationId);
        $jacocoInit[175] = true;
        Single buildLocalNotification = buildLocalNotification(context2, title, body, img, pressIntentAction, onDismissAction);
        $jacocoInit[176] = true;
        return buildLocalNotification;
    }

    private Single<PendingIntent> getPressIntentAction(String trackUrl, String url, int notificationId, Context context2) {
        boolean[] $jacocoInit = $jacocoInit();
        Single b = Single.m742b((Callable<? extends T>) new C4213na<Object>(context2, notificationId, trackUrl, url));
        $jacocoInit[13] = true;
        Single<PendingIntent> b2 = b.mo3694b(Schedulers.computation());
        $jacocoInit[14] = true;
        return b2;
    }

    /* renamed from: a */
    static /* synthetic */ PendingIntent m448a(Context context2, int notificationId, String trackUrl, String url) throws Exception {
        boolean[] $jacocoInit = $jacocoInit();
        Intent resultIntent = new Intent(context2, NotificationReceiver.class);
        $jacocoInit[163] = true;
        resultIntent.setAction(NotificationReceiver.NOTIFICATION_PRESSED_ACTION);
        $jacocoInit[164] = true;
        resultIntent.putExtra(NotificationReceiver.NOTIFICATION_NOTIFICATION_ID, notificationId);
        $jacocoInit[165] = true;
        if (TextUtils.isEmpty(trackUrl)) {
            $jacocoInit[166] = true;
        } else {
            $jacocoInit[167] = true;
            resultIntent.putExtra(NotificationReceiver.NOTIFICATION_TRACK_URL, trackUrl);
            $jacocoInit[168] = true;
        }
        if (TextUtils.isEmpty(url)) {
            $jacocoInit[169] = true;
        } else {
            $jacocoInit[170] = true;
            resultIntent.putExtra(NotificationReceiver.NOTIFICATION_TARGET_URL, url);
            $jacocoInit[171] = true;
        }
        PendingIntent broadcast = PendingIntent.getBroadcast(context2, notificationId, resultIntent, 134217728);
        $jacocoInit[172] = true;
        return broadcast;
    }

    private Single<Notification> buildLocalNotification(Context context2, String title, String body, String iconUrl, PendingIntent pressIntentAction, PendingIntent onDismissAction) {
        boolean[] $jacocoInit = $jacocoInit();
        C4251xa xaVar = new C4251xa(context2, pressIntentAction, title, body, onDismissAction, iconUrl);
        Single b = Single.m742b((Callable<? extends T>) xaVar);
        $jacocoInit[15] = true;
        Single b2 = b.mo3694b(Schedulers.computation());
        $jacocoInit[16] = true;
        Single<Notification> a = b2.mo3686a(C14522a.m46170a());
        $jacocoInit[17] = true;
        return a;
    }

    /* renamed from: a */
    static /* synthetic */ Notification m446a(Context context2, PendingIntent pressIntentAction, String title, String body, PendingIntent onDismissAction, String iconUrl) throws Exception {
        boolean[] $jacocoInit = $jacocoInit();
        C0451c cVar = new C0451c(context2);
        $jacocoInit[144] = true;
        cVar.mo5110a(pressIntentAction);
        $jacocoInit[145] = true;
        cVar.mo5120c((int) C1375R.drawable.ic_stat_aptoide_notification);
        $jacocoInit[146] = true;
        cVar.mo5106a(C0510b.m2564a(context2, (int) C1375R.color.default_orange_gradient_end));
        $jacocoInit[147] = true;
        cVar.mo5121c((CharSequence) title);
        $jacocoInit[148] = true;
        cVar.mo5118b((CharSequence) body);
        $jacocoInit[149] = true;
        Resources resources = context2.getResources();
        $jacocoInit[150] = true;
        String string = resources.getString(C1375R.string.promo_update2appc_notification_dismiss_button);
        $jacocoInit[151] = true;
        cVar.mo5108a(0, (CharSequence) string, onDismissAction);
        $jacocoInit[152] = true;
        Resources resources2 = context2.getResources();
        $jacocoInit[153] = true;
        String string2 = resources2.getString(C1375R.string.promo_update2appc_notification_claim_button);
        $jacocoInit[154] = true;
        cVar.mo5108a(0, (CharSequence) string2, pressIntentAction);
        $jacocoInit[155] = true;
        C6354n b = C5926c.m10920b(context2);
        $jacocoInit[156] = true;
        C6029k a = b.mo19314a();
        $jacocoInit[157] = true;
        a.mo18841a(iconUrl);
        $jacocoInit[158] = true;
        C5980b b2 = a.mo18842b();
        $jacocoInit[159] = true;
        Bitmap bitmap = (Bitmap) b2.get();
        $jacocoInit[160] = true;
        cVar.mo5111a(bitmap);
        $jacocoInit[161] = true;
        Notification notification = cVar.mo5105a();
        notification.flags = 20;
        $jacocoInit[162] = true;
        return notification;
    }

    private Single<Notification> buildNotification(Context context2, String title, String body, String iconUrl, PendingIntent pressIntentAction, int notificationId, PendingIntent onDismissAction, String appName, String graphic) {
        boolean[] $jacocoInit = $jacocoInit();
        C4161Ca ca = new C4161Ca(context2, pressIntentAction, iconUrl, title, body, onDismissAction);
        Single b = Single.m742b((Callable<? extends T>) ca);
        $jacocoInit[18] = true;
        Single b2 = b.mo3694b(Schedulers.computation());
        $jacocoInit[19] = true;
        Single a = b2.mo3686a(C14522a.m46170a());
        C4203ia iaVar = new C4203ia(this, context2, title, body, notificationId, appName, graphic, iconUrl);
        $jacocoInit[20] = true;
        Single<Notification> d = a.mo3698d(iaVar);
        $jacocoInit[21] = true;
        return d;
    }

    /* renamed from: a */
    static /* synthetic */ Notification m447a(Context context2, PendingIntent pressIntentAction, String iconUrl, String title, String body, PendingIntent onDismissAction) throws Exception {
        boolean[] $jacocoInit = $jacocoInit();
        C0451c cVar = new C0451c(context2);
        $jacocoInit[133] = true;
        cVar.mo5110a(pressIntentAction);
        $jacocoInit[134] = true;
        cVar.mo5122c(false);
        $jacocoInit[135] = true;
        cVar.mo5120c((int) C1375R.drawable.ic_stat_aptoide_notification);
        $jacocoInit[136] = true;
        ImageLoader with = ImageLoader.with(context2);
        $jacocoInit[137] = true;
        Bitmap loadBitmap = with.loadBitmap(iconUrl);
        $jacocoInit[138] = true;
        cVar.mo5111a(loadBitmap);
        $jacocoInit[139] = true;
        cVar.mo5121c((CharSequence) title);
        $jacocoInit[140] = true;
        cVar.mo5118b((CharSequence) body);
        $jacocoInit[141] = true;
        cVar.mo5117b(onDismissAction);
        $jacocoInit[142] = true;
        Notification notification = cVar.mo5105a();
        notification.flags = 20;
        $jacocoInit[143] = true;
        return notification;
    }

    /* renamed from: a */
    public /* synthetic */ Notification mo2252a(Context context2, String title, String body, int notificationId, String appName, String graphic, String iconUrl, Notification notification) {
        boolean[] $jacocoInit = $jacocoInit();
        setExpandedView(context2, title, body, notificationId, notification, appName, graphic, iconUrl);
        $jacocoInit[132] = true;
        return notification;
    }

    private Notification setExpandedView(Context context2, String title, String body, int notificationId, Notification notification, String appName, String graphic, String iconUrl) {
        Notification notification2 = notification;
        boolean[] $jacocoInit = $jacocoInit();
        if (VERSION.SDK_INT < 16) {
            $jacocoInit[22] = true;
            String str = title;
            String str2 = body;
            String str3 = appName;
        } else {
            $jacocoInit[23] = true;
            RemoteViews remoteViews = new RemoteViews(context2.getPackageName(), C1375R.layout.pushnotificationlayout);
            $jacocoInit[24] = true;
            RemoteViews expandedView = remoteViews;
            loadImage(context2, notificationId, notification, iconUrl, expandedView, C1375R.C1376id.icon);
            $jacocoInit[25] = true;
            expandedView.setTextViewText(C1375R.C1376id.title, title);
            $jacocoInit[26] = true;
            expandedView.setTextViewText(C1375R.C1376id.app_name, appName);
            $jacocoInit[27] = true;
            expandedView.setTextViewText(C1375R.C1376id.description, body);
            $jacocoInit[28] = true;
            if (!TextUtils.isEmpty(graphic)) {
                $jacocoInit[29] = true;
                loadImage(context2, notificationId, notification, graphic, expandedView, C1375R.C1376id.push_notification_graphic);
                $jacocoInit[30] = true;
            } else {
                expandedView.setViewVisibility(C1375R.C1376id.push_notification_graphic, 8);
                $jacocoInit[31] = true;
            }
            notification2.bigContentView = expandedView;
            $jacocoInit[32] = true;
        }
        $jacocoInit[33] = true;
        return notification2;
    }

    private void loadImage(Context context2, int notificationId, Notification notification, String url, RemoteViews expandedView, int viewId) {
        boolean[] $jacocoInit = $jacocoInit();
        C5973f fVar = new C5973f(context2, viewId, expandedView, notification, notificationId);
        $jacocoInit[34] = true;
        C5973f notificationTarget = fVar;
        ImageLoader with = ImageLoader.with(context2);
        $jacocoInit[35] = true;
        with.loadImageToNotification(notificationTarget, url);
        $jacocoInit[36] = true;
    }

    public PendingIntent getOnDismissAction(int notificationId) {
        boolean[] $jacocoInit = $jacocoInit();
        Intent resultIntent = new Intent(this.context, NotificationReceiver.class);
        $jacocoInit[37] = true;
        resultIntent.setAction(NotificationReceiver.NOTIFICATION_DISMISSED_ACTION);
        $jacocoInit[38] = true;
        resultIntent.putExtra(NotificationReceiver.NOTIFICATION_NOTIFICATION_ID, notificationId);
        $jacocoInit[39] = true;
        PendingIntent broadcast = PendingIntent.getBroadcast(this.context, notificationId, resultIntent, 134217728);
        $jacocoInit[40] = true;
        return broadcast;
    }

    public void showNotification(Context context2, RootInstallErrorNotification installErrorNotification) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[41] = true;
        Notification notification = mapToAndroidNotification(context2, installErrorNotification);
        $jacocoInit[42] = true;
        this.notificationManager.notify(installErrorNotification.getNotificationId(), notification);
        $jacocoInit[43] = true;
    }

    private Notification mapToAndroidNotification(Context context2, RootInstallErrorNotification installErrorNotification) {
        boolean[] $jacocoInit = $jacocoInit();
        C0451c cVar = new C0451c(context2);
        $jacocoInit[44] = true;
        String message = installErrorNotification.getMessage();
        $jacocoInit[45] = true;
        cVar.mo5121c((CharSequence) message);
        $jacocoInit[46] = true;
        cVar.mo5120c((int) C1375R.drawable.ic_stat_aptoide_notification);
        $jacocoInit[47] = true;
        cVar.mo5111a(installErrorNotification.getIcon());
        $jacocoInit[48] = true;
        cVar.mo5115a(true);
        $jacocoInit[49] = true;
        cVar.mo5112a(installErrorNotification.getAction());
        $jacocoInit[50] = true;
        cVar.mo5117b(installErrorNotification.getDeleteAction());
        $jacocoInit[51] = true;
        Notification notification = cVar.mo5105a();
        notification.flags = 20;
        $jacocoInit[52] = true;
        return notification;
    }

    public void dismissNotification(int notificationId) {
        boolean[] $jacocoInit = $jacocoInit();
        this.notificationManager.cancel(notificationId);
        $jacocoInit[53] = true;
    }

    private C0117M dismissNotificationAfterAction(int notificationId) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M a = C0117M.m586a((C0131o<? extends C0117M>) new C4217pa<Object>(this, notificationId));
        $jacocoInit[54] = true;
        return a;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo2253a(int notificationId) {
        boolean[] $jacocoInit = $jacocoInit();
        try {
            NotificationCenter notificationCenter2 = this.notificationCenter;
            NotificationIdsMapper notificationIdsMapper2 = this.notificationIdsMapper;
            $jacocoInit[127] = true;
            Integer[] notificationType = notificationIdsMapper2.getNotificationType(notificationId);
            $jacocoInit[128] = true;
            C0117M notificationDismissed = notificationCenter2.notificationDismissed(notificationType);
            $jacocoInit[129] = true;
            return notificationDismissed;
        } catch (RuntimeException e) {
            $jacocoInit[130] = true;
            C0117M b = C0117M.m591b((Throwable) e);
            $jacocoInit[131] = true;
            return b;
        }
    }

    private void callDeepLink(Context context2, NotificationInfo notificationInfo) {
        boolean[] $jacocoInit = $jacocoInit();
        String targetUrl = notificationInfo.getNotificationUrl();
        $jacocoInit[55] = true;
        Intent i = new Intent("android.intent.action.VIEW", Uri.parse(targetUrl));
        $jacocoInit[56] = true;
        i.setFlags(268435456);
        try {
            $jacocoInit[57] = true;
            context2.startActivity(i);
            $jacocoInit[58] = true;
        } catch (ActivityNotFoundException e) {
            $jacocoInit[59] = true;
            this.crashReport.log(e);
            $jacocoInit[60] = true;
        }
        $jacocoInit[61] = true;
    }

    private void setNotificationBootCompletedSubscribe() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S actionBootCompleted = this.view.getActionBootCompleted();
        C4193da daVar = new C4193da(this);
        $jacocoInit[62] = true;
        C0120S b = actionBootCompleted.mo3636b((C0129b<? super T>) daVar);
        C4255za zaVar = C4255za.f7838a;
        C4249wa waVar = new C4249wa(this);
        $jacocoInit[63] = true;
        b.mo3626a((C0129b<? super T>) zaVar, (C0129b<Throwable>) waVar);
        $jacocoInit[64] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo2258a(NotificationInfo __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.notificationCenter.setup();
        $jacocoInit[126] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m453b(NotificationInfo __) {
        $jacocoInit()[125] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo2260a(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(throwable);
        $jacocoInit[124] = true;
    }

    private void setNotificationDismissSubscribe() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S notificationDismissed = this.view.getNotificationDismissed();
        C4253ya yaVar = C4253ya.f7836a;
        $jacocoInit[65] = true;
        C0120S d = notificationDismissed.mo3653d((C0132p<? super T, Boolean>) yaVar);
        C4189ba baVar = new C4189ba(this);
        $jacocoInit[66] = true;
        C0120S b = d.mo3636b((C0129b<? super T>) baVar);
        C4207ka kaVar = new C4207ka(this);
        $jacocoInit[67] = true;
        C0120S d2 = b.mo3653d((C0132p<? super T, Boolean>) kaVar);
        C4197fa faVar = new C4197fa(this);
        $jacocoInit[68] = true;
        C0120S g = d2.mo3663g((C0132p<? super T, ? extends C0117M>) faVar);
        $jacocoInit[69] = true;
        C0117M l = g.mo3673l();
        C4157Aa aa = C4157Aa.f7704a;
        C4225sa saVar = new C4225sa(this);
        $jacocoInit[70] = true;
        l.mo3588a((C0128a) aa, (C0129b<? super Throwable>) saVar);
        $jacocoInit[71] = true;
    }

    /* renamed from: c */
    static /* synthetic */ Boolean m454c(NotificationInfo notificationInfo) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (notificationInfo.getNotificationType() < 8) {
            $jacocoInit[121] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[122] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[123] = true;
        return valueOf;
    }

    /* renamed from: d */
    public /* synthetic */ void mo2265d(NotificationInfo notificationInfo) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[118] = true;
        int notificationType = notificationInfo.getNotificationType();
        $jacocoInit[119] = true;
        dismissNotificationAfterAction(notificationType);
        $jacocoInit[120] = true;
    }

    /* renamed from: e */
    public /* synthetic */ Boolean mo2268e(NotificationInfo notificationInfo) {
        boolean[] $jacocoInit = $jacocoInit();
        NotificationIdsMapper notificationIdsMapper2 = this.notificationIdsMapper;
        $jacocoInit[113] = true;
        int notificationType = notificationInfo.getNotificationType();
        $jacocoInit[114] = true;
        Integer num = notificationIdsMapper2.getNotificationType(notificationType)[0];
        $jacocoInit[115] = true;
        boolean equals = num.equals(Integer.valueOf(7));
        $jacocoInit[116] = true;
        Boolean valueOf = Boolean.valueOf(equals);
        $jacocoInit[117] = true;
        return valueOf;
    }

    /* renamed from: f */
    public /* synthetic */ C0117M mo2269f(NotificationInfo notificationInfo) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M deleteAllForType = this.notificationProvider.deleteAllForType(7);
        $jacocoInit[112] = true;
        return deleteAllForType;
    }

    /* renamed from: a */
    static /* synthetic */ void m449a() {
        $jacocoInit()[111] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo2263b(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(throwable);
        $jacocoInit[110] = true;
    }

    private void setNotificationPressSubscribe() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S notificationClick = this.view.getNotificationClick();
        C4232va vaVar = new C4232va(this);
        $jacocoInit[72] = true;
        C0120S i = notificationClick.mo3668i(vaVar);
        C4221qa qaVar = new C4221qa(this);
        $jacocoInit[73] = true;
        C0120S b = i.mo3636b((C0129b<? super T>) qaVar);
        C4205ja jaVar = new C4205ja(this);
        $jacocoInit[74] = true;
        C0120S d = b.mo3653d((C0132p<? super T, Boolean>) jaVar);
        C4195ea eaVar = new C4195ea(this);
        $jacocoInit[75] = true;
        C0120S g = d.mo3663g((C0132p<? super T, ? extends C0117M>) eaVar);
        $jacocoInit[76] = true;
        C0117M l = g.mo3673l();
        C4163Da da = C4163Da.f7715a;
        C4165Ea ea = new C4165Ea(this);
        $jacocoInit[77] = true;
        l.mo3588a((C0128a) da, (C0129b<? super Throwable>) ea);
        $jacocoInit[78] = true;
    }

    /* renamed from: g */
    public /* synthetic */ Single mo2270g(NotificationInfo notificationInfo) {
        boolean[] $jacocoInit = $jacocoInit();
        NotificationProvider notificationProvider2 = this.notificationProvider;
        NotificationIdsMapper notificationIdsMapper2 = this.notificationIdsMapper;
        $jacocoInit[89] = true;
        Integer[] notificationType = notificationIdsMapper2.getNotificationType(notificationInfo.getNotificationType());
        $jacocoInit[90] = true;
        Single lastShowed = notificationProvider2.getLastShowed(notificationType);
        C4228ta taVar = new C4228ta(this, notificationInfo);
        $jacocoInit[91] = true;
        Single b = lastShowed.mo3695b((C0129b<? super T>) taVar);
        C4191ca caVar = new C4191ca(this);
        $jacocoInit[92] = true;
        Single b2 = b.mo3695b((C0129b<? super T>) caVar);
        C4211ma maVar = new C4211ma(notificationInfo);
        $jacocoInit[93] = true;
        Single d = b2.mo3698d(maVar);
        $jacocoInit[94] = true;
        return d;
    }

    /* renamed from: a */
    public /* synthetic */ void mo2259a(NotificationInfo notificationInfo, p005cm.aptoide.p006pt.database.realm.Notification notification) {
        boolean[] $jacocoInit = $jacocoInit();
        if (notification.getType() == 7) {
            $jacocoInit[99] = true;
        } else {
            $jacocoInit[100] = true;
            NotificationAnalytics notificationAnalytics2 = this.notificationAnalytics;
            int type = notification.getType();
            $jacocoInit[101] = true;
            String abTestingGroup = notification.getAbTestingGroup();
            int campaignId = notification.getCampaignId();
            $jacocoInit[102] = true;
            String url = notification.getUrl();
            $jacocoInit[103] = true;
            notificationAnalytics2.sendPushNotificationPressedEvent(type, abTestingGroup, campaignId, url);
            NotificationAnalytics notificationAnalytics3 = this.notificationAnalytics;
            $jacocoInit[104] = true;
            String notificationTrackUrl = notificationInfo.getNotificationTrackUrl();
            $jacocoInit[105] = true;
            int notificationType = notificationInfo.getNotificationType();
            String notificationUrl = notificationInfo.getNotificationUrl();
            $jacocoInit[106] = true;
            int campaignId2 = notification.getCampaignId();
            String abTestingGroup2 = notification.getAbTestingGroup();
            $jacocoInit[107] = true;
            notificationAnalytics3.sendNotificationTouchEvent(notificationTrackUrl, notificationType, notificationUrl, campaignId2, abTestingGroup2);
            $jacocoInit[108] = true;
        }
        $jacocoInit[109] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo2257a(p005cm.aptoide.p006pt.database.realm.Notification notification) {
        boolean[] $jacocoInit = $jacocoInit();
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[96] = true;
        ScreenTagHistory build = Builder.build("Notification");
        $jacocoInit[97] = true;
        navigationTracker2.registerScreen(build);
        $jacocoInit[98] = true;
    }

    /* renamed from: b */
    static /* synthetic */ NotificationInfo m450b(NotificationInfo notificationInfo, p005cm.aptoide.p006pt.database.realm.Notification notification) {
        $jacocoInit()[95] = true;
        return notificationInfo;
    }

    /* renamed from: h */
    public /* synthetic */ void mo2272h(NotificationInfo notificationInfo) {
        boolean[] $jacocoInit = $jacocoInit();
        callDeepLink(this.context, notificationInfo);
        $jacocoInit[87] = true;
        dismissNotificationAfterAction(notificationInfo.getNotificationType());
        $jacocoInit[88] = true;
    }

    /* renamed from: i */
    public /* synthetic */ Boolean mo2273i(NotificationInfo notificationInfo) {
        boolean[] $jacocoInit = $jacocoInit();
        NotificationIdsMapper notificationIdsMapper2 = this.notificationIdsMapper;
        $jacocoInit[82] = true;
        int notificationType = notificationInfo.getNotificationType();
        $jacocoInit[83] = true;
        Integer num = notificationIdsMapper2.getNotificationType(notificationType)[0];
        $jacocoInit[84] = true;
        boolean equals = num.equals(Integer.valueOf(7));
        $jacocoInit[85] = true;
        Boolean valueOf = Boolean.valueOf(equals);
        $jacocoInit[86] = true;
        return valueOf;
    }

    /* renamed from: j */
    public /* synthetic */ C0117M mo2274j(NotificationInfo notificationInfo) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M deleteAllForType = this.notificationProvider.deleteAllForType(7);
        $jacocoInit[81] = true;
        return deleteAllForType;
    }

    /* renamed from: b */
    static /* synthetic */ void m451b() {
        $jacocoInit()[80] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo2264c(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(throwable);
        $jacocoInit[79] = true;
    }
}
