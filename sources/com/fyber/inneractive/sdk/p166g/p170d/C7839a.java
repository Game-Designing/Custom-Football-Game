package com.fyber.inneractive.sdk.p166g.p170d;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.fyber.inneractive.sdk.p166g.p169c.C7838b;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.IAlog.C7984a;

/* renamed from: com.fyber.inneractive.sdk.g.d.a */
public final class C7839a extends MediaPlayer implements OnCompletionListener, OnErrorListener, OnPreparedListener, OnSeekCompleteListener, OnVideoSizeChangedListener {

    /* renamed from: a */
    Context f15820a;

    /* renamed from: b */
    public C7838b f15821b = C7838b.Idle;

    /* renamed from: c */
    public boolean f15822c = false;

    /* renamed from: d */
    public boolean f15823d = false;

    /* renamed from: e */
    Handler f15824e;

    /* renamed from: f */
    HandlerThread f15825f;

    /* renamed from: g */
    Handler f15826g;

    /* renamed from: h */
    private boolean f15827h = false;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f15828i = false;

    /* renamed from: j */
    private boolean f15829j = false;

    /* renamed from: k */
    private Exception f15830k = null;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public C7853a f15831l;

    /* renamed from: m */
    private Surface f15832m;

    /* renamed from: n */
    private SurfaceHolder f15833n;

    /* renamed from: o */
    private long f15834o;

    /* renamed from: p */
    private int f15835p = 0;

    /* renamed from: q */
    private Runnable f15836q;

    /* renamed from: r */
    private Handler f15837r;

    /* renamed from: s */
    private Runnable f15838s;

    /* renamed from: t */
    private int f15839t = 0;

    /* renamed from: u */
    private int f15840u = 0;

    /* renamed from: v */
    private int f15841v = 0;

    /* renamed from: w */
    private int f15842w = 0;

    /* renamed from: com.fyber.inneractive.sdk.g.d.a$a */
    public interface C7853a {
        /* renamed from: a */
        void mo24457a(C7838b bVar);

        /* renamed from: a */
        void mo24458a(Exception exc);
    }

    /* renamed from: h */
    static /* synthetic */ void m17574h(C7839a aVar) {
        if (aVar.mo24567a()) {
            aVar.f15841v = super.getVideoWidth();
            aVar.f15842w = super.getVideoHeight();
            aVar.f15839t = super.getDuration();
        }
    }

    public C7839a(Context context, C7853a aVar, Handler handler) {
        this.f15820a = context;
        this.f15831l = aVar;
        this.f15824e = handler;
        setOnPreparedListener(this);
        setOnErrorListener(this);
        setOnSeekCompleteListener(this);
        setOnVideoSizeChangedListener(this);
        super.setOnCompletionListener(this);
        this.f15825f = new HandlerThread("MP-Worker");
        this.f15825f.start();
        this.f15826g = new Handler(this.f15825f.getLooper());
        this.f15838s = new Runnable() {
            public final void run() {
                C7839a.m17574h(C7839a.this);
            }
        };
    }

    public final void setOnCompletionListener(OnCompletionListener onCompletionListener) {
        throw new IllegalAccessError("Please use IAplayerCallbacks to receive completion events");
    }

