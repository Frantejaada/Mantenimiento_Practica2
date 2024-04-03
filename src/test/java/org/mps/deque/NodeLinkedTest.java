package org.mps.deque;
//Hecho por Francisco Javier Tejada Martín

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NodeLinkedTest {

    @Nested
    @DisplayName("Constructor tests")
    class NodeConstructor {
        @Test
        @DisplayName("previous, next = null")
        public void Constructor_RightArguments_ReturnAllAttributes() {
            String expectedItem = "item";
            LinkedNode<String> node = new LinkedNode<String>(expectedItem, null, null);

            String resultItem = node.getItem();
            LinkedNode<String> previousResult = node.getPrevious();
            LinkedNode<String> nextResult = node.getNext();

            assertEquals(expectedItem, resultItem);
            assertNull(previousResult);
            assertNull(nextResult);
        }

        @Test
        @DisplayName("previous, next != null")
        public void Constructor_RightArgumentsWithNodes_ReturnAllAttributes() {
            String expectedItem = "item";
            LinkedNode<String> expectedPreviousNode = new LinkedNode<String>(expectedItem, null, null);
            LinkedNode<String> expectedNextNode = new LinkedNode<String>(expectedItem, null, null);
            LinkedNode<String> node = new LinkedNode<String>(expectedItem, expectedPreviousNode, expectedNextNode);

            String resultItem = node.getItem();
            LinkedNode<String> resultPreviousResult = node.getPrevious();
            LinkedNode<String> resultNextResult = node.getNext();

            assertEquals(expectedItem, resultItem);
            assertEquals(expectedPreviousNode, resultPreviousResult);
            assertEquals(expectedNextNode, resultNextResult);
        }

        @Test
        @DisplayName("item = null")
        public void Constructor_NullItem_ReturnItem() {
            LinkedNode<String> node = new LinkedNode<String>(null, null, null);

            String resultItem = node.getItem();

            assertNull(resultItem);
        }
    }

    @Nested
    @DisplayName("check IsFirstNode")
    class IsFirstNode{
        @Test
        @DisplayName("when is first node")
        public void IsFirstNode_WithoutPreviousNode_True(){
            LinkedNode<String> expectedNextNode = new LinkedNode<String>(null, null, null);
            LinkedNode<String> node = new LinkedNode<String>(null, null, expectedNextNode);

            assertTrue(node.isFirstNode());
        }

        @Test
        @DisplayName("when isn't first node")
        public void IsFirstNode_WithPreviousNode_False(){
            LinkedNode<String> expectedPreviousNode = new LinkedNode<String>(null, null, null);
            LinkedNode<String> node = new LinkedNode<String>(null, null, null);

            node.setPrevious(expectedPreviousNode);

            assertFalse(node.isFirstNode());
        }
    }

    @Nested
    @DisplayName("check isLastNode")
    class isLastNode{
        @Test
        @DisplayName("when is last node")
        public void IsLastNode_WithoutNextNode_True(){
            LinkedNode<String> node = new LinkedNode<String>(null, null, null);

            assertTrue(node.isLastNode());
        }

        @Test
        @DisplayName("when isn't first node")
        public void IsLastNode_WithNextNode_False(){
            LinkedNode<String> expectedNextNode = new LinkedNode<String>(null, null, null);
            LinkedNode<String> node = new LinkedNode<String>(null, null, null);
            node.setNext(expectedNextNode);

            assertFalse(node.isLastNode());
        }
    }

    @Nested
    @DisplayName("check isNotATerminalNode")
    class isNotATerminalNode{
        @Test
        @DisplayName("when is a terminal node with both null")
        public void IsLastNode_WithoutNextNodeandPreviousNode_False(){
            LinkedNode<String> node = new LinkedNode<String>(null, null, null);

            assertFalse(node.isNotATerminalNode());
        }

        @Test
        @DisplayName("when is a terminal node with previous null")
        public void IsLastNode_WithoutPreviousNode_False(){
            LinkedNode<String> expectedNextNode = new LinkedNode<String>(null, null, null);
            LinkedNode<String> node = new LinkedNode<String>(null, null, expectedNextNode);

            assertFalse(node.isNotATerminalNode());
        }

        @Test
        @DisplayName("when is a terminal node with next null")
        public void IsLastNode_WithoutNext_False(){
            LinkedNode<String> expectedPreviousNode = new LinkedNode<String>(null, null, null);
            LinkedNode<String> node = new LinkedNode<String>(null, expectedPreviousNode, null);

            assertFalse(node.isNotATerminalNode());
        }

        @Test
        @DisplayName("when isn't first node")
        public void IsLastNode_WithBothNodes_True(){
            LinkedNode<String> expectedNextNode = new LinkedNode<String>(null, null, null);
            LinkedNode<String> expectedPreviousNode = new LinkedNode<String>(null, null, null);
            LinkedNode<String> node = new LinkedNode<String>(null, expectedPreviousNode, expectedNextNode);

            assertTrue(node.isNotATerminalNode());
        }
    }


    @Test
    @DisplayName("check setItem")
    public void SetItem_WithSetItem_NewItem(){
        String expectedItem = "newItem";
        LinkedNode<String> node = new LinkedNode<String>(null, null, null);
        node.setItem(expectedItem);

        String resultItem = node.getItem();

        assertEquals(expectedItem, resultItem);
    }

}
