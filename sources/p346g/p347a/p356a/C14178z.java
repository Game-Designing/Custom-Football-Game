package p346g.p347a.p356a;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import p346g.p347a.C13817b;
import p363i.p369c.C14236b;
import p363i.p369c.C14246c;

/* renamed from: g.a.a.z */
/* compiled from: NetworkTopologyDiscoveryImpl */
public class C14178z implements C13817b {

    /* renamed from: a */
    private static final C14236b f43061a = C14246c.m45851a(C14178z.class.getName());

    /* renamed from: a */
    public InetAddress[] mo43163a() {
        Set<InetAddress> result = new HashSet<>();
        try {
            Enumeration<NetworkInterface> nifs = NetworkInterface.getNetworkInterfaces();
            while (nifs.hasMoreElements()) {
                NetworkInterface nif = (NetworkInterface) nifs.nextElement();
                Enumeration<InetAddress> iaenum = nif.getInetAddresses();
                while (iaenum.hasMoreElements()) {
                    InetAddress interfaceAddress = (InetAddress) iaenum.nextElement();
                    if (f43061a.isTraceEnabled()) {
                        C14236b bVar = f43061a;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Found NetworkInterface/InetAddress: ");
                        sb.append(nif);
                        sb.append(" -- ");
                        sb.append(interfaceAddress);
                        bVar.mo44345c(sb.toString());
                    }
                    if (mo44160a(nif, interfaceAddress)) {
                        result.add(interfaceAddress);
                    }
                }
            }
        } catch (SocketException se) {
            C14236b bVar2 = f43061a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Error while fetching network interfaces addresses: ");
            sb2.append(se);
            bVar2.mo44343b(sb2.toString());
        }
        return (InetAddress[]) result.toArray(new InetAddress[result.size()]);
    }

    /* renamed from: a */
    public boolean mo44160a(NetworkInterface networkInterface, InetAddress interfaceAddress) {
        try {
            if (networkInterface.isUp() && networkInterface.supportsMulticast() && !networkInterface.isLoopback()) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
