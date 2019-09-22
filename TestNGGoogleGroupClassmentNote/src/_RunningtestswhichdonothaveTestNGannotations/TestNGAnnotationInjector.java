package _RunningtestswhichdonothaveTestNGannotations;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;
import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.ClassFile;
import javassist.bytecode.ConstPool;
import javassist.bytecode.annotation.Annotation;
import org.testng.annotations.Test;
 
import java.util.ArrayList;
import java.util.List;
 
public class TestNGAnnotationInjector {
 
	 public static Class[] addAnnotationToTestClass(String... classNames) throws NotFoundException, CannotCompileException {
	        List<Class> classes = new ArrayList<>();
	        for (String classname : classNames) {
	            classes.add(addAnnotationToTestClass(classname));
	        }
	        return classes.toArray(new Class[classes.size()]);
	    }
	 
	    public static Class addAnnotationToTestClass(String className) throws NotFoundException, CannotCompileException {
	        ClassPool pool = ClassPool.getDefault();
	        CtClass cc = pool.getCtClass(className);
	        ClassFile ccFile = cc.getClassFile();
	        ConstPool constpool = ccFile.getConstPool();
	        AnnotationsAttribute attr = new AnnotationsAttribute(constpool, AnnotationsAttribute.visibleTag);
	        Annotation annot = new Annotation(Test.class.getCanonicalName(), constpool);
	        attr.addAnnotation(annot);
	        ccFile.addAttribute(attr);
	        return cc.toClass();
	    }
	}