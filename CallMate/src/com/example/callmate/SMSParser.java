package com.example.callmate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SMSParser {

	List<String> splitedTextList=new ArrayList<String>();

	public SMSParser(String smsText) {
		String[] splitedText = smsText.split(" ");
		splitedTextList.addAll(Arrays.asList(splitedText));
		}

	public List<String> getNumbers() {

		if (splitedTextList.get(0).equals(Constants.MESSAGE_TOKEN)) {
			splitedTextList.remove(0);
		}
		return splitedTextList;

	}

	public boolean isValidMessage() {

		if (splitedTextList.get(0).equals(Constants.MESSAGE_TOKEN)) {
			return true;
		} else {
			return false;
		}
	}

}
