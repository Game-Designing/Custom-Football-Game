package android.support.p000v4.app;

import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;

/* renamed from: android.support.v4.app.i */
/* compiled from: BaseFragmentActivityApi16 */
abstract class C0012i extends C0009h {
    boolean mStartedActivityFromFragment;

    C0012i() {
    }

    public void startActivityForResult(Intent intent, int requestCode, Bundle options) {
        if (!this.mStartedActivityFromFragment && requestCode != -1) {
            C0009h.checkForValidRequestCode(requestCode);
        }
        super.startActivityForResult(intent, requestCode, options);
    }

    public void startIntentSenderForResult(IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws SendIntentException {
        if (!this.mStartedIntentSenderFromFragment && requestCode != -1) {
            C0009h.checkForValidRequestCode(requestCode);
        }
        super.startIntentSenderForResult(intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags, options);
    }
}
