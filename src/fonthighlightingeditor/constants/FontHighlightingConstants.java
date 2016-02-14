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

package fonthighlightingeditor.constants;

public class FontHighlightingConstants {
	// Filepaths

	private static final String DATA_PATH = "/data";
	private static final String ICON_PATH = DATA_PATH + "/icons/";

	public static final String PDE_ICON_16 = ICON_PATH + "pde-16.png";
	public static final String PDE_ICON_32 = ICON_PATH + "pde-32.png";

	// Error message strings

	private static final String EXCEPTION_HEADER = "Exception at ";
	public static final String INVOKELATER_OUTER_EXCEPTION = EXCEPTION_HEADER + "invokeLater()";
	public static final String INVOKELATER_INNER_EXCEPTION = EXCEPTION_HEADER + "invokeLater() -> run()";
	public static final String FRAME_SETUP_EXCEPTION = EXCEPTION_HEADER + "frame -> setupLayout()";

	// UI strings

	public static final String TOOL_NAME = "##tool.name##";
	public static final String STARTUP_INFO = TOOL_NAME + " v. ##tool.prettyVersion## by ##author.name##.\n"
			+ "Please report any issues at ##source.url##\n";
	public static final String TEXTAREA_INFO = "Use this tool to modify PDE's color highlighting settings.\n(Hover over the name of each setting to display info)";

	public static final String COMMENT1_NAME = "comment1: ";
	public static final String COMMENT1_TOOLTIP = "Used to mark a comment.";
}
