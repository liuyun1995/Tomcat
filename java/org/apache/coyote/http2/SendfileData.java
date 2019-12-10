package org.apache.coyote.http2;

import java.nio.MappedByteBuffer;
import java.nio.file.Path;

class SendfileData {
    Path path;
    Stream stream;
    // Note: a mapped buffer is a special construct with an underlying file
    // that doesn't need to be closed
    MappedByteBuffer mappedBuffer;
    long left;
    int streamReservation;
    int connectionReservation;
    long pos;
    long end;
}