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

			// Set up a common font

			Font f = new Font("Dialog", Font.PLAIN, 12);
			UIManager.put("Button.font", f);
			UIManager.put("TextArea.font", f);

			// Info
			final JLabel lblNewLabel = new JLabel(
					"<html>Use this tool to modify PDE's font highlighting settings.<br>(Hover over the name of each setting to display info)</html>");

			// -----
			final JSeparator topSeparator = new JSeparator();

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
					.addComponent(topSeparator, GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE));
			layout.setVerticalGroup(
					layout.createParallelGroup(Alignment.TRAILING)
							.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(topSeparator, GroupLayout.PREFERRED_SIZE, 2,
											GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 177, Short.MAX_VALUE)
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

			setPreferredSize(new Dimension(600, 300));

			setResizable(false);

			pack();

			setLocationRelativeTo(null);

			setVisible(true);
		} catch (Exception e) {
			System.out.println(FontHighlightingConstants.FRAME_SETUP_EXCEPTION);
			e.printStackTrace();
		}
	}

	private void applyChanges() {
		try {
			// TODO: apply changes
			disposeFrame();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void disposeFrame() {
		dispose();
	}
}
