package br.ufal.ic.cg.church.objects.impl;

import javax.media.opengl.GL2;

import br.ufal.ic.cg.church.objects.AutoDrawnableObject;

import com.jogamp.opengl.util.gl2.GLUT;

public class LateralWall extends AutoDrawnableObject {

	private GLUT glut;
	private int startList = gl.glGenLists(12);

	public LateralWall(GL2 gl) {
		super(gl);
		glut = new GLUT();
		compileGround(gl);
	}

	private void compileGround(GL2 gl) {

		// vigas e colunas
		gl.glNewList(startList, GL2.GL_COMPILE);

		glut.glutSolidCube(0.45f);

		gl.glEndList();

	}

	@Override
	public void selfDraw(GL2 gl) {

		gl.glColor3f(1.0f, 1.0f, 1.0f);
		texture.enable(gl);
		texture.bind(gl);

		// viga esquerda
		gl.glPushMatrix();
		gl.glTranslatef(5.0f, -17.8f, 8.0f);
		gl.glScalef(1.0f, 55f, 1.0f);
		gl.glCallList(startList);
		gl.glPopMatrix();

		// viga direita
		gl.glPushMatrix();
		gl.glTranslatef(12.2f, -17.8f, 8.0f);
		gl.glScalef(1.0f, 55f, 1.0f);
		gl.glCallList(startList);
		gl.glPopMatrix();
		//

		// colunas
		gl.glPushMatrix();
		gl.glTranslatef(12.2f, -21.6f, 4f);
		gl.glScalef(1.0f, 2.44f, 18f);

		for (int j = 0; j < 2; j++) {
			for (int i = 0; i < 5; i++) {
				gl.glCallList(startList);
				gl.glTranslatef(0, 1.6f, 0);
			}
			gl.glTranslatef(-7.2f, -8f, 0f);
		}
		gl.glPopMatrix();

	}

	@Override
	protected String getTextureExtension() {
		return "jpg";
	}

	@Override
	protected String getTextureImg() {
		return "whiteWall.jpg";
	}

}
