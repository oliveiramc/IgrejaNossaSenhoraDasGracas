package br.ufal.ic.cg.church.objects.impl;

import javax.media.opengl.GL2;

import br.ufal.ic.cg.church.objects.AutoDrawnableObject;

import com.jogamp.opengl.util.gl2.GLUT;

/**
 * @author Adeilson Lima
 * @author Emanuele Silva
 * @author Priscylla Silva
 * 
 * @version 1.0
 */
public class BackWall extends AutoDrawnableObject {

	private GLUT glut;
	private int startList = gl.glGenLists(6);

	/**
	 * 
	 * @param gl
	 */
	public BackWall(GL2 gl) {
		super(gl);
		glut = new GLUT();
		compileGround(gl);
	}

	/**
	 * 
	 * @param gl
	 */
	private void createWindow(GL2 gl) {

		gl.glBegin(GL2.GL_POLYGON);
		// window
		gl.glColor3f(0.43f, 0.21f, 0.10f);
		gl.glVertex3f(0.16f, -9.22f, 3.0f);

		gl.glVertex3f(0.16f, -9.22f, 4.31f);

		gl.glVertex3f(0.16f, -8.2f, 4.31f);

		gl.glVertex3f(0.16f, -8.2f, 3.0f);

		gl.glEnd();

		// //linha 1

		gl.glBegin(GL2.GL_POLYGON);
		// quadrado1
		gl.glColor3f(1.0f, 1.0f, 0.0f);

		gl.glVertex3f(0.17f, -8.52f, 3.02f);

		gl.glColor3f(0.94f, 0.90f, 0.55f);

		gl.glVertex3f(0.17f, -8.52f, 3.32f);

		gl.glVertex3f(0.17f, -8.22f, 3.32f);

		gl.glVertex3f(0.17f, -8.22f, 3.02f);

		gl.glEnd();

		gl.glBegin(GL2.GL_POLYGON);
		// quadrado2 - roxo
		gl.glColor3f(0.41f, 0.14f, 0.54f);

		gl.glVertex3f(0.17f, -8.85f, 3.02f);

		gl.glVertex3f(0.17f, -8.85f, 3.32f);

		gl.glColor3f(0.98f, 0.81f, 0.69f);

		gl.glVertex3f(0.17f, -8.55f, 3.32f);

		gl.glVertex3f(0.17f, -8.55f, 3.02f);

		gl.glEnd();

		gl.glBegin(GL2.GL_POLYGON);
		// quadrado3
		gl.glColor3f(1.0f, 1.0f, 0.0f);

		gl.glVertex3f(0.17f, -9.19f, 3.02f);

		gl.glColor3f(0.94f, 0.90f, 0.55f);

		gl.glVertex3f(0.17f, -9.19f, 3.32f);

		gl.glVertex3f(0.17f, -8.87f, 3.32f);

		gl.glVertex3f(0.17f, -8.87f, 3.02f);

		gl.glEnd();

		// linha 2

		gl.glBegin(GL2.GL_POLYGON);
		// quadrado1
		gl.glColor3f(1.0f, 1.0f, 0.0f);

		gl.glVertex3f(0.17f, -8.52f, 3.34f);

		gl.glColor3f(0.94f, 0.90f, 0.55f);

		gl.glVertex3f(0.17f, -8.52f, 3.64f);

		gl.glVertex3f(0.17f, -8.22f, 3.64f);

		gl.glVertex3f(0.17f, -8.22f, 3.34f);

		gl.glEnd();

		gl.glBegin(GL2.GL_POLYGON);
		// quadrado2 - roxo
		gl.glColor3f(0.41f, 0.14f, 0.54f);

		gl.glVertex3f(0.17f, -8.85f, 3.34f);

		gl.glVertex3f(0.17f, -8.85f, 3.64f);

		gl.glColor3f(0.98f, 0.81f, 0.69f);

		gl.glVertex3f(0.17f, -8.55f, 3.64f);

		gl.glVertex3f(0.17f, -8.55f, 3.34f);

		gl.glEnd();

		gl.glBegin(GL2.GL_POLYGON);
		// quadrado3
		gl.glColor3f(1.0f, 1.0f, 0.0f);

		gl.glVertex3f(0.17f, -9.19f, 3.34f);

		gl.glColor3f(0.94f, 0.90f, 0.55f);
		gl.glVertex3f(0.17f, -9.19f, 3.64f);

		gl.glVertex3f(0.17f, -8.87f, 3.64f);

		gl.glVertex3f(0.17f, -8.87f, 3.34f);

		gl.glEnd();

		// linha 3

		gl.glBegin(GL2.GL_POLYGON);
		// quadrado1 - roxo
		gl.glColor3f(0.41f, 0.14f, 0.54f);

		gl.glVertex3f(0.17f, -8.52f, 3.66f);

		gl.glVertex3f(0.17f, -8.52f, 3.96f);

		gl.glColor3f(0.98f, 0.81f, 0.69f);

		gl.glVertex3f(0.17f, -8.22f, 3.96f);

		gl.glVertex3f(0.17f, -8.22f, 3.66f);

		gl.glEnd();

		gl.glBegin(GL2.GL_POLYGON);
		// quadrado2 - roxo
		gl.glColor3f(0.41f, 0.14f, 0.54f);

		gl.glVertex3f(0.17f, -8.85f, 3.66f);

		gl.glVertex3f(0.17f, -8.85f, 3.96f);

		gl.glColor3f(0.98f, 0.81f, 0.69f);

		gl.glVertex3f(0.17f, -8.55f, 3.96f);

		gl.glVertex3f(0.17f, -8.55f, 3.66f);

		gl.glEnd();

		gl.glBegin(GL2.GL_POLYGON);
		// quadrado3 - roxo
		gl.glColor3f(0.41f, 0.14f, 0.54f);

		gl.glVertex3f(0.17f, -9.19f, 3.66f);

		gl.glVertex3f(0.17f, -9.19f, 3.96f);

		gl.glColor3f(0.98f, 0.81f, 0.69f);

		gl.glVertex3f(0.17f, -8.87f, 3.96f);

		gl.glVertex3f(0.17f, -8.87f, 3.66f);

		gl.glEnd();

		// linha 4

		gl.glBegin(GL2.GL_POLYGON);
		// quadrado1
		gl.glColor3f(1.0f, 1.0f, 0.0f);

		gl.glVertex3f(0.17f, -8.52f, 3.98f);

		gl.glColor3f(0.94f, 0.90f, 0.55f);

		gl.glVertex3f(0.17f, -8.52f, 4.28f);

		gl.glVertex3f(0.17f, -8.22f, 4.28f);

		gl.glVertex3f(0.17f, -8.22f, 3.98f);

		gl.glEnd();

		gl.glBegin(GL2.GL_POLYGON);
		// quadrado2 - roxo
		gl.glColor3f(0.41f, 0.14f, 0.54f);

		gl.glVertex3f(0.17f, -8.85f, 3.98f);

		gl.glVertex3f(0.17f, -8.85f, 4.28f);

		gl.glColor3f(0.98f, 0.81f, 0.69f);

		gl.glVertex3f(0.17f, -8.55f, 4.28f);

		gl.glVertex3f(0.17f, -8.55f, 3.97f);

		gl.glEnd();

		gl.glBegin(GL2.GL_POLYGON);
		// quadrado3

		gl.glColor3f(1.0f, 1.0f, 0.0f);

		gl.glVertex3f(0.17f, -9.19f, 3.98f);

		gl.glColor3f(0.94f, 0.90f, 0.55f);

		gl.glVertex3f(0.17f, -9.19f, 4.28f);

		gl.glVertex3f(0.17f, -8.87f, 4.28f);

		gl.glVertex3f(0.17f, -8.87f, 3.98f);

		gl.glEnd();

	}

