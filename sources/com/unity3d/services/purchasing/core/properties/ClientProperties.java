package com.unity3d.services.purchasing.core.properties;

import com.unity3d.services.purchasing.core.IPurchasingAdapter;

public class ClientProperties {
    private static IPurchasingAdapter adapter;

    public static void setAdapter(IPurchasingAdapter adapter2) {
        adapter = adapter2;
    }

    public static IPurchasingAdapter getAdapter() {
        return adapter;
    }
}
