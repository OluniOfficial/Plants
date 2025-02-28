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

### ❓ How does the plugin work?

Below you can see an example of how the plugin works with the default config.

#### A simple right-click on a crop.

![Alt Text](https://media.giphy.com/media/v1.Y2lkPTc5MGI3NjExYXZ3d2Q1cjg3Z3QzNmdxY3lpYW5kMHExa2s4bDl0bGc1NTNvMGE2eCZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/C4QkpZTY7W1JF1Wi7v/giphy.gif)

#### With a special item (WITHOUT CUSTOMMODELDATA).

![Alt Text](https://media2.giphy.com/media/v1.Y2lkPTc5MGI3NjExYXZ3d2Q1cjg3Z3QzNmdxY3lpYW5kMHExa2s4bDl0bGc1NTNvMGE2eCZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/C4QkpZTY7W1JF1Wi7v/giphy.gif)

#### With a special item (CustomModelData).

![Alt Text](https://media1.giphy.com/media/v1.Y2lkPTc5MGI3NjExYXZtaHBzMHBlMzI4MzNpYTR3ZnM2ZnZvcHpidXF0YzFiYzVpN3hxbSZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/Me7yLLwUuVWNmSxROB/giphy.gif)
