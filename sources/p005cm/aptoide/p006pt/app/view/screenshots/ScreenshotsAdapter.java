package p005cm.aptoide.p006pt.app.view.screenshots;

import android.support.p001v7.widget.RecyclerView.C0970a;
import android.support.p001v7.widget.RecyclerView.C1000w;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.view.app.AppScreenshot;
import p005cm.aptoide.p006pt.view.app.AppVideo;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.app.view.screenshots.ScreenshotsAdapter */
public class ScreenshotsAdapter extends C0970a<ScreenshotViewHolder> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private ArrayList<String> imageUris;
    private C14963c<ScreenShotClickEvent> screenShotClick;
    private List<AppScreenshot> screenshots;
    private List<AppVideo> videos;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5533716553078898808L, "cm/aptoide/pt/app/view/screenshots/ScreenshotsAdapter", 38);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void onBindViewHolder(C1000w wVar, int i) {
        boolean[] $jacocoInit = $jacocoInit();
        onBindViewHolder((ScreenshotViewHolder) wVar, i);
        $jacocoInit[36] = true;
    }

    public ScreenshotsAdapter(List<AppScreenshot> screenshots2, List<AppVideo> videos2, C14963c<ScreenShotClickEvent> screenShotClick2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.screenshots = screenshots2;
        this.videos = videos2;
        this.screenShotClick = screenShotClick2;
        $jacocoInit[0] = true;
    }

    public ScreenshotViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        boolean[] $jacocoInit = $jacocoInit();
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        $jacocoInit[1] = true;
        View view = from.inflate(C1375R.layout.row_item_screenshots_gallery, viewGroup, false);
        $jacocoInit[2] = true;
        ScreenshotViewHolder screenshotViewHolder = new ScreenshotViewHolder(view, this.screenShotClick);
        $jacocoInit[3] = true;
        return screenshotViewHolder;
    }

    public void onBindViewHolder(ScreenshotViewHolder holder, int position) {
        int i;
        boolean[] $jacocoInit = $jacocoInit();
        if (isVideo(position)) {
            $jacocoInit[4] = true;
            holder.bindView((AppVideo) this.videos.get(position));
            $jacocoInit[5] = true;
            return;
        }
        List<AppVideo> list = this.videos;
        if (list != null) {
            i = list.size();
            $jacocoInit[6] = true;
        } else {
            i = 0;
            $jacocoInit[7] = true;
        }
        int position2 = position - i;
        $jacocoInit[8] = true;
        if (!isScreenShot(position2)) {
            $jacocoInit[9] = true;
        } else {
            $jacocoInit[10] = true;
            holder.bindView((AppScreenshot) this.screenshots.get(position2), position2, this.imageUris);
            $jacocoInit[11] = true;
        }
        $jacocoInit[12] = true;
    }

    public int getItemCount() {
        int i;
        boolean[] $jacocoInit = $jacocoInit();
        List<AppVideo> list = this.videos;
        int i2 = 0;
        if (list != null) {
            i = list.size();
            $jacocoInit[13] = true;
        } else {
            $jacocoInit[14] = true;
            i = 0;
        }
        List<AppScreenshot> list2 = this.screenshots;
        if (list2 != null) {
            i2 = list2.size();
            $jacocoInit[15] = true;
        } else {
            $jacocoInit[16] = true;
        }
        int i3 = i + i2;
        $jacocoInit[17] = true;
        return i3;
    }

    public void updateScreenshots(List<AppScreenshot> screenshots2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.screenshots = screenshots2;
        $jacocoInit[18] = true;
        this.imageUris = new ArrayList<>(screenshots2.size());
        $jacocoInit[19] = true;
        $jacocoInit[20] = true;
        for (AppScreenshot screenshot : screenshots2) {
            $jacocoInit[21] = true;
            this.imageUris.add(screenshot.getUrl());
            $jacocoInit[22] = true;
        }
        notifyDataSetChanged();
        $jacocoInit[23] = true;
    }

    public void updateVideos(List<AppVideo> videos2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.videos = videos2;
        $jacocoInit[24] = true;
        notifyDataSetChanged();
        $jacocoInit[25] = true;
    }

    private boolean isScreenShot(int position) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        List<AppScreenshot> list = this.screenshots;
        if (list == null) {
            $jacocoInit[26] = true;
        } else if (position >= list.size()) {
            $jacocoInit[27] = true;
        } else {
            $jacocoInit[28] = true;
            z = true;
            $jacocoInit[30] = true;
            return z;
        }
        z = false;
        $jacocoInit[29] = true;
        $jacocoInit[30] = true;
        return z;
    }

    private boolean isVideo(int position) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        List<AppVideo> list = this.videos;
        if (list == null) {
            $jacocoInit[31] = true;
        } else if (position >= list.size()) {
            $jacocoInit[32] = true;
        } else {
            $jacocoInit[33] = true;
            z = true;
            $jacocoInit[35] = true;
            return z;
        }
        z = false;
        $jacocoInit[34] = true;
        $jacocoInit[35] = true;
        return z;
    }
}
