/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package staticvsintancemethod;

/**
 *
 * @author indra
 */
public class ComparisonClass {
        public int a;
        public int b;
        public final int final_a;
        public final int final_b;
        public ComparisonClass(int a, int b){
            this.a = a;
            this.b = b;
            final_a = a;
            final_b = b;
        }
        public int instanceMethodAccessMember(){
            return a + b;
        }

        public int instanceMethodAccessFinalMember(){
            return final_a + final_b;
        }

        public int instanceMethodWithParam(int a, int b){
            return a + b;
        }

        public int instanceMethodWithFinalParam(final int a, final int b){
            return a + b;
        }
        
        public static int staticMethodCalledByClassName(int a, int b){
            return a + b;
        }    

        public static int staticMethodCalledByClassNameFinalParam(final int a, final int b){
            return a + b;
        }    
        
        public static int staticMethodCalledByInstanceName(int a, int b){
            return a + b;
        }    

        public static int staticMethodCalledByInstanceNameFinalParam(final int a, final int b){
            return a + b;
        }    
}
