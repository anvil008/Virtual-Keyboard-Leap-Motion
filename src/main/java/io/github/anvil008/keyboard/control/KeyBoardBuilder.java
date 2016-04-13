package io.github.anvil008.keyboard.control;

import javafx.util.Builder;
import io.github.anvil008.keyboard.robot.IRobot;

import java.nio.file.Path;
import java.util.Locale;

public class KeyBoardBuilder implements Builder<KeyboardPane> {

	private final KeyboardPane kb;

	protected KeyBoardBuilder() {
		kb = new KeyboardPane();
	}

	public static KeyBoardBuilder create() {
		return new KeyBoardBuilder();
	}

	public KeyBoardBuilder layerPath(Path path) {
		kb.setLayerPath(path);
		return this;
	}

	public KeyBoardBuilder layer(DefaultLayer layer) {
		kb.setLayer(layer);
		return this;
	}

	public KeyBoardBuilder style(String css) {
		kb.setStyle(css);
		return this;
	}

	public KeyBoardBuilder initLocale(Locale locale) {
		kb.setLocale(locale);
		return this;
	}

	public KeyBoardBuilder initScale(double scale) {
		kb.setScale(scale);
		return this;
	}

	public KeyBoardBuilder addIRobot(IRobot robot) {
		kb.addRobotHandler(robot);
		return this;
	}

	@Override
	public KeyboardPane build() {
		try {
			kb.load();
		} catch (Exception e) {
			new RuntimeException(e);
		}
		return kb;
	}

}
