package p005cm.aptoide.p006pt.app.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.p001v7.widget.RecyclerView.C1000w;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.bumptech.glide.p103f.p104a.C5976i;
import java.util.Date;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.app.AppReview;
import p005cm.aptoide.p006pt.app.ReviewStats;
import p005cm.aptoide.p006pt.app.ReviewUser;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p005cm.aptoide.p006pt.utils.AptoideUtils.DateTimeU;

/* renamed from: cm.aptoide.pt.app.view.MiniTopReviewViewHolder */
public class MiniTopReviewViewHolder extends C1000w {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final int LAYOUT_ID = 2131427542;
    private TextView addedDate;
    private TextView commentText;
    private TextView commentTitle;
    private C5976i<Drawable> imageLoadingTarget;
    private RatingBar ratingBar;
    private ImageView userIconImageView;
    private TextView userName;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5325159988478610834L, "cm/aptoide/pt/app/view/MiniTopReviewViewHolder", 32);
        $jacocoData = probes;
        return probes;
    }

    public MiniTopReviewViewHolder(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        $jacocoInit[0] = true;
        bindViews(itemView);
        $jacocoInit[1] = true;
    }

    private void bindViews(View view) {
        boolean[] $jacocoInit = $jacocoInit();
        this.userIconImageView = (ImageView) view.findViewById(C1375R.C1376id.user_icon);
        $jacocoInit[2] = true;
        this.ratingBar = (RatingBar) view.findViewById(C1375R.C1376id.rating_bar);
        $jacocoInit[3] = true;
        this.commentTitle = (TextView) view.findViewById(C1375R.C1376id.comment_title);
        $jacocoInit[4] = true;
        this.userName = (TextView) view.findViewById(C1375R.C1376id.user_name);
        $jacocoInit[5] = true;
        this.addedDate = (TextView) view.findViewById(C1375R.C1376id.added_date);
        $jacocoInit[6] = true;
        this.commentText = (TextView) view.findViewById(C1375R.C1376id.comment);
        $jacocoInit[7] = true;
    }

    public void setup(AppReview review) {
        boolean[] $jacocoInit = $jacocoInit();
        ReviewUser reviewUser = review.getReviewUser();
        $jacocoInit[8] = true;
        String imageUrl = reviewUser.getAvatar();
        $jacocoInit[9] = true;
        Context context = this.itemView.getContext();
        $jacocoInit[10] = true;
        ImageLoader with = ImageLoader.with(context);
        ImageView imageView = this.userIconImageView;
        $jacocoInit[11] = true;
        this.imageLoadingTarget = with.loadWithCircleTransformAndPlaceHolderAvatarSize(imageUrl, imageView, C1375R.drawable.layer_1);
        $jacocoInit[12] = true;
        TextView textView = this.userName;
        ReviewUser reviewUser2 = review.getReviewUser();
        $jacocoInit[13] = true;
        String name = reviewUser2.getName();
        $jacocoInit[14] = true;
        textView.setText(name);
        $jacocoInit[15] = true;
        RatingBar ratingBar2 = this.ratingBar;
        ReviewStats reviewStats = review.getReviewStats();
        $jacocoInit[16] = true;
        float rating = reviewStats.getRating();
        $jacocoInit[17] = true;
        ratingBar2.setRating(rating);
        $jacocoInit[18] = true;
        this.commentTitle.setText(review.getTitle());
        $jacocoInit[19] = true;
        this.commentText.setText(review.getBody());
        $jacocoInit[20] = true;
        TextView textView2 = this.addedDate;
        DateTimeU instance = DateTimeU.getInstance(context);
        $jacocoInit[21] = true;
        Date added = review.getAdded();
        $jacocoInit[22] = true;
        long time = added.getTime();
        Resources resources = context.getResources();
        $jacocoInit[23] = true;
        String timeDiffString = instance.getTimeDiffString(time, context, resources);
        $jacocoInit[24] = true;
        textView2.setText(timeDiffString);
        $jacocoInit[25] = true;
    }

    public void cancelImageLoad() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.imageLoadingTarget == null) {
            $jacocoInit[26] = true;
        } else {
            $jacocoInit[27] = true;
            Context context = this.itemView.getContext();
            $jacocoInit[28] = true;
            Context applicationContext = context.getApplicationContext();
            C5976i<Drawable> iVar = this.imageLoadingTarget;
            $jacocoInit[29] = true;
            ImageLoader.cancel(applicationContext, iVar);
            $jacocoInit[30] = true;
        }
        $jacocoInit[31] = true;
    }
}
