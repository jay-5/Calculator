/**
 * @author Rakith (Jay) Jayewardene
 * Creates a class named Variable that extends Function
 */
public class Variable extends Function{
  
  /* Stores the inputValue */
  private double inputValue;  
  
  /** 
   * A method that takes a double named inputValue as input and returns the value
   * @return the inputValue as a double */
  @Override
  public double value(double inputValue) {
    return inputValue;
  }
  
  /**
   * A method that takes no input and throws an Unsupported Operation Exception 
   */
  @Override
  public double value() {
    throw new UnsupportedOperationException();
  }
  
  /**
   * A method that takes no input and takes the derivative of the variable
   * @return the derivative of the variable in type Function 
   */
  @Override
  public Function derivative() {
    return new Number(1);
  }
  
  /**
   * A method that takes no input and converts the variable to a String
   * @return the String representation of the variable 
   */
  @Override
  public String toString() {
    return "x";
  }
  
  /* A method that takes an input Object called function and compares it to a different variable
   * @return true if the object is equal to the variable and returns false if it does not
   */
  @Override
  public boolean equals(Object function) {
    if(function instanceof Variable) {
      return true;
    }
    return false;
  }
}


