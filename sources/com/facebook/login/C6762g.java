package com.facebook.login;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* renamed from: com.facebook.login.g */
/* compiled from: DeviceAuthDialog */
class C6762g implements OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DeviceAuthDialog f12423a;

    C6762g(DeviceAuthDialog this$0) {
        this.f12423a = this$0;
    }

    public void onClick(DialogInterface alertDialog, int which) {
        this.f12423a.f12361i.setContentView(this.f12423a.mo20010b(false));
        DeviceAuthDialog deviceAuthDialog = this.f12423a;
        deviceAuthDialog.mo20009a(deviceAuthDialog.f12364l);
    }
}
