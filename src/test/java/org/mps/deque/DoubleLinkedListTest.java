package org.mps.deque;
//Hecho por Francisco Javier Tejada Martín

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

public class DoubleLinkedListTest {

    @Nested
    @DisplayName("check prepend")
    class checkPrepend{
        @Test
        @DisplayName("when structure doesn't have nodes")
        void Prepend_WithoutNodes_FirstTAndLastT(){
            String expectedItem = "item";
            int expectedSize = 1;
            DoubleLinkedList<String> list = new DoubleLinkedList<>();

            list.prepend(expectedItem);

            assertEquals(expectedItem, list.first());
            assertEquals(expectedSize, list.size());
            assertEquals(expectedItem, list.last());
        }

        @Test
        @DisplayName("when structure have first node")
        void Prepend_WithFirstNode_FirstTAndLastT(){
            String firstItem = "item";
            String lastItem = "lastItem";
            int expectedSize = 2;
            DoubleLinkedList<String> list = new DoubleLinkedList<>();

            list.prepend(lastItem);
            list.prepend(firstItem);

            assertEquals(firstItem, list.first());
            assertEquals(expectedSize, list.size());
            assertEquals(lastItem,list.last());
        }

        @Test
        @DisplayName("when structure have last node")
        void Prepend_WithLastNode_FirstTAndLastT(){
            String firstItem = "item";
            String lastItem = "lastItem";
            int expectedSize = 2;
            DoubleLinkedList<String> list = new DoubleLinkedList<>();
            list.append(lastItem);

            list.prepend(firstItem);

            assertEquals(firstItem, list.first());
            assertEquals(expectedSize, list.size());
            assertEquals(lastItem,list.last());
        }

        @Test
        @DisplayName("when structure with nodes")
        void Prepend_WithNodes_FirstTAndLastT(){
            String firstItem = "item";
            String secondItem = "secondItem";
            String thirdItem = "thirdItem";
            int expectedSize = 3;
            DoubleLinkedList<String> list = new DoubleLinkedList<>();

            list.prepend(thirdItem);
            list.prepend(secondItem);
            list.prepend(firstItem);

            assertEquals(firstItem, list.first());
            assertEquals(expectedSize, list.size());
            assertEquals(thirdItem,list.last());
        }
    }

    @Nested
    @DisplayName("check append")
    class checkAppend{
        @Test
        @DisplayName("when structure doesn't have nodes")
        void Append_WithoutNodes_FirstTAndLastT(){
            String expectedItem = "item";
            int expectedSize = 1;
            DoubleLinkedList<String> list = new DoubleLinkedList<>();

            list.append(expectedItem);

            assertEquals(expectedItem, list.last());
            assertEquals(expectedSize, list.size());
            assertEquals(expectedItem ,list.first());
        }

        @Test
        @DisplayName("when structure have first node")
        void Append_WithFirstNode_FirstTAndLastT(){
            String lastItem = "lastItem";
            String firstItem = "item";
            int expectedSize = 2;
            DoubleLinkedList<String> list = new DoubleLinkedList<>();

            list.prepend(firstItem);
            list.append(lastItem);

            assertEquals(firstItem, list.first());
            assertEquals(expectedSize, list.size());
            assertEquals(lastItem,list.last());
        }

        @Test
        @DisplayName("when structure have last node")
        void Append_WithLastNode_FirstTAndLastT(){
            String firstItem = "item";
            String lastItem = "lastItem";
            int expectedSize = 2;
            DoubleLinkedList<String> list = new DoubleLinkedList<>();

            list.append(lastItem);
            list.prepend(firstItem);

            assertEquals(firstItem, list.first());
            assertEquals(expectedSize, list.size());
            assertEquals(lastItem,list.last());
        }

        @Test
        @DisplayName("when structure with nodes")
        void Append_WithNodes_FirstTAndLastT(){
            String firstItem = "item";
            String secondItem = "secondItem";
            String thirdItem = "thirdItem";
            int expectedSize = 3;
            DoubleLinkedList<String> list = new DoubleLinkedList<>();

            list.append(firstItem);
            list.append(secondItem);
            list.append(thirdItem);

            assertEquals(firstItem, list.first());
            assertEquals(expectedSize, list.size());
            assertEquals(thirdItem,list.last());
        }
    }

