/**
 * Font Highlighting Editor for Processing
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
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.*;
import javax.swing.event.*;

import processing.app.*;
import processing.app.ui.ColorChooser;
import processing.core.PApplet;

import fonthighlightingeditor.constants.FontHighlightingConstants;
import fonthighlightingeditor.utils.FontHighlightingUtils;

public class FontHighlightingFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	private Base base;
	private Border cb;
	private GroupLayout layout;
	private ColorChooser comment1Chooser;

	public FontHighlightingFrame(Base base) {
		this.base = base;

		setupFrame();
	}

	/**
	 * A method that sets up the frame's UI
	 */
	public void setupFrame() {
		try {
			cb = new CompoundBorder(BorderFactory.createMatteBorder(1, 1, 0, 0, new Color(195, 195, 195)),
					BorderFactory.createMatteBorder(0, 0, 1, 1, new Color(54, 54, 54)));

			// Set the frame title
			setTitle(FontHighlightingConstants.TOOL_NAME);

			// Set the frame icons (used IDE icons from Processing/lib/icons)

			List<Image> icons = new ArrayList<Image>();

			icons.add(loadImage(FontHighlightingConstants.PDE_ICON_16));
			icons.add(loadImage(FontHighlightingConstants.PDE_ICON_32));

			setIconImages(icons);

			/*
			 * Set up four controls for every editor.token.*.style preference.
			 * 
			 * As much logic as possible was split into helper methods, but we
			 * still need to use 16 lines to setup a single group of controls
			 */
			JLabel comment1HashLabel = new JLabel("#");
			JLabel comment1Label = new JLabel(FontHighlightingConstants.COMMENT1_NAME);
			comment1Label.setToolTipText(FontHighlightingConstants.COMMENT1_TOOLTIP);
			final JTextField comment1Field = this.setupTextField("editor.token.comment1.style");
			final JTextField comment1HexField = this.setupHexField("editor.token.comment1.style", comment1Field);
			comment1Chooser = new ColorChooser(this, false, Preferences.getColor("editor.token.comment1.style"),
					Language.text("prompt.ok"), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							String colorValue = comment1Chooser.getHexColor();
							colorValue = colorValue.substring(1);
							comment1HexField.setText(colorValue);
							comment1Field.setBackground(new Color(PApplet.unhex(colorValue)));
							comment1Chooser.hide();
						}
					});
			this.setupMouseListener(comment1Field, comment1Chooser);

			// Setup the layout
			layout = new GroupLayout(getContentPane());
			layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
					.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(comment1Label)
							.addPreferredGap(ComponentPlacement.RELATED).addComponent(comment1HashLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comment1HexField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED).addComponent(comment1Field,
									GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(331, Short.MAX_VALUE)));
			layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING)
					.addGroup(layout.createSequentialGroup().addContainerGap()
							.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(comment1Label)
									.addComponent(comment1HashLabel)
									.addComponent(comment1HexField, GroupLayout.PREFERRED_SIZE,
											GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(comment1Field, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(340, Short.MAX_VALUE)));
			layout.setAutoCreateGaps(true);
			layout.setAutoCreateContainerGaps(true);
			getContentPane().setLayout(layout);

			// Wrapping up - set a preferred size, center and display

			setPreferredSize(new Dimension(500, 400));
			setResizable(false);

			pack();

			setLocationRelativeTo(null);

			setVisible(true);
		} catch (Exception e) {
			System.out.println(FontHighlightingConstants.FRAME_SETUP_EXCEPTION);
			e.printStackTrace();
		}
	}

	/**
	 * Sets up a disabled "text field" used to call colorChooser and show the
	 * current color selection
	 * 
	 * @param preferenceName
	 *            The name of the preference the field refers to
	 * @return A fully setup JTextField variable
	 */
	private JTextField setupTextField(String preferenceName) {
		JTextField field = new JTextField("      ");
		field.setOpaque(true);
		field.setEnabled(false);
		field.setBorder(cb);
		field.setBackground(FontHighlightingUtils.extractColor(preferenceName));
		return field;
	}

	/**
	 * Sets up a text field used to actually edit the preference
	 * 
	 * @param preferenceName
	 *            The name of the preference the field refers to
	 * @param textField
	 *            A disabled text field (see above)
	 * @return A fully setup JTextField variable
	 */
	private JTextField setupHexField(String preferenceName, final JTextField textField) {
		final JTextField hexField = new JTextField(6);
		hexField.setText(FontHighlightingUtils.extractColorString(preferenceName));
		hexField.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				final String colorValue = hexField.getText().toUpperCase();
				if (colorValue.length() == 7 && (colorValue.startsWith("#")))
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							hexField.setText(colorValue.substring(1));
						}
					});
				if (colorValue.length() == 6 && colorValue.matches("[0123456789ABCDEF]*")) {
					textField.setBackground(new Color(PApplet.unhex(colorValue)));
					if (!colorValue.equals(hexField.getText()))
						SwingUtilities.invokeLater(new Runnable() {
							public void run() {
								hexField.setText(colorValue);
							}
						});
				}
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				final String colorValue = hexField.getText().toUpperCase();
				if (colorValue.length() == 7 && (colorValue.startsWith("#")))
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							hexField.setText(colorValue.substring(1));
						}
					});
				if (colorValue.length() == 6 && colorValue.matches("[0123456789ABCDEF]*")) {
					textField.setBackground(new Color(PApplet.unhex(colorValue)));
					if (!colorValue.equals(hexField.getText()))
						SwingUtilities.invokeLater(new Runnable() {
							public void run() {
								hexField.setText(colorValue);
							}
						});
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});
		return hexField;
	}

	/**
	 * Sets up the mouse listener that makes an (invisible) text field activate
	 * a ColorChooser
	 * 
	 * @param textField
	 *            A disabled text field (see above)
	 * @param chooser
	 *            A ColorChooser instance
	 */
	private void setupMouseListener(final JTextField textField, final ColorChooser chooser) {
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				chooser.show();
			}
		});
	}

	/**
	 * Loads the image located at a provided path
	 * 
	 * @param filePath
	 *            The path to the image (filename included)
	 * @return An image located at the given path
	 */
	private Image loadImage(String filePath) {
		return new ImageIcon(this.getClass().getResource(filePath)).getImage();
	}
}
