# Java0期模块总结



## 1.JVM

该模块总结学习内容如下：

1. 首先学习掌握了Jvm的基础知识
2. 学习了 Java 字节码技术
3. 理解了Java 内存模型
4. 学习了 GC 日志解读与分析
5. 学习使用了内存分析及相关工具
6. JVM 问题分析调优经验
7. 理解各种GC算法等内容

## 2.NIO

该模块总结学习内容如下：

1. 深入理解了java基于socket编程的原理，服务器通信的过程等。
2. 5中 IO 模型与相关概念，阻塞、非阻塞，同步、异步等的理解。
3. NIO 模型与相关概念，Netty 是一个异步的，基于事件驱动的，基于NIO的网络应用开发框架。
4. 学习了Netty的简介，以及基于netty如何实现NIO
   1. 学习netty的 Channel ，ChannelFuture  ，Event & Handler，  ChannelPipeline 等基本概念
   2. 使用netty进行基本的使用。
5. 理解高并发原理，以及Netty如何实现高并发等，理解Netty的实现原理等。
6. Netty的拆包与粘包等网络优化d

## 3.并发编程

该模块总结学习内容如下：

1. 多线程基础
   1. 创建线程的N种方式
   2. Thread的状态流转
   3. 中断与异常处理
2. 线程安全问题，以及java并发模块如何解决线程安全问题
   1. synchronized 关键字
   2. happens-before 原则
   3. volatile
   4. final 等关键字的理解

3. 线程池原理与应用
   1. 线程池的创建
   2. 线程池的参数理解
   3. 拒绝策略等
4. java并发包的理解
5. 并发编程中锁的理解
   1. 理解synchronized 设计
   2. 理解JUC中Lock 接口相关设计
   3. 读写锁的设计
   4. 锁的最佳实践等
6. JUC中并发工具类的相关理解
   1. Atomic 工具类
   2. CAS原理
   3. 理解Lock/Condition
   4. 理解AQS
   5. 常用工具类 Semaphore  CountdownLatch  CyclicBarrier
   6. 学习Future/FutureTask/CompletableFuture等

## 4.Spring 和 ORM 等框架

## 5.MySQL 数据库和 SQL

## 6.分库分表

## 7.RPC 和微服务

## 8.分布式缓存

## 9.分布式消息队列