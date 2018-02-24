package q1_linkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Q1 LinkedList")
class LinkedListTest {

    private LinkedList standard;
    private LinkedList empty;
    private LinkedList one;
    private LinkedList two;


    void check(String expected, LinkedList list) {
        assertEquals(expected, list.description());
    }

    @Nested
    class e01 {

        @BeforeEach
        void prepare() {
            standard = new LinkedList();
            standard.buildDemo();
        }

        @Nested
        class level1 {
            @Test
            void description() {
                check("[6, 7, 3, 8, 4]", standard);
            }

            @Test
            void size() {
                assertEquals(5, standard.size());
            }

            @Test
            void isEmpty() {
                assertEquals(false, standard.isEmpty());
            }
        }


        @Nested
        class level2 {
            @Test
            void get() {
                assertEquals(6, standard.get(0));
            }

            @Test
            void lastValue() {
                assertEquals(4, standard.lastValue());
            }

            @Test
            void indexOf() {
                assertEquals(3, standard.indexOf(8));
                assertEquals(-1, standard.indexOf(2));
            }

            @Test
            void contains() {
                assertEquals(true, standard.contains(8));
                assertEquals(false, standard.contains(2));
                assertEquals(true, standard.contains(4));
            }
        }

        @Nested
        class level3 {
            @Test
            void add() {
                standard.add(9);
                check("[6, 7, 3, 8, 4, 9]", standard);
            }

            @Test
            void push() {
                standard.push(9);
                check("[6, 7, 3, 8, 4, 9]", standard);
            }

            @Test
            void pop() {
                standard.pop();
                check("[6, 7, 3, 8]", standard);
            }

        }

        @Nested
        class level4 {

            @Test
            void remove() {
                standard.remove(5);
                check("[6, 7, 3, 8, 4]", standard);
            }

            @Test
            void insert() {
                standard.insert(3, 9);
                check("[6, 7, 3, 9, 8, 4]", standard);
            }

            @Test
            void replace() {
                standard.replace(4, 9);
                check("[6, 7, 3, 8, 9]", standard);
            }
        }

    }

    @Nested
    class e02 {
        @BeforeEach
        void prepare() {
            standard = new LinkedList();
            standard.buildDemo();

            empty = new LinkedList();
        }

        void prepareOne() {
            one = new LinkedList();
            one.push(6);
        }

        void prepareTwo() {
            two = new LinkedList();
            two.push(6);
            two.push(7);
        }

        @Nested
        class level1 {
            @Test
            void description() {
                check("[]", empty);
            }

            @Test
            void size() {
                assertEquals(0, empty.size());
            }

            @Test
            void isEmpty() {
                assertEquals(true, empty.isEmpty());
            }
        }

        @Nested
        class level2 {
            @Test
            void get() {
                assertEquals(-1, empty.get(0));
            }

            @Test
            void lastValue() {
                assertEquals(-1, empty.lastValue());
            }

            @Test
            void indexOf() {
                assertEquals(-1, empty.indexOf(6));
            }

            @Test
            void contains() {
                assertEquals(false, empty.contains(6));
            }
        }


        @Nested
        class level3 {

            @Nested
            class add {

                @Test
                void case1() {
                    prepareOne();
                    check("[6]", one);
                }

                @Test
                void case2() {
                    prepareTwo();
                    check("[6, 7]", two);
                }
            }

            @Nested
            class pop {

                @Test
                void case1() {
                    prepareOne();
                    one.pop();
                    check("[]", one);
                }

                @Test
                void case2() {
                    empty.pop();
                    check("[]", empty);
                }

                @Test
                void case3() {
                    prepareTwo();
                    two.pop();
                    two.pop();
                    check("[]", two);
                }
            }
        }

        @Nested
        class level4 {

            @Nested
            class insert {

                @Nested
                class toEmpty {

                    @Test
                    void case1() {
                        empty.insert(0, 1);
                        check("[1]", empty);
                    }

                    @Test
                    void case2() {
                        empty.insert(1, 1);
                        check("[]", empty);
                    }
                }

                @Nested
                class toOne {

                    @Test
                    void case1() {
                        prepareOne();
                        one.insert(0, 1);
                        check("[1, 6]", one);
                    }

                    @Test
                    void case2() {
                        prepareOne();
                        one.insert(1, 1);
                        check("[6, 1]", one);
                    }

                    @Test
                    void case3() {
                        prepareOne();
                        one.insert(2, 1);
                        check("[6]", one);
                    }
                }

                @Nested
                class toTwo {

                    @Test
                    void case1() {
                        prepareTwo();
                        two.insert(0, 1);
                        check("[1, 6, 7]", two);
                    }

                    @Test
                    void case2() {
                        prepareTwo();
                        two.insert(1, 1);
                        check("[6, 1, 7]", two);
                    }

                    @Test
                    void case3() {
                        prepareTwo();
                        two.insert(2, 1);
                        check("[6, 7, 1]", two);
                    }

                    @Test
                    void case4() {
                        prepareTwo();
                        two.insert(3, 1);
                        check("[6, 7]", two);
                    }
                }
            }

            @Nested
            class remove {

                @Nested
                class fromEmpty {

                    @Test
                    void case1() {
                        empty.remove(0);
                        check("[]", empty);
                    }
                }

                @Nested
                class fromOne {

                    @Test
                    void case1() {
                        prepareOne();
                        one.remove(0);
                        check("[]", one);
                    }

                    @Test
                    void case2() {
                        prepareOne();
                        one.remove(1);
                        check("[6]", one);
                    }
                }

                @Nested
                class fromTwo {

                    @Test
                    void case1() {
                        prepareTwo();
                        two.remove(0);
                        check("[7]", two);
                    }

                    @Test
                    void case2() {
                        prepareTwo();
                        two.remove(1);
                        check("[6]", two);
                    }

                    @Test
                    void case3() {
                        prepareTwo();
                        two.remove(2);
                        check("[6, 7]", two);
                    }

                }
            }
        }
    }
}










