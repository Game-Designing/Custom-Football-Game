package com.inmobi.ads;

import android.annotation.TargetApi;
import android.app.KeyguardManager;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioAttributes.Builder;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.support.p001v7.widget.LinearLayoutManager;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import android.widget.MediaController.MediaPlayerControl;
import android.widget.ProgressBar;
import com.inmobi.ads.AdContainer.RenderingProperties.PlacementType;
import com.inmobi.ads.cache.C10513a;
import com.inmobi.ads.cache.C10513a.C10514a;
import com.inmobi.ads.cache.C10517d;
import com.inmobi.commons.core.p218a.C10621a;
import com.inmobi.commons.core.p221d.C10656b;
import com.inmobi.commons.core.p222e.C10658a;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

@TargetApi(15)
public class NativeVideoView extends TextureView implements MediaPlayerControl {
    /* access modifiers changed from: private */

    /* renamed from: m */
    public static final String f31398m = NativeVideoView.class.getSimpleName();

    /* renamed from: A */
    private OnCompletionListener f31399A = new OnCompletionListener() {
        public final void onCompletion(MediaPlayer mediaPlayer) {
            try {
                NativeVideoView.m33724f(NativeVideoView.this);
            } catch (Exception e) {
                NativeVideoView.f31398m;
                new StringBuilder("SDK encountered unexpected error in handling the media playback complete event; ").append(e.getMessage());
                C10621a.m34854a().mo34423a(new C10658a(e));
            }
        }
    };

