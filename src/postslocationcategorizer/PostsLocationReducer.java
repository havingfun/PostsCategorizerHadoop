/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package postslocationcategorizer;

/**
 *
 * @author rajesh
 */

import com.kenai.jaffl.mapper.FunctionMapper.Context;
import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class PostsLocationReducer extends MapReduceBase implements
                Reducer<Text, IntWritable, Text, IntWritable> {

    @Override
    public void reduce(Text key, Iterator<IntWritable> values, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
         int sum = 0;
         while(values.hasNext())
         {
             sum+=Integer.parseInt(values.next().toString());
         }
            output.collect(key, new IntWritable(sum));
    }


}
