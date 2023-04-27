package com.mygdx.game;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;

import static com.badlogic.gdx.Input.*;

/**
 * Created by Rodrigo on 03/06/2015.
 */
public class WorldControllerManager extends InputAdapter{
    private static final String TAG = WorldControllerManager.class.getName();

    public Assets assets;
    public WorldCameraManager worldCameraManager;

    public Level level;
    public int lives;
    public int score;

    public WorldControllerManager() {
        init();
    }

    private void init(){
        Gdx.input.setInputProcessor(this);
        worldCameraManager = new WorldCameraManager();
        lives = Constants.LIVES_START;
        initLevel();
        //initTestObjects();
    }

    private void initLevel () {
        score = 0;
        level = new Level(Constants.LEVEL_01);
    }

  public void update(float deltaTime){
      handleDebugInput(deltaTime);
      worldCameraManager.update(deltaTime);
  }

    private void handleDebugInput(float deltaTime) {
        if(Gdx.app.getType() != Application.ApplicationType.Desktop) return;
        //Select Sprite Controls
        float camMoveSpeed = 5*deltaTime;

        if(Gdx.input.isKeyPressed(Keys.RIGHT)){
            moveCamera(camMoveSpeed,0);
        }
        if(Gdx.input.isKeyPressed(Keys.LEFT)){
            moveCamera(-camMoveSpeed,0);
        }
    }

    private void moveCamera(float x, int y) {
        x += worldCameraManager.getPosition().x;
        y += worldCameraManager.getPosition().y;
        worldCameraManager.setPosition(x, y);
    }

    @Override
    public boolean keyUp (int keycode) {
// Reset game world
        if (keycode == Keys.R) {
            init();
            Gdx.app.debug(TAG, "Game world resetted");
        }
        return false;
    }


  /*  TEST TO PRINT ASSETS _ WORKING!!!(Funcionando Porra!)
    private void initTestObjects() {

        // Create new array for 1 sprites
        testSprites = new Sprite[1];
        assets = new Assets();
        Array<TextureRegion> regions = new Array<TextureRegion>();
        regions.add(assets.floor);


        for (int i = 0; i < testSprites.length; i++) {
            Sprite spr = new Sprite(regions.random());
            // Define sprite size to be 1m x 1m in game world
            spr.setSize((float) 5.15, (float) 1.35);
            // Set origin to sprite's center
            spr.setOrigin(spr.getWidth() / 2.0f, spr.getHeight() / 2.0f);

            // Calculate random position for sprite
            float randomX = MathUtils.random(-2.0f, 2.0f);
            float randomY = MathUtils.random(-2.0f, 2.0f);
            spr.setPosition((float) -4.0, 0);
            // Put new sprite into array
            testSprites[i] = spr;
        }
        // Set first sprite as selected one
        selectedSprite = 0;
    }
*/
}
