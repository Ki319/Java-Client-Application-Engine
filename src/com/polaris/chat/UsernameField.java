package com.polaris.chat;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glEnd;

import org.lwjgl.glfw.GLFW;

import com.polaris.engine.gui.element.TextField;
import com.polaris.engine.render.FontMap;
import com.polaris.engine.render.OpenGL;
import com.polaris.engine.render.Texture;
import com.polaris.engine.util.MathHelper;

public class UsernameField extends TextField
{
	private FontMap fontMap;
	private double highlightTicks = 0;

	public UsernameField() 
	{
		super(720, -40, 480, 30);
		fontMap = Texture.getFontMap("basic");
		nullText = "Username";
	}

	public void render(double delta)
	{
		highlightTicks = MathHelper.getExpValue(highlightTicks, .3d - (highlighted ? 0 : .3d), .25d, delta);

		glEnd();
		glEnable(GL_TEXTURE_2D);
		Texture.glBindTexture("font:basic");
		if(nullText != null && text.length() == 0)
		{
			OpenGL.glColor(0, 0, 0, .2 + highlightTicks);
			fontMap.drawAlignedFittedString(nullText, position.x + elementWidth / 2, position.y, 1, 1, elementWidth, elementHeight);
		}
		else
		{
			OpenGL.glColor(0, 0, 0, .5 + highlightTicks);
			fontMap.drawAlignedFittedString(text, position.x + elementWidth / 2, position.y, 1, 1, elementWidth, elementHeight);
		}
		glDisable(GL_TEXTURE_2D);
	}

	public void update(double delta)
	{
		super.update(delta);
		position.y = ((GuiLogin)gui).arrowYCoord - 40;
	}

	public int keyPressed(int keyId, int mods)
	{
		char key = (char) keyId;
		if(text.length() < 15 && ((key >= 65 && key <= 90) || (key >= 97 && key <= 122) || (text.length() > 1 && key >= 48 && key <= 57)))
		{
			text += key;
		}
		else if(keyId == GLFW.GLFW_KEY_ENTER)
		{
			gui.unbindCurrentElement();
			return 1;
		}
		else if((keyId == GLFW.GLFW_KEY_BACKSPACE || keyId == GLFW.GLFW_KEY_DELETE))
		{
			if(text.length() > 0)
			{
				text = text.substring(0, text.length() - 1);
			}
			return (10 << 16);
		}
		else if((keyId == GLFW.GLFW_KEY_TAB))
		{
			gui.setCurrentElement(1);
		}
		else if(keyId == GLFW.GLFW_KEY_ESCAPE)
		{
			gui.unbindCurrentElement();
		}
		return 0;
	}

	public int keyHeld(int keyId, int called, int mods)
	{
		if((keyId == GLFW.GLFW_KEY_BACKSPACE || keyId == GLFW.GLFW_KEY_DELETE))
		{
			if(text.length() > 0)
			{
				text = text.substring(0, text.length() - 1);
			}
			return (10 - Math.min(called, 9) << 16);
		}
		return 0;
	}

}