package br.ufal.ic.cg.church.objects.impl;

import javax.media.opengl.GL2;

import br.ufal.ic.cg.church.objects.AutoDrawnableObject;

import com.jogamp.opengl.util.gl2.GLUT;

public class Tower extends AutoDrawnableObject {

	private GLUT glut = new GLUT();
	private int startList;

	public Tower(GL2 gl) {
		super(gl);
		compile(gl);
	}

	private void compile(GL2 gl) {

		startList = 12;
		gl.glNewList(startList, GL2.GL_COMPILE);
		gl.glColor3f(1f, 1f, 1f);
		glut.glutSolidCube(0.6f);
		gl.glEndList();
	}

	public void selfDraw(GL2 gl) {

		texture.enable(gl);
		texture.bind(gl);

		gl.glTranslatef(8.65f, -0.8f, 8.8f);

		gl.glPushMatrix();
		gl.glScalef(3f, 3f, 3f);
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
		return "whiteWall.jpg";
	}

}