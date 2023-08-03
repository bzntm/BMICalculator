package id.ac.upnvj.bmicalculator;

public class CalculateBMI {
    public static final CalculateBMI instance = new CalculateBMI();

    public static final String BMI_CATEGORY_UNDERWEIGHT = "Stunted/Underweight, seek professional help";
    public static final String BMI_CATEGORY_HEALTHY = "You're healthy";
    public static final String BMI_CATEGORY_OVERWEIGHT = "Overweight, please diet sooner";
    public static final String BMI_CATEGORY_OBESE = "Obese, seek professional help";

    public static CalculateBMI getInstance() {
        return instance;
    }

    public double CountBMI(double HeightCM, double MassKG) {
        return (MassKG / ((HeightCM/100) * (HeightCM/100)));
    }

    public String classifyBMI(double bmi) {
        if (bmi < 18.5) {
            return BMI_CATEGORY_UNDERWEIGHT;
        } else if (bmi >= 18.5 && bmi < 25) {
            return BMI_CATEGORY_HEALTHY;
        } else if (bmi >= 25 && bmi < 30) {
            return BMI_CATEGORY_OVERWEIGHT;
        } else {
            return BMI_CATEGORY_OBESE;
        }
    }
}