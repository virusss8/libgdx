package edu.feri.rv.virusss8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g3d.loaders.obj.ObjLoader;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.Input;

public class MyOther implements ApplicationListener {
    private Mesh[] mesh;
    private PerspectiveCamera camera;
    public static final float angle = new Float(0.2);
    float comX = new Float(0);
	float comY = new Float(0);
	float comZ = new Float(1.5);
	float step = new Float(0.1);
    private Music music;
    private Texture texture = null;
    private Mesh world = null;

    @Override
    public void create() {
    	if (mesh == null) {

			InputStream stream = null;
			try {
				stream = new FileInputStream(Gdx.files.internal("data/missile.obj").path());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			world = ObjLoader.loadObj(stream, true);

			FileHandle imageFileHandle = Gdx.files.internal("data/woot.jpg"); 
	        texture = new Texture(imageFileHandle);
			mesh = new Mesh[6];
			
			Gdx.gl.glEnable(GL10.GL_DEPTH_TEST);
			Gdx.gl10.glTranslatef(0.0f,0.0f,-3.0f);
    	}
    }

    @Override
    public void dispose() { }

    @Override
    public void pause() { }

    @Override
    public void render() {    	
    	if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
//			comY+=0.015;
			comY -= step;
		} 
		else if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
//			comY-=0.015;
			comY += step;
		}
		else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
//			comX+=0.015;
			rotate(2*angle);
		}
		else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
//			comX-=0.015;
			rotate(-(4*angle)); // obrnemo tako da ne stoji na mestu ampak dejansko rotira
		}
		else if (Gdx.input.isKeyPressed(Input.Keys.PLUS)) {
//			comZ+=0.015;
			if(comX > 0) {
				if(comZ > 0) {
					comZ -= step;
				}
				else {
					comZ += step;				
				}
				comX -= step;
			}
			else {
				if(comZ > 0) {
					comZ -= step;
				}
				else {
					comZ += step;
				}
				comX += step;
			}
		}
		else if (Gdx.input.isKeyPressed(Input.Keys.MINUS)) {
//			comZ-=0.015;
			if(comX < 0) {
				if(comZ < 0) {
					comZ -= step;
				}
				else {
					comZ += step;				
				}
				comX += step;
			}
			else {
				if(comZ < 0) {
					comZ -= step;
				}
				else {
					comZ += step;
				}
				comX += step;
			}
		}
		else if (Gdx.input.isKeyPressed(Input.Keys.P)) {
			music = Gdx.audio.newMusic(Gdx.files.internal("music\\SetFireToTheRain.mp3"));
			music.setLooping(true);
			music.play();
		}
		else if (Gdx.input.isKeyPressed(Input.Keys.C)) {
			music.pause();
		}

    	rotateDefault();
    	
		camera.position.set(comX, comY, comZ);
		camera.lookAt(0, 0, 0);
		
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
	    Gdx.graphics.getGL10().glEnable(GL10.GL_TEXTURE_2D);
		camera.update();
		camera.apply(Gdx.gl10);

		texture.bind();
		world.render(GL10.GL_TRIANGLES);
		
		try {
			Thread.sleep(16); // ~60FPS
		} catch (InterruptedException e) {}

//		for (Mesh allMashes : triangleMesh) {
//			allMashes.render(GL10.GL_TRIANGLE_STRIP, 0, 4); //renderiraj vse stranice, ki so sestavljene iz dveh trikotnikov
//		}
    }
    
    private void rotate(float angleDeg) {
		float cos = MathUtils.cosDeg(angleDeg);
		float sin = MathUtils.sinDeg(angleDeg);
		float x = comX;
		float z = comZ;

		comX = (cos*x - sin*z);
		comZ = (sin*x + cos*z);
	}
    
    public void rotateDefault() {
		rotate(angle);
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