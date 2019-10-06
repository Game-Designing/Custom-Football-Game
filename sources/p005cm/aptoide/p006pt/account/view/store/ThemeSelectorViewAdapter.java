package p005cm.aptoide.p006pt.account.view.store;

import android.support.p001v7.widget.RecyclerView.C0970a;
import android.support.p001v7.widget.RecyclerView.C1000w;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.store.StoreTheme;
import p019d.p022i.p023b.C0100e;
import p019d.p022i.p296a.p305c.C13034a;
import p026rx.C0120S;
import p026rx.p027b.C0129b;

/* renamed from: cm.aptoide.pt.account.view.store.ThemeSelectorViewAdapter */
public class ThemeSelectorViewAdapter extends C0970a<ViewHolder> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private StoreTheme selectedStoreTheme;
    private final C0100e<StoreTheme> storeThemePublishRelay;
    private final List<StoreTheme> themes;

    /* renamed from: cm.aptoide.pt.account.view.store.ThemeSelectorViewAdapter$ViewHolder */
    public static final class ViewHolder extends C1000w {
        private static transient /* synthetic */ boolean[] $jacocoData = null;
        private static final int LAYOUT = 2131427567;
        private StoreTheme storeTheme;
        private ImageView storeThemeCheckMark;
        private ImageView storeThemeImage;
        private final C0100e<StoreTheme> storeThemePublishRelay;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(7258920840974825136L, "cm/aptoide/pt/account/view/store/ThemeSelectorViewAdapter$ViewHolder", 13);
            $jacocoData = probes;
            return probes;
        }

        public ViewHolder(View itemView, C0100e<StoreTheme> storeThemePublishRelay2) {
            boolean[] $jacocoInit = $jacocoInit();
            super(itemView);
            this.storeThemePublishRelay = storeThemePublishRelay2;
            $jacocoInit[0] = true;
            bind(itemView);
            $jacocoInit[1] = true;
        }

        private void bind(View view) {
            boolean[] $jacocoInit = $jacocoInit();
            this.storeThemeImage = (ImageView) view.findViewById(C1375R.C1376id.theme_color);
            $jacocoInit[2] = true;
            this.storeThemeCheckMark = (ImageView) view.findViewById(C1375R.C1376id.theme_checked);
            $jacocoInit[3] = true;
            C0120S a = C13034a.m42490a(view);
            C1522M m = new C1522M(this);
            $jacocoInit[4] = true;
            C0120S b = a.mo3636b((C0129b<? super T>) m);
            $jacocoInit[5] = true;
            b.mo3670j();
            $jacocoInit[6] = true;
        }

        /* renamed from: a */
        public /* synthetic */ void mo9863a(Void __) {
            boolean[] $jacocoInit = $jacocoInit();
            this.storeThemePublishRelay.call(this.storeTheme);
            $jacocoInit[12] = true;
        }

        public void update(StoreTheme storeTheme2, StoreTheme selectedStoreTheme) {
            boolean[] $jacocoInit = $jacocoInit();
            this.storeTheme = storeTheme2;
            $jacocoInit[7] = true;
            this.storeThemeImage.setBackgroundResource(storeTheme2.getRoundDrawable());
            if (storeTheme2 == selectedStoreTheme) {
                $jacocoInit[8] = true;
                this.storeThemeCheckMark.setVisibility(0);
                $jacocoInit[9] = true;
            } else {
                this.storeThemeCheckMark.setVisibility(8);
                $jacocoInit[10] = true;
            }
            $jacocoInit[11] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5204064219768601188L, "cm/aptoide/pt/account/view/store/ThemeSelectorViewAdapter", 15);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void onBindViewHolder(C1000w wVar, int i) {
        boolean[] $jacocoInit = $jacocoInit();
        onBindViewHolder((ViewHolder) wVar, i);
        $jacocoInit[12] = true;
    }

    public ThemeSelectorViewAdapter(C0100e<StoreTheme> storeThemePublishRelay2, List<StoreTheme> themes2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.storeThemePublishRelay = storeThemePublishRelay2;
        this.themes = themes2;
        $jacocoInit[0] = true;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        boolean[] $jacocoInit = $jacocoInit();
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        $jacocoInit[1] = true;
        View itemView = from.inflate(C1375R.layout.partial_store_theme_round_item, parent, false);
        $jacocoInit[2] = true;
        ViewHolder viewHolder = new ViewHolder(itemView, this.storeThemePublishRelay);
        $jacocoInit[3] = true;
        return viewHolder;
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        holder.update((StoreTheme) this.themes.get(position), this.selectedStoreTheme);
        $jacocoInit[4] = true;
    }

    public int getItemCount() {
        int i;
        boolean[] $jacocoInit = $jacocoInit();
        List<StoreTheme> list = this.themes;
        if (list != null) {
            i = list.size();
            $jacocoInit[5] = true;
        } else {
            i = 0;
            $jacocoInit[6] = true;
        }
        $jacocoInit[7] = true;
        return i;
    }

    public void selectTheme(StoreTheme selectedStoreTheme2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.selectedStoreTheme = selectedStoreTheme2;
        $jacocoInit[8] = true;
        notifyDataSetChanged();
        $jacocoInit[9] = true;
    }

    public StoreTheme getSelectedTheme() {
        boolean[] $jacocoInit = $jacocoInit();
        StoreTheme storeTheme = this.selectedStoreTheme;
        $jacocoInit[10] = true;
        return storeTheme;
    }

    /* renamed from: a */
    public /* synthetic */ void mo9858a(StoreTheme storeTheme) {
        boolean[] $jacocoInit = $jacocoInit();
        selectTheme(storeTheme);
        $jacocoInit[14] = true;
    }

    public C0120S<StoreTheme> storeThemeSelection() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<StoreTheme> b = this.storeThemePublishRelay.mo3636b((C0129b<? super T>) new C1521L<Object>(this));
        $jacocoInit[11] = true;
        return b;
    }
}
