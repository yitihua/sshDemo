package cn.edu.nenu.domain;

import cn.edu.nenu.config.orm.IdEntity;
import cn.edu.nenu.util.Constants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "T_ORGANIZATION")
public class Organization extends IdEntity {
    @Column(length = 128)
    private String name;
    @Column(length = 128)
    private String alias;
    @Column(length = 32)
    private String code;
    @Column(length = 128)
    private String treeCode;
    private float levelSort;
    private Constants.Status status = Constants.Status.DISABLE;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTreeCode() {
        return treeCode;
    }

    public void setTreeCode(String treeCode) {
        this.treeCode = treeCode;
    }

    public float getLevelSort() {
        return levelSort;
    }

    public void setLevelSort(float levelSort) {
        this.levelSort = levelSort;
    }

}
