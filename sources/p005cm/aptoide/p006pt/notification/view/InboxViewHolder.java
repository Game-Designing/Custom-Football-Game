package p005cm.aptoide.p006pt.notification.view;

import android.support.p001v7.widget.RecyclerView.C1000w;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p005cm.aptoide.p006pt.notification.AptoideNotification;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.notification.view.InboxViewHolder */
class InboxViewHolder extends C1000w {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private TextView body;
    private C14963c<AptoideNotification> notificationSubject;
    private final TextView title;
    private ImageView userAvatar;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6278001777061821856L, "cm/aptoide/pt/notification/view/InboxViewHolder", 10);
        $jacocoData = probes;
        return probes;
    }

    protected InboxViewHolder(View itemView, C14963c<AptoideNotification> notificationSubject2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        this.notificationSubject = notificationSubject2;
        $jacocoInit[0] = true;
        this.title = (TextView) itemView.findViewById(C1375R.C1376id.fragment_inbox_list_title);
        $jacocoInit[1] = true;
        this.body = (TextView) itemView.findViewById(C1375R.C1376id.fragment_inbox_list_body);
        $jacocoInit[2] = true;
        this.userAvatar = (ImageView) itemView.findViewById(C1375R.C1376id.fragment_inbox_list_item_image);
        $jacocoInit[3] = true;
    }

    public void setNotification(AptoideNotification notification) {
        boolean[] $jacocoInit = $jacocoInit();
        this.title.setText(notification.getTitle());
        $jacocoInit[4] = true;
        this.body.setText(notification.getBody());
        $jacocoInit[5] = true;
        ImageLoader with = ImageLoader.with(this.itemView.getContext());
        $jacocoInit[6] = true;
        with.loadWithShadowCircleTransform(notification.getImg(), this.userAvatar);
        $jacocoInit[7] = true;
        this.itemView.setOnClickListener(new C4247o(this, notification));
        $jacocoInit[8] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo15338a(AptoideNotification notification, View v) {
        boolean[] $jacocoInit = $jacocoInit();
        this.notificationSubject.onNext(notification);
        $jacocoInit[9] = true;
    }
}
