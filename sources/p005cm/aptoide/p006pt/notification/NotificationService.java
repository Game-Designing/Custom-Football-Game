package p005cm.aptoide.p006pt.notification;

import android.content.SharedPreferences;
import android.content.res.Resources;
import java.util.LinkedList;
import java.util.List;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.Account;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.p006pt.dataprovider.model.p075v1.Attr;
import p005cm.aptoide.p006pt.dataprovider.model.p075v1.GetPullNotificationsResponse;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p076v1.notification.PullCampaignNotificationsRequest;
import p005cm.aptoide.p006pt.networking.IdsRepository;
import p026rx.C0120S;
import p026rx.Single;
import p026rx.p027b.C0132p;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.notification.NotificationService */
public class NotificationService {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AptoideAccountManager accountManager;
    private final String applicationId;
    private final Factory converterFactory;
    private final String extraId;
    private final OkHttpClient httpClient;
    private final IdsRepository idsRepository;
    private final Resources resources;
    private final SharedPreferences sharedPreferences;
    private final String versionName;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1467203677861781473L, "cm/aptoide/pt/notification/NotificationService", 28);
        $jacocoData = probes;
        return probes;
    }

    public NotificationService(String applicationId2, OkHttpClient httpClient2, Factory converterFactory2, IdsRepository idsRepository2, String versionName2, String extraId2, SharedPreferences sharedPreferences2, Resources resources2, AptoideAccountManager accountManager2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.applicationId = applicationId2;
        this.httpClient = httpClient2;
        this.converterFactory = converterFactory2;
        this.idsRepository = idsRepository2;
        this.versionName = versionName2;
        this.extraId = extraId2;
        this.sharedPreferences = sharedPreferences2;
        this.resources = resources2;
        this.accountManager = accountManager2;
        $jacocoInit[0] = true;
    }

    public Single<List<AptoideNotification>> getCampaignNotifications() {
        boolean[] $jacocoInit = $jacocoInit();
        PullCampaignNotificationsRequest of = PullCampaignNotificationsRequest.m7434of(this.idsRepository.getUniqueIdentifier(), this.versionName, this.applicationId, this.httpClient, this.converterFactory, this.extraId, this.sharedPreferences, this.resources);
        $jacocoInit[1] = true;
        C0120S observe = of.observe();
        C4231v vVar = new C4231v(this);
        $jacocoInit[2] = true;
        C0120S f = observe.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) vVar);
        $jacocoInit[3] = true;
        C0120S d = f.mo3647d();
        $jacocoInit[4] = true;
        Single<List<AptoideNotification>> n = d.mo3678n();
        $jacocoInit[5] = true;
        return n;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo2233a(List response) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S accountStatus = this.accountManager.accountStatus();
        $jacocoInit[24] = true;
        C0120S d = accountStatus.mo3647d();
        C4248w wVar = new C4248w(this, response);
        $jacocoInit[25] = true;
        C0120S j = d.mo3669j(wVar);
        $jacocoInit[26] = true;
        return j;
    }

    /* renamed from: a */
    public /* synthetic */ List mo2232a(List response, Account account) {
        boolean[] $jacocoInit = $jacocoInit();
        List convertCampaignNotifications = convertCampaignNotifications(response, account.getId());
        $jacocoInit[27] = true;
        return convertCampaignNotifications;
    }

    private List<AptoideNotification> convertCampaignNotifications(List<GetPullNotificationsResponse> response, String id) {
        boolean[] $jacocoInit = $jacocoInit();
        List<AptoideNotification> aptoideNotifications = new LinkedList<>();
        $jacocoInit[6] = true;
        $jacocoInit[7] = true;
        for (GetPullNotificationsResponse notification : response) {
            String appName = null;
            String graphic = null;
            $jacocoInit[8] = true;
            if (notification.getAttr() == null) {
                $jacocoInit[9] = true;
            } else {
                $jacocoInit[10] = true;
                Attr attr = notification.getAttr();
                $jacocoInit[11] = true;
                appName = attr.getAppName();
                $jacocoInit[12] = true;
                Attr attr2 = notification.getAttr();
                $jacocoInit[13] = true;
                graphic = attr2.getAppGraphic();
                $jacocoInit[14] = true;
            }
            $jacocoInit[15] = true;
            String body = notification.getBody();
            String img = notification.getImg();
            $jacocoInit[16] = true;
            String title = notification.getTitle();
            String url = notification.getUrl();
            $jacocoInit[17] = true;
            String urlTrack = notification.getUrlTrack();
            $jacocoInit[18] = true;
            String urlTrackNc = notification.getUrlTrackNc();
            long currentTimeMillis = System.currentTimeMillis();
            $jacocoInit[19] = true;
            Long expire = notification.getExpire();
            String abTestingGroup = notification.getAbTestingGroup();
            $jacocoInit[20] = true;
            AptoideNotification aptoideNotification = new AptoideNotification(body, img, title, url, 0, appName, graphic, -1, id, urlTrack, urlTrackNc, false, currentTimeMillis, expire, abTestingGroup, notification.getCampaignId(), notification.getLang());
            $jacocoInit[21] = true;
            aptoideNotifications.add(aptoideNotification);
            $jacocoInit[22] = true;
        }
        $jacocoInit[23] = true;
        return aptoideNotifications;
    }
}
