package p1xel.antijoin;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.server.ServerListPingEvent;

public class Listener implements org.bukkit.event.Listener {

    @EventHandler
    public void onJoin(PlayerLoginEvent e) {

        Player p = e.getPlayer();

        if (!AntiJoin.isAntiJoin) {
            return;
        }

        if (p.isOp()) {
            return;
        }

        if (p.hasPermission("antijoin.bypass")) {
            return;
        }

        e.setResult(PlayerLoginEvent.Result.KICK_OTHER);
        e.setKickMessage(Config.getMessage("messages.anti-join"));

    }

    @EventHandler
    public void onWTF(ServerListPingEvent e) {

        if (AntiJoin.isAntiJoin) {

            if (Config.getBool("motd.enable")) {

                e.setMotd(Config.getMessage("motd.line1") + "\n" + Config.getMessage("motd.line2"));

            }

        }

    }

}
