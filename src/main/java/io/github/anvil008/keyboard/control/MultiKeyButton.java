package io.github.anvil008.keyboard.control;


import javafx.animation.Animation.Status;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.scene.Node;
import javafx.scene.input.MouseButton;
import javafx.util.Duration;
import org.slf4j.LoggerFactory;

import java.util.Collection;

class MultiKeyButton extends KeyButton {

	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(MultiKeyButton.class);

	private MultiKeyPopup context;

	private final Collection<String> styles;

	private final DoubleProperty scaleProperty;

	MultiKeyButton(DoubleProperty scaleProperty, Collection<String> styles) {
		super();
		getStyleClass().add("multi-button");
		this.styles = styles;
		this.scaleProperty = scaleProperty;
	}

	@Override
	protected void initEventListener(long delay) {

		buttonDelay = new Timeline(new KeyFrame(new Duration(delay), event -> fireLongPressed()));

		setOnDragDetected(e -> {
			logger.trace("{} drag detected", getKeyCode());
			if (buttonDelay.getStatus().equals(Status.RUNNING) && buttonDelay.getCurrentRate() > 0) {
				buttonDelay.stop();
				fireLongPressed();
			}
			e.consume();
		});

		setOnMouseClicked(event -> {
			logger.trace("{} clicked: {}", getKeyCode(), buttonDelay.getCurrentRate());

			if (event.getButton().equals(MouseButton.PRIMARY)) {
				if (buttonDelay.getStatus().equals(Status.RUNNING)) {
					buttonDelay.stop();
					fireShortPressed();
				}
			}
			setFocused(false);
			event.consume();
		});

		setOnMousePressed(event -> {
			logger.trace("{} pressed: {}", getKeyCode(), buttonDelay.getCurrentRate());
			if (event.getButton().equals(MouseButton.PRIMARY)) {
				buttonDelay.playFromStart();
			}
			event.consume();
		});

	}

	private MultiKeyPopup getContext() {
		if (context == null) {
			context = new MultiKeyPopup();
			context.getStylesheets().setAll(styles);
			context.setOnHidden(event -> {
				getParent().getParent().setEffect(null);
				getParent().getParent().setDisable(false);
			});
			setOnLongPressed(event -> {

				// getParent().getParent().setEffect(new BoxBlur());
				getParent().getParent().setDisable(true);
				setFocused(false);
				context.show((Node) event.getSource(), scaleProperty.get());
			});

		}
		return context;
	}

	@Override
	public void addExtKeyCode(int extKeyCode, String label) {
		KeyButton button = new ShortPressKeyButton();
		button.setText(label);
		button.setKeyCode(extKeyCode);

		if (getStyleClass() != null) {
			button.getStyleClass().addAll(getStyleClass());
		} else {
			button.setId("key-context-button");
		}
		button.setFocusTraversable(false);

		button.setPrefWidth(this.getPrefWidth());
		button.setPrefHeight(this.getPrefHeight());

		button.setOnShortPressed(getOnShortPressed());

		getContext().addButton(button);
	}

}
