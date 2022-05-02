package p1xel.antijoin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.annotation.ParametersAreNonnullByDefault;

public class Cmd implements CommandExecutor {

    @Override
    @ParametersAreNonnullByDefault
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (args.length == 0) {
            if (sender.hasPermission("antijoin.use")) {
                sender.sendMessage(Config.getMessage("messages.commands.help"));
                return true;
            } else {
                sender.sendMessage(Config.getMessage("messages.no-perm"));
                return true;
            }
        }

        if (args.length == 1) {

            if (!sender.hasPermission("antijoin.use")) {
                sender.sendMessage(Config.getMessage("messages.no-perm"));
                return true;
            }

            if (args[0].equalsIgnoreCase("help")) {

                sender.sendMessage(Config.getMessage("messages.commands.top"));
                sender.sendMessage(Config.getMessage("messages.commands.help"));
                sender.sendMessage(Config.getMessage("messages.commands.toggle"));
                sender.sendMessage(Config.getMessage("messages.commands.kick"));
                sender.sendMessage(Config.getMessage("messages.commands.reload"));
                sender.sendMessage(Config.getMessage("messages.commands.bottom"));
                return true;

            }

            if (args[0].equalsIgnoreCase("toggle")) {

                if (AntiJoin.isAntiJoin) {

                    AntiJoin.isAntiJoin = false;
                    sender.sendMessage(Config.getMessage("messages.toggle-off"));
                    return true;

                } else {

                    AntiJoin.isAntiJoin = true;
                    sender.sendMessage(Config.getMessage("messages.toggle-on"));

                    if (Config.getBool("settings.kick-when-on")) {
                        for (Player p : Bukkit.getOnlinePlayers()) {
                            if (!p.isOp()) {
                                if (!p.hasPermission("antijoin.bypass")) {
                                    p.kickPlayer(Config.getMessage("messages.anti-join"));
                                }
                            }
                        }
                    }

                    return true;

                }


            }

            if (args[0].equalsIgnoreCase("kick")) {

                if (AntiJoin.isAntiJoin) {

                    for (Player p : Bukkit.getOnlinePlayers()) {
                        if (!p.isOp()) {
                            if (!p.hasPermission("antijoin.bypass")) {
                                p.kickPlayer(Config.getMessage("messages.anti-join"));
                            }
                        }
                    }
                    sender.sendMessage(Config.getMessage("messages.kick-success"));
                    return true;

                } else {

                    sender.sendMessage(Config.getMessage("messages.not-on"));
                    return true;

                }

            }

            if (args[0].equalsIgnoreCase("reload")) {

                AntiJoin.getInstance().reloadConfig();
                sender.sendMessage(Config.getMessage("messages.reload-success"));
                return true;

            }



        }














        return false;
    }


}
