/**
 * @author Rakith (Jay) Jayewardene
 * Creates a class named Sin that extends Function
 */
public class Sin extends Function {
  
  /* Stores the operand */
  private Function operand; 
  
  /* Stores the inputValue */
  private double inputValue; 
  
  /**
   * Constructor that initializes Function named operand
   * @param operand
   */
  public Sin(Function operand) {
    this.operand = operand;
  }
  
  /**
   * Method that gets the operand
   * @return operand in type Function
   */
  public Function getOperand() {
    return operand;
  }
  
  /**
   * Method that provides the sine value of the double named inputValue
   * @return sin value in type double
   */
  @Override
  public double value(double inputValue) {
    return Math.sin(getOperand().value(inputValue));
  }
  
  /** 
   * Method that does not take input and throws an UnsupportedOperationException
   */
  @Override
  public double value() {
    throw new UnsupportedOperationException(); 
  }
  
  /**
   * Method that takes no input and takes the derivative of the sine function
   * @return type function 
   */
  @Override
  public Function derivative() {
    return new BinaryOp(getOperand().derivative(), new Cos(getOperand()),BinaryOp.Op.MULT);
  }
  
  /** 
   * Method that converts the function to a string
   * @return the String of the sine function
   */
  @Override
  public String toString() {
    return "Sin[" + getOperand().toString() + "]";
  }
  
  /**
   * Method that compares an Object function to the sine function
   * @return true if the Object and sine function are equal or false if they are not
   */
  @Override
  public boolean equals(Object function) {
    if(function instanceof Log) {
      return true; 
    }
    return false;
  }
}

