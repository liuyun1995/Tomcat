package org.apache.coyote.http2;

/**
 * Represents the remote connection settings: i.e. the settings the server must
 * use when communicating with the client.
 */
class ConnectionSettingsRemote extends ConnectionSettingsBase<ConnectionException> {

    private static final String ENDPOINT_NAME = "Remote(server->client)";

    ConnectionSettingsRemote(String connectionId) {
        super(connectionId);
    }


    @Override
    final void throwException(String msg, Http2Error error) throws ConnectionException {
        throw new ConnectionException(msg, error);
    }


    @Override
    final String getEndpointName() {
        return ENDPOINT_NAME;
    }
}
