package p005cm.aptoide.p006pt.dataprovider.util.referrer;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: cm.aptoide.pt.dataprovider.util.referrer.ReferrersMap */
public class ReferrersMap extends ConcurrentHashMap<String, List<Long>> {
    public void add(String packageName, long networkId) {
        if (networkId != -1) {
            if (!containsKey(packageName)) {
                put(packageName, new LinkedList());
            }
            ((List) get(packageName)).add(Long.valueOf(networkId));
        }
    }
}
