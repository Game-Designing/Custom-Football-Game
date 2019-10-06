package p005cm.aptoide.p006pt.app.view.screenshots;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.p001v7.widget.RecyclerView.C1000w;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import java.util.ArrayList;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p005cm.aptoide.p006pt.view.app.AppScreenshot;
import p005cm.aptoide.p006pt.view.app.AppVideo;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.app.view.screenshots.ScreenshotViewHolder */
public class ScreenshotViewHolder extends C1000w {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    static final int LAYOUT_ID = 2131427618;
    private static final String PORTRAIT = "PORTRAIT";
    private FrameLayout media_layout;
    private ImageView play_button;
    private final C14963c<ScreenShotClickEvent> screenShotClick;
    private ImageView screenshot;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4658776901631128600L, "cm/aptoide/pt/app/view/screenshots/ScreenshotViewHolder", 38);
        $jacocoData = probes;
        return probes;
    }

    ScreenshotViewHolder(View itemView, C14963c<ScreenShotClickEvent> screenShotClick2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        $jacocoInit[0] = true;
        assignViews(itemView);
        this.screenShotClick = screenShotClick2;
        $jacocoInit[1] = true;
    }

    /* access modifiers changed from: protected */
    public void assignViews(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        this.screenshot = (ImageView) itemView.findViewById(C1375R.C1376id.screenshot_image_item);
        $jacocoInit[2] = true;
        this.play_button = (ImageView) itemView.findViewById(C1375R.C1376id.play_button);
        $jacocoInit[3] = true;
        this.media_layout = (FrameLayout) itemView.findViewById(C1375R.C1376id.media_layout);
        $jacocoInit[4] = true;
    }

    public void bindView(AppVideo item) {
        boolean[] $jacocoInit = $jacocoInit();
        Context context = this.screenshot.getContext();
        if (context == null) {
            $jacocoInit[5] = true;
            return;
        }
        ImageLoader with = ImageLoader.with(context);
        $jacocoInit[6] = true;
        with.load(item.getThumbnail(), C1375R.drawable.placeholder_square, this.screenshot);
        $jacocoInit[7] = true;
        if (isLollipopOrHigher()) {
            $jacocoInit[8] = true;
            FrameLayout frameLayout = this.media_layout;
            Resources resources = context.getResources();
            $jacocoInit[9] = true;
            Drawable drawable = resources.getDrawable(C1375R.color.overlay_black, context.getTheme());
            $jacocoInit[10] = true;
            frameLayout.setForeground(drawable);
            $jacocoInit[11] = true;
        } else {
            FrameLayout frameLayout2 = this.media_layout;
            Resources resources2 = context.getResources();
            $jacocoInit[12] = true;
            Drawable drawable2 = resources2.getDrawable(C1375R.color.overlay_black);
            $jacocoInit[13] = true;
            frameLayout2.setForeground(drawable2);
            $jacocoInit[14] = true;
        }
        this.play_button.setVisibility(0);
        $jacocoInit[15] = true;
        this.itemView.setOnClickListener(new C2202b(this, item));
        $jacocoInit[16] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo11000a(AppVideo item, View __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.screenShotClick.onNext(new ScreenShotClickEvent(Uri.parse(item.getUrl())));
        $jacocoInit[37] = true;
    }

    private boolean isLollipopOrHigher() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (VERSION.SDK_INT >= 21) {
            $jacocoInit[17] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[18] = true;
        }
        $jacocoInit[19] = true;
        return z;
    }

    public void bindView(AppScreenshot item, int position, ArrayList<String> imagesUris) {
        boolean[] $jacocoInit = $jacocoInit();
        Context context = this.screenshot.getContext();
        if (context == null) {
            $jacocoInit[20] = true;
            return;
        }
        this.media_layout.setForeground(null);
        $jacocoInit[21] = true;
        this.play_button.setVisibility(8);
        $jacocoInit[22] = true;
        ImageLoader with = ImageLoader.with(context);
        $jacocoInit[23] = true;
        String url = item.getUrl();
        String orientation = item.getOrientation();
        $jacocoInit[24] = true;
        int placeholder = getPlaceholder(item.getOrientation());
        ImageView imageView = this.screenshot;
        $jacocoInit[25] = true;
        with.loadScreenshotToThumb(url, orientation, placeholder, imageView);
        $jacocoInit[26] = true;
        this.itemView.setOnClickListener(new C2201a(this, imagesUris, position));
        $jacocoInit[27] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo11001a(ArrayList imagesUris, int position, View __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.screenShotClick.onNext(new ScreenShotClickEvent(imagesUris, position));
        $jacocoInit[36] = true;
    }

    private int getPlaceholder(String orient) {
        boolean[] $jacocoInit = $jacocoInit();
        if (viewIsInPortrait(orient)) {
            $jacocoInit[28] = true;
            return C1375R.drawable.placeholder_9_16;
        }
        $jacocoInit[29] = true;
        return C1375R.drawable.placeholder_16_9;
    }

    private boolean viewIsInPortrait(String orient) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (TextUtils.isEmpty(orient)) {
            $jacocoInit[30] = true;
        } else {
            String upperCase = orient.toUpperCase();
            $jacocoInit[31] = true;
            if (!upperCase.equals(PORTRAIT)) {
                $jacocoInit[32] = true;
            } else {
                $jacocoInit[33] = true;
                z = true;
                $jacocoInit[35] = true;
                return z;
            }
        }
        z = false;
        $jacocoInit[34] = true;
        $jacocoInit[35] = true;
        return z;
    }
}
