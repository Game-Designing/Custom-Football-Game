package p019d.p307j.p308a;

import com.liulishuo.filedownloader.message.BlockCompleteMessage;
import com.liulishuo.filedownloader.message.MessageSnapshot;
import com.liulishuo.filedownloader.model.C10913c;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import junit.framework.Assert;
import p019d.p307j.p308a.C13069D.C13070a;
import p019d.p307j.p308a.C13079a.C13081b;
import p019d.p307j.p308a.C13079a.C13083d;
import p019d.p307j.p308a.p313e.C13117d;
import p019d.p307j.p308a.p313e.C13121g;

/* renamed from: d.j.a.o */
/* compiled from: FileDownloadMessenger */
class C13135o implements C13153z {

    /* renamed from: a */
    private C13081b f40167a;

    /* renamed from: b */
    private C13083d f40168b;

    /* renamed from: c */
    private Queue<MessageSnapshot> f40169c;

    /* renamed from: d */
    private boolean f40170d = false;

    C13135o(C13081b task, C13083d callback) {
        m42845a(task, callback);
    }

    /* renamed from: a */
    private void m42845a(C13081b task, C13083d callback) {
        this.f40167a = task;
        this.f40168b = callback;
        this.f40169c = new LinkedBlockingQueue();
    }

    /* renamed from: b */
    public boolean mo42121b() {
        if (C13117d.f40139a) {
            C13117d.m42778a(this, "notify begin %s", this.f40167a);
        }
        if (this.f40167a == null) {
            C13117d.m42783e(this, "can't begin the task, the holder fo the messenger is nil, %d", Integer.valueOf(this.f40169c.size()));
            return false;
        }
        this.f40168b.onBegin();
        return true;
    }

    /* renamed from: a */
    public void mo42118a(MessageSnapshot snapshot) {
        if (C13117d.f40139a) {
            C13117d.m42778a(this, "notify pending %s", this.f40167a);
        }
        this.f40168b.mo42056j();
        m42846k(snapshot);
    }

    /* renamed from: e */
    public void mo42126e(MessageSnapshot snapshot) {
        if (C13117d.f40139a) {
            C13117d.m42778a(this, "notify started %s", this.f40167a);
        }
        this.f40168b.mo42056j();
        m42846k(snapshot);
    }

    /* renamed from: d */
    public void mo42125d(MessageSnapshot snapshot) {
        if (C13117d.f40139a) {
            C13117d.m42778a(this, "notify connected %s", this.f40167a);
        }
        this.f40168b.mo42056j();
        m42846k(snapshot);
    }

    /* renamed from: g */
    public void mo42128g(MessageSnapshot snapshot) {
        C13079a originTask = this.f40167a.mo42043F();
        if (C13117d.f40139a) {
            C13117d.m42778a(this, "notify progress %s %d %d", originTask, Long.valueOf(originTask.mo42038w()), Long.valueOf(originTask.mo42039y()));
        }
        if (originTask.mo42032o() <= 0) {
            if (C13117d.f40139a) {
                C13117d.m42778a(this, "notify progress but client not request notify %s", this.f40167a);
            }
            return;
        }
        this.f40168b.mo42056j();
        m42846k(snapshot);
    }

    /* renamed from: i */
    public void mo42130i(MessageSnapshot snapshot) {
        if (C13117d.f40139a) {
            C13117d.m42778a(this, "notify block completed %s %s", this.f40167a, Thread.currentThread().getName());
        }
        this.f40168b.mo42056j();
        m42846k(snapshot);
    }

    /* renamed from: c */
    public void mo42122c(MessageSnapshot snapshot) {
        if (C13117d.f40139a) {
            C13079a originTask = this.f40167a.mo42043F();
            C13117d.m42778a(this, "notify retry %s %d %d %s", this.f40167a, Integer.valueOf(originTask.mo42030m()), Integer.valueOf(originTask.mo42009a()), originTask.mo42018f());
        }
        this.f40168b.mo42056j();
        m42846k(snapshot);
    }

    /* renamed from: h */
    public void mo42129h(MessageSnapshot snapshot) {
        if (C13117d.f40139a) {
            C13117d.m42778a(this, "notify warn %s", this.f40167a);
        }
        this.f40168b.mo42055e();
        m42846k(snapshot);
    }

    /* renamed from: b */
    public void mo42120b(MessageSnapshot snapshot) {
        if (C13117d.f40139a) {
            C13081b bVar = this.f40167a;
            C13117d.m42778a(this, "notify error %s %s", bVar, bVar.mo42043F().mo42018f());
        }
        this.f40168b.mo42055e();
        m42846k(snapshot);
    }

    /* renamed from: f */
    public void mo42127f(MessageSnapshot snapshot) {
        if (C13117d.f40139a) {
            C13117d.m42778a(this, "notify paused %s", this.f40167a);
        }
        this.f40168b.mo42055e();
        m42846k(snapshot);
    }

