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

import javax.swing.*;

public class FlatRoundLightLaf extends FlatDarkLaf {
    private static final String NAME = "Flat round light theme";
    private static final String ID = "FlatRoundLightTheme";
    private static final String DESCRIPTION = "Rounded theme customized from FlatLightLaf";

    public FlatRoundLightLaf() {
        super();
    }

    @Override
    public UIDefaults getDefaults() {
        UIDefaults defaults = super.getDefaults();
        defaults.put( "Component.arrowType", "triangle" );
        defaults.put( "Button.arc", 999 );
        defaults.put( "Component.arc", 999 );
        defaults.put( "ProgressBar.arc", 999 );
        defaults.put( "TextComponent.arc", 999 );
        return defaults;
    }

    /**
     * Adds this look and feel to the set of available look and feels.
     * <p>
     * Useful if your application uses {@link UIManager#getInstalledLookAndFeels()}
     * to query available LaFs and display them to the user in a combobox.
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