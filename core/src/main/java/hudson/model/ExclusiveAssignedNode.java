package hudson.model;

/**
 * This action can be attached to a ${@link hudson.model.Queue.Task} to mark it as tied to a specific
 * executor node, which can be retrieved by display name.
 * A {@link hudson.slaves.Cloud} which do manage ${@link OneShotExecutor}s should rely on this action
 * to accept matching task when node has been provisioned.
 *
 * @author <a href="mailto:nicolas.deloof@gmail.com">Nicolas De Loof</a>
 */
public class ExclusiveAssignedNode extends InvisibleAction {


    private final String displayName;

    public ExclusiveAssignedNode(String displayName) {
        this.displayName = displayName;
    }
}
