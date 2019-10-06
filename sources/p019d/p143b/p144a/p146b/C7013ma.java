package p019d.p143b.p144a.p146b;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import p019d.p143b.p144a.p147c.C7209sc;
import p019d.p143b.p150d.C7262l;
import p019d.p143b.p150d.C7267q;
import p019d.p143b.p150d.C7269s;

/* renamed from: d.b.a.b.ma */
class C7013ma extends FrameLayout implements SurfaceTextureListener, C7023ra {

    /* renamed from: a */
    private final C7262l f13068a;

    /* renamed from: b */
    private final TextureView f13069b;

    /* renamed from: c */
    private final MediaPlayer f13070c = new MediaPlayer();

    /* renamed from: d */
    private final Runnable f13071d;

    /* renamed from: e */
    private int f13072e;

    /* renamed from: f */
    private int f13073f;

    /* renamed from: g */
    private int f13074g;

    C7013ma(C7267q qVar, Context context, Runnable runnable) {
        super(context);
        this.f13068a = qVar.mo23049b();
        this.f13071d = runnable;
        this.f13069b = new TextureView(context);
        this.f13069b.setLayoutParams(new LayoutParams(-1, -1, 17));
        this.f13069b.setSurfaceTextureListener(this);
        addView(this.f13069b);
    }

    /* renamed from: a */
    private void m14487a() {
        C7269s.m15817a(this.f13071d, 250);
    }

    /* renamed from: a */
    public void mo22599a(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int b = C7209sc.m15481b(getContext());
        int i6 = this.f13072e;
        if (i6 == 0) {
            i4 = this.f13069b.getWidth();
            i3 = this.f13069b.getHeight();
            this.f13072e = b;
            this.f13073f = i4;
            this.f13074g = i3;
        } else if (b == i6) {
            i4 = this.f13073f;
            i3 = this.f13074g;
        } else {
            i4 = this.f13074g;
            i3 = this.f13073f;
        }
        float f = ((float) i2) / ((float) i);
        float f2 = (float) i4;
        int i7 = (int) (f2 * f);
        if (i3 >= i7) {
            i5 = i4;
        } else {
            i5 = (int) (((float) i3) / f);
            i7 = i3;
        }
        try {
            int i8 = (i4 - i5) / 2;
            int i9 = (i3 - i7) / 2;
            Matrix matrix = new Matrix();
            this.f13069b.getTransform(matrix);
            matrix.setScale(((float) i5) / f2, ((float) i7) / ((float) i3));
            matrix.postTranslate((float) i8, (float) i9);
            this.f13069b.setTransform(matrix);
            invalidate();
            requestLayout();
        } catch (Throwable th) {
            C7262l lVar = this.f13068a;
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to set video size to width: ");
            sb.append(i);
            sb.append(" height: ");
            sb.append(i2);
            lVar.mo22916b("TextureVideoView", sb.toString());
            m14487a();
        }
    }

    public int getCurrentPosition() {
        return this.f13070c.getCurrentPosition();
    }

    public int getDuration() {
        return this.f13070c.getDuration();
    }

    public boolean isPlaying() {
        return this.f13070c.isPlaying();
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        Surface surface = new Surface(surfaceTexture);
        try {
            this.f13070c.setSurface(surface);
            this.f13070c.setAudioStreamType(3);
            this.f13070c.prepare();
        } catch (Throwable th) {
            this.f13068a.mo22917b("TextureVideoView", "Failed to prepare media player", th);
            surface.release();
            m14487a();
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void pause() {
        this.f13070c.pause();
    }

    public void seekTo(int i) {
        this.f13070c.seekTo(i);
    }

    public void setOnCompletionListener(OnCompletionListener onCompletionListener) {
        this.f13070c.setOnCompletionListener(onCompletionListener);
    }

    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.f13070c.setOnErrorListener(onErrorListener);
    }

    public void setOnPreparedListener(OnPreparedListener onPreparedListener) {
        this.f13070c.setOnPreparedListener(onPreparedListener);
    }

    public void setVideoURI(Uri uri) {
        try {
            this.f13070c.setDataSource(uri.toString());
        } catch (Throwable th) {
            C7262l lVar = this.f13068a;
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to set video URI: ");
            sb.append(uri);
            lVar.mo22917b("TextureVideoView", sb.toString(), th);
            m14487a();
        }
    }

    public void start() {
        this.f13070c.start();
    }

    public void stopPlayback() {
        this.f13070c.stop();
    }
}
