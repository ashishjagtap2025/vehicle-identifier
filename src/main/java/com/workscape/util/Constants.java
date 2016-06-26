/**
 * 
 */
package com.workscape.util;

import com.workscape.model.Wheel;

/**
 * @author Ashish
 */
public final class Constants {
	private Constants() {}
	public static final String HUMAN_POWERTRAIN = "human";
	public static final String INT_COM_POWERTRAIN = "internalcombustion";
	public static final String BERNOULLI_POWERTRAIN = "bernoulli";
	
	public static final String VEHICLE = "vehicle";
	public static final String FRAME = "frame";
	public static final String MATERIAL = "material";
	public static final String WHEEL = "wheel";
	
	public static final String PLASTIC_MATERIAL = "plastic";
	public static final String METAL_MATERIAL = "metal";
	
	public static final String FRONT = "front";
	public static final String REAR = "rear";
	public static final String RIGHT_FRONT = "right front";
	public static final String LEFT_FRONT = "left front";
	public static final String RIGHT_REAR = "right rear";
	public static final String LEFT_REAR = "left rear";
	
	public static final Wheel FRONT_PLASTIC_WHEEL = new Wheel(FRONT, PLASTIC_MATERIAL);
	public static final Wheel REAR_LEFT_PLASTIC_WHEEL = new Wheel(LEFT_REAR, PLASTIC_MATERIAL);
	public static final Wheel REAR_RIGHT_PLASTIC_WHEEL = new Wheel(RIGHT_REAR, PLASTIC_MATERIAL);
	
	public static final Wheel FRONT_METAL_WHEEL = new Wheel(FRONT, METAL_MATERIAL);
	public static final Wheel REAR_METAL_WHEEL = new Wheel(REAR, METAL_MATERIAL);
	
	public static final Wheel FRONT_RIGHT_WHEEL = new Wheel(RIGHT_FRONT, "");
	public static final Wheel FRONT_LEFT_WHEEL = new Wheel(LEFT_FRONT, "");
	public static final Wheel REAR_RIGHT_WHEEL = new Wheel(RIGHT_REAR, "");
	public static final Wheel REAR_LEFT_WHEEL = new Wheel(LEFT_REAR, "");
	
	public static final Wheel[] BIG_WHEELS = { FRONT_PLASTIC_WHEEL, REAR_LEFT_PLASTIC_WHEEL, REAR_RIGHT_PLASTIC_WHEEL };
	public static final Wheel[] TWO_WHEELS = { FRONT_METAL_WHEEL, REAR_METAL_WHEEL };
	public static final Wheel[] CAR_WHEELS = { FRONT_RIGHT_WHEEL, FRONT_LEFT_WHEEL, REAR_RIGHT_WHEEL, REAR_LEFT_WHEEL };
	
	/*public static final ArrayList<Wheel> BIG_WHEELS_LIST = new ArrayList<Wheel>(Arrays.asList(BIG_WHEELS));
	public static final ArrayList<Wheel> BICYCLE_WHEELS_LIST = new ArrayList<Wheel>(Arrays.asList(BICYCLE_WHEELS));
	public static final ArrayList<Wheel> MOTORCYCLE_WHEELS_LIST = new ArrayList<Wheel>(Arrays.asList(MOTORCYCLE_WHEELS));
	public static final ArrayList<Wheel> CAR_WHEELS_LIST = new ArrayList<Wheel>(Arrays.asList(CAR_WHEELS));*/
}
