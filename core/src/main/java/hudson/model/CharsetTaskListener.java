package hudson.model;

import java.nio.charset.Charset;

/**
 * A {@link TaskListener} that can tell the {@link Charset} it uses to store logs.
 */
public interface CharsetTaskListener extends TaskListener {

    Charset getCharset();
}
