package org.apache.catalina.ant;

import org.apache.tools.ant.BuildException;

/**
 * Ant task that implements the <code>/undeploy</code> command, supported by
 * the Tomcat manager application.
 *
 * @author Craig R. McClanahan
 * @since 4.1
 */
public class UndeployTask extends AbstractCatalinaCommandTask {

    /**
     * Execute the requested operation.
     *
     * @throws BuildException if an error occurs
     */
    @Override
    public void execute() throws BuildException {

        super.execute();
        execute(createQueryString("/undeploy").toString());

    }


}
