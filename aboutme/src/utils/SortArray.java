package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import model.bean.Experience;

public class SortArray {
	
	public static ArrayList<Experience> listSort(ArrayList<Experience> listSort)  {
		
		Collections.sort(listSort, new Comparator<Experience>() {
        public int compare(Experience ex1, Experience ex2) {
            if (ex1.getTime().before(ex2.getTime())) {
                return -1;
            } else {
                if (ex1.getTime() == ex2.getTime()) {
                    return 0;
                } else {
                    return 1;
                }
            }
        }
    });
		return listSort;
	
} }

