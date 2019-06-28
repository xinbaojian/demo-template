package com.qitech.utils;

import com.qitech.pojo.TreeNode;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * layui树形菜单数据生成辅助类
 *
 * @author xinbj
 * @date 2019-02-18
 */
public class TreeNodeUtils {

    /**
     * List 列表数据转换为树形菜单数据
     *
     * @param list
     * @return
     */
    public static List<TreeNode> toTree(List<TreeNode> list) {
        List<TreeNode> treeNodeList = new ArrayList<>();
        list.forEach(t -> {
            if (treeNodeList.contains(t)) {
                treeNodeList.forEach(u -> {
                    if (u.getGroup().equals(t.getGroup())) {
                        u.getChildren().add(t);
                    }
                });
            } else {
                TreeNode node = new TreeNode(t.getGroup());
                node.getChildren().add(t);
                treeNodeList.add(node);
            }
        });
        return treeNodeList.stream().filter(t -> !CollectionUtils.isEmpty(t.getChildren())).collect(Collectors.toList());
    }

    public static List<TreeNode> toTreeList(List<TreeNode> list) {
        if (CollectionUtils.isEmpty(list)) {
            return list;
        }
        Iterator<TreeNode> it = list.iterator();
        TreeNode node;
        TreeNode parent;
        while (it.hasNext()) {
            node = it.next();
            parent = findParent(list, node);
            if (parent != null) {
                parent.getChildren().add(node);
                it.remove();
            }
        }
        return sorted(filterNoChildren(list));
    }

    /**
     * 判断某一节点的父节点是否存在树形结构的List中
     *
     * @param list 树形结构的list
     * @param node 查找的节点
     * @return
     */
    private static TreeNode findParent(List<TreeNode> list, TreeNode node) {
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        TreeNode parent = null;
        for (TreeNode treeNode : list) {
            if (treeNode.getId().equals(node.getPid())) {
                parent = treeNode;
            } else if (!CollectionUtils.isEmpty(treeNode.getChildren())) {
                parent = findParent(treeNode.getChildren(), node);
            }
            if (parent != null) {
                return parent;
            }
        }
        return null;
    }

    /**
     * 排序，sort 值越大越靠前
     *
     * @param list
     * @return
     */
    public static List<TreeNode> sorted(List<TreeNode> list) {
        list = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        for (TreeNode node : list) {
            if (!CollectionUtils.isEmpty(node.getChildren())) {
                node.setChildren(sorted(node.getChildren()));
            }
        }
        return list;
    }

    /**
     * 过滤没有设备的机构节点
     *
     * @param list
     * @return
     */
    private static List<TreeNode> filterNoChildren(List<TreeNode> list) {
        Iterator<TreeNode> iterator = list.iterator();
        TreeNode node;
        while (iterator.hasNext()) {
            node = iterator.next();
            if (!node.getEquipment()) {
                if (CollectionUtils.isEmpty(node.getChildren())) {
                    iterator.remove();
                } else if (!hasEquNode(node.getChildren())) {
                    iterator.remove();
                } else {
                    filterNoChildren(node.getChildren());
                }
            }
        }
        return list;
    }

    /**
     * 判断该树列表中是否有设备
     *
     * @param list
     * @return 有设备 true 否则 false
     */
    private static Boolean hasEquNode(List<TreeNode> list) {
        Boolean result = Boolean.FALSE;
        for (TreeNode treeNode : list) {
            if (treeNode.getEquipment()) {
                result = Boolean.TRUE;
                break;
            } else {
                if (!CollectionUtils.isEmpty(treeNode.getChildren())) {
                    result = hasEquNode(treeNode.getChildren());
                    if (result) {
                        break;
                    }
                }
            }
        }
        return result;
    }

}
