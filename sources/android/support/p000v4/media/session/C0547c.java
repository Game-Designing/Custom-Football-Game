package android.support.p000v4.media.session;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder.DeathRecipient;
import android.os.Message;
import android.os.RemoteException;
import android.support.p000v4.media.MediaMetadataCompat;
import android.support.p000v4.media.session.C0542a.C0543a;
import android.support.p000v4.media.session.C0553f.C0554a;
import java.lang.ref.WeakReference;
import java.util.List;

/* renamed from: android.support.v4.media.session.c */
/* compiled from: MediaControllerCompat */
public abstract class C0547c implements DeathRecipient {

    /* renamed from: a */
    private final Object f1775a;

    /* renamed from: b */
    C0548a f1776b;

    /* renamed from: c */
    boolean f1777c;

    /* renamed from: android.support.v4.media.session.c$a */
    /* compiled from: MediaControllerCompat */
    private class C0548a extends Handler {
    }

    /* renamed from: android.support.v4.media.session.c$b */
    /* compiled from: MediaControllerCompat */
    private static class C0549b implements C0554a {

        /* renamed from: a */
        private final WeakReference<C0547c> f1778a;

        C0549b(C0547c callback) {
            this.f1778a = new WeakReference<>(callback);
        }

        /* renamed from: w */
        public void mo5419w() {
            C0547c callback = (C0547c) this.f1778a.get();
            if (callback != null) {
                callback.mo5401a();
            }
        }

        /* renamed from: a */
        public void mo5416a(String event, Bundle extras) {
            C0547c callback = (C0547c) this.f1778a.get();
            if (callback == null) {
                return;
            }
            if (!callback.f1777c || VERSION.SDK_INT >= 23) {
                callback.mo5408a(event, extras);
            }
        }

        /* renamed from: b */
        public void mo5418b(Object stateObj) {
            C0547c callback = (C0547c) this.f1778a.get();
            if (callback != null && !callback.f1777c) {
                callback.mo5405a(PlaybackStateCompat.m2672a(stateObj));
            }
        }

        /* renamed from: a */
        public void mo5415a(Object metadataObj) {
            C0547c callback = (C0547c) this.f1778a.get();
            if (callback != null) {
                callback.mo5404a(MediaMetadataCompat.m2639a(metadataObj));
            }
        }

        /* renamed from: a */
        public void mo5417a(List<?> queue) {
            C0547c callback = (C0547c) this.f1778a.get();
            if (callback != null) {
                callback.mo5409a(MediaSessionCompat$QueueItem.m2671a(queue));
            }
        }

        /* renamed from: a */
        public void mo5414a(CharSequence title) {
            C0547c callback = (C0547c) this.f1778a.get();
            if (callback != null) {
                callback.mo5407a(title);
            }
        }

        /* renamed from: a */
        public void mo5413a(Bundle extras) {
            C0547c callback = (C0547c) this.f1778a.get();
            if (callback != null) {
                callback.mo5403a(extras);
            }
        }

        /* renamed from: a */
        public void mo5412a(int type, int stream, int control, int max, int current) {
            C0547c callback = (C0547c) this.f1778a.get();
            if (callback != null) {
                C0552e eVar = new C0552e(type, stream, control, max, current);
                callback.mo5406a(eVar);
            }
        }
    }

    /* renamed from: android.support.v4.media.session.c$c */
    /* compiled from: MediaControllerCompat */
    private static class C0550c extends C0543a {

        /* renamed from: a */
        private final WeakReference<C0547c> f1779a;

        C0550c(C0547c callback) {
            this.f1779a = new WeakReference<>(callback);
        }

        /* renamed from: a */
        public void mo5392a(String event, Bundle extras) throws RemoteException {
            C0547c callback = (C0547c) this.f1779a.get();
            if (callback != null) {
                callback.mo5402a(1, event, extras);
            }
        }

        /* renamed from: w */
        public void mo5372w() throws RemoteException {
            C0547c callback = (C0547c) this.f1779a.get();
            if (callback != null) {
                callback.mo5402a(8, null, null);
            }
        }

