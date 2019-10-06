package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* renamed from: com.facebook.k */
/* compiled from: CustomTabMainActivity */
class C6741k extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ CustomTabMainActivity f12337a;

    C6741k(CustomTabMainActivity this$0) {
        this.f12337a = this$0;
    }

    public void onReceive(Context context, Intent intent) {
        Intent newIntent = new Intent(this.f12337a, CustomTabMainActivity.class);
        newIntent.setAction(CustomTabMainActivity.f11766d);
        String str = CustomTabMainActivity.f11765c;
        newIntent.putExtra(str, intent.getStringExtra(str));
        newIntent.addFlags(603979776);
        this.f12337a.startActivity(newIntent);
    }
}
