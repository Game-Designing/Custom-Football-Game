package p005cm.aptoide.p006pt.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.DeepLinkIntentReceiver;

/* renamed from: cm.aptoide.pt.widget.SearchWidgetProvider */
public class SearchWidgetProvider extends AppWidgetProvider {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4940772213866647477L, "cm/aptoide/pt/widget/SearchWidgetProvider", 10);
        $jacocoData = probes;
        return probes;
    }

    public SearchWidgetProvider() {
        $jacocoInit()[0] = true;
    }

    public void onUpdate(Context context, AppWidgetManager manager, int[] appWidgetIds) {
        boolean[] $jacocoInit = $jacocoInit();
        int length = appWidgetIds.length;
        $jacocoInit[1] = true;
        int i = 0;
        while (i < length) {
            int appWidgetId = appWidgetIds[i];
            $jacocoInit[2] = true;
            Intent intent = new Intent(context, DeepLinkIntentReceiver.class);
            $jacocoInit[3] = true;
            intent.setData(Uri.parse("aptoide://cm.aptoide.pt/deeplink?name=search"));
            $jacocoInit[4] = true;
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
            $jacocoInit[5] = true;
            RemoteViews views = new RemoteViews(context.getPackageName(), C1375R.layout.widget_search_layout);
            $jacocoInit[6] = true;
            views.setOnClickPendingIntent(C1375R.C1376id.widget_search_bar, pendingIntent);
            $jacocoInit[7] = true;
            manager.updateAppWidget(appWidgetId, views);
            i++;
            $jacocoInit[8] = true;
        }
        $jacocoInit[9] = true;
    }
}
