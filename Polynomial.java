/**
 * @author Rakith (Jay) Jayewardene
 * Creates a class named Polynomial that extends Function
 */
public class Polynomial extends Function {
  
  /* Stores the operand */
  private Function operand;  
  
  /* Stores the power */
  private double power;        
  
  /**
   * A constructor that initializes an input Function named operand and double named power
   * @param operand and power
   */
  public Polynomial(Function operand,double power) {
    this.operand = operand;
    this.power = power;
  }
  
  /**
   * Method that gets the power
   * @return power in type double
   */
  public double getPower() {
    return power;
  }
  
  /**
   * Method that takes a double named power as input and sets the power
   */
  public void setPower(double power) {
    this.power = power;
  }
  
  /**
   * A method that takes no input and gets the operand
   * @return the operand
   */
  public Function getOperand() {
    return operand;
  }
  
  /**
   * A method that takes a Function named operand and sets the operand
   */
  public void setOperand(Function operand) {
    this.operand = operand;
  }
  
  /** 
   * A method that takes a double named inputValue as input and returns the value
   * @return the inputValue as a double 
   */
  @Override
  public double value(double inputValue) {
    return Math.pow(this.getOperand().value(inputValue), this.getPower());
  }
  
  @Override
  public double value() {
    return Math.pow(this.getOperand().value(), this.getPower());
  }
  
  /**
   * A method that takes no input and takes the derivative of the polynomial function
   * @return the derivative of the polynomial function in type Function 
   */
  @Override
  public Function derivative() {
    return new BinaryOp(new Number(power), new BinaryOp(new Polynomial(getOperand(), 1.0), getOperand().derivative(),BinaryOp.Op.MULT),BinaryOp.Op.MULT);
  }
  
  /**
   * Method that converts the polynomial function to a String
   * @return String representation of the polynomial function
   */
  @Override
  public String toString() {
    return getOperand() + "^" + power;
  }
  
  /* A method that takes an input Object called function and compares it to the polynomial function
   * @return true if the object is equal to the polynomial function and returns false if it does not
   */
  @Override
  public boolean equals(Object function) {
    if(function instanceof Polynomial) {
      if(this.operand.equals(((Polynomial)(function)).getOperand()) && this.power == ((Polynomial)(function)).getPower())  {
        return true; 
      }
    }
    return false;
  }
}