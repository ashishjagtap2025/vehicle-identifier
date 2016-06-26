/**
 * 
 */
package com.workscape.model;

/**
 * @author Ashish
 */
public class Wheel implements Comparable<Wheel> {
	private String position = "";
	private String material = "";

	/**
	 * 
	 */
	public Wheel() {}
	
	public Wheel(String position, String material) {
		super();
		this.position = position;
		this.material = material;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((material == null) ? 0 : material.hashCode());
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Wheel other = (Wheel) obj;
		if (material == null) {
			if (other.material != null)
				return false;
		} else if (!material.equals(other.material))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Wheel [position=" + position + ", material=" + material + "]";
	}

	public int compareTo(Wheel o) {
		return position.compareTo(o.getPosition());
	}
}//End of Wheel Class.