PostsCategorizerHadoop
======================

Posts Categorizer (Demography) using Hadoop

Usage at Single Node -

It is a basic example of Hadoop in Netbeans.
Put all the jar files from Hadoop_lib to the Project libraries.
Use a TSV file that contains Posts alongwith Location. You can have multiple columns, you just need to know the field number of location.
You will need to pass three arguements 
arg0 - input TSV file
arg1 - path for the output
arg3 - field number of the location field

Run the program.
You will get a result in the output path. The result file will contain the count of posts by location.

Usage at Cluster -

Create JAR file of the project using ANT or directly through Netbeans.
Insert the input TSV file in the HDFS system.
Then run the file as 
./hadoop jar JAR_PATH arg0 arg1 arg2
