package br.ufal.ic.cg.church.renderer;

import java.util.ArrayList;
import java.util.List;

import javax.media.opengl.DebugGL2;
import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.glu.GLU;

import br.ufal.ic.cg.church.objects.AutoDrawnableObject;
import br.ufal.ic.cg.church.objects.impl.AboveTheDoor;
import br.ufal.ic.cg.church.objects.impl.Altar;
import br.ufal.ic.cg.church.objects.impl.Ambao;
import br.ufal.ic.cg.church.objects.impl.ArchLateral;
import br.ufal.ic.cg.church.objects.impl.BackWall;
import br.ufal.ic.cg.church.objects.impl.Column;
import br.ufal.ic.cg.church.objects.impl.Cruz;
import br.ufal.ic.cg.church.objects.impl.FundoCapelinha;
import br.ufal.ic.cg.church.objects.impl.NovoAltar;
import br.ufal.ic.cg.church.objects.impl.Stair;
import br.ufal.ic.cg.church.objects.impl.Door;
import br.ufal.ic.cg.church.objects.impl.ExternalHalfWall;
import br.ufal.ic.cg.church.objects.impl.ExternalHalfWall2;
import br.ufal.ic.cg.church.objects.impl.ExternalHalfWall3;
import br.ufal.ic.cg.church.objects.impl.ExternalHalfWall4;
import br.ufal.ic.cg.church.objects.impl.Floor;
import br.ufal.ic.cg.church.objects.impl.Floor2;
import br.ufal.ic.cg.church.objects.impl.FrontAltar;
import br.ufal.ic.cg.church.objects.impl.FrontWall;
import br.ufal.ic.cg.church.objects.impl.Halfwall;
import br.ufal.ic.cg.church.objects.impl.HalfwallAltar;
import br.ufal.ic.cg.church.objects.impl.HallDeEntrada;
import br.ufal.ic.cg.church.objects.impl.LeftChapel;
import br.ufal.ic.cg.church.objects.impl.Pew;
import br.ufal.ic.cg.church.objects.impl.Roof;
import br.ufal.ic.cg.church.objects.impl.Tower;
import br.ufal.ic.cg.church.objects.impl.Wall;

/**
 * @author Adeilson Lima
 * @author Emanuele Silva
 * @author Priscylla Silva
 * 
 * @version 1.0
 */
public class MovableCameraImpl extends MovableCamera {

	private Door door;

	private float[] ambientLight = { 1f, 1f, 1f, 1f };
	private float[] diffuseLight = { .2f, .2f, .2f, 1f };
	private float[] lightColorSpecular = { 0.8f,0.8f,0.8f,1.0f };
	private float[] lightPos = { 10f, -10f, 8f, 1f };

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<AutoDrawnableObject> objects;

	/**
	 * 
	 */
	public MovableCameraImpl() {

		this.objects = new ArrayList<AutoDrawnableObject>();
	}

	/**
	 * 
	 * @param gl
	 */
	protected void initObjects(GL2 gl) {

		this.objects.add(new Pew(gl));
		this.objects.add(new Wall(gl));
		this.objects.add(new Halfwall(gl));
		this.objects.add(new BackWall(gl));
		this.objects.add(new Floor(gl));
		this.objects.add(new Altar(gl));
		this.objects.add(new HalfwallAltar(gl));
		this.objects.add(new LeftChapel(gl));
		this.objects.add(new NovoAltar(gl));
		this.objects.add(new FundoCapelinha(gl));
		this.objects.add(new ArchLateral(gl));
		this.objects.add(new Column(gl));
		this.objects.add(new FrontAltar(gl));
		this.objects.add(new Roof(gl));
		this.objects.add(new HallDeEntrada(gl));
		this.objects.add(new FrontWall(gl));
		this.objects.add(new ExternalHalfWall(gl));
		this.objects.add(new ExternalHalfWall2(gl));
		this.objects.add(new ExternalHalfWall3(gl));
		this.objects.add(new ExternalHalfWall4(gl));
		this.objects.add(new Tower(gl));
		this.objects.add(new Cruz(gl));
		this.objects.add(new Ambao(gl));
		this.objects.add(door = new Door(gl));
		this.objects.add(new AboveTheDoor(gl));
		this.objects.add(new Floor2(gl));
		this.objects.add(new Stair(gl));

	}

	/**
	 * 
	 */
	@Override
	public void display(GLAutoDrawable drawable) {

		GL2 gl = drawable.getGL().getGL2();

		gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);

		gl.glMatrixMode(GL2.GL_MODELVIEW);
		gl.glLoadIdentity();
		setCameraPos();

		gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_POSITION, lightPos, 0);

		gl.glEnable(GL2.GL_TEXTURE_2D);

		for (AutoDrawnableObject obj : this.objects) {
			gl.glPushMatrix();
			obj.bindTexture();
			obj.selfDraw(gl);
			obj.unbindTexture();
			gl.glPopMatrix();
		}

		gl.glTranslatef(lightPos[0], lightPos[1], lightPos[2]);
		gl.glColor3f(1f, 1f, 1f);

		gl.glFlush();
	}

	/**
	 * 
	 */
	@Override
	public void init(GLAutoDrawable drawable) {

		GL2 gl = drawable.getGL().getGL2();

		drawable.setGL(new DebugGL2(drawable.getGL().getGL2()));

		this.initObjects(gl);
		this.initLight(gl);

		gl.setSwapInterval(1);
		gl.glEnable(GL.GL_DEPTH_TEST);

		gl.glClearColor(135 / 255f, 206 / 255f, 235 / 255f, 0.0f);

	}

	/**
	 * 
	 */
	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width,
			int height) {

		GL2 gl = drawable.getGL().getGL2();
		GLU glu = new GLU();

		if (height <= 0) {
			height = 1;
		}
		final float h = (float) width / (float) height;
		gl.glViewport(0, 0, width, height);
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		glu.gluPerspective(45.0f, h, 1.0, 200.0);
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		gl.glLoadIdentity();
	}

	@Override
	public void dispose(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub

	}

	private void initLight(GL2 gl) {
		gl.glEnable(GL2.GL_LIGHTING);

		gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_AMBIENT, ambientLight, 0);
		gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_DIFFUSE, diffuseLight, 0);
		gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_SPECULAR, lightColorSpecular, 0);

		gl.glEnable(GL2.GL_LIGHT0);
		
		float[] rgba = {1f, 1f, 1f};
		gl.glMaterialfv(GL2.GL_FRONT, GL2.GL_SPECULAR, rgba, 0);

		gl.glEnable(GL2.GL_COLOR_MATERIAL);

	}

	public void processKeyPressed(final char c) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				if (c == 'o') {
					door.openDoor();
				}
				if (c == 'c') {
					door.closeDoor();
				}

			}
		}).start();
	}
}
