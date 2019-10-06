package p005cm.aptoide.p006pt.editorial;

import android.support.p001v7.widget.RecyclerView.C1000w;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.editorial.EditorialEvent.Type;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.editorial.MediaViewHolder */
class MediaViewHolder extends C1000w {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private TextView description;
    private ImageView image;
    private C14963c<EditorialEvent> uiEventListener;
    private ImageView videoThumbnail;
    private FrameLayout videoThumbnailContainer;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7762000501689049141L, "cm/aptoide/pt/editorial/MediaViewHolder", 23);
        $jacocoData = probes;
        return probes;
    }

    public MediaViewHolder(View view, C14963c<EditorialEvent> uiEventListener2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(view);
        this.uiEventListener = uiEventListener2;
        $jacocoInit[0] = true;
        this.image = (ImageView) view.findViewById(C1375R.C1376id.image_item);
        $jacocoInit[1] = true;
        this.videoThumbnail = (ImageView) view.findViewById(C1375R.C1376id.editorial_video_thumbnail);
        $jacocoInit[2] = true;
        this.videoThumbnailContainer = (FrameLayout) view.findViewById(C1375R.C1376id.editorial_video_thumbnail_container);
        $jacocoInit[3] = true;
        this.description = (TextView) view.findViewById(C1375R.C1376id.editorial_image_description);
        $jacocoInit[4] = true;
    }

    public void setVisibility(EditorialMedia editorialMedia) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!editorialMedia.hasUrl()) {
            $jacocoInit[5] = true;
        } else {
            $jacocoInit[6] = true;
            if (editorialMedia.isVideo()) {
                $jacocoInit[7] = true;
                if (editorialMedia.getThumbnail() == null) {
                    $jacocoInit[8] = true;
                } else {
                    $jacocoInit[9] = true;
                    ImageLoader with = ImageLoader.with(this.itemView.getContext());
                    $jacocoInit[10] = true;
                    with.load(editorialMedia.getThumbnail(), this.videoThumbnail);
                    $jacocoInit[11] = true;
                }
                this.videoThumbnailContainer.setVisibility(0);
                $jacocoInit[12] = true;
                this.videoThumbnailContainer.setOnClickListener(new C3198oc(this, editorialMedia));
                $jacocoInit[13] = true;
            } else {
                ImageLoader with2 = ImageLoader.with(this.itemView.getContext());
                $jacocoInit[14] = true;
                with2.load(editorialMedia.getUrl(), this.image);
                $jacocoInit[15] = true;
                this.image.setVisibility(0);
                $jacocoInit[16] = true;
            }
            this.description.setText(editorialMedia.getDescription());
            $jacocoInit[17] = true;
        }
        $jacocoInit[18] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14015a(EditorialMedia editorialMedia, View v) {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<EditorialEvent> cVar = this.uiEventListener;
        Type type = Type.MEDIA;
        $jacocoInit[20] = true;
        EditorialEvent editorialEvent = new EditorialEvent(type, editorialMedia.getUrl());
        $jacocoInit[21] = true;
        cVar.onNext(editorialEvent);
        $jacocoInit[22] = true;
    }

    public void setDescriptionVisible() {
        boolean[] $jacocoInit = $jacocoInit();
        this.description.setVisibility(0);
        $jacocoInit[19] = true;
    }
}
