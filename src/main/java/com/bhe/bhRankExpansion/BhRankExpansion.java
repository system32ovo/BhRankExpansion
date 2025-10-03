package com.bhe.bhRankExpansion;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Method;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BhRankExpansion extends PlaceholderExpansion {

    private Plugin bhRankPlugin;
    private Method getPlayerTitleMethod;
    private final Logger logger = Logger.getLogger("BHRankExpansion"); // 创建自己的Logger

    @Override
    public String onRequest(OfflinePlayer player, @NotNull String identifier) {
        // 确保已获取BHRank插件实例
        if (bhRankPlugin == null) {
            bhRankPlugin = Bukkit.getPluginManager().getPlugin("BHRank");

            if (bhRankPlugin == null) {
                logger.warning("无法找到BHRank主插件");
                return "";
            }
        }

        // 初始化反射方法
        if (getPlayerTitleMethod == null) {
            try {
                getPlayerTitleMethod = bhRankPlugin.getClass().getMethod("getPlayerTitle", UUID.class);
            } catch (Exception e) {
                logger.log(Level.SEVERE, "无法获取BHRank的getPlayerTitle方法", e);
                return "";
            }
        }

        // 只处理玩家头衔占位符
        if ("player_title".equalsIgnoreCase(identifier) && player != null) {
            return getPlayerTitle(player.getUniqueId());
        }

        return null;
    }

    private String getPlayerTitle(UUID uuid) {
        try {
            // 使用反射调用BHRank的主插件方法
            return (String) getPlayerTitleMethod.invoke(bhRankPlugin, uuid);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "获取玩家头衔失败", e);
            return "";
        }
    }

    @Override
    public @NotNull String getIdentifier() {
        return "bhrank";
    }

    @Override
    public @NotNull String getAuthor() {
        return "BlackHoleEraTeam";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0.0";
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public boolean canRegister() {
        // 确保BHRank插件存在
        return Bukkit.getPluginManager().getPlugin("BHRank") != null;
    }
}
