package hudson.model;

/**
 * Action attached to a {@link Label} to mark it as a Label for executor which will only
 * be used for one build, then immediately shut down. Typical usage is for container executors
 * that will be dedicated to a build and should always start from a clean state.
 *
 * @author <a href="mailto:nicolas.deloof@gmail.com">Nicolas De Loof</a>
 */
public class OneShotExecutor extends InvisibleAction {
}