    @Nested
    @DisplayName("check deleteFirst")
    class checkDeleteFirst{
        @Test
        @DisplayName("check with first")
        void DeleteFirst_WithFirst_First(){
            String item = "first";
            int expectedSize = 0;
            DoubleLinkedList<String> list = new DoubleLinkedList<>();
            list.prepend(item);

            list.deleteFirst();

            assertEquals(expectedSize, list.size());
            assertThrows(DoubleLinkedQueueException.class, list::first);
        }

        @Test
        @DisplayName("check with more nodes")
        void DeleteFirst_WithMoreNodes_First(){
            String item = "first";
            int expectedSize = 1;
            DoubleLinkedList<String> list = new DoubleLinkedList<>();
            list.prepend(item);
            list.prepend(item);

            list.deleteFirst();

            assertEquals(expectedSize, list.size());
            assertEquals(item,list.first());
        }

        @Test
        @DisplayName("check without first")
        void DeleteFirst_WithFirst_ThrowException(){
            DoubleLinkedList<String> list = new DoubleLinkedList<>();

            assertThrows(DoubleLinkedQueueException.class, list::deleteFirst);
        }
    }

    @Nested
    @DisplayName("check deleteLast")
    class checkDeleteLast{
        @Test
        @DisplayName("check with last")
        void DeleteLast_WithLast_Last(){
            String item = "last";
            int expectedSize = 0;
            DoubleLinkedList<String> list = new DoubleLinkedList<>();
            list.append(item);

            list.deleteLast();

            assertEquals(expectedSize, list.size());
            assertThrows(DoubleLinkedQueueException.class, list::last);
        }

        @Test
        @DisplayName("check with more of 1 nodes")
        void DeleteLast_WithMoreNodes_Last(){
            String item = "last";
            int expectedSize = 1;
            DoubleLinkedList<String> list = new DoubleLinkedList<>();
            list.append(item);
            list.append(item);

            list.deleteLast();

            assertEquals(expectedSize, list.size());
            assertEquals(item ,list.last());
        }

        @Test
        @DisplayName("check without last")
        void DeleteLast_WithoutLast_ThrowException(){
            DoubleLinkedList<String> list = new DoubleLinkedList<>();

            assertThrows(DoubleLinkedQueueException.class, list::deleteLast);
        }
    }

    @Nested
    @DisplayName("check get")
    class checkGet{

        @Test
        @DisplayName("whith index >= size")
        void Get_IndexGreaterThanSize_ThrowExecption(){
            int index = 0;
            DoubleLinkedList<String> list = new DoubleLinkedList<>();

            assertThrows(IndexOutOfBoundsException.class, () -> list.get(index));
        }

        @Test
        @DisplayName("with index is the first")
        void Get_IndexIsTheFirst_First(){
            int index = 0;
            String expectedItem = "1";
            DoubleLinkedList<String> list = new DoubleLinkedList<>();

            list.prepend(expectedItem);

            assertEquals(expectedItem, list.get(index));
        }

        @Test
        @DisplayName("with index in the middle")
        void Get_IndexInTheMiddle_MiddleElement(){
            int index = 2;
            String expectedItem = "3";
            DoubleLinkedList<String> list = new DoubleLinkedList<>();
            list.prepend("4");
            list.prepend(expectedItem);
            list.prepend("2");
            list.prepend("1");

            assertEquals(expectedItem, list.get(index));
        }

        @Test
        @DisplayName("with index is the last")
        void Get_IndexIsTheLast_LastElement(){
            int index = 3;
            String expectedItem = "4";
            DoubleLinkedList<String> list = new DoubleLinkedList<>();
            list.prepend("4");
            list.prepend(expectedItem);
            list.prepend("2");
            list.prepend("1");

            assertEquals(expectedItem, list.get(index));
        }
    }

    @Nested
    @DisplayName("check contains")
    class checkContains{

        @Test
        @DisplayName("check with all elements")
        void Contains_AllElements_AllTrue(){
            DoubleLinkedList<String> list = new DoubleLinkedList<>();
            list.prepend("4");
            list.prepend("3");
            list.prepend("2");
            list.prepend("1");

            assertTrue(list.contains("1"));
            assertTrue(list.contains("2"));
            assertTrue(list.contains("3"));
            assertTrue(list.contains("4"));
        }

        @Test
        @DisplayName("no exist the element")
        void Contains_NoExistTheElement_False(){
            DoubleLinkedList<String> list = new DoubleLinkedList<>();
            list.prepend("4");
            list.prepend("3");
            list.prepend("2");
            list.prepend("1");

            assertFalse(list.contains("5"));
        }

    }

