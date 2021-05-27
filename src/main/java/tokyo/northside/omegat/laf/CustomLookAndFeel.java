
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

package tokyo.northside.omegat.laf;

import com.formdev.flatlaf.FlatLightLaf;
import org.omegat.util.gui.UIDesignManager;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class CustomLookAndFeel {
    private CustomLookAndFeel() {
    }

    /**
     * load plugin.
     */
    public static void loadPlugins() {
        UIDesignManager.registerThemeLoader(FlatLafloader);
    }

    /**
     * unload plugin.
     */
    public static void unloadPlugins() {
    }

    public static class FlatLafloader extends IThemeLoader {

        public static String getName() {
            return "Flat Light LaF";
        }

        /**
         * Set LookAndFeel default and load application colors
         */
        public static void onStartup() {
            try {
                UIManager.setLookAndFeel(new FlatLightLaf());
                UIManager.put( "Button.arc", 999 );
                UIManager.put( "Component.arc", 999 );
                UIManager.put( "ProgressBar.arc", 999 );
                UIManager.put( "TextComponent.arc", 999 );
            } catch (UnsupportedLookAndFeelException e) {
                e.printStackTrace();
            }
        }
    }
}
