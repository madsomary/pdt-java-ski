package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupRemovalTests extends TestBase {

	@Test
	public void deleteSomeGroup() {

		SortedListOf<GroupData> oldList = new SortedListOf<GroupData>(app.getModel().getGroups());

		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size() - 1);

		app.getGroupHelper().deleteGroup(index);

		SortedListOf<GroupData> newList = new SortedListOf<GroupData>(app.getModel().getGroups());

		assertThat(newList, equalTo(oldList.without(index)));

	}

}
