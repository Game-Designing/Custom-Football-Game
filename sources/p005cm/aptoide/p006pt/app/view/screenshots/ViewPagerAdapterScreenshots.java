package p005cm.aptoide.p006pt.app.view.screenshots;

import android.content.Context;
import android.content.res.Resources;
import android.support.p000v4.view.C0642s;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.ArrayList;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;

/* renamed from: cm.aptoide.pt.app.view.screenshots.ViewPagerAdapterScreenshots */
public class ViewPagerAdapterScreenshots extends C0642s {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ArrayList<String> uris;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7273396478634344664L, "cm/aptoide/pt/app/view/screenshots/ViewPagerAdapterScreenshots", 15);
        $jacocoData = probes;
        return probes;
    }

    public ViewPagerAdapterScreenshots(ArrayList<String> uris2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.uris = uris2;
        $jacocoInit[0] = true;
    }

    public int getCount() {
        boolean[] $jacocoInit = $jacocoInit();
        int size = this.uris.size();
        $jacocoInit[1] = true;
        return size;
    }

    public Object instantiateItem(ViewGroup container, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        Context context = container.getContext();
        $jacocoInit[2] = true;
        LayoutInflater from = LayoutInflater.from(context);
        $jacocoInit[3] = true;
        View rootView = from.inflate(C1375R.layout.row_item_screenshots_big, null);
        $jacocoInit[4] = true;
        ImageView imageView = (ImageView) rootView.findViewById(C1375R.C1376id.screenshot_image_big);
        $jacocoInit[5] = true;
        ImageLoader with = ImageLoader.with(context);
        ArrayList<String> arrayList = this.uris;
        $jacocoInit[6] = true;
        with.load((String) arrayList.get(position), getPlaceholder(context), imageView);
        $jacocoInit[7] = true;
        container.addView(rootView);
        $jacocoInit[8] = true;
        return rootView;
    }

    public void destroyItem(ViewGroup container, int position, Object object) {
        boolean[] $jacocoInit = $jacocoInit();
        container.removeView((View) object);
        $jacocoInit[9] = true;
    }

    public boolean isViewFromObject(View view, Object object) {
        boolean[] $jacocoInit = $jacocoInit();
        boolean equals = view.equals(object);
        $jacocoInit[10] = true;
        return equals;
    }

    private int getPlaceholder(Context context) {
        int id;
        boolean[] $jacocoInit = $jacocoInit();
        Resources resources = context.getResources();
        $jacocoInit[11] = true;
        if (resources.getConfiguration().orientation == 1) {
            id = C1375R.drawable.placeholder_9_16;
            $jacocoInit[12] = true;
        } else {
            id = C1375R.drawable.placeholder_16_9;
            $jacocoInit[13] = true;
        }
        $jacocoInit[14] = true;
        return id;
    }
}
