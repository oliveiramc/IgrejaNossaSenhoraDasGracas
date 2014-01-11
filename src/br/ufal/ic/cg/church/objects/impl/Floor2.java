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

public class Floor2 extends AutoDrawnableObject {

	private int startList = gl.glGenLists(5);

	/**
	 * 
	 * @param gl
	 */
	public Floor2(GL2 gl) {
		super(gl);

		compileGround(gl);
	}

	/**
	 * 
	 * @param gl
	 */
	private void compileGround(GL2 gl) {

		gl.glNewList(startList, GL2.GL_COMPILE);

		gl.glColor3f(1.0f, 1.0f, 1.0f);

		gl.glPushMatrix();

		gl.glBegin(GL2.GL_POLYGON);

		gl.glVertex3f(-0.15f, 0.0f, 0.0f);

		gl.glVertex3f(-12.65f, 0.0f, 0.0f);

		gl.glVertex3f(-12.65f, -4.7f, 0.0f);

		gl.glVertex3f(-10.8f, -4.7f, 0.0f);

		gl.glVertex3f(-9.0f, -3.25f, 0.0f);

		gl.glVertex3f(-4.3f, -3.25f, 0.0f);

		gl.glVertex3f(-2.9f, -4.7f, 0.0f);

		gl.glVertex3f(-0.15f, -4.7f, 0.0f);

		gl.glEnd();
		gl.glPopMatrix();

		gl.glEndList();
	}
	
	/**
	 * 
	 * @param x_init
	 * @return
	 */
	private double[][] createRetangulo(float x_init) {

		double[][] arr = new double[4][3];
		float x_width = (float) ((float) 5.0 - 0.4);
		double z_height = 2.4d; // fixa
		double z_init = 5; // fixa

		arr[0] = new double[] { x_init, 0, z_init };
		arr[1] = new double[] { x_init, 0.0, z_init + z_height };
		arr[2] = new double[] { x_init + x_width, 0.0, z_init + z_height };
		arr[3] = new double[] { x_init + x_width, 0.0, z_init };
		return arr;

	}

	/**
	 * 
	 */
	@Override
	public void selfDraw(GL2 gl) {

		texture.enable(gl);
		texture.bind(gl);

		gl.glPushMatrix();

		gl.glTranslatef(15f, -0.5f, 4.5f);

		gl.glCallList(startList);

		gl.glPopMatrix();
		
		this.createRetangulo(0.3f);
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
