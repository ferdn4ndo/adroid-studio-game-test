package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Disposable;

/**
 * Created by Rodrigo on 04/06/2015.
 */
public class Assets{

    public static final String TAG = Assets.class.getName();

    private TextureAtlas atlasImages;
    private Skin skin;

    //Regions
    public TextureRegion floor;

    public Assets() {
        atlasImages = new TextureAtlas(Constants.TEXTURE_ATLAS_OBJECTS);
        skin = new Skin();
        skin.addRegions(atlasImages);
        loadTextures();
    }

    private void loadTextures() {
        floor = new AssetFloor(atlasImages).floor;
    }

    public Skin getSkin() {
        return skin;
    }
    public void dispose(){
        atlasImages.dispose();
        skin.dispose();
    }

    public class   AssetFloor {
        public final AtlasRegion floor;

        public AssetFloor(TextureAtlas atlas) {
            floor = atlas.findRegion("chao");
        }
    }
}