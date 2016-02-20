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

	// private Base base;

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
	private JFormattedTextField formattedFieldKeyword3;
	private JFormattedTextField formattedFieldKeyword4;
	private JFormattedTextField formattedFieldKeyword5;
	private JFormattedTextField formattedFieldKeyword6;
	private JFormattedTextField formattedFieldLabel;
	private JFormattedTextField formattedFieldLiteral1;
	private JFormattedTextField formattedFieldLiteral2;
	private JFormattedTextField formattedFieldOperator;
	private JFormattedTextField formattedFieldBgColor;

	private JTextField disabledFieldComment1;
	private JTextField disabledFieldComment2;
	private JTextField disabledFieldFunction1;
	private JTextField disabledFieldFunction2;
	private JTextField disabledFieldFunction3;
	private JTextField disabledFieldFunction4;
	private JTextField disabledFieldInvalid;
	private JTextField disabledFieldKeyword1;
	private JTextField disabledFieldKeyword2;
	private JTextField disabledFieldKeyword3;
	private JTextField disabledFieldKeyword4;
	private JTextField disabledFieldKeyword5;
	private JTextField disabledFieldKeyword6;
	private JTextField disabledFieldLabel;
	private JTextField disabledFieldLiteral1;
	private JTextField disabledFieldLiteral2;
	private JTextField disabledFieldOperator;
	private JTextField disabledFieldBgColor;

	private ColorChooser colorChooserComment1;
	private ColorChooser colorChooserComment2;
	private ColorChooser colorChooserFunction1;
	private ColorChooser colorChooserFunction2;
	private ColorChooser colorChooserFunction3;
	private ColorChooser colorChooserFunction4;
	private ColorChooser colorChooserInvalid;
	private ColorChooser colorChooserKeyword1;
	private ColorChooser colorChooserKeyword2;
	private ColorChooser colorChooserKeyword3;
	private ColorChooser colorChooserKeyword4;
	private ColorChooser colorChooserKeyword5;
	private ColorChooser colorChooserKeyword6;
	private ColorChooser colorChooserLabel;
	private ColorChooser colorChooserLiteral1;
	private ColorChooser colorChooserLiteral2;
	private ColorChooser colorChooserOperator;
	private ColorChooser colorChooserBgColor;

	public FontHighlightingFrame(Base base) {
		// this.base = base;

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

			// keyword3
			currentPreference = "keyword3";

			final JLabel infoLabelKeyword3 = ComponentCreator.createInfoLabel(currentPreference);
			final JLabel hashLabelKeyword3 = ComponentCreator.createHashLabel();

			disabledFieldKeyword3 = ComponentCreator.createDisabledTextField(currentPreference);
			formattedFieldKeyword3 = ComponentCreator.createFormattedTextField(currentPreference,
					disabledFieldKeyword3);

			colorChooserKeyword3 = new ColorChooser(this, false, ToolHelpers.extractColor(currentPreference),
					Language.text("prompt.ok"), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							String colorValue = colorChooserKeyword3.getHexColor();
							formattedFieldKeyword3.setText(colorValue.substring(1));
							colorChooserKeyword3.hide();
						}
					});

			ComponentCreator.setupMouseListener(this, disabledFieldKeyword3, colorChooserKeyword3);

			// keyword4
			currentPreference = "keyword4";

			final JLabel infoLabelKeyword4 = ComponentCreator.createInfoLabel(currentPreference);
			final JLabel hashLabelKeyword4 = ComponentCreator.createHashLabel();

			disabledFieldKeyword4 = ComponentCreator.createDisabledTextField(currentPreference);
			formattedFieldKeyword4 = ComponentCreator.createFormattedTextField(currentPreference,
					disabledFieldKeyword4);

			colorChooserKeyword4 = new ColorChooser(this, false, ToolHelpers.extractColor(currentPreference),
					Language.text("prompt.ok"), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							String colorValue = colorChooserKeyword4.getHexColor();
							formattedFieldKeyword4.setText(colorValue.substring(1));
							colorChooserKeyword4.hide();
						}
					});

			ComponentCreator.setupMouseListener(this, disabledFieldKeyword4, colorChooserKeyword4);

			// keyword5
			currentPreference = "keyword5";

			final JLabel infoLabelKeyword5 = ComponentCreator.createInfoLabel(currentPreference);
			final JLabel hashLabelKeyword5 = ComponentCreator.createHashLabel();

			disabledFieldKeyword5 = ComponentCreator.createDisabledTextField(currentPreference);
			formattedFieldKeyword5 = ComponentCreator.createFormattedTextField(currentPreference,
					disabledFieldKeyword5);

			colorChooserKeyword5 = new ColorChooser(this, false, ToolHelpers.extractColor(currentPreference),
					Language.text("prompt.ok"), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							String colorValue = colorChooserKeyword5.getHexColor();
							formattedFieldKeyword5.setText(colorValue.substring(1));
							colorChooserKeyword5.hide();
						}
					});

			ComponentCreator.setupMouseListener(this, disabledFieldKeyword5, colorChooserKeyword5);

			// keyword6
			currentPreference = "keyword6";

			final JLabel infoLabelKeyword6 = ComponentCreator.createInfoLabel(currentPreference);
			final JLabel hashLabelKeyword6 = ComponentCreator.createHashLabel();

			disabledFieldKeyword6 = ComponentCreator.createDisabledTextField(currentPreference);
			formattedFieldKeyword6 = ComponentCreator.createFormattedTextField(currentPreference,
					disabledFieldKeyword6);

			colorChooserKeyword6 = new ColorChooser(this, false, ToolHelpers.extractColor(currentPreference),
					Language.text("prompt.ok"), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							String colorValue = colorChooserKeyword6.getHexColor();
							formattedFieldKeyword6.setText(colorValue.substring(1));
							colorChooserKeyword6.hide();
						}
					});

			ComponentCreator.setupMouseListener(this, disabledFieldKeyword6, colorChooserKeyword6);

			// label
			currentPreference = "label";

			final JLabel infoLabelLabel = ComponentCreator.createInfoLabel(currentPreference);
			final JLabel hashLabelLabel = ComponentCreator.createHashLabel();

			disabledFieldLabel = ComponentCreator.createDisabledTextField(currentPreference);
			formattedFieldLabel = ComponentCreator.createFormattedTextField(currentPreference, disabledFieldLabel);

			colorChooserLabel = new ColorChooser(this, false, ToolHelpers.extractColor(currentPreference),
					Language.text("prompt.ok"), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							String colorValue = colorChooserLabel.getHexColor();
							formattedFieldLabel.setText(colorValue.substring(1));
							colorChooserLabel.hide();
						}
					});

			ComponentCreator.setupMouseListener(this, disabledFieldLabel, colorChooserLabel);

			// literal1
			currentPreference = "literal1";

			final JLabel infoLabelLiteral1 = ComponentCreator.createInfoLabel(currentPreference);
			final JLabel hashLabelLiteral1 = ComponentCreator.createHashLabel();

			disabledFieldLiteral1 = ComponentCreator.createDisabledTextField(currentPreference);
			formattedFieldLiteral1 = ComponentCreator.createFormattedTextField(currentPreference,
					disabledFieldLiteral1);

			colorChooserLiteral1 = new ColorChooser(this, false, ToolHelpers.extractColor(currentPreference),
					Language.text("prompt.ok"), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							String colorValue = colorChooserLiteral1.getHexColor();
							formattedFieldLiteral1.setText(colorValue.substring(1));
							colorChooserLiteral1.hide();
						}
					});

			ComponentCreator.setupMouseListener(this, disabledFieldLiteral1, colorChooserLiteral1);

			// literal2
			currentPreference = "literal2";

			final JLabel infoLabelLiteral2 = ComponentCreator.createInfoLabel(currentPreference);
			final JLabel hashLabelLiteral2 = ComponentCreator.createHashLabel();

			disabledFieldLiteral2 = ComponentCreator.createDisabledTextField(currentPreference);
			formattedFieldLiteral2 = ComponentCreator.createFormattedTextField(currentPreference,
					disabledFieldLiteral2);

			colorChooserLiteral2 = new ColorChooser(this, false, ToolHelpers.extractColor(currentPreference),
					Language.text("prompt.ok"), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							String colorValue = colorChooserLiteral2.getHexColor();
							formattedFieldLiteral2.setText(colorValue.substring(1));
							colorChooserLiteral2.hide();
						}
					});

			ComponentCreator.setupMouseListener(this, disabledFieldLiteral2, colorChooserLiteral2);

			// operator
			currentPreference = "operator";

			final JLabel infoLabelOperator = ComponentCreator.createInfoLabel(currentPreference);
			final JLabel hashLabelOperator = ComponentCreator.createHashLabel();

			disabledFieldOperator = ComponentCreator.createDisabledTextField(currentPreference);
			formattedFieldOperator = ComponentCreator.createFormattedTextField(currentPreference,
					disabledFieldOperator);

			colorChooserOperator = new ColorChooser(this, false, ToolHelpers.extractColor(currentPreference),
					Language.text("prompt.ok"), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							String colorValue = colorChooserOperator.getHexColor();
							formattedFieldOperator.setText(colorValue.substring(1));
							colorChooserOperator.hide();
						}
					});

			ComponentCreator.setupMouseListener(this, disabledFieldOperator, colorChooserOperator);

			// window.bgcolor
			currentPreference = "bgcolor";

			final JLabel infoLabelBgColor = ComponentCreator.createInfoLabel(currentPreference);
			final JLabel hashLabelBgColor = ComponentCreator.createHashLabel();

			disabledFieldBgColor = ComponentCreator.createDisabledTextField(currentPreference);
			formattedFieldBgColor = ComponentCreator.createFormattedTextField(currentPreference, disabledFieldBgColor);

			colorChooserBgColor = new ColorChooser(this, false, ToolHelpers.extractColor(currentPreference),
					Language.text("prompt.ok"), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							String colorValue = colorChooserBgColor.getHexColor();
							formattedFieldBgColor.setText(colorValue.substring(1));
							colorChooserBgColor.hide();
						}
					});

			ComponentCreator.setupMouseListener(this, disabledFieldBgColor, colorChooserBgColor);

			// -----
			final JSeparator bottomSeparator = new JSeparator();

			// [Discard Changes]
			final JButton btnDiscardChanges = new JButton("Discard Changes");
			btnDiscardChanges.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					discardChanges();
				}
			});

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
							.addComponent(infoLabelKeyword3, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(hashLabelKeyword3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(formattedFieldKeyword3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(disabledFieldKeyword3, GroupLayout.PREFERRED_SIZE, 26,
									GroupLayout.PREFERRED_SIZE).addGap(18))
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
							.addComponent(infoLabelKeyword4, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(hashLabelKeyword4, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(formattedFieldKeyword4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(disabledFieldKeyword4, GroupLayout.PREFERRED_SIZE, 26,
									GroupLayout.PREFERRED_SIZE).addContainerGap(18, Short.MAX_VALUE))
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
							.addComponent(infoLabelKeyword5, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(hashLabelKeyword5, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(formattedFieldKeyword5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(disabledFieldKeyword5, GroupLayout.PREFERRED_SIZE, 26,
									GroupLayout.PREFERRED_SIZE)
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
							.addComponent(infoLabelKeyword6, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(hashLabelKeyword6, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(formattedFieldKeyword6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(disabledFieldKeyword6, GroupLayout.PREFERRED_SIZE, 26,
									GroupLayout.PREFERRED_SIZE)
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
							.addComponent(infoLabelLabel, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(hashLabelLabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(formattedFieldLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(disabledFieldLabel, GroupLayout.PREFERRED_SIZE, 26,
									GroupLayout.PREFERRED_SIZE)
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
							.addComponent(infoLabelLiteral1, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(hashLabelLiteral1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(formattedFieldLiteral1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(disabledFieldLiteral1, GroupLayout.PREFERRED_SIZE, 26,
									GroupLayout.PREFERRED_SIZE)
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
							.addComponent(infoLabelLiteral2, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(hashLabelLiteral2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(formattedFieldLiteral2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(disabledFieldLiteral2, GroupLayout.PREFERRED_SIZE, 26,
									GroupLayout.PREFERRED_SIZE).addContainerGap(18, Short.MAX_VALUE))
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
							.addComponent(infoLabelOperator, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(hashLabelOperator, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(formattedFieldOperator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(disabledFieldOperator, GroupLayout.PREFERRED_SIZE, 26,
									GroupLayout.PREFERRED_SIZE).addContainerGap(18, Short.MAX_VALUE))
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
							.addComponent(infoLabelBgColor, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(hashLabelBgColor, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(formattedFieldBgColor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(disabledFieldBgColor, GroupLayout.PREFERRED_SIZE, 26,
									GroupLayout.PREFERRED_SIZE).addContainerGap(18, Short.MAX_VALUE)));
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
							.addComponent(infoLabelKeyword3).addComponent(hashLabelKeyword3)
							.addComponent(formattedFieldKeyword3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(disabledFieldKeyword3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(infoLabelComment2)
							.addComponent(hashLabelComment2)
							.addComponent(formattedFieldComment2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(disabledFieldComment2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(infoLabelKeyword4).addComponent(hashLabelKeyword4)
							.addComponent(formattedFieldKeyword4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(disabledFieldKeyword4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(infoLabelFunction1)
							.addComponent(hashLabelFunction1)
							.addComponent(formattedFieldFunction1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(disabledFieldFunction1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(infoLabelKeyword5).addComponent(hashLabelKeyword5)
							.addComponent(formattedFieldKeyword5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(disabledFieldKeyword5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(infoLabelFunction2)
							.addComponent(hashLabelFunction2)
							.addComponent(formattedFieldFunction2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(disabledFieldFunction2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(infoLabelKeyword6).addComponent(hashLabelKeyword6)
							.addComponent(formattedFieldKeyword6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(disabledFieldKeyword6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(infoLabelFunction3)
							.addComponent(hashLabelFunction3)
							.addComponent(formattedFieldFunction3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(disabledFieldFunction3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(infoLabelLabel).addComponent(hashLabelLabel)
							.addComponent(formattedFieldLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(disabledFieldLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(infoLabelFunction4)
							.addComponent(hashLabelFunction4)
							.addComponent(formattedFieldFunction4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(disabledFieldFunction4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(infoLabelLiteral1).addComponent(hashLabelLiteral1)
							.addComponent(formattedFieldLiteral1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(disabledFieldLiteral1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(infoLabelInvalid)
							.addComponent(hashLabelInvalid)
							.addComponent(formattedFieldInvalid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(disabledFieldInvalid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(infoLabelLiteral2).addComponent(hashLabelLiteral2)
							.addComponent(formattedFieldLiteral2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(disabledFieldLiteral2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(infoLabelKeyword1)
							.addComponent(hashLabelKeyword1)
							.addComponent(formattedFieldKeyword1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(disabledFieldKeyword1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(infoLabelOperator).addComponent(hashLabelOperator)
							.addComponent(formattedFieldOperator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(disabledFieldOperator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(infoLabelKeyword2)
							.addComponent(hashLabelKeyword2)
							.addComponent(formattedFieldKeyword2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(disabledFieldKeyword2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(infoLabelBgColor).addComponent(hashLabelBgColor)
							.addComponent(formattedFieldBgColor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(disabledFieldBgColor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
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

	/**
	 * Applies user changes to PDE preferences
	 */

	private void applyChanges() {
		try {
			/*
			 * Using this approach because it automatically discards invalid
			 * data typed in manually
			 */

			ToolHelpers.setPreference("comment1", disabledFieldComment1.getBackground());
			ToolHelpers.setPreference("comment2", disabledFieldComment2.getBackground());
			ToolHelpers.setPreference("function1", disabledFieldFunction1.getBackground());
			ToolHelpers.setPreference("function2", disabledFieldFunction2.getBackground());
			ToolHelpers.setPreference("function3", disabledFieldFunction3.getBackground());
			ToolHelpers.setPreference("function4", disabledFieldFunction4.getBackground());
			ToolHelpers.setPreference("invalid", disabledFieldInvalid.getBackground());
			ToolHelpers.setPreference("keyword1", disabledFieldKeyword1.getBackground());
			ToolHelpers.setPreference("keyword2", disabledFieldKeyword2.getBackground());
			ToolHelpers.setPreference("keyword3", disabledFieldKeyword3.getBackground());
			ToolHelpers.setPreference("keyword4", disabledFieldKeyword4.getBackground());
			ToolHelpers.setPreference("keyword5", disabledFieldKeyword5.getBackground());
			ToolHelpers.setPreference("keyword6", disabledFieldKeyword6.getBackground());
			ToolHelpers.setPreference("label", disabledFieldLabel.getBackground());
			ToolHelpers.setPreference("literal1", disabledFieldLiteral1.getBackground());
			ToolHelpers.setPreference("literal2", disabledFieldLiteral2.getBackground());
			ToolHelpers.setPreference("operator", disabledFieldOperator.getBackground());
			ToolHelpers.setPreference("bgcolor", disabledFieldBgColor.getBackground());

			JOptionPane.showMessageDialog(null, ToolConstants.RESTART_REQUIRED_MESSAGE,
					ToolConstants.RESTART_REQUIRED_TITLE, JOptionPane.WARNING_MESSAGE);

			disposeFrame();
		} catch (Exception e) {
			System.out.println(ToolConstants.APPLY_CHANGES_EXCEPTION);
			e.printStackTrace();
		}
	}

	/**
	 * Resets the field values to current PDE preferences
	 */
	private void discardChanges() {
		try {
			formattedFieldComment1.setText(ToolHelpers.extractColorString("comment1"));
			formattedFieldComment2.setText(ToolHelpers.extractColorString("comment2"));
			formattedFieldFunction1.setText(ToolHelpers.extractColorString("function1"));
			formattedFieldFunction2.setText(ToolHelpers.extractColorString("function2"));
			formattedFieldFunction3.setText(ToolHelpers.extractColorString("function3"));
			formattedFieldFunction4.setText(ToolHelpers.extractColorString("function4"));
			formattedFieldInvalid.setText(ToolHelpers.extractColorString("invalid"));
			formattedFieldKeyword1.setText(ToolHelpers.extractColorString("keyword1"));
			formattedFieldKeyword2.setText(ToolHelpers.extractColorString("keyword2"));
			formattedFieldKeyword3.setText(ToolHelpers.extractColorString("keyword3"));
			formattedFieldKeyword4.setText(ToolHelpers.extractColorString("keyword4"));
			formattedFieldKeyword5.setText(ToolHelpers.extractColorString("keyword5"));
			formattedFieldKeyword6.setText(ToolHelpers.extractColorString("keyword6"));
			formattedFieldLabel.setText(ToolHelpers.extractColorString("label"));
			formattedFieldLiteral1.setText(ToolHelpers.extractColorString("literal1"));
			formattedFieldLiteral2.setText(ToolHelpers.extractColorString("literal2"));
			formattedFieldOperator.setText(ToolHelpers.extractColorString("operator"));
			formattedFieldBgColor.setText(ToolHelpers.extractColorString("bgcolor"));
		} catch (Exception e) {
			System.out.println(ToolConstants.DISCARD_CHANGES_EXCEPTION);
			e.printStackTrace();
		}
	}

	private void disposeFrame() {
		dispose();
	}
}
