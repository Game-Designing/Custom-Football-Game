package com.mopub.nativeads;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.Drawables;
import java.util.Map;

public class NativeRendererHelper {
    public static void addTextView(TextView textView, String contents) {
        if (textView == null) {
            SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
            StringBuilder sb = new StringBuilder();
            sb.append("Attempted to add text (");
            sb.append(contents);
            sb.append(") to null TextView.");
            MoPubLog.log(sdkLogEvent, sb.toString());
            return;
        }
        textView.setText(null);
        if (contents == null) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "Attempted to set TextView contents to null.");
        } else {
            textView.setText(contents);
        }
    }

    public static void addPrivacyInformationIcon(ImageView privacyInformationIconImageView, String privacyInformationImageUrl, String privacyInformationClickthroughUrl) {
        if (privacyInformationIconImageView != null) {
            if (privacyInformationClickthroughUrl == null) {
                privacyInformationIconImageView.setImageDrawable(null);
                privacyInformationIconImageView.setOnClickListener(null);
                privacyInformationIconImageView.setVisibility(4);
                return;
            }
            Context context = privacyInformationIconImageView.getContext();
            if (context != null) {
                if (privacyInformationImageUrl == null) {
                    privacyInformationIconImageView.setImageDrawable(Drawables.NATIVE_PRIVACY_INFORMATION_ICON.createDrawable(context));
                } else {
                    NativeImageHelper.loadImageView(privacyInformationImageUrl, privacyInformationIconImageView);
                }
                privacyInformationIconImageView.setOnClickListener(new C11644ta(context, privacyInformationClickthroughUrl));
                privacyInformationIconImageView.setVisibility(0);
            }
        }
    }

    public static void addCtaButton(TextView ctaTextView, View rootView, String contents) {
        addTextView(ctaTextView, contents);
        if (ctaTextView != null && rootView != null) {
            ctaTextView.setOnClickListener(new C11647ua(rootView));
        }
    }

    public static void updateExtras(View mainView, Map<String, Integer> extrasIds, Map<String, Object> extras) {
        if (mainView == null) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "Attempted to bind extras on a null main view.");
            return;
        }
        for (String key : extrasIds.keySet()) {
            View view = mainView.findViewById(((Integer) extrasIds.get(key)).intValue());
            Object content = extras.get(key);
            if (view instanceof ImageView) {
                ((ImageView) view).setImageDrawable(null);
                Object object = extras.get(key);
                if (object != null && (object instanceof String)) {
                    NativeImageHelper.loadImageView((String) object, (ImageView) view);
                }
            } else if (view instanceof TextView) {
                ((TextView) view).setText(null);
                if (content instanceof String) {
                    addTextView((TextView) view, (String) content);
                }
            } else {
                SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
                StringBuilder sb = new StringBuilder();
                sb.append("View bound to ");
                sb.append(key);
                sb.append(" should be an instance of TextView or ImageView.");
                MoPubLog.log(sdkLogEvent, sb.toString());
            }
        }
    }
}
