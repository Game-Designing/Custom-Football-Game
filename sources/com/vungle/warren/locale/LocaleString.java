package com.vungle.warren.locale;

import java.util.Locale;

public class LocaleString {
    public static final int ID_DOWNLOADING = 4;
    public static final int ID_DOWNLOAD_COMPLETE = 5;
    public static final int ID_PROGRESS = 3;
    public static final int ID_START_DOWNLOAD = 1;
    public static final int ID_WAITING_FOR_WIFI = 2;
    private static final String TEXT_DOWNLOADING_CN = "下载中…";
    private static final String TEXT_DOWNLOADING_DEFAULT = "Downloading…";
    private static final String TEXT_DOWNLOAD_COMPLETE_CN = "下载完成";
    private static final String TEXT_DOWNLOAD_COMPLETE_DEFAULT = "Download complete.";
    private static final String TEXT_IN_PROGRESS_CN = "正在下载…";
    private static final String TEXT_IN_PROGRESS_DEFAULT = "Download in progress…";
    private static final String TEXT_START_DOWNLOAD_CN = "开始下载…";
    private static final String TEXT_START_DOWNLOAD_DEFAULT = "Download started…";
    private static final String TEXT_WAITING_FOR_WIFI_CN = "等待Wi-Fi…";
    private static final String TEXT_WAITING_FOR_WIFI_DEFAULT = "Waiting for Wi-Fi…";

    public static String getLocaleText(int id) {
        boolean isCN = Locale.getDefault().getLanguage().equals(new Locale("zh").getLanguage());
        if (id == 1) {
            return isCN ? TEXT_START_DOWNLOAD_CN : TEXT_START_DOWNLOAD_DEFAULT;
        } else if (id == 2) {
            return isCN ? TEXT_WAITING_FOR_WIFI_CN : TEXT_WAITING_FOR_WIFI_DEFAULT;
        } else if (id == 3) {
            return isCN ? TEXT_IN_PROGRESS_CN : TEXT_IN_PROGRESS_DEFAULT;
        } else if (id == 4) {
            return isCN ? TEXT_DOWNLOADING_CN : TEXT_DOWNLOADING_DEFAULT;
        } else if (id != 5) {
            return "";
        } else {
            return isCN ? TEXT_DOWNLOAD_COMPLETE_CN : TEXT_DOWNLOAD_COMPLETE_DEFAULT;
        }
    }
}