    /* renamed from: j */
    public void mo42131j(MessageSnapshot snapshot) {
        if (C13117d.f40139a) {
            C13117d.m42778a(this, "notify completed %s", this.f40167a);
        }
        this.f40168b.mo42055e();
        m42846k(snapshot);
    }

    /* renamed from: k */
    private void m42846k(MessageSnapshot snapshot) {
        C13081b bVar = this.f40167a;
        if (bVar == null) {
            if (C13117d.f40139a) {
                C13117d.m42778a(this, "occur this case, it would be the host task of this messenger has been over(paused/warn/completed/error) on the other thread before receiving the snapshot(id[%d], status[%d])", Integer.valueOf(snapshot.mo35701e()), Byte.valueOf(snapshot.mo35687k()));
            }
            return;
        }
        if (this.f40170d || bVar.mo42043F().mo42006A() == null) {
            if (C13136p.m42862b() && snapshot.mo35687k() == 4) {
                this.f40168b.mo42055e();
            }
            m42844a((int) snapshot.mo35687k());
        } else {
            this.f40169c.offer(snapshot);
            C13132n.m42834a().mo42115a((C13153z) this);
        }
    }

    /* renamed from: a */
    private void m42844a(int status) {
        if (!C10913c.m35800b(status)) {
            return;
        }
        if (this.f40169c.isEmpty()) {
            this.f40167a = null;
        } else {
            throw new IllegalStateException(C13121g.m42792a("the messenger[%s] has already accomplished all his job, but there still are some messages in parcel queue[%d]", this, Integer.valueOf(this.f40169c.size())));
        }
    }

    /* renamed from: d */
    public void mo42124d() {
        C13126i largeFileListener;
        if (!this.f40170d) {
            MessageSnapshot message = (MessageSnapshot) this.f40169c.poll();
            int currentStatus = message.mo35687k();
            C13081b task = this.f40167a;
            boolean z = false;
            String a = C13121g.m42792a("can't handover the message, no master to receive this message(status[%d]) size[%d]", Integer.valueOf(currentStatus), Integer.valueOf(this.f40169c.size()));
            if (task != null) {
                z = true;
            }
            Assert.assertTrue(a, z);
            C13079a originTask = task.mo42043F();
            C13130l listener = originTask.mo42006A();
            C13070a messageHandler = task.mo42052v();
            m42844a(currentStatus);
            if (listener != null && !listener.isInvalid()) {
                if (currentStatus == 4) {
                    try {
                        listener.blockComplete(originTask);
                        mo42131j(((BlockCompleteMessage) message).mo35686b());
                    } catch (Throwable throwable) {
                        mo42120b(messageHandler.mo41989a(throwable));
                    }
                } else {
                    if (listener instanceof C13126i) {
                        largeFileListener = (C13126i) listener;
                    } else {
                        largeFileListener = null;
                    }
                    if (currentStatus == -4) {
                        listener.warn(originTask);
                    } else if (currentStatus == -3) {
                        listener.completed(originTask);
                    } else if (currentStatus != -2) {
                        if (currentStatus == -1) {
                            listener.error(originTask, message.mo35698l());
                        } else if (currentStatus != 1) {
                            if (currentStatus != 2) {
                                if (currentStatus != 3) {
                                    if (currentStatus != 5) {
                                        if (currentStatus == 6) {
                                            listener.started(originTask);
                                        }
                                    } else if (largeFileListener != null) {
                                        largeFileListener.retry(originTask, message.mo35698l(), message.mo35699h(), message.mo35697f());
                                    } else {
                                        listener.retry(originTask, message.mo35698l(), message.mo35699h(), message.mo35688i());
                                    }
                                } else if (largeFileListener != null) {
                                    largeFileListener.progress(originTask, message.mo35697f(), originTask.mo42039y());
                                } else {
                                    listener.progress(originTask, message.mo35688i(), originTask.mo42026i());
                                }
                            } else if (largeFileListener != null) {
                                largeFileListener.connected(originTask, message.mo35694c(), message.mo35696n(), originTask.mo42038w(), message.mo35691g());
                            } else {
                                listener.connected(originTask, message.mo35694c(), message.mo35696n(), originTask.mo42031n(), message.mo35689j());
                            }
                        } else if (largeFileListener != null) {
                            largeFileListener.pending(originTask, message.mo35697f(), message.mo35691g());
                        } else {
                            listener.pending(originTask, message.mo35688i(), message.mo35689j());
                        }
                    } else if (largeFileListener != null) {
                        largeFileListener.paused(originTask, message.mo35697f(), message.mo35691g());
                    } else {
                        listener.paused(originTask, message.mo35688i(), message.mo35689j());
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public boolean mo42119a() {
        return this.f40167a.mo42043F().mo42008G();
    }

    /* renamed from: c */
    public boolean mo42123c() {
        return ((MessageSnapshot) this.f40169c.peek()).mo35687k() == 4;
    }

    public String toString() {
        return C13121g.m42792a("%d:%s", Integer.valueOf(this.f40167a.mo42043F().getId()), super.toString());
    }
}
