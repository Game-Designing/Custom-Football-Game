package p005cm.aptoide.p006pt.comments.view;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.TextView;
import java.util.List;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.comments.CommentAdder;
import p005cm.aptoide.p006pt.dataprovider.WebService;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.DataList;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.ListComments;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.ListCommentsRequest;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p005cm.aptoide.p006pt.view.recycler.widget.Widget;
import p019d.p022i.p296a.p305c.C13034a;
import p026rx.C0120S;
import p026rx.C0137ja;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.p029i.C0136c;
import retrofit2.Converter.Factory;
import rx.Observable;

/* renamed from: cm.aptoide.pt.comments.view.CommentsReadMoreWidget */
public class CommentsReadMoreWidget extends Widget<CommentsReadMoreDisplayable> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private TextView readMoreButton;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6847964316068602108L, "cm/aptoide/pt/comments/view/CommentsReadMoreWidget", 22);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void bindView(Displayable displayable, int i) {
        boolean[] $jacocoInit = $jacocoInit();
        bindView((CommentsReadMoreDisplayable) displayable, i);
        $jacocoInit[16] = true;
    }

    public CommentsReadMoreWidget(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        $jacocoInit[0] = true;
    }

    /* access modifiers changed from: protected */
    public void assignViews(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        this.readMoreButton = (TextView) itemView.findViewById(C1375R.C1376id.read_more_button);
        $jacocoInit[1] = true;
    }

    public void bindView(CommentsReadMoreDisplayable displayable, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[2] = true;
        BodyInterceptor<BaseBody> baseBodyInterceptor = ((AptoideApplication) getContext().getApplicationContext()).getAccountSettingsBodyInterceptorPoolV7();
        $jacocoInit[3] = true;
        OkHttpClient httpClient = ((AptoideApplication) getContext().getApplicationContext()).getDefaultClient();
        $jacocoInit[4] = true;
        Factory converterFactory = WebService.getDefaultConverter();
        $jacocoInit[5] = true;
        long resourceId = displayable.getResourceId();
        int next = displayable.getNext();
        $jacocoInit[6] = true;
        boolean isReview = displayable.isReview();
        $jacocoInit[7] = true;
        TokenInvalidator tokenInvalidator = ((AptoideApplication) getContext().getApplicationContext()).getTokenInvalidator();
        $jacocoInit[8] = true;
        SharedPreferences defaultSharedPreferences = ((AptoideApplication) getContext().getApplicationContext()).getDefaultSharedPreferences();
        $jacocoInit[9] = true;
        ListCommentsRequest of = ListCommentsRequest.m7470of(resourceId, next, 100, isReview, baseBodyInterceptor, httpClient, converterFactory, tokenInvalidator, defaultSharedPreferences);
        $jacocoInit[10] = true;
        Observable<ListComments> listCommentsObservable = of.observe();
        $jacocoInit[11] = true;
        C0136c cVar = this.compositeSubscription;
        C0120S a = C13034a.m42490a(this.readMoreButton);
        C2658D d = new C2658D(listCommentsObservable);
        $jacocoInit[12] = true;
        C0120S f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) d);
        C2655C c = new C2655C(displayable);
        $jacocoInit[13] = true;
        C0137ja c2 = f.mo3646c((C0129b<? super T>) c);
        $jacocoInit[14] = true;
        cVar.mo3713a(c2);
        $jacocoInit[15] = true;
    }

    /* renamed from: a */
    static /* synthetic */ C0120S m7346a(C0120S listCommentsObservable, Void __) {
        $jacocoInit()[21] = true;
        return listCommentsObservable;
    }

    /* renamed from: a */
    static /* synthetic */ void m7347a(CommentsReadMoreDisplayable displayable, ListComments listComments) {
        boolean[] $jacocoInit = $jacocoInit();
        CommentAdder commentAdder = displayable.getCommentAdder();
        $jacocoInit[17] = true;
        DataList dataList = listComments.getDataList();
        $jacocoInit[18] = true;
        List list = dataList.getList();
        $jacocoInit[19] = true;
        commentAdder.addComment(list);
        $jacocoInit[20] = true;
    }
}
