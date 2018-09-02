/**
 * @author Rakith (Jay) Jayewardene
 * Creates a class named Exponent that extends Function
 */
public class Exponent extends Function{
  
  /* Stores the input value */
  private double inputValue;   
  
  /* Stores the operand */
  private Function operand;   
  
  /**
   * A constuctor for exponent that takes a function that is the operand of an exponential function 
   * @param operand
   */
  public Exponent(Function operand) {
    this.operand = operand;
  }
  
  /**
   * Method that gets the operand 
   * @return operand
   */
  public Function getOperand() {
    return operand;
  }
  
  /**
   * Method that takes a double as input and returns its exponential value
   * @return the exponential value of the inputValue as a double
   */
  @Override
  public double value(double inputValue) {
    return Math.exp(getOperand().value(inputValue));
  }
  
  /**
   * Method that takes no input and returns the exponential value of the operand
   * @return exponential value of Function
   */
  @Override
  public double value() {
    return Math.exp(getOperand().value());
  }
  
  /** 
   * Method that takes the derivative of the exponential function
   * @return the derivative of the exponential function
   */
  @Override
  public Function derivative() {
    return new BinaryOp(getOperand().derivative(), new Exponent(getOperand()),BinaryOp.Op.MULT);
  }
  
  /**
   * Method that converts the exponential function to a String
   * @return String representation of the exponential function
   */
  @Override
  public String toString() {
    return "Exp" + "[" + getOperand().toString() + "]";
  }
  
  /** 
   * Method that compares an Object named function to the exponential function
   * @return true if the Object is equal to the exponential function or false if it is not equal
   */
  @Override
  public boolean equals(Object function) {
    if(function instanceof Exponent) {
      if (this.inputValue == ((Exponent)(function)).value()) {
        return true; 
      }
    }
    return false;
  }
  
}