package edu.feri.rv.virusss8;

import com.badlogic.gdx.backends.jogl.JoglApplication;

public class MyCubeDesktop {
	public static void main (String[] argv) {
//        new JoglApplication(new MyOther(), "Moj objekt", 480, 320, false);
        new JoglApplication(new MyCube(), "Moja kocka", 480, 320, false);
	}
}
