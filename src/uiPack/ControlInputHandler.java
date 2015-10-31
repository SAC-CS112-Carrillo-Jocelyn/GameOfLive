package uiPack;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import uiPack.controls.IControl;

public class ControlInputHandler implements MouseListener, MouseMotionListener {
	private static List<IControl> controls = new ArrayList<IControl>();

	public static void register(IControl control){
		controls.add(control);
	}

	public static void unregister(IControl control){
		controls.remove(control);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (controls.size() == 0 || e.isConsumed()){
			return;
		}

		Point currentMousePosition = e.getPoint();

		for (IControl control : controls){
			Rectangle bounds = control.getBounds();

			if (bounds.contains(currentMousePosition) && !control.isReadOnly()){
				control.click(new Point(currentMousePosition.x - bounds.x, currentMousePosition.y - bounds.y));
				e.consume();
				return;
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if (controls.size() == 0 || e.isConsumed()){
			return;
		}

		Point currentMousePosition = e.getPoint();

		for (IControl control : controls){
			control.mouseOver(false, null);
		}

		for (IControl control : controls){
			Rectangle bounds = control.getBounds();

			if (bounds.contains(currentMousePosition)){
				control.mouseOver(true, new Point(currentMousePosition.x - bounds.x, currentMousePosition.y - bounds.y));
				e.consume();
				return;
			}
		}
	}
}