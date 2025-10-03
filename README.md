# BHRank Expansion - PlaceholderAPI 扩展

![BHRank](https://modrinth.com/plugin/bhrank)

BHRank 插件的 PlaceholderAPI 扩展，允许在其他插件中使用 BHRank 的玩家头衔数据。

## 🚀 功能特色

- 🔌 **无缝集成** - 为 BHRank 主插件提供 PlaceholderAPI 支持
- 🎯 **单一占位符** - 提供 `%bhrank_player_title%` 占位符

## 📋 前置要求

- **Minecraft 服务器**: 1.21.x
- **BHRank 主插件**
- **PlaceholderAPI**

## 🔧 安装方法

### 下载安装（推荐）
1. 确保已安装 BHRank 主插件和 PlaceholderAPI
2. 将本扩展放入 `plugins/PlaceholderAPI/expansions/` 文件夹
3. 重启服务器或执行 `/papi reload`

### 手动构建
```bash
git clone <repository-url>
cd BhRankExpansion
mvn clean package
```

## 📖 占位符列表
- %bhrank_player_title%	- 获取玩家的自定义头衔	
示例：[VIP] Playername

**关于更多占位符使用教程请前往BHRank的modrinth**
