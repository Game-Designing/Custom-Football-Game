package p005cm.aptoide.p006pt.view.recycler;

import android.content.Context;
import android.support.p001v7.widget.RecyclerView.C1000w;
import android.view.View;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p026rx.C0137ja;
import p026rx.p029i.C0136c;

/* renamed from: cm.aptoide.pt.view.recycler.RecyclerViewHolder */
public abstract class RecyclerViewHolder<T> extends C1000w {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private C0136c compositeSubscription = new C0136c();
    private Context context;
    private T viewModel;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-10008808305779864L, "cm/aptoide/pt/view/recycler/RecyclerViewHolder", 12);
        $jacocoData = probes;
        return probes;
    }

    public abstract int getViewResource();

    /* access modifiers changed from: protected */
    public abstract void update(Context context2, T t);

    protected RecyclerViewHolder(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        $jacocoInit[0] = true;
        $jacocoInit[1] = true;
        this.context = itemView.getContext();
        $jacocoInit[2] = true;
    }

    public final void updateViewModel(T viewModel2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.viewModel = viewModel2;
        $jacocoInit[3] = true;
        update(this.context, viewModel2);
        $jacocoInit[4] = true;
    }

    /* access modifiers changed from: protected */
    public T getViewModel() {
        boolean[] $jacocoInit = $jacocoInit();
        T t = this.viewModel;
        $jacocoInit[5] = true;
        return t;
    }

    /* access modifiers changed from: protected */
    public void addSubscription(C0137ja s) {
        boolean[] $jacocoInit = $jacocoInit();
        this.compositeSubscription.mo3713a(s);
        $jacocoInit[6] = true;
    }

    public final void releaseSubscriptions() {
        boolean[] $jacocoInit = $jacocoInit();
        if (!this.compositeSubscription.mo3715b()) {
            $jacocoInit[7] = true;
        } else if (this.compositeSubscription.isUnsubscribed()) {
            $jacocoInit[8] = true;
        } else {
            $jacocoInit[9] = true;
            this.compositeSubscription.unsubscribe();
            $jacocoInit[10] = true;
        }
        $jacocoInit[11] = true;
    }
}
