package com.mygdx.game.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.AbstractGameObject;
import com.mygdx.game.Assets;

/**
 * Created by Rodrigo on 04/06/2015.
 */
public class PsicodelicFloor extends AbstractGameObject{

    Assets assets = new Assets();

    private TextureRegion beginFloor;
    private TextureRegion mediumFloor;
    private TextureRegion endFloor;

    private int length;

    public PsicodelicFloor() {
        init();
    }

    private void init() {
        dimension.set(1,1.5f);
        mediumFloor = assets.floor;
        setLength(5);
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void increaseLength(int amount){
        setLength(length + amount);
    }

    @Override
    public void render(SpriteBatch batch) {
        TextureRegion reg = null;
        float relX = 0;
        float relY = 0;

       /* public void draw (Texture texture, float x, float y,float originX,
        float originY, float width, float height, float scaleX, float
        scaleY, float rotation, int srcX, int srcY,
        int srcWidth, int srcHeight, boolean flipX, boolean flipY);
        */

        // Draw left edge
        //TODO Criar beginFloor, por enquanto estou usando mediumFloor
        reg = mediumFloor;
        relX -= dimension.x / 4;
        batch.draw(reg.getTexture(), position.x + relX, position.y +
                        relY, origin.x, origin.y, dimension.x / 4, dimension.y,
                scale.x, scale.y, rotation, reg.getRegionX(), reg.getRegionY(),
                reg.getRegionWidth(), reg.getRegionHeight(), false, false);

        // Draw middle
        relX = 0;

        // reg = mediumFloor;
        reg = mediumFloor;
        for (int i = 0; i < length; i++) {
            batch.draw(reg.getTexture(), position.x + relX, position.y
                            + relY, origin.x, origin.y, dimension.x, dimension.y,
                    scale.x, scale.y, rotation, reg.getRegionX(), reg.getRegionY(),
                    reg.getRegionWidth(), reg.getRegionHeight(), false, false);
            relX += dimension.x;
        }

        //Draw Right Edge
        //TODO Criar endFloor, por enquanto estou usando mediumFloor, lembrando que apenas espelho o beginFloor por enquanto
        reg = mediumFloor;
        batch.draw(reg.getTexture(),position.x + relX, position.y +
                        relY, origin.x + dimension.x / 8, origin.y, dimension.x / 4,
                dimension.y, scale.x, scale.y, rotation, reg.getRegionX(),
                reg.getRegionY(), reg.getRegionWidth(), reg.getRegionHeight(),
                true, false);
    }

}
