package org.apache.coyote.http2;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.apache.tomcat.util.res.StringManager;

/**
 * Used to managed prioritisation.
 */
abstract class AbstractStream {

    private static final Log log = LogFactory.getLog(AbstractStream.class);
    private static final StringManager sm = StringManager.getManager(AbstractStream.class);

    private final Integer identifier;

    private volatile AbstractStream parentStream = null;
    private final Set<Stream> childStreams = Collections.newSetFromMap(new ConcurrentHashMap<>());
    private long windowSize = ConnectionSettingsBase.DEFAULT_INITIAL_WINDOW_SIZE;


    AbstractStream(Integer identifier) {
        this.identifier = identifier;
    }


    final Integer getIdentifier() {
        return identifier;
    }


    final int getIdAsInt() {
        return identifier.intValue();
    }


    final void detachFromParent() {
        if (parentStream != null) {
            parentStream.getChildStreams().remove(this);
            parentStream = null;
        }
    }


    final void addChild(Stream child) {
        child.setParentStream(this);
        childStreams.add(child);
    }


    final boolean isDescendant(AbstractStream stream) {
        // Is the passed in Stream a descendant of this Stream?
        // Start at the passed in Stream and work up
        AbstractStream parent = stream.getParentStream();
        while (parent != null && parent != this) {
            parent = parent.getParentStream();
        }
        return parent != null;
    }


    final AbstractStream getParentStream() {
        return parentStream;
    }


    final void setParentStream(AbstractStream parentStream) {
        this.parentStream = parentStream;
    }


    final Set<Stream> getChildStreams() {
        return childStreams;
    }


    final synchronized void setWindowSize(long windowSize) {
        this.windowSize = windowSize;
    }


    final synchronized long getWindowSize() {
        return windowSize;
    }


    /**
     * Increment window size.
     *
     * @param increment The amount by which the window size should be increased
     * @throws Http2Exception If the window size is now higher than
     *                        the maximum allowed
     */
    synchronized void incrementWindowSize(int increment) throws Http2Exception {
        // No need for overflow protection here.
        // Increment can't be more than Integer.MAX_VALUE and once windowSize
        // goes beyond 2^31-1 an error is triggered.
        windowSize += increment;

        if (log.isDebugEnabled()) {
            log.debug(sm.getString("abstractStream.windowSizeInc", getConnectionId(),
                    getIdentifier(), Integer.toString(increment), Long.toString(windowSize)));
        }

        if (windowSize > ConnectionSettingsBase.MAX_WINDOW_SIZE) {
            String msg = sm.getString("abstractStream.windowSizeTooBig", getConnectionId(), identifier,
                    Integer.toString(increment), Long.toString(windowSize));
            if (identifier.intValue() == 0) {
                throw new ConnectionException(msg, Http2Error.FLOW_CONTROL_ERROR);
            } else {
                throw new StreamException(
                        msg, Http2Error.FLOW_CONTROL_ERROR, identifier.intValue());
            }
        }
    }


    final synchronized void decrementWindowSize(int decrement) {
        // No need for overflow protection here. Decrement can never be larger
        // the Integer.MAX_VALUE and once windowSize goes negative no further
        // decrements are permitted
        windowSize -= decrement;
        if (log.isDebugEnabled()) {
            log.debug(sm.getString("abstractStream.windowSizeDec", getConnectionId(),
                    getIdentifier(), Integer.toString(decrement), Long.toString(windowSize)));
        }
    }


    abstract String getConnectionId();

    abstract int getWeight();
}
