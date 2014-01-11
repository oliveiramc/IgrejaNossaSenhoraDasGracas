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

public class Roof extends AutoDrawnableObject {

	private GLUT glut;
	private int startList = gl.glGenLists(13);

	/**
	 * 
	 * @param gl
	 */
	public Roof(GL2 gl) {
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
		
		gl.glColor3f(1.0f, 1.0f, 1.0f);

		glut.glutSolidCube(0.15f);

		gl.glEndList();
	}

	/**
	 * 
	 */
	@Override
	public void selfDraw(GL2 gl) {

		gl.glPushMatrix();

		gl.glTranslatef(8.6f, -15.0f, 0.0f);

		gl.glScalef(85.0f, 200.0f, 1.0f);

		gl.glTranslatef(0.0f, 0.0f, 8.0f);

		gl.glColor3f(1.0f, 1.0f, 1.0f);

		gl.glCallList(startList);

		gl.glPopMatrix();

		gl.glPushMatrix();

		gl.glTranslatef(8.7f, -15.0f, 10.1f);

		gl.glScalef(6.5f, 15.0f, 2.0f);

		gl.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);

		this.drawRoof(gl);

		gl.glPopMatrix();

	}

	@SuppressWarnings("static-access")
	private void drawRoof(GL2 gl) {

		gl.glTexParameteri(GL2.GL_TEXTURE_2D, GL2.GL_TEXTURE_WRAP_S,
				GL2.GL_REPEAT);
		gl.glTexParameteri(GL2.GL_TEXTURE_2D, GL2.GL_TEXTURE_WRAP_T,
				GL2.GL_REPEAT);

		texture.enable(gl);
		texture.bind(gl);

		gl.glBegin(gl.GL_TRIANGLES);

		gl.glColor3f(0.54f, 0.0f, 0.0f); // Red

		gl.glVertex3f(-1.0f, -1.0f, 1.0f); // Left Of Triangle (Front)
		gl.glTexCoord2f(1.0f, 0.0f);

		gl.glVertex3f(1.0f, -1.0f, 1.0f);
		gl.glTexCoord2f(0.5f, 1.0f);

		gl.glVertex3f(0.0f, 1.0f, 0.0f); // Top Of Triangle (Front)
		gl.glTexCoord2f(0.0f, 0.0f);

		gl.glEnd();

		gl.glBegin(gl.GL_TRIANGLES);

		gl.glVertex3f(0.0f, 1.0f, 0.0f); // Top Of Triangle (Right)
		gl.glTexCoord2f(0.5f, 1.0f);

		gl.glVertex3f(1.0f, -1.0f, 1.0f); // Left Of Triangle (Right)
		gl.glTexCoord2f(1.0f, 0.0f);

		gl.glVertex3f(1.0f, -1.0f, -1.0f); // Right Of Triangle (Right)
		gl.glTexCoord2f(0.0f, 0.0f);

		gl.glEnd();

		gl.glBegin(gl.GL_TRIANGLES);

		gl.glVertex3f(0.0f, 1.0f, 0.0f); // Top Of Triangle (Back)
		gl.glTexCoord2f(0.5f, 1.0f);

		gl.glVertex3f(1.0f, -1.0f, -1.0f); // Left Of Triangle (Back)
		gl.glTexCoord2f(1.0f, 0.0f);

		gl.glVertex3f(-1.0f, -1.0f, -1.0f); // Right Of Triangle (Back)
		gl.glTexCoord2f(0.0f, 0.0f);

		gl.glEnd();

		gl.glBegin(gl.GL_TRIANGLES);

		gl.glVertex3f(0.0f, 1.0f, 0.0f); // Top Of Triangle (Left)
		gl.glTexCoord2f(1.0f, 0.0f);

		gl.glVertex3f(-1.0f, -1.0f, -1.0f); // Left Of Triangle (Left)
		gl.glTexCoord2f(0.5f, 1.0f);

		gl.glVertex3f(-1.0f, -1.0f, 1.0f); // Right Of Triangle (Left)
		gl.glTexCoord2f(0.0f, 0.0f);

		gl.glEnd();
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
		return "roof.jpg";
	}

}
