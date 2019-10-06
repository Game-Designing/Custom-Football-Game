package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.ConnectionPool;
import okhttp3.EventListener;
import okhttp3.Interceptor.Chain;
import okhttp3.OkHttpClient;
import okhttp3.Route;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RouteSelector.Selection;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;

public final class StreamAllocation {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public final Address address;
    public final Call call;
    private final Object callStackTrace;
    private boolean canceled;
    private HttpCodec codec;
    private RealConnection connection;
    private final ConnectionPool connectionPool;
    public final EventListener eventListener;
    private int refusedStreamCount;
    private boolean released;
    private boolean reportedAcquired;
    private Route route;
    private Selection routeSelection;
    private final RouteSelector routeSelector;

    public static final class StreamAllocationReference extends WeakReference<StreamAllocation> {
        public final Object callStackTrace;

        StreamAllocationReference(StreamAllocation referent, Object callStackTrace2) {
            super(referent);
            this.callStackTrace = callStackTrace2;
        }
    }

    public StreamAllocation(ConnectionPool connectionPool2, Address address2, Call call2, EventListener eventListener2, Object callStackTrace2) {
        this.connectionPool = connectionPool2;
        this.address = address2;
        this.call = call2;
        this.eventListener = eventListener2;
        this.routeSelector = new RouteSelector(address2, routeDatabase(), call2, eventListener2);
        this.callStackTrace = callStackTrace2;
    }

