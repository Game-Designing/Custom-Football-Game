package p019d.p143b.p144a.p146b;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;

/* renamed from: d.b.a.b.aa */
class C6989aa implements OnErrorListener {

    /* renamed from: a */
    final /* synthetic */ C6987Z f12983a;

    C6989aa(C6987Z z) {
        this.f12983a = z;
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        this.f12983a.f12952a.f12842F.post(new C6991ba(this, i, i2));
        return true;
    }
}