        /* renamed from: a */
        public void mo5391a(PlaybackStateCompat state) throws RemoteException {
            C0547c callback = (C0547c) this.f1779a.get();
            if (callback != null) {
                callback.mo5402a(2, state, null);
            }
        }

        /* renamed from: a */
        public void mo5368a(MediaMetadataCompat metadata) throws RemoteException {
            C0547c callback = (C0547c) this.f1779a.get();
            if (callback != null) {
                callback.mo5402a(3, metadata, null);
            }
        }

        /* renamed from: a */
        public void mo5371a(List<MediaSessionCompat$QueueItem> queue) throws RemoteException {
            C0547c callback = (C0547c) this.f1779a.get();
            if (callback != null) {
                callback.mo5402a(5, queue, null);
            }
        }

        /* renamed from: a */
        public void mo5370a(CharSequence title) throws RemoteException {
            C0547c callback = (C0547c) this.f1779a.get();
            if (callback != null) {
                callback.mo5402a(6, title, null);
            }
        }

        /* renamed from: b */
        public void mo5393b(boolean enabled) throws RemoteException {
            C0547c callback = (C0547c) this.f1779a.get();
            if (callback != null) {
                callback.mo5402a(11, Boolean.valueOf(enabled), null);
            }
        }

        /* renamed from: i */
        public void mo5396i(int repeatMode) throws RemoteException {
            C0547c callback = (C0547c) this.f1779a.get();
            if (callback != null) {
                callback.mo5402a(9, Integer.valueOf(repeatMode), null);
            }
        }

        /* renamed from: c */
        public void mo5394c(boolean enabled) throws RemoteException {
        }

        /* renamed from: h */
        public void mo5395h(int shuffleMode) throws RemoteException {
            C0547c callback = (C0547c) this.f1779a.get();
            if (callback != null) {
                callback.mo5402a(12, Integer.valueOf(shuffleMode), null);
            }
        }

        /* renamed from: a */
        public void mo5367a(Bundle extras) throws RemoteException {
            C0547c callback = (C0547c) this.f1779a.get();
            if (callback != null) {
                callback.mo5402a(7, extras, null);
            }
        }

        /* renamed from: a */
        public void mo5369a(ParcelableVolumeInfo info) throws RemoteException {
            C0547c callback = (C0547c) this.f1779a.get();
            if (callback != null) {
                C0552e pi = null;
                if (info != null) {
                    C0552e eVar = new C0552e(info.f1752a, info.f1753b, info.f1754c, info.f1755d, info.f1756e);
                    pi = eVar;
                }
                callback.mo5402a(4, pi, null);
            }
        }

        /* renamed from: H */
        public void mo5390H() throws RemoteException {
            C0547c callback = (C0547c) this.f1779a.get();
            if (callback != null) {
                callback.mo5402a(13, null, null);
            }
        }
    }

    public C0547c() {
        if (VERSION.SDK_INT >= 21) {
            this.f1775a = C0553f.m2721a(new C0549b(this));
        } else {
            this.f1775a = new C0550c(this);
        }
    }

    /* renamed from: b */
    public void mo5410b() {
    }

    /* renamed from: a */
    public void mo5401a() {
    }

    /* renamed from: a */
    public void mo5408a(String event, Bundle extras) {
    }

    /* renamed from: a */
    public void mo5405a(PlaybackStateCompat state) {
    }

    /* renamed from: a */
    public void mo5404a(MediaMetadataCompat metadata) {
    }

    /* renamed from: a */
    public void mo5409a(List<MediaSessionCompat$QueueItem> list) {
    }

    /* renamed from: a */
    public void mo5407a(CharSequence title) {
    }

    /* renamed from: a */
    public void mo5403a(Bundle extras) {
    }

    /* renamed from: a */
    public void mo5406a(C0552e info) {
    }

    public void binderDied() {
        mo5401a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo5402a(int what, Object obj, Bundle data) {
        C0548a aVar = this.f1776b;
        if (aVar != null) {
            Message msg = aVar.obtainMessage(what, obj);
            msg.setData(data);
            msg.sendToTarget();
        }
    }
}
