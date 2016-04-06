import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.lib.LongSumReducer;
import org.apache.hadoop.mapred.lib.TokenCountMapper;


	public class WordCount {
		public static void main(String[] args) {
		JobClient client = new JobClient();
		JobConf conf = new JobConf(WordCount.class);
		
		//Input file for Word Count Program in Hadoop File system
		FileInputFormat.addInputPath(conf, new Path("/user/biadmin/Project/Phase1/tweetdataset.json"));
		
		//Output directory for Word Count
		FileOutputFormat.setOutputPath(conf, new Path("/user/biadmin/Project/Phase1/tweetWordCountoutput"));
		conf.setOutputKeyClass(Text.class);
		conf.setOutputValueClass(LongWritable.class);
		
		//Calling the Map Reduce Program
		conf.setMapperClass(TokenCountMapper.class);
		conf.setCombinerClass(LongSumReducer.class); 
		conf.setReducerClass(LongSumReducer.class); 
		client.setConf(conf);
		try {
		JobClient.runJob(conf);
		} catch (Exception e) {
		e.printStackTrace();
		}
		}
		}

