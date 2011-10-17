/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package staticvsintancemethod;



/**
 *
 * @author indra
 */
public class StaticVSIntanceMethod {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int param1 = 1;
        int param2 = 2;
        ComparisonClass c = new ComparisonClass(param1, param2);
        //final int maxint = Integer.MAX_VALUE;
        final int maxint = 500000;
        long start;
        long end;
        
        final int maxloop = 10;
        
        long[] imamLength = new long[maxloop];
        long[] imafmLength = new long[maxloop];
        long[] imwpLength = new long[maxloop];
        long[] imwfpLength = new long[maxloop];
        long[] smLength = new long[maxloop];
        long[] smfpLength = new long[maxloop];
        long[] smcnLength = new long[maxloop];
        long[] smcnfpLength = new long[maxloop];
        
        for (int l = 0; l < maxloop; ++l) {
            start = System.nanoTime();
            for (int i = 0; i < maxint; ++i) {
                c.instanceMethodAccessMember();
            }
            end = System.nanoTime();
            imamLength[l] = end - start;

            start = System.nanoTime();
            for (int i = 0; i < maxint; ++i) {
                c.instanceMethodAccessFinalMember();
            }
            end = System.nanoTime();
            imafmLength[l] = end - start;
            

            start = System.nanoTime();
            for (int i = 0; i < maxint; ++i) {
                c.instanceMethodWithParam(param1, param2);
            }
            end = System.nanoTime();
            imwpLength[l] = end - start;

            start = System.nanoTime();
            for (int i = 0; i < maxint; ++i) {
                c.instanceMethodWithFinalParam(param1, param2);
            }
            end = System.nanoTime();
            imwfpLength[l] = end - start;

            
            start = System.nanoTime();
            for (int i = 0; i < maxint; ++i) {
                c.staticMethodCalledByInstanceName(param1, param2);
            }
            end = System.nanoTime();
            smLength[l] = end - start;

            start = System.nanoTime();
            for (int i = 0; i < maxint; ++i) {
                c.staticMethodCalledByInstanceNameFinalParam(param1, param2);
            }
            end = System.nanoTime();
            smfpLength[l] = end - start;
            
            start = System.nanoTime();
            for (int i = 0; i < maxint; ++i) {
                ComparisonClass.staticMethodCalledByClassName(param1, param2);
            }
            end = System.nanoTime();
            smcnLength[l] = end - start;

            start = System.nanoTime();
            for (int i = 0; i < maxint; ++i) {
                ComparisonClass.staticMethodCalledByClassNameFinalParam(param1, param2);
            }
            end = System.nanoTime();
            smcnfpLength[l] = end - start;
        }
        Statistic imamStat = new Statistic();
        imamStat.name = "Instance Method Accessing Member";
        imamStat.array = imamLength;
        Statistic.calculate(imamStat);

        Statistic imafmStat = new Statistic();
        imafmStat.name = "Instance Method Accessing Final Member";
        imafmStat.array = imafmLength;
        Statistic.calculate(imafmStat);
        
        Statistic imwpStat = new Statistic();
        imwpStat.name = "Instance Method With Parameter";
        imwpStat.array = imwpLength;
        Statistic.calculate(imwpStat);

        Statistic imwfpStat = new Statistic();
        imwfpStat.name = "Instance Method With Final Parameter";
        imwfpStat.array = imwfpLength;
        Statistic.calculate(imwfpStat);
        
        Statistic smStat = new Statistic();
        smStat.name = "Static Method Called Using Instance Name";
        smStat.array = smLength;
        Statistic.calculate(smStat);

        Statistic smfpStat = new Statistic();
        smfpStat.name = "Static Method Called Using Instance Name Final Param";
        smfpStat.array = smfpLength;
        Statistic.calculate(smfpStat);
        
        Statistic smcnStat = new Statistic();
        smcnStat.name = "Static Method Called Using Class Name";
        smcnStat.array = smcnLength;
        Statistic.calculate(smcnStat);

        Statistic smcnfpStat = new Statistic();
        smcnfpStat.name = "Static Method Called Using Class Name FinalParam";
        smcnfpStat.array = smcnfpLength;
        Statistic.calculate(smcnfpStat);
        
        Statistic[] statArray = new Statistic[]{
            imamStat, imafmStat, imwpStat, imwfpStat, smStat, smfpStat, 
            smcnStat, smcnfpStat};
        
        Statistic.sortByMean(statArray);
        
        System.out.println("Iteratian each method = " + maxint);
        System.out.println("loop iteration = " + maxloop);

        System.out.println(Statistic.asString(imamStat));
        System.out.println(Statistic.asString(imafmStat));
        System.out.println(Statistic.asString(imwpStat));
        System.out.println(Statistic.asString(smStat));
        System.out.println(Statistic.asString(smfpStat));
        System.out.println(Statistic.asString(smcnStat));
        System.out.println(Statistic.asString(smcnfpStat));

        System.out.println("\nRank by mean:");
        System.out.println("No| Mean | Name\t\t\t\t | Mean - stdev | Name");
        for (int i = 0; i < statArray.length; ++i) {
            System.out.println((i + 1) + ". " + 
                    statArray[i].mean + " : " 
                    + statArray[i].name + " | " +
                    (statArray[i].mean - statArray[i].stdev) + " : " 
                    + statArray[i].name
                    );
        }

    }

}