    public final void setDisplay(final SurfaceHolder surfaceHolder) {
        StringBuilder sb = new StringBuilder();
        sb.append(mo24569c());
        sb.append(" setDisplay called");
        IAlog.m18021b(sb.toString());
        if (!mo24567a()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(mo24569c());
            sb2.append(" setDisplay called when player is not ready!");
            IAlog.m18021b(sb2.toString());
            return;
        }
        SurfaceHolder surfaceHolder2 = this.f15833n;
        if (surfaceHolder2 == null || !surfaceHolder2.equals(surfaceHolder)) {
            this.f15833n = surfaceHolder;
            mo24565a((Runnable) new Runnable() {
                public final void run() {
                    C7839a.m17565a(C7839a.this, surfaceHolder);
                }
            });
            return;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(mo24569c());
        sb3.append(" setDisplay called with existing surface. ignoring!");
        IAlog.m18021b(sb3.toString());
    }

    public final void setSurface(final Surface surface) {
        StringBuilder sb = new StringBuilder();
        sb.append(mo24569c());
        sb.append(" setSurface called");
        IAlog.m18021b(sb.toString());
        Surface surface2 = this.f15832m;
        if (surface2 == null || !surface2.equals(surface)) {
            this.f15832m = surface;
            mo24565a((Runnable) new Runnable() {
                public final void run() {
                    C7839a.m17564a(C7839a.this, surface);
                }
            });
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(mo24569c());
        sb2.append(" setSurface called with existing surface. ignoring!");
        IAlog.m18021b(sb2.toString());
    }

    /* renamed from: a */
    public final boolean mo24567a() {
        C7838b bVar = this.f15821b;
        return (bVar == C7838b.Idle || bVar == C7838b.Preparing) ? false : true;
    }

    public final boolean isPlaying() {
        return mo24567a() && this.f15821b != C7838b.Paused && super.isPlaying();
    }

    public final int getDuration() {
        return this.f15839t;
    }

    public final int getCurrentPosition() {
        if (mo24567a()) {
            return super.getCurrentPosition();
        }
        return 0;
    }

    public final int getVideoWidth() {
        return this.f15841v;
    }

    public final int getVideoHeight() {
        return this.f15842w;
    }

    /* renamed from: a */
    public final void mo24566a(String str) {
        C7984a aVar = new C7984a(mo24569c(), "loadUri");
        this.f15828i = false;
        this.f15829j = false;
        this.f15830k = null;
        if (isPlaying()) {
            StringBuilder sb = new StringBuilder();
            sb.append(mo24569c());
            sb.append(" loadUri stopping play before refresh");
            IAlog.m18021b(sb.toString());
            stop();
        }
        this.f15834o = System.currentTimeMillis();
        m17568d();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(mo24569c());
        sb2.append(" calling setDataSource with ");
        sb2.append(str);
        IAlog.m18021b(sb2.toString());
        try {
            setDataSource(str);
            StringBuilder sb3 = new StringBuilder();
            sb3.append(mo24569c());
            sb3.append(" setDataSource succeeded, calling prepareAsync");
            IAlog.m18021b(sb3.toString());
            mo24564a(C7838b.Preparing);
            try {
                prepareAsync();
            } catch (IllegalStateException e) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(mo24569c());
                sb4.append(" prepareAsync failed with illegal mState exception: ");
                sb4.append(e.getMessage());
                IAlog.m18024e(sb4.toString());
                this.f15835p++;
                if (this.f15835p < 5) {
                    mo24566a(str);
                }
                if (this.f15835p == 5) {
                    this.f15830k = e;
                }
                this.f15835p = 0;
            }
            aVar.mo24830a();
        } catch (Exception e2) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(mo24569c());
            sb5.append(" error setting data source ");
            sb5.append(str);
            IAlog.m18024e(sb5.toString());
            StringBuilder sb6 = new StringBuilder();
            sb6.append(mo24569c());
            sb6.append(" exception message: ");
            sb6.append(e2.getMessage());
            IAlog.m18024e(sb6.toString());
            this.f15830k = e2;
        }
    }

    public final void release() {
        if (!this.f15827h) {
            mo24565a((Runnable) new Runnable() {
                public final void run() {
                    C7839a.m17562a(C7839a.this);
                    Handler handler = C7839a.this.f15826g;
                    if (handler != null) {
                        handler.removeCallbacksAndMessages(null);
                        C7839a.this.f15826g = null;
                    }
                    C7839a.this.f15825f = null;
                    Looper.myLooper().quit();
                }
            });
        }
        this.f15831l = null;
        this.f15838s = null;
        this.f15827h = true;
        StringBuilder sb = new StringBuilder();
        sb.append(mo24569c());
        sb.append(" release called");
        IAlog.m18021b(sb.toString());
    }

