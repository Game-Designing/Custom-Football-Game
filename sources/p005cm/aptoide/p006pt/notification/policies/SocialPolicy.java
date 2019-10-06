package p005cm.aptoide.p006pt.notification.policies;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.notification.NotificationProvider;
import p005cm.aptoide.p006pt.notification.Policy;
import p026rx.Single;

/* renamed from: cm.aptoide.pt.notification.policies.SocialPolicy */
public class SocialPolicy implements Policy {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final int police1Occurrences = 1;
    private static final long police1timeFrame = TimeUnit.HOURS.toMillis(1);
    private static final int police2Occurrences = 3;
    private static final long police2timeFrame = TimeUnit.DAYS.toMillis(1);
    private NotificationProvider notificationProvider;
    private Integer[] notificationsTypes;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1996062116407186731L, "cm/aptoide/pt/notification/policies/SocialPolicy", 17);
        $jacocoData = probes;
        return probes;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[15] = true;
        $jacocoInit[16] = true;
    }

    public SocialPolicy(NotificationProvider notificationProvider2, Integer[] notificationsTypes2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.notificationProvider = notificationProvider2;
        this.notificationsTypes = notificationsTypes2;
        $jacocoInit[0] = true;
    }

    public Single<Boolean> shouldShow() {
        boolean[] $jacocoInit = $jacocoInit();
        long now = System.currentTimeMillis();
        long police1startTime = now - police1timeFrame;
        long police2startTime = now - police2timeFrame;
        $jacocoInit[1] = true;
        long j = now;
        Single createPolicy = createPolicy(this.notificationsTypes, j, police1startTime, 1);
        Integer[] numArr = this.notificationsTypes;
        $jacocoInit[2] = true;
        Single single = createPolicy;
        Single createPolicy2 = createPolicy(numArr, j, police2startTime, 3);
        C4219b bVar = C4219b.f7789a;
        $jacocoInit[3] = true;
        Single<Boolean> a = Single.m740a(single, createPolicy2, bVar);
        $jacocoInit[4] = true;
        return a;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m8635a(Boolean passRule1, Boolean passRule2) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!passRule1.booleanValue()) {
            $jacocoInit[10] = true;
        } else if (!passRule2.booleanValue()) {
            $jacocoInit[11] = true;
        } else {
            $jacocoInit[12] = true;
            z = true;
            Boolean valueOf = Boolean.valueOf(z);
            $jacocoInit[14] = true;
            return valueOf;
        }
        z = false;
        $jacocoInit[13] = true;
        Boolean valueOf2 = Boolean.valueOf(z);
        $jacocoInit[14] = true;
        return valueOf2;
    }

    private Single<Boolean> createPolicy(Integer[] notificationsTypes2, long endTime, long startTime, int occurrences) {
        boolean[] $jacocoInit = $jacocoInit();
        Single dismissedNotifications = this.notificationProvider.getDismissedNotifications(notificationsTypes2, startTime, endTime);
        C4218a aVar = new C4218a(occurrences);
        $jacocoInit[5] = true;
        Single<Boolean> d = dismissedNotifications.mo3698d(aVar);
        $jacocoInit[6] = true;
        return d;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m8634a(int occurrences, List aptoideNotifications) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (aptoideNotifications.size() < occurrences) {
            $jacocoInit[7] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[8] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[9] = true;
        return valueOf;
    }
}
