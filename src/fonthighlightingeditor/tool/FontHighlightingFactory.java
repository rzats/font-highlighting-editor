package fonthighlightingeditor.tool;

import java.text.ParseException;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

import fonthighlightingeditor.constants.FontHighlightingConstants;
import fonthighlightingeditor.utils.FontHighlightingHelpers;

public class FontHighlightingFactory {
	/**
	 * Generates a label containing info about a preference
	 * 
	 * @param preferenceName
	 *            The name of the preference the label refers to
	 * @return An instantiated label
	 */
	public static JLabel createInfoLabel(String preferenceName) {
		final JLabel label = new JLabel(preferenceName + ":");
		label.setToolTipText("<html>" + FontHighlightingConstants.TOOLTIPS.get(preferenceName) + "</html>");

		return label;
	}

	/**
	 * Generates a label with a hash text. This mostly exists for consistency
	 * 
	 * @return A label containing the character "#"
	 */
	public static JLabel createHashLabel() {
		return new JLabel("#");
	}

	/**
	 * Sets up a disabled "text field" used to call colorChooser and show the
	 * current color selection
	 *
	 * @param preferenceName
	 *            The name of the preference the field refers to
	 * @return An instantiated JFormattedTextField
	 */
	public static JTextField createDisabledTextField(String preferenceName) {
		JTextField field = new JTextField(" ");
		field.setOpaque(true);
		field.setEnabled(false);
		field.setBackground(FontHighlightingHelpers.extractColor(preferenceName));
		return field;
	}

	/**
	 * Sets up a formatted text field used to edit the preference
	 *
	 * @param preferenceName
	 *            The name of the preference the field refers to
	 * @param textField
	 *            A disabled JTextField
	 * @return An instantiated JFormattedTextField
	 */
	public static JFormattedTextField createFormattedTextField(String preferenceName, final JTextField textField) {
		// 6-character hex code

		MaskFormatter formatter = null;
		try {
			formatter = new MaskFormatter("HHHHHH");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		final JFormattedTextField formattedFeld = new JFormattedTextField(formatter);
		formattedFeld.setText(FontHighlightingHelpers.extractColorString(preferenceName));
		/*
		 * formattedFeld.getDocument().addDocumentListener(new
		 * DocumentListener() {
		 * 
		 * @Override public void removeUpdate(DocumentEvent e) { final String
		 * colorValue = formattedFeld.getText().toUpperCase(); if
		 * (colorValue.length() == 7 && (colorValue.startsWith("#")))
		 * SwingUtilities.invokeLater(new Runnable() { public void run() {
		 * formattedFeld.setText(colorValue.substring(1)); } }); if
		 * (colorValue.length() == 6 &&
		 * colorValue.matches("[0123456789ABCDEF]*")) {
		 * textField.setBackground(new Color(PApplet.unhex(colorValue))); if
		 * (!colorValue.equals(formattedFeld.getText()))
		 * SwingUtilities.invokeLater(new Runnable() { public void run() {
		 * formattedFeld.setText(colorValue); } }); } }
		 * 
		 * @Override public void insertUpdate(DocumentEvent e) { final String
		 * colorValue = formattedFeld.getText().toUpperCase(); if
		 * (colorValue.length() == 7 && (colorValue.startsWith("#")))
		 * SwingUtilities.invokeLater(new Runnable() { public void run() {
		 * formattedFeld.setText(colorValue.substring(1)); } }); if
		 * (colorValue.length() == 6 &&
		 * colorValue.matches("[0123456789ABCDEF]*")) {
		 * textField.setBackground(new Color(PApplet.unhex(colorValue))); if
		 * (!colorValue.equals(formattedFeld.getText()))
		 * SwingUtilities.invokeLater(new Runnable() { public void run() {
		 * formattedFeld.setText(colorValue); } }); } }
		 * 
		 * @Override public void changedUpdate(DocumentEvent e) { } });
		 */
		return formattedFeld;
	}
}
