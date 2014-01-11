package br.ufal.ic.cg.church.objects.impl;

import javax.media.opengl.GL2;

import br.ufal.ic.cg.church.objects.AutoDrawnableObject;

/**
 * @author Adeilson Lima
 * @author Emanuele Silva
 * @author Priscylla Silva
 * 
 * @version 1.0
 */

public class Wall extends AutoDrawnableObject {

	private int startList = gl.glGenLists(2);

	/**
	 * 
	 * @param gl
	 */
	public Wall(GL2 gl) {
		super(gl);

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

		gl.glVertex3f(0.16f, -9.22f, 4.94f);

		gl.glVertex3f(0.16f, -8.2f, 4.94f);

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
		// quadrado2
		gl.glColor3f(1.0f, 1.0f, 0.0f);
		gl.glVertex3f(0.17f, -8.85f, 3.02f);

		gl.glColor3f(0.94f, 0.90f, 0.55f);

		gl.glVertex3f(0.17f, -8.85f, 3.32f);

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
		// quadrado2 - rosa
		gl.glColor3f(1.0f, 0.0f, 1.0f);

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
		// quadrado1
		gl.glColor3f(1.0f, 1.0f, 0.0f);

		gl.glVertex3f(0.17f, -8.52f, 3.66f);

		gl.glColor3f(0.94f, 0.90f, 0.55f);

		gl.glVertex3f(0.17f, -8.52f, 3.96f);

		gl.glVertex3f(0.17f, -8.22f, 3.96f);

		gl.glVertex3f(0.17f, -8.22f, 3.66f);

		gl.glEnd();

		gl.glBegin(GL2.GL_POLYGON);
		// quadrado2 - rosa
		gl.glColor3f(1.0f, 0.0f, 1.0f);

		gl.glVertex3f(0.17f, -8.85f, 3.66f);

		gl.glVertex3f(0.17f, -8.85f, 3.96f);

		gl.glColor3f(0.98f, 0.81f, 0.69f);

		gl.glVertex3f(0.17f, -8.55f, 3.96f);

		gl.glVertex3f(0.17f, -8.55f, 3.66f);

		gl.glEnd();

		gl.glBegin(GL2.GL_POLYGON);
		// quadrado3
		gl.glColor3f(1.0f, 1.0f, 0.0f);

		gl.glVertex3f(0.17f, -9.19f, 3.66f);

		gl.glColor3f(0.94f, 0.90f, 0.55f);

		gl.glVertex3f(0.17f, -9.19f, 3.96f);

		gl.glVertex3f(0.17f, -8.87f, 3.96f);

		gl.glVertex3f(0.17f, -8.87f, 3.66f);

		gl.glEnd();

		// linha 4

		gl.glBegin(GL2.GL_POLYGON);
		// quadrado1 - rosa
		gl.glColor3f(1.0f, 0.0f, 1.0f);

		gl.glVertex3f(0.17f, -8.52f, 3.98f);

		gl.glVertex3f(0.17f, -8.52f, 4.28f);

		gl.glColor3f(0.98f, 0.81f, 0.69f);

		gl.glVertex3f(0.17f, -8.22f, 4.28f);

		gl.glVertex3f(0.17f, -8.22f, 3.98f);

		gl.glEnd();

		gl.glBegin(GL2.GL_POLYGON);
		// quadrado2 - rosa
		gl.glColor3f(1.0f, 0.0f, 1.0f);

		gl.glVertex3f(0.17f, -8.85f, 3.98f);

		gl.glVertex3f(0.17f, -8.85f, 4.28f);

		gl.glColor3f(0.98f, 0.81f, 0.69f);

		gl.glVertex3f(0.17f, -8.55f, 4.28f);

		gl.glVertex3f(0.17f, -8.55f, 3.97f);

		gl.glEnd();

		gl.glBegin(GL2.GL_POLYGON);
		// quadrado3 -rosa
		gl.glColor3f(1.0f, 0.0f, 1.0f);

		gl.glVertex3f(0.17f, -9.19f, 3.98f);

		gl.glVertex3f(0.17f, -9.19f, 4.28f);

		gl.glColor3f(0.98f, 0.81f, 0.69f);

		gl.glVertex3f(0.17f, -8.87f, 4.28f);

		gl.glVertex3f(0.17f, -8.87f, 3.98f);

		gl.glEnd();

		// linha 5

		gl.glBegin(GL2.GL_POLYGON);
		// quadrado1
		gl.glColor3f(1.0f, 1.0f, 0.0f);

		gl.glVertex3f(0.17f, -8.52f, 4.30f);

		gl.glColor3f(0.94f, 0.90f, 0.55f);

		gl.glVertex3f(0.17f, -8.52f, 4.60f);

		gl.glVertex3f(0.17f, -8.22f, 4.60f);

		gl.glVertex3f(0.17f, -8.22f, 4.30f);

		gl.glEnd();

		gl.glBegin(GL2.GL_POLYGON);
		// quadrado2 - rosa
		gl.glColor3f(1.0f, 0.0f, 1.0f);

		gl.glVertex3f(0.17f, -8.85f, 4.30f);

		gl.glVertex3f(0.17f, -8.85f, 4.60f);

		gl.glColor3f(0.98f, 0.81f, 0.69f);

		gl.glVertex3f(0.17f, -8.55f, 4.60f);

		gl.glVertex3f(0.17f, -8.55f, 4.30f);

		gl.glEnd();

		gl.glBegin(GL2.GL_POLYGON);
		// quadrado3
		gl.glColor3f(1.0f, 1.0f, 0.0f);

		gl.glVertex3f(0.17f, -9.19f, 4.30f);

		gl.glColor3f(0.94f, 0.90f, 0.55f);

		gl.glVertex3f(0.17f, -9.19f, 4.60f);

		gl.glVertex3f(0.17f, -8.87f, 4.60f);

		gl.glVertex3f(0.17f, -8.87f, 4.30f);

		gl.glEnd();

		// //linha 6

		gl.glBegin(GL2.GL_POLYGON);
		// quadrado1
		gl.glColor3f(1.0f, 1.0f, 0.0f);

		gl.glVertex3f(0.17f, -8.52f, 4.62f);

		gl.glColor3f(0.94f, 0.90f, 0.55f);

		gl.glVertex3f(0.17f, -8.52f, 4.92f);

		gl.glVertex3f(0.17f, -8.22f, 4.92f);

		gl.glVertex3f(0.17f, -8.22f, 4.62f);

		gl.glEnd();

		gl.glBegin(GL2.GL_POLYGON);
		// quadrado2
		gl.glColor3f(1.0f, 1.0f, 0.0f);

		gl.glVertex3f(0.17f, -8.85f, 4.62f);

		gl.glColor3f(0.94f, 0.90f, 0.55f);

		gl.glVertex3f(0.17f, -8.85f, 4.92f);

		gl.glVertex3f(0.17f, -8.55f, 4.92f);

		gl.glVertex3f(0.17f, -8.55f, 4.62f);

		gl.glEnd();

		gl.glBegin(GL2.GL_POLYGON);
		// quadrado3
		gl.glColor3f(1.0f, 1.0f, 0.0f);

		gl.glVertex3f(0.17f, -9.19f, 4.62f);

		gl.glColor3f(0.94f, 0.90f, 0.55f);

		gl.glVertex3f(0.17f, -9.19f, 4.92f);

		gl.glVertex3f(0.17f, -8.87f, 4.92f);

		gl.glVertex3f(0.17f, -8.87f, 4.62f);

		gl.glEnd();

		gl.glColor3f(1.0f, 1.0f, 1.0f);

	}

