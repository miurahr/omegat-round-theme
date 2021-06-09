/**************************************************************************
 OmegaT - Computer Assisted Translation (CAT) tool
          with fuzzy matching, translation memory, keyword search,
          glossaries, and translation leveraging into updated projects.

 Copyright (C) 2021 Hiroshi Miura
               Home page: http://www.omegat.org/

 This file is part of OmegaT.

 OmegaT is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 OmegaT is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>.
 **************************************************************************/
package tokyo.northside.omegat.theme;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Insets;

public class FlatRoundDarkLaf extends FlatDarkLaf {
    private static final String NAME = "Flat round dark theme";
    private static final String ID = "FlatRoundDarkTheme";
    private static final String DESCRIPTION = "Rounded theme customized from FlatDarkLaf";

    public FlatRoundDarkLaf() {
        super();
    }

    @Override
	public UIDefaults getDefaults() {
		UIDefaults defaults = super.getDefaults();

        Color standardBgColor = defaults.getColor("Panel.background");
        defaults.put("TextPane.background", standardBgColor);
        Color borderColor = defaults.getColor("Panel.borderColor");

        defaults.put("OmegaTBorder.color", borderColor);
        Color statusAreaColor = Utils.adjustRGB(standardBgColor, 0x57 - 0xEE);
        Color activeTitleBgColor = Utils.adjustRGB(standardBgColor, 0xF6 - 0xEE);
        defaults.put("VLDocking.highlight", activeTitleBgColor);
        defaults.put("VLDocking.shadow", statusAreaColor);

        // Main window main area
        int outside = 5;
        defaults.put("DockingDesktop.border", new EmptyBorder(outside, outside, outside, outside));

        // Docked, visible panels get two borders if we're not careful:
        // Drawn by VLDocking. Surrounds panel content AND header. Set this to empty margin instead.
        int panel = 2;
        defaults.put("DockView.singleDockableBorder", new EmptyBorder(panel, panel, panel, panel));
        int maxPanel = outside + panel;
        defaults.put("DockView.maximizedDockableBorder", new EmptyBorder(maxPanel, maxPanel, maxPanel, maxPanel));

        // OmegaT-defined Dockables.
        defaults.put("OmegaTDockablePanel.border", new MatteBorder(1, 1, 1, 1, borderColor));
        defaults.put("OmegaTDockablePanelViewport.border", new EmptyBorder(0, 0, 0, 0));
        defaults.put("OmegaTDockablePanel.isProportionalMargins", true);

        // Tabbed docked, visible panels are surrounded by LAF-specific chrome, but the surrounding
        // colors don't appear to be available through the API. These values are from visual inspection.
        if (Utils.isMacOSX()) {
            defaults.put("DockView.tabbedDockableBorder", new MatteBorder(0, 5, 5, 5, new Color(0xE6E6E6)));
        } else if (Utils.isWindows()) {
            defaults.put("DockView.tabbedDockableBorder", new MatteBorder(2, 5, 5, 5, Color.GRAY));
            defaults.put( "TitlePane.unifiedBackground", true );
        } else {
            defaults.put("DockView.tabbedDockableBorder", new MatteBorder(5, 5, 5, 5, standardBgColor));
        }

        int cornerRadius = 0;

        // Panel title bars
        Color activeTitleText = defaults.getColor("Label.foreground");
        Color inactiveTitleText = new Color(0x808080);

        defaults.put("DockViewTitleBar.border",
                new RoundedCornerBorder(cornerRadius, borderColor, org.omegat.util.gui.RoundedCornerBorder.SIDE_TOP));
        defaults.put("InternalFrame.activeTitleForeground", activeTitleText);
        defaults.put("InternalFrame.activeTitleBackground", activeTitleBgColor);
        defaults.put("InternalFrame.inactiveTitleForeground", inactiveTitleText);
        defaults.put("InternalFrame.inactiveTitleBackground", standardBgColor);

        // Disable gradient on pane title bars
        defaults.put("DockViewTitleBar.disableCustomPaint", true);

        // AutoHideButtonPanel is where minimized panel tabs go. Use compound border to give left/right margins.
        defaults.put("AutoHideButtonPanel.bottomBorder", new CompoundBorder(
                new MatteBorder(1, 0, 0, 0, borderColor),
                new EmptyBorder(0, 2 * outside, 0, 2 * outside)));
        //defaults.put("AutoHideButtonPanel.background", bottomAreaBgColor);
        defaults.put("AutoHideButton.expandBorderBottom",
                new org.omegat.util.gui.RoundedCornerBorder(cornerRadius, borderColor, org.omegat.util.gui.RoundedCornerBorder.SIDE_BOTTOM));
        defaults.put("AutoHideButton.background", standardBgColor);
        // OmegaT-defined status box in lower right
        defaults.put("OmegaTStatusArea.border", new MatteBorder(1, 1, 1, 1, statusAreaColor));
        // Lowermost section margins
        defaults.put("OmegaTMainWindowBottomMargin.border", new EmptyBorder(0, 2 * outside, outside, 2 * outside));

        defaults.put("OmegaTEditorFilter.border", new MatteBorder(1, 1, 0, 1, borderColor));

        // Undocked panel
        defaults.put("activeCaption", Color.GRAY);
        defaults.put("activeCaptionBorder", borderColor);
        defaults.put("inactiveCaption", standardBgColor);
        defaults.put("inactiveCaptionBorder", borderColor);

        // Icons
        defaults.put("DockViewTitleBar.maximize", Utils.getIcon("appbar.app.tall.inactive.png"));
        defaults.put("DockViewTitleBar.maximize.rollover", Utils.getIcon("appbar.app.tall.png"));
        defaults.put("DockViewTitleBar.maximize.pressed", Utils.getIcon("appbar.app.tall.pressed.png"));
        defaults.put("DockViewTitleBar.restore", Utils.getIcon("appbar.window.restore.inactive.png"));
        defaults.put("DockViewTitleBar.restore.rollover", Utils.getIcon("appbar.window.restore.png"));
        defaults.put("DockViewTitleBar.restore.pressed", Utils.getIcon("appbar.window.restore.pressed.png"));
        defaults.put("DockViewTitleBar.hide", Utils.getIcon("appbar.hide.inactive.png"));
        defaults.put("DockViewTitleBar.hide.rollover", Utils.getIcon("appbar.hide.png"));
        defaults.put("DockViewTitleBar.hide.pressed", Utils.getIcon("appbar.hide.pressed.png"));
        defaults.put("DockViewTitleBar.float", Utils.getIcon("appbar.fullscreen.inactive.png"));
        defaults.put("DockViewTitleBar.float.rollover", Utils.getIcon("appbar.fullscreen.png"));
        defaults.put("DockViewTitleBar.float.pressed", Utils.getIcon("appbar.fullscreen.pressed.png"));
        defaults.put("DockViewTitleBar.dock", Utils.getIcon("appbar.window.restore.inactive.png"));
        defaults.put("DockViewTitleBar.dock.rollover", Utils.getIcon("appbar.window.restore.png"));
        defaults.put("DockViewTitleBar.dock.pressed", Utils.getIcon("appbar.window.restore.pressed.png"));
        defaults.put("DockViewTitleBar.attach", Utils.getIcon("appbar.dock.window.inactive.png"));
        defaults.put("DockViewTitleBar.attach.rollover", Utils.getIcon("appbar.dock.window.png"));
        defaults.put("DockViewTitleBar.attach.pressed", Utils.getIcon("appbar.dock.window.pressed.png"));

        defaults.put("DockViewTitleBar.menu.hide", Utils.getIcon("appbar.hide.png"));
        defaults.put("DockViewTitleBar.menu.maximize", Utils.getIcon("appbar.app.tall.png"));
        defaults.put("DockViewTitleBar.menu.restore", Utils.getIcon("appbar.window.restore.png"));
        defaults.put("DockViewTitleBar.menu.dock", Utils.getIcon("appbar.window.restore.png"));
        defaults.put("DockViewTitleBar.menu.float", Utils.getIcon("appbar.fullscreen.png"));
        defaults.put("DockViewTitleBar.menu.attach", Utils.getIcon("appbar.dock.window.png"));

        defaults.put("DockTabbedPane.menu.hide", Utils.getIcon("appbar.hide.png"));
        defaults.put("DockTabbedPane.menu.maximize", Utils.getIcon("appbar.app.tall.png"));
        defaults.put("DockTabbedPane.menu.float", Utils.getIcon("appbar.fullscreen.png"));

        // Standard components customize
        defaults.put( "Component.arrowType", "triangle" );
        defaults.put( "Button.arc", 999 );
        defaults.put( "Component.arc", 999 );
        defaults.put( "CheckBox.arc", 999 );
        defaults.put( "ProgressBar.arc", 999 );
        defaults.put( "TextComponent.arc", 999 );
        defaults.put( "ScrollBar.trackArc", 999 );
        defaults.put( "ScrollBar.thumbArc", 999 );
        defaults.put( "ScrollBar.trackInsets", new Insets( 2, 4, 2, 4 ) );
        defaults.put( "ScrollBar.thumbInsets", new Insets( 2, 2, 2, 2 ) );
        defaults.put( "ScrollBar.track", new Color( 0xe0e0e0 ) );
        defaults.put( "TabbedPane.tabSeparatorsFullHeight", true );
        defaults.put( "TabbedPane.selectedBackground", Color.GRAY );

        return defaults;
    }

  	/**
	 * Adds this look and feel to the set of available look and feels.
	 * <p>
	 * Useful if your application uses {@link UIManager#getInstalledLookAndFeels()}
	 * to query available LaFs and display them to the user in a combobox.
	 */
	public static void installLafInfo() {
		installLafInfo( NAME, FlatRoundDarkLaf.class );
	}

    @Override
    public String getID() {
        return ID;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}

