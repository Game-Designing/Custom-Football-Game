package com.liulishuo.filedownloader.message;

import com.liulishuo.filedownloader.message.C10904d.C10906b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import p019d.p307j.p308a.p313e.C13111b;

/* renamed from: com.liulishuo.filedownloader.message.g */
/* compiled from: MessageSnapshotThreadPool */
public class C10909g {

    /* renamed from: a */
    private final List<C10910a> f33331a = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C10906b f33332b;

    /* renamed from: com.liulishuo.filedownloader.message.g$a */
    /* compiled from: MessageSnapshotThreadPool */
    public class C10910a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final List<Integer> f33333a = new ArrayList();

        /* renamed from: b */
        private final Executor f33334b;

        public C10910a(int index) {
            StringBuilder sb = new StringBuilder();
            sb.append("Flow-");
            sb.append(index);
            this.f33334b = C13111b.m42766a(1, sb.toString());
        }

        /* renamed from: a */
        public void mo35710a(int id) {
            this.f33333a.add(Integer.valueOf(id));
        }

        /* renamed from: a */
        public void mo35711a(MessageSnapshot snapshot) {
            this.f33334b.execute(new C10908f(this, snapshot));
        }
    }

    C10909g(int poolCount, C10906b receiver) {
        this.f33332b = receiver;
        for (int i = 0; i < poolCount; i++) {
            this.f33331a.add(new C10910a(i));
        }
    }

    /* renamed from: a */
    public void mo35709a(MessageSnapshot snapshot) {
        C10910a targetPool = null;
        try {
            synchronized (this.f33331a) {
                int id = snapshot.mo35701e();
                Iterator it = this.f33331a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    C10910a executor = (C10910a) it.next();
                    if (executor.f33333a.contains(Integer.valueOf(id))) {
                        targetPool = executor;
                        break;
                    }
                }
                if (targetPool == null) {
                    int leastTaskCount = 0;
                    Iterator it2 = this.f33331a.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        C10910a executor2 = (C10910a) it2.next();
                        if (executor2.f33333a.size() <= 0) {
                            targetPool = executor2;
                            break;
                        } else if (leastTaskCount == 0 || executor2.f33333a.size() < leastTaskCount) {
                            leastTaskCount = executor2.f33333a.size();
                            targetPool = executor2;
                        }
                    }
                }
                targetPool.mo35710a(id);
            }
            targetPool.mo35711a(snapshot);
        } catch (Throwable th) {
            targetPool.mo35711a(snapshot);
            throw th;
        }
    }
}
