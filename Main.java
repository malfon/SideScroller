import java.io.IOException;
import java.nio.file.Paths;

import org.jsfml.graphics.*;
import org.jsfml.window.*;
import org.jsfml.window.Keyboard.Key;
import org.jsfml.window.event.*;
import org.jsfml.system.*;

public class Main
{	
	public static int width=800, height=600;
	static int blocksize = width/20;
	static Clock clock = new Clock();
	static Texture /*p1t, mapt, uit*/ skyt, buildingst, groundt;
	static Sprite /*p1, map*/ sky, buildings, ground;

	public static void main(String args[]) throws IOException
	{
		RenderWindow window = new RenderWindow();
		window.create(new VideoMode(800, 600), "RPG");

		boolean w=false, s=false, a=false, d=false;

		Time dt = clock.restart();

		/*p1t = new Texture();
		p1t.loadFromFile(Paths.get("bin/player.png"));
		p1 = new Sprite();
		p1.setTexture(p1t);
		p1.setPosition(width-500+7, height-300+8);*/

		/*mapt = new Texture();
		mapt.loadFromFile(Paths.get("bin/map.png"));
		map = new Sprite();
		map.setTexture(mapt);
		map.setPosition(0, 0);*/

		/*uit = new Texture();
		uit.loadFromFile(Paths.get("bin/ui.png"));*/
		
		skyt = new Texture();
		skyt.loadFromFile(Paths.get("bin/sky.png"));
		sky = new Sprite();
		sky.setTexture(skyt);
		sky.setPosition(0, 0);
		
		buildingst = new Texture();
		buildingst.loadFromFile(Paths.get("bin/buildings.png"));
		buildings = new Sprite();
		buildings.setTexture(buildingst);
		buildings.setPosition(0, 200);
		
		groundt = new Texture();
		groundt.loadFromFile(Paths.get("bin/ground.png"));
		ground = new Sprite();
		ground.setTexture(groundt);
		ground.setPosition(0, 400);

		while(window.isOpen())
		{
			window.clear(Color.WHITE);
			for(Event event : window.pollEvents())
			{
				switch(event.type)
				{
				case CLOSED:
					window.close();
					break;

				case KEY_PRESSED:
					if(Keyboard.isKeyPressed(Key.ESCAPE))
						window.close();
					break;

				default:
					break;
				}
			}

			input(dt, w, s, a, d);
			
			if(sky.getPosition().x < -1200)
				sky.setPosition(-1200, 0);
			else
				sky.move(-dt.asSeconds()/8, 0);
			
			if(buildings.getPosition().x < -1200)
				buildings.setPosition(-1200, 200);
			else
				buildings.move(-dt.asSeconds()/4, 0);
			
			if(ground.getPosition().x < -1200)
				ground.setPosition(-1200, 400);
			else
				ground.move(-dt.asSeconds()/2, 0);

			//window.draw(map);
			//window.draw(p1);
			window.draw(sky);
			window.draw(buildings);
			window.draw(ground);
			window.display();
		}
	}

	static void input(Time dt, boolean w, boolean s, boolean a, boolean d)
	{
		dt = clock.restart();

		if(Keyboard.isKeyPressed(Key.W))
			w=true;
		if(Keyboard.isKeyPressed(Key.S))
			s=true;
		if(Keyboard.isKeyPressed(Key.A))
			a=true;
		if(Keyboard.isKeyPressed(Key.D))
			d=true;

		/*if(w && !s && !a && !d)
		{
			if(map.getPosition().y>0)
			{
				map.setPosition(map.getPosition().x, 0);
				if(p1.getPosition().y > 0)
					p1.move(0, -blocksize*dt.asSeconds());
			}

			map.move(0, blocksize*dt.asSeconds());
			w=true;
			s=false;
			a=false;
			d=false;
		}

		if(!w && s && !a && !d)
		{
			if(map.getPosition().y<-height/2)
			{
				map.setPosition(map.getPosition().x, -height/2);
				if(p1.getPosition().y <height-30)
					p1.move(0, blocksize*dt.asSeconds());
			}

			map.move(0, -blocksize*dt.asSeconds());
			w=false;
			s=true;
			a=false;
			d=false;
		}

		if(!w && !s && a && !d)
		{
			if(map.getPosition().x>0)
			{
				map.setPosition(0, map.getPosition().y);
				if(p1.getPosition().x>0)
					p1.move(-blocksize*dt.asSeconds(), 0);
			}

			map.move(blocksize*dt.asSeconds(), 0);
			w=false;
			s=false;
			a=true;
			d=true;
		}

		if(!w && !s && !a && d)
		{
			if(map.getPosition().x<-width/2)
			{
				map.setPosition(-width/2, map.getPosition().y);
				if(p1.getPosition().x<width-40)
					p1.move(blocksize*dt.asSeconds(), 0);
			}

			map.move(-blocksize*dt.asSeconds(), 0);
			w=false;
			s=false;
			a=true;
			d=true;
		}*/
	}
}
