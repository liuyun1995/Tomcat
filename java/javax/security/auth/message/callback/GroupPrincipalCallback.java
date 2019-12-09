package javax.security.auth.message.callback;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;

/**
 * Callback that enables an authentication module to inform the runtime of the
 * groups a user is in.
 */
public class GroupPrincipalCallback implements Callback {

    private final Subject subject;
    private final String[] groups;

    public GroupPrincipalCallback(Subject subject, String[] groups) {
        this.subject = subject;
        this.groups = groups;
    }

    public Subject getSubject() {
        return subject;
    }

    public String[] getGroups() {
        return groups;
    }
}
