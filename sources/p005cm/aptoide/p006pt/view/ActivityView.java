package p005cm.aptoide.p006pt.view;

import com.trello.rxlifecycle.C0096f;
import com.trello.rxlifecycle.C0097g;
import com.trello.rxlifecycle.p263a.C12542a;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.analytics.view.AnalyticsActivity;
import p005cm.aptoide.p006pt.presenter.Presenter;
import p005cm.aptoide.p006pt.presenter.View;
import p005cm.aptoide.p006pt.presenter.View.LifecycleEvent;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.view.ActivityView */
public abstract class ActivityView extends AnalyticsActivity implements View {
    private static transient /* synthetic */ boolean[] $jacocoData;

    /* renamed from: cm.aptoide.pt.view.ActivityView$1 */
    static /* synthetic */ class C00701 {
        static final /* synthetic */ int[] $SwitchMap$com$trello$rxlifecycle$android$ActivityEvent = new int[C12542a.values().length];
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(525943570598845700L, "cm/aptoide/pt/view/ActivityView$1", 14);
            $jacocoData = probes;
            return probes;
        }

        static {
            boolean[] $jacocoInit = $jacocoInit();
            try {
                $jacocoInit[0] = true;
                $SwitchMap$com$trello$rxlifecycle$android$ActivityEvent[C12542a.CREATE.ordinal()] = 1;
                $jacocoInit[1] = true;
            } catch (NoSuchFieldError e) {
                try {
                    $jacocoInit[2] = true;
                } catch (NoSuchFieldError e2) {
                    try {
                        $jacocoInit[4] = true;
                    } catch (NoSuchFieldError e3) {
                        try {
                            $jacocoInit[6] = true;
                        } catch (NoSuchFieldError e4) {
                            try {
                                $jacocoInit[8] = true;
                            } catch (NoSuchFieldError e5) {
                                try {
                                    $jacocoInit[10] = true;
                                } catch (NoSuchFieldError e6) {
                                    $jacocoInit[12] = true;
                                }
                            }
                        }
                    }
                }
            }
            $SwitchMap$com$trello$rxlifecycle$android$ActivityEvent[C12542a.START.ordinal()] = 2;
            $jacocoInit[3] = true;
            $SwitchMap$com$trello$rxlifecycle$android$ActivityEvent[C12542a.RESUME.ordinal()] = 3;
            $jacocoInit[5] = true;
            $SwitchMap$com$trello$rxlifecycle$android$ActivityEvent[C12542a.PAUSE.ordinal()] = 4;
            $jacocoInit[7] = true;
            $SwitchMap$com$trello$rxlifecycle$android$ActivityEvent[C12542a.STOP.ordinal()] = 5;
            $jacocoInit[9] = true;
            $SwitchMap$com$trello$rxlifecycle$android$ActivityEvent[C12542a.DESTROY.ordinal()] = 6;
            $jacocoInit[11] = true;
            $jacocoInit[13] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3798586211030810205L, "cm/aptoide/pt/view/ActivityView", 12);
        $jacocoData = probes;
        return probes;
    }

    public ActivityView() {
        $jacocoInit()[0] = true;
    }

    public final <T> C0096f<T> bindUntilEvent(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        C0096f<T> a = C0097g.m559a(getLifecycleEvent(), lifecycleEvent);
        $jacocoInit[1] = true;
        return a;
    }

    /* renamed from: a */
    public /* synthetic */ LifecycleEvent mo2453a(C12542a event) {
        boolean[] $jacocoInit = $jacocoInit();
        LifecycleEvent convertToEvent = convertToEvent(event);
        $jacocoInit[11] = true;
        return convertToEvent;
    }

    public C0120S<LifecycleEvent> getLifecycleEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<LifecycleEvent> j = lifecycle().mo3669j(new C5310b(this));
        $jacocoInit[2] = true;
        return j;
    }

    public void attachPresenter(Presenter presenter) {
        boolean[] $jacocoInit = $jacocoInit();
        presenter.present();
        $jacocoInit[3] = true;
    }

    private LifecycleEvent convertToEvent(C12542a event) {
        boolean[] $jacocoInit = $jacocoInit();
        switch (C00701.$SwitchMap$com$trello$rxlifecycle$android$ActivityEvent[event.ordinal()]) {
            case 1:
                LifecycleEvent lifecycleEvent = LifecycleEvent.CREATE;
                $jacocoInit[4] = true;
                return lifecycleEvent;
            case 2:
                LifecycleEvent lifecycleEvent2 = LifecycleEvent.START;
                $jacocoInit[5] = true;
                return lifecycleEvent2;
            case 3:
                LifecycleEvent lifecycleEvent3 = LifecycleEvent.RESUME;
                $jacocoInit[6] = true;
                return lifecycleEvent3;
            case 4:
                LifecycleEvent lifecycleEvent4 = LifecycleEvent.PAUSE;
                $jacocoInit[7] = true;
                return lifecycleEvent4;
            case 5:
                LifecycleEvent lifecycleEvent5 = LifecycleEvent.STOP;
                $jacocoInit[8] = true;
                return lifecycleEvent5;
            case 6:
                LifecycleEvent lifecycleEvent6 = LifecycleEvent.DESTROY;
                $jacocoInit[9] = true;
                return lifecycleEvent6;
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("Unrecognized event: ");
                sb.append(event.name());
                IllegalStateException illegalStateException = new IllegalStateException(sb.toString());
                $jacocoInit[10] = true;
                throw illegalStateException;
        }
    }
}
