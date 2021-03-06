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

import javax.swing.UIManager;

/**
 * OmegaT driver module to register themes.
 */
public final class RoundThemes {

    private RoundThemes() {
    }

    /**
     * Register the plugin.
     */
    public static void loadPlugins() {
        UIManager.installLookAndFeel("Flat Round Dark",
                "tokyo.northside.omegat.theme.FlatRoundDarkLaf");
        UIManager.installLookAndFeel("Flat Round Light",
                "tokyo.northside.omegat.theme.FlatRoundLightLaf");
    }

    /**
     * Unload plugins.
     * Currently do nothing.
     */
    public static void unloadPlugins() {
    }
}