	/**
	 * 
	 * @param gl
	 */
	private void drawWindow(GL2 gl) {

		gl.glPushMatrix();

		gl.glTranslatef(2.2f, 1.0f, 0.0f);

		for (int i = 0; i < 2; i++) {

			this.createWindow(gl);

			gl.glTranslatef(0.001f, -9.22f, 3.0f);
			gl.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
			gl.glTranslatef(-0.001f, 8.22f, -3.0f);

			this.createWindow(gl);

			gl.glTranslatef(0.0f, 8.0f, 0.0f);

		}

		gl.glTranslatef(0.0f, -12.0f, 0.0f);
		this.createWindow(gl);

		gl.glTranslatef(0.001f, -9.22f, 3.0f);
		gl.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
		gl.glTranslatef(-0.001f, 8.22f, -3.0f);

		this.createWindow(gl);

		gl.glPopMatrix();

	}

	/**
	 * 
	 * @param gl
	 */
	private void compileGround(GL2 gl) {

		gl.glNewList(startList, GL2.GL_COMPILE);

		// Bottom face
		gl.glBegin(GL2.GL_POLYGON);
		gl.glVertex3f(0.15f, 0.0f, 8.0f);
		gl.glTexCoord2f(0.0f, 0.0f);

		gl.glVertex3f(-0.15f, 0.0f, 8.0f);
		gl.glTexCoord2f(0.0f, 1.0f);

		gl.glVertex3f(-0.15f, 0.0f, 0.0f);
		gl.glTexCoord2f(1.0f, 0.0f);

		gl.glVertex3f(0.15f, 0.0f, 0.0f);
		gl.glTexCoord2f(1.0f, 1.0f);

		gl.glEnd();

		gl.glBegin(GL2.GL_POLYGON);
		// Front face
		gl.glVertex3f(0.15f, 0.0f, 8.0f);
		gl.glTexCoord2f(0.0f, 0.0f);

		gl.glVertex3f(-0.15f, 0.0f, 8.0f);
		gl.glTexCoord2f(0.0f, 1.0f);

		gl.glVertex3f(-0.15f, -30.0f, 8.0f);
		gl.glTexCoord2f(1.0f, 0.0f);

		gl.glVertex3f(0.15f, -30.0f, 8.0f);
		gl.glTexCoord2f(1.0f, 1.0f);

		gl.glEnd();

		gl.glBegin(GL2.GL_POLYGON);
		// Back face
		gl.glVertex3f(0.15f, -30.0f, 0.0f);
		gl.glTexCoord2f(0.0f, 0.0f);

		gl.glVertex3f(-0.15f, -30.0f, 0.0f);
		gl.glTexCoord2f(0.0f, 1.0f);

		gl.glVertex3f(-0.15f, 0.0f, 0.0f);
		gl.glTexCoord2f(1.0f, 0.0f);

		gl.glVertex3f(0.15f, 0.0f, 0.0f);
		gl.glTexCoord2f(1.0f, 1.0f);

		gl.glEnd();

		gl.glBegin(GL2.GL_POLYGON);
		// Left face
		gl.glVertex3f(-0.15f, 0.0f, 8.0f);
		gl.glTexCoord2f(0.0f, 0.0f);

		gl.glVertex3f(-0.15f, 0.0f, 0.0f);
		gl.glTexCoord2f(0.0f, 1.0f);

		gl.glVertex3f(-0.15f, -30.0f, 0.0f);
		gl.glTexCoord2f(1.0f, 0.0f);

		gl.glVertex3f(-0.15f, -30.0f, 8.0f);
		gl.glTexCoord2f(1.0f, 1.0f);

		gl.glEnd();

		gl.glBegin(GL2.GL_POLYGON);
		// Right face
		gl.glVertex3f(0.15f, 0.0f, 0.0f);
		gl.glTexCoord2f(0.0f, 0.0f);

		gl.glVertex3f(0.15f, 0.0f, 8.0f);
		gl.glTexCoord2f(0.0f, 1.0f);

		gl.glVertex3f(0.15f, -30.0f, 8.0f);
		gl.glTexCoord2f(1.0f, 0.0f);

		gl.glVertex3f(0.15f, -30.0f, 0.0f);
		gl.glTexCoord2f(1.0f, 1.0f);

		gl.glEnd();

		gl.glEndList();

	}

	/**
	 * 
	 */
	@Override
	public void selfDraw(GL2 gl) {

		texture.enable(gl);
		texture.bind(gl);

		gl.glColor3f(1.0f, 1.0f, 1.0f);

		gl.glPushMatrix();

		gl.glTranslatef(2.2f, 0.0f, 0.0f);

		for (int i = 0; i < 2; i++) {
			gl.glCallList(startList);
			gl.glTranslatef(12.64f, 0.0f, 0.0f);

		}

		gl.glPopMatrix();

		gl.glPushMatrix();
		this.drawWindow(gl);

		gl.glTranslatef(12.64f, 0.0f, 0.0f);
		this.drawWindow(gl);

		this.drawWindow(gl);
		this.drawWindow(gl);

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
