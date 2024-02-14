package host.plas.managers;

import me.neznamy.tab.api.TabAPI;
import me.neznamy.tab.api.TabPlayer;
import me.neznamy.tab.api.event.player.PlayerLoadEvent;
import me.neznamy.tab.api.tablist.TabListFormatManager;
import net.streamline.api.modules.ModuleUtils;
import net.streamline.api.placeholders.RATRegistry;
import net.streamline.api.placeholders.callbacks.RATCallback;
import net.streamline.api.placeholders.handling.RATHandledString;
import net.streamline.api.placeholders.replaceables.AbstractReplaceable;

public class TABManager {
    public static TabAPI getApi() {
        return TabAPI.getInstance();
    }

    public static void init() {
        getApi().getEventBus().register(PlayerLoadEvent.class, event -> {
            TabPlayer player = event.getPlayer();
            // do something
        });

        RATRegistry.getReplacements().forEach((identifier, replaceable) -> {
            getApi().getPlaceholderManager().registerPlayerPlaceholder(identifier, 5, (player) -> ModuleUtils.replaceAllPlayerBungee(player.getUniqueId().toString(), identifier));
        });
    }
}
