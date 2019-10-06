package com.google.android.gms.ads.mediation;

import android.os.Bundle;

public interface MediationAdapter extends MediationExtrasReceiver {

    public static class zza {

        /* renamed from: a */
        private int f19175a;

        public final zza zzdj(int i) {
            this.f19175a = 1;
            return this;
        }

        public final Bundle zzacc() {
            Bundle bundle = new Bundle();
            bundle.putInt("capabilities", this.f19175a);
            return bundle;
        }
    }

    void onDestroy();

    void onPause();

    void onResume();
}
