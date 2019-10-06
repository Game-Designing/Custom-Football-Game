package p005cm.aptoide.p006pt.view.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.p000v4.app.C0486t;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import com.trello.rxlifecycle.C0096f;
import com.trello.rxlifecycle.C0097g;
import com.trello.rxlifecycle.p263a.C12543b;
import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.logger.Logger;
import p005cm.aptoide.p006pt.navigator.ActivityNavigator;
import p005cm.aptoide.p006pt.navigator.ActivityResultNavigator;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.navigator.FragmentResultNavigator;
import p005cm.aptoide.p006pt.presenter.Presenter;
import p005cm.aptoide.p006pt.presenter.View;
import p005cm.aptoide.p006pt.presenter.View.LifecycleEvent;
import p005cm.aptoide.p006pt.util.ScreenTrackingUtils;
import p005cm.aptoide.p006pt.view.BaseFragment;
import p026rx.C0120S;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.view.fragment.FragmentView */
public abstract class FragmentView extends BaseFragment implements View {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private static final String TAG = FragmentView.class.getName();
    private ActivityResultNavigator activityResultNavigator;
    private boolean startActivityForResultCalled;

    /* renamed from: cm.aptoide.pt.view.fragment.FragmentView$1 */
    static /* synthetic */ class C53431 {
        static final /* synthetic */ int[] $SwitchMap$com$trello$rxlifecycle$android$FragmentEvent = new int[C12543b.values().length];
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(8437584028407363595L, "cm/aptoide/pt/view/fragment/FragmentView$1", 22);
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
        boolean[] probes = Offline.getProbes(-3669337401195967886L, "cm/aptoide/pt/view/fragment/FragmentView", 57);
        $jacocoData = probes;
        return probes;
    }

    public FragmentView() {
        $jacocoInit()[0] = true;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[56] = true;
    }

    public FragmentNavigator getFragmentNavigator() {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentNavigator fragmentNavigator = this.activityResultNavigator.getFragmentNavigator();
        $jacocoInit[1] = true;
        return fragmentNavigator;
    }

    public ActivityNavigator getActivityNavigator() {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityNavigator activityNavigator = this.activityResultNavigator.getActivityNavigator();
        $jacocoInit[2] = true;
        return activityNavigator;
    }

    public FragmentNavigator getFragmentChildNavigator(int containerId) {
        boolean[] $jacocoInit = $jacocoInit();
        C0486t childFragmentManager = getChildFragmentManager();
        ActivityResultNavigator activityResultNavigator2 = this.activityResultNavigator;
        $jacocoInit[3] = true;
        Map fragmentResultMap = activityResultNavigator2.getFragmentResultMap();
        ActivityResultNavigator activityResultNavigator3 = this.activityResultNavigator;
        $jacocoInit[4] = true;
        FragmentResultNavigator fragmentResultNavigator = new FragmentResultNavigator(childFragmentManager, containerId, 17432576, 17432577, fragmentResultMap, activityResultNavigator3.getFragmentResultRelay());
        $jacocoInit[5] = true;
        return fragmentResultNavigator;
    }

