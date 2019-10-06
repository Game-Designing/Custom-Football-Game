package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import com.google.android.gms.ads.internal.zzk;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@TargetApi(14)
@zzard
public final class zzbcd extends zzbco implements OnBufferingUpdateListener, OnCompletionListener, OnErrorListener, OnInfoListener, OnPreparedListener, OnVideoSizeChangedListener, SurfaceTextureListener {

    /* renamed from: c */
    private static final Map<Integer, String> f25077c = new HashMap();

    /* renamed from: d */
    private final zzbdg f25078d;

    /* renamed from: e */
    private final boolean f25079e;

    /* renamed from: f */
    private int f25080f = 0;

    /* renamed from: g */
    private int f25081g = 0;

    /* renamed from: h */
    private MediaPlayer f25082h;

    /* renamed from: i */
    private Uri f25083i;

    /* renamed from: j */
    private int f25084j;

    /* renamed from: k */
    private int f25085k;

    /* renamed from: l */
    private int f25086l;

    /* renamed from: m */
    private int f25087m;

    /* renamed from: n */
    private int f25088n;

    /* renamed from: o */
    private zzbdd f25089o;

    /* renamed from: p */
    private boolean f25090p;

    /* renamed from: q */
    private int f25091q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public zzbcn f25092r;

    public zzbcd(Context context, boolean z, boolean z2, zzbde zzbde, zzbdg zzbdg) {
        super(context);
        setSurfaceTextureListener(this);
        this.f25078d = zzbdg;
        this.f25090p = z;
        this.f25079e = z2;
        this.f25078d.mo30432a(this);
    }

    /* renamed from: e */
    public final String mo30353e() {
        String valueOf = String.valueOf(this.f25090p ? " spherical" : "");
        String str = "MediaPlayer";
        return valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
    }

    /* renamed from: a */
    public final void mo30348a(zzbcn zzbcn) {
        this.f25092r = zzbcn;
    }

    public final void setVideoPath(String str) {
        Uri parse = Uri.parse(str);
        zzvv a = zzvv.m31316a(parse);
        if (a == null || a.f29551a != null) {
            if (a != null) {
                parse = Uri.parse(a.f29551a);
            }
            this.f25083i = parse;
            this.f25091q = 0;
            m26420f();
            requestLayout();
            invalidate();
        }
    }

