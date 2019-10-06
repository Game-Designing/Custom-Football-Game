package p005cm.aptoide.p006pt.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import p026rx.C0120S.C0122a;
import p026rx.C14980ia;
import p026rx.p027b.C0128a;
import p026rx.p029i.C14978f;

/* renamed from: cm.aptoide.pt.utils.BroadcastRegisterOnSubscribe */
public class BroadcastRegisterOnSubscribe implements C0122a<Intent> {
    private final String broadcastPermission;
    /* access modifiers changed from: private */
    public final Context context;
    private final IntentFilter intentFilter;
    private final Handler schedulerHandler;

    public BroadcastRegisterOnSubscribe(Context context2, IntentFilter intentFilter2, String broadcastPermission2, Handler schedulerHandler2) {
        this.context = context2;
        this.intentFilter = intentFilter2;
        this.broadcastPermission = broadcastPermission2;
        this.schedulerHandler = schedulerHandler2;
    }

    public void call(final C14980ia<? super Intent> subscriber) {
        final BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                if (!subscriber.isUnsubscribed()) {
                    subscriber.onNext(intent);
                }
            }
        };
        subscriber.add(C14978f.m46781a(new C0128a() {
            public void call() {
                BroadcastRegisterOnSubscribe.this.context.unregisterReceiver(broadcastReceiver);
            }
        }));
        this.context.registerReceiver(broadcastReceiver, this.intentFilter, this.broadcastPermission, this.schedulerHandler);
    }
}
