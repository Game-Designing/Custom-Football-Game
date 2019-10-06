package com.fyber.inneractive.sdk.external;

import android.annotation.TargetApi;
import com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener;

public interface InneractiveUnitController<EL extends EventsListener> {

    public static class AdDisplayError extends Exception {
        public AdDisplayError() {
        }

        public AdDisplayError(String str) {
            super(str);
        }

        public AdDisplayError(String str, Throwable th) {
            super(str, th);
        }

        public AdDisplayError(Throwable th) {
            super(th);
        }

        @TargetApi(24)
        public AdDisplayError(String str, Throwable th, boolean z, boolean z2) {
            super(str, th, z, z2);
        }
    }

    public interface EventsListener {
        void onAdClicked(InneractiveAdSpot inneractiveAdSpot);

        void onAdEnteredErrorState(InneractiveAdSpot inneractiveAdSpot, AdDisplayError adDisplayError);

        void onAdImpression(InneractiveAdSpot inneractiveAdSpot);

        void onAdWillCloseInternalBrowser(InneractiveAdSpot inneractiveAdSpot);

        void onAdWillOpenExternalApp(InneractiveAdSpot inneractiveAdSpot);
    }

    public static abstract class EventsListenerAdapter implements EventsListener {
        public void onAdImpression(InneractiveAdSpot inneractiveAdSpot) {
        }

        public void onAdClicked(InneractiveAdSpot inneractiveAdSpot) {
        }

        public void onAdWillCloseInternalBrowser(InneractiveAdSpot inneractiveAdSpot) {
        }

        public void onAdWillOpenExternalApp(InneractiveAdSpot inneractiveAdSpot) {
        }
    }

    void addContentController(InneractiveContentController inneractiveContentController);

    void destroy();

    InneractiveAdSpot getAdSpot();

    EL getEventsListener();

    InneractiveContentController getSelectedContentController();

    void setEventsListener(EL el);
}
