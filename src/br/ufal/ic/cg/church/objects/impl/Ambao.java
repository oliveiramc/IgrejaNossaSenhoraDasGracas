package br.ufal.ic.cg.church.objects.impl;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

import br.ufal.ic.cg.church.objects.AutoDrawnableObject;

public class Ambao extends AutoDrawnableObject{
	private int startList;
	private GLU glu = new GLU();
	
	public Ambao(GL2 gl) {
		super(gl);
		compileGround(gl);
	}

	private void compileGround(GL2 gl) {
		
		startList = gl.glGenLists(1);
		
		GLUquadric quadric = glu.gluNewQuadric();
		
		gl.glNewList(startList, GL2.GL_COMPILE);
		gl.glColor3f(0.92f, 0.51f, 0.23f);//92,51,23
		gl.glTranslatef(12, -27, 0.2f);
		
		
		//tronco
		gl.glTranslatef(0, 0, 0.1f);
		gl.glScalef(1, 1, 3.2f);
		glu.gluQuadricTexture(quadric, true);
		glu.gluCylinder(quadric, 0.2, 0.2, 0.4, 8, 8);
		
		gl.glTranslatef(0, 0, 0.4f);
		glu.gluQuadricTexture(quadric, true);
		glu.gluDisk(quadric, 0f,0.4f , 8, 8);
		
		
		gl.glEndList();
	}

	@Override
	public void selfDraw(GL2 gl) {
		gl.glColor3f(0.54f, 0.28f, -1.0f);
		gl.glTranslatef(-1f, 3.2f, -0.1f);
		gl.glCallList(startList);
	}

	@Override
	protected String getTextureExtension() {
		// TODO Auto-generated method stub
		return "jpg";
	}

	@Override
	protected String getTextureImg() {
		// TODO Auto-generated method stub
		return "ambao.jpg";
	}

}
