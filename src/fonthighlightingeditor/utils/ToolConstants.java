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

package fonthighlightingeditor.utils;

import java.util.*;

/**
 * Various constant values used by the frame.
 */

public final class ToolConstants {
	// Prevent instantiation
	private ToolConstants() {
	}

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
	public static final String STARTUP_INFO = TOOL_NAME + " v. ##tool.prettyVersion##\nby ##author.name##.\n"
			+ "Please report any issues at ##source.url##\n";
	public static final String HEADER_MESSAGE = "<html>Use this tool to modify PDE's font highlighting settings.<br>(Hover over the name of each setting to display info)</html>";

	@SuppressWarnings("serial")
	public static final Map<String, String> TOOLTIPS = new HashMap<String, String>() {
		{
			/*
			 * Description strings taken from
			 * github.com/processing/processing/blob/master/app/src/processing/
			 * app/syntax/Token.java
			 * 
			 * TODO: some of these appear to be unused, do research
			 */

			put("comment1", "This can be used to mark a comment.");
			put("comment2", "This can be used to mark a comment");
			put("function1", "Functions");
			put("function2", "Methods<br />(Functions inside a class)");
			put("function3", "Loop/function-like blocks<br />(for, while etc)");
			put("function4", "Built-in Processing functions<br />(setup, draw, mouseDragged etc)");
			put("invalid", "Invalid or incomplete tokens");
			put("keyword1", "Keywords<br />(void, int, boolean etc)");
			put("keyword2", "Fields<br />(Variables within a class)");
			put("keyword3", "Loop/function-like blocks<br />(for, while etc)");
			put("keyword4", "Processing variables<br />(width, height, focused, etc)");
			put("keyword5", "Datatypes<br />(int, boolean etc)");
			put("keyword6", "Keywords which can be followed by parenthesis");
			put("label", "Labels");
			put("literal1", "Strings in quotes");
			put("literal2", "Constants<br />(QUARTER_PI, CORNERS etc)");
			put("operator", "Operators");
			put("bgcolor", "IDE background color");
		}
	};
}
