package hudson.model.listeners;

import hudson.Extension;
import hudson.XmlFile;
import hudson.model.Saveable;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author <a href="mailto:nicolas.deloof@gmail.com">Nicolas De Loof</a>
 */
@Extension
public class MySaveableListener extends SaveableListener {

    public static Map<String, Tuple> files = new ConcurrentHashMap<>();


    @Override
    public void onDeclared(Saveable o, XmlFile file) {
        final String path = file.getFile().getPath();
        files.put(path, new Tuple(o, file));
    }

    public static void reload(String path) throws IOException {
        final Tuple tuple = files.get(path);
        tuple.saveable.load(tuple.x);
    }

    private static class Tuple {
        Saveable  saveable;
        XmlFile x;

        public Tuple(Saveable saveable, XmlFile x) {
            this.saveable = saveable;
            this.x = x;
        }
    }
}
