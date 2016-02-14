package fonthighlightingeditor.tool;

import javax.swing.JLabel;

import fonthighlightingeditor.constants.FontHighlightingConstants;

public class FontHighlightingFactory {
	/**
	 * Generates a label containing info about a preference
	 * 
	 * @param preferenceName
	 *            The name of the preference
	 * @return An instantiated label
	 */
	public static JLabel createInfoLabel(String preferenceName) {
		final JLabel label = new JLabel(preferenceName + ":");
		label.setToolTipText("<html>" + FontHighlightingConstants.TOOLTIPS.get(preferenceName) + "</html>");

		return label;
	}
}
