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

import processing.app.*;
import processing.app.ui.ColorChooser;

import fonthighlightingeditor.utils.*;

public class FontHighlightingFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	private Base base;

	private GroupLayout layout;
	private JFormattedTextField formattedFieldComment1;
	private JFormattedTextField formattedFieldComment2;
	private JFormattedTextField formattedFieldFunction1;
	private JFormattedTextField formattedFieldFunction2;
	private JFormattedTextField formattedFieldFunction3;
	private JFormattedTextField formattedFieldFunction4;
	private JFormattedTextField formattedFieldInvalid;
	private JFormattedTextField formattedFieldKeyword1;
	private JFormattedTextField formattedFieldKeyword2;
	private JTextField disabledFieldComment1;
	private JTextField disabledFieldComment2;
	private JTextField disabledFieldFunction1;
	private JTextField disabledFieldFunction2;
	private JTextField disabledFieldFunction3;
	private JTextField disabledFieldFunction4;
	private JTextField disabledFieldInvalid;
	private JTextField disabledFieldKeyword1;
	private JTextField disabledFieldKeyword2;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTextField textField_29;
	private JTextField textField_30;
	private JTextField textField_31;
	private JTextField textField_32;
	private JTextField textField_33;
	private JTextField textField_34;
	private JTextField textField_35;
	private ColorChooser colorChooserComment1;
	private ColorChooser colorChooserComment2;
	private ColorChooser colorChooserFunction1;
	private ColorChooser colorChooserFunction2;
	private ColorChooser colorChooserFunction3;
	private ColorChooser colorChooserFunction4;
	private ColorChooser colorChooserInvalid;
	private ColorChooser colorChooserKeyword1;
	private ColorChooser colorChooserKeyword2;

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
			setTitle(ToolConstants.TOOL_NAME);

			// Set the frame icons (used IDE icons from Processing/lib/icons)

			List<Image> icons = new ArrayList<Image>();

			icons.add(ToolHelpers.loadImage(ToolConstants.PDE_ICON_16));
			icons.add(ToolHelpers.loadImage(ToolConstants.PDE_ICON_32));

			setIconImages(icons);

			// Set up a common font

			Font f = new Font("Dialog", Font.PLAIN, 12);
			UIManager.put("Button.font", f);
			UIManager.put("TextArea.font", f);

			// Info
			final JLabel lblNewLabel = new JLabel(ToolConstants.HEADER_MESSAGE);

			// -----
			final JSeparator topSeparator = new JSeparator();

			/*
			 * Setting up all the components. Tried to make this as much DRY as
			 * possible (ComponentCreator really helps) but alas.
			 */

			// comment1

			// This is just to avoid accidental mismatches
			String currentPreference = "comment1";

			final JLabel infoLabelComment1 = ComponentCreator.createInfoLabel(currentPreference);
			final JLabel hashLabelComment1 = ComponentCreator.createHashLabel();

			disabledFieldComment1 = ComponentCreator.createDisabledTextField(currentPreference);
			formattedFieldComment1 = ComponentCreator.createFormattedTextField(currentPreference,
					disabledFieldComment1);

			/*
			 * Can't place this inside a helper method because the
			 * ActionListener refers to the colorChooser variable
			 */
			colorChooserComment1 = new ColorChooser(this, false, ToolHelpers.extractColor(currentPreference),
					Language.text("prompt.ok"), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							String colorValue = colorChooserComment1.getHexColor();
							formattedFieldComment1.setText(colorValue.substring(1));
							colorChooserComment1.hide();
						}
					});

			ComponentCreator.setupMouseListener(this, disabledFieldComment1, colorChooserComment1);

			// comment2
			currentPreference = "comment2";

			final JLabel infoLabelComment2 = ComponentCreator.createInfoLabel(currentPreference);
			final JLabel hashLabelComment2 = ComponentCreator.createHashLabel();

			disabledFieldComment2 = ComponentCreator.createDisabledTextField(currentPreference);
			formattedFieldComment2 = ComponentCreator.createFormattedTextField(currentPreference,
					disabledFieldComment2);

			colorChooserComment2 = new ColorChooser(this, false, ToolHelpers.extractColor(currentPreference),
					Language.text("prompt.ok"), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							String colorValue = colorChooserComment2.getHexColor();
							formattedFieldComment2.setText(colorValue.substring(1));
							colorChooserComment2.hide();
						}
					});

			ComponentCreator.setupMouseListener(this, disabledFieldComment2, colorChooserComment2);

			// function1
			currentPreference = "function1";

			final JLabel infoLabelFunction1 = ComponentCreator.createInfoLabel(currentPreference);
			final JLabel hashLabelFunction1 = ComponentCreator.createHashLabel();

			disabledFieldFunction1 = ComponentCreator.createDisabledTextField(currentPreference);
			formattedFieldFunction1 = ComponentCreator.createFormattedTextField(currentPreference,
					disabledFieldFunction1);

			colorChooserFunction1 = new ColorChooser(this, false, ToolHelpers.extractColor(currentPreference),
					Language.text("prompt.ok"), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							String colorValue = colorChooserFunction1.getHexColor();
							formattedFieldFunction1.setText(colorValue.substring(1));
							colorChooserFunction1.hide();
						}
					});

			ComponentCreator.setupMouseListener(this, disabledFieldFunction1, colorChooserFunction1);

			// function2
			currentPreference = "function2";

			final JLabel infoLabelFunction2 = ComponentCreator.createInfoLabel(currentPreference);
			final JLabel hashLabelFunction2 = ComponentCreator.createHashLabel();

			disabledFieldFunction2 = ComponentCreator.createDisabledTextField(currentPreference);
			formattedFieldFunction2 = ComponentCreator.createFormattedTextField(currentPreference,
					disabledFieldFunction2);

			colorChooserFunction2 = new ColorChooser(this, false, ToolHelpers.extractColor(currentPreference),
					Language.text("prompt.ok"), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							String colorValue = colorChooserFunction2.getHexColor();
							formattedFieldFunction2.setText(colorValue.substring(1));
							colorChooserFunction2.hide();
						}
					});

			ComponentCreator.setupMouseListener(this, disabledFieldFunction2, colorChooserFunction2);

			// function3
			currentPreference = "function3";

			final JLabel infoLabelFunction3 = ComponentCreator.createInfoLabel(currentPreference);
			final JLabel hashLabelFunction3 = ComponentCreator.createHashLabel();

			disabledFieldFunction3 = ComponentCreator.createDisabledTextField(currentPreference);
			formattedFieldFunction3 = ComponentCreator.createFormattedTextField(currentPreference,
					disabledFieldFunction3);

			colorChooserFunction3 = new ColorChooser(this, false, ToolHelpers.extractColor(currentPreference),
					Language.text("prompt.ok"), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							String colorValue = colorChooserFunction3.getHexColor();
							formattedFieldFunction3.setText(colorValue.substring(1));
							colorChooserFunction3.hide();
						}
					});

			ComponentCreator.setupMouseListener(this, disabledFieldFunction3, colorChooserFunction3);

			// function4
			currentPreference = "function4";

			final JLabel infoLabelFunction4 = ComponentCreator.createInfoLabel(currentPreference);
			final JLabel hashLabelFunction4 = ComponentCreator.createHashLabel();

			disabledFieldFunction4 = ComponentCreator.createDisabledTextField(currentPreference);
			formattedFieldFunction4 = ComponentCreator.createFormattedTextField(currentPreference,
					disabledFieldFunction4);

			colorChooserFunction4 = new ColorChooser(this, false, ToolHelpers.extractColor(currentPreference),
					Language.text("prompt.ok"), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							String colorValue = colorChooserFunction4.getHexColor();
							formattedFieldFunction4.setText(colorValue.substring(1));
							colorChooserFunction4.hide();
						}
					});

			ComponentCreator.setupMouseListener(this, disabledFieldFunction4, colorChooserFunction4);

			// invalid
			currentPreference = "invalid";

			final JLabel infoLabelInvalid = ComponentCreator.createInfoLabel(currentPreference);
			final JLabel hashLabelInvalid = ComponentCreator.createHashLabel();

			disabledFieldInvalid = ComponentCreator.createDisabledTextField(currentPreference);
			formattedFieldInvalid = ComponentCreator.createFormattedTextField(currentPreference, disabledFieldInvalid);

			colorChooserInvalid = new ColorChooser(this, false, ToolHelpers.extractColor(currentPreference),
					Language.text("prompt.ok"), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							String colorValue = colorChooserInvalid.getHexColor();
							formattedFieldInvalid.setText(colorValue.substring(1));
							colorChooserInvalid.hide();
						}
					});

			ComponentCreator.setupMouseListener(this, disabledFieldInvalid, colorChooserInvalid);

			// keyword1
			currentPreference = "keyword1";

			final JLabel infoLabelKeyword1 = ComponentCreator.createInfoLabel(currentPreference);
			final JLabel hashLabelKeyword1 = ComponentCreator.createHashLabel();

			disabledFieldKeyword1 = ComponentCreator.createDisabledTextField(currentPreference);
			formattedFieldKeyword1 = ComponentCreator.createFormattedTextField(currentPreference,
					disabledFieldKeyword1);

			colorChooserKeyword1 = new ColorChooser(this, false, ToolHelpers.extractColor(currentPreference),
					Language.text("prompt.ok"), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							String colorValue = colorChooserKeyword1.getHexColor();
							formattedFieldKeyword1.setText(colorValue.substring(1));
							colorChooserKeyword1.hide();
						}
					});

			ComponentCreator.setupMouseListener(this, disabledFieldKeyword1, colorChooserKeyword1);

			// keyword2
			currentPreference = "keyword2";

			final JLabel infoLabelKeyword2 = ComponentCreator.createInfoLabel(currentPreference);
			final JLabel hashLabelKeyword2 = ComponentCreator.createHashLabel();

			disabledFieldKeyword2 = ComponentCreator.createDisabledTextField(currentPreference);
			formattedFieldKeyword2 = ComponentCreator.createFormattedTextField(currentPreference,
					disabledFieldKeyword2);

			colorChooserKeyword2 = new ColorChooser(this, false, ToolHelpers.extractColor(currentPreference),
					Language.text("prompt.ok"), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							String colorValue = colorChooserKeyword2.getHexColor();
							formattedFieldKeyword2.setText(colorValue.substring(1));
							colorChooserKeyword2.hide();
						}
					});

			ComponentCreator.setupMouseListener(this, disabledFieldKeyword2, colorChooserKeyword2);

			final JLabel label_17 = new JLabel("comment1:");

			final JLabel label_18 = new JLabel("comment1:");

			final JLabel label_19 = new JLabel("comment1:");

			final JLabel label_20 = new JLabel("comment1:");

			final JLabel label_21 = new JLabel("comment1:");

			final JLabel label_22 = new JLabel("comment1:");

			final JLabel label_23 = new JLabel("comment1:");

			final JLabel label_24 = new JLabel("comment1:");

			final JLabel label_25 = new JLabel("comment1:");

			final JLabel label_26 = ComponentCreator.createHashLabel();

			final JLabel label_27 = ComponentCreator.createHashLabel();

			final JLabel label_28 = ComponentCreator.createHashLabel();

			final JLabel label_29 = ComponentCreator.createHashLabel();

			final JLabel label_30 = ComponentCreator.createHashLabel();

			final JLabel label_31 = ComponentCreator.createHashLabel();

			final JLabel label_32 = ComponentCreator.createHashLabel();

			final JLabel label_33 = ComponentCreator.createHashLabel();

			final JLabel label_34 = ComponentCreator.createHashLabel();

			textField_18 = new JTextField();
			textField_18.setColumns(10);

			textField_19 = new JTextField();
			textField_19.setColumns(10);

			textField_20 = new JTextField();
			textField_20.setColumns(10);

			textField_21 = new JTextField();
			textField_21.setColumns(10);

			textField_22 = new JTextField();
			textField_22.setColumns(10);

			textField_23 = new JTextField();
			textField_23.setColumns(10);

			textField_24 = new JTextField();
			textField_24.setColumns(10);

			textField_25 = new JTextField();
			textField_25.setColumns(10);

			textField_26 = new JTextField();
			textField_26.setColumns(10);

			textField_27 = new JTextField();
			textField_27.setEditable(false);
			textField_27.setColumns(10);

			textField_28 = new JTextField();
			textField_28.setEditable(false);
			textField_28.setColumns(10);

			textField_29 = new JTextField();
			textField_29.setEditable(false);
			textField_29.setColumns(10);

			textField_30 = new JTextField();
			textField_30.setEditable(false);
			textField_30.setColumns(10);

			textField_31 = new JTextField();
			textField_31.setEditable(false);
			textField_31.setColumns(10);

			textField_32 = new JTextField();
			textField_32.setEditable(false);
			textField_32.setColumns(10);

			textField_33 = new JTextField();
			textField_33.setEditable(false);
			textField_33.setColumns(10);

			textField_34 = new JTextField();
			textField_34.setEditable(false);
			textField_34.setColumns(10);

			textField_35 = new JTextField();
			textField_35.setEditable(false);
			textField_35.setColumns(10);

			// -----
			final JSeparator bottomSeparator = new JSeparator();

			// [Discard Changes]
			final JButton btnDiscardChanges = new JButton("Discard Changes");

			// [OK]
			final JButton btnOK = new JButton("OK");
			btnOK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					applyChanges();
				}
			});

			// [Cancel]
			final JButton btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					disposeFrame();
				}
			});

			// Layout setup
			layout = new GroupLayout(getContentPane());
			layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
					.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(btnDiscardChanges)
							.addPreferredGap(ComponentPlacement.RELATED, 343, Short.MAX_VALUE).addComponent(btnOK)
							.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnCancel).addContainerGap())
					.addComponent(bottomSeparator, GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
					.addGroup(
							layout.createSequentialGroup().addContainerGap()
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 495,
											GroupLayout.PREFERRED_SIZE)
									.addContainerGap(89, Short.MAX_VALUE))
					.addComponent(topSeparator, GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
					.addGroup(
							layout.createSequentialGroup().addContainerGap()
									.addComponent(infoLabelComment1, GroupLayout.PREFERRED_SIZE, 96,
											GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(hashLabelComment1, GroupLayout.PREFERRED_SIZE, 40,
											GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(formattedFieldComment1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(disabledFieldComment1, GroupLayout.PREFERRED_SIZE, 26,
									GroupLayout.PREFERRED_SIZE).addGap(18)
							.addComponent(label_17, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_26, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_18, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_27, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addGap(18))
					.addGroup(
							layout.createSequentialGroup().addContainerGap()
									.addComponent(infoLabelComment2, GroupLayout.PREFERRED_SIZE, 96,
											GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(hashLabelComment2, GroupLayout.PREFERRED_SIZE, 40,
											GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(formattedFieldComment2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(disabledFieldComment2, GroupLayout.PREFERRED_SIZE, 26,
									GroupLayout.PREFERRED_SIZE).addGap(18)
							.addComponent(label_18, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_27, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_19, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_28, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(18, Short.MAX_VALUE))
					.addGroup(layout.createSequentialGroup().addContainerGap()
							.addComponent(infoLabelFunction1, GroupLayout.PREFERRED_SIZE, 96,
									GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(hashLabelFunction1, GroupLayout.PREFERRED_SIZE, 40,
									GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(formattedFieldFunction1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(disabledFieldFunction1, GroupLayout.PREFERRED_SIZE, 26,
									GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(label_19, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_28, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_20, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_29, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(18, Short.MAX_VALUE))
					.addGroup(layout.createSequentialGroup().addContainerGap()
							.addComponent(infoLabelFunction2, GroupLayout.PREFERRED_SIZE, 96,
									GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(hashLabelFunction2, GroupLayout.PREFERRED_SIZE, 40,
									GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(formattedFieldFunction2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(disabledFieldFunction2, GroupLayout.PREFERRED_SIZE, 26,
									GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(label_20, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_29, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_21, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_30, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(18, Short.MAX_VALUE))
					.addGroup(layout.createSequentialGroup().addContainerGap()
							.addComponent(infoLabelFunction3, GroupLayout.PREFERRED_SIZE, 96,
									GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(hashLabelFunction3, GroupLayout.PREFERRED_SIZE, 40,
									GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(formattedFieldFunction3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(disabledFieldFunction3, GroupLayout.PREFERRED_SIZE, 26,
									GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(label_21, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_30, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_22, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_31, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(18, Short.MAX_VALUE))
					.addGroup(layout.createSequentialGroup().addContainerGap()
							.addComponent(infoLabelFunction4, GroupLayout.PREFERRED_SIZE, 96,
									GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(hashLabelFunction4, GroupLayout.PREFERRED_SIZE, 40,
									GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(formattedFieldFunction4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(disabledFieldFunction4, GroupLayout.PREFERRED_SIZE, 26,
									GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(label_22, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_31, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_23, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_32, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(18, Short.MAX_VALUE))
					.addGroup(
							layout.createSequentialGroup().addContainerGap()
									.addComponent(infoLabelInvalid, GroupLayout.PREFERRED_SIZE, 96,
											GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(hashLabelInvalid, GroupLayout.PREFERRED_SIZE, 40,
											GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(formattedFieldInvalid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(disabledFieldInvalid, GroupLayout.PREFERRED_SIZE, 26,
									GroupLayout.PREFERRED_SIZE).addGap(18)
							.addComponent(label_23, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_32, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_24, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_33, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(18, Short.MAX_VALUE))
					.addGroup(
							layout.createSequentialGroup().addContainerGap()
									.addComponent(infoLabelKeyword1, GroupLayout.PREFERRED_SIZE, 96,
											GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(hashLabelKeyword1, GroupLayout.PREFERRED_SIZE, 40,
											GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(formattedFieldKeyword1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(disabledFieldKeyword1, GroupLayout.PREFERRED_SIZE, 26,
									GroupLayout.PREFERRED_SIZE).addGap(18)
							.addComponent(label_24, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_33, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_25, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_34, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(18, Short.MAX_VALUE))
					.addGroup(
							layout.createSequentialGroup().addContainerGap()
									.addComponent(infoLabelKeyword2, GroupLayout.PREFERRED_SIZE, 96,
											GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(hashLabelKeyword2, GroupLayout.PREFERRED_SIZE, 40,
											GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(formattedFieldKeyword2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(disabledFieldKeyword2, GroupLayout.PREFERRED_SIZE, 26,
									GroupLayout.PREFERRED_SIZE).addGap(18)
							.addComponent(label_25, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_34, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_26, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_35, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(18, Short.MAX_VALUE)));
			layout.setVerticalGroup(
					layout.createParallelGroup(Alignment.TRAILING)
							.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(topSeparator, GroupLayout.PREFERRED_SIZE, 2,
											GroupLayout.PREFERRED_SIZE)
					.addGap(14)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(infoLabelComment1)
							.addComponent(hashLabelComment1)
							.addComponent(formattedFieldComment1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(disabledFieldComment1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(label_17).addComponent(label_26)
							.addComponent(textField_18, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(textField_27, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(infoLabelComment2)
							.addComponent(hashLabelComment2)
							.addComponent(formattedFieldComment2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(disabledFieldComment2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(label_18).addComponent(label_27)
							.addComponent(textField_19, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(textField_28, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(infoLabelFunction1)
							.addComponent(hashLabelFunction1)
							.addComponent(formattedFieldFunction1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(disabledFieldFunction1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(label_19).addComponent(label_28)
							.addComponent(textField_20, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(textField_29, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(infoLabelFunction2)
							.addComponent(hashLabelFunction2)
							.addComponent(formattedFieldFunction2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(disabledFieldFunction2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(label_20).addComponent(label_29)
							.addComponent(textField_21, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(textField_30, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(infoLabelFunction3)
							.addComponent(hashLabelFunction3)
							.addComponent(formattedFieldFunction3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(disabledFieldFunction3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(label_21).addComponent(label_30)
							.addComponent(textField_22, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(textField_31, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(infoLabelFunction4)
							.addComponent(hashLabelFunction4)
							.addComponent(formattedFieldFunction4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(disabledFieldFunction4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(label_22).addComponent(label_31)
							.addComponent(textField_23, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(textField_32, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(infoLabelInvalid)
							.addComponent(hashLabelInvalid)
							.addComponent(formattedFieldInvalid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(disabledFieldInvalid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(label_23).addComponent(label_32)
							.addComponent(textField_24, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(textField_33, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(infoLabelKeyword1)
							.addComponent(hashLabelKeyword1)
							.addComponent(formattedFieldKeyword1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(disabledFieldKeyword1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(label_24).addComponent(label_33)
							.addComponent(textField_25, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(textField_34, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(infoLabelKeyword2)
							.addComponent(hashLabelKeyword2)
							.addComponent(formattedFieldKeyword2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(disabledFieldKeyword2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(label_25).addComponent(label_34)
							.addComponent(textField_26, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(textField_35, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
					.addComponent(bottomSeparator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
							GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(btnCancel).addComponent(btnOK)
							.addComponent(btnDiscardChanges)).addContainerGap()));
			getContentPane().setLayout(layout);

			// Wrapping up - set a preferred size, center the frame and display
			addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					disposeFrame();
				}
			});

			if (Platform.isWindows()) {
				setPreferredSize(new Dimension(580, 375));
			} else if (Platform.isLinux()) {
				setPreferredSize(new Dimension(645, 410));
			} else {
				setPreferredSize(new Dimension(650, 430));
			}

			setResizable(false);

			pack();

			setLocationRelativeTo(null);

			setVisible(true);
		} catch (Exception e) {
			System.out.println(ToolConstants.FRAME_SETUP_EXCEPTION);
			e.printStackTrace();
		}
	}

	private void applyChanges() {
		try {
			disposeFrame();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void disposeFrame() {
		dispose();
	}
}
