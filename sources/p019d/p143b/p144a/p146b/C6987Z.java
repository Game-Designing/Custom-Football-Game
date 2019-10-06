package p019d.p143b.p144a.p146b;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/* renamed from: d.b.a.b.Z */
class C6987Z implements OnPreparedListener {

    /* renamed from: a */
    final /* synthetic */ C6950D f12952a;

    C6987Z(C6950D d) {
        this.f12952a = d;
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        this.f12952a.f12851O = new WeakReference(mediaPlayer);
        float f = this.f12952a.m14251K() ^ true ? 1.0f : 0.0f;
        mediaPlayer.setVolume(f, f);
        int videoWidth = mediaPlayer.getVideoWidth();
        int videoHeight = mediaPlayer.getVideoHeight();
        this.f12952a.f12881y = (int) TimeUnit.MILLISECONDS.toSeconds((long) mediaPlayer.getDuration());
        this.f12952a.f12844H.mo22599a(videoWidth, videoHeight);
        C7023ra raVar = this.f12952a.f12844H;
        if (raVar instanceof C6990b) {
            mediaPlayer.setDisplay(((C6990b) raVar).getHolder());
        }
        mediaPlayer.setOnErrorListener(new C6989aa(this));
        if (this.f12952a.f12838B == 0) {
            this.f12952a.m14259S();
            this.f12952a.m14253M();
            this.f12952a.m14264X();
            this.f12952a.m14263W();
            this.f12952a.mo22503j();
            this.f12952a.m14316u();
        }
    }
}
