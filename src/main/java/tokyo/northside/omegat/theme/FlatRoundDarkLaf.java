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
import org.omegat.gui.theme.DefaultFlatTheme;

import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Insets;


/**
 * Flat and round dark theme for OmegaT.
 * This is based on FlatLaf's FlatDarkLaf module.
 */
@SuppressWarnings("unused")
public class FlatRoundDarkLaf extends FlatDarkLaf {
    private static final String NAME = "Flat round dark theme";
    private static final String ID = "FlatRoundDarkTheme";
    private static final String DESCRIPTION = "Rounded theme customized from FlatDarkLaf";

    /**
     * Constructor.
     */
    public FlatRoundDarkLaf() {
        super();
    }

    /**
     * Return default theme configurations.
     *
     * @return
     */
    @Override
    public UIDefaults getDefaults() {
        UIDefaults defaults = super.getDefaults();

        // get OmegaT defaults
        defaults = DefaultFlatTheme.setDefaults(defaults, ID);

        // GTK+ has bug that TextPane background is fixed white.
        // https://sourceforge.net/p/omegat/bugs/1013/
        Color standardBgColor = defaults.getColor("Panel.background");
        defaults.put("TextPane.background", standardBgColor);

        // Borders
        Color borderColor = new Color(0x8aa5b8);
        defaults.put("OmegaTBorder.color", borderColor);
        defaults.put("OmegaTDockablePanel.border", new MatteBorder(1, 1, 1, 1, borderColor));

        // Default application Colors
        defaults.put("OmegaT.activeSource", new Color(0x287128));
        defaults.put("OmegaT.source", new Color(0x82b682));
        defaults.put("OmegaT.noted", new Color(0xa0c0c0));
        defaults.put("OmegaT.untranslated", new Color(0x4d4daa));
        defaults.put("OmegaT.translated", new Color(0x57572d));
        defaults.put("OmegaT.nonUnique", new Color(0x808080));
        defaults.put("OmegaT.placeholder", new Color(0x969696));
        defaults.put("OmegaT.removeTextTarget", new Color(0xff0000));
        defaults.put("OmegaT.nbsp", new Color(0xc8c8c8));
        defaults.put("OmegaT.whiteSpace", new Color(0x808080));
        defaults.put("OmegaT.bidiMarkers", new Color(0x480000));
        defaults.put("OmegaT.paragraphStart", new Color(0xaeaeae));
        defaults.put("OmegaT.markComesFromTm", new Color(0xaa8072));
        defaults.put("OmegaT.markComesFromTxXice", new Color(0xaf76df));
        defaults.put("OmegaT.markComesFromTmX100pc", new Color(0x3f54f8));
        defaults.put("OmegaT.markComesFromTmXauto", new Color(0x3f2546));
        defaults.put("OmegaT.markComesFromTmXendorced", new Color(0x005500));
        defaults.put("OmegaT.replace", new Color(0x0000ff));
        defaults.put("OmegaT.languageTools", new Color(0x0000ff));
        defaults.put("OmegaT.transTips", new Color(0x0000ff));
        defaults.put("OmegaT.spellCheck", new Color(0xff0000));
        defaults.put("OmegaT.terminology", new Color(0xffa500));
        defaults.put("OmegaT.matchesChanged", new Color(0x0000ff));
        defaults.put("OmegaT.matchesUnchanged", new Color(0x00ff00));
        defaults.put("OmegaT.matchesInsActive", new Color(0x0000ff));
        defaults.put("OmegaT.matchesInsInactive", new Color(0x808080));
        defaults.put("OmegaT.hyperlink", new Color(0x0000ff));
        defaults.put("OmegaT.searchFoundMark", new Color(0x0000ff));
        defaults.put("OmegaT.searchReplaceMark", new Color(0xff9900));
        defaults.put("OmegaT.notificationMin", new Color(0x332233));
        defaults.put("OmegaT.notificationMax", new Color(0x647354));
        defaults.put("OmegaT.alignerAccepted", new Color(0x15bb45));
        defaults.put("OmegaT.alignerNeedsReview", new Color(0xff0000));
        defaults.put("OmegaT.alignerHighlight", new Color(0xffff00));
        defaults.put("OmegaT.alignerTableRowHighlight", new Color(0xc8c8c8));
        defaults.put("OmegaT.projectFilesCurrentFileForeground", new Color(0x0));
        defaults.put("OmegaT.projectFilesCurrentFileBackground", new Color(0xc8ddf2));
        defaults.put("OmegaT.searchFieldErrorText", new Color(0x7f0000));
        defaults.put("OmegaT.searchDimmedBackground", new Color(0x80, 0x80, 0x80, 0x80));
        defaults.put("OmegaT.searchResultBorder", new Color(0xEE, 0xD2, 0x00, 0x80));

        // FIXME: VLDocking values have to be set to the "developer defaults"
        // not the "LAF defaults" because that's where
        // DockingUISettings#installUI puts them
        UIManager.put("DockViewTitleBar.border", new MatteBorder(1, 1, 1, 1, borderColor));

        // Panel title bars
        Color activeTitleBgColor = Utils.adjustRGB(standardBgColor, 0xF6 - 0xEE);
        Color activeTitleText = defaults.getColor("Label.foreground");
        Color inactiveTitleText = new Color(0x767676);

        defaults.put("InternalFrame.activeTitleForeground", activeTitleText);
        defaults.put("InternalFrame.activeTitleBackground", activeTitleBgColor);
        defaults.put("InternalFrame.inactiveTitleForeground", inactiveTitleText);
        defaults.put("InternalFrame.inactiveTitleBackground", standardBgColor);

        // Undocked panel
        defaults.put("activeCaption", Color.GRAY);
        defaults.put("activeCaptionBorder", borderColor);
        defaults.put("inactiveCaption", standardBgColor);
        defaults.put("inactiveCaptionBorder", borderColor);

        // Standard components customize
        defaults.put("Component.arrowType", "triangle");
        defaults.put("Button.arc", 999);
        defaults.put("Component.arc", 999);
        defaults.put("CheckBox.arc", 999);
        defaults.put("ProgressBar.arc", 999);
        defaults.put("TextComponent.arc", 999);
        defaults.put("ScrollBar.trackArc", 999);
        defaults.put("ScrollBar.thumbArc", 999);
        defaults.put("ScrollBar.trackInsets", new Insets(3, 5, 3, 5));
        defaults.put("ScrollBar.thumbInsets", new Insets(3, 3, 3, 3));
        defaults.put("ScrollBar.width", 16);
        defaults.put("ScrollBar.track", new Color(0x757575));
        defaults.put("TabbedPane.tabSeparatorsFullHeight", true);
        defaults.put("TabbedPane.selectedBackground", Color.GRAY);

        return defaults;
    }

    /**
     * Adds this look and feel to the set of available look and feels.
     * <p>
     * Useful if your application uses {@link UIManager#getInstalledLookAndFeels()}
     * to query available LaFs and display them to the user in a combobox.
     */
    public static void installLafInfo() {
        installLafInfo(NAME, FlatRoundDarkLaf.class);
    }

    /**
     * Return theme id.
     *
     * @return
     */
    @Override
    public String getID() {
        return ID;
    }

    /**
     * Return human readable name of theme.
     *
     * @return
     */
    @Override
    public String getName() {
        return NAME;
    }

    /**
     * Return description of theme.
     *
     * @return
     */
    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}
