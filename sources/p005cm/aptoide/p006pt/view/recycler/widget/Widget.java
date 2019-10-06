package p005cm.aptoide.p006pt.view.recycler.widget;

import android.support.p000v4.app.C0014p;
import android.support.p000v4.app.Fragment;
import android.support.p001v7.widget.RecyclerView.C1000w;
import android.view.View;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.navigator.ActivityNavigator;
import p005cm.aptoide.p006pt.navigator.ActivityResultNavigator;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p026rx.p029i.C0136c;

/* renamed from: cm.aptoide.pt.view.recycler.widget.Widget */
public abstract class Widget<T extends Displayable> extends C1000w {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private ActivityNavigator activityNavigator;
    protected C0136c compositeSubscription;
    private final FragmentNavigator fragmentNavigator = ((ActivityResultNavigator) getContext()).getFragmentNavigator();

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5139867575369412338L, "cm/aptoide/pt/view/recycler/widget/Widget", 23);
        $jacocoData = probes;
        return probes;
    }

    /* access modifiers changed from: protected */
    public abstract void assignViews(View view);

    public abstract void bindView(T t, int i);

    public Widget(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        $jacocoInit[0] = true;
        $jacocoInit[1] = true;
        this.activityNavigator = ((ActivityResultNavigator) getContext()).getActivityNavigator();
        try {
            $jacocoInit[2] = true;
            assignViews(itemView);
            $jacocoInit[3] = true;
        } catch (Exception e) {
            $jacocoInit[4] = true;
            CrashReport instance = CrashReport.getInstance();
            $jacocoInit[5] = true;
            instance.log(e);
            $jacocoInit[6] = true;
        }
        $jacocoInit[7] = true;
    }

    public C0014p getContext() {
        C0014p pVar = (C0014p) this.itemView.getContext();
        $jacocoInit()[8] = true;
        return pVar;
    }

    public void unbindView() {
        boolean[] $jacocoInit = $jacocoInit();
        C0136c cVar = this.compositeSubscription;
        if (cVar == null) {
            $jacocoInit[9] = true;
        } else if (cVar.isUnsubscribed()) {
            $jacocoInit[10] = true;
        } else {
            $jacocoInit[11] = true;
            this.compositeSubscription.mo3712a();
            $jacocoInit[12] = true;
        }
        $jacocoInit[13] = true;
    }

    public void internalBindView(T displayable, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.compositeSubscription != null) {
            $jacocoInit[14] = true;
        } else {
            $jacocoInit[15] = true;
            this.compositeSubscription = new C0136c();
            $jacocoInit[16] = true;
        }
        displayable.setVisible(true);
        $jacocoInit[17] = true;
        bindView(displayable, position);
        $jacocoInit[18] = true;
    }

    public View getRootView() {
        boolean[] $jacocoInit = $jacocoInit();
        Fragment peekLast = getFragmentNavigator().peekLast();
        $jacocoInit[19] = true;
        View view = peekLast.getView();
        $jacocoInit[20] = true;
        return view;
    }

    /* access modifiers changed from: protected */
    public FragmentNavigator getFragmentNavigator() {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentNavigator fragmentNavigator2 = this.fragmentNavigator;
        $jacocoInit[21] = true;
        return fragmentNavigator2;
    }

    /* access modifiers changed from: protected */
    public ActivityNavigator getActivityNavigator() {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityNavigator activityNavigator2 = this.activityNavigator;
        $jacocoInit[22] = true;
        return activityNavigator2;
    }
}
