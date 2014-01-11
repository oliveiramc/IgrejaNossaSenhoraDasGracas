package br.ufal.ic.cg.church.objects.impl;

import javax.media.opengl.GL2;

import com.jogamp.opengl.util.gl2.GLUT;

import br.ufal.ic.cg.church.objects.AutoDrawnableObject;

public class AboveTheDoor extends AutoDrawnableObject {

	private GLUT glut = new GLUT();
	private int startList;

	public AboveTheDoor(GL2 gl) {
		super(gl);
		compile(gl);
	}

	private void compile(GL2 gl) {

		gl.glColor3f(0.45f, 0.25f, 0f);
		startList = gl.glGenLists(1);
		gl.glNewList(startList, GL2.GL_COMPILE);
		gl.glColor3f(0.54f, 0.28f, 0.15f);
		glut.glutSolidCube(0.1f);
		gl.glEndList();
	}

	public void selfDraw(GL2 gl) {

		gl.glTranslatef(8.7f, -0.3f, 3.5f);

		gl.glPushMatrix();
		gl.glScalef(20f, 2, 10);
		gl.glCallList(startList);
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
		return "pew.jpg";
	}
}