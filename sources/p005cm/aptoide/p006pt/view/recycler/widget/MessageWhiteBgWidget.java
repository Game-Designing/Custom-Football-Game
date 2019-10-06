package p005cm.aptoide.p006pt.view.recycler.widget;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p005cm.aptoide.p006pt.view.recycler.displayable.MessageWhiteBgDisplayable;

/* renamed from: cm.aptoide.pt.view.recycler.widget.MessageWhiteBgWidget */
public class MessageWhiteBgWidget extends Widget<MessageWhiteBgDisplayable> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private TextView message;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6401920426543472780L, "cm/aptoide/pt/view/recycler/widget/MessageWhiteBgWidget", 8);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void bindView(Displayable displayable, int i) {
        boolean[] $jacocoInit = $jacocoInit();
        bindView((MessageWhiteBgDisplayable) displayable, i);
        $jacocoInit[7] = true;
    }

    public MessageWhiteBgWidget(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        $jacocoInit[0] = true;
    }

    /* access modifiers changed from: protected */
    public void assignViews(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        this.message = (TextView) itemView.findViewById(C1375R.C1376id.message);
        $jacocoInit[1] = true;
    }

    public void bindView(MessageWhiteBgDisplayable displayable, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        String messageText = displayable.getMessage();
        $jacocoInit[2] = true;
        if (TextUtils.isEmpty(messageText)) {
            $jacocoInit[3] = true;
            this.message.setVisibility(8);
            $jacocoInit[4] = true;
        } else {
            this.message.setText(messageText);
            $jacocoInit[5] = true;
        }
        $jacocoInit[6] = true;
    }
}