    /* renamed from: B */
    private OnInfoListener f31400B = new OnInfoListener() {
        @TargetApi(17)
        public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (VERSION.SDK_INT >= 17 && 3 == i) {
                NativeVideoView.this.mo33881a(8, 8);
            }
            return true;
        }
    };

    /* renamed from: C */
    private OnBufferingUpdateListener f31401C = new OnBufferingUpdateListener() {
        public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            NativeVideoView.this.f31424w = i;
        }
    };

    /* renamed from: D */
    private OnErrorListener f31402D = new OnErrorListener() {
        public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            NativeVideoView.f31398m;
            StringBuilder sb = new StringBuilder("Media Play Error ");
            sb.append(i);
            sb.append(",");
            sb.append(i2);
            if (NativeVideoView.this.f31421t != null) {
                NativeVideoView.this.f31421t.mo33926a(i);
            }
            if (NativeVideoView.this.f31405c != null) {
                NativeVideoView.this.f31405c.f31745a = -1;
                NativeVideoView.this.f31405c.f31746b = -1;
            }
            if (NativeVideoView.this.f31423v != null) {
                NativeVideoView.this.f31423v.mo33870b();
            }
            NativeVideoView.m33728h(NativeVideoView.this);
            return true;
        }
    };

    /* renamed from: a */
    Uri f31403a;

    /* renamed from: b */
    Map<String, String> f31404b;
    /* access modifiers changed from: 0000 */

    /* renamed from: c */
    public C10432av f31405c = null;

    /* renamed from: d */
    int f31406d;
    /* access modifiers changed from: 0000 */

    /* renamed from: e */
    public int f31407e;
    /* access modifiers changed from: 0000 */

    /* renamed from: f */
    public int f31408f;

    /* renamed from: g */
    C10343d f31409g;

    /* renamed from: h */
    Handler f31410h;

    /* renamed from: i */
    boolean f31411i;

    /* renamed from: j */
    OnVideoSizeChangedListener f31412j = new OnVideoSizeChangedListener() {
        public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            NativeVideoView.this.f31407e = mediaPlayer.getVideoWidth();
            NativeVideoView.this.f31408f = mediaPlayer.getVideoHeight();
            if (NativeVideoView.this.f31407e != 0 && NativeVideoView.this.f31408f != 0) {
                NativeVideoView.this.requestLayout();
            }
        }
    };

    /* renamed from: k */
    OnPreparedListener f31413k = new OnPreparedListener() {
        public final void onPrepared(MediaPlayer mediaPlayer) {
            if (NativeVideoView.this.f31405c != null) {
                NativeVideoView.this.f31405c.f31745a = 2;
                NativeVideoView nativeVideoView = NativeVideoView.this;
                boolean d = nativeVideoView.f31427z = true;
                nativeVideoView.f31426y = d;
                nativeVideoView.f31425x = d;
                if (NativeVideoView.this.f31423v != null) {
                    NativeVideoView.this.f31423v.setEnabled(true);
                }
                NativeVideoView.this.f31407e = mediaPlayer.getVideoWidth();
                NativeVideoView.this.f31408f = mediaPlayer.getVideoHeight();
                C10449be beVar = (C10449be) NativeVideoView.this.getTag();
                String str = "didCompleteQ4";
                int i = 0;
                if (beVar != null && ((Boolean) beVar.f31629v.get(str)).booleanValue()) {
                    NativeVideoView.this.mo33881a(8, 0);
                    if (((PlacementType) beVar.f31629v.get("placementType")) == PlacementType.PLACEMENT_TYPE_FULLSCREEN) {
                        return;
                    }
                }
                if (NativeVideoView.this.getPlaybackEventListener() != null) {
                    NativeVideoView.this.getPlaybackEventListener().mo33927a(0);
                }
                if (beVar != null && !((Boolean) beVar.f31629v.get(str)).booleanValue()) {
                    i = ((Integer) beVar.f31629v.get("seekPosition")).intValue();
                }
                String str2 = "isFullScreen";
                if (NativeVideoView.this.f31407e == 0 || NativeVideoView.this.f31408f == 0) {
                    if (3 == NativeVideoView.this.f31405c.f31746b && beVar != null && ((Boolean) beVar.f31629v.get(str2)).booleanValue()) {
                        NativeVideoView.this.start();
                    }
                } else if (3 == NativeVideoView.this.f31405c.f31746b) {
                    if (beVar != null && ((Boolean) beVar.f31629v.get(str2)).booleanValue()) {
                        NativeVideoView.this.start();
                    }
                    if (NativeVideoView.this.f31423v != null) {
                        NativeVideoView.this.f31423v.mo33869a();
                    }
                } else if (!NativeVideoView.this.isPlaying() && ((i != 0 || NativeVideoView.this.getCurrentPosition() > 0) && NativeVideoView.this.f31423v != null)) {
                    NativeVideoView.this.f31423v.mo33869a();
                }
            }
        }
    };

    /* renamed from: l */
    final SurfaceTextureListener f31414l = new SurfaceTextureListener() {
        @TargetApi(16)
        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            NativeVideoView.this.f31415n = new Surface(surfaceTexture);
            NativeVideoView.this.m33726g();
        }

        public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            boolean z = true;
            boolean z2 = NativeVideoView.this.f31405c != null && NativeVideoView.this.f31405c.f31746b == 3;
            if (i <= 0 || i2 <= 0) {
                z = false;
            }
            if (NativeVideoView.this.f31405c != null && z2 && z) {
                if (NativeVideoView.this.getTag() != null) {
                    int intValue = ((Integer) ((C10449be) NativeVideoView.this.getTag()).f31629v.get("seekPosition")).intValue();
                    if (intValue != 0) {
                        NativeVideoView.this.mo33880a(intValue);
                    }
                }
                NativeVideoView.this.start();
            }
        }

        public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            if (NativeVideoView.this.f31415n != null) {
                NativeVideoView.this.f31415n.release();
                NativeVideoView.this.f31415n = null;
            }
            if (NativeVideoView.this.f31423v != null) {
                NativeVideoView.this.f31423v.mo33870b();
            }
            NativeVideoView.this.mo33883c();
            return true;
        }

        public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: n */
    public Surface f31415n = null;

    /* renamed from: o */
    private int f31416o;

    /* renamed from: p */
    private int f31417p = LinearLayoutManager.INVALID_OFFSET;

    /* renamed from: q */
    private int f31418q = 0;

    /* renamed from: r */
    private C10342c f31419r;

    /* renamed from: s */
    private C10341b f31420s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public C10340a f31421t;

    /* renamed from: u */
    private boolean f31422u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public NativeVideoController f31423v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public int f31424w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public boolean f31425x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public boolean f31426y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public boolean f31427z;

    /* renamed from: com.inmobi.ads.NativeVideoView$a */
    interface C10340a {
        /* renamed from: a */
        void mo33926a(int i);
    }

    /* renamed from: com.inmobi.ads.NativeVideoView$b */
    interface C10341b {
        /* renamed from: a */
        void mo33927a(int i);
    }

    /* renamed from: com.inmobi.ads.NativeVideoView$c */
    interface C10342c {
        /* renamed from: a */
        void mo33928a(int i);
    }

    /* renamed from: com.inmobi.ads.NativeVideoView$d */
    static final class C10343d extends Handler {

        /* renamed from: a */
        private final WeakReference<NativeVideoView> f31436a;

        C10343d(NativeVideoView nativeVideoView) {
            this.f31436a = new WeakReference<>(nativeVideoView);
        }

        public final void handleMessage(Message message) {
            NativeVideoView nativeVideoView = (NativeVideoView) this.f31436a.get();
            if (nativeVideoView != null && message.what == 1) {
                int duration = nativeVideoView.getDuration();
                int currentPosition = nativeVideoView.getCurrentPosition();
                if (!(duration == -1 || currentPosition == 0)) {
                    C10449be beVar = (C10449be) nativeVideoView.getTag();
                    String str = "didCompleteQ1";
                    if (!((Boolean) beVar.f31629v.get(str)).booleanValue() && (currentPosition * 4) - duration >= 0) {
                        beVar.f31629v.put(str, Boolean.valueOf(true));
                        nativeVideoView.getQuartileCompletedListener().mo33928a(0);
                    }
                    String str2 = "didCompleteQ2";
                    if (!((Boolean) beVar.f31629v.get(str2)).booleanValue() && (currentPosition * 2) - duration >= 0) {
                        beVar.f31629v.put(str2, Boolean.valueOf(true));
                        nativeVideoView.getQuartileCompletedListener().mo33928a(1);
                    }
                    String str3 = "didCompleteQ3";
                    if (!((Boolean) beVar.f31629v.get(str3)).booleanValue() && (currentPosition * 4) - (duration * 3) >= 0) {
                        beVar.f31629v.put(str3, Boolean.valueOf(true));
                        nativeVideoView.getQuartileCompletedListener().mo33928a(2);
                    }
                    boolean booleanValue = ((Boolean) beVar.f31629v.get("didQ4Fire")).booleanValue();
                    if ((((float) currentPosition) / ((float) duration)) * 100.0f > ((float) beVar.f31788E) && !booleanValue) {
                        nativeVideoView.getPlaybackEventListener().mo33927a(5);
                    }
                }
                sendEmptyMessageDelayed(1, 1000);
            }
            super.handleMessage(message);
        }
    }

    /* renamed from: f */
    static /* synthetic */ void m33724f(NativeVideoView nativeVideoView) {
        C10432av avVar = nativeVideoView.f31405c;
        if (avVar != null) {
            avVar.f31745a = 5;
            avVar.f31746b = 5;
        }
        NativeVideoController nativeVideoController = nativeVideoView.f31423v;
        if (nativeVideoController != null) {
            nativeVideoController.mo33870b();
        }
        C10343d dVar = nativeVideoView.f31409g;
        if (dVar != null) {
            dVar.removeMessages(1);
        }
        if (nativeVideoView.getTag() != null) {
            C10449be beVar = (C10449be) nativeVideoView.getTag();
            String str = "didCompleteQ4";
            if (!((Boolean) beVar.f31629v.get(str)).booleanValue()) {
                beVar.f31629v.put(str, Boolean.valueOf(true));
                if (nativeVideoView.getQuartileCompletedListener() != null) {
                    nativeVideoView.getQuartileCompletedListener().mo33928a(3);
                }
            }
            beVar.f31629v.put("didSignalVideoCompleted", Boolean.valueOf(true));
            if (beVar != null) {
                beVar.f31629v.put("didCompleteQ1", Boolean.valueOf(false));
                beVar.f31629v.put("didCompleteQ2", Boolean.valueOf(false));
                beVar.f31629v.put("didCompleteQ3", Boolean.valueOf(false));
                beVar.f31629v.put("didPause", Boolean.valueOf(false));
                beVar.f31629v.put("didStartPlaying", Boolean.valueOf(false));
                beVar.f31629v.put("didQ4Fire", Boolean.valueOf(false));
            }
            if (beVar.f31786C) {
                nativeVideoView.start();
            } else if (((Boolean) beVar.f31629v.get("isFullScreen")).booleanValue()) {
                nativeVideoView.mo33881a(8, 0);
            }
        }
    }

    public NativeVideoView(Context context) {
        super(context);
        requestLayout();
        invalidate();
    }

    public C10432av getMediaPlayer() {
        return this.f31405c;
    }

    /* renamed from: a */
    public final void mo33879a() {
        Surface surface = this.f31415n;
        if (surface != null) {
            surface.release();
            this.f31415n = null;
        }
        mo33883c();
    }

    public int getState() {
        C10432av avVar = this.f31405c;
        if (avVar != null) {
            return avVar.f31745a;
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        try {
            int defaultSize = TextureView.getDefaultSize(this.f31407e, i);
            int defaultSize2 = TextureView.getDefaultSize(this.f31408f, i2);
            if (this.f31407e <= 0 || this.f31408f <= 0) {
                i4 = defaultSize;
                i3 = defaultSize2;
            } else {
                int mode = MeasureSpec.getMode(i);
                i4 = MeasureSpec.getSize(i);
                int mode2 = MeasureSpec.getMode(i2);
                i3 = MeasureSpec.getSize(i2);
                if (mode == 1073741824 && mode2 == 1073741824) {
                    if (this.f31407e * i3 < this.f31408f * i4) {
                        i3 = (this.f31408f * i4) / this.f31407e;
                    } else if (this.f31407e * i3 > this.f31408f * i4) {
                        i4 = (this.f31407e * i3) / this.f31408f;
                    }
                } else if (mode == 1073741824) {
                    int i6 = (this.f31408f * i4) / this.f31407e;
                    if (mode2 != Integer.MIN_VALUE || i6 <= i3) {
                        i3 = i6;
                    }
                } else {
                    if (mode2 == 1073741824) {
                        i5 = (this.f31407e * i3) / this.f31408f;
                        if (mode == Integer.MIN_VALUE && i5 > i4) {
                        }
                    } else {
                        int i7 = this.f31407e;
                        int i8 = this.f31408f;
                        if (mode2 != Integer.MIN_VALUE || i8 <= i3) {
                            i5 = i7;
                            i3 = i8;
                        } else {
                            i5 = (this.f31407e * i3) / this.f31408f;
                        }
                        if (mode == Integer.MIN_VALUE && i5 > i4) {
                            i3 = (this.f31408f * i4) / this.f31407e;
                        }
                    }
                    i4 = i5;
                }
            }
            setMeasuredDimension(i4, i3);
        } catch (Exception e) {
            new StringBuilder("SDK encountered unexpected error in handling the onMeasure event; ").append(e.getMessage());
        }
    }

    /* access modifiers changed from: 0000 */
    public NativeVideoController getMediaController() {
        return this.f31423v;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final boolean mo33882b() {
        C10432av avVar = this.f31405c;
        if (avVar != null) {
            int i = avVar.f31745a;
            if (!(i == -1 || i == 0 || i == 1)) {
                return true;
            }
        }
        return false;
    }

    public void setIsLockScreen(boolean z) {
        this.f31422u = z;
    }

    @TargetApi(20)
    public void start() {
        boolean z;
        int i;
        PowerManager powerManager = (PowerManager) getContext().getSystemService("power");
        boolean inKeyguardRestrictedInputMode = ((KeyguardManager) getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode();
        if (VERSION.SDK_INT < 20) {
            z = powerManager.isScreenOn();
        } else {
            z = powerManager.isInteractive();
        }
        boolean b = mo33882b();
        C10449be beVar = (C10449be) getTag();
        boolean z2 = beVar == null || ((Boolean) beVar.f31629v.get("shouldAutoPlay")).booleanValue();
        if (b && !z2) {
            mo33881a(8, 0);
        }
        if (b && z && !this.f31405c.isPlaying() && z2 && (this.f31422u || !inKeyguardRestrictedInputMode)) {
            String str = "didCompleteQ4";
            if (beVar == null || ((Boolean) beVar.f31629v.get(str)).booleanValue()) {
                i = 0;
            } else {
                i = ((Integer) beVar.f31629v.get("seekPosition")).intValue();
            }
            mo33887d();
            mo33880a(i);
            this.f31405c.start();
            this.f31405c.f31745a = 3;
            mo33881a(8, 8);
            if (beVar != null) {
                beVar.f31629v.put(str, Boolean.valueOf(false));
                if (beVar.mo34157a()) {
                    mo33888e();
                }
                String str2 = "didPause";
                if (((Boolean) beVar.f31629v.get(str2)).booleanValue()) {
                    getPlaybackEventListener().mo33927a(3);
                    beVar.f31629v.put(str2, Boolean.valueOf(false));
                } else {
                    getPlaybackEventListener().mo33927a(1);
                }
                C10343d dVar = this.f31409g;
                if (dVar != null && !dVar.hasMessages(1)) {
                    this.f31409g.sendEmptyMessage(1);
                }
            }
            NativeVideoController nativeVideoController = this.f31423v;
            if (nativeVideoController != null) {
                nativeVideoController.mo33869a();
            }
        }
        C10432av avVar = this.f31405c;
        if (avVar != null) {
            avVar.f31746b = 3;
        }
    }

    public void pause() {
        if (mo33882b() && this.f31405c.isPlaying()) {
            this.f31405c.pause();
            this.f31405c.f31745a = 4;
            if (getTag() != null) {
                C10449be beVar = (C10449be) getTag();
                beVar.f31629v.put("didPause", Boolean.valueOf(true));
                beVar.f31629v.put("seekPosition", Integer.valueOf(getCurrentPosition()));
            }
            getPlaybackEventListener().mo33927a(2);
        }
        C10432av avVar = this.f31405c;
        if (avVar != null) {
            avVar.f31746b = 4;
        }
        this.f31411i = false;
    }

    public int getDuration() {
        if (mo33882b()) {
            return this.f31405c.getDuration();
        }
        return -1;
    }

    public int getCurrentPosition() {
        if (mo33882b()) {
            return this.f31405c.getCurrentPosition();
        }
        return 0;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo33880a(int i) {
        if (mo33882b()) {
            this.f31405c.seekTo(i);
        }
    }

    public void seekTo(int i) {
    }

    public boolean isPlaying() {
        return mo33882b() && this.f31405c.isPlaying();
    }

    public int getBufferPercentage() {
        if (this.f31405c != null) {
            return this.f31424w;
        }
        return 0;
    }

    public boolean canPause() {
        return this.f31425x;
    }

    public boolean canSeekBackward() {
        return this.f31426y;
    }

    public boolean canSeekForward() {
        return this.f31427z;
    }

    public int getAudioSessionId() {
        if (this.f31406d == 0) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f31406d = mediaPlayer.getAudioSessionId();
            mediaPlayer.release();
        }
        return this.f31406d;
    }

    public void setVideoPath(String str) {
        setVideoURI(Uri.parse(str));
    }

    public void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    public void setVideoURI(Uri uri, Map<String, String> map) {
        this.f31403a = uri;
        this.f31404b = map;
        m33726g();
        requestLayout();
        invalidate();
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m33726g() {
        C10432av avVar;
        if (this.f31403a != null && this.f31415n != null) {
            if (this.f31405c == null) {
                C10449be beVar = (C10449be) getTag();
                PlacementType placementType = PlacementType.PLACEMENT_TYPE_FULLSCREEN;
                if (beVar != null) {
                    placementType = (PlacementType) beVar.f31629v.get("placementType");
                }
                if (PlacementType.PLACEMENT_TYPE_FULLSCREEN == placementType) {
                    avVar = new C10432av();
                } else {
                    avVar = C10432av.m34161a();
                }
                this.f31405c = avVar;
                int i = this.f31406d;
                if (i != 0) {
                    this.f31405c.setAudioSessionId(i);
                } else {
                    this.f31406d = this.f31405c.getAudioSessionId();
                }
                try {
                    this.f31405c.setDataSource(getContext().getApplicationContext(), this.f31403a, this.f31404b);
                } catch (IOException e) {
                    C10432av avVar2 = this.f31405c;
                    avVar2.f31745a = -1;
                    avVar2.f31746b = -1;
                    return;
                }
            }
            try {
                C10449be beVar2 = (C10449be) getTag();
                this.f31405c.setOnPreparedListener(this.f31413k);
                this.f31405c.setOnVideoSizeChangedListener(this.f31412j);
                this.f31405c.setOnCompletionListener(this.f31399A);
                this.f31405c.setOnErrorListener(this.f31402D);
                this.f31405c.setOnInfoListener(this.f31400B);
                this.f31405c.setOnBufferingUpdateListener(this.f31401C);
                this.f31405c.setSurface(this.f31415n);
                if (VERSION.SDK_INT >= 26) {
                    this.f31405c.setAudioAttributes(new Builder().setUsage(1).setContentType(2).setLegacyStreamType(3).build());
                } else {
                    this.f31405c.setAudioStreamType(3);
                }
                this.f31405c.prepareAsync();
                this.f31424w = 0;
                this.f31405c.f31745a = 1;
                m33727h();
                if (beVar2 != null) {
                    if (((Boolean) beVar2.f31629v.get("shouldAutoPlay")).booleanValue()) {
                        this.f31405c.f31746b = 3;
                    }
                    if (((Boolean) beVar2.f31629v.get("didCompleteQ4")).booleanValue()) {
                        mo33881a(8, 0);
                        return;
                    }
                }
                mo33881a(0, 0);
            } catch (Exception e2) {
                C10432av avVar3 = this.f31405c;
                avVar3.f31745a = -1;
                avVar3.f31746b = -1;
                this.f31402D.onError(avVar3, 1, 0);
                C10621a.m34854a().mo34423a(new C10658a(e2));
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public final void mo33883c() {
        if (this.f31405c != null) {
            C10343d dVar = this.f31409g;
            if (dVar != null) {
                dVar.removeMessages(1);
            }
            if (getTag() != null) {
                ((C10449be) getTag()).f31629v.put("seekPosition", Integer.valueOf(getCurrentPosition()));
            }
            C10432av avVar = this.f31405c;
            avVar.f31745a = 0;
            avVar.f31746b = 0;
            avVar.reset();
            this.f31405c.setOnPreparedListener(null);
            this.f31405c.setOnVideoSizeChangedListener(null);
            this.f31405c.setOnCompletionListener(null);
            this.f31405c.setOnErrorListener(null);
            this.f31405c.setOnInfoListener(null);
            this.f31405c.setOnBufferingUpdateListener(null);
            if (getTag() != null) {
                if (PlacementType.PLACEMENT_TYPE_INLINE == ((C10449be) getTag()).f31629v.get("placementType")) {
                    this.f31405c.mo34138b();
                }
            } else {
                this.f31405c.mo34138b();
            }
            AudioManager audioManager = (AudioManager) getContext().getSystemService("audio");
            if (audioManager != null) {
                audioManager.abandonAudioFocus(null);
            }
            this.f31405c = null;
        }
    }

    /* renamed from: d */
    public final void mo33887d() {
        C10432av avVar = this.f31405c;
        if (avVar != null) {
            this.f31416o = 0;
            avVar.setVolume(0.0f, 0.0f);
            if (getTag() != null) {
                ((C10449be) getTag()).f31629v.put("currentMediaVolume", Integer.valueOf(0));
            }
        }
    }

    /* renamed from: e */
    public final void mo33888e() {
        C10432av avVar = this.f31405c;
        if (avVar != null) {
            this.f31416o = 1;
            avVar.setVolume(1.0f, 1.0f);
            if (getTag() != null) {
                ((C10449be) getTag()).f31629v.put("currentMediaVolume", Integer.valueOf(15));
            }
        }
    }

    public int getVolume() {
        if (mo33882b()) {
            return this.f31416o;
        }
        return -1;
    }

    public int getVideoVolume() {
        if (isPlaying()) {
            return this.f31416o;
        }
        return -1;
    }

    public int getLastVolume() {
        return this.f31417p;
    }

    public void setLastVolume(int i) {
        this.f31417p = i;
    }

    /* renamed from: h */
    private void m33727h() {
        if (this.f31405c != null) {
            NativeVideoController nativeVideoController = this.f31423v;
            if (nativeVideoController != null) {
                nativeVideoController.setMediaPlayer(this);
                this.f31423v.setEnabled(mo33882b());
                this.f31423v.mo33869a();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo33881a(int i, int i2) {
        if (this.f31405c != null) {
            ProgressBar progressBar = ((NativeVideoWrapper) getParent()).getProgressBar();
            ImageView poster = ((NativeVideoWrapper) getParent()).getPoster();
            progressBar.setVisibility(i);
            poster.setVisibility(i2);
        }
    }

    public void setMediaController(NativeVideoController nativeVideoController) {
        if (nativeVideoController != null) {
            this.f31423v = nativeVideoController;
            m33727h();
        }
    }

    public C10342c getQuartileCompletedListener() {
        return this.f31419r;
    }

    public void setQuartileCompletedListener(C10342c cVar) {
        this.f31419r = cVar;
    }

    public C10341b getPlaybackEventListener() {
        return this.f31420s;
    }

    public void setPlaybackEventListener(C10341b bVar) {
        this.f31420s = bVar;
    }

    public void setMediaErrorListener(C10340a aVar) {
        this.f31421t = aVar;
    }

    /* renamed from: h */
    static /* synthetic */ void m33728h(NativeVideoView nativeVideoView) {
        try {
            if (nativeVideoView.f31403a != null) {
                String uri = nativeVideoView.f31403a.toString();
                C10517d.m34431a();
                C10656b a = C10656b.m34962a();
                List a2 = a.mo34470a("asset", C10517d.f32077a, "disk_uri=? ", new String[]{uri}, null, null, "created_ts DESC ", "1");
                a.mo34476b();
                C10513a a3 = a2.isEmpty() ? null : C10517d.m34429a((ContentValues) a2.get(0));
                C10514a aVar = new C10514a();
                if (a3 != null) {
                    C10513a a4 = aVar.mo34238a(a3.f32048d, 0, 0).mo34240a();
                    C10517d.m34431a();
                    C10517d.m34432b(a4);
                }
            }
        } catch (Exception e) {
        }
    }
}
