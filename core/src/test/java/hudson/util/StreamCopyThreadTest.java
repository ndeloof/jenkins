package hudson.util;

import org.apache.tools.ant.filters.StringInputStream;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author <a href="mailto:nicolas.deloof@gmail.com">Nicolas De Loof</a>
 */
public class StreamCopyThreadTest {

    @Test
    public void testCharsetConversion() throws IOException {

        ByteArrayOutputStream ref = new ByteArrayOutputStream();
        try (OutputStreamWriter w = new OutputStreamWriter(ref, Charset.forName("Cp1252"))
        ) {
            w.write("€éèêëàç");
        }
        ref.close();
        // ref contain CP1252 encoded String

        // Here is our platform-encoded equivalent of same string
        InputStream in = new StringInputStream("€éèêëàç");

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        new StreamCopyThread("test", in, out, true, Charset.forName("Cp1252")).run();
        assertArrayEquals(ref.toByteArray(), out.toByteArray());
    }

}