
package io.github.anvil008.keyboard.xml.layout;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "row"
})
@XmlRootElement(name = "Keyboard")
public class Keyboard {

    @XmlElement(name = "Row", required = true)
    protected List<Row> row;
    @XmlAttribute(name = "keyWidth")
    protected Integer keyWidth;
    @XmlAttribute(name = "keyHeight")
    protected Integer keyHeight;
    @XmlAttribute(name = "horizontalGap")
    protected Integer horizontalGap;
    @XmlAttribute(name = "verticalGap")
    protected Integer verticalGap;


    public List<Row> getRow() {
        if (row == null) {
            row = new ArrayList<Row>();
        }
        return this.row;
    }

    public Integer getKeyWidth() {
        return keyWidth;
    }


    public void setKeyWidth(Integer value) {
        this.keyWidth = value;
    }


    public Integer getKeyHeight() {
        return keyHeight;
    }


    public void setKeyHeight(Integer value) {
        this.keyHeight = value;
    }


    public Integer getHorizontalGap() {
        return horizontalGap;
    }


    public void setHorizontalGap(Integer value) {
        this.horizontalGap = value;
    }

    public Integer getVerticalGap() {
        return verticalGap;
    }


    public void setVerticalGap(Integer value) {
        this.verticalGap = value;
    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "key"
    })
    public static class Row {

        @XmlElement(name = "Key", required = true)
        protected List<Key> key;
        @XmlAttribute(name = "rowEdgeFlags")
        protected String rowEdgeFlags;

        /**
         * Gets the value of the key property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the key property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getKey().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Keyboard.Row.Key }
         *
         *
         */
        public List<Key> getKey() {
            if (key == null) {
                key = new ArrayList<Key>();
            }
            return this.key;
        }

        /**
         * Ruft den Wert der rowEdgeFlags-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRowEdgeFlags() {
            return rowEdgeFlags;
        }

        /**
         * Legt den Wert der rowEdgeFlags-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRowEdgeFlags(String value) {
            this.rowEdgeFlags = value;
        }


        /**
         * <p>Java-Klasse für anonymous complex type.
         * 
         * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;attribute name="codes" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="popupCharacters" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="popupKeyboard" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="keyLabel" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="keyOutputText" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="movable" type="{http://www.w3.org/2001/XMLSchema}boolean" />
         *       &lt;attribute name="sticky" type="{http://www.w3.org/2001/XMLSchema}boolean" />
         *       &lt;attribute name="modifier" type="{http://www.w3.org/2001/XMLSchema}boolean" />
         *       &lt;attribute name="repeatable" type="{http://www.w3.org/2001/XMLSchema}boolean" />
         *       &lt;attribute name="keyIconStyle" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="keyLabelStyle" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="keyWidth" type="{http://www.w3.org/2001/XMLSchema}int" />
         *       &lt;attribute name="keyEdgeFlags">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *             &lt;enumeration value="left"/>
         *             &lt;enumeration value="right"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *       &lt;attribute name="horizontalGap" type="{http://www.w3.org/2001/XMLSchema}int" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class Key {

            @XmlAttribute(name = "codes", required = true)
            protected String codes;
            @XmlAttribute(name = "popupCharacters")
            protected String popupCharacters;
            @XmlAttribute(name = "popupKeyboard")
            protected String popupKeyboard;
            @XmlAttribute(name = "keyLabel")
            protected String keyLabel;
            @XmlAttribute(name = "keyOutputText")
            protected String keyOutputText;
            @XmlAttribute(name = "movable")
            protected Boolean movable;
            @XmlAttribute(name = "sticky")
            protected Boolean sticky;
            @XmlAttribute(name = "modifier")
            protected Boolean modifier;
            @XmlAttribute(name = "repeatable")
            protected Boolean repeatable;
            @XmlAttribute(name = "keyIconStyle")
            protected String keyIconStyle;
            @XmlAttribute(name = "keyLabelStyle")
            protected String keyLabelStyle;
            @XmlAttribute(name = "keyWidth")
            protected Integer keyWidth;
            @XmlAttribute(name = "keyEdgeFlags")
            protected String keyEdgeFlags;
            @XmlAttribute(name = "horizontalGap")
            protected Integer horizontalGap;

            public String getCodes() {
                return codes;
            }

            public void setCodes(String value) {
                this.codes = value;
            }

            public String getPopupCharacters() {
                return popupCharacters;
            }

            public void setPopupCharacters(String value) {
                this.popupCharacters = value;
            }

            public String getPopupKeyboard() {
                return popupKeyboard;
            }

            public void setPopupKeyboard(String value) {
                this.popupKeyboard = value;
            }

            public String getKeyLabel() {
                return keyLabel;
            }

            public void setKeyLabel(String value) {
                this.keyLabel = value;
            }

            public String getKeyOutputText() {
                return keyOutputText;
            }

            public void setKeyOutputText(String value) {
                this.keyOutputText = value;
            }

            public Boolean isMovable() {
                return movable;
            }

            public void setMovable(Boolean value) {
                this.movable = value;
            }

            public Boolean isSticky() {
                return sticky;
            }

            public void setSticky(Boolean value) {
                this.sticky = value;
            }

            public Boolean isModifier() {
                return modifier;
            }

            public void setModifier(Boolean value) {
                this.modifier = value;
            }

            public Boolean isRepeatable() {
                return repeatable;
            }

            public void setRepeatable(Boolean value) {
                this.repeatable = value;
            }

            public String getKeyIconStyle() {
                return keyIconStyle;
            }

            public void setKeyIconStyle(String value) {
                this.keyIconStyle = value;
            }

            public String getKeyLabelStyle() {
                return keyLabelStyle;
            }

            public void setKeyLabelStyle(String value) {
                this.keyLabelStyle = value;
            }

            public Integer getKeyWidth() {
                return keyWidth;
            }

            public void setKeyWidth(Integer value) {
                this.keyWidth = value;
            }

            public String getKeyEdgeFlags() {
                return keyEdgeFlags;
            }

            public void setKeyEdgeFlags(String value) {
                this.keyEdgeFlags = value;
            }

            public Integer getHorizontalGap() {
                return horizontalGap;
            }

            public void setHorizontalGap(Integer value) {
                this.horizontalGap = value;
            }

        }

    }

}
