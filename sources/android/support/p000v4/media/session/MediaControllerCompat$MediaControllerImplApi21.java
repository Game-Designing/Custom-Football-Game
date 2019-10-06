package android.support.p000v4.media.session;

import android.os.Bundle;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.p000v4.app.C0476j;
import android.support.p000v4.media.MediaMetadataCompat;
import android.support.p000v4.media.session.C0544b.C0545a;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

/* renamed from: android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21 */
class MediaControllerCompat$MediaControllerImplApi21 implements C0551d {

    /* renamed from: a */
    private final List<C0547c> f1742a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C0544b f1743b;

    /* renamed from: c */
    private HashMap<C0547c, C0541a> f1744c;

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver */
    private static class ExtraBinderRequestResultReceiver extends ResultReceiver {

        /* renamed from: a */
        private WeakReference<MediaControllerCompat$MediaControllerImplApi21> f1745a;

        /* access modifiers changed from: protected */
        public void onReceiveResult(int resultCode, Bundle resultData) {
            MediaControllerCompat$MediaControllerImplApi21 mediaControllerImpl = (MediaControllerCompat$MediaControllerImplApi21) this.f1745a.get();
            if (mediaControllerImpl != null && resultData != null) {
                mediaControllerImpl.f1743b = C0545a.m2688a(C0476j.m2415a(resultData, "android.support.v4.media.session.EXTRA_BINDER"));
                mediaControllerImpl.m2662a();
            }
        }
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$a */
    private static class C0541a extends C0550c {
        C0541a(C0547c callback) {
            super(callback);
        }

        /* renamed from: w */
        public void mo5372w() throws RemoteException {
            throw new AssertionError();
        }

        /* renamed from: a */
        public void mo5368a(MediaMetadataCompat metadata) throws RemoteException {
            throw new AssertionError();
        }

        /* renamed from: a */
        public void mo5371a(List<MediaSessionCompat$QueueItem> list) throws RemoteException {
            throw new AssertionError();
        }

        /* renamed from: a */
        public void mo5370a(CharSequence title) throws RemoteException {
            throw new AssertionError();
        }

        /* renamed from: a */
        public void mo5367a(Bundle extras) throws RemoteException {
            throw new AssertionError();
        }

        /* renamed from: a */
        public void mo5369a(ParcelableVolumeInfo info) throws RemoteException {
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2662a() {
        if (this.f1743b != null) {
            synchronized (this.f1742a) {
                for (C0547c callback : this.f1742a) {
                    C0541a extraCallback = new C0541a(callback);
                    this.f1744c.put(callback, extraCallback);
                    callback.f1777c = true;
                    try {
                        this.f1743b.mo5399a(extraCallback);
                        callback.mo5410b();
                    } catch (RemoteException e) {
                        Log.e("MediaControllerCompat", "Dead object in registerCallback.", e);
                    }
                }
                this.f1742a.clear();
            }
        }
    }
}
