package com.google.android.gms.ads;

import android.os.RemoteException;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzaar;
import com.google.android.gms.internal.ads.zzacc;
import com.google.android.gms.internal.ads.zzard;
import com.google.android.gms.internal.ads.zzbad;

@zzard
public final class VideoController {
    @KeepForSdk
    public static final int PLAYBACK_STATE_ENDED = 3;
    @KeepForSdk
    public static final int PLAYBACK_STATE_PAUSED = 2;
    @KeepForSdk
    public static final int PLAYBACK_STATE_PLAYING = 1;
    @KeepForSdk
    public static final int PLAYBACK_STATE_READY = 5;
    @KeepForSdk
    public static final int PLAYBACK_STATE_UNKNOWN = 0;

    /* renamed from: a */
    private final Object f19028a = new Object();

    /* renamed from: b */
    private zzaar f19029b;

    /* renamed from: c */
    private VideoLifecycleCallbacks f19030c;

    public static abstract class VideoLifecycleCallbacks {
        public void onVideoStart() {
        }

        public void onVideoPlay() {
        }

        public void onVideoPause() {
        }

        public void onVideoEnd() {
        }

        public void onVideoMute(boolean z) {
        }
    }

    public final void zza(zzaar zzaar) {
        synchronized (this.f19028a) {
            this.f19029b = zzaar;
            if (this.f19030c != null) {
                setVideoLifecycleCallbacks(this.f19030c);
            }
        }
    }

    public final zzaar zzdh() {
        zzaar zzaar;
        synchronized (this.f19028a) {
            zzaar = this.f19029b;
        }
        return zzaar;
    }

    public final void play() {
        synchronized (this.f19028a) {
            if (this.f19029b != null) {
                try {
                    this.f19029b.play();
                } catch (RemoteException e) {
                    zzbad.m26356b("Unable to call play on video controller.", e);
                }
            }
        }
    }

    public final void pause() {
        synchronized (this.f19028a) {
            if (this.f19029b != null) {
                try {
                    this.f19029b.pause();
                } catch (RemoteException e) {
                    zzbad.m26356b("Unable to call pause on video controller.", e);
                }
            }
        }
    }

    public final void mute(boolean z) {
        synchronized (this.f19028a) {
            if (this.f19029b != null) {
                try {
                    this.f19029b.mo29368h(z);
                } catch (RemoteException e) {
                    zzbad.m26356b("Unable to call mute on video controller.", e);
                }
            }
        }
    }

    public final boolean isMuted() {
        synchronized (this.f19028a) {
            if (this.f19029b == null) {
                return true;
            }
            try {
                boolean Da = this.f19029b.mo29363Da();
                return Da;
            } catch (RemoteException e) {
                zzbad.m26356b("Unable to call isMuted on video controller.", e);
                return true;
            }
        }
    }

    @KeepForSdk
    public final int getPlaybackState() {
        synchronized (this.f19028a) {
            if (this.f19029b == null) {
                return 0;
            }
            try {
                int i = this.f19029b.mo29369i();
                return i;
            } catch (RemoteException e) {
                zzbad.m26356b("Unable to call getPlaybackState on video controller.", e);
                return 0;
            }
        }
    }

    public final boolean isCustomControlsEnabled() {
        synchronized (this.f19028a) {
            if (this.f19029b == null) {
                return false;
            }
            try {
                boolean Xa = this.f19029b.mo29366Xa();
                return Xa;
            } catch (RemoteException e) {
                zzbad.m26356b("Unable to call isUsingCustomPlayerControls.", e);
                return false;
            }
        }
    }

    public final boolean isClickToExpandEnabled() {
        synchronized (this.f19028a) {
            if (this.f19029b == null) {
                return false;
            }
            try {
                boolean O = this.f19029b.mo29365O();
                return O;
            } catch (RemoteException e) {
                zzbad.m26356b("Unable to call isClickToExpandEnabled.", e);
                return false;
            }
        }
    }

    public final void setVideoLifecycleCallbacks(VideoLifecycleCallbacks videoLifecycleCallbacks) {
        Preconditions.m21858a(videoLifecycleCallbacks, (Object) "VideoLifecycleCallbacks may not be null.");
        synchronized (this.f19028a) {
            this.f19030c = videoLifecycleCallbacks;
            if (this.f19029b != null) {
                try {
                    this.f19029b.mo29367a(new zzacc(videoLifecycleCallbacks));
                } catch (RemoteException e) {
                    zzbad.m26356b("Unable to call setVideoLifecycleCallbacks on video controller.", e);
                }
            }
        }
    }

    public final VideoLifecycleCallbacks getVideoLifecycleCallbacks() {
        VideoLifecycleCallbacks videoLifecycleCallbacks;
        synchronized (this.f19028a) {
            videoLifecycleCallbacks = this.f19030c;
        }
        return videoLifecycleCallbacks;
    }

    public final boolean hasVideoContent() {
        boolean z;
        synchronized (this.f19028a) {
            z = this.f19029b != null;
        }
        return z;
    }

    public final float getAspectRatio() {
        synchronized (this.f19028a) {
            if (this.f19029b == null) {
                return 0.0f;
            }
            try {
                float K = this.f19029b.mo29364K();
                return K;
            } catch (RemoteException e) {
                zzbad.m26356b("Unable to call getAspectRatio on video controller.", e);
                return 0.0f;
            }
        }
    }
}
