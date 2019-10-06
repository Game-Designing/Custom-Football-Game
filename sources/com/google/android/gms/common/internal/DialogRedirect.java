package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.p000v4.app.Fragment;
import android.util.Log;
import com.google.android.gms.common.api.internal.LifecycleFragment;

public abstract class DialogRedirect implements OnClickListener {
    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo27776a();

    /* renamed from: a */
    public static DialogRedirect m21807a(Activity activity, Intent intent, int i) {
        return new C8700a(intent, activity, i);
    }

    /* renamed from: a */
    public static DialogRedirect m21808a(Fragment fragment, Intent intent, int i) {
        return new C8701b(intent, fragment, i);
    }

    /* renamed from: a */
    public static DialogRedirect m21809a(LifecycleFragment lifecycleFragment, Intent intent, int i) {
        return new C8702c(intent, lifecycleFragment, i);
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            mo27776a();
        } catch (ActivityNotFoundException e) {
            Log.e("DialogRedirect", "Failed to start resolution intent", e);
        } finally {
            dialogInterface.dismiss();
        }
    }
}
