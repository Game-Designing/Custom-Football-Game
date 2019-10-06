package p005cm.aptoide.p006pt.social.data;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.social.data.User */
public class User {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final int NO_FOLLOWERS = -1;
    public static final int NO_FOLLOWINGS = -1;
    public static final int NO_NOTIFICATION_ID = -1;
    private final String analyticsUrl;
    private final String bodyMessage;
    private final long followers;
    private final long following;
    private final String image;
    private boolean isLogged;
    private final int notificationId;
    private final String urlAction;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1578448601735866440L, "cm/aptoide/pt/social/data/User", 23);
        $jacocoData = probes;
        return probes;
    }

    public User(String bodyMessage2, String image2, String urlAction2, int notificationId2, boolean isLogged2, String analyticsUrl2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.bodyMessage = bodyMessage2;
        this.image = image2;
        this.urlAction = urlAction2;
        this.notificationId = notificationId2;
        this.isLogged = isLogged2;
        this.analyticsUrl = analyticsUrl2;
        this.followers = -1;
        this.following = -1;
        $jacocoInit[0] = true;
    }

    public User(boolean isLogged2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.isLogged = isLogged2;
        this.bodyMessage = null;
        this.image = null;
        this.urlAction = null;
        this.notificationId = -1;
        this.followers = -1;
        this.following = -1;
        this.analyticsUrl = null;
        $jacocoInit[1] = true;
    }

    public User(long followers2, long following2, boolean isLogged2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.followers = followers2;
        this.following = following2;
        this.isLogged = isLogged2;
        this.bodyMessage = null;
        this.image = null;
        this.urlAction = null;
        this.notificationId = -1;
        this.analyticsUrl = null;
        $jacocoInit[2] = true;
    }

    public long getFollowers() {
        boolean[] $jacocoInit = $jacocoInit();
        long j = this.followers;
        $jacocoInit[3] = true;
        return j;
    }

    public long getFollowing() {
        boolean[] $jacocoInit = $jacocoInit();
        long j = this.following;
        $jacocoInit[4] = true;
        return j;
    }

    public String getBodyMessage() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.bodyMessage;
        $jacocoInit[5] = true;
        return str;
    }

    public String getImage() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.image;
        $jacocoInit[6] = true;
        return str;
    }

    public String getUrlAction() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.urlAction;
        $jacocoInit[7] = true;
        return str;
    }

    public int getNotificationId() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.notificationId;
        $jacocoInit[8] = true;
        return i;
    }

    public boolean isLogged() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.isLogged;
        $jacocoInit[9] = true;
        return z;
    }

    public boolean hasNotification() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (this.bodyMessage == null) {
            $jacocoInit[10] = true;
        } else if (this.image == null) {
            $jacocoInit[11] = true;
        } else if (this.urlAction == null) {
            $jacocoInit[12] = true;
        } else if (this.notificationId == -1) {
            $jacocoInit[13] = true;
        } else {
            $jacocoInit[14] = true;
            z = true;
            $jacocoInit[16] = true;
            return z;
        }
        z = false;
        $jacocoInit[15] = true;
        $jacocoInit[16] = true;
        return z;
    }

    public boolean hasStats() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (getFollowers() == -1) {
            $jacocoInit[17] = true;
        } else if (getFollowing() == -1) {
            $jacocoInit[18] = true;
        } else {
            $jacocoInit[19] = true;
            z = true;
            $jacocoInit[21] = true;
            return z;
        }
        z = false;
        $jacocoInit[20] = true;
        $jacocoInit[21] = true;
        return z;
    }

    public String getAnalyticsUrl() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.analyticsUrl;
        $jacocoInit[22] = true;
        return str;
    }
}