    public HttpCodec newStream(OkHttpClient client, Chain chain, boolean doExtensiveHealthChecks) {
        try {
            HttpCodec resultCodec = findHealthyConnection(chain.connectTimeoutMillis(), chain.readTimeoutMillis(), chain.writeTimeoutMillis(), client.pingIntervalMillis(), client.retryOnConnectionFailure(), doExtensiveHealthChecks).newCodec(client, chain, this);
            synchronized (this.connectionPool) {
                this.codec = resultCodec;
            }
            return resultCodec;
        } catch (IOException e) {
            throw new RouteException(e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        if (r0.isHealthy(r9) != false) goto L_0x0018;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private okhttp3.internal.connection.RealConnection findHealthyConnection(int r4, int r5, int r6, int r7, boolean r8, boolean r9) throws java.io.IOException {
        /*
            r3 = this;
        L_0x0000:
            okhttp3.internal.connection.RealConnection r0 = r3.findConnection(r4, r5, r6, r7, r8)
            okhttp3.ConnectionPool r1 = r3.connectionPool
            monitor-enter(r1)
            int r2 = r0.successCount     // Catch:{ all -> 0x0019 }
            if (r2 != 0) goto L_0x000d
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            return r0
        L_0x000d:
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            boolean r1 = r0.isHealthy(r9)
            if (r1 != 0) goto L_0x0018
            r3.noNewStreams()
            goto L_0x0000
        L_0x0018:
            return r0
        L_0x0019:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            goto L_0x001d
        L_0x001c:
            throw r2
        L_0x001d:
            goto L_0x001c
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.StreamAllocation.findHealthyConnection(int, int, int, int, boolean, boolean):okhttp3.internal.connection.RealConnection");
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0077 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00cd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private okhttp3.internal.connection.RealConnection findConnection(int r19, int r20, int r21, int r22, boolean r23) throws java.io.IOException {
        /*
            r18 = this;
            r1 = r18
            r2 = 0
            r3 = 0
            r4 = 0
            okhttp3.ConnectionPool r5 = r1.connectionPool
            monitor-enter(r5)
            boolean r0 = r1.released     // Catch:{ all -> 0x0142 }
            if (r0 != 0) goto L_0x013a
            okhttp3.internal.http.HttpCodec r0 = r1.codec     // Catch:{ all -> 0x0142 }
            if (r0 != 0) goto L_0x0132
            boolean r0 = r1.canceled     // Catch:{ all -> 0x0142 }
            if (r0 != 0) goto L_0x012a
            okhttp3.internal.connection.RealConnection r0 = r1.connection     // Catch:{ all -> 0x0142 }
            java.net.Socket r6 = r18.releaseIfNoNewStreams()     // Catch:{ all -> 0x0142 }
            okhttp3.internal.connection.RealConnection r7 = r1.connection     // Catch:{ all -> 0x0142 }
            if (r7 == 0) goto L_0x0022
            okhttp3.internal.connection.RealConnection r7 = r1.connection     // Catch:{ all -> 0x0142 }
            r3 = r7
            r0 = 0
        L_0x0022:
            boolean r7 = r1.reportedAcquired     // Catch:{ all -> 0x0142 }
            if (r7 != 0) goto L_0x0029
            r0 = 0
            r7 = r0
            goto L_0x002a
        L_0x0029:
            r7 = r0
        L_0x002a:
            if (r3 != 0) goto L_0x0042
            okhttp3.internal.Internal r0 = okhttp3.internal.Internal.instance     // Catch:{ all -> 0x0142 }
            okhttp3.ConnectionPool r8 = r1.connectionPool     // Catch:{ all -> 0x0142 }
            okhttp3.Address r9 = r1.address     // Catch:{ all -> 0x0142 }
            r10 = 0
            r0.get(r8, r9, r1, r10)     // Catch:{ all -> 0x0142 }
            okhttp3.internal.connection.RealConnection r0 = r1.connection     // Catch:{ all -> 0x0142 }
            if (r0 == 0) goto L_0x003f
            r2 = 1
            okhttp3.internal.connection.RealConnection r0 = r1.connection     // Catch:{ all -> 0x0142 }
            r3 = r0
            goto L_0x0042
        L_0x003f:
            okhttp3.Route r0 = r1.route     // Catch:{ all -> 0x0142 }
            r4 = r0
        L_0x0042:
            monitor-exit(r5)     // Catch:{ all -> 0x0142 }
            okhttp3.internal.Util.closeQuietly(r6)
            if (r7 == 0) goto L_0x004f
            okhttp3.EventListener r0 = r1.eventListener
            okhttp3.Call r5 = r1.call
            r0.connectionReleased(r5, r7)
        L_0x004f:
            if (r2 == 0) goto L_0x0058
            okhttp3.EventListener r0 = r1.eventListener
            okhttp3.Call r5 = r1.call
            r0.connectionAcquired(r5, r3)
        L_0x0058:
            if (r3 == 0) goto L_0x005b
            return r3
        L_0x005b:
            r0 = 0
            if (r4 != 0) goto L_0x0073
            okhttp3.internal.connection.RouteSelector$Selection r5 = r1.routeSelection
            if (r5 == 0) goto L_0x0068
            boolean r5 = r5.hasNext()
            if (r5 != 0) goto L_0x0073
        L_0x0068:
            r0 = 1
            okhttp3.internal.connection.RouteSelector r5 = r1.routeSelector
            okhttp3.internal.connection.RouteSelector$Selection r5 = r5.next()
            r1.routeSelection = r5
            r8 = r0
            goto L_0x0074
        L_0x0073:
            r8 = r0
        L_0x0074:
            okhttp3.ConnectionPool r9 = r1.connectionPool
            monitor-enter(r9)
            boolean r0 = r1.canceled     // Catch:{ all -> 0x0127 }
            if (r0 != 0) goto L_0x011f
            if (r8 == 0) goto L_0x00a7
            okhttp3.internal.connection.RouteSelector$Selection r0 = r1.routeSelection     // Catch:{ all -> 0x0127 }
            java.util.List r0 = r0.getAll()     // Catch:{ all -> 0x0127 }
            r5 = 0
            int r10 = r0.size()     // Catch:{ all -> 0x0127 }
        L_0x0088:
            if (r5 >= r10) goto L_0x00a7
            java.lang.Object r11 = r0.get(r5)     // Catch:{ all -> 0x0127 }
            okhttp3.Route r11 = (okhttp3.Route) r11     // Catch:{ all -> 0x0127 }
            okhttp3.internal.Internal r12 = okhttp3.internal.Internal.instance     // Catch:{ all -> 0x0127 }
            okhttp3.ConnectionPool r13 = r1.connectionPool     // Catch:{ all -> 0x0127 }
            okhttp3.Address r14 = r1.address     // Catch:{ all -> 0x0127 }
            r12.get(r13, r14, r1, r11)     // Catch:{ all -> 0x0127 }
            okhttp3.internal.connection.RealConnection r12 = r1.connection     // Catch:{ all -> 0x0127 }
            if (r12 == 0) goto L_0x00a4
            r2 = 1
            okhttp3.internal.connection.RealConnection r12 = r1.connection     // Catch:{ all -> 0x0127 }
            r3 = r12
            r1.route = r11     // Catch:{ all -> 0x0127 }
            goto L_0x00a7
        L_0x00a4:
            int r5 = r5 + 1
            goto L_0x0088
        L_0x00a7:
            if (r2 != 0) goto L_0x00c2
            if (r4 != 0) goto L_0x00b2
            okhttp3.internal.connection.RouteSelector$Selection r0 = r1.routeSelection     // Catch:{ all -> 0x0127 }
            okhttp3.Route r0 = r0.next()     // Catch:{ all -> 0x0127 }
            r4 = r0
        L_0x00b2:
            r1.route = r4     // Catch:{ all -> 0x0127 }
            r0 = 0
            r1.refusedStreamCount = r0     // Catch:{ all -> 0x0127 }
            okhttp3.internal.connection.RealConnection r5 = new okhttp3.internal.connection.RealConnection     // Catch:{ all -> 0x0127 }
            okhttp3.ConnectionPool r10 = r1.connectionPool     // Catch:{ all -> 0x0127 }
            r5.<init>(r10, r4)     // Catch:{ all -> 0x0127 }
            r3 = r5
            r1.acquire(r3, r0)     // Catch:{ all -> 0x0127 }
        L_0x00c2:
            monitor-exit(r9)     // Catch:{ all -> 0x0127 }
            if (r2 == 0) goto L_0x00cd
            okhttp3.EventListener r0 = r1.eventListener
            okhttp3.Call r5 = r1.call
            r0.connectionAcquired(r5, r3)
            return r3
        L_0x00cd:
            okhttp3.Call r0 = r1.call
            okhttp3.EventListener r5 = r1.eventListener
            r10 = r3
            r11 = r19
            r12 = r20
            r13 = r21
            r14 = r22
            r15 = r23
            r16 = r0
            r17 = r5
            r10.connect(r11, r12, r13, r14, r15, r16, r17)
            okhttp3.internal.connection.RouteDatabase r0 = r18.routeDatabase()
            okhttp3.Route r5 = r3.route()
            r0.connected(r5)
            r5 = 0
            okhttp3.ConnectionPool r10 = r1.connectionPool
            monitor-enter(r10)
            r0 = 1
            r1.reportedAcquired = r0     // Catch:{ all -> 0x011c }
            okhttp3.internal.Internal r0 = okhttp3.internal.Internal.instance     // Catch:{ all -> 0x011c }
            okhttp3.ConnectionPool r9 = r1.connectionPool     // Catch:{ all -> 0x011c }
            r0.put(r9, r3)     // Catch:{ all -> 0x011c }
            boolean r0 = r3.isMultiplexed()     // Catch:{ all -> 0x011c }
            if (r0 == 0) goto L_0x0110
            okhttp3.internal.Internal r0 = okhttp3.internal.Internal.instance     // Catch:{ all -> 0x011c }
            okhttp3.ConnectionPool r9 = r1.connectionPool     // Catch:{ all -> 0x011c }
            okhttp3.Address r11 = r1.address     // Catch:{ all -> 0x011c }
            java.net.Socket r0 = r0.deduplicate(r9, r11, r1)     // Catch:{ all -> 0x011c }
            r5 = r0
            okhttp3.internal.connection.RealConnection r0 = r1.connection     // Catch:{ all -> 0x011c }
            r3 = r0
        L_0x0110:
            monitor-exit(r10)     // Catch:{ all -> 0x011c }
            okhttp3.internal.Util.closeQuietly(r5)
            okhttp3.EventListener r0 = r1.eventListener
            okhttp3.Call r9 = r1.call
            r0.connectionAcquired(r9, r3)
            return r3
        L_0x011c:
            r0 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x011c }
            throw r0
        L_0x011f:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0127 }
            java.lang.String r5 = "Canceled"
            r0.<init>(r5)     // Catch:{ all -> 0x0127 }
            throw r0     // Catch:{ all -> 0x0127 }
        L_0x0127:
            r0 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x0127 }
            throw r0
        L_0x012a:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0142 }
            java.lang.String r6 = "Canceled"
            r0.<init>(r6)     // Catch:{ all -> 0x0142 }
            throw r0     // Catch:{ all -> 0x0142 }
        L_0x0132:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0142 }
            java.lang.String r6 = "codec != null"
            r0.<init>(r6)     // Catch:{ all -> 0x0142 }
            throw r0     // Catch:{ all -> 0x0142 }
        L_0x013a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0142 }
            java.lang.String r6 = "released"
            r0.<init>(r6)     // Catch:{ all -> 0x0142 }
            throw r0     // Catch:{ all -> 0x0142 }
        L_0x0142:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0142 }
            goto L_0x0146
        L_0x0145:
            throw r0
        L_0x0146:
            goto L_0x0145
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.StreamAllocation.findConnection(int, int, int, int, boolean):okhttp3.internal.connection.RealConnection");
    }

    private Socket releaseIfNoNewStreams() {
        RealConnection allocatedConnection = this.connection;
        if (allocatedConnection == null || !allocatedConnection.noNewStreams) {
            return null;
        }
        return deallocate(false, false, true);
    }

    public void streamFinished(boolean noNewStreams, HttpCodec codec2, long bytesRead, IOException e) {
        Connection releasedConnection;
        Socket socket;
        boolean callEnd;
        this.eventListener.responseBodyEnd(this.call, bytesRead);
        synchronized (this.connectionPool) {
            if (codec2 != null) {
                if (codec2 == this.codec) {
                    if (!noNewStreams) {
                        this.connection.successCount++;
                    }
                    releasedConnection = this.connection;
                    socket = deallocate(noNewStreams, false, true);
                    if (this.connection != null) {
                        releasedConnection = null;
                    }
                    callEnd = this.released;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("expected ");
            sb.append(this.codec);
            sb.append(" but was ");
            sb.append(codec2);
            throw new IllegalStateException(sb.toString());
        }
        Util.closeQuietly(socket);
        if (releasedConnection != null) {
            this.eventListener.connectionReleased(this.call, releasedConnection);
        }
        if (e != null) {
            this.eventListener.callFailed(this.call, e);
        } else if (callEnd) {
            this.eventListener.callEnd(this.call);
        }
    }

    public HttpCodec codec() {
        HttpCodec httpCodec;
        synchronized (this.connectionPool) {
            httpCodec = this.codec;
        }
        return httpCodec;
    }

    private RouteDatabase routeDatabase() {
        return Internal.instance.routeDatabase(this.connectionPool);
    }

    public Route route() {
        return this.route;
    }

    public synchronized RealConnection connection() {
        return this.connection;
    }

    public void release() {
        Connection releasedConnection;
        Socket socket;
        synchronized (this.connectionPool) {
            releasedConnection = this.connection;
            socket = deallocate(false, true, false);
            if (this.connection != null) {
                releasedConnection = null;
            }
        }
        Util.closeQuietly(socket);
        if (releasedConnection != null) {
            this.eventListener.connectionReleased(this.call, releasedConnection);
        }
    }

    public void noNewStreams() {
        Connection releasedConnection;
        Socket socket;
        synchronized (this.connectionPool) {
            releasedConnection = this.connection;
            socket = deallocate(true, false, false);
            if (this.connection != null) {
                releasedConnection = null;
            }
        }
        Util.closeQuietly(socket);
        if (releasedConnection != null) {
            this.eventListener.connectionReleased(this.call, releasedConnection);
        }
    }

    private Socket deallocate(boolean noNewStreams, boolean released2, boolean streamFinished) {
        if (streamFinished) {
            this.codec = null;
        }
        if (released2) {
            this.released = true;
        }
        Socket socket = null;
        RealConnection realConnection = this.connection;
        if (realConnection != null) {
            if (noNewStreams) {
                realConnection.noNewStreams = true;
            }
            if (this.codec == null && (this.released || this.connection.noNewStreams)) {
                release(this.connection);
                if (this.connection.allocations.isEmpty()) {
                    this.connection.idleAtNanos = System.nanoTime();
                    if (Internal.instance.connectionBecameIdle(this.connectionPool, this.connection)) {
                        socket = this.connection.socket();
                    }
                }
                this.connection = null;
            }
        }
        return socket;
    }

    public void cancel() {
        HttpCodec codecToCancel;
        RealConnection connectionToCancel;
        synchronized (this.connectionPool) {
            this.canceled = true;
            codecToCancel = this.codec;
            connectionToCancel = this.connection;
        }
        if (codecToCancel != null) {
            codecToCancel.cancel();
        } else if (connectionToCancel != null) {
            connectionToCancel.cancel();
        }
    }

    public void streamFailed(IOException e) {
        Connection releasedConnection;
        Socket socket;
        boolean noNewStreams = false;
        synchronized (this.connectionPool) {
            if (e instanceof StreamResetException) {
                StreamResetException streamResetException = (StreamResetException) e;
                if (streamResetException.errorCode == ErrorCode.REFUSED_STREAM) {
                    this.refusedStreamCount++;
                }
                if (streamResetException.errorCode != ErrorCode.REFUSED_STREAM || this.refusedStreamCount > 1) {
                    noNewStreams = true;
                    this.route = null;
                }
            } else if (this.connection != null) {
                if (!this.connection.isMultiplexed() || (e instanceof ConnectionShutdownException)) {
                    noNewStreams = true;
                    if (this.connection.successCount == 0) {
                        if (!(this.route == null || e == null)) {
                            this.routeSelector.connectFailed(this.route, e);
                        }
                        this.route = null;
                    }
                }
                releasedConnection = this.connection;
                socket = deallocate(noNewStreams, false, true);
                if (this.connection != null || !this.reportedAcquired) {
                    releasedConnection = null;
                }
            }
            releasedConnection = this.connection;
            socket = deallocate(noNewStreams, false, true);
            releasedConnection = null;
        }
        Util.closeQuietly(socket);
        if (releasedConnection != null) {
            this.eventListener.connectionReleased(this.call, releasedConnection);
        }
    }

    public void acquire(RealConnection connection2, boolean reportedAcquired2) {
        if (this.connection == null) {
            this.connection = connection2;
            this.reportedAcquired = reportedAcquired2;
            connection2.allocations.add(new StreamAllocationReference(this, this.callStackTrace));
            return;
        }
        throw new IllegalStateException();
    }

    private void release(RealConnection connection2) {
        int size = connection2.allocations.size();
        for (int i = 0; i < size; i++) {
            if (((Reference) connection2.allocations.get(i)).get() == this) {
                connection2.allocations.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }

    public Socket releaseAndAcquire(RealConnection newConnection) {
        if (this.codec == null && this.connection.allocations.size() == 1) {
            Reference<StreamAllocation> onlyAllocation = (Reference) this.connection.allocations.get(0);
            Socket socket = deallocate(true, false, false);
            this.connection = newConnection;
            newConnection.allocations.add(onlyAllocation);
            return socket;
        }
        throw new IllegalStateException();
    }

    public boolean hasMoreRoutes() {
        if (this.route == null) {
            Selection selection = this.routeSelection;
            if ((selection == null || !selection.hasNext()) && !this.routeSelector.hasNext()) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        RealConnection connection2 = connection();
        return connection2 != null ? connection2.toString() : this.address.toString();
    }
}
