package com.test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class BigDecimalVSDouble {

	// default to read a double primitive value of 18 digit precision
	public static final NumberFormat DEFAULT_DECIMAL_FORMAT = new DecimalFormat("#.0#################");
	public static final BigDecimal ZERO = new BigDecimal("0");

	public static BigDecimal add(double a, double b) {
		String s = DEFAULT_DECIMAL_FORMAT.format(a);
		BigDecimal bd = new BigDecimal(s);
		return add(bd, b);
	}

	public static BigDecimal add(BigDecimal a, double b) {
		String s = DEFAULT_DECIMAL_FORMAT.format(b);
		BigDecimal bd = new BigDecimal(s);
		return add(a, bd);
	}

	public static BigDecimal add(BigDecimal a, BigDecimal b) {
		if (a == null)
			return (b == null) ? ZERO : b;
		return a.add(b);
	}

	@SuppressWarnings({ "rawtypes", "unused" })
	public static void main(String[] args) {

		// Main Difference 1 - BigDecimal provides more control on how rounding
		// is done and thus provide more accurate output
		// https://blogs.oracle.com/corejavatechtips/the-need-for-bigdecimal
		doubleCalucations();
		bigDecimalCalculations();

		// Diff 2 - BigDecimal is more accurate
		// double a = 0.02;
		// double b = 0.03;
		// double c = b - a;
		// System.out.println(c);
		//
		// BigDecimal _a = new BigDecimal("0.02");
		// BigDecimal _b = new BigDecimal("0.03");
		// BigDecimal _c = _b.subtract(_a);
		// System.out.println(_c);
		//
		// // Diff 3 - BigDecimal should be initialized with string
		// System.out.println(1000.0d+0.0001d);
		// System.out.println(new BigDecimal(1000.0).add(new
		// BigDecimal(0.0001)));
		// System.out.println(new BigDecimal("1000.0").add(new
		// BigDecimal("0.0001")));
		//
		// // Diff 4 - BigDecimal is more accurate when we define precision
		// System.out.println( 0.1f + 0.1f + 0.1f + 0.1f + 0.1f + 0.1f + 0.1f +
		// 0.1f + 0.1f + 0.1f );
		// System.out.println( 0.1d + 0.1d + 0.1d + 0.1d + 0.1d + 0.1d + 0.1d +
		// 0.1d + 0.1d + 0.1d );
		// System.out.println( new BigDecimal(0.1d).add(new
		// BigDecimal(0.1d)).add(new BigDecimal(0.1d)).add(new BigDecimal(0.1d))
		// .add(new BigDecimal(0.1d)).add(new BigDecimal(0.1d)).add(new
		// BigDecimal(0.1d)).add(new BigDecimal(0.1d))
		// .add(new BigDecimal(0.1d)).add(new BigDecimal(0.1d)));
		// System.out.println (
		// "add (add (add (add (add (add (add (add (add (0.1, 0.1), 0.1), 0.1),
		// 0.1), 0.1), 0.1), 0.1), 0.1), 0.1) = " +
		// add (add (add (add (add (add (add (add (add (0.1, 0.1), 0.1), 0.1),
		// 0.1), 0.1), 0.1), 0.1), 0.1), 0.1));
		// System.out.println (
		// "new BigDecimal (\"0.0175\").multiply (new BigDecimal
		// (\"100000\").doubleValue()) = " +
		// new BigDecimal ("0.0175").multiply (new BigDecimal
		// ("100000")).doubleValue());
		// System.out.println (
		// "0.0175d*100000d= " + 0.0175d*100000d);

		// // Problem with double
		// System.out.println( 0.3 == 0.1d + 0.1d + 0.1d );
		//
		// // Doubles overflow
		// double big = 1.0e307 * 2000 / 2000;
		// System.out.println( big == 1.0e307 );
		//
		// // Large and small are not friends!
		// System.out.println( 1234.0d + 1.0e-13d == 1234.0d );
		//
		// // WYSINWYG - What You See Is Not What You Get
		// System.out.println( Float.toString(0.1f) );
		// System.out.println( Double.toString(0.1f) );
		// System.out.println( Double.toString(0.1d) );

	}

	private static void doubleCalucations() {
		System.out.println("***** Double bill calculation *****");
		double amount = 100.05;
		double discount = amount * 0.10;
		double total = amount - discount;
		double tax = total * 0.05;
		double taxedTotal = tax + total;
		NumberFormat money = NumberFormat.getCurrencyInstance();
		System.out.println("Subtotal : " + money.format(amount));
		System.out.println("Discount : " + money.format(discount));
		System.out.println("Total : " + money.format(total));
		System.out.println("Tax : " + money.format(tax));
		System.out.println("Tax+Total: " + money.format(taxedTotal));
	}

	private static void bigDecimalCalculations() {
		System.out.println("***** BigDecimal bill calculation *****");
		BigDecimal amount = new BigDecimal("100.05");
		BigDecimal discountPercent = new BigDecimal("0.10");
		BigDecimal discount = amount.multiply(discountPercent);
		discount = discount.setScale(2, RoundingMode.HALF_UP);
		BigDecimal total = amount.subtract(discount);
		total = total.setScale(2, RoundingMode.HALF_UP);
		BigDecimal taxPercent = new BigDecimal("0.05");
		BigDecimal tax = total.multiply(taxPercent);
		tax = tax.setScale(2, RoundingMode.HALF_UP);
		BigDecimal taxedTotal = total.add(tax);
		taxedTotal = taxedTotal.setScale(2, RoundingMode.HALF_UP);
		System.out.println("Subtotal : " + amount);
		System.out.println("Discount : " + discount);
		System.out.println("Total : " + total);
		System.out.println("Tax : " + tax);
		System.out.println("Tax+Total: " + taxedTotal);
	}
}
