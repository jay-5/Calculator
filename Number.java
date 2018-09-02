/**
 * @author Rakith (Jay) Jayewardene
 * Creates a class named Number that extends Function
 */
public class Number extends Function{
  
  /* Stores the inputValue */
  private double inputValue;  
  
  /**
   * A constructor that initializes an input double named inputValue
   * @param inputValue
   */
  public Number(double inputValue) {
    this.inputValue = inputValue;
  }
  /** 
   * A method that takes a double named inputValue as input and returns the value
   * @return the inputValue as a double */
  @Override
  public double value(double inputValue) {
    return this.inputValue;
  }
  
  /** 
   * A method that takes no input and returns the value
   * @return the inputValue as a double */
  @Override
  public double value() {
    return this.inputValue; 
  }
  
  /**
   * A method that takes no input and takes the derivative of the number
   * @return the derivative of the number in type Function 
   */
  @Override
  public Function derivative() {
    return new Number(0);
  }
  
  /**
   * A method that takes no input and converts the number to a String
   * @return the String representation of the number
   */
  @Override
  public String toString() {
    return "" +this.inputValue;
  }
  
  /* A method that takes an input Object called function and compares it to a different number
   * @return true if the object is equal to the number and returns false if it does not
   */
  @Override
  public boolean equals(Object function) {
    if(function instanceof Number) {
      if (this.inputValue == ((Number)(function)).value()) {
        return true; 
      }
    }
    return false;
  }
  
}