    /* renamed from: d */
    public final void mo30352d() {
        zzawz.m26003f("AdMediaPlayerView stop");
        MediaPlayer mediaPlayer = this.f25082h;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.f25082h.release();
            this.f25082h = null;
            m26423i(0);
            this.f25081g = 0;
        }
        this.f25078d.mo30431a();
    }

    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        StringBuilder sb = new StringBuilder(57);
        sb.append("AdMediaPlayerView size changed: ");
        sb.append(i);
        sb.append(" x ");
        sb.append(i2);
        zzawz.m26003f(sb.toString());
        this.f25084j = mediaPlayer.getVideoWidth();
        this.f25085k = mediaPlayer.getVideoHeight();
        if (this.f25084j != 0 && this.f25085k != 0) {
            requestLayout();
        }
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        zzawz.m26003f("AdMediaPlayerView prepared");
        m26423i(2);
        this.f25078d.mo30433b();
        zzaxi.f24961a.post(new C9576md(this));
        this.f25084j = mediaPlayer.getVideoWidth();
        this.f25085k = mediaPlayer.getVideoHeight();
        int i = this.f25091q;
        if (i != 0) {
            mo30350b(i);
        }
        m26421g();
        int i2 = this.f25084j;
        int i3 = this.f25085k;
        StringBuilder sb = new StringBuilder(62);
        sb.append("AdMediaPlayerView stream dimensions: ");
        sb.append(i2);
        sb.append(" x ");
        sb.append(i3);
        zzbad.m26357c(sb.toString());
        if (this.f25081g == 3) {
            mo30351c();
        }
        mo28179a();
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        zzawz.m26003f("AdMediaPlayerView completion");
        m26423i(5);
        this.f25081g = 5;
        zzaxi.f24961a.post(new C9598nd(this));
    }

    public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        String str = (String) f25077c.get(Integer.valueOf(i));
        String str2 = (String) f25077c.get(Integer.valueOf(i2));
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 37 + String.valueOf(str2).length());
        sb.append("AdMediaPlayerView MediaPlayer info: ");
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        zzawz.m26003f(sb.toString());
        return true;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        String str = (String) f25077c.get(Integer.valueOf(i));
        String str2 = (String) f25077c.get(Integer.valueOf(i2));
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 38 + String.valueOf(str2).length());
        sb.append("AdMediaPlayerView MediaPlayer error: ");
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        zzbad.m26359d(sb.toString());
        m26423i(-1);
        this.f25081g = -1;
        zzaxi.f24961a.post(new C9620od(this, str, str2));
        return true;
    }

    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        this.f25086l = i;
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        zzawz.m26003f("AdMediaPlayerView surface created");
        m26420f();
        zzaxi.f24961a.post(new C9642pd(this));
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        zzawz.m26003f("AdMediaPlayerView surface changed");
        boolean z = true;
        boolean z2 = this.f25081g == 3;
        if (!(this.f25084j == i && this.f25085k == i2)) {
            z = false;
        }
        if (this.f25082h != null && z2 && z) {
            int i3 = this.f25091q;
            if (i3 != 0) {
                mo30350b(i3);
            }
            mo30351c();
        }
        zzbdd zzbdd = this.f25089o;
        if (zzbdd != null) {
            zzbdd.mo30423a(i, i2);
        }
        zzaxi.f24961a.post(new C9663qd(this, i, i2));
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        zzawz.m26003f("AdMediaPlayerView surface destroyed");
        MediaPlayer mediaPlayer = this.f25082h;
        if (mediaPlayer != null && this.f25091q == 0) {
            this.f25091q = mediaPlayer.getCurrentPosition();
        }
        zzbdd zzbdd = this.f25089o;
        if (zzbdd != null) {
            zzbdd.mo30425b();
        }
        zzaxi.f24961a.post(new C9684rd(this));
        m26419a(true);
        return true;
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.f25078d.mo30434b(this);
        this.f25093a.mo30418a(surfaceTexture, this.f25092r);
    }

    /* access modifiers changed from: protected */
    public final void onWindowVisibilityChanged(int i) {
        StringBuilder sb = new StringBuilder(58);
        sb.append("AdMediaPlayerView window visibility changed to ");
        sb.append(i);
        zzawz.m26003f(sb.toString());
        zzaxi.f24961a.post(new C9554ld(this, i));
        super.onWindowVisibilityChanged(i);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00aa, code lost:
        if (r7 != r1) goto L_0x00ac;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onMeasure(int r6, int r7) {
        /*
            r5 = this;
            int r0 = r5.f25084j
            int r0 = android.view.TextureView.getDefaultSize(r0, r6)
            int r1 = r5.f25085k
            int r1 = android.view.TextureView.getDefaultSize(r1, r7)
            int r2 = r5.f25084j
            if (r2 <= 0) goto L_0x008f
            int r2 = r5.f25085k
            if (r2 <= 0) goto L_0x008f
            com.google.android.gms.internal.ads.zzbdd r2 = r5.f25089o
            if (r2 != 0) goto L_0x008f
            int r0 = android.view.View.MeasureSpec.getMode(r6)
            int r6 = android.view.View.MeasureSpec.getSize(r6)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            int r7 = android.view.View.MeasureSpec.getSize(r7)
            r2 = 1073741824(0x40000000, float:2.0)
            if (r0 != r2) goto L_0x004b
            if (r1 != r2) goto L_0x004b
            int r0 = r5.f25084j
            int r1 = r0 * r7
            int r2 = r5.f25085k
            int r3 = r6 * r2
            if (r1 >= r3) goto L_0x0040
            int r0 = r0 * r7
            int r0 = r0 / r2
            r1 = r7
            r6 = r0
            goto L_0x0090
        L_0x0040:
            int r1 = r0 * r7
            int r3 = r6 * r2
            if (r1 <= r3) goto L_0x006e
            int r2 = r2 * r6
            int r1 = r2 / r0
            goto L_0x0090
        L_0x004b:
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 != r2) goto L_0x005e
            int r0 = r5.f25085k
            int r0 = r0 * r6
            int r2 = r5.f25084j
            int r0 = r0 / r2
            if (r1 != r3) goto L_0x005c
            if (r0 <= r7) goto L_0x005c
            goto L_0x006e
        L_0x005c:
            r1 = r0
            goto L_0x0090
        L_0x005e:
            if (r1 != r2) goto L_0x0070
            int r1 = r5.f25084j
            int r1 = r1 * r7
            int r2 = r5.f25085k
            int r1 = r1 / r2
            if (r0 != r3) goto L_0x006d
            if (r1 <= r6) goto L_0x006d
            goto L_0x006e
        L_0x006d:
            r6 = r1
        L_0x006e:
            r1 = r7
            goto L_0x0090
        L_0x0070:
            int r2 = r5.f25084j
            int r4 = r5.f25085k
            if (r1 != r3) goto L_0x007e
            if (r4 <= r7) goto L_0x007e
            int r2 = r2 * r7
            int r2 = r2 / r4
            r1 = r7
            goto L_0x007f
        L_0x007e:
            r1 = r4
        L_0x007f:
            if (r0 != r3) goto L_0x008d
            if (r2 <= r6) goto L_0x008d
            int r7 = r5.f25085k
            int r7 = r7 * r6
            int r0 = r5.f25084j
            int r1 = r7 / r0
            goto L_0x0090
        L_0x008d:
            r6 = r2
            goto L_0x0090
        L_0x008f:
            r6 = r0
        L_0x0090:
            r5.setMeasuredDimension(r6, r1)
            com.google.android.gms.internal.ads.zzbdd r7 = r5.f25089o
            if (r7 == 0) goto L_0x009a
            r7.mo30423a(r6, r1)
        L_0x009a:
            int r7 = android.os.Build.VERSION.SDK_INT
            r0 = 16
            if (r7 != r0) goto L_0x00b3
            int r7 = r5.f25087m
            if (r7 <= 0) goto L_0x00a6
            if (r7 != r6) goto L_0x00ac
        L_0x00a6:
            int r7 = r5.f25088n
            if (r7 <= 0) goto L_0x00af
            if (r7 == r1) goto L_0x00af
        L_0x00ac:
            r5.m26421g()
        L_0x00af:
            r5.f25087m = r6
            r5.f25088n = r1
        L_0x00b3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbcd.onMeasure(int, int):void");
    }

    public final String toString() {
        String name = zzbcd.class.getName();
        String hexString = Integer.toHexString(hashCode());
        StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 1 + String.valueOf(hexString).length());
        sb.append(name);
        sb.append("@");
        sb.append(hexString);
        return sb.toString();
    }

    /* renamed from: f */
    private final void m26420f() {
        zzawz.m26003f("AdMediaPlayerView init MediaPlayer");
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (this.f25083i != null && surfaceTexture != null) {
            m26419a(false);
            try {
                zzk.zzlw();
                this.f25082h = new MediaPlayer();
                this.f25082h.setOnBufferingUpdateListener(this);
                this.f25082h.setOnCompletionListener(this);
                this.f25082h.setOnErrorListener(this);
                this.f25082h.setOnInfoListener(this);
                this.f25082h.setOnPreparedListener(this);
                this.f25082h.setOnVideoSizeChangedListener(this);
                this.f25086l = 0;
                if (this.f25090p) {
                    this.f25089o = new zzbdd(getContext());
                    this.f25089o.mo30424a(surfaceTexture, getWidth(), getHeight());
                    this.f25089o.start();
                    SurfaceTexture c = this.f25089o.mo30426c();
                    if (c != null) {
                        surfaceTexture = c;
                    } else {
                        this.f25089o.mo30425b();
                        this.f25089o = null;
                    }
                }
                this.f25082h.setDataSource(getContext(), this.f25083i);
                zzk.zzlx();
                this.f25082h.setSurface(new Surface(surfaceTexture));
                this.f25082h.setAudioStreamType(3);
                this.f25082h.setScreenOnWhilePlaying(true);
                this.f25082h.prepareAsync();
                m26423i(1);
            } catch (IOException | IllegalArgumentException | IllegalStateException e) {
                String valueOf = String.valueOf(this.f25083i);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 36);
                sb.append("Failed to initialize MediaPlayer at ");
                sb.append(valueOf);
                zzbad.m26358c(sb.toString(), e);
                onError(this.f25082h, 1, 0);
            }
        }
    }

    /* renamed from: g */
    private final void m26421g() {
        if (this.f25079e && m26422h() && this.f25082h.getCurrentPosition() > 0 && this.f25081g != 3) {
            zzawz.m26003f("AdMediaPlayerView nudging MediaPlayer");
            m26418a(0.0f);
            this.f25082h.start();
            int currentPosition = this.f25082h.getCurrentPosition();
            long b = zzk.zzln().mo27935b();
            while (m26422h() && this.f25082h.getCurrentPosition() == currentPosition) {
                if (zzk.zzln().mo27935b() - b > 250) {
                    break;
                }
            }
            this.f25082h.pause();
            mo28179a();
        }
    }

    /* renamed from: a */
    private final void m26419a(boolean z) {
        zzawz.m26003f("AdMediaPlayerView release");
        zzbdd zzbdd = this.f25089o;
        if (zzbdd != null) {
            zzbdd.mo30425b();
            this.f25089o = null;
        }
        MediaPlayer mediaPlayer = this.f25082h;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.f25082h.release();
            this.f25082h = null;
            m26423i(0);
            if (z) {
                this.f25081g = 0;
                this.f25081g = 0;
            }
        }
    }

    /* renamed from: c */
    public final void mo30351c() {
        zzawz.m26003f("AdMediaPlayerView play");
        if (m26422h()) {
            this.f25082h.start();
            m26423i(3);
            this.f25093a.mo30417a();
            zzaxi.f24961a.post(new C9705sd(this));
        }
        this.f25081g = 3;
    }

    /* renamed from: b */
    public final void mo30349b() {
        zzawz.m26003f("AdMediaPlayerView pause");
        if (m26422h() && this.f25082h.isPlaying()) {
            this.f25082h.pause();
            m26423i(4);
            zzaxi.f24961a.post(new C9726td(this));
        }
        this.f25081g = 4;
    }

    public final int getDuration() {
        if (m26422h()) {
            return this.f25082h.getDuration();
        }
        return -1;
    }

    public final int getCurrentPosition() {
        if (m26422h()) {
            return this.f25082h.getCurrentPosition();
        }
        return 0;
    }

    /* renamed from: b */
    public final void mo30350b(int i) {
        StringBuilder sb = new StringBuilder(34);
        sb.append("AdMediaPlayerView seek ");
        sb.append(i);
        zzawz.m26003f(sb.toString());
        if (m26422h()) {
            this.f25082h.seekTo(i);
            this.f25091q = 0;
            return;
        }
        this.f25091q = i;
    }

    /* renamed from: h */
    private final boolean m26422h() {
        if (this.f25082h != null) {
            int i = this.f25080f;
            if (!(i == -1 || i == 0 || i == 1)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public final void mo30347a(float f, float f2) {
        zzbdd zzbdd = this.f25089o;
        if (zzbdd != null) {
            zzbdd.mo30422a(f, f2);
        }
    }

    public final int getVideoWidth() {
        MediaPlayer mediaPlayer = this.f25082h;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoWidth();
        }
        return 0;
    }

    public final int getVideoHeight() {
        MediaPlayer mediaPlayer = this.f25082h;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoHeight();
        }
        return 0;
    }

    /* renamed from: a */
    public final void mo28179a() {
        m26418a(this.f25094b.mo30437a());
    }

    /* renamed from: a */
    private final void m26418a(float f) {
        MediaPlayer mediaPlayer = this.f25082h;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.setVolume(f, f);
            } catch (IllegalStateException e) {
            }
        } else {
            zzbad.m26359d("AdMediaPlayerView setMediaPlayerVolume() called before onPrepared().");
        }
    }

    /* renamed from: i */
    private final void m26423i(int i) {
        if (i == 3) {
            this.f25078d.mo30435c();
            this.f25094b.mo30440b();
        } else if (this.f25080f == 3) {
            this.f25078d.mo30436d();
            this.f25094b.mo30441c();
        }
        this.f25080f = i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public final /* synthetic */ void mo30358h(int i) {
        zzbcn zzbcn = this.f25092r;
        if (zzbcn != null) {
            zzbcn.onWindowVisibilityChanged(i);
        }
    }

    static {
        if (VERSION.SDK_INT >= 17) {
            f25077c.put(Integer.valueOf(-1004), "MEDIA_ERROR_IO");
            f25077c.put(Integer.valueOf(-1007), "MEDIA_ERROR_MALFORMED");
            f25077c.put(Integer.valueOf(-1010), "MEDIA_ERROR_UNSUPPORTED");
            f25077c.put(Integer.valueOf(-110), "MEDIA_ERROR_TIMED_OUT");
            f25077c.put(Integer.valueOf(3), "MEDIA_INFO_VIDEO_RENDERING_START");
        }
        f25077c.put(Integer.valueOf(100), "MEDIA_ERROR_SERVER_DIED");
        f25077c.put(Integer.valueOf(1), "MEDIA_ERROR_UNKNOWN");
        f25077c.put(Integer.valueOf(1), "MEDIA_INFO_UNKNOWN");
        f25077c.put(Integer.valueOf(700), "MEDIA_INFO_VIDEO_TRACK_LAGGING");
        f25077c.put(Integer.valueOf(701), "MEDIA_INFO_BUFFERING_START");
        f25077c.put(Integer.valueOf(702), "MEDIA_INFO_BUFFERING_END");
        f25077c.put(Integer.valueOf(800), "MEDIA_INFO_BAD_INTERLEAVING");
        f25077c.put(Integer.valueOf(801), "MEDIA_INFO_NOT_SEEKABLE");
        f25077c.put(Integer.valueOf(802), "MEDIA_INFO_METADATA_UPDATE");
        if (VERSION.SDK_INT >= 19) {
            f25077c.put(Integer.valueOf(901), "MEDIA_INFO_UNSUPPORTED_SUBTITLE");
            f25077c.put(Integer.valueOf(902), "MEDIA_INFO_SUBTITLE_TIMED_OUT");
        }
    }
}
