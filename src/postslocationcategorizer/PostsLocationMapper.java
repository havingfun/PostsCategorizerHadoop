/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package postslocationcategorizer;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;


public class PostsLocationMapper extends MapReduceBase implements
                Mapper<LongWritable, Text, Text, IntWritable> {
    
        private Text PostsLocationKey = new Text();
        private final static IntWritable one = new IntWritable(1);
        private int fieldnum;
        
        
        public void configure(JobConf job) {
            fieldnum = Integer.parseInt(job.get("FieldNumber"));
        }
        
        public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException
        {

                String dataRow = value.toString();
                // since these are tab seperated files lets tokenize on tab
                String valColumns[] = dataRow.split("\t");
                String location = valColumns[fieldnum-1];
                location = location.trim();
                location = location.toLowerCase();
                PostsLocationKey.set(location);
                output.collect(PostsLocationKey, one);
        }

}
