package br.ufal.ic.cg.church.objects.impl;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUtessellator;
import javax.media.opengl.glu.GLUtessellatorCallback;

import br.ufal.ic.cg.church.objects.AutoDrawnableObject;
import br.ufal.ic.cg.church.objects.GeometryUtils;

public class FrontWall extends AutoDrawnableObject {

	private int startList;
	private GLU glu;

	private double wall_Height = 8;
	private double wall_Width = 12.6;

	public FrontWall(GL2 gl) {
		super(gl);
		initData();
	}

	private void initData() {
		glu = new GLU();

		TessellCallBack tessCallback = new TessellCallBack(gl, glu);

		double rect[][] = new double[][] { { 0, 0, 0.0 },
				{ wall_Width, 0, 0.0 }, { wall_Width, 0.0, wall_Height },
				{ 0, 0.0, wall_Height } };
		double[] normal = GeometryUtils.calculateNormal(rect[0], rect[1],
				rect[2]);

		double tri_meio[][] = GeometryUtils.createPortalVertices(5.4f, 0f, 1.8f,
				3f);
		double tri[][] = GeometryUtils.createPortalVertices(1.0f, 0f, 1.4f, 2f);
		double tri2[][] = GeometryUtils.createPortalVertices(10f, 0f, 1.4f, 2f);

		double[][] window1 = GeometryUtils.createPortalVertices(10.4f, 5f,
				0.7f, 1f);
		double[][] window2 = GeometryUtils.createPortalVertices(1.5f, 5f, 0.7f,
				1f);
		double[][] window3 = GeometryUtils.createPortalVertices(5.9f, 5f, 0.7f,
				1f);

		float y_translate = 0.5f;

		startList = gl.glGenLists(4);

		GLUtessellator tobj = GLU.gluNewTess();

		GLU.gluTessCallback(tobj, GLU.GLU_TESS_VERTEX, tessCallback);// glVertex3dv);
		GLU.gluTessCallback(tobj, GLU.GLU_TESS_BEGIN, tessCallback);// beginCallback);
		GLU.gluTessCallback(tobj, GLU.GLU_TESS_END, tessCallback);// endCallback);
		GLU.gluTessCallback(tobj, GLU.GLU_TESS_ERROR, tessCallback);// errorCallback);

		// lado_dentro
		gl.glNewList(startList, GL2.GL_COMPILE);
		GLU.gluTessBeginPolygon(tobj, null);
		GLU.gluTessBeginContour(tobj);
		for (int i = 0; i < rect.length; i++) {
			GLU.gluTessVertex(tobj, rect[i], 0, new double[] { rect[i][0],
					rect[i][1], rect[i][2], normal[0], normal[1], normal[2] });
		}
		GLU.gluTessEndContour(tobj);
		GLU.gluTessBeginContour(tobj);
		//
		// // Todas as 5 aberturas.
		for (int i = 0; i < tri.length; i++) {

			GLU.gluTessVertex(tobj, tri[i], 0, new double[] { tri[i][0],
					tri[i][1], tri[i][2], normal[0], normal[1], normal[2] });
		}
		GLU.gluTessEndContour(tobj);
		GLU.gluTessBeginContour(tobj);
		for (int i = 0; i < tri2.length; i++) {
			GLU.gluTessVertex(tobj, tri2[i], 0, new double[] { tri2[i][0],
					tri2[i][1], tri2[i][2], normal[0], normal[1], normal[2] });
		}
		GLU.gluTessEndContour(tobj);
		GLU.gluTessBeginContour(tobj);
		for (int i = 0; i < tri_meio.length; i++) {
			GLU.gluTessVertex(tobj, tri_meio[i], 0, new double[] {
					tri_meio[i][0], tri_meio[i][1], tri_meio[i][2], normal[0],
					normal[1], normal[2] });
		}

		GLU.gluTessEndContour(tobj);
		GLU.gluTessBeginContour(tobj);
		for (int i = 0; i < window1.length; i++) {
			GLU.gluTessVertex(tobj, window1[i], 0, new double[] {
					window1[i][0], window1[i][1], window1[i][2], normal[0],
					normal[1], normal[2] });
		}
		for (int i = 0; i < window2.length; i++) {
			GLU.gluTessVertex(tobj, window2[i], 0, new double[] {
					window2[i][0], window2[i][1], window2[i][2], normal[0],
					normal[1], normal[2] });
		}
		for (int i = 0; i < window3.length; i++) {
			GLU.gluTessVertex(tobj, window3[i], 0, new double[] {
					window3[i][0], window3[i][1], window3[i][2], normal[0],
					normal[1], normal[2] });
		}

		GLU.gluTessEndContour(tobj);
		GLU.gluTessEndPolygon(tobj);
		gl.glEndList();

		double[] normal2 = GeometryUtils.calculateNormal(rect[2], rect[1],
				rect[0]);

		// Lado_fora
		gl.glNewList(startList + 1, GL2.GL_COMPILE);
		GLU.gluTessNormal(tobj, normal2[0], normal2[1], normal2[2]);
		GLU.gluTessBeginPolygon(tobj, null);
		GLU.gluTessBeginContour(tobj);
		for (int i = rect.length - 1; i >= 0; i--) {
			GLU.gluTessVertex(tobj, rect[i], 0,
					new double[] { rect[i][0], rect[i][1], rect[i][2],
							normal2[0], normal2[1], normal2[2] });
		}
		GLU.gluTessEndContour(tobj);
		GLU.gluTessBeginContour(tobj);

		for (int i = tri.length - 1; i >= 0; i--) {
			GLU.gluTessVertex(tobj, tri[i], 0, new double[] { tri[i][0],
					tri[i][1], tri[i][2], normal2[0], normal2[1], normal2[2] });
		}
		GLU.gluTessEndContour(tobj);
		GLU.gluTessBeginContour(tobj);
		for (int i = tri2.length - 1; i >= 0; i--) {
			GLU.gluTessVertex(tobj, tri2[i], 0,
					new double[] { tri2[i][0], tri2[i][1], tri2[i][2],
							normal2[0], normal2[1], normal2[2] });
		}

		GLU.gluTessEndContour(tobj);
		GLU.gluTessBeginContour(tobj);
		for (int i = tri_meio.length - 1; i >= 0; i--) {
			GLU.gluTessVertex(tobj, tri_meio[i], 0, new double[] {
					tri_meio[i][0], tri_meio[i][1], tri_meio[i][2], normal2[0],
					normal2[1], normal2[2] });
		}

		GLU.gluTessEndContour(tobj);
		GLU.gluTessBeginContour(tobj);
		for (int i = window1.length - 1; i >= 0; i--) {
			GLU.gluTessVertex(tobj, window1[i], 0, new double[] {
					window1[i][0], window1[i][1], window1[i][2], normal[0],
					normal[1], normal[2] });
		}
		for (int i = 0; i < window2.length; i++) {
			GLU.gluTessVertex(tobj, window2[i], 0, new double[] {
					window2[i][0], window2[i][1], window2[i][2], normal[0],
					normal[1], normal[2] });
		}
		for (int i = 0; i < window3.length; i++) {
			GLU.gluTessVertex(tobj, window3[i], 0, new double[] {
					window3[i][0], window3[i][1], window3[i][2], normal[0],
					normal[1], normal[2] });
		}
		GLU.gluTessEndContour(tobj);
		GLU.gluTessEndPolygon(tobj);
		gl.glEndList();

		gl.glNewList(startList + 2, GL2.GL_COMPILE);

		GeometryUtils.calculatePortalInside(gl, tri, y_translate, true);
		GeometryUtils.calculatePortalInside(gl, tri2, y_translate, true);
		GeometryUtils.calculatePortalInside(gl, window1, y_translate, true);
		GeometryUtils.calculatePortalInside(gl, window2, y_translate, true);
		GeometryUtils.calculatePortalInside(gl, window3, y_translate, true);
		GeometryUtils.calculatePortalInside(gl, tri_meio, y_translate, false);
		gl.glEndList();

		GLU.gluDeleteTess(tobj);

	}

