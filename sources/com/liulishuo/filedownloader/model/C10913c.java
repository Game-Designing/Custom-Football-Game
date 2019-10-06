package com.liulishuo.filedownloader.model;

import p019d.p307j.p308a.C13079a;

/* renamed from: com.liulishuo.filedownloader.model.c */
/* compiled from: FileDownloadStatus */
public class C10913c {
    /* renamed from: b */
    public static boolean m35800b(int status) {
        return status < 0;
    }

    /* renamed from: a */
    public static boolean m35797a(int status) {
        return status > 0;
    }

    /* renamed from: a */
    public static boolean m35798a(int status, int nextStatus) {
        if ((status != 3 && status != 5 && status == nextStatus) || m35800b(status)) {
            return false;
        }
        if (status >= 1 && status <= 6 && nextStatus >= 10 && nextStatus <= 11) {
            return false;
        }
        if (status != 1) {
            if (status != 2) {
                if (status != 3) {
                    if (status != 5) {
                        if (status != 6) {
                            return true;
                        }
                        if (nextStatus == 0 || nextStatus == 1) {
                            return false;
                        }
                        return true;
                    } else if (nextStatus == 1 || nextStatus == 6) {
                        return false;
                    } else {
                        return true;
                    }
                } else if (nextStatus == 0 || nextStatus == 1 || nextStatus == 2 || nextStatus == 6) {
                    return false;
                } else {
                    return true;
                }
            } else if (nextStatus == 0 || nextStatus == 1 || nextStatus == 6) {
                return false;
            } else {
                return true;
            }
        } else if (nextStatus != 0) {
            return true;
        } else {
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m35801b(int status, int nextStatus) {
        if ((status != 3 && status != 5 && status == nextStatus) || m35800b(status)) {
            return false;
        }
        if (nextStatus == -2 || nextStatus == -1) {
            return true;
        }
        if (status != 0) {
            if (status != 1) {
                if (status == 2 || status == 3) {
                    if (nextStatus == -3 || nextStatus == 3 || nextStatus == 5) {
                        return true;
                    }
                    return false;
                } else if (status == 5 || status == 6) {
                    if (nextStatus == 2 || nextStatus == 5) {
                        return true;
                    }
                    return false;
                } else if (status != 10) {
                    if (status != 11) {
                        return false;
                    }
                    if (nextStatus == -4 || nextStatus == -3 || nextStatus == 1) {
                        return true;
                    }
                    return false;
                } else if (nextStatus != 11) {
                    return false;
                } else {
                    return true;
                }
            } else if (nextStatus != 6) {
                return false;
            } else {
                return true;
            }
        } else if (nextStatus != 10) {
            return false;
        } else {
            return true;
        }
    }

    /* renamed from: a */
    public static boolean m35799a(C13079a task) {
        return task.getStatus() == 0 || task.getStatus() == 3;
    }
}
