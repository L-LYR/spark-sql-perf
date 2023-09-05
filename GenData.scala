import com.databricks.spark.sql.perf.tpcds.TPCDSTables
val rootDirPrefix = "hdfs://s44:8020/tpcds-data-"
val databaseNamePrefix = "tpcds"
// val scaleFactors = List("1", "10", "50", "100", "300", "500", "1000")
val scaleFactors = List("1000")

val format = "parquet"
val sqlContext = spark.sqlContext
for (scaleFactor <- scaleFactors) {
    val rootDir = rootDirPrefix + scaleFactor
    val databaseName = databaseNamePrefix + scaleFactor
    val tables = new TPCDSTables(sqlContext, dsdgenDir="/mnt/hadoop/tpcds-kit/tools/", scaleFactor=scaleFactor, useDoubleForDecimal=false, useStringForDate=false)
    tables.genData(location=rootDir, format=format, overwrite=true, partitionTables=true, clusterByPartitionColumns=true, filterOutNullPartitionValues=false, tableFilter="", numPartitions=100)
}
