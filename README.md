# OmegaT round theme plugin

This is OmegaT plugin to provide additional theme settings for OmegaT 5.6.0 and later.

## Themes

### Flat Rounded Dark theme

Flat theme that buttons and bullets are rounded, and dark coloring

### Flat Rounded Light theme

Flat theme that buttons and bullets are rounded, and light coloring.

## Developer note

### OmegaT defaults

Theme plugins can get OmegaT defaults through `DefaultFlatTheme#setDefaults` or
`DefaultClassicTheme#setDefaults`, then customize and override it by following way.

```java
public UIDefaults getDefaults(){
        UIDefaults defaults=super.getDefaults();
        // get OmegaT defaults
        defaults=DefaultFlatTheme.setDefaults(defaults);
        defaults.put("OmegaTBorder.color",borderColor);
        return defaults;
}
```

### Default values of theme

Swing `UIManager` manages three "layers" of "defaults" (= sets of key-value settings). From the Javadoc:

1. Developer defaults. With few exceptions Swing does not alter the developer defaults; these are intended to be modified and used by the developer.
2. Look and feel defaults. The look and feel defaults are supplied by the look and feel at the time it is installed as the current look and feel (setLookAndFeel() is invoked). The look and feel defaults can be obtained using the getLookAndFeelDefaults() method.
3. Sytem defaults. The system defaults are provided by Swing.
   
In `setDefaults` implementation we can only set values on layer 2 (LAF defaults).
However VLDocking's installUI puts all of its settings into layer 1.
We can't override the VLDocking defaults from layer 2, so we have no choice
but to put them in layer 1 via UIManager#put*.

The correct solution is to change VLDocking: it should let you install
its defaults into layer 2. But in the meantime we can work around it
by using UIManager#put* in our setDefaults method.

### When customize `Dockview`

You should use `UIManager#put` in the meantime like as follows;

```
UIManager.put("DockViewTitleBar.border", new MatteBorder(1, 1, 1, 1, borderColor));
```

## License

The plugin is distributed under GNU General Public License 3 or later.

