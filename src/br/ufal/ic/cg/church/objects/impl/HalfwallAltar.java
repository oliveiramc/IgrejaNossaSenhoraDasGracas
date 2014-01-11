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

public class HalfwallAltar extends AutoDrawnableObject {

	private int startList = 8;

	public HalfwallAltar(GL2 gl) {
		super(gl);
		compileGround(gl);
	}

	private void compileGround(GL2 gl) {
		gl.glNewList(startList, GL2.GL_COMPILE);

		gl.glBegin(GL2.GL_POLYGON);
		gl.glColor3f(0.54f, 0.28f, 0.15f);

		gl.glVertex3f(-0.16f, 0.0f, 0.0f);
		gl.glTexCoord2f(0.0f, 0.0f);

		gl.glVertex3f(-0.16f, 0.0f, 1.5f);
		gl.glTexCoord2f(0.0f, 1.0f);

		gl.glVertex3f(-0.16f, -7.5f, 1.5f);
		gl.glTexCoord2f(1.0f, 0.0f);

		gl.glVertex3f(-0.16f, -7.5f, 0.0f);
		gl.glTexCoord2f(1.0f, 1.0f);

		gl.glEnd();

		gl.glEndList();
	}

	@Override
	public void selfDraw(GL2 gl) {

		texture.enable(gl);
		texture.bind(gl);

		gl.glPushMatrix();
		gl.glTranslatef(5.34f, -22.4f, 0.0f);

		for (int i = 0; i < 2; i++) {
			gl.glCallList(startList);
			gl.glTranslatef(6.84f, 0.0f, 0.0f);
		}

		gl.glPopMatrix();

	}

	@Override
	protected String getTextureExtension() {
		return "jpg";
	}

	@Override
	protected String getTextureImg() {
		return "wood.jpg";
	}

}