	/**
	 * 
	 * @param gl
	 */
	private void drawWindow(GL2 gl) {

		gl.glPushMatrix();

		gl.glTranslatef(5.05f, -14.6f, -0.9f);

		this.createWindow(gl);

		gl.glTranslatef(0.06f, -8.75f, 2.1f);
		gl.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
		gl.glTranslatef(-0.06f, 8.75f, -2.1f);

		this.createWindow(gl);

		gl.glPopMatrix();

	}

	/**
	 * 
	 * @param gl
	 */
	private void drawBack(GL2 gl) {
		
		// parede do fundo
		gl.glPushMatrix();

		gl.glTranslatef(8.60f, -30.0f, 4.0f);

		gl.glScalef(84.8f, 1.0f, 53.0f);

		gl.glCallList(startList);

		gl.glPopMatrix();

	}

	/**
	 * 
	 * @param gl
	 */
	private void drawLateral(GL2 gl) {
		
		gl.glColor3f(1.0f, 1.0f, 1.0f);

		// paredes laterais
		gl.glPushMatrix();

		gl.glTranslatef(12.1f, -26.2f, 4.0f);
		gl.glScalef(1.0f, 50.7f, 53.0f);

		for (int i = 0; i < 2; i++) {

			gl.glCallList(startList);
			gl.glTranslatef(-7.0f, 0.0f, 0.0f);
		}

		gl.glPopMatrix();
	}

	/**
	 * 
	 * @param gl
	 */
	private void compileGround(GL2 gl) {
		gl.glNewList(startList, GL2.GL_COMPILE);

		gl.glColor3f(1.0f, 1.0f, 1.0f);

		glut.glutSolidCube(0.15f);

		gl.glEndList();
	}

	/**
	 * 
	 */
	@Override
	public void selfDraw(GL2 gl) {
		
		gl.glColor3f(1.0f, 1.0f, 1.0f);
		
		texture.enable(gl);
		texture.bind(gl);

		this.drawBack(gl);

		this.drawLateral(gl);

		// janelas dentro do altar
		gl.glPushMatrix();

		for (int i = 0; i < 2; i++) {

			this.drawWindow(gl);
			gl.glTranslatef(7.0f, 0.0f, 0.0f);
		}

		gl.glPopMatrix();
	}

	/**
	 * 
	 */
	@Override
	protected String getTextureExtension() {
		return "jpg";
	}

	/**
	 * 
	 */
	@Override
	protected String getTextureImg() {
		return "whiteWall.jpg";
	}
}
