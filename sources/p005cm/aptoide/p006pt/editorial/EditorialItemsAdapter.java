package p005cm.aptoide.p006pt.editorial;

import android.support.p001v7.widget.RecyclerView.C0970a;
import android.support.p001v7.widget.RecyclerView.C1000w;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import java.text.DecimalFormat;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.editorial.EditorialItemsAdapter */
class EditorialItemsAdapter extends C0970a<EditorialItemsViewHolder> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final C14963c<EditorialDownloadEvent> downloadEventListener;
    private List<EditorialContent> editorialItemList;
    private final DecimalFormat oneDecimalFormat;
    private boolean shouldHaveAnimation = true;
    private C14963c<EditorialEvent> uiEventListener;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3179865714298920859L, "cm/aptoide/pt/editorial/EditorialItemsAdapter", 11);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void onBindViewHolder(C1000w wVar, int i) {
        boolean[] $jacocoInit = $jacocoInit();
        onBindViewHolder((EditorialItemsViewHolder) wVar, i);
        $jacocoInit[9] = true;
    }

    public EditorialItemsAdapter(List<EditorialContent> editorialItemList2, DecimalFormat oneDecimalFormat2, C14963c<EditorialEvent> uiEventListener2, C14963c<EditorialDownloadEvent> downloadEventListener2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.editorialItemList = editorialItemList2;
        this.oneDecimalFormat = oneDecimalFormat2;
        this.uiEventListener = uiEventListener2;
        this.downloadEventListener = downloadEventListener2;
        $jacocoInit[0] = true;
    }

    public EditorialItemsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        boolean[] $jacocoInit = $jacocoInit();
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        $jacocoInit[1] = true;
        EditorialItemsViewHolder editorialItemsViewHolder = new EditorialItemsViewHolder(from.inflate(C1375R.layout.editorial_item_layout, parent, false), this.oneDecimalFormat, this.uiEventListener, this.downloadEventListener);
        $jacocoInit[2] = true;
        return editorialItemsViewHolder;
    }

    public void onBindViewHolder(EditorialItemsViewHolder editorialItemsViewHolder, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        EditorialContent editorialContent = (EditorialContent) this.editorialItemList.get(position);
        boolean z = this.shouldHaveAnimation;
        $jacocoInit[3] = true;
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[4] = true;
        editorialItemsViewHolder.setVisibility(editorialContent, position, valueOf);
        $jacocoInit[5] = true;
    }

    public int getItemCount() {
        boolean[] $jacocoInit = $jacocoInit();
        int size = this.editorialItemList.size();
        $jacocoInit[6] = true;
        return size;
    }

    public void add(List<EditorialContent> editorialItemList2, boolean shouldHaveAnimation2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.editorialItemList.addAll(editorialItemList2);
        this.shouldHaveAnimation = shouldHaveAnimation2;
        $jacocoInit[7] = true;
        notifyDataSetChanged();
        $jacocoInit[8] = true;
    }
}
