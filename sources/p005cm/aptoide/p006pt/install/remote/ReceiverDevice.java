package p005cm.aptoide.p006pt.install.remote;

import java.net.InetAddress;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.install.remote.ReceiverDevice */
public class ReceiverDevice {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private InetAddress address;
    private String deviceName;
    private int port;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(499697612354732972L, "cm/aptoide/pt/install/remote/ReceiverDevice", 11);
        $jacocoData = probes;
        return probes;
    }

    public ReceiverDevice(String deviceName2, InetAddress address2, int port2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.deviceName = deviceName2;
        this.address = address2;
        this.port = port2;
        $jacocoInit[0] = true;
    }

    public int getPort() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.port;
        $jacocoInit[1] = true;
        return i;
    }

    public String getDeviceName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.deviceName;
        $jacocoInit[2] = true;
        return str;
    }

    public void setDeviceName(String deviceName2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.deviceName = deviceName2;
        $jacocoInit[3] = true;
    }

    public boolean isSameDevice(ReceiverDevice device) {
        boolean[] $jacocoInit = $jacocoInit();
        String hostAddress = this.address.getHostAddress();
        $jacocoInit[4] = true;
        InetAddress address2 = device.getAddress();
        $jacocoInit[5] = true;
        String hostAddress2 = address2.getHostAddress();
        $jacocoInit[6] = true;
        if (hostAddress.equals(hostAddress2)) {
            $jacocoInit[7] = true;
            return true;
        }
        $jacocoInit[8] = true;
        return false;
    }

    public InetAddress getAddress() {
        boolean[] $jacocoInit = $jacocoInit();
        InetAddress inetAddress = this.address;
        $jacocoInit[9] = true;
        return inetAddress;
    }

    public void setAddress(InetAddress address2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.address = address2;
        $jacocoInit[10] = true;
    }
}
