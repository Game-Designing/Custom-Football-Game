package com.vungle.warren.utility;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.vungle.warren.p267ui.VungleWebViewActivity;
import java.net.URISyntaxException;

public class ExternalRouter {
    public static void launch(String url, Context context) throws URISyntaxException {
        Intent i = Intent.parseUri(url, 0);
        i.setFlags(268435456);
        if (i.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(i);
            return;
        }
        i.setComponent(new ComponentName(context, VungleWebViewActivity.class));
        context.startActivity(i);
    }
}
