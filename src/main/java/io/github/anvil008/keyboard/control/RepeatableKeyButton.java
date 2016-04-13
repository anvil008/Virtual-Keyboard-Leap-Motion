package io.github.anvil008.keyboard.control;


import javafx.animation.Animation.Status;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.input.MouseButton;
import javafx.util.Duration;
import org.slf4j.LoggerFactory;

class RepeatableKeyButton extends KeyButton {

	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(RepeatableKeyButton.class);

	private final long REPEAT_DELAY = 40;

	RepeatableKeyButton() {
		super();
		getStyleClass().add("repeatable-button");
	}

	@Override
	protected void initEventListener(long delay) {

		buttonDelay = new Timeline(new KeyFrame(Duration.millis(delay), event -> {
			fireShortPressed();
			buttonDelay.playFrom(buttonDelay.getCycleDuration().subtract(Duration.millis(REPEAT_DELAY)));
		}));

		setOnDragDetected(e -> {
			logger.trace("{} drag detected", getKeyCode());
			buttonDelay.stop();
			e.consume();
		});

		setOnMousePressed(e -> {
			logger.trace("{} pressed", getKeyCode());
			if (e.getButton().equals(MouseButton.PRIMARY)) {
				if (!isMovable()) {
					fireShortPressed();
				}
				buttonDelay.playFromStart();
			}
			e.consume();
		});

		setOnMouseReleased(e -> {
			logger.trace("{} released", getKeyCode());
			if (isMovable() && buttonDelay.getStatus() == Status.RUNNING) {
				fireShortPressed();
			}
			buttonDelay.stop();
			setFocused(false);
			e.consume();
		});

	}

}
