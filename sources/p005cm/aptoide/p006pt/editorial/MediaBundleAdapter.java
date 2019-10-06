package p005cm.aptoide.p006pt.editorial;

import android.support.p001v7.widget.RecyclerView.C0970a;
import android.support.p001v7.widget.RecyclerView.C1000w;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.editorial.MediaBundleAdapter */
class MediaBundleAdapter extends C0970a<MediaViewHolder> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private List<EditorialMedia> media;
    private C14963c<EditorialEvent> uiEventListener;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-285040863362293984L, "cm/aptoide/pt/editorial/MediaBundleAdapter", 9);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void onBindViewHolder(C1000w wVar, int i) {
        boolean[] $jacocoInit = $jacocoInit();
        onBindViewHolder((MediaViewHolder) wVar, i);
        $jacocoInit[7] = true;
    }

    public MediaBundleAdapter(List<EditorialMedia> media2, C14963c<EditorialEvent> uiEventListener2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.media = media2;
        this.uiEventListener = uiEventListener2;
        $jacocoInit[0] = true;
    }

    public MediaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        boolean[] $jacocoInit = $jacocoInit();
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        $jacocoInit[1] = true;
        MediaViewHolder mediaViewHolder = new MediaViewHolder(from.inflate(C1375R.layout.media_layout, parent, false), this.uiEventListener);
        $jacocoInit[2] = true;
        return mediaViewHolder;
    }

    public void onBindViewHolder(MediaViewHolder mediaViewHolder, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        mediaViewHolder.setVisibility((EditorialMedia) this.media.get(position));
        $jacocoInit[3] = true;
    }

    public int getItemCount() {
        boolean[] $jacocoInit = $jacocoInit();
        int size = this.media.size();
        $jacocoInit[4] = true;
        return size;
    }

    public void add(List<EditorialMedia> media2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.media.addAll(media2);
        $jacocoInit[5] = true;
        notifyDataSetChanged();
        $jacocoInit[6] = true;
    }
}
