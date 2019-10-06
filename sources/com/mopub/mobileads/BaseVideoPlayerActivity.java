package com.mopub.mobileads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import com.mopub.common.AdType;
import com.mopub.common.Constants;
import com.mopub.common.DataKeys;
import com.mopub.common.FullAdType;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;

public class BaseVideoPlayerActivity extends Activity {
    public static final String VIDEO_CLASS_EXTRAS_KEY = "video_view_class_name";
    public static final String VIDEO_URL = "video_url";

    public static void startMraid(Context context, String videoUrl) {
        try {
            context.startActivity(m37293a(context, videoUrl));
        } catch (ActivityNotFoundException e) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "Activity MraidVideoPlayerActivity not found. Did you declare it in your AndroidManifest.xml?");
        }
    }

    /* renamed from: a */
    static Intent m37293a(Context context, String videoUrl) {
        Intent intentVideoPlayerActivity = new Intent(context, MraidVideoPlayerActivity.class);
        intentVideoPlayerActivity.setFlags(268435456);
        intentVideoPlayerActivity.putExtra(VIDEO_CLASS_EXTRAS_KEY, AdType.MRAID);
        intentVideoPlayerActivity.putExtra("video_url", videoUrl);
        return intentVideoPlayerActivity;
    }

    /* renamed from: b */
    static void m37294b(Context context, VastVideoConfig vastVideoConfig, long broadcastIdentifier) {
        try {
            context.startActivity(m37292a(context, vastVideoConfig, broadcastIdentifier));
        } catch (ActivityNotFoundException e) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "Activity MraidVideoPlayerActivity not found. Did you declare it in your AndroidManifest.xml?");
        }
    }

    /* renamed from: a */
    static Intent m37292a(Context context, VastVideoConfig vastVideoConfig, long broadcastIdentifier) {
        Intent intentVideoPlayerActivity = new Intent(context, MraidVideoPlayerActivity.class);
        intentVideoPlayerActivity.setFlags(268435456);
        intentVideoPlayerActivity.putExtra(VIDEO_CLASS_EXTRAS_KEY, FullAdType.VAST);
        intentVideoPlayerActivity.putExtra("vast_video_config", vastVideoConfig);
        intentVideoPlayerActivity.putExtra(DataKeys.BROADCAST_IDENTIFIER_KEY, broadcastIdentifier);
        return intentVideoPlayerActivity;
    }

    public static void startNativeVideo(Context context, long nativeVideoId, VastVideoConfig vastVideoConfig) {
        try {
            context.startActivity(createIntentNativeVideo(context, nativeVideoId, vastVideoConfig));
        } catch (ActivityNotFoundException e) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "Activity MraidVideoPlayerActivity not found. Did you declare it in your AndroidManifest.xml?");
        }
    }

    public static Intent createIntentNativeVideo(Context context, long nativeVideoId, VastVideoConfig vastVideoConfig) {
        Intent intentVideoPlayerActivity = new Intent(context, MraidVideoPlayerActivity.class);
        intentVideoPlayerActivity.setFlags(268435456);
        intentVideoPlayerActivity.putExtra(VIDEO_CLASS_EXTRAS_KEY, "native");
        intentVideoPlayerActivity.putExtra(Constants.NATIVE_VIDEO_ID, nativeVideoId);
        intentVideoPlayerActivity.putExtra(Constants.NATIVE_VAST_VIDEO_CONFIG, vastVideoConfig);
        return intentVideoPlayerActivity;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        AudioManager am = (AudioManager) getSystemService("audio");
        if (am != null) {
            am.abandonAudioFocus(null);
        }
    }
}
