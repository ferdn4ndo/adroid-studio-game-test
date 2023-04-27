package com.mygdx.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;

/**
 * Created by Rodrigo on 03/06/2015.
 */
public class WorldRendererManager implements Disposable {

    private OrthographicCamera camera;
    private SpriteBatch batch;
    private WorldControllerManager worldControllerManager;

    public WorldRendererManager(WorldControllerManager worldControllerManager) {
        this.worldControllerManager = worldControllerManager;
        init();
    }

    private void init() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera(Constants.VIEWPORT_WIDTH,
                Constants.VIEWPORT_HEIGHT);
        camera.position.set(0, 0, 0);
        camera.update();
    }

    public void render(){
        renderWorld(batch);
        //renderTestObjects();
    }

    private void renderWorld (SpriteBatch batch) {
        worldControllerManager.worldCameraManager.applyTo(camera);
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        worldControllerManager.level.render(batch);
        batch.end();
    }

   /* private void renderTestObjects() {
        //worldControllerManager.cameraHelper.applyTo(camera);
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        for(Sprite sprite : worldControllerManager.testSprites) {
            sprite.draw(batch);
        }
        batch.end();
    }*/

    public void resize(int width, int height){
        camera.viewportWidth = (Constants.VIEWPORT_HEIGHT / height) *
                width;
        camera.update();
    }
    @Override
    public void dispose() {
        batch.dispose();
    }
}
