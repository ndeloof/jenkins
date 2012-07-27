package hudson.model;

import hudson.Extension;
import hudson.Functions;

import java.util.Map;

/**
 * Default User.CannonicalIdResolver to escape unsupported characters and generate user ID.
 * Compared to other implementations, this resolver will always return an ID
 *
 * @author: <a hef="mailto:nicolas.deloof@gmail.com">Nicolas De Loof</a>
*/
@Extension
public class DefaultIdResolver extends User.CannonicalIdResolver {

    @Override
    public String resolveCannonicalId(String idOrFullName, Map context) {
        String id = idOrFullName.replace('\\', '_').replace('/', '_').replace('<','_')
                .replace('>', '_');  // 4 replace() still faster than regex
        if (Functions.isWindows()) id = id.replace(':','_');
        return id;
    }

    @Override
    public int getPriority() {
        return Integer.MIN_VALUE;
    }

    @Override
    public Descriptor<User.CannonicalIdResolver> getDescriptor() {
        return DESCRIPTOR;
    }

    public static final Descriptor<User.CannonicalIdResolver> DESCRIPTOR = new Descriptor<User.CannonicalIdResolver>() {
        public String getDisplayName() {
            return "compute default user ID";
        }
    };

}
