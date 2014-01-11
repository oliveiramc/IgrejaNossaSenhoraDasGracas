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
public class Altar extends AutoDrawnableObject {

	private GLUT glut;

	/**
	 * 
	 * @param gl
	 */
	public Altar(GL2 gl) {
		super(gl);
		glut = new GLUT();
	}


	/**
	 * 
	 */
	@Override
	public void selfDraw(GL2 gl) {

		// janelas dentro do altar
	/*	
		texture.enable(gl);
		texture.bind(gl);*/

	

		gl.glPushMatrix();
		
		gl.glColor3f(0.20f, 0.09f, 0.09f);

		gl.glTranslatef(8.6f, -24.0f, 0.7f);
		gl.glScalef(2.89f, 1.0f, 1.34f);

		glut.glutSolidCube(0.9f);
		

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
	//	return "wood.jpg";
		return "altar.jpg";
	}
}
