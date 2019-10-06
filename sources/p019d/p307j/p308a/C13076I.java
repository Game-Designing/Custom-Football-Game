package p019d.p307j.p308a;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.util.SparseArray;
import com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import p019d.p307j.p308a.C13079a.C13080a;
import p019d.p307j.p308a.C13079a.C13081b;
import p019d.p307j.p308a.p313e.C13117d;
import p019d.p307j.p308a.p313e.C13121g;

/* renamed from: d.j.a.I */
/* compiled from: QueuesHandler */
class C13076I implements C13068C {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final SparseArray<Handler> f40061a = new SparseArray<>();

    /* renamed from: d.j.a.I$a */
    /* compiled from: QueuesHandler */
    private static class C13077a implements C13080a {

        /* renamed from: a */
        private final WeakReference<C13078b> f40062a;

        /* renamed from: b */
        private int f40063b;

        private C13077a(WeakReference<C13078b> wSerialHandlerCallback) {
            this.f40062a = wSerialHandlerCallback;
        }

        /* renamed from: a */
        public C13080a mo41999a(int index) {
            this.f40063b = index;
            return this;
        }

        /* renamed from: a */
        public void mo42000a(C13079a task) {
            WeakReference<C13078b> weakReference = this.f40062a;
            if (weakReference != null && weakReference.get() != null) {
                ((C13078b) this.f40062a.get()).m42577a(this.f40063b);
            }
        }
    }

    /* renamed from: d.j.a.I$b */
    /* compiled from: QueuesHandler */
    private class C13078b implements Callback {

        /* renamed from: a */
        private Handler f40064a;

        /* renamed from: b */
        private List<C13081b> f40065b;

        /* renamed from: c */
        private int f40066c = 0;

        /* renamed from: d */
        private C13077a f40067d = new C13077a(new WeakReference(this));

        C13078b() {
        }

        /* renamed from: a */
        public void mo42002a(Handler handler) {
            this.f40064a = handler;
        }

        /* renamed from: a */
        public void mo42003a(List<C13081b> list) {
            this.f40065b = list;
        }

        public boolean handleMessage(Message msg) {
            int i = msg.what;
            if (i == 1) {
                if (msg.arg1 >= this.f40065b.size()) {
                    synchronized (C13076I.this.f40061a) {
                        C13076I.this.f40061a.remove(((C13081b) this.f40065b.get(0)).mo42045b());
                    }
                    Handler handler = this.f40064a;
                    C13130l lVar = null;
                    if (!(handler == null || handler.getLooper() == null)) {
                        this.f40064a.getLooper().quit();
                        this.f40064a = null;
                        this.f40065b = null;
                        this.f40067d = null;
                    }
                    if (C13117d.f40139a) {
                        Class<C13078b> cls = C13078b.class;
                        Object[] objArr = new Object[2];
                        List<C13081b> list = this.f40065b;
                        if (!(list == null || list.get(0) == null)) {
                            lVar = ((C13081b) this.f40065b.get(0)).mo42043F().mo42006A();
                        }
                        objArr[0] = lVar;
                        objArr[1] = Integer.valueOf(msg.arg1);
                        C13117d.m42778a(cls, "final serial %s %d", objArr);
                    }
                    return true;
                }
                this.f40066c = msg.arg1;
                C13081b stackTopTask = (C13081b) this.f40065b.get(this.f40066c);
                synchronized (stackTopTask.mo42048d()) {
                    if (stackTopTask.mo42043F().getStatus() == 0) {
                        if (!C13128k.m42819b().mo42110c(stackTopTask)) {
                            C13079a F = stackTopTask.mo42043F();
                            C13077a aVar = this.f40067d;
                            aVar.mo41999a(this.f40066c + 1);
                            F.mo42014b(aVar);
                            stackTopTask.mo42041C();
                        }
                    }
                    if (C13117d.f40139a) {
                        C13117d.m42778a(C13078b.class, "direct go next by not contains %s %d", stackTopTask, Integer.valueOf(msg.arg1));
                    }
                    m42577a(msg.arg1 + 1);
                    return true;
                }
            } else if (i == 2) {
                mo42001a();
            } else if (i == 3) {
                mo42004b();
            }
            return true;
        }

