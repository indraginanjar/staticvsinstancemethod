/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package staticvsintancemethod;

import java.util.Arrays;

/**
 *
 * @author indra
 */
public class Statistic {

        public String name;
        public long[] array;
        public long max;
        public double mean;
        public double median;
        public long min;
        public double stdev;
        public long sum;
        
    static void calculate(Statistic s) {
        Arrays.sort(s.array);
        s.min = s.array[0];
        s.max = s.array[s.array.length - 1];
        if (s.array.length % 2 == 0) {
            s.median = (double) s.array[s.array.length / 2] + (double) s.array[s.array.length / 2 - 1] / 2d;
        } else {
            s.median = s.array[s.array.length / 2 + 1];
        }
        s.sum = 0;
        for (long i : s.array) {
            s.sum += i;
        }
        s.mean = s.sum / s.array.length;
        long sigma = 0;
        for (long i : s.array) {
            sigma += Math.abs(i - s.mean);
        }
        s.stdev = sigma / s.array.length;
    }

    static String asString(Statistic s) {
        StringBuilder b = new StringBuilder("\n");
        b.append(s.name)
                .append(" :\nMin = ")
                .append(s.min)
                .append("Max = " )
                .append(s.max)
                .append("Median = ")
                .append(s.median)
                .append("Sum = ")
                .append(s.sum)
                .append("Mean = ")
                .append(s.mean)
                .append("Stdev = ")
                .append(s.stdev);
        return b.toString();
    }

    static void sortByMean(Statistic[] stats) {
        for (int i = 0; i < stats.length; ++i) {
            for (int j = 0; j < stats.length - 1; ++j) {
                if (stats[j].mean > stats[j + 1].mean) {
                    swap(stats, j, j + 1);
                }
            }
        }
    }
    
    static void swap(Statistic[] stats, int a, int b) {
        Statistic t = stats[a];
        stats[a] = stats[b];
        stats[b] = t;
    }
    
    static void sortByMeanAndStdev(Statistic[] stats) {
        for (int i = 0; i < stats.length; ++i) {
            for (int j = 0; j < stats.length - 1; ++j) {
                if (stats[j].mean - stats[j].stdev > stats[j + 1].mean - stats[j + 1].stdev) {
                    swap(stats, j, j + 1);
                }
            }
        }
    }    
}
