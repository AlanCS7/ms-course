package io.github.alancs7.hrpayroll.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

	private String name;
	private Double dailyIncome;
	private Integer days;

	public double getTotal() {
		return days * dailyIncome;
	}
}
