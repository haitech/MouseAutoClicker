package no.haitech.mouseautoclicker;

import java.awt.MouseInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * MouseAutoClicker is a small program that moves the mouse in given
 * coordinates and time.
 * 
 * @author Thomas Le
 * 
 * MouseAutoClicker is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * MouseAutoClicker is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public license
 * along with MouseAutoClicker. If not, see <http://www.gnu.org/licenses/>.
 */
public class MouseAutoClicker {
	@SuppressWarnings("serial")
	// Coordinates for mouse
	private static ArrayList<MouseMove> mouseMove = new ArrayList<MouseMove>() {{
		add(new MouseMove(1352,42));		// Refresh
		add(new MouseMove(1886,475, 2800));	// Stop
		add(new MouseMove(1913,524,10000)); // Close
	}};
	// Date format
	private static String dateFormat = "ddMMyy-HH:mm:ss:SSS";
	// When the mouse should move
	private static String[] strDates = {
		"160212-14:48:30:000",
		"160212-14:50:00:000",
		"160212-16:50:00:000"
	};
	// To adjust the extra delay for actually timer.
	private static long delay = -3600;
	// Enables mouseFinder, prints out x,y. Disables dates.
	private static boolean mouseFinder = false;
	
	
	/**
	 * Main
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// Initialization.
		DateFormat format = new SimpleDateFormat(dateFormat);
		Queue<Date> calDates = new LinkedList<Date>();

		// Prints program started.
		System.out.println("Program Started.");
	
		// Goes through the string array of dates.
		// Converts them to Calendar objects. And put them in to queue.
		for(String d : strDates) {
			Date date = (Date)format.parse(d.toString());
			calDates.add(date);
		}
		
		
		while(!calDates.isEmpty() || mouseFinder) {
			Thread.sleep(1); // To minimize the CPU usage.
			
			// Retrieves the X,Y axes from Mouse.
			if(mouseFinder)
				System.out.println(MouseInfo.getPointerInfo().getLocation());
			
			if(((System.currentTimeMillis() >= (calDates.element().getTime()+delay))) && !mouseFinder) {
				System.out.println(calDates.poll()); // Removes the date from queue.
				for(MouseMove o : mouseMove)
					o.move();
			}
		}
		
		// Program exit.
		System.out.println("Program ended. No more Dates.");
		System.exit(0);
	}
}
