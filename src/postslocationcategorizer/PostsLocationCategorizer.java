/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package postslocationcategorizer;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;

public class PostsLocationCategorizer {

        /**
         * @param args
         */
        public static void main(String[] args) throws Exception {
                JobConf conf = new JobConf(PostsLocationCategorizer.class);
                conf.setJobName("geolocationgroup");

                conf.setOutputKeyClass(Text.class);
                conf.setOutputValueClass(IntWritable.class);

                conf.setMapperClass(PostsLocationMapper.class);
                // conf.setCombinerClass(AnagramReducer.class);
                conf.setReducerClass(PostsLocationReducer.class);
                
                conf.set("FieldNumber", args[2]);

                conf.setInputFormat(TextInputFormat.class);
                conf.setOutputFormat(TextOutputFormat.class);

                FileInputFormat.setInputPaths(conf, new Path(args[0]));
                FileOutputFormat.setOutputPath(conf, new Path(args[1]));

                JobClient.runJob(conf);

        }

}