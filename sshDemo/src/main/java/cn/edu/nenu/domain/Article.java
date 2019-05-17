package cn.edu.nenu.domain;

import cn.edu.nenu.config.orm.IdEntity;
import cn.edu.nenu.util.Constants;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "T_ARTICLE")
public class Article extends IdEntity {
    @Column(length = 128)
    private String title;
    @Lob
    @Basic(fetch = FetchType.EAGER)
    private String content;
    @ManyToOne
    @JoinColumn(name = "creator_id",referencedColumnName = "id", nullable = false)
    private User creator;

    private LocalDateTime createdAt;
    private LocalDateTime lasteditAt;
    private Constants.Status status = Constants.Status.DISABLE;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }



    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getLasteditAt() {
        return lasteditAt;
    }

    public void setLasteditAt(LocalDateTime lasteditAt) {
        this.lasteditAt = lasteditAt;
    }

}
