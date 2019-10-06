package com.vungle.warren;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.p000v4.p037os.ResultReceiver;
import android.webkit.WebView;
import com.vungle.warren.DirectDownloadAdapter.CONTRACT_TYPE;

@SuppressLint({"RestrictedApi"})
public class SDKDownloadClient {
    /* access modifiers changed from: private */
    public WebView adWebView;
    /* access modifiers changed from: private */
    public ValidationCheck appMarketValidation;
    private ResultReceiver callBackReceiver = new ResultReceiver(new Handler(Looper.getMainLooper())) {
        /* access modifiers changed from: protected */
        @SuppressLint({"SetTextI18n"})
        public void onReceiveResult(int resultCode, Bundle resultData) {
            String str = DirectDownloadAdapter.PACKAGE_NAME;
            String str2 = DirectDownloadAdapter.RESULT;
            if (resultCode == 6) {
                String string = resultData.getString(str);
                boolean isInstalled = resultData.getBoolean(str2);
                boolean isInAppPurchase = resultData.getBoolean(DirectDownloadAdapter.IN_APP_PURCHASE, false);
                if (SDKDownloadClient.this.installStatusCheck != null) {
                    SDKDownloadClient.this.installStatusCheck.isAppInstalled(isInstalled, isInAppPurchase);
                }
            } else if (resultCode == 16) {
                if (SDKDownloadClient.this.adWebView != null) {
                    SDKDownloadClient.this.adWebView.loadUrl("javascript:window.vungle.mraidBridgeExt.getInstallationStatus({\"status\":0})");
                }
            } else if (resultCode == 17) {
                float progressPercent = ((float) resultData.getInt(DirectDownloadAdapter.PROGRESS)) / 100.0f;
                if (SDKDownloadClient.this.adWebView != null) {
                    WebView access$100 = SDKDownloadClient.this.adWebView;
                    StringBuilder sb = new StringBuilder();
                    sb.append("javascript:window.vungle.mraidBridgeExt.getInstallationStatus({\"status\":0,\"percentage\":");
                    sb.append(progressPercent);
                    sb.append("})");
                    access$100.loadUrl(sb.toString());
                }
            } else if (resultCode == 18) {
                if (SDKDownloadClient.this.adWebView != null) {
                    SDKDownloadClient.this.adWebView.loadUrl("javascript:window.vungle.mraidBridgeExt.getInstallationStatus({\"status\":1,\"percentage\":0})");
                }
            } else if (resultCode == 19) {
                boolean downloadInstallSuccess = resultData.getBoolean(str2, true);
                if (SDKDownloadClient.this.adWebView == null) {
                    return;
                }
                if (!downloadInstallSuccess) {
                    SDKDownloadClient.this.adWebView.loadUrl("javascript:window.vungle.mraidBridgeExt.getInstallationStatus({\"status\":-1})");
                } else {
                    SDKDownloadClient.this.adWebView.loadUrl("javascript:window.vungle.mraidBridgeExt.getInstallationStatus({\"status\":1,\"percentage\":1})");
                }
            } else if (resultCode != 26) {
                if (resultCode == 36) {
                    String string2 = resultData.getString(str);
                    boolean isValid = resultData.getBoolean(str2);
                    if (SDKDownloadClient.this.appMarketValidation != null) {
                        SDKDownloadClient.this.appMarketValidation.validateAppPresenceInMarket(isValid);
                        return;
                    }
                    return;
                }
                if (resultCode == 56) {
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public InstallStatusCheck installStatusCheck;
    private String pkgName;
    private ResultReceiver sendingReceiver;

    public interface InstallStatusCheck {
        void isAppInstalled(boolean z, boolean z2);
    }

    public interface ValidationCheck {
        void validateAppPresenceInMarket(boolean z);
    }

    public SDKDownloadClient(String pkgName2) {
        this.pkgName = pkgName2;
    }

    public void setSendingReceiver(ResultReceiver sendingReceiver2) {
        this.sendingReceiver = sendingReceiver2;
    }

    public void setAdWebView(WebView adWebView2) {
        this.adWebView = adWebView2;
    }

    public void sendDownloadRequest() {
        Bundle bundle = new Bundle();
        bundle.putString(DirectDownloadAdapter.PACKAGE_NAME, this.pkgName);
        this.sendingReceiver.send(11, bundle);
    }

    public void sendOpenPackageRequest() {
        Bundle bundle = new Bundle();
        bundle.putString(DirectDownloadAdapter.PACKAGE_NAME, this.pkgName);
        this.sendingReceiver.send(51, bundle);
    }

    public void cancelDownloadRequest() {
        Bundle bundle = new Bundle();
        bundle.putString(DirectDownloadAdapter.PACKAGE_NAME, this.pkgName);
        this.sendingReceiver.send(21, bundle);
    }

    public void installStatusRequest() {
        Bundle bundle = new Bundle();
        bundle.putString(DirectDownloadAdapter.PACKAGE_NAME, this.pkgName);
        this.sendingReceiver.send(1, bundle);
    }

    public ResultReceiver getCallBackReceiver() {
        return this.callBackReceiver;
    }

    public void sendADDisplayingNotify(boolean isOver80, CONTRACT_TYPE type) {
        Bundle bundle = new Bundle();
        bundle.putString(DirectDownloadAdapter.PACKAGE_NAME, this.pkgName);
        bundle.putString(DirectDownloadAdapter.ADTYPE, type.name());
        this.sendingReceiver.send(isOver80 ? 71 : 72, bundle);
    }

    /* access modifiers changed from: protected */
    public void sendValidation(String pkgName2) {
        Bundle bundle = new Bundle();
        bundle.putString(DirectDownloadAdapter.PACKAGE_NAME, pkgName2);
        this.sendingReceiver.send(31, bundle);
    }

    private void requestDetailOpen() {
        Bundle bundle = new Bundle();
        bundle.putString(DirectDownloadAdapter.PACKAGE_NAME, this.pkgName);
        this.sendingReceiver.send(61, bundle);
    }

    public void setAppMarketValidation(ValidationCheck appMarketValidation2) {
        this.appMarketValidation = appMarketValidation2;
    }

    public void setInstallStatusCheck(InstallStatusCheck installStatusCheck2) {
        this.installStatusCheck = installStatusCheck2;
    }

    public void cleanUp() {
        this.adWebView = null;
    }
}
