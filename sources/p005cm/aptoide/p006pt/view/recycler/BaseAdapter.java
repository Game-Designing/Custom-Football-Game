package p005cm.aptoide.p006pt.view.recycler;

import android.os.Bundle;
import android.support.p001v7.widget.RecyclerView.C0970a;
import android.support.p001v7.widget.RecyclerView.C1000w;
import android.view.ViewGroup;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.utils.AptoideUtils.ThreadU;
import p005cm.aptoide.p006pt.view.LifecycleSchim;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayables;
import p005cm.aptoide.p006pt.view.recycler.widget.Widget;
import p005cm.aptoide.p006pt.view.recycler.widget.WidgetFactory;

/* renamed from: cm.aptoide.pt.view.recycler.BaseAdapter */
public class BaseAdapter extends C0970a<Widget> implements LifecycleSchim {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Displayables displayables;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6847185061591268660L, "cm/aptoide/pt/view/recycler/BaseAdapter", 49);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void onBindViewHolder(C1000w wVar, int i) {
        boolean[] $jacocoInit = $jacocoInit();
        onBindViewHolder((Widget) wVar, i);
        $jacocoInit[33] = true;
    }

    public /* bridge */ /* synthetic */ void onViewRecycled(C1000w wVar) {
        boolean[] $jacocoInit = $jacocoInit();
        onViewRecycled((Widget) wVar);
        $jacocoInit[32] = true;
    }

    public BaseAdapter(List<Displayable> displayables2) {
        boolean[] $jacocoInit = $jacocoInit();
        this();
        $jacocoInit[0] = true;
        this.displayables.add(displayables2);
        $jacocoInit[1] = true;
    }

    public BaseAdapter() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[2] = true;
        this.displayables = new Displayables();
        $jacocoInit[3] = true;
    }

    public Widget onCreateViewHolder(ViewGroup parent, int viewType) {
        boolean[] $jacocoInit = $jacocoInit();
        Widget newBaseViewHolder = WidgetFactory.newBaseViewHolder(parent, viewType);
        $jacocoInit[4] = true;
        return newBaseViewHolder;
    }

    public void onBindViewHolder(Widget holder, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        holder.internalBindView(this.displayables.get(Integer.valueOf(position)), position);
        $jacocoInit[5] = true;
    }

    public int getItemViewType(int position) {
        boolean[] $jacocoInit = $jacocoInit();
        Displayable displayable = this.displayables.get(Integer.valueOf(position));
        $jacocoInit[6] = true;
        int viewLayout = displayable.getViewLayout();
        $jacocoInit[7] = true;
        return viewLayout;
    }

    public long getItemId(int position) {
        long j = (long) position;
        $jacocoInit()[8] = true;
        return j;
    }

    public int getItemCount() {
        boolean[] $jacocoInit = $jacocoInit();
        int size = this.displayables.size();
        $jacocoInit[9] = true;
        return size;
    }

    public void onViewRecycled(Widget holder) {
        boolean[] $jacocoInit = $jacocoInit();
        holder.unbindView();
        $jacocoInit[10] = true;
        super.onViewRecycled(holder);
        $jacocoInit[11] = true;
    }

    public Displayable popDisplayable() {
        boolean[] $jacocoInit = $jacocoInit();
        Displayable pop = this.displayables.pop();
        $jacocoInit[12] = true;
        notifyItemRemoved(this.displayables.size());
        $jacocoInit[13] = true;
        return pop;
    }

    public Displayable getDisplayable(int position) {
        boolean[] $jacocoInit = $jacocoInit();
        Displayable displayable = this.displayables.get(Integer.valueOf(position));
        $jacocoInit[14] = true;
        return displayable;
    }

    public void addDisplayable(int position, Displayable displayable) {
        boolean[] $jacocoInit = $jacocoInit();
        ThreadU.runOnUiThread(new C5361b(this, position, displayable));
        $jacocoInit[15] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo17261a(int position, Displayable displayable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.displayables.add(position, displayable);
        $jacocoInit[47] = true;
        notifyDataSetChanged();
        $jacocoInit[48] = true;
    }

    public void addDisplayable(Displayable displayable) {
        boolean[] $jacocoInit = $jacocoInit();
        ThreadU.runOnUiThread(new C5371g(this, displayable));
        $jacocoInit[16] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo17263a(Displayable displayable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.displayables.add(displayable);
        $jacocoInit[45] = true;
        notifyItemInserted(this.displayables.size() - 1);
        $jacocoInit[46] = true;
    }

    public void addDisplayables(List<? extends Displayable> displayables2) {
        boolean[] $jacocoInit = $jacocoInit();
        ThreadU.runOnUiThread(new C5369e(this, displayables2));
        $jacocoInit[17] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo17264a(List displayables2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.displayables.add(displayables2);
        $jacocoInit[43] = true;
        notifyDataSetChanged();
        $jacocoInit[44] = true;
    }

    public void addDisplayables(int position, List<? extends Displayable> displayables2) {
        boolean[] $jacocoInit = $jacocoInit();
        ThreadU.runOnUiThread(new C5362c(this, position, displayables2));
        $jacocoInit[18] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo17262a(int position, List displayables2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.displayables.add(position, displayables2);
        $jacocoInit[41] = true;
        notifyItemRangeInserted(position, displayables2.size());
        $jacocoInit[42] = true;
    }

    public void removeDisplayables(int startPosition, int endPosition) {
        boolean[] $jacocoInit = $jacocoInit();
        ThreadU.runOnUiThread(new C5363d(this, startPosition, endPosition));
        $jacocoInit[19] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo17260a(int startPosition, int endPosition) {
        boolean[] $jacocoInit = $jacocoInit();
        int numberRemovedItems = this.displayables.remove(startPosition, endPosition);
        $jacocoInit[39] = true;
        notifyItemRangeRemoved(startPosition, numberRemovedItems);
        $jacocoInit[40] = true;
    }

    public void removeDisplayable(int position) {
        boolean[] $jacocoInit = $jacocoInit();
        ThreadU.runOnUiThread(new C5360a(this, position));
        $jacocoInit[20] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo17259a(int position) {
        boolean[] $jacocoInit = $jacocoInit();
        this.displayables.remove(position);
        $jacocoInit[37] = true;
        notifyItemRemoved(position);
        $jacocoInit[38] = true;
    }

    public void clearDisplayables() {
        boolean[] $jacocoInit = $jacocoInit();
        ThreadU.runOnUiThread(new C5370f(this));
        $jacocoInit[21] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo17258a() {
        boolean[] $jacocoInit = $jacocoInit();
        this.displayables.clear();
        $jacocoInit[35] = true;
        notifyDataSetChanged();
        $jacocoInit[36] = true;
    }

    public void onResume() {
        boolean[] $jacocoInit = $jacocoInit();
        this.displayables.onResume();
        $jacocoInit[22] = true;
    }

    public void onPause() {
        boolean[] $jacocoInit = $jacocoInit();
        this.displayables.onPause();
        $jacocoInit[23] = true;
    }

    public void onViewCreated() {
        boolean[] $jacocoInit = $jacocoInit();
        this.displayables.onViewCreated();
        $jacocoInit[24] = true;
    }

    public void onDestroyView() {
        boolean[] $jacocoInit = $jacocoInit();
        this.displayables.onDestroyView();
        $jacocoInit[25] = true;
    }

    public void onSaveInstanceState(Bundle outState) {
        boolean[] $jacocoInit = $jacocoInit();
        this.displayables.onSaveInstanceState(outState);
        $jacocoInit[26] = true;
    }

    public void onViewStateRestored(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        this.displayables.onViewStateRestored(savedInstanceState);
        $jacocoInit[27] = true;
    }

    public void removeDisplayable(Displayable displayable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.displayables.remove(displayable);
        $jacocoInit[28] = true;
        notifyItemRemoved(this.displayables.getPosition(displayable));
        $jacocoInit[29] = true;
    }

    public void addDisplayableWithAnimation(int position, Displayable displayable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.displayables.add(position, displayable);
        $jacocoInit[30] = true;
        notifyItemInserted(position);
        $jacocoInit[31] = true;
    }
}
