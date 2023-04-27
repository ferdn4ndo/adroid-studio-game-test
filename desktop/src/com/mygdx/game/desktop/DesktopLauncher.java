package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MyGame;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.badlogic.gdx.tools.texturepacker.TexturePacker.Settings;

import java.io.IOException;


public class DesktopLauncher{
	private static boolean rebuildAtlas = true;
	private static boolean drawDebugOutline = true;

	public static void main (String[] arg) throws IOException{
		/*//This code generates the Atlas file with libGDX TexturePacker,
			but i'm using the GUI Texture Packer
		if(rebuildAtlas){
			Settings settings = new Settings();
			settings.maxHeight = 1024;
			settings.maxWidth = 1024;
			settings.duplicatePadding = false;
			settings.debug = drawDebugOutline;
			TexturePacker.process(settings,"assets-raw/images","../android/assets/images","myGame.pack");
		}*/

		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		//The Screen dimentions are initially 800x480
		config.width = 800;
		config.height = 480;
		config.title = "My First Game";
		new LwjglApplication(new MyGame(), config);
	}
}
