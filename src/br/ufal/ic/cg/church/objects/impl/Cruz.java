package br.ufal.ic.cg.church.objects.impl;

import javax.media.opengl.GL2;

import br.ufal.ic.cg.church.objects.AutoDrawnableObject;

import com.jogamp.opengl.util.gl2.GLUT;

public class Cruz extends AutoDrawnableObject {
	
	private GLUT glut = new GLUT();
	private int startList;
	
	public Cruz(GL2 gl) {
		super(gl);
		compile(gl);
	}

	
	
	private void compile(GL2 gl) {
		
		
		startList = gl.glGenLists(1);
		gl.glNewList(startList, GL2.GL_COMPILE);
		gl.glColor3f(0.112f, 0.219f, 0.147f);// 112,219,147
		glut.glutSolidCube(0.1f);
		gl.glEndList();
	}



	public void selfDraw(GL2 gl) {
		
		gl.glTranslatef(8.65f, 0f, 10.5f);
		
		gl.glPushMatrix();
		gl.glScalef(7f, 1, 1);
		gl.glCallList(startList);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		gl.glTranslatef(0f, 0f, -0.3f);
		gl.glScalef(1f, 1, 12.5f);
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

