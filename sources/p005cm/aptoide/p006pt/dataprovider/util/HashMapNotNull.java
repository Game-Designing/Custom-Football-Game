package p005cm.aptoide.p006pt.dataprovider.util;

import java.util.HashMap;
import p005cm.aptoide.p006pt.dataprovider.p010ws.RefreshBody;

/* renamed from: cm.aptoide.pt.dataprovider.util.HashMapNotNull */
public class HashMapNotNull<K, V> extends HashMap<K, V> implements RefreshBody {
    public V put(K key, V value) {
        return value != null ? super.put(key, value) : value;
    }

    public void setRefresh(boolean refresh) {
    }
}
