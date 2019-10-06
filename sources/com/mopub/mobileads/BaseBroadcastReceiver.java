package com.mopub.mobileads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.p000v4.content.C0515e;
import com.mopub.common.DataKeys;
import com.mopub.common.Preconditions;

public abstract class BaseBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private final long f34698a;

    /* renamed from: b */
    private Context f34699b;

    public abstract IntentFilter getIntentFilter();

    public BaseBroadcastReceiver(long broadcastIdentifier) {
        this.f34698a = broadcastIdentifier;
    }

    public static void broadcastAction(Context context, long broadcastIdentifier, String action) {
        Preconditions.checkNotNull(context, "context cannot be null");
        Preconditions.checkNotNull(action, "action cannot be null");
        Intent intent = new Intent(action);
        intent.putExtra(DataKeys.BROADCAST_IDENTIFIER_KEY, broadcastIdentifier);
        C0515e.m2597a(context.getApplicationContext()).mo5314a(intent);
    }

    public void register(BroadcastReceiver broadcastReceiver, Context context) {
        this.f34699b = context;
        C0515e.m2597a(this.f34699b).mo5313a(broadcastReceiver, getIntentFilter());
    }

    public void unregister(BroadcastReceiver broadcastReceiver) {
        Context context = this.f34699b;
        if (context != null && broadcastReceiver != null) {
            C0515e.m2597a(context).mo5312a(broadcastReceiver);
            this.f34699b = null;
        }
    }

    public boolean shouldConsumeBroadcast(Intent intent) {
        Preconditions.checkNotNull(intent, "intent cannot be null");
        return this.f34698a == intent.getLongExtra(DataKeys.BROADCAST_IDENTIFIER_KEY, -1);
    }
}
