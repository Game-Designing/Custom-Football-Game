package p346g.p347a.p356a;

import java.io.IOException;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import p346g.p347a.p356a.p357a.C14107h;
import p346g.p347a.p356a.p358b.C14110a;
import p363i.p369c.C14236b;
import p363i.p369c.C14246c;

/* renamed from: g.a.a.k */
/* compiled from: DNSStatefulObject */
public interface C14146k {

    /* renamed from: g.a.a.k$a */
    /* compiled from: DNSStatefulObject */
    public static final class C14147a {

        /* renamed from: a */
        private static C14236b f42973a = C14246c.m45851a(C14147a.class.getName());

        /* renamed from: b */
        private final String f42974b;

        /* renamed from: c */
        private final ConcurrentMap<Thread, Semaphore> f42975c = new ConcurrentHashMap(50);

        public C14147a(String name) {
            this.f42974b = name;
        }

        /* renamed from: a */
        public void mo44005a(long timeout) {
            Thread thread = Thread.currentThread();
            if (((Semaphore) this.f42975c.get(thread)) == null) {
                Semaphore semaphore = new Semaphore(1, true);
                semaphore.drainPermits();
                this.f42975c.putIfAbsent(thread, semaphore);
            }
            try {
                ((Semaphore) this.f42975c.get(thread)).tryAcquire(timeout, TimeUnit.MILLISECONDS);
            } catch (InterruptedException exception) {
                f42973a.mo44346c("Exception ", exception);
            }
        }

        /* renamed from: a */
        public void mo44004a() {
            Collection<Semaphore> semaphores = this.f42975c.values();
            for (Semaphore semaphore : semaphores) {
                semaphore.release();
                semaphores.remove(semaphore);
            }
        }

        public String toString() {
            StringBuilder aLog = new StringBuilder(1000);
            aLog.append("Semaphore: ");
            aLog.append(this.f42974b);
            if (this.f42975c.size() == 0) {
                aLog.append(" no semaphores.");
            } else {
                aLog.append(" semaphores:\n");
                for (Thread thread : this.f42975c.keySet()) {
                    aLog.append("\tThread: ");
                    aLog.append(thread.getName());
                    aLog.append(' ');
                    aLog.append(this.f42975c.get(thread));
                    aLog.append(10);
                }
            }
            return aLog.toString();
        }
    }

    /* renamed from: g.a.a.k$b */
    /* compiled from: DNSStatefulObject */
    public static class C14148b extends ReentrantLock implements C14146k {

        /* renamed from: a */
        private static C14236b f42976a = C14246c.m45851a(C14148b.class.getName());

        /* renamed from: b */
        private volatile C14164v f42977b = null;

        /* renamed from: c */
        protected volatile C14110a f42978c = null;

        /* renamed from: d */
        protected volatile C14107h f42979d = C14107h.PROBING_1;

        /* renamed from: e */
        private final C14147a f42980e = new C14147a("Announce");

        /* renamed from: f */
        private final C14147a f42981f = new C14147a("Cancel");

