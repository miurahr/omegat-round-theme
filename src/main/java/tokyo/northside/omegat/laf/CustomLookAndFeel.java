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

import org.omegat.util.gui.UIDesignManager;
import org.omegat.gui.theme.IThemeInitializer;

import javax.swing.UIManager;
import java.util.Map;


public class CustomLookAndFeel {

    private CustomLookAndFeel() {
    }

    public static void loadPlugins() {
        UIDesignManager.registerTheme("FlatLaf Dark","com.formdev.flatlaf.FlatDarkLaf");
        UIDesignManager.registerTheme("FlatLaf Light","com.formdev.flatlaf.FlatLightLaf");
        UIDesignManager.registerTheme(new FlatRoundDarkTheme());
    }

    public static void unloadPlugins() {
    }

    public static final class FlatRoundDarkTheme implements IThemeInitializer {

        @Override
        public String getName() {
            return "Flat Round Dark";
        }

        @Override
        public String getClassName() {
            return "com.formdev.flatlaf.FlatDarkLaf";
        }

        @Override
        public void setup() {
            UIManager.put( "Component.arrowType", "triangle" );
            UIManager.put( "Button.arc", 999 );
            UIManager.put( "Component.arc", 999 );
            UIManager.put( "ProgressBar.arc", 999 );
            UIManager.put( "TextComponent.arc", 999 );
        }

        public Map<String, Object> getConfig() {
            return null;
        }
    }
}
