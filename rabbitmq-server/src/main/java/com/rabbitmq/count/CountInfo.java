package com.rabbitmq.count;

import java.util.concurrent.atomic.AtomicLong;

public class CountInfo {

    /**
     * 最后
     */
    private long lastReceive;

    private long lastSent;

    private long lastSend;

    private long maxChannelNum;

    private long curChannelNum;

    /**
     *receive message count
     */
    private AtomicLong receiveNum = new AtomicLong();

    /**
     * send message count
     */
    private AtomicLong sentNum = new AtomicLong();

    /**
     * receive and send hearbeat count
     */
    private AtomicLong heartbeatNum = new AtomicLong();

    public long getCurChannelNum() {
        return curChannelNum;
    }

    public void setCurChannelNum(long curChannelNum) {
        this.curChannelNum = curChannelNum;
        if (this.maxChannelNum < curChannelNum) {
            this.maxChannelNum = curChannelNum;
        }
    }

    public long getMaxChannelNum() {
        return maxChannelNum;
    }

    public AtomicLong getReceiveNum() {
        return receiveNum;
    }

    public AtomicLong getSentNum() {
        return sentNum;
    }

    public AtomicLong getHeartbeatNum() {
        return heartbeatNum;
    }

    public long getLastReceive() {
        return lastReceive;
    }

    public void setLastReceive(long lastReceive) {
        if (this.lastReceive < lastReceive) {
            this.lastReceive = lastReceive;
        }
    }

    public long getLastSent() {
        return lastSent;
    }

    public void setLastSent(long lastSent) {
        if (this.lastSent < lastSent) {
            this.lastSent = lastSent;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("StatisticInfo [lastReceive=").append(this.lastReceive);
        sb.append(", lastSent=").append(this.lastSent);
        sb.append(", receiveNum=").append(this.receiveNum);
        sb.append(", sentNum=").append(this.sentNum);
        sb.append(", heartbeatNum=").append(this.heartbeatNum);
        sb.append(", maxChannelNum=").append(this.maxChannelNum);
        sb.append(", curChannelNum=").append(this.curChannelNum);
        sb.append("]");
        return sb.toString();
    }

}
