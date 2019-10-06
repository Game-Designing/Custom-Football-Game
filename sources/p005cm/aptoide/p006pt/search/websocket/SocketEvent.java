package p005cm.aptoide.p006pt.search.websocket;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.search.websocket.SocketEvent */
public final class SocketEvent {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final byte[] data;
    private final Status status;

    /* renamed from: cm.aptoide.pt.search.websocket.SocketEvent$Status */
    public enum Status {
        OPEN,
        MESSAGE,
        CLOSING,
        CLOSED,
        FAILURE;

        static {
            boolean[] $jacocoInit;
            $jacocoInit[3] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2720215075317851762L, "cm/aptoide/pt/search/websocket/SocketEvent", 7);
        $jacocoData = probes;
        return probes;
    }

    SocketEvent(Status status2, byte[] data2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.status = status2;
        this.data = data2;
        $jacocoInit[0] = true;
    }

    SocketEvent(Status status2) {
        boolean[] $jacocoInit = $jacocoInit();
        this(status2, null);
        $jacocoInit[1] = true;
    }

    public Status getStatus() {
        boolean[] $jacocoInit = $jacocoInit();
        Status status2 = this.status;
        $jacocoInit[2] = true;
        return status2;
    }

    public byte[] getData() {
        boolean[] $jacocoInit = $jacocoInit();
        byte[] bArr = this.data;
        $jacocoInit[3] = true;
        return bArr;
    }

    public boolean hasData() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (this.data != null) {
            $jacocoInit[4] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[5] = true;
        }
        $jacocoInit[6] = true;
        return z;
    }
}
