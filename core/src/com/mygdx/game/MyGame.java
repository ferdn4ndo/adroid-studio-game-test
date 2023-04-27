package com.mygdx.game;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGame extends ApplicationAdapter {

    private static final String TAG = MyGame.class.getName();

    private WorldControllerManager worldControllerManager;
    private WorldRendererManager worldRendererManager;
    private Assets assets;


    public boolean paused;
	
	@Override
	public void create () {
        //Set libGDX log level to DEBUG
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        //Initialize Controller and Renderer
        worldControllerManager = new WorldControllerManager();
        worldRendererManager = new WorldRendererManager(worldControllerManager);
        // Game world is active on start
        paused = false;

	}

	@Override
	public void render () {

        if(!paused){
            // Update game world by the time that has passed
            // since last rendered frame.
            worldControllerManager.update(Gdx.graphics.getDeltaTime());
        }

        //The following code sets the clear color and clears the screen
        Gdx.gl.glClearColor(0x64/255.0f, 0x95/255.0f, 0xed/255.0f,
                0xff/255.0f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Render game world to screen
        worldRendererManager.render();
	}

	@Override
	public void resize(int width, int height){worldRendererManager.resize(width, height);}

	@Override
    public void pause(){
        paused = true;
    }

    @Override
    public void resume(){
        paused = false;
    }

    @Override
    public  void dispose(){

    }
}
