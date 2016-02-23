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

package fonthighlightingeditor.tool;

import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.MaskFormatter;

import processing.app.ui.ColorChooser;
import processing.core.PApplet;

import fonthighlightingeditor.utils.*;

/**
 * Factory-ish class that creates some repeatable controls used in the frame
 */
public class ComponentCreator {
	/**
	 * Creates a label containing info about a preference
	 * 
	 * @param preferenceName
	 *            The name of the preference the label will be associated with
	 * @return A label containing info about the preference
	 */
	public static JLabel createInfoLabel(String preferenceName) {
		final JLabel label = new JLabel(preferenceName + ":");
		label.setToolTipText("<html>" + ToolConstants.TOOLTIPS.get(preferenceName) + "</html>");

		return label;
	}

	/**
	 * Creates a label with a hash text. This mostly exists for consistency
	 * 
	 * @return A label containing the character "#"
	 */
	public static JLabel createHashLabel() {
		return new JLabel("#", SwingConstants.CENTER);
	}

	/**
	 * Creates a disabled "text field" used to call colorChooser and show the
	 * current color selection
	 *
	 * @param preferenceName
	 *            The name of the preference the field will be associated with
	 * @return A disabled JTextField
	 */
	public static JTextField createDisabledTextField(String preferenceName) {
		JTextField field = new JTextField(" ");
		field.setOpaque(true);
		field.setEnabled(true);
		field.setEditable(false);
		field.setBackground(ToolHelpers.extractColor(preferenceName));
		return field;
	}

	/**
	 * Creates a formatted text field used to edit the preference
	 *
	 * @param preferenceName
	 *            The name of the preference the field will be associated with
	 * @param textField
	 *            A disabled JTextField associated with the preference
	 * @return An instantiated JFormattedTextField
	 */
	public static JFormattedTextField createFormattedTextField(String preferenceName, final JTextField textField) {
		MaskFormatter formatter = null;
		try {
			formatter = new MaskFormatter("HHHHHH");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// Initialize the field
		final JFormattedTextField formattedTextField = new JFormattedTextField(formatter);
		formattedTextField.setColumns(10);
		formattedTextField.setText(ToolHelpers.extractColorString(preferenceName));

		// Respond to changes
		formattedTextField.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				final String colorValue = formattedTextField.getText().toUpperCase();
				if (colorValue.length() == 6 && colorValue.matches("[0123456789ABCDEF]*")) {
					textField.setBackground(new Color(PApplet.unhex(colorValue)));
					if (!colorValue.equals(formattedTextField.getText())) {
						SwingUtilities.invokeLater(new Runnable() {
							public void run() {
								formattedTextField.setText(colorValue);
							}
						});
					}
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});

		return formattedTextField;
	}

	/**
	 * Sets up a mouse listener for the disabled field
	 * 
	 * @param frame
	 *            The current FontHighlightingFrame instance
	 * @param disabledField
	 *            A disabled JTextField
	 * @param chooser
	 *            A ColorChooser to be triggered when the field is clicked
	 */
	public static void setupMouseListener(final FontHighlightingFrame frame, JTextField disabledField,
			final ColorChooser chooser) {
		disabledField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				frame.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				frame.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				chooser.show();
			}
		});
	}
}
