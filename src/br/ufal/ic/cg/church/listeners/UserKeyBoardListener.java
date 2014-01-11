package br.ufal.ic.cg.church.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import br.ufal.ic.cg.church.renderer.MovableCamera;

public class UserKeyBoardListener implements KeyListener {

	private MovableCamera renderer; // renderizador
	final private List<Integer> pressed; // lista de caracteres teclados

	private boolean run = true;

	public UserKeyBoardListener(MovableCamera renderer) {
		this.renderer = renderer;
		pressed = new ArrayList<Integer>();

		Thread listener = new Thread(new Runnable() {

			@Override
			public void run() {
				while (run) {
					try {
						Thread.sleep(30);
					} catch (InterruptedException e) {
					}
					if (pressed.size() > 0)
						processPressedKeys();
				}
			}
		});
		listener.start();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		renderer.processKeyPressed(e.getKeyChar());
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (!pressed.contains(e.getKeyCode())) {
			pressed.add(e.getKeyCode());

		}
	}

	private void processPressedKeys() { // trivial
		if (pressed.contains(38) && pressed.contains(39))
			renderer.walkFoward(45, 45, 0);
		else if (pressed.contains(38) && pressed.contains(37))
			renderer.walkFoward(-45, -45, 0);
		else if (pressed.contains(40) && pressed.contains(39))
			renderer.walkBackard(-45, -45, 0);
		else if (pressed.contains(40) && pressed.contains(37))
			renderer.walkBackard(+45, +45, 0);
		else if (pressed.contains(38))
			renderer.walkForward();
		else if (pressed.contains(40))
			renderer.walkBackward();
		else if (pressed.contains(39))
			renderer.walkRight();
		else if (pressed.contains(37))
			renderer.walkLeft();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		pressed.remove(new Integer(e.getKeyCode()));
	}

	@Override
	/**finaliza a thread*/
	protected void finalize() throws Throwable {
		run = false;
		super.finalize();
	}

}
