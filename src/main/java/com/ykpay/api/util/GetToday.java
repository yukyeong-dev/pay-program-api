package com.ykpay.api.util;

import java.text.SimpleDateFormat;

public class GetToday {
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public String getToday() {
		java.util.Date d = new java.util.Date();
		return sdf.format(d);
	}

}