	@Override
	public void selfDraw(GL2 gl) {

		texture.enable(gl);
		texture.bind(gl);

		gl.glCallList(startList + 3);
		gl.glTranslatef(2.3f, 0f, 0f);

		gl.glColor3f(1f, 1f, 1f);
		gl.glCallList(startList);

		gl.glTranslatef(0f, -0.5f, 0f);
		gl.glCallList(startList + 1);

		gl.glCallList(startList + 2);

	}

	private double[] calculateTexturePoint(double[] vertice) {
		double d_x = vertice[0] / wall_Width;
		double d_z = vertice[2] / wall_Height;

		return new double[] { d_x, d_z };
	}

	class TessellCallBack implements GLUtessellatorCallback {
		private GL2 gl;
		private GLU glu;

		public TessellCallBack(GL2 gl, GLU glu) {
			this.gl = gl;
			this.glu = glu;
		}

		public void begin(int type) {
			gl.glBegin(type);
		}

		public void end() {
			gl.glEnd();
		}

		public void vertex(Object vertexData) {
			double[] pointer;
			if (vertexData instanceof double[]) {
				pointer = (double[]) vertexData;
				gl.glTexCoord2dv(calculateTexturePoint(pointer), 0);
				gl.glVertex3dv(pointer, 0);
				if (pointer.length == 6) {
					gl.glNormal3dv(pointer, 3);
				}
			}
		}

		public void vertexData(Object vertexData, Object polygonData) {
		}

		public void combine(double[] coords, Object[] data, //
				float[] weight, Object[] outData) {
			for (Double object : coords) {
				System.out.println(object);
			}
			System.exit(0);
		}

		public void combineData(double[] coords, Object[] data, //
				float[] weight, Object[] outData, Object polygonData) {
			System.exit(0);
		}

		public void error(int errnum) {
			String estring;

			estring = glu.gluErrorString(errnum);
			System.err.println("Tessellation Error: " + estring);
			System.exit(0);
		}

		public void beginData(int type, Object polygonData) {
		}

		public void endData(Object polygonData) {
		}

		public void edgeFlag(boolean boundaryEdge) {
		}

		public void edgeFlagData(boolean boundaryEdge, Object polygonData) {
		}

		public void errorData(int errnum, Object polygonData) {
		}
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
