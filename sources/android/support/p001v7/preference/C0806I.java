package android.support.p001v7.preference;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

/* renamed from: android.support.v7.preference.I */
/* compiled from: SeekBarPreference */
class C0806I implements OnSeekBarChangeListener {

    /* renamed from: a */
    final /* synthetic */ SeekBarPreference f2411a;

    C0806I(SeekBarPreference this$0) {
        this.f2411a = this$0;
    }

    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (fromUser && !this.f2411a.f2472R) {
            this.f2411a.m3876a(seekBar);
        }
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
        this.f2411a.f2472R = true;
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        this.f2411a.f2472R = false;
        if (seekBar.getProgress() + this.f2411a.f2469O != this.f2411a.f2468N) {
            this.f2411a.m3876a(seekBar);
        }
    }
}