    public void onAttach(Activity activity) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onAttach(activity);
        try {
            $jacocoInit[6] = true;
            this.activityResultNavigator = (ActivityResultNavigator) activity;
            $jacocoInit[7] = true;
        } catch (ClassCastException e) {
            $jacocoInit[8] = true;
            Logger instance = Logger.getInstance();
            String str = TAG;
            $jacocoInit[9] = true;
            Object[] objArr = {ActivityResultNavigator.class.getName()};
            $jacocoInit[10] = true;
            instance.mo2140e(str, String.format("Parent activity must implement %s interface", objArr));
            $jacocoInit[11] = true;
        }
        $jacocoInit[12] = true;
    }

    public void onDestroy() {
        boolean[] $jacocoInit = $jacocoInit();
        super.onDestroy();
        $jacocoInit[13] = true;
        ScreenTrackingUtils instance = ScreenTrackingUtils.getInstance();
        $jacocoInit[14] = true;
        instance.decrementNumberOfScreens();
        $jacocoInit[15] = true;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[16] = true;
        ScreenTrackingUtils instance = ScreenTrackingUtils.getInstance();
        $jacocoInit[17] = true;
        instance.incrementNumberOfScreens();
        $jacocoInit[18] = true;
    }

    public void setUserVisibleHint(boolean isVisibleToUser) {
        boolean[] $jacocoInit = $jacocoInit();
        super.setUserVisibleHint(isVisibleToUser);
        if (!isVisibleToUser) {
            $jacocoInit[19] = true;
        } else {
            $jacocoInit[20] = true;
            ScreenTrackingUtils instance = ScreenTrackingUtils.getInstance();
            $jacocoInit[21] = true;
            instance.addScreenToHistory(getClass().getSimpleName());
            $jacocoInit[22] = true;
        }
        $jacocoInit[23] = true;
    }

    public void startActivityForResult(Intent intent, int requestCode) {
        boolean[] $jacocoInit = $jacocoInit();
        this.startActivityForResultCalled = true;
        $jacocoInit[24] = true;
        super.startActivityForResult(intent, requestCode);
        $jacocoInit[25] = true;
    }

    public void startActivityForResult(Intent intent, int requestCode, Bundle options) {
        boolean[] $jacocoInit = $jacocoInit();
        this.startActivityForResultCalled = true;
        $jacocoInit[26] = true;
        super.startActivityForResult(intent, requestCode, options);
        $jacocoInit[27] = true;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreateOptionsMenu(menu, inflater);
        $jacocoInit[28] = true;
    }

    public void onPrepareOptionsMenu(Menu menu) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onPrepareOptionsMenu(menu);
        $jacocoInit[29] = true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        boolean[] $jacocoInit = $jacocoInit();
        if (item.getItemId() == 16908332) {
            $jacocoInit[30] = true;
            if (getFragmentNavigator().popBackStack()) {
                $jacocoInit[31] = true;
            } else {
                $jacocoInit[32] = true;
                getActivityNavigator().navigateBack();
                $jacocoInit[33] = true;
            }
            $jacocoInit[34] = true;
            return true;
        }
        boolean onOptionsItemSelected = super.onOptionsItemSelected(item);
        $jacocoInit[35] = true;
        return onOptionsItemSelected;
    }

    public final <T> C0096f<T> bindUntilEvent(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        C0096f<T> a = C0097g.m559a(getLifecycleEvent(), lifecycleEvent);
        $jacocoInit[36] = true;
        return a;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo17250a(C12543b event) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S convertToEvent = convertToEvent(event);
        $jacocoInit[55] = true;
        return convertToEvent;
    }

    public C0120S<LifecycleEvent> getLifecycleEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<LifecycleEvent> f = lifecycle().mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C5347c<Object,Object>(this));
        $jacocoInit[37] = true;
        return f;
    }

    public void attachPresenter(Presenter presenter) {
        boolean[] $jacocoInit = $jacocoInit();
        presenter.present();
        $jacocoInit[38] = true;
    }

    /* access modifiers changed from: protected */
    public void hideKeyboard() {
        boolean[] $jacocoInit = $jacocoInit();
        Activity activity = getActivity();
        $jacocoInit[39] = true;
        android.view.View view = activity.getCurrentFocus();
        if (view == null) {
            $jacocoInit[40] = true;
        } else {
            $jacocoInit[41] = true;
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
            $jacocoInit[42] = true;
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 2);
            $jacocoInit[43] = true;
        }
        $jacocoInit[44] = true;
    }

    private C0120S<LifecycleEvent> convertToEvent(C12543b event) {
        boolean[] $jacocoInit = $jacocoInit();
        switch (C53431.$SwitchMap$com$trello$rxlifecycle$android$FragmentEvent[event.ordinal()]) {
            case 1:
            case 2:
                C0120S<LifecycleEvent> c = C0120S.m651c();
                $jacocoInit[45] = true;
                return c;
            case 3:
                C0120S<LifecycleEvent> c2 = C0120S.m652c(LifecycleEvent.CREATE);
                $jacocoInit[46] = true;
                return c2;
            case 4:
                C0120S<LifecycleEvent> c3 = C0120S.m652c(LifecycleEvent.START);
                $jacocoInit[47] = true;
                return c3;
            case 5:
                C0120S<LifecycleEvent> c4 = C0120S.m652c(LifecycleEvent.RESUME);
                $jacocoInit[48] = true;
                return c4;
            case 6:
                C0120S<LifecycleEvent> c5 = C0120S.m652c(LifecycleEvent.PAUSE);
                $jacocoInit[49] = true;
                return c5;
            case 7:
                C0120S<LifecycleEvent> c6 = C0120S.m652c(LifecycleEvent.STOP);
                $jacocoInit[50] = true;
                return c6;
            case 8:
                C0120S<LifecycleEvent> c7 = C0120S.m652c(LifecycleEvent.DESTROY);
                $jacocoInit[51] = true;
                return c7;
            case 9:
            case 10:
                C0120S<LifecycleEvent> c8 = C0120S.m651c();
                $jacocoInit[52] = true;
                return c8;
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("Unrecognized event: ");
                sb.append(event.name());
                IllegalStateException illegalStateException = new IllegalStateException(sb.toString());
                $jacocoInit[53] = true;
                throw illegalStateException;
        }
    }

    public boolean isStartActivityForResultCalled() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.startActivityForResultCalled;
        $jacocoInit[54] = true;
        return z;
    }
}
