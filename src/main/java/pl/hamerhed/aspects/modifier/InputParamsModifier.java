package pl.hamerhed.aspects.modifier;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class InputParamsModifier {

	@Around("execution(* pl.hamerhed.aspects.modifier.Converter.getMap(..))")
	public Object listModifier(ProceedingJoinPoint jp) throws Throwable {
		
		Object[] args = jp.getArgs();
		for (Object object : args) {
			System.out.println("arg=" + object.getClass().getCanonicalName());
		}
		
		//argumenty sa unmodifiable?
		List<String> countries = (List<String>) args[0];
		List<String> newList = new ArrayList<>(countries);
		newList.add("Poland");
		Object result = jp.proceed(new Object[] {newList}); 
		
		return result;
	}
}
