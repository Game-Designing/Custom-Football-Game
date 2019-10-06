package p005cm.aptoide.p006pt.app.view.donations;

import android.support.p001v7.widget.RecyclerView.C0970a;
import android.support.p001v7.widget.RecyclerView.C1000w;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import java.text.DecimalFormat;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.app.view.donations.view.DonationListEntryViewHolder;

/* renamed from: cm.aptoide.pt.app.view.donations.DonationsAdapter */
public class DonationsAdapter extends C0970a<DonationListEntryViewHolder> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private List<Donation> donations;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1045967177659491950L, "cm/aptoide/pt/app/view/donations/DonationsAdapter", 12);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void onBindViewHolder(C1000w wVar, int i) {
        boolean[] $jacocoInit = $jacocoInit();
        onBindViewHolder((DonationListEntryViewHolder) wVar, i);
        $jacocoInit[10] = true;
    }

    public DonationsAdapter(List<Donation> donations2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.donations = donations2;
        $jacocoInit[0] = true;
    }

    public DonationListEntryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        boolean[] $jacocoInit = $jacocoInit();
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        $jacocoInit[1] = true;
        DonationListEntryViewHolder donationListEntryViewHolder = new DonationListEntryViewHolder(from.inflate(C1375R.layout.appview_donations_list_entry, parent, false), new DecimalFormat("0.##"));
        $jacocoInit[2] = true;
        return donationListEntryViewHolder;
    }

    public void onBindViewHolder(DonationListEntryViewHolder holder, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        int i = position + 1;
        Donation donation = (Donation) this.donations.get(position);
        $jacocoInit[3] = true;
        String owner = donation.getOwner();
        Donation donation2 = (Donation) this.donations.get(position);
        $jacocoInit[4] = true;
        float appc = donation2.getAppc();
        $jacocoInit[5] = true;
        holder.setUp(i, owner, appc);
        $jacocoInit[6] = true;
    }

    public int getItemCount() {
        boolean[] $jacocoInit = $jacocoInit();
        int size = this.donations.size();
        $jacocoInit[7] = true;
        return size;
    }

    public void setDonations(List<Donation> donations2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.donations = donations2;
        $jacocoInit[8] = true;
        notifyDataSetChanged();
        $jacocoInit[9] = true;
    }
}
