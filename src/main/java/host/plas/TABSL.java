package host.plas;

import host.plas.managers.TABManager;
import host.plas.ratapi.TABExpansion;
import lombok.Getter;
import lombok.Setter;
import singularity.modules.SimpleModule;
import org.pf4j.PluginWrapper;

import java.util.List;

public class TABSL extends SimpleModule {
    @Getter @Setter
    private static TABSL instance; // This will be used to access the module instance from anywhere in the plugin.

    @Getter @Setter
    private static TABExpansion tabExpansion; // This will be used to access the expansion instance from anywhere in the plugin.

    public TABSL(PluginWrapper wrapper) {
        super(wrapper);
    }

    @Override
    public void registerCommands() {
        setCommands(List.of(
        ));
    }

    @Override
    public void onEnable() {
        instance = this; // Set the instance to this module upon enabling.

        tabExpansion = new TABExpansion(); // Initialize the expansion.

        TABManager.init(); // Initialize the TABManager.
    }
}
