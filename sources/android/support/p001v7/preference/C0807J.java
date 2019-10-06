package android.support.p001v7.preference;

import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

/* renamed from: android.support.v7.preference.J */
/* compiled from: SeekBarPreference */
class C0807J implements OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ SeekBarPreference f2412a;

    C0807J(SeekBarPreference this$0) {
        this.f2412a = this$0;
    }

    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (event.getAction() != 0) {
            return false;
        }
        if ((!this.f2412a.f2475U && (keyCode == 21 || keyCode == 22)) || keyCode == 23 || keyCode == 66) {
            return false;
        }
        if (this.f2412a.f2473S != null) {
            return this.f2412a.f2473S.onKeyDown(keyCode, event);
        }
        Log.e("SeekBarPreference", "SeekBar view is null and hence cannot be adjusted.");
        return false;
    }
}
