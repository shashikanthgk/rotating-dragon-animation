package engineTester;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;

import Models.TextureModel;
import Models.rawModel;
import entities.Camera;
import entities.Entity;
import entities.Light;
import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.OBJLoader;
import renderEngine.renderer;
import shaders.StaticShader;
import textures.ModelTexture;


public class MainGameLoop {


	public static void main(String[] args) {
		DisplayManager.createDisplay();
		Loader loader = new Loader();
		StaticShader shader =  new StaticShader();
		renderer renderer1 = new renderer(shader);
		


		rawModel model = OBJLoader.loadObjModel("dragon", loader);//loader.loadToVAO(vertices,textureCoords,indices);
        ModelTexture texture = new ModelTexture(loader.loadTexture("stallTexture"));
        TextureModel staticModel = new TextureModel(model,texture);
        Entity entity = new Entity(staticModel, new Vector3f(0,0,-50),0,0,0,1);
        Light light = new Light(new Vector3f(0,0,-20),new Vector3f(1,1,1));
        Camera camera = new Camera();

		while (!Display.isCloseRequested()) {
		//entity.increasePosition(0, 0, -0.1f);
	  entity.increaseRotation(0,1, 0);

       camera.move();

	  renderer1.prepare();
      shader.start();
      shader.loadLight(light);
      shader.loadViewMatrix(camera);
      renderer1.render(entity,shader);
      shader.stop();
      DisplayManager.updateDisplay();
		}
		
		shader.cleanUp();
		loader.cleanUp();

		DisplayManager.closeDisplay();
	}

}
