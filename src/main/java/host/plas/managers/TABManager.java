package host.plas.managers;

import host.plas.TABSL;
import me.neznamy.tab.api.TabAPI;
import me.neznamy.tab.api.TabPlayer;
import me.neznamy.tab.api.event.EventBus;
import me.neznamy.tab.api.event.player.PlayerLoadEvent;
import net.streamline.api.modules.ModuleUtils;
import net.streamline.api.placeholders.RATRegistry;

public class TABManager {
    public static TabAPI getApi() {
        return TabAPI.getInstance();
    }

    public static void init() {
        EventBus eventBus = getApi().getEventBus();
        if (eventBus != null) {
            eventBus.register(PlayerLoadEvent.class, event -> {
                TabPlayer player = event.getPlayer();
                // do something
            });
        }

        RATRegistry.getReplacements().forEach((identifier, replaceable) -> {
            try {
                String fin = ensureIsPlaceholderableString(identifier);
                getApi().getPlaceholderManager().registerPlayerPlaceholder(fin,
                        50 * 5, (player) -> ModuleUtils.replaceAllPlayerBungee(player.getUniqueId().toString(), fin));
            } catch (Exception e) {
                TABSL.getInstance().logWarning("Could not register placeholder " + identifier + " due to: " + e.getMessage());
            }
        });
    }

    public static String ensureIsPlaceholderableString(String string) {
        String fin = string.replace("][", "");
        if (fin.startsWith("[")) {
            fin = fin.substring(1);
        }
        if (fin.endsWith("]")) {
            fin = fin.substring(0, fin.length() - 1);
        }
        if (! fin.startsWith("%")) {
            fin = "%" + fin;
        }
        if (! fin.endsWith("%")) {
            fin = fin + "%";
        }

        return fin;
    }
}
