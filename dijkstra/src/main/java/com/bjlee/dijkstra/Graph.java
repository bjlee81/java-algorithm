package com.bjlee.dijkstra;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * 경로에 대한 그래프 클래스
 */
public class Graph {
    // 중복방지를 위한 set
    private Set<Node> nodes = new HashSet<>();

    public Set<Node> getNodes() {
        return nodes;
    }

    public void setNodes(Set<Node> nodes) {
        this.nodes = nodes;
    }

    // 전체 경로에 대한 노드를 추가한다.
    public void addNode(Node nodeA) {
        nodes.add(nodeA);
    }

    // 최종 경로
    public String toPath() {
        return null;
    }

    /**
     * 시작 nodes 에 대해 그래프상의 모든 노드에 대한 최단 거리를 결정한다.
     *
     * @param startNode 시작할 노드
     * @return
     */
    public Graph searchShortenPathDistance(Node startNode) {
        System.out.println("최단 경로를 찾습니다.");
        // 최종 경로 그래프
        startNode.setDistance(0);

        // 방문 노드
        Set<Node> settledNodes = new HashSet<>();
        // 미방문 노드
        Set<Node> unsettledNodes = new HashSet<>();

        // 시작노드에 대해 미방문노드 설정
        unsettledNodes.add(startNode);

        // 방문하지 않은 노드가 없을 때까지 순환
        while (unsettledNodes.size() != 0) {
            // 최초는 방문노드 없음
            // 미방문 노드중에 제일 가까운 거리의 노드 검색
            Node curNode = getLowestDistanceNode(unsettledNodes);

            // 미방문노드에서 탐색된 노드 삭제
            unsettledNodes.remove(curNode);

            // 현재노드에서 이웃노드 탐색
            for (Map.Entry<Node, Integer> neighborPair : curNode.getNeighborNodes().entrySet()) {
                Node neighborNode = neighborPair.getKey();
                Integer edgeWeight = neighborPair.getValue();
                // 방문한 노드가 아니면 최단거리 계산
                if (!settledNodes.contains(neighborNode)) {
                    calculateMinimumDistance(neighborNode, edgeWeight, curNode);
                    unsettledNodes.add(neighborNode);
                }
            }
            // 해당노드를 방문했으면 방문노드에 추가
            settledNodes.add(curNode);
        }

        return this;
    }

    private Node getLowestDistanceNode(Set<Node> unsettledNodes) {
        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Node node : unsettledNodes) {
            int nodeDistance = node.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

    private void calculateMinimumDistance(Node evaluationNode, Integer edgeWeigh, Node sourceNode) {
        Integer sourceDistance = sourceNode.getDistance();
        if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + edgeWeigh);
            LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }
}
