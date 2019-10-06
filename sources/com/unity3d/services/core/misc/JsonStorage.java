package com.unity3d.services.core.misc;

import android.text.TextUtils;
import com.unity3d.services.core.log.DeviceLog;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONObject;

public class JsonStorage {
    private JSONObject _data;

    public synchronized boolean initData() {
        if (this._data != null) {
            return false;
        }
        this._data = new JSONObject();
        return true;
    }

    public synchronized void setData(JSONObject data) {
        this._data = data;
    }

    public synchronized JSONObject getData() {
        return this._data;
    }

    public synchronized boolean hasData() {
        if (this._data == null || this._data.length() <= 0) {
            return false;
        }
        return true;
    }

    public synchronized void clearData() {
        this._data = null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0049, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean set(java.lang.String r6, java.lang.Object r7) {
        /*
            r5 = this;
            monitor-enter(r5)
            org.json.JSONObject r0 = r5._data     // Catch:{ all -> 0x0079 }
            r1 = 0
            if (r0 == 0) goto L_0x0051
            if (r6 == 0) goto L_0x0051
            int r0 = r6.length()     // Catch:{ all -> 0x0079 }
            if (r0 == 0) goto L_0x0051
            if (r7 != 0) goto L_0x0011
            goto L_0x0051
        L_0x0011:
            java.lang.String r0 = r5.getParentObjectTreeFor(r6)     // Catch:{ all -> 0x0079 }
            r5.createObjectTree(r0)     // Catch:{ all -> 0x0079 }
            java.lang.String r0 = r5.getParentObjectTreeFor(r6)     // Catch:{ all -> 0x0079 }
            java.lang.Object r0 = r5.findObject(r0)     // Catch:{ all -> 0x0079 }
            boolean r0 = r0 instanceof org.json.JSONObject     // Catch:{ all -> 0x0079 }
            if (r0 == 0) goto L_0x004a
            java.lang.String r0 = r5.getParentObjectTreeFor(r6)     // Catch:{ all -> 0x0079 }
            java.lang.Object r0 = r5.findObject(r0)     // Catch:{ all -> 0x0079 }
            org.json.JSONObject r0 = (org.json.JSONObject) r0     // Catch:{ all -> 0x0079 }
            java.lang.String r2 = "\\."
            java.lang.String[] r2 = r6.split(r2)     // Catch:{ all -> 0x0079 }
            r3 = 1
            if (r0 == 0) goto L_0x0047
            int r4 = r2.length     // Catch:{ JSONException -> 0x003f }
            int r4 = r4 - r3
            r4 = r2[r4]     // Catch:{ JSONException -> 0x003f }
            r0.put(r4, r7)     // Catch:{ JSONException -> 0x003f }
            goto L_0x0047
        L_0x003f:
            r3 = move-exception
            java.lang.String r4 = "Couldn't set value"
            com.unity3d.services.core.log.DeviceLog.exception(r4, r3)     // Catch:{ all -> 0x0079 }
            monitor-exit(r5)
            return r1
        L_0x0047:
            monitor-exit(r5)
            return r3
        L_0x004a:
            java.lang.String r0 = "Cannot set subvalue to an object that is not JSONObject"
            com.unity3d.services.core.log.DeviceLog.debug(r0)     // Catch:{ all -> 0x0079 }
            monitor-exit(r5)
            return r1
        L_0x0051:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0079 }
            r0.<init>()     // Catch:{ all -> 0x0079 }
            java.lang.String r2 = "Storage not properly initialized or incorrect parameters:"
            r0.append(r2)     // Catch:{ all -> 0x0079 }
            org.json.JSONObject r2 = r5._data     // Catch:{ all -> 0x0079 }
            r0.append(r2)     // Catch:{ all -> 0x0079 }
            java.lang.String r2 = ", "
            r0.append(r2)     // Catch:{ all -> 0x0079 }
            r0.append(r6)     // Catch:{ all -> 0x0079 }
            java.lang.String r2 = ", "
            r0.append(r2)     // Catch:{ all -> 0x0079 }
            r0.append(r7)     // Catch:{ all -> 0x0079 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0079 }
            com.unity3d.services.core.log.DeviceLog.error(r0)     // Catch:{ all -> 0x0079 }
            monitor-exit(r5)
            return r1
        L_0x0079:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.misc.JsonStorage.set(java.lang.String, java.lang.Object):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004b, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.lang.Object get(java.lang.String r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            org.json.JSONObject r0 = r5._data     // Catch:{ all -> 0x004c }
            r1 = 0
            if (r0 != 0) goto L_0x000d
            java.lang.String r0 = "Data is NULL, readStorage probably not called"
            com.unity3d.services.core.log.DeviceLog.error(r0)     // Catch:{ all -> 0x004c }
            monitor-exit(r5)
            return r1
        L_0x000d:
            java.lang.String r0 = "\\."
            java.lang.String[] r0 = r6.split(r0)     // Catch:{ all -> 0x004c }
            java.lang.String r2 = r5.getParentObjectTreeFor(r6)     // Catch:{ all -> 0x004c }
            java.lang.Object r2 = r5.findObject(r2)     // Catch:{ all -> 0x004c }
            boolean r2 = r2 instanceof org.json.JSONObject     // Catch:{ all -> 0x004c }
            if (r2 == 0) goto L_0x004a
            java.lang.String r2 = r5.getParentObjectTreeFor(r6)     // Catch:{ all -> 0x004c }
            java.lang.Object r2 = r5.findObject(r2)     // Catch:{ all -> 0x004c }
            org.json.JSONObject r2 = (org.json.JSONObject) r2     // Catch:{ all -> 0x004c }
            if (r2 == 0) goto L_0x004a
            r1 = 0
            int r3 = r0.length     // Catch:{ Exception -> 0x0042 }
            int r3 = r3 + -1
            r3 = r0[r3]     // Catch:{ Exception -> 0x0042 }
            boolean r3 = r2.has(r3)     // Catch:{ Exception -> 0x0042 }
            if (r3 == 0) goto L_0x0041
            int r3 = r0.length     // Catch:{ Exception -> 0x0042 }
            int r3 = r3 + -1
            r3 = r0[r3]     // Catch:{ Exception -> 0x0042 }
            java.lang.Object r3 = r2.get(r3)     // Catch:{ Exception -> 0x0042 }
            r1 = r3
        L_0x0041:
            goto L_0x0048
        L_0x0042:
            r3 = move-exception
            java.lang.String r4 = "Error getting data"
            com.unity3d.services.core.log.DeviceLog.exception(r4, r3)     // Catch:{ all -> 0x004c }
        L_0x0048:
            monitor-exit(r5)
            return r1
        L_0x004a:
            monitor-exit(r5)
            return r1
        L_0x004c:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.misc.JsonStorage.get(java.lang.String):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0072, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.util.List<java.lang.String> getKeys(java.lang.String r10, boolean r11) {
        /*
            r9 = this;
            monitor-enter(r9)
            java.lang.Object r0 = r9.get(r10)     // Catch:{ all -> 0x0076 }
            boolean r0 = r0 instanceof org.json.JSONObject     // Catch:{ all -> 0x0076 }
            if (r0 == 0) goto L_0x0073
            java.lang.Object r0 = r9.get(r10)     // Catch:{ all -> 0x0076 }
            org.json.JSONObject r0 = (org.json.JSONObject) r0     // Catch:{ all -> 0x0076 }
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0076 }
            r1.<init>()     // Catch:{ all -> 0x0076 }
            if (r0 == 0) goto L_0x0071
            java.util.Iterator r2 = r0.keys()     // Catch:{ all -> 0x0076 }
        L_0x001a:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0076 }
            if (r3 == 0) goto L_0x0071
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0076 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0076 }
            r4 = 0
            if (r11 == 0) goto L_0x0042
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0076 }
            r5.<init>()     // Catch:{ all -> 0x0076 }
            r5.append(r10)     // Catch:{ all -> 0x0076 }
            java.lang.String r6 = "."
            r5.append(r6)     // Catch:{ all -> 0x0076 }
            r5.append(r3)     // Catch:{ all -> 0x0076 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0076 }
            java.util.List r5 = r9.getKeys(r5, r11)     // Catch:{ all -> 0x0076 }
            r4 = r5
        L_0x0042:
            r1.add(r3)     // Catch:{ all -> 0x0076 }
            if (r4 == 0) goto L_0x0070
            java.util.Iterator r5 = r4.iterator()     // Catch:{ all -> 0x0076 }
        L_0x004b:
            boolean r6 = r5.hasNext()     // Catch:{ all -> 0x0076 }
            if (r6 == 0) goto L_0x0070
            java.lang.Object r6 = r5.next()     // Catch:{ all -> 0x0076 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0076 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0076 }
            r7.<init>()     // Catch:{ all -> 0x0076 }
            r7.append(r3)     // Catch:{ all -> 0x0076 }
            java.lang.String r8 = "."
            r7.append(r8)     // Catch:{ all -> 0x0076 }
            r7.append(r6)     // Catch:{ all -> 0x0076 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0076 }
            r1.add(r7)     // Catch:{ all -> 0x0076 }
            goto L_0x004b
        L_0x0070:
            goto L_0x001a
        L_0x0071:
            monitor-exit(r9)
            return r1
        L_0x0073:
            r0 = 0
            monitor-exit(r9)
            return r0
        L_0x0076:
            r10 = move-exception
            monitor-exit(r9)
            goto L_0x007a
        L_0x0079:
            throw r10
        L_0x007a:
            goto L_0x0079
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.misc.JsonStorage.getKeys(java.lang.String, boolean):java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0039, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean delete(java.lang.String r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            org.json.JSONObject r0 = r5._data     // Catch:{ all -> 0x003a }
            r1 = 0
            if (r0 != 0) goto L_0x000d
            java.lang.String r0 = "Data is NULL, readStorage probably not called"
            com.unity3d.services.core.log.DeviceLog.error(r0)     // Catch:{ all -> 0x003a }
            monitor-exit(r5)
            return r1
        L_0x000d:
            java.lang.String r0 = "\\."
            java.lang.String[] r0 = r6.split(r0)     // Catch:{ all -> 0x003a }
            java.lang.String r2 = r5.getParentObjectTreeFor(r6)     // Catch:{ all -> 0x003a }
            java.lang.Object r2 = r5.findObject(r2)     // Catch:{ all -> 0x003a }
            boolean r2 = r2 instanceof org.json.JSONObject     // Catch:{ all -> 0x003a }
            if (r2 == 0) goto L_0x0038
            java.lang.String r2 = r5.getParentObjectTreeFor(r6)     // Catch:{ all -> 0x003a }
            java.lang.Object r2 = r5.findObject(r2)     // Catch:{ all -> 0x003a }
            org.json.JSONObject r2 = (org.json.JSONObject) r2     // Catch:{ all -> 0x003a }
            if (r2 == 0) goto L_0x0038
            int r3 = r0.length     // Catch:{ all -> 0x003a }
            r4 = 1
            int r3 = r3 - r4
            r3 = r0[r3]     // Catch:{ all -> 0x003a }
            java.lang.Object r3 = r2.remove(r3)     // Catch:{ all -> 0x003a }
            if (r3 == 0) goto L_0x0038
            monitor-exit(r5)
            return r4
        L_0x0038:
            monitor-exit(r5)
            return r1
        L_0x003a:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.misc.JsonStorage.delete(java.lang.String):boolean");
    }

    private synchronized Object findObject(String key) {
        String[] objects = key.split("\\.");
        JSONObject parentObject = this._data;
        if (key.length() == 0) {
            return parentObject;
        }
        int idx = 0;
        while (idx < objects.length) {
            if (!parentObject.has(objects[idx])) {
                return null;
            }
            try {
                parentObject = parentObject.getJSONObject(objects[idx]);
                idx++;
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Couldn't read JSONObject: ");
                sb.append(objects[idx]);
                DeviceLog.exception(sb.toString(), e);
                return null;
            }
        }
        return parentObject;
    }

    private synchronized void createObjectTree(String tree) {
        String[] objects = tree.split("\\.");
        JSONObject parentObject = this._data;
        if (tree.length() != 0) {
            for (int idx = 0; idx < objects.length; idx++) {
                if (!parentObject.has(objects[idx])) {
                    try {
                        parentObject = parentObject.put(objects[idx], new JSONObject()).getJSONObject(objects[idx]);
                    } catch (Exception e) {
                        DeviceLog.exception("Couldn't create new JSONObject", e);
                    }
                } else {
                    try {
                        parentObject = parentObject.getJSONObject(objects[idx]);
                    } catch (Exception e2) {
                        DeviceLog.exception("Couldn't get existing JSONObject", e2);
                    }
                }
            }
        }
    }

    private synchronized String getParentObjectTreeFor(String tree) {
        ArrayList<String> tmpObs;
        tmpObs = new ArrayList<>(Arrays.asList(tree.split("\\.")));
        tmpObs.remove(tmpObs.size() - 1);
        return TextUtils.join(".", tmpObs.toArray());
    }
}
