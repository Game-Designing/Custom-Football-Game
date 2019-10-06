package com.vungle.warren.p267ui;

import android.os.Build.VERSION;
import android.util.Log;

/* renamed from: com.vungle.warren.ui.VungleFlexViewActivity */
public class VungleFlexViewActivity extends VungleActivity {
    private static final String TAG = VungleFlexViewActivity.class.getSimpleName();

    /* access modifiers changed from: protected */
    public boolean canRotate() {
        boolean blockRotate = getApplication().getApplicationInfo().targetSdkVersion >= 27 && VERSION.SDK_INT == 26;
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("allow rotation = ");
        sb.append(!blockRotate);
        Log.d(str, sb.toString());
        if (!blockRotate) {
            return true;
        }
        return false;
    }
}
