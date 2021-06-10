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

import org.omegat.util.Log;
import org.omegat.util.gui.UIDesignManager;

public class FlatThemes {

    private FlatThemes() {
    }

    public static void loadPlugins() {
        try {
            // OmegaT 5.6.0 and later has a method, when launching older OmegaT, ignored.
            UIDesignManager.class.getDeclaredMethod("registerTheme", String.class, String.class);
            UIDesignManager.registerTheme("Flat Round Dark", "tokyo.northside.omegat.theme.FlatRoundDarkLaf");
            UIDesignManager.registerTheme("Flat Round Light", "tokyo.northside.omegat.theme.FlatRoundLightLaf");
        } catch (NoSuchMethodException e) {
            Log.log("Theme plugin: OmegaT version seems to be too old to support theme plugin.");
        }
    }

    public static void unloadPlugins() {
    }
}
