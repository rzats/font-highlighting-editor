/**
 * Part of the Font Highlighting Editor for Processing
 *
 * ##copyright##
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General
 * Public License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, MA  02111-1307  USA
 *
 * @author   ##author##
 * @modified ##date##
 * @version  ##tool.prettyVersion##
 */

package fonthighlightingeditor.utils;

import java.awt.*;

import javax.swing.ImageIcon;

import processing.app.Preferences;

import fonthighlightingeditor.tool.FontHighlightingFrame;

/**
 * Assorted helper methods used by the tool.
 */

public class ToolHelpers {
	/**
	 * Gets a value of a PDE preference given an alias used in the frame.
	 * 
	 * @param preferenceName
	 *            The shortened alias of the preference
	 * @return A value of the preference
	 */
	private static String getPreference(String preferenceName) {
		if (preferenceName == "bgcolor") {
			return Preferences.get("run.window." + preferenceName);
		} else {
			return Preferences.get("editor.token." + preferenceName + ".style");
		}
	}

	/**
	 * Gets a default value of a PDE preference given an alias used in the
	 * frame.
	 * 
	 * @param preferenceName
	 *            The shortened alias of the preference
	 * @return A default value of the preference
	 */
	private static String getDefaultPreference(String preferenceName) {
		if (preferenceName == "bgcolor") {
			return Preferences.get("run.window.bgcolor");
		} else {
			return Preferences.getDefault("editor.token." + preferenceName + ".style");
		}
	}

	/**
	 * Extracts a string representing a color from a preference
	 * 
	 * @param preferenceName
	 *            The shortened alias of the preference
	 * @return A hex color string (w/o leading #) extracted from the preference
	 */
	public static String extractColorString(String preferenceName) {
		String s = getPreference(preferenceName);

		int index = s.lastIndexOf(",");
		if (index == -1) {
			return s.substring(1).toUpperCase();
		} else {
			return s.substring(1, index).toUpperCase();
		}
	}

	/**
	 * Tiny wrapper that sets a preference to its default value
	 * 
	 * @param preferenceName
	 *            The shortened alias of the preference
	 * @return A hex color string (w/o leading #) extracted from the preference
	 */
	public static String extractDefaultColorString(String preferenceName) {
		String s = getDefaultPreference(preferenceName);

		int index = s.lastIndexOf(",");
		if (index == -1) {
			return s.substring(1).toUpperCase();
		} else {
			return s.substring(1, index).toUpperCase();
		}
	}

	/**
	 * Extracts a color from an editor.token.*.style preference
	 * 
	 * @param preferenceName
	 *            The shortened alias of the preference
	 * @return A Color object extracted from the preference
	 */
	public static Color extractColor(String preferenceName) {
		return Color.decode("#" + extractColorString(preferenceName));
	}

	/**
	 * Sets a Processing preference by a given shortened alias
	 * 
	 * @param preferenceName
	 *            The shortened alias of the preference
	 * @param color
	 *            The color the preference will be set to
	 */
	public static void setPreference(String preferenceName, Color color) {
		String s = getPreference(preferenceName);

		String newPreferenceValue = String.format("#%06X", (0xFFFFFF & color.getRGB())) + s.substring(7);

		/*
		 * Some defaults are in lowercase, some in uppercase - sticking to
		 * lowercase
		 */
		if (preferenceName == "bgcolor") {
			Preferences.set("run.window." + preferenceName, newPreferenceValue.toLowerCase());
		} else {
			Preferences.set("editor.token." + preferenceName + ".style", newPreferenceValue.toLowerCase());
		}
	}

	/**
	 * Loads the image located at a provided path.
	 * 
	 * @param filePath
	 *            The path to the image (filename included)
	 * @return An image located at the given path
	 */
	public static Image loadImage(String filePath) {
		return new ImageIcon(FontHighlightingFrame.class.getResource(filePath)).getImage();
	}

}
