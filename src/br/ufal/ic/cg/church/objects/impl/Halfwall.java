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
public class Halfwall extends AutoDrawnableObject {

	private int startList = 4;

	/**
	 * 
	 * @param gl
	 */
	public Halfwall(GL2 gl) {
		super(gl);
		compileGround(gl);
	}

	/**
	 * 
	 * @param gl
	 */
	private void compileGround(GL2 gl) {
		gl.glNewList(startList, GL2.GL_COMPILE);

		gl.glBegin(GL2.GL_POLYGON);
		gl.glColor3f(0.54f, 0.28f, 0.15f);

		gl.glVertex3f(-0.16f, 0.0f, 0.0f);
		gl.glTexCoord2f(0.0f, 0.0f);

		gl.glVertex3f(-0.16f, 0.0f, 1.5f);
		gl.glTexCoord2f(0.0f, 1.0f);

		gl.glVertex3f(-0.16f, -22.0f, 1.5f);
		gl.glTexCoord2f(1.0f, 0.0f);

		gl.glVertex3f(-0.16f, -22.0f, 0.0f);
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

		gl.glPushMatrix();
		gl.glTranslatef(14.84f, 0.0f, 0.0f);

		gl.glCallList(startList);
		gl.glTranslatef(-12.32f, 0.0f, 0.0f);

		gl.glCallList(startList);

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
		return "wood.jpg";
	}
}