        /* renamed from: a */
        public void mo42001a() {
            ((C13081b) this.f40065b.get(this.f40066c)).mo42043F().mo42012a((C13080a) this.f40067d);
            this.f40064a.removeCallbacksAndMessages(null);
        }

        /* renamed from: b */
        public void mo42004b() {
            m42577a(this.f40066c);
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m42577a(int nextIndex) {
            Handler handler = this.f40064a;
            if (handler == null || this.f40065b == null) {
                C13117d.m42783e(this, "need go next %d, but params is not ready %s %s", Integer.valueOf(nextIndex), this.f40064a, this.f40065b);
                return;
            }
            Message nextMsg = handler.obtainMessage();
            nextMsg.what = 1;
            nextMsg.arg1 = nextIndex;
            if (C13117d.f40139a) {
                Class<C13078b> cls = C13078b.class;
                Object[] objArr = new Object[2];
                List<C13081b> list = this.f40065b;
                C13130l lVar = null;
                if (!(list == null || list.get(0) == null)) {
                    lVar = ((C13081b) this.f40065b.get(0)).mo42043F().mo42006A();
                }
                objArr[0] = lVar;
                objArr[1] = Integer.valueOf(nextMsg.arg1);
                C13117d.m42778a(cls, "start next %s %s", objArr);
            }
            this.f40064a.sendMessage(nextMsg);
        }
    }

    /* renamed from: b */
    public boolean mo41979b(C13130l listener) {
        int attachKey = listener.hashCode();
        List<IRunningTask> list = C13128k.m42819b().mo42100a(attachKey, listener);
        if (m42567a(attachKey, list, listener, false)) {
            return false;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((C13081b) it.next()).mo42041C();
        }
        return true;
    }

    /* renamed from: a */
    public boolean mo41977a(C13130l listener) {
        C13078b callback = new C13078b();
        int attachKey = callback.hashCode();
        List<IRunningTask> list = C13128k.m42819b().mo42100a(attachKey, listener);
        if (m42567a(attachKey, list, listener, true)) {
            return false;
        }
        HandlerThread serialThread = new HandlerThread(C13121g.m42792a("filedownloader serial thread %s-%d", listener, Integer.valueOf(attachKey)));
        serialThread.start();
        Handler serialHandler = new Handler(serialThread.getLooper(), callback);
        callback.mo42002a(serialHandler);
        callback.mo42003a(list);
        callback.m42577a(0);
        synchronized (this.f40061a) {
            this.f40061a.put(attachKey, serialHandler);
        }
        return true;
    }

    /* renamed from: b */
    public void mo41978b() {
        for (int i = 0; i < this.f40061a.size(); i++) {
            m42566a((Handler) this.f40061a.get(this.f40061a.keyAt(i)));
        }
    }

    /* renamed from: a */
    public void mo41975a(List<Integer> attachKeyList) {
        for (Integer attachKey : attachKeyList) {
            m42568b((Handler) this.f40061a.get(attachKey.intValue()));
        }
    }

    /* renamed from: a */
    public int mo41974a() {
        return this.f40061a.size();
    }

    /* renamed from: a */
    public boolean mo41976a(int attachKey) {
        return this.f40061a.get(attachKey) != null;
    }

    /* renamed from: a */
    private boolean m42567a(int attachKey, List<C13081b> list, C13130l listener, boolean isSerial) {
        if (C13136p.m42862b()) {
            C13136p.m42861a().mo42133a(list.size(), true, listener);
        }
        if (C13117d.f40139a) {
            C13117d.m42782d(C13149w.class, "start list attachKey[%d] size[%d] listener[%s] isSerial[%B]", Integer.valueOf(attachKey), Integer.valueOf(list.size()), listener, Boolean.valueOf(isSerial));
        }
        if (list != null && !list.isEmpty()) {
            return false;
        }
        C13117d.m42783e(C13149w.class, "Tasks with the listener can't start, because can't find any task with the provided listener, maybe tasks instance has been started in the past, so they are all are inUsing, if in this case, you can use [BaseDownloadTask#reuse] to reuse theme first then start again: [%s, %B]", listener, Boolean.valueOf(isSerial));
        return true;
    }

    /* renamed from: a */
    private void m42566a(Handler handler) {
        handler.sendEmptyMessage(2);
    }

    /* renamed from: b */
    private void m42568b(Handler handler) {
        handler.sendEmptyMessage(3);
    }
}
