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

public class Pew extends AutoDrawnableObject {

	private int displayIndex = 1;

	/**
	 * 
	 * @param gl
	 */
	public Pew(GL2 gl) {
		super(gl);
		compileGround(gl);
	}

	/**
	 * 
	 * @param gl
	 */
	private void compileGround(GL2 gl) {
		gl.glNewList(displayIndex, GL2.GL_COMPILE);

		// horizontal meio
		gl.glBegin(GL2.GL_POLYGON);
		gl.glVertex3f(0, 0, 1f);
		gl.glTexCoord2f(0f, 0f);
		gl.glVertex3f(0, 4, 1f);
		gl.glTexCoord2f(0f, 0.5f);
		gl.glVertex3f(1, 4, 1f);
		gl.glTexCoord2f(0.5f, 0f);
		gl.glVertex3f(1, 0, 1f);
		gl.glTexCoord2f(0.5f, 0.5f);
		gl.glEnd();

		// horizontal baixo

		gl.glBegin(GL2.GL_POLYGON);
		gl.glVertex3f(-0.5f, 0, 0.3f);
		gl.glTexCoord2f(0f, 0f);
		gl.glVertex3f(-0.5f, 4, 0.3f);
		gl.glTexCoord2f(0f, 0.5f);
		gl.glVertex3f(-0.8f, 4, 0.3f);
		gl.glTexCoord2f(0.5f, 0f);
		gl.glVertex3f(-0.8f, 0, 0.3f);
		gl.glTexCoord2f(0.5f, 0.5f);
		gl.glEnd();

		// parte costas
		gl.glBegin(GL2.GL_POLYGON);
		gl.glVertex3f(-0.25f, 0, 1f);
		gl.glTexCoord2f(0f, 0f);
		gl.glVertex3f(-0.25f, 4, 1f);
		gl.glTexCoord2f(0f, 0.5f);
		gl.glVertex3f(-0.4f, 4, 2f);
		gl.glTexCoord2f(0.5f, 0f);
		gl.glVertex3f(-0.4f, 0, 2f);
		gl.glTexCoord2f(0.5f, 0.5f);
		gl.glEnd();

		// vertical l1
		gl.glBegin(GL2.GL_QUADS);
		gl.glVertex3f(0f, 0f, 0f);
		gl.glTexCoord2f(0f, 0f);
		gl.glVertex3f(1f, 0f, 0f);
		gl.glTexCoord2f(0f, 0.5f);
		gl.glVertex3f(1f, 0f, 1f);
		gl.glTexCoord2f(0.5f, 0f);
		gl.glVertex3f(0f, 0f, 1f);
		gl.glTexCoord2f(0.5f, 0.5f);
		gl.glEnd();

		// vertical maior l1

		gl.glBegin(GL2.GL_POLYGON);
		gl.glVertex3f(-0.8f, 0f, 0f);
		gl.glTexCoord2f(0f, 0f);
		gl.glVertex3f(0f, 0f, 0f);
		gl.glTexCoord2f(0f, 0.5f);
		gl.glVertex3f(0f, 0f, 2.3f);
		gl.glTexCoord2f(0.5f, 0f);
		gl.glVertex3f(-0.8f, 0f, 2.3f);
		gl.glTexCoord2f(0.5f, 0.5f);
		gl.glEnd();

		// vertical centro
		gl.glBegin(GL2.GL_POLYGON);
		gl.glVertex3f(0f, 2f, 0f);
		gl.glTexCoord2f(0f, 0f);
		gl.glVertex3f(1f, 2f, 0f);
		gl.glTexCoord2f(0f, 0.5f);
		gl.glVertex3f(1f, 2f, 1f);
		gl.glTexCoord2f(0.5f, 0f);
		gl.glVertex3f(0f, 2f, 1f);
		gl.glTexCoord2f(0.5f, 0.5f);
		gl.glEnd();

		// vertical l2
		gl.glBegin(GL2.GL_POLYGON);
		gl.glVertex3f(0f, 4f, 0f);
		gl.glTexCoord2f(0f, 0f);
		gl.glVertex3f(1f, 4f, 0f);

		gl.glVertex3f(1f, 4f, 1f);

		gl.glVertex3f(0f, 4f, 1f);

		gl.glEnd();

		// vertical maior l2
		gl.glBegin(GL2.GL_POLYGON);
		gl.glVertex3f(0f, 4f, 0f);
		gl.glTexCoord2f(0f, 0f);
		gl.glVertex3f(-0.8f, 4f, 0f);
		gl.glTexCoord2f(0f, 0.5f);
		gl.glVertex3f(-0.8f, 4f, 2.3f);
		gl.glTexCoord2f(0.5f, 0f);
		gl.glVertex3f(0f, 4f, 2.3f);
		gl.glTexCoord2f(0.5f, 0.5f);
		gl.glEnd();
		gl.glEndList();
	}

	/**
	 * 
	 */
	@Override
	public void selfDraw(GL2 gl) {

		gl.glScalef(0.4f, 0.4f, 0.5f);
		gl.glRotatef(-90, 0f, 0f, 1f);
		gl.glTranslatef(15.5f, 7.0f, 0.0f);

		// Bancos laterais 1
		gl.glPushMatrix();
		gl.glTranslatef(0.0f, -0.6f, 0.0f);
		for (int i = 0; i <= 12; i++) {

			gl.glCallList(displayIndex);
			gl.glTranslatef(3.0f, 0.0f, 0.0f);
		}
		gl.glPopMatrix();

		gl.glTranslatef(0.0f, 7.5f, 0.0f);

		// Bancos centrais 1
		gl.glPushMatrix();
		gl.glTranslatef(0.0f, -0.5f, 0.0f);
		for (int i = 0; i <= 12; i++) {

			gl.glPushMatrix();
			
			gl.glScalef(1, 1.5f, 1);
			
			gl.glCallList(displayIndex);
			gl.glPopMatrix();
			gl.glTranslatef(3.0f, 0.0f, 0.0f);
		}
		gl.glPopMatrix();

		gl.glTranslatef(0.0f, 10.6f, 0.0f);

		// Bancos centrais 2
		gl.glPushMatrix();
		gl.glTranslatef(0.0f, -1.8f, 0.0f);
		for (int i = 0; i <= 12; i++) {

			gl.glPushMatrix();
			
			gl.glScalef(1, 1.5f, 1);
			
			gl.glCallList(displayIndex);
			gl.glPopMatrix();
			gl.glTranslatef(3.0f, 0.0f, 0.0f);
			
		}
		gl.glPopMatrix();

		gl.glTranslatef(0.0f, 7.5f, 0.0f);

		// Bancos laterais 2
		gl.glPushMatrix();
		for (int i = 0; i <= 12; i++) {

			gl.glCallList(displayIndex);
			gl.glTranslatef(3.0f, 0.0f, 0.0f);
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
		return "pew.jpg";
	}

}
