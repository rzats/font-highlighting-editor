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

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fonthighlightingeditor.constants.FontHighlightingConstants;
import processing.app.Base;
import processing.app.tools.Tool;
import processing.app.ui.Editor;

public class FontHighlightingEditor implements Tool {
	Base base;
	Editor editor;
	static FontHighlightingFrame frame;

	public String getMenuTitle() {
		return "##tool.name##";
	}

	public void init(Base base) {
		this.base = base;
	}

	public void run() {
		// Boilerplate to initialize the frame
		// Most of the work will be done elsewhere
		try {
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					try {
						// Limit to one window instance
						if (frame == null) {
							frame = new FontHighlightingFrame(base);

							// Don't close the entire PDE along with the tool
							frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

							System.out.println(FontHighlightingConstants.STARTUP_INFO);
						} else {
							frame.setVisible(true);
						}
					} catch (Exception e) {
						System.out.println(FontHighlightingConstants.INVOKELATER_INNER_EXCEPTION);
						e.printStackTrace();
					}
				}
			});
		} catch (Exception e) {
			System.out.println(FontHighlightingConstants.INVOKELATER_OUTER_EXCEPTION);
			e.printStackTrace();
		}
	}
}