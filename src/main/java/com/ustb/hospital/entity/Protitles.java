package com.ustb.hospital.entity;

public class Protitles {
    private int protitleId;
    private String protitleName;
    private String protitleDescription;

    public int getProtitleId() {
        return protitleId;
    }

    public void setProtitleId(int protitleId) {
        this.protitleId = protitleId;
    }

    public String getProtitleName() {
        return protitleName;
    }

    public void setProtitleName(String protitleName) {
        this.protitleName = protitleName;
    }

    public String getProtitleDescription() {
        return protitleDescription;
    }

    public void setProtitleDescription(String protitleDescription) {
        this.protitleDescription = protitleDescription;
    }

    @Override
    public String toString() {
        return "Protitles{" +
                "protitleId=" + protitleId +
                ", protitleName='" + protitleName + '\'' +
                ", protitleDescription='" + protitleDescription + '\'' +
                '}';
    }
}
