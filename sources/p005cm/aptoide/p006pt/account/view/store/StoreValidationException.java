package p005cm.aptoide.p006pt.account.view.store;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.account.view.store.StoreValidationException */
class StoreValidationException extends Throwable {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final int EMPTY_AVATAR = 1;
    public static final int EMPTY_NAME = 0;
    public static final String FACEBOOK_1 = "FACEBOOK_1";
    public static final String FACEBOOK_2 = "FACEBOOK_2";
    public static final String TWITCH_1 = "TWITCH_1";
    public static final String TWITCH_2 = "TWITCH_2";
    public static final String TWITTER_1 = "TWITTER_1";
    public static final String TWITTER_2 = "TWITTER_2";
    public static final String YOUTUBE_1 = "YOUTUBE_1";
    public static final String YOUTUBE_2 = "YOUTUBE_2";
    private final int errorCode;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8969271836543329516L, "cm/aptoide/pt/account/view/store/StoreValidationException", 2);
        $jacocoData = probes;
        return probes;
    }

    public StoreValidationException(int errorCode2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.errorCode = errorCode2;
        $jacocoInit[0] = true;
    }

    public int getErrorCode() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.errorCode;
        $jacocoInit[1] = true;
        return i;
    }
}
