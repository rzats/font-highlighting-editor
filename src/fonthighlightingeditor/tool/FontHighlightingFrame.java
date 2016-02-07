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

import java.awt.Dimension;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import processing.app.ui.Editor;

public class FontHighlightingFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	Editor editor;

	// Flag set to true if frame is successfully loaded
	boolean isInitialized = false;

	public FontHighlightingFrame(Editor editor) {
		try {
			this.editor = editor;

			this.setTitle("##tool.name##");

			java.util.List<Image> icons = new ArrayList<Image>();

			icons.add(loadImage("/data/icons/pde-16.png"));
			icons.add(loadImage("/data/icons/pde-32.png"));

			this.setIconImages(icons);

			this.setPreferredSize(new Dimension(500, 400));
			this.setResizable(false);

			this.pack();
			this.setLocationRelativeTo(null);
			this.setVisible(true);
		} catch (Exception e) {
			System.out.println("Exception at frame constructor");
			e.printStackTrace();
		}
	}

	// Helper method to load an image from the filename
	// Had some issues with the methods provided in data/README, but this
	// one-liner works just fine
	public Image loadImage(String filename) {
		return new ImageIcon(this.getClass().getResource(filename)).getImage();
	}
}
