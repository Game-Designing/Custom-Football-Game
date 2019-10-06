package p005cm.aptoide.p006pt.search.websocket;

import java.nio.charset.Charset;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.logger.Logger;
import p005cm.aptoide.p006pt.search.websocket.SocketEvent.Status;
import p026rx.C0120S;
import p026rx.C14504P;
import p026rx.C14504P.C14505a;
import p026rx.p027b.C0129b;
import p362h.C14195j;

/* renamed from: cm.aptoide.pt.search.websocket.ReactiveWebSocket */
public class ReactiveWebSocket {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final int CLOSE_STATUS_CODE = 1000;
    private final OkHttpClient client;
    private final Request request;
    private WebSocket webSocket;

    /* renamed from: cm.aptoide.pt.search.websocket.ReactiveWebSocket$1 */
    static /* synthetic */ class C49191 {
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(3430832704520618915L, "cm/aptoide/pt/search/websocket/ReactiveWebSocket$1", 0);
            $jacocoData = probes;
            return probes;
        }
    }

    /* renamed from: cm.aptoide.pt.search.websocket.ReactiveWebSocket$ReactiveWebSocketListener */
    private static final class ReactiveWebSocketListener extends WebSocketListener {
        private static transient /* synthetic */ boolean[] $jacocoData;
        private static final String TAG = ReactiveWebSocketListener.class.getName();
        private final C14504P<SocketEvent> emitter;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(3648668960528053930L, "cm/aptoide/pt/search/websocket/ReactiveWebSocket$ReactiveWebSocketListener", 29);
            $jacocoData = probes;
            return probes;
        }

        /* synthetic */ ReactiveWebSocketListener(C14504P x0, C49191 x1) {
            boolean[] $jacocoInit = $jacocoInit();
            this(x0);
            $jacocoInit[27] = true;
        }

        static {
            boolean[] $jacocoInit = $jacocoInit();
            $jacocoInit[28] = true;
        }

        private ReactiveWebSocketListener(C14504P<SocketEvent> emitter2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.emitter = emitter2;
            $jacocoInit[0] = true;
        }

        public void onOpen(WebSocket webSocket, Response response) {
            boolean[] $jacocoInit = $jacocoInit();
            super.onOpen(webSocket, response);
            $jacocoInit[1] = true;
            this.emitter.onNext(new SocketEvent(Status.OPEN));
            $jacocoInit[2] = true;
            Logger instance = Logger.getInstance();
            String str = TAG;
            $jacocoInit[3] = true;
            instance.mo2146v(str, "onOpen ::");
            $jacocoInit[4] = true;
        }

        public void onMessage(WebSocket webSocket, String text) {
            boolean[] $jacocoInit = $jacocoInit();
            super.onMessage(webSocket, text);
            C14504P<SocketEvent> p = this.emitter;
            Status status = Status.MESSAGE;
            $jacocoInit[5] = true;
            SocketEvent socketEvent = new SocketEvent(status, text.getBytes(Charset.forName("UTF-8")));
            $jacocoInit[6] = true;
            p.onNext(socketEvent);
            $jacocoInit[7] = true;
            Logger instance = Logger.getInstance();
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("onMessage (String) :: message = ");
            sb.append(text);
            String sb2 = sb.toString();
            $jacocoInit[8] = true;
            instance.mo2146v(str, sb2);
            $jacocoInit[9] = true;
        }

        public void onMessage(WebSocket webSocket, C14195j bytes) {
            boolean[] $jacocoInit = $jacocoInit();
            super.onMessage(webSocket, bytes);
            $jacocoInit[10] = true;
            this.emitter.onNext(new SocketEvent(Status.MESSAGE, bytes.mo44288u()));
            $jacocoInit[11] = true;
            Logger instance = Logger.getInstance();
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("onMessage (bytes) :: size = ");
            $jacocoInit[12] = true;
            sb.append(bytes.mo44285s());
            instance.mo2146v(str, sb.toString());
            $jacocoInit[13] = true;
        }

        public void onClosing(WebSocket webSocket, int code, String reason) {
            boolean[] $jacocoInit = $jacocoInit();
            super.onClosing(webSocket, code, reason);
            $jacocoInit[14] = true;
            this.emitter.onNext(new SocketEvent(Status.CLOSING));
            $jacocoInit[15] = true;
            Logger instance = Logger.getInstance();
            String str = TAG;
            $jacocoInit[16] = true;
            instance.mo2146v(str, "onClosing :: ");
            $jacocoInit[17] = true;
        }

        public void onClosed(WebSocket webSocket, int code, String reason) {
            boolean[] $jacocoInit = $jacocoInit();
            super.onClosed(webSocket, code, reason);
            $jacocoInit[18] = true;
            this.emitter.onNext(new SocketEvent(Status.CLOSED));
            $jacocoInit[19] = true;
            this.emitter.onCompleted();
            $jacocoInit[20] = true;
            Logger instance = Logger.getInstance();
            String str = TAG;
            $jacocoInit[21] = true;
            instance.mo2146v(str, "onClosed :: ");
            $jacocoInit[22] = true;
        }

        public void onFailure(WebSocket webSocket, Throwable throwable, Response response) {
            boolean[] $jacocoInit = $jacocoInit();
            super.onFailure(webSocket, throwable, response);
            $jacocoInit[23] = true;
            this.emitter.onError(throwable);
            $jacocoInit[24] = true;
            Logger instance = Logger.getInstance();
            String str = TAG;
            $jacocoInit[25] = true;
            instance.mo2146v(str, "onFailure :: ");
            $jacocoInit[26] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8449011732193514537L, "cm/aptoide/pt/search/websocket/ReactiveWebSocket", 11);
        $jacocoData = probes;
        return probes;
    }

    public ReactiveWebSocket(OkHttpClient client2, Request request2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.client = client2;
        this.request = request2;
        $jacocoInit[0] = true;
    }

    public void send(String data) {
        boolean[] $jacocoInit = $jacocoInit();
        WebSocket webSocket2 = this.webSocket;
        if (webSocket2 != null) {
            $jacocoInit[1] = true;
            webSocket2.send(data);
            $jacocoInit[3] = true;
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Call listen() first to open the connection and wait for data.");
        $jacocoInit[2] = true;
        throw illegalStateException;
    }

    public void send(byte[] data) {
        boolean[] $jacocoInit = $jacocoInit();
        WebSocket webSocket2 = this.webSocket;
        if (webSocket2 != null) {
            $jacocoInit[4] = true;
            webSocket2.send(C14195j.m45647a(data));
            $jacocoInit[6] = true;
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Call listen() first to open the connection and wait for data.");
        $jacocoInit[5] = true;
        throw illegalStateException;
    }

    public C0120S<SocketEvent> listen() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<SocketEvent> a = C0120S.m642a((C0129b<C14504P<T>>) new C4920a<C14504P<T>>(this), C14505a.LATEST);
        $jacocoInit[7] = true;
        return a;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16402a(C14504P emitter) {
        boolean[] $jacocoInit = $jacocoInit();
        this.webSocket = this.client.newWebSocket(this.request, new ReactiveWebSocketListener(emitter, null));
        $jacocoInit[8] = true;
        emitter.mo45700a(new C4921b(this));
        $jacocoInit[9] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16401a() throws Exception {
        boolean[] $jacocoInit = $jacocoInit();
        this.webSocket.close(1000, null);
        $jacocoInit[10] = true;
    }
}
