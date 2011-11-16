package edu.feri.rv.virusss8;

import com.badlogic.gdx.backends.jogl.JoglApplication;

public class MyCubeDesktop {
	public static void main (String[] argv) {
        new JoglApplication(new MyCube(), "My First Triangle", 480, 320, false);
	}
}
