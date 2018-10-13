package pl.hamerhed.aspects.modifier;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class PizzaModifier {

	@Around("execution(* pl.hamerhed.aspects.modifier.Pizza.getPizza()) and !bean(pizzaBolonia)")
	public String pizzaWithCheese(ProceedingJoinPoint jp) throws Throwable {
		String pizza = (String) jp.proceed();
		return pizza + " and cheese";
	}
}