    @Nested
    @DisplayName("check remove")
    class checkRemove {
        @Test
        @DisplayName("first is removed")
        void Remove_TheFirstElement_NewFirstElement(){
            DoubleLinkedList<String> list = new DoubleLinkedList<>();
            list.append("1"); // 1
            list.prepend("2"); // 2 1
            list.append("3");// 2 1 3
            list.prepend("4"); // 4 2 1 3

            list.remove("4"); // 2 1 3

            assertEquals("2", list.first());
            assertEquals("1", list.get(1));
        }

        @Test
        @DisplayName("last is removed")
        void Remove_TheLastElement_NewLastElement(){
            DoubleLinkedList<String> list = new DoubleLinkedList<>();
            list.append("1"); // 1
            list.prepend("2"); // 2 1
            list.append("3");// 2 1 3
            list.prepend("4"); // 4 2 1 3

            list.remove("3"); // 4 2 1

            assertEquals("1", list.last());
            assertEquals("2", list.get(1));
        }

        @Test
        @DisplayName("element is in the middle")
        void Remove_AMiddleElement_RightDistribution(){
            DoubleLinkedList<String> list = new DoubleLinkedList<>();
            list.append("1"); // 1
            list.prepend("2"); // 2 1
            list.append("3");// 2 1 3
            list.prepend("4"); // 4 2 1 3

            list.remove("2"); // 4 1 3

            assertEquals("4", list.first());
            assertEquals("1", list.get(1));
            assertEquals("3", list.get(2));
            assertEquals("4", list.get(0));
        }

        @Test
        @DisplayName("don`t remove")
        void Remove_Nothing_EqualDistribution(){
            DoubleLinkedList<String> list = new DoubleLinkedList<>();
            list.append("1"); // 1
            list.prepend("2"); // 2 1
            list.append("3");// 2 1 3
            list.prepend("4"); // 4 2 1 3

            assertEquals("4", list.first());
            assertEquals("2", list.get(1));
            assertEquals("1", list.get(2));
            assertEquals("3", list.get(3));
        }
    }

    @Nested
    @DisplayName("check sort")
    class checkSort{

        @Test
        @DisplayName("sort with 4 elements")
        void Sort_DisorderElements_OrderElements(){
            Comparator<? super String> comparator = Comparator.naturalOrder();
            DoubleLinkedList<String> list = new DoubleLinkedList<>();
            list.append("1"); // 1
            list.prepend("2"); // 2 1
            list.append("3");// 2 1 3
            list.prepend("4"); // 4 2 1 3

            list.sort(comparator);

            assertEquals("1", list.first());
            assertEquals("2", list.get(1));
            assertEquals("3", list.get(2));
            assertEquals("4", list.get(3));
            assertEquals("4", list.last());
        }

        @Test
        @DisplayName("sort with 1 elements")
        void Sort_DisorderElement_RightOperation(){
            Comparator<? super String> comparator = Comparator.naturalOrder();
            DoubleLinkedList<String> list = new DoubleLinkedList<>();
            list.append("1"); // 1

            list.sort(comparator);

            assertEquals("1", list.first());
            assertEquals("1", list.get(0));
        }

        @Test
        @DisplayName("sort with 0 elements")
        void Sort_WithoutElement_RightOperation(){
            Comparator<? super String> comparator = Comparator.naturalOrder();
            DoubleLinkedList<String> list = new DoubleLinkedList<>();

            list.sort(comparator);

            assertThrows(DoubleLinkedQueueException.class, list::first);
            assertThrows(DoubleLinkedQueueException.class, list::last);
        }
    }


    @Test
    @DisplayName("a lot of operations 1")
    void JointOperations1(){
        DoubleLinkedList<String> list = new DoubleLinkedList<>();
        list.append("1"); // 1
        list.prepend("2"); // 2 1
        list.append("3");// 2 1 3
        list.prepend("4"); // 4 2 1 3

        assertEquals("1", list.get(2));
        assertEquals("4", list.first());
        assertEquals("3",list.last());
    }

    @Test
    @DisplayName("a lot of operations 2")
    void JointOperations2(){
        DoubleLinkedList<String> list = new DoubleLinkedList<>();
        list.append("1"); // 1
        list.prepend("2"); // 2 1
        list.append("3");// 2 1 3
        list.prepend("4"); // 4 2 1 3
        list.deleteLast(); //4 2 1
        list.deleteFirst();// 2 1

        assertEquals("2", list.first());
        assertEquals("1",list.last());
    }
}
