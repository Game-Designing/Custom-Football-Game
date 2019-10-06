package p024io.realm.internal.android;

import android.os.Handler;
import android.os.Looper;
import p024io.realm.internal.C7314a;
import p024io.realm.internal.Keep;
import p024io.realm.internal.RealmNotifier;
import p024io.realm.internal.SharedRealm;

@Keep
/* renamed from: io.realm.internal.android.AndroidRealmNotifier */
public class AndroidRealmNotifier extends RealmNotifier {
    private Handler handler;

    public AndroidRealmNotifier(SharedRealm sharedRealm, C7314a capabilities) {
        super(sharedRealm);
        if (capabilities.mo23728a()) {
            this.handler = new Handler(Looper.myLooper());
        } else {
            this.handler = null;
        }
    }

    public boolean post(Runnable runnable) {
        Handler handler2 = this.handler;
        return handler2 != null && handler2.post(runnable);
    }
}
