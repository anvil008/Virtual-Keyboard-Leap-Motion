package io.github.anvil008.keyboard.control;

import javafx.beans.property.ObjectProperty;
import javafx.event.EventHandler;
import io.github.anvil008.keyboard.event.KeyButtonEvent;


interface LongPressable {

	void setOnLongPressed(EventHandler<? super KeyButtonEvent> eventhandler);

	EventHandler<? super KeyButtonEvent> getOnLongPressed();

	ObjectProperty<EventHandler<? super KeyButtonEvent>> onLongPressedProperty();

	void setOnShortPressed(EventHandler<? super KeyButtonEvent> eventhandler);

	EventHandler<? super KeyButtonEvent> getOnShortPressed();

	ObjectProperty<EventHandler<? super KeyButtonEvent>> onShortPressedProperty();
}
