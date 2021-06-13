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

import com.formdev.flatlaf.FlatLightLaf;
import org.omegat.gui.theme.DefaultFlatTheme;

import java.awt.Color;
import java.awt.Insets;

import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;


@SuppressWarnings("unused")
public class FlatRoundLightLaf extends FlatLightLaf {
    private static final String NAME = "Flat round light theme";
    private static final String ID = "FlatRoundLightTheme";
    private static final String DESCRIPTION = "Rounded theme customized from FlatLightLaf";

    public FlatRoundLightLaf() {
        super();
    }

    @Override
    public UIDefaults getDefaults() {
        UIDefaults defaults = super.getDefaults();
        defaults = DefaultFlatTheme.setDefaults(defaults, ID);

        Color standardBgColor = defaults.getColor("Panel.background");
        defaults.put("TextPane.background", Color.WHITE);

        // Borders
        Color borderColor = new Color(0x0f5e9c);
        defaults.put("OmegaTBorder.color", borderColor);
        defaults.put("OmegaTDockablePanel.border", new MatteBorder(1, 1, 1, 1, borderColor));
        // FIXME: VLDocking values have to be set to the "developer defaults"
        // not the "LAF defaults" because that's where
        // DockingUISettings#installUI puts them
        UIManager.put("DockViewTitleBar.border", new MatteBorder(1, 1, 1, 1, borderColor));

        // OmegaT-defined Dockables.
        defaults.put("OmegaTDockablePanel.border", new MatteBorder(1, 1, 1, 1, borderColor));
        defaults.put("OmegaTDockablePanel.isProportionalMargins", true);

        int cornerRadius = 0;

        // Panel title bars
        Color activeTitleText = defaults.getColor("Label.foreground");
        Color activeTitleBgColor = Utils.adjustRGB(standardBgColor, 0xF6 - 0xEE);
        Color inactiveTitleText = new Color(0x808080);
        defaults.put("InternalFrame.activeTitleForeground", activeTitleText);
        defaults.put("InternalFrame.activeTitleBackground", activeTitleBgColor);
        defaults.put("InternalFrame.inactiveTitleForeground", inactiveTitleText);
        defaults.put("InternalFrame.inactiveTitleBackground", standardBgColor);

        // Undocked panel
        defaults.put("activeCaption", Color.WHITE);
        defaults.put("activeCaptionBorder", borderColor);
        defaults.put("inactiveCaption", standardBgColor);
        defaults.put("inactiveCaptionBorder", borderColor);

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
        defaults.put( "TabbedPane.selectedBackground", Color.white );

        return defaults;
    }

    /**
     * Adds this look and feel to the set of available look and feels.
     */
    public static void installLafInfo() {
        installLafInfo( NAME, FlatRoundLightLaf.class );
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