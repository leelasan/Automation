package StaticNonStatic;

//- First we must know that the difference between static and non static methods 
//  differ from static and non static variables : 

//- this code explain static method - non static method and what is the difference

  public class MyClass {
      static {
          System.out.println("this is static routine ... ");

      }
        public static void foo(){
          System.out.println("this is static method ");
      }

      public void blabla(){

       System.out.println("this is non static method ");
      }

      public static void main(String[] args) {

         /* ***************************************************************************  
          * 1- in static method you can implement the method inside its class like :  *       
          * you don't have to make an object of this class to implement this method   *      
          * MyClass.foo();          // this is correct                                *     
          * MyClass.blabla();       // this is not correct because any non static     *
          * method you must make an object from the class to access it like this :    *            
          * MyClass m = new MyClass();                                                *     
          * m.blabla();                                                               *    
          * ***************************************************************************/

          // access static method without make an object 
          MyClass.foo();

          MyClass m = new MyClass();
          // access non static method via make object 
          m.blabla();
          /* 
            access static method make a warning but the code run ok 
             because you don't have to make an object from MyClass 
             you can easily call it MyClass.foo(); 
          */
          m.foo();
      }    
  }
  /* output of the code */
  /*
  this is static routine ... 
  this is static method 
  this is non static method 
  this is static method
  */