package p346g.p347a.p356a;

import java.util.EventListener;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p346g.p347a.C13820c;
import p346g.p347a.C13821d;
import p346g.p347a.C13823e;
import p346g.p347a.C13824f;
import p363i.p369c.C14236b;
import p363i.p369c.C14246c;

/* renamed from: g.a.a.w */
/* compiled from: ListenerStatus */
public class C14169w<T extends EventListener> {

    /* renamed from: a */
    private final T f43048a;

    /* renamed from: b */
    private final boolean f43049b;

    /* renamed from: g.a.a.w$a */
    /* compiled from: ListenerStatus */
    public static class C14170a extends C14169w<C13823e> {

        /* renamed from: c */
        private static C14236b f43050c = C14246c.m45851a(C14170a.class.getName());

        /* renamed from: d */
        private final ConcurrentMap<String, C13821d> f43051d = new ConcurrentHashMap(32);

        public C14170a(C13823e listener, boolean synch) {
            super(listener, synch);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo44152a(C13820c event) {
            StringBuilder sb = new StringBuilder();
            sb.append(event.mo43167c());
            sb.append(".");
            sb.append(event.mo43169d());
            if (this.f43051d.putIfAbsent(sb.toString(), event.mo43166b().clone()) == null) {
                ((C13823e) mo44147a()).serviceAdded(event);
                C13821d info = event.mo43166b();
                if (info != null && info.mo43187u()) {
                    ((C13823e) mo44147a()).serviceResolved(event);
                    return;
                }
                return;
            }
            C14236b bVar = f43050c;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Service Added called for a service already added: ");
            sb2.append(event);
            bVar.mo44340a(sb2.toString());
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo44153b(C13820c event) {
            StringBuilder sb = new StringBuilder();
            sb.append(event.mo43167c());
            sb.append(".");
            sb.append(event.mo43169d());
            String qualifiedName = sb.toString();
            ConcurrentMap<String, C13821d> concurrentMap = this.f43051d;
            if (concurrentMap.remove(qualifiedName, concurrentMap.get(qualifiedName))) {
                ((C13823e) mo44147a()).serviceRemoved(event);
                return;
            }
            C14236b bVar = f43050c;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Service Removed called for a service already removed: ");
            sb2.append(event);
            bVar.mo44340a(sb2.toString());
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public synchronized void mo44154c(C13820c event) {
            C13821d info = event.mo43166b();
            if (info == null || !info.mo43187u()) {
                C14236b bVar = f43050c;
                StringBuilder sb = new StringBuilder();
                sb.append("Service Resolved called for an unresolved event: ");
                sb.append(event);
                bVar.mo44343b(sb.toString());
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(event.mo43167c());
                sb2.append(".");
                sb2.append(event.mo43169d());
                String qualifiedName = sb2.toString();
                C13821d previousServiceInfo = (C13821d) this.f43051d.get(qualifiedName);
                if (m45539a(info, previousServiceInfo)) {
                    C14236b bVar2 = f43050c;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Service Resolved called for a service already resolved: ");
                    sb3.append(event);
                    bVar2.mo44340a(sb3.toString());
                } else if (previousServiceInfo == null) {
                    if (this.f43051d.putIfAbsent(qualifiedName, info.clone()) == null) {
                        ((C13823e) mo44147a()).serviceResolved(event);
                    }
                } else if (this.f43051d.replace(qualifiedName, previousServiceInfo, info.clone())) {
                    ((C13823e) mo44147a()).serviceResolved(event);
                }
            }
        }

        /* renamed from: a */
        private static final boolean m45539a(C13821d info, C13821d lastInfo) {
            if (info == null || lastInfo == null || !info.equals(lastInfo)) {
                return false;
            }
            byte[] text = info.mo43184r();
            byte[] lastText = lastInfo.mo43184r();
            if (text.length != lastText.length) {
                return false;
            }
            for (int i = 0; i < text.length; i++) {
                if (text[i] != lastText[i]) {
                    return false;
                }
            }
            if (info.mo43171a(lastInfo) == 0) {
                return false;
            }
            return true;
        }

        public String toString() {
            StringBuilder aLog = new StringBuilder(Opcodes.ACC_STRICT);
            aLog.append("[Status for ");
            aLog.append(((C13823e) mo44147a()).toString());
            if (this.f43051d.isEmpty()) {
                aLog.append(" no type event ");
            } else {
                aLog.append(" (");
                for (String service : this.f43051d.keySet()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(service);
                    sb.append(", ");
                    aLog.append(sb.toString());
                }
                aLog.append(") ");
            }
            aLog.append("]");
            return aLog.toString();
        }
    }

    /* renamed from: g.a.a.w$b */
    /* compiled from: ListenerStatus */
    public static class C14171b extends C14169w<C13824f> {

        /* renamed from: c */
        private static C14236b f43052c = C14246c.m45851a(C14171b.class.getName());

        /* renamed from: d */
        private final ConcurrentMap<String, String> f43053d;

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo44155a(C13820c event) {
            if (this.f43053d.putIfAbsent(event.mo43169d(), event.mo43169d()) == null) {
                ((C13824f) mo44147a()).mo43190b(event);
                return;
            }
            C14236b bVar = f43052c;
            StringBuilder sb = new StringBuilder();
            sb.append("Service Type Added called for a service type already added: ");
            sb.append(event);
            bVar.mo44345c(sb.toString());
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo44156b(C13820c event) {
            if (this.f43053d.putIfAbsent(event.mo43169d(), event.mo43169d()) == null) {
                ((C13824f) mo44147a()).mo43189a(event);
                return;
            }
            C14236b bVar = f43052c;
            StringBuilder sb = new StringBuilder();
            sb.append("Service Sub Type Added called for a service sub type already added: ");
            sb.append(event);
            bVar.mo44345c(sb.toString());
        }

        public String toString() {
            StringBuilder aLog = new StringBuilder(Opcodes.ACC_STRICT);
            aLog.append("[Status for ");
            aLog.append(((C13824f) mo44147a()).toString());
            if (this.f43053d.isEmpty()) {
                aLog.append(" no type event ");
            } else {
                aLog.append(" (");
                for (String type : this.f43053d.keySet()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(type);
                    sb.append(", ");
                    aLog.append(sb.toString());
                }
                aLog.append(") ");
            }
            aLog.append("]");
            return aLog.toString();
        }
    }

    public C14169w(T listener, boolean synch) {
        this.f43048a = listener;
        this.f43049b = synch;
    }

    /* renamed from: a */
    public T mo44147a() {
        return this.f43048a;
    }

    /* renamed from: b */
    public boolean mo44148b() {
        return this.f43049b;
    }

    public int hashCode() {
        return mo44147a().hashCode();
    }

    public boolean equals(Object obj) {
        return (obj instanceof C14169w) && mo44147a().equals(((C14169w) obj).mo44147a());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[Status for ");
        sb.append(mo44147a().toString());
        sb.append("]");
        return sb.toString();
    }
}
