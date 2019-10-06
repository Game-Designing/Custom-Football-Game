package android.support.p001v7.preference;

import android.os.Handler;
import android.os.Message;

/* renamed from: android.support.v7.preference.p */
/* compiled from: PreferenceFragmentCompat */
class C0832p extends Handler {

    /* renamed from: a */
    final /* synthetic */ C0835s f2514a;

    C0832p(C0835s this$0) {
        this.f2514a = this$0;
    }

    public void handleMessage(Message msg) {
        if (msg.what == 1) {
            this.f2514a.bindPreferences();
        }
    }
}
