package com.Samarth.beans;

import java.util.ArrayList;
import java.util.List;

import com.Samarth.dataaccess.BookDataAccess;

public class SubjectBean {
	private List<String> subjects;

	public SubjectBean() {
		this.subjects = new ArrayList<String>();
	}

	public List<String> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}

	public boolean fetchSubjects() {
		try (BookDataAccess obj = new BookDataAccess()) {
			this.subjects = obj.findAllSubjects();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
