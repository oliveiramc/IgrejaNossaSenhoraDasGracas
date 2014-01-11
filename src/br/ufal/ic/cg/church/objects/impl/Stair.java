package br.ufal.ic.cg.church.objects.impl;

import javax.media.opengl.GL2;

import br.ufal.ic.cg.church.objects.AutoDrawnableObject;

import com.jogamp.opengl.util.gl2.GLUT;

public class Stair extends AutoDrawnableObject {

	private GLUT glut = new GLUT();
	private int startList;

	public Stair(GL2 gl) {
		super(gl);
		compile(gl);
	}

	private void compile(GL2 gl) {

		startList = gl.glGenLists(1);
		gl.glNewList(startList, GL2.GL_COMPILE);
		gl.glColor3f(92/255f,64/255f,51/255f);
		glut.glutSolidCube(0.1f);
		gl.glEndList();
	}

	public void selfDraw(GL2 gl) {

		gl.glColor3f(0.45f, 0.25f, 0f);

		gl.glPushMatrix();

		gl.glTranslatef(2.7f, -3.5f, -0.1f);

		gl.glScalef(7f, 2.3f, 2.2f);

		for (int i = 0; i < 11; ++i) {
			gl.glTranslatef(0, 0.1f, 0.1f);
			gl.glCallList(startList);
		}

		gl.glTranslatef(0, 0.1f, 0.0f);

		gl.glCallList(startList);

		gl.glTranslatef(0, 0.1f, 0.0f);

		gl.glCallList(startList);

		gl.glPopMatrix();

		gl.glPushMatrix();

		gl.glTranslatef(2.7f, -0.9f, 2.1f);

		gl.glScalef(2.3f, 7f, 2.2f);

		for (int i = 0; i < 10; ++i) {
			gl.glTranslatef(0.1f, 0.0f, 0.1f);
			gl.glCallList(startList);
		}

		gl.glPopMatrix();
	}

	@Override
	protected String getTextureExtension() {
		// TODO Auto-generated method stub
		return "jpg";
	}

	@Override
	protected String getTextureImg() {
		// TODO Auto-generated method stub
		return "wood.jpg";
	}
}
