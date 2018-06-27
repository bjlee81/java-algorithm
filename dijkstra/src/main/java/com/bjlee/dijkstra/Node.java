package com.bjlee.dijkstra;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Node {
    // 노드명
    private String name;
    // 가장 짧은 경로의 linkedlist
    private List<Node> shortestPath = new LinkedList<>();
    // 거리는 설정하지 않으면 최대값으로
    private Integer distance = Integer.MAX_VALUE;

    // 인접노드
    Map<Node, Integer> neighborNodes = new HashMap<>();

    /**
     * 해당 노드에서 이동 가능한 노드를 추가
     *
     * @param nodeB 이웃 노드 객체
     * @param distance 해당 노드까지의 거리
     */
    public void addDestination(Node nodeB, int distance) {
        neighborNodes.put(nodeB, distance);
    }

    public Node(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Node> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(List<Node> shortestPath) {
        this.shortestPath = shortestPath;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Map<Node, Integer> getNeighborNodes() {
        return neighborNodes;
    }

    public void setNeighborNodes(Map<Node, Integer> neighborNodes) {
        this.neighborNodes = neighborNodes;
    }
}
