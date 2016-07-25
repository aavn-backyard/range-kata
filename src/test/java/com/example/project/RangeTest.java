package com.example.project;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.time.chrono.ChronoLocalDate;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RangeTest {

	@Test
	public void f() {
		Range<Integer> open = Range.open(5, 7);
		Assert.assertEquals(open.contains(5), false);
		Assert.assertEquals(open.contains(10), false);


		Range<Integer> closed = Range.closed(5, 7);
		Assert.assertEquals(closed.contains(5), true);

		Range<Integer> openClosed = Range.openClosed(5, 7);
		Assert.assertEquals(openClosed.contains(5), false);
		Assert.assertEquals(openClosed.contains(7), true);

		Range<Integer> closedOpen = Range.closedOpen(5, 7);
		Assert.assertEquals(closedOpen.contains(5), true);
		Assert.assertEquals(closedOpen.contains(7), false);

		Range<String> text = Range.open("abc", "xyz");
		
		Assert.assertEquals(text.contains("aaa"), false);
		Assert.assertEquals(text.contains("abd"), true);
		Assert.assertEquals(text.contains("ayz"), true);
		Assert.assertEquals(text.contains("aba"), false);
		Assert.assertEquals(text.contains("xyz"), false);
		
		
		Range<BigDecimal> decimals = Range.open(new BigDecimal("1.32432"),
				new BigDecimal("1.324323423423423423423"));
		Assert.assertEquals(
				decimals.contains(new BigDecimal("1.324323423423")), true);
		Assert.assertEquals(
				decimals.contains(new BigDecimal("1.3243234234234234234239999")), false);

		Range<ChronoLocalDate> dates = Range.closed(
				LocalDate.of(2016, Month.SEPTEMBER, 11),
				LocalDate.of(2017, Month.JUNE, 30));
		Assert.assertEquals(
				dates.contains(LocalDate.of(2016, Month.NOVEMBER, 11)), true);

	}
}
