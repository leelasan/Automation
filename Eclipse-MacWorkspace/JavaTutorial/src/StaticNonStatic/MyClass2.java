package StaticNonStatic;

//- this code explain static method - non static Variables and what is the diff 


public class MyClass2 {

           // you can declare static variable here : 
           // or you can write  int callCount = 0; 
           // make the same thing 
           //static int callCount = 0; = int callCount = 0;
           static int callCount = 0;    

           public void method() {
               /********************************************************************* 
               Can i declare a static variable inside static member function in Java?
               - no you can't 
               static int callCount = 0;  // error                                                   
               ***********************************************************************/
           /* static variable */
           callCount++;
           System.out.println("Calls in method (1) : " + callCount);
           }

           public void method2() {
           int callCount2 = 0 ; 
           /* non static variable */   
           callCount2++;
           System.out.println("Calls in method (2) : " + callCount2);
           }


       public static void main(String[] args) {
        MyClass2 m = new MyClass2();
        /* method (1) calls */
        m.method(); 
        m.method();
        m.method();
        /* method (2) calls */
        m.method2();
        m.method2();
        m.method2();
       }

   }
   // output 

   // Calls in method (1) : 1
   // Calls in method (1) : 2
   // Calls in method (1) : 3
   // Calls in method (2) : 1
   // Calls in method (2) : 1
   // Calls in method (2) : 1 