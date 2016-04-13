package io.github.anvil008.keyboard.control;

import javafx.scene.input.MouseButton;
import org.slf4j.LoggerFactory;

class ShortPressKeyButton extends KeyButton {

	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(ShortPressKeyButton.class);

	ShortPressKeyButton() {
		super();
	}

	@Override
	protected void initEventListener(long delay) {
		setOnMousePressed(event -> {
			logger.trace("{} pressed", getKeyCode());
			if (event.getButton().equals(MouseButton.PRIMARY)) {
				fireShortPressed();
			}
			setFocused(false);
			event.consume();
		});
	}

}
