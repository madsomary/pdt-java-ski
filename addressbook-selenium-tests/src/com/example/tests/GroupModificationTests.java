package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupModificationTests extends TestBase {

	@Test(dataProvider = "randomValidGroupGenerator")
	public void modifySomeGroup(GroupData group) {

		SortedListOf<GroupData> oldList = new SortedListOf<GroupData>(app
				.getModel().getGroups());

		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size() - 1);

		app.getGroupHelper().modifyGroup(index, group);

		SortedListOf<GroupData> newList = new SortedListOf<GroupData>(app
				.getModel().getGroups());

		assertThat(newList, equalTo(oldList.without(index).withAdded(group)));
		if ("true".equals(app.getProperty("check.db"))) {
			if (wantToCheck()) {
				assertThat(app.getModel().getGroups(), equalTo(app
						.getHibernateHelper().listGroups()));
			}

		}

		if ("true".equals(app.getProperty("check.ui"))) {
			if (wantToCheck()) {
				assertThat(app.getModel().getGroups(), equalTo(app
						.getGroupHelper().getUiGroups()));
			}
		}
	}

}
