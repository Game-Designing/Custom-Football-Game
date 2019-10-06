package p346g.p347a.p356a;

import java.io.IOException;
import java.net.DatagramPacket;
import p346g.p347a.p356a.p357a.C14100a;
import p363i.p369c.C14236b;
import p363i.p369c.C14246c;

/* renamed from: g.a.a.D */
/* compiled from: SocketListener */
class C14098D extends Thread {

    /* renamed from: a */
    static C14236b f42765a = C14246c.m45851a(C14098D.class.getName());

    /* renamed from: b */
    private final C14164v f42766b;

    C14098D(C14164v jmDNSImpl) {
        StringBuilder sb = new StringBuilder();
        sb.append("SocketListener(");
        sb.append(jmDNSImpl != null ? jmDNSImpl.mo44087G() : "");
        sb.append(")");
        super(sb.toString());
        setDaemon(true);
        this.f42766b = jmDNSImpl;
    }

    public void run() {
        String str = ".run() exception ";
        try {
            byte[] buf = new byte[8972];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            while (!this.f42766b.mo44096Q() && !this.f42766b.mo44095P()) {
                packet.setLength(buf.length);
                this.f42766b.mo44090K().receive(packet);
                if (this.f42766b.mo44096Q() || this.f42766b.mo44095P() || this.f42766b.mo44097R() || this.f42766b.isClosed()) {
                    break;
                }
                try {
                    if (!this.f42766b.mo44086F().mo44054a(packet)) {
                        C14123d msg = new C14123d(packet);
                        if (msg.mo43950s()) {
                            if (f42765a.isTraceEnabled()) {
                                C14236b bVar = f42765a;
                                StringBuilder sb = new StringBuilder();
                                sb.append(getName());
                                sb.append(".run() JmDNS in:");
                                sb.append(msg.mo43916a(true));
                                bVar.mo44345c(sb.toString());
                            }
                            if (msg.mo43947p()) {
                                if (packet.getPort() != C14100a.f42767a) {
                                    this.f42766b.mo44116b(msg, packet.getAddress(), packet.getPort());
                                }
                                this.f42766b.mo44116b(msg, this.f42766b.mo44083C(), C14100a.f42767a);
                            } else {
                                this.f42766b.mo44106a(msg);
                            }
                        } else if (f42765a.isDebugEnabled()) {
                            C14236b bVar2 = f42765a;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(getName());
                            sb2.append(".run() JmDNS in message with error code:");
                            sb2.append(msg.mo43916a(true));
                            bVar2.mo44340a(sb2.toString());
                        }
                    }
                } catch (IOException e) {
                    C14236b bVar3 = f42765a;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(getName());
                    sb3.append(str);
                    bVar3.mo44344b(sb3.toString(), e);
                }
            }
        } catch (IOException e2) {
            if (!this.f42766b.mo44096Q() && !this.f42766b.mo44095P() && !this.f42766b.mo44097R() && !this.f42766b.isClosed()) {
                C14236b bVar4 = f42765a;
                StringBuilder sb4 = new StringBuilder();
                sb4.append(getName());
                sb4.append(str);
                bVar4.mo44344b(sb4.toString(), e2);
                this.f42766b.mo44099T();
            }
        }
        if (f42765a.isTraceEnabled()) {
            C14236b bVar5 = f42765a;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(getName());
            sb5.append(".run() exiting.");
            bVar5.mo44345c(sb5.toString());
        }
    }
}
