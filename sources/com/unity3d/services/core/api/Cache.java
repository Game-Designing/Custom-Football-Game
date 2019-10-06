package com.unity3d.services.core.api;

import android.annotation.TargetApi;
import android.media.MediaMetadataRetriever;
import android.util.Base64;
import android.util.SparseArray;
import com.unity3d.services.core.cache.CacheDirectory;
import com.unity3d.services.core.cache.CacheDirectoryType;
import com.unity3d.services.core.cache.CacheError;
import com.unity3d.services.core.cache.CacheThread;
import com.unity3d.services.core.device.Device;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.properties.SdkProperties;
import com.unity3d.services.core.request.WebRequestError;
import com.unity3d.services.core.webview.bridge.WebViewCallback;
import com.unity3d.services.core.webview.bridge.WebViewExposed;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Cache {
    @WebViewExposed
    public static void download(String url, String fileId, JSONArray headers, Boolean append, WebViewCallback callback) {
        if (CacheThread.isActive()) {
            callback.error(CacheError.FILE_ALREADY_CACHING, new Object[0]);
        } else if (!Device.isActiveNetworkConnected()) {
            callback.error(CacheError.NO_INTERNET, new Object[0]);
        } else {
            try {
                CacheThread.download(url, fileIdToFilename(fileId), Request.getHeadersMap(headers), append.booleanValue());
                callback.invoke(new Object[0]);
            } catch (Exception e) {
                DeviceLog.exception("Error mapping headers for the request", e);
                callback.error(WebRequestError.MAPPING_HEADERS_FAILED, url, fileId);
            }
        }
    }

    @WebViewExposed
    public static void stop(WebViewCallback callback) {
        if (!CacheThread.isActive()) {
            callback.error(CacheError.NOT_CACHING, new Object[0]);
            return;
        }
        CacheThread.cancel();
        callback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void isCaching(WebViewCallback callback) {
        callback.invoke(Boolean.valueOf(CacheThread.isActive()));
    }

    @WebViewExposed
    public static void getFileContent(String fileId, String encoding, WebViewCallback callback) {
        String fileContents;
        String fileName = fileIdToFilename(fileId);
        File f = new File(fileName);
        if (!f.exists()) {
            callback.error(CacheError.FILE_NOT_FOUND, fileId, fileName);
            return;
        }
        try {
            byte[] byteData = Utilities.readFileBytes(f);
            if (encoding == null) {
                callback.error(CacheError.UNSUPPORTED_ENCODING, fileId, fileName, encoding);
                return;
            }
            String str = "UTF-8";
            if (encoding.equals(str)) {
                fileContents = Charset.forName(str).decode(ByteBuffer.wrap(byteData)).toString();
            } else if (encoding.equals("Base64")) {
                fileContents = Base64.encodeToString(byteData, 2);
            } else {
                callback.error(CacheError.UNSUPPORTED_ENCODING, fileId, fileName, encoding);
                return;
            }
            callback.invoke(fileContents);
        } catch (IOException e) {
            CacheError cacheError = CacheError.FILE_IO_ERROR;
            StringBuilder sb = new StringBuilder();
            sb.append(e.getMessage());
            sb.append(", ");
            sb.append(e.getClass().getName());
            callback.error(cacheError, fileId, fileName, sb.toString());
        }
    }

    @WebViewExposed
    public static void setFileContent(String fileId, String encoding, String content, WebViewCallback callback) {
        String str = "UTF-8";
        String str2 = "Error closing FileOutputStream";
        String targetFileName = fileIdToFilename(fileId);
        boolean fileOutput = null;
        boolean fileOutput2 = false;
        try {
            byte[] fileContents = content.getBytes(str);
            if (encoding != null && encoding.length() > 0) {
                if (encoding.equals("Base64")) {
                    fileContents = Base64.decode(content, 2);
                } else if (!encoding.equals(str)) {
                    callback.error(CacheError.UNSUPPORTED_ENCODING, fileId, targetFileName, encoding);
                    return;
                }
            }
            try {
                fileOutput = new FileOutputStream(targetFileName);
                fileOutput.write(fileContents);
                fileOutput.flush();
                fileOutput2 = true;
                try {
                    fileOutput.close();
                } catch (Exception e) {
                    DeviceLog.exception(str2, e);
                }
            } catch (FileNotFoundException e2) {
                callback.error(CacheError.FILE_NOT_FOUND, fileId, targetFileName, encoding);
                if (fileOutput != null) {
                    fileOutput.close();
                }
            } catch (IOException e3) {
                callback.error(CacheError.FILE_IO_ERROR, fileId, targetFileName, encoding);
                if (fileOutput != null) {
                    fileOutput.close();
                }
            } finally {
                if (fileOutput != null) {
                    try {
                        fileOutput.close();
                    } catch (Exception e4) {
                        DeviceLog.exception(str2, e4);
                    }
                }
            }
            if (fileOutput) {
                callback.invoke(new Object[0]);
            }
        } catch (UnsupportedEncodingException e5) {
            callback.error(CacheError.UNSUPPORTED_ENCODING, fileId, targetFileName, encoding);
        }
    }

    @WebViewExposed
    public static void getFiles(WebViewCallback callback) {
        File cacheDirectory = SdkProperties.getCacheDirectory();
        if (cacheDirectory != null) {
            DeviceLog.debug("Unity Ads cache: checking app directory for Unity Ads cached files");
            File[] fileList = cacheDirectory.listFiles(new FilenameFilter() {
                public boolean accept(File dir, String filename) {
                    return filename.startsWith(SdkProperties.getCacheFilePrefix());
                }
            });
            if (fileList == null || fileList.length == 0) {
                callback.invoke(new JSONArray());
            }
            try {
                JSONArray files = new JSONArray();
                for (File f : fileList) {
                    String name = f.getName().substring(SdkProperties.getCacheFilePrefix().length());
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unity Ads cache: found ");
                    sb.append(name);
                    sb.append(", ");
                    sb.append(f.length());
                    sb.append(" bytes");
                    DeviceLog.debug(sb.toString());
                    files.put(getFileJson(name));
                }
                callback.invoke(files);
            } catch (JSONException e) {
                DeviceLog.exception("Error creating JSON", e);
                callback.error(CacheError.JSON_ERROR, new Object[0]);
            }
        }
    }

    @WebViewExposed
    public static void getFileInfo(String fileId, WebViewCallback callback) {
        try {
            callback.invoke(getFileJson(fileId));
        } catch (JSONException e) {
            DeviceLog.exception("Error creating JSON", e);
            callback.error(CacheError.JSON_ERROR, new Object[0]);
        }
    }

    @WebViewExposed
    public static void getFilePath(String fileId, WebViewCallback callback) {
        if (new File(fileIdToFilename(fileId)).exists()) {
            callback.invoke(fileIdToFilename(fileId));
            return;
        }
        callback.error(CacheError.FILE_NOT_FOUND, new Object[0]);
    }

    @WebViewExposed
    public static void deleteFile(String fileId, WebViewCallback callback) {
        if (new File(fileIdToFilename(fileId)).delete()) {
            callback.invoke(new Object[0]);
        } else {
            callback.error(CacheError.FILE_IO_ERROR, new Object[0]);
        }
    }

    @WebViewExposed
    public static void getHash(String fileId, WebViewCallback callback) {
        callback.invoke(Utilities.Sha256(fileId));
    }

    @WebViewExposed
    public static void setTimeouts(Integer connectTimeout, Integer readTimeout, WebViewCallback callback) {
        CacheThread.setConnectTimeout(connectTimeout.intValue());
        CacheThread.setReadTimeout(readTimeout.intValue());
        callback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void getTimeouts(WebViewCallback callback) {
        callback.invoke(Integer.valueOf(CacheThread.getConnectTimeout()), Integer.valueOf(CacheThread.getReadTimeout()));
    }

    @WebViewExposed
    public static void setProgressInterval(Integer interval, WebViewCallback callback) {
        CacheThread.setProgressInterval(interval.intValue());
        callback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void getProgressInterval(WebViewCallback callback) {
        callback.invoke(Integer.valueOf(CacheThread.getProgressInterval()));
    }

    @WebViewExposed
    public static void getFreeSpace(WebViewCallback callback) {
        callback.invoke(Long.valueOf(Device.getFreeSpace(SdkProperties.getCacheDirectory())));
    }

    @WebViewExposed
    public static void getTotalSpace(WebViewCallback callback) {
        callback.invoke(Long.valueOf(Device.getTotalSpace(SdkProperties.getCacheDirectory())));
    }

    @WebViewExposed
    public static void getMetaData(String fileId, JSONArray requestedMetaDatas, WebViewCallback callback) {
        try {
            SparseArray<String> returnValues = getMetaData(fileIdToFilename(fileId), requestedMetaDatas);
            JSONArray returnJsonArray = new JSONArray();
            for (int i = 0; i < returnValues.size(); i++) {
                JSONArray entryJsonArray = new JSONArray();
                entryJsonArray.put(returnValues.keyAt(i));
                entryJsonArray.put(returnValues.valueAt(i));
                returnJsonArray.put(entryJsonArray);
            }
            callback.invoke(returnJsonArray);
        } catch (JSONException e) {
            callback.error(CacheError.JSON_ERROR, e.getMessage());
        } catch (RuntimeException e2) {
            callback.error(CacheError.INVALID_ARGUMENT, e2.getMessage());
        } catch (IOException e3) {
            callback.error(CacheError.FILE_IO_ERROR, e3.getMessage());
        }
    }

    @WebViewExposed
    public static void getCacheDirectoryType(WebViewCallback callback) {
        CacheDirectory cacheDir = SdkProperties.getCacheDirectoryObject();
        if (cacheDir == null || cacheDir.getCacheDirectory(ClientProperties.getApplicationContext()) == null) {
            callback.error(CacheError.CACHE_DIRECTORY_NULL, new Object[0]);
        } else if (!cacheDir.getCacheDirectory(ClientProperties.getApplicationContext()).exists()) {
            callback.error(CacheError.CACHE_DIRECTORY_DOESNT_EXIST, new Object[0]);
        } else {
            CacheDirectoryType cacheDirType = cacheDir.getType();
            if (cacheDirType == null) {
                callback.error(CacheError.CACHE_DIRECTORY_TYPE_NULL, new Object[0]);
                return;
            }
            callback.invoke(cacheDirType.name());
        }
    }

    @WebViewExposed
    public static void getCacheDirectoryExists(WebViewCallback callback) {
        File cacheDir = SdkProperties.getCacheDirectory();
        if (cacheDir == null) {
            callback.error(CacheError.CACHE_DIRECTORY_NULL, new Object[0]);
            return;
        }
        callback.invoke(Boolean.valueOf(cacheDir.exists()));
    }

    @WebViewExposed
    public static void recreateCacheDirectory(WebViewCallback callback) {
        if (SdkProperties.getCacheDirectory().exists()) {
            callback.error(CacheError.CACHE_DIRECTORY_EXISTS, new Object[0]);
            return;
        }
        SdkProperties.setCacheDirectory(null);
        if (SdkProperties.getCacheDirectory() == null) {
            callback.error(CacheError.CACHE_DIRECTORY_NULL, new Object[0]);
        } else {
            callback.invoke(new Object[0]);
        }
    }

    @TargetApi(10)
    private static SparseArray<String> getMetaData(String videoFile, JSONArray requestedMetaDatas) throws JSONException, IOException, RuntimeException {
        File f = new File(videoFile);
        SparseArray<String> returnArray = new SparseArray<>();
        if (f.exists()) {
            MediaMetadataRetriever metadataRetriever = new MediaMetadataRetriever();
            metadataRetriever.setDataSource(f.getAbsolutePath());
            for (int i = 0; i < requestedMetaDatas.length(); i++) {
                int metaDataKey = requestedMetaDatas.getInt(i);
                String metaDataValue = metadataRetriever.extractMetadata(metaDataKey);
                if (metaDataValue != null) {
                    returnArray.put(metaDataKey, metaDataValue);
                }
            }
            return returnArray;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("File: ");
        sb.append(f.getAbsolutePath());
        sb.append(" doesn't exist");
        throw new IOException(sb.toString());
    }

    private static String fileIdToFilename(String fileId) {
        StringBuilder sb = new StringBuilder();
        sb.append(SdkProperties.getCacheDirectory());
        sb.append("/");
        sb.append(SdkProperties.getCacheFilePrefix());
        sb.append(fileId);
        return sb.toString();
    }

    private static JSONObject getFileJson(String fileId) throws JSONException {
        JSONObject fileJson = new JSONObject();
        fileJson.put("id", fileId);
        File f = new File(fileIdToFilename(fileId));
        String str = "found";
        if (f.exists()) {
            fileJson.put(str, true);
            fileJson.put("size", f.length());
            fileJson.put("mtime", f.lastModified());
        } else {
            fileJson.put(str, false);
        }
        return fileJson;
    }
}
