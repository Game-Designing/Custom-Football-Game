package com.fyber.inneractive.sdk.p166g.p168b;

import android.content.Context;
import android.view.Surface;
import com.fyber.inneractive.sdk.p166g.p169c.C7838b;
import com.fyber.inneractive.sdk.p166g.p170d.C7839a;
import com.fyber.inneractive.sdk.util.IAlog;

/* renamed from: com.fyber.inneractive.sdk.g.b.a */
public final class C7794a extends C7799e {

    /* renamed from: k */
    private C7839a f15683k;

    /* renamed from: l */
    private int f15684l = 0;

    /* renamed from: m */
    private int f15685m = 2;

    /* renamed from: n */
    private int f15686n = 0;

    /* renamed from: o */
    private boolean f15687o = false;

    public C7794a(Context context) {
        super(context);
        IAlog.m18021b("Creating IAAndroidMediaPlayerController");
    }

    /* renamed from: a */
    public final void mo24416a() {
        C7839a aVar = this.f15683k;
        if (aVar != null) {
            aVar.reset();
            this.f15683k.release();
            this.f15683k = null;
        }
        super.mo24416a();
    }

    /* renamed from: a */
    public final void mo24420a(boolean z) {
        if (!mo24422b() || !this.f15706j) {
            this.f15706j = z;
            C7839a aVar = this.f15683k;
            if (aVar != null) {
                aVar.mo24568b();
            }
        }
    }

    /* renamed from: b */
    public final void mo24421b(boolean z) {
        if (mo24422b() || !this.f15706j) {
            this.f15706j = z;
            C7839a aVar = this.f15683k;
            if (aVar != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(aVar.mo24569c());
                sb.append(" unmute");
                IAlog.m18021b(sb.toString());
                aVar.f15823d = false;
                if (aVar.mo24567a()) {
                    aVar.mo24565a((Runnable) new Runnable() {
                        public final void run() {
                            C7839a.m17572f(C7839a.this);
                        }
                    });
                    return;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(aVar.mo24569c());
                sb2.append(" unmute called when player is not ready!");
                IAlog.m18021b(sb2.toString());
            }
        }
    }

    /* renamed from: b */
    public final boolean mo24422b() {
        C7839a aVar = this.f15683k;
        if (aVar != null) {
            return aVar.f15823d;
        }
        return false;
    }

    /* renamed from: c */
    public final void mo24423c() {
        C7839a aVar = this.f15683k;
        if (aVar != null) {
            aVar.pause();
        }
    }

    /* renamed from: d */
    public final int mo24424d() {
        C7839a aVar = this.f15683k;
        if (aVar != null) {
            return aVar.getVideoWidth();
        }
        return 0;
    }

    /* renamed from: e */
    public final int mo24425e() {
        C7839a aVar = this.f15683k;
        if (aVar != null) {
            return aVar.getVideoHeight();
        }
        return 0;
    }

    /* renamed from: f */
    public final void mo24426f() {
        C7839a aVar = this.f15683k;
        if (aVar != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(aVar.mo24569c());
            sb.append(" seek to called with = 1 mPlayAfterSeek = true");
            IAlog.m18021b(sb.toString());
            if (!aVar.mo24567a()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(aVar.mo24569c());
                sb2.append(" seek called when player is not ready!");
                IAlog.m18021b(sb2.toString());
                return;
            }
            C7838b bVar = aVar.f15821b;
            C7838b bVar2 = C7838b.Seeking;
            if (bVar == bVar2) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(aVar.mo24569c());
                sb3.append(" seek called when player is already seeking!");
                IAlog.m18021b(sb3.toString());
                return;
            }
            aVar.mo24564a(bVar2);
            aVar.f15822c = true;
            aVar.mo24565a((Runnable) new Runnable() {

                /* renamed from: a */
                final /* synthetic */ int f15845a = 1;

                public final void run() {
                    C7839a.m17563a(C7839a.this, this.f15845a);
                }
            });
        }
    }

    /* renamed from: g */
    public final void mo24427g() {
        C7839a aVar = this.f15683k;
        if (aVar != null) {
            aVar.start();
        }
    }

    /* renamed from: h */
    public final int mo24428h() {
        C7839a aVar = this.f15683k;
        if (aVar != null) {
            return aVar.getCurrentPosition();
        }
        return 0;
    }

    /* renamed from: i */
    public final int mo24429i() {
        C7839a aVar = this.f15683k;
        if (aVar != null) {
            return aVar.getDuration();
        }
        return 0;
    }

    /* renamed from: a */
    public final void mo24418a(Surface surface) {
        C7839a aVar = this.f15683k;
        if (aVar != null) {
            aVar.setSurface(surface);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public final void mo24430j() {
        if (this.f15683k == null) {
            IAlog.m18021b("MediaPlayerController: creating media player");
            this.f15683k = new C7839a(this.f15697a, this, this.f15702f);
        }
    }

    /* renamed from: a */
    public final void mo24419a(String str) {
        this.f15683k.mo24566a(str);
    }

    /* renamed from: a */
    public final void mo24417a(int i) {
        super.mo24417a(i);
        if (i == this.f15684l) {
            StringBuilder sb = new StringBuilder();
            sb.append(IAlog.m18018a((Object) this));
            sb.append("Video is stuck! Progress doesn't change");
            IAlog.m18021b(sb.toString());
            this.f15686n++;
            if (this.f15686n == this.f15685m) {
                mo24457a(C7838b.Buffering);
                this.f15687o = true;
            }
        } else if (this.f15687o) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(IAlog.m18018a((Object) this));
            sb2.append("Video progress was stuck! but now it goes forward. Remove buffering state");
            IAlog.m18021b(sb2.toString());
            mo24457a(C7838b.Playing);
            this.f15686n = 0;
            this.f15687o = false;
        }
        this.f15684l = i;
    }

    /* renamed from: k */
    public final Object mo24431k() {
        return this.f15683k;
    }
}
