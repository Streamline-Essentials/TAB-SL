package host.plas.ratapi;

import net.streamline.api.placeholders.expansions.RATExpansion;

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
