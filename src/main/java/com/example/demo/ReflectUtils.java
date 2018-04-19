package com.example.demo;


/**
 * 反射工具
 * @author yindl
 *
 */
public class ReflectUtils{

	public static void setMethodValue(Object obj, String name, Class<?> parameterTypes, Object args){
		try{
			obj.getClass().getMethod(name, parameterTypes).invoke(obj, args);
		}catch(Exception e){
		}
	}

	public static void setMethodValue(Object obj, String name, Class<?>[] parameterTypes, Object[] args){
		try{
			obj.getClass().getMethod(name, parameterTypes).invoke(obj, args);
		}catch(Exception e){
			e.printStackTrace()
		}
	}

	public static Object getMethodValue(Object obj, String name){
		try{
			return obj.getClass().getMethod(name).invoke(obj);
		}catch(Exception e){
			e.printStackTrace()
		}
		return null;
	}

	public static Object getFieldValue(Object obj, String name){
		try{
			return obj.getClass().getField(name).get(obj);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public static Object getMethodValue(Object obj, String methodName, Class<?>[] parameterTypes, Object[] args) throws Exception{
		return obj.getClass().getMethod(methodName, parameterTypes).invoke(obj, args);
	}
	
	/**
	 * 调用静态方法
	 * @param methodName
	 * @param clazz
	 * @param parameterTypes
	 * @param args
	 * @return
	 */
	public static void exeStaticMethod(String methodName, Class<?> clazz, Class<?>[] parameterTypes, Object[] args){
		try{
			clazz.getMethod(methodName, parameterTypes).invoke(null, args);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 调用静态方法
	 * @param methodName
	 * @param clazz
	 * @param parameterTypes
	 * @param args
	 * @return
	 */
	public static Object getStaticMethodValue(String methodName, Class<?> clazz, Class<?>[] parameterTypes, Object[] args){
		try{
			return clazz.getMethod(methodName, parameterTypes).invoke(null, args);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
