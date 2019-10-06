package com.mopub.volley.toolbox;

import android.content.Context;
import com.mopub.volley.Network;
import com.mopub.volley.RequestQueue;
import java.io.File;

public class Volley {
    public static RequestQueue newRequestQueue(Context context, BaseHttpStack stack) {
        BasicNetwork network;
        if (stack == null) {
            network = new BasicNetwork(new HurlStack());
        } else {
            network = new BasicNetwork(stack);
        }
        return m38678a(context, network);
    }

    /* renamed from: a */
    private static RequestQueue m38678a(Context context, Network network) {
        RequestQueue queue = new RequestQueue(new DiskBasedCache(new File(context.getCacheDir(), "volley")), network);
        queue.start();
        return queue;
    }
}
