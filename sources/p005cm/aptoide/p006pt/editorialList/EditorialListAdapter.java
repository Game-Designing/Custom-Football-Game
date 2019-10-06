package p005cm.aptoide.p006pt.editorialList;

import android.support.p001v7.widget.RecyclerView.C0970a;
import android.support.p001v7.widget.RecyclerView.C1000w;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.editorial.CaptionBackgroundPainter;
import p005cm.aptoide.p006pt.home.EditorialBundleViewHolder;
import p005cm.aptoide.p006pt.home.HomeEvent;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.editorialList.EditorialListAdapter */
class EditorialListAdapter extends C0970a<EditorialBundleViewHolder> {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final int EDITORIAL_CARD = 2131427467;
    private static final int LOADING = 2131427593;
    private final CaptionBackgroundPainter captionBackgroundPainter;
    private List<CurationCard> editorialListItems;
    private final ProgressCard progressBundle;
    private final C14963c<HomeEvent> uiEventsListener;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4954858017797487131L, "cm/aptoide/pt/editorialList/EditorialListAdapter", 46);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void onBindViewHolder(C1000w wVar, int i) {
        boolean[] $jacocoInit = $jacocoInit();
        onBindViewHolder((EditorialBundleViewHolder) wVar, i);
        $jacocoInit[44] = true;
    }

    public EditorialListAdapter(List<CurationCard> editorialListItems2, ProgressCard progressBundle2, C14963c<HomeEvent> uiEventsListener2, CaptionBackgroundPainter captionBackgroundPainter2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.editorialListItems = editorialListItems2;
        this.progressBundle = progressBundle2;
        this.uiEventsListener = uiEventsListener2;
        this.captionBackgroundPainter = captionBackgroundPainter2;
        $jacocoInit[0] = true;
    }

    public EditorialBundleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        boolean[] $jacocoInit = $jacocoInit();
        if (viewType == C1375R.layout.editorial_action_item) {
            $jacocoInit[1] = true;
            LayoutInflater from = LayoutInflater.from(parent.getContext());
            $jacocoInit[2] = true;
            EditorialBundleViewHolder editorialBundleViewHolder = new EditorialBundleViewHolder(from.inflate(C1375R.layout.editorial_action_item, parent, false), this.uiEventsListener, this.captionBackgroundPainter);
            $jacocoInit[3] = true;
            return editorialBundleViewHolder;
        }
        LayoutInflater from2 = LayoutInflater.from(parent.getContext());
        $jacocoInit[4] = true;
        LoadingViewHolder loadingViewHolder = new LoadingViewHolder(from2.inflate(C1375R.layout.progress_item, parent, false), this.uiEventsListener, this.captionBackgroundPainter);
        $jacocoInit[5] = true;
        return loadingViewHolder;
    }

    public void onBindViewHolder(EditorialBundleViewHolder editorialsViewHolder, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        if (editorialsViewHolder instanceof LoadingViewHolder) {
            $jacocoInit[6] = true;
        } else {
            $jacocoInit[7] = true;
            editorialsViewHolder.setEditorialCard((CurationCard) this.editorialListItems.get(position), position);
            $jacocoInit[8] = true;
        }
        $jacocoInit[9] = true;
    }

    public int getItemViewType(int position) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.editorialListItems.get(position) instanceof ProgressCard) {
            $jacocoInit[10] = true;
            return C1375R.layout.progress_item;
        }
        $jacocoInit[11] = true;
        return C1375R.layout.editorial_action_item;
    }

    public int getItemCount() {
        boolean[] $jacocoInit = $jacocoInit();
        int size = this.editorialListItems.size();
        $jacocoInit[12] = true;
        return size;
    }

    public void add(List<CurationCard> editorialItemList) {
        boolean[] $jacocoInit = $jacocoInit();
        this.editorialListItems.addAll(editorialItemList);
        $jacocoInit[13] = true;
        notifyDataSetChanged();
        $jacocoInit[14] = true;
    }

    public void addLoadMore() {
        boolean[] $jacocoInit = $jacocoInit();
        if (getLoadingPosition() >= 0) {
            $jacocoInit[15] = true;
        } else {
            $jacocoInit[16] = true;
            this.editorialListItems.add(this.progressBundle);
            $jacocoInit[17] = true;
            notifyItemInserted(this.editorialListItems.size() - 1);
            $jacocoInit[18] = true;
        }
        $jacocoInit[19] = true;
    }

    public void removeLoadMore() {
        boolean[] $jacocoInit = $jacocoInit();
        int loadingPosition = getLoadingPosition();
        if (loadingPosition < 0) {
            $jacocoInit[20] = true;
        } else {
            $jacocoInit[21] = true;
            this.editorialListItems.remove(loadingPosition);
            $jacocoInit[22] = true;
            notifyItemRemoved(loadingPosition);
            $jacocoInit[23] = true;
        }
        $jacocoInit[24] = true;
    }

    public synchronized int getLoadingPosition() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.editorialListItems.size() - 1;
        $jacocoInit[25] = true;
        while (i >= 0) {
            $jacocoInit[26] = true;
            if (((CurationCard) this.editorialListItems.get(i)) instanceof ProgressCard) {
                $jacocoInit[27] = true;
                return i;
            }
            i--;
            $jacocoInit[28] = true;
        }
        $jacocoInit[29] = true;
        return -1;
    }

    public void update(List<CurationCard> curationCards) {
        boolean[] $jacocoInit = $jacocoInit();
        this.editorialListItems = curationCards;
        $jacocoInit[30] = true;
        notifyDataSetChanged();
        $jacocoInit[31] = true;
    }

    public CurationCard getCard(int visibleItem) {
        CurationCard curationCard = (CurationCard) this.editorialListItems.get(visibleItem);
        $jacocoInit()[32] = true;
        return curationCard;
    }

    public void updateEditorialCard(CurationCard curationCard) {
        boolean[] $jacocoInit = $jacocoInit();
        int i = 0;
        $jacocoInit[33] = true;
        while (i < this.editorialListItems.size()) {
            $jacocoInit[34] = true;
            if (curationCard == null) {
                $jacocoInit[35] = true;
            } else {
                CurationCard curationCard2 = (CurationCard) this.editorialListItems.get(i);
                $jacocoInit[36] = true;
                String id = curationCard2.getId();
                $jacocoInit[37] = true;
                if (!id.equals(curationCard.getId())) {
                    $jacocoInit[38] = true;
                } else {
                    $jacocoInit[39] = true;
                    this.editorialListItems.set(i, curationCard);
                    $jacocoInit[40] = true;
                    notifyItemChanged(i);
                    $jacocoInit[41] = true;
                }
            }
            i++;
            $jacocoInit[42] = true;
        }
        $jacocoInit[43] = true;
    }
}
