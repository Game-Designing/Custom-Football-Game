package p005cm.aptoide.p006pt.view.fragment;

import com.trello.rxlifecycle.C0096f;
import com.trello.rxlifecycle.C0097g;
import com.trello.rxlifecycle.p263a.C12543b;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.presenter.Presenter;
import p005cm.aptoide.p006pt.presenter.View;
import p005cm.aptoide.p006pt.presenter.View.LifecycleEvent;
import p026rx.C0120S;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.view.fragment.BaseDialogView */
public class BaseDialogView extends BaseDialogFragment implements View {
    private static transient /* synthetic */ boolean[] $jacocoData;

    /* renamed from: cm.aptoide.pt.view.fragment.BaseDialogView$1 */
    static /* synthetic */ class C53421 {
        static final /* synthetic */ int[] $SwitchMap$com$trello$rxlifecycle$android$FragmentEvent = new int[C12543b.values().length];
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(6204933787545918896L, "cm/aptoide/pt/view/fragment/BaseDialogView$1", 22);
            $jacocoData = probes;
            return probes;
        }

        static {
            boolean[] $jacocoInit = $jacocoInit();
            try {
                $jacocoInit[0] = true;
                $SwitchMap$com$trello$rxlifecycle$android$FragmentEvent[C12543b.ATTACH.ordinal()] = 1;
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
                                    try {
                                        $jacocoInit[12] = true;
                                    } catch (NoSuchFieldError e7) {
                                        try {
                                            $jacocoInit[14] = true;
                                        } catch (NoSuchFieldError e8) {
                                            try {
                                                $jacocoInit[16] = true;
                                            } catch (NoSuchFieldError e9) {
                                                try {
                                                    $jacocoInit[18] = true;
                                                } catch (NoSuchFieldError e10) {
                                                    $jacocoInit[20] = true;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            $SwitchMap$com$trello$rxlifecycle$android$FragmentEvent[C12543b.CREATE.ordinal()] = 2;
            $jacocoInit[3] = true;
            $SwitchMap$com$trello$rxlifecycle$android$FragmentEvent[C12543b.CREATE_VIEW.ordinal()] = 3;
            $jacocoInit[5] = true;
            $SwitchMap$com$trello$rxlifecycle$android$FragmentEvent[C12543b.START.ordinal()] = 4;
            $jacocoInit[7] = true;
            $SwitchMap$com$trello$rxlifecycle$android$FragmentEvent[C12543b.RESUME.ordinal()] = 5;
            $jacocoInit[9] = true;
            $SwitchMap$com$trello$rxlifecycle$android$FragmentEvent[C12543b.PAUSE.ordinal()] = 6;
            $jacocoInit[11] = true;
            $SwitchMap$com$trello$rxlifecycle$android$FragmentEvent[C12543b.STOP.ordinal()] = 7;
            $jacocoInit[13] = true;
            $SwitchMap$com$trello$rxlifecycle$android$FragmentEvent[C12543b.DESTROY_VIEW.ordinal()] = 8;
            $jacocoInit[15] = true;
            $SwitchMap$com$trello$rxlifecycle$android$FragmentEvent[C12543b.DETACH.ordinal()] = 9;
            $jacocoInit[17] = true;
            $SwitchMap$com$trello$rxlifecycle$android$FragmentEvent[C12543b.DESTROY.ordinal()] = 10;
            $jacocoInit[19] = true;
            $jacocoInit[21] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4306495588043980131L, "cm/aptoide/pt/view/fragment/BaseDialogView", 14);
        $jacocoData = probes;
        return probes;
    }

    public BaseDialogView() {
        $jacocoInit()[0] = true;
    }

    public final <T> C0096f<T> bindUntilEvent(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        C0096f<T> a = C0097g.m559a(getLifecycleEvent(), lifecycleEvent);
        $jacocoInit[1] = true;
        return a;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo17222a(C12543b event) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S convertToEvent = convertToEvent(event);
        $jacocoInit[13] = true;
        return convertToEvent;
    }

    public C0120S<LifecycleEvent> getLifecycleEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<LifecycleEvent> f = lifecycle().mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C5345a<Object,Object>(this));
        $jacocoInit[2] = true;
        return f;
    }

    public void attachPresenter(Presenter presenter) {
        boolean[] $jacocoInit = $jacocoInit();
        presenter.present();
        $jacocoInit[3] = true;
    }

    private C0120S<LifecycleEvent> convertToEvent(C12543b event) {
        boolean[] $jacocoInit = $jacocoInit();
        switch (C53421.$SwitchMap$com$trello$rxlifecycle$android$FragmentEvent[event.ordinal()]) {
            case 1:
            case 2:
                C0120S<LifecycleEvent> c = C0120S.m651c();
                $jacocoInit[4] = true;
                return c;
            case 3:
                C0120S<LifecycleEvent> c2 = C0120S.m652c(LifecycleEvent.CREATE);
                $jacocoInit[5] = true;
                return c2;
            case 4:
                C0120S<LifecycleEvent> c3 = C0120S.m652c(LifecycleEvent.START);
                $jacocoInit[6] = true;
                return c3;
            case 5:
                C0120S<LifecycleEvent> c4 = C0120S.m652c(LifecycleEvent.RESUME);
                $jacocoInit[7] = true;
                return c4;
            case 6:
                C0120S<LifecycleEvent> c5 = C0120S.m652c(LifecycleEvent.PAUSE);
                $jacocoInit[8] = true;
                return c5;
            case 7:
                C0120S<LifecycleEvent> c6 = C0120S.m652c(LifecycleEvent.STOP);
                $jacocoInit[9] = true;
                return c6;
            case 8:
                C0120S<LifecycleEvent> c7 = C0120S.m652c(LifecycleEvent.DESTROY);
                $jacocoInit[10] = true;
                return c7;
            case 9:
            case 10:
                C0120S<LifecycleEvent> c8 = C0120S.m651c();
                $jacocoInit[11] = true;
                return c8;
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("Unrecognized event: ");
                sb.append(event.name());
                IllegalStateException illegalStateException = new IllegalStateException(sb.toString());
                $jacocoInit[12] = true;
                throw illegalStateException;
        }
    }
}
