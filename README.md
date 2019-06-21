# User_access_session_analysis_platform
用户访问session行为分析平台（附带大量性能调优）
### 模块介绍
+ 对用户访问session进行分析
+ JDBC辅助类封装
+ 用户访问session聚合统计
+ 按时间比例随机抽取session
+ 获取点击、下单和支付次数排名前10的品类
+ 获取top10品类的点击次数最多的10个session
+ 性能调优
+ 数据倾斜问题解决
+ 简单客户端功能演示
### 功能方案设计实现
+ 按条件筛选session
  + 对原始的数据，进行聚合。用一些最基本的筛选条件，比如时间范围，从hive表中提取数据，然后按照session_id这个字段进行聚合，聚合后就是一个用户的某个
  session在指定时间内的访问的记录，比如搜索过的所有的字段词、点击过的所有的品类id、session对应的userid关联的用户的基础信息。聚合过后，针对session
  粒度的数据，按照使用者指定的筛选条件，进行数据的筛选。筛选出来符合条件的session
+ 聚合统计
  + 使用自定义Accumulator技术，完成分布式计算，即用一个Accumulator，来计算所有的指标，实现安全的累加操作，得到各个访问时长的session数量
+ 在符合条件的session中，按照时间比例随机抽取1000个session
  + 综合运用Spark的countBykey、groupByKey、mapToPair等算子，实现按时间比例随机均匀采样抽取的算法
+ 在符合条件的session中，获取点击、下单和支付数量排名前10的品类
  + 对每个品类的点击、下单和支付的数量都进行计算。然后使用自定义Key二次排序算法，实现所有品类，按照三个字段，点击数量、下单数量、支付数量依次进行排序
+ 对于排名前10的品类，分别获取点击次数排名前10的session
  + 使用Spark的分组取TopN算法实现，对排名前10的品类对应的数据，按照品类id进行分组，然后求出每组点击数量排名前10的session
### 调优
+ 性能调优
  + 调节并行度
  + 重构RDD架构以及RDD持久化
  + 广播大变量
  + 使用kryo序列化
  + 使用fastutil优化数据格式
  + 调节数据本地化等待时长
+ JVM调优
  + 降低cache操作的内存占比
  + 调节executor堆外内存与连接等待时长
+ Shuffle调优
  + 合并map端输出文件
  + 调节map端内存缓冲与reduce端内存占比
+ 算子调优
  + reduceByKey本地聚合
  + 使用MapPartition提升Map类操作性能
  + filter过后使用coalesce减少分区数量
  + 使用foreachPartition优化写数据库性能
  + 使用repartition解决Spark SQL低并行度的性能问题
+ 数据倾斜解决方案
  + 聚合源数据以及过滤导致倾斜的key
  + 提高shuffle操作reduce并行度
  + 使用随机key实现双重聚合
  + 将reduce join转换为map join
  + sample采样倾斜key单独进行join
  + 使用随机数以及扩容表进行join
