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

public class Floor extends AutoDrawnableObject {

	private GLUT glut;
	private int startList = gl.glGenLists(5);

	/**
	 * 
	 * @param gl
	 */
	public Floor(GL2 gl) {
		super(gl);
		glut = new GLUT();
		compileGround(gl);
	}

	/**
	 * 
	 * @param gl
	 */
	private void compileGround(GL2 gl) {

		gl.glNewList(startList, GL2.GL_COMPILE);

		gl.glColor3f(0.41f, 0.41f, 0.41f);

		glut.glutSolidCube(0.15f);

		gl.glEndList();
	}

	/**
	 * 
	 * @param gl
	 */
	private void drawfloor(GL2 gl) {

		gl.glColor3f(0.15f, 0.15f, 0.15f);
		gl.glPushMatrix();
		gl.glTranslatef(8.18f, 0.02f, 0.005f);

		gl.glBegin(GL2.GL_POLYGON);
		gl.glVertex3f(-0.60f, -30.0f, 0.0f);
		gl.glTexCoord2f(0.0f, 0.0f);

		gl.glVertex3f(-0.15f, -30.0f, 0.0f);
		gl.glTexCoord2f(0.0f, 1.0f);

		gl.glVertex3f(-0.15f, 0.0f, 0.0f);
		gl.glTexCoord2f(1.0f, 0.0f);

		gl.glVertex3f(-0.60f, 0.0f, 0.0f);
		gl.glTexCoord2f(1.0f, 1.0f);

		gl.glEnd();
		gl.glPopMatrix();
	}

	/**
	 * 
	 */
	@Override
	public void selfDraw(GL2 gl) {

		texture.enable(gl);
		texture.bind(gl);

		gl.glPushMatrix();

		gl.glTranslatef(8.6f, -15.0f, -0.1f);

		gl.glScalef(85.0f, 200.0f, 1.0f);

		gl.glCallList(startList);

		gl.glPopMatrix();

		gl.glPushMatrix();
		gl.glTranslatef(15.0f, 0.0f, 0.0f);

		gl.glBegin(GL2.GL_POLYGON);

		gl.glVertex3f(-12.65f, -30.0f, 0.0f);
		gl.glTexCoord2f(0.0f, 0.0f);

		gl.glVertex3f(-0.15f, -30.0f, 0.0f);
		gl.glTexCoord2f(0.0f, 1.0f);

		gl.glVertex3f(-0.15f, 0.0f, 0.0f);
		gl.glTexCoord2f(1.0f, 0.0f);

		gl.glVertex3f(-12.65f, 0.0f, 0.0f);
		gl.glTexCoord2f(1.0f, 1.0f);

		gl.glEnd();
		gl.glPopMatrix();

		for (int i = 0; i < 2; i++) {

			this.drawfloor(gl);

			gl.glTranslatef(1.73f, 0.0f, 0.0f);
		}
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
		return "floor.jpg";
	}

}
