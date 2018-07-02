package com.bjlee.dijkstra;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@DisplayName("경로탐색 알고리즘")
class AppTests {
    // 최단 비용을 계산할 수 있다.
    // 경유지를 기록할 수 있다.
    Graph graph;

    @BeforeEach
    void setUp() {
        graph = GraphFactory.createGraph();

        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");

        nodeA.addDestination(nodeB, 10);
        nodeA.addDestination(nodeC, 30);
        nodeA.addDestination(nodeD, 15);

        nodeB.addDestination(nodeE, 20);

        nodeC.addDestination(nodeF, 5);

        nodeD.addDestination(nodeE, 2);
        nodeD.addDestination(nodeC, 5);
        nodeD.addDestination(nodeF, 20);

        nodeE.addDestination(nodeF, 20);

        nodeF.addDestination(nodeD, 20);

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);
    }

    @AfterEach
    void tearDown() {

    }


    @Test
    void serarchPath() {
        // Given - 어떤 상황
        // When - 어떻게 동작
        Stream<Node> stream = graph.getNodes().stream();
        Node startNode = stream.filter(node -> "A".equals(node.getName())).findAny().orElse(null);
        Graph graph1 = graph.searchShortenPathDistance(startNode);

        // Then - 동작한 결과
        graph1.toPath();
        // A to F path
        startNode.getShortestPath().stream().map(Node::getName).collect(Collectors.toList()).forEach(System.out::println);
        startNode.getShortestPath().stream().forEach(System.out::println);
    }
}
