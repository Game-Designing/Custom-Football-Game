package p019d.p143b.p144a.p146b;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;

/* renamed from: d.b.a.b.da */
class C6995da implements OnErrorListener {

    /* renamed from: a */
    final /* synthetic */ C6950D f12995a;

    C6995da(C6950D d) {
        this.f12995a = d;
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        this.f12995a.f12842F.post(new C6997ea(this, i, i2));
        return true;
    }
}
