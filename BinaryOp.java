/**
 * @author Rakith (Jay) Jayewardene
 * Creates a class for BinaryOp that extends Function
 */
public class BinaryOp extends Function {
  
  /* Stores leftOperand */
  private Function leftOperand;   
  
  /* Stores rightOperand */
  private Function rightOperand;  
  
  /* Stores the operator */
  private Op operator;                      
  
  /* Creates an enum for Op */
  enum Op {
    PLUS("+"), SUB("-"), MULT("*"), DIV("/");
    
    private String name;  //Stores the name of the Op
    
    /* Initializes the name for Op */
    private Op(String name) {
      this.name = name;
    }
    
    /** Method that gets the name of the Op
      * @return the Op name
      */
    private String getName() {
      return name;
    }
  }
  
  /* A constructor for BinaryOp that takes leftOperand, operator, and rightOperand as input
   * @param leftOperand, operator, and rightOperand
   */
  public BinaryOp(Function leftOperand, Function rightOperand, Op operator) {
    this.leftOperand = leftOperand;
    this.rightOperand = rightOperand;
    this.operator = operator;
  }
  
  /**
   * A method that takes no input and gets the operator
   * @return the operator
   */
  public Op getOperator() {
    return operator; 
  }
  
  /**
   * A method that takes no input and gets the left operand
   * @return the left operand
   */
  public Function getLeftOperand() {
    return leftOperand;
  }
  
  /**
   * A method that takes no input and gets the right operand
   * @return the right operand
   */
  public Function getRightOperand() {
    return rightOperand;
  }
  
  /* Takes a double as input input and returns the value of type Binary Op */
  @Override
  public double value(double inputValue) {
    if(operator == BinaryOp.Op.PLUS) {
      return leftOperand.value() + rightOperand.value();
    }
    if(operator == BinaryOp.Op.SUB) {
      return leftOperand.value() - rightOperand.value();
    }
    if(operator == BinaryOp.Op.MULT) {
      return leftOperand.value() * rightOperand.value();
    }
    if(operator == BinaryOp.Op.DIV) {
      return leftOperand.value() / rightOperand.value();
    }
    else { 
      return 0; 
    }
  }
  
  /* Takes no input and throws an unsupported operation exception */
  @Override
  public double value() throws UnsupportedOperationException{
    throw new UnsupportedOperationException();
  }
  
  /**
   * A method that takes no input and takes the derivative of the BinaryOp
   * @return the derivative of the BinaryOp in type Function 
   */
  @Override
  public Function derivative() {
 
    switch(getOperator()) {
      case PLUS:
        return new BinaryOp( getLeftOperand().derivative(), getRightOperand().derivative(), BinaryOp.Op.PLUS);
      case SUB:
        return new BinaryOp( getLeftOperand().derivative(), getRightOperand().derivative(), BinaryOp.Op.SUB);
      case MULT: 
        return new BinaryOp(new BinaryOp(getLeftOperand(), getRightOperand().derivative(), BinaryOp.Op.MULT), new BinaryOp(getLeftOperand().derivative(), getRightOperand(), BinaryOp.Op.MULT), BinaryOp.Op.PLUS);
      default:  //used for division
        return new BinaryOp(new BinaryOp(new BinaryOp(getLeftOperand().derivative(), getRightOperand(), BinaryOp.Op.MULT), new BinaryOp(getLeftOperand(), getRightOperand().derivative(), BinaryOp.Op.MULT), BinaryOp.Op.SUB), new BinaryOp(getRightOperand(), getRightOperand(), BinaryOp.Op.MULT), BinaryOp.Op.DIV);    
    }
  }
    /* Converts the input to a String */
    @Override
    public String toString() {
      return getLeftOperand() + " " + getOperator() + " " + getRightOperand();
    }
    
    /**
     * A method that takes no input and converts the BinaryOp to a String
     * @return the String representation of the BinaryOp
     */
    @Override
    public boolean equals(Object function) {
      if(function instanceof BinaryOp) {
        if((leftOperand.equals(((BinaryOp)(function)).getLeftOperand())) && rightOperand.equals(((BinaryOp)(function)).getRightOperand()) && operator.equals(((BinaryOp)(function)).getOperator()))
          return true; 
      }
      return false;
  }
}  