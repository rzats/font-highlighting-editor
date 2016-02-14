package fonthighlightingeditor.utils;

import java.awt.Color;

import processing.app.Preferences;

public class FontHighlightingHelpers {
	/**
	 * Extracts a string representing a color from an editor.token.*.style
	 * preference
	 * 
	 * @param preferenceName
	 *            The name of the preference
	 * @return A hex color string (w/o leading #) extracted from the preference
	 */
	public static String extractColorString(String preferenceName) {
		String s = Preferences.get(preferenceName);
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
}
