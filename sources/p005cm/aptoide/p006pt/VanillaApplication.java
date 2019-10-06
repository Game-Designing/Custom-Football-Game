package p005cm.aptoide.p006pt;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Environment;
import java.io.File;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.WebService;
import p005cm.aptoide.p006pt.networking.AuthenticationPersistence;
import p005cm.aptoide.p006pt.networking.IdsRepository;
import p005cm.aptoide.p006pt.networking.Pnp1AuthorizationInterceptor;
import p005cm.aptoide.p006pt.notification.NotificationService;
import p005cm.aptoide.p006pt.notification.NotificationSyncScheduler;
import p005cm.aptoide.p006pt.notification.sync.NotificationSyncFactory;
import p005cm.aptoide.p006pt.notification.sync.NotificationSyncManager;
import p005cm.aptoide.p006pt.sync.SyncScheduler;
import p005cm.aptoide.p006pt.view.ActivityProvider;
import p005cm.aptoide.p006pt.view.FragmentProvider;
import p005cm.aptoide.p006pt.view.configuration.implementation.VanillaActivityProvider;
import p005cm.aptoide.p006pt.view.configuration.implementation.VanillaFragmentProvider;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.VanillaApplication */
public class VanillaApplication extends NotificationApplicationView {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private NotificationSyncScheduler notificationSyncScheduler;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3163006063282601077L, "cm/aptoide/pt/VanillaApplication", 22);
        $jacocoData = probes;
        return probes;
    }

    public VanillaApplication() {
        $jacocoInit()[0] = true;
    }

    public String getCachePath() {
        boolean[] $jacocoInit = $jacocoInit();
        StringBuilder sb = new StringBuilder();
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        $jacocoInit[1] = true;
        sb.append(externalStorageDirectory.getAbsolutePath());
        sb.append("/.aptoide/");
        String sb2 = sb.toString();
        $jacocoInit[2] = true;
        return sb2;
    }

    public String getFeedbackEmail() {
        $jacocoInit()[3] = true;
        return "support@aptoide.com";
    }

    public String getAccountType() {
        $jacocoInit()[4] = true;
        return "cm.aptoide.pt";
    }

    public String getPartnerId() {
        $jacocoInit()[5] = true;
        return null;
    }

    public String getExtraId() {
        $jacocoInit()[6] = true;
        return null;
    }

    public boolean isCreateStoreUserPrivacyEnabled() {
        $jacocoInit()[7] = true;
        return true;
    }

    public NotificationSyncScheduler getNotificationSyncScheduler() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = true;
        if (this.notificationSyncScheduler != null) {
            $jacocoInit[8] = true;
        } else {
            $jacocoInit[9] = true;
            SyncScheduler alarmSyncScheduler = getAlarmSyncScheduler();
            Builder builder = new Builder();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            $jacocoInit[10] = true;
            Builder readTimeout = builder.readTimeout(45, timeUnit);
            TimeUnit timeUnit2 = TimeUnit.SECONDS;
            $jacocoInit[11] = true;
            Builder writeTimeout = readTimeout.writeTimeout(45, timeUnit2);
            $jacocoInit[12] = true;
            AuthenticationPersistence authenticationPersistence = getAuthenticationPersistence();
            $jacocoInit[13] = true;
            Pnp1AuthorizationInterceptor pnp1AuthorizationInterceptor = new Pnp1AuthorizationInterceptor(authenticationPersistence, getTokenInvalidator());
            $jacocoInit[14] = true;
            Builder addInterceptor = writeTimeout.addInterceptor(pnp1AuthorizationInterceptor);
            $jacocoInit[15] = true;
            OkHttpClient build = addInterceptor.build();
            Factory defaultConverter = WebService.getDefaultConverter();
            IdsRepository idsRepository = getIdsRepository();
            $jacocoInit[16] = true;
            String extraId = getExtraId();
            SharedPreferences defaultSharedPreferences = getDefaultSharedPreferences();
            Resources resources = getResources();
            $jacocoInit[17] = true;
            NotificationService notificationService = r6;
            NotificationService notificationService2 = new NotificationService("cm.aptoide.pt", build, defaultConverter, idsRepository, BuildConfig.VERSION_NAME, extraId, defaultSharedPreferences, resources, getAccountManager());
            NotificationSyncFactory notificationSyncFactory = new NotificationSyncFactory(notificationService, getNotificationProvider());
            z = true;
            this.notificationSyncScheduler = new NotificationSyncManager(alarmSyncScheduler, true, notificationSyncFactory);
            $jacocoInit[18] = true;
        }
        NotificationSyncScheduler notificationSyncScheduler2 = this.notificationSyncScheduler;
        $jacocoInit[19] = z;
        return notificationSyncScheduler2;
    }

    public FragmentProvider createFragmentProvider() {
        boolean[] $jacocoInit = $jacocoInit();
        VanillaFragmentProvider vanillaFragmentProvider = new VanillaFragmentProvider();
        $jacocoInit[20] = true;
        return vanillaFragmentProvider;
    }

    public ActivityProvider createActivityProvider() {
        boolean[] $jacocoInit = $jacocoInit();
        VanillaActivityProvider vanillaActivityProvider = new VanillaActivityProvider();
        $jacocoInit[21] = true;
        return vanillaActivityProvider;
    }
}
