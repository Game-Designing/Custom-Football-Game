package p005cm.aptoide.analytics.implementation.loggers;

import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request.Builder;
import okhttp3.Response;
import p005cm.aptoide.analytics.KnockEventLogger;

/* renamed from: cm.aptoide.analytics.implementation.loggers.HttpKnockEventLogger */
public class HttpKnockEventLogger implements KnockEventLogger {
    private final OkHttpClient client;

    public HttpKnockEventLogger(OkHttpClient client2) {
        this.client = client2;
    }

    public void log(String url) {
        this.client.newCall(new Builder().url(url).build()).enqueue(new Callback() {
            public void onFailure(Call call, IOException e) {
            }

            public void onResponse(Call call, Response response) {
                response.body().close();
            }
        });
    }
}
