package p005cm.aptoide.p006pt.notification.view;

import android.support.p001v7.widget.RecyclerView.C0970a;
import android.support.p001v7.widget.RecyclerView.C1000w;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.notification.AptoideNotification;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.notification.view.InboxAdapter */
public class InboxAdapter extends C0970a<InboxViewHolder> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private C14963c<AptoideNotification> notificationSubject;
    private List<AptoideNotification> notifications;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8648349529827936118L, "cm/aptoide/pt/notification/view/InboxAdapter", 9);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void onBindViewHolder(C1000w wVar, int i) {
        boolean[] $jacocoInit = $jacocoInit();
        onBindViewHolder((InboxViewHolder) wVar, i);
        $jacocoInit[7] = true;
    }

    public InboxAdapter(List<AptoideNotification> notifications2, C14963c<AptoideNotification> notificationSubject2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.notifications = notifications2;
        this.notificationSubject = notificationSubject2;
        $jacocoInit[0] = true;
    }

    public InboxViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        boolean[] $jacocoInit = $jacocoInit();
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        $jacocoInit[1] = true;
        InboxViewHolder inboxViewHolder = new InboxViewHolder(from.inflate(C1375R.layout.fragment_inbox_list_item, parent, false), this.notificationSubject);
        $jacocoInit[2] = true;
        return inboxViewHolder;
    }

    public void onBindViewHolder(InboxViewHolder holder, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        holder.setNotification((AptoideNotification) this.notifications.get(position));
        $jacocoInit[3] = true;
    }

    public int getItemCount() {
        boolean[] $jacocoInit = $jacocoInit();
        int size = this.notifications.size();
        $jacocoInit[4] = true;
        return size;
    }

    public void updateNotifications(List<AptoideNotification> notifications2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.notifications = notifications2;
        $jacocoInit[5] = true;
        notifyDataSetChanged();
        $jacocoInit[6] = true;
    }
}
