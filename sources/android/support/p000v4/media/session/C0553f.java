package android.support.p000v4.media.session;

import android.media.AudioAttributes;
import android.media.MediaMetadata;
import android.media.session.MediaController.Callback;
import android.media.session.MediaController.PlaybackInfo;
import android.media.session.MediaSession.QueueItem;
import android.media.session.PlaybackState;
import android.os.Bundle;
import java.util.List;

/* renamed from: android.support.v4.media.session.f */
/* compiled from: MediaControllerCompatApi21 */
class C0553f {

    /* renamed from: android.support.v4.media.session.f$a */
    /* compiled from: MediaControllerCompatApi21 */
    public interface C0554a {
        /* renamed from: a */
        void mo5412a(int i, int i2, int i3, int i4, int i5);

        /* renamed from: a */
        void mo5413a(Bundle bundle);

        /* renamed from: a */
        void mo5414a(CharSequence charSequence);

        /* renamed from: a */
        void mo5415a(Object obj);

        /* renamed from: a */
        void mo5416a(String str, Bundle bundle);

        /* renamed from: a */
        void mo5417a(List<?> list);

        /* renamed from: b */
        void mo5418b(Object obj);

        /* renamed from: w */
        void mo5419w();
    }

    /* renamed from: android.support.v4.media.session.f$b */
    /* compiled from: MediaControllerCompatApi21 */
    static class C0555b<T extends C0554a> extends Callback {

        /* renamed from: a */
        protected final T f1785a;

        public C0555b(T callback) {
            this.f1785a = callback;
        }

        public void onSessionDestroyed() {
            this.f1785a.mo5419w();
        }

        public void onSessionEvent(String event, Bundle extras) {
            this.f1785a.mo5416a(event, extras);
        }

        public void onPlaybackStateChanged(PlaybackState state) {
            this.f1785a.mo5418b(state);
        }

        public void onMetadataChanged(MediaMetadata metadata) {
            this.f1785a.mo5415a((Object) metadata);
        }

        public void onQueueChanged(List<QueueItem> queue) {
            this.f1785a.mo5417a(queue);
        }

        public void onQueueTitleChanged(CharSequence title) {
            this.f1785a.mo5414a(title);
        }

        public void onExtrasChanged(Bundle extras) {
            this.f1785a.mo5413a(extras);
        }

        public void onAudioInfoChanged(PlaybackInfo info) {
            this.f1785a.mo5412a(info.getPlaybackType(), C0556c.m2732b(info), info.getVolumeControl(), info.getMaxVolume(), info.getCurrentVolume());
        }
    }

    /* renamed from: android.support.v4.media.session.f$c */
    /* compiled from: MediaControllerCompatApi21 */
    public static class C0556c {
        /* renamed from: a */
        public static AudioAttributes m2731a(Object volumeInfoObj) {
            return ((PlaybackInfo) volumeInfoObj).getAudioAttributes();
        }

        /* renamed from: b */
        public static int m2732b(Object volumeInfoObj) {
            return m2730a(m2731a(volumeInfoObj));
        }

        /* renamed from: a */
        private static int m2730a(AudioAttributes aa) {
            if ((aa.getFlags() & 1) == 1) {
                return 7;
            }
            if ((aa.getFlags() & 4) == 4) {
                return 6;
            }
            switch (aa.getUsage()) {
                case 1:
                case 11:
                case 12:
                case 14:
                    return 3;
                case 2:
                    return 0;
                case 3:
                    return 8;
                case 4:
                    return 4;
                case 5:
                case 7:
                case 8:
                case 9:
                case 10:
                    return 5;
                case 6:
                    return 2;
                case 13:
                    return 1;
                default:
                    return 3;
            }
        }
    }

    /* renamed from: a */
    public static Object m2721a(C0554a callback) {
        return new C0555b(callback);
    }
}
