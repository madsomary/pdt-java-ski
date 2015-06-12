package com.example.tests;

import static com.example.tests.GroupDataGenerator.loadGroupsFromXmlFile;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupCreationTests extends TestBase {

	@DataProvider
	public Iterator<Object[]> groupsFromFile() throws IOException {
		return wrapGroupsForDataProvider(
				loadGroupsFromXmlFile(new File("groups.xml"))).iterator();
	}

	@Test(dataProvider = "groupsFromFile")
	public void testGroupCreationWithValidData(GroupData group)
			throws Exception {

		SortedListOf<GroupData> oldList =  new SortedListOf<GroupData>(app.getModel().getGroups());

		app.getGroupHelper().createGroup(group);

		SortedListOf<GroupData> newList =  new SortedListOf<GroupData>(app.getModel().getGroups());

		assertThat(newList, equalTo(oldList.withAdded(group)));

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
