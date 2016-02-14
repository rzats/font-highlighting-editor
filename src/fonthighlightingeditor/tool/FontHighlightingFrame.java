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

import processing.app.Base;

import fonthighlightingeditor.constants.FontHighlightingConstants;
import fonthighlightingeditor.utils.FontHighlightingHelpers;

public class FontHighlightingFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	private Base base;

	private GroupLayout layout;

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
			// Set the frame title
			setTitle(FontHighlightingConstants.TOOL_NAME);

			// Set the frame icons (used IDE icons from Processing/lib/icons)

			List<Image> icons = new ArrayList<Image>();

			icons.add(FontHighlightingHelpers.loadImage(FontHighlightingConstants.PDE_ICON_16));
			icons.add(FontHighlightingHelpers.loadImage(FontHighlightingConstants.PDE_ICON_32));

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
					disposeFrame();
				}
			});

			// These are still TBA - disable for now

			final JButton btnImport = new JButton("Import");
			btnImport.setEnabled(false);
			final JButton btnExport = new JButton("Export");
			btnExport.setEnabled(false);

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

			String currentPreference;

			// comment1

			currentPreference = "comment1";

			final JLabel comment1InfoLabel = FontHighlightingFactory.createInfoLabel(currentPreference);

			final JLabel comment1HashLabel = FontHighlightingFactory.createHashLabel();

			comment1DisabledField = FontHighlightingFactory.createDisabledTextField(currentPreference);

			final JFormattedTextField comment1FormattedField = FontHighlightingFactory
					.createFormattedTextField(currentPreference, comment1DisabledField);

			// comment2

			currentPreference = "comment2";

			final JLabel comment2InfoLabel = FontHighlightingFactory.createInfoLabel(currentPreference);

			final JLabel comment2HashLabel = FontHighlightingFactory.createHashLabel();

			comment2DisabledField = FontHighlightingFactory.createDisabledTextField(currentPreference);

			final JFormattedTextField comment2FormattedField = FontHighlightingFactory
					.createFormattedTextField(currentPreference, comment2DisabledField);

			// function1

			currentPreference = "function1";

			final JLabel function1InfoLabel = FontHighlightingFactory.createInfoLabel(currentPreference);

			final JLabel function1HashLabel = FontHighlightingFactory.createHashLabel();

			function1DisabledField = FontHighlightingFactory.createDisabledTextField(currentPreference);

			final JFormattedTextField function1FormattedField = FontHighlightingFactory
					.createFormattedTextField(currentPreference, function1DisabledField);

			// function2

			currentPreference = "function2";

			final JLabel function2InfoLabel = FontHighlightingFactory.createInfoLabel(currentPreference);

			final JLabel function2HashLabel = FontHighlightingFactory.createHashLabel();

			function2DisabledField = FontHighlightingFactory.createDisabledTextField(currentPreference);

			final JFormattedTextField function2FormattedField = FontHighlightingFactory
					.createFormattedTextField(currentPreference, function2DisabledField);

			// function3

			currentPreference = "function3";

			final JLabel function3InfoLabel = FontHighlightingFactory.createInfoLabel(currentPreference);

			final JLabel function3HashLabel = FontHighlightingFactory.createHashLabel();

			function3DisabledField = FontHighlightingFactory.createDisabledTextField(currentPreference);

			final JFormattedTextField function3FormattedField = FontHighlightingFactory
					.createFormattedTextField(currentPreference, function3DisabledField);

			// function4

			currentPreference = "function4";

			final JLabel function4InfoLabel = FontHighlightingFactory.createInfoLabel(currentPreference);

			final JLabel function4HashLabel = FontHighlightingFactory.createHashLabel();

			function4DisabledField = FontHighlightingFactory.createDisabledTextField(currentPreference);

			final JFormattedTextField function4FormattedField = FontHighlightingFactory
					.createFormattedTextField(currentPreference, function4DisabledField);

			// invalid

			currentPreference = "invalid";

			final JLabel invalidInfoLabel = FontHighlightingFactory.createInfoLabel(currentPreference);

			final JLabel invalidHashLabel = FontHighlightingFactory.createHashLabel();

			invalidDisabledField = FontHighlightingFactory.createDisabledTextField(currentPreference);

			final JFormattedTextField invalidFormattedField = FontHighlightingFactory
					.createFormattedTextField(currentPreference, invalidDisabledField);

			// keyword1

			currentPreference = "keyword1";

			final JLabel keyword1InfoLabel = FontHighlightingFactory.createInfoLabel(currentPreference);

			final JLabel keyword1HashLabel = FontHighlightingFactory.createHashLabel();

			keyword1DisabledField = FontHighlightingFactory.createDisabledTextField(currentPreference);

			final JFormattedTextField keyword1FormattedField = FontHighlightingFactory
					.createFormattedTextField(currentPreference, keyword1DisabledField);

			// keyword2
			currentPreference = "keyword2";

			final JLabel keyword2InfoLabel = FontHighlightingFactory.createInfoLabel(currentPreference);

			final JLabel keyword2HashLabel = FontHighlightingFactory.createHashLabel();

			keyword2DisabledField = FontHighlightingFactory.createDisabledTextField(currentPreference);

			final JFormattedTextField keyword2FormattedField = FontHighlightingFactory
					.createFormattedTextField(currentPreference, keyword2DisabledField);

			// keyword3
			currentPreference = "keyword3";

			final JLabel keyword3InfoLabel = FontHighlightingFactory.createInfoLabel(currentPreference);

			final JLabel keyword3HashLabel = FontHighlightingFactory.createHashLabel();

			keyword3DisabledField = FontHighlightingFactory.createDisabledTextField(currentPreference);

			final JFormattedTextField keyword3FormattedField = FontHighlightingFactory
					.createFormattedTextField(currentPreference, keyword3DisabledField);

			// keyword4
			currentPreference = "keyword4";

			final JLabel keyword4InfoLabel = FontHighlightingFactory.createInfoLabel(currentPreference);

			final JLabel keyword4HashLabel = FontHighlightingFactory.createHashLabel();

			keyword4DisabledField = FontHighlightingFactory.createDisabledTextField(currentPreference);

			final JFormattedTextField keyword4FormattedField = FontHighlightingFactory
					.createFormattedTextField(currentPreference, keyword4DisabledField);

			// keyword5
			currentPreference = "keyword5";

			final JLabel keyword5InfoLabel = FontHighlightingFactory.createInfoLabel(currentPreference);

			final JLabel keyword5HashLabel = FontHighlightingFactory.createHashLabel();

			keyword5DisabledField = FontHighlightingFactory.createDisabledTextField(currentPreference);

			final JFormattedTextField keyword5FormattedField = FontHighlightingFactory
					.createFormattedTextField(currentPreference, keyword5DisabledField);

			// keyword6
			currentPreference = "keyword6";

			final JLabel keyword6InfoLabel = FontHighlightingFactory.createInfoLabel(currentPreference);

			final JLabel keyword6HashLabel = FontHighlightingFactory.createHashLabel();

			keyword6DisabledField = FontHighlightingFactory.createDisabledTextField(currentPreference);

			final JFormattedTextField keyword6FormattedField = FontHighlightingFactory
					.createFormattedTextField(currentPreference, keyword6DisabledField);

			// label
			currentPreference = "label";

			final JLabel labelInfoLabel = FontHighlightingFactory.createInfoLabel(currentPreference);

			final JLabel labelHashLabel = FontHighlightingFactory.createHashLabel();

			labelDisabledField = FontHighlightingFactory.createDisabledTextField(currentPreference);

			final JFormattedTextField labelFormattedField = FontHighlightingFactory
					.createFormattedTextField(currentPreference, labelDisabledField);

			// literal1
			currentPreference = "literal1";

			final JLabel literal1InfoLabel = FontHighlightingFactory.createInfoLabel(currentPreference);

			final JLabel literal1HashLabel = FontHighlightingFactory.createHashLabel();

			literal1DisabledField = FontHighlightingFactory.createDisabledTextField(currentPreference);

			final JFormattedTextField literal1FormattedField = FontHighlightingFactory
					.createFormattedTextField(currentPreference, literal1DisabledField);

			// literal2
			currentPreference = "literal2";

			final JLabel literal2InfoLabel = FontHighlightingFactory.createInfoLabel(currentPreference);

			final JLabel literal2HashLabel = FontHighlightingFactory.createHashLabel();

			literal2DisabledField = FontHighlightingFactory.createDisabledTextField(currentPreference);

			final JFormattedTextField literal2FormattedField = FontHighlightingFactory
					.createFormattedTextField(currentPreference, literal2DisabledField);

			// operator
			currentPreference = "operator";

			final JLabel operatorInfoLabel = FontHighlightingFactory.createInfoLabel(currentPreference);

			final JLabel operatorHashLabel = FontHighlightingFactory.createHashLabel();

			operatorDisabledField = FontHighlightingFactory.createDisabledTextField(currentPreference);

			final JFormattedTextField operatorFormattedField = FontHighlightingFactory
					.createFormattedTextField(currentPreference, operatorDisabledField);

			// bgcolor
			currentPreference = "bgcolor";

			final JLabel bgColorInfoLabel = FontHighlightingFactory.createInfoLabel(currentPreference);

			final JLabel bgColorHashLabel = FontHighlightingFactory.createHashLabel();

			bgColorDisabledField = FontHighlightingFactory.createDisabledTextField(currentPreference);

			final JFormattedTextField bgColorFormattedField = FontHighlightingFactory
					.createFormattedTextField(currentPreference, bgColorDisabledField);

			/*
			 * Setup the layout
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
			addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					disposeFrame();
				}
			});

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
		try {
			/*
			 * Using this approach because it automatically discards invalid
			 * data typed in manually
			 * 
			 * TODO: find out which of these are actually used by anything
			 */
			FontHighlightingHelpers.setPreference("comment1", comment1DisabledField.getBackground());
			FontHighlightingHelpers.setPreference("comment2", comment2DisabledField.getBackground());
			FontHighlightingHelpers.setPreference("function1", function1DisabledField.getBackground());
			FontHighlightingHelpers.setPreference("function2", function2DisabledField.getBackground());
			FontHighlightingHelpers.setPreference("function3", function3DisabledField.getBackground());
			FontHighlightingHelpers.setPreference("function4", function4DisabledField.getBackground());
			FontHighlightingHelpers.setPreference("invalid", invalidDisabledField.getBackground());
			FontHighlightingHelpers.setPreference("keyword1", keyword1DisabledField.getBackground());
			FontHighlightingHelpers.setPreference("keyword2", keyword2DisabledField.getBackground());
			FontHighlightingHelpers.setPreference("keyword3", keyword3DisabledField.getBackground());
			FontHighlightingHelpers.setPreference("keyword4", keyword4DisabledField.getBackground());
			FontHighlightingHelpers.setPreference("keyword5", keyword5DisabledField.getBackground());
			FontHighlightingHelpers.setPreference("keyword6", keyword6DisabledField.getBackground());
			FontHighlightingHelpers.setPreference("label", labelDisabledField.getBackground());
			FontHighlightingHelpers.setPreference("literal1", literal1DisabledField.getBackground());
			FontHighlightingHelpers.setPreference("literal2", literal2DisabledField.getBackground());
			FontHighlightingHelpers.setPreference("operator", operatorDisabledField.getBackground());
			FontHighlightingHelpers.setPreference("bgcolor", bgColorDisabledField.getBackground());

			JOptionPane.showMessageDialog(null, "A restart is required to apply the changes.", "Warning",
					JOptionPane.WARNING_MESSAGE);
			disposeFrame();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void disposeFrame() {
		dispose();
	}
}
