package io.github.anvil008.keyboard.xml;

import io.github.anvil008.keyboard.xml.layout.Keyboard;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;

public class KeyboardLayoutHandler {

	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(KeyboardLayoutHandler.class);

	private ConcurrentHashMap<String, Keyboard> layoutStringCache;;
	private ConcurrentHashMap<URL, Keyboard> layoutURLCache;
	private JAXBContext context;

	private Unmarshaller unmarshaller;

	public KeyboardLayoutHandler() {
		this(false);
	}

	public KeyboardLayoutHandler(boolean cached) {
		try {
			context = JAXBContext.newInstance(new Class[] { Keyboard.class });
			unmarshaller = context.createUnmarshaller();

			if (cached) {
				layoutStringCache = new ConcurrentHashMap<>(8);
				layoutURLCache = new ConcurrentHashMap<>(8);
			}
		} catch (JAXBException e) {
			logger.error(e.getMessage(), e);
		}
	}

	/**
	 * Build {@link Keyboard} layout from XML {@link String}
	 *
	 * @param file
	 *            String (resources/xml/keyboardlayout.xml)
	 * @return {@link Keyboard} layout instance
	 * @throws IOException
	 *             If this String path could not be read
	 */
	public Keyboard getLayout(String file) throws IOException {
		if (layoutStringCache != null) {
			return layoutStringCache.computeIfAbsent(file, f -> {
				URL url = KeyboardLayoutHandler.class.getResource(f);
				try {
					if (url != null) {
						return getLayout(url);
					}
					return getLayout(KeyboardLayoutHandler.class.getResourceAsStream(f));
				} catch (Exception e) {
					logger.error("file: " + String.valueOf(f) + " can not be read", e);
				}
				return null;
			});
		}

		URL url = KeyboardLayoutHandler.class.getResource(file);
		if (url != null) {
			return getLayout(url);
		}

		InputStream is = KeyboardLayoutHandler.class.getResourceAsStream(file);
		if (is != null) {
			return getLayout(is);
		}
		throw new IOException("layout not found on: " + file);
	}

	/**
	 * Build {@link Keyboard} layout from XML {@link URL}
	 *
	 * @param url
	 *            (resources/xml/keyboardlayout.xml)
	 * @return {@link Keyboard} layout instance
	 * @throws IOException
	 *             If this URL could not be read
	 */
	public Keyboard getLayout(URL url) throws IOException {

		if (layoutURLCache != null) {
			return layoutURLCache.computeIfAbsent(url, u -> {
				Object obj = null;
				try {
					obj = unmarshaller.unmarshal(u);
				} catch (JAXBException e) {
					logger.error("file: " + String.valueOf(u) + " can not be read", e);
				}
				if (obj != null && obj instanceof Keyboard) {
					return (Keyboard) obj;
				}
				return null;
			});
		}

		Object obj = null;
		try {
			obj = unmarshaller.unmarshal(url);
		} catch (JAXBException e) {
			throw new IOException("file: " + url + " can not be read", e);
		}
		if (obj != null && obj instanceof Keyboard) {
			return (Keyboard) obj;
		}
		return null;
	}

	/**
	 * Build {@link Keyboard} layout from XML {@link InputStream}
	 *
	 * @param is
	 *            (resources/xml/keyboardlayout.xml)
	 * @return {@link Keyboard} layout instance
	 * @throws IOException
	 *             If this InputStream could not be read
	 */
	private Keyboard getLayout(InputStream is) throws IOException {

		Object obj = null;
		try {
			obj = unmarshaller.unmarshal(is);
		} catch (JAXBException e) {
			throw new IOException("stream can not be read", e);
		}
		if (obj != null && obj instanceof Keyboard) {
			return (Keyboard) obj;
		}
		return null;
	}
}
