
package io.github.anvil008.keyboard.xml.layout;

import javax.xml.bind.annotation.XmlRegistry;


@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.comtel2000.keyboard.xml.layout
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Keyboard }
     * 
     */
    public Keyboard createKeyboard() {
        return new Keyboard();
    }

    /**
     * Create an instance of {@link Keyboard.Row }
     * 
     */
    public Keyboard.Row createKeyboardRow() {
        return new Keyboard.Row();
    }

    /**
     * Create an instance of {@link Keyboard.Row.Key }
     * 
     */
    public Keyboard.Row.Key createKeyboardRowKey() {
        return new Keyboard.Row.Key();
    }

}
