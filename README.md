# 🌱 Plants Plugin

A simple **Minecraft Paper Plugin** that allows players to interact with crops using specific tools, automatically replanting them.

## 📜 Features
- Harvest the crop without breaking it! Just right-click on the crop and harvest it!
- Supports harvesting within a 3x3 radius of the crop that the player clicked on using items that can be configured in the config (There you can set custommodeldata for their work)
- To reload the config, just write /plants reload.
- You can make it so that only players who have a special right can harvest crops with this mechanic!

## ⚙️ Configuration (`config.yml`)
🔹 Default configuration:

```yaml
custom-model-data: 500 

items-list:
  - IRON_AXE

permission-enable: false
no-access-message: "&aYou dont have access to this action!"
```

🔹 Config Options:
- `custom-model-data:` Sets the Custom Model Data value for allowed tools.
- `items-list:` List of allowed tools that can be used for harvesting 3x3.
- `permission-enable:` Enables/disables permission check (plants.interact).
- `no-access-message:` Message displayed if a player lacks permission.

## 📚 Other information

### 🛠 Commands
| Command | Permission | Description |
|----------------|:---------:|----------------:|
| /plants reload | plants.reload | It simply reloads the plugin config. |

### 🔑 Permissions

| Permission | Description |
|----------------|:---------:|
| plants.reload | For /plants reload command. |
| plants.interact | Responsible for whether the player can harvest crops by right-clicking. (Only if `permission-enable` in the config is true) |

### 🗂️ Versions

| Plugin Version | Version | Download |
|----------------|:---------:|----------------:|
| 1.1 | 1.21.4 | [Download v1.1](https://github.com/OluniOfficial/Plants/releases/download/v1.1/Plants-1.1.jar) |
