package sanguinetti.online.model;

public class Variable {
	String tagName,
			idValue;

	/**
	 * @param tagName
	 * @param idValue
	 */
	public Variable(String tagName, String idValue) {
		this.tagName = tagName;
		this.idValue = idValue;
	}

	/**
	 *
	 */
	public Variable() {
	}

	/**
	 * @return the tagName
	 */
	public String getTagName() {
		return tagName;
	}

	/**
	 * @param tagName the tagName to set
	 */
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	/**
	 * @return the idValue
	 */
	public String getIdValue() {
		return idValue;
	}

	/**
	 * @param idValue the idValue to set
	 */
	public void setIdValue(String idValue) {
		this.idValue = idValue;
	}
	
}
