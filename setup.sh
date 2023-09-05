#!/bin/bash

SPARK_MASTER_IP=s44 HADOOP_CONF_DIR=/mnt/hadoop/hadoop-2.7.7/etc/hadoop $HOME/spark-2.4.0-bin-hadoop2.7/bin/spark-shell \
    --master yarn \
    --name GenData \
    --deploy-mode client \
    --driver-memory 16G \
    --num-executors 10 \
    --executor-cores 1 \
    --executor-memory 3G \
    --conf spark.yarn.jars=hdfs://s44:8020/spark-2.4.0/jars/*.jar \
    --jars ./target/scala-2.11/spark-sql-perf_2.11-0.5.0-SNAPSHOT.jar,scala-logging-api_2.11-2.1.2.jar,scala-logging-slf4j_2.11-2.1.2.jar

