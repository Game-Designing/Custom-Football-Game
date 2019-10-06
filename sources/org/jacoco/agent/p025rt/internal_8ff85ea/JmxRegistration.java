package org.jacoco.agent.p025rt.internal_8ff85ea;

import java.lang.management.ManagementFactory;
import java.util.concurrent.Callable;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.StandardMBean;
import org.jacoco.agent.p025rt.IAgent;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.JmxRegistration */
class JmxRegistration implements Callable<Void> {
    private static final String JMX_NAME = "org.jacoco:type=Runtime";
    private final ObjectName name = new ObjectName(JMX_NAME);
    private final MBeanServer server = ManagementFactory.getPlatformMBeanServer();

    JmxRegistration(IAgent agent) throws Exception {
        this.server.registerMBean(new StandardMBean(agent, IAgent.class), this.name);
    }

    public Void call() throws Exception {
        this.server.unregisterMBean(this.name);
        return null;
    }
}
