package p005cm.aptoide.p006pt.store.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.store.view.StoreAutoCompleteTextView */
public class StoreAutoCompleteTextView extends AutoCompleteTextView {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final int DEFAULT_AUTOCOMPLETE_DELAY = 2000;
    private static final int MESSAGE_TEXT_CHANGED = 100;
    private int mAutoCompleteDelay = DEFAULT_AUTOCOMPLETE_DELAY;
    private final Handler mHandler = new Handler(this) {
        private static transient /* synthetic */ boolean[] $jacocoData;
        final /* synthetic */ StoreAutoCompleteTextView this$0;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(9211284843800045961L, "cm/aptoide/pt/store/view/StoreAutoCompleteTextView$1", 2);
            $jacocoData = probes;
            return probes;
        }

        {
            boolean[] $jacocoInit = $jacocoInit();
            this.this$0 = this$0;
            $jacocoInit[0] = true;
        }

        public void handleMessage(Message msg) {
            boolean[] $jacocoInit = $jacocoInit();
            StoreAutoCompleteTextView.access$001(this.this$0, (CharSequence) msg.obj, msg.arg1);
            $jacocoInit[1] = true;
        }
    };

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1649224957904067889L, "cm/aptoide/pt/store/view/StoreAutoCompleteTextView", 6);
        $jacocoData = probes;
        return probes;
    }

    static /* synthetic */ void access$001(StoreAutoCompleteTextView x0, CharSequence x1, int x2) {
        boolean[] $jacocoInit = $jacocoInit();
        super.performFiltering(x1, x2);
        $jacocoInit[5] = true;
    }

    public StoreAutoCompleteTextView(Context context, AttributeSet attrs) {
        boolean[] $jacocoInit = $jacocoInit();
        super(context, attrs);
        $jacocoInit[0] = true;
        $jacocoInit[1] = true;
    }

    /* access modifiers changed from: protected */
    public void performFiltering(CharSequence text, int keyCode) {
        boolean[] $jacocoInit = $jacocoInit();
        this.mHandler.removeMessages(100);
        $jacocoInit[2] = true;
        Handler handler = this.mHandler;
        handler.sendMessageDelayed(handler.obtainMessage(100, text), (long) this.mAutoCompleteDelay);
        $jacocoInit[3] = true;
    }

    public void onFilterComplete(int count) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onFilterComplete(count);
        $jacocoInit[4] = true;
    }
}
