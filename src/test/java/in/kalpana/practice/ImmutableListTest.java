package in.kalpana.practice;

import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Random;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ImmutableListTest {

    @Test
    public void shouldCreateAnEmptyImmutableList() {
        ImmutableList<Integer> Nil = ImmutableList.EmptyList();
        assertThat(Nil.size(), is(0));
        Random random = new Random();
        assertThat(Nil.exists(random.nextInt()), is(false));
    }

    @Test
    public void shouldAddAnElementToImmutableList() {
        ImmutableList<Integer> Nil = ImmutableList.EmptyList();
        ImmutableList<Integer> list = Nil.add(1);
        assertThat(list.exists(1), is(true));
    }

    @Test
    public void shouldAddMultipleElementsToImmutableList() {
        ImmutableList<Integer> list = ImmutableList.<Integer>EmptyList()
                .add(1)
                .add(2)
                .add(3);

        assertThat(list.exists(1), is(true));
        assertThat(list.exists(2), is(true));
        assertThat(list.exists(3), is(true));
        assertThat(list.exists(4), is(false));
    }

    @Test
    public void shouldCheckForAnElementInTheList() {
        ImmutableList<Integer> list = ImmutableList
                .<Integer>EmptyList()
                .add(1);

        assertThat(list.exists(1), is(true));
        assertThat(list.exists(2), is(false));
    }

    @Test
    public void shouldReturnSizeOfTheList() {
        ImmutableList<Integer> list = ImmutableList.<Integer>EmptyList()
                .add(1)
                .add(2)
                .add(3);

        assertThat(list.size(), is(3));
    }

    @Test
    public void shouldDeleteAnElementFromExistingList() {
        ImmutableList<Integer> list = ImmutableList.<Integer>EmptyList()
                .add(1)
                .add(2)
                .add(3);
        ImmutableList<Integer> deletedList = list.delete(3);
        assertThat(deletedList.exists(3), is(false));

        ImmutableList<Integer> deletedList2 = list.delete(4);

        for (int element = 1; element <= 3; element++) {
            assertThat(deletedList2.exists(element), is(true));
        }
    }

    @Test
    public void shouldDeleteNonHeadElementFromList() {
        ImmutableList<Integer> list = ImmutableList.<Integer>EmptyList()
                .add(1)
                .add(2)
                .add(3);

        ImmutableList<Integer> deletedList = list.delete(2);
        assertThat(deletedList.size(), is(2));
        assertThat(deletedList.exists(2), is(false));
        assertThat(deletedList.exists(1), is(true));
        assertThat(deletedList.exists(3), is(true));
    }

    @Test
    public void shouldReturnSameListWhenTheresNothingToDelete() {
        ImmutableList<Integer> list = ImmutableList.<Integer>EmptyList()
                .add(1)
                .add(2)
                .add(3);

        ImmutableList<Integer> unmodifiedList = list.delete(4);
        assertTrue(unmodifiedList == list);
    }

    @Test
    public void shouldBeAbleToIterateOverTheList() {
        ImmutableList<Integer> list = ImmutableList.<Integer>EmptyList()
                .add(1)
                .add(2)
                .add(3);

        int sum = 0;
        for (Integer integer : list) {
            sum += integer;
        }

        assertThat(sum, is(6));
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldReturnNoSuchElementExceptionForEmptyList() {
        ImmutableList<Integer> list = ImmutableList.EmptyList();
        list.iterator().next();
    }
}