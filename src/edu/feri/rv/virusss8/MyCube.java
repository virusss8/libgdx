package edu.feri.rv.virusss8;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.Input;

public class MyCube implements ApplicationListener {
    private Mesh[] triangleMesh;
    private Camera camera;
    private static float comX = 0.0f; 
    private static float comY = 0.0f;
    private static float comZ = 2.0f;

    @Override
    public void create() {
        if (triangleMesh == null) {
        	triangleMesh = new Mesh[6];
        	
        	for (int i = 0; i < 6; i++) {
				triangleMesh[i] = new Mesh(true, 4, 4,
						new VertexAttribute(Usage.Position, 3, "a_position"),
						new VertexAttribute(Usage.ColorPacked, 4, "a_color"));

				triangleMesh[i].setIndices(new short[] { 0, 1, 2, 3 });
			}

        	triangleMesh[0].setVertices(new float[] {
        			0.5f, 0.5f, 0.5f, Color.toFloatBits(75, 0, 0, 255),
        	        -0.5f, 0.5f, 0.5f, Color.toFloatBits(75, 0, 0, 255),
        	        0.5f, -0.5f, 0.5f, Color.toFloatBits(75, 0, 0, 255),
        	        -0.5f, -0.5f, 0.5f, Color.toFloatBits(75, 0, 0, 255) });
        	 
        	triangleMesh[1].setVertices(new float[] {
        	        0.5f, 0.5f, -0.5f, Color.toFloatBits(128, 0, 0, 255),
        	        -0.5f, 0.5f, -0.5f, Color.toFloatBits(128, 0, 0, 255),
        	        0.5f, -0.5f, -0.5f,  Color.toFloatBits(128, 0, 0, 255),
        	        -0.5f, -0.5f, -0.5f, Color.toFloatBits(128, 0, 0, 255) });
        	 
        	triangleMesh[2].setVertices(new float[] {
        	        0.5f, 0.5f, -0.5f, Color.toFloatBits(0, 255, 0, 255),
        	        -0.5f, 0.5f, -0.5f, Color.toFloatBits(0, 255, 0, 255),
        	        0.5f, 0.5f, 0.5f, Color.toFloatBits(0, 255, 0, 255),
        	        -0.5f, 0.5f, 0.5f, Color.toFloatBits(0, 255, 0, 255) });
        	 
        	triangleMesh[3].setVertices(new float[] {
        	        0.5f, -0.5f, -0.5f, Color.toFloatBits(0, 96, 0, 255),
        	        -0.5f, -0.5f, -0.5f, Color.toFloatBits(0, 96, 0, 255),
        	        0.5f, -0.5f, 0.5f, Color.toFloatBits(0, 96, 0, 255),
        	        -0.5f, -0.5f, 0.5f,  Color.toFloatBits(0, 96, 0, 255) });
        	 
            triangleMesh[4].setVertices(new float[] {
        	        0.5f, 0.5f, 0.5f, Color.toFloatBits(0, 0, 101, 255),
        	        0.5f, -0.5f, 0.5f, Color.toFloatBits(0, 0, 101, 255),
        	        0.5f, 0.5f, -0.5f, Color.toFloatBits(0, 0, 101, 255),
        	        0.5f, -0.5f, -0.5f, Color.toFloatBits(0, 0, 101, 255) });
        	 
            triangleMesh[5].setVertices(new float[] {
        	        -0.5f, 0.5f, 0.5f, Color.toFloatBits(0, 0, 96, 255),
        	        -0.5f, -0.5f, 0.5f, Color.toFloatBits(0, 0, 96, 255),
        	        -0.5f, 0.5f, -0.5f, Color.toFloatBits(0, 0, 96, 255),
        	        -0.5f, -0.5f, -0.5f, Color.toFloatBits(0, 0, 96, 255) });
            }
        Gdx.gl.glEnable(GL10.GL_DEPTH_TEST);
    }

    @Override
    public void dispose() { }

    @Override
    public void pause() { }


//    @Override
//    public void render() {
//        camera.update();
//        camera.apply(Gdx.gl10);
//        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
//        squareMesh.render(GL10.GL_TRIANGLE_STRIP, 0, 4);
////        nearSquare.render(GL10.GL_TRIANGLE_STRIP, 0, 4);
//        desno.render(GL10.GL_TRIANGLE_STRIP, 0, 4);
//        zgoraj.render(GL10.GL_TRIANGLE_STRIP, 0, 4);
//    }

    private int total = 0;
    private float movementIncrement = 0.006f;

    @Override
    public void render() {
//        total += 1;
//        if (total > 500) {
//            movementIncrement = -movementIncrement;
//            total = -200;
//        }
//
//        camera.rotate(movementIncrement * 20, 0, 1, 0);
//        camera.translate(movementIncrement, 0, movementIncrement);
//        camera.update();
//        camera.apply(Gdx.gl10);
//        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
//        spredaj.render(GL10.GL_TRIANGLE_STRIP, 0, 4);
//        zadaj.render(GL10.GL_TRIANGLE_STRIP, 0, 4);
//        zgoraj.render(GL10.GL_TRIANGLE_STRIP, 0, 4);
//        spodaj.render(GL10.GL_TRIANGLE_STRIP, 0, 4);
//        levo.render(GL10.GL_TRIANGLE_STRIP, 0, 4);
//        desno.render(GL10.GL_TRIANGLE_STRIP, 0, 4);
    	
    	if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
			comY+=0.015;
		} 
		else if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
			comY-=0.015;
		}
		else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			comX+=0.015;
		}
		else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			comX-=0.015;
		}
		else if (Gdx.input.isKeyPressed(Input.Keys.PAGE_DOWN)) {
			comZ+=0.015;
		}
		else if (Gdx.input.isKeyPressed(Input.Keys.PAGE_UP)) {
			comZ-=0.015;
		}

		camera.position.set(comX, comY, comZ);

		camera.update();
		camera.apply(Gdx.gl10);

		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

		for (Mesh allMashes : triangleMesh) {
			allMashes.render(GL10.GL_TRIANGLE_STRIP, 0, 4); //renderiraj vse stranice, ki so sestavljene iz dveh trikotnikov
		}

		try {
			Thread.sleep(16); // ~60FPS
		} catch (InterruptedException e) {
		}
    }
    
    @Override
    public void resize(int width, int height) {
    	float aspectRatio = (float) width / (float) height;
//    	camera = new OrthographicCamera(2f * aspectRatio, 2f); // ta kamera ne spreminja oblike objektov, zato tudi 3d objekte vidimo v 2D
		camera = new PerspectiveCamera(67, 2f * aspectRatio, 2f);  // tukaj lahko dejansko objekte vidimo v 3D, ker se jim spreminja oblika, glede na kot gledanja
		camera.near = 0.1f;
		camera.translate(comX, comY, comZ);
    }

    @Override
    public void resume() { }
}
