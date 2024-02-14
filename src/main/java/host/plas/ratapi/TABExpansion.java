package host.plas.ratapi;

import host.plas.managers.TABManager;
import net.streamline.api.placeholders.expansions.RATExpansion;
import net.streamline.api.placeholders.replaceables.IdentifiedReplaceable;
import net.streamline.api.placeholders.replaceables.IdentifiedUserReplaceable;
import tv.quaint.utils.MatcherUtils;

public class TABExpansion extends RATExpansion {
    public TABExpansion() {
        super(
                new RATExpansionBuilder(
                        "tab"
                )
        );
    }

    @Override
    public void init() {

    }
}
