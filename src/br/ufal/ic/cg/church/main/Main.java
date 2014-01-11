package br.ufal.ic.cg.church.main;

import java.awt.Dimension;

import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;

import br.ufal.ic.cg.church.listeners.UserKeyBoardListener;
import br.ufal.ic.cg.church.listeners.UserMouseEventListener;
import br.ufal.ic.cg.church.renderer.MovableCameraImpl;

import com.jogamp.opengl.util.Animator;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;

	public static void main(String args[]) {

		GLCanvas canvas; // lugar onde os objetos serao montados

		GLProfile profile = GLProfile.get(GLProfile.GL2); // usando versao 2.x
															// do OpenGL
		GLCapabilities capabilites = new GLCapabilities(profile);
		capabilites.setDoubleBuffered(true);

		canvas = new GLCanvas(capabilites);
		Animator animator = new Animator(canvas); // anima/loop para esta sempre
													// redesenhando

		JFrame frame = new JFrame("Paróquia N. Senhora das Graças"); // cria uma
																		// janela...
		frame.getContentPane().add(canvas); // ... e adiciona o canvas

		MovableCameraImpl r; // falta implementar esta classe
		canvas.addGLEventListener(r = new MovableCameraImpl()); // adiciona
																// classe que
																// implementa
																// GLEventListener
																// (o renderer)

		/** construtor irá criar uma thread para processar teclas precionadas */
		UserKeyBoardListener listener = new UserKeyBoardListener(r); // trata
																		// eventos
																		// do
																		// teclado

		UserMouseEventListener mouseListener = new UserMouseEventListener(r); // trata
																				// eventos
																				// do
																				// mouse

		canvas.addKeyListener(listener); // adiciona classe que trata eventos do
											// teclado
		canvas.addMouseListener(mouseListener); // adiciona classe que trata
												// eventos do mouse
		canvas.addMouseMotionListener(mouseListener); // adiciona classe que
														// trata eventos do
														// mouse
		canvas.addMouseWheelListener(mouseListener); // adiciona classe que
														// trata eventos do
														// mouse

		frame.getContentPane().add(canvas);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setSize(new Dimension(1360, 720));
		frame.setVisible(true);

		canvas.requestFocus();
		animator.start(); // vai para classe que implementa a interface
							// GLEventListener (Renderer) e fica em loop

	}

}
