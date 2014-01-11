package br.ufal.ic.cg.church.objects.impl;

import javax.media.opengl.GL2;

import br.ufal.ic.cg.church.objects.AutoDrawnableObject;

public class NovoAltar extends AutoDrawnableObject{

	public NovoAltar(GL2 gl) {
		super(gl);
	}

	@Override
	protected String getTextureExtension() {
		return "jpg";
	}

	@Override
	protected String getTextureImg() {
	//	return "wood.jpg";
		return "altar.jpg";
	}

	@Override
	public void selfDraw(GL2 gl) {
		texture.enable(gl);
		texture.bind(gl);
		
		gl.glBegin(GL2.GL_POLYGON);
		
		gl.glTexCoord2f(1.0f, 1.0f);
		gl.glVertex3f(5.2f	,-29.9f,0);
		gl.glTexCoord2f(1.0f, 0.0f);
		gl.glVertex3f(5.2f	,-29.9f,8);
		gl.glTexCoord2f(0.0f, 0.0f);
		gl.glVertex3f(12f,-29.9f,8);
		gl.glTexCoord2f(0.0f, 1.0f);
		gl.glVertex3f(12f,-29.9f,0);
		
		gl.glEnd();
		
	}

}
