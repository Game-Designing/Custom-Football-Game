package p019d.p307j.p308a.p313e;

/* renamed from: d.j.a.e.a */
/* compiled from: DownloadServiceNotConnectedHelper */
public class C13110a {
    /* renamed from: a */
    public static boolean m42763a(String url, String path, boolean pathAsDirectory) {
        m42761a("request start the task([%s], [%s], [%B]) in the download service", url, path, Boolean.valueOf(pathAsDirectory));
        return false;
    }

    /* renamed from: c */
    public static boolean m42765c(int id) {
        m42761a("request pause the task[%d] in the download service", Integer.valueOf(id));
        return false;
    }

    /* renamed from: b */
    public static byte m42764b(int id) {
        m42761a("request get the status for the task[%d] in the download service", Integer.valueOf(id));
        return 0;
    }

    /* renamed from: a */
    public static void m42760a() {
        m42761a("request pause all tasks in the download service", new Object[0]);
    }

    /* renamed from: a */
    public static boolean m42762a(int id) {
        m42761a("request clear the task[%d] data in the database", Integer.valueOf(id));
        return false;
    }

    /* renamed from: a */
    private static void m42761a(String message, Object... args) {
        StringBuilder sb = new StringBuilder();
        sb.append(message);
        sb.append(", but the download service isn't connected yet.");
        sb.append("\nYou can use FileDownloader#isServiceConnected() to check whether the service has been connected, \nbesides you can use following functions easier to control your code invoke after the service has been connected: \n1. FileDownloader#bindService(Runnable)\n2. FileDownloader#insureServiceBind()\n3. FileDownloader#insureServiceBindAsync()");
        C13117d.m42783e(C13110a.class, sb.toString(), args);
    }
}
