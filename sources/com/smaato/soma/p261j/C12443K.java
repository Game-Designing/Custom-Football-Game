package com.smaato.soma.p261j;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;

/* renamed from: com.smaato.soma.j.K */
/* compiled from: Video */
class C12443K implements OnErrorListener {

    /* renamed from: a */
    final /* synthetic */ C12446N f38845a;

    C12443K(C12446N this$0) {
        this.f38845a = this$0;
    }

    public boolean onError(MediaPlayer mediaPlayer, int what, int extra) {
        StringBuilder sb = new StringBuilder();
        sb.append("MP Err");
        sb.append(what);
        C12146d.m39965a(new C12147e("VIDEO", sb.toString(), 1, C12143a.DEBUG));
        this.f38845a.f38850b.removeCallbacksAndMessages(null);
        mediaPlayer.release();
        Runtime.getRuntime().gc();
        this.f38845a.f38855g.mo39480a();
        return false;
    }
}
