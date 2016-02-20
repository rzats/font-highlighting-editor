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
	 * Extracts a string representing a color from an editor.token.*.style
	 * preference
	 * 
	 * @param preferenceName
	 *            The name of the preference
	 * @return A hex color string (w/o leading #) extracted from the preference
	 */
	public static String extractColorString(String preferenceName) {
		String s;
		if (preferenceName == "bgcolor") {
			s = Preferences.get("run.window." + preferenceName);
		} else {
			s = Preferences.get("editor.token." + preferenceName + ".style");
		}

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
	 *            The name of the preference
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
		String s;
		if (preferenceName == "bgcolor") {
			s = Preferences.get("run.window." + preferenceName);
		} else {
			s = Preferences.get("editor.token." + preferenceName + ".style");
		}

		String newPreference = String.format("#%06X", (0xFFFFFF & color.getRGB())) + s.substring(7);

		/*
		 * Some defaults are in lowercase, some in uppercase - sticking to
		 * lowercase
		 */
		if (preferenceName == "bgcolor") {
			Preferences.set("run.window." + preferenceName, newPreference.toLowerCase());
		} else {
			Preferences.set("editor.token." + preferenceName + ".style", newPreference.toLowerCase());
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