    public final void reset() {
        StringBuilder sb = new StringBuilder();
        sb.append(mo24569c());
        sb.append(" reset called");
        IAlog.m18021b(sb.toString());
        Runnable runnable = this.f15836q;
        if (runnable != null) {
            this.f15837r.removeCallbacks(runnable);
        }
        mo24565a((Runnable) new Runnable() {
            public final void run() {
                C7839a.this.m17568d();
            }
        });
    }

    public final void start() {
        StringBuilder sb = new StringBuilder();
        sb.append(mo24569c());
        sb.append(" Start called");
        IAlog.m18021b(sb.toString());
        if (!mo24567a()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(mo24569c());
            sb2.append(" MediaPlayer: Start called when player is not ready! - mState = ");
            sb2.append(this.f15821b);
            IAlog.m18021b(sb2.toString());
        } else if (this.f15821b == C7838b.Seeking) {
            this.f15822c = true;
        } else if (isPlaying()) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(mo24569c());
            sb3.append(" MediaPlayer: Start called when player is already playing. do nothing");
            IAlog.m18021b(sb3.toString());
        } else {
            mo24565a((Runnable) new Runnable() {
                public final void run() {
                    C7839a.m17567c(C7839a.this);
                }
            });
        }
    }

    public final void stop() {
        C7984a aVar = new C7984a(mo24569c(), "stop");
        if (mo24567a()) {
            super.stop();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(mo24569c());
        sb.append(" stop called");
        IAlog.m18021b(sb.toString());
        aVar.mo24830a();
    }

    public final void pause() {
        C7838b bVar = this.f15821b;
        if (bVar == C7838b.Idle || bVar == C7838b.Completed || bVar == C7838b.Paused || bVar == C7838b.Prepared) {
            StringBuilder sb = new StringBuilder();
            sb.append(mo24569c());
            sb.append(" paused called when player is in mState: ");
            sb.append(this.f15821b);
            sb.append(" ignoring");
            IAlog.m18021b(sb.toString());
            return;
        }
        mo24564a(C7838b.Paused);
        if (mo24567a()) {
            mo24565a((Runnable) new Runnable() {
                public final void run() {
                    C7839a.m17569d(C7839a.this);
                }
            });
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(mo24569c());
            sb2.append(" paused called when player is not ready!");
            IAlog.m18021b(sb2.toString());
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(mo24569c());
        sb3.append(" pause");
        IAlog.m18021b(sb3.toString());
    }

    /* renamed from: b */
    public final void mo24568b() {
        this.f15823d = true;
        if (mo24567a()) {
            mo24565a((Runnable) new Runnable() {
                public final void run() {
                    C7839a.m17571e(C7839a.this);
                }
            });
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(mo24569c());
            sb.append(" mute called when player is not ready!");
            IAlog.m18021b(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(mo24569c());
        sb2.append(" mute");
        IAlog.m18021b(sb2.toString());
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        StringBuilder sb = new StringBuilder();
        sb.append(mo24569c());
        sb.append(" onPrepared ");
        sb.append(this);
        sb.append(" gotPrepared = ");
        sb.append(this.f15829j);
        IAlog.m18021b(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(mo24569c());
        sb2.append("Media prepare time took ");
        sb2.append(System.currentTimeMillis() - this.f15834o);
        sb2.append(" msec");
        IAlog.m18021b(sb2.toString());
        C7838b bVar = this.f15821b;
        if (bVar != C7838b.Preparing && bVar != C7838b.Seeking) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(mo24569c());
            sb3.append(" onPrepared: previous error encountered. Aborting");
            IAlog.m18023d(sb3.toString());
        } else if (!this.f15829j) {
            this.f15829j = true;
            m17570e();
        } else {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(mo24569c());
            sb4.append(" onPrepared called again??? We are already prepared");
            IAlog.m18021b(sb4.toString());
        }
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        this.f15840u = getDuration();
        mo24564a(C7838b.Completed);
    }

    public final boolean onError(MediaPlayer mediaPlayer, final int i, final int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append(mo24569c());
        sb.append(" onError code = ");
        sb.append(i);
        sb.append(" code2 = ");
        sb.append(i2);
        IAlog.m18023d(sb.toString());
        m17568d();
        this.f15824e.post(new Runnable() {
            public final void run() {
                if (C7839a.this.f15831l != null) {
                    C7853a g = C7839a.this.f15831l;
                    StringBuilder sb = new StringBuilder("Player Error: ");
                    sb.append(i);
                    sb.append(", ");
                    sb.append(i2);
                    g.mo24458a(new Exception(sb.toString()));
                }
            }
        });
        return true;
    }

    public final void onSeekComplete(MediaPlayer mediaPlayer) {
        StringBuilder sb = new StringBuilder();
        sb.append(mo24569c());
        sb.append(" onSeekComplete called current position = ");
        sb.append(mediaPlayer.getCurrentPosition());
        IAlog.m18021b(sb.toString());
        if (this.f15821b != C7838b.Seeking) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(mo24569c());
            sb2.append(" onSeekComplete called when Story is not seeking");
            IAlog.m18021b(sb2.toString());
            return;
        }
        if (this.f15823d) {
            mo24568b();
        }
        if (this.f15822c) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(mo24569c());
            sb3.append(" onSeekComplete mPlayAfterSeek = true");
            IAlog.m18021b(sb3.toString());
            this.f15821b = C7838b.Paused;
            start();
            return;
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append(mo24569c());
        sb4.append(" onSeekComplete mPlayAfterSeek = false");
        IAlog.m18021b(sb4.toString());
        mo24564a(C7838b.Paused);
    }

    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append(mo24569c());
        sb.append(" onVideoSizeChanged ");
        sb.append(i);
        sb.append(", ");
        sb.append(i2);
        IAlog.m18021b(sb.toString());
        if (!this.f15828i) {
            Runnable runnable = this.f15836q;
            if (runnable != null) {
                this.f15837r.removeCallbacks(runnable);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(mo24569c());
                sb2.append(" onVideoSizeChanged cancelling prepared runnable");
                IAlog.m18021b(sb2.toString());
            }
            this.f15828i = true;
            if (i == 0 || i2 == 0) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(mo24569c());
                sb3.append(" onVideoSizeChanged - Invalid video size!");
                IAlog.m18023d(sb3.toString());
                onError(this, 0, 0);
                return;
            }
            StringBuilder sb4 = new StringBuilder();
            sb4.append(mo24569c());
            sb4.append("Media got video size time took ");
            sb4.append(System.currentTimeMillis() - this.f15834o);
            sb4.append(" msec");
            IAlog.m18021b(sb4.toString());
            this.f15841v = i;
            this.f15842w = i2;
            m17570e();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m17568d() {
        C7984a aVar = new C7984a(mo24569c(), "reset");
        C7838b bVar = this.f15821b;
        C7838b bVar2 = C7838b.Idle;
        if (bVar == bVar2) {
            StringBuilder sb = new StringBuilder();
            sb.append(mo24569c());
            sb.append(" reset called, but player is already resetted. Do nothing");
            IAlog.m18021b(sb.toString());
            return;
        }
        mo24564a(bVar2);
        try {
            super.reset();
        } catch (Exception e) {
        }
        aVar.mo24830a();
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m17570e() {
        if (this.f15829j) {
            if (this.f15828i) {
                StringBuilder sb = new StringBuilder();
                sb.append(mo24569c());
                sb.append("Media load time took ");
                sb.append(System.currentTimeMillis() - this.f15834o);
                sb.append(" msec");
                IAlog.m18021b(sb.toString());
                mo24564a(C7838b.Prepared);
                if (this.f15823d) {
                    mo24568b();
                }
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(mo24569c());
                sb2.append("Got prepared only, waiting for video size");
                IAlog.m18021b(sb2.toString());
                if (this.f15836q == null) {
                    this.f15836q = new Runnable() {
                        public final void run() {
                            StringBuilder sb = new StringBuilder();
                            sb.append(C7839a.this.mo24569c());
                            sb.append("Cannot wait for video size anymore");
                            IAlog.m18021b(sb.toString());
                            if (C7839a.this.getDuration() == 0) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(C7839a.this.mo24569c());
                                sb2.append("Cannot wait for video size anymore. duration is still 0 - aborting");
                                IAlog.m18021b(sb2.toString());
                                C7839a aVar = C7839a.this;
                                aVar.onError(aVar, 0, 0);
                                return;
                            }
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(C7839a.this.mo24569c());
                            sb3.append("Cannot wait for video size anymore. moving into ready");
                            IAlog.m18021b(sb3.toString());
                            C7839a.this.f15828i = true;
                            C7839a.this.m17570e();
                        }
                    };
                }
                if (this.f15837r == null) {
                    this.f15837r = new Handler(Looper.getMainLooper());
                }
                this.f15837r.postDelayed(this.f15836q, 2000);
            }
        }
    }

    /* renamed from: a */
    public final void mo24564a(final C7838b bVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(mo24569c());
        sb.append(" updatePlayerState - ");
        sb.append(bVar);
        IAlog.m18021b(sb.toString());
        synchronized (this.f15821b) {
            if (this.f15821b == bVar) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(mo24569c());
                sb2.append(" updatePlayerState - mState didn't change!");
                IAlog.m18021b(sb2.toString());
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(mo24569c());
                sb3.append(" updatePlayerState - changing from ");
                sb3.append(this.f15821b);
                sb3.append(" to ");
                sb3.append(bVar);
                IAlog.m18021b(sb3.toString());
                this.f15821b = bVar;
                this.f15824e.post(new Runnable() {
                    public final void run() {
                        if (C7839a.this.f15831l != null) {
                            C7839a.this.f15831l.mo24457a(bVar);
                        }
                    }
                });
            }
        }
    }

    /* renamed from: a */
    public final void mo24565a(Runnable runnable) {
        HandlerThread handlerThread = this.f15825f;
        if (handlerThread != null && handlerThread.isAlive() && !this.f15825f.isInterrupted()) {
            Handler handler = this.f15826g;
            if (handler != null) {
                handler.post(runnable);
            }
        }
        if (this.f15841v == 0 || this.f15842w == 0 || this.f15839t == 0) {
            Handler handler2 = this.f15826g;
            if (handler2 != null) {
                handler2.post(this.f15838s);
            }
        }
    }

    /* renamed from: c */
    public final String mo24569c() {
        StringBuilder sb = new StringBuilder("mp(");
        sb.append(this);
        sb.append("): T:");
        sb.append(Thread.currentThread().getId());
        sb.append("-");
        sb.append(Thread.currentThread().getName());
        sb.append(": ");
        return sb.toString();
    }

    /* renamed from: a */
    static /* synthetic */ void m17565a(C7839a aVar, SurfaceHolder surfaceHolder) {
        C7984a aVar2 = new C7984a(aVar.mo24569c(), "setDisplayInternal");
        StringBuilder sb = new StringBuilder();
        sb.append(aVar.mo24569c());
        sb.append(" setDisplay called with ");
        sb.append(surfaceHolder);
        IAlog.m18021b(sb.toString());
        try {
            super.setDisplay(surfaceHolder);
            if (surfaceHolder == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(aVar.mo24569c());
                sb2.append(" setDisplay with null! current display cleared");
                IAlog.m18021b(sb2.toString());
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(aVar.mo24569c());
                sb3.append(" setDisplay - replacing surface holder!");
                IAlog.m18021b(sb3.toString());
            }
            aVar2.mo24830a();
        } catch (Exception e) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(aVar.mo24569c());
            sb4.append(" super.setDisplay threw exception!");
            IAlog.m18021b(sb4.toString());
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m17564a(C7839a aVar, Surface surface) {
        C7984a aVar2 = new C7984a(aVar.mo24569c(), "setSurface");
        StringBuilder sb = new StringBuilder();
        sb.append(aVar.mo24569c());
        sb.append(" setSurface called with ");
        sb.append(surface);
        IAlog.m18021b(sb.toString());
        try {
            super.setSurface(surface);
            if (surface == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(aVar.mo24569c());
                sb2.append(" setSurface with null! current surface cleared");
                IAlog.m18021b(sb2.toString());
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(aVar.mo24569c());
                sb3.append(" setSurface - replacing surface!");
                IAlog.m18021b(sb3.toString());
            }
            aVar2.mo24830a();
        } catch (Exception e) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(aVar.mo24569c());
            sb4.append(" super.setSurface threw exception!");
            IAlog.m18021b(sb4.toString());
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m17562a(C7839a aVar) {
        C7984a aVar2 = new C7984a(aVar.mo24569c(), "release");
        super.release();
        aVar2.mo24830a();
    }

    /* renamed from: c */
    static /* synthetic */ void m17567c(C7839a aVar) {
        C7984a aVar2 = new C7984a(aVar.mo24569c(), "start");
        C7838b bVar = aVar.f15821b;
        if (bVar == C7838b.Paused || bVar == C7838b.Prepared || bVar == C7838b.Completed) {
            super.start();
            aVar.mo24564a(C7838b.Playing);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(aVar.mo24569c());
            sb.append(" Start called in wrong mState! ");
            sb.append(bVar);
            IAlog.m18021b(sb.toString());
            if (aVar.f15821b == C7838b.Seeking) {
                aVar.f15822c = true;
            }
        }
        aVar2.mo24830a();
    }

    /* renamed from: a */
    static /* synthetic */ void m17563a(C7839a aVar, int i) {
        C7984a aVar2 = new C7984a(aVar.mo24569c(), "seekTo");
        super.seekTo(i);
        aVar2.mo24830a();
    }

    /* renamed from: d */
    static /* synthetic */ void m17569d(C7839a aVar) {
        C7984a aVar2 = new C7984a(aVar.mo24569c(), "delayed pause");
        if (super.isPlaying()) {
            super.pause();
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(aVar.mo24569c());
            sb.append(" paused called cannot set to pause, canceled");
            IAlog.m18021b(sb.toString());
        }
        aVar2.mo24830a();
    }

    /* renamed from: e */
    static /* synthetic */ void m17571e(C7839a aVar) {
        C7984a aVar2 = new C7984a(aVar.mo24569c(), "mute");
        aVar.setVolume(0.0f, 0.0f);
        aVar2.mo24830a();
    }

    /* renamed from: f */
    static /* synthetic */ void m17572f(C7839a aVar) {
        C7984a aVar2 = new C7984a(aVar.mo24569c(), "unmute");
        AudioManager audioManager = (AudioManager) aVar.f15820a.getSystemService("audio");
        int streamVolume = audioManager.getStreamVolume(3);
        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
        float f = ((float) streamVolume) / ((float) streamMaxVolume);
        StringBuilder sb = new StringBuilder();
        sb.append(aVar.mo24569c());
        sb.append(" unmute maxVolume = ");
        sb.append(streamMaxVolume);
        sb.append(" currentVolume = ");
        sb.append(streamVolume);
        sb.append(" targetVolume = ");
        sb.append(f);
        IAlog.m18021b(sb.toString());
        if (f == 0.0f) {
            f = 0.1f;
        }
        aVar.setVolume(f, f);
        aVar2.mo24830a();
    }
}
