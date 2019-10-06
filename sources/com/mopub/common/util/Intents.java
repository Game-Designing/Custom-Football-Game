package com.mopub.common.util;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.mopub.common.Constants;
import com.mopub.common.MoPub;
import com.mopub.common.MoPub.BrowserAgent;
import com.mopub.common.MoPubBrowser;
import com.mopub.common.Preconditions;
import com.mopub.common.Preconditions.NoThrow;
import com.mopub.common.UrlAction;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.exceptions.IntentNotResolvableException;
import com.mopub.exceptions.UrlParseException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Intents {

    /* renamed from: a */
    private static final Map<String, String> f34590a;

    static {
        Map<String, String> tempMap = new HashMap<>();
        tempMap.put("market", "https://play.google.com/store/apps/details?%s");
        tempMap.put("amzn", "http://www.amazon.com/gp/mas/dl/android?%s");
        f34590a = Collections.unmodifiableMap(tempMap);
    }

    private Intents() {
    }

    public static void startActivity(Context context, Intent intent) throws IntentNotResolvableException {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(intent);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            throw new IntentNotResolvableException((Throwable) e);
        }
    }

    public static Intent getStartActivityIntent(Context context, Class clazz, Bundle extras) {
        Intent intent = new Intent(context, clazz);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        if (extras != null) {
            intent.putExtras(extras);
        }
        return intent;
    }

    public static boolean deviceCanHandleIntent(Context context, Intent intent) {
        try {
            return !context.getPackageManager().queryIntentActivities(intent, 0).isEmpty();
        } catch (NullPointerException e) {
            return false;
        }
    }

    public static Intent intentForNativeBrowserScheme(Uri uri) throws UrlParseException {
        Preconditions.checkNotNull(uri);
        if (!UrlAction.OPEN_NATIVE_BROWSER.shouldTryHandlingUrl(uri)) {
            String supportedSchemes = "mopubnativebrowser://";
            if (MoPub.getBrowserAgent() == BrowserAgent.NATIVE) {
                StringBuilder sb = new StringBuilder();
                sb.append(supportedSchemes);
                sb.append(", http://, or https://");
                supportedSchemes = sb.toString();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("URI does not have ");
            sb2.append(supportedSchemes);
            sb2.append(" scheme.");
            throw new UrlParseException(sb2.toString());
        }
        String str = "android.intent.action.VIEW";
        if ("mopubnativebrowser".equalsIgnoreCase(uri.getScheme())) {
            return new Intent(str, m37189a(uri));
        }
        if (MoPub.getBrowserAgent() == BrowserAgent.NATIVE) {
            return new Intent(str, uri);
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Invalid URI: ");
        sb3.append(uri.toString());
        throw new UrlParseException(sb3.toString());
    }

    /* renamed from: a */
    private static Uri m37189a(Uri uri) throws UrlParseException {
        Preconditions.checkNotNull(uri);
        if ("navigate".equals(uri.getHost())) {
            try {
                String urlToOpenInNativeBrowser = uri.getQueryParameter("url");
                if (urlToOpenInNativeBrowser != null) {
                    return Uri.parse(urlToOpenInNativeBrowser);
                }
                throw new UrlParseException("URL missing 'url' query parameter.");
            } catch (UnsupportedOperationException e) {
                SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
                StringBuilder sb = new StringBuilder();
                sb.append("Could not handle url: ");
                sb.append(uri);
                MoPubLog.log(sdkLogEvent, sb.toString());
                throw new UrlParseException("Passed-in URL did not create a hierarchical URI.");
            }
        } else {
            throw new UrlParseException("URL missing 'navigate' host parameter.");
        }
    }

    public static Intent intentForShareTweet(Uri uri) throws UrlParseException {
        if (UrlAction.HANDLE_SHARE_TWEET.shouldTryHandlingUrl(uri)) {
            try {
                String screenName = uri.getQueryParameter("screen_name");
                String tweetId = uri.getQueryParameter("tweet_id");
                if (TextUtils.isEmpty(screenName)) {
                    throw new UrlParseException("URL missing non-empty 'screen_name' query parameter.");
                } else if (!TextUtils.isEmpty(tweetId)) {
                    String shareMessage = String.format("Check out @%s's Tweet: %s", new Object[]{screenName, String.format("https://twitter.com/%s/status/%s", new Object[]{screenName, tweetId})});
                    Intent shareTweetIntent = new Intent("android.intent.action.SEND");
                    shareTweetIntent.setType("text/plain");
                    shareTweetIntent.putExtra("android.intent.extra.SUBJECT", shareMessage);
                    shareTweetIntent.putExtra("android.intent.extra.TEXT", shareMessage);
                    return shareTweetIntent;
                } else {
                    throw new UrlParseException("URL missing non-empty 'tweet_id' query parameter.");
                }
            } catch (UnsupportedOperationException e) {
                SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
                StringBuilder sb = new StringBuilder();
                sb.append("Could not handle url: ");
                sb.append(uri);
                MoPubLog.log(sdkLogEvent, sb.toString());
                throw new UrlParseException("Passed-in URL did not create a hierarchical URI.");
            }
        } else {
            throw new UrlParseException("URL does not have mopubshare://tweet? format.");
        }
    }

    public static void showMoPubBrowserForUrl(Context context, Uri uri, String dspCreativeId) throws IntentNotResolvableException {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(uri);
        SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
        StringBuilder sb = new StringBuilder();
        sb.append("Final URI to show in browser: ");
        sb.append(uri);
        MoPubLog.log(sdkLogEvent, sb.toString());
        Bundle extras = new Bundle();
        extras.putString(MoPubBrowser.DESTINATION_URL_KEY, uri.toString());
        if (!TextUtils.isEmpty(dspCreativeId)) {
            extras.putString(MoPubBrowser.DSP_CREATIVE_ID, dspCreativeId);
        }
        Intent intent = getStartActivityIntent(context, MoPubBrowser.class, extras);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Could not show MoPubBrowser for url: ");
        sb2.append(uri);
        sb2.append("\n\tPerhaps you forgot to declare com.mopub.common.MoPubBrowser in your Android manifest file.");
        launchIntentForUserClick(context, intent, sb2.toString());
    }

    public static void launchIntentForUserClick(Context context, Intent intent, String errorMessage) throws IntentNotResolvableException {
        NoThrow.checkNotNull(context);
        NoThrow.checkNotNull(intent);
        try {
            startActivity(context, intent);
        } catch (IntentNotResolvableException e) {
            StringBuilder sb = new StringBuilder();
            sb.append(errorMessage);
            sb.append("\n");
            sb.append(e.getMessage());
            throw new IntentNotResolvableException(sb.toString());
        }
    }

    public static void launchApplicationUrl(Context context, Uri uri) throws IntentNotResolvableException {
        String str = "android.intent.action.VIEW";
        Intent intent = new Intent(str, uri);
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(uri);
        if (deviceCanHandleIntent(context, intent)) {
            launchApplicationIntent(context, intent);
        } else if (!f34590a.containsKey(intent.getScheme()) || intent.getData() == null || TextUtils.isEmpty(intent.getData().getQuery())) {
            StringBuilder sb = new StringBuilder();
            sb.append("Could not handle application specific action: ");
            sb.append(uri);
            sb.append("\n\tYou may be running in the emulator or another device which does not have the required application.");
            throw new IntentNotResolvableException(sb.toString());
        } else {
            launchApplicationIntent(context, new Intent(str, Uri.parse(String.format((String) f34590a.get(intent.getScheme()), new Object[]{intent.getData().getQuery()}))));
        }
    }

    public static void launchApplicationIntent(Context context, Intent intent) throws IntentNotResolvableException {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(intent);
        if (deviceCanHandleIntent(context, intent)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to open intent: ");
            sb.append(intent);
            String errorMessage = sb.toString();
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            launchIntentForUserClick(context, intent, errorMessage);
            return;
        }
        String fallbackUrl = intent.getStringExtra("browser_fallback_url");
        if (!TextUtils.isEmpty(fallbackUrl)) {
            Uri fallbackUri = Uri.parse(fallbackUrl);
            String fallbackScheme = fallbackUri.getScheme();
            if (Constants.HTTP.equalsIgnoreCase(fallbackScheme) || "https".equalsIgnoreCase(fallbackScheme)) {
                showMoPubBrowserForUrl(context, fallbackUri, null);
            } else {
                launchApplicationUrl(context, fallbackUri);
            }
        } else if (!f34590a.containsKey(intent.getScheme())) {
            launchApplicationUrl(context, getPlayStoreUri(intent));
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Device could not handle neither intent nor market url.\nIntent: ");
            sb2.append(intent.toString());
            throw new IntentNotResolvableException(sb2.toString());
        }
    }

    public static Uri getPlayStoreUri(Intent intent) {
        Preconditions.checkNotNull(intent);
        StringBuilder sb = new StringBuilder();
        sb.append("market://details?id=");
        sb.append(intent.getPackage());
        return Uri.parse(sb.toString());
    }

    public static void launchActionViewIntent(Context context, Uri uri, String errorMessage) throws IntentNotResolvableException {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(uri);
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        launchIntentForUserClick(context, intent, errorMessage);
    }

    @Deprecated
    public static boolean canHandleApplicationUrl(Context context, Uri uri) {
        return false;
    }

    @Deprecated
    public static boolean canHandleApplicationUrl(Context context, Uri uri, boolean logError) {
        return false;
    }
}
