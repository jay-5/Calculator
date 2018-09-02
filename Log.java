/**
 * @author Rakith (Jay) Jayewardene
 * Creates a class called Log which extends Function 
 */
public class Log extends Function {
  
  /* Stores the operand */
  private Function operand; 
  
  /* Stores the input value */
  private double inputValue;  
  
  /**
   * A constructor that takes operand as input
   * @param operand 
   */
  public Log(Function operand) {
    this.operand = operand;
  }
  
  /**
   * A method that gets the operand
   * @return operand 
   */
  public Function getOperand() {
    return operand;
  }
  
  /**
   * A method that sets the operand
   * @param operand 
   */
  public void setOperand(Function operand) {
    this.operand = operand;
  }
  
  /** 
   * A method that takes no input and produces the log of the inputValue
   * @return the log value of the input as a double
   */
  @Override
  public double value(double inputValue) {
    return Math.log(getOperand().value(this.inputValue));
  }
  
  /** 
   * A method that takes no input and produces the log of the value
   * @return the log value of the input as a double
   */
  @Override
  public double value() {
    return Math.log(getOperand().value(inputValue)); 
  }
  
  /**
   * A method that takes no input and takes the derivative of the log function
   * @return the derivative of the log function in type Function 
   */
  @Override
  public Function derivative() {
    return new BinaryOp(new Number(1), getOperand(), BinaryOp.Op.DIV);
  }
  
  /**
   * A method that takes no input and converts the log function to a String
   * @return the String representation of the log function 
   */
  @Override
  public String toString() {
    return "Log[" + getOperand().toString() + "]";
  }
  
  /**
   * A method that compares an Object function to the log function
   * @return true if the Object and log function are equal or false if they are not
   */
  @Override
  public boolean equals(Object function) {
    if(function instanceof Log) {
      return true; 
    }
    return false;
  }
  
}

