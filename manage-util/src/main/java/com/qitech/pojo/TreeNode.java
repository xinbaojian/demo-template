package com.qitech.pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author xin.bj
 * @program security_m
 * @description layui树结构构建辅助类
 * @create 2018-12-01 16:18
 **/
public class TreeNode implements Comparable<TreeNode> {

    private String id;

    private String pid;

    private String name;

    private String group;

    private String icon;

    /**
     * 排序
     */
    private Integer sort;

    private List<TreeNode> children = new ArrayList<>();

    private Boolean spread = Boolean.TRUE;

    private Boolean isEquipment = Boolean.FALSE;

    private String coordx;

    private String coordy;

    public TreeNode() {
    }

    public TreeNode(String id, String pid, String name, String group) {
        this.id = id;
        this.pid = pid;
        this.name = name;
        this.group = group;
    }

    public TreeNode(String group) {
        this.group = group;
    }

    public String getGroup() {
        return group;
    }

    public TreeNode setGroup(String group) {
        this.group = group;
        return this;
    }

    public String getName() {
        return name;
    }

    public TreeNode setName(String name) {
        this.name = name;
        return this;
    }

    public String getId() {
        return id;
    }

    public TreeNode setId(String id) {
        this.id = id;
        return this;
    }

    public String getPid() {
        return pid;
    }

    public TreeNode setPid(String pid) {
        this.pid = pid;
        return this;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public TreeNode setChildren(List<TreeNode> children) {
        this.children = children;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TreeNode treeNode = (TreeNode) o;
        return id.equals(treeNode.id) &&
                pid.equals(treeNode.pid) &&
                name.equals(treeNode.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pid, name);
    }

    public Integer getSort() {
        if (sort == null) {
            sort = 0;
        }
        return sort;
    }

    public TreeNode setSort(Integer sort) {
        this.sort = sort;
        return this;
    }

    public String getIcon() {
        return icon;
    }

    public TreeNode setIcon(String icon) {
        this.icon = icon;
        return this;
    }

    @Override
    public int compareTo(TreeNode o) {
        return getSort().compareTo(o.getSort());
    }

    public Boolean getSpread() {
        return spread;
    }

    public TreeNode setSpread(Boolean spread) {
        this.spread = spread;
        return this;
    }

    public Boolean getEquipment() {
        return isEquipment;
    }

    public TreeNode setEquipment(Boolean equipment) {
        this.isEquipment = equipment;
        return this;
    }

    public String getCoordx() {
        return coordx;
    }

    public TreeNode setCoordx(String coordx) {
        this.coordx = coordx;
        return this;
    }

    public String getCoordy() {
        return coordy;
    }

    public TreeNode setCoordy(String coordy) {
        this.coordy = coordy;
        return this;
    }
}
