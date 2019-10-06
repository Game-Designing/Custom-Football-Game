package p019d.p307j.p308a;

import com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask;
import com.liulishuo.filedownloader.message.C10904d.C10906b;
import com.liulishuo.filedownloader.message.MessageSnapshot;
import java.util.Iterator;
import java.util.List;
import p019d.p307j.p308a.C13079a.C13081b;
import p019d.p307j.p308a.p313e.C13117d;

/* renamed from: d.j.a.G */
/* compiled from: MessageSnapshotGate */
public class C13074G implements C10906b {
    /* renamed from: a */
    private boolean m42563a(List<C13081b> taskList, MessageSnapshot snapshot) {
        if (taskList.size() > 1 && snapshot.mo35687k() == -3) {
            for (C13081b task : taskList) {
                if (task.mo42052v().mo41993d(snapshot)) {
                    return true;
                }
            }
        }
        for (C13081b task2 : taskList) {
            if (task2.mo42052v().mo41991b(snapshot)) {
                return true;
            }
        }
        if (-4 == snapshot.mo35687k()) {
            for (C13081b task3 : taskList) {
                if (task3.mo42052v().mo41992c(snapshot)) {
                    return true;
                }
            }
        }
        if (taskList.size() == 1) {
            return ((C13081b) taskList.get(0)).mo42052v().mo41990a(snapshot);
        }
        return false;
    }

    /* renamed from: a */
    public void mo35707a(MessageSnapshot snapshot) {
        synchronized (Integer.toString(snapshot.mo35701e()).intern()) {
            List<IRunningTask> taskList = C13128k.m42819b().mo42111d(snapshot.mo35701e());
            if (taskList.size() > 0) {
                C13079a topOriginTask = ((C13081b) taskList.get(0)).mo42043F();
                if (C13117d.f40139a) {
                    C13117d.m42778a(this, "~~~callback %s old[%s] new[%s] %d", Integer.valueOf(snapshot.mo35701e()), Byte.valueOf(topOriginTask.getStatus()), Byte.valueOf(snapshot.mo35687k()), Integer.valueOf(taskList.size()));
                }
                if (!m42563a(taskList, snapshot)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("The event isn't consumed, id:");
                    sb.append(snapshot.mo35701e());
                    sb.append(" status:");
                    sb.append(snapshot.mo35687k());
                    sb.append(" task-count:");
                    sb.append(taskList.size());
                    String log = sb.toString();
                    Iterator it = taskList.iterator();
                    while (it.hasNext()) {
                        C13081b task = (C13081b) it.next();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(log);
                        sb2.append(" | ");
                        sb2.append(task.mo42043F().getStatus());
                        log = sb2.toString();
                    }
                    C13117d.m42781c(this, log, new Object[0]);
                }
            } else {
                C13117d.m42781c(this, "Receive the event %d, but there isn't any running task in the upper layer", Byte.valueOf(snapshot.mo35687k()));
            }
        }
    }
}
