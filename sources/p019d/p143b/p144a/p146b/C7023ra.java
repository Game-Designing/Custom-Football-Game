package p019d.p143b.p144a.p146b;

import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;

/* renamed from: d.b.a.b.ra */
interface C7023ra {
    /* renamed from: a */
    void mo22599a(int i, int i2);

    int getCurrentPosition();

    int getDuration();

    int getHeight();

    int getWidth();

    boolean isPlaying();

    void pause();

    void seekTo(int i);

    void setLayoutParams(LayoutParams layoutParams);

    void setOnCompletionListener(OnCompletionListener onCompletionListener);

    void setOnErrorListener(OnErrorListener onErrorListener);

    void setOnPreparedListener(OnPreparedListener onPreparedListener);

    void setOnTouchListener(OnTouchListener onTouchListener);

    void setVideoURI(Uri uri);

    void start();

    void stopPlayback();
}
