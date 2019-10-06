package p019d.p143b.p144a.p147c;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p019d.p143b.p150d.C7262l;

/* renamed from: d.b.a.c.Sb */
public class C7110Sb {

    /* renamed from: a */
    private final String f13367a = "TaskManager";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C7142c f13368b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C7262l f13369c;

    /* renamed from: d */
    private final ScheduledThreadPoolExecutor f13370d;

    /* renamed from: e */
    private final ScheduledThreadPoolExecutor f13371e;

    /* renamed from: f */
    private final ScheduledThreadPoolExecutor f13372f;

    /* renamed from: g */
    private final List<C7122Wb> f13373g = new ArrayList(5);

    /* renamed from: h */
    private final Object f13374h = new Object();

    /* renamed from: i */
    private boolean f13375i;

    C7110Sb(C7142c cVar) {
        this.f13368b = cVar;
        this.f13369c = cVar.mo23049b();
        this.f13370d = m14921a("main");
        this.f13371e = m14921a("back");
        this.f13372f = m14921a("postbacks");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public long m14919a(C7113Tb tb) {
        long taskCount;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        if (tb == C7113Tb.MAIN) {
            taskCount = this.f13370d.getTaskCount();
            scheduledThreadPoolExecutor = this.f13370d;
        } else if (tb == C7113Tb.BACKGROUND) {
            taskCount = this.f13371e.getTaskCount();
            scheduledThreadPoolExecutor = this.f13371e;
        } else if (tb != C7113Tb.POSTBACKS) {
            return 0;
        } else {
            taskCount = this.f13372f.getTaskCount();
            scheduledThreadPoolExecutor = this.f13372f;
        }
        return taskCount - scheduledThreadPoolExecutor.getCompletedTaskCount();
    }

    /* renamed from: a */
    private ScheduledThreadPoolExecutor m14921a(String str) {
        return new ScheduledThreadPoolExecutor(1, new C7116Ub(this, str));
    }

    /* renamed from: a */
    private static void m14922a(Runnable runnable, long j, ScheduledExecutorService scheduledExecutorService) {
        if (j > 0) {
            scheduledExecutorService.schedule(runnable, j, TimeUnit.MILLISECONDS);
        } else {
            scheduledExecutorService.submit(runnable);
        }
    }

    /* renamed from: a */
    private boolean m14923a(C7122Wb wb) {
        if (wb.f13400b.f13628e) {
            return false;
        }
        synchronized (this.f13374h) {
            if (this.f13375i) {
                return false;
            }
            this.f13373g.add(wb);
            return true;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo22968a() {
        synchronized (this.f13374h) {
            this.f13375i = false;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo22969a(C7184mb mbVar) {
        String str = "TaskManager";
        if (mbVar != null) {
            try {
                C7262l lVar = this.f13369c;
                StringBuilder sb = new StringBuilder();
                sb.append("Executing ");
                sb.append(mbVar.mo23203a());
                sb.append(" immediately...");
                lVar.mo22920d(str, sb.toString());
                mbVar.run();
                C7262l lVar2 = this.f13369c;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(mbVar.mo23203a());
                sb2.append(" finished executing...");
                lVar2.mo22920d(str, sb2.toString());
            } catch (Throwable th) {
                this.f13369c.mo22917b(str, "Task failed execution", th);
            }
        } else {
            this.f13369c.mo22916b(str, "Attempted to execute null task immediately");
        }
    }

    /* renamed from: a */
    public void mo22970a(C7184mb mbVar, C7113Tb tb) {
        mo22971a(mbVar, tb, 0);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo22971a(C7184mb mbVar, C7113Tb tb, long j) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        if (mbVar == null) {
            throw new IllegalArgumentException("No task specified");
        } else if (j < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid delay specified: ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString());
        } else if (tb == C7113Tb.MAIN || tb == C7113Tb.BACKGROUND || tb == C7113Tb.POSTBACKS) {
            C7122Wb wb = new C7122Wb(this, mbVar, tb);
            if (!m14923a(wb)) {
                long a = m14919a(tb) + 1;
                C7262l lVar = this.f13369c;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Scheduling ");
                sb2.append(mbVar.f13624a);
                sb2.append(" on ");
                sb2.append(tb);
                sb2.append(" queue in ");
                sb2.append(j);
                sb2.append("ms with new queue size ");
                sb2.append(a);
                lVar.mo22918c("TaskManager", sb2.toString());
                if (tb == C7113Tb.MAIN) {
                    scheduledThreadPoolExecutor = this.f13370d;
                } else if (tb == C7113Tb.BACKGROUND) {
                    scheduledThreadPoolExecutor = this.f13371e;
                } else if (tb == C7113Tb.POSTBACKS) {
                    scheduledThreadPoolExecutor = this.f13372f;
                } else {
                    return;
                }
                m14922a((Runnable) wb, j, (ScheduledExecutorService) scheduledThreadPoolExecutor);
                return;
            }
            C7262l lVar2 = this.f13369c;
            String a2 = mbVar.mo23203a();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Task ");
            sb3.append(mbVar.mo23203a());
            sb3.append(" execution delayed until after init");
            lVar2.mo22920d(a2, sb3.toString());
        } else {
            throw new IllegalArgumentException("Invalid queue specified");
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo22972b() {
        synchronized (this.f13374h) {
            this.f13375i = true;
            for (C7122Wb wb : this.f13373g) {
                mo22970a(wb.f13400b, wb.f13401c);
            }
            this.f13373g.clear();
        }
    }
}
