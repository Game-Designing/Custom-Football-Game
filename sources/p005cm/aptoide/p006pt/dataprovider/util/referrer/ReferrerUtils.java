package p005cm.aptoide.p006pt.dataprovider.util.referrer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* renamed from: cm.aptoide.pt.dataprovider.util.referrer.ReferrerUtils */
public class ReferrerUtils {
    public static final int DELAY = 5;
    public static final int RETRIES = 2;
    public static final ReferrersMap excludedNetworks = new ReferrersMap();
    protected static final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
}
