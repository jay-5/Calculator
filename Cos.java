/**
 * @author Rakith (Jay) Jayewardene
 * Creates a class named Cos that extends Function
 */
public class Cos extends Function {
  
  /* Stores the operand */
  private Function operand;    
  
  /* Stores the input value */
  private double inputValue;   
  
  /**
   * A constructor that takes an input of operand
   * @param operand
   */
  public Cos(Function operand) {
    this.operand = operand;
  }
  
  /**
   * A method that takes no input and gets the operand
   * @return the operand
   */
  public Function getOperand() {
    return operand;
  }
  
  /** 
   * Method that takes a double named inputValue and returns the cosine value of it
   * @return the cosine value of the input as a double
   */
  @Override
  public double value(double inputValue) {
    return Math.cos(getOperand().value(inputValue));
  }
  
  /** 
   * Method that does not take input and throws an UnsupportedOperationException
   */
  @Override
  public double value() {
    throw new UnsupportedOperationException();
  }
  
  /**
   * Method that takes no input and takes the derivative of the cosine function
   * @return type function 
   */
  @Override
  public Function derivative() {
    return new BinaryOp(new BinaryOp(new Number(-1), getOperand().derivative(),BinaryOp.Op.MULT), new Sin(getOperand()), BinaryOp.Op.MULT);
  }
  
  /** 
   * Method that converts the function to a string
   * @return the String of the cosine function
   */
  @Override
  public String toString() {
    return "Cos[" + getOperand().toString() + "]";
  }
  
  /**
   * Method that compares an Object function to the cosine function
   * @return true if the Object and cosine function are equal or false if they are not
   */
  @Override
  public boolean equals(Object function) {
    if(function instanceof Log) {
      return true; 
    }
    return false;
  }
  
}

