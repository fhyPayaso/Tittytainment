package com.fhypayaso.tittytainment.pojo.entity;

import java.io.Serializable;
import java.util.Date;

public class Movie implements Serializable {
    private Integer id;

    private String movieName;

    private String movieAlias;

    private String coverUrl;

    private Double doubanScore;

    private Integer movieMins;

    private String languages;

    private String regions;

    private Date releaseTime;

    private Date createdTime;

    private Date updatedTime;

    private String storyline;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName == null ? null : movieName.trim();
    }

    public String getMovieAlias() {
        return movieAlias;
    }

    public void setMovieAlias(String movieAlias) {
        this.movieAlias = movieAlias == null ? null : movieAlias.trim();
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl == null ? null : coverUrl.trim();
    }

    public Double getDoubanScore() {
        return doubanScore;
    }

    public void setDoubanScore(Double doubanScore) {
        this.doubanScore = doubanScore;
    }

    public Integer getMovieMins() {
        return movieMins;
    }

    public void setMovieMins(Integer movieMins) {
        this.movieMins = movieMins;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages == null ? null : languages.trim();
    }

    public String getRegions() {
        return regions;
    }

    public void setRegions(String regions) {
        this.regions = regions == null ? null : regions.trim();
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getStoryline() {
        return storyline;
    }

    public void setStoryline(String storyline) {
        this.storyline = storyline == null ? null : storyline.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", movieName=").append(movieName);
        sb.append(", movieAlias=").append(movieAlias);
        sb.append(", coverUrl=").append(coverUrl);
        sb.append(", doubanScore=").append(doubanScore);
        sb.append(", movieMins=").append(movieMins);
        sb.append(", languages=").append(languages);
        sb.append(", regions=").append(regions);
        sb.append(", releaseTime=").append(releaseTime);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", updatedTime=").append(updatedTime);
        sb.append(", storyline=").append(storyline);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}