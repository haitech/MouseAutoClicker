package no.haitech.mouseautoclicker;
import java.awt.Robot;
import java.awt.event.InputEvent;

/**
 * MouseMove object
 * Information where the move should move.
 * 
 * @author Thomas Le
 * 
 * This file is part of MouseAutoClicker.
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
public class MouseMove {
	private int x;
	private int y;
	private int sleep;
	private Robot robot;

	/**
	 * Constructor
	 * with sleep timer.
	 * 
	 * @param x set x-mouse.
	 * @param y set y-mouse.
	 * @param sleep sleep time.
	 */
	public MouseMove(int x, int y, int sleep) {
		this.x = x;
		this.y = y;
		this.sleep = sleep;
	}

	/**
	 * Constructor
	 * without sleep timer.
	 *  
	 * @param x set x-mouse.
	 * @param y set y-mouse.
	 */
	public MouseMove(int x, int y) {
		this.x = x;
		this.y = y;
		this.sleep = 0;
	}

	/**
	 * Move the mouse.
	 */
	public void move() throws Exception {
		robot = new Robot();
		if(sleep > 0)
			Thread.sleep(sleep);


		// Move mouse.
		robot.mouseMove(x, y);
		// Left click and release.
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
	}
}
