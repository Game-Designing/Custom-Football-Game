package android.support.p000v4.media.session;

import android.media.session.PlaybackState;
import android.media.session.PlaybackState.CustomAction;
import android.os.Bundle;
import java.util.List;

/* renamed from: android.support.v4.media.session.n */
/* compiled from: PlaybackStateCompatApi21 */
class C0564n {

    /* renamed from: android.support.v4.media.session.n$a */
    /* compiled from: PlaybackStateCompatApi21 */
    static final class C0565a {
        /* renamed from: a */
        public static String m2744a(Object customActionObj) {
            return ((CustomAction) customActionObj).getAction();
        }

        /* renamed from: d */
        public static CharSequence m2747d(Object customActionObj) {
            return ((CustomAction) customActionObj).getName();
        }

        /* renamed from: c */
        public static int m2746c(Object customActionObj) {
            return ((CustomAction) customActionObj).getIcon();
        }

        /* renamed from: b */
        public static Bundle m2745b(Object customActionObj) {
            return ((CustomAction) customActionObj).getExtras();
        }
    }

    /* renamed from: i */
    public static int m2743i(Object stateObj) {
        return ((PlaybackState) stateObj).getState();
    }

    /* renamed from: h */
    public static long m2742h(Object stateObj) {
        return ((PlaybackState) stateObj).getPosition();
    }

    /* renamed from: c */
    public static long m2737c(Object stateObj) {
        return ((PlaybackState) stateObj).getBufferedPosition();
    }

    /* renamed from: g */
    public static float m2741g(Object stateObj) {
        return ((PlaybackState) stateObj).getPlaybackSpeed();
    }

    /* renamed from: a */
    public static long m2735a(Object stateObj) {
        return ((PlaybackState) stateObj).getActions();
    }

    /* renamed from: e */
    public static CharSequence m2739e(Object stateObj) {
        return ((PlaybackState) stateObj).getErrorMessage();
    }

    /* renamed from: f */
    public static long m2740f(Object stateObj) {
        return ((PlaybackState) stateObj).getLastPositionUpdateTime();
    }

    /* renamed from: d */
    public static List<Object> m2738d(Object stateObj) {
        return ((PlaybackState) stateObj).getCustomActions();
    }

    /* renamed from: b */
    public static long m2736b(Object stateObj) {
        return ((PlaybackState) stateObj).getActiveQueueItemId();
    }
}
