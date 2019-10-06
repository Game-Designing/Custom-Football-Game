package com.smaato.soma.p261j;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;

/* renamed from: com.smaato.soma.j.M */
/* compiled from: Video */
class C12445M implements OnPreparedListener {

    /* renamed from: a */
    final /* synthetic */ C12446N f38848a;

    C12445M(C12446N this$0) {
        this.f38848a = this$0;
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        C12146d.m39965a(new C12147e("VIDEO", "MP prep", 1, C12143a.DEBUG));
        if (this.f38848a.f38850b != null) {
            this.f38848a.f38850b.postDelayed(new C12444L(this, mediaPlayer), 250);
        }
    }
}
