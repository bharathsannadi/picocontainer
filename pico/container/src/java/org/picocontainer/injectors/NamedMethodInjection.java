package org.picocontainer.injectors;

import org.picocontainer.ComponentAdapter;
import org.picocontainer.ComponentMonitor;
import org.picocontainer.LifecycleStrategy;
import org.picocontainer.Parameter;
import org.picocontainer.PicoCompositionException;

import java.util.Properties;

public class NamedMethodInjection extends AbstractInjectionType {

    private final String prefix;
    private final boolean optional;

    public NamedMethodInjection(String prefix) {
        this(prefix, true);
    }

    public NamedMethodInjection() {
        this("set");
    }

    public NamedMethodInjection(boolean optional) {
        this("set", optional);
    }

    public NamedMethodInjection(String prefix, boolean optional) {
        this.prefix = prefix;
        this.optional = optional;
    }

    public <T> ComponentAdapter<T> createComponentAdapter(ComponentMonitor monitor, LifecycleStrategy lifecycleStrategy, Properties componentProperties, Object key, Class<T> impl, Parameter... parameters) throws PicoCompositionException {
        return wrapLifeCycle(monitor.newInjector(new NamedMethodInjector(key, impl, parameters, monitor, prefix, optional)), lifecycleStrategy);
    }
}