        /* renamed from: c */
        public C14164v mo44015c() {
            return this.f42977b;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo43815a(C14164v dns) {
            this.f42977b = dns;
        }

        /* renamed from: a */
        public void mo44008a(C14110a task, C14107h state) {
            if (this.f42978c == null && this.f42979d == state) {
                lock();
                try {
                    if (this.f42978c == null && this.f42979d == state) {
                        mo43816c(task);
                    }
                } finally {
                    unlock();
                }
            }
        }

        /* renamed from: b */
        public void mo44011b(C14110a task) {
            if (this.f42978c == task) {
                lock();
                try {
                    if (this.f42978c == task) {
                        mo43816c(null);
                    }
                } finally {
                    unlock();
                }
            }
        }

        /* renamed from: b */
        public boolean mo44014b(C14110a task, C14107h state) {
            lock();
            try {
                return this.f42978c == task && this.f42979d == state;
            } finally {
                unlock();
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public void mo43816c(C14110a task) {
            this.f42978c = task;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo44007a(C14107h state) {
            lock();
            try {
                this.f42979d = state;
                if (mo44016d()) {
                    this.f42980e.mo44004a();
                }
                if (mo44018f()) {
                    this.f42981f.mo44004a();
                    this.f42980e.mo44004a();
                }
            } finally {
                unlock();
            }
        }

        /* renamed from: a */
        public boolean mo43803a(C14110a task) {
            if (this.f42978c == task) {
                lock();
                try {
                    if (this.f42978c == task) {
                        mo44007a(this.f42979d.mo43839e());
                    } else {
                        C14236b bVar = f42976a;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Trying to advance state whhen not the owner. owner: ");
                        sb.append(this.f42978c);
                        sb.append(" perpetrator: ");
                        sb.append(task);
                        bVar.mo44343b(sb.toString());
                    }
                } finally {
                    unlock();
                }
            }
            return true;
        }

        /* renamed from: l */
        public boolean mo44024l() {
            if (!m45376m()) {
                lock();
                try {
                    if (!m45376m()) {
                        mo44007a(this.f42979d.mo43848v());
                        mo43816c(null);
                    }
                } finally {
                    unlock();
                }
            }
            return true;
        }

        /* renamed from: a */
        public boolean mo44009a() {
            boolean result = false;
            if (!m45376m()) {
                lock();
                try {
                    if (!m45376m()) {
                        mo44007a(C14107h.CANCELING_1);
                        mo43816c(null);
                        result = true;
                    }
                } finally {
                    unlock();
                }
            }
            return result;
        }

        /* renamed from: b */
        public boolean mo44012b() {
            boolean result = false;
            if (!m45377n()) {
                lock();
                try {
                    if (!m45377n()) {
                        mo44007a(C14107h.CLOSING);
                        mo43816c(null);
                        result = true;
                    }
                } finally {
                    unlock();
                }
            }
            return result;
        }

        /* renamed from: k */
        public boolean mo44023k() {
            lock();
            try {
                mo44007a(C14107h.PROBING_1);
                mo43816c(null);
                return false;
            } finally {
                unlock();
            }
        }

        /* renamed from: j */
        public boolean mo44022j() {
            return this.f42979d.mo43847u();
        }

        /* renamed from: e */
        public boolean mo44017e() {
            return this.f42979d.mo43841g();
        }

        /* renamed from: d */
        public boolean mo44016d() {
            return this.f42979d.mo43840f();
        }

        /* renamed from: g */
        public boolean mo44019g() {
            return this.f42979d.mo43843j();
        }

        /* renamed from: f */
        public boolean mo44018f() {
            return this.f42979d.mo43842i();
        }

        /* renamed from: i */
        public boolean mo44021i() {
            return this.f42979d.mo43845t();
        }

        /* renamed from: h */
        public boolean mo44020h() {
            return this.f42979d.mo43844s();
        }

        /* renamed from: m */
        private boolean m45376m() {
            return this.f42979d.mo43842i() || this.f42979d.mo43843j();
        }

        /* renamed from: n */
        private boolean m45377n() {
            return this.f42979d.mo43844s() || this.f42979d.mo43845t();
        }

        /* renamed from: a */
        public boolean mo44010a(long timeout) {
            if (!mo44016d() && !m45376m()) {
                this.f42980e.mo44005a(timeout + 10);
            }
            if (!mo44016d()) {
                this.f42980e.mo44005a(10);
                if (!mo44016d()) {
                    if (m45376m() || m45377n()) {
                        C14236b bVar = f42976a;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Wait for announced cancelled: ");
                        sb.append(this);
                        bVar.mo44340a(sb.toString());
                    } else {
                        C14236b bVar2 = f42976a;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Wait for announced timed out: ");
                        sb2.append(this);
                        bVar2.mo44343b(sb2.toString());
                    }
                }
            }
            return mo44016d();
        }

        /* renamed from: b */
        public boolean mo44013b(long timeout) {
            if (!mo44018f()) {
                this.f42981f.mo44005a(timeout);
            }
            if (!mo44018f()) {
                this.f42981f.mo44005a(10);
                if (!mo44018f() && !m45377n()) {
                    C14236b bVar = f42976a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Wait for canceled timed out: ");
                    sb.append(this);
                    bVar.mo44343b(sb.toString());
                }
            }
            return mo44018f();
        }

        public String toString() {
            String str;
            String str2 = " task: ";
            String str3 = " state: ";
            String str4 = "DNS: ";
            String str5 = "NO DNS";
            try {
                StringBuilder sb = new StringBuilder();
                if (this.f42977b != null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str4);
                    sb2.append(this.f42977b.mo44087G());
                    sb2.append(" [");
                    sb2.append(this.f42977b.mo44084D());
                    sb2.append("]");
                    str = sb2.toString();
                } else {
                    str = str5;
                }
                sb.append(str);
                sb.append(str3);
                sb.append(this.f42979d);
                sb.append(str2);
                sb.append(this.f42978c);
                return sb.toString();
            } catch (IOException e) {
                StringBuilder sb3 = new StringBuilder();
                if (this.f42977b != null) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(str4);
                    sb4.append(this.f42977b.mo44087G());
                    str5 = sb4.toString();
                }
                sb3.append(str5);
                sb3.append(str3);
                sb3.append(this.f42979d);
                sb3.append(str2);
                sb3.append(this.f42978c);
                return sb3.toString();
            }
        }
    }

    /* renamed from: a */
    boolean mo43803a(C14110a aVar);
}
