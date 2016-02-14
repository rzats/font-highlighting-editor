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
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.text.MaskFormatter;

import processing.app.Base;

import fonthighlightingeditor.constants.FontHighlightingConstants;

public class FontHighlightingFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	private Base base;
	GroupLayout layout;

	private JTextField comment1DisabledField;
	private JTextField comment2DisabledField;
	private JTextField function1DisabledField;
	private JTextField function2DisabledField;
	private JTextField function3DisabledField;
	private JTextField function4DisabledField;
	private JTextField invalidDisabledField;
	private JTextField keyword1DisabledField;
	private JTextField keyword2DisabledField;
	private JTextField keyword3DisabledField;
	private JTextField keyword4DisabledField;
	private JTextField keyword5DisabledField;
	private JTextField keyword6DisabledField;
	private JTextField labelDisabledField;
	private JTextField literal1DisabledField;
	private JTextField literal2DisabledField;
	private JTextField operatorDisabledField;
	private JTextField bgColorDisabledField;

	public FontHighlightingFrame(Base base) {
		this.base = base;

		setupFrame();
	}

	/**
	 * A method that sets up the frame's UI
	 */
	private void setupFrame() {
		try {
			// cb = new CompoundBorder(BorderFactory.createMatteBorder(1, 1, 0,
			// 0, new Color(195, 195, 195)),
			// BorderFactory.createMatteBorder(0, 0, 1, 1, new Color(54, 54,
			// 54)));

			// Set the frame title
			setTitle(FontHighlightingConstants.TOOL_NAME);

			// Set the frame icons (used IDE icons from Processing/lib/icons)

			List<Image> icons = new ArrayList<Image>();

			icons.add(loadImage(FontHighlightingConstants.PDE_ICON_16));
			icons.add(loadImage(FontHighlightingConstants.PDE_ICON_32));

			setIconImages(icons);

			Font f = new Font("Dialog", Font.PLAIN, 12);
			UIManager.put("Button.font", f);
			UIManager.put("TextArea.font", f);

			// Setup the text area displaying a tiny readme
			final JTextArea infoArea = new JTextArea();
			infoArea.setEditable(false);
			infoArea.setBackground(null);
			infoArea.setHighlighter(null);
			infoArea.setText(FontHighlightingConstants.TEXTAREA_INFO);

			// Setup separators
			final JSeparator topSeparator = new JSeparator();
			final JSeparator bottomSeparator = new JSeparator();

			// Setup buttons
			final JButton btnOK = new JButton("OK");
			btnOK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					applyPreferences();
				}
			});

			final JButton btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});

			final JButton btnImport = new JButton("Import");

			final JButton btnExport = new JButton("Export");

			/*
			 * Formatter used in all JFormattedTextFields to restrict them to a
			 * 6-character hex code
			 */

			MaskFormatter formatter = null;
			try {
				formatter = new MaskFormatter("HHHHHH");
			} catch (ParseException e) {
				e.printStackTrace();
			}

			/*
			 * Setup a series of control groups:
			 * 
			 * 1. name/info label
			 * 
			 * 2. hash label
			 * 
			 * 3. formatted text field
			 * 
			 * 4. a disabled text field linking to a colorChooser
			 * 
			 */

			String currentPref;
			// comment1

			currentPref = "comment1";

			final JLabel comment1InfoLabel = FontHighlightingFactory.createInfoLabel(currentPref);

			final JLabel comment1HashLabel = new JLabel("#");

			final JFormattedTextField comment1FormattedField = new JFormattedTextField(formatter);

			comment1DisabledField = new JTextField();
			comment1DisabledField.setEnabled(false);
			comment1DisabledField.setColumns(10);

			// comment2

			currentPref = "comment2";

			final JLabel comment2InfoLabel = FontHighlightingFactory.createInfoLabel(currentPref);

			final JLabel comment2HashLabel = new JLabel("#");

			final JFormattedTextField comment2FormattedField = new JFormattedTextField(formatter);

			comment2DisabledField = new JTextField();
			comment2DisabledField.setEnabled(false);
			comment2DisabledField.setColumns(10);

			// function1
			currentPref = "function1";

			final JLabel function1InfoLabel = FontHighlightingFactory.createInfoLabel(currentPref);

			final JLabel function1HashLabel = new JLabel("#");

			final JFormattedTextField function1FormattedField = new JFormattedTextField(formatter);

			function1DisabledField = new JTextField();
			function1DisabledField.setEnabled(false);
			function1DisabledField.setColumns(10);

			// function2
			currentPref = "function2";

			final JLabel function2InfoLabel = FontHighlightingFactory.createInfoLabel(currentPref);

			final JLabel function2HashLabel = new JLabel("#");

			final JFormattedTextField function2FormattedField = new JFormattedTextField(formatter);

			function2DisabledField = new JTextField();
			function2DisabledField.setEnabled(false);
			function2DisabledField.setColumns(10);

			// function3
			currentPref = "function3";

			final JLabel function3InfoLabel = FontHighlightingFactory.createInfoLabel(currentPref);

			final JLabel function3HashLabel = new JLabel("#");

			final JFormattedTextField function3FormattedField = new JFormattedTextField(formatter);

			function3DisabledField = new JTextField();
			function3DisabledField.setEnabled(false);
			function3DisabledField.setColumns(10);

			// function4
			currentPref = "function4";

			final JLabel function4InfoLabel = FontHighlightingFactory.createInfoLabel(currentPref);

			final JLabel function4HashLabel = new JLabel("#");

			final JFormattedTextField function4FormattedField = new JFormattedTextField(formatter);

			function4DisabledField = new JTextField();
			function4DisabledField.setEnabled(false);
			function4DisabledField.setColumns(10);

			// invalid
			currentPref = "invalid";

			final JLabel invalidInfoLabel = FontHighlightingFactory.createInfoLabel(currentPref);

			final JLabel invalidHashLabel = new JLabel("#");

			final JFormattedTextField invalidFormattedField = new JFormattedTextField(formatter);

			invalidDisabledField = new JTextField();
			invalidDisabledField.setEnabled(false);
			invalidDisabledField.setColumns(10);

			// keyword1
			currentPref = "keyword1";

			final JLabel keyword1InfoLabel = FontHighlightingFactory.createInfoLabel(currentPref);

			final JLabel keyword1HashLabel = new JLabel("#");

			final JFormattedTextField keyword1FormattedField = new JFormattedTextField(formatter);

			keyword1DisabledField = new JTextField();
			keyword1DisabledField.setEnabled(false);
			keyword1DisabledField.setColumns(10);

			// keyword2
			currentPref = "keyword2";

			final JLabel keyword2InfoLabel = FontHighlightingFactory.createInfoLabel(currentPref);

			final JLabel keyword2HashLabel = new JLabel("#");

			final JFormattedTextField keyword2FormattedField = new JFormattedTextField(formatter);

			keyword2DisabledField = new JTextField();
			keyword2DisabledField.setEnabled(false);
			keyword2DisabledField.setColumns(10);

			// keyword3
			currentPref = "keyword3";

			final JLabel keyword3InfoLabel = FontHighlightingFactory.createInfoLabel(currentPref);

			final JLabel keyword3HashLabel = new JLabel("#");

			final JFormattedTextField keyword3FormattedField = new JFormattedTextField(formatter);

			keyword3DisabledField = new JTextField();
			keyword3DisabledField.setEnabled(false);
			keyword3DisabledField.setColumns(10);

			// keyword4
			currentPref = "keyword4";

			final JLabel keyword4InfoLabel = FontHighlightingFactory.createInfoLabel(currentPref);

			final JLabel keyword4HashLabel = new JLabel("#");

			final JFormattedTextField keyword4FormattedField = new JFormattedTextField(formatter);

			keyword4DisabledField = new JTextField();
			keyword4DisabledField.setEnabled(false);
			keyword4DisabledField.setColumns(10);

			// keyword5
			currentPref = "keyword5";

			final JLabel keyword5InfoLabel = FontHighlightingFactory.createInfoLabel(currentPref);

			final JLabel keyword5HashLabel = new JLabel("#");

			final JFormattedTextField keyword5FormattedField = new JFormattedTextField(formatter);

			keyword5DisabledField = new JTextField();
			keyword5DisabledField.setEnabled(false);
			keyword5DisabledField.setColumns(10);

			// keyword6
			currentPref = "keyword6";

			final JLabel keyword6InfoLabel = FontHighlightingFactory.createInfoLabel(currentPref);

			final JLabel keyword6HashLabel = new JLabel("#");

			final JFormattedTextField keyword6FormattedField = new JFormattedTextField(formatter);

			keyword6DisabledField = new JTextField();
			keyword6DisabledField.setEnabled(false);
			keyword6DisabledField.setColumns(10);

			// label
			currentPref = "label";

			final JLabel labelInfoLabel = FontHighlightingFactory.createInfoLabel(currentPref);

			final JLabel labelHashLabel = new JLabel("#");

			final JFormattedTextField labelFormattedField = new JFormattedTextField(formatter);

			labelDisabledField = new JTextField();
			labelDisabledField.setEnabled(false);
			labelDisabledField.setColumns(10);

			// literal1
			currentPref = "literal1";

			final JLabel literal1InfoLabel = FontHighlightingFactory.createInfoLabel(currentPref);

			final JLabel literal1HashLabel = new JLabel("#");

			final JFormattedTextField literal1FormattedField = new JFormattedTextField(formatter);

			literal1DisabledField = new JTextField();
			literal1DisabledField.setEnabled(false);
			literal1DisabledField.setColumns(10);

			// literal2
			currentPref = "literal2";

			final JLabel literal2InfoLabel = FontHighlightingFactory.createInfoLabel(currentPref);

			final JLabel literal2HashLabel = new JLabel("#");

			final JFormattedTextField literal2FormattedField = new JFormattedTextField(formatter);

			literal2DisabledField = new JTextField();
			literal2DisabledField.setEnabled(false);
			literal2DisabledField.setColumns(10);

			// operator
			currentPref = "operator";

			final JLabel operatorInfoLabel = FontHighlightingFactory.createInfoLabel(currentPref);

			final JLabel operatorHashLabel = new JLabel("#");

			final JFormattedTextField operatorFormattedField = new JFormattedTextField(formatter);

			operatorDisabledField = new JTextField();
			operatorDisabledField.setEnabled(false);
			operatorDisabledField.setColumns(10);

			// bgcolor
			currentPref = "bgcolor";

			final JLabel bgColorInfoLabel = FontHighlightingFactory.createInfoLabel(currentPref);

			final JLabel bgColorHashLabel = new JLabel("#");

			final JFormattedTextField bgColorFormattedField = new JFormattedTextField(formatter);

			bgColorDisabledField = new JTextField();
			bgColorDisabledField.setEnabled(false);
			bgColorDisabledField.setColumns(10);

			// JLabel comment1HashLabel = new JLabel("#");
			// JLabel comment1Label = new
			// JLabel(FontHighlightingConstants.COMMENT1_NAME);
			// comment1Label.setToolTipText(FontHighlightingConstants.COMMENT1_TOOLTIP);
			// final JTextField comment1Field =
			// this.setupTextField("editor.token.comment1.style");
			// final JTextField comment1HexField =
			// this.setupHexField("editor.token.comment1.style",
			// comment1Field);
			// comment1Chooser = new ColorChooser(this, false,
			// Preferences.getColor("editor.token.comment1.style"),
			// Language.text("prompt.ok"), new ActionListener() {
			// @Override
			// public void actionPerformed(ActionEvent e) {
			// String colorValue = comment1Chooser.getHexColor();
			// colorValue = colorValue.substring(1);
			// comment1HexField.setText(colorValue);
			// comment1Field.setBackground(new
			// Color(PApplet.unhex(colorValue)));
			// comment1Chooser.hide();
			// }
			// });
			// this.setupMouseListener(comment1Field, comment1Chooser);

			/*
			 * Setup the layout. Lots and lots of autogenerated code here.
			 */
			layout = new GroupLayout(getContentPane());
			layout.setHorizontalGroup(layout.createParallelGroup(Alignment.TRAILING)
					.addGroup(layout.createSequentialGroup().addContainerGap()
							.addComponent(infoArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addContainerGap(475, Short.MAX_VALUE))
					.addComponent(topSeparator, GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
					.addGroup(
							layout.createSequentialGroup().addContainerGap()
									.addComponent(comment1InfoLabel, GroupLayout.PREFERRED_SIZE, 56,
											GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(comment1HashLabel, GroupLayout.PREFERRED_SIZE, 8,
											GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(comment1FormattedField, GroupLayout.PREFERRED_SIZE, 51,
									GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(comment1DisabledField, GroupLayout.PREFERRED_SIZE, 20,
									GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(invalidInfoLabel, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(invalidHashLabel, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(invalidFormattedField, GroupLayout.PREFERRED_SIZE, 51,
									GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(invalidDisabledField, GroupLayout.PREFERRED_SIZE, 20,
									GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(keyword6InfoLabel, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(keyword6HashLabel, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(keyword6FormattedField, GroupLayout.PREFERRED_SIZE, 51,
									GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(keyword6DisabledField, GroupLayout.PREFERRED_SIZE, 20,
									GroupLayout.PREFERRED_SIZE).addContainerGap(15, Short.MAX_VALUE))
					.addGroup(
							layout.createSequentialGroup().addContainerGap()
									.addComponent(comment2InfoLabel, GroupLayout.PREFERRED_SIZE, 56,
											GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(comment2HashLabel, GroupLayout.PREFERRED_SIZE, 8,
											GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(comment2FormattedField, GroupLayout.PREFERRED_SIZE, 51,
									GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(comment2DisabledField, GroupLayout.PREFERRED_SIZE, 20,
									GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(keyword1InfoLabel, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(keyword1HashLabel, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(keyword1FormattedField, GroupLayout.PREFERRED_SIZE, 51,
									GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(keyword1DisabledField, GroupLayout.PREFERRED_SIZE, 20,
									GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(labelInfoLabel, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(labelHashLabel, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(labelFormattedField, GroupLayout.PREFERRED_SIZE, 51,
									GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(labelDisabledField, GroupLayout.PREFERRED_SIZE, 20,
									GroupLayout.PREFERRED_SIZE).addContainerGap(15, Short.MAX_VALUE))
					.addGroup(
							layout.createSequentialGroup().addContainerGap()
									.addComponent(function1InfoLabel, GroupLayout.PREFERRED_SIZE, 56,
											GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(function1HashLabel, GroupLayout.PREFERRED_SIZE, 8,
											GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(function1FormattedField, GroupLayout.PREFERRED_SIZE, 51,
									GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(function1DisabledField, GroupLayout.PREFERRED_SIZE, 20,
									GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(keyword2InfoLabel, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(keyword2HashLabel, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(keyword2FormattedField, GroupLayout.PREFERRED_SIZE, 51,
									GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(keyword2DisabledField, GroupLayout.PREFERRED_SIZE, 20,
									GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(literal1InfoLabel, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(literal1HashLabel, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(literal1FormattedField, GroupLayout.PREFERRED_SIZE, 51,
									GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(literal1DisabledField, GroupLayout.PREFERRED_SIZE, 20,
									GroupLayout.PREFERRED_SIZE).addContainerGap(15, Short.MAX_VALUE))
					.addGroup(
							layout.createSequentialGroup().addContainerGap()
									.addComponent(function2InfoLabel, GroupLayout.PREFERRED_SIZE, 56,
											GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(function2HashLabel, GroupLayout.PREFERRED_SIZE, 8,
											GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(function2FormattedField, GroupLayout.PREFERRED_SIZE, 51,
									GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(function2DisabledField, GroupLayout.PREFERRED_SIZE, 20,
									GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(keyword3InfoLabel, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(keyword3HashLabel, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(keyword3FormattedField, GroupLayout.PREFERRED_SIZE, 51,
									GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(keyword3DisabledField, GroupLayout.PREFERRED_SIZE, 20,
									GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(literal2InfoLabel, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(literal2HashLabel, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(literal2FormattedField, GroupLayout.PREFERRED_SIZE, 51,
									GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(literal2DisabledField, GroupLayout.PREFERRED_SIZE, 20,
									GroupLayout.PREFERRED_SIZE).addContainerGap(15, Short.MAX_VALUE))
					.addGroup(
							layout.createSequentialGroup().addContainerGap()
									.addComponent(function3InfoLabel, GroupLayout.PREFERRED_SIZE, 56,
											GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(function3HashLabel, GroupLayout.PREFERRED_SIZE, 8,
											GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(function3FormattedField, GroupLayout.PREFERRED_SIZE, 51,
									GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(function3DisabledField, GroupLayout.PREFERRED_SIZE, 20,
									GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(keyword4InfoLabel, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(keyword4HashLabel, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(keyword4FormattedField, GroupLayout.PREFERRED_SIZE, 51,
									GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(keyword4DisabledField, GroupLayout.PREFERRED_SIZE, 20,
									GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(operatorInfoLabel, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(operatorHashLabel, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(operatorFormattedField, GroupLayout.PREFERRED_SIZE, 51,
									GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(operatorDisabledField, GroupLayout.PREFERRED_SIZE, 20,
									GroupLayout.PREFERRED_SIZE).addContainerGap(15, Short.MAX_VALUE))
					.addGroup(
							layout.createSequentialGroup().addContainerGap()
									.addComponent(function4InfoLabel, GroupLayout.PREFERRED_SIZE, 56,
											GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(function4HashLabel, GroupLayout.PREFERRED_SIZE, 8,
											GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(function4FormattedField, GroupLayout.PREFERRED_SIZE, 51,
									GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(function4DisabledField, GroupLayout.PREFERRED_SIZE, 20,
									GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(keyword5InfoLabel, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(keyword5HashLabel, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(keyword5FormattedField, GroupLayout.PREFERRED_SIZE, 51,
									GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(keyword5DisabledField, GroupLayout.PREFERRED_SIZE, 20,
									GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(bgColorInfoLabel, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(bgColorHashLabel, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(bgColorFormattedField, GroupLayout.PREFERRED_SIZE, 51,
									GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(bgColorDisabledField, GroupLayout.PREFERRED_SIZE, 20,
									GroupLayout.PREFERRED_SIZE).addContainerGap(15, Short.MAX_VALUE))
					.addGroup(Alignment.LEADING,
							layout.createSequentialGroup().addContainerGap()
									.addComponent(btnImport, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnExport, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 202, Short.MAX_VALUE)
									.addComponent(btnOK, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())
					.addComponent(bottomSeparator, GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE));
			layout.setVerticalGroup(
					layout.createParallelGroup(Alignment.LEADING)
							.addGroup(layout.createSequentialGroup().addContainerGap()
									.addComponent(infoArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(topSeparator, GroupLayout.PREFERRED_SIZE, 2,
											GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
							.addGroup(layout.createSequentialGroup()
									.addGroup(layout.createParallelGroup(Alignment.LEADING)
											.addGroup(layout.createParallelGroup(Alignment.BASELINE)
													.addComponent(comment1InfoLabel).addComponent(comment1HashLabel)
													.addComponent(comment1FormattedField, GroupLayout.PREFERRED_SIZE,
															GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(comment1DisabledField, GroupLayout.PREFERRED_SIZE,
											GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(layout.createSequentialGroup().addGap(3).addComponent(invalidInfoLabel))
									.addGroup(layout.createSequentialGroup().addGap(3).addComponent(invalidHashLabel))
									.addComponent(invalidFormattedField, GroupLayout.PREFERRED_SIZE,
											GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(invalidDisabledField, GroupLayout.PREFERRED_SIZE,
											GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED).addGroup(
									layout.createParallelGroup(Alignment.LEADING)
											.addGroup(layout.createSequentialGroup().addGap(3)
													.addComponent(comment2InfoLabel))
									.addGroup(layout.createSequentialGroup().addGap(3).addComponent(comment2HashLabel))
									.addComponent(comment2FormattedField, GroupLayout.PREFERRED_SIZE,
											GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(comment2DisabledField, GroupLayout.PREFERRED_SIZE,
											GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGroup(layout.createSequentialGroup().addGap(3).addComponent(keyword1InfoLabel))
									.addGroup(layout.createSequentialGroup().addGap(3).addComponent(keyword1HashLabel))
									.addComponent(keyword1FormattedField, GroupLayout.PREFERRED_SIZE,
											GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(keyword1DisabledField, GroupLayout.PREFERRED_SIZE,
											GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGroup(layout.createSequentialGroup()
									.addGroup(layout.createParallelGroup(Alignment.LEADING)
											.addGroup(layout.createSequentialGroup().addGap(3)
													.addComponent(keyword6InfoLabel))
									.addGroup(layout.createSequentialGroup().addGap(3).addComponent(keyword6HashLabel))
									.addComponent(keyword6FormattedField, GroupLayout.PREFERRED_SIZE,
											GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(keyword6DisabledField, GroupLayout.PREFERRED_SIZE,
											GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(layout.createParallelGroup(Alignment.LEADING)
											.addGroup(layout.createSequentialGroup().addGap(3)
													.addComponent(labelInfoLabel))
											.addGroup(layout.createSequentialGroup().addGap(3)
													.addComponent(labelHashLabel))
											.addComponent(labelFormattedField, GroupLayout.PREFERRED_SIZE,
													GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(labelDisabledField, GroupLayout.PREFERRED_SIZE,
													GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(
							ComponentPlacement.RELATED).addGroup(
									layout.createParallelGroup(Alignment.LEADING)
											.addGroup(layout.createSequentialGroup().addGap(3)
													.addComponent(function1InfoLabel))
							.addGroup(layout.createSequentialGroup().addGap(3).addComponent(function1HashLabel))
							.addComponent(function1FormattedField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(function1DisabledField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addGroup(layout.createSequentialGroup().addGap(3).addComponent(keyword2InfoLabel))
							.addGroup(layout.createSequentialGroup().addGap(3).addComponent(keyword2HashLabel))
							.addComponent(keyword2FormattedField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(keyword2DisabledField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addGroup(layout.createSequentialGroup().addGap(3).addComponent(literal1InfoLabel))
							.addGroup(layout.createSequentialGroup().addGap(3).addComponent(literal1HashLabel))
							.addComponent(literal1FormattedField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(literal1DisabledField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)).addPreferredGap(ComponentPlacement.RELATED).addGroup(
											layout.createParallelGroup(Alignment.LEADING)
													.addGroup(layout.createSequentialGroup().addGap(3)
															.addComponent(function2InfoLabel))
									.addGroup(layout.createSequentialGroup().addGap(3).addComponent(function2HashLabel))
									.addComponent(function2FormattedField, GroupLayout.PREFERRED_SIZE,
											GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(function2DisabledField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addGroup(layout.createSequentialGroup().addGap(3).addComponent(keyword3InfoLabel))
							.addGroup(layout.createSequentialGroup().addGap(3).addComponent(keyword3HashLabel))
							.addComponent(keyword3FormattedField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(keyword3DisabledField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addGroup(layout.createSequentialGroup().addGap(3).addComponent(literal2InfoLabel))
							.addGroup(layout.createSequentialGroup().addGap(3).addComponent(literal2HashLabel))
							.addComponent(literal2FormattedField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE).addComponent(literal2DisabledField,
											GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(
							ComponentPlacement.RELATED).addGroup(
									layout.createParallelGroup(Alignment.LEADING)
											.addGroup(layout.createSequentialGroup().addGap(3).addComponent(
													function3InfoLabel))
							.addGroup(layout.createSequentialGroup().addGap(3).addComponent(function3HashLabel))
							.addComponent(function3FormattedField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(function3DisabledField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addGroup(layout.createSequentialGroup().addGap(3).addComponent(keyword4InfoLabel))
							.addGroup(layout.createSequentialGroup().addGap(3).addComponent(keyword4HashLabel))
							.addComponent(keyword4FormattedField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(keyword4DisabledField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addGroup(layout.createSequentialGroup().addGap(3).addComponent(operatorInfoLabel))
							.addGroup(layout.createSequentialGroup().addGap(3).addComponent(operatorHashLabel))
							.addComponent(operatorFormattedField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(operatorDisabledField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)).addPreferredGap(ComponentPlacement.RELATED).addGroup(
											layout.createParallelGroup(Alignment.LEADING)
													.addGroup(layout.createSequentialGroup().addGap(3)
															.addComponent(bgColorInfoLabel))
									.addGroup(layout.createSequentialGroup().addGap(3).addComponent(bgColorHashLabel))
									.addComponent(bgColorFormattedField, GroupLayout.PREFERRED_SIZE,
											GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(bgColorDisabledField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addGroup(layout.createSequentialGroup().addGap(3).addComponent(keyword5InfoLabel))
							.addGroup(layout.createSequentialGroup().addGap(3).addComponent(keyword5HashLabel))
							.addComponent(keyword5FormattedField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(keyword5DisabledField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addGroup(layout.createSequentialGroup().addGap(3).addComponent(function4InfoLabel))
							.addGroup(layout.createSequentialGroup().addGap(3).addComponent(function4HashLabel))
							.addComponent(function4FormattedField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE).addComponent(function4DisabledField,
											GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE))
					.addGap(13)
					.addComponent(bottomSeparator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
							GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(btnImport)
							.addComponent(btnExport).addComponent(btnCancel).addComponent(btnOK)).addContainerGap()));

			getContentPane().setLayout(layout);

			// Wrapping up - set a preferred size, center the frame and display

			setPreferredSize(new Dimension(540, 300));
			setResizable(false);

			pack();

			setLocationRelativeTo(null);

			setVisible(true);
		} catch (Exception e) {
			System.out.println(FontHighlightingConstants.FRAME_SETUP_EXCEPTION);
			e.printStackTrace();
		}
	}

	private void applyPreferences() {
		// TODO: implement this
		dispose();
	}

	// Old factory code here
	//
	// /**
	// * Sets up a disabled "text field" used to call colorChooser and show the
	// * current color selection
	// *
	// * @param preferenceName
	// * The name of the preference the field refers to
	// * @return A fully setup JTextField variable
	// */
	// private JTextField setupTextField(String preferenceName) {
	// JTextField field = new JTextField(" ");
	// field.setOpaque(true);
	// field.setEnabled(false);
	// field.setBorder(cb);
	// field.setBackground(FontHighlightingHelpers.extractColor(preferenceName));
	// return field;
	// }
	//
	// /**
	// * Sets up a text field used to actually edit the preference
	// *
	// * @param preferenceName
	// * The name of the preference the field refers to
	// * @param comment1DisabledField
	// * A disabled text field (see above)
	// * @return A fully setup JTextField variable
	// */
	// private JTextField setupHexField(String preferenceName, final JTextField
	// comment1DisabledField) {
	// final JTextField hexField = new JTextField(6);
	// hexField.setText(FontHighlightingHelpers.extractColorString(preferenceName));
	// hexField.getDocument().addDocumentListener(new DocumentListener() {
	//
	// @Override
	// public void removeUpdate(DocumentEvent e) {
	// final String colorValue = hexField.getText().toUpperCase();
	// if (colorValue.length() == 7 && (colorValue.startsWith("#")))
	// SwingUtilities.invokeLater(new Runnable() {
	// public void run() {
	// hexField.setText(colorValue.substring(1));
	// }
	// });
	// if (colorValue.length() == 6 &&
	// colorValue.matches("[0123456789ABCDEF]*")) {
	// comment1DisabledField.setBackground(new
	// Color(PApplet.unhex(colorValue)));
	// if (!colorValue.equals(hexField.getText()))
	// SwingUtilities.invokeLater(new Runnable() {
	// public void run() {
	// hexField.setText(colorValue);
	// }
	// });
	// }
	// }
	//
	// @Override
	// public void insertUpdate(DocumentEvent e) {
	// final String colorValue = hexField.getText().toUpperCase();
	// if (colorValue.length() == 7 && (colorValue.startsWith("#")))
	// SwingUtilities.invokeLater(new Runnable() {
	// public void run() {
	// hexField.setText(colorValue.substring(1));
	// }
	// });
	// if (colorValue.length() == 6 &&
	// colorValue.matches("[0123456789ABCDEF]*")) {
	// comment1DisabledField.setBackground(new
	// Color(PApplet.unhex(colorValue)));
	// if (!colorValue.equals(hexField.getText()))
	// SwingUtilities.invokeLater(new Runnable() {
	// public void run() {
	// hexField.setText(colorValue);
	// }
	// });
	// }
	// }
	//
	// @Override
	// public void changedUpdate(DocumentEvent e) {
	// }
	// });
	// return hexField;
	// }
	//
	// /**
	// * Sets up the mouse listener that makes an (invisible) text field
	// activate
	// * a ColorChooser
	// *
	// * @param comment1DisabledField
	// * A disabled text field (see above)
	// * @param chooser
	// * A ColorChooser instance
	// */
	// private void setupMouseListener(final JTextField comment1DisabledField,
	// final
	// ColorChooser chooser) {
	// comment1DisabledField.addMouseListener(new MouseAdapter() {
	// @Override
	// public void mouseExited(MouseEvent e) {
	// setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	// }
	//
	// @Override
	// public void mouseEntered(MouseEvent e) {
	// setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	// }
	//
	// @Override
	// public void mouseClicked(MouseEvent e) {
	// chooser.show();
	// }
	// });
	// }

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
