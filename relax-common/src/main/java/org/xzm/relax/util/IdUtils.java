package org.xzm.relax.util;

/**
 * id生成器 snowflake算法
 */
public class IdUtils {

    private long workerId;
    private long datacenterId;
    private long sequence;

    private long workerIdBits = 4L;
    private long datacenterIdBits = 4L;
    private long maxWorkerId = -1L ^ (-1L << workerIdBits);
    private long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);
    private long sequenceBits = 12L;

    private long workerIdShift = sequenceBits;
    private long datacenterIdShift = sequenceBits + workerIdBits;
    private long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;
    private long sequenceMask = -1L ^ (-1L << sequenceBits);

    private long lastTimestamp = -1L;

    private static IdUtils instance = new IdUtils(0,0);

    private IdUtils(long workerId, long datacenterId){
        // sanity check for workerId
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0",maxWorkerId));
        }
        if (datacenterId > maxDatacenterId || datacenterId < 0) {
            throw new IllegalArgumentException(String.format("datacenter Id can't be greater than %d or less than 0",maxDatacenterId));
        }
        System.out.printf("worker starting. timestamp left shift %d, datacenter id bits %d, worker id bits %d, sequence bits %d, workerid %d",
                timestampLeftShift, datacenterIdBits, workerIdBits, sequenceBits, workerId);

        this.workerId = workerId;
        this.datacenterId = datacenterId;
    }

    public static long id(){
        return instance.nextId();
    }

    private synchronized long nextId() {
        //获取当前时间戳
        long timestamp = timeGen();

        //当前时间小于最后上次获取时间，需要先同步时钟
        if (timestamp < lastTimestamp) {
            System.err.printf("clock is moving backwards.  Rejecting requests until %d.", lastTimestamp);
            throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds",
                    lastTimestamp - timestamp));
        }

        //时间相等，处于同一毫秒内
        if (lastTimestamp == timestamp) {
            //序列号+1
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                //序列号超过12bit，等待下一毫秒
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            //时间不同，序列从0开始
            sequence = 0;
        }

        //设置最后的使用的时间戳
        lastTimestamp = timestamp;

        //生成id，1bit符号位+41bit时间戳+5bit数据中心id+5bit工作机器id+12bit序列号
        return (timestamp << timestampLeftShift) |
                (datacenterId << datacenterIdShift) |
                (workerId << workerIdShift) |
                sequence;
    }

    /**
     * 获取下一个毫秒的时间戳
     * @param lastTimestamp 时间
     * @return 时间戳
     */
    private long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    private long timeGen(){
        return System.currentTimeMillis();
    }

    public long getWorkerId(){
        return workerId;
    }

    public long getDatacenterId(){
        return datacenterId;
    }

    public long getTimestamp(){
        return System.currentTimeMillis();
    }
}
