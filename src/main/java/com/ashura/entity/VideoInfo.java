package com.ashura.entity;

public class VideoInfo {
    private Integer id;

    private String avid;

    private String videoname;

    private String classify;

    private String upuser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAvid() {
        return avid;
    }

    public void setAvid(String avid) {
        this.avid = avid == null ? null : avid.trim();
    }

    public String getVideoname() {
        return videoname;
    }

    public void setVideoname(String videoname) {
        this.videoname = videoname == null ? null : videoname.trim();
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify == null ? null : classify.trim();
    }

    public String getUpuser() {
        return upuser;
    }

    public void setUpuser(String upuser) {
        this.upuser = upuser == null ? null : upuser.trim();
    }
}