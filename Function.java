import java.lang.UnsupportedOperationException;

/**
 * @author Rakith (Jay) Jayewardene
 * Establishes an abstract class named Function
 */
public abstract class Function {
  
  /** 
   * Creates an abstract method named value that takes a double as input
   * @param inputValue
   */
  public abstract double value(double inputValue);
  
  /**
   * Creates an abstract method named value that takes no input
   */
  public abstract double value() throws UnsupportedOperationException;
  
  /**
   * Creates an abstract method named derivative that takes no input
   * @return type Function 
   */
  public abstract Function derivative();
  
  /** 
   * Creates an abstract method named equals that takes an Object named function as input
   * @return type boolean
   */
  public abstract boolean equals(Object function);
  
}