package com.unity3d.services.ads.api;

import com.unity3d.ads.purchasing.IPurchasing;
import com.unity3d.ads.purchasing.PurchasingError;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.webview.bridge.WebViewCallback;
import com.unity3d.services.core.webview.bridge.WebViewExposed;

public class Purchasing {
    public static IPurchasing purchaseInterface = null;

    public static void setPurchasingInterface(IPurchasing purchasing) {
        purchaseInterface = purchasing;
    }

    @WebViewExposed
    public static void initiatePurchasingCommand(final String eventString, WebViewCallback callback) {
        Utilities.runOnUiThread(new Runnable() {
            public void run() {
                IPurchasing iPurchasing = Purchasing.purchaseInterface;
                if (iPurchasing != null) {
                    iPurchasing.onPurchasingCommand(eventString);
                }
            }
        });
        if (purchaseInterface != null) {
            callback.invoke(new Object[0]);
        } else {
            callback.error(PurchasingError.PURCHASE_INTERFACE_NULL, new Object[0]);
        }
    }

    @WebViewExposed
    public static void getPromoVersion(WebViewCallback callback) {
        Utilities.runOnUiThread(new Runnable() {
            public void run() {
                IPurchasing iPurchasing = Purchasing.purchaseInterface;
                if (iPurchasing != null) {
                    iPurchasing.onGetPurchasingVersion();
                }
            }
        });
        if (purchaseInterface != null) {
            callback.invoke(new Object[0]);
        } else {
            callback.error(PurchasingError.PURCHASE_INTERFACE_NULL, new Object[0]);
        }
    }

    @WebViewExposed
    public static void getPromoCatalog(WebViewCallback callback) {
        Utilities.runOnUiThread(new Runnable() {
            public void run() {
                IPurchasing iPurchasing = Purchasing.purchaseInterface;
                if (iPurchasing != null) {
                    iPurchasing.onGetProductCatalog();
                }
            }
        });
        if (purchaseInterface != null) {
            callback.invoke(new Object[0]);
        } else {
            callback.error(PurchasingError.PURCHASE_INTERFACE_NULL, new Object[0]);
        }
    }

    @WebViewExposed
    public static void initializePurchasing(WebViewCallback callback) {
        Utilities.runOnUiThread(new Runnable() {
            public void run() {
                IPurchasing iPurchasing = Purchasing.purchaseInterface;
                if (iPurchasing != null) {
                    iPurchasing.onInitializePurchasing();
                }
            }
        });
        if (purchaseInterface != null) {
            callback.invoke(new Object[0]);
        } else {
            callback.error(PurchasingError.PURCHASE_INTERFACE_NULL, new Object[0]);
        }
    }
}
